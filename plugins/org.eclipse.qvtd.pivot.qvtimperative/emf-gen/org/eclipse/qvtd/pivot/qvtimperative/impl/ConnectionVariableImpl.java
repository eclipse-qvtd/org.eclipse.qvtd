/**
 * <copyright>
 *
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConnectionVariableImpl extends VariableDeclarationImpl implements ConnectionVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.CONNECTION_VARIABLE;
	}

} //ConnectionVariableImpl
