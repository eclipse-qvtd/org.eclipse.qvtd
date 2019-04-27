/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cast Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CastEdge is temporaily created to model an oclAsType, but is rewritten once all casts are visible.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClassDatum <em>Referred Class Datum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCastEdge()
 * @model
 * @generated
 */
public interface CastEdge extends Edge
{

	/**
	 * Returns the value of the '<em><b>Referred Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class Datum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class Datum</em>' reference.
	 * @see #setReferredClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getCastEdge_ReferredClassDatum()
	 * @model required="true" transient="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!CastEdge!referredClassDatum'"
	 * @generated
	 */
	ClassDatum getReferredClassDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClassDatum <em>Referred Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class Datum</em>' reference.
	 * @see #getReferredClassDatum()
	 * @generated
	 */
	void setReferredClassDatum(ClassDatum value);

	void initialize(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull ClassDatum classDatum, @NonNull Node targetNode);
} // CastEdge
