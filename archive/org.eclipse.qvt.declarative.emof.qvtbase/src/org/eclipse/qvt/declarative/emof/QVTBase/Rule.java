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
 * $Id: Rule.java,v 1.2 2009/01/14 19:13:04 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getRule()
 * @model abstract="true"
 * @generated
 */
public interface Rule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.QVTBase.Domain}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Domain#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getRule_Domain()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Domain#getRule
	 * @model opposite="rule" containment="true"
	 * @generated
	 */
	EList<Domain> getDomain();

	/**
	 * Returns the value of the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides</em>' reference.
	 * @see #setOverrides(Rule)
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getRule_Overrides()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='overriden'"
	 * @generated
	 */
	Rule getOverrides();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getOverrides <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides</em>' reference.
	 * @see #getOverrides()
	 * @generated
	 */
	void setOverrides(Rule value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(Transformation)
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage#getRule_Transformation()
	 * @see org.eclipse.qvt.declarative.emof.QVTBase.Transformation#getRule
	 * @model opposite="rule" resolveProxies="false"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTBase.Rule#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(Transformation value);

} // Rule
