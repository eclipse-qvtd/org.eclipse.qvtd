/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

public class QVTcorePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTcoreVisitor<Object>
{
	public QVTcorePrettyPrintVisitor(@NonNull PrettyPrinter context) {
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
	public Object visitBottomVariable(@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public Object visitCoreDomain(@NonNull CoreDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitCoreModel(@NonNull CoreModel object) {
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
	public Object visitGuardVariable(@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public Object visitMapping(@NonNull Mapping pMapping) {
		Transformation pTransformation = pMapping.getTransformation();
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pTransformation);
		List<Mapping> asRefines = pMapping.getSpecification();
		if (asRefines.size() > 0) {
			context.append(" refines ");
			boolean isFirst = true;
			for (Mapping asRefine : asRefines) {
				if (!isFirst) {
					context.append(",");
				}
				context.appendName(asRefine);
				isFirst = false;
			}
		}
		Rule asOverridden = pMapping.getOverridden();
		if (asOverridden != null) {
			context.append(" overrides ");
			Transformation overriddenTransformation = QVTcoreUtil.getContainingTransformation(asOverridden);
			if (overriddenTransformation != pTransformation) {
				context.appendQualifiedType(overriddenTransformation);
				context.append("::");
			}
			context.appendName(asOverridden);
		}
		context.append(" {");
		context.push("", "");
		for (Domain pDomain : pMapping.getDomain()) {
			if (pDomain instanceof CoreDomain) {
				context.appendName(pDomain);
				doArea((CoreDomain)pDomain);
			}
		}
		context.append("where");
		doArea(pMapping);
		context.pop();
		return null;
	}

	@Override
	public Object visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		safeVisit(asNavigationAssignment.getSlotExpression());
		context.append(".");
		context.appendName(QVTcoreUtil.getTargetProperty(asNavigationAssignment));
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
