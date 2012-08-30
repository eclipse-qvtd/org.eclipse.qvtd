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

import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getDirectionCS()
 * @model
 * @generated
 */
public interface DirectionCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getDirectionCS_Imports()
	 * @model
	 * @generated
	 */
	EList<org.eclipse.ocl.examples.pivot.Package> getImports();

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.CoreDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getDirectionCS_Uses()
	 * @model
	 * @generated
	 */
	EList<CoreDomain> getUses();

} // DirectionCS
