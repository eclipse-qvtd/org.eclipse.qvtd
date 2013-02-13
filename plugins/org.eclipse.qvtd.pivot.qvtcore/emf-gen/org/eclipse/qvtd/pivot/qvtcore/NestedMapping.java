/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.pivot.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.NestedMapping#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getNestedMapping()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NestedMapping extends EObject, Element {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(Mapping)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getNestedMapping_Context()
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal
	 * @model opposite="local" resolveProxies="false"
	 * @generated
	 */
	Mapping getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.NestedMapping#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Mapping value);

} // NestedMapping
