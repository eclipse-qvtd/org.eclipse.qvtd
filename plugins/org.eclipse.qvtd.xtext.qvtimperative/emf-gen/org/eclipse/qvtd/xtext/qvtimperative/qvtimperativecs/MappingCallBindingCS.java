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
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Call Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#isIsLoop <em>Is Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS()
 * @model
 * @generated
 */
public interface MappingCallBindingCS extends ExpCS {
	/**
	 * Returns the value of the '<em><b>Mapping Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Call</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Call</em>' container reference.
	 * @see #setMappingCall(MappingCallCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_MappingCall()
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS#getBindings
	 * @model opposite="bindings" transient="false"
	 * @generated
	 */
	MappingCallCS getMappingCall();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getMappingCall <em>Mapping Call</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Call</em>' container reference.
	 * @see #getMappingCall()
	 * @generated
	 */
	void setMappingCall(MappingCallCS value);

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
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_ReferredVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getReferredVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getReferredVariable <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Variable</em>' reference.
	 * @see #getReferredVariable()
	 * @generated
	 */
	void setReferredVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Is Loop</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Loop</em>' attribute.
	 * @see #setIsLoop(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingCallBindingCS_IsLoop()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean"
	 * @generated
	 */
	boolean isIsLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS#isIsLoop <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Loop</em>' attribute.
	 * @see #isIsLoop()
	 * @generated
	 */
	void setIsLoop(boolean value);

} // MappingCallBindingCS
