/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms;

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
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getForeignKey()
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
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getForeignKey_RefersTo()
	 * @model required="true"
	 * @generated
	 */
	Key getRefersTo();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getRefersTo <em>Refers To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refers To</em>' reference.
	 * @see #getRefersTo()
	 * @generated
	 */
	void setRefersTo(Key value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getForeignKey_Columns()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getForeignKeys
	 * @model opposite="foreignKeys"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Table#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getForeignKey_Owner()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Table#getForeignKeys
	 * @model opposite="foreignKeys" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

} // ForeignKey
