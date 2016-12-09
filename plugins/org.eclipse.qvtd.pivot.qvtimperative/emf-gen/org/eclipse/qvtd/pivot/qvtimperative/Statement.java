/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Statement is the basis for all execution by a Mapping.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getStatement()
 * @generated
 */
public interface Statement extends NamedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String joinNames(EList<String> names);

} // Statement
