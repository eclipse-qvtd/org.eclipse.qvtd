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

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtcorecst.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
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
	public class BottomPatternCompletion extends SingleContinuation<BottomPatternCS>
	{
		public BottomPatternCompletion(CS2PivotConversion context, BottomPatternCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement);
			refreshConstraints(pBottomPattern.getAssignment(), pBottomPattern.getPredicate(), csElement);
			return null;
		}
	}

	public class GuardPatternCompletion extends SingleContinuation<GuardPatternCS>
	{
		public GuardPatternCompletion(CS2PivotConversion context, GuardPatternCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement);
			refreshConstraints(null, pGuardPattern.getPredicate(), csElement);
			return null;
		}
	}

	public QVTcorePostOrderVisitor(CS2PivotConversion context) {
		super(context);
	}

	protected void refreshConstraints(List<Assignment> assignments, List<Predicate> predicates, PatternCS csElement) {
		List<Assignment> pAssignments = new ArrayList<Assignment>(); 
		List<Predicate> pPredicates = new ArrayList<Predicate>(); 
		for (AssignmentCS csConstraint : csElement.getConstraints()) {
			ExpCS csTarget = csConstraint.getTarget();
			ExpCS csInitialiser = csConstraint.getInitialiser();
			boolean isDefault = csConstraint.isDefault();
			OCLExpression target = context.visitLeft2Right(OCLExpression.class, csTarget);
			if (csInitialiser != null) {
				Assignment assignment = null;
				if (target instanceof PropertyCallExp) {
					PropertyCallExp propertyCallExp = (PropertyCallExp)target;
					PropertyAssignment propertyAssignment = context.refreshModelElement(PropertyAssignment.class,
							QVTcorePackage.Literals.PROPERTY_ASSIGNMENT, csConstraint);
					propertyAssignment.setSlotExpression(propertyCallExp.getSource());
					propertyAssignment.setTargetProperty(propertyCallExp.getReferredProperty());
					assignment = propertyAssignment;
				}
				else if (target instanceof VariableExp) {
					VariableExp variableExp = (VariableExp)target;
					VariableAssignment variableAssignment = context.refreshModelElement(VariableAssignment.class,
							QVTcorePackage.Literals.VARIABLE_ASSIGNMENT, csConstraint);
					variableAssignment.setTargetVariable((Variable) variableExp.getReferredVariable());
					assignment = variableAssignment;
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
				predicate.setConditionExpression(target);
				pPredicates.add(predicate);
			}
		}
		if (assignments != null) {
			PivotUtil.refreshList(assignments, pAssignments);
		}
		PivotUtil.refreshList(predicates, pPredicates);
	}

	@Override
	public Continuation<?> visitAreaCS(AreaCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitAssignmentCS(AssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(BottomPatternCS csElement) {
		BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement);
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getRealizedVariables());
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(EnforcementOperation.class, pBottomPattern.getEnforcementOperation(), csElement.getEnforcementOperations());
		return new BottomPatternCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitConstraintCS(ConstraintCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(DirectionCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(EnforcementOperationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(GuardPatternCS csElement) {
		GuardPattern pGuardPattern = PivotUtil.getPivot(GuardPattern.class, csElement);
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getUnrealizedVariables());
		return new GuardPatternCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitMappingCS(MappingCS csElement) {
		Mapping pMapping = PivotUtil.getPivot(Mapping.class, csElement);
		PivotUtil.refreshList(pMapping.getRefinement(), csElement.getRefines());
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(ParamDeclarationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitPatternCS(PatternCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(QueryCS csElement) {
		Function pFunction = PivotUtil.getPivot(Function.class, csElement);
		OCLExpression target = context.visitLeft2Right(OCLExpression.class, csElement.getExpression());
		pFunction.setQueryExpression(target);
		return null;
	}

	@Override
	public Continuation<?> visitRealizeableVariableCS(RealizeableVariableCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(RealizedVariableCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(TopLevelCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(TransformationCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(UnrealizedVariableCS object) {
		return null;
	}
}