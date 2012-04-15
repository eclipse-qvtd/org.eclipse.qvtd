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

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.xtext.qvtcorecst.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ConstraintCS;
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
import org.eclipse.qvtd.xtext.qvtcorecst.util.AbstractExtendingDelegatingQVTcoreCSVisitor;

public class QVTcorePostOrderVisitor
	extends AbstractExtendingDelegatingQVTcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{
	public QVTcorePostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitAreaCS(AreaCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(BottomPatternCS csElement) {
		BottomPattern pBottomPattern = PivotUtil.getPivot(BottomPattern.class, csElement);
		List<Assignment> pAssignments = new ArrayList<Assignment>(); 
		List<Predicate> pPredicates = new ArrayList<Predicate>(); 
		for (ConstraintCS csConstraint : csElement.getConstraints()) {
			boolean isDefault = csConstraint.isDefault();
			ExpCS initialiser = csConstraint.getInitialiser();
			if (initialiser != null) {
				Assignment pAssignment = context.refreshModelElement(Assignment.class,
						QVTcorePackage.Literals.ASSIGNMENT, csConstraint);
				pAssignment.setIsDefault(isDefault);
				pAssignments.add(pAssignment);
			}
			else {
				if (isDefault) {
					// FIXME warning
				}
				Predicate pPredicate = context.refreshModelElement(Predicate.class,
						QVTbasePackage.Literals.PREDICATE, csConstraint);
				pPredicates.add(pPredicate);
			}
		}
		PivotUtil.refreshList(pBottomPattern.getAssignment(), pAssignments);
		PivotUtil.refreshList(pBottomPattern.getPredicate(), pPredicates);
		context.refreshPivotList(Variable.class, pBottomPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(RealizedVariable.class, pBottomPattern.getRealizedVariable(), csElement.getRealizedVariables());
		context.refreshPivotList(EnforcementOperation.class, pBottomPattern.getEnforcementOperation(), csElement.getEnforcementOperations());
		return null;
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
		List<Predicate> pPredicates = new ArrayList<Predicate>(); 
		for (ConstraintCS csConstraint : csElement.getConstraints()) {
			boolean isDefault = csConstraint.isDefault();
			ExpCS initialiser = csConstraint.getInitialiser();
			if (initialiser != null) {
				// FIXME warning
			}
			else {
				if (isDefault) {
					// FIXME warning
				}
				Predicate pPredicate = context.refreshModelElement(Predicate.class,
						QVTbasePackage.Literals.PREDICATE, csConstraint);
				pPredicates.add(pPredicate);
			}
		}
		PivotUtil.refreshList(pGuardPattern.getPredicate(), pPredicates);
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getUnrealizedVariables());
		context.refreshPivotList(Variable.class, pGuardPattern.getVariable(), csElement.getUnrealizedVariables());
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(MappingCS csElement) {
		Mapping pMapping = PivotUtil.getPivot(Mapping.class, csElement);
//		context.refreshPivotList(Mapping.class, pMapping.getRefinement(), csElement.getRefines());
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
		context.refreshPivotList(FunctionParameter.class, pFunction.getOwnedParameter(), csElement.getInputParamDeclaration());
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