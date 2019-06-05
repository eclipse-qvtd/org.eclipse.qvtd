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
 * A representation of the model object '<em><b>Boolean Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.BooleanExpCS#isBoolSymbol <em>Bool Symbol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getBooleanExpCS()
 * @model
 * @generated
 */
public interface BooleanExpCS extends BooleanLiteralExpCS
{
  /**
	 * Returns the value of the '<em><b>Bool Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Symbol</em>' attribute.
	 * @see #setBoolSymbol(boolean)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getBooleanExpCS_BoolSymbol()
	 * @model
	 * @generated
	 */
  boolean isBoolSymbol();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.BooleanExpCS#isBoolSymbol <em>Bool Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool Symbol</em>' attribute.
	 * @see #isBoolSymbol()
	 * @generated
	 */
  void setBoolSymbol(boolean value);

} // BooleanExpCS
