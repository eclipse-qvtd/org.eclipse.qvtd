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
package example2.classescstraces;

import org.eclipse.emf.ecore.EObject;

import example2.classescs.ClassCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class CS2 Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescstraces.ClassCS2Class#getClassCS <em>Class CS</em>}</li>
 *   <li>{@link example2.classescstraces.ClassCS2Class#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @see example2.classescstraces.ClassescstracesPackage#getClassCS2Class()
 * @model
 * @generated
 */
public interface ClassCS2Class extends EObject {
	/**
	 * Returns the value of the '<em><b>Class CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class CS</em>' reference.
	 * @see #setClassCS(ClassCS)
	 * @see example2.classescstraces.ClassescstracesPackage#getClassCS2Class_ClassCS()
	 * @model required="true"
	 * @generated
	 */
	ClassCS getClassCS();

	/**
	 * Sets the value of the '{@link example2.classescstraces.ClassCS2Class#getClassCS <em>Class CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class CS</em>' reference.
	 * @see #getClassCS()
	 * @generated
	 */
	void setClassCS(ClassCS value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(example2.classes.Class)
	 * @see example2.classescstraces.ClassescstracesPackage#getClassCS2Class_Class()
	 * @model required="true"
	 * @generated
	 */
	example2.classes.Class getClass_();

	/**
	 * Sets the value of the '{@link example2.classescstraces.ClassCS2Class#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(example2.classes.Class value);

} // ClassCS2Class
