/*******************************************************************************
 * Copyright (c) 2012, 2016 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativePattern;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTimperativeToStringVisitor extends QVTbaseToStringVisitor implements QVTimperativeVisitor<String>
{
	protected static class QVTimperativeToStringFactory implements QVTbaseToStringVisitor.Factory
	{
		protected QVTimperativeToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTimperativeToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTimperativePackage eInstance = QVTimperativePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTimperativeToStringFactory();

	public QVTimperativeToStringVisitor(@NonNull StringBuilder s) {
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
	public @Nullable String visitConnectionAssignment(@NonNull ConnectionAssignment connectionAssignment) {
		appendName(connectionAssignment.getTargetVariable());
		append(" += ");
		safeVisit(connectionAssignment.getValue());
		return null;
	}

	@Override
	public @Nullable String visitConnectionStatement(@NonNull ConnectionStatement asConnectionStatement) {
		appendName(asConnectionStatement.getTargetVariable());
		append(" += ");
		safeVisit(asConnectionStatement.getValue());
		return null;
	}

	@Override
	public @Nullable String visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visitVariable(object);
	}

	@Override
	public String visitGuardPattern(@NonNull GuardPattern object) {
		appendQualifiedName((NamedElement)object.getArea());
		append("$Guard");
		return null;
	}

	@Override
	public String visitImperativeDomain(@NonNull ImperativeDomain object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public @Nullable String visitImperativeModel(@NonNull ImperativeModel object) {
		return visitModel(object);
	}

	@Override
	public String visitImperativePattern(@NonNull ImperativePattern object) {
		append("ImperativePattern ");
		//		appendName(object);
		return null;
	}

	@Override
	public @Nullable String visitMapping(@NonNull Mapping object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public @Nullable String visitMappingCall(@NonNull MappingCall object) {
		appendQualifiedName(object.getReferredMapping());
		append(" {");
		boolean isFirst = true;
		for (MappingCallBinding binding : object.getBinding()) {
			if (!isFirst) {
				append(", ");
			}
			appendName(binding.getBoundVariable());
			append(binding.isIsPolled() ? " ?= " : " := ");
			safeVisit(binding.getValue());
			isFirst = false;
		}
		append("}");
		return null;
	}

	@Override
	public @Nullable String visitMappingCallBinding(@NonNull MappingCallBinding object) {
		appendName(object.getBoundVariable());
		append(object.isIsPolled() ? " ?= " : " := ");
		safeVisit(object.getValue());
		return null;
	}

	@Override
	public @Nullable String visitMappingLoop(@NonNull MappingLoop object) {
		boolean isFirst = true;
		for (Variable iterator : object.getOwnedIterators()) {
			if (!isFirst) {
				append(", ");
			}
			appendName(iterator);
			isFirst = false;
		}
		append(" := ");
		safeVisit(object.getOwnedSource());
		return null;
	}

	@Override
	public @Nullable String visitMappingStatement(@NonNull MappingStatement object) {
		return null;
	}

	@Override
	public String visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		safeVisit(asNavigationAssignment.getSlotExpression());
		append(".");
		appendName(QVTimperativeUtil.getTargetProperty(asNavigationAssignment));
		append(" := ");
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
	public @Nullable String visitStatement(@NonNull Statement object) {
		return null;
	}

	@Override
	public String visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		appendName(variableAssignment.getTargetVariable());
		append(" := ");
		safeVisit(variableAssignment.getValue());
		return null;
	}

	@Override
	public @Nullable String visitVariablePredicate(@NonNull VariablePredicate variablePredicate) {
		appendName(variablePredicate.getTargetVariable());
		append(" := ");
		safeVisit(variablePredicate.getConditionExpression());
		return null;
	}
}
