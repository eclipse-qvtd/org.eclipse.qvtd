/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSourcedCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
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
public class QVTiCGModelSwitch<@Nullable T> extends Switch<T> {
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
			case 0: {
				CGConnectionAssignment cgConnectionAssignment = (CGConnectionAssignment)theEObject;
				T result = caseCGConnectionAssignment(cgConnectionAssignment);
				if (result == null) result = caseCGValuedElement(cgConnectionAssignment);
				if (result == null) result = caseCGTypedElement(cgConnectionAssignment);
				if (result == null) result = caseCGNamedElement(cgConnectionAssignment);
				if (result == null) result = caseCGElement(cgConnectionAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				CGConnectionVariable cgConnectionVariable = (CGConnectionVariable)theEObject;
				T result = caseCGConnectionVariable(cgConnectionVariable);
				if (result == null) result = caseCGGuardVariable(cgConnectionVariable);
				if (result == null) result = caseCGParameter(cgConnectionVariable);
				if (result == null) result = caseCGVariable(cgConnectionVariable);
				if (result == null) result = caseCGValuedElement(cgConnectionVariable);
				if (result == null) result = caseCGTypedElement(cgConnectionVariable);
				if (result == null) result = caseCGNamedElement(cgConnectionVariable);
				if (result == null) result = caseCGElement(cgConnectionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				CGEcoreRealizedVariable cgEcoreRealizedVariable = (CGEcoreRealizedVariable)theEObject;
				T result = caseCGEcoreRealizedVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGRealizedVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGVariable(cgEcoreRealizedVariable);
				if (result == null) result = caseCGValuedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGTypedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGNamedElement(cgEcoreRealizedVariable);
				if (result == null) result = caseCGElement(cgEcoreRealizedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				CGFunction cgFunction = (CGFunction)theEObject;
				T result = caseCGFunction(cgFunction);
				if (result == null) result = caseCGOperation(cgFunction);
				if (result == null) result = caseCGCallable(cgFunction);
				if (result == null) result = caseCGValuedElement(cgFunction);
				if (result == null) result = caseCGTypedElement(cgFunction);
				if (result == null) result = caseCGNamedElement(cgFunction);
				if (result == null) result = caseCGElement(cgFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)theEObject;
				T result = caseCGFunctionCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGOperationCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGCallExp(cgFunctionCallExp);
				if (result == null) result = caseCGValuedElement(cgFunctionCallExp);
				if (result == null) result = caseCGTypedElement(cgFunctionCallExp);
				if (result == null) result = caseCGNamedElement(cgFunctionCallExp);
				if (result == null) result = caseCGElement(cgFunctionCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				CGFunctionParameter cgFunctionParameter = (CGFunctionParameter)theEObject;
				T result = caseCGFunctionParameter(cgFunctionParameter);
				if (result == null) result = caseCGParameter(cgFunctionParameter);
				if (result == null) result = caseCGVariable(cgFunctionParameter);
				if (result == null) result = caseCGValuedElement(cgFunctionParameter);
				if (result == null) result = caseCGTypedElement(cgFunctionParameter);
				if (result == null) result = caseCGNamedElement(cgFunctionParameter);
				if (result == null) result = caseCGElement(cgFunctionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				CGGuardVariable cgGuardVariable = (CGGuardVariable)theEObject;
				T result = caseCGGuardVariable(cgGuardVariable);
				if (result == null) result = caseCGParameter(cgGuardVariable);
				if (result == null) result = caseCGVariable(cgGuardVariable);
				if (result == null) result = caseCGValuedElement(cgGuardVariable);
				if (result == null) result = caseCGTypedElement(cgGuardVariable);
				if (result == null) result = caseCGNamedElement(cgGuardVariable);
				if (result == null) result = caseCGElement(cgGuardVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				CGMapping cgMapping = (CGMapping)theEObject;
				T result = caseCGMapping(cgMapping);
				if (result == null) result = caseCGValuedElement(cgMapping);
				if (result == null) result = caseCGTypedElement(cgMapping);
				if (result == null) result = caseCGNamedElement(cgMapping);
				if (result == null) result = caseCGElement(cgMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				CGMappingCall cgMappingCall = (CGMappingCall)theEObject;
				T result = caseCGMappingCall(cgMappingCall);
				if (result == null) result = caseCGValuedElement(cgMappingCall);
				if (result == null) result = caseCGTypedElement(cgMappingCall);
				if (result == null) result = caseCGNamedElement(cgMappingCall);
				if (result == null) result = caseCGElement(cgMappingCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				CGMappingCallBinding cgMappingCallBinding = (CGMappingCallBinding)theEObject;
				T result = caseCGMappingCallBinding(cgMappingCallBinding);
				if (result == null) result = caseCGValuedElement(cgMappingCallBinding);
				if (result == null) result = caseCGTypedElement(cgMappingCallBinding);
				if (result == null) result = caseCGNamedElement(cgMappingCallBinding);
				if (result == null) result = caseCGElement(cgMappingCallBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10: {
				CGMappingExp cgMappingExp = (CGMappingExp)theEObject;
				T result = caseCGMappingExp(cgMappingExp);
				if (result == null) result = caseCGValuedElement(cgMappingExp);
				if (result == null) result = caseCGTypedElement(cgMappingExp);
				if (result == null) result = caseCGNamedElement(cgMappingExp);
				if (result == null) result = caseCGElement(cgMappingExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11: {
				CGMappingLoop cgMappingLoop = (CGMappingLoop)theEObject;
				T result = caseCGMappingLoop(cgMappingLoop);
				if (result == null) result = caseCGIterationCallExp(cgMappingLoop);
				if (result == null) result = caseCGSourcedCallExp(cgMappingLoop);
				if (result == null) result = caseCGCallExp(cgMappingLoop);
				if (result == null) result = caseCGValuedElement(cgMappingLoop);
				if (result == null) result = caseCGTypedElement(cgMappingLoop);
				if (result == null) result = caseCGNamedElement(cgMappingLoop);
				if (result == null) result = caseCGElement(cgMappingLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12: {
				CGMiddlePropertyAssignment cgMiddlePropertyAssignment = (CGMiddlePropertyAssignment)theEObject;
				T result = caseCGMiddlePropertyAssignment(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGEcorePropertyAssignment(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGPropertyAssignment(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGValuedElement(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGTypedElement(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGNamedElement(cgMiddlePropertyAssignment);
				if (result == null) result = caseCGElement(cgMiddlePropertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13: {
				CGMiddlePropertyCallExp cgMiddlePropertyCallExp = (CGMiddlePropertyCallExp)theEObject;
				T result = caseCGMiddlePropertyCallExp(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGOppositePropertyCallExp(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGNavigationCallExp(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGSourcedCallExp(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGCallExp(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGValuedElement(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGTypedElement(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGNamedElement(cgMiddlePropertyCallExp);
				if (result == null) result = caseCGElement(cgMiddlePropertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14: {
				CGRealizedVariable cgRealizedVariable = (CGRealizedVariable)theEObject;
				T result = caseCGRealizedVariable(cgRealizedVariable);
				if (result == null) result = caseCGVariable(cgRealizedVariable);
				if (result == null) result = caseCGValuedElement(cgRealizedVariable);
				if (result == null) result = caseCGTypedElement(cgRealizedVariable);
				if (result == null) result = caseCGNamedElement(cgRealizedVariable);
				if (result == null) result = caseCGElement(cgRealizedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 15: {
				CGRealizedVariablePart cgRealizedVariablePart = (CGRealizedVariablePart)theEObject;
				T result = caseCGRealizedVariablePart(cgRealizedVariablePart);
				if (result == null) result = caseCGValuedElement(cgRealizedVariablePart);
				if (result == null) result = caseCGTypedElement(cgRealizedVariablePart);
				if (result == null) result = caseCGNamedElement(cgRealizedVariablePart);
				if (result == null) result = caseCGElement(cgRealizedVariablePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 16: {
				CGSpeculateExp cgSpeculateExp = (CGSpeculateExp)theEObject;
				T result = caseCGSpeculateExp(cgSpeculateExp);
				if (result == null) result = caseCGValuedElement(cgSpeculateExp);
				if (result == null) result = caseCGTypedElement(cgSpeculateExp);
				if (result == null) result = caseCGNamedElement(cgSpeculateExp);
				if (result == null) result = caseCGElement(cgSpeculateExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 17: {
				CGSpeculatePart cgSpeculatePart = (CGSpeculatePart)theEObject;
				T result = caseCGSpeculatePart(cgSpeculatePart);
				if (result == null) result = caseCGValuedElement(cgSpeculatePart);
				if (result == null) result = caseCGTypedElement(cgSpeculatePart);
				if (result == null) result = caseCGNamedElement(cgSpeculatePart);
				if (result == null) result = caseCGElement(cgSpeculatePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 18: {
				CGTransformation cgTransformation = (CGTransformation)theEObject;
				T result = caseCGTransformation(cgTransformation);
				if (result == null) result = caseCGClass(cgTransformation);
				if (result == null) result = caseCGNamedElement(cgTransformation);
				if (result == null) result = caseCGElement(cgTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 19: {
				CGTypedModel cgTypedModel = (CGTypedModel)theEObject;
				T result = caseCGTypedModel(cgTypedModel);
				if (result == null) result = caseCGValuedElement(cgTypedModel);
				if (result == null) result = caseCGTypedElement(cgTypedModel);
				if (result == null) result = caseCGNamedElement(cgTypedModel);
				if (result == null) result = caseCGElement(cgTypedModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Connection Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Connection Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGConnectionAssignment(CGConnectionAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Connection Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Connection Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGConnectionVariable(CGConnectionVariable object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>CG Mapping Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Mapping Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMappingExp(CGMappingExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Mapping Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Mapping Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMappingLoop(CGMappingLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Middle Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Middle Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMiddlePropertyAssignment(CGMiddlePropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Middle Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Middle Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGMiddlePropertyCallExp(CGMiddlePropertyCallExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>CG Realized Variable Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Realized Variable Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGRealizedVariablePart(CGRealizedVariablePart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Speculate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Speculate Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGSpeculateExp(CGSpeculateExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Speculate Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Speculate Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGSpeculatePart(CGSpeculatePart object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>CG Sourced Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Sourced Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGSourcedCallExp(CGSourcedCallExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>CG Iteration Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Iteration Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGIterationCallExp(CGIterationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Navigation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Navigation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGNavigationCallExp(CGNavigationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CG Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Opposite Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGOppositePropertyCallExp(CGOppositePropertyCallExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>CG Callable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CG Callable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCGCallable(CGCallable object) {
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
