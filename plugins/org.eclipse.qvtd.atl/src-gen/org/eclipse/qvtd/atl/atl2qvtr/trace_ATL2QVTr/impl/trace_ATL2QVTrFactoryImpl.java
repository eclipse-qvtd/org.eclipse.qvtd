/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
			case trace_ATL2QVTrPackage.CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: return createCmapVariableExp_referredVariable_Helper();
			case trace_ATL2QVTrPackage.CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: return createCmapVariableExp_referredVariable_VariableDeclaration();
			case trace_ATL2QVTrPackage.DMAP_HELPER: return createDmapHelper();
			case trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION: return createDmapOclExpression();
			case trace_ATL2QVTrPackage.DMAP_VARIABLE_EXP_REFERRED_VARIABLE: return createDmapVariableExp_referredVariable();
			case trace_ATL2QVTrPackage.TMAP_BINDING: return createTmapBinding();
			case trace_ATL2QVTrPackage.TMAP_BOOLEAN_EXP: return createTmapBooleanExp();
			case trace_ATL2QVTrPackage.TMAP_HELPER_ATTRIBUTE: return createTmapHelper_Attribute();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT: return createTmapHelper_Context();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION: return createTmapHelper_Operation();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP: return createTmapIfExp();
			case trace_ATL2QVTrPackage.TMAP_IN_PATTERN: return createTmapInPattern();
			case trace_ATL2QVTrPackage.TMAP_IN_PATTERN_FILTER: return createTmapInPattern_filter();
			case trace_ATL2QVTrPackage.TMAP_INTEGER_EXP: return createTmapIntegerExp();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE: return createTmapMatchedRule();
			case trace_ATL2QVTrPackage.TMAP_MATCHED_RULE_SUPER: return createTmapMatchedRule_super();
			case trace_ATL2QVTrPackage.TMAP_MODULE: return createTmapModule();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER: return createTmapNavigationOrAttributeCallExp_Helper();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY: return createTmapNavigationOrAttributeCallExp_Property();
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL: return createTmapOclMetamodel();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN: return createTmapOclModel_IN();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_OUT: return createTmapOclModel_OUT();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER: return createTmapOperationCallExp_Helper();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION: return createTmapOperationCallExp_Operation();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_ARGUMENT: return createTmapOperationCallExp_argument();
			case trace_ATL2QVTrPackage.TMAP_OPERATOR_CALL_EXP: return createTmapOperatorCallExp();
			case trace_ATL2QVTrPackage.TMAP_OUT_PATTERN: return createTmapOutPattern();
			case trace_ATL2QVTrPackage.TMAP_SIMPLE_IN_PATTERN_ELEMENT: return createTmapSimpleInPatternElement();
			case trace_ATL2QVTrPackage.TMAP_SIMPLE_OUT_PATTERN_ELEMENT: return createTmapSimpleOutPatternElement();
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP: return createTmapStringExp();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE: return createTmapVariable();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP: return createTmapVariableExp();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER: return createTmapVariableExp_referredVariable_Helper();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION: return createTmapVariableExp_referredVariable_VariableDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmapVariableExp_referredVariable_Helper createCmapVariableExp_referredVariable_Helper() {
		CmapVariableExp_referredVariable_HelperImpl cmapVariableExp_referredVariable_Helper = new CmapVariableExp_referredVariable_HelperImpl();
		return cmapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CmapVariableExp_referredVariable_VariableDeclaration createCmapVariableExp_referredVariable_VariableDeclaration() {
		CmapVariableExp_referredVariable_VariableDeclarationImpl cmapVariableExp_referredVariable_VariableDeclaration = new CmapVariableExp_referredVariable_VariableDeclarationImpl();
		return cmapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapHelper createDmapHelper() {
		DmapHelperImpl dmapHelper = new DmapHelperImpl();
		return dmapHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression createDmapOclExpression() {
		DmapOclExpressionImpl dmapOclExpression = new DmapOclExpressionImpl();
		return dmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapVariableExp_referredVariable createDmapVariableExp_referredVariable() {
		DmapVariableExp_referredVariableImpl dmapVariableExp_referredVariable = new DmapVariableExp_referredVariableImpl();
		return dmapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapBinding createTmapBinding() {
		TmapBindingImpl tmapBinding = new TmapBindingImpl();
		return tmapBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapBooleanExp createTmapBooleanExp() {
		TmapBooleanExpImpl tmapBooleanExp = new TmapBooleanExpImpl();
		return tmapBooleanExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapHelper_Attribute createTmapHelper_Attribute() {
		TmapHelper_AttributeImpl tmapHelper_Attribute = new TmapHelper_AttributeImpl();
		return tmapHelper_Attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapHelper_Context createTmapHelper_Context() {
		TmapHelper_ContextImpl tmapHelper_Context = new TmapHelper_ContextImpl();
		return tmapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapHelper_Operation createTmapHelper_Operation() {
		TmapHelper_OperationImpl tmapHelper_Operation = new TmapHelper_OperationImpl();
		return tmapHelper_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapIfExp createTmapIfExp() {
		TmapIfExpImpl tmapIfExp = new TmapIfExpImpl();
		return tmapIfExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapInPattern createTmapInPattern() {
		TmapInPatternImpl tmapInPattern = new TmapInPatternImpl();
		return tmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapInPattern_filter createTmapInPattern_filter() {
		TmapInPattern_filterImpl tmapInPattern_filter = new TmapInPattern_filterImpl();
		return tmapInPattern_filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapIntegerExp createTmapIntegerExp() {
		TmapIntegerExpImpl tmapIntegerExp = new TmapIntegerExpImpl();
		return tmapIntegerExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapMatchedRule createTmapMatchedRule() {
		TmapMatchedRuleImpl tmapMatchedRule = new TmapMatchedRuleImpl();
		return tmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapMatchedRule_super createTmapMatchedRule_super() {
		TmapMatchedRule_superImpl tmapMatchedRule_super = new TmapMatchedRule_superImpl();
		return tmapMatchedRule_super;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapModule createTmapModule() {
		TmapModuleImpl tmapModule = new TmapModuleImpl();
		return tmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapNavigationOrAttributeCallExp_Helper createTmapNavigationOrAttributeCallExp_Helper() {
		TmapNavigationOrAttributeCallExp_HelperImpl tmapNavigationOrAttributeCallExp_Helper = new TmapNavigationOrAttributeCallExp_HelperImpl();
		return tmapNavigationOrAttributeCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapNavigationOrAttributeCallExp_Property createTmapNavigationOrAttributeCallExp_Property() {
		TmapNavigationOrAttributeCallExp_PropertyImpl tmapNavigationOrAttributeCallExp_Property = new TmapNavigationOrAttributeCallExp_PropertyImpl();
		return tmapNavigationOrAttributeCallExp_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOclMetamodel createTmapOclMetamodel() {
		TmapOclMetamodelImpl tmapOclMetamodel = new TmapOclMetamodelImpl();
		return tmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOclModel_IN createTmapOclModel_IN() {
		TmapOclModel_INImpl tmapOclModel_IN = new TmapOclModel_INImpl();
		return tmapOclModel_IN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOclModel_OUT createTmapOclModel_OUT() {
		TmapOclModel_OUTImpl tmapOclModel_OUT = new TmapOclModel_OUTImpl();
		return tmapOclModel_OUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOperationCallExp_Helper createTmapOperationCallExp_Helper() {
		TmapOperationCallExp_HelperImpl tmapOperationCallExp_Helper = new TmapOperationCallExp_HelperImpl();
		return tmapOperationCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOperationCallExp_Operation createTmapOperationCallExp_Operation() {
		TmapOperationCallExp_OperationImpl tmapOperationCallExp_Operation = new TmapOperationCallExp_OperationImpl();
		return tmapOperationCallExp_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOperationCallExp_argument createTmapOperationCallExp_argument() {
		TmapOperationCallExp_argumentImpl tmapOperationCallExp_argument = new TmapOperationCallExp_argumentImpl();
		return tmapOperationCallExp_argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOperatorCallExp createTmapOperatorCallExp() {
		TmapOperatorCallExpImpl tmapOperatorCallExp = new TmapOperatorCallExpImpl();
		return tmapOperatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOutPattern createTmapOutPattern() {
		TmapOutPatternImpl tmapOutPattern = new TmapOutPatternImpl();
		return tmapOutPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapSimpleInPatternElement createTmapSimpleInPatternElement() {
		TmapSimpleInPatternElementImpl tmapSimpleInPatternElement = new TmapSimpleInPatternElementImpl();
		return tmapSimpleInPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapSimpleOutPatternElement createTmapSimpleOutPatternElement() {
		TmapSimpleOutPatternElementImpl tmapSimpleOutPatternElement = new TmapSimpleOutPatternElementImpl();
		return tmapSimpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapStringExp createTmapStringExp() {
		TmapStringExpImpl tmapStringExp = new TmapStringExpImpl();
		return tmapStringExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariable createTmapVariable() {
		TmapVariableImpl tmapVariable = new TmapVariableImpl();
		return tmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariableExp createTmapVariableExp() {
		TmapVariableExpImpl tmapVariableExp = new TmapVariableExpImpl();
		return tmapVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariableExp_referredVariable_Helper createTmapVariableExp_referredVariable_Helper() {
		TmapVariableExp_referredVariable_HelperImpl tmapVariableExp_referredVariable_Helper = new TmapVariableExp_referredVariable_HelperImpl();
		return tmapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariableExp_referredVariable_VariableDeclaration createTmapVariableExp_referredVariable_VariableDeclaration() {
		TmapVariableExp_referredVariable_VariableDeclarationImpl tmapVariableExp_referredVariable_VariableDeclaration = new TmapVariableExp_referredVariable_VariableDeclarationImpl();
		return tmapVariableExp_referredVariable_VariableDeclaration;
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
