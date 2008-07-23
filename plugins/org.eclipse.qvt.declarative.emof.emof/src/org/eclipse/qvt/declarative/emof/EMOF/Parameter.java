/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Parameter.java,v 1.1 2008/07/23 09:55:18 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EMOF;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EMOF.Parameter#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends TypedElement, MultiplicityElement {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EMOF.Operation#getOwnedParameter <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage#getParameter_Operation()
	 * @see org.eclipse.qvt.declarative.emof.EMOF.Operation#getOwnedParameter
	 * @model opposite="ownedParameter"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.EMOF.Parameter#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // Parameter
