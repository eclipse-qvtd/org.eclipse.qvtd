/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classescstraces;

import org.eclipse.emf.ecore.EObject;

import example2.classes.Root;
import example2.classescs.RootCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root CS2 Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescstraces.RootCS2Root#getRootCS <em>Root CS</em>}</li>
 *   <li>{@link example2.classescstraces.RootCS2Root#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see example2.classescstraces.ClassescstracesPackage#getRootCS2Root()
 * @model
 * @generated
 */
public interface RootCS2Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Root CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root CS</em>' reference.
	 * @see #setRootCS(RootCS)
	 * @see example2.classescstraces.ClassescstracesPackage#getRootCS2Root_RootCS()
	 * @model required="true"
	 * @generated
	 */
	RootCS getRootCS();

	/**
	 * Sets the value of the '{@link example2.classescstraces.RootCS2Root#getRootCS <em>Root CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root CS</em>' reference.
	 * @see #getRootCS()
	 * @generated
	 */
	void setRootCS(RootCS value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Root)
	 * @see example2.classescstraces.ClassescstracesPackage#getRootCS2Root_Root()
	 * @model required="true"
	 * @generated
	 */
	Root getRoot();

	/**
	 * Sets the value of the '{@link example2.classescstraces.RootCS2Root#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Root value);

} // RootCS2Root
