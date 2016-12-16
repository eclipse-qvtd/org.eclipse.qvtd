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
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QVTimperativeCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtbasecs.util.QVTbaseCSVisitor<R>
{
	R visitAddStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AddStatementCS object);
	R visitAppendParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterBindingCS object);
	R visitAppendParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull AppendParameterCS object);
	R visitBufferStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull BufferStatementCS object);
	R visitCheckStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull CheckStatementCS object);
	R visitDeclareStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DeclareStatementCS object);
	R visitDirectionCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull DirectionCS object);
	R visitGuardParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterBindingCS object);
	R visitGuardParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull GuardParameterCS object);
	R visitLoopParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull LoopParameterBindingCS object);
	R visitMappingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCS object);
	R visitMappingCallCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingCallCS object);
	R visitMappingLoopCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingLoopCS object);
	R visitMappingParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterBindingCS object);
	R visitMappingParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingParameterCS object);
	R visitMappingStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull MappingStatementCS object);
	R visitNewStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull NewStatementCS object);
	R visitObservableStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ObservableStatementCS object);
	R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull ParamDeclarationCS object);
	R visitQueryCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull QueryCS object);
	R visitSetStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SetStatementCS object);
	R visitSimpleParameterBindingCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterBindingCS object);
	R visitSimpleParameterCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull SimpleParameterCS object);
	R visitStatementCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull StatementCS object);
	R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TopLevelCS object);
	R visitTransformationCS(org.eclipse.qvtd.xtext.qvtimperativecs.@NonNull TransformationCS object);
}
