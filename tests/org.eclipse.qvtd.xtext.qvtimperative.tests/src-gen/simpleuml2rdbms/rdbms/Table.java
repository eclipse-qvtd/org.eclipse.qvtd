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
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.rdbms.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Table#getSchema <em>Schema</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Table#getKeys <em>Keys</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.Table#getForeignKeys <em>Foreign Keys</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.Column}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Column#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getTable_Columns()
	 * @see simpleuml2rdbms.rdbms.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Schema#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' container reference.
	 * @see #setSchema(Schema)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getTable_Schema()
	 * @see simpleuml2rdbms.rdbms.Schema#getTables
	 * @model opposite="tables" required="true" transient="false"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.Table#getSchema <em>Schema</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' container reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.Key}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Key#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' containment reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getTable_Keys()
	 * @see simpleuml2rdbms.rdbms.Key#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Key> getKeys();

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' containment reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' containment reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getTable_ForeignKeys()
	 * @see simpleuml2rdbms.rdbms.ForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

} // Table
