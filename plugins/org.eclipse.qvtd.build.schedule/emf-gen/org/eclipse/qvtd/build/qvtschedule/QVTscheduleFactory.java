/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.build.qvtschedule.QVTschedulePackage
 * @generated
 */
public interface QVTscheduleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTscheduleFactory eINSTANCE = org.eclipse.qvtd.build.qvtschedule.impl.QVTscheduleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Datum</em>'.
	 * @generated
	 */
	ClassDatum createClassDatum();

	/**
	 * Returns a new object of class '<em>Data Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Parameter</em>'.
	 * @generated
	 */
	DataParameter createDataParameter();

	/**
	 * Returns a new object of class '<em>Input Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Action</em>'.
	 * @generated
	 */
	InputAction createInputAction();

	/**
	 * Returns a new object of class '<em>Mapping Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Action</em>'.
	 * @generated
	 */
	MappingAction createMappingAction();

	/**
	 * Returns a new object of class '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Action</em>'.
	 * @generated
	 */
	OutputAction createOutputAction();

	/**
	 * Returns a new object of class '<em>Parameter Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Derivation</em>'.
	 * @generated
	 */
	ParameterDerivation createParameterDerivation();

	/**
	 * Returns a new object of class '<em>Property Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Datum</em>'.
	 * @generated
	 */
	PropertyDatum createPropertyDatum();

	/**
	 * Returns a new object of class '<em>Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule</em>'.
	 * @generated
	 */
	Schedule createSchedule();

	/**
	 * Returns a new object of class '<em>Secondary Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Secondary Parameter</em>'.
	 * @generated
	 */
	SecondaryParameter createSecondaryParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTschedulePackage getQVTschedulePackage();

} //QVTscheduleFactory
