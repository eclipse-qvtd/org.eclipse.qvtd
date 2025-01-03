/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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

import javax.tools.JavaFileObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.genmodel.OCLGenModelUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

/**
 * GenModelCompilerStep activates the EMF GenModel tooling to generate the Java classes from the
 * synthesized Ecore model for the middle/trace model.
 */
public class GenModelGenerateCompilerStep extends AbstractCompilerStep
{
	private static final class Generator extends org.eclipse.emf.codegen.ecore.generator.Generator
	{
		private final @NonNull Collection<GeneratorAdapterFactory> adapterFactories = new ArrayList<>();

		public Generator() {
			for (GeneratorAdapterFactory.@NonNull Descriptor descriptor : OCLGenModelUtil.getGeneratorAdapterFactoryDescriptors()) {
				GeneratorAdapterFactory adapterFactory = descriptor.createAdapterFactory();
				adapterFactories.add(adapterFactory);
				adapterFactory.setGenerator(this);
			}
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
			QVTruntimeUtil.errPrintln(message);
		}

		public void addWarning(@NonNull CompilerChain compilerChain, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.out.println(message);
		}

		public void addError(@NonNull CompilerChain compilerChain, String string) {
			QVTruntimeUtil.errPrintln(string);
		}

		public void addWarning(@NonNull CompilerChain compilerChain, String string) {
			System.out.println(string);
		}
	}

	public GenModelGenerateCompilerStep(@NonNull CompilerChain compilerChain) {
		super(compilerChain, QVTrCompilerChain.GENMODEL_STEP);
	}

	public void execute() throws IOException {
		Boolean keepOldJavaFiles = compilerChain.basicGetOption(QVTrCompilerChain.GENMODEL_STEP, QVTrCompilerChain.KEEP_OLD_JAVA_FILES_KEY);
		URI genmodelURI = compilerChain.getURI(QVTrCompilerChain.GENMODEL_STEP, QVTrCompilerChain.URI_KEY);
		ResourceSet resourceSet = environmentFactory.getResourceSet();
		Resource genmodelResource = resourceSet.getResource(genmodelURI, true);
		assert genmodelResource != null;
		GenModel genModel = (GenModel) genmodelResource.getContents().get(0);
		URI classFileURI = compilerChain.basicGetOption(QVTrCompilerChain.CLASS_STEP, QVTrCompilerChain.URI_KEY);
		@SuppressWarnings("unused")
		URI traceURI = compilerChain.getURI(QVTrCompilerChain.TRACE_STEP, QVTrCompilerChain.URI_KEY);
		if (classFileURI != null) {
			String classFilePath = classFileURI.toFileString();
			String sourceFilePathPrefix;
			if (EcorePlugin.IS_ECLIPSE_RUNNING) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFile genIFile = root.getFile(new Path(genModel.getModelDirectory()));
				File genFile = URIUtil.toFile(genIFile.getLocationURI());
				sourceFilePathPrefix = genFile.getAbsolutePath().replace("\\", "/");
			}
			else {
				URI genModelDirectoryURI = URI.createPlatformResourceURI(genModel.getModelDirectory(), true);
				sourceFilePathPrefix = resourceSet.getURIConverter().normalize(genModelDirectoryURI).toFileString() + "/";
			}
			assert classFilePath != null;
			if (keepOldJavaFiles != Boolean.TRUE) {
				for (GenPackage genPackage : genModel.getGenPackages()) {
					String basePackage = genPackage.getBasePackage();
					String sourcePath = sourceFilePathPrefix + (basePackage != null ? ("/" + basePackage.replace(".", "/")) : "") + "/" + genPackage.getEcorePackage().getName();
					JavaFileUtil.deleteJavaFiles(sourcePath);
				}
			}
			generateModels(genModel);
			new File(classFilePath).mkdirs();
			List<@NonNull JavaFileObject> compilationUnits = new ArrayList<@NonNull JavaFileObject>();
			Set<@NonNull String> basePackages = new HashSet<>();
			for (GenPackage genPackage : genModel.getGenPackages()) {
				String basePackage = genPackage.getBasePackage();
				basePackage = (basePackage != null ? ("/" + basePackage.replace(".", "/")) : "") + "/" + genPackage.getEcorePackage().getName();
				if (basePackages.add(basePackage)) {
					String sourceFilePath = sourceFilePathPrefix + basePackage;
					JavaFileUtil.gatherCompilationUnits(compilationUnits, new File(sourceFilePath));
				}
			}
			JavaClasspath classpath = compilerChain.basicGetOption(QVTrCompilerChain.CLASS_STEP, QVTrCompilerChain.CLASSPATH_KEY);
			assert classpath != null;
			String problemMessage = JavaFileUtil.compileClasses(compilationUnits, sourceFilePathPrefix, classFilePath, classpath);
			if (problemMessage != null) {
				addProblem(new CompilerChainException(problemMessage));
			}
		}
		throwCompilerChainExceptionForErrors();
		compiled(genmodelResource);
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

		GenModelGenerateCompilerStep.Generator generator = new Generator();
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