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

import java.util.List;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CG Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMappingCallBindings <em>Mapping Call Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall()
 * @model
 * @generated
 */
public interface CGMappingCall extends CGValuedElement {

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getMappingCalls <em>Mapping Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' container reference.
	 * @see #setMapping(CGMapping)
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall_Mapping()
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getMappingCalls
	 * @model opposite="mappingCalls" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	CGMapping getMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping <em>Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' container reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(CGMapping value);

	/**
	 * Returns the value of the '<em><b>Mapping Call Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Call Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Call Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#getCGMappingCall_MappingCallBindings()
	 * @model containment="true"
	 * @generated
	 */
	List<CGMappingCallBinding> getMappingCallBindings();
} // CGMappingCall
