/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.rdbms.Schema#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.rdbms.RDBMSPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.rdbms.Table}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.rdbms.Table#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see manualuml2rdbms.rdbms.RDBMSPackage#getSchema_Tables()
	 * @see manualuml2rdbms.rdbms.Table#getSchema
	 * @model opposite="schema" containment="true"
	 * @generated
	 */
	EList<Table> getTables();

} // Schema
