/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
package test.simpleuml;

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
 *   <li>{@link test.simpleuml.Class#getGeneral <em>General</em>}</li>
 *   <li>{@link test.simpleuml.Class#getForward <em>Forward</em>}</li>
 *   <li>{@link test.simpleuml.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link test.simpleuml.Class#getReverse <em>Reverse</em>}</li>
 *   <li>{@link test.simpleuml.Class#getGeneralOpposite <em>General Opposite</em>}</li>
 * </ul>
 *
 * @see test.simpleuml.SimpleumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link test.simpleuml.Class}.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Class#getGeneralOpposite <em>General Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClass_General()
	 * @see test.simpleuml.Class#getGeneralOpposite
	 * @model opposite="generalOpposite"
	 * @generated
	 */
	EList<Class> getGeneral();

	/**
	 * Returns the value of the '<em><b>Forward</b></em>' reference list.
	 * The list contents are of type {@link test.simpleuml.Association}.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClass_Forward()
	 * @see test.simpleuml.Association#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Association> getForward();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link test.simpleuml.Attribute}.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClass_Attributes()
	 * @see test.simpleuml.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Reverse</b></em>' reference list.
	 * The list contents are of type {@link test.simpleuml.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse</em>' reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClass_Reverse()
	 * @model derived="true"
	 * @generated
	 */
	EList<Association> getReverse();

	/**
	 * Returns the value of the '<em><b>General Opposite</b></em>' reference list.
	 * The list contents are of type {@link test.simpleuml.Class}.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Class#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Opposite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Opposite</em>' reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClass_GeneralOpposite()
	 * @see test.simpleuml.Class#getGeneral
	 * @model opposite="general"
	 * @generated
	 */
	EList<Class> getGeneralOpposite();

} // Class
