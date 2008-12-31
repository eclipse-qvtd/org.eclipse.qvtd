/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Domain.java,v 1.4 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getDomain()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TypedModelExistsWarning\r\nTypedModelDefinedByTransformation\r\nCheckableOrEnforceable\r\n\r\n'"
 * @generated
 */
public interface Domain extends ENamedElement {

	/**
	 * Returns the value of the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Checkable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Checkable</em>' attribute.
	 * @see #isSetIsCheckable()
	 * @see #unsetIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getDomain_IsCheckable()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsCheckable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Checkable</em>' attribute.
	 * @see #isSetIsCheckable()
	 * @see #unsetIsCheckable()
	 * @see #isIsCheckable()
	 * @generated
	 */
	void setIsCheckable(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsCheckable()
	 * @see #isIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @generated
	 */
	void unsetIsCheckable();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsCheckable <em>Is Checkable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Checkable</em>' attribute is set.
	 * @see #unsetIsCheckable()
	 * @see #isIsCheckable()
	 * @see #setIsCheckable(boolean)
	 * @generated
	 */
	boolean isSetIsCheckable();

	/**
	 * Returns the value of the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforceable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforceable</em>' attribute.
	 * @see #isSetIsEnforceable()
	 * @see #unsetIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getDomain_IsEnforceable()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isIsEnforceable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforceable</em>' attribute.
	 * @see #isSetIsEnforceable()
	 * @see #unsetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @generated
	 */
	void setIsEnforceable(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @generated
	 */
	void unsetIsEnforceable();

	/**
	 * Returns whether the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#isIsEnforceable <em>Is Enforceable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Enforceable</em>' attribute is set.
	 * @see #unsetIsEnforceable()
	 * @see #isIsEnforceable()
	 * @see #setIsEnforceable(boolean)
	 * @generated
	 */
	boolean isSetIsEnforceable();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Rule#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getDomain_Rule()
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.Rule#getDomain
	 * @model opposite="domain" required="true"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see #setTypedModel(TypedModel)
	 * @see org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage#getDomain_TypedModel()
	 * @model
	 * @generated
	 */
	TypedModel getTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTBase.Domain#getTypedModel <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Model</em>' reference.
	 * @see #getTypedModel()
	 * @generated
	 */
	void setTypedModel(TypedModel value);

} // Domain
