/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage
 * @generated
 */
public class trace_ATL2QVTrAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static trace_ATL2QVTrPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public trace_ATL2QVTrAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = trace_ATL2QVTrPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected trace_ATL2QVTrSwitch<@Nullable Adapter> modelSwitch =
		new trace_ATL2QVTrSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseTC_mapBinding(TC_mapBinding object) {
				return createTC_mapBindingAdapter();
			}
			@Override
			public Adapter caseTC_mapBooleanExp(TC_mapBooleanExp object) {
				return createTC_mapBooleanExpAdapter();
			}
			@Override
			public Adapter caseTC_mapHelper(TC_mapHelper object) {
				return createTC_mapHelperAdapter();
			}
			@Override
			public Adapter caseTC_mapHelper_Attribute(TC_mapHelper_Attribute object) {
				return createTC_mapHelper_AttributeAdapter();
			}
			@Override
			public Adapter caseTC_mapHelper_Context(TC_mapHelper_Context object) {
				return createTC_mapHelper_ContextAdapter();
			}
			@Override
			public Adapter caseTC_mapHelper_Operation(TC_mapHelper_Operation object) {
				return createTC_mapHelper_OperationAdapter();
			}
			@Override
			public Adapter caseTC_mapIfExp(TC_mapIfExp object) {
				return createTC_mapIfExpAdapter();
			}
			@Override
			public Adapter caseTC_mapInPattern(TC_mapInPattern object) {
				return createTC_mapInPatternAdapter();
			}
			@Override
			public Adapter caseTC_mapInPattern_filter(TC_mapInPattern_filter object) {
				return createTC_mapInPattern_filterAdapter();
			}
			@Override
			public Adapter caseTC_mapIntegerExp(TC_mapIntegerExp object) {
				return createTC_mapIntegerExpAdapter();
			}
			@Override
			public Adapter caseTC_mapMatchedRule(TC_mapMatchedRule object) {
				return createTC_mapMatchedRuleAdapter();
			}
			@Override
			public Adapter caseTC_mapMatchedRule_super(TC_mapMatchedRule_super object) {
				return createTC_mapMatchedRule_superAdapter();
			}
			@Override
			public Adapter caseTC_mapModule(TC_mapModule object) {
				return createTC_mapModuleAdapter();
			}
			@Override
			public Adapter caseTC_mapNavigationOrAttributeCallExp(TC_mapNavigationOrAttributeCallExp object) {
				return createTC_mapNavigationOrAttributeCallExpAdapter();
			}
			@Override
			public Adapter caseTC_mapNavigationOrAttributeCallExp_Helper(TC_mapNavigationOrAttributeCallExp_Helper object) {
				return createTC_mapNavigationOrAttributeCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTC_mapNavigationOrAttributeCallExp_Property(TC_mapNavigationOrAttributeCallExp_Property object) {
				return createTC_mapNavigationOrAttributeCallExp_PropertyAdapter();
			}
			@Override
			public Adapter caseTC_mapOclExpression(TC_mapOclExpression object) {
				return createTC_mapOclExpressionAdapter();
			}
			@Override
			public Adapter caseTC_mapOclMetamodel(TC_mapOclMetamodel object) {
				return createTC_mapOclMetamodelAdapter();
			}
			@Override
			public Adapter caseTC_mapOclModel_IN(TC_mapOclModel_IN object) {
				return createTC_mapOclModel_INAdapter();
			}
			@Override
			public Adapter caseTC_mapOclModel_OUT(TC_mapOclModel_OUT object) {
				return createTC_mapOclModel_OUTAdapter();
			}
			@Override
			public Adapter caseTC_mapOperationCallExp(TC_mapOperationCallExp object) {
				return createTC_mapOperationCallExpAdapter();
			}
			@Override
			public Adapter caseTC_mapOperationCallExp_Helper(TC_mapOperationCallExp_Helper object) {
				return createTC_mapOperationCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTC_mapOperationCallExp_Operation(TC_mapOperationCallExp_Operation object) {
				return createTC_mapOperationCallExp_OperationAdapter();
			}
			@Override
			public Adapter caseTC_mapOperationCallExp_argument(TC_mapOperationCallExp_argument object) {
				return createTC_mapOperationCallExp_argumentAdapter();
			}
			@Override
			public Adapter caseTC_mapOperatorCallExp(TC_mapOperatorCallExp object) {
				return createTC_mapOperatorCallExpAdapter();
			}
			@Override
			public Adapter caseTC_mapOutPattern(TC_mapOutPattern object) {
				return createTC_mapOutPatternAdapter();
			}
			@Override
			public Adapter caseTC_mapSimpleInPatternElement(TC_mapSimpleInPatternElement object) {
				return createTC_mapSimpleInPatternElementAdapter();
			}
			@Override
			public Adapter caseTC_mapSimpleOutPatternElement(TC_mapSimpleOutPatternElement object) {
				return createTC_mapSimpleOutPatternElementAdapter();
			}
			@Override
			public Adapter caseTC_mapStringExp(TC_mapStringExp object) {
				return createTC_mapStringExpAdapter();
			}
			@Override
			public Adapter caseTC_mapVariable(TC_mapVariable object) {
				return createTC_mapVariableAdapter();
			}
			@Override
			public Adapter caseTC_mapVariableExp(TC_mapVariableExp object) {
				return createTC_mapVariableExpAdapter();
			}
			@Override
			public Adapter caseTC_mapVariableExp_referredVariable(TC_mapVariableExp_referredVariable object) {
				return createTC_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseTC_mapVariableExp_referredVariable_Helper(TC_mapVariableExp_referredVariable_Helper object) {
				return createTC_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseTC_mapVariableExp_referredVariable_VariableDeclaration(TC_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createTC_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter caseTI_mapBooleanExp(TI_mapBooleanExp object) {
				return createTI_mapBooleanExpAdapter();
			}
			@Override
			public Adapter caseTI_mapHelper(TI_mapHelper object) {
				return createTI_mapHelperAdapter();
			}
			@Override
			public Adapter caseTI_mapHelper_Attribute(TI_mapHelper_Attribute object) {
				return createTI_mapHelper_AttributeAdapter();
			}
			@Override
			public Adapter caseTI_mapHelper_Operation(TI_mapHelper_Operation object) {
				return createTI_mapHelper_OperationAdapter();
			}
			@Override
			public Adapter caseTI_mapIfExp(TI_mapIfExp object) {
				return createTI_mapIfExpAdapter();
			}
			@Override
			public Adapter caseTI_mapIntegerExp(TI_mapIntegerExp object) {
				return createTI_mapIntegerExpAdapter();
			}
			@Override
			public Adapter caseTI_mapNavigationOrAttributeCallExp(TI_mapNavigationOrAttributeCallExp object) {
				return createTI_mapNavigationOrAttributeCallExpAdapter();
			}
			@Override
			public Adapter caseTI_mapNavigationOrAttributeCallExp_Helper(TI_mapNavigationOrAttributeCallExp_Helper object) {
				return createTI_mapNavigationOrAttributeCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTI_mapNavigationOrAttributeCallExp_Property(TI_mapNavigationOrAttributeCallExp_Property object) {
				return createTI_mapNavigationOrAttributeCallExp_PropertyAdapter();
			}
			@Override
			public Adapter caseTI_mapOclExpression(TI_mapOclExpression object) {
				return createTI_mapOclExpressionAdapter();
			}
			@Override
			public Adapter caseTI_mapOperationCallExp(TI_mapOperationCallExp object) {
				return createTI_mapOperationCallExpAdapter();
			}
			@Override
			public Adapter caseTI_mapOperationCallExp_Helper(TI_mapOperationCallExp_Helper object) {
				return createTI_mapOperationCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTI_mapOperationCallExp_Operation(TI_mapOperationCallExp_Operation object) {
				return createTI_mapOperationCallExp_OperationAdapter();
			}
			@Override
			public Adapter caseTI_mapOperatorCallExp(TI_mapOperatorCallExp object) {
				return createTI_mapOperatorCallExpAdapter();
			}
			@Override
			public Adapter caseTI_mapStringExp(TI_mapStringExp object) {
				return createTI_mapStringExpAdapter();
			}
			@Override
			public Adapter caseTI_mapVariableExp(TI_mapVariableExp object) {
				return createTI_mapVariableExpAdapter();
			}
			@Override
			public Adapter caseTI_mapVariableExp_referredVariable(TI_mapVariableExp_referredVariable object) {
				return createTI_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseTI_mapVariableExp_referredVariable_Helper(TI_mapVariableExp_referredVariable_Helper object) {
				return createTI_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseTI_mapVariableExp_referredVariable_VariableDeclaration(TI_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createTI_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter caseWC_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable object) {
				return createWC_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseWC_mapVariableExp_referredVariable_Helper(WC_mapVariableExp_referredVariable_Helper object) {
				return createWC_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseWC_mapVariableExp_referredVariable_VariableDeclaration(WC_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createWC_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter caseWI_mapVariableExp_referredVariable(WI_mapVariableExp_referredVariable object) {
				return createWI_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseWI_mapVariableExp_referredVariable_Helper(WI_mapVariableExp_referredVariable_Helper object) {
				return createWI_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseWI_mapVariableExp_referredVariable_VariableDeclaration(WI_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createWI_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapOclExpression(TI_mapOclExpression object) {
				return createtrace_ATL2QVTr_TI_mapOclExpressionAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapBooleanExp(TI_mapBooleanExp object) {
				return createtrace_ATL2QVTr_TI_mapBooleanExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapHelper(TI_mapHelper object) {
				return createtrace_ATL2QVTr_TI_mapHelperAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapHelper_Attribute(TI_mapHelper_Attribute object) {
				return createtrace_ATL2QVTr_TI_mapHelper_AttributeAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapHelper_Operation(TI_mapHelper_Operation object) {
				return createtrace_ATL2QVTr_TI_mapHelper_OperationAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapIfExp(TI_mapIfExp object) {
				return createtrace_ATL2QVTr_TI_mapIfExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapIntegerExp(TI_mapIntegerExp object) {
				return createtrace_ATL2QVTr_TI_mapIntegerExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp(TI_mapNavigationOrAttributeCallExp object) {
				return createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_Helper(TI_mapNavigationOrAttributeCallExp_Helper object) {
				return createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_HelperAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_Property(TI_mapNavigationOrAttributeCallExp_Property object) {
				return createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_PropertyAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapOperationCallExp(TI_mapOperationCallExp object) {
				return createtrace_ATL2QVTr_TI_mapOperationCallExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapOperationCallExp_Helper(TI_mapOperationCallExp_Helper object) {
				return createtrace_ATL2QVTr_TI_mapOperationCallExp_HelperAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapOperationCallExp_Operation(TI_mapOperationCallExp_Operation object) {
				return createtrace_ATL2QVTr_TI_mapOperationCallExp_OperationAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapOperatorCallExp(TI_mapOperatorCallExp object) {
				return createtrace_ATL2QVTr_TI_mapOperatorCallExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapStringExp(TI_mapStringExp object) {
				return createtrace_ATL2QVTr_TI_mapStringExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapVariableExp(TI_mapVariableExp object) {
				return createtrace_ATL2QVTr_TI_mapVariableExpAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapVariableExp_referredVariable(TI_mapVariableExp_referredVariable object) {
				return createtrace_ATL2QVTr_TI_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapVariableExp_referredVariable_Helper(TI_mapVariableExp_referredVariable_Helper object) {
				return createtrace_ATL2QVTr_TI_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_TI_mapVariableExp_referredVariable_VariableDeclaration(TI_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createtrace_ATL2QVTr_TI_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_WI_mapVariableExp_referredVariable(WI_mapVariableExp_referredVariable object) {
				return createtrace_ATL2QVTr_WI_mapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_WI_mapVariableExp_referredVariable_Helper(WI_mapVariableExp_referredVariable_Helper object) {
				return createtrace_ATL2QVTr_WI_mapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter casetrace_ATL2QVTr_WI_mapVariableExp_referredVariable_VariableDeclaration(WI_mapVariableExp_referredVariable_VariableDeclaration object) {
				return createtrace_ATL2QVTr_WI_mapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBinding <em>TC map Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBinding
	 * @generated
	 */
	public Adapter createTC_mapBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBooleanExp <em>TC map Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBooleanExp
	 * @generated
	 */
	public Adapter createTC_mapBooleanExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper <em>TC map Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper
	 * @generated
	 */
	public Adapter createTC_mapHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute <em>TC map Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute
	 * @generated
	 */
	public Adapter createTC_mapHelper_AttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context <em>TC map Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context
	 * @generated
	 */
	public Adapter createTC_mapHelper_ContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Operation <em>TC map Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Operation
	 * @generated
	 */
	public Adapter createTC_mapHelper_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIfExp <em>TC map If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIfExp
	 * @generated
	 */
	public Adapter createTC_mapIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern <em>TC map In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern
	 * @generated
	 */
	public Adapter createTC_mapInPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern_filter <em>TC map In Pattern filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern_filter
	 * @generated
	 */
	public Adapter createTC_mapInPattern_filterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp <em>TC map Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp
	 * @generated
	 */
	public Adapter createTC_mapIntegerExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule <em>TC map Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule
	 * @generated
	 */
	public Adapter createTC_mapMatchedRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule_super <em>TC map Matched Rule super</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule_super
	 * @generated
	 */
	public Adapter createTC_mapMatchedRule_superAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapModule <em>TC map Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapModule
	 * @generated
	 */
	public Adapter createTC_mapModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp <em>TC map Navigation Or Attribute Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp
	 * @generated
	 */
	public Adapter createTC_mapNavigationOrAttributeCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper <em>TC map Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	public Adapter createTC_mapNavigationOrAttributeCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Property <em>TC map Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	public Adapter createTC_mapNavigationOrAttributeCallExp_PropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclExpression <em>TC map Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclExpression
	 * @generated
	 */
	public Adapter createTC_mapOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclMetamodel <em>TC map Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclMetamodel
	 * @generated
	 */
	public Adapter createTC_mapOclMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_IN <em>TC map Ocl Model IN</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_IN
	 * @generated
	 */
	public Adapter createTC_mapOclModel_INAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_OUT <em>TC map Ocl Model OUT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_OUT
	 * @generated
	 */
	public Adapter createTC_mapOclModel_OUTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp <em>TC map Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp
	 * @generated
	 */
	public Adapter createTC_mapOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Helper <em>TC map Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Helper
	 * @generated
	 */
	public Adapter createTC_mapOperationCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Operation <em>TC map Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Operation
	 * @generated
	 */
	public Adapter createTC_mapOperationCallExp_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_argument <em>TC map Operation Call Exp argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_argument
	 * @generated
	 */
	public Adapter createTC_mapOperationCallExp_argumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperatorCallExp <em>TC map Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperatorCallExp
	 * @generated
	 */
	public Adapter createTC_mapOperatorCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern <em>TC map Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern
	 * @generated
	 */
	public Adapter createTC_mapOutPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement <em>TC map Simple In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement
	 * @generated
	 */
	public Adapter createTC_mapSimpleInPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleOutPatternElement <em>TC map Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleOutPatternElement
	 * @generated
	 */
	public Adapter createTC_mapSimpleOutPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapStringExp <em>TC map String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapStringExp
	 * @generated
	 */
	public Adapter createTC_mapStringExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable <em>TC map Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable
	 * @generated
	 */
	public Adapter createTC_mapVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp <em>TC map Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp
	 * @generated
	 */
	public Adapter createTC_mapVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable <em>TC map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createTC_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_Helper <em>TC map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createTC_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration <em>TC map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createTC_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapBooleanExp <em>TI map Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapBooleanExp
	 * @generated
	 */
	public Adapter createTI_mapBooleanExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper <em>TI map Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper
	 * @generated
	 */
	public Adapter createTI_mapHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute <em>TI map Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute
	 * @generated
	 */
	public Adapter createTI_mapHelper_AttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation <em>TI map Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation
	 * @generated
	 */
	public Adapter createTI_mapHelper_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIfExp <em>TI map If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIfExp
	 * @generated
	 */
	public Adapter createTI_mapIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIntegerExp <em>TI map Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIntegerExp
	 * @generated
	 */
	public Adapter createTI_mapIntegerExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp <em>TI map Navigation Or Attribute Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp
	 * @generated
	 */
	public Adapter createTI_mapNavigationOrAttributeCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Helper <em>TI map Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	public Adapter createTI_mapNavigationOrAttributeCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Property <em>TI map Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	public Adapter createTI_mapNavigationOrAttributeCallExp_PropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression <em>TI map Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression
	 * @generated
	 */
	public Adapter createTI_mapOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp <em>TI map Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp
	 * @generated
	 */
	public Adapter createTI_mapOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Helper <em>TI map Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Helper
	 * @generated
	 */
	public Adapter createTI_mapOperationCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Operation <em>TI map Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Operation
	 * @generated
	 */
	public Adapter createTI_mapOperationCallExp_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperatorCallExp <em>TI map Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperatorCallExp
	 * @generated
	 */
	public Adapter createTI_mapOperatorCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapStringExp <em>TI map String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapStringExp
	 * @generated
	 */
	public Adapter createTI_mapStringExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp <em>TI map Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp
	 * @generated
	 */
	public Adapter createTI_mapVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable <em>TI map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createTI_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_Helper <em>TI map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createTI_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_VariableDeclaration <em>TI map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createTI_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable <em>WC map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createWC_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_Helper <em>WC map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createWC_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_VariableDeclaration <em>WC map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createWC_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable <em>WI map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createWI_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_Helper <em>WI map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createWI_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_VariableDeclaration <em>WI map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createWI_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression <em>TI map Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapBooleanExp <em>TI map Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapBooleanExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapBooleanExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper <em>TI map Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute <em>TI map Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapHelper_AttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation <em>TI map Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapHelper_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIfExp <em>TI map If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIfExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIntegerExp <em>TI map Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIntegerExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapIntegerExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp <em>TI map Navigation Or Attribute Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Helper <em>TI map Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Property <em>TI map Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapNavigationOrAttributeCallExp_PropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp <em>TI map Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Helper <em>TI map Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Helper
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapOperationCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Operation <em>TI map Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Operation
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapOperationCallExp_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperatorCallExp <em>TI map Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperatorCallExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapOperatorCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapStringExp <em>TI map String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapStringExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapStringExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp <em>TI map Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable <em>TI map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_Helper <em>TI map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_VariableDeclaration <em>TI map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_TI_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable <em>WI map Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_WI_mapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_Helper <em>WI map Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_WI_mapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_VariableDeclaration <em>WI map Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createtrace_ATL2QVTr_WI_mapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //trace_ATL2QVTrAdapterFactory
