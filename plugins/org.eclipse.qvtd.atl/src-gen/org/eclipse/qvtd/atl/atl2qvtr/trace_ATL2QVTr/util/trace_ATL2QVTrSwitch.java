/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			case trace_ATL2QVTrPackage.TC_MAP_BINDING: {
				TC_mapBinding tC_mapBinding = (TC_mapBinding)theEObject;
				T result = caseTC_mapBinding(tC_mapBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_BOOLEAN_EXP: {
				TC_mapBooleanExp tC_mapBooleanExp = (TC_mapBooleanExp)theEObject;
				T result = caseTC_mapBooleanExp(tC_mapBooleanExp);
				if (result == null) result = caseTI_mapBooleanExp(tC_mapBooleanExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapBooleanExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_HELPER: {
				TC_mapHelper tC_mapHelper = (TC_mapHelper)theEObject;
				T result = caseTC_mapHelper(tC_mapHelper);
				if (result == null) result = caseTI_mapHelper(tC_mapHelper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE: {
				TC_mapHelper_Attribute tC_mapHelper_Attribute = (TC_mapHelper_Attribute)theEObject;
				T result = caseTC_mapHelper_Attribute(tC_mapHelper_Attribute);
				if (result == null) result = caseTI_mapHelper_Attribute(tC_mapHelper_Attribute);
				if (result == null) result = caseTI_mapHelper(tC_mapHelper_Attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT: {
				TC_mapHelper_Context tC_mapHelper_Context = (TC_mapHelper_Context)theEObject;
				T result = caseTC_mapHelper_Context(tC_mapHelper_Context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_OPERATION: {
				TC_mapHelper_Operation tC_mapHelper_Operation = (TC_mapHelper_Operation)theEObject;
				T result = caseTC_mapHelper_Operation(tC_mapHelper_Operation);
				if (result == null) result = caseTI_mapHelper_Operation(tC_mapHelper_Operation);
				if (result == null) result = caseTI_mapHelper(tC_mapHelper_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP: {
				TC_mapIfExp tC_mapIfExp = (TC_mapIfExp)theEObject;
				T result = caseTC_mapIfExp(tC_mapIfExp);
				if (result == null) result = caseTI_mapIfExp(tC_mapIfExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapIfExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN: {
				TC_mapInPattern tC_mapInPattern = (TC_mapInPattern)theEObject;
				T result = caseTC_mapInPattern(tC_mapInPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER: {
				TC_mapInPattern_filter tC_mapInPattern_filter = (TC_mapInPattern_filter)theEObject;
				T result = caseTC_mapInPattern_filter(tC_mapInPattern_filter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP: {
				TC_mapIntegerExp tC_mapIntegerExp = (TC_mapIntegerExp)theEObject;
				T result = caseTC_mapIntegerExp(tC_mapIntegerExp);
				if (result == null) result = caseTI_mapIntegerExp(tC_mapIntegerExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapIntegerExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE: {
				TC_mapMatchedRule tC_mapMatchedRule = (TC_mapMatchedRule)theEObject;
				T result = caseTC_mapMatchedRule(tC_mapMatchedRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER: {
				TC_mapMatchedRule_super tC_mapMatchedRule_super = (TC_mapMatchedRule_super)theEObject;
				T result = caseTC_mapMatchedRule_super(tC_mapMatchedRule_super);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_MODULE: {
				TC_mapModule tC_mapModule = (TC_mapModule)theEObject;
				T result = caseTC_mapModule(tC_mapModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP: {
				TC_mapNavigationOrAttributeCallExp tC_mapNavigationOrAttributeCallExp = (TC_mapNavigationOrAttributeCallExp)theEObject;
				T result = caseTC_mapNavigationOrAttributeCallExp(tC_mapNavigationOrAttributeCallExp);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp(tC_mapNavigationOrAttributeCallExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapNavigationOrAttributeCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER: {
				TC_mapNavigationOrAttributeCallExp_Helper tC_mapNavigationOrAttributeCallExp_Helper = (TC_mapNavigationOrAttributeCallExp_Helper)theEObject;
				T result = caseTC_mapNavigationOrAttributeCallExp_Helper(tC_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp_Helper(tC_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp(tC_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTI_mapOclExpression(tC_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY: {
				TC_mapNavigationOrAttributeCallExp_Property tC_mapNavigationOrAttributeCallExp_Property = (TC_mapNavigationOrAttributeCallExp_Property)theEObject;
				T result = caseTC_mapNavigationOrAttributeCallExp_Property(tC_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp_Property(tC_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp(tC_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTI_mapOclExpression(tC_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OCL_EXPRESSION: {
				TC_mapOclExpression tC_mapOclExpression = (TC_mapOclExpression)theEObject;
				T result = caseTC_mapOclExpression(tC_mapOclExpression);
				if (result == null) result = caseTI_mapOclExpression(tC_mapOclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL: {
				TC_mapOclMetamodel tC_mapOclMetamodel = (TC_mapOclMetamodel)theEObject;
				T result = caseTC_mapOclMetamodel(tC_mapOclMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN: {
				TC_mapOclModel_IN tC_mapOclModel_IN = (TC_mapOclModel_IN)theEObject;
				T result = caseTC_mapOclModel_IN(tC_mapOclModel_IN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_OUT: {
				TC_mapOclModel_OUT tC_mapOclModel_OUT = (TC_mapOclModel_OUT)theEObject;
				T result = caseTC_mapOclModel_OUT(tC_mapOclModel_OUT);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP: {
				TC_mapOperationCallExp tC_mapOperationCallExp = (TC_mapOperationCallExp)theEObject;
				T result = caseTC_mapOperationCallExp(tC_mapOperationCallExp);
				if (result == null) result = caseTI_mapOperationCallExp(tC_mapOperationCallExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapOperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_HELPER: {
				TC_mapOperationCallExp_Helper tC_mapOperationCallExp_Helper = (TC_mapOperationCallExp_Helper)theEObject;
				T result = caseTC_mapOperationCallExp_Helper(tC_mapOperationCallExp_Helper);
				if (result == null) result = caseTI_mapOperationCallExp_Helper(tC_mapOperationCallExp_Helper);
				if (result == null) result = caseTI_mapOperationCallExp(tC_mapOperationCallExp_Helper);
				if (result == null) result = caseTI_mapOclExpression(tC_mapOperationCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION: {
				TC_mapOperationCallExp_Operation tC_mapOperationCallExp_Operation = (TC_mapOperationCallExp_Operation)theEObject;
				T result = caseTC_mapOperationCallExp_Operation(tC_mapOperationCallExp_Operation);
				if (result == null) result = caseTI_mapOperationCallExp_Operation(tC_mapOperationCallExp_Operation);
				if (result == null) result = caseTI_mapOperationCallExp(tC_mapOperationCallExp_Operation);
				if (result == null) result = caseTI_mapOclExpression(tC_mapOperationCallExp_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT: {
				TC_mapOperationCallExp_argument tC_mapOperationCallExp_argument = (TC_mapOperationCallExp_argument)theEObject;
				T result = caseTC_mapOperationCallExp_argument(tC_mapOperationCallExp_argument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP: {
				TC_mapOperatorCallExp tC_mapOperatorCallExp = (TC_mapOperatorCallExp)theEObject;
				T result = caseTC_mapOperatorCallExp(tC_mapOperatorCallExp);
				if (result == null) result = caseTI_mapOperatorCallExp(tC_mapOperatorCallExp);
				if (result == null) result = caseTI_mapOperationCallExp(tC_mapOperatorCallExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapOperatorCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_OUT_PATTERN: {
				TC_mapOutPattern tC_mapOutPattern = (TC_mapOutPattern)theEObject;
				T result = caseTC_mapOutPattern(tC_mapOutPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT: {
				TC_mapSimpleInPatternElement tC_mapSimpleInPatternElement = (TC_mapSimpleInPatternElement)theEObject;
				T result = caseTC_mapSimpleInPatternElement(tC_mapSimpleInPatternElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT: {
				TC_mapSimpleOutPatternElement tC_mapSimpleOutPatternElement = (TC_mapSimpleOutPatternElement)theEObject;
				T result = caseTC_mapSimpleOutPatternElement(tC_mapSimpleOutPatternElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_STRING_EXP: {
				TC_mapStringExp tC_mapStringExp = (TC_mapStringExp)theEObject;
				T result = caseTC_mapStringExp(tC_mapStringExp);
				if (result == null) result = caseTI_mapStringExp(tC_mapStringExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapStringExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE: {
				TC_mapVariable tC_mapVariable = (TC_mapVariable)theEObject;
				T result = caseTC_mapVariable(tC_mapVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP: {
				TC_mapVariableExp tC_mapVariableExp = (TC_mapVariableExp)theEObject;
				T result = caseTC_mapVariableExp(tC_mapVariableExp);
				if (result == null) result = caseTI_mapVariableExp(tC_mapVariableExp);
				if (result == null) result = caseTI_mapOclExpression(tC_mapVariableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE: {
				TC_mapVariableExp_referredVariable tC_mapVariableExp_referredVariable = (TC_mapVariableExp_referredVariable)theEObject;
				T result = caseTC_mapVariableExp_referredVariable(tC_mapVariableExp_referredVariable);
				if (result == null) result = caseTI_mapVariableExp_referredVariable(tC_mapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: {
				TC_mapVariableExp_referredVariable_Helper tC_mapVariableExp_referredVariable_Helper = (TC_mapVariableExp_referredVariable_Helper)theEObject;
				T result = caseTC_mapVariableExp_referredVariable_Helper(tC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTI_mapVariableExp_referredVariable_Helper(tC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTI_mapVariableExp_referredVariable(tC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: {
				TC_mapVariableExp_referredVariable_VariableDeclaration tC_mapVariableExp_referredVariable_VariableDeclaration = (TC_mapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseTC_mapVariableExp_referredVariable_VariableDeclaration(tC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTI_mapVariableExp_referredVariable_VariableDeclaration(tC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTI_mapVariableExp_referredVariable(tC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_BOOLEAN_EXP: {
				TI_mapBooleanExp tI_mapBooleanExp = (TI_mapBooleanExp)theEObject;
				T result = caseTI_mapBooleanExp(tI_mapBooleanExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapBooleanExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_HELPER: {
				TI_mapHelper tI_mapHelper = (TI_mapHelper)theEObject;
				T result = caseTI_mapHelper(tI_mapHelper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_HELPER_ATTRIBUTE: {
				TI_mapHelper_Attribute tI_mapHelper_Attribute = (TI_mapHelper_Attribute)theEObject;
				T result = caseTI_mapHelper_Attribute(tI_mapHelper_Attribute);
				if (result == null) result = caseTI_mapHelper(tI_mapHelper_Attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_HELPER_OPERATION: {
				TI_mapHelper_Operation tI_mapHelper_Operation = (TI_mapHelper_Operation)theEObject;
				T result = caseTI_mapHelper_Operation(tI_mapHelper_Operation);
				if (result == null) result = caseTI_mapHelper(tI_mapHelper_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_IF_EXP: {
				TI_mapIfExp tI_mapIfExp = (TI_mapIfExp)theEObject;
				T result = caseTI_mapIfExp(tI_mapIfExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapIfExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_INTEGER_EXP: {
				TI_mapIntegerExp tI_mapIntegerExp = (TI_mapIntegerExp)theEObject;
				T result = caseTI_mapIntegerExp(tI_mapIntegerExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapIntegerExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP: {
				TI_mapNavigationOrAttributeCallExp tI_mapNavigationOrAttributeCallExp = (TI_mapNavigationOrAttributeCallExp)theEObject;
				T result = caseTI_mapNavigationOrAttributeCallExp(tI_mapNavigationOrAttributeCallExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapNavigationOrAttributeCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER: {
				TI_mapNavigationOrAttributeCallExp_Helper tI_mapNavigationOrAttributeCallExp_Helper = (TI_mapNavigationOrAttributeCallExp_Helper)theEObject;
				T result = caseTI_mapNavigationOrAttributeCallExp_Helper(tI_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp(tI_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = caseTI_mapOclExpression(tI_mapNavigationOrAttributeCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY: {
				TI_mapNavigationOrAttributeCallExp_Property tI_mapNavigationOrAttributeCallExp_Property = (TI_mapNavigationOrAttributeCallExp_Property)theEObject;
				T result = caseTI_mapNavigationOrAttributeCallExp_Property(tI_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTI_mapNavigationOrAttributeCallExp(tI_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = caseTI_mapOclExpression(tI_mapNavigationOrAttributeCallExp_Property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_OCL_EXPRESSION: {
				TI_mapOclExpression tI_mapOclExpression = (TI_mapOclExpression)theEObject;
				T result = caseTI_mapOclExpression(tI_mapOclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_OPERATION_CALL_EXP: {
				TI_mapOperationCallExp tI_mapOperationCallExp = (TI_mapOperationCallExp)theEObject;
				T result = caseTI_mapOperationCallExp(tI_mapOperationCallExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapOperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_OPERATION_CALL_EXP_HELPER: {
				TI_mapOperationCallExp_Helper tI_mapOperationCallExp_Helper = (TI_mapOperationCallExp_Helper)theEObject;
				T result = caseTI_mapOperationCallExp_Helper(tI_mapOperationCallExp_Helper);
				if (result == null) result = caseTI_mapOperationCallExp(tI_mapOperationCallExp_Helper);
				if (result == null) result = caseTI_mapOclExpression(tI_mapOperationCallExp_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_OPERATION_CALL_EXP_OPERATION: {
				TI_mapOperationCallExp_Operation tI_mapOperationCallExp_Operation = (TI_mapOperationCallExp_Operation)theEObject;
				T result = caseTI_mapOperationCallExp_Operation(tI_mapOperationCallExp_Operation);
				if (result == null) result = caseTI_mapOperationCallExp(tI_mapOperationCallExp_Operation);
				if (result == null) result = caseTI_mapOclExpression(tI_mapOperationCallExp_Operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_OPERATOR_CALL_EXP: {
				TI_mapOperatorCallExp tI_mapOperatorCallExp = (TI_mapOperatorCallExp)theEObject;
				T result = caseTI_mapOperatorCallExp(tI_mapOperatorCallExp);
				if (result == null) result = caseTI_mapOperationCallExp(tI_mapOperatorCallExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapOperatorCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_STRING_EXP: {
				TI_mapStringExp tI_mapStringExp = (TI_mapStringExp)theEObject;
				T result = caseTI_mapStringExp(tI_mapStringExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapStringExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_VARIABLE_EXP: {
				TI_mapVariableExp tI_mapVariableExp = (TI_mapVariableExp)theEObject;
				T result = caseTI_mapVariableExp(tI_mapVariableExp);
				if (result == null) result = caseTI_mapOclExpression(tI_mapVariableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE: {
				TI_mapVariableExp_referredVariable tI_mapVariableExp_referredVariable = (TI_mapVariableExp_referredVariable)theEObject;
				T result = caseTI_mapVariableExp_referredVariable(tI_mapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: {
				TI_mapVariableExp_referredVariable_Helper tI_mapVariableExp_referredVariable_Helper = (TI_mapVariableExp_referredVariable_Helper)theEObject;
				T result = caseTI_mapVariableExp_referredVariable_Helper(tI_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseTI_mapVariableExp_referredVariable(tI_mapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: {
				TI_mapVariableExp_referredVariable_VariableDeclaration tI_mapVariableExp_referredVariable_VariableDeclaration = (TI_mapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseTI_mapVariableExp_referredVariable_VariableDeclaration(tI_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseTI_mapVariableExp_referredVariable(tI_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE: {
				WC_mapVariableExp_referredVariable wC_mapVariableExp_referredVariable = (WC_mapVariableExp_referredVariable)theEObject;
				T result = caseWC_mapVariableExp_referredVariable(wC_mapVariableExp_referredVariable);
				if (result == null) result = caseWI_mapVariableExp_referredVariable(wC_mapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: {
				WC_mapVariableExp_referredVariable_Helper wC_mapVariableExp_referredVariable_Helper = (WC_mapVariableExp_referredVariable_Helper)theEObject;
				T result = caseWC_mapVariableExp_referredVariable_Helper(wC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseWI_mapVariableExp_referredVariable_Helper(wC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseWI_mapVariableExp_referredVariable(wC_mapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: {
				WC_mapVariableExp_referredVariable_VariableDeclaration wC_mapVariableExp_referredVariable_VariableDeclaration = (WC_mapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseWC_mapVariableExp_referredVariable_VariableDeclaration(wC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseWI_mapVariableExp_referredVariable_VariableDeclaration(wC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseWI_mapVariableExp_referredVariable(wC_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE: {
				WI_mapVariableExp_referredVariable wI_mapVariableExp_referredVariable = (WI_mapVariableExp_referredVariable)theEObject;
				T result = caseWI_mapVariableExp_referredVariable(wI_mapVariableExp_referredVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: {
				WI_mapVariableExp_referredVariable_Helper wI_mapVariableExp_referredVariable_Helper = (WI_mapVariableExp_referredVariable_Helper)theEObject;
				T result = caseWI_mapVariableExp_referredVariable_Helper(wI_mapVariableExp_referredVariable_Helper);
				if (result == null) result = caseWI_mapVariableExp_referredVariable(wI_mapVariableExp_referredVariable_Helper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: {
				WI_mapVariableExp_referredVariable_VariableDeclaration wI_mapVariableExp_referredVariable_VariableDeclaration = (WI_mapVariableExp_referredVariable_VariableDeclaration)theEObject;
				T result = caseWI_mapVariableExp_referredVariable_VariableDeclaration(wI_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = caseWI_mapVariableExp_referredVariable(wI_mapVariableExp_referredVariable_VariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapBinding(TC_mapBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Boolean Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Boolean Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapBooleanExp(TC_mapBooleanExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapHelper(TC_mapHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Helper Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Helper Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapHelper_Attribute(TC_mapHelper_Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Helper Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Helper Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapHelper_Context(TC_mapHelper_Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Helper Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Helper Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapHelper_Operation(TC_mapHelper_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapIfExp(TC_mapIfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map In Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map In Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapInPattern(TC_mapInPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map In Pattern filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map In Pattern filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapInPattern_filter(TC_mapInPattern_filter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Integer Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Integer Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapIntegerExp(TC_mapIntegerExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Matched Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Matched Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapMatchedRule(TC_mapMatchedRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Matched Rule super</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Matched Rule super</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapMatchedRule_super(TC_mapMatchedRule_super object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapModule(TC_mapModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapNavigationOrAttributeCallExp(TC_mapNavigationOrAttributeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapNavigationOrAttributeCallExp_Helper(TC_mapNavigationOrAttributeCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Navigation Or Attribute Call Exp Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapNavigationOrAttributeCallExp_Property(TC_mapNavigationOrAttributeCallExp_Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOclExpression(TC_mapOclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Ocl Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Ocl Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOclMetamodel(TC_mapOclMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Ocl Model IN</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Ocl Model IN</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOclModel_IN(TC_mapOclModel_IN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Ocl Model OUT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Ocl Model OUT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOclModel_OUT(TC_mapOclModel_OUT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOperationCallExp(TC_mapOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Operation Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Operation Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOperationCallExp_Helper(TC_mapOperationCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Operation Call Exp Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Operation Call Exp Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOperationCallExp_Operation(TC_mapOperationCallExp_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Operation Call Exp argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Operation Call Exp argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOperationCallExp_argument(TC_mapOperationCallExp_argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOperatorCallExp(TC_mapOperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Out Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Out Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapOutPattern(TC_mapOutPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Simple In Pattern Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Simple In Pattern Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapSimpleInPatternElement(TC_mapSimpleInPatternElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Simple Out Pattern Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Simple Out Pattern Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapSimpleOutPatternElement(TC_mapSimpleOutPatternElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map String Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map String Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapStringExp(TC_mapStringExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapVariable(TC_mapVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapVariableExp(TC_mapVariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapVariableExp_referredVariable(TC_mapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapVariableExp_referredVariable_Helper(TC_mapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TC map Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTC_mapVariableExp_referredVariable_VariableDeclaration(TC_mapVariableExp_referredVariable_VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Boolean Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Boolean Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapBooleanExp(TI_mapBooleanExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapHelper(TI_mapHelper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Helper Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Helper Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapHelper_Attribute(TI_mapHelper_Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Helper Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Helper Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapHelper_Operation(TI_mapHelper_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map If Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map If Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapIfExp(TI_mapIfExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Integer Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Integer Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapIntegerExp(TI_mapIntegerExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapNavigationOrAttributeCallExp(TI_mapNavigationOrAttributeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapNavigationOrAttributeCallExp_Helper(TI_mapNavigationOrAttributeCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Navigation Or Attribute Call Exp Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapNavigationOrAttributeCallExp_Property(TI_mapNavigationOrAttributeCallExp_Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapOclExpression(TI_mapOclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapOperationCallExp(TI_mapOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Operation Call Exp Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Operation Call Exp Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapOperationCallExp_Helper(TI_mapOperationCallExp_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Operation Call Exp Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Operation Call Exp Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapOperationCallExp_Operation(TI_mapOperationCallExp_Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapOperatorCallExp(TI_mapOperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map String Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map String Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapStringExp(TI_mapStringExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapVariableExp(TI_mapVariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapVariableExp_referredVariable(TI_mapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapVariableExp_referredVariable_Helper(TI_mapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TI map Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTI_mapVariableExp_referredVariable_VariableDeclaration(TI_mapVariableExp_referredVariable_VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWC_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWC_mapVariableExp_referredVariable_Helper(WC_mapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WC map Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWC_mapVariableExp_referredVariable_VariableDeclaration(WC_mapVariableExp_referredVariable_VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWI_mapVariableExp_referredVariable(WI_mapVariableExp_referredVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable Helper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable Helper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWI_mapVariableExp_referredVariable_Helper(WI_mapVariableExp_referredVariable_Helper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WI map Variable Exp referred Variable Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWI_mapVariableExp_referredVariable_VariableDeclaration(WI_mapVariableExp_referredVariable_VariableDeclaration object) {
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
