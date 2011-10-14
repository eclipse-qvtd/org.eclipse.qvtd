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
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationalTransformation()
 * @model
 * @generated
 */
public interface RelationalTransformation extends Transformation {
	/**
	 * Returns the value of the '<em><b>Owned Key</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtrelation.Key}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#getRelationalTransformation_OwnedKey()
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 * @generated
	 */
	EList<Key> getOwnedKey();

} // RelationalTransformation
