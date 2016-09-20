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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Append Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCallBinding specifies the binding of a single variable as part of
 * a MappingCall. A value is bound to the variable. OPtionally isLoop may be true
 * to indicate that the value is a collection of values, each of which is to
 * be used as part of a distinct invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAppendParameterBinding()
 * @generated
 */
public interface AppendParameterBinding extends MappingParameterBinding {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value or collection of values to bind to boundVariable
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(ConnectionVariable)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAppendParameterBinding_Value()
	 * @generated
	 */
	ConnectionVariable getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ConnectionVariable value);

} // AppendParameterBinding
