/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;

public class QVTiIsBreakpointableVisitor extends AbstractExtendingQVTimperativeVisitor<Boolean, Object>
{
	public static final @NonNull QVTiIsBreakpointableVisitor INSTANCE = new QVTiIsBreakpointableVisitor(QVTiIsBreakpointableVisitor.class);

	private QVTiIsBreakpointableVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitElement(@NonNull Element object) {
		return ValidBreakpointLocator.IS_START; //null;
	}

	@Override
	public @Nullable Boolean visitLoopExp(@NonNull LoopExp object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitOCLExpression(@NonNull OCLExpression object) {
		return ValidBreakpointLocator.IS_START;
	}

	@Override
	public @Nullable Boolean visitOperationCallExp(@NonNull OperationCallExp object) {
		return ValidBreakpointLocator.IS_END;
	}

	@Override
	public @Nullable Boolean visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unimplemented " + getClass().getName() + " for " + visitable.eClass().getName());
	}
}
