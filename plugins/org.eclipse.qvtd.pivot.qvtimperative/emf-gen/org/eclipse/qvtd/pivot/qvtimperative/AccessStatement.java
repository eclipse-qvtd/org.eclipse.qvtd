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

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceVariable <em>Source Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAccessStatement()
 * @generated
 */
public interface AccessStatement extends VariableStatement {
	/**
	 * Returns the value of the '<em><b>Source Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Variable</em>' reference.
	 * @see #setSourceVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAccessStatement_SourceVariable()
	 * @generated
	 */
	VariableDeclaration getSourceVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceVariable <em>Source Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Variable</em>' reference.
	 * @see #getSourceVariable()
	 * @generated
	 */
	void setSourceVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Source Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Property</em>' reference.
	 * @see #setSourceProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAccessStatement_SourceProperty()
	 * @generated
	 */
	Property getSourceProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceProperty <em>Source Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Property</em>' reference.
	 * @see #getSourceProperty()
	 * @generated
	 */
	void setSourceProperty(Property value);

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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getAccessStatement_IsOpposite()
	 * @generated
	 */
	boolean isIsOpposite();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#isIsOpposite <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Opposite</em>' attribute.
	 * @see #isIsOpposite()
	 * @generated
	 */
	void setIsOpposite(boolean value);

} // AccessStatement
