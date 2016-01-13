/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

public class QVTimperativeUtil extends QVTcoreBaseUtil
{
    /** The name of the root mapping */
	public static final @NonNull String ROOT_MAPPING_NAME = "__root__";
	public static final @NonNull String MIDDLE_DOMAIN_NAME = "middle";

	public static final class MappingCallBindingComparator implements Comparator<MappingCallBinding>
	{
		public static final @NonNull MappingCallBindingComparator INSTANCE = new MappingCallBindingComparator();

		@Override
		public int compare(MappingCallBinding o1, MappingCallBinding o2) {
			Variable v1 = o1.getBoundVariable();
			Variable v2 = o2.getBoundVariable();
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	/**
	 * Return a MappingStatement comprising the concatenation of mappingStatementOrStatements and mappingStatement.
	 * mappingStatementOrStatements may be null, a MappingStatement or a composite MappingSequence.
	 */
	public static @NonNull MappingStatement addMappingStatement(@Nullable MappingStatement mappingStatementOrStatements, @NonNull MappingStatement mappingStatement) {
		if (mappingStatementOrStatements == null) {
			return mappingStatement;
		}
		else if (mappingStatementOrStatements instanceof MappingSequence){
			((MappingSequence)mappingStatementOrStatements).getMappingStatements().add(mappingStatement);
			return mappingStatementOrStatements;
		}
		else  {
			@SuppressWarnings("null")@NonNull MappingSequence mappingSequence = QVTimperativeFactory.eINSTANCE.createMappingSequence();
			List<MappingStatement> mappingStatements = mappingSequence.getMappingStatements();
			mappingStatements.add(mappingStatementOrStatements);
			mappingStatements.add(mappingStatement);
			return mappingSequence;
		}
	}

	public static @NonNull ImperativeDomain createImperativeDomain(@NonNull TypedModel typedModel) {
		ImperativeDomain coreDomain = QVTimperativeFactory.eINSTANCE.createImperativeDomain();
		coreDomain.setName(typedModel.getName());
		coreDomain.setTypedModel(typedModel);
		coreDomain.setBottomPattern(QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern());
		coreDomain.setGuardPattern(QVTcoreBaseFactory.eINSTANCE.createGuardPattern());
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
		mapping.setBottomPattern(QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern());
		mapping.setGuardPattern(QVTcoreBaseFactory.eINSTANCE.createGuardPattern());
		return mapping;
	}

	public static @NonNull MappingCall createMappingCall(@NonNull Mapping mapping, @NonNull List<MappingCallBinding> mappingCallBindings) {
		MappingCall mappingCall = QVTimperativeFactory.eINSTANCE.createMappingCall();
		mappingCall.setReferredMapping(mapping);
		mappingCall.getBinding().addAll(mappingCallBindings);
		return mappingCall;
	}

	public static @NonNull MappingCallBinding createMappingCallBinding(@NonNull Variable variable, @NonNull OCLExpression value) {
		MappingCallBinding mappingCallBinding = QVTimperativeFactory.eINSTANCE.createMappingCallBinding();
		mappingCallBinding.setBoundVariable(variable);
		mappingCallBinding.setValue(value);
		return mappingCallBinding;
	}

	public static @NonNull MappingLoop createMappingLoop(@NonNull OCLExpression source, @NonNull Variable iterator, @NonNull MappingStatement mappingStatement) {
		assert iterator.eContainer() == null;
		MappingLoop ml = QVTimperativeFactory.eINSTANCE.createMappingLoop();
		ml.setOwnedSource(source);
		ml.getOwnedIterators().add(iterator);
		ml.setOwnedBody(mappingStatement);
		return ml;
	}

	public static @NonNull MappingSequence createMappingSequence(@NonNull List<MappingStatement> mappingStatements) {
		MappingSequence mappingSequence = QVTimperativeFactory.eINSTANCE.createMappingSequence();
		mappingSequence.getMappingStatements().addAll(mappingStatements);
		return mappingSequence;
	}

	public static @NonNull MappingSequence zzcreateMappingSequence(MappingStatement... mappingStatements)  {
		@SuppressWarnings("null")@NonNull MappingSequence mappingSequence = QVTimperativeFactory.eINSTANCE.createMappingSequence();
		if (mappingStatements != null) {
			for (@SuppressWarnings("null")@NonNull MappingStatement mappingStatement : mappingStatements) {
				mappingSequence.getMappingStatements().add(mappingStatement);
			}
		}
		return mappingSequence;
	}

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

	public static @NonNull PropertyAssignment createPropertyAssignment(@NonNull OCLExpression slotExpression, @NonNull Property targetProperty, @NonNull OCLExpression value) {
		PropertyAssignment propertyAssignment = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
		propertyAssignment.setSlotExpression(slotExpression);
		propertyAssignment.setTargetProperty(targetProperty);
		propertyAssignment.setValue(value);
		return propertyAssignment;
	}

/*	public static @NonNull PropertyCallExp createPropertyCallExp(@NonNull OCLExpression source, @NonNull Property property) {
		PropertyCallExp propertyCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
		propertyCallExp.setOwnedSource(source);
		propertyCallExp.setReferredProperty(property);
		propertyCallExp.setType(property.getType());
		return propertyCallExp;
	} */

	public static RealizedVariable createRealizedVariable(@NonNull String name, @NonNull Type type) {
		RealizedVariable realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		realizedVariable.setName(name);
		realizedVariable.setType(type);
		realizedVariable.setIsRequired(true);
		return realizedVariable;
	}

	public static @NonNull Transformation createTransformation(@NonNull String name) {
		Transformation transformation = QVTbaseFactory.eINSTANCE.createTransformation();
		transformation.setName(name);
		return transformation;
	}

	public static @NonNull TypedModel createTypedModel(@NonNull String name) {
		TypedModel typedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
		typedModel.setName(name);
		return typedModel;
	}

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

	public static boolean isConnectionAccumulator(@NonNull Variable asVariable) {
		OCLExpression ownedInit = asVariable.getOwnedInit();
		if (!(ownedInit instanceof VariableExp) && !(ownedInit instanceof CollectionLiteralExp)) {
			return false;
		}
		Mapping asMapping = getContainingMapping(asVariable);
		assert asMapping != null;
		return isConnectionAccumulator(asVariable, asMapping.getMappingStatement());
	}
	private static boolean isConnectionAccumulator(@NonNull VariableDeclaration asVariable, MappingStatement mappingStatement) {
		if (mappingStatement instanceof MappingCall) {
			for (MappingCallBinding asBinding : ((MappingCall)mappingStatement).getBinding()) {
				if ((asBinding.getValue() instanceof VariableExp) && (((VariableExp)asBinding.getValue()).getReferredVariable() == asVariable)) {
					Variable boundVariable = asBinding.getBoundVariable();
					assert boundVariable != null;
					if (isConnectionVariable(boundVariable)) {
						return true;
					}
				}
			}
		}
		else if (mappingStatement instanceof MappingSequence) {
			for (MappingStatement childStatement : ((MappingSequence)mappingStatement).getMappingStatements()) {
				if (isConnectionAccumulator(asVariable, childStatement)) {
					return true;
				}
			}
		}
		else if (mappingStatement instanceof MappingLoop) {
			OCLExpression mappingBody = ((MappingLoop)mappingStatement).getOwnedBody();
			if ((mappingBody instanceof MappingStatement) && isConnectionAccumulator(asVariable, (MappingStatement) mappingBody)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isConnectionVariable(@NonNull Variable asVariable) {
		Area asArea = QVTimperativeUtil.getContainingArea(asVariable);
		if ((asArea instanceof Mapping) && (asVariable.getType() instanceof CollectionType))  {
			return true;
		}
		return false;
	}

	public static boolean isPrimitiveVariable(@NonNull Variable asVariable) {
		Area asArea = QVTimperativeUtil.getContainingArea(asVariable);
		if ((asArea instanceof Mapping) && !(asVariable.getType() instanceof CollectionType))  {
			return true;
		}
		return false;
	}

	/**
	 * Return a copy of asVariablePredicates sorted to avoid reverse references from the predicate expressions.
	 */
	public static @NonNull List<VariablePredicate> sortVariablePredicates(@NonNull Mapping asMapping, @NonNull List<VariablePredicate> asVariablePredicates) {
		Set<Variable> asGuardVariables = new HashSet<Variable>();
		asGuardVariables.addAll(asMapping.getGuardPattern().getVariable());
		for (Domain asDomain : asMapping.getDomain()) {
			asGuardVariables.addAll(((CoreDomain)asDomain).getGuardPattern().getVariable());
		}
		List<VariableDeclaration> pendingVariables = new ArrayList<VariableDeclaration>();
		Map<VariableDeclaration, VariablePredicate> variable2predicate = new HashMap<VariableDeclaration, VariablePredicate>();
		Map<VariableDeclaration, Set<VariablePredicate>> variable2predicates = new HashMap<VariableDeclaration, Set<VariablePredicate>>();
		Map<VariablePredicate, @NonNull Set<VariableDeclaration>> predicate2variables = new HashMap<VariablePredicate, @NonNull Set<VariableDeclaration>>();
		for (VariablePredicate asVariablePredicate : asVariablePredicates) {
			for (TreeIterator<EObject> tit = asVariablePredicate.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					VariableDeclaration asVariable = ((VariableExp)eObject).getReferredVariable();
					if ((asVariable != null) && asGuardVariables.contains(asVariable)) {
						Set<VariablePredicate> predicates = variable2predicates.get(asVariable);
						if (predicates == null){
							predicates = new HashSet<VariablePredicate>();
							variable2predicates.put(asVariable, predicates);
						}
						predicates.add(asVariablePredicate);
						Set<VariableDeclaration> variables = predicate2variables.get(asVariablePredicate);
						if (variables == null){
							variables = new HashSet<VariableDeclaration>();
							predicate2variables.put(asVariablePredicate, variables);
						}
						variables.add(asVariable);
						pendingVariables.add(asVariablePredicate.getTargetVariable());
						variable2predicate.put(asVariablePredicate.getTargetVariable(), asVariablePredicate);
					}
				}
			}
		}
		int oldSize;
		List<VariablePredicate> asSortedVariablePredicates = new ArrayList<VariablePredicate>();
		Collections.sort(pendingVariables, NameUtil.NAMEABLE_COMPARATOR);		// Ensure deterministic order
		while (pendingVariables.size() > 0) {
			oldSize = asSortedVariablePredicates.size();
			for (VariableDeclaration asVariable : pendingVariables) {
				VariablePredicate asVariablePredicate1 = variable2predicate.get(asVariable);
				Set<VariableDeclaration> variables = predicate2variables.get(asVariablePredicate1);
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
	}
}