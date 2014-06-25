/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage
 * @generated
 */
public interface QvtSchedulingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtSchedulingFactory eINSTANCE = org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Abstract Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Datum</em>'.
	 * @generated
	 */
	AbstractDatum createAbstractDatum();

	/**
	 * Returns a new object of class '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Action</em>'.
	 * @generated
	 */
	AbstractAction createAbstractAction();

	/**
	 * Returns a new object of class '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Datum</em>'.
	 * @generated
	 */
	ClassDatum createClassDatum();

	/**
	 * Returns a new object of class '<em>Data Type Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Datum</em>'.
	 * @generated
	 */
	DataTypeDatum createDataTypeDatum();

	/**
	 * Returns a new object of class '<em>Distinct Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distinct Data</em>'.
	 * @generated
	 */
	DistinctData createDistinctData();

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
	 * Returns a new object of class '<em>Mapping Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Binding</em>'.
	 * @generated
	 */
	MappingBinding createMappingBinding();

	/**
	 * Returns a new object of class '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Action</em>'.
	 * @generated
	 */
	OutputAction createOutputAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QvtSchedulingPackage getQvtSchedulingPackage();

} //QvtSchedulingFactory
