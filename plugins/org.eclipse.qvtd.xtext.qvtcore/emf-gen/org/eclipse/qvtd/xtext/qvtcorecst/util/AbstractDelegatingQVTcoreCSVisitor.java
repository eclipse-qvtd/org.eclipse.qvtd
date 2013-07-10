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
 * from: org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCST.genmodel
 * by: org.eclipse.ocl.examples.build.xtend.GenerateVisitors
 * invoked by: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtcorecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTcoreCSVisitor<R, C, D extends QVTcoreCSVisitor<R>>
	extends org.eclipse.qvtd.xtext.qvtcorebasecst.util.AbstractDelegatingQVTcoreBaseCSVisitor<R, C, D>
	implements QVTcoreCSVisitor<R>
{
	protected AbstractDelegatingQVTcoreCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}
}
