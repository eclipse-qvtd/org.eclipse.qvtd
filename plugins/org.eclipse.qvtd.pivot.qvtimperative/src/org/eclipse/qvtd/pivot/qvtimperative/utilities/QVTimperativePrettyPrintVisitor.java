/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public class QVTimperativePrettyPrintVisitor extends QVTcoreBasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{	
	public QVTimperativePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	private void doArea(Area pArea) {
		context.append(" (");
		safeVisit(pArea.getGuardPattern());
		context.append(")\n{");
		safeVisit(pArea.getBottomPattern());
		context.append("}\n");
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
	public Object visitConnectionAssignment(@NonNull ConnectionAssignment asConnectionAssignment) {
		context.appendName(asConnectionAssignment.getTargetVariable());
		context.append(" += ");
		safeVisit(asConnectionAssignment.getValue());
		context.append(";\n");
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
	public Object visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable Object visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitMapping(@NonNull Mapping pMapping) {
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pMapping.getTransformation());
		context.append(" {\n");
		context.push("", "");
		for (Domain pDomain : pMapping.getDomain()) {
			if (pDomain instanceof CoreDomain) {
				context.appendName(pDomain);
				doArea((CoreDomain)pDomain);
			}
		}
		context.append("where");
		doArea(pMapping);
		safeVisit(pMapping.getMappingStatement());
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingCall(@NonNull MappingCall pMappingCall) {
		if (pMappingCall.isIsInfinite()) {
			context.append("infinite ");
		}
		context.append("map ");
		context.appendName(pMappingCall.getReferredMapping());
		context.append(" {\n");
		context.push("", "");
		for (MappingCallBinding mappingCallBinding : pMappingCall.getBinding()) {
			safeVisit(mappingCallBinding);
		}
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingCallBinding(@NonNull MappingCallBinding pMappingCallBinding) {
		context.appendName(pMappingCallBinding.getBoundVariable());
		context.append(pMappingCallBinding.isIsPolled() ? " ?= " : " := ");
		safeVisit(pMappingCallBinding.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitMappingLoop(@NonNull MappingLoop pMappingLoop) {
		context.append("for ");
		context.appendElement(pMappingLoop.getOwnedIterators().get(0));
		context.append(" in ");
		context.appendElement(pMappingLoop.getOwnedSource());
		context.append(" {\n");
		context.push("", "");
		safeVisit(pMappingLoop.getOwnedBody());
		context.append("}");
		context.pop();
		return null;
	}

	@Override
	public Object visitMappingSequence(@NonNull MappingSequence pMappingSequence) {
		for (MappingStatement pMappingStatement : pMappingSequence.getMappingStatements()) {
			safeVisit(pMappingStatement);
		}
		return null;
	}

	@Override
	public Object visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public Object visitPredicate(@NonNull Predicate pPredicate) {
		safeVisit(pPredicate.getConditionExpression());
		return null;
	}

	@Override
	public Object visitPropertyAssignment(@NonNull PropertyAssignment pPropertyAssignment) {
		safeVisit(pPropertyAssignment.getSlotExpression());
		context.append(".");
		context.appendName(pPropertyAssignment.getTargetProperty());
		context.append(" := ");
		safeVisit(pPropertyAssignment.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitRealizedVariable(@NonNull RealizedVariable pRealizedVariable) {
		context.append("realize ");
		visitVariable(pRealizedVariable);
		return null;
	}

	@Override
	public Object visitVariable(@NonNull Variable pVariable) {
		if (pVariable.eContainer() instanceof MappingLoop) {
			context.appendName(pVariable);
			context.append(" : ");
			context.appendElement(pVariable.getType());
		}
		else {
			super.visitVariable(pVariable);
			context.append(";\n");
		}
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

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull VariablePredicate object) {
		// TODO Auto-generated method stub
		return null;
	}
}
