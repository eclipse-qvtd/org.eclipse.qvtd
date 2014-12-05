/*******************************************************************************
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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTimperativeCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTimperativeCSVisitor<R, C, D extends QVTimperativeCSVisitor<R>>
	extends org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.util.AbstractDelegatingQVTcoreBaseCSVisitor<R, C, D>
	implements QVTimperativeCSVisitor<R>
{
	protected AbstractDelegatingQVTimperativeCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.xtext.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	public @Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS object) {
		return delegate.visitMappingCallBindingCS(object);
	}

	public @Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS object) {
		return delegate.visitMappingCallCS(object);
	}

	public @Nullable R visitMappingLoopCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS object) {
		return delegate.visitMappingLoopCS(object);
	}

	public @Nullable R visitMappingSequenceCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingSequenceCS object) {
		return delegate.visitMappingSequenceCS(object);
	}

	public @Nullable R visitMappingStatementCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingStatementCS object) {
		return delegate.visitMappingStatementCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}
}
