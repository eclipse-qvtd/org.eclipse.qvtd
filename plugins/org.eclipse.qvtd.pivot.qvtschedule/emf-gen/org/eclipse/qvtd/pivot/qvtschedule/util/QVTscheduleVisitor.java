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
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QVTscheduleVisitor<R> extends org.eclipse.ocl.pivot.util.Visitor<R>
{
	R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object);
	R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object);
	R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object);
}
