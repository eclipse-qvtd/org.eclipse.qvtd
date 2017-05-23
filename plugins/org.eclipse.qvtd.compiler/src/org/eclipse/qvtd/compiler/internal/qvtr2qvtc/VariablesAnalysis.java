/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * VariablesAnalysis manages all the variables in use by a Relation and its corresponding Mapping.
 */
/*public*/ class VariablesAnalysis extends QVTcoreHelper
{
	//	public static void gatherBoundVariables(@NonNull Map<@NonNull Variable, @Nullable TemplateExp> boundVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {
	//		for (Element asRoot : asRoots) {
	//			gatherBoundVariables(boundVariables, asRoot);
	//		}
	//	}
	/**
	 * Return a Map from each bound variable to the TemplateExp for which it is the TempateExp.getBindsTo().
	 */
	public static @NonNull Map<@NonNull Variable, @NonNull TemplateExp> gatherBoundVariables(@NonNull Element asRoot) {
		Map<@NonNull Variable, @NonNull TemplateExp> boundVariables = new HashMap<>();
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof TemplateExp) {
				Variable bindsTo = QVTrelationUtil.getBindsTo((TemplateExp)eObject);
				TemplateExp oldTemplateExp = boundVariables.put(bindsTo, (TemplateExp)eObject);
				assert oldTemplateExp == null;
			}
		}
		return boundVariables;
	}

	/**
	 * Return a Map from each member variable to the CollectionTemplateExp's for which it is a CollectionTempateExp.member.referredVariable.
	 */
	public static @Nullable Map<@NonNull Variable, @NonNull List<@NonNull CollectionTemplateExp>> gatherMemberVariables(@NonNull Element asRoot) {
		Map<@NonNull Variable, @NonNull List<@NonNull CollectionTemplateExp>> memberVariable2collectionTemplateExps = null;
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof CollectionTemplateExp) {
				CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)eObject;
				for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
					if (member instanceof VariableExp) {
						Variable memberVariable = QVTrelationUtil.getReferredVariable((VariableExp)member);
						if (memberVariable2collectionTemplateExps == null) {
							memberVariable2collectionTemplateExps = new HashMap<>();
						}
						List<@NonNull CollectionTemplateExp> collectionTemplateExps = memberVariable2collectionTemplateExps.get(memberVariable);
						if (collectionTemplateExps == null) {
							collectionTemplateExps = new ArrayList<>();
							memberVariable2collectionTemplateExps.put(memberVariable, collectionTemplateExps);
						}
						if (!collectionTemplateExps.contains(collectionTemplateExp)) {
							collectionTemplateExps.add(collectionTemplateExp);
						}
					}
				}
			}
		}
		return memberVariable2collectionTemplateExps;
	}

	/**
	 * Return all variables referenced within the composition tree of each of asRoots.
	 */
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {
		for (@NonNull Element asRoot : asRoots) {
			gatherReferredVariables(referredVariables, asRoot);
		}
	}
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Element asRoot) {
		for (@NonNull EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable instanceof Variable) {
					referredVariables.add((Variable)referredVariable);
				}
			}
			else if (eObject instanceof Variable) {
				referredVariables.add((Variable)eObject);
			}
			else if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();
				if (bindsTo != null) {
					referredVariables.add(bindsTo);
				}
				if (eObject instanceof CollectionTemplateExp) {				// Member variable are contained VariableExp's
					Variable rest = ((CollectionTemplateExp)eObject).getRest();
					if ((rest != null) && !rest.isIsImplicit()) {
						referredVariables.add(rest);
					}
				}
			}
		}
	}
	public static void gatherReferredVariablesWithTypedModels(@NonNull Map<@NonNull Variable, @Nullable TypedModel> referredVariable2typedModel, @NonNull Element asRoot) {
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable instanceof Variable) {
					EObject eContainer = eObject.eContainer();
					if (eContainer instanceof RelationCallExp) {
						RelationCallExp relationCallExp = (RelationCallExp)eContainer;
						int argument = relationCallExp.getArgument().indexOf(eObject);
						assert argument >= 0;
						Relation referredRelation = ClassUtil.nonNullState(relationCallExp.getReferredRelation());
						List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(referredRelation);
						assert argument < rootVariables.size();
						Variable rootVariable = rootVariables.get(argument);
						RelationDomain relationDomain = QVTrelationUtil.getRootVariableDomain(rootVariable);
						gatherReferredVariablesWithTypedModelsAdd(referredVariable2typedModel, (Variable)referredVariable, relationDomain.getTypedModel());
					}
					else {
						gatherReferredVariablesWithTypedModelsAdd(referredVariable2typedModel, (Variable)referredVariable, null);
					}
				}
			}
			else if (eObject instanceof Variable) {
				gatherReferredVariablesWithTypedModelsAdd(referredVariable2typedModel, (Variable)eObject, null);
			}
			else if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();
				if (bindsTo != null) {
					gatherReferredVariablesWithTypedModelsAdd(referredVariable2typedModel, bindsTo, null);
				}
				if (eObject instanceof CollectionTemplateExp) {
					Variable rest = ((CollectionTemplateExp)eObject).getRest();
					if ((rest != null) && !rest.isIsImplicit()) {
						gatherReferredVariablesWithTypedModelsAdd(referredVariable2typedModel, rest, null);
					}
				}
			}
		}
	}
	private static void gatherReferredVariablesWithTypedModelsAdd(@NonNull Map<@NonNull Variable, @Nullable TypedModel> referredVariable2typedModel,
			@NonNull Variable variable, @Nullable TypedModel rTypedModel) {
		if (rTypedModel != null) {
			TypedModel oldTypedModel = referredVariable2typedModel.put(variable, rTypedModel);
			assert (oldTypedModel == rTypedModel) || (oldTypedModel == null);
		}
		else if (!referredVariable2typedModel.containsKey(variable)) {
			referredVariable2typedModel.put(variable, null);
		}
	}

	/**
	 * Return a Map from each rest variable to the CollectionTemplateExp for which it is a CollectionTempateExp.rest.
	 */
	public static @Nullable Map<@NonNull Variable, @NonNull CollectionTemplateExp> gatherRestVariables(@NonNull Element asRoot) {
		Map<@NonNull Variable, @NonNull CollectionTemplateExp> restVariable2collectionTemplateExp = null;
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof CollectionTemplateExp) {
				CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)eObject;
				Variable rest = collectionTemplateExp.getRest();
				if (rest != null) {
					if (restVariable2collectionTemplateExp == null) {
						restVariable2collectionTemplateExp = new HashMap<>();
					}
					CollectionTemplateExp oldCollectionTemplateExp = restVariable2collectionTemplateExp.put(rest, collectionTemplateExp);
					assert oldCollectionTemplateExp == null;
				}
			}
		}
		return restVariable2collectionTemplateExp;
	}

	// TODO bug 453863 // ?? this is suspect for more than 2 domains. // FIXME What is 'shared'? a) any two domains b) output/any-input c) all domains
	/**
	 * Return the variables that are used by more than one domain of the relation and so must be middle variables.
	 */
	public static @NonNull Set<@NonNull Variable> getMiddleDomainVariables(@NonNull Relation rRelation) {
		Set<@NonNull Variable> rSomeDomainVariables = new HashSet<>();
		Set<@NonNull Variable> rMiddleDomainVariables = new HashSet<>();
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(rRelation)) {
			Set<@NonNull Variable> rThisDomainVariables = new HashSet<>();
			VariablesAnalysis.gatherReferredVariables(rThisDomainVariables, rDomain);
			for (@NonNull Variable rVariable : rThisDomainVariables) {
				if (!rSomeDomainVariables.add(rVariable)) {
					rMiddleDomainVariables.add(rVariable);				// Accumulate second (and higher) usages
				}
			}
		}
		return rMiddleDomainVariables;
	}

	public static class WhenedVariablesAnalysis extends VariablesAnalysis
	{
		public WhenedVariablesAnalysis(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationDomain rEnforcedDomain,
				@NonNull CoreDomain cEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			super(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		public boolean isWhened() {
			return true;
		}
	}

	public static class WheredVariablesAnalysis extends VariablesAnalysis
	{
		public WheredVariablesAnalysis(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationDomain rEnforcedDomain,
				@NonNull CoreDomain cEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
			super(qvtr2qvtc, rEnforcedDomain, cEnforcedDomain, traceClass);
		}

		@Override
		public boolean isWhered() {
			return true;
		}
	}

	protected final @NonNull QVTr2QVTc qvtr2qvtc;
	protected final @NonNull CoreDomain cEnforcedDomain;
	protected final @NonNull Mapping cMapping;
	protected final @NonNull Transformation cTransformation;
	protected final @NonNull BottomPattern cMiddleBottomPattern;
	protected final @NonNull GuardPattern cMiddleGuardPattern;
	protected final @NonNull RealizedVariable cMiddleRealizedVariable;		// tcv: The trace class variable (the middle variable identifying the middle object)
	protected final @NonNull Variable rThisVariable;
	protected final @NonNull Variable cThisVariable;

	/**
	 * Map from the each core variable name in use to an originating object, typically the VariableAnalysis of a relation variable,
	 * but the RElationCallExp of a where, the invoking relation of a call-from invocation, or this for the middle variable.
	 */
	private @NonNull Map<@NonNull String, @NonNull VariableAnalysis> name2originator = new HashMap<>();

	/**
	 * The analysis of each relation variable.
	 */
	private final @NonNull Map<@NonNull Variable, @NonNull VariableAnalysis> rVariable2analysis = new HashMap<>();

	/**
	 * The analysis of each core variable.
	 */
	private final @NonNull Map<@NonNull Variable, @NonNull VariableAnalysis> cVariable2analysis = new HashMap<>();

	public VariablesAnalysis(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationDomain rEnforcedDomain,
			@NonNull CoreDomain cEnforcedDomain, @NonNull Type traceClass) throws CompilerChainException {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.cEnforcedDomain = cEnforcedDomain;
		this.cMapping = ClassUtil.nonNullState(QVTcoreUtil.getContainingMapping(cEnforcedDomain));
		this.cTransformation = ClassUtil.nonNullState(cMapping.getTransformation());
		this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
		this.cMiddleGuardPattern = ClassUtil.nonNullState(cMapping.getGuardPattern());
		//
		this.cMiddleRealizedVariable = addCoreRealizedVariable("trace", traceClass);

		this.rThisVariable = QVTbaseUtil.getContextVariable(environmentFactory.getStandardLibrary(), QVTbaseUtil.getContainingTransformation(rEnforcedDomain));
		this.cThisVariable = QVTbaseUtil.getContextVariable(environmentFactory.getStandardLibrary(), cTransformation);
		ThisVariableAnalysis thisVariableAnalysis = new ThisVariableAnalysis(this, rThisVariable, cThisVariable);
		addVariableAnalysis(thisVariableAnalysis);
	}

	/**
	 * Add the predicate "cLeftExpression = cRightExpression" to cCorePattern.
	 * @throws CompilerChainException
	 */
	protected void addConditionPredicate(@NonNull CorePattern cCorePattern, @NonNull OCLExpression cLeftExpression, @NonNull OCLExpression cRightExpression) throws CompilerChainException {
		OperationCallExp eTerm = createOperationCallExp(cLeftExpression, "=", cRightExpression);
		addPredicate(cCorePattern, eTerm);
	}

	/**
	 * Create a core Variable with a name and type in the middle guard pattern. The variable has no corresponding relation variable.
	 * @throws CompilerChainException
	 */
	public @NonNull Variable addCoreGuardVariable(@NonNull String name, @NonNull Type type) throws CompilerChainException {
		CoreVariableAnalysis analysis = new CoreVariableAnalysis(this, name, type, null);
		Variable cVariable = analysis.getCoreVariable();
		addVariableAnalysis(analysis);
		cMiddleGuardPattern.getVariable().add(cVariable);
		return cVariable;
	}

	/**
	 * Create a core RealizedVariable with a name and type in the middle bottom pattern. The variable has no corresponding relation variable.
	 * @throws CompilerChainException
	 */
	public @NonNull RealizedVariable addCoreRealizedVariable(@NonNull String name, @NonNull Type type) throws CompilerChainException {
		CoreVariableAnalysis analysis = new CoreVariableAnalysis(this, name, type);
		RealizedVariable cVariable = analysis.getCoreRealizedVariable();
		addVariableAnalysis(analysis);
		cMiddleBottomPattern.getRealizedVariable().add(cVariable);
		return cVariable;
	}

	public @NonNull Variable addCoreVariable(@NonNull String name, @NonNull OCLExpression mMember) throws CompilerChainException {
		CoreVariableAnalysis analysis = new CoreVariableAnalysis(this, name, ClassUtil.nonNullState(mMember.getType()), mMember);
		Variable cVariable = analysis.getCoreVariable();
		addVariableAnalysis(analysis);
		cMiddleGuardPattern.getVariable().add(cVariable);
		return cVariable;
	}

	public void addNavigationAssignment(@NonNull Variable rTargetVariable, @NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		getVariableAnalysis(rTargetVariable).addNavigationAssignment(targetProperty, cExpression, isPartial);
	}

	public void addNavigationPredicate(@NonNull CorePattern cCorePattern, @NonNull Variable rTargetVariable, @NonNull Property targetProperty, @NonNull OCLExpression cExpression) throws CompilerChainException {
		Variable cTargetVariable = getCoreVariable(rTargetVariable);
		NavigationCallExp cNavigationExp = createNavigationCallExp(createVariableExp(cTargetVariable), targetProperty);
		if (cExpression instanceof VariableExp) {
			addConditionPredicate(cCorePattern, cExpression, cNavigationExp);
		}
		else {
			addConditionPredicate(cCorePattern, cNavigationExp, cExpression);
		}
	}

	protected void addPredicate(@NonNull CorePattern cExpectedCorePattern, @NonNull OCLExpression cExpression) throws CompilerChainException {
		assert cMapping == QVTcoreUtil.getContainingMapping(cExpectedCorePattern);
		QVTr2QVTc.SYNTHESIS.println("  addPredicate " + cExpression);
		Set<@NonNull Variable> cReferredVariables = new HashSet<>();
		gatherReferredVariables(cReferredVariables, cExpression);
		boolean isGuard = true;
		boolean isMiddle = false;
		CorePattern cReferredPattern = null;
		for (@NonNull Variable cReferredVariable : cReferredVariables) {
			VariableAnalysis analysis = cVariable2analysis.get(cReferredVariable);
			if (analysis == null) {
				isGuard = false;
				isMiddle = true;
				break;
			}
			else {
				CorePattern corePattern = analysis.getCorePattern();
				if (corePattern == null) {
				}
				else if (!(corePattern instanceof GuardPattern)) {
					isGuard = false;
				}
				if (cReferredPattern == null) {
					cReferredPattern = corePattern;
				}
				else if (cReferredPattern != corePattern) {
					isMiddle = true;
				}
			}
		}
		if (isMiddle) {
			cReferredPattern = isGuard ? cMiddleGuardPattern : cMiddleBottomPattern;
		}
		else if (cReferredPattern != null) {
			cReferredPattern = isGuard ? cReferredPattern.getArea().getGuardPattern() : cReferredPattern.getArea().getBottomPattern();
		}
		//		assert cExpectedCorePattern == cReferredPattern;
		if (cReferredPattern != null) {
			Predicate cPredicate = createPredicate(cExpression);
			/*cExpectedCorePattern*/cReferredPattern.getPredicate().add(cPredicate);
		}
	}

	/**
	 * Add the assignment for rVariable to the middle BottomPattern. If isOptional, a missing trace property is ignored.
	 *
	 * Returns the core variant of the relation variable.
	 */
	public @NonNull Variable addTraceNavigationAssignment(@NonNull Variable rVariable, boolean isOptional) throws CompilerChainException {
		Variable cVariable = getCoreVariable(rVariable); //getCoreRealizedVariable(rTargetVariable);
		Property cTargetProperty = qvtr2qvtc.basicGetTraceProperty(QVTrelationUtil.getType(cMiddleRealizedVariable), rVariable);
		assert isOptional || (cTargetProperty != null);
		if (cTargetProperty != null) {
			assert (!cTargetProperty.isIsMany() || (cVariable.getType() instanceof CollectionType));
			VariableExp cSlotVariableExp = createVariableExp(cMiddleRealizedVariable);
			OCLExpression cExpression = createVariableExp(cVariable);
			NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cTargetProperty, cExpression, false);
			QVTr2QVTc.SYNTHESIS.println("  addPropertyAssignment " + cAssignment);
			assertNewAssignment(QVTcoreUtil.getOwnedAssignments(cMiddleBottomPattern), cAssignment);
			cMiddleBottomPattern.getAssignment().add(cAssignment);
		}
		return cVariable;
	}

	public @NonNull Variable addTraceNavigationAssignment(@NonNull Property cTargetProperty, @NonNull Variable cVariable) throws CompilerChainException {
		assert (!cTargetProperty.isIsMany() || (cVariable.getType() instanceof CollectionType));
		VariableExp cSlotVariableExp = createVariableExp(cMiddleRealizedVariable);
		OCLExpression cExpression = createVariableExp(cVariable);
		NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cTargetProperty, cExpression, false);
		QVTr2QVTc.SYNTHESIS.println("  addPropertyAssignment " + cAssignment);
		assertNewAssignment(QVTcoreUtil.getOwnedAssignments(cMiddleBottomPattern), cAssignment);
		cMiddleBottomPattern.getAssignment().add(cAssignment);
		return cVariable;
	}

	public void addVariableAnalysis(@NonNull VariableAnalysis analysis) throws CompilerChainException {
		Variable cVariable = analysis.getCoreVariable();
		cVariable2analysis.put(cVariable, analysis);
		Variable rVariable = analysis.getRelationVariable();
		if (rVariable != null) {
			rVariable2analysis.put(rVariable, analysis);
		}
	}

	public void assertNewAssignment(@NonNull Iterable<@NonNull Assignment> oldAssignments, @NonNull NavigationAssignment newAssignment) {
		//		if ("tr.action := sm".equals(newAssignment.toString())) {
		//			newAssignment.toString();
		//		}
		OCLExpression newSlotExpression = newAssignment.getSlotExpression();
		if (newSlotExpression instanceof VariableExp) {
			VariableDeclaration newVariable = ((VariableExp)newSlotExpression).getReferredVariable();
			Property targetProperty = QVTcoreUtil.getTargetProperty(newAssignment);
			for (@NonNull Assignment oldAssignment : oldAssignments) {
				if (oldAssignment instanceof NavigationAssignment) {
					if (QVTcoreUtil.getTargetProperty((NavigationAssignment)oldAssignment) == targetProperty) {
						OCLExpression oldSlotExpression = ((NavigationAssignment)oldAssignment).getSlotExpression();
						if (oldSlotExpression instanceof VariableExp) {
							VariableDeclaration oldVariable = ((VariableExp)oldSlotExpression).getReferredVariable();
							assert oldVariable != newVariable : "Repeated assignment: \"" + oldAssignment + "\", \"" + newAssignment + "\"";
						}
					}
				}
			}
		}
	}

	protected @Nullable VariableAnalysis basicGetVariableAnalysis(@NonNull Variable relationVariable) {
		return rVariable2analysis.get(relationVariable);
	}

	public void check() {
		for (@NonNull VariableAnalysis analysis : rVariable2analysis.values()) {
			analysis.check();
		}
	}

	public @NonNull Iterable<@NonNull VariableAnalysis> getAnalyses() {
		return rVariable2analysis.values();
	}

	public @NonNull Variable getCoreThisVariable() {
		return cThisVariable;
	}

	public @NonNull Variable getCoreVariable(@NonNull Variable rVariable) throws CompilerChainException {			// doRVarToMVar
		return getVariableAnalysis(rVariable).getCoreVariable();
	}

	protected @NonNull VariableAnalysis getCoreVariableAnalysis(@NonNull Variable coreVariable) {
		return ClassUtil.nonNullState(cVariable2analysis.get(coreVariable));
	}

	public @NonNull BottomPattern getMiddleBottomPattern() {
		return cMiddleBottomPattern;
	}

	public @NonNull GuardPattern getMiddleGuardPattern() {
		return cMiddleGuardPattern;
	}

	public @NonNull RealizedVariable getMiddleRealizedVariable() {
		return cMiddleRealizedVariable;
	}

	@Nullable OCLExpression getTemplateExp(@NonNull ObjectTemplateExp objectTemplateExp, @NonNull Parameter keyParameter) {
		String keyParameterName = keyParameter.getName();
		for (@NonNull PropertyTemplateItem propertyTemplateItem : ClassUtil.nullFree(objectTemplateExp.getPart())) {
			Property property = propertyTemplateItem.getReferredProperty();
			if (ClassUtil.safeEquals(property.getName(), keyParameterName)) {
				return propertyTemplateItem.getValue();
			}
		}
		EObject eContainer = objectTemplateExp.eContainer();
		if (eContainer instanceof PropertyTemplateItem) {
			PropertyTemplateItem containingPropertyTemplateItem = (PropertyTemplateItem)eContainer;
			Property property = containingPropertyTemplateItem.getReferredProperty();
			Property oppositeProperty = property != null ? property.getOpposite() : null;
			if ((oppositeProperty != null) && ClassUtil.safeEquals(oppositeProperty.getName(), keyParameterName)) {
				return containingPropertyTemplateItem.getObjContainer();
			}
		}
		return null;
	}

	public @NonNull String getUniqueVariableName(@NonNull String name, @NonNull VariableAnalysis originator) {
		Object oldOriginator = name2originator.get(name);
		if (oldOriginator != null) {
			assert oldOriginator != originator;		// Lazy re-creation should not occur.
			for (int i = 0; true; i++) {
				String newName = name + "_" + i;
				if (!name2originator.containsKey(newName)) {
					name = newName;
					break;
				}
			}
		}
		name2originator.put(name, originator);
		return name;
	}

	protected @NonNull VariableAnalysis getVariableAnalysis(@NonNull Variable relationVariable) {
		VariableAnalysis analysis = rVariable2analysis.get(relationVariable);
		if (analysis == null) {
			assert QVTbaseUtil.basicGetContainingTransformation(relationVariable) instanceof RelationalTransformation;
			if (relationVariable instanceof IteratorVariable) {
				analysis = new IteratorVariableAnalysis(this, (IteratorVariable)relationVariable);
			}
			else if (relationVariable instanceof LetVariable) {
				analysis = new LetVariableAnalysis(this, (LetVariable)relationVariable);
			}
			else {
				analysis = new RelationVariableAnalysis(this, relationVariable);
			}
			rVariable2analysis.put(relationVariable, analysis);
		}
		return analysis;
	}

	/**
	 * True if analysis of a relation invoked within a when or where clause.
	 */
	public boolean isInvoked() {
		return isWhened() || isWhered();
	}

	/**
	 * True if analysis of a relation invoked within a when clause.
	 */
	public boolean isWhened() {
		return false;
	}

	/**
	 * True if analysis of a relation invoked within a where clause.
	 */
	public boolean isWhered() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull String> names = new ArrayList<>(name2originator.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(name + " => " );
			Object originator = name2originator.get(name);
			if (originator != this) {
				s.append(originator);
			}
		}
		return s.toString();
	}
}
