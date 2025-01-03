/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorecs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direction CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.DirectionCS#getUses <em>Uses</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getDirectionCS()
 * @model
 * @generated
 */
public interface DirectionCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getDirectionCS_Imports()
	 * @model
	 * @generated
	 */
	EList<org.eclipse.ocl.pivot.Package> getImports();

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getDirectionCS_Uses()
	 * @model
	 * @generated
	 */
	EList<TypedModel> getUses();

} // DirectionCS
