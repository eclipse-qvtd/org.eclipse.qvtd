/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Root;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.BaseModel#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getBaseModel()
 * @model
 * @generated
 */
public interface BaseModel extends EObject, Root {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.Unit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getBaseModel_Unit()
	 * @model containment="true"
	 * @generated
	 */
	EList<Unit> getUnit();

} // BaseModel
