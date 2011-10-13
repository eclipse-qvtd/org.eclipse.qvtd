/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bottom Pattern CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getEnforcementOperations <em>Enforcement Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getRealizedVariables <em>Realized Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getBottomPatternCS()
 * @model
 * @generated
 */
public interface BottomPatternCS extends PatternCS {
	/**
	 * Returns the value of the '<em><b>Enforcement Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforcement Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforcement Operations</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getBottomPatternCS_EnforcementOperations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnforcementOperationCS> getEnforcementOperations();

	/**
	 * Returns the value of the '<em><b>Realized Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variables</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getBottomPatternCS_RealizedVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<RealizedVariableCS> getRealizedVariables();

} // BottomPatternCS
