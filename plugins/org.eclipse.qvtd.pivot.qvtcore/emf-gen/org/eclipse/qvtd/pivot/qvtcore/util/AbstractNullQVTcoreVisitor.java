/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcore.util;

/**
 * An AbstractNullQVTcoreVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTcoreVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTcoreVisitor(C context) {
	    super(context);
	}	

	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.Assignment object) {
		return null;
	}

	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.BottomPattern object) {
		return null;
	}

	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.CoreDomain object) {
		return null;
	}

	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return null;
	}

	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.CorePattern object) {
		return null;
	}

	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object) {
		return null;
	}

	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.GuardPattern object) {
		return null;
	}

	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return null;
	}

	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object) {
		return null;
	}

	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object) {
		return null;
	}

	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object) {
		return null;
	}
}
