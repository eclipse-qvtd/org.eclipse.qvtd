/**
 * <copyright>
 * 
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Realized Variable Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getOwningRealizedVariable <em>Owning Realized Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getInit <em>Init</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getExecutorProperty <em>Executor Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariablePart()
 * @model
 * @generated
 */
public interface CGRealizedVariablePart extends CGValuedElement {
	/**
	 * Returns the value of the '<em><b>Owning Realized Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Realized Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Realized Variable</em>' container reference.
	 * @see #setOwningRealizedVariable(CGRealizedVariable)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariablePart_OwningRealizedVariable()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwnedParts
	 * @model opposite="ownedParts" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGRealizedVariable getOwningRealizedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getOwningRealizedVariable <em>Owning Realized Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Realized Variable</em>' container reference.
	 * @see #getOwningRealizedVariable()
	 * @generated
	 */
	void setOwningRealizedVariable(CGRealizedVariable value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(CGValuedElement)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariablePart_Init()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CGValuedElement getInit();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(CGValuedElement value);

	/**
	 * Returns the value of the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The shared type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Executor Property</em>' reference.
	 * @see #setExecutorProperty(CGExecutorProperty)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariablePart_ExecutorProperty()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGExecutorProperty getExecutorProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart#getExecutorProperty <em>Executor Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executor Property</em>' reference.
	 * @see #getExecutorProperty()
	 * @generated
	 */
	void setExecutorProperty(CGExecutorProperty value);

} // CGRealizedVariablePart
