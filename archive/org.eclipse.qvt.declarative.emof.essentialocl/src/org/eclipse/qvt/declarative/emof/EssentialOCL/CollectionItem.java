/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CollectionItem.java,v 1.1 2008/07/23 09:56:32 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.CollectionItem#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getCollectionItem()
 * @model
 * @generated
 */
public interface CollectionItem extends CollectionLiteralPart {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference.
	 * @see #setItem(OclExpression)
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getCollectionItem_Item()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.CollectionItem#getItem <em>Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' containment reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(OclExpression value);

} // CollectionItem
