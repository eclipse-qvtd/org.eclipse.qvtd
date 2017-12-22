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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trace_ATL2QVTrFactoryImpl extends EFactoryImpl implements trace_ATL2QVTrFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static trace_ATL2QVTrFactory init() {
		try {
			trace_ATL2QVTrFactory thetrace_ATL2QVTrFactory = (trace_ATL2QVTrFactory)EPackage.Registry.INSTANCE.getEFactory(trace_ATL2QVTrPackage.eNS_URI);
			if (thetrace_ATL2QVTrFactory != null) {
				return thetrace_ATL2QVTrFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new trace_ATL2QVTrFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public trace_ATL2QVTrFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case trace_ATL2QVTrPackage.TC_MAP_BINDING: return createTC_mapBinding();
			case trace_ATL2QVTrPackage.TC_MAP_BOOLEAN_EXP: return createTC_mapBooleanExp();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER: return createTC_mapHelper();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_ATTRIBUTE: return createTC_mapHelper_Attribute();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT: return createTC_mapHelper_Context();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_OPERATION: return createTC_mapHelper_Operation();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP: return createTC_mapIfExp();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN: return createTC_mapInPattern();
			case trace_ATL2QVTrPackage.TC_MAP_IN_PATTERN_FILTER: return createTC_mapInPattern_filter();
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP: return createTC_mapIntegerExp();
			case trace_ATL2QVTrPackage.TC_MAP_LOCATED_ELEMENT: return createTC_mapLocatedElement();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE: return createTC_mapMatchedRule();
			case trace_ATL2QVTrPackage.TC_MAP_MATCHED_RULE_SUPER: return createTC_mapMatchedRule_super();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE: return createTC_mapModule();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP: return createTC_mapNavigationOrAttributeCallExp();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER: return createTC_mapNavigationOrAttributeCallExp_Helper();
			case trace_ATL2QVTrPackage.TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY: return createTC_mapNavigationOrAttributeCallExp_Property();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_EXPRESSION: return createTC_mapOclExpression();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL: return createTC_mapOclMetamodel();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN: return createTC_mapOclModel_IN();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_OUT: return createTC_mapOclModel_OUT();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP: return createTC_mapOperationCallExp();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_HELPER: return createTC_mapOperationCallExp_Helper();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_OPERATION: return createTC_mapOperationCallExp_Operation();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT: return createTC_mapOperationCallExp_argument();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATOR_CALL_EXP: return createTC_mapOperatorCallExp();
			case trace_ATL2QVTrPackage.TC_MAP_OUT_PATTERN: return createTC_mapOutPattern();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_IN_PATTERN_ELEMENT: return createTC_mapSimpleInPatternElement();
			case trace_ATL2QVTrPackage.TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT: return createTC_mapSimpleOutPatternElement();
			case trace_ATL2QVTrPackage.TC_MAP_STRING_EXP: return createTC_mapStringExp();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE: return createTC_mapVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP: return createTC_mapVariableExp();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE: return createTC_mapVariableExp_referredVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: return createTC_mapVariableExp_referredVariable_Helper();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: return createTC_mapVariableExp_referredVariable_VariableDeclaration();
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE: return createWC_mapVariableExp_referredVariable();
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: return createWC_mapVariableExp_referredVariable_Helper();
			case trace_ATL2QVTrPackage.WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: return createWC_mapVariableExp_referredVariable_VariableDeclaration();
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: return createWI_mapVariableExp_referredVariable_Helper();
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: return createWI_mapVariableExp_referredVariable_VariableDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapBinding createTC_mapBinding() {
		TC_mapBindingImpl tC_mapBinding = new TC_mapBindingImpl();
		return tC_mapBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapBooleanExp createTC_mapBooleanExp() {
		TC_mapBooleanExpImpl tC_mapBooleanExp = new TC_mapBooleanExpImpl();
		return tC_mapBooleanExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapHelper createTC_mapHelper() {
		TC_mapHelperImpl tC_mapHelper = new TC_mapHelperImpl();
		return tC_mapHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapHelper_Attribute createTC_mapHelper_Attribute() {
		TC_mapHelper_AttributeImpl tC_mapHelper_Attribute = new TC_mapHelper_AttributeImpl();
		return tC_mapHelper_Attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapHelper_Context createTC_mapHelper_Context() {
		TC_mapHelper_ContextImpl tC_mapHelper_Context = new TC_mapHelper_ContextImpl();
		return tC_mapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapHelper_Operation createTC_mapHelper_Operation() {
		TC_mapHelper_OperationImpl tC_mapHelper_Operation = new TC_mapHelper_OperationImpl();
		return tC_mapHelper_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapIfExp createTC_mapIfExp() {
		TC_mapIfExpImpl tC_mapIfExp = new TC_mapIfExpImpl();
		return tC_mapIfExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapInPattern createTC_mapInPattern() {
		TC_mapInPatternImpl tC_mapInPattern = new TC_mapInPatternImpl();
		return tC_mapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapInPattern_filter createTC_mapInPattern_filter() {
		TC_mapInPattern_filterImpl tC_mapInPattern_filter = new TC_mapInPattern_filterImpl();
		return tC_mapInPattern_filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapIntegerExp createTC_mapIntegerExp() {
		TC_mapIntegerExpImpl tC_mapIntegerExp = new TC_mapIntegerExpImpl();
		return tC_mapIntegerExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapLocatedElement createTC_mapLocatedElement() {
		TC_mapLocatedElementImpl tC_mapLocatedElement = new TC_mapLocatedElementImpl();
		return tC_mapLocatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapMatchedRule createTC_mapMatchedRule() {
		TC_mapMatchedRuleImpl tC_mapMatchedRule = new TC_mapMatchedRuleImpl();
		return tC_mapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapMatchedRule_super createTC_mapMatchedRule_super() {
		TC_mapMatchedRule_superImpl tC_mapMatchedRule_super = new TC_mapMatchedRule_superImpl();
		return tC_mapMatchedRule_super;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapModule createTC_mapModule() {
		TC_mapModuleImpl tC_mapModule = new TC_mapModuleImpl();
		return tC_mapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapNavigationOrAttributeCallExp createTC_mapNavigationOrAttributeCallExp() {
		TC_mapNavigationOrAttributeCallExpImpl tC_mapNavigationOrAttributeCallExp = new TC_mapNavigationOrAttributeCallExpImpl();
		return tC_mapNavigationOrAttributeCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapNavigationOrAttributeCallExp_Helper createTC_mapNavigationOrAttributeCallExp_Helper() {
		TC_mapNavigationOrAttributeCallExp_HelperImpl tC_mapNavigationOrAttributeCallExp_Helper = new TC_mapNavigationOrAttributeCallExp_HelperImpl();
		return tC_mapNavigationOrAttributeCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapNavigationOrAttributeCallExp_Property createTC_mapNavigationOrAttributeCallExp_Property() {
		TC_mapNavigationOrAttributeCallExp_PropertyImpl tC_mapNavigationOrAttributeCallExp_Property = new TC_mapNavigationOrAttributeCallExp_PropertyImpl();
		return tC_mapNavigationOrAttributeCallExp_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOclExpression createTC_mapOclExpression() {
		TC_mapOclExpressionImpl tC_mapOclExpression = new TC_mapOclExpressionImpl();
		return tC_mapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOclMetamodel createTC_mapOclMetamodel() {
		TC_mapOclMetamodelImpl tC_mapOclMetamodel = new TC_mapOclMetamodelImpl();
		return tC_mapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOclModel_IN createTC_mapOclModel_IN() {
		TC_mapOclModel_INImpl tC_mapOclModel_IN = new TC_mapOclModel_INImpl();
		return tC_mapOclModel_IN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOclModel_OUT createTC_mapOclModel_OUT() {
		TC_mapOclModel_OUTImpl tC_mapOclModel_OUT = new TC_mapOclModel_OUTImpl();
		return tC_mapOclModel_OUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOperationCallExp createTC_mapOperationCallExp() {
		TC_mapOperationCallExpImpl tC_mapOperationCallExp = new TC_mapOperationCallExpImpl();
		return tC_mapOperationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOperationCallExp_Helper createTC_mapOperationCallExp_Helper() {
		TC_mapOperationCallExp_HelperImpl tC_mapOperationCallExp_Helper = new TC_mapOperationCallExp_HelperImpl();
		return tC_mapOperationCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOperationCallExp_Operation createTC_mapOperationCallExp_Operation() {
		TC_mapOperationCallExp_OperationImpl tC_mapOperationCallExp_Operation = new TC_mapOperationCallExp_OperationImpl();
		return tC_mapOperationCallExp_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOperationCallExp_argument createTC_mapOperationCallExp_argument() {
		TC_mapOperationCallExp_argumentImpl tC_mapOperationCallExp_argument = new TC_mapOperationCallExp_argumentImpl();
		return tC_mapOperationCallExp_argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOperatorCallExp createTC_mapOperatorCallExp() {
		TC_mapOperatorCallExpImpl tC_mapOperatorCallExp = new TC_mapOperatorCallExpImpl();
		return tC_mapOperatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapOutPattern createTC_mapOutPattern() {
		TC_mapOutPatternImpl tC_mapOutPattern = new TC_mapOutPatternImpl();
		return tC_mapOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapSimpleInPatternElement createTC_mapSimpleInPatternElement() {
		TC_mapSimpleInPatternElementImpl tC_mapSimpleInPatternElement = new TC_mapSimpleInPatternElementImpl();
		return tC_mapSimpleInPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapSimpleOutPatternElement createTC_mapSimpleOutPatternElement() {
		TC_mapSimpleOutPatternElementImpl tC_mapSimpleOutPatternElement = new TC_mapSimpleOutPatternElementImpl();
		return tC_mapSimpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapStringExp createTC_mapStringExp() {
		TC_mapStringExpImpl tC_mapStringExp = new TC_mapStringExpImpl();
		return tC_mapStringExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariable createTC_mapVariable() {
		TC_mapVariableImpl tC_mapVariable = new TC_mapVariableImpl();
		return tC_mapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariableExp createTC_mapVariableExp() {
		TC_mapVariableExpImpl tC_mapVariableExp = new TC_mapVariableExpImpl();
		return tC_mapVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariableExp_referredVariable createTC_mapVariableExp_referredVariable() {
		TC_mapVariableExp_referredVariableImpl tC_mapVariableExp_referredVariable = new TC_mapVariableExp_referredVariableImpl();
		return tC_mapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariableExp_referredVariable_Helper createTC_mapVariableExp_referredVariable_Helper() {
		TC_mapVariableExp_referredVariable_HelperImpl tC_mapVariableExp_referredVariable_Helper = new TC_mapVariableExp_referredVariable_HelperImpl();
		return tC_mapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TC_mapVariableExp_referredVariable_VariableDeclaration createTC_mapVariableExp_referredVariable_VariableDeclaration() {
		TC_mapVariableExp_referredVariable_VariableDeclarationImpl tC_mapVariableExp_referredVariable_VariableDeclaration = new TC_mapVariableExp_referredVariable_VariableDeclarationImpl();
		return tC_mapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WC_mapVariableExp_referredVariable createWC_mapVariableExp_referredVariable() {
		WC_mapVariableExp_referredVariableImpl wC_mapVariableExp_referredVariable = new WC_mapVariableExp_referredVariableImpl();
		return wC_mapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WC_mapVariableExp_referredVariable_Helper createWC_mapVariableExp_referredVariable_Helper() {
		WC_mapVariableExp_referredVariable_HelperImpl wC_mapVariableExp_referredVariable_Helper = new WC_mapVariableExp_referredVariable_HelperImpl();
		return wC_mapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WC_mapVariableExp_referredVariable_VariableDeclaration createWC_mapVariableExp_referredVariable_VariableDeclaration() {
		WC_mapVariableExp_referredVariable_VariableDeclarationImpl wC_mapVariableExp_referredVariable_VariableDeclaration = new WC_mapVariableExp_referredVariable_VariableDeclarationImpl();
		return wC_mapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WI_mapVariableExp_referredVariable_Helper createWI_mapVariableExp_referredVariable_Helper() {
		WI_mapVariableExp_referredVariable_HelperImpl wI_mapVariableExp_referredVariable_Helper = new WI_mapVariableExp_referredVariable_HelperImpl();
		return wI_mapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WI_mapVariableExp_referredVariable_VariableDeclaration createWI_mapVariableExp_referredVariable_VariableDeclaration() {
		WI_mapVariableExp_referredVariable_VariableDeclarationImpl wI_mapVariableExp_referredVariable_VariableDeclaration = new WI_mapVariableExp_referredVariable_VariableDeclarationImpl();
		return wI_mapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public trace_ATL2QVTrPackage gettrace_ATL2QVTrPackage() {
		return (trace_ATL2QVTrPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static trace_ATL2QVTrPackage getPackage() {
		return trace_ATL2QVTrPackage.eINSTANCE;
	}

} //trace_ATL2QVTrFactoryImpl
