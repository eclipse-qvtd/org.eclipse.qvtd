/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Loop CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getOwnedIterator <em>Owned Iterator</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getInExpression <em>In Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getMappingSequence <em>Mapping Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingLoopCS()
 * @model
 * @generated
 */
public interface MappingLoopCS extends MappingStatementCS {
	/**
	 * Returns the value of the '<em><b>Owned Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Iterator</em>' containment reference.
	 * @see #setOwnedIterator(VariableCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingLoopCS_OwnedIterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableCS getOwnedIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getOwnedIterator <em>Owned Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Iterator</em>' containment reference.
	 * @see #getOwnedIterator()
	 * @generated
	 */
	void setOwnedIterator(VariableCS value);

	/**
	 * Returns the value of the '<em><b>In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Expression</em>' containment reference.
	 * @see #setInExpression(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingLoopCS_InExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getInExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getInExpression <em>In Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Expression</em>' containment reference.
	 * @see #getInExpression()
	 * @generated
	 */
	void setInExpression(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Mapping Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Sequence</em>' containment reference.
	 * @see #setMappingSequence(MappingSequenceCS)
	 * @see org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage#getMappingLoopCS_MappingSequence()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MappingSequenceCS getMappingSequence();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS#getMappingSequence <em>Mapping Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Sequence</em>' containment reference.
	 * @see #getMappingSequence()
	 * @generated
	 */
	void setMappingSequence(MappingSequenceCS value);

} // MappingLoopCS
