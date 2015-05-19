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
package simpleuml2rdbms.uml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.Class#getForward <em>Forward</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.Class#getGeneral <em>General</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.Class#getGeneralOpposite <em>General Opposite</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.Class#getReverse <em>Reverse</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.uml.UMLPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Attribute}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClass_Attributes()
	 * @see simpleuml2rdbms.uml.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Association}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClass_Forward()
	 * @see simpleuml2rdbms.uml.Association#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Association> getForward();

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Class}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Class#getGeneralOpposite <em>General Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClass_General()
	 * @see simpleuml2rdbms.uml.Class#getGeneralOpposite
	 * @model opposite="generalOpposite"
	 * @generated
	 */
	EList<Class> getGeneral();

	/**
	 * Returns the value of the '<em><b>General Opposite</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Class}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Class#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Opposite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Opposite</em>' reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClass_GeneralOpposite()
	 * @see simpleuml2rdbms.uml.Class#getGeneral
	 * @model opposite="general"
	 * @generated
	 */
	EList<Class> getGeneralOpposite();

	/**
	 * Returns the value of the '<em><b>Reverse</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.uml.Association}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.uml.Association#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse</em>' reference list.
	 * @see simpleuml2rdbms.uml.UMLPackage#getClass_Reverse()
	 * @see simpleuml2rdbms.uml.Association#getDestination
	 * @model opposite="destination" derived="true"
	 * @generated
	 */
	EList<Association> getReverse();

} // Class
