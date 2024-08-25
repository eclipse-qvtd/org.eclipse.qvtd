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
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.ExpressionInOCLImpl;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FunctionBodyImpl extends ExpressionInOCLImpl implements FunctionBody {
	/**
	 * The number of structural features of the '<em>Function Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_BODY_FEATURE_COUNT = ExpressionInOCLImpl.EXPRESSION_IN_OCL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Function Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_BODY_OPERATION_COUNT = ExpressionInOCLImpl.EXPRESSION_IN_OCL_OPERATION_COUNT + 0;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBodyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.FUNCTION_BODY;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitFunctionBody(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public Type basicGetType() {
		return ownedBody != null ? ownedBody.getType() : null;
	}

	@Override
	public Type getType() {
		return ownedBody.getType();
	}

	@Override
	protected boolean setReloadableProxy() {
		// TODO Auto-generated method stub
		return super.setReloadableProxy();
	}

	@Override
	public @Nullable Notifier getReloadableNotifier() {
		// TODO Auto-generated method stub
		return super.getReloadableNotifier();
	}
} //FunctionBodyImpl
