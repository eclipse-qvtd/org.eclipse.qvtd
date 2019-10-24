/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.pivot.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Target#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Target#getOwnedTargetElements <em>Owned Target Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owning Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTargets <em>Owned Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Transformation</em>' container reference.
	 * @see #setOwningTransformation(Transformation)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTarget_OwningTransformation()
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTargets
	 * @model opposite="ownedTargets" required="true"
	 * @generated
	 */
	Transformation getOwningTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Target#getOwningTransformation <em>Owning Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Transformation</em>' container reference.
	 * @see #getOwningTransformation()
	 * @generated
	 */
	void setOwningTransformation(Transformation value);

	/**
	 * Returns the value of the '<em><b>Owned Target Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtbase.TargetElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Target Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Target Elements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getTarget_OwnedTargetElements()
	 * @model containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<TargetElement> getOwnedTargetElements();

} // Target
