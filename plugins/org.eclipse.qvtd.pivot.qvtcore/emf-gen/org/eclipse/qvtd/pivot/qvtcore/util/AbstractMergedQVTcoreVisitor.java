/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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

/**
 * An AbstractMergedQVTcoreVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractMergedQVTcoreBaseVisitor<R, C>
	implements QVTcoreVisitor<R>
{
	protected AbstractMergedQVTcoreVisitor(C context) {
		super(context);
	}

	@Override
	public R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object) {
		return visiting(object);
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object) {
		return visiting(object);
	}
}
