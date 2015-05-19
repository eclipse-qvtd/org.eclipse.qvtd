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
package manualuml2rdbms.uml2rdbms;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute To Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.AttributeToColumn#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAttributeToColumn()
 * @model
 * @generated
 */
public interface AttributeToColumn extends FromAttribute, ToColumn {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(PrimitiveToName)
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getAttributeToColumn_Type()
	 * @model
	 * @generated
	 */
	PrimitiveToName getType();

	/**
	 * Sets the value of the '{@link manualuml2rdbms.uml2rdbms.AttributeToColumn#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveToName value);

} // AttributeToColumn
