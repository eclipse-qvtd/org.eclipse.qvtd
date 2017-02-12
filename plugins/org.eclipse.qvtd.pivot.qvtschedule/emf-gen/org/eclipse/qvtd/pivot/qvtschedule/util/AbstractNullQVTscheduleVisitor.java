/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTscheduleVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.
 */
 @Deprecated
public abstract class AbstractNullQVTscheduleVisitor<@Nullable R, C>
	extends org.eclipse.ocl.pivot.util.AbstractNullVisitor<R, C> implements QVTscheduleVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractNullQVTscheduleVisitor(C context) {
		super(context);
	}

	@Override
	public R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return null;
	}

	@Override
	public R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return null;
	}

	@Override
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return null;
	}
}
