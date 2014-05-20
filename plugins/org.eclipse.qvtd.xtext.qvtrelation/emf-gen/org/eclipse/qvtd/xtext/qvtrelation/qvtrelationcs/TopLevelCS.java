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
 */
package org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TopLevelCS#getImportClauses <em>Import Clauses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TopLevelCS#getTransformations <em>Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTopLevelCS()
 * @model
 * @generated
 */
public interface TopLevelCS extends RootPackageCS {
	/**
	 * Returns the value of the '<em><b>Import Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.UnitCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Clauses</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTopLevelCS_ImportClauses()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitCS> getImportClauses();

	/**
	 * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage#getTopLevelCS_Transformations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TransformationCS> getTransformations();

} // TopLevelCS
