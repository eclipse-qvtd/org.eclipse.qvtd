/*******************************************************************************
 * Copyright (c) 2014, 2016 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
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
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGeneratorAdapterFactory;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
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
import org.eclipse.qvtd.compiler.internal.common.AbstractQVTc2QVTc;
import org.eclipse.qvtd.compiler.internal.genmodel.QVTdGenModelGeneratorAdapterFactory;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.UniqueArrayList;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class QVTr2QVTc extends AbstractQVTc2QVTc
{
	public static final @NonNull TracingOption SYNTHESIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/synthesis");
	public static final @NonNull TracingOption VARIABLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/variables");

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

	protected static class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTr2QVTc>
	{
		public CreateVisitor(@NonNull QVTr2QVTc context) {
			super(context);
		}
	}

	private class Issues {

		public void addError(QVTr2QVTc qvTrToQVTc, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.err.println(message);
		}

		public void addWarning(QVTr2QVTc qvTrToQVTc, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.out.println(message);
		}

		public void addError(QVTr2QVTc qvTrToQVTc, String string) {
			System.err.println(string);
		}

		public void addWarning(QVTr2QVTc qvTrToQVTc, String string) {
			System.out.println(string);
		}
	}

	protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTr2QVTc>
	{
		public UpdateVisitor(@NonNull QVTr2QVTc context) {
			super(context);
		}
	}

	protected final @NonNull StandardLibrary standardLibrary;
	private final @NonNull Resource qvtrResource;
	private final @NonNull Resource qvtcResource;
	protected final @NonNull QVTrelationHelper rHelper;
	protected final @NonNull QVTrNameGenerator nameGenerator;

	/**
	 * Optional configuration of the NsURI of the trace package.
	 */
	private @Nullable String traceNsURI = null;
	private final @NonNull Map<@NonNull Element, @NonNull Element> globalTarget2source = new HashMap<>();
	private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> globalSource2targets = new HashMap<>();

	/**
	 * All leaf packages that contribute to the trace. Typically just one leaf package. May be many.
	 */
	private final @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> txTracePackages = new ArrayList<>();
	//	private final @NonNull List<@NonNull Transformation> cTransformations = new ArrayList<@NonNull Transformation>();

	/**
	 * Mapping from each key via the TYpedModel in which it is enforced to its corresponding identification constructor function.
	 */
	private final @NonNull Map<@NonNull Key, @NonNull Map<@NonNull TypedModel, @NonNull Function>> key2typedModel2function = new HashMap<>();

	/**
	 * The Key that identifies each Class.
	 * Multiple keys per class are prohibited by WFRs. See Bug 512532 for rationale.
	 * Singly-derived keys re-use the ancestral key, with a distinct key-class.
	 * Multiply-derived keys are synthesized lazily.
	 * A null value indicates that no key exists.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @Nullable Key> completeClass2key = new HashMap<>();

	/**
	 * Mapping from each relation to its corresponding trace class.
	 */
	private final @NonNull Map<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class> relation2traceClass = new HashMap<>();

	/**
	 * Mapping from each relation to its corresponding trace class.
	 */
	private final @NonNull Map<@NonNull RelationCallExp, org.eclipse.ocl.pivot.@NonNull Class> invocation2traceClass = new HashMap<>();

	/**
	 * Map from each relation to all the expressions that call the relationfrom a where clause.
	 */
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2whenInvocations = new HashMap<>();

	/**
	 * Map from each relation to all the expressions that call the relationfrom a when clause.
	 */
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2whereInvocations = new HashMap<>();

	/**
	 * Map from each relation invocation the relation whose where predicate contains the invocation.
	 * @deprecated computable - no cache required
	 */
	@Deprecated
	private final @NonNull Map<@NonNull RelationCallExp, @NonNull Relation> invocation2invokingRelation = new HashMap<>();

	private @NonNull CoreModel coreModel;

	/**
	 * The core Transformation for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, @NonNull Transformation> rTransformation2cTransformation = new HashMap<>();

	/**
	 * The trace Package for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, org.eclipse.ocl.pivot.@NonNull Package> rTransformation2tracePackage = new HashMap<>();

	/**
	 * The core TypedModel for each Relational TypedModel.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull TypedModel> relationalTypedModel2coreTypedModel = new HashMap<>();

	/**
	 * The lazily created named Trace Properties in each Trace Class.
	 */
	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Map<@NonNull String, @NonNull Property>> traceClass2name2traceProperty = new HashMap<>();

	/**
	 * The lazily created named Core mappings for each transformation.
	 */
	private @NonNull Map<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>> transformation2name2mapping = new HashMap<>();

	/**
	 * The root variables (in relation call order) of each relation.
	 */
	private @NonNull Map<@NonNull Relation, @NonNull List<@NonNull Variable>> relation2rootVariables = new HashMap<>();

	private @Nullable Property oclContainerProperty = null;

	public QVTr2QVTc(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource qvtcResource) {
		super(environmentFactory);
		this.standardLibrary = environmentFactory.getStandardLibrary();
		this.qvtrResource = qvtrResource;
		this.qvtcResource = qvtcResource;
		//		this.traceResource = traceResource;
		this.rHelper = new QVTrelationHelper(environmentFactory);
		this.nameGenerator = new QVTrNameGenerator(this);
		this.coreModel = QVTcoreFactory.eINSTANCE.createCoreModel();

		// Create a cache of opposite relations and copy imports
		TreeIterator<EObject> it = qvtrResource.getAllContents();
		while (it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Key) {
				analyzeKey((Key)eo);
			}
			if (eo instanceof Relation) {
				Relation relation = (Relation)eo;
				analyzeInvocations(relation);
				analyzeRootVariables(relation);
			}
			if (eo instanceof Import) {
				this.coreModel.getOwnedImports().add((Import) EcoreUtil.copy(eo));
			}
		}
	}

	protected void analyzeInvocations(@NonNull Relation callingRelation) {
		Pattern whenPattern = callingRelation.getWhen();
		if (whenPattern != null) {
			analyzeInvocations(callingRelation, whenPattern, relation2whenInvocations);
		}
		Pattern wherePattern = callingRelation.getWhere();
		if (wherePattern != null) {
			analyzeInvocations(callingRelation, wherePattern, relation2whereInvocations);
		}
	}

	protected void analyzeInvocations(@NonNull Relation callingRelation, @NonNull Pattern pattern,
			@NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2invocations2) {
		for (Predicate predicate : pattern.getPredicate()) {
			OCLExpression predicateExpression = predicate.getConditionExpression();
			if (predicateExpression instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) predicateExpression;
				Relation calledRelation = ClassUtil.nonNullState(relationInvocation.getReferredRelation());
				List<@NonNull RelationCallExp> relationInvocations = relation2invocations2.get(calledRelation);
				if (relationInvocations == null) {
					relationInvocations = new ArrayList<>();
					relation2invocations2.put(calledRelation, relationInvocations);
				}
				relationInvocations.add(relationInvocation);
				invocation2invokingRelation.put(relationInvocation, callingRelation);
			}
		}
	}

	protected void analyzeKey(@NonNull Key key) {
		CompleteClass identifies = getCompleteClass(QVTrelationUtil.getIdentifies(key));
		completeClass2key.put(identifies, key);
	}

	protected void analyzeRootVariables(@NonNull Relation relation) {
		List<@NonNull Variable> rootVariables = new ArrayList<>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(relation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				TemplateExp rRootTemplateExpression = rDomainPattern.getTemplateExpression();
				if (rRootTemplateExpression != null) {
					Variable rRootVariable = rRootTemplateExpression.getBindsTo();
					if (rRootVariable != null) {
						rootVariables.add(rRootVariable);
					}
				}
			}
		}
		relation2rootVariables.put(relation, rootVariables);
	}

	public @Nullable Property basicGetProperty(/*@NonNull*/ Type aClass, @NonNull NamedElement rNamedElement) throws CompilerChainException {
		/*@NonNull*/ String name = rNamedElement.getName();
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = getCompleteClass(aClass);
		return completeClass.getProperty(name);
	}

	public @NonNull CoreDomain createCoreDomain(@NonNull TypedModel typedModel) {
		CoreDomain coreDomain = QVTcoreFactory.eINSTANCE.createCoreDomain();
		coreDomain.setTypedModel(typedModel);
		coreDomain.setName(ClassUtil.nonNullState(typedModel.getName()));
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

	public @NonNull String createKeyFunctionName(@NonNull TypedModel rTypedModel, @NonNull Key rKey) {
		return nameGenerator.createKeyFunctionName(rTypedModel, rKey);
	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return nameGenerator.createKeyedVariableName(identifiedVariable);
	}

	/**
	 * Create the name Mapping for a cTransformation.
	 */
	/*public*/ @NonNull Mapping createMapping(@NonNull Relation relation, @NonNull String name) {
		RelationalTransformation rt = (RelationalTransformation) relation.getTransformation();
		assert rt != null;
		@NonNull Transformation cTransformation = getCoreTransformation(rt);
		Map<@NonNull String, @NonNull Mapping> name2mapping = transformation2name2mapping.get(cTransformation);
		if (name2mapping == null) {
			name2mapping = new HashMap<>();
			transformation2name2mapping.put(cTransformation, name2mapping);
		}
		String distinctName = name;
		Mapping coreMapping = name2mapping.get(name);
		int suffix = 0;
		while (coreMapping != null) {
			distinctName = name + ++suffix;
			coreMapping = name2mapping.get(distinctName);
		}
		coreMapping = helper.createMapping(distinctName);
		putGlobalTrace(coreMapping, relation);
		coreMapping.setTransformation(cTransformation);
		name2mapping.put(name, coreMapping);
		//		}
		return coreMapping;
	}


	public @NonNull RealizedVariable createRealizedVariable(@NonNull TypedElement typedElement) {
		return createRealizedVariable(ClassUtil.nonNullState(typedElement.getName()), ClassUtil.nonNullState(typedElement.getType()));
	}

	public @NonNull RealizedVariable createRealizedVariable(@NonNull String name, @NonNull Type type) {
		RealizedVariable realizedVariable = QVTcoreFactory.eINSTANCE.createRealizedVariable();
		realizedVariable.setName(name);
		realizedVariable.setType(type);
		realizedVariable.setIsRequired(true);
		return realizedVariable;
	}

	public @NonNull String createTraceClassName(@NonNull Relation relation) {
		return nameGenerator.createTraceClassName(relation);
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

	public void execute() throws CompilerChainException {
		transformToTracePackages();
		transformToCoreTransformations();
	}

	public void generateModels(@NonNull GenModel genModel) {
		((PivotMetamodelManager)environmentFactory.getMetamodelManager()).addGenModel(genModel);
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

		Generator generator = new Generator();
		generator.setInput(genModel);
		Monitor monitor = /*showProgress ? new LoggerMonitor(log) :*/ new BasicMonitor();
		diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);
		reportDiagnostics(new Issues(), diagnostic);
	}

	public @NonNull CompleteClass getCompleteClass(@NonNull Type type) {
		CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(type);
		return completeClass;
	}

	/*public*/ @NonNull Transformation getCoreTransformation(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nonNullState(rTransformation2cTransformation.get(rTransformation));
	}

	/*public*/ @NonNull TypedModel getCoreTypedModel(@NonNull TypedModel relationTypedModel) {
		return ClassUtil.nonNullState(relationalTypedModel2coreTypedModel.get(relationTypedModel));
	}

	/*	public @NonNull DomainPattern getDomainPattern(@NonNull Domain d) {
		List<@NonNull DomainPattern> pattern = ClassUtil.nullFree(((RelationDomain) d).getPattern());
		assert pattern.size() == 1;
		DomainPattern domainPattern = pattern.get(0);
		assert domainPattern != null;
		return domainPattern;
	} */

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	@Override
	public @NonNull QVTcoreHelper getHelper() {
		return helper;
	}

	/*public*/ @NonNull Relation getInvokingRelation(@NonNull RelationCallExp rInvocation) {
		Relation rRelation1 = ClassUtil.nonNullState(invocation2invokingRelation.get(rInvocation));
		Relation rRelation2 = (Relation) ((Predicate)rInvocation.eContainer()).getPattern().eContainer();
		assert rRelation1 == rRelation2;
		return rRelation1;
	}

	/**
	 * Return the Key for completeClass, returning null if none, or an explicit key if defined,
	 * or a synthesized key if singly/multiply inherited.
	 */
	public @Nullable Key getKeyForCompleteClass(@NonNull CompleteClass completeClass) {
		Key key = completeClass2key.get(completeClass);
		if ((key == null) && !completeClass2key.containsKey(completeClass)) {
			Set<@NonNull Property> parts = null;
			for (@NonNull CompleteClass superCompleteClass : completeClass.getProperSuperCompleteClasses()) {
				Key superKey = getKeyForCompleteClass(superCompleteClass);
				if (superKey != null) {
					if (parts == null) {
						parts = new HashSet<>();
					}
					for (@NonNull Property property : QVTrelationUtil.getOwnedParts(superKey)) {
						parts.add(property);
					}
					for (@NonNull Property property : QVTrelationUtil.getOwnedOppositeParts(superKey)) {
						parts.add(QVTrelationUtil.getOpposite(property));
					}
				}
			}
			if (parts != null) {
				key = new QVTrelationHelper(environmentFactory).createKey(completeClass.getPrimaryClass(), parts);
			}
			completeClass2key.put(completeClass, key);
		}
		return key;
	}

	public @Nullable Key getKeyForType(@NonNull Type type) {
		CompleteClass completeClass = getCompleteClass(type);
		return getKeyForCompleteClass(completeClass);
	}

	/*public*/ @NonNull Function getKeyFunction(@NonNull TypedModel rTypedModel, @NonNull Key rKey) throws CompilerChainException {
		Map<@NonNull TypedModel, @NonNull Function> typedModel2function = key2typedModel2function.get(rKey);
		if (typedModel2function == null) {
			typedModel2function = new HashMap<>();
			key2typedModel2function.put(rKey, typedModel2function);
		}
		Function cKeyFunction = typedModel2function.get(rTypedModel);
		if (cKeyFunction == null) {
			Iterable<org.eclipse.ocl.pivot.@NonNull Class> usedClasses = QVTrelationUtil.getUsedClasses(rTypedModel);
			org.eclipse.ocl.pivot.@NonNull Class identifiedClass = QVTrelationUtil.getIdentifies(rKey);
			assert (Iterables.contains(usedClasses, identifiedClass));
			QVTr2QVTc.SYNTHESIS.println("key " + rKey);
			KeyToFunctionForIdentification keyToMapping = new KeyToFunctionForIdentification(this, rTypedModel, rKey);
			cKeyFunction = keyToMapping.transform();
			getCoreTransformation(QVTrelationUtil.getContainingTransformation(rTypedModel)).getOwnedOperations().add(cKeyFunction);
			//			}
			typedModel2function.put(rTypedModel, cKeyFunction);
			//		putTrace(traceClass, r);
		}
		return cKeyFunction;
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

	public Predicate getPredicateForRelationCallExp(RelationCallExp ri) {
		// TODO Auto-generated method stub
		return null;
	}

	public @NonNull String getProjectName(@NonNull URI traceURI) {
		URI trimFileExtension = traceURI.trimFileExtension();
		if (trimFileExtension.isPlatform()) {
			return trimFileExtension.segment(1);
		}
		else {
			return trimFileExtension.segment(0);
		}
	}

	/**
	 * Return the property of aClass whose name corresponds to rNamedElement.
	 * @throws CompilerChainException if no such property
	 */
	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, @NonNull NamedElement rNamedElement) throws CompilerChainException {
		Property property = getProperty(aClass, rNamedElement.getName());
		if (rNamedElement instanceof Property) {
			assert rNamedElement == property;
		}
		return property;
	}
	protected @NonNull Property getProperty(/*@NonNull*/ Type aClass, /*@NonNull*/ String name) throws CompilerChainException {
		assert (aClass != null) && (name != null);
		CompleteClass completeClass = getCompleteClass(aClass);
		Property p = completeClass.getProperty(name);
		if (p != null)
			return p;
		throw new CompilerChainException("No property '" + name + "' in '" + aClass + "::" + "'");
	}

	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcResource;
	}

	public @NonNull List<@NonNull Variable> getRootVariables(@NonNull Relation relation) {
		return ClassUtil.nonNullState(relation2rootVariables.get(relation));
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	public @Nullable List<@NonNull Element> getGlobalTargets(@NonNull Element element) {
		return globalSource2targets.get(element);
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation relation) {
		return ClassUtil.nonNullState(relation2traceClass.get(relation));
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull RelationCallExp invocation) {
		return ClassUtil.nonNullState(invocation2traceClass.get(invocation));
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Package getTracePackage(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nonNullState(rTransformation2tracePackage.get(rTransformation));
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getWhenRelationCallExpsForRelation(@NonNull Relation relation) {
		return relation2whenInvocations.get(relation);
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getWhereRelationCallExpsForRelation(@NonNull Relation relation) {
		return relation2whereInvocations.get(relation);
	}

	protected void mapQueries(@NonNull RelationalTransformation rTransformation, @NonNull Transformation cTransformation) {
		List<@NonNull Operation> cOperations = new ArrayList<>();
		for (@NonNull Operation rOperation : QVTbaseUtil.getOwnedOperations(rTransformation)) {
			Element cOperation = rOperation.accept(createVisitor);
			if (cOperation instanceof Operation) {
				cOperations.add((Operation) cOperation);
				putGlobalTrace(cOperation, rOperation);
			}
		}
		cTransformation.getOwnedOperations().addAll(cOperations);
		for (@NonNull Operation cOperation : cOperations) {
			cOperation.accept(updateVisitor);
		}
	}

	/**
	 * Transform the contents of a single rTransformation to populate the already created cTransformation.
	 */
	protected void mapTransformation(@NonNull RelationalTransformation rTransformation, @NonNull Transformation cTransformation) throws CompilerChainException {
		List<@NonNull Relation> rRelations = Lists.newArrayList(QVTrelationUtil.getOwnedRelations(rTransformation));
		Collections.sort(rRelations, NameUtil.NAMEABLE_COMPARATOR);
		Variable cThis = QVTbaseUtil.getContextVariable(standardLibrary, cTransformation);
		Variable rThis = QVTbaseUtil.getContextVariable(standardLibrary, rTransformation);
		//			putGlobalTrace(cThis, rThis);
		addTrace(rThis, cThis);
		UniqueArrayList<@NonNull TypedModel> rEnforceableTypedModels = new UniqueArrayList<>();
		for (@NonNull Relation rRelation : rRelations) {
			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
				if (rDomain.isIsEnforceable()) {
					rEnforceableTypedModels.add(QVTrelationUtil.getTypedModel(rDomain));
				}
			}
		}
		mapQueries(rTransformation, cTransformation);
		for (@NonNull Relation rRelation : rRelations) {
			if (rRelation.isIsTopLevel()) {
				QVTr2QVTc.SYNTHESIS.println("topLevel " + rRelation);
				TopLevelRelationToMappingForEnforcement topLevelRelationToMappingForEnforcement = new TopLevelRelationToMappingForEnforcement(this, rRelation);
				topLevelRelationToMappingForEnforcement.transform();
			}
		}
		for (@NonNull Relation rRelation : rRelations) {
			if (!rRelation.isIsTopLevel()) {
				Iterable<@NonNull RelationCallExp> whenInvocations = relation2whenInvocations.get(rRelation);
				Iterable<@NonNull RelationCallExp> whereInvocations = relation2whereInvocations.get(rRelation);
				InvokedRelationToMappingForEnforcement invokedRelationToMappingForEnforcement = new InvokedRelationToMappingForEnforcement(this, rRelation, whenInvocations, whereInvocations);
				invokedRelationToMappingForEnforcement.transform();
			}
		}
		CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedOperationsList(cTransformation));
		CompilerUtil.normalizeNameables(QVTbaseUtil.getRule(cTransformation));
	}

	// Create the top rules, and search the input model for the appropriate types, when possible?
	public void prepare() {
		try {
			qvtrResource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// EXIT!
		} finally {
			//			if (qvtrModel.isLoaded()) {
			//RuleFactory factory = new RuleFactory();
			//rules = factory.createTopRules(this);
			//				ruleFactories = new Rule.Factory[] {
			//						RelationalTransformationToMappingTransformation.FACTORY,
			//						RelationToTraceClass.FACTORY
			//				};
			//			}
		}
	}

	/*public*/ void putCoreTransformation(@NonNull RelationalTransformation relationTransformation, @NonNull Transformation cTransformation) {
		rTransformation2cTransformation.put(relationTransformation, cTransformation);
		putGlobalTrace(cTransformation, relationTransformation);
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

	/*public*/ void putInvocationTrace(@NonNull RelationCallExp rInvocation, org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		org.eclipse.ocl.pivot.Class oldTraceClass = invocation2traceClass.put(rInvocation, traceClass);
		assert oldTraceClass == null;
		//		putTrace(traceClass, r);
	}

	/*public*/ void putRelationTrace(@NonNull Relation rRelation, org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		org.eclipse.ocl.pivot.Class oldTraceClass = relation2traceClass.put(rRelation, traceClass);
		assert oldTraceClass == null;
		//		putTrace(traceClass, r);
	}

	/*public*/ void putTracePackage(@NonNull RelationalTransformation rt, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {
		org.eclipse.ocl.pivot.Package oldTracePackage = rTransformation2tracePackage.put(rt, tracePackage);
		assert oldTracePackage == null;
		//		putTrace(tracePackage, rt);
	}

	public void putTypedModel(@NonNull TypedModel relationTypedModel, @NonNull TypedModel coreTypedModel) {
		TypedModel oldTypedModel = relationalTypedModel2coreTypedModel.put(relationTypedModel, coreTypedModel);
		assert oldTypedModel == null;
	}

	protected void reportDiagnostics(Issues issues, Diagnostic diagnostic) {
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
						issues.addError(this, message, null, null, throwable, data);
					}
					else if (severity == Diagnostic.WARNING) {
						issues.addWarning(this, message, null, null, throwable, data);
					}
				}
			}
			else {
				if (severity == Diagnostic.ERROR) {
					issues.addError(this, diagnostic.toString());
				}
				else if (severity == Diagnostic.WARNING) {
					issues.addWarning(this, diagnostic.toString());
				}
			}
		}
	}

	public void saveCore(@NonNull Resource asResource, @NonNull Map<?, ?> options) throws IOException {
		asResource.getContents().add(this.coreModel);
		// Copy imports

		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : txTracePackages) {
			Import asImport = helper.createImport(null, asPackage);
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

	public @NonNull GenModel saveGenModel(@NonNull Resource asResource, @NonNull URI traceURI, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> genModelOptions, @NonNull Map<Object, Object> saveOptions2, @Nullable Collection<@NonNull ? extends GenPackage> usedGenPackages) throws IOException {
		URI trimFileExtension = traceURI.trimFileExtension();
		String projectName = getProjectName(traceURI);
		Resource genmodelResource = environmentFactory.getResourceSet().createResource(genModelURI);
		@SuppressWarnings("null")@NonNull GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.getForeignModel().add(traceURI.lastSegment());
		String copyrightText = genModelOptions != null ? genModelOptions.get(CompilerChain.GENMODEL_COPYRIGHT_TEXT) : null;
		if (copyrightText != null) {
			genModel.setCopyrightText(copyrightText);
		}
		if (usedGenPackages != null) {
			genModel.getUsedGenPackages().addAll(usedGenPackages);
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
				for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asModel.getOwnedPackages())) {
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
				for (@NonNull Import asImport : ClassUtil.nullFree(asModel.getOwnedImports())) {
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
						if (usedGenPackages != null) {
							for (@NonNull GenPackage usedGenPackage : usedGenPackages) {
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
				transformToCoreTransformationHierarchy(ClassUtil.nullFree(coreModel.getOwnedPackages()), ClassUtil.nullFree(relationModel.getOwnedPackages()));
			}
		}
		List<@NonNull RelationalTransformation> rTransformations = new ArrayList<>(rTransformation2cTransformation.keySet());
		Collections.sort(rTransformations, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull RelationalTransformation rTransformation : rTransformations) {
			Transformation cTransformation = getCoreTransformation(rTransformation);
			pushScope(cTransformation);
			mapTransformation(rTransformation, cTransformation);
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
			org.eclipse.ocl.pivot.@NonNull Package corePackage = helper.createPackage(name, relationPackage.getNsPrefix(), relationPackage.getURI());
			corePackages.add(corePackage);
			//
			//	Transform the transformations to establish callable names.
			//
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : ClassUtil.nullFree(relationPackage.getOwnedClasses())) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToMappingTransformation rTransformationToMappingTransformation = new RelationalTransformationToMappingTransformation(this);
					Transformation cTransformation = rTransformationToMappingTransformation.doRelationalTransformationToMappingTransformation((RelationalTransformation)relationClass);
					corePackage.getOwnedClasses().add(cTransformation);
					//					CompilerUtil.normalizeNameables(ClassUtil.nullFree(cTransformation.getRule()));
				}
			}
			CompilerUtil.normalizeNameables(ClassUtil.nullFree(corePackage.getOwnedClasses()));
			//
			//	Recurse to establish callable names in nested packages.
			//
			transformToCoreTransformationHierarchy(ClassUtil.nullFree(corePackage.getOwnedPackages()), ClassUtil.nullFree(relationPackage.getOwnedPackages()));
		}
	}

	public void transformToTracePackages() throws CompilerChainException {
		List<org.eclipse.ocl.pivot.@NonNull Package> rootTracePackages = null;
		for (@NonNull EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages = transformToTracePackageHierarchy(ClassUtil.nullFree(((RelationModel)eObject).getOwnedPackages()));
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
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : ClassUtil.nullFree(relationPackage.getOwnedClasses())) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToTracePackage rTransformationToTracePackage = new RelationalTransformationToTracePackage(this, (RelationalTransformation)relationClass);
					org.eclipse.ocl.pivot.Package nestedTracePackage = rTransformationToTracePackage.transform();
					txTracePackages.add(nestedTracePackage);
					if (nestedTracePackages == null) {
						nestedTracePackages = new ArrayList<>();
					}
					nestedTracePackages.add(nestedTracePackage);
				}
			}
			List<org.eclipse.ocl.pivot.@NonNull Package> nestedTracePackages2 = transformToTracePackageHierarchy(ClassUtil.nullFree(relationPackage.getOwnedPackages()));
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

	/**
	 * Lazily create the name Property for a traceClass with a type. If manyTraces is set there may be many trace class instances referencing the same object through
	 * the trace property and so the implicit opposite must be a Bag.
	 */
	/*public*/ @NonNull Property whenTraceProperty(@Nullable Domain rDomain, org.eclipse.ocl.pivot.@NonNull Class traceClass, @NonNull String name, @NonNull Type type, boolean isRequired, boolean manyTraces) {
		Map<@NonNull String, @NonNull Property> name2traceProperty = traceClass2name2traceProperty.get(traceClass);
		if (name2traceProperty == null) {
			name2traceProperty = new HashMap<>();
			traceClass2name2traceProperty.put(traceClass, name2traceProperty);
		}
		Property traceProperty = name2traceProperty.get(name);
		if (traceProperty == null) {
			traceProperty = PivotFactory.eINSTANCE.createProperty();
			traceProperty.setName(name);
			traceProperty.setType(type);
			traceProperty.setIsRequired(isRequired);
			if (rDomain != null) {
				Annotation domainAnnotation = PivotFactory.eINSTANCE.createAnnotation();
				domainAnnotation.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE);
				Detail domainDetail = PivotFactory.eINSTANCE.createDetail();
				domainDetail.setName(DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN);
				domainDetail.getValues().add(rDomain.getName());
				domainAnnotation.getOwnedDetails().add(domainDetail);
				traceProperty.getOwnedAnnotations().add(domainAnnotation);
			}
			name2traceProperty.put(name, traceProperty);
			traceProperty.setOwningClass(traceClass);
			if (!(type instanceof DataType)) {
				Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
				oppositeProperty.setName(traceClass.getName());		// FIXME unique, mutable Class
				oppositeProperty.setType(manyTraces ? environmentFactory.getCompleteEnvironment().getBagType(traceClass, true, null, null) : traceClass);
				oppositeProperty.setIsRequired(manyTraces);
				//				oppositeProperty.setType(traceClass);
				//				oppositeProperty.setIsRequired(false);
				oppositeProperty.setIsImplicit(true);
				oppositeProperty.setOwningClass((org.eclipse.ocl.pivot.@NonNull Class)type);
				traceProperty.setOpposite(oppositeProperty);
				oppositeProperty.setOpposite(traceProperty);
				//				putTrace(oppositeProperty, type);
			}
			//			putTrace(traceProperty, traceClass);
		}
		else {
			assert traceProperty.getType() == type;
		}
		return traceProperty;
	}
}
