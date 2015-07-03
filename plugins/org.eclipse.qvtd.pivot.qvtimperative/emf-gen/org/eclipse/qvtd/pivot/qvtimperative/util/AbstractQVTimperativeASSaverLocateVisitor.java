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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseASSaverLocateVisitor;

/**
 * An AbstractQVTimperativeASSaverLocateVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTimperativeASSaverLocateVisitor
	extends QVTcoreBaseASSaverLocateVisitor
	implements QVTimperativeVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitImperativeBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

	@Override
	public @Nullable Object visitImperativeModel(@NonNull org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Object visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtimperative.Mapping object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Object visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCall object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Object visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitMappingLoop(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingLoop object) {
		return visitCallExp(object);
	}

	@Override
	public @Nullable Object visitMappingSequence(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingSequence object) {
		return visitMappingStatement(object);
	}

	@Override
	public @Nullable Object visitMappingStatement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.MappingStatement object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate object) {
		return visitPredicate(object);
	}
}
