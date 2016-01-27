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
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.AbstractQVTcoreBaseCSPostOrderVisitor;

public class QVTcoreBaseCSPostOrderVisitor extends AbstractQVTcoreBaseCSPostOrderVisitor
{
	public QVTcoreBaseCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	protected @Nullable Assignment refreshPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull PredicateOrAssignmentCS csConstraint) {
		PropertyAssignment propertyAssignment = PivotUtil.getPivot(PropertyAssignment.class, csConstraint);
		if (propertyAssignment != null) {
			propertyAssignment.setSlotExpression(propertyCallExp.getOwnedSource());
			propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
		}
		return propertyAssignment;
	}

	protected @Nullable Assignment refreshVariableAssignment(@NonNull VariableExp variableExp, @NonNull PredicateOrAssignmentCS csConstraint) {
		VariableAssignment variableAssignment = PivotUtil.getPivot(VariableAssignment.class, csConstraint);
		if (variableAssignment != null) {
			variableAssignment.setTargetVariable((Variable) variableExp.getReferredVariable());
		}
		return variableAssignment;
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
					if (target instanceof PropertyCallExp) {
						assignment = refreshPropertyAssignment((PropertyCallExp)target, csConstraint);
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
	public Continuation<?> visitEnforcementOperationCS(@NonNull EnforcementOperationCS object) {
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
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS csElement) {
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