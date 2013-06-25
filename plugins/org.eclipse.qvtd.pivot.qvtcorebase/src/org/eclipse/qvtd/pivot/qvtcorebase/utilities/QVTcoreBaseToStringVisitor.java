/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTcoreBaseToStringVisitor extends QVTbaseToStringVisitor implements QVTcoreBaseVisitor<String>
{
	private static final class Factory implements ToStringVisitor.Factory
	{
		private Factory() {
			QVTbaseToStringVisitor.FACTORY.getClass();
			ToStringVisitor.addFactory(this);
		}

		public @NonNull ToStringVisitor createToStringVisitor() {
			return new QVTcoreBaseToStringVisitor();
		}

		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTcoreBasePackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new Factory();

	protected QVTcoreBaseToStringVisitor() {}

	public String visitAssignment(@NonNull Assignment object) {
		append("Assignment ");
//		appendName(object);
		return null;
	}

	public String visitBottomPattern(@NonNull BottomPattern object) {
		append("BottomPattern ");
//		appendName(object);
		return null;
	}

	public String visitCoreDomain(@NonNull CoreDomain object) {
		append("core domain ");
		appendName(object);
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
		append("GuardPattern ");
//		appendName(object);
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
