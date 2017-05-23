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
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.ReferringElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCall specifies the invocation of a referredMapping with a set of bindings.
 * An installed mapping is invoked asynchronously whenever suitable values are available on consumed connections.
 * An invoked mapping is invoked synchronously with values provided by the caller.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getOwnedMappingParameterBindings <em>Owned Mapping Parameter Bindings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall <em>Is Install</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke <em>Is Invoke</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping <em>Referred Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredNames <em>Referred Names</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferringNames <em>Referring Names</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall()
 * @generated
 */
public interface MappingCall extends MappingStatement, ReferringElement {
	/**
	 * Returns the value of the '<em><b>Owned Mapping Parameter Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Set of bindings of variables or expressions to forma parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Mapping Parameter Bindings</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_OwnedMappingParameterBindings()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getOwningMappingCall
	 * @generated
	 */
	EList<MappingParameterBinding> getOwnedMappingParameterBindings();

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
	 * Returns the value of the '<em><b>Referred Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Names</em>' attribute list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_ReferredNames()
	 * @generated
	 */
	EList<String> getReferredNames();

	/**
	 * Returns the value of the '<em><b>Referring Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referring Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Names</em>' attribute list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_ReferringNames()
	 * @generated
	 */
	EList<String> getReferringNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateMatchingCallBindings(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNotBothInstallAndInvoke(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueCallBindings(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * Returns the value of the '<em><b>Is Install</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An install MappingCall declares a MappingCall that consumes one or more connections and appends to zero or more connections.
	 * Invocations of the mapping are driven by the availability of values in the connection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Install</em>' attribute.
	 * @see #setIsInstall(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_IsInstall()
	 * @generated
	 */
	boolean isIsInstall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall <em>Is Install</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An invoke MappingCall invokes a Mapping that uses one or more values and appends to zero or more connections.
	 * Invocations of the mapping is requested by the caller.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Invoke</em>' attribute.
	 * @see #setIsInvoke(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCall_IsInvoke()
	 * @generated
	 */
	boolean isIsInvoke();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Invoke</em>' attribute.
	 * @see #isIsInvoke()
	 * @generated
	 */
	void setIsInvoke(boolean value);

} // MappingCall
