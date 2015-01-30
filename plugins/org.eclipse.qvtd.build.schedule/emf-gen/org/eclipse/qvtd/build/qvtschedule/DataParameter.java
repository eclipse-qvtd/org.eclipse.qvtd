/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.pivot.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#isIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData <em>Primary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData <em>Secondary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum <em>Datum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter()
 * @model
 * @generated
 */
public interface DataParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Loop</em>' attribute.
	 * @see #setIsLoop(boolean)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter_IsLoop()
	 * @model
	 * @generated
	 */
	boolean isIsLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#isIsLoop <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Loop</em>' attribute.
	 * @see #isIsLoop()
	 * @generated
	 */
	void setIsLoop(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Primary Distinct Data</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getPrimaryArguments <em>Primary Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Distinct Data</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Distinct Data</em>' container reference.
	 * @see #setPrimaryDistinctData(DistinctData)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter_PrimaryDistinctData()
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getPrimaryArguments
	 * @model opposite="primaryArguments" transient="false"
	 * @generated
	 */
	DistinctData getPrimaryDistinctData();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData <em>Primary Distinct Data</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Distinct Data</em>' container reference.
	 * @see #getPrimaryDistinctData()
	 * @generated
	 */
	void setPrimaryDistinctData(DistinctData value);

	/**
	 * Returns the value of the '<em><b>Secondary Distinct Data</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getSecondaryArguments <em>Secondary Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary Distinct Data</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary Distinct Data</em>' container reference.
	 * @see #setSecondaryDistinctData(DistinctData)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter_SecondaryDistinctData()
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getSecondaryArguments
	 * @model opposite="secondaryArguments" transient="false"
	 * @generated
	 */
	DistinctData getSecondaryDistinctData();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData <em>Secondary Distinct Data</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary Distinct Data</em>' container reference.
	 * @see #getSecondaryDistinctData()
	 * @generated
	 */
	void setSecondaryDistinctData(DistinctData value);

	/**
	 * Returns the value of the '<em><b>Datum</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datum</em>' reference.
	 * @see #setDatum(AbstractDatum)
	 * @see org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage#getDataParameter_Datum()
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter
	 * @model opposite="dataParameter" required="true"
	 * @generated
	 */
	AbstractDatum getDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum <em>Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datum</em>' reference.
	 * @see #getDatum()
	 * @generated
	 */
	void setDatum(AbstractDatum value);

} // DataParameter
