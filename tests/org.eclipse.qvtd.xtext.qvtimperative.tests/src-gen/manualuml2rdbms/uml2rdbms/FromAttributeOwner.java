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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Attribute Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml2rdbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}</li>
 * </ul>
 *
 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttributeOwner()
 * @model abstract="true"
 * @generated
 */
public interface FromAttributeOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>From Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link manualuml2rdbms.uml2rdbms.FromAttribute}.
	 * It is bidirectional and its opposite is '{@link manualuml2rdbms.uml2rdbms.FromAttribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Attributes</em>' containment reference list.
	 * @see manualuml2rdbms.uml2rdbms.UML2RDBMSPackage#getFromAttributeOwner_FromAttributes()
	 * @see manualuml2rdbms.uml2rdbms.FromAttribute#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<FromAttribute> getFromAttributes();

} // FromAttributeOwner
