/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingQVTimperativeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTimperativeVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractExtendingQVTbaseVisitor<R, C>
	implements QVTimperativeVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTimperativeVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public R visitAppendParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameter object) {
		return visitConnectionVariable(object);
	}

	@Override
	public R visitAppendParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public R visitBufferStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BufferStatement object) {
		return visitConnectionVariable(object);
	}

	@Override
	public R visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public R visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public R visitGuardParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public R visitGuardParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public R visitImperativeTransformation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public R visitImperativeTypedModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTypedModel object) {
		return visitTypedModel(object);
	}

	@Override
	public R visitLoopParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public R visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visitMappingStatement(object);
	}

	@Override
	public R visitMappingParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public R visitMappingParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameterBinding object) {
		return visitElement(object);
	}

	@Override
	public R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public R visitObservableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ObservableStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public R visitSimpleParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public R visitSimpleParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		return visitNamedElement(object);
	}

	@Override
	public R visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object) {
		return visitVariableDeclaration(object);
	}
}
