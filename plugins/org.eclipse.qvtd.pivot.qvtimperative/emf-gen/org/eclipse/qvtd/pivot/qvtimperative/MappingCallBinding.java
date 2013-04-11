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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;

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
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getBoundVariable <em>Bound Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsLoop <em>Is Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding()
 * @model
 * @generated
 */
public interface MappingCallBinding extends EObject, Element {
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
	 * @model opposite="binding" transient="false"
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
	 * @model required="true"
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
	 * @model containment="true" required="true"
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

	/**
	 * Returns the value of the '<em><b>Is Loop</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether the value is a collection of values to be looped over.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Loop</em>' attribute.
	 * @see #setIsLoop(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingCallBinding_IsLoop()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsLoop <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Loop</em>' attribute.
	 * @see #isIsLoop()
	 * @generated
	 */
	void setIsLoop(boolean value);

} // MappingCallBinding
