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
package manualuml2rdbms.rdbms;

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
 *   <li>{@link manualuml2rdbms.rdbms.Table#getColumn <em>Column</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.Table#getSchema <em>Schema</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.Table#getTheKey <em>The Key</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.Table#getKey <em>Key</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.Table#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.rdbms.Column}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Column#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' containment reference list.
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable_Column()
	 * @see manualuml2rdbms.rdbms.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Column> getColumn();

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Schema#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' container reference.
	 * @see #setSchema(Schema)
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable_Schema()
	 * @see manualuml2rdbms.rdbms.Schema#getTables
	 * @model opposite="tables" required="true" transient="false"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.rdbms.Table#getSchema <em>Schema</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' container reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

	/**
	 * Returns the value of the '<em><b>The Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Key</em>' reference.
	 * @see #setTheKey(Key)
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable_TheKey()
	 * @model
	 * @generated
	 */
	Key getTheKey();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.rdbms.Table#getTheKey <em>The Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Key</em>' reference.
	 * @see #getTheKey()
	 * @generated
	 */
	void setTheKey(Key value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.rdbms.Key}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Key#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable_Key()
	 * @see manualuml2rdbms.rdbms.Key#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Key> getKey();

	/**
	 * Returns the value of the '<em><b>Foreign Key</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.rdbms.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key</em>' containment reference list.
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getTable_ForeignKey()
	 * @see manualuml2rdbms.rdbms.ForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKey();

} // Table
