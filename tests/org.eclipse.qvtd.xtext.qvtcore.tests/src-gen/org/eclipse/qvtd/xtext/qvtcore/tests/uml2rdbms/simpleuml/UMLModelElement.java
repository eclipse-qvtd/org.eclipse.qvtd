/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.UMLModelElement#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.UMLModelElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage#getUMLModelElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage#getUMLModelElement_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.UMLModelElement#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage#getUMLModelElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.UMLModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // UMLModelElement
