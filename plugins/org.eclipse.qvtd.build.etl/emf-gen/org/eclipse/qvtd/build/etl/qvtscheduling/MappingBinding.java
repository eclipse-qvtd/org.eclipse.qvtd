/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction <em>Mapping Action</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#isLoop <em>Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getDatum <em>Datum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingBinding()
 * @model
 * @generated
 */
public interface MappingBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction#getMappingBindings <em>Mapping Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Action</em>' container reference.
	 * @see #setMappingAction(MappingAction)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingBinding_MappingAction()
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction#getMappingBindings
	 * @model opposite="mappingBindings" transient="false"
	 * @generated
	 */
	MappingAction getMappingAction();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction <em>Mapping Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Action</em>' container reference.
	 * @see #getMappingAction()
	 * @generated
	 */
	void setMappingAction(MappingAction value);

	/**
	 * Returns the value of the '<em><b>Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' attribute.
	 * @see #setLoop(boolean)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingBinding_Loop()
	 * @model
	 * @generated
	 */
	boolean isLoop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#isLoop <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' attribute.
	 * @see #isLoop()
	 * @generated
	 */
	void setLoop(boolean value);

	/**
	 * Returns the value of the '<em><b>Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datum</em>' reference.
	 * @see #setDatum(DataTypeDatum)
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#getMappingBinding_Datum()
	 * @model
	 * @generated
	 */
	DataTypeDatum getDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getDatum <em>Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datum</em>' reference.
	 * @see #getDatum()
	 * @generated
	 */
	void setDatum(DataTypeDatum value);

} // MappingBinding
