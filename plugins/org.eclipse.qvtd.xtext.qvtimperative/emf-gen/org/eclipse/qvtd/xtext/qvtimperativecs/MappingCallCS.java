/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInstall <em>Is Install</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInvoke <em>Is Invoke</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedBindings <em>Owned Bindings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS()
 * @model
 * @generated
 */
public interface MappingCallCS extends MappingStatementCS {
	/**
	 * Returns the value of the '<em><b>Is Install</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Install</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Install</em>' attribute.
	 * @see #setIsInstall(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS_IsInstall()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsInstall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInstall <em>Is Install</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Install</em>' attribute.
	 * @see #isIsInstall()
	 * @generated
	 */
	void setIsInstall(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Invoke</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Invoke</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Invoke</em>' attribute.
	 * @see #setIsInvoke(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS_IsInvoke()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsInvoke();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#isIsInvoke <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invoke</em>' attribute.
	 * @see #isIsInvoke()
	 * @generated
	 */
	void setIsInvoke(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Mapping</em>' reference.
	 * @see #setReferredMapping(Mapping)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS_ReferredMapping()
	 * @model resolveProxies="false" derived="true"
	 * @generated
	 */
	Mapping getReferredMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getReferredMapping <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Mapping</em>' reference.
	 * @see #getReferredMapping()
	 * @generated
	 */
	void setReferredMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterBindingCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterBindingCS#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS_OwnedBindings()
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterBindingCS#getOwningMappingCall
	 * @model opposite="owningMappingCall" containment="true" ordered="false"
	 * @generated
	 */
	EList<MappingParameterBindingCS> getOwnedBindings();

	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#getMappingCallCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

} // MappingCallCS
