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
 * A representation of the model object '<em><b>Iterate Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.IterateExpCS#getAccVar <em>Acc Var</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getIterateExpCS()
 * @model
 * @generated
 */
public interface IterateExpCS extends LoopExpCS
{
  /**
	 * Returns the value of the '<em><b>Acc Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Acc Var</em>' containment reference.
	 * @see #setAccVar(AccVarCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getIterateExpCS_AccVar()
	 * @model containment="true"
	 * @generated
	 */
  AccVarCS getAccVar();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.IterateExpCS#getAccVar <em>Acc Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acc Var</em>' containment reference.
	 * @see #getAccVar()
	 * @generated
	 */
  void setAccVar(AccVarCS value);

} // IterateExpCS
