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
 * $Id: QueryCS.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.qvt.declarative.parser.environment.IHasName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getQueryCS()
 * @model superTypes="org.eclipse.ocl.cst.CSTNode org.eclipse.qvt.declarative.parser.qvt.cst.IHasName"
 * @generated
 */
public interface QueryCS extends CSTNode, IHasName {
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' containment reference.
	 * @see #setPathName(PathNameCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getQueryCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Param Declaration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Param Declaration</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getQueryCS_InputParamDeclaration()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDeclarationCS> getInputParamDeclaration();

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #setOclExpression(OCLExpressionCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getQueryCS_OclExpression()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getOclExpression <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getQueryCS_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeCS value);

} // QueryCS
