/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.AbstractQVTc2QVTc;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

public class QVTr2QVTc extends AbstractQVTc2QVTc
{
	public static final @NonNull TracingOption CALL_TREE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/callTree");
	public static final @NonNull TracingOption SYNTHESIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/synthesis");
	public static final @NonNull TracingOption VARIABLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/variables");

	public static final class GenPackageComparator implements Comparator<@NonNull GenPackage>
	{
		public static final @NonNull GenPackageComparator INSTANCE = new GenPackageComparator();

		@Override
		public int compare(@NonNull GenPackage o1, @NonNull GenPackage o2) {
			String n1 = String.valueOf(o1.getNSURI());
			String n2 = String.valueOf(o2.getNSURI());
			return n1.compareTo(n2);
		}
	}

	protected static class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTr2QVTc>
	{
		public CreateVisitor(@NonNull QVTr2QVTc context) {
			super(context);
		}
	}

	public static final class RelationComparator implements Comparator<@NonNull Relation>
	{
		private @NonNull Map<@NonNull Relation, @NonNull Set<@NonNull Relation>> relation2overriddens = new HashMap<>();

		@Override
		public int compare(@NonNull Relation r1, @NonNull Relation r2) {
			//
			//	Top level first
			//
			boolean t1 = r1.isIsTopLevel();
			boolean t2 = r2.isIsTopLevel();
			if (t1 != t2) {
				return t1 ? -1 : 1;
			}
			//
			//	Overriding last
			//
			Set<@NonNull Relation> o1 = getOverriddens(r1);
			Set<@NonNull Relation> o2 = getOverriddens(r2);
			if (o1.contains(r2)) {
				assert !o2.contains(r1);
				return 1;
			}
			else if (o2.contains(r1)) {
				return -1;
			}
			//
			//	Alphabetical
			//
			String n1 = NameUtil.getSafeName(r1);
			String n2 = NameUtil.getSafeName(r2);
			return ClassUtil.safeCompareTo(n1, n2);
		}

		private @NonNull Set<@NonNull Relation> getOverriddens(@NonNull Relation relation) {
			Set<@NonNull Relation> overriddens = relation2overriddens.get(relation);
			if (overriddens == null) {
				overriddens = new HashSet<>();
				for (Relation overridden = relation; overridden != null; overridden = QVTrelationUtil.basicGetOverridden(overridden)) {
					if (!overriddens.add(overridden)) {
						System.err.println("Cyclic override for " + relation + " at " + overridden);
						break;
					}
				}
				relation2overriddens.put(relation, overriddens);
			}
			return overriddens;
		}
	}

	protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTr2QVTc>
	{
		public UpdateVisitor(@NonNull QVTr2QVTc context) {
			super(context);
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

	protected final @NonNull StandardLibrary standardLibrary;
	private final @NonNull Resource qvtrResource;
	protected final @NonNull QVTrNameGenerator nameGenerator;

	/**
	 * Optional configuration of the NsURI of the trace package.
	 */
	private @Nullable String traceNsURI = null;
	private final @NonNull Map<@NonNull Element, @NonNull Element> globalTarget2source = new HashMap<>();
	private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> globalSource2targets = new HashMap<>();

	/**
	 * The Core model for the result.
	 */
	private @NonNull CoreModel coreModel;

	/**
	 * The relational TypedModel for each core TypedModel.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull TypedModel> coreTypedModel2relationalTypedModel = new HashMap<>();

	/**
	 * All leaf packages that contribute to the trace. Typically just one leaf package. May be many.
	 */
	private final @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> txTracePackages = new ArrayList<>();

	/**
	 * The core TypedModel for each relational TypedModel.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull TypedModel> relationalTypedModel2coreTypedModel = new HashMap<>();

	/**
	 * The TransformationAnalysis of each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, @NonNull TransformationAnalysis> transformation2transformationAnalysis = new HashMap<>();

	/**
	 * The RelationalTransformation2CoreTransformation conversion for each TransformationAnalysis.
	 */
	private @NonNull Map<@NonNull TransformationAnalysis, @NonNull RelationalTransformation2CoreTransformation> transformationAnalysis2relationalTransformation2coreTransformation = new HashMap<>();

	/**
	 * The RelationalTransformation2TracePackage conversion for each TransformationAnalysis.
	 */
	private @NonNull Map<@NonNull TransformationAnalysis, @NonNull RelationalTransformation2TracePackage> transformationAnalysis2relationalTransformation2tracePackage = new HashMap<>();

	private @Nullable Property oclContainerProperty = null;

	public QVTr2QVTc(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource) {
		super(environmentFactory);
		this.standardLibrary = environmentFactory.getStandardLibrary();
		this.qvtrResource = qvtrResource;
		this.nameGenerator = new QVTrNameGenerator(this);
		this.coreModel = QVTcoreFactory.eINSTANCE.createCoreModel();

		// Create a cache of opposite relations and copy imports
		TreeIterator<EObject> it = qvtrResource.getAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof RelationalTransformation) {
				RelationalTransformation rTransformation = (RelationalTransformation)eo;
				transformation2transformationAnalysis.put(rTransformation, new TransformationAnalysis(this, rTransformation));
			}
			if (eo instanceof Import) {
				this.coreModel.getOwnedImports().add((Import) EcoreUtil.copy(eo));
			}
		}
		for (TransformationAnalysis transformationAnalysis : transformation2transformationAnalysis.values()) {
			transformationAnalysis.analyze();
		}
	}

	public Element createCopy(@NonNull Element cElement) {
		return cElement.accept(createVisitor);
	}

	public @NonNull CoreDomain createCoreDomain(@NonNull TypedModel typedModel) {
		CoreDomain coreDomain = QVTcoreFactory.eINSTANCE.createCoreDomain();
		coreDomain.setTypedModel(typedModel);
		coreDomain.setName(QVTrelationUtil.getName(typedModel));
		//			putTrace(coreDomain, coreRule);
		GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
		coreDomain.setGuardPattern(guardPattern);
		//			putTrace(guardPattern, coreRule);
		BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
		coreDomain.setBottomPattern(bottomPattern);
		return coreDomain;
	}

	@Override
	protected @NonNull AbstractCreateVisitor<@NonNull ?> createCreateVisitor() {
		return new CreateVisitor(this);
	}

	@Override
	protected @NonNull AbstractUpdateVisitor<@NonNull ?> createUpdateVisitor() {
		return new UpdateVisitor(this);
	}

	// Save the qvtc resource
	public void dispose() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
	}

	public @NonNull TypedModel getCoreTypedModel(@NonNull TypedModel relationTypedModel) {
		return ClassUtil.nonNullState(relationalTypedModel2coreTypedModel.get(relationTypedModel));
	}

	public @Nullable List<@NonNull Element> getGlobalTargets(@NonNull Element element) {
		return globalSource2targets.get(element);
	}

	public @NonNull QVTrNameGenerator getNameGenerator() {
		return nameGenerator;
	}

	public @NonNull Property getOclContainerProperty() {
		Property oclContainerProperty2 = oclContainerProperty;
		if (oclContainerProperty2 == null) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			oclContainerProperty2 = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContainer");
			assert oclContainerProperty2 != null : "OCL Standard Library has no OclElement::oclContainer property";
			oclContainerProperty = oclContainerProperty2;
		}
		return oclContainerProperty2 ;
	}

	public @NonNull RelationalTransformation2CoreTransformation getRelationalTransformation2CoreTransformation(@NonNull TransformationAnalysis transformationAnalysis) {
		return ClassUtil.nonNullState(transformationAnalysis2relationalTransformation2coreTransformation.get(transformationAnalysis));
	}

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage(@NonNull TransformationAnalysis transformationAnalysis) {
		return ClassUtil.nonNullState(transformationAnalysis2relationalTransformation2tracePackage.get(transformationAnalysis));
	}

	public @NonNull TypedModel getRelationTypedModel(@NonNull TypedModel coreTypedModel) {
		return ClassUtil.nonNullState(coreTypedModel2relationalTypedModel.get(coreTypedModel));
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nonNullState(transformation2transformationAnalysis.get(rTransformation));
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

	/*private*/ void putGlobalTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
		//		if (relationElement != null) {
		Element oldRelationElement = globalTarget2source.put(coreElement, relationElement);
		assert oldRelationElement == null;
		List<@NonNull Element> targets = globalSource2targets.get(relationElement);
		if (targets == null) {
			targets = new ArrayList<> ();
			globalSource2targets.put(relationElement, targets);
		}
		targets.add(coreElement);
		//		}
	}

	public void putTypedModel(@NonNull TypedModel relationTypedModel, @NonNull TypedModel coreTypedModel) {
		TypedModel oldTypedModel = relationalTypedModel2coreTypedModel.put(relationTypedModel, coreTypedModel);
		assert oldTypedModel == null;
		oldTypedModel = coreTypedModel2relationalTypedModel.put(coreTypedModel, relationTypedModel);
		assert oldTypedModel == null;
	}

	public void saveCore(@NonNull Resource asResource, @NonNull Map<?, ?> options) throws IOException {
		asResource.getContents().add(this.coreModel);
		// Copy imports

		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : txTracePackages) {
			Import asImport = createImport(null, asPackage);
			coreModel.getOwnedImports().add(asImport);
		}
		//		-- scan for dangling references if this is really wanted
		//		for (EObject eObject : potentialOrphans) {
		//			if (eObject.eContainer() == null) {
		//				asResource.getContents().add(eObject);
		//			}
		//		}
		asResource.save(options);
	}

	public @NonNull GenModel saveGenModel(@NonNull ProblemHandler problemHandler, @NonNull Resource asResource, @NonNull URI traceURI, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> genModelOptions, @NonNull Map<Object, Object> saveOptions2, @Nullable Collection<@NonNull ? extends GenPackage> usedGenPackages) throws IOException {
		URI trimFileExtension = traceURI.trimFileExtension();
		String projectName = getProjectName(traceURI);
		Resource genmodelResource = environmentFactory.getResourceSet().createResource(genModelURI);
		@SuppressWarnings("null")@NonNull GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.getForeignModel().add(traceURI.lastSegment());
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
		genModel.setModelDirectory("/" + projectName + "/src-gen");
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
		genModel.reconcile();
		Map<Object, Object> saveOptions = new HashMap<>(saveOptions2);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(DerivedConstants.RESOURCE_OPTION_LINE_DELIMITER, "\n");
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
		genmodelResource.save(saveOptions);
		return genModel;
	}

	public @NonNull Resource saveTrace(@NonNull Resource asResource, @NonNull URI traceURI, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> traceOptions, @NonNull Map<?, ?> saveOptions) throws IOException {
		Model root = PivotFactory.eINSTANCE.createModel();
		root.setExternalURI(traceURI.toString());
		asResource.getContents().add(root);
		if ((traceNsURI != null) && (txTracePackages.size() == 1)) {
			txTracePackages.get(0).setURI(traceNsURI);
		}
		for (org.eclipse.ocl.pivot.@NonNull Package txTracePackage : txTracePackages) {
			org.eclipse.ocl.pivot.@NonNull Package rootPackage = txTracePackage;
			for (EObject eContainer = rootPackage.eContainer(); eContainer instanceof org.eclipse.ocl.pivot.Package; eContainer = eContainer.eContainer()) {
				rootPackage = (org.eclipse.ocl.pivot.Package)eContainer;
			}
			if (!root.getOwnedPackages().contains(rootPackage)) {
				root.getOwnedPackages().add(rootPackage);
			}
		}
		AS2Ecore as2ecore = new AS2Ecore((EnvironmentFactoryInternal) environmentFactory, traceURI, null);
		XMLResource ecoreResource = as2ecore.convertResource(asResource, traceURI);
		ecoreResource.save(saveOptions);
		return ecoreResource;
	}

	public void setTraceNsURI(@Nullable String traceNsURI) {
		this.traceNsURI = traceNsURI;
	}

	public void transformToCoreTransformations() throws CompilerChainException {
		setDebugSource(qvtrResource);
		//
		//	Build the corresponding QVTc Model/Package/Transformation hierarchy.
		//
		for (@NonNull EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				RelationModel relationModel = (RelationModel)eObject;
				String externalURI = relationModel.getExternalURI();
				if (externalURI.endsWith(".qvtras")) {
					externalURI = externalURI.replace(".qvtras", ".qvtcas");
				}
				else if (externalURI.endsWith(".qvtr")) {
					externalURI = externalURI.replace(".qvtr", ".qvtcas");
				}
				coreModel.setExternalURI(externalURI);
				transformToCoreTransformationHierarchy(QVTrelationUtil.Internal.getOwnedPackagesList(coreModel), QVTrelationUtil.getOwnedPackages(relationModel));
			}
		}
		List<@NonNull TransformationAnalysis> transformationAnalyses = new ArrayList<>(transformation2transformationAnalysis.values());
		Collections.sort(transformationAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull TransformationAnalysis transformationAnalysis : transformationAnalyses) {
			RelationalTransformation2CoreTransformation relationalTransformation2CoreTransformation = getRelationalTransformation2CoreTransformation(transformationAnalysis);
			Transformation cTransformation = relationalTransformation2CoreTransformation.getCoreTransformation();
			pushScope(cTransformation);
			relationalTransformation2CoreTransformation.transformContents();
			popScope();
		}
		/*		for (@NonNull Transformation cTransformation : rTransformation2cTransformation.values()) {
			List<DebugTraceBack> debugTraceBacks = cTransformation.getOwnedDebugTraceBacks();
			for (@NonNull Element target : target2source.keySet()) {
				if (QVTbaseUtil.getContainingTransformation(target) == cTransformation) {
					DebugTraceBack traceBack = QVTbaseFactory.eINSTANCE.createDebugTraceBack();
					traceBack.setTarget(target);
// FIXME true source URI					traceBack.getSources().add(target2source.get(target));
					debugTraceBacks.add(traceBack);
				}
			}
//			CompilerUtil.normalizeNameables(debugTraceBacks);
		} */
	}

	/**
	 * Descend the relationPackages hierarchy to establish a QVTc transformation object for each QVTr transformation object with a corresponding package hierarchy in corePackages.
	 */
	private void transformToCoreTransformationHierarchy(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> corePackages, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) {
		for (org.eclipse.ocl.pivot.@NonNull Package relationPackage : relationPackages) {
			String name = relationPackage.getName();
			assert name != null;
			org.eclipse.ocl.pivot.@NonNull Package corePackage = createPackage(name, relationPackage.getNsPrefix(), relationPackage.getURI());
			corePackages.add(corePackage);
			//
			//	Transform the transformations to establish callable names.
			//
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : QVTrelationUtil.getOwnedClasses(relationPackage)) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformation rTransformation = (RelationalTransformation)relationClass;
					TransformationAnalysis transformationAnalysis = getTransformationAnalysis(rTransformation);
					RelationalTransformation2CoreTransformation relationalTransformation2coreTransformation = new RelationalTransformation2CoreTransformation(this, transformationAnalysis);
					transformationAnalysis2relationalTransformation2coreTransformation.put(transformationAnalysis, relationalTransformation2coreTransformation);
					Transformation cTransformation = relationalTransformation2coreTransformation.transform();
					corePackage.getOwnedClasses().add(cTransformation);
					//					CompilerUtil.normalizeNameables(QVTrelationUtil.getRule(cTransformation)));
				}
			}
			CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedClassesList(corePackage));
			//
			//	Recurse to establish callable names in nested packages.
			//
			transformToCoreTransformationHierarchy(QVTrelationUtil.Internal.getOwnedPackagesList(corePackage), QVTrelationUtil.getOwnedPackages(relationPackage));
		}
	}

	public void transformToTracePackages() throws CompilerChainException {
		List<org.eclipse.ocl.pivot.@NonNull Package> rootTracePackages = null;
		for (@NonNull EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages = transformToTracePackageHierarchy(QVTrelationUtil.getOwnedPackages((RelationModel)eObject));
				if (tracePackages != null) {
					if (rootTracePackages == null) {
						rootTracePackages = new ArrayList<>();
					}
					rootTracePackages.addAll(tracePackages);
				}
			}
		}
		if (rootTracePackages != null) {
			CompilerUtil.normalizeNameables(rootTracePackages);
		}
	}

	private @Nullable List<org.eclipse.ocl.pivot.@NonNull Package> transformToTracePackageHierarchy(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) throws CompilerChainException {
		List<org.eclipse.ocl.pivot.@NonNull Package> nestingTracePackages = null;
		for (org.eclipse.ocl.pivot.@NonNull Package relationPackage : relationPackages) {
			List<org.eclipse.ocl.pivot.@NonNull Package> nestedTracePackages = null;
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : QVTrelationUtil.getOwnedClasses(relationPackage)) {
				if (relationClass instanceof RelationalTransformation) {
					TransformationAnalysis transformationAnalysis = getTransformationAnalysis((RelationalTransformation)relationClass);
					RelationalTransformation2TracePackage relationalTransformation2tracePackage = new RelationalTransformation2TracePackage(this, transformationAnalysis);
					transformationAnalysis2relationalTransformation2tracePackage.put(transformationAnalysis, relationalTransformation2tracePackage);
					org.eclipse.ocl.pivot.Package nestedTracePackage = relationalTransformation2tracePackage.transform();
					txTracePackages.add(nestedTracePackage);
					if (nestedTracePackages == null) {
						nestedTracePackages = new ArrayList<>();
					}
					nestedTracePackages.add(nestedTracePackage);
				}
			}
			List<org.eclipse.ocl.pivot.@NonNull Package> nestedTracePackages2 = transformToTracePackageHierarchy(QVTrelationUtil.Internal.getOwnedPackagesList(relationPackage));
			if (nestedTracePackages2 != null) {
				if (nestedTracePackages == null) {
					nestedTracePackages = new ArrayList<>();
				}
				nestedTracePackages.addAll(nestedTracePackages2);
			}
			if (nestedTracePackages != null) {
				CompilerUtil.normalizeNameables(nestedTracePackages);
				//				String uri = relationPackage.getURI();		// FIXME replicate tx package hierarchy
				//				if (uri == null) {
				//					StringBuilder s = new StringBuilder();
				//					getURI(relationPackage, s);
				//					uri = s.toString();
				//				}
				//				org.eclipse.ocl.pivot.Package nestingTracePackage = helper.createPackage(ClassUtil.nonNull(relationPackage.getName()), relationPackage.getNsPrefix(), uri);
				//				nestingTracePackage.getOwnedPackages().addAll(nestedTracePackages);
				if (nestingTracePackages == null) {
					nestingTracePackages = new ArrayList<>();
				}
				//				nestingTracePackages.add(nestingTracePackage);
				nestingTracePackages.addAll(nestedTracePackages);
			}
		}
		return nestingTracePackages;
	}

	public void updateCopy(@NonNull Element cElement) {
		cElement.accept(updateVisitor);
	}
}
