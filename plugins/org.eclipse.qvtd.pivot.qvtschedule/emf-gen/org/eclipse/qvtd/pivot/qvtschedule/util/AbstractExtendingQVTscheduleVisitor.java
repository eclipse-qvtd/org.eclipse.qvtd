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
 * An AbstractExtendingQVTscheduleVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTscheduleVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractExtendingVisitor<R, C>
	implements QVTscheduleVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTscheduleVisitor(C context) {
		super(context);
	}

	@Override
	public R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		return visitRole(object);
	}

	@Override
	public R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		return visitRole(object);
	}

	@Override
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return visitElement(object);
	}
}
