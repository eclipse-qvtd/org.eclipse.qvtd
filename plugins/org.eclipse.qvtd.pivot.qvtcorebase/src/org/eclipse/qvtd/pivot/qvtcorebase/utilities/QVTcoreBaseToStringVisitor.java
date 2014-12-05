/*******************************************************************************
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTcoreBaseToStringVisitor extends QVTbaseToStringVisitor implements QVTcoreBaseVisitor<String>
{
	public QVTcoreBaseToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	public String visitAssignment(@NonNull Assignment object) {
		append("Assignment ");
//		appendName(object);
		return null;
	}

	public String visitBottomPattern(@NonNull BottomPattern object) {
		appendQualifiedName((NamedElement)object.getArea());
		append("$Bottom");
		return null;
	}

	public String visitCoreDomain(@NonNull CoreDomain object) {
		appendQualifiedName(object);
		return null;
	}

	public String visitCorePattern(@NonNull CorePattern object) {
		append("CorePattern ");
//		appendName(object);
		return null;
	}

	public String visitEnforcementOperation(@NonNull EnforcementOperation object) {
		append("EnforcementOperation ");
//		appendName(object);
		return null;
	}

	public String visitGuardPattern(@NonNull GuardPattern object) {
		appendQualifiedName((NamedElement)object.getArea());
		append("$Guard");
		return null;
	}

	public String visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		safeVisit(propertyAssignment.getSlotExpression());
		append(".");
		appendName(propertyAssignment.getTargetProperty());
		append(" := ");
		safeVisit(propertyAssignment.getValue());
		return null;
	}

	public String visitRealizedVariable(@NonNull RealizedVariable variable) {
		append("realized ");
		visitVariable(variable);
		return null;
	}

	public String visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		appendName(variableAssignment.getTargetVariable());
		append(" := ");
		safeVisit(variableAssignment.getValue());
		return null;
	}
}
