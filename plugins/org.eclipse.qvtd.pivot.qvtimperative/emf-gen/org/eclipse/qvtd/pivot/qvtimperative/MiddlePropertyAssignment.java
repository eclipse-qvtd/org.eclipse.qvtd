/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Middle Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MiddlePropertyAssignment identifies a property assignment to the middle model.
 * It adds an additional feature to facilitate efficient access to a cache of
 * non-navigable outer-to-middle opposites.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment#getCacheIndex <em>Cache Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMiddlePropertyAssignment()
 * @model
 * @generated
 */
public interface MiddlePropertyAssignment extends PropertyAssignment {
	/**
	 * Returns the value of the '<em><b>Cache Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Identification of the cache of unnavigable opposites to be maintained
	 * by this property assignment. May be null if no cache is required.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cache Index</em>' attribute.
	 * @see #setCacheIndex(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMiddlePropertyAssignment_CacheIndex()
	 * @model
	 * @generated
	 */
	Integer getCacheIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment#getCacheIndex <em>Cache Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Index</em>' attribute.
	 * @see #getCacheIndex()
	 * @generated
	 */
	void setCacheIndex(Integer value);

} // MiddlePropertyAssignment
