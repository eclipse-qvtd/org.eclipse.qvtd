/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: TestRule.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestRule#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestRule()
 * @model
 * @generated
 */
public interface TestRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#getTestRule_Contents()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<EObject> getContents();

} // TestRule
