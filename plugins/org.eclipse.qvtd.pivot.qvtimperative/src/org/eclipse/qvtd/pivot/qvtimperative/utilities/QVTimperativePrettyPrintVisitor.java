/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

public class QVTimperativePrettyPrintVisitor extends QVTcoreBasePrettyPrintVisitor implements QVTimperativeVisitor<Object>
{	
	private static final class Factory implements PrettyPrinter.Factory
	{
		private Factory() {
			QVTcoreBasePrettyPrintVisitor.FACTORY.getClass();
			PrettyPrinter.addFactory(QVTimperativePackage.eINSTANCE, this);
		}

		public @NonNull AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
			return new QVTimperativePrettyPrintVisitor(printer);
		}
	}

	public static @NonNull PrettyPrinter.Factory FACTORY = new Factory();

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
		context.append(" |\n");
		for (Assignment pAssignment : pBottomPattern.getAssignment()) {
			safeVisit(pAssignment);
		}
		return null;
	}

	@Override
	public Object visitGuardPattern(@NonNull GuardPattern pGuardPattern) {
		for (Variable pVariable : pGuardPattern.getVariable()) {
			safeVisit(pVariable);
		}
		context.append(" |\n");
		for (Predicate pPredicate : pGuardPattern.getPredicate()) {
			safeVisit(pPredicate);
		}
		return null;
	}

	public Object visitImperativeModel(@NonNull ImperativeModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMapping(@NonNull Mapping pMapping) {
		context.append("map ");
		context.appendName(pMapping);
		context.append(" in ");
		context.appendName(pMapping.getTransformation());
		context.append(") {\n");
		context.push("", "");
		for (Domain pDomain : pMapping.getDomain()) {
			if (pDomain instanceof CoreDomain) {
				context.appendName(pDomain);
				doArea((CoreDomain)pDomain);
			}
		}
		context.append("where");
		doArea(pMapping);
		for (MappingCall pMappingCall : pMapping.getMappingCall()) {
			safeVisit(pMappingCall);
		}
		context.pop();
		context.append("\n}");
		return null;
	}

	public Object visitMappingCall(@NonNull MappingCall pMappingCall) {
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

	public Object visitMappingCallBinding(@NonNull MappingCallBinding bMappingCallBinding) {
		context.appendName(bMappingCallBinding.getBoundVariable());
		context.append(bMappingCallBinding.isIsLoop() ? " <= " : " := ");
		safeVisit(bMappingCallBinding.getValue());
		context.append(";\n");
		return null;
	}

	@Override
	public Object visitPredicate(@NonNull Predicate pPredicate) {
		safeVisit(pPredicate.getConditionExpression());
		return null;
	}

	@Override
	public Object visitPropertyAssignment(@NonNull PropertyAssignment pPropertyAssignment) {
		safeVisit(pPropertyAssignment.getSlotExpression());
		context.append(" = ");
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
		super.visitVariable(pVariable);
		context.append(";\n");
		return null;
	}
}
