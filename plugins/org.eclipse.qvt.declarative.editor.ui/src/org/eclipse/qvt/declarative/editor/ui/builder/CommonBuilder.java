/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonBuilder.java,v 1.3 2008/08/26 19:12:12 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.imp.builder.BuilderBase;
import org.eclipse.imp.builder.BuilderUtils;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;

/**
 * A builder may be activated on a file containing language code every time it
 * has changed (when "Build automatically" is on), or when the programmer
 * chooses to "Build" a project.
 */
public abstract class CommonBuilder extends BuilderBase
{	
	protected final ICreationFactory creationFactory;

	protected CommonBuilder(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
	}

	/**
	 * Collects compilation-unit dependencies for the given file, and records
	 * them via calls to <code>fDependency.addDependency()</code>.
	 */
	@Override
	protected void collectDependencies(IFile file) {
//		String fromPath = file.getFullPath().toString();	
//		getPlugin().writeInfoMsg("Collecting dependencies from ${LANG_NAME} file: " + file.getName());	
// T O D O : implement dependency collector
// E.g. for each dependency:
// fDependencyInfo.addDependency(fromPath, uponPath);
	}

	/**
	 * Compile one language file.
	 */
	@Override
	protected void compile(final IFile inputFile, IProgressMonitor monitor) {
		IPath projectRelativeInputPath = inputFile.getProjectRelativePath();
		IPath workspaceRelativeInputPath = inputFile.getFullPath();
		IPath workspaceRelativeOutputPath = workspaceRelativeInputPath;
		IClasspathEntry classpathEntry = getClasspathEntry(inputFile);
		if (classpathEntry != null) {
			IPath sourcePath = classpathEntry.getPath();
			IPath outputPath = classpathEntry.getOutputLocation();
			workspaceRelativeOutputPath = outputPath.append(workspaceRelativeInputPath.removeFirstSegments(sourcePath.segmentCount()));
		}
		if (hasTextExtension(inputFile))
			workspaceRelativeOutputPath = workspaceRelativeOutputPath.removeFileExtension();
		workspaceRelativeOutputPath = workspaceRelativeOutputPath.addFileExtension(creationFactory.getXMLExtension());
		IFile outputFile = getProject().getFile(workspaceRelativeOutputPath.removeFirstSegments(1));
		getPlugin().writeInfoMsg("Building " + creationFactory.getLanguageName() + " input file: '" + inputFile.getName() + "', output file: '" + outputFile.getName() + "'");
		ProblemHandler problemHandler = creationFactory.createProblemHandler(inputFile);
		try {
			IParseController parseController = createParseController();
			parseController.getAnnotationTypeInfo().addProblemMarkerType(getErrorMarkerID());
			ISourceProject sourceProject = ModelFactory.open(inputFile.getProject());
			parseController.initialize(projectRelativeInputPath, sourceProject, (IMessageHandler) problemHandler);
			String contents = BuilderUtils.getFileContents(inputFile);
			Object ast = parseController.parse(contents, false, monitor);
			URI uri = URI.createPlatformResourceURI(workspaceRelativeOutputPath.toString(), true);
			Resource resource = ((ASTandCST)ast).getAST();
			resource.setURI(uri);
			resource.save(null);
			doRefresh(outputFile.getParent());
		} catch (Exception e) {
			getPlugin().logException("Failed to compile '" + inputFile.toString() + "'", e);
		} finally {
			problemHandler.flush(BasicMonitor.toMonitor(monitor));
		}
	}

	protected IParseController createParseController() {
		return creationFactory.createParseController();
	}

	/**
	 * Return the classpath entries applicable to the current project.
	 * Returns null if not a Java project.
	 */
	protected IClasspathEntry[] getClasspathEntries(IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject == null)
			return null;
		try {
			return javaProject.getResolvedClasspath(true);
		} catch (JavaModelException e) {
			return null;
		}
	}

	/**
	 * Return the classpath entry applicable to the file.
	 * Retuyrns null if none available.
	 */
	protected IClasspathEntry getClasspathEntry(IFile file) {
		IClasspathEntry[] resolvedClasspath = getClasspathEntries(file.getProject());		
		if (resolvedClasspath == null)
			return null;
		IPath workspaceRelativeInputPath = file.getFullPath();
		for (IClasspathEntry resolvedClasspathEntry : resolvedClasspath) {
			if (resolvedClasspathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath sourcePath = resolvedClasspathEntry.getPath();
				if (sourcePath.isPrefixOf(workspaceRelativeInputPath))
					return resolvedClasspathEntry;
			}
		}
		return null;
	}

	public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	@Override
	public String getErrorMarkerID() {
		return creationFactory.getErrorMarkerId();
	}

	@Override
	public String getInfoMarkerID() {
		return creationFactory.getInfoMarkerId();
	}

	public Language getLanguage() {
		return creationFactory.getLanguage();
	}

	public String getLanguageName() {
		return creationFactory.getLanguageName();
	}

	@Override
	public PluginBase getPlugin() {
		return (PluginBase) creationFactory.getPlugin();
	}

	@Override
	public String getWarningMarkerID() {
		return creationFactory.getWarningMarkerId();
	}
	
	/**
	 * Return true if file has one if the text extensions defined by the
	 * user preferences and consequently is to be treated as a source file.
	 */
	protected boolean hasTextExtension(IFile file) {
		IPath workspaceRelativeInputPath = file.getFullPath();
		String fileExtension = workspaceRelativeInputPath.getFileExtension();
		for (String textExtension : creationFactory.getTextExtensions()) {
			if (textExtension.equals(fileExtension))
				return true;
		}
		return false;
	}

	/**
	 * Decide whether or not to scan a file for dependencies. Note:
	 * <code>isNonRootSourceFile()</code> and <code>isSourceFile()</code>
	 * should never return true for the same file.
	 * 
	 * @return true iff the given file is a source file that this builder should
	 *         scan for dependencies, but not compile as a top-level compilation
	 *         unit.
	 * 
	 */
	@Override
	protected boolean isNonRootSourceFile(IFile resource) {
		return false;
	}

	/**
	 * @return true iff this resource identifies an output folder
	 */
	@Override
	protected boolean isOutputFolder(IResource resource) {
		IClasspathEntry[] resolvedClasspath = getClasspathEntries(resource.getProject());		
		if (resolvedClasspath == null)
			return false;		// FIXME ???
		IPath workspaceRelativePath = resource.getFullPath();
		for (IClasspathEntry resolvedClasspathEntry : resolvedClasspath) {
			if (resolvedClasspathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				IPath outputPath = resolvedClasspathEntry.getOutputLocation();
				if ((outputPath != null) && outputPath.isPrefixOf(workspaceRelativePath))
					return true;
			}
		}
		return false;
	}

	/**
	 * Decide whether a file needs to be build using this builder. Note that
	 * <code>isNonRootSourceFile()</code> and <code>isSourceFile()</code>
	 * should never return true for the same file.
	 * 
	 * @return true iff an arbitrary file is a source file for this language.
	 */
	@Override
	protected boolean isSourceFile(IFile file) {
		if (!hasTextExtension(file))
			return false;
		if (getClasspathEntry(file) == null)
			return false;
		return true;
	}
}
