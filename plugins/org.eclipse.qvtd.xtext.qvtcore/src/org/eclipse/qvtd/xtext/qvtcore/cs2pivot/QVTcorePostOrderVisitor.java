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
 *
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcorecst.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.PatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS;

public class QVTcorePostOrderVisitor extends AbstractQVTcorePostOrderVisitor
{

	public QVTcorePostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	protected void refreshConstraints(List<Assignment> assignments, List<Predicate> predicates, PatternCS csElement) {
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
					PropertyCallExp propertyCallExp = (PropertyCallExp)target;
					PropertyAssignment propertyAssignment = context.refreshModelElement(PropertyAssignment.class,
							QVTcorePackage.Literals.PROPERTY_ASSIGNMENT, csConstraint);
					if (propertyAssignment != null) {
						propertyAssignment.setSlotExpression(propertyCallExp.getSource());
						propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
						assignment = propertyAssignment;
					}
				}
				else if (target instanceof VariableExp) {
					VariableExp variableExp = (VariableExp)target;
					VariableAssignment variableAssignment = context.refreshModelElement(VariableAssignment.class,
							QVTcorePackage.Literals.VARIABLE_ASSIGNMENT, csConstraint);
					if (variableAssignment != null) {
						variableAssignment.setTargetVariable((Variable) variableExp.getReferredVariable());
						assignment = variableAssignment;
					}
				}
				else {
					// FIXME warning
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
					// FIXME warning
				}
				Predicate predicate = context.refreshModelElement(Predicate.class,
						QVTbasePackage.Literals.PREDICATE, csConstraint);
				if (predicate != null) {
					predicate.setConditionExpression(target);
					pPredicates.add(predicate);
				}
			}
		}
		if (assignments != null) {
			PivotUtil.refreshList(assignments, pAssignments);
		}
		PivotUtil.refreshList(predicates, pPredicates);
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
			refreshConstraints(pBottomPattern.getAssignment(), pBottomPattern.getPredicate(), csElement);
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
			refreshConstraints(null, pGuardPattern.getPredicate(), csElement);
		}
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCallBindingCS(@NonNull MappingCallBindingCS csElement) {
		MappingCallBinding pBinding = PivotUtil.getPivot(MappingCallBinding.class, csElement);
		if (pBinding != null) {
			ExpCS expression = csElement.getValue();
			if (expression != null) {
				OCLExpression target = context.visitLeft2Right(OCLExpression.class, expression);
				pBinding.setValue(target);
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
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS object) {
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