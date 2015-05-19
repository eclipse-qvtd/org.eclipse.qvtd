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
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.rdbms.ForeignKey#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.ForeignKey#getColumn <em>Column</em>}</li>
 *   <li>{@link manualuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.rdbms.RDBMSPackage#getForeignKey()
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
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getForeignKey_RefersTo()
	 * @model required="true"
	 * @generated
	 */
	Key getRefersTo();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.rdbms.ForeignKey#getRefersTo <em>Refers To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refers To</em>' reference.
	 * @see #getRefersTo()
	 * @generated
	 */
	void setRefersTo(Key value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link manualuml2rdbms.rdbms.Column}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Column#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getForeignKey_Column()
	 * @see manualuml2rdbms.rdbms.Column#getForeignKeys
	 * @model opposite="foreignKeys"
	 * @generated
	 */
	EList<Column> getColumn();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Table#getForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getForeignKey_Owner()
	 * @see manualuml2rdbms.rdbms.Table#getForeignKey
	 * @model opposite="foreignKey" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.rdbms.ForeignKey#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

} // ForeignKey
