/**
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getInitialiser <em>Initialiser</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getAssignmentCS()
 * @model
 * @generated
 */
public interface AssignmentCS extends ExpCS {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getAssignmentCS_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getAssignmentCS_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ExpCS getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialiser</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialiser</em>' containment reference.
	 * @see #setInitialiser(ExpCS)
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage#getAssignmentCS_Initialiser()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getInitialiser();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getInitialiser <em>Initialiser</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialiser</em>' containment reference.
	 * @see #getInitialiser()
	 * @generated
	 */
	void setInitialiser(ExpCS value);

} // AssignmentCS
