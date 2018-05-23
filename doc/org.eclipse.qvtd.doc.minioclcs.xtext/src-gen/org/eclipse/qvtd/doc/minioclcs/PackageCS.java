/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PackageCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PackageCS#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PackageCS#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends CSTrace
{
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
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPackageCS_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.PackageCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.minioclcs.PackageCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPackageCS_Packages()
	 * @model containment="true"
	 * @generated
	 */
  EList<PackageCS> getPackages();

  /**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.minioclcs.ClassCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPackageCS_Classes()
	 * @model containment="true"
	 * @generated
	 */
  EList<ClassCS> getClasses();

} // PackageCS
