/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distinct Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getPrimaryArguments <em>Primary Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getSecondaryArguments <em>Secondary Arguments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDistinctData()
 * @model
 * @generated
 */
public interface DistinctData extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(AbstractAction)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDistinctData_Target()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getDistinctArguments
	 * @model opposite="distinctArguments" transient="false"
	 * @generated
	 */
	AbstractAction getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Primary Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DataParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData <em>Primary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Arguments</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDistinctData_PrimaryArguments()
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData
	 * @model opposite="primaryDistinctData" containment="true" required="true"
	 * @generated
	 */
	EList<DataParameter> getPrimaryArguments();

	/**
	 * Returns the value of the '<em><b>Secondary Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.qvtschedule.DataParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData <em>Secondary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Arguments</em>' containment reference list.
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDistinctData_SecondaryArguments()
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData
	 * @model opposite="secondaryDistinctData" containment="true"
	 * @generated
	 */
	EList<DataParameter> getSecondaryArguments();

} // DistinctData
