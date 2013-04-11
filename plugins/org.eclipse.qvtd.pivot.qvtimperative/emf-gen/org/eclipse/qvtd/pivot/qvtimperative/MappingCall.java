/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.ReferringElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCall specifies the invocation of a referredMapping with a set of bindings
 * of the bound variables of the referredMapping to values provided in the invocation.
 * Where Collections of values are provided for isLoop bindings, a distinct invocation
 * is performed for each distinct permutation of Collection elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping <em>Referred Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall()
 * @model
 * @generated
 */
public interface MappingCall extends EObject, OCLExpression, ReferringElement {
	/**
	 * Returns the value of the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Mapping invoked by the MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referred Mapping</em>' reference.
	 * @see #setReferredMapping(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_ReferredMapping()
	 * @model required="true"
	 * @generated
	 */
	Mapping getReferredMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping</em>' reference.
	 * @see #getReferredMapping()
	 * @generated
	 */
	void setReferredMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Set of value to bound variable bindings.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_Binding()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall
	 * @model opposite="mappingCall" containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingCallBinding> getBinding();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Mapping that provides the invocation context for this MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_Context()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingCall
	 * @model opposite="mappingCall" required="true" transient="false"
	 * @generated
	 */
	Mapping getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Mapping value);

} // MappingCall
