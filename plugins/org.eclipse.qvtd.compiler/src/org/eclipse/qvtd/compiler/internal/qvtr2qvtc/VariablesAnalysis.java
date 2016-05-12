/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * VariablesAnalysis manages all the variables in use by a Relation and its corresponding Mapping.
 */
/*public*/ class VariablesAnalysis extends QVTcoreHelper
{
	/**
	 * Return all variables bound to a single variable within the composition tree of each of asRoots.
	 */
	public static void gatherBoundVariables(@NonNull Map<@NonNull Variable, @Nullable TemplateExp> boundVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {		
		for (Element asRoot : asRoots) {
			gatherBoundVariables(boundVariables, asRoot);		
		}
	}
	public static void gatherBoundVariables(@NonNull Map<@NonNull Variable, @Nullable TemplateExp> boundVariables, @NonNull Element asRoot) {		
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();				// ?? CollectionTemplateExp collection is not bound
				if (bindsTo != null) {
					boundVariables.put(bindsTo, (TemplateExp)eObject);
				}
				if (eObject instanceof CollectionTemplateExp) {						// ?? VariableExp members are bound
					Variable rest = ((CollectionTemplateExp)eObject).getRest();		// ?? not bound
					if (rest != null) {
						boundVariables.put(rest, null);
					}
				}
			}
		}
	}
	
	/**
	 * Return all variables referenced within the composition tree of each of asRoots.
	 */
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {		
		for (Element asRoot : asRoots) {
			gatherReferredVariables(referredVariables, asRoot);		
		}
	}
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Element asRoot) {		
		for (EObject eObject : new TreeIterable(asRoot, true)) {
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
				if (eObject instanceof CollectionTemplateExp) {
					Variable rest = ((CollectionTemplateExp)eObject).getRest();
					if (rest != null) {
						referredVariables.add(rest);
					}
				}
			}
		}
	}
	// TODO bug 453863 // ?? this is suspect for more than 2 domains. // FIXME What is 'shared'? a) any two domains b) output/any-input c) all domains
	/**
	 * Return the variables that are used by more than one domain of the relation and so must be middle variables.
	 */
	public static @NonNull Set<@NonNull Variable> getMiddleDomainVariables(@NonNull Relation rRelation) {	
		Set<@NonNull Variable> rSomeDomainVariables = new HashSet<@NonNull Variable>();
		Set<@NonNull Variable> rMiddleDomainVariables = new HashSet<@NonNull Variable>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			Set<@NonNull Variable> rThisDomainVariables = new HashSet<@NonNull Variable>();
			VariablesAnalysis.gatherReferredVariables(rThisDomainVariables, rDomain);
			for (@NonNull Variable rVariable : rThisDomainVariables) {
				if (!rSomeDomainVariables.add(rVariable)) {
					rMiddleDomainVariables.add(rVariable);				// Accumulate second (and higher) usages
				}
			}
		}
		return rMiddleDomainVariables;
	}

	/**
	 * A VariableAnalysis accumulates the usage of a relation varaible and eventually synthesizes an appropriate core variable.
	 */
	protected class VariableAnalysis
	{
		protected final @NonNull Variable rVariable;
		protected final @NonNull String name;
		private @Nullable Key rKey = null;
		private @Nullable TemplateExp rTemplateExp = null;
		private boolean isEnforcedBound = false;
		private boolean isEnforcedReferred = false;
		private @Nullable CoreDomain otherBound = null;
		private boolean isOtherReferred = false;
		private boolean isRoot = false;
		private boolean isWhen = false;
		private boolean isWhere = false;
		private @Nullable Variable cVariable;
		
		private VariableAnalysis(@NonNull Variable rVariable) {
			this.rVariable = rVariable;
			this.name = getUniqueVariableName(ClassUtil.nonNullState(rVariable.getName()), this);
		}
		
		/**
		 * Add the predicate "cLeftExpression = cRightExpression" to cCorePattern.
		 */
		protected void addConditionPredicate(@NonNull CorePattern cCorePattern, @NonNull OCLExpression cLeftExpression, @NonNull OCLExpression cRightExpression) {
			OperationCallExp eTerm = createOperationCallExp(cLeftExpression, "=", cRightExpression);
			addPredicate(cCorePattern, eTerm);
		}
		
		/**
		 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
		 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
		 */
		public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression) {
			Key rKey2 = rKey;
			if (isKeyed() && (rKey2 != null)) {
				if (rKey2.getPart().contains(targetProperty)) {
					return;
				}
				if (rKey2.getOppositePart().contains(targetProperty.getOpposite())) {
					return;
				}
			}
			Variable cVariable2 = getCoreVariable();
			if (!targetProperty.isIsMany() || (cExpression.getType() instanceof CollectionType)) {
				VariableExp cSlotVariableExp = createVariableExp(cVariable2);
				NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, targetProperty, cExpression);
				QVTrToQVTc.SYNTHESIS.println("addPropertyAssignment " + cAssignment);
				assertNewAssignment(cMiddleBottomPattern.getAssignment(), cAssignment);
				cMiddleBottomPattern.getAssignment().add(cAssignment);
				return;
			}
			Property cOppositeProperty = targetProperty.getOpposite();
			if ((cOppositeProperty != null) && (cExpression instanceof VariableExp) && (!cOppositeProperty.isIsMany() || (cVariable2.getType() instanceof CollectionType))) {
				VariableExp cSlotVariableExp = (VariableExp)cExpression;
				NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, cOppositeProperty, createVariableExp(cVariable2));
				QVTrToQVTc.SYNTHESIS.println("addOppositePropertyAssignment " + cAssignment);
				assertNewAssignment(cMiddleBottomPattern.getAssignment(), cAssignment);
				cMiddleBottomPattern.getAssignment().add(cAssignment);
				return;
			}
			throw new IllegalStateException("Unsupported collection assign " + cVariable2 + " . " + targetProperty + " := " + cExpression);
		}

		protected void addPredicate(@NonNull CorePattern cCorePattern, @NonNull OCLExpression cExpression) {
			QVTrToQVTc.SYNTHESIS.println("addPredicate " + cExpression);
			Predicate cPredicate = createPredicate(cExpression);
			cCorePattern.getPredicate().add(cPredicate);
		}

		public @Nullable RealizedVariable basicGetCoreRealizedVariable() {
			return (RealizedVariable)cVariable;
		}

		public @Nullable Variable basicGetCoreVariable() {
			return cVariable;
		}
		
		public void check() {
			if (cVariable == null) {
				System.err.println("No cVariable for " + this);
				return;
			}
			CorePattern cPattern = getCorePattern();
			boolean isRealized = isRealized();
			assert (cVariable != null) && (cVariable.eContainer() == cPattern);
			assert (cVariable instanceof RealizedVariable) == isRealized;
		}
		
		private @NonNull CorePattern getCorePattern() {
			Area cArea = null;
			boolean isGuard = false;
			if (isWhen) {
//				isGuard = true;
				assert isEnforcedBound || (otherBound != null);
				cArea = isEnforcedBound ? cEnforcedDomain : otherBound;
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isGuard = false; //rKey != null;
				cArea = rKey != null ? cMapping : cEnforcedDomain;
			}
			else if (otherBound != null) {
				isGuard = isRoot;
				cArea = otherBound;
			}
			else if (isEnforcedReferred && isOtherReferred) {
				isGuard = false;
				cArea = cMapping;
			}			
			assert cArea != null;
			return ClassUtil.nonNullState(isGuard ? cArea.getGuardPattern() : cArea.getBottomPattern());
		}

		public @NonNull Variable getCoreVariable() {
			Variable cVariable2 = cVariable;
			if (cVariable2 == null) {
				cVariable2 = synthesize();
			}
			return cVariable2;
		}

		public @NonNull Variable getRelationVariable() {
			return rVariable;
		}
		
		private void initializeKeyedVariable(@NonNull Variable cKeyedVariable) {
			Function function = qvtr2qvtc.getKeyFunction(ClassUtil.nonNull(rKey));
			Variable thisVariable = QVTbaseUtil.getContextVariable(environmentFactory.getStandardLibrary(), cTransformation);
			List<@NonNull OCLExpression> asArguments = new ArrayList<@NonNull OCLExpression>();
			if (rTemplateExp instanceof ObjectTemplateExp) {
				ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)rTemplateExp;
				for (@NonNull Parameter keyParameter : ClassUtil.nullFree(function.getOwnedParameters())) {
					OCLExpression parameterExp = getTemplateExp(objectTemplateExp, keyParameter);
					if (parameterExp instanceof TemplateExp) {
						Variable rVariable = ClassUtil.nonNullState(((TemplateExp)parameterExp).getBindsTo());
						Variable cVariable = VariablesAnalysis.this.getCoreVariable(rVariable);
						asArguments.add(createVariableExp(cVariable));
					}
					else if (parameterExp instanceof VariableExp) {
						Variable rVariable = (Variable) ClassUtil.nonNullState(((VariableExp)parameterExp).getReferredVariable());
						Variable cVariable = VariablesAnalysis.this.getCoreVariable(rVariable);
						asArguments.add(createVariableExp(cVariable));
					}
					else {
						asArguments.add(createInvalidExpression());
					}
				}
			}
			OCLExpression asConstructor = createOperationCallExp(createVariableExp(thisVariable), function, asArguments);
//			addConditionPredicate(cMiddleBottomPattern, createVariableExp(cKeyedVariable), asConstructor);
			@NonNull VariableAssignment cVariableAssignment = createVariableAssignment(cKeyedVariable, asConstructor);
			cMiddleBottomPattern.getAssignment().add(cVariableAssignment);
		}
		
		private boolean isKeyed() {
			boolean isKeyed = false;
			if (isWhen) {
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isKeyed = rKey != null;
			}
			return isKeyed;
		}
		
		private boolean isRealized() {
			boolean isRealized = false;
			if (isWhen) {
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isRealized = rKey == null;
			}
			return isRealized;
		}

		public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @Nullable Key rKey) {
			assert !isEnforcedBound;
			assert this.otherBound == null;
			assert this.rKey == null;
			assert this.rTemplateExp == null;
			this.isEnforcedBound = true;
			this.rTemplateExp = rTemplateExp;
			this.rKey = rKey;
		}

		public void setIsEnforcedReferred() {
			this.isEnforcedReferred = true;
		}

		public void setIsRoot() {
			this.isRoot = true;
		}

		public void setIsWhen() {
			this.isWhen = true;
		}

		public void setIsWhere() {
			this.isWhere = true;
		}

		public void setOtherBound(@NonNull CoreDomain otherDomain) {
			assert !isEnforcedBound;
			assert this.otherBound == null;
			this.otherBound = otherDomain;
		}

		public void setOtherReferred(@NonNull CoreDomain otherDomain) {
			this.isOtherReferred = true;
		}

		public @NonNull Variable synthesize() {
			Variable cVariable2 = cVariable;
			if (cVariable2 == null) {
				CorePattern cPattern = getCorePattern();
				boolean isKeyed = isKeyed();
				boolean isRealized = isRealized();
				//
				Type type = ClassUtil.nonNullState(rVariable.getType());
				if (isKeyed) {
					cVariable = cVariable2 = createVariable(name, type, true, null);
					initializeKeyedVariable(cVariable2);
					cPattern.getVariable().add(cVariable2);
				}
				else if (!isRealized) {
					cVariable = cVariable2 = createVariable(name, type, rVariable.isIsRequired(), null);
					cPattern.getVariable().add(cVariable2);
				}
				else  {
					RealizedVariable cRealizedVariable = createRealizedVariable(name, type);
					((BottomPattern)cPattern).getRealizedVariable().add(cRealizedVariable);
					cVariable = cVariable2 = cRealizedVariable;
				}
			}
			return cVariable2;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(rVariable.toString());
			if (isWhen) {
				s.append(" WHEN");
			}
			if (isWhere) {
				s.append(" WHERE");
			}
			if (isRoot) {
				s.append(" ROOT");
			}
			if (rKey != null) {
				s.append(" KEYED");
			}
			if (isEnforcedBound) {
				s.append(" ENFORCED");
			}
			else if (isEnforcedReferred) {
				s.append(" enforced");
			}
			if (otherBound != null) {
				s.append(" OTHER");
			}
			else if (isOtherReferred) {
				s.append(" other");
			}			
			if (rTemplateExp != null) {
				s.append(" " + rTemplateExp);
			}			
			return s.toString();
		}
	}
	
	protected final @NonNull QVTrToQVTc qvtr2qvtc;
	protected final @NonNull CoreDomain cEnforcedDomain;
	protected final @NonNull Mapping cMapping;
	protected final @NonNull Transformation cTransformation;
	protected final @NonNull BottomPattern cMiddleBottomPattern;
	protected final @NonNull RealizedVariable cMiddleRealizedVariable;		// tcv: The trace class variable (the middle variable identifying the middle object)

	/**
	 * Map from the each core variable name in use to an originating object, typically the VariableAnalysis of a relation variable,
	 * but the RElationCallExp of a where, the invoking relation of a call-from invocation, or this for the middle variable.
	 */
	private @NonNull Map<@NonNull String, @NonNull Object> name2originator = new HashMap<@NonNull String, @NonNull Object>();	
	
	/**
	 * The analysis of each relation variable.
	 */
	private final @NonNull Map<@NonNull Variable, @NonNull VariableAnalysis> rVariable2analysis = new HashMap<@NonNull Variable, @NonNull VariableAnalysis>();
	
	public VariablesAnalysis(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull CoreDomain cEnforcedDomain, @NonNull Type traceClass) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.qvtr2qvtc = qvtr2qvtc;
		this.cEnforcedDomain = cEnforcedDomain;
		this.cMapping = ClassUtil.nonNullState(QVTcoreUtil.getContainingMapping(cEnforcedDomain));
		this.cTransformation = ClassUtil.nonNullState(cMapping.getTransformation());
		this.cMiddleBottomPattern = ClassUtil.nonNullState(cMapping.getBottomPattern());
		//
		String middleRealizedVariableName = getUniqueVariableName("trace", this);
		this.cMiddleRealizedVariable = createRealizedVariable(middleRealizedVariableName, traceClass);
		cMiddleBottomPattern.getRealizedVariable().add(cMiddleRealizedVariable);
	}

	public void addNavigationAssignment(@NonNull Variable rTargetVariable, @NonNull Property targetProperty, @NonNull OCLExpression cExpression) {
		getVariableAnalysis(rTargetVariable).addNavigationAssignment(targetProperty, cExpression);
	}
	
	/**
	 * Add the NavigationAssignment "trace.cProperty := cExpression" to the middle BottomPattern.
	 */
	public void addTraceNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression) {
		assert (!targetProperty.isIsMany() || (cExpression.getType() instanceof CollectionType));
		VariableExp cSlotVariableExp = createVariableExp(cMiddleRealizedVariable);
		NavigationAssignment cAssignment = createNavigationAssignment(cSlotVariableExp, targetProperty, cExpression);
		QVTrToQVTc.SYNTHESIS.println("addPropertyAssignment " + cAssignment);
		assertNewAssignment(cMiddleBottomPattern.getAssignment(), cAssignment);
		cMiddleBottomPattern.getAssignment().add(cAssignment);
	}
	
	private void assertNewAssignment(@NonNull List<Assignment> oldAssignments, @NonNull NavigationAssignment newAssignment) {
//		if ("tr.action := sm".equals(newAssignment.toString())) {
//			newAssignment.toString();
//		}
		OCLExpression newSlotExpression = newAssignment.getSlotExpression();
		if (newSlotExpression instanceof VariableExp) {
			VariableDeclaration newVariable = ((VariableExp)newSlotExpression).getReferredVariable();
			Property targetProperty = QVTcoreBaseUtil.getTargetProperty(newAssignment);
			for (Assignment oldAssignment : oldAssignments) {
				if (oldAssignment instanceof NavigationAssignment) {				
					if (QVTcoreBaseUtil.getTargetProperty((NavigationAssignment)oldAssignment) == targetProperty) {
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
	
	public void check() {
		for (@NonNull VariableAnalysis analysis : rVariable2analysis.values()) {
			analysis.check();
		}
	}
	
	/**
	 * Create a core Variable with a name and type in the middle guard pattern. The variable has no corresponding relation variable.
	 * @param originator 
	 */
	public @NonNull Variable createCoreOnlyVariable(@NonNull String name, @NonNull Type type, @NonNull Element originator) {
		String uniqueName = getUniqueVariableName(name, originator);
		return createVariable(uniqueName, type, true, null);
	}

	public @NonNull Iterable<@NonNull VariableAnalysis> getAnalyses() {
		return rVariable2analysis.values();
	}
	
	public @NonNull Variable getCoreVariable(@NonNull Variable rVariable) {			// doRVarToMVar
		return getVariableAnalysis(rVariable).getCoreVariable();
	}
	
	public @NonNull RealizedVariable getMiddleRealizedVariable() {
		return cMiddleRealizedVariable;
	}
	
	private @Nullable OCLExpression getTemplateExp(@NonNull ObjectTemplateExp objectTemplateExp, @NonNull Parameter keyParameter) {
		String keyParameterName = keyParameter.getName();
		for (@NonNull PropertyTemplateItem propertyTemplateItem : ClassUtil.nullFree(objectTemplateExp.getPart())) {
			Property property = propertyTemplateItem.getReferredProperty();
			if (ClassUtil.safeEquals(property.getName(), keyParameterName)) {
				return propertyTemplateItem.getValue();
			}
		}
		EObject eContainer = objectTemplateExp.eContainer();
		if (eContainer instanceof PropertyTemplateItem) {
			PropertyTemplateItem continingPropertyTemplateItem = (PropertyTemplateItem)eContainer;
			Property property = continingPropertyTemplateItem.getReferredProperty();
			Property oppositeProperty = property != null ? property.getOpposite() : null;
			if ((oppositeProperty != null) && ClassUtil.safeEquals(oppositeProperty.getName(), keyParameterName)) {
				return continingPropertyTemplateItem.getValue();
			}
		}
		return null;
	}

	public @NonNull String getUniqueVariableName(@NonNull String name, @NonNull Object originator) {
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
			assert QVTbaseUtil.getContainingTransformation(relationVariable) instanceof RelationalTransformation;
			analysis = new VariableAnalysis(relationVariable);
			rVariable2analysis.put(relationVariable, analysis);
		}
		return analysis;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull String> names = new ArrayList<@NonNull String>(name2originator.keySet());
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
