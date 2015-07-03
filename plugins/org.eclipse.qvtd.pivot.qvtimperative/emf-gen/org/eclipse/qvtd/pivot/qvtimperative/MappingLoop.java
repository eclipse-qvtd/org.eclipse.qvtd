/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Imperative MappingLoop support an iterated nested mapping call.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedBody <em>Owned Body</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop()
 * @generated
 */
public interface MappingLoop extends CallExp, MappingStatement {

	/**
	 * Returns the value of the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body</em>' containment reference.
	 * @see #setOwnedBody(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedBody()
	 * @generated
	 */
	OCLExpression getOwnedBody();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedBody <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body</em>' containment reference.
	 * @see #getOwnedBody()
	 * @generated
	 */
	void setOwnedBody(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterators</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedIterators()
	 * @generated
	 */
	EList<Variable> getOwnedIterators();

} // MappingLoop
