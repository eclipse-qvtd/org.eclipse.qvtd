/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

import org.eclipse.ocl.examples.domain.elements.Nameable;

import org.eclipse.qvtd.codegen.qvticgmodel.*;

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
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage
 * @generated
 */
public class QVTiCGModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTiCGModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTiCGModelSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTiCGModelPackage.eINSTANCE;
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
			case QVTiCGModelPackage.CG_ECORE_PROPERTY_ASSIGNMENT: {
				CGEcorePropertyAssignment cgEcorePropertyAssignment = (CGEcorePropertyAssignment)theEObject;
				T result = caseCGEcorePropertyAssignment(cgEcorePropertyAssignment);
				if (result == null) result = caseCGPropertyAssignment(cgEcorePropertyAssignment);
				if (result == null) result = caseCGValuedElement(cgEcorePropertyAssignment);
				if (result == null) result = caseCGTypedElement(cgEcorePropertyAssignment);
				if (result == null) result = caseCGNamedElement(cgEcorePropertyAssignment);
				if (result == null) result = caseCGElement(cgEcorePropertyAssignment);
				if (result == null) result = caseNameable(cgEcorePropertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_ECORE_REALIZED_VARIABLE: {
				CGEcoreRealizedVariable cgEcoreRealizedVariable = (CGEcoreRealizedVariable)theEObject;
				T result = caseCGEcoreRealizedVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGRealizedVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGValuedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGTypedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGNamedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGElement(cgEcoreRealizedVariable);
				if (result == null) result = caseNameable(cgEcoreRealizedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_FUNCTION: {
				CGFunction cgFunction = (CGFunction)theEObject;
				T result = caseCGFunction(cgFunction);
				if (result == null) result = caseCGOperation(cgFunction);
				if (result == null) result = caseCGTypedElement(cgFunction);
				if (result == null) result = caseCGNamedElement(cgFunction);
				if (result == null) result = caseCGElement(cgFunction);
				if (result == null) result = caseNameable(cgFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_FUNCTION_CALL_EXP: {
				CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)theEObject;
				T result = caseCGFunctionCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGOperationCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGValuedElement(cgFunctionCallExp);
				if (result == null) result = caseCGTypedElement(cgFunctionCallExp);
				if (result == null) result = caseCGNamedElement(cgFunctionCallExp);
				if (result == null) result = caseCGElement(cgFunctionCallExp);
				if (result == null) result = caseNameable(cgFunctionCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_FUNCTION_PARAMETER: {
				CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)theEObject;
				T result = caseCGFunctionParameter(cgFunctionParameter);
				if (result == null) result = caseCGParameter(cgFunctionParameter);
				if (result == null) result = caseCGVariable(cgFunctionParameter);
				if (result == null) result = caseCGValuedElement(cgFunctionParameter);
				if (result == null) result = caseCGTypedElement(cgFunctionParameter);
				if (result == null) result = caseCGNamedElement(cgFunctionParameter);
				if (result == null) result = caseCGElement(cgFunctionParameter);
				if (result == null) result = caseNameable(cgFunctionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_GUARD_VARIABLE: {
				CGGuardVariable cgGuardVariable = (CGGuardVariable)theEObject;
				T result = caseCGGuardVariable(cgGuardVariable);
				if (result == null) result = caseCGParameter(cgGuardVariable);
				if (result == null) result = caseCGVariable(cgGuardVariable);
				if (result == null) result = caseCGValuedElement(cgGuardVariable);
				if (result == null) result = caseCGTypedElement(cgGuardVariable);
				if (result == null) result = caseCGNamedElement(cgGuardVariable);
				if (result == null) result = caseCGElement(cgGuardVariable);
				if (result == null) result = caseNameable(cgGuardVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_MAPPING: {
				CGMapping cgMapping = (CGMapping)theEObject;
				T result = caseCGMapping(cgMapping);
				if (result == null) result = caseCGTypedElement(cgMapping);
				if (result == null) result = caseCGNamedElement(cgMapping);
				if (result == null) result = caseCGElement(cgMapping);
				if (result == null) result = caseNameable(cgMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_MAPPING_CALL: {
				CGMappingCall cgMappingCall = (CGMappingCall)theEObject;
				T result = caseCGMappingCall(cgMappingCall);
				if (result == null) result = caseCGValuedElement(cgMappingCall);
				if (result == null) result = caseCGTypedElement(cgMappingCall);
				if (result == null) result = caseCGNamedElement(cgMappingCall);
				if (result == null) result = caseCGElement(cgMappingCall);
				if (result == null) result = caseNameable(cgMappingCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING: {
				CGMappingCallBinding cgMappingCallBinding = (CGMappingCallBinding)theEObject;
				T result = caseCGMappingCallBinding(cgMappingCallBinding);
				if (result == null) result = caseCGValuedElement(cgMappingCallBinding);
				if (result == null) result = caseCGTypedElement(cgMappingCallBinding);
				if (result == null) result = caseCGNamedElement(cgMappingCallBinding);
				if (result == null) result = caseCGElement(cgMappingCallBinding);
				if (result == null) result = caseNameable(cgMappingCallBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_PREDICATE: {
				CGPredicate cgPredicate = (CGPredicate)theEObject;
				T result = caseCGPredicate(cgPredicate);
				if (result == null) result = caseCGValuedElement(cgPredicate);
				if (result == null) result = caseCGTypedElement(cgPredicate);
				if (result == null) result = caseCGNamedElement(cgPredicate);
				if (result == null) result = caseCGElement(cgPredicate);
				if (result == null) result = caseNameable(cgPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT: {
				CGPropertyAssignment cgPropertyAssignment = (CGPropertyAssignment)theEObject;
				T result = caseCGPropertyAssignment(cgPropertyAssignment);
				if (result == null) result = caseCGValuedElement(cgPropertyAssignment);
				if (result == null) result = caseCGTypedElement(cgPropertyAssignment);
				if (result == null) result = caseCGNamedElement(cgPropertyAssignment);
				if (result == null) result = caseCGElement(cgPropertyAssignment);
				if (result == null) result = caseNameable(cgPropertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_REALIZED_VARIABLE: {
				CGRealizedVariable cgRealizedVariable = (CGRealizedVariable)theEObject;
				T result = caseCGRealizedVariable(cgRealizedVariable);
				if (result == null) result = caseCGVariable(cgRealizedVariable);
				if (result == null) result = caseCGValuedElement(cgRealizedVariable);
				if (result == null) result = caseCGTypedElement(cgRealizedVariable);
				if (result == null) result = caseCGNamedElement(cgRealizedVariable);
				if (result == null) result = caseCGElement(cgRealizedVariable);
				if (result == null) result = caseNameable(cgRealizedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_TRANSFORMATION: {
				CGTransformation cgTransformation = (CGTransformation)theEObject;
				T result = caseCGTransformation(cgTransformation);
				if (result == null) result = caseCGClass(cgTransformation);
				if (result == null) result = caseCGNamedElement(cgTransformation);
				if (result == null) result = caseCGElement(cgTransformation);
				if (result == null) result = caseNameable(cgTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTiCGModelPackage.CG_TYPED_MODEL: {
				CGTypedModel cgTypedModel = (CGTypedModel)theEObject;
				T result = caseCGTypedModel(cgTypedModel);
				if (result == null) result = caseCGNamedElement(cgTypedModel);
				if (result == null) result = caseCGElement(cgTypedModel);
				if (result == null) result = caseNameable(cgTypedModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Ecore Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Ecore Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGEcorePropertyAssignment(CGEcorePropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Ecore Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Ecore Realized Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGEcoreRealizedVariable(CGEcoreRealizedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGFunction(CGFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Function Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Function Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGFunctionCallExp(CGFunctionCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Function Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Function Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGFunctionParameter(CGFunctionParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Guard Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Guard Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGGuardVariable(CGGuardVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGPropertyAssignment(CGPropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMapping(CGMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGTransformation(CGTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Typed Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGTypedModel(CGTypedModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Mapping Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMappingCall(CGMappingCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Mapping Call Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Mapping Call Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMappingCallBinding(CGMappingCallBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGPredicate(CGPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Realized Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGRealizedVariable(CGRealizedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGElement(CGElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGNamedElement(CGNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGTypedElement(CGTypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Valued Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Valued Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGValuedElement(CGValuedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGOperation(CGOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGCallExp(CGCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGOperationCallExp(CGOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGParameter(CGParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGClass(CGClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGVariable(CGVariable object) {
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

} //QVTiCGModelSwitch
