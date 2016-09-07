/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtimperativecs.AreaCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ConnectionStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeRealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PatternCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.UnrealizedVariableCS;
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

	protected @Nullable Assignment refreshPropertyAssignment(@NonNull NavigationCallExp propertyCallExp, @NonNull PredicateOrAssignmentCS csConstraint) {
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
			propertyAssignment.setTargetProperty(PivotUtil.getReferredProperty(propertyCallExp));
			//			propertyAssignment.setIsOpposite(target instanceof FeatureCallExp);		// FIXME isOpposite
		}
		return propertyAssignment;
	}

	protected @Nullable Assignment refreshVariableAssignment(@NonNull VariableExp variableExp, @NonNull PredicateOrAssignmentCS csConstraint) {
		Assignment assignment = PivotUtil.getPivot(Assignment.class, csConstraint);
		if (assignment instanceof ConnectionAssignment) {
			((ConnectionAssignment)assignment).setTargetVariable((ConnectionVariable) variableExp.getReferredVariable());
			return assignment;
		}
		else {
			VariableAssignment variableAssignment = PivotUtil.getPivot(VariableAssignment.class, csConstraint);
			if (variableAssignment != null) {
				variableAssignment.setTargetVariable((Variable) variableExp.getReferredVariable());
			}
			return variableAssignment;
		}
	}

	@Override
	public Continuation<?> visitAreaCS(@NonNull AreaCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement);
		if (pBottomPattern != null) {
			List<Assignment> pAssignments = new ArrayList<Assignment>();
			List<Predicate> pPredicates = new ArrayList<Predicate>();
			for (PredicateOrAssignmentCS csConstraint : csElement.getOwnedConstraints()) {
				ExpCS csTarget = csConstraint.getOwnedTarget();
				ExpCS csInitialiser = csConstraint.getOwnedInitExpression();
				boolean isDefault = csConstraint.isIsDefault();
				OCLExpression target = csTarget != null ? context.visitLeft2Right(OCLExpression.class, csTarget) : null;
				if (csInitialiser != null) {
					Assignment assignment = null;
					if (target instanceof NavigationCallExp) {
						assignment = refreshPropertyAssignment((NavigationCallExp)target, csConstraint);
					}
					else if (target instanceof VariableExp) {
						assignment = refreshVariableAssignment((VariableExp)target, csConstraint);
					}
					else if (target != null) {
						context.addDiagnostic(csElement, "unrecognised Constraint target " + target.eClass().getName());
					}
					if (assignment != null) {
						OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
						assignment.setIsDefault(isDefault);
						assignment.setValue(initialiser);
						pAssignments.add(assignment);
					}
				}
				else {
					if (isDefault) {
						context.addDiagnostic(csElement, "misplaced default ignored");
					}
					Predicate predicate = PivotUtil.getPivot(Predicate.class, csConstraint);
					if (predicate != null) {
						predicate.setConditionExpression(target);
						pPredicates.add(predicate);
					}
				}
			}
			PivotUtilInternal.refreshList(pBottomPattern.getAssignment(), pAssignments);
			PivotUtilInternal.refreshList(pBottomPattern.getPredicate(), pPredicates);
		}
		return null;
	}

	@Override
	public @Nullable Continuation<?> visitConnectionStatementCS(@NonNull ConnectionStatementCS csElement) {
		ConnectionStatement asConnectionStatement = PivotUtil.getPivot(ConnectionStatement.class, csElement);
		if (asConnectionStatement != null) {
			asConnectionStatement.setTargetVariable((ConnectionVariable) csElement.getTargetVariable());
			ExpCS csInitialiser = csElement.getOwnedExpression();
			if (csInitialiser != null) {
				OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
				asConnectionStatement.setValue(initialiser);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(@NonNull ConstraintCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		GuardPattern asGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement);
		if (asGuardPattern != null) {
			context.refreshList(Predicate.class, ClassUtil.nullFree(asGuardPattern.getPredicate()), csElement.getOwnedPredicates());
		}
		return null;
	}

	@Override
	public Continuation<?> visitImperativeRealizedVariableCS(@NonNull ImperativeRealizedVariableCS csElement) {
		RealizedVariable asRealizedVariable = PivotUtil.getPivot(RealizedVariable.class, csElement);
		if (asRealizedVariable != null) {
			ExpCS expression = csElement.getOwnedInitExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asRealizedVariable.setOwnedInit(target);
			}
		}
		return null;
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
			ExpCS expression = csElement.getOwnedKeyExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asMapping.setOwnedKeyExpression(target);
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
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPatternCS(@NonNull PatternCS object) {
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
	public Continuation<?> visitPredicateOrAssignmentCS(@NonNull PredicateOrAssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Function pFunction = PivotUtil.getPivot(Function.class, csElement);
		if (pFunction != null) {
			ExpCS expression = csElement.getOwnedExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				pFunction.setQueryExpression(target);
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitRealizeableVariableCS(@NonNull RealizeableVariableCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(@NonNull RealizedVariableCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
		if (csElement.eContainer() instanceof GuardPatternCS) {
			return null;		// 'initExpression' is a guardExpression resolved by MappingCS
		}
		Variable asVariable = PivotUtil.getPivot(Variable.class, csElement);
		if (asVariable != null) {
			ExpCS expression = csElement.getOwnedInitExpression();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				asVariable.setOwnedInit(target);
			}
		}
		return null;
	}
}
