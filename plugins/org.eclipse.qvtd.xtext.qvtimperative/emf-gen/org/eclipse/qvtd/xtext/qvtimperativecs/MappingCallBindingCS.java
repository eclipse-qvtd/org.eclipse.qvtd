/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#isIsPolled <em>Is Polled</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS()
 * @model
 * @generated
 */
public interface MappingCallBindingCS extends ExpCS {
	/**
	 * Returns the value of the '<em><b>Is Polled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Polled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Polled</em>' attribute.
	 * @see #setIsPolled(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_IsPolled()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsPolled();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#isIsPolled <em>Is Polled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Polled</em>' attribute.
	 * @see #isIsPolled()
	 * @generated
	 */
	void setIsPolled(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedBindings <em>Owned Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Mapping Call</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #setOwningMappingCall(MappingCallCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_OwningMappingCall()
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedBindings
	 * @model opposite="ownedBindings" transient="false"
	 * @generated
	 */
	MappingCallCS getOwningMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwningMappingCall <em>Owning Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Mapping Call</em>' container reference.
	 * @see #getOwningMappingCall()
	 * @generated
	 */
	void setOwningMappingCall(MappingCallCS value);

	/**
	 * Returns the value of the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Variable</em>' reference.
	 * @see #setReferredVariable(Variable)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_ReferredVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getReferredVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Variable</em>' reference.
	 * @see #getReferredVariable()
	 * @generated
	 */
	void setReferredVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference.
	 * @see #setOwnedValue(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_OwnedValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getOwnedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS#getOwnedValue <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Value</em>' containment reference.
	 * @see #getOwnedValue()
	 * @generated
	 */
	void setOwnedValue(ExpCS value);

} // MappingCallBindingCS
