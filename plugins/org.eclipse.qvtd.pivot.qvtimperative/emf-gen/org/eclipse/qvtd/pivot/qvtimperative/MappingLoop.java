/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
 * An Imperative MappingLoop support an iterated nested mapping call.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements <em>Owned Mapping Statements</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop()
 * @generated
 */
public interface MappingLoop extends MappingStatement {

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
	 * @return the value of the '<em>Owned Mapping Statements</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedMappingStatements()
	 * @generated
	 */
	EList<MappingStatement> getOwnedMappingStatements();

	/**
	 * Returns the value of the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Source</em>' containment reference.
	 * @see #setOwnedSource(OCLExpression)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#getMappingLoop_OwnedSource()
	 * @generated
	 */
	OCLExpression getOwnedSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedSource <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Source</em>' containment reference.
	 * @see #getOwnedSource()
	 * @generated
	 */
	void setOwnedSource(OCLExpression value);

} // MappingLoop
