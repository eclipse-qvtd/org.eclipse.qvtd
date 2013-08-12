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

import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Realized Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType <em>Executor Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMappingExp <em>Mapping Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariable()
 * @model
 * @generated
 */
public interface CGRealizedVariable extends CGVariable {

	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(CGTypedModel)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariable_TypedModel()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGTypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(CGTypedModel value);

	/**
	 * Returns the value of the '<em><b>Executor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The shared type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Executor Type</em>' reference.
	 * @see #setExecutorType(CGExecutorType)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariable_ExecutorType()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	CGExecutorType getExecutorType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType <em>Executor Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executor Type</em>' reference.
	 * @see #getExecutorType()
	 * @generated
	 */
	void setExecutorType(CGExecutorType value);

	/**
	 * Returns the value of the '<em><b>Mapping Exp</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Exp</em>' container reference.
	 * @see #setMappingExp(CGMappingExp)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGRealizedVariable_MappingExp()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getRealizedVariables
	 * @model opposite="realizedVariables" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMappingExp getMappingExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMappingExp <em>Mapping Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Exp</em>' container reference.
	 * @see #getMappingExp()
	 * @generated
	 */
	void setMappingExp(CGMappingExp value);
} // CGRealizedVariable
