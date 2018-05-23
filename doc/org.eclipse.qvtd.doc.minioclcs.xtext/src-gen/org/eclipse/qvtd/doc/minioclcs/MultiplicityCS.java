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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isOpt <em>Opt</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isMult <em>Mult</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getLowerInt <em>Lower Int</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getUpperInt <em>Upper Int</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isUpperMult <em>Upper Mult</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS()
 * @model
 * @generated
 */
public interface MultiplicityCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Opt</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opt</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Opt</em>' attribute.
	 * @see #setOpt(boolean)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_Opt()
	 * @model
	 * @generated
	 */
  boolean isOpt();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isOpt <em>Opt</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opt</em>' attribute.
	 * @see #isOpt()
	 * @generated
	 */
  void setOpt(boolean value);

  /**
	 * Returns the value of the '<em><b>Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mult</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mult</em>' attribute.
	 * @see #setMult(boolean)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_Mult()
	 * @model
	 * @generated
	 */
  boolean isMult();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isMult <em>Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mult</em>' attribute.
	 * @see #isMult()
	 * @generated
	 */
  void setMult(boolean value);

  /**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(int)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_Mandatory()
	 * @model
	 * @generated
	 */
  int getMandatory();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #getMandatory()
	 * @generated
	 */
  void setMandatory(int value);

  /**
	 * Returns the value of the '<em><b>Lower Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Int</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Int</em>' attribute.
	 * @see #setLowerInt(int)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_LowerInt()
	 * @model
	 * @generated
	 */
  int getLowerInt();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getLowerInt <em>Lower Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Int</em>' attribute.
	 * @see #getLowerInt()
	 * @generated
	 */
  void setLowerInt(int value);

  /**
	 * Returns the value of the '<em><b>Upper Int</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Int</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Int</em>' attribute.
	 * @see #setUpperInt(int)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_UpperInt()
	 * @model
	 * @generated
	 */
  int getUpperInt();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#getUpperInt <em>Upper Int</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Int</em>' attribute.
	 * @see #getUpperInt()
	 * @generated
	 */
  void setUpperInt(int value);

  /**
	 * Returns the value of the '<em><b>Upper Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Mult</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Mult</em>' attribute.
	 * @see #setUpperMult(boolean)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getMultiplicityCS_UpperMult()
	 * @model
	 * @generated
	 */
  boolean isUpperMult();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.MultiplicityCS#isUpperMult <em>Upper Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Mult</em>' attribute.
	 * @see #isUpperMult()
	 * @generated
	 */
  void setUpperMult(boolean value);

} // MultiplicityCS
