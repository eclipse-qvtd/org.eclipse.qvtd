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
 * $Id: IdentifierCS.java,v 1.3 2008/11/28 17:23:01 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.environment.IHasName;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getAstNode <em>Ast Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifierCS()
 * @model superTypes="org.eclipse.ocl.cst.CSTNode org.eclipse.qvt.declarative.parser.qvt.cst.IHasName"
 * @generated
 */
public interface IdentifierCS extends CSTNode, IHasName {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifierCS_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast Node</em>' reference.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#getIdentifierCS_AstNode()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EObject getAstNode();

} // IdentifierCS
