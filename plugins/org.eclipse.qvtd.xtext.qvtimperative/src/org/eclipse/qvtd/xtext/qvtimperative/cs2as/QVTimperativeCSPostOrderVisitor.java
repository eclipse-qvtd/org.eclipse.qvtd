/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.AbstractQVTimperativeCSPostOrderVisitor;

public class QVTimperativeCSPostOrderVisitor extends AbstractQVTimperativeCSPostOrderVisitor
{
	protected static class MappingCallBindingCSCompletion extends SingleContinuation<MappingCallBindingCS>
	{
		public MappingCallBindingCSCompletion(@NonNull CS2ASConversion context, @NonNull MappingCallBindingCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			MappingCallBinding pBinding = PivotUtil.getPivot(MappingCallBinding.class, csElement);
			if (pBinding != null) {
				ExpCS expression = csElement.getOwnedValue();
				if (expression != null) {
					OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
					pBinding.setValue(target);
				}
			}
			return null;
		}
	}

	public QVTimperativeCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	protected @Nullable Assignment refreshPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull PredicateOrAssignmentCS csConstraint) {
		@Nullable PropertyAssignment propertyAssignment;
//		Property referredProperty = propertyCallExp.getReferredProperty();
//		Property oppositeProperty = referredProperty.getOpposite();
//		if ((oppositeProperty != null) && oppositeProperty.isIsImplicit()) {
//			propertyAssignment = PivotUtil.getPivot(OppositePropertyAssignment.class, csConstraint);
//		}
//		else {
			propertyAssignment = PivotUtil.getPivot(PropertyAssignment.class, csConstraint);
//		}
		if (propertyAssignment != null) {
			propertyAssignment.setSlotExpression(propertyCallExp.getOwnedSource());
			propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
		}
		return propertyAssignment;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		Mapping asMapping = PivotUtil.getPivot(Mapping.class, csElement);
		if (asMapping != null) {
			List<VariablePredicate> asVariablePredicates = null;
			for (DomainCS csDomain : csElement.getOwnedDomains()) {
				GuardPatternCS csGuardPattern = csDomain.getOwnedGuardPattern();
				for (UnrealizedVariableCS csVariable : csGuardPattern.getOwnedUnrealizedVariables()) {
					Variable asVariable = PivotUtil.getPivot(Variable.class, csVariable);
					if (asVariable != null) {
						ExpCS csGuardExpression = csVariable.getOwnedInitExpression();
						if (csGuardExpression != null) {
							OCLExpression asExpression = context.visitLeft2Right(OCLExpression.class, csGuardExpression);
							if (asExpression != null) {
								VariablePredicate asVariablePredicate = QVTimperativeFactory.eINSTANCE.createVariablePredicate();
								asVariablePredicate.setTargetVariable(asVariable);
								asVariablePredicate.setConditionExpression(asExpression);
								if (asVariablePredicates == null) {
									asVariablePredicates = new ArrayList<VariablePredicate>();
								}
								asVariablePredicates.add(asVariablePredicate);
							}
						}
					}
				}
			}
			if (asVariablePredicates != null) {
				List<Predicate> asPredicates = asMapping.getGuardPattern().getPredicate();
				List<VariablePredicate> asSortedPredicates = QVTimperativeUtil.sortVariablePredicates(asMapping, asVariablePredicates);
				int j = 0;
				for (VariablePredicate asVariablePredicate : asSortedPredicates) {
					asPredicates.add(j++, asVariablePredicate);
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		return new MappingCallBindingCSCompletion(context, csElement);		// Must wait till MappingLoop iterators initialized
	}

	@Override
	public Continuation<?> visitMappingLoopCS(@NonNull MappingLoopCS csElement) {
		MappingLoop pMappingLoop = PivotUtil.getPivot(MappingLoop.class, csElement);
		if (pMappingLoop != null) {
			ExpCS expression = csElement.getOwnedInExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				if (target != null) {
					pMappingLoop.setOwnedSource(target);
					List<Variable> iterators = pMappingLoop.getOwnedIterators();
					if (iterators.size() > 0) {
						Variable iterator = iterators.get(0);
						if (iterator.getType() == null) {
							Type type = target.getType();
							if (type instanceof CollectionType) {
								type = ((CollectionType)type).getElementType();
							}
							iterator.setType(type);
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		Predicate asPredicate = PivotUtil.getPivot(Predicate.class, csElement);
		if (asPredicate != null) {
			OCLExpression asCondition = null;
			ExpCS csCondition = csElement.getOwnedCondition();
			if (csCondition != null) {
				asCondition = context.visitLeft2Right(OCLExpression.class, csCondition);
			}
			asPredicate.setConditionExpression(asCondition);
		}
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
		return null;
	}
	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		if (csElement.eContainer() instanceof GuardPatternCS) {
			return null;		// 'initExpression' is a guardExpression resolved by MappingCS
		}
		return super.visitUnrealizedVariableCS(csElement);
	}
}
