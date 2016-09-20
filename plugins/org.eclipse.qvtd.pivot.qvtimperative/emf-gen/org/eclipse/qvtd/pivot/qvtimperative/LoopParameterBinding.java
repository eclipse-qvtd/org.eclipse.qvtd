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
 * A representation of the model object '<em><b>Loop Parameter Binding</b></em>'.
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck <em>Is Check</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getLoopParameterBinding()
 * @generated
 */
public interface LoopParameterBinding extends MappingParameterBinding {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value or collection of values to bind to boundVariable
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(LoopVariable)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getLoopParameterBinding_Value()
	 * @generated
	 */
	LoopVariable getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(LoopVariable value);

	/**
	 * Returns the value of the '<em><b>Is Check</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the variable initialization needs to be checked as a predicate. This is a derivation of not ownedInit.type.conformsTo(self.type).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Check</em>' attribute.
	 * @see #setIsCheck(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getLoopParameterBinding_IsCheck()
	 * @generated
	 */
	boolean isIsCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Check</em>' attribute.
	 * @see #isIsCheck()
	 * @generated
	 */
	void setIsCheck(boolean value);

} // LoopParameterBinding
