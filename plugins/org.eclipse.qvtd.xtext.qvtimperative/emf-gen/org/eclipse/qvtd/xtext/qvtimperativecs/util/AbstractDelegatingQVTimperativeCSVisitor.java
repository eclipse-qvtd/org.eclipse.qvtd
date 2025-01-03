/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTimperativeCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTimperativeCSVisitor<R, C, @NonNull D extends QVTimperativeCSVisitor<R>>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractDelegatingQVTbaseCSVisitor<R, C, D>
	implements QVTimperativeCSVisitor<R>
{
	protected AbstractDelegatingQVTimperativeCSVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.xtext.basecs.util.@NonNull VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAddStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AddStatementCS object) {
		return delegate.visitAddStatementCS(object);
	}

	@Override
	public R visitAppendParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterBindingCS object) {
		return delegate.visitAppendParameterBindingCS(object);
	}

	@Override
	public R visitAppendParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterCS object) {
		return delegate.visitAppendParameterCS(object);
	}

	@Override
	public R visitBufferStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BufferStatementCS object) {
		return delegate.visitBufferStatementCS(object);
	}

	@Override
	public R visitCheckStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull CheckStatementCS object) {
		return delegate.visitCheckStatementCS(object);
	}

	@Override
	public R visitDeclareStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DeclareStatementCS object) {
		return delegate.visitDeclareStatementCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object) {
		return delegate.visitDirectionCS(object);
	}

	@Override
	public R visitEntryPointCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull EntryPointCS object) {
		return delegate.visitEntryPointCS(object);
	}

	@Override
	public R visitGuardParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterBindingCS object) {
		return delegate.visitGuardParameterBindingCS(object);
	}

	@Override
	public R visitGuardParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterCS object) {
		return delegate.visitGuardParameterCS(object);
	}

	@Override
	public R visitLoopParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull LoopParameterBindingCS object) {
		return delegate.visitLoopParameterBindingCS(object);
	}

	@Override
	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object) {
		return delegate.visitMappingCS(object);
	}

	@Override
	public R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object) {
		return delegate.visitMappingCallCS(object);
	}

	@Override
	public R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object) {
		return delegate.visitMappingLoopCS(object);
	}

	@Override
	public R visitMappingParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterBindingCS object) {
		return delegate.visitMappingParameterBindingCS(object);
	}

	@Override
	public R visitMappingParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterCS object) {
		return delegate.visitMappingParameterCS(object);
	}

	@Override
	public R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object) {
		return delegate.visitMappingStatementCS(object);
	}

	@Override
	public R visitNewStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull NewStatementCS object) {
		return delegate.visitNewStatementCS(object);
	}

	@Override
	public R visitObservableStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ObservableStatementCS object) {
		return delegate.visitObservableStatementCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object) {
		return delegate.visitParamDeclarationCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object) {
		return delegate.visitQueryCS(object);
	}

	@Override
	public R visitSetStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SetStatementCS object) {
		return delegate.visitSetStatementCS(object);
	}

	@Override
	public R visitSimpleParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterBindingCS object) {
		return delegate.visitSimpleParameterBindingCS(object);
	}

	@Override
	public R visitSimpleParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterCS object) {
		return delegate.visitSimpleParameterCS(object);
	}

	@Override
	public R visitSpeculateStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SpeculateStatementCS object) {
		return delegate.visitSpeculateStatementCS(object);
	}

	@Override
	public R visitStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull StatementCS object) {
		return delegate.visitStatementCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}
}
