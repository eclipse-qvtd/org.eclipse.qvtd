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
package simpleuml2rdbms.rdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.rdbms.Key#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Key#getColumn <em>Column</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getKey()
 * @model
 * @generated
 */
public interface Key extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Table#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getKey_Owner()
	 * @see simpleuml2rdbms.rdbms.Table#getKeys
	 * @model opposite="keys" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.Key#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.Column}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Column#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getKey_Column()
	 * @see simpleuml2rdbms.rdbms.Column#getKeys
	 * @model opposite="keys"
	 * @generated
	 */
	EList<Column> getColumn();

} // Key
