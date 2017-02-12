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
 * An AbstractMergedQVTscheduleVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTscheduleVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractMergedVisitor<R, C>
	implements QVTscheduleVisitor<R>
{
	protected AbstractMergedQVTscheduleVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visiting(object);
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		return visiting(object);
	}

	@Override
	public R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return visiting(object);
	}

	@Override
	public R visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		return visiting(object);
	}

	@Override
	public R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visiting(object);
	}

	@Override
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return visiting(object);
	}
}
