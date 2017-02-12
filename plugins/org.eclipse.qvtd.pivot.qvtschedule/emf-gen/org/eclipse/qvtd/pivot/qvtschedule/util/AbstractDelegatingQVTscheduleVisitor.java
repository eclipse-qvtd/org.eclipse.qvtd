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

/**
 * An AbstractDelegatingQVTscheduleVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTscheduleVisitor<R, C, @NonNull D extends QVTscheduleVisitor<R>>
	extends org.eclipse.ocl.pivot.util.AbstractDelegatingVisitor<R, C, D>
	implements QVTscheduleVisitor<R>
{
	protected AbstractDelegatingQVTscheduleVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return delegate.visitAbstractDatum(object);
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return delegate.visitClassDatum(object);
	}

	@Override
	public R visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		return delegate.visitConnectionRole(object);
	}

	@Override
	public R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return delegate.visitEdgeRole(object);
	}

	@Override
	public R visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		return delegate.visitMappingAction(object);
	}

	@Override
	public R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return delegate.visitNodeRole(object);
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return delegate.visitPropertyDatum(object);
	}

	@Override
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return delegate.visitRole(object);
	}
}
