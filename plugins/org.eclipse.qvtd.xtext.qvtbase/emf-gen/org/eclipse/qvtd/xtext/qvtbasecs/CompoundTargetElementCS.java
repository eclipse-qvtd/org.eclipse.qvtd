/**
 * Copyright (c) 2010, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Target Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS#getOwnedTargetElements <em>Owned Target Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getCompoundTargetElementCS()
 * @model
 * @generated
 */
public interface CompoundTargetElementCS extends TargetElementCS
{
	/**
	 * Returns the value of the '<em><b>Owned Target Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Target Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Target Elements</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getCompoundTargetElementCS_OwnedTargetElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleTargetElementCS> getOwnedTargetElements();

} // CompoundTargetElementCS
