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
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getKeys <em>Keys</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getColumn()
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
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getColumn_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getColumn_Owner()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Table#getColumns
	 * @model opposite="columns" required="true" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Column#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys</em>' reference list.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getColumn_ForeignKeys()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.ForeignKey#getColumns
	 * @model opposite="columns"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeys();

	/**
	 * Returns the value of the '<em><b>Keys</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Key}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Key#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' reference list.
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage#getColumn_Keys()
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.Key#getColumn
	 * @model opposite="column"
	 * @generated
	 */
	EList<Key> getKeys();

} // Column
