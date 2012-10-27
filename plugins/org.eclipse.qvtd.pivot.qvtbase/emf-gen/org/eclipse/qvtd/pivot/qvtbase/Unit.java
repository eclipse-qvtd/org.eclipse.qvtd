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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.Unit#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject, NamedElement {
	/**
	 * Returns the value of the '<em><b>Used Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Package</em>' reference.
	 * @see #setUsedPackage(Namespace)
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#getUnit_UsedPackage()
	 * @model ordered="false"
	 * @generated
	 */
	Namespace getUsedPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtbase.Unit#getUsedPackage <em>Used Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Package</em>' reference.
	 * @see #getUsedPackage()
	 * @generated
	 */
	void setUsedPackage(Namespace value);

} // Unit
