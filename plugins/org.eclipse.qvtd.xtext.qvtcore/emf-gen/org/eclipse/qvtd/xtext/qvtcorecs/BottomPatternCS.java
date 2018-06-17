/**
 * <copyright>
 * 
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
package org.eclipse.qvtd.xtext.qvtcorecs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedEnforcementOperations <em>Owned Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedRealizedVariables <em>Owned Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.BottomPatternCS#getOwnedConstraints <em>Owned Constraints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getBottomPatternCS()
 * @model
 * @generated
 */
public interface BottomPatternCS extends PatternCS {
	/**
	 * Returns the value of the '<em><b>Owned Enforcement Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecs.EnforcementOperationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Enforcement Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Enforcement Operations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getBottomPatternCS_OwnedEnforcementOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnforcementOperationCS> getOwnedEnforcementOperations();

	/**
	 * Returns the value of the '<em><b>Owned Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecs.RealizedVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getBottomPatternCS_OwnedRealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealizedVariableCS> getOwnedRealizedVariables();

	/**
	 * Returns the value of the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Constraints</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage#getBottomPatternCS_OwnedConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<PredicateOrAssignmentCS> getOwnedConstraints();

} // BottomPatternCS
