/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbasePrettyPrintVisitor;
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

public class QVTcoreBasePrettyPrintVisitor extends QVTbasePrettyPrintVisitor implements QVTcoreBaseVisitor<Object>
{	
	public QVTcoreBasePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Override
	public Object visitAssignment(@NonNull Assignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitBottomPattern(@NonNull BottomPattern object) {
		// TODO Auto-generated method stub
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
	public Object visitGuardPattern(@NonNull GuardPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPropertyAssignment(@NonNull PropertyAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitRealizedVariable(@NonNull RealizedVariable object) {
		return visitVariable(object);
	}

	@Override
	public Object visitVariableAssignment(@NonNull VariableAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}
}
