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
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getReverse <em>Reverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class)
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#getAssociation_Destination()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getReverse
	 * @model opposite="reverse" required="true"
	 * @generated
	 */
	org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class getDestination();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class)
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#getAssociation_Source()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class#getForward
	 * @model opposite="forward" required="true"
	 * @generated
	 */
	org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class value);

} // Association
