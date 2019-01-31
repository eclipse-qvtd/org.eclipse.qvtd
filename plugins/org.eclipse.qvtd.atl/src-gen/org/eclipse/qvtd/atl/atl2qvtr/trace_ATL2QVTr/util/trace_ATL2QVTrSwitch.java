/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.*;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;
import org.eclipse.qvtd.runtime.qvttrace.Execution;
import org.eclipse.qvtd.runtime.qvttrace.TraceElement;
import org.eclipse.qvtd.runtime.qvttrace.TraceInstance;

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
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage
 * @generated
 */
public class trace_ATL2QVTrSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static trace_ATL2QVTrPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public trace_ATL2QVTrSwitch() {
		if (modelPackage == null) {
			modelPackage = trace_ATL2QVTrPackage.eINSTANCE;
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
				CmapVariableExp_referredVariable_Helper cmapVariableExp_referredVariable_Helper = (CmapVariableExp_referredVariable_Helper)theEObject;
				T result = caseCmapVariableExp_referredVariable_Helper(cmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseDmapVariableExp_referredVariable(cmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseDispatch(cmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTraceInstance(cmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTraceElement(cmapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				CmapVariableExp_referredVariable_VariableDeclaration cmapVariableExp_referredVariable_VariableDeclaration = (CmapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseCmapVariableExp_referredVariable_VariableDeclaration(cmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseDmapVariableExp_referredVariable(cmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseDispatch(cmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTraceInstance(cmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTraceElement(cmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				DmapHelper dmapHelper = (DmapHelper)theEObject;
				T result = caseDmapHelper(dmapHelper);
				if (result == null) result = caseDispatch(dmapHelper);
				if (result == null) result = caseTraceInstance(dmapHelper);
				if (result == null) result = caseTraceElement(dmapHelper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				DmapOclExpression dmapOclExpression = (DmapOclExpression)theEObject;
				T result = caseDmapOclExpression(dmapOclExpression);
				if (result == null) result = caseDispatch(dmapOclExpression);
				if (result == null) result = caseTraceInstance(dmapOclExpression);
				if (result == null) result = caseTraceElement(dmapOclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				DmapVariableExp_referredVariable dmapVariableExp_referredVariable = (DmapVariableExp_referredVariable)theEObject;
				T result = caseDmapVariableExp_referredVariable(dmapVariableExp_referredVariable);
				if (result == null) result = caseDispatch(dmapVariableExp_referredVariable);
				if (result == null) result = caseTraceInstance(dmapVariableExp_referredVariable);
				if (result == null) result = caseTraceElement(dmapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				ImapHelper imapHelper = (ImapHelper)theEObject;
				T result = caseImapHelper(imapHelper);
				if (result == null) result = caseExecution(imapHelper);
				if (result == null) result = caseTraceInstance(imapHelper);
				if (result == null) result = caseTraceElement(imapHelper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				ImapOclExpression imapOclExpression = (ImapOclExpression)theEObject;
				T result = caseImapOclExpression(imapOclExpression);
				if (result == null) result = caseExecution(imapOclExpression);
				if (result == null) result = caseTraceInstance(imapOclExpression);
				if (result == null) result = caseTraceElement(imapOclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				ImapVariableExp_referredVariable imapVariableExp_referredVariable = (ImapVariableExp_referredVariable)theEObject;
				T result = caseImapVariableExp_referredVariable(imapVariableExp_referredVariable);
				if (result == null) result = caseExecution(imapVariableExp_referredVariable);
				if (result == null) result = caseTraceInstance(imapVariableExp_referredVariable);
				if (result == null) result = caseTraceElement(imapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				TmapBinding tmapBinding = (TmapBinding)theEObject;
				T result = caseTmapBinding(tmapBinding);
				if (result == null) result = caseExecution(tmapBinding);
				if (result == null) result = caseTraceInstance(tmapBinding);
				if (result == null) result = caseTraceElement(tmapBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				TmapBooleanExp tmapBooleanExp = (TmapBooleanExp)theEObject;
				T result = caseTmapBooleanExp(tmapBooleanExp);
				if (result == null) result = caseImapOclExpression(tmapBooleanExp);
				if (result == null) result = caseExecution(tmapBooleanExp);
				if (result == null) result = caseTraceInstance(tmapBooleanExp);
				if (result == null) result = caseTraceElement(tmapBooleanExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10: {
				TmapHelper_Attribute tmapHelper_Attribute = (TmapHelper_Attribute)theEObject;
				T result = caseTmapHelper_Attribute(tmapHelper_Attribute);
				if (result == null) result = caseImapHelper(tmapHelper_Attribute);
				if (result == null) result = caseExecution(tmapHelper_Attribute);
				if (result == null) result = caseTraceInstance(tmapHelper_Attribute);
				if (result == null) result = caseTraceElement(tmapHelper_Attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11: {
				TmapHelper_Context tmapHelper_Context = (TmapHelper_Context)theEObject;
				T result = caseTmapHelper_Context(tmapHelper_Context);
				if (result == null) result = caseExecution(tmapHelper_Context);
				if (result == null) result = caseTraceInstance(tmapHelper_Context);
				if (result == null) result = caseTraceElement(tmapHelper_Context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12: {
				TmapHelper_Operation tmapHelper_Operation = (TmapHelper_Operation)theEObject;
				T result = caseTmapHelper_Operation(tmapHelper_Operation);
				if (result == null) result = caseImapHelper(tmapHelper_Operation);
				if (result == null) result = caseExecution(tmapHelper_Operation);
				if (result == null) result = caseTraceInstance(tmapHelper_Operation);
				if (result == null) result = caseTraceElement(tmapHelper_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13: {
				TmapIfExp tmapIfExp = (TmapIfExp)theEObject;
				T result = caseTmapIfExp(tmapIfExp);
				if (result == null) result = caseImapOclExpression(tmapIfExp);
				if (result == null) result = caseExecution(tmapIfExp);
				if (result == null) result = caseTraceInstance(tmapIfExp);
				if (result == null) result = caseTraceElement(tmapIfExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14: {
				TmapInPattern tmapInPattern = (TmapInPattern)theEObject;
				T result = caseTmapInPattern(tmapInPattern);
				if (result == null) result = caseExecution(tmapInPattern);
				if (result == null) result = caseTraceInstance(tmapInPattern);
				if (result == null) result = caseTraceElement(tmapInPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 15: {
				TmapInPattern_filter tmapInPattern_filter = (TmapInPattern_filter)theEObject;
				T result = caseTmapInPattern_filter(tmapInPattern_filter);
				if (result == null) result = caseExecution(tmapInPattern_filter);
				if (result == null) result = caseTraceInstance(tmapInPattern_filter);
				if (result == null) result = caseTraceElement(tmapInPattern_filter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 16: {
				TmapIntegerExp tmapIntegerExp = (TmapIntegerExp)theEObject;
				T result = caseTmapIntegerExp(tmapIntegerExp);
				if (result == null) result = caseImapOclExpression(tmapIntegerExp);
				if (result == null) result = caseExecution(tmapIntegerExp);
				if (result == null) result = caseTraceInstance(tmapIntegerExp);
				if (result == null) result = caseTraceElement(tmapIntegerExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 17: {
				TmapMatchedRule tmapMatchedRule = (TmapMatchedRule)theEObject;
				T result = caseTmapMatchedRule(tmapMatchedRule);
				if (result == null) result = caseExecution(tmapMatchedRule);
				if (result == null) result = caseTraceInstance(tmapMatchedRule);
				if (result == null) result = caseTraceElement(tmapMatchedRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 18: {
				TmapMatchedRule_super tmapMatchedRule_super = (TmapMatchedRule_super)theEObject;
				T result = caseTmapMatchedRule_super(tmapMatchedRule_super);
				if (result == null) result = caseExecution(tmapMatchedRule_super);
				if (result == null) result = caseTraceInstance(tmapMatchedRule_super);
				if (result == null) result = caseTraceElement(tmapMatchedRule_super);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 19: {
				TmapModule tmapModule = (TmapModule)theEObject;
				T result = caseTmapModule(tmapModule);
				if (result == null) result = caseExecution(tmapModule);
				if (result == null) result = caseTraceInstance(tmapModule);
				if (result == null) result = caseTraceElement(tmapModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 20: {
				TmapNavigationOrAttributeCallExp_Helper tmapNavigationOrAttributeCallExp_Helper = (TmapNavigationOrAttributeCallExp_Helper)theEObject;
				T result = caseTmapNavigationOrAttributeCallExp_Helper(tmapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseImapOclExpression(tmapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseExecution(tmapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTraceInstance(tmapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTraceElement(tmapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 21: {
				TmapNavigationOrAttributeCallExp_Property tmapNavigationOrAttributeCallExp_Property = (TmapNavigationOrAttributeCallExp_Property)theEObject;
				T result = caseTmapNavigationOrAttributeCallExp_Property(tmapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseImapOclExpression(tmapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseExecution(tmapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTraceInstance(tmapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTraceElement(tmapNavigationOrAttributeCallExp_Property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 22: {
				TmapOclMetamodel tmapOclMetamodel = (TmapOclMetamodel)theEObject;
				T result = caseTmapOclMetamodel(tmapOclMetamodel);
				if (result == null) result = caseExecution(tmapOclMetamodel);
				if (result == null) result = caseTraceInstance(tmapOclMetamodel);
				if (result == null) result = caseTraceElement(tmapOclMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 23: {
				TmapOclModel_IN tmapOclModel_IN = (TmapOclModel_IN)theEObject;
				T result = caseTmapOclModel_IN(tmapOclModel_IN);
				if (result == null) result = caseExecution(tmapOclModel_IN);
				if (result == null) result = caseTraceInstance(tmapOclModel_IN);
				if (result == null) result = caseTraceElement(tmapOclModel_IN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 24: {
				TmapOclModel_OUT tmapOclModel_OUT = (TmapOclModel_OUT)theEObject;
				T result = caseTmapOclModel_OUT(tmapOclModel_OUT);
				if (result == null) result = caseExecution(tmapOclModel_OUT);
				if (result == null) result = caseTraceInstance(tmapOclModel_OUT);
				if (result == null) result = caseTraceElement(tmapOclModel_OUT);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 25: {
				TmapOperationCallExp_Helper tmapOperationCallExp_Helper = (TmapOperationCallExp_Helper)theEObject;
				T result = caseTmapOperationCallExp_Helper(tmapOperationCallExp_Helper);
				if (result == null) result = caseImapOclExpression(tmapOperationCallExp_Helper);
				if (result == null) result = caseExecution(tmapOperationCallExp_Helper);
				if (result == null) result = caseTraceInstance(tmapOperationCallExp_Helper);
				if (result == null) result = caseTraceElement(tmapOperationCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 26: {
				TmapOperationCallExp_Operation tmapOperationCallExp_Operation = (TmapOperationCallExp_Operation)theEObject;
				T result = caseTmapOperationCallExp_Operation(tmapOperationCallExp_Operation);
				if (result == null) result = caseImapOclExpression(tmapOperationCallExp_Operation);
				if (result == null) result = caseExecution(tmapOperationCallExp_Operation);
				if (result == null) result = caseTraceInstance(tmapOperationCallExp_Operation);
				if (result == null) result = caseTraceElement(tmapOperationCallExp_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 27: {
				TmapOperationCallExp_argument tmapOperationCallExp_argument = (TmapOperationCallExp_argument)theEObject;
				T result = caseTmapOperationCallExp_argument(tmapOperationCallExp_argument);
				if (result == null) result = caseExecution(tmapOperationCallExp_argument);
				if (result == null) result = caseTraceInstance(tmapOperationCallExp_argument);
				if (result == null) result = caseTraceElement(tmapOperationCallExp_argument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 28: {
				TmapOperatorCallExp tmapOperatorCallExp = (TmapOperatorCallExp)theEObject;
				T result = caseTmapOperatorCallExp(tmapOperatorCallExp);
				if (result == null) result = caseImapOclExpression(tmapOperatorCallExp);
				if (result == null) result = caseExecution(tmapOperatorCallExp);
				if (result == null) result = caseTraceInstance(tmapOperatorCallExp);
				if (result == null) result = caseTraceElement(tmapOperatorCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 29: {
				TmapOutPattern tmapOutPattern = (TmapOutPattern)theEObject;
				T result = caseTmapOutPattern(tmapOutPattern);
				if (result == null) result = caseExecution(tmapOutPattern);
				if (result == null) result = caseTraceInstance(tmapOutPattern);
				if (result == null) result = caseTraceElement(tmapOutPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 30: {
				TmapSimpleInPatternElement tmapSimpleInPatternElement = (TmapSimpleInPatternElement)theEObject;
				T result = caseTmapSimpleInPatternElement(tmapSimpleInPatternElement);
				if (result == null) result = caseExecution(tmapSimpleInPatternElement);
				if (result == null) result = caseTraceInstance(tmapSimpleInPatternElement);
				if (result == null) result = caseTraceElement(tmapSimpleInPatternElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 31: {
				TmapSimpleOutPatternElement tmapSimpleOutPatternElement = (TmapSimpleOutPatternElement)theEObject;
				T result = caseTmapSimpleOutPatternElement(tmapSimpleOutPatternElement);
				if (result == null) result = caseExecution(tmapSimpleOutPatternElement);
				if (result == null) result = caseTraceInstance(tmapSimpleOutPatternElement);
				if (result == null) result = caseTraceElement(tmapSimpleOutPatternElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 32: {
				TmapStringExp tmapStringExp = (TmapStringExp)theEObject;
				T result = caseTmapStringExp(tmapStringExp);
				if (result == null) result = caseImapOclExpression(tmapStringExp);
				if (result == null) result = caseExecution(tmapStringExp);
				if (result == null) result = caseTraceInstance(tmapStringExp);
				if (result == null) result = caseTraceElement(tmapStringExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 33: {
				TmapVariable tmapVariable = (TmapVariable)theEObject;
				T result = caseTmapVariable(tmapVariable);
				if (result == null) result = caseExecution(tmapVariable);
				if (result == null) result = caseTraceInstance(tmapVariable);
				if (result == null) result = caseTraceElement(tmapVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 34: {
				TmapVariableExp tmapVariableExp = (TmapVariableExp)theEObject;
				T result = caseTmapVariableExp(tmapVariableExp);
				if (result == null) result = caseImapOclExpression(tmapVariableExp);
				if (result == null) result = caseExecution(tmapVariableExp);
				if (result == null) result = caseTraceInstance(tmapVariableExp);
				if (result == null) result = caseTraceElement(tmapVariableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 35: {
				TmapVariableExp_referredVariable_Helper tmapVariableExp_referredVariable_Helper = (TmapVariableExp_referredVariable_Helper)theEObject;
				T result = caseTmapVariableExp_referredVariable_Helper(tmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseImapVariableExp_referredVariable(tmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseExecution(tmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTraceInstance(tmapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTraceElement(tmapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 36: {
				TmapVariableExp_referredVariable_VariableDeclaration tmapVariableExp_referredVariable_VariableDeclaration = (TmapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseTmapVariableExp_referredVariable_VariableDeclaration(tmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseImapVariableExp_referredVariable(tmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseExecution(tmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTraceInstance(tmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTraceElement(tmapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cmap Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cmap Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCmapVariableExp_referredVariable_Helper(CmapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cmap Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCmapVariableExp_referredVariable_VariableDeclaration(CmapVariableExp_referredVariable_VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dmap Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dmap Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDmapHelper(DmapHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dmap Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dmap Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDmapOclExpression(DmapOclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dmap Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dmap Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDmapVariableExp_referredVariable(DmapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imap Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imap Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImapHelper(ImapHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imap Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imap Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImapOclExpression(ImapOclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imap Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imap Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImapVariableExp_referredVariable(ImapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapBinding(TmapBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Boolean Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Boolean Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapBooleanExp(TmapBooleanExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Helper Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Helper Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapHelper_Attribute(TmapHelper_Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Helper Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Helper Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapHelper_Context(TmapHelper_Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Helper Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Helper Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapHelper_Operation(TmapHelper_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapIfExp(TmapIfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap In Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap In Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapInPattern(TmapInPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap In Pattern filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap In Pattern filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapInPattern_filter(TmapInPattern_filter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Integer Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Integer Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapIntegerExp(TmapIntegerExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Matched Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Matched Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapMatchedRule(TmapMatchedRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Matched Rule super</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Matched Rule super</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapMatchedRule_super(TmapMatchedRule_super object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapModule(TmapModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Navigation Or Attribute Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Navigation Or Attribute Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Navigation Or Attribute Call Exp Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Navigation Or Attribute Call Exp Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Ocl Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Ocl Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOclMetamodel(TmapOclMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Ocl Model IN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Ocl Model IN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOclModel_IN(TmapOclModel_IN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Ocl Model OUT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Ocl Model OUT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOclModel_OUT(TmapOclModel_OUT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOperationCallExp_Helper(TmapOperationCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOperationCallExp_Operation(TmapOperationCallExp_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Operation Call Exp argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOperationCallExp_argument(TmapOperationCallExp_argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOperatorCallExp(TmapOperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Out Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Out Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapOutPattern(TmapOutPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Simple In Pattern Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Simple In Pattern Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapSimpleInPatternElement(TmapSimpleInPatternElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Simple Out Pattern Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Simple Out Pattern Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapSimpleOutPatternElement(TmapSimpleOutPatternElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap String Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap String Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapStringExp(TmapStringExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapVariable(TmapVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapVariableExp(TmapVariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tmap Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTmapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceElement(TraceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceInstance(TraceInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDispatch(Dispatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecution(Execution object) {
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

} //trace_ATL2QVTrSwitch
