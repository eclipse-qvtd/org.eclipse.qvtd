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
 * from: model/QVTcoreBase.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcorebase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTcoreBaseVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTcoreBaseVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractNullQVTbaseVisitor<R, C> implements QVTcoreBaseVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTcoreBaseVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object) {
		return null;
	}

	public @Nullable R visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object) {
		return null;
	}

	public @Nullable R visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object) {
		return null;
	}

	public @Nullable R visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object) {
		return null;
	}

	public @Nullable R visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object) {
		return null;
	}

	public @Nullable R visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object) {
		return null;
	}

	public @Nullable R visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object) {
		return null;
	}

	public @Nullable R visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object) {
		return null;
	}

	public @Nullable R visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object) {
		return null;
	}
}
