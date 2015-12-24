/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * An AbstractWrappingQVTcoreVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTcoreVisitor<R, C, D extends QVTcoreVisitor<R>, P>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractWrappingQVTcoreBaseVisitor<R, C, D, P>
	implements QVTcoreVisitor<R>
{
	protected AbstractWrappingQVTcoreVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCoreModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapping(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
