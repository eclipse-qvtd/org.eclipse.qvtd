/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getQueryCS()
 * @model
 * @generated
 */
public interface QueryCS extends TypedElementCS {
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
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getQueryCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' reference.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getQueryCS_Transformation()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Transformation getTransformation();

	/**
	 * Returns the value of the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Param Declaration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Param Declaration</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getQueryCS_InputParamDeclaration()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParamDeclarationCS> getInputParamDeclaration();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getQueryCS_Expression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(ExpCS value);

} // QueryCS
