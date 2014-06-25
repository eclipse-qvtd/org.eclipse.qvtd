/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distinct Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getPrimaryArgument <em>Primary Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getSecondaryArgument <em>Secondary Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getDistinctData()
 * @model
 * @generated
 */
public interface DistinctData extends EObject {
	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getDistinctData_Targets()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getDistinctArguments
	 * @model opposite="distinctArguments"
	 * @generated
	 */
	EList<AbstractAction> getTargets();

	/**
	 * Returns the value of the '<em><b>Primary Argument</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData <em>Primary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Argument</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Argument</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getDistinctData_PrimaryArgument()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData
	 * @model opposite="primaryDistinctData"
	 * @generated
	 */
	EList<AbstractDatum> getPrimaryArgument();

	/**
	 * Returns the value of the '<em><b>Secondary Argument</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSecondaryDistinctData <em>Secondary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Argument</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Argument</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getDistinctData_SecondaryArgument()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSecondaryDistinctData
	 * @model opposite="secondaryDistinctData"
	 * @generated
	 */
	EList<AbstractDatum> getSecondaryArgument();

} // DistinctData
