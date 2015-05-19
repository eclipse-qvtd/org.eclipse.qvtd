/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package manualuml2rdbms.uml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml.Association#getSource <em>Source</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.Association#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml.UMLPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml.Class#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(manualuml2rdbms.uml.Class)
	 * @see manualuml2rdbms.uml.UMLPackage#getAssociation_Source()
	 * @see manualuml2rdbms.uml.Class#getForward
	 * @model opposite="forward" required="true"
	 * @generated
	 */
	manualuml2rdbms.uml.Class getSource();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(manualuml2rdbms.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(manualuml2rdbms.uml.Class)
	 * @see manualuml2rdbms.uml.UMLPackage#getAssociation_Destination()
	 * @model required="true"
	 * @generated
	 */
	manualuml2rdbms.uml.Class getDestination();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml.Association#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(manualuml2rdbms.uml.Class value);

} // Association
