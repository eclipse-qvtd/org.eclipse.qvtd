/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.utilities.JavaSourceFileObject;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class QVTrCompilerChain extends AbstractCompilerChain
{
	protected static class Xtext2QVTrCompilerStep extends AbstractCompilerStep
	{
		public Xtext2QVTrCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTR_STEP);
		}

		public @NonNull Resource execute(@NonNull URI txURI) throws IOException {
			//			Transformation loadTransformation = QVTrelationUtil.loadTransformation(environmentFactory, txURI, false);
			//			Resource rResource = ClassUtil.nonNullState(loadTransformation.eResource());
			Resource rResource = QVTrelationUtil.loadTransformations(environmentFactory, txURI, false);
			// FIXME Following code fixes up missing source. Should be fixed earlier.
			List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, rResource);
			if (missingOperationCallSources != null) {
				System.err.println("Missing OperationCallExp sources were fixed up for '" + txURI + "'");
			}
			compiled(rResource);
			//			saveResource(rResource, QVTR_STEP); -- causes test failures
			return rResource;
		}
	}

	protected static class QVTr2QVTcCompilerStep extends AbstractCompilerStep
	{
		public QVTr2QVTcCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTC_STEP);
		}

		public @NonNull Resource execute(@NonNull Resource rResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				//		URI classURI = getURI(CLASS_STEP, URI_KEY);
				URI classURI = compilerChain.getOption(CLASS_STEP, URI_KEY);
				URI qvtcURI = compilerChain.getURI(QVTC_STEP, URI_KEY);
				URI traceURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
				URI genModelURI = compilerChain.getURI(GENMODEL_STEP, URI_KEY);
				Map<@NonNull String, @Nullable String> traceOptions = compilerChain.getOption(TRACE_STEP, TRACE_OPTIONS_KEY);
				String traceNsURI = traceOptions != null ? traceOptions.get(TRACE_NS_URI) : null;
				Resource cResource = createResource(qvtcURI);
				Resource traceResource = createResource(PivotUtilInternal.getASURI(traceURI));
				QVTr2QVTc t = new QVTr2QVTc(environmentFactory, rResource, cResource);
				if (traceNsURI != null) {
					t.setTraceNsURI(traceNsURI);
				}
				t.prepare();
				//
				t.transformToTracePackages();
				Map<Object, Object> saveOptions = compilerChain.getOption(TRACE_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				t.saveTrace(traceResource, traceURI, genModelURI, traceOptions, saveOptions);
				assertNoResourceErrors("Trace save", traceResource);
				compiled(TRACE_STEP, cResource);
				//
				t.transformToCoreTransformations();
				saveOptions = compilerChain.getOption(QVTR_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				t.saveCore(cResource, saveOptions);
				assertNoResourceErrors("Core save", cResource);
				compiled(QVTC_STEP, cResource);

				if (getOption(DEBUG_KEY) == Boolean.TRUE) {
					URI txURI = cResource.getURI();
					if (txURI != null) {
						URI inputURI = txURI;
						URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvtc");
						doQVTcSerializeAndLoad(inputURI, serializedURI);
					}
				}
				// FIXME next few lines should be classURI != null, but a test fails in combination (? due to global registry leakage)
				saveOptions = compilerChain.getOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.getOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
				GenModel genModel = t.saveGenModel(traceResource, traceURI, genModelURI, compilerChain.getOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY), saveOptions, usedGenPackages);

				if (classURI != null) {
					String binProjectName = t.getProjectName(traceURI);
					File binFile;
					String objectPath;
					String sourcePathPrefix;
					List<@NonNull String> classpathProjects;
					if (EcorePlugin.IS_ECLIPSE_RUNNING) {
						IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
						IProject binProject = root.getProject(binProjectName);
						IFolder binFolder = binProject.getFolder("bin");
						binFile = URIUtil.toFile(binFolder.getLocationURI());
						objectPath = binFile.toString()/*.replace(".", "/")*/.replace("\\", "/");		// FIXME deduce/parameterize bin
						IFile genIFile = root.getFile(new Path(genModel.getModelDirectory()));
						File genFile = URIUtil.toFile(genIFile.getLocationURI());
						sourcePathPrefix = genFile.getAbsolutePath().replace("\\", "/");
						classpathProjects = JavaSourceFileObject.createClasspathProjectList(binProjectName, "org.eclipse.emf.common", "org.eclipse.emf.ecore", "org.eclipse.jdt.annotation", "org.eclipse.ocl.pivot", "org.eclipse.osgi", "org.eclipse.qvtd.runtime");
					}
					else {
						ResourceSet resourceSet = environmentFactory.getResourceSet();
						URI normalizedClassURI = resourceSet.getURIConverter().normalize(classURI);
						objectPath = normalizedClassURI.toFileString();
						URI location = ClassUtil.nonNullState(((StandaloneProjectMap)environmentFactory.getProjectManager()).getLocation(binProjectName));
						binFile = new File(location.appendSegment("bin").toFileString());
						URI genModelDirectoryURI = URI.createPlatformResourceURI(genModel.getModelDirectory(), true);
						sourcePathPrefix = resourceSet.getURIConverter().normalize(genModelDirectoryURI).toFileString() + "/";
						classpathProjects = null;
					}
					assert objectPath != null;
					for (GenPackage genPackage : genModel.getGenPackages()) {
						String basePackage = genPackage.getBasePackage();
						String sourcePath = sourcePathPrefix + (basePackage != null ? ("/" + basePackage.replace(".", "/")) : "");
						JavaFileUtil.deleteJavaFiles(sourcePath);
					}
					t.generateModels(genModel);
					binFile.mkdir();
					for (GenPackage genPackage : genModel.getGenPackages()) {
						String basePackage = genPackage.getBasePackage();
						String sourcePath = sourcePathPrefix + (basePackage != null ? ("/" + basePackage.replace(".", "/")) : "");
						JavaSourceFileObject.compileClasses(sourcePath, objectPath, classpathProjects);
					}
				}
				compiled(GENMODEL_STEP, cResource);
				return cResource;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected final @NonNull Xtext2QVTrCompilerStep xtext2qvtrCompilerStep;
	protected final @NonNull QVTr2QVTcCompilerStep qvtr2qvtcCompilerStep;

	public QVTrCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super(environmentFactory, txURI, options);
		this.xtext2qvtrCompilerStep = createXtext2QVTrCompilerStep();
		this.qvtr2qvtcCompilerStep = createQVTr2QVTcCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull String enforcedOutputName) throws IOException {
		Resource rResource = xtext2qvtrCompilerStep.execute(txURI);
		Resource cResource = qvtr2qvtcCompilerStep.execute(rResource);
		QVTuConfiguration qvtuConfiguration = createQVTuConfiguration(cResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputName);
		//		setOption(QVTU_STEP, QVTU_CONFIGURATION_KEY, qvtuConfiguration);
		Resource pResource = qvtc2qvtp(cResource, qvtuConfiguration);
		return qvtp2qvti(pResource);
	}

	protected @NonNull QVTr2QVTcCompilerStep createQVTr2QVTcCompilerStep() {
		return new QVTr2QVTcCompilerStep(this);
	}

	protected @NonNull Xtext2QVTrCompilerStep createXtext2QVTrCompilerStep() {
		return new Xtext2QVTrCompilerStep(this);
	}
}
