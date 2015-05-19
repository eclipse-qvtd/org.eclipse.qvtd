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
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.rdbms.Column#getType <em>Type</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Column#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Column#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Column#getKeys <em>Keys</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getColumn_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getColumn_Owner()
	 * @see simpleuml2rdbms.rdbms.Table#getColumns
	 * @model opposite="columns" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.Column#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.ForeignKey#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getColumn_ForeignKeys()
	 * @see simpleuml2rdbms.rdbms.ForeignKey#getColumns
	 * @model opposite="columns"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.Key}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Key#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getColumn_Keys()
	 * @see simpleuml2rdbms.rdbms.Key#getColumn
	 * @model opposite="column"
	 * @generated
	 */
	EList<Key> getKeys();

} // Column
