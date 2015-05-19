/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Imperative Mapping extends the abstract declarative mapping to support
 * explicit nested invocation of mappings with bindings for the invoked mapping's
 * bound variables.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingStatement <em>Mapping Statement</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping()
 * @generated
 */
public interface Mapping extends AbstractMapping {
	/**
	 * Returns the value of the '<em><b>Mapping Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Statement</em>' containment reference.
	 * @see #setMappingStatement(MappingStatement)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMapping_MappingStatement()
	 * @generated
	 */
	MappingStatement getMappingStatement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingStatement <em>Mapping Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Statement</em>' containment reference.
	 * @see #getMappingStatement()
	 * @generated
	 */
	void setMappingStatement(MappingStatement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EList<Mapping> getAllMappings();

} // Mapping
