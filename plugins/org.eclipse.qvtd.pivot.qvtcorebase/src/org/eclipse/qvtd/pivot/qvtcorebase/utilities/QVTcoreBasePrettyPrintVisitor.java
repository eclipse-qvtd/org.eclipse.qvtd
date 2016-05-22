/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;

public abstract class QVTcoreBasePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTcoreBaseVisitor<Object>
{	
	public QVTcoreBasePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	protected void doArea(@NonNull Area pArea) {
		context.append(" (");
		safeVisit(pArea.getGuardPattern());
		context.append(")\n{");
		safeVisit(pArea.getBottomPattern());
		context.append("}\n");
	}

	@Override
	public Object visitAssignment(@NonNull Assignment object) {
		return null;
	}

	@Override
	public Object visitBottomPattern(@NonNull BottomPattern pBottomPattern) {
		for (RealizedVariable pRealizedVariable : pBottomPattern.getRealizedVariable()) {
			safeVisit(pRealizedVariable);
		}
		for (Variable pVariable : pBottomPattern.getVariable()) {
			safeVisit(pVariable);
		}
		context.append(" |");
		List<Predicate> predicates = pBottomPattern.getPredicate();
		if (predicates.size() > 0) {
			context.append("\n");
			for (Predicate pPredicate : predicates) {
				safeVisit(pPredicate);
			}
		}
		List<Assignment> assignments = pBottomPattern.getAssignment();
		if (assignments.size() > 0) {
			context.append("\n");
			for (Assignment pAssignment : assignments) {
				safeVisit(pAssignment);
			}
		}
		return null;
	}

	@Override
	public Object visitCoreDomain(@NonNull CoreDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCorePattern(@NonNull CorePattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitGuardPattern(@NonNull GuardPattern pGuardPattern) {
		for (Variable pVariable : pGuardPattern.getVariable()) {
			safeVisit(pVariable);
		}
		context.append(" |");
		List<Predicate> predicates = pGuardPattern.getPredicate();
		if (predicates.size() > 0) {
			context.append("\n");
			for (Predicate pPredicate : predicates) {
				safeVisit(pPredicate);
			}
		}
		return null;
	}

	@Override
	public Object visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		safeVisit(asNavigationAssignment.getSlotExpression());
		context.append(".");
		context.appendName(QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment));
		context.append(" := ");
		safeVisit(asNavigationAssignment.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public Object visitPredicate(@NonNull Predicate pPredicate) {
		safeVisit(pPredicate.getConditionExpression());
		return null;
	}

	@Override
	public Object visitPropertyAssignment(@NonNull PropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public Object visitRealizedVariable(@NonNull RealizedVariable pRealizedVariable) {
		context.append("realize ");
		visitVariable(pRealizedVariable);
		return null;
	}

	@Override
	public Object visitVariableAssignment(@NonNull VariableAssignment pVariableAssignment) {
		context.appendName(pVariableAssignment.getTargetVariable());
		context.append(" := ");
		safeVisit(pVariableAssignment.getValue());
		context.append(";\n");
		return null;
	}
}
