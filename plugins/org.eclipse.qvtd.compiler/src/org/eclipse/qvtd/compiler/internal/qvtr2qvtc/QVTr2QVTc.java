/*******************************************************************************
 * Copyright (c) 2014, 2017 The University of York and Willink Transformations.
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
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
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
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
	//	private final @NonNull Map<@NonNull RelationCallExp, @NonNull List<org.eclipse.ocl.pivot.@NonNull Class>> invocation2traceClasses = new HashMap<>();

	/**
	 * Map from each relation to all the expressions that call the relation from a when clause.
	 */
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2incomingWhenInvocations = new HashMap<>();
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2outgoingWhenInvocations = new HashMap<>();

	/**
	 * Map from each relation to all the expressions that call the relation from a where clause.
	 */
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2incomingWhereInvocations = new HashMap<>();
	private final @NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2outgoingWhereInvocations = new HashMap<>();

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

	private @Nullable RelationalTransformation2TracePackage relationalTransformation2TracePackage = null;

	/**
	 * The core TypedModel for each Relational TypedModel.
	 */
	private @NonNull Map<@NonNull TypedModel, @NonNull TypedModel> relationalTypedModel2coreTypedModel = new HashMap<>();

	/**
	 * The lazily created named Core mappings for each transformation.
	 */
	private @NonNull Map<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>> transformation2name2mapping = new HashMap<>();

	/**
	 * The root variables (in relation call order) of each relation.
	 */
	private @NonNull Map<@NonNull Relation, @NonNull List<@NonNull Variable>> relation2rootVariables = new HashMap<>();

	/**
	 * Closure of all overriding relations for each relation, or null if not overridden.
	 */
	private @NonNull Map<@NonNull Relation, @Nullable Set<@NonNull Relation>> relation2overridingRelations = new HashMap<>();

	/**
	 * The per-relation conversions.
	 */
	private @NonNull Map<@NonNull Relation, @NonNull Relation2Mappings> relation2relation2mapping = new HashMap<>();

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
				for (Relation anOverriddenRelation = relation; anOverriddenRelation != null; anOverriddenRelation = QVTrelationUtil.basicGetOverridden(anOverriddenRelation)) {
					if ((anOverriddenRelation != relation) && !addOverridingRelation(anOverriddenRelation, relation)) {
						break;
					}
				}
			}
			if (eo instanceof Import) {
				this.coreModel.getOwnedImports().add((Import) EcoreUtil.copy(eo));
			}
		}
	}

	private boolean addOverridingRelation(@NonNull Relation overriddenRelation, @NonNull Relation overridingRelation) {
		assert overridingRelation != overriddenRelation;
		Set<@NonNull Relation> overridingRelations = relation2overridingRelations.get(overriddenRelation);
		if (overridingRelations == null) {
			overridingRelations = new HashSet<>();
			relation2overridingRelations.put(overriddenRelation, overridingRelations);
		}
		return overridingRelations.add(overridingRelation);
	}

	protected void analyzeInvocations(@NonNull Relation callingRelation) {
		Pattern whenPattern = callingRelation.getWhen();
		if (whenPattern != null) {
			analyzeInvocations(callingRelation, whenPattern, relation2incomingWhenInvocations, relation2outgoingWhenInvocations);
		}
		Pattern wherePattern = callingRelation.getWhere();
		if (wherePattern != null) {
			analyzeInvocations(callingRelation, wherePattern, relation2incomingWhereInvocations, relation2outgoingWhereInvocations);
		}
	}

	protected void analyzeInvocations(@NonNull Relation callingRelation, @NonNull Pattern pattern,
			@NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2incomingInvocations,
			@NonNull Map<@NonNull Relation, @Nullable List<@NonNull RelationCallExp>> relation2outgoingInvocations) {
		for (@NonNull Predicate predicate : QVTrelationUtil.getOwnedPredicates(pattern)) {
			OCLExpression predicateExpression = predicate.getConditionExpression();
			if (predicateExpression instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) predicateExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(relationInvocation);
				List<@NonNull RelationCallExp> incomingInvocations = relation2incomingInvocations.get(invokedRelation);
				if (incomingInvocations == null) {
					incomingInvocations = new ArrayList<>();
					relation2incomingInvocations.put(invokedRelation, incomingInvocations);
				}
				incomingInvocations.add(relationInvocation);
				Relation invokingRelation = QVTrelationUtil.getContainingRelation(relationInvocation);
				List<@NonNull RelationCallExp> outgoingInvocations = relation2outgoingInvocations.get(invokingRelation);
				if (outgoingInvocations == null) {
					outgoingInvocations = new ArrayList<>();
					relation2outgoingInvocations.put(invokingRelation, outgoingInvocations);
				}
				outgoingInvocations.add(relationInvocation);
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
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rRootTemplateExpression = rDomainPattern.getTemplateExpression();
				if (rRootTemplateExpression != null) {
					rootVariables.add(QVTrelationUtil.getBindsTo(rRootTemplateExpression));
				}
			}
		}
		relation2rootVariables.put(relation, rootVariables);
	}

	public org.eclipse.ocl.pivot.@Nullable Class basicGetSignatureClass(@NonNull Relation rRelation) {
		return getRelationalTransformation2TracePackage().basicGetSignatureClass(rRelation);
	}

	public @Nullable Property basicGetTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) throws CompilerChainException {
		Property traceProperty = getRelationalTransformation2TracePackage().basicGetTraceProperty(aClass, rVariable);
		if (traceProperty != null) {
			return traceProperty;
		}
		String name = QVTrelationUtil.getName(rVariable);
		CompleteClass completeClass = getCompleteClass(aClass);
		return completeClass.getProperty(name);
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
		RelationalTransformation rt = QVTrelationUtil.getTransformation(relation);
		@NonNull Transformation cTransformation = getCoreTransformation(rt);
		Map<@NonNull String, @NonNull Mapping> name2mapping = transformation2name2mapping.get(cTransformation);
		if (name2mapping == null) {
			name2mapping = new HashMap<>();
			transformation2name2mapping.put(cTransformation, name2mapping);
		}
		Mapping coreMapping = name2mapping.get(name);
		assert (coreMapping == null);
		coreMapping = helper.createMapping(name);
		putGlobalTrace(coreMapping, relation);
		coreMapping.setIsAbstract(relation.isIsAbstract());
		coreMapping.setTransformation(cTransformation);
		name2mapping.put(name, coreMapping);
		return coreMapping;
	}

	public @NonNull RealizedVariable createRealizedVariable(@NonNull TypedElement typedElement) {
		return createRealizedVariable(QVTrelationUtil.getName(typedElement), QVTrelationUtil.getType(typedElement));
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

	/*	public void execute() throws CompilerChainException {
		prepare();
		transformToTracePackages();
		transformToCoreTransformations();
	} */

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

	public @Nullable List<@NonNull Element> getGlobalTargets(@NonNull Element element) {
		return globalSource2targets.get(element);
	}

	@Override
	public @NonNull QVTcoreHelper getHelper() {
		return helper;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhenInvocationsOf(@NonNull Relation relation) {
		return relation2incomingWhenInvocations.get(relation);
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhereInvocationsOf(@NonNull Relation relation) {
		return relation2incomingWhereInvocations.get(relation);
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

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingWhenInvocationsOf(@NonNull Relation relation) {
		return relation2outgoingWhenInvocations.get(relation);
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingWhereInvocationsOf(@NonNull Relation relation) {
		return relation2outgoingWhereInvocations.get(relation);
	}

	public @NonNull Iterable<@NonNull Relation> getOverridingRelations(@NonNull Relation overriddenRelation) {
		Set<@NonNull Relation> overridingRelations = relation2overridingRelations.get(overriddenRelation);
		return overridingRelations != null ? overridingRelations : Collections.emptyList();
	}

	public Predicate getPredicateForRelationCallExp(RelationCallExp ri) {
		// TODO Auto-generated method stub
		return null;
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

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return ClassUtil.nonNullState(relationalTransformation2TracePackage);
	}

	public @NonNull List<@NonNull Variable> getRootVariables(@NonNull Relation relation) {
		return ClassUtil.nonNullState(relation2rootVariables.get(relation));
	}

	public org.eclipse.ocl.pivot.@NonNull Class getSignatureClass(@NonNull Relation rRelation) {
		return getRelationalTransformation2TracePackage().getSignatureClass(rRelation);
	}

	//	public @NonNull Property getSignatureProperty(@NonNull RelationCallExp rInvocation) {
	//		return getRelationalTransformation2TracePackage().getSignatureProperty(rInvocation);
	//	}

	/**
	 * Return the trace property that corresponds to rVariable in aClass.
	 */
	protected @NonNull Property getSignatureProperty(org.eclipse.ocl.pivot.@NonNull Class aClass, @NonNull VariableDeclaration rVariable) {
		return getRelationalTransformation2TracePackage().getSignatureProperty(aClass, rVariable);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return standardLibrary;
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation rRelation) {
		return getRelationalTransformation2TracePackage().getTraceClass(rRelation);
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Package getTracePackage(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nonNullState(rTransformation2tracePackage.get(rTransformation));
	}

	/**
	 * Return the trace property of aClass whose name corresponds to rNamedElement.
	 * @throws CompilerChainException if no such property
	 */
	protected @NonNull Property getTraceProperty(@NonNull Type aClass, @NonNull VariableDeclaration rVariable) throws CompilerChainException {
		Property property = getRelationalTransformation2TracePackage().basicGetTraceProperty(aClass, rVariable);
		if (property != null) {
			return property;
		}
		property = getProperty(aClass, rVariable.getName());		// FIXME above should be non-null to ensure uniquely named property is in use
		if (rVariable instanceof Property) {
			assert rVariable == property;
		}
		return property;
	}

	public @NonNull Property getTraceProperty(@NonNull RelationCallExp rInvocation) {
		return getRelationalTransformation2TracePackage().getTraceProperty(rInvocation);
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
		Collections.sort(rRelations, new RelationComparator());
		Variable cThis = QVTbaseUtil.getContextVariable(standardLibrary, cTransformation);
		Variable rThis = QVTbaseUtil.getContextVariable(standardLibrary, rTransformation);
		//			putGlobalTrace(cThis, rThis);
		addTrace(rThis, cThis);
		//		UniqueArrayList<@NonNull TypedModel> rEnforceableTypedModels = new UniqueArrayList<>();		// FIXME not used
		//		for (@NonNull Relation rRelation : rRelations) {
		//			for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
		//				if (rDomain.isIsEnforceable()) {
		//					rEnforceableTypedModels.add(QVTrelationUtil.getTypedModel(rDomain));
		//				}
		//			}
		//		}
		mapQueries(rTransformation, cTransformation);
		for (@NonNull Relation rRelation : rRelations) {
			Relation2Mappings relation2mappings;
			if (rRelation.isIsAbstract()) {
				QVTr2QVTc.SYNTHESIS.println("abstract " + rRelation);
				relation2mappings = new Relation2AbstractMappings(this, rRelation);
			}
			else if (rRelation.isIsTopLevel()) {
				QVTr2QVTc.SYNTHESIS.println("topLevel " + rRelation);
				relation2mappings = new TopLevelRelationToMappingForEnforcement(this, rRelation);
			}
			else {
				relation2mappings = new InvokedRelationToMappingForEnforcement(this, rRelation);
			}
			relation2mappings.analyze();
			relation2relation2mapping.put(rRelation, relation2mappings);
		}
		for (@NonNull Relation rRelation : rRelations) {
			Relation2Mappings relation2mapping = relation2relation2mapping.get(rRelation);
			assert relation2mapping != null;
			relation2mapping.synthesize();
		}
		CompilerUtil.normalizeNameables(QVTbaseUtil.Internal.getOwnedOperationsList(cTransformation));
		CompilerUtil.normalizeNameables(QVTbaseUtil.getRule(cTransformation));
	}

	public void addRelation2Mappings(@NonNull Relation2Mappings relation2mappings) {
		Relation rRelation = relation2mappings.getRelation();
		relation2relation2mapping.put(rRelation, relation2mappings);
	}

	public @NonNull Relation2Mappings getRelation2Mappings(@NonNull Relation rRelation) {
		return ClassUtil.nonNullState(relation2relation2mapping.get(rRelation));
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

	/*	public void putInvocationTrace(@NonNull RelationCallExp rInvocation, org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		List<org.eclipse.ocl.pivot.@NonNull Class> traceClasses = invocation2traceClasses.get(rInvocation);
		if (traceClasses == null) {
			traceClasses = new ArrayList<>();
			invocation2traceClasses.put(rInvocation, traceClasses);
		}
		assert !traceClasses.contains(traceClass);
		traceClasses.add(traceClass);
		//		putTrace(traceClass, r);
	} */

	public void putRelationTrace(@NonNull Relation rRelation, org.eclipse.ocl.pivot.@NonNull Class traceClass) {
		org.eclipse.ocl.pivot.Class oldTraceClass = relation2traceClass.put(rRelation, traceClass);
		assert oldTraceClass == null;
		//		putTrace(traceClass, r);
	}

	public void putTracePackage(@NonNull RelationalTransformation rt, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {
		org.eclipse.ocl.pivot.Package oldTracePackage = rTransformation2tracePackage.put(rt, tracePackage);
		assert oldTracePackage == null;
		//		putTrace(tracePackage, rt);
	}

	public void putTypedModel(@NonNull TypedModel relationTypedModel, @NonNull TypedModel coreTypedModel) {
		TypedModel oldTypedModel = relationalTypedModel2coreTypedModel.put(relationTypedModel, coreTypedModel);
		assert oldTypedModel == null;
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
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : QVTrelationUtil.getOwnedClasses(relationPackage)) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToMappingTransformation rTransformationToMappingTransformation = new RelationalTransformationToMappingTransformation(this);
					Transformation cTransformation = rTransformationToMappingTransformation.doRelationalTransformationToMappingTransformation((RelationalTransformation)relationClass);
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
					relationalTransformation2TracePackage = new RelationalTransformation2TracePackage(this, (RelationalTransformation)relationClass);
					org.eclipse.ocl.pivot.Package nestedTracePackage = relationalTransformation2TracePackage.transform();
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
}
