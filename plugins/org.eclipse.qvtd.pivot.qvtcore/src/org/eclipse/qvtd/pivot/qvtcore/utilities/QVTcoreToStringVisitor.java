/*******************************************************************************
 * Copyright (c) 2012, 2017 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
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
	protected static class QVTcoreToStringFactory implements QVTbaseToStringVisitor.Factory
	{
		protected QVTcoreToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTcoreToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTcorePackage eInstance = QVTcorePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTcoreToStringFactory();

	public QVTcoreToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitAssignment(@NonNull Assignment object) {
		append("Assignment ");
		//		appendName(object);
		return null;
	}

	@Override
	public String visitBottomPattern(@NonNull BottomPattern object) {
		appendQualifiedName((NamedElement)object.getArea());
		append("$Bottom");
		return null;
	}

	@Override
	public String visitBottomVariable(@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public String visitCoreDomain(@NonNull CoreDomain object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public String visitCoreModel(@NonNull CoreModel object) {
		return visitModel(object);
	}

	@Override
	public String visitCorePattern(@NonNull CorePattern object) {
		append("CorePattern ");
		//		appendName(object);
		return null;
	}

	@Override
	public String visitEnforcementOperation(@NonNull EnforcementOperation object) {
		append("EnforcementOperation ");
		//		appendName(object);
		return null;
	}

	@Override
	public String visitGuardPattern(@NonNull GuardPattern object) {
		appendQualifiedName((NamedElement)object.getArea());
		append("$Guard");
		return null;
	}

	@Override
	public String visitGuardVariable(@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public String visitMapping(@NonNull Mapping object) {
		append("mapping ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		safeVisit(asNavigationAssignment.getSlotExpression());
		append(".");
		appendName(QVTcoreUtil.getTargetProperty(asNavigationAssignment));
		append(asNavigationAssignment.isIsPartial() ? " += " : " := ");
		safeVisit(asNavigationAssignment.getValue());
		return null;
	}

	@Override
	public String visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public String visitPropertyAssignment(@NonNull PropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public String visitRealizedVariable(@NonNull RealizedVariable variable) {
		//		append("realized ");
		visitVariable(variable);
		return null;
	}

	@Override
	public String visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		appendName(variableAssignment.getTargetVariable());
		append(" := ");
		safeVisit(variableAssignment.getValue());
		return null;
	}
}
