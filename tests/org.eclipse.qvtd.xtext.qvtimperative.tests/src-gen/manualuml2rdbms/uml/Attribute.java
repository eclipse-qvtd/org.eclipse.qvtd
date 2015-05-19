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
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.Attribute#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml.UMLPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends UMLModelElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml.Classifier#getTypeOpposite <em>Type Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see manualuml2rdbms.uml.UMLPackage#getAttribute_Type()
	 * @see manualuml2rdbms.uml.Classifier#getTypeOpposite
	 * @model opposite="typeOpposite" required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml.Attribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(manualuml2rdbms.uml.Class)
	 * @see manualuml2rdbms.uml.UMLPackage#getAttribute_Owner()
	 * @see manualuml2rdbms.uml.Class#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	manualuml2rdbms.uml.Class getOwner();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml.Attribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(manualuml2rdbms.uml.Class value);

} // Attribute
