/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
 * An AbstractMergedQVTimperativeVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTimperativeVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractMergedQVTcoreBaseVisitor<R, C>
	implements QVTimperativeVisitor<R>
{
	protected AbstractMergedQVTimperativeVisitor(@NonNull C context) {
		super(context);
	}

	@Override
	public @Nullable R visitConnectionAssignment(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitImperativeBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitImperativeDomain(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMappingLoop(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingLoop object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMappingSequence(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingSequence object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitMappingStatement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingStatement object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object) {
		return visiting(object);
	}
}
