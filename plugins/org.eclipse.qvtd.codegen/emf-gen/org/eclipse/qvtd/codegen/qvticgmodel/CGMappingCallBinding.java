/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping Call Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValueOrValues <em>Value Or Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#isLoop <em>Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding()
 * @model
 * @generated
 */
public interface CGMappingCallBinding extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Value Or Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Or Values</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Or Values</em>' containment reference.
	 * @see #setValueOrValues(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding_ValueOrValues()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getValueOrValues();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValueOrValues <em>Value Or Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Or Values</em>' containment reference.
	 * @see #getValueOrValues()
	 * @generated
	 */
	void setValueOrValues(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Loop</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' attribute.
	 * @see #setLoop(boolean)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCallBinding_Loop()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#isLoop <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' attribute.
	 * @see #isLoop()
	 * @generated
	 */
	void setLoop(boolean value);

} // CGMappingCallBinding
