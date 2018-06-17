/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classes.Package#getOwnedClasses <em>Owned Classes</em>}</li>
 *   <li>{@link classes.Package#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @see classes.ClassesPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends NamedElement, Namespace {
	/**
	 * Returns the value of the '<em><b>Owned Classes</b></em>' containment reference list.
	 * The list contents are of type {@link classes.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Classes</em>' containment reference list.
	 * @see classes.ClassesPackage#getPackage_OwnedClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<classes.Class> getOwnedClasses();

	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link classes.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see classes.ClassesPackage#getPackage_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Package> getOwnedPackages();

} // Package
