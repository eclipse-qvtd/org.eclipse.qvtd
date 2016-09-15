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
import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsEmit <em>Is Emit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement()
 * @generated
 */
public interface SetStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variable</em>' reference.
	 * @see #setTargetVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_TargetVariable()
	 * @generated
	 */
	VariableDeclaration getTargetVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Variable</em>' reference.
	 * @see #getTargetVariable()
	 * @generated
	 */
	void setTargetVariable(VariableDeclaration value);

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
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Emit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Emit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Emit</em>' attribute.
	 * @see #setIsEmit(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getSetStatement_IsEmit()
	 * @generated
	 */
	boolean isIsEmit();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsEmit <em>Is Emit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Emit</em>' attribute.
	 * @see #isIsEmit()
	 * @generated
	 */
	void setIsEmit(boolean value);

} // SetStatement
