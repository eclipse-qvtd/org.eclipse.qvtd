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
 * from: model/QVTimperativeCST.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtimperativecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.AbstractDelegatingQVTcoreBaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.QVTcoreBaseCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTimperativeCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTimperativeCSVisitor<R, C, D extends QVTcoreBaseCSVisitor<R>>
	extends AbstractDelegatingQVTcoreBaseCSVisitor<R, C, D>
	implements QVTimperativeCSVisitor<R>
{
	protected AbstractExtendingDelegatingQVTimperativeCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS object) {
		return delegate.visitAbstractMappingCS(object);
	}

	public @Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS object) {
		return delegate.visitModelElementCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS object) {
		return delegate.visitRootPackageCS(object);
	}
}
