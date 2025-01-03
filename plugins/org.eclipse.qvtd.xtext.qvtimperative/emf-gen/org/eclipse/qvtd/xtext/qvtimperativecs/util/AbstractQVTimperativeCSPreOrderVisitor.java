/*******************************************************************************
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.qvtd.xtext.qvtbase.cs2as.QVTbaseCSPreOrderVisitor;

/**
 * An AbstractQVTimperativeCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeCSPreOrderVisitor
	extends QVTbaseCSPreOrderVisitor
	implements QVTimperativeCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Continuation<?> visitAddStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AddStatementCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitAppendParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterBindingCS csElement) {
		return visitMappingParameterBindingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitAppendParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterCS csElement) {
		return visitMappingParameterCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitBufferStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BufferStatementCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitCheckStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull CheckStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDeclareStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DeclareStatementCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitEntryPointCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull EntryPointCS csElement) {
		return visitMappingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitGuardParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterBindingCS csElement) {
		return visitMappingParameterBindingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitGuardParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterCS csElement) {
		return visitMappingParameterCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitLoopParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull LoopParameterBindingCS csElement) {
		return visitMappingParameterBindingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS csElement) {
		return visitMappingStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterBindingCS csElement) {
		return visitExpCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitNewStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull NewStatementCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitObservableStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ObservableStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSetStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SetStatementCS csElement) {
		return visitObservableStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSimpleParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterBindingCS csElement) {
		return visitMappingParameterBindingCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSimpleParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterCS csElement) {
		return visitMappingParameterCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitSpeculateStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SpeculateStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull StatementCS csElement) {
		return visitModelElementCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	@Override
	public @Nullable Continuation<?> visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS csElement) {
		return visitAbstractTransformationCS(csElement);
	}
}
