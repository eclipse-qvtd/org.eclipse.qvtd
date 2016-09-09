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

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getSlotExpression <em>Slot Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement()
 * @generated
 */
public interface SetStatement extends BottomStatement {
	/**
	 * Returns the value of the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot Expression</em>' containment reference.
	 * @see #setSlotExpression(VariableExp)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_SlotExpression()
	 * @generated
	 */
	VariableExp getSlotExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getSlotExpression <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slot Expression</em>' containment reference.
	 * @see #getSlotExpression()
	 * @generated
	 */
	void setSlotExpression(VariableExp value);

	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' reference.
	 * @see #setTargetProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_TargetProperty()
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' reference.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_Value()
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Opposite</em>' attribute.
	 * @see #isSetIsOpposite()
	 * @see #unsetIsOpposite()
	 * @see #setIsOpposite(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_IsOpposite()
	 * @generated
	 */
	boolean isIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #isSetIsOpposite()
	 * @see #unsetIsOpposite()
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsOpposite()
	 * @see #isIsOpposite()
	 * @see #setIsOpposite(boolean)
	 * @generated
	 */
	void unsetIsOpposite();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Opposite</em>' attribute is set.
	 * @see #unsetIsOpposite()
	 * @see #isIsOpposite()
	 * @see #setIsOpposite(boolean)
	 * @generated
	 */
	boolean isSetIsOpposite();

} // SetStatement
