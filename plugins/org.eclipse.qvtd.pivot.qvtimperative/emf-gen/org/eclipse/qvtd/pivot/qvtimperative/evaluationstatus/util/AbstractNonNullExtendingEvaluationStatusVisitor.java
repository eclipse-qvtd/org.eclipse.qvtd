/*******************************************************************************
 * <copyright>
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/EvaluationStatus.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingNonNullEvaluationStatusVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 * The return in annotated as @NonNull.
 */
public abstract class AbstractNonNullExtendingEvaluationStatusVisitor<R, C>
	extends AbstractEvaluationStatusVisitor<R, C>
	implements EvaluationStatusVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNonNullExtendingEvaluationStatusVisitor(@NonNull C context) {
		super(context);
	}	
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param visitable a visitable
	 * @return the non-null result of visiting it
	 */
	@Override
	public @NonNull R visit(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement visitable) {
		R result = visitable.accept(this);
		if (result == null) {
			throw new IllegalStateException("null return from non-null " + getClass().getName());
		}
		return result;
	}

	@Override
	public @NonNull R visitAssociationStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus object) {
		return visitPropertyStatus(object);
	}

	@Override
	public @NonNull R visitAttributeStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus object) {
		return visitPropertyStatus(object);
	}

	@Override
	public @NonNull R visitClassStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus object) {
		return visitElementStatus(object);
	}

	@Override
	public @NonNull R visitElementStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus object) {
		return visitEvaluationElement(object);
	}

	@Override
	public @NonNull R visitEvaluationElement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement object) {
		return visiting(object);
	}

	@Override
	public @NonNull R visitMappingStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus object) {
		return visitEvaluationElement(object);
	}

	@Override
	public @NonNull R visitPropertyStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus object) {
		return visitElementStatus(object);
	}

	@Override
	public @NonNull R visitTransformationStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus object) {
		return visitEvaluationElement(object);
	}

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Override
	public abstract @NonNull R visiting(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement visitable);
}
