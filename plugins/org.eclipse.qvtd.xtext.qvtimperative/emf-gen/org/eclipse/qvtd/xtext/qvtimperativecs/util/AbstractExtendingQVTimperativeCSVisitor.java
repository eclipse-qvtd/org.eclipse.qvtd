/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
package	org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingQVTimperativeCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTimperativeCSVisitor<R, C>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractExtendingQVTbaseCSVisitor<R, C>
	implements QVTimperativeCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTimperativeCSVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAddStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AddStatementCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitAppendParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterBindingCS object) {
		return visitMappingParameterBindingCS(object);
	}

	@Override
	public R visitAppendParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterCS object) {
		return visitMappingParameterCS(object);
	}

	@Override
	public R visitBufferStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BufferStatementCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitCheckStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull CheckStatementCS object) {
		return visitStatementCS(object);
	}

	@Override
	public R visitDeclareStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DeclareStatementCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitGuardParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterBindingCS object) {
		return visitMappingParameterBindingCS(object);
	}

	@Override
	public R visitGuardParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterCS object) {
		return visitMappingParameterCS(object);
	}

	@Override
	public R visitLoopParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull LoopParameterBindingCS object) {
		return visitMappingParameterBindingCS(object);
	}

	@Override
	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object) {
		return visitNamedElementCS(object);
	}

	@Override
	public R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object) {
		return visitMappingStatementCS(object);
	}

	@Override
	public R visitMappingParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterBindingCS object) {
		return visitExpCS(object);
	}

	@Override
	public R visitMappingParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object) {
		return visitStatementCS(object);
	}

	@Override
	public R visitNewStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull NewStatementCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitObservableStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ObservableStatementCS object) {
		return visitStatementCS(object);
	}

	@Override
	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object) {
		return visitTypedElementCS(object);
	}

	@Override
	public R visitSetStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SetStatementCS object) {
		return visitObservableStatementCS(object);
	}

	@Override
	public R visitSimpleParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterBindingCS object) {
		return visitMappingParameterBindingCS(object);
	}

	@Override
	public R visitSimpleParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterCS object) {
		return visitMappingParameterCS(object);
	}

	@Override
	public R visitStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull StatementCS object) {
		return visitModelElementCS(object);
	}

	@Override
	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	@Override
	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object) {
		return visitAbstractTransformationCS(object);
	}
}
