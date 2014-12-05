/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Middle Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MiddlePropertyCallExp identifies a property call from the middle model.
 * It adds an additional feature to facilitate efficient access to a cache of
 * non-navigable outer-to-middle opposites.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp#getCacheIndex <em>Cache Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMiddlePropertyCallExp()
 * @generated
 */
public interface MiddlePropertyCallExp extends EObject, OppositePropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Cache Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Identification of the cache of unnavigable opposites to be exploited
	 * by this property call. Should not be null during execution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cache Index</em>' attribute.
	 * @see #setCacheIndex(Integer)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMiddlePropertyCallExp_CacheIndex()
	 * @generated
	 */
	Integer getCacheIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp#getCacheIndex <em>Cache Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cache Index</em>' attribute.
	 * @see #getCacheIndex()
	 * @generated
	 */
	void setCacheIndex(Integer value);

} // MiddlePropertyCallExp
