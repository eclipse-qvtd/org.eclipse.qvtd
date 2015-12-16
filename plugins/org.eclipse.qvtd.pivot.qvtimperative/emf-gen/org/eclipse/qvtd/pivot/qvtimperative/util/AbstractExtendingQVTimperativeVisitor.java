/*******************************************************************************
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
 * An AbstractExtendingQVTimperativeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTimperativeVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractExtendingQVTcoreBaseVisitor<R, C>
	implements QVTimperativeVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTimperativeVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitConnectionAssignment(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment object) {
		return visitAssignment(object);
	}

	@Override
	public @Nullable R visitImperativeBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable R visitImperativeDomain(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain object) {
		return visitCoreDomain(object);
	}

	@Override
	public @Nullable R visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitMappingLoop(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingLoop object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable R visitMappingSequence(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingSequence object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable R visitMappingStatement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingStatement object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable R visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object) {
		return visitPredicate(object);
	}
}
