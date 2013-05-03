/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/QVTcoreBase.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcorebase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTcoreBaseVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreBaseVisitor<R, C, D extends QVTcoreBaseVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTcoreBaseVisitor<R>
{
    protected AbstractDelegatingQVTcoreBaseVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object) {
		return delegate.visitAssignment(object);
	}

	public @Nullable R visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object) {
		return delegate.visitBottomPattern(object);
	}

	public @Nullable R visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object) {
		return delegate.visitCoreDomain(object);
	}

	public @Nullable R visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object) {
		return delegate.visitCorePattern(object);
	}

	public @Nullable R visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object) {
		return delegate.visitEnforcementOperation(object);
	}

	public @Nullable R visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object) {
		return delegate.visitGuardPattern(object);
	}

	public @Nullable R visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object) {
		return delegate.visitPropertyAssignment(object);
	}

	public @Nullable R visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object) {
		return delegate.visitRealizedVariable(object);
	}

	public @Nullable R visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object) {
		return delegate.visitVariableAssignment(object);
	}
}
