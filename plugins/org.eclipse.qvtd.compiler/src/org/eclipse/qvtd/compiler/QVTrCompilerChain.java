/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc.GenPackageComparator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTr2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.QVTs2QVTs;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

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
			ASResource qvtrResource = QVTrelationUtil.loadTransformations(environmentFactory, txURI, false);
			qvtrResource.setURI(getURI());
			// FIXME Following code fixes up missing source. Should be fixed earlier.
			List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, qvtrResource);
			if (missingOperationCallSources != null) {
				System.err.println("Missing OperationCallExp sources were fixed up for '" + txURI + "'");
			}
			boolean missingTraceArtefacts = QVTrelationUtil.rewriteMissingTraceArtefacts(environmentFactory, qvtrResource);
			if (missingTraceArtefacts) {
				System.err.println("Missing trace TypedModel.Class artefacts were fixed up for '" + txURI + "'");
			}
			checkForProxyURIs(qvtrResource);
			saveResource(qvtrResource);
			return qvtrResource;
		}
	}

	protected static class QVTr2QVTsCompilerStep extends AbstractCompilerStep
	{
		public QVTr2QVTsCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTS_STEP);
			AbstractQVTb2QVTs.DEBUG_GRAPHS.setState(basicGetOption(CompilerChain.DEBUG_KEY) == Boolean.TRUE);
		}

		public @NonNull ScheduleManager execute(@NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				CompilerOptions.StepOptions schedulerOptions = compilerChain.basicGetOptions(CompilerChain.QVTS_STEP);
				Transformation asTransformation = AbstractCompilerChain.getTransformation(qvtrResource);
				QVTuConfiguration qvtuConfiguration = ((AbstractCompilerChain)compilerChain).createQVTuConfiguration(qvtrResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputNames);
				//				>>>>>>> fd5dac8 [529130] Change to QVTr-to-QVTs+trace in CompilerChain
				QVTr2QVTs qvtr2qvts = new QVTr2QVTs(environmentFactory, this, qvtuConfiguration, schedulerOptions);
				ScheduleManager scheduleManager = qvtr2qvts.getScheduleManager();
				scheduleManager.addTransformation(asTransformation);
				Resource qvtsResource = createResource();
				qvtsResource.getContents().add(scheduleManager.getScheduleModel());
				//
				//	QVTr to QVTs and trace
				//
				Map<@NonNull String, @Nullable String> traceOptions = compilerChain.basicGetOption(TRACE_STEP, TRACE_OPTIONS_KEY);
				String traceNsURI = traceOptions != null ? traceOptions.get(TRACE_NS_URI) : null;
				//				if (traceNsURI != null) {
				//					t.setTraceNsURI(traceNsURI);
				//				}
				Map<@NonNull RootRegion, Iterable<@NonNull MappingRegion>> rootRegion2activeRegions = qvtr2qvts.transform(qvtrResource, qvtsResource, traceNsURI, traceResource);
				//
				//	Save trace (occurs as part of GenModel creation)
				//
				if (false) {		// FIXME true for debugging but results in two same-URI resources, need to unload this temporary
					URI ecoreURI = traceResource.getURI().trimFileExtension();
					AS2Ecore as2ecore = new AS2Ecore(environmentFactory, ecoreURI, null);
					XMLResource ecoreResource = as2ecore.convertResource(traceResource, ecoreURI);
					ecoreResource.save(null);
					throwCompilerChainExceptionForErrors();
				}
				//
				//	QVTs optimization
				//
				//				List<@NonNull MappingRegion> activeRegions = qvtr2qvts.getActiveRegions();
				String rootName = ClassUtil.nonNullState(qvtrResource.getURI().trimFileExtension().trimFileExtension().lastSegment());
				QVTs2QVTs qvts2qvts = new QVTs2QVTs(this, scheduleManager, rootName);
				qvts2qvts.transform(scheduleManager, rootRegion2activeRegions);
				throwCompilerChainExceptionForErrors();
				saveResource(qvtsResource);
				return scheduleManager;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected static class CreateGenModelCompilerStep extends AbstractCompilerStep
	{
		public CreateGenModelCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, TRACE_STEP);
		}

		public void execute(@NonNull Resource traceResource) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				//
				//	Create and Save Ecore variant of Trace Model
				//
				URI ecoreURI = compilerChain.getURI(TRACE_STEP, URI_KEY);
				AS2Ecore as2ecore = new AS2Ecore(environmentFactory, ecoreURI, null);
				XMLResource ecoreResource = as2ecore.convertResource(traceResource, ecoreURI);
				Map<Object, Object> saveOptions = compilerChain.basicGetOption(TRACE_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				ecoreResource.save(saveOptions);
				throwCompilerChainExceptionForErrors();
				assertNoResourceSetErrors("Trace save", traceResource);
				compiled(traceResource);
				//
				//	Create and Save GenModel
				//
				URI genModelURI = compilerChain.getURI(GENMODEL_STEP, URI_KEY);
				saveOptions = compilerChain.basicGetOption(GENMODEL_STEP, SAVE_OPTIONS_KEY);
				if (saveOptions == null) {
					saveOptions = XMIUtil.createSaveOptions();
				}
				saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				Collection<@NonNull ? extends GenPackage> usedGenPackages = compilerChain.basicGetOption(GENMODEL_STEP, GENMODEL_USED_GENPACKAGES_KEY);
				saveGenModel(this, traceResource, genModelURI, compilerChain.basicGetOption(GENMODEL_STEP, GENMODEL_OPTIONS_KEY), saveOptions, usedGenPackages);
				//					>>>>>>> fd5dac8 [529130] Change to QVTr-to-QVTs+trace in CompilerChain
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}

		private void getUsedGenPackageClosure(@NonNull ProblemHandler problemHandler, @NonNull Map<@NonNull String, @NonNull GenPackage> uri2genPackage, @NonNull Iterable<@NonNull ? extends GenPackage> genPackages) {
			for (@NonNull GenPackage newGenPackage : genPackages) {
				String nsURI = newGenPackage.getNSURI();
				if (nsURI == null) {
					problemHandler.addProblem(new CompilerChainException("Null nsURI for " + newGenPackage, newGenPackage));
				}
				else {
					GenPackage oldGenPackage = uri2genPackage.put(nsURI, newGenPackage);
					if (oldGenPackage != newGenPackage) {
						if (oldGenPackage != null) {
							problemHandler.addProblem(new CompilerChainException("Conflicting " + oldGenPackage + " ignored", oldGenPackage));
						}
						else {
							GenModel newGenModel = newGenPackage.getGenModel();
							Iterable<GenPackage> newUsedGenPackages = ClassUtil.nullFree(newGenModel.getUsedGenPackages());
							getUsedGenPackageClosure(problemHandler, uri2genPackage, newUsedGenPackages);
						}
					}
				}
			}
		}

		public static @NonNull String getProjectName(@NonNull URI traceURI) {
			URI trimFileExtension = traceURI.trimFileExtension();
			if (trimFileExtension.isPlatform()) {
				return trimFileExtension.segment(1);
			}
			else {
				return trimFileExtension.segment(0);
			}
		}

		public @NonNull GenModel saveGenModel(@NonNull ProblemHandler problemHandler, @NonNull Resource asResource, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> genModelOptions, @NonNull Map<Object, Object> saveOptions2, @Nullable Collection<@NonNull ? extends GenPackage> usedGenPackages) throws IOException {
			URI traceURI = asResource.getURI();
			assert traceURI != null;
			@NonNull URI ecoreURI = PivotUtilInternal.getNonASURI(traceURI);
			URI trimFileExtension = traceURI.trimFileExtension();
			String projectName = getProjectName(traceURI);
			Resource genmodelResource = environmentFactory.getResourceSet().createResource(genModelURI);
			@SuppressWarnings("null")@NonNull GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
			genModel.getForeignModel().add(ecoreURI.lastSegment());
			String copyrightText = genModelOptions != null ? genModelOptions.get(CompilerChain.GENMODEL_COPYRIGHT_TEXT) : null;
			if (copyrightText != null) {
				genModel.setCopyrightText(copyrightText);
			}
			Map<@NonNull String, @NonNull GenPackage> uri2genPackage = new HashMap<>();
			List<@NonNull GenPackage> allUsedGenPackages = new ArrayList<>();
			if (usedGenPackages != null) {
				getUsedGenPackageClosure(problemHandler, uri2genPackage, usedGenPackages);
				allUsedGenPackages.addAll(uri2genPackage.values());
				Collections.sort(allUsedGenPackages, GenPackageComparator.INSTANCE);
				genModel.getUsedGenPackages().addAll(allUsedGenPackages);
			}
			genModel.setModelDirectory("/" + projectName + "/" + JavaFileUtil.TEST_SRC_FOLDER_NAME);
			genModel.setModelPluginID(projectName);
			genModel.setModelName(trimFileExtension.lastSegment());
			genModel.setBundleManifest(false);
			genModel.setUpdateClasspath(false);
			genModel.setImporterID(new EcoreImporter().getID());
			genModel.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
			genModel.setCopyrightFields(false);
			genModel.setOperationReflection(true);
			genModel.setImportOrganizing(true);
			genModel.setRootExtendsClass(MinimalEObjectImpl.Container.class.getName());
			genModel.setPluginKey("");
			genModel.setTemplateDirectory("/org.eclipse.ocl.examples.codegen/templates");
			genmodelResource.getContents().add(genModel);
			String basePrefix = genModelOptions != null ? genModelOptions.get(CompilerChain.GENMODEL_BASE_PREFIX) : null;
			List<GenPackage> genPackages = genModel.getGenPackages();
			for (EObject eObject : asResource.getContents()) {
				if (eObject instanceof Model) {
					Model asModel = (Model)eObject;
					for (org.eclipse.ocl.pivot.@NonNull Package asPackage : QVTrelationUtil.getOwnedPackages(asModel)) {
						GenPackage genPackage = genModel.createGenPackage();
						EPackage ePackage = (EPackage) asPackage.getESObject();
						genPackage.setEcorePackage(ePackage);
						genPackage.setPrefix(ePackage.getName());
						if (basePrefix != null) {
							genPackage.setBasePackage(basePrefix);
						}
						genPackages.add(genPackage);
					}
					Set<org.eclipse.ocl.pivot.@NonNull Package> asPackages = new HashSet<>();
					for (EObject element : new TreeIterable(asModel, false)) {
						if (element instanceof Property) {
							Property property = (Property)element;
							Type type = property.getType();
							while (type instanceof CollectionType) {
								type = ((CollectionType)type).getElementType();
							}
							if (type instanceof org.eclipse.ocl.pivot.Class) {
								org.eclipse.ocl.pivot.Package asPackage = ((org.eclipse.ocl.pivot.Class)type).getOwningPackage();
								if (asPackage != null) {
									asPackages.add(asPackage);
								}
							}
						}
					}
					for (@NonNull Import asImport : QVTrelationUtil.getOwnedImports(asModel)) {
						Namespace asNamespace = asImport.getImportedNamespace();
						if (asNamespace instanceof org.eclipse.ocl.pivot.Package) {
							org.eclipse.ocl.pivot.@NonNull Package asPackage = (org.eclipse.ocl.pivot.Package)asNamespace;
							asPackages.add(asPackage);
						}
					}
					List<org.eclipse.ocl.pivot.@NonNull Package> asPackageList = new ArrayList<>(asPackages);
					Collections.sort(asPackageList, NameUtil.NAMEABLE_COMPARATOR);
					for (org.eclipse.ocl.pivot.@NonNull Package asPackage : asPackageList) {
						EPackage ePackage = (EPackage) asPackage.getESObject();
						if (ePackage != null) {
							GenPackage genPackage = null;
							if (allUsedGenPackages != null) {
								for (@NonNull GenPackage usedGenPackage : allUsedGenPackages) {
									EPackage ecorePackage = usedGenPackage.getEcorePackage();
									if ((ecorePackage != null) && ClassUtil.safeEquals(ecorePackage.getNsURI(), ePackage.getNsURI())) {
										genPackage = usedGenPackage;
										break;
									}
								}
							}
							if (genPackage == null) {
								for (GenPackage aGenPackage : genPackages) {
									if (aGenPackage.getEcorePackage() == ePackage) {
										genPackage = aGenPackage;
										break;
									}
								}
								if (genPackage == null) {
									genPackage = genModel.createGenPackage();
									genPackage.setEcorePackage(ePackage);
									genPackage.setPrefix(ePackage.getName());
									if (basePrefix != null) {
										genPackage.setBasePackage(basePrefix);
									}
									genPackages.add(genPackage);
								}
							}
						}
					}
				}
			}
			genModel.reconcile();
			Map<Object, Object> saveOptions = new HashMap<>(saveOptions2);
			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
			saveOptions.put(DerivedConstants.RESOURCE_OPTION_LINE_DELIMITER, "\n");
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
			genmodelResource.save(saveOptions);
			return genModel;
		}
	}

	protected final @NonNull Xtext2QVTrCompilerStep xtext2qvtrCompilerStep;
	protected final @NonNull QVTr2QVTsCompilerStep qvtr2qvtsCompilerStep;
	protected final @NonNull CreateGenModelCompilerStep createGenModelCompilerStep;
	protected final @NonNull GenModelGenerateCompilerStep genmodelGenerateCompilerStep;

	public QVTrCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
		super(environmentFactory, txURI, intermediateFileNamePrefixURI, options);
		this.xtext2qvtrCompilerStep = createXtext2QVTrCompilerStep();
		this.qvtr2qvtsCompilerStep = createQVTr2QVTsCompilerStep();
		this.createGenModelCompilerStep = createCreateGenModelCompilerStepStep();
		this.genmodelGenerateCompilerStep = createGenModelGenerateCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException {
		Resource qvtrResource = xtext2qvtrCompilerStep.execute(txURI);
		return qvtr2qvti(qvtrResource, enforcedOutputNames);
	}

	public @NonNull ImperativeTransformation qvtr2qvti(@NonNull Resource qvtrResource, @NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException {
		URI ecoreTraceURI = getURI(TRACE_STEP, URI_KEY);
		URI traceURI = PivotUtilInternal.getASURI(ecoreTraceURI);
		Resource traceResource = createResource(traceURI);
		ScheduleManager scheduleManager = qvtr2qvtsCompilerStep.execute(qvtrResource, traceResource, enforcedOutputNames);
		createGenModelCompilerStep.execute(traceResource);
		return qvts2qvtiCompilerStep.execute(scheduleManager);
	}

	protected @NonNull CreateGenModelCompilerStep createCreateGenModelCompilerStepStep() {
		return new CreateGenModelCompilerStep(this);
	}

	protected @NonNull GenModelGenerateCompilerStep createGenModelGenerateCompilerStep() {
		return new GenModelGenerateCompilerStep(this);
	}

	protected @NonNull QVTr2QVTsCompilerStep createQVTr2QVTsCompilerStep() {
		return new QVTr2QVTsCompilerStep(this);
	}

	protected @NonNull Xtext2QVTrCompilerStep createXtext2QVTrCompilerStep() {
		return new Xtext2QVTrCompilerStep(this);
	}

	@Override
	public @NonNull Class<? extends Transformer> generate(@NonNull ImperativeTransformation asTransformation, @NonNull String... genModelFiles) throws Exception {
		genmodelGenerateCompilerStep.execute();
		return super.generate(asTransformation, genModelFiles);
	}
}
