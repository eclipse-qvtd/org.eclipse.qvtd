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
 * An AbstractExtendingEvaluationStatusVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingEvaluationStatusVisitor<R, C>
	extends AbstractEvaluationStatusVisitor<R, C>
	implements EvaluationStatusVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingEvaluationStatusVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAssociationStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull AssociationStatus object) {
		return visitPropertyStatus(object);
	}

	@Override
	public R visitAttributeStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull AttributeStatus object) {
		return visitPropertyStatus(object);
	}

	@Override
	public R visitClassStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull ClassStatus object) {
		return visitElementStatus(object);
	}

	@Override
	public R visitElementStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull ElementStatus object) {
		return visitEvaluationElement(object);
	}

	@Override
	public R visitEvaluationElement(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull EvaluationElement object) {
		return visiting(object);
	}

	@Override
	public R visitMappingStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull MappingStatus object) {
		return visitEvaluationElement(object);
	}

	@Override
	public R visitPropertyStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull PropertyStatus object) {
		return visitElementStatus(object);
	}

	@Override
	public R visitTransformationStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull TransformationStatus object) {
		return visitEvaluationElement(object);
	}
}
