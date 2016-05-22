/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.schedule;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage
 * @generated
 */
public interface ScheduleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScheduleFactory eINSTANCE = org.eclipse.qvtd.pivot.schedule.impl.ScheduleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Datum</em>'.
	 * @generated
	 */
	@NonNull ClassDatum createClassDatum();

	/**
	 * Returns a new object of class '<em>Data Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Parameter</em>'.
	 * @generated
	 */
	@NonNull DataParameter createDataParameter();

	/**
	 * Returns a new object of class '<em>Input Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Action</em>'.
	 * @generated
	 */
	@NonNull InputAction createInputAction();

	/**
	 * Returns a new object of class '<em>Mapping Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Action</em>'.
	 * @generated
	 */
	@NonNull MappingAction createMappingAction();

	/**
	 * Returns a new object of class '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Action</em>'.
	 * @generated
	 */
	@NonNull OutputAction createOutputAction();

	/**
	 * Returns a new object of class '<em>Parameter Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Derivation</em>'.
	 * @generated
	 */
	@NonNull ParameterDerivation createParameterDerivation();

	/**
	 * Returns a new object of class '<em>Property Datum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Datum</em>'.
	 * @generated
	 */
	@NonNull PropertyDatum createPropertyDatum();

	/**
	 * Returns a new object of class '<em>Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule</em>'.
	 * @generated
	 */
	@NonNull Schedule createSchedule();

	/**
	 * Returns a new object of class '<em>Secondary Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Secondary Parameter</em>'.
	 * @generated
	 */
	@NonNull SecondaryParameter createSecondaryParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulePackage getSchedulePackage();

} //ScheduleFactory
