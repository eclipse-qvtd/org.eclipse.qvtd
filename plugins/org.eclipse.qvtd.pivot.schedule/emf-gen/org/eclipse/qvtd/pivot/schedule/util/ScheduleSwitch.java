/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.schedule.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.schedule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage
 * @generated
 */
public class ScheduleSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SchedulePackage.ABSTRACT_DATUM: {
				AbstractDatum abstractDatum = (AbstractDatum)theEObject;
				T result = caseAbstractDatum(abstractDatum);
				if (result == null) result = caseScheduleElement(abstractDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.ABSTRACT_ACTION: {
				AbstractAction abstractAction = (AbstractAction)theEObject;
				T result = caseAbstractAction(abstractAction);
				if (result == null) result = caseScheduleElement(abstractAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.CLASS_DATUM: {
				ClassDatum classDatum = (ClassDatum)theEObject;
				T result = caseClassDatum(classDatum);
				if (result == null) result = caseAbstractDatum(classDatum);
				if (result == null) result = caseScheduleElement(classDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.DATA_PARAMETER: {
				DataParameter dataParameter = (DataParameter)theEObject;
				T result = caseDataParameter(dataParameter);
				if (result == null) result = caseScheduleElement(dataParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.INPUT_ACTION: {
				InputAction inputAction = (InputAction)theEObject;
				T result = caseInputAction(inputAction);
				if (result == null) result = caseAbstractAction(inputAction);
				if (result == null) result = caseScheduleElement(inputAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.MAPPING_ACTION: {
				MappingAction mappingAction = (MappingAction)theEObject;
				T result = caseMappingAction(mappingAction);
				if (result == null) result = caseAbstractAction(mappingAction);
				if (result == null) result = caseScheduleElement(mappingAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.OUTPUT_ACTION: {
				OutputAction outputAction = (OutputAction)theEObject;
				T result = caseOutputAction(outputAction);
				if (result == null) result = caseAbstractAction(outputAction);
				if (result == null) result = caseScheduleElement(outputAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.PARAMETER_DERIVATION: {
				ParameterDerivation parameterDerivation = (ParameterDerivation)theEObject;
				T result = caseParameterDerivation(parameterDerivation);
				if (result == null) result = caseScheduleElement(parameterDerivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.PROPERTY_DATUM: {
				PropertyDatum propertyDatum = (PropertyDatum)theEObject;
				T result = casePropertyDatum(propertyDatum);
				if (result == null) result = caseAbstractDatum(propertyDatum);
				if (result == null) result = caseScheduleElement(propertyDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.SCHEDULE: {
				Schedule schedule = (Schedule)theEObject;
				T result = caseSchedule(schedule);
				if (result == null) result = caseScheduleElement(schedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.SCHEDULE_ELEMENT: {
				ScheduleElement scheduleElement = (ScheduleElement)theEObject;
				T result = caseScheduleElement(scheduleElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulePackage.SECONDARY_PARAMETER: {
				SecondaryParameter secondaryParameter = (SecondaryParameter)theEObject;
				T result = caseSecondaryParameter(secondaryParameter);
				if (result == null) result = caseScheduleElement(secondaryParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDatum(AbstractDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAction(AbstractAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDatum(ClassDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataParameter(DataParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputAction(InputAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingAction(MappingAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputAction(OutputAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Derivation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Derivation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDerivation(ParameterDerivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDatum(PropertyDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedule(Schedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleElement(ScheduleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Secondary Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Secondary Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecondaryParameter(SecondaryParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ScheduleSwitch
