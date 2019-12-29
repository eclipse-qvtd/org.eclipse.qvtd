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
 * A representation of the model object '<em><b>Predicate Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A not-partial PredicateEdge requires source and target nodes to have the same identity/value. A partial PredicateEdge requires target node identity/value to be one of the source node identity/values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge#isPartial <em>Partial</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPredicateEdge()
 * @model
 * @generated
 */
public interface PredicateEdge extends Edge {

	/**
	 * Returns the value of the '<em><b>Partial</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if this edge is a partial many-to-one relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Partial</em>' attribute.
	 * @see #setPartial(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getPredicateEdge_Partial()
	 * @model default="false" required="true"
	 * @generated
	 */
	@Override
	boolean isPartial();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge#isPartial <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partial</em>' attribute.
	 * @see #isPartial()
	 * @generated
	 */
	void setPartial(boolean value);

	void initialize(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @NonNull Node targetNode, boolean isPartial);
} // PredicateEdge
