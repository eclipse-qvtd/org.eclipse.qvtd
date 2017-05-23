/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class QVTimperativeUtil extends QVTbaseUtil
{
	public static final class MappingParameterBindingComparator implements Comparator<@NonNull MappingParameterBinding>
	{
		public static final @NonNull MappingParameterBindingComparator INSTANCE = new MappingParameterBindingComparator();

		@Override
		public int compare(@NonNull MappingParameterBinding o1, @NonNull MappingParameterBinding o2) {
			VariableDeclaration v1 = o1.getBoundVariable();
			VariableDeclaration v2 = o2.getBoundVariable();
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected static class PatternVariableComparator implements Comparator<@NonNull Variable>
	{
		private final @NonNull Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs;

		protected PatternVariableComparator(@NonNull Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs) {
			this.def2refs = def2refs;
		}

		@Override
		public int compare(@NonNull Variable o1, @NonNull Variable o2) {
			List<@NonNull VariableDeclaration> l1 = def2refs.get(o1);
			List<@NonNull VariableDeclaration> l2 = def2refs.get(o2);
			int s1 = l1 != null ? l1.size() : 0;
			int s2 = l2 != null ? l2.size() : 0;
			if (s1 != s2) {
				return s1 - s2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static @Nullable ImperativeTransformation basicGetContainingTransformation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ImperativeTransformation) {
				return (ImperativeTransformation) eObject;
			}
		}
		return null;
	}

	public static @Nullable ImperativeTypedModel basicGetOwnedTypedModel(@NonNull ImperativeTransformation transformation, @Nullable String name) {
		return NameUtil.getNameable(getOwnedTypedModels(transformation), name);
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getClassType(@NonNull TypedElement typedElement) {
		return ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)typedElement.getType());
	}

	public static @Nullable Mapping getContainingMapping(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Mapping) {
				return (Mapping) eObject;
			}
		}
		return null;
	}

	public static @Nullable Statement getContainingStatement(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Statement) {
				return (Statement) eObject;
			}
		}
		return null;
	}

	public static @NonNull ImperativeTransformation getContainingTransformation(@Nullable EObject eObject) {
		return ClassUtil.nonNullState(basicGetContainingTransformation(eObject));
	}

	public static @NonNull String getName(@NonNull Mapping asMapping) {
		return ClassUtil.nonNullState(asMapping.getName());
	}

	public static @NonNull String getName(@NonNull MappingParameter asParameter) {
		return ClassUtil.nonNullState(asParameter.getName());
	}

	public static @NonNull Mapping getOwnedMapping(@NonNull ImperativeTransformation transformation, @Nullable String name) {
		return ClassUtil.nonNullState(NameUtil.getNameable(getOwnedMappings(transformation), name));
	}

	@SuppressWarnings("unchecked")
	public static @NonNull Iterable<@NonNull MappingParameterBinding> getOwnedMappingParameterBindings(@NonNull MappingCall mappingCall) {
		Object ownedParameters = mappingCall.getOwnedMappingParameterBindings();
		return (@NonNull Iterable<@NonNull MappingParameterBinding>)ownedParameters;
	}

	@SuppressWarnings("unchecked")
	public static @NonNull Iterable<@NonNull MappingParameter> getOwnedMappingParameters(@NonNull Mapping mapping) {
		Object ownedParameters = mapping.getOwnedMappingParameters();
		return (@NonNull Iterable<@NonNull MappingParameter>)ownedParameters;
	}

	@SuppressWarnings("unchecked")
	public static @NonNull Iterable<@NonNull Mapping> getOwnedMappings(@NonNull ImperativeTransformation transformation) {
		Object rule = transformation.getRule();
		return (@NonNull Iterable<@NonNull Mapping>)rule;
	}

	public static @NonNull ImperativeTypedModel getOwnedTypedModel(@NonNull ImperativeTransformation transformation, @Nullable String name) {
		return ClassUtil.nonNullState(NameUtil.getNameable(getOwnedTypedModels(transformation), name));
	}

	@SuppressWarnings("unchecked")
	public static @NonNull Iterable<@NonNull ImperativeTypedModel> getOwnedTypedModels(@NonNull ImperativeTransformation transformation) {
		Object modelParameter = transformation.getModelParameter();
		return (@NonNull Iterable<@NonNull ImperativeTypedModel>)modelParameter;
	}

	public static @NonNull Mapping getReferredMapping(MappingCall asMappingCall) {
		return ClassUtil.nonNullState(asMappingCall.getReferredMapping());
	}

	public static @NonNull Mapping getRootMapping(@NonNull ImperativeTransformation asTransformation) {
		Mapping asRootMapping = NameUtil.getNameable(getOwnedMappings(asTransformation), QVTscheduleUtil.ROOT_MAPPING_NAME);	// Obsolete relic
		for (@NonNull Mapping asMapping : getOwnedMappings(asTransformation)) {
			boolean isRoot = true;
			for (@NonNull MappingParameter asParameter : QVTimperativeUtil.getOwnedMappingParameters(asMapping)) {
				if (asParameter instanceof GuardParameter) {
					isRoot = false;
					break;
				}
				if (asParameter instanceof SimpleParameter) {
					isRoot = false;
					break;
				}
			}
			if (isRoot) {
				if (asRootMapping == null) {
					asRootMapping = asMapping;
				}
				else if (asRootMapping != asMapping) {
					throw new IllegalStateException("Transformation " + asTransformation.getName() + " has ambiguous root mappings: " + asRootMapping + ", " + asMapping);
				}
			}
		}
		if (asRootMapping  == null) {
			throw new IllegalStateException("Transformation " + asTransformation.getName() + " has no root mapping");
		}
		return asRootMapping;
	}

	public static @NonNull Property getTargetProperty(@NonNull SetStatement asSetStatement) {
		Property referredProperty = ClassUtil.nonNullState(asSetStatement.getTargetProperty());
		if (asSetStatement.isIsOpposite()) {
			if (referredProperty.eIsProxy() ) {
				throw new IllegalStateException("Unresolved target property proxy '" + EcoreUtil.getURI(referredProperty) + "' at '" + EcoreUtil.getURI(asSetStatement) + "'");
			}
			return ClassUtil.nonNullState(referredProperty.getOpposite());
		}
		else {
			return referredProperty;
		}
	}

	public static boolean isObserver(@NonNull Mapping asMapping) {
		boolean isHazardous = false;
		for (@NonNull Statement asStatement : ClassUtil.nullFree(asMapping.getOwnedStatements())) {
			if ((asStatement instanceof ObservableStatement)
					&& (((ObservableStatement)asStatement).getObservedProperties().size() > 0)) {
				return true;
			}
		}
		return isHazardous;
	}

	public static boolean isPrimitiveVariable(@NonNull VariableDeclaration asVariable) {
		if (!(asVariable.getType() instanceof CollectionType))  {
			return true;
		}
		return false;
	}

	public static @NonNull ImperativeTransformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTiEnvironmentFactory.CREATE_STRATEGY);
		try {
			return (ImperativeTransformation) loadTransformation(ImperativeModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	/**
	 * Sort the pattern variables into a least referenced first then alphabetical order.
	 */
	public static void sortPatternVariables(@NonNull List<@NonNull ? extends Variable> variables) {
		if (variables.size() > 1) {
			final Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs = new HashMap<>();
			//
			// Initialize the def2refs.keySet as a fast is-a-pattern-variable lookup.
			//
			for (@NonNull Variable variable : variables) {
				def2refs.put(variable, null);
			}
			//
			// Initialize the def2refs.values with the directly referenced pattern variables.
			//
			for (@NonNull Variable variable : variables) {
				List<@NonNull VariableDeclaration> refs = null;
				OCLExpression initExpression = variable.getOwnedInit();
				if (initExpression != null) {
					for (@NonNull EObject eObject : new TreeIterable(initExpression, true)) {
						if (eObject instanceof VariableExp) {
							VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
							assert referredVariable != null;
							if (def2refs.containsKey(referredVariable)) {
								if (refs == null) {
									refs = new ArrayList<>();
									def2refs.put(variable, refs);
								}
								if (!refs.contains(referredVariable)) {
									refs.add(referredVariable);
								}
							}
						}
					}
				}
			}
			//
			// Recursively expand the def2refs.values to the closure of the directly referenced pattern variables.
			//
			boolean changed = true;
			while (changed) {
				changed = false;
				for (@NonNull Variable variable : def2refs.keySet()) {
					List<@NonNull VariableDeclaration> refs = def2refs.get(variable);
					if (refs != null) {
						for (int i = 0; i < refs.size(); i++) {
							VariableDeclaration ref = refs.get(i);
							List<@NonNull VariableDeclaration> refRefs = def2refs.get(ref);
							if (refRefs != null) {
								for (@NonNull VariableDeclaration refRef : refRefs) {
									if (!refs.contains(refRef)) {
										refs.add(refRef);
										changed = true;
									}
								}
							}
						}
					}
				}
			}
			//
			// Sort the variables fewest references first then alphabetically.
			//
			ClassUtil.sort(variables, new PatternVariableComparator(def2refs));
		}
	}

	public static @NonNull MappingCall getOwningMappingCall(@NonNull MappingParameterBinding mappingParameterBinding) {
		return ClassUtil.nonNullState(mappingParameterBinding.getOwningMappingCall());
	}

	/**
	 * Return a copy of asVariablePredicates sorted to avoid reverse references from the predicate expressions.
	 *
	public static @NonNull List<@NonNull VariablePredicate> sortVariablePredicates(@NonNull Mapping asMapping, @NonNull List<@NonNull VariablePredicate> asVariablePredicates) {
		Set<@NonNull VariableDeclaration> asGuardVariables = new HashSet<>();
		asGuardVariables.addAll(ClassUtil.nullFree(asMapping.getGuardPattern().getOwnedGuardVariables()));
		asGuardVariables.addAll(ClassUtil.nullFree(asMapping.getInoutVariables()));
		asGuardVariables.addAll(ClassUtil.nullFree(asMapping.getOwnedPredicateVariables()));
		for (Domain asDomain : asMapping.getDomain()) {
			asGuardVariables.addAll(ClassUtil.nullFree(((ImperativeDomain)asDomain).getGuardPattern().getOwnedGuardVariables()));
		}
		List<@NonNull VariableDeclaration> pendingVariables = new ArrayList<>();
		Map<@NonNull VariableDeclaration, @NonNull VariablePredicate> variable2predicate = new HashMap<>();
		Map<@NonNull VariableDeclaration, @NonNull Set<@NonNull VariablePredicate>> variable2predicates = new HashMap<>();
		Map<@NonNull VariablePredicate, @NonNull Set<@NonNull VariableDeclaration>> predicate2variables = new HashMap<>();
		for (@NonNull VariablePredicate asVariablePredicate : asVariablePredicates) {
			for (TreeIterator<EObject> tit = asVariablePredicate.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					VariableDeclaration asVariable = ((VariableExp)eObject).getReferredVariable();
					if ((asVariable != null) && asGuardVariables.contains(asVariable)) {
						Set<@NonNull VariablePredicate> predicates = variable2predicates.get(asVariable);
						if (predicates == null){
							predicates = new HashSet<>();
							variable2predicates.put(asVariable, predicates);
						}
						predicates.add(asVariablePredicate);
						Set<@NonNull VariableDeclaration> variables = predicate2variables.get(asVariablePredicate);
						if (variables == null){
							variables = new HashSet<>();
							predicate2variables.put(asVariablePredicate, variables);
						}
						variables.add(asVariable);
						Variable targetVariable = asVariablePredicate.getTargetVariable();
						assert targetVariable != null;
						pendingVariables.add(targetVariable);
						variable2predicate.put(targetVariable, asVariablePredicate);
					}
				}
			}
		}
		int oldSize;
		List<@NonNull VariablePredicate> asSortedVariablePredicates = new ArrayList<>();
		Collections.sort(pendingVariables, NameUtil.NAMEABLE_COMPARATOR);		// Ensure deterministic order
		while (pendingVariables.size() > 0) {
			oldSize = asSortedVariablePredicates.size();
			for (@NonNull VariableDeclaration asVariable : pendingVariables) {
				VariablePredicate asVariablePredicate1 = variable2predicate.get(asVariable);
				assert asVariablePredicate1 != null;
				Set<@NonNull VariableDeclaration> variables = predicate2variables.get(asVariablePredicate1);
				if (variables != null){
					variables.retainAll(pendingVariables);
					if (variables.size() <= 0) {
						asSortedVariablePredicates.add(asVariablePredicate1);
						Set<VariablePredicate> predicates = variable2predicates.get(asVariable);
						if (predicates != null) {
							for (VariablePredicate asVariablePredicate2 : predicates) {
								Set<VariableDeclaration> variables2 = predicate2variables.get(asVariablePredicate2);
								if (variables2 != null) {
									variables2.remove(asVariable);
								}
							}
						}
						pendingVariables.remove(asVariable);
						predicate2variables.remove(asVariablePredicate1);
						break;
					}
				}
			}
			if (asSortedVariablePredicates.size() == oldSize) {
				for (VariablePredicate asVariablePredicate : predicate2variables.keySet()) {
					asSortedVariablePredicates.add(asVariablePredicate);
				}
				break;			// FIXME error message for cycle
			}
		}
		return asSortedVariablePredicates;
	} */

}