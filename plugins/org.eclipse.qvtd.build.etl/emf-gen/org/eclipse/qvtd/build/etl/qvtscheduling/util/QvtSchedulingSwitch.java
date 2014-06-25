/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.qvtd.build.etl.qvtscheduling.*;

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
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage
 * @generated
 */
public class QvtSchedulingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QvtSchedulingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtSchedulingSwitch() {
		if (modelPackage == null) {
			modelPackage = QvtSchedulingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case QvtSchedulingPackage.ABSTRACT_DATUM: {
				AbstractDatum abstractDatum = (AbstractDatum)theEObject;
				T result = caseAbstractDatum(abstractDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.ABSTRACT_ACTION: {
				AbstractAction abstractAction = (AbstractAction)theEObject;
				T result = caseAbstractAction(abstractAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.CLASS_DATUM: {
				ClassDatum classDatum = (ClassDatum)theEObject;
				T result = caseClassDatum(classDatum);
				if (result == null) result = caseAbstractDatum(classDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.DATA_TYPE_DATUM: {
				DataTypeDatum dataTypeDatum = (DataTypeDatum)theEObject;
				T result = caseDataTypeDatum(dataTypeDatum);
				if (result == null) result = caseAbstractDatum(dataTypeDatum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.DISTINCT_DATA: {
				DistinctData distinctData = (DistinctData)theEObject;
				T result = caseDistinctData(distinctData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.INPUT_ACTION: {
				InputAction inputAction = (InputAction)theEObject;
				T result = caseInputAction(inputAction);
				if (result == null) result = caseAbstractAction(inputAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.MAPPING_ACTION: {
				MappingAction mappingAction = (MappingAction)theEObject;
				T result = caseMappingAction(mappingAction);
				if (result == null) result = caseAbstractAction(mappingAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.MAPPING_BINDING: {
				MappingBinding mappingBinding = (MappingBinding)theEObject;
				T result = caseMappingBinding(mappingBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QvtSchedulingPackage.OUTPUT_ACTION: {
				OutputAction outputAction = (OutputAction)theEObject;
				T result = caseOutputAction(outputAction);
				if (result == null) result = caseAbstractAction(outputAction);
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
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Datum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Datum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDatum(DataTypeDatum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distinct Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distinct Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistinctData(DistinctData object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingBinding(MappingBinding object) {
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

} //QvtSchedulingSwitch
