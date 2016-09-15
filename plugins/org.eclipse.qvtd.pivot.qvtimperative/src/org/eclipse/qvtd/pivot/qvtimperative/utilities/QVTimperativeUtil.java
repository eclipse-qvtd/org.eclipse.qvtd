/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTimperativeUtil extends QVTbaseUtil
{
	/** The name of the root mapping */
	public static final @NonNull String ROOT_MAPPING_NAME = "__root__";
	public static final @NonNull String MIDDLE_DOMAIN_NAME = "middle";

	public static final class MappingCallBindingComparator implements Comparator<MappingCallBinding>
	{
		public static final @NonNull MappingCallBindingComparator INSTANCE = new MappingCallBindingComparator();

		@Override
		public int compare(MappingCallBinding o1, MappingCallBinding o2) {
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

	/**
	 * Return a MappingStatement comprising the concatenation of mappingStatementOrStatements and mappingStatement.
	 * mappingStatementOrStatements may be null, a MappingStatement or a composite MappingSequence.
	 *
	public static @NonNull MappingStatement addMappingStatement(@Nullable MappingStatement mappingStatementOrStatements, @NonNull MappingStatement mappingStatement) {
		if (mappingStatementOrStatements == null) {
			return mappingStatement;
		}
		else if (mappingStatementOrStatements instanceof MappingSequence){
			((MappingSequence)mappingStatementOrStatements).getMappingStatements().add(mappingStatement);
			return mappingStatementOrStatements;
		}
		else  {
			MappingSequence mappingSequence = QVTimperativeFactory.eINSTANCE.createMappingSequence();
			List<MappingStatement> mappingStatements = mappingSequence.getMappingStatements();
			mappingStatements.add(mappingStatementOrStatements);
			mappingStatements.add(mappingStatement);
			return mappingSequence;
		}
	} */

	public static @NonNull ImperativeDomain createImperativeDomain(@NonNull TypedModel typedModel) {
		ImperativeDomain coreDomain = QVTimperativeFactory.eINSTANCE.createImperativeDomain();
		coreDomain.setName(typedModel.getName());
		coreDomain.setTypedModel(typedModel);
		return coreDomain;
	}

	public static @NonNull IterateExp createIterateExp(@Nullable OCLExpression asSource, @NonNull Iteration asIteration, @NonNull List<? extends Variable> asIterators, @NonNull OCLExpression asBody) {
		IterateExp asCallExp = PivotFactory.eINSTANCE.createIterateExp();
		asCallExp.setReferredIteration(asIteration);
		asCallExp.setOwnedSource(asSource);
		asCallExp.getOwnedIterators().addAll(asIterators);
		asCallExp.setOwnedBody(asBody);
		asCallExp.setType(asIteration.getType());
		asCallExp.setIsRequired(asIteration.isIsRequired());
		return asCallExp;
	}

	public static @NonNull Mapping createMapping(@NonNull String name) {
		Mapping mapping = QVTimperativeFactory.eINSTANCE.createMapping();
		mapping.setName(name);
		return mapping;
	}

	public static @NonNull MappingCall createMappingCall(@NonNull Mapping mapping, @NonNull List<MappingCallBinding> mappingCallBindings) {
		MappingCall mappingCall = QVTimperativeFactory.eINSTANCE.createMappingCall();
		mappingCall.setReferredMapping(mapping);
		mappingCall.getBinding().addAll(mappingCallBindings);
		return mappingCall;
	}

	public static @NonNull MappingCallBinding createMappingCallBinding(@NonNull VariableDeclaration variable, @NonNull OCLExpression value) {
		MappingCallBinding mappingCallBinding = QVTimperativeFactory.eINSTANCE.createMappingCallBinding();
		mappingCallBinding.setBoundVariable(variable);
		mappingCallBinding.setValue(value);
		return mappingCallBinding;
	}

	public static @NonNull MappingLoop createMappingLoop(@NonNull OCLExpression source, @NonNull LoopVariable iterator, @NonNull MappingStatement mappingStatement) {
		assert iterator.eContainer() == null;
		MappingLoop ml = QVTimperativeFactory.eINSTANCE.createMappingLoop();
		ml.setOwnedSource(source);
		ml.getOwnedIterators().add(iterator);
		ml.getOwnedMappingStatements().add(mappingStatement);
		return ml;
	}

	/*	public static @NonNull MappingSequence createMappingSequence(@NonNull List<@NonNull MappingStatement> mappingStatements) {
		MappingSequence mappingSequence = QVTimperativeFactory.eINSTANCE.createMappingSequence();
		mappingSequence.getMappingStatements().addAll(mappingStatements);
		return mappingSequence;
	} */

	/*	public static @NonNull OperationCallExp createOperationCallExp(@NonNull OCLExpression sourceExp, @NonNull Operation operation, OCLExpression... arguments) {
		OperationCallExp exp = PivotFactory.eINSTANCE.createOperationCallExp();
		exp.setOwnedSource(sourceExp);
		exp.setReferredOperation(operation);
		if (arguments != null) {
			for (OCLExpression argument : arguments) {
				List<OCLExpression> ownedArguments = exp.getOwnedArguments();
				ownedArguments.add(argument);
			}
		}
		// FIXME type
		return exp;
	} */

	public static @NonNull Property createProperty(@NonNull String name, @NonNull Type type, boolean isRequired) {
		Property property = PivotUtil.createProperty(name, type);
		property.setIsRequired(isRequired);
		return property;
	}

	/*	public static @NonNull PropertyCallExp createPropertyCallExp(@NonNull OCLExpression source, @NonNull Property property) {
		PropertyCallExp propertyCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
		propertyCallExp.setOwnedSource(source);
		propertyCallExp.setReferredProperty(property);
		propertyCallExp.setType(property.getType());
		return propertyCallExp;
	} */

	public static @NonNull NewStatement createNewStatement(@NonNull String name, @NonNull ImperativeTypedModel typedModel, @NonNull Type type) {
		NewStatement newStatement = QVTimperativeFactory.eINSTANCE.createNewStatement();
		newStatement.setName(name);
		newStatement.setReferredTypedModel(typedModel);
		newStatement.setType(type);
		newStatement.setIsRequired(true);
		return newStatement;
	}

	public static @NonNull SetStatement createSetStatement(@NonNull VariableDeclaration asVariable, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression, boolean isEmit) {
		SetStatement asSetAssignment = QVTimperativeFactory.eINSTANCE.createSetStatement();
		if (asProperty.isIsImplicit()) {
			asSetAssignment.setTargetProperty(asProperty.getOpposite());
			asSetAssignment.setIsOpposite(true);
		}
		else {
			asSetAssignment.setTargetProperty(asProperty);
			asSetAssignment.setIsOpposite(false);
		}
		asSetAssignment.setTargetVariable(asVariable);
		asSetAssignment.setValue(asValueExpression);
		asSetAssignment.setIsEmit(isEmit);
		return asSetAssignment;
	}

	public static @NonNull Transformation createTransformation(@NonNull String name) {
		Transformation transformation = QVTbaseFactory.eINSTANCE.createTransformation();
		transformation.setName(name);
		return transformation;
	}

	public static @NonNull ImperativeTypedModel createTypedModel(@NonNull String name) {
		ImperativeTypedModel typedModel = QVTimperativeFactory.eINSTANCE.createImperativeTypedModel();
		typedModel.setName(name);
		return typedModel;
	}

	public static @NonNull ImperativeDomain getArea(@NonNull Mapping mapping, @NonNull TypedModel typedModel) {
		for (Domain domain : mapping.getDomain()) {
			if (domain.getTypedModel() == typedModel) {
				return (ImperativeDomain)domain;
			}
		}
		throw new IllegalStateException();
		//		return mapping;
	}

	/*	public static @Nullable Area getContainingArea(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Area) {
				return (Area) eObject;
			}
		}
		return null;
	} */

	/*	public static @NonNull Variable createVariable(@NonNull String name, @NonNull Type type) {
		Variable bodyIt = PivotFactory.eINSTANCE.createVariable();
		bodyIt.setName(name);
		bodyIt.setType(type);
		return bodyIt;
	}

	public static @NonNull VariableExp createVariableExp(@NonNull Variable variable) {
		VariableExp variableExp = PivotFactory.eINSTANCE.createVariableExp();
		variableExp.setReferredVariable(variable);
		variableExp.setType(variable.getType());
		return variableExp;
	} */

	public static @Nullable Mapping getContainingMapping(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Mapping) {
				return (Mapping) eObject;
			}
		}
		return null;
	}

	public static @Nullable ImperativeDomain getDomain(@NonNull Mapping rule, @NonNull TypedModel typedModel) {
		return (ImperativeDomain)getDomain((Rule)rule, typedModel);
	}

	public static @NonNull Property getTargetProperty(@NonNull SetStatement asSetStatement) {
		Property referredProperty = ClassUtil.nonNullState(asSetStatement.getTargetProperty());
		return asSetStatement.isIsOpposite() ? ClassUtil.nonNullState(referredProperty.getOpposite()) : referredProperty;
	}

	public static @Nullable TypedModel getTypedModel(@Nullable Domain domain) {
		if (domain instanceof ImperativeDomain) {
			return ((ImperativeDomain)domain).getTypedModel();
		}
		else {
			return null;
		}
	}

	public static boolean isPrimitiveVariable(@NonNull VariableDeclaration asVariable) {
		Domain asArea = QVTimperativeUtil.getContainingDomain(asVariable);
		if (asArea != null) {
			return false;
		}
		if (!(asVariable.getType() instanceof CollectionType))  {
			return true;
		}
		return false;
	}

	public static @NonNull Transformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTiEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformation(ImperativeModel.class, environmentFactory, transformationURI, keepDebug);
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