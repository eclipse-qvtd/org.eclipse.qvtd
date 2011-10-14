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
 * $Id: Mapping.java,v 1.2 2009/01/14 21:37:13 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getRefinement <em>Refinement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedName\r\nDomainTypedModelsMatchModelParameters'"
 * @generated
 */
public interface Mapping extends Rule, Area {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getMapping_Specification()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getRefinement
	 * @model opposite="refinement" ordered="false"
	 * @generated
	 */
	EList<Mapping> getSpecification();

	/**
	 * Returns the value of the '<em><b>Local</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getMapping_Local()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getContext
	 * @model opposite="context" containment="true" ordered="false"
	 * @generated
	 */
	EList<Mapping> getLocal();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(Mapping)
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getMapping_Context()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getLocal
	 * @model opposite="local" resolveProxies="false"
	 * @generated
	 */
	Mapping getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Mapping value);

	/**
	 * Returns the value of the '<em><b>Refinement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinement</em>' reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#getMapping_Refinement()
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.Mapping#getSpecification
	 * @model opposite="specification" ordered="false"
	 * @generated
	 */
	EList<Mapping> getRefinement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Mapping> getAllMappings();

} // Mapping
