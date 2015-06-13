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
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface EvaluationStatusVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	@Nullable R visiting(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement visitable);

	@Nullable R visitAssociationStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus object);
	@Nullable R visitAttributeStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus object);
	@Nullable R visitClassStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus object);
	@Nullable R visitElementStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus object);
	@Nullable R visitEvaluationElement(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationElement object);
	@Nullable R visitMappingStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus object);
	@Nullable R visitPropertyStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus object);
	@Nullable R visitTransformationStatus(@NonNull org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus object);
}
