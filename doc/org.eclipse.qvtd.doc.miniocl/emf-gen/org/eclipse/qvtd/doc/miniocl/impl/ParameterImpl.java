/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.Parameter;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ParameterImpl extends VariableImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.PARAMETER;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitParameter(this);
	}

} //ParameterImpl
