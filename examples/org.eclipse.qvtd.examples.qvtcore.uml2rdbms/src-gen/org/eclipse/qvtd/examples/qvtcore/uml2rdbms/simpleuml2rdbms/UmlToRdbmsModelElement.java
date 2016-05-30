/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml To Rdbms Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getUmlToRdbmsModelElement()
 * @model abstract="true"
 * @generated
 */
public interface UmlToRdbmsModelElement extends EObject {
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
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage#getUmlToRdbmsModelElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // UmlToRdbmsModelElement
