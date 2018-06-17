/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS#getLast <em>Last</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getCollectionLiteralPartCS()
 * @model
 * @generated
 */
public interface CollectionLiteralPartCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference.
	 * @see #setFirst(ExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getCollectionLiteralPartCS_First()
	 * @model containment="true"
	 * @generated
	 */
  ExpCS getFirst();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
  void setFirst(ExpCS value);

  /**
	 * Returns the value of the '<em><b>Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Last</em>' containment reference.
	 * @see #setLast(ExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getCollectionLiteralPartCS_Last()
	 * @model containment="true"
	 * @generated
	 */
  ExpCS getLast();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.CollectionLiteralPartCS#getLast <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last</em>' containment reference.
	 * @see #getLast()
	 * @generated
	 */
  void setLast(ExpCS value);

} // CollectionLiteralPartCS
