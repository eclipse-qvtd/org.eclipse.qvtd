/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.pivot.Variable;

import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getRealizedVariables <em>Realized Variables</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getClassDatum()
 * @model
 * @generated
 */
public interface ClassDatum extends AbstractDatum {
	/**
	 * Returns the value of the '<em><b>Realized Variables</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Variables</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getClassDatum_RealizedVariables()
	 * @model
	 * @generated
	 */
	EList<RealizedVariable> getRealizedVariables();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getClassDatum_Variables()
	 * @model
	 * @generated
	 */
	EList<Variable> getVariables();

} // ClassDatum
