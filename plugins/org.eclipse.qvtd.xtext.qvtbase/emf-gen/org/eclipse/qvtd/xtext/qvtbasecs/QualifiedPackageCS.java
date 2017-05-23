/**
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS#getOwnedPathName <em>Owned Path Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getQualifiedPackageCS()
 * @model
 * @generated
 */
public interface QualifiedPackageCS extends PackageCS
{
	/**
	 * Returns the value of the '<em><b>Owned Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Path Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #setOwnedPathName(PathNameCS)
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#getQualifiedPackageCS_OwnedPathName()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getOwnedPathName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS#getOwnedPathName <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Path Name</em>' containment reference.
	 * @see #getOwnedPathName()
	 * @generated
	 */
	void setOwnedPathName(PathNameCS value);

} // QualifiedPackageCS
