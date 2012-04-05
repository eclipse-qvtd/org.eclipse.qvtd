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
 * $Id: PatternCS.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS#getUnrealizedVariables <em>Unrealized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getPatternCS()
 * @model abstract="true"
 * @generated
 */
public interface PatternCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.OCLExpressionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getPatternCS_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLExpressionCS> getConstraints();

	/**
	 * Returns the value of the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unrealized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unrealized Variables</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getPatternCS_UnrealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnrealizedVariableCS> getUnrealizedVariables();

} // PatternCS
