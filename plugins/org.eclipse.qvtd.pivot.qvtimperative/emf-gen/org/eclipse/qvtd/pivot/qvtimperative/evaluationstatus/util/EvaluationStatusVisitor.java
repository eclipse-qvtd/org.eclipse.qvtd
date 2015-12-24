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
	R visiting(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull EvaluationElement visitable);

	R visitAssociationStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull AssociationStatus object);
	R visitAttributeStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull AttributeStatus object);
	R visitClassStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull ClassStatus object);
	R visitElementStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull ElementStatus object);
	R visitEvaluationElement(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull EvaluationElement object);
	R visitMappingStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull MappingStatus object);
	R visitPropertyStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull PropertyStatus object);
	R visitTransformationStatus(org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.@NonNull TransformationStatus object);
}
