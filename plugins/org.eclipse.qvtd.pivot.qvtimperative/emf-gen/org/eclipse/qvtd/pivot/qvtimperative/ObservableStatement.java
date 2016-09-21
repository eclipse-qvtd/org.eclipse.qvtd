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

import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observable Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ObservableStatement may involve evaluation of an expression that accesses object properties whose
 * values may not be available. If not ready,the mapping execution is suspended until the required value
 * is made available by a notifying SetStatement.
 * 
 * syntax: oclText[observe class::property ...]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement#getObservedProperties <em>Observed Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getObservableStatement()
 * @generated
 */
public interface ObservableStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Observed Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The properties whose accesses must be checked for readiness.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Observed Properties</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getObservableStatement_ObservedProperties()
	 * @generated
	 */
	EList<Property> getObservedProperties();

} // ObservableStatement
