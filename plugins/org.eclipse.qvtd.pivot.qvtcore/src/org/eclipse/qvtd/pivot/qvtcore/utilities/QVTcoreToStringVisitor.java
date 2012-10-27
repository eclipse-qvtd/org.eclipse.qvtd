/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTcoreToStringVisitor extends QVTbaseToStringVisitor implements QVTcoreVisitor<String>
{
	private static final class Factory implements ToStringVisitor.Factory
	{
		private Factory() {
			QVTbaseToStringVisitor.FACTORY.getClass();
			ToStringVisitor.addFactory(this);
		}

		public @NonNull ToStringVisitor createToStringVisitor() {
			return new QVTcoreToStringVisitor();
		}

		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTcorePackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new Factory();

	protected QVTcoreToStringVisitor() {}

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

	public String visitCoreModel(@NonNull CoreModel object) {
		return visitRoot(object);
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

	public String visitMapping(@NonNull Mapping object) {
		append("mapping ");
		appendName(object);
		return null;
	}

	public String visitPropertyAssignment(@NonNull PropertyAssignment object) {
		append("PropertyAssignment ");
//		appendName(object);
		return null;
	}

	public String visitRealizedVariable(@NonNull RealizedVariable object) {
		append("RealizedVariable ");
		appendName(object);
		return null;
	}

	public String visitVariableAssignment(@NonNull VariableAssignment object) {
		append("VariableAssignment ");
//		appendName(object);
		return null;
	}
}
