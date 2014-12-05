/*******************************************************************************
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
 * from: org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTcoreVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreVisitor<R, C, D extends QVTcoreVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractDelegatingQVTcoreBaseVisitor<R, C, D>
	implements QVTcoreVisitor<R>
{
	protected AbstractDelegatingQVTcoreVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitCoreModel(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return delegate.visitCoreModel(object);
	}

	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return delegate.visitMapping(object);
	}
}
