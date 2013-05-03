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
 * from: model/QVTcore.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTcoreVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTcoreVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractNullQVTcoreBaseVisitor<R, C> implements QVTcoreVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTcoreVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitCoreModel(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreModel object) {
		return null;
	}

	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtcore.Mapping object) {
		return null;
	}
}
