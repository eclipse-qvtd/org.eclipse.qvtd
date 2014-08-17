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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTimperativeVisitor<R> extends org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor<R>
{
	@Nullable R visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object);
	@Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object);
	@Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object);
	@Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object);
	@Nullable R visitMappingLoop(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingLoop object);
	@Nullable R visitMappingSequence(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingSequence object);
	@Nullable R visitMappingStatement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingStatement object);
	@Nullable R visitMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment object);
	@Nullable R visitMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp object);
	@Nullable R visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object);
}
