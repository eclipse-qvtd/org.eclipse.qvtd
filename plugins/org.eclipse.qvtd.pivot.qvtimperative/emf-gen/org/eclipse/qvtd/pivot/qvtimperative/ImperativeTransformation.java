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
package org.eclipse.qvtd.pivot.qvtimperative;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imperative Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An ImperativeTransfornmation distinguishes a QVTi transformation from other transformations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation#getContextType <em>Context Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTransformation()
 * @generated
 */
public interface ImperativeTransformation extends Transformation {

	/**
	 * Returns the value of the '<em><b>Context Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optionally distinct type for the implementation of the context type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context Type</em>' reference.
	 * @see #setContextType(org.eclipse.ocl.pivot.Class)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getImperativeTransformation_ContextType()
	 * @generated
	 */
	org.eclipse.ocl.pivot.Class getContextType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation#getContextType <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Type</em>' reference.
	 * @see #getContextType()
	 * @generated
	 */
	void setContextType(org.eclipse.ocl.pivot.Class value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateAllRulesAreMappings(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateUniqueTargetNames(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ImperativeTransformation
