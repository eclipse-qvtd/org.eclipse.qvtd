/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseFlowAnalysisDeducerFromTrueVisitor;

/**
 * An AbstractQVTimperativeFlowAnalysisDeducerFromTrueVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeFlowAnalysisDeducerFromTrueVisitor
	extends QVTbaseFlowAnalysisDeducerFromTrueVisitor
	implements QVTimperativeVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeFlowAnalysisDeducerFromTrueVisitor(@NonNull FlowAnalysis flowAnalysis) {
		super(flowAnalysis);
	}

	@Override
	public @Nullable Boolean visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitAppendParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameter object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitAppendParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitBufferStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BufferStatement object) {
		return visitConnectionVariable(object);
	}

	@Override
	public @Nullable Boolean visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public @Nullable Boolean visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitEntryPoint(org.eclipse.qvtd.pivot.qvtimperative.@NonNull EntryPoint object) {
		return visitMapping(object);
	}

	@Override
	public @Nullable Boolean visitGuardParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public @Nullable Boolean visitGuardParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitImperativeTransformation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable Boolean visitLoopParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitMappingParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter object) {
		return visitVariableDeclaration(object);
	}

	@Override
	public @Nullable Boolean visitMappingParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameterBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object) {
		return visitVariableStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatementPart(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatementPart object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitObservableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ObservableStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object) {
		return visitObservableStatement(object);
	}

	@Override
	public @Nullable Boolean visitSimpleParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameter object) {
		return visitMappingParameter(object);
	}

	@Override
	public @Nullable Boolean visitSimpleParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameterBinding object) {
		return visitMappingParameterBinding(object);
	}

	@Override
	public @Nullable Boolean visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object) {
		return visitVariableDeclaration(object);
	}
}
