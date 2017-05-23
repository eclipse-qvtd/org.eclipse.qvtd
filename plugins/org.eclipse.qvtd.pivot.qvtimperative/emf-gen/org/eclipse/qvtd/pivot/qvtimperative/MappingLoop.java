/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingLoop supports an iteration of mapping invocations.
 * 
 * syntax: oclText[for name : type in expression {...}]
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements <em>Owned Mapping Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop()
 * @generated
 */
public interface MappingLoop extends MappingStatement, ObservableStatement {

	/**
	 * Returns the value of the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop <em>Owning Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The iterator loop variable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Iterators</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedIterators()
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop
	 * @generated
	 */
	EList<LoopVariable> getOwnedIterators();

	/**
	 * Returns the value of the '<em><b>Owned Mapping Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtimperative.MappingStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mapping Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The statements to be iterated, typically a single MappingCall.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Mapping Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedMappingStatements()
	 * @generated
	 */
	EList<MappingStatement> getOwnedMappingStatements();

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expression whose values provide the iterator values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedExpression()
	 * @generated
	 */
	OCLExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(OCLExpression value);

} // MappingLoop
