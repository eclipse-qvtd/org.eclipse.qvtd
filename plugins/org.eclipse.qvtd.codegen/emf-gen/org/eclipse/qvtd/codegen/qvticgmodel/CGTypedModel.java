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

import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex <em>Model Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTypedModel()
 * @model
 * @generated
 */
public interface CGTypedModel extends CGNamedElement {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getTypedModels <em>Typed Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(CGTransformation)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTypedModel_Transformation()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getTypedModels
	 * @model opposite="typedModels" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGTransformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(CGTransformation value);

	/**
	 * Returns the value of the '<em><b>Model Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Index</em>' attribute.
	 * @see #setModelIndex(int)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGTypedModel_ModelIndex()
	 * @model
	 * @generated
	 */
	int getModelIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex <em>Model Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Index</em>' attribute.
	 * @see #getModelIndex()
	 * @generated
	 */
	void setModelIndex(int value);

} // CGTypedModel
