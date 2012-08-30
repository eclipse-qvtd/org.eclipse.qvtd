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

		public AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(PrettyPrinter printer) {
			return new QVTcorePrettyPrintVisitor(printer);
		}
	}

	public static PrettyPrinter.Factory FACTORY = new Factory();

	public QVTcorePrettyPrintVisitor(PrettyPrinter context) {
		super(context);
	}

	public Object visitAssignment(Assignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitBottomPattern(BottomPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCoreDomain(CoreDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCoreModel(CoreModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitCorePattern(CorePattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitEnforcementOperation(EnforcementOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitGuardPattern(GuardPattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMapping(Mapping object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPropertyAssignment(PropertyAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRealizedVariable(RealizedVariable object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitVariableAssignment(VariableAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}
}
