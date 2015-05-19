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
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingCallBinding specifies the binding of a single variable as part of
 * a MappingCall. A value is bound to the variable. OPtionally isLoop may be true
 * to indicate that the value is a collection of values, each of which is to
 * be used as part of a distinct invocation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getBoundVariable <em>Bound Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled <em>Is Polled</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding()
 * @generated
 */
public interface MappingCallBinding extends Element {
	/**
	 * Returns the value of the '<em><b>Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Call</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The containing MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Call</em>' container reference.
	 * @see #setMappingCall(MappingCall)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding_MappingCall()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding
	 * @generated
	 */
	MappingCall getMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall <em>Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Call</em>' container reference.
	 * @see #getMappingCall()
	 * @generated
	 */
	void setMappingCall(MappingCall value);

	/**
	 * Returns the value of the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The variable with the mappingCall.referredMapping bound to the/a value
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bound Variable</em>' reference.
	 * @see #setBoundVariable(Variable)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding_BoundVariable()
	 * @generated
	 */
	Variable getBoundVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getBoundVariable <em>Bound Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Variable</em>' reference.
	 * @see #getBoundVariable()
	 * @generated
	 */
	void setBoundVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Is Polled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Polled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A polled MappingCallBinding requires invocation of the mapping to be deverred until all relevant properties are available.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Polled</em>' attribute.
	 * @see #isSetIsPolled()
	 * @see #unsetIsPolled()
	 * @see #setIsPolled(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding_IsPolled()
	 * @generated
	 */
	boolean isIsPolled();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled <em>Is Polled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Polled</em>' attribute.
	 * @see #isSetIsPolled()
	 * @see #unsetIsPolled()
	 * @see #isIsPolled()
	 * @generated
	 */
	void setIsPolled(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled <em>Is Polled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsPolled()
	 * @see #isIsPolled()
	 * @see #setIsPolled(boolean)
	 * @generated
	 */
	void unsetIsPolled();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled <em>Is Polled</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Polled</em>' attribute is set.
	 * @see #unsetIsPolled()
	 * @see #isIsPolled()
	 * @see #setIsPolled(boolean)
	 * @generated
	 */
	boolean isSetIsPolled();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value or collection of values to bind to boundVariable
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding_Value()
	 * @generated
	 */
	OCLExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OCLExpression value);

} // MappingCallBinding
