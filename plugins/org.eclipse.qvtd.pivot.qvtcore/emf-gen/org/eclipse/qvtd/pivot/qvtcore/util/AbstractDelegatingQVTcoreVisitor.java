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
 * An AbstractDelegatingQVTcoreVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreVisitor<R, C, D extends QVTcoreVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTcoreVisitor<R>
{
    protected AbstractDelegatingQVTcoreVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.Assignment object) {
		return delegate.visitAssignment(object);
	}

	public R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.BottomPattern object) {
		return delegate.visitBottomPattern(object);
	}

	public R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.CoreDomain object) {
		return delegate.visitCoreDomain(object);
	}

	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return delegate.visitCoreModel(object);
	}

	public R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.CorePattern object) {
		return delegate.visitCorePattern(object);
	}

	public R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object) {
		return delegate.visitEnforcementOperation(object);
	}

	public R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.GuardPattern object) {
		return delegate.visitGuardPattern(object);
	}

	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return delegate.visitMapping(object);
	}

	public R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object) {
		return delegate.visitPropertyAssignment(object);
	}

	public R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object) {
		return delegate.visitRealizedVariable(object);
	}

	public R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object) {
		return delegate.visitVariableAssignment(object);
	}
}
