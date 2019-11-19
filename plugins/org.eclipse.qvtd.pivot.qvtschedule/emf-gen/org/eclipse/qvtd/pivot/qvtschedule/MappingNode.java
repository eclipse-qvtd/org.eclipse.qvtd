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
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingNode may contribute to a MappingRegion in a QBTs graph.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched <em>Matched</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingNode()
 * @model abstract="true"
 * @generated
 */
public interface MappingNode extends Node {
	/**
	 * Returns the value of the '<em><b>Matched</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * Return true if after execution this node exactly corresponds to a non-null object or to a non-null value or to an explicit null.
	 * Conversely return false if this node is optionally null or part of a conditional expression evaluation.
	 * Collections are never null-valued, not even empty collections.
	 *
	 * deprecated try to use isUnconditional or getUtility
	 * <p>
	 * If the meaning of the '<em>Matched</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matched</em>' attribute.
	 * @see #setMatched(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMappingNode_Matched()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMatched();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched <em>Matched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matched</em>' attribute.
	 * @see #isMatched()
	 * @generated
	 */
	void setMatched(boolean value);

	void setOriginatingElement(@NonNull Element originatingElement);

} // MappingNode
