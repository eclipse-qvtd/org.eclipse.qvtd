/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGeneratorAdapterFactory;
import org.eclipse.qvtd.compiler.internal.genmodel.QVTdGenModelGeneratorAdapterFactory;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

/**
 * GenModelCompilerStep activates the EMF GenModel tooling to generate the Java classes from the
 * synthesized Ecore model for the middle/trace model.
 */
public class GenModelCompilerStep extends AbstractCompilerStep
{
	private static final class Generator extends org.eclipse.emf.codegen.ecore.generator.Generator
	{
		private final @NonNull Collection<GeneratorAdapterFactory> adapterFactories = new ArrayList<>();

		public Generator() {
			// Replacement for EMF to fix BUG 485764, BUG 485089
			addAdapterFactoryDescriptor(QVTdGenModelGeneratorAdapterFactory.DESCRIPTOR);
			// OCLinEcore embedded support
			addAdapterFactoryDescriptor(OCLinEcoreGeneratorAdapterFactory.DESCRIPTOR);
		}

		private void addAdapterFactoryDescriptor(Descriptor descriptor) {
			GeneratorAdapterFactory adapterFactory = descriptor.createAdapterFactory();
			adapterFactories.add(adapterFactory);
			adapterFactory.setGenerator(this);
		}

		@Override
		protected Collection<GeneratorAdapterFactory> getAdapterFactories( Object object) {
			return adapterFactories;
		}
	}

	private static class Issues
	{
		public void addError(@NonNull CompilerChain compilerChain, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.err.println(message);
		}

		public void addWarning(@NonNull CompilerChain compilerChain, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.out.println(message);
		}

		public void addError(@NonNull CompilerChain compilerChain, String string) {
			System.err.println(string);
		}

		public void addWarning(@NonNull CompilerChain compilerChain, String string) {
			System.out.println(string);
		}
	}

	public GenModelCompilerStep(@NonNull CompilerChain compilerChain) {
		super(compilerChain, QVTrCompilerChain.GENMODEL_STEP);
	}

	public void execute() throws IOException { // FIXME This is similar to Java2ClassCompilerStep.execute
		URI genmodelURI = compilerChain.getURI(QVTrCompilerChain.GENMODEL_STEP, QVTrCompilerChain.URI_KEY);
		URI qvtcURI = compilerChain.getURI(QVTrCompilerChain.QVTC_STEP, QVTrCompilerChain.URI_KEY);
		Resource cResource = environmentFactory.getMetamodelManager().getASResourceSet().getResource(qvtcURI, true);
		assert cResource != null;
		Resource gResource = environmentFactory.getResourceSet().getResource(genmodelURI, true);
		assert gResource != null;
		GenModel genModel = (GenModel) gResource.getContents().get(0);
		List<@NonNull String> classProjectNames = compilerChain.basicGetOption(QVTrCompilerChain.CLASS_STEP, QVTrCompilerChain.CLASS_PROJECT_NAMES_KEY);
		URI classFileURI = compilerChain.basicGetOption(QVTrCompilerChain.CLASS_STEP, QVTrCompilerChain.URI_KEY);
		URI traceURI = compilerChain.getURI(QVTrCompilerChain.TRACE_STEP, QVTrCompilerChain.URI_KEY);
		if (classFileURI != null) {
			String classFilePath;
			String sourceFilePathPrefix;
			List<@NonNull String> classpathProjects;
			URIConverter uriConverter = environmentFactory.getResourceSet().getURIConverter();
			if (EcorePlugin.IS_ECLIPSE_RUNNING) {
				String binProjectName = QVTr2QVTc.getProjectName(traceURI);
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				classFilePath = classFileURI.toFileString();
				assert classFilePath != null;
				IFile genIFile = root.getFile(new Path(genModel.getModelDirectory()));
				File genFile = URIUtil.toFile(genIFile.getLocationURI());
				sourceFilePathPrefix = genFile.getAbsolutePath().replace("\\", "/");
				classpathProjects = CompilerUtil.createClassPathProjectList(uriConverter, binProjectName, classFilePath, classProjectNames);
			}
			else {
				classFilePath = classFileURI.toFileString();
				URI genModelDirectoryURI = URI.createPlatformResourceURI(genModel.getModelDirectory(), true);
				sourceFilePathPrefix = uriConverter.normalize(genModelDirectoryURI).toFileString() + "/";
				classpathProjects = null;
			}
			assert classFilePath != null;
			for (GenPackage genPackage : genModel.getGenPackages()) {
				String basePackage = genPackage.getBasePackage();
				String sourcePath = sourceFilePathPrefix + (basePackage != null ? ("/" + basePackage.replace(".", "/")) : "");
				JavaFileUtil.deleteJavaFiles(sourcePath);
			}
			generateModels(genModel);
			new File(classFilePath).mkdirs();
			Set<@NonNull String> basePackages = new HashSet<>();
			for (GenPackage genPackage : genModel.getGenPackages()) {
				String basePackage = genPackage.getBasePackage();
				basePackage = basePackage != null ? ("/" + basePackage.replace(".", "/")) : "";
				if (basePackages.add(basePackage)) {
					String sourceFilePath = sourceFilePathPrefix + basePackage;
					String problemMessage = JavaFileUtil.compileClasses(sourceFilePath, classFilePath, classpathProjects);
					if (problemMessage != null) {
						addProblem(new CompilerChainException(problemMessage));
					}
				}
			}
		}
		throwCompilerChainExceptionForErrors();
		compiled(gResource);
	}

	protected void generateModels(@NonNull GenModel genModel) {
		environmentFactory.getMetamodelManager().addGenModel(genModel);
		//**		ResourceUtils.checkResourceSet(resourceSet);
		// genModel.setCanGenerate(true);
		// validate();



		genModel.setValidateModel(true); // The more checks the better
		//		genModel.setCodeFormatting(true); // Normalize layout
		genModel.setForceOverwrite(false); // Don't overwrite read-only
		// files
		genModel.setCanGenerate(true);
		// genModel.setFacadeHelperClass(null); // Non-null gives JDT
		// default NPEs
		//		genModel.setFacadeHelperClass(ASTFacadeHelper.class.getName()); // Bug 308069
		// genModel.setValidateModel(true);
		//		genModel.setBundleManifest(false); // New manifests should be
		//											// generated manually
		//		genModel.setUpdateClasspath(false); // New class-paths should be
		//											// generated manually
		//		if (genModel.getComplianceLevel().compareTo(GenJDKLevel.JDK50_LITERAL) < 0) {
		//			genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
		//		}
		// genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
		Diagnostic diagnostic = genModel.diagnose();
		assert diagnostic != null;
		reportDiagnostics(new Issues(), diagnostic);

		/*
		 * JavaModelManager.getJavaModelManager().initializePreferences();
		 * new
		 * JavaCorePreferenceInitializer().initializeDefaultPreferences();
		 *
		 * GenJDKLevel genSDKcomplianceLevel =
		 * genModel.getComplianceLevel(); String complianceLevel =
		 * JavaCore.VERSION_1_5; switch (genSDKcomplianceLevel) { case
		 * JDK60_LITERAL: complianceLevel = JavaCore.VERSION_1_6; case
		 * JDK14_LITERAL: complianceLevel = JavaCore.VERSION_1_4; default:
		 * complianceLevel = JavaCore.VERSION_1_5; } // Hashtable<?,?>
		 * defaultOptions = JavaCore.getDefaultOptions(); //
		 * JavaCore.setComplianceOptions(complianceLevel, defaultOptions);
		 * // JavaCore.setOptions(defaultOptions);
		 */

		GenModelCompilerStep.Generator generator = new Generator();
		generator.setInput(genModel);
		Monitor monitor = /*showProgress ? new LoggerMonitor(log) :*/ new BasicMonitor();
		diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);
		assert diagnostic != null;
		reportDiagnostics(new Issues(), diagnostic);
	}

	protected void reportDiagnostics(@NonNull Issues issues, @NonNull Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		if (severity != Diagnostic.OK) {
			List<Diagnostic> children = diagnostic.getChildren();
			if (children.size() > 0) {
				for (Diagnostic child : children) {
					severity = child.getSeverity();
					@SuppressWarnings("unchecked") List<Object> data = (List<Object>) child.getData();
					Throwable throwable = null;
					String message;
					if ((data.size() == 1) && (data.get(0) instanceof Throwable)) {
						throwable = (Throwable) data.get(0);
						data = null;
						message = child.getMessage();
					}
					else {
						message = child.toString();
					}
					if (severity == Diagnostic.ERROR) {
						issues.addError(compilerChain, message, null, null, throwable, data);
					}
					else if (severity == Diagnostic.WARNING) {
						issues.addWarning(compilerChain, message, null, null, throwable, data);
					}
				}
			}
			else {
				if (severity == Diagnostic.ERROR) {
					issues.addError(compilerChain, diagnostic.toString());
				}
				else if (severity == Diagnostic.WARNING) {
					issues.addWarning(compilerChain, diagnostic.toString());
				}
			}
		}
	}
}