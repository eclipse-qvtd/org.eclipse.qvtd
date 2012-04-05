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
 * $Id: TopLevelCS.java,v 1.2 2008/08/09 17:42:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getTransformations <em>Transformations</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getQueries <em>Queries</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getTopLevelCS()
 * @model
 * @generated
 */
public interface TopLevelCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getTopLevelCS_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingCS> getMappings();

	/**
	 * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getTopLevelCS_Queries()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryCS> getQueries();

	/**
	 * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformations</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage#getTopLevelCS_Transformations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationCS> getTransformations();

} // TopLevelCS
