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
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.rdbms.ForeignKey#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.ForeignKey#getColumns <em>Columns</em>}</li>
 *   <li>{@link simpleuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Refers To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refers To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refers To</em>' reference.
	 * @see #setRefersTo(Key)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getForeignKey_RefersTo()
	 * @model required="true"
	 * @generated
	 */
	Key getRefersTo();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.ForeignKey#getRefersTo <em>Refers To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refers To</em>' reference.
	 * @see #getRefersTo()
	 * @generated
	 */
	void setRefersTo(Key value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link simpleuml2rdbms.rdbms.Column}.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Column#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getForeignKey_Columns()
	 * @see simpleuml2rdbms.rdbms.Column#getForeignKeys
	 * @model opposite="foreignKeys"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simpleuml2rdbms.rdbms.Table#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see simpleuml2rdbms.rdbms.RDBMSPackage#getForeignKey_Owner()
	 * @see simpleuml2rdbms.rdbms.Table#getForeignKeys
	 * @model opposite="foreignKeys" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link simpleuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

} // ForeignKey
