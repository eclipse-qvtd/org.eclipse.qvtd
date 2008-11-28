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
 * $Id: IdentifiedCS.java,v 1.3 2008/11/28 17:23:01 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.environment.IHasName;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identified CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getAstNode <em>Ast Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifiedCS()
 * @model superTypes="org.eclipse.ocl.cst.CSTNode org.eclipse.qvt.declarative.parser.qvt.cst.IHasName"
 * @generated
 */
public interface IdentifiedCS extends CSTNode, IHasName {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(IdentifierCS)
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifiedCS_Identifier()
	 * @model containment="true"
	 * @generated
	 */
	IdentifierCS getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(IdentifierCS value);

	/**
	 * Returns the value of the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast Node</em>' reference.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifiedCS_AstNode()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EObject getAstNode();

} // IdentifiedCS
