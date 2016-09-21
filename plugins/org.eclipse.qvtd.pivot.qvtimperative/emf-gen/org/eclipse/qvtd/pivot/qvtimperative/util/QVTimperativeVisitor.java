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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTimperativeVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object);
	R visitAppendParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameter object);
	R visitAppendParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AppendParameterBinding object);
	R visitBufferStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BufferStatement object);
	R visitCheckStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull CheckStatement object);
	R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object);
	R visitDeclareStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull DeclareStatement object);
	R visitGuardParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameter object);
	R visitGuardParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardParameterBinding object);
	R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object);
	R visitImperativeTransformation(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTransformation object);
	R visitImperativeTypedModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeTypedModel object);
	R visitLoopParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopParameterBinding object);
	R visitLoopVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull LoopVariable object);
	R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object);
	R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object);
	R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object);
	R visitMappingParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter object);
	R visitMappingParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameterBinding object);
	R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object);
	R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object);
	R visitObservableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ObservableStatement object);
	R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object);
	R visitSimpleParameter(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameter object);
	R visitSimpleParameterBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SimpleParameterBinding object);
	R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object);
	R visitVariableStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableStatement object);
}
