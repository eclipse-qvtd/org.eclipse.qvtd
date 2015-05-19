/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTimperativeCSVisitor<R> extends org.eclipse.qvtd.xtext.qvtcorebasecs.util.QVTcoreBaseCSVisitor<R>
{
	@Nullable R visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS object);
	@Nullable R visitMappingCallBindingCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS object);
	@Nullable R visitMappingCallCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS object);
	@Nullable R visitMappingLoopCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS object);
	@Nullable R visitMappingSequenceCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS object);
	@Nullable R visitMappingStatementCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS object);
	@Nullable R visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS object);
}
