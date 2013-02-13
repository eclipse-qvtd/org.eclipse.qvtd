/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.MappingCall;
import org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

public class QVTcorePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTcoreVisitor<Object>
{	
	private static final class Factory implements PrettyPrinter.Factory
	{
		private Factory() {
			QVTbasePrettyPrintVisitor.FACTORY.getClass();
			PrettyPrinter.addFactory(QVTcorePackage.eINSTANCE, this);
		}

		public @NonNull AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
			return new QVTcorePrettyPrintVisitor(printer);
		}
	}

	public static @NonNull PrettyPrinter.Factory FACTORY = new Factory();

	public QVTcorePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	public Object visitAssignment(@NonNull Assignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitBottomPattern(@NonNull BottomPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCoreDomain(@NonNull CoreDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCoreModel(@NonNull CoreModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCorePattern(@NonNull CorePattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitGuardPattern(@NonNull GuardPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMapping(@NonNull Mapping object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMappingCall(@NonNull MappingCall object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMappingCallBinding(@NonNull MappingCallBinding object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPropertyAssignment(@NonNull PropertyAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRealizedVariable(@NonNull RealizedVariable object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVariableAssignment(@NonNull VariableAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}
}
