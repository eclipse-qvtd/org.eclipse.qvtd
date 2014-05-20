/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
package test.simplerdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simplerdbms.Table#getColumn <em>Column</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getSchema <em>Schema</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getTheKey <em>The Key</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getKey <em>Key</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simplerdbms.SimplerdbmsPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' containment reference list.
	 * The list contents are of type {@link test.simplerdbms.Column}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Column#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' containment reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_Column()
	 * @see test.simplerdbms.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Column> getColumn();

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Schema#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' container reference.
	 * @see #setSchema(Schema)
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_Schema()
	 * @see test.simplerdbms.Schema#getTables
	 * @model opposite="tables" required="true" transient="false"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link test.simplerdbms.Table#getSchema <em>Schema</em>}' container reference.
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
	 * If the meaning of the '<em>The Key</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Key</em>' reference.
	 * @see #setTheKey(Key)
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_TheKey()
	 * @model
	 * @generated
	 */
	Key getTheKey();

	/**
	 * Sets the value of the '{@link test.simplerdbms.Table#getTheKey <em>The Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Key</em>' reference.
	 * @see #getTheKey()
	 * @generated
	 */
	void setTheKey(Key value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link test.simplerdbms.Key}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Key#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_Key()
	 * @see test.simplerdbms.Key#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Key> getKey();

	/**
	 * Returns the value of the '<em><b>Foreign Key</b></em>' containment reference list.
	 * The list contents are of type {@link test.simplerdbms.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.ForeignKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key</em>' containment reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_ForeignKey()
	 * @see test.simplerdbms.ForeignKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKey();

} // Table
