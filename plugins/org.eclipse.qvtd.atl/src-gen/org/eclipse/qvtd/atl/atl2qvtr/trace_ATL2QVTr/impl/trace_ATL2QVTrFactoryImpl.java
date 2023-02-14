/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
			case 0: return createCmapVariableExp_referredVariable_Helper();
			case 1: return createCmapVariableExp_referredVariable_VariableDeclaration();
			case 2: return createDmapHelper();
			case 3: return createDmapOclExpression();
			case 4: return createDmapVariableExp_referredVariable();
			case 8: return createTmapBinding();
			case 9: return createTmapBooleanExp();
			case 10: return createTmapHelper_Attribute();
			case 11: return createTmapHelper_Context();
			case 12: return createTmapHelper_Operation();
			case 13: return createTmapIfExp();
			case 14: return createTmapInPattern();
			case 15: return createTmapInPattern_filter();
			case 16: return createTmapIntegerExp();
			case 17: return createTmapMatchedRule();
			case 18: return createTmapMatchedRule_super();
			case 19: return createTmapModule();
			case 20: return createTmapNavigationOrAttributeCallExp_Helper();
			case 21: return createTmapNavigationOrAttributeCallExp_Property();
			case 22: return createTmapOclMetamodel();
			case 23: return createTmapOclModel_IN();
			case 24: return createTmapOclModel_OUT();
			case 25: return createTmapOclType();
			case 26: return createTmapOperationCallExp_Helper();
			case 27: return createTmapOperationCallExp_Operation();
			case 28: return createTmapOperationCallExp_argument();
			case 29: return createTmapOperatorCallExp();
			case 30: return createTmapSimpleInPatternElement();
			case 31: return createTmapSimpleOutPatternElement();
			case 32: return createTmapStringExp();
			case 33: return createTmapVariable();
			case 34: return createTmapVariableExp();
			case 35: return createTmapVariableExp_referredVariable_Helper();
			case 36: return createTmapVariableExp_referredVariable_VariableDeclaration();
			case 37: return createTxATL2QVTr();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CmapVariableExp_referredVariable_Helper createCmapVariableExp_referredVariable_Helper() {
		CmapVariableExp_referredVariable_HelperImpl cmapVariableExp_referredVariable_Helper = new CmapVariableExp_referredVariable_HelperImpl();
		return cmapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CmapVariableExp_referredVariable_VariableDeclaration createCmapVariableExp_referredVariable_VariableDeclaration() {
		CmapVariableExp_referredVariable_VariableDeclarationImpl cmapVariableExp_referredVariable_VariableDeclaration = new CmapVariableExp_referredVariable_VariableDeclarationImpl();
		return cmapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapHelper createDmapHelper() {
		DmapHelperImpl dmapHelper = new DmapHelperImpl();
		return dmapHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression createDmapOclExpression() {
		DmapOclExpressionImpl dmapOclExpression = new DmapOclExpressionImpl();
		return dmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapVariableExp_referredVariable createDmapVariableExp_referredVariable() {
		DmapVariableExp_referredVariableImpl dmapVariableExp_referredVariable = new DmapVariableExp_referredVariableImpl();
		return dmapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapBinding createTmapBinding() {
		TmapBindingImpl tmapBinding = new TmapBindingImpl();
		return tmapBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapBooleanExp createTmapBooleanExp() {
		TmapBooleanExpImpl tmapBooleanExp = new TmapBooleanExpImpl();
		return tmapBooleanExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Attribute createTmapHelper_Attribute() {
		TmapHelper_AttributeImpl tmapHelper_Attribute = new TmapHelper_AttributeImpl();
		return tmapHelper_Attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Context createTmapHelper_Context() {
		TmapHelper_ContextImpl tmapHelper_Context = new TmapHelper_ContextImpl();
		return tmapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Operation createTmapHelper_Operation() {
		TmapHelper_OperationImpl tmapHelper_Operation = new TmapHelper_OperationImpl();
		return tmapHelper_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapIfExp createTmapIfExp() {
		TmapIfExpImpl tmapIfExp = new TmapIfExpImpl();
		return tmapIfExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapInPattern createTmapInPattern() {
		TmapInPatternImpl tmapInPattern = new TmapInPatternImpl();
		return tmapInPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapInPattern_filter createTmapInPattern_filter() {
		TmapInPattern_filterImpl tmapInPattern_filter = new TmapInPattern_filterImpl();
		return tmapInPattern_filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapIntegerExp createTmapIntegerExp() {
		TmapIntegerExpImpl tmapIntegerExp = new TmapIntegerExpImpl();
		return tmapIntegerExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapMatchedRule createTmapMatchedRule() {
		TmapMatchedRuleImpl tmapMatchedRule = new TmapMatchedRuleImpl();
		return tmapMatchedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapMatchedRule_super createTmapMatchedRule_super() {
		TmapMatchedRule_superImpl tmapMatchedRule_super = new TmapMatchedRule_superImpl();
		return tmapMatchedRule_super;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapModule createTmapModule() {
		TmapModuleImpl tmapModule = new TmapModuleImpl();
		return tmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapNavigationOrAttributeCallExp_Helper createTmapNavigationOrAttributeCallExp_Helper() {
		TmapNavigationOrAttributeCallExp_HelperImpl tmapNavigationOrAttributeCallExp_Helper = new TmapNavigationOrAttributeCallExp_HelperImpl();
		return tmapNavigationOrAttributeCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapNavigationOrAttributeCallExp_Property createTmapNavigationOrAttributeCallExp_Property() {
		TmapNavigationOrAttributeCallExp_PropertyImpl tmapNavigationOrAttributeCallExp_Property = new TmapNavigationOrAttributeCallExp_PropertyImpl();
		return tmapNavigationOrAttributeCallExp_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclMetamodel createTmapOclMetamodel() {
		TmapOclMetamodelImpl tmapOclMetamodel = new TmapOclMetamodelImpl();
		return tmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclModel_IN createTmapOclModel_IN() {
		TmapOclModel_INImpl tmapOclModel_IN = new TmapOclModel_INImpl();
		return tmapOclModel_IN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclModel_OUT createTmapOclModel_OUT() {
		TmapOclModel_OUTImpl tmapOclModel_OUT = new TmapOclModel_OUTImpl();
		return tmapOclModel_OUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclType createTmapOclType() {
		TmapOclTypeImpl tmapOclType = new TmapOclTypeImpl();
		return tmapOclType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperationCallExp_Helper createTmapOperationCallExp_Helper() {
		TmapOperationCallExp_HelperImpl tmapOperationCallExp_Helper = new TmapOperationCallExp_HelperImpl();
		return tmapOperationCallExp_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperationCallExp_Operation createTmapOperationCallExp_Operation() {
		TmapOperationCallExp_OperationImpl tmapOperationCallExp_Operation = new TmapOperationCallExp_OperationImpl();
		return tmapOperationCallExp_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperationCallExp_argument createTmapOperationCallExp_argument() {
		TmapOperationCallExp_argumentImpl tmapOperationCallExp_argument = new TmapOperationCallExp_argumentImpl();
		return tmapOperationCallExp_argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOperatorCallExp createTmapOperatorCallExp() {
		TmapOperatorCallExpImpl tmapOperatorCallExp = new TmapOperatorCallExpImpl();
		return tmapOperatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapSimpleInPatternElement createTmapSimpleInPatternElement() {
		TmapSimpleInPatternElementImpl tmapSimpleInPatternElement = new TmapSimpleInPatternElementImpl();
		return tmapSimpleInPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapSimpleOutPatternElement createTmapSimpleOutPatternElement() {
		TmapSimpleOutPatternElementImpl tmapSimpleOutPatternElement = new TmapSimpleOutPatternElementImpl();
		return tmapSimpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapStringExp createTmapStringExp() {
		TmapStringExpImpl tmapStringExp = new TmapStringExpImpl();
		return tmapStringExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariable createTmapVariable() {
		TmapVariableImpl tmapVariable = new TmapVariableImpl();
		return tmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp createTmapVariableExp() {
		TmapVariableExpImpl tmapVariableExp = new TmapVariableExpImpl();
		return tmapVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp_referredVariable_Helper createTmapVariableExp_referredVariable_Helper() {
		TmapVariableExp_referredVariable_HelperImpl tmapVariableExp_referredVariable_Helper = new TmapVariableExp_referredVariable_HelperImpl();
		return tmapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp_referredVariable_VariableDeclaration createTmapVariableExp_referredVariable_VariableDeclaration() {
		TmapVariableExp_referredVariable_VariableDeclarationImpl tmapVariableExp_referredVariable_VariableDeclaration = new TmapVariableExp_referredVariable_VariableDeclarationImpl();
		return tmapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxATL2QVTr createTxATL2QVTr() {
		TxATL2QVTrImpl txATL2QVTr = new TxATL2QVTrImpl();
		return txATL2QVTr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
