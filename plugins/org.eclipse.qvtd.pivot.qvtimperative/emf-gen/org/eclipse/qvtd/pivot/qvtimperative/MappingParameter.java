/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingParameter defines a formal parameter of a mapping. The parameter is bound by the
 * mapping invocation to satisfy the requirements of the derived parameter class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping <em>Owning Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameter()
 * @generated
 */
public interface MappingParameter extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Owning Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedMappingParameters <em>Owned Mapping Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Mapping</em>' container reference.
	 * @see #setOwningMapping(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingParameter_OwningMapping()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedMappingParameters
	 * @generated
	 */
	Mapping getOwningMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter#getOwningMapping <em>Owning Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping</em>' container reference.
	 * @see #getOwningMapping()
	 * @generated
	 */
	void setOwningMapping(Mapping value);

} // MappingParameter
