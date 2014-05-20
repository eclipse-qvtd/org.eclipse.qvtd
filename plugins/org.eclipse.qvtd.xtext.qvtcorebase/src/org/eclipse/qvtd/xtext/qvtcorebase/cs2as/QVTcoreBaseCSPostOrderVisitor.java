/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.AbstractQVTcoreBaseCSPostOrderVisitor;

public class QVTcoreBaseCSPostOrderVisitor extends AbstractQVTcoreBaseCSPostOrderVisitor
{
	public QVTcoreBaseCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	protected @Nullable Assignment refreshPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull AssignmentCS csConstraint) {
		@NonNull PropertyAssignment propertyAssignment = context.refreshModelElement(PropertyAssignment.class,
			QVTcoreBasePackage.Literals.PROPERTY_ASSIGNMENT, csConstraint);
		propertyAssignment.setSlotExpression(propertyCallExp.getSource());
		propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
		return propertyAssignment;
	}

	protected @Nullable Assignment refreshVariableAssignment(@NonNull VariableExp variableExp, @NonNull AssignmentCS csConstraint) {
		@NonNull VariableAssignment variableAssignment = context.refreshModelElement(VariableAssignment.class,
			QVTcoreBasePackage.Literals.VARIABLE_ASSIGNMENT, csConstraint);
		variableAssignment.setTargetVariable((Variable) variableExp.getReferredVariable());
		return variableAssignment;
	}

	@Override
	public Continuation<?> visitAreaCS(@NonNull AreaCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement);
		if (pBottomPattern != null) {
			List<Assignment> pAssignments = new ArrayList<Assignment>(); 
			List<Predicate> pPredicates = new ArrayList<Predicate>(); 
			for (AssignmentCS csConstraint : csElement.getConstraints()) {
				ExpCS csTarget = csConstraint.getTarget();
				ExpCS csInitialiser = csConstraint.getInitialiser();
				boolean isDefault = csConstraint.isDefault();
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
					@NonNull Predicate predicate = context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csConstraint);
					predicate.setConditionExpression(target);
					pPredicates.add(predicate);
				}
			}
			PivotUtil.refreshList(pBottomPattern.getAssignment(), pAssignments);
			PivotUtil.refreshList(pBottomPattern.getPredicate(), pPredicates);
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
		GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement);
		if (pGuardPattern != null) {
			List<Predicate> pPredicates = new ArrayList<Predicate>(); 
			for (AssignmentCS csConstraint : csElement.getConstraints()) {
				ExpCS csTarget = csConstraint.getTarget();
				ExpCS csInitialiser = csConstraint.getInitialiser();
				OCLExpression target = csTarget != null ? context.visitLeft2Right(OCLExpression.class, csTarget) : null;
				if (csInitialiser != null) {
					if (target instanceof VariableExp) {
						Variable variable = (Variable) ((VariableExp)target).getReferredVariable();
						OCLExpression initialiser = context.visitLeft2Right(OCLExpression.class, csInitialiser);
						variable.setInitExpression(initialiser);
					}
					else if (target != null) {
						context.addDiagnostic(csElement, "unrecognised Guard Constraint target " + target.eClass().getName());
					}
				}
				else {
					@NonNull Predicate predicate = context.refreshModelElement(Predicate.class, QVTbasePackage.Literals.PREDICATE, csConstraint);
					predicate.setConditionExpression(target);
					pPredicates.add(predicate);
				}
				if (csConstraint.isDefault()) {
					context.addDiagnostic(csElement, "misplaced default ignored");
				}
			}
			PivotUtil.refreshList(pGuardPattern.getPredicate(), pPredicates);
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
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Function pFunction = PivotUtil.getPivot(Function.class, csElement);
		if (pFunction != null) {
			ExpCS expression = csElement.getExpression();
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
	public Continuation<?> visitUnrealizedVariableCS(@NonNull UnrealizedVariableCS object) {
		return null;
	}
}