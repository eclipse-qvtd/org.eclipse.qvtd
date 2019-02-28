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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.*;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;
import org.eclipse.qvtd.runtime.qvttrace.Execution;
import org.eclipse.qvtd.runtime.qvttrace.TraceElement;
import org.eclipse.qvtd.runtime.qvttrace.TraceInstance;

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
			public Adapter caseCmapVariableExp_referredVariable_Helper(CmapVariableExp_referredVariable_Helper object) {
				return createCmapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseCmapVariableExp_referredVariable_VariableDeclaration(CmapVariableExp_referredVariable_VariableDeclaration object) {
				return createCmapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter caseDmapHelper(DmapHelper object) {
				return createDmapHelperAdapter();
			}
			@Override
			public Adapter caseDmapOclExpression(DmapOclExpression object) {
				return createDmapOclExpressionAdapter();
			}
			@Override
			public Adapter caseDmapVariableExp_referredVariable(DmapVariableExp_referredVariable object) {
				return createDmapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseImapHelper(ImapHelper object) {
				return createImapHelperAdapter();
			}
			@Override
			public Adapter caseImapOclExpression(ImapOclExpression object) {
				return createImapOclExpressionAdapter();
			}
			@Override
			public Adapter caseImapVariableExp_referredVariable(ImapVariableExp_referredVariable object) {
				return createImapVariableExp_referredVariableAdapter();
			}
			@Override
			public Adapter caseTmapBinding(TmapBinding object) {
				return createTmapBindingAdapter();
			}
			@Override
			public Adapter caseTmapBooleanExp(TmapBooleanExp object) {
				return createTmapBooleanExpAdapter();
			}
			@Override
			public Adapter caseTmapHelper_Attribute(TmapHelper_Attribute object) {
				return createTmapHelper_AttributeAdapter();
			}
			@Override
			public Adapter caseTmapHelper_Context(TmapHelper_Context object) {
				return createTmapHelper_ContextAdapter();
			}
			@Override
			public Adapter caseTmapHelper_Operation(TmapHelper_Operation object) {
				return createTmapHelper_OperationAdapter();
			}
			@Override
			public Adapter caseTmapIfExp(TmapIfExp object) {
				return createTmapIfExpAdapter();
			}
			@Override
			public Adapter caseTmapInPattern(TmapInPattern object) {
				return createTmapInPatternAdapter();
			}
			@Override
			public Adapter caseTmapInPattern_filter(TmapInPattern_filter object) {
				return createTmapInPattern_filterAdapter();
			}
			@Override
			public Adapter caseTmapIntegerExp(TmapIntegerExp object) {
				return createTmapIntegerExpAdapter();
			}
			@Override
			public Adapter caseTmapMatchedRule(TmapMatchedRule object) {
				return createTmapMatchedRuleAdapter();
			}
			@Override
			public Adapter caseTmapMatchedRule_super(TmapMatchedRule_super object) {
				return createTmapMatchedRule_superAdapter();
			}
			@Override
			public Adapter caseTmapModule(TmapModule object) {
				return createTmapModuleAdapter();
			}
			@Override
			public Adapter caseTmapNavigationOrAttributeCallExp_Helper(TmapNavigationOrAttributeCallExp_Helper object) {
				return createTmapNavigationOrAttributeCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTmapNavigationOrAttributeCallExp_Property(TmapNavigationOrAttributeCallExp_Property object) {
				return createTmapNavigationOrAttributeCallExp_PropertyAdapter();
			}
			@Override
			public Adapter caseTmapOclMetamodel(TmapOclMetamodel object) {
				return createTmapOclMetamodelAdapter();
			}
			@Override
			public Adapter caseTmapOclModel_IN(TmapOclModel_IN object) {
				return createTmapOclModel_INAdapter();
			}
			@Override
			public Adapter caseTmapOclModel_OUT(TmapOclModel_OUT object) {
				return createTmapOclModel_OUTAdapter();
			}
			@Override
			public Adapter caseTmapOclType(TmapOclType object) {
				return createTmapOclTypeAdapter();
			}
			@Override
			public Adapter caseTmapOperationCallExp_Helper(TmapOperationCallExp_Helper object) {
				return createTmapOperationCallExp_HelperAdapter();
			}
			@Override
			public Adapter caseTmapOperationCallExp_Operation(TmapOperationCallExp_Operation object) {
				return createTmapOperationCallExp_OperationAdapter();
			}
			@Override
			public Adapter caseTmapOperationCallExp_argument(TmapOperationCallExp_argument object) {
				return createTmapOperationCallExp_argumentAdapter();
			}
			@Override
			public Adapter caseTmapOperatorCallExp(TmapOperatorCallExp object) {
				return createTmapOperatorCallExpAdapter();
			}
			@Override
			public Adapter caseTmapSimpleInPatternElement(TmapSimpleInPatternElement object) {
				return createTmapSimpleInPatternElementAdapter();
			}
			@Override
			public Adapter caseTmapSimpleOutPatternElement(TmapSimpleOutPatternElement object) {
				return createTmapSimpleOutPatternElementAdapter();
			}
			@Override
			public Adapter caseTmapStringExp(TmapStringExp object) {
				return createTmapStringExpAdapter();
			}
			@Override
			public Adapter caseTmapVariable(TmapVariable object) {
				return createTmapVariableAdapter();
			}
			@Override
			public Adapter caseTmapVariableExp(TmapVariableExp object) {
				return createTmapVariableExpAdapter();
			}
			@Override
			public Adapter caseTmapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper object) {
				return createTmapVariableExp_referredVariable_HelperAdapter();
			}
			@Override
			public Adapter caseTmapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration object) {
				return createTmapVariableExp_referredVariable_VariableDeclarationAdapter();
			}
			@Override
			public Adapter caseTraceElement(TraceElement object) {
				return createTraceElementAdapter();
			}
			@Override
			public Adapter caseTraceInstance(TraceInstance object) {
				return createTraceInstanceAdapter();
			}
			@Override
			public Adapter caseDispatch(Dispatch object) {
				return createDispatchAdapter();
			}
			@Override
			public Adapter caseExecution(Execution object) {
				return createExecutionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper <em>Cmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createCmapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration <em>Cmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createCmapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper <em>Dmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper
	 * @generated
	 */
	public Adapter createDmapHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression <em>Dmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression
	 * @generated
	 */
	public Adapter createDmapOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable <em>Dmap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createDmapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper <em>Imap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper
	 * @generated
	 */
	public Adapter createImapHelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression <em>Imap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression
	 * @generated
	 */
	public Adapter createImapOclExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable <em>Imap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable
	 * @generated
	 */
	public Adapter createImapVariableExp_referredVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding <em>Tmap Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding
	 * @generated
	 */
	public Adapter createTmapBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp <em>Tmap Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp
	 * @generated
	 */
	public Adapter createTmapBooleanExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute <em>Tmap Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute
	 * @generated
	 */
	public Adapter createTmapHelper_AttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context <em>Tmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context
	 * @generated
	 */
	public Adapter createTmapHelper_ContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation <em>Tmap Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation
	 * @generated
	 */
	public Adapter createTmapHelper_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp <em>Tmap If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp
	 * @generated
	 */
	public Adapter createTmapIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern <em>Tmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern
	 * @generated
	 */
	public Adapter createTmapInPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter <em>Tmap In Pattern filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter
	 * @generated
	 */
	public Adapter createTmapInPattern_filterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp <em>Tmap Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp
	 * @generated
	 */
	public Adapter createTmapIntegerExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule <em>Tmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule
	 * @generated
	 */
	public Adapter createTmapMatchedRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super <em>Tmap Matched Rule super</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super
	 * @generated
	 */
	public Adapter createTmapMatchedRule_superAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule <em>Tmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule
	 * @generated
	 */
	public Adapter createTmapModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper <em>Tmap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	public Adapter createTmapNavigationOrAttributeCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property <em>Tmap Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	public Adapter createTmapNavigationOrAttributeCallExp_PropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel <em>Tmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel
	 * @generated
	 */
	public Adapter createTmapOclMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN <em>Tmap Ocl Model IN</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN
	 * @generated
	 */
	public Adapter createTmapOclModel_INAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT <em>Tmap Ocl Model OUT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT
	 * @generated
	 */
	public Adapter createTmapOclModel_OUTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType <em>Tmap Ocl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType
	 * @generated
	 */
	public Adapter createTmapOclTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper <em>Tmap Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper
	 * @generated
	 */
	public Adapter createTmapOperationCallExp_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation <em>Tmap Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation
	 * @generated
	 */
	public Adapter createTmapOperationCallExp_OperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument <em>Tmap Operation Call Exp argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument
	 * @generated
	 */
	public Adapter createTmapOperationCallExp_argumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp <em>Tmap Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp
	 * @generated
	 */
	public Adapter createTmapOperatorCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement <em>Tmap Simple In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement
	 * @generated
	 */
	public Adapter createTmapSimpleInPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement <em>Tmap Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement
	 * @generated
	 */
	public Adapter createTmapSimpleOutPatternElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp <em>Tmap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp
	 * @generated
	 */
	public Adapter createTmapStringExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable <em>Tmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable
	 * @generated
	 */
	public Adapter createTmapVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp <em>Tmap Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp
	 * @generated
	 */
	public Adapter createTmapVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper <em>Tmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	public Adapter createTmapVariableExp_referredVariable_HelperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration <em>Tmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	public Adapter createTmapVariableExp_referredVariable_VariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.runtime.qvttrace.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceElement
	 * @generated
	 */
	public Adapter createTraceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance <em>Trace Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceInstance
	 * @generated
	 */
	public Adapter createTraceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.runtime.qvttrace.Dispatch <em>Dispatch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.runtime.qvttrace.Dispatch
	 * @generated
	 */
	public Adapter createDispatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.runtime.qvttrace.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.runtime.qvttrace.Execution
	 * @generated
	 */
	public Adapter createExecutionAdapter() {
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
