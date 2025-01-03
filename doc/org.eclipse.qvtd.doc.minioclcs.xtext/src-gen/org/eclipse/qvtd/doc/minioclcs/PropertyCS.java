/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPropertyCS()
 * @model
 * @generated
 */
public interface PropertyCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPropertyCS_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(PathNameCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPropertyCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getTypeRef();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
  void setTypeRef(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(MultiplicityCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getPropertyCS_Multiplicity()
	 * @model containment="true"
	 * @generated
	 */
  MultiplicityCS getMultiplicity();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.PropertyCS#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
  void setMultiplicity(MultiplicityCS value);

} // PropertyCS
