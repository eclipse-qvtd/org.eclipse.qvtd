/**
 * <copyright>
 *
 * Copyright (c) 2018, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.runtime.qvttrace.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.qvtd.runtime.qvttrace.Execution;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExecutionImpl extends TraceInstanceImpl implements Execution {
	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION_FEATURE_COUNT = TraceInstanceImpl.TRACE_INSTANCE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION_OPERATION_COUNT = TraceInstanceImpl.TRACE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtracePackage.Literals.EXECUTION;
	}

} //ExecutionImpl
