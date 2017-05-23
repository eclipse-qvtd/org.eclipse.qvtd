/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Domain CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS#getOwnedPatterns <em>Owned Patterns</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPrimitiveTypeDomainCS()
 * @model
 * @generated
 */
public interface PrimitiveTypeDomainCS extends AbstractDomainCS {

	/**
	 * Returns the value of the '<em><b>Owned Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Patterns</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getPrimitiveTypeDomainCS_OwnedPatterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveTypeDomainPatternCS> getOwnedPatterns();

} // PrimitiveTypeDomainCS
