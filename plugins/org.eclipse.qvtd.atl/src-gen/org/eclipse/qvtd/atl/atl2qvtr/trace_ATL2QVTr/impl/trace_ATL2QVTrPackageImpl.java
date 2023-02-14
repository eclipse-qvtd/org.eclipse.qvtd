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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.atl.common.ATL.ATLPackage;

import org.eclipse.m2m.atl.common.OCL.OCLPackage;

import org.eclipse.m2m.atl.common.PrimitiveTypes.PrimitiveTypesPackage;

import org.eclipse.ocl.pivot.PivotPackage;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TxATL2QVTr;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

import org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage;

import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class trace_ATL2QVTrPackageImpl extends EPackageImpl implements trace_ATL2QVTrPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cmapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cmapVariableExp_referredVariable_VariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dmapHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dmapOclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dmapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imapHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imapOclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapBooleanExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapHelper_AttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapHelper_ContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapHelper_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapIfExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapInPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapInPattern_filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapIntegerExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapMatchedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapMatchedRule_superEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapNavigationOrAttributeCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapNavigationOrAttributeCallExp_PropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOclMetamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOclModel_INEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOclModel_OUTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOclTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOperationCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOperationCallExp_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOperationCallExp_argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapOperatorCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapSimpleInPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapSimpleOutPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapStringExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapVariableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tmapVariableExp_referredVariable_VariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txATL2QVTrEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private trace_ATL2QVTrPackageImpl() {
		super(eNS_URI, trace_ATL2QVTrFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link trace_ATL2QVTrPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static trace_ATL2QVTrPackage init() {
		if (isInited) return (trace_ATL2QVTrPackage)EPackage.Registry.INSTANCE.getEPackage(trace_ATL2QVTrPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredtrace_ATL2QVTrPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		trace_ATL2QVTrPackageImpl thetrace_ATL2QVTrPackage = registeredtrace_ATL2QVTrPackage instanceof trace_ATL2QVTrPackageImpl ? (trace_ATL2QVTrPackageImpl)registeredtrace_ATL2QVTrPackage : new trace_ATL2QVTrPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		OCLstdlibPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();
		QVTtracePackage.eINSTANCE.eClass();
		QVTruntimeLibraryPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thetrace_ATL2QVTrPackage.createPackageContents();

		// Initialize created meta-data
		thetrace_ATL2QVTrPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thetrace_ATL2QVTrPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(trace_ATL2QVTrPackage.eNS_URI, thetrace_ATL2QVTrPackage);
		return thetrace_ATL2QVTrPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCmapVariableExp_referredVariable_Helper() {
		return cmapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCmapVariableExp_referredVariable_VariableDeclaration() {
		return cmapVariableExp_referredVariable_VariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDmapHelper() {
		return dmapHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_D3atlHelper() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_D4qvtrFunction() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_DomapHelper_Attribute() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_DomapHelper_Operation() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_Result() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDmapHelper_S0global() {
		return (EAttribute)dmapHelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDmapOclExpression() {
		return dmapOclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_D3atlExpression() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_D4qvtrExpression() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapBooleanExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapIfExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapIntegerExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOclType() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOperationCallExp_Helper() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOperationCallExp_Operation() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOperatorCallExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapStringExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapVariableExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_Result() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDmapOclExpression_S0global() {
		return (EAttribute)dmapOclExpressionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDmapVariableExp_referredVariable() {
		return dmapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_D3atlExpression() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_D4qvtrExpression() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_Result() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDmapVariableExp_referredVariable_S0global() {
		return (EAttribute)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImapHelper() {
		return imapHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImapHelper_S0global() {
		return (EAttribute)imapHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImapOclExpression() {
		return imapOclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImapOclExpression_S0global() {
		return (EAttribute)imapOclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImapVariableExp_referredVariable() {
		return imapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImapVariableExp_referredVariable_S0global() {
		return (EAttribute)imapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapBinding() {
		return tmapBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapBinding_S0global() {
		return (EAttribute)tmapBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapBinding_T1propertyName() {
		return (EAttribute)tmapBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T3atlBinding() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T3atlExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T3atlOutPatternElement() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T4qvtrExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T4qvtrPart() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T4qvtrTemplate() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_WmapOclExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_WmapSimpleOutPatternElement() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapBooleanExp() {
		return tmapBooleanExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBooleanExp_Dispatcher() {
		return (EReference)tmapBooleanExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapBooleanExp_T1symbol() {
		return (EAttribute)tmapBooleanExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapHelper_Attribute() {
		return tmapHelper_AttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_Dispatcher() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapHelper_Attribute_T1attributeName() {
		return (EAttribute)tmapHelper_AttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T3atlDefinition() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T3atlExpression() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T3atlFeature() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T3atlModule() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T3atlType() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T4qvtrExpression() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T4qvtrTransformation() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_WmapHelper_Context() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_WmapModule() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_WmapOclExpression() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapHelper_Attribute_S0local() {
		return (EAttribute)tmapHelper_AttributeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapHelper_Context() {
		return tmapHelper_ContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapHelper_Context_S0global() {
		return (EAttribute)tmapHelper_ContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T3atlContext() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T3atlDefinition() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T3atlHelper() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T3atlReturnType() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T4qvtrFunction() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T4qvtrParameter() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_WmapVariable() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapHelper_Operation() {
		return tmapHelper_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_Dispatcher() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapHelper_Operation_T1operationName() {
		return (EAttribute)tmapHelper_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T3atlDefinition() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T3atlExpression() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T3atlFeature() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T3atlModule() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T3atlType() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T4qvtrExpression() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T4qvtrTransformation() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_WmapHelper_Context() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_WmapModule() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_WmapOclExpression() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapHelper_Operation_S0local() {
		return (EAttribute)tmapHelper_OperationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapIfExp() {
		return tmapIfExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_Dispatcher() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T3atlCondition() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T3atlElse() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T3atlThen() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T4qvtrCondition() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T4qvtrElse() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T4qvtrThen() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_WmapOclExpression() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_WmapOclExpression1() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_WmapOclExpression2() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapIfExp_S0local() {
		return (EAttribute)tmapIfExpEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapInPattern() {
		return tmapInPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapInPattern_S0global() {
		return (EAttribute)tmapInPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T3atlModel() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T3atlPattern() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T3atlRule() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T4qvtrDomain() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T4qvtrRelation() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T4qvtrTypedModel() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_WmapMatchedRule() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_WmapOclMetamodel() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapInPattern_filter() {
		return tmapInPattern_filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapInPattern_filter_S0global() {
		return (EAttribute)tmapInPattern_filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T3atlExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T3atlPattern() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T3atlRule() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T4p() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T4qvtrDomain() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T4qvtrExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T4qvtrRelation() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T4w() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapInPattern() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapMatchedRule() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapOclExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapIntegerExp() {
		return tmapIntegerExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIntegerExp_Dispatcher() {
		return (EReference)tmapIntegerExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapIntegerExp_T1symbol() {
		return (EAttribute)tmapIntegerExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapMatchedRule() {
		return tmapMatchedRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapMatchedRule_S0global() {
		return (EAttribute)tmapMatchedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapMatchedRule_T1ruleName() {
		return (EAttribute)tmapMatchedRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T3atlModule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T3atlOutPattern() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T3matchedRule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T4_6() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T4qvtrRelation() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T4qvtrTransformation() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_WmapModule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapMatchedRule_super() {
		return tmapMatchedRule_superEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapMatchedRule_super_S0global() {
		return (EAttribute)tmapMatchedRule_superEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T3atlChildRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T3atlSuperRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T4qvtrOverriddenRelation() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T4qvtrOverridesRelation() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_WmapMatchedRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_WmapMatchedRule1() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapModule() {
		return tmapModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapModule_S0global() {
		return (EAttribute)tmapModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapModule_T1txName() {
		return (EAttribute)tmapModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T3atlModule() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T4_3() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T4_4() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T4_5() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T4_6() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T4qvtrTransformation() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapNavigationOrAttributeCallExp_Helper() {
		return tmapNavigationOrAttributeCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_Dispatcher() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapNavigationOrAttributeCallExp_Helper_T1propertyName() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlAttributes() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlModule() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrOperation() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSourceArgument() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrThisVariable() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrTransformation() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapHelper() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapModule() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapNavigationOrAttributeCallExp_Helper_S0local() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapNavigationOrAttributeCallExp_Property() {
		return tmapNavigationOrAttributeCallExp_PropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_Dispatcher() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapNavigationOrAttributeCallExp_Property_T1propertyName() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T3atlAttributes() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T3atlModule() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T3atlSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T4qvtrProperty() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapNavigationOrAttributeCallExp_Property_S0local() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOclMetamodel() {
		return tmapOclMetamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOclMetamodel_S0global() {
		return (EAttribute)tmapOclMetamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOclMetamodel_T1tmName() {
		return (EAttribute)tmapOclMetamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclMetamodel_T3oclMetamodel() {
		return (EReference)tmapOclMetamodelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclMetamodel_T4qvtrTypedModel() {
		return (EReference)tmapOclMetamodelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOclModel_IN() {
		return tmapOclModel_INEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOclModel_IN_S0global() {
		return (EAttribute)tmapOclModel_INEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T3atlModule() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T3oclMetamodel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T3oclModel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T4qvtrPackages() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T4qvtrTransformation() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T4qvtrTypedModel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_WmapModule() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_WmapOclMetamodel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOclModel_OUT() {
		return tmapOclModel_OUTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOclModel_OUT_S0global() {
		return (EAttribute)tmapOclModel_OUTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T3atlModule() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T3oclMetamodel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T3oclModel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T4qvtrPackages() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T4qvtrTransformation() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T4qvtrTypedModel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_WmapModule() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_WmapOclMetamodel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOclType() {
		return tmapOclTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclType_Dispatcher() {
		return (EReference)tmapOclTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOperationCallExp_Helper() {
		return tmapOperationCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_Dispatcher() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperationCallExp_Helper_T1operationName() {
		return (EAttribute)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T3atlModule() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T3atlOperations() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T3atlSource() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T4qvtrOperation() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T4qvtrSource() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T4qvtrSourceArgument() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T4qvtrThisVariable() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T4qvtrTransformation() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapHelper() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapModule() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperationCallExp_Helper_S0local() {
		return (EAttribute)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOperationCallExp_Operation() {
		return tmapOperationCallExp_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_Dispatcher() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperationCallExp_Operation_T1operationName() {
		return (EAttribute)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T3atlModule() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T3atlOperations() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T3atlSource() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T4qvtrOperation() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T4qvtrSource() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperationCallExp_Operation_S0local() {
		return (EAttribute)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOperationCallExp_argument() {
		return tmapOperationCallExp_argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperationCallExp_argument_S0global() {
		return (EAttribute)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T3atlArgument() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T3atlParent() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T4qvtrArgument() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T4qvtrParent() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_WmapOclExpression1() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOperatorCallExp() {
		return tmapOperatorCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_Dispatcher() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperatorCallExp_T1operationName() {
		return (EAttribute)tmapOperatorCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T3atlSource() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T4qvtrOperation() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T4qvtrSource() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_WmapOclExpression() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOperatorCallExp_S0local() {
		return (EAttribute)tmapOperatorCallExpEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapSimpleInPatternElement() {
		return tmapSimpleInPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapSimpleInPatternElement_S0global() {
		return (EAttribute)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapSimpleInPatternElement_T1elementName() {
		return (EAttribute)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T3atlElement() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T3atlPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T3atlRule() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T4qvtrDomain() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T4qvtrPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T4qvtrRelation() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T4qvtrTemplate() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T4qvtrVariable() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapInPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapMatchedRule() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapVariable() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapSimpleOutPatternElement() {
		return tmapSimpleOutPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapSimpleOutPatternElement_S0global() {
		return (EAttribute)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapSimpleOutPatternElement_T1elementName() {
		return (EAttribute)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T3atlElement() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T3atlMetamodel() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T3atlPattern() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T3atlRule() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T3atlType() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrDomain() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrPattern() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrRelation() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrTemplate() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrType() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrTypedModel() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T4qvtrVariable() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapMatchedRule() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapOclMetamodel() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapVariable() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapStringExp() {
		return tmapStringExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapStringExp_Dispatcher() {
		return (EReference)tmapStringExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapStringExp_T1symbol() {
		return (EAttribute)tmapStringExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapVariable() {
		return tmapVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapVariable_S0global() {
		return (EAttribute)tmapVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariable_T3atlVariable() {
		return (EReference)tmapVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariable_T4qvtrVariable() {
		return (EReference)tmapVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapVariableExp() {
		return tmapVariableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_Dispatcher() {
		return (EReference)tmapVariableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapVariableExp_T1varName() {
		return (EAttribute)tmapVariableExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_T3atlVariable() {
		return (EReference)tmapVariableExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_WmapVariableExp_referredVariable() {
		return (EReference)tmapVariableExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapVariableExp_referredVariable_Helper() {
		return tmapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_Helper_Dispatcher() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_Helper_T3atlHelper() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_Helper_T3atlVariable() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_Helper_T4qvtrVariable() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapVariableExp_referredVariable_Helper_S0local() {
		return (EAttribute)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapVariableExp_referredVariable_VariableDeclaration() {
		return tmapVariableExp_referredVariable_VariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher() {
		return (EReference)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_VariableDeclaration_T3atlVariable() {
		return (EReference)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_VariableDeclaration_T4qvtrVariable() {
		return (EReference)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapVariableExp_referredVariable_VariableDeclaration_S0local() {
		return (EAttribute)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxATL2QVTr() {
		return txATL2QVTrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public trace_ATL2QVTrFactory gettrace_ATL2QVTrFactory() {
		return (trace_ATL2QVTrFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cmapVariableExp_referredVariable_HelperEClass = createEClass(0);

		cmapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(1);

		dmapHelperEClass = createEClass(2);
		createEReference(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 0);
		createEReference(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 1);
		createEReference(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 2);
		createEReference(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 3);
		createEReference(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 4);
		createEAttribute(dmapHelperEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 5);

		dmapOclExpressionEClass = createEClass(3);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 0);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 1);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 2);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 3);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 4);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 5);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 6);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 7);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 8);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 9);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 10);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 11);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 12);
		createEReference(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 13);
		createEAttribute(dmapOclExpressionEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 14);

		dmapVariableExp_referredVariableEClass = createEClass(4);
		createEReference(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 0);
		createEReference(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 1);
		createEReference(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 2);
		createEReference(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 3);
		createEReference(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 4);
		createEAttribute(dmapVariableExp_referredVariableEClass, DispatchImpl.DISPATCH_FEATURE_COUNT + 5);

		imapHelperEClass = createEClass(5);
		createEAttribute(imapHelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);

		imapOclExpressionEClass = createEClass(6);
		createEAttribute(imapOclExpressionEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);

		imapVariableExp_referredVariableEClass = createEClass(7);
		createEAttribute(imapVariableExp_referredVariableEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);

		tmapBindingEClass = createEClass(8);
		createEAttribute(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapBindingEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);

		tmapBooleanExpEClass = createEClass(9);
		createEReference(tmapBooleanExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapBooleanExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);

		tmapHelper_AttributeEClass = createEClass(10);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);
		createEAttribute(tmapHelper_AttributeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13);

		tmapHelper_ContextEClass = createEClass(11);
		createEAttribute(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapHelper_ContextEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);

		tmapHelper_OperationEClass = createEClass(12);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);
		createEAttribute(tmapHelper_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13);

		tmapIfExpEClass = createEClass(13);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEAttribute(tmapIfExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);

		tmapInPatternEClass = createEClass(14);
		createEAttribute(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapInPatternEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);

		tmapInPattern_filterEClass = createEClass(15);
		createEAttribute(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapInPattern_filterEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);

		tmapIntegerExpEClass = createEClass(16);
		createEReference(tmapIntegerExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapIntegerExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);

		tmapMatchedRuleEClass = createEClass(17);
		createEAttribute(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapMatchedRuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);

		tmapMatchedRule_superEClass = createEClass(18);
		createEAttribute(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapMatchedRule_superEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);

		tmapModuleEClass = createEClass(19);
		createEAttribute(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapModuleEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);

		tmapNavigationOrAttributeCallExp_HelperEClass = createEClass(20);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13);
		createEAttribute(tmapNavigationOrAttributeCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 14);

		tmapNavigationOrAttributeCallExp_PropertyEClass = createEClass(21);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEAttribute(tmapNavigationOrAttributeCallExp_PropertyEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);

		tmapOclMetamodelEClass = createEClass(22);
		createEAttribute(tmapOclMetamodelEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapOclMetamodelEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapOclMetamodelEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOclMetamodelEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);

		tmapOclModel_INEClass = createEClass(23);
		createEAttribute(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapOclModel_INEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);

		tmapOclModel_OUTEClass = createEClass(24);
		createEAttribute(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapOclModel_OUTEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);

		tmapOclTypeEClass = createEClass(25);
		createEReference(tmapOclTypeEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);

		tmapOperationCallExp_HelperEClass = createEClass(26);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);
		createEReference(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13);
		createEAttribute(tmapOperationCallExp_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 14);

		tmapOperationCallExp_OperationEClass = createEClass(27);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEAttribute(tmapOperationCallExp_OperationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);

		tmapOperationCallExp_argumentEClass = createEClass(28);
		createEAttribute(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOperationCallExp_argumentEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);

		tmapOperatorCallExpEClass = createEClass(29);
		createEReference(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEAttribute(tmapOperatorCallExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);

		tmapSimpleInPatternElementEClass = createEClass(30);
		createEAttribute(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapSimpleInPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);

		tmapSimpleOutPatternElementEClass = createEClass(31);
		createEAttribute(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEAttribute(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 14);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 15);
		createEReference(tmapSimpleOutPatternElementEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 16);

		tmapStringExpEClass = createEClass(32);
		createEReference(tmapStringExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapStringExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);

		tmapVariableEClass = createEClass(33);
		createEAttribute(tmapVariableEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0);
		createEReference(tmapVariableEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapVariableEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);

		tmapVariableExpEClass = createEClass(34);
		createEReference(tmapVariableExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEAttribute(tmapVariableExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapVariableExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapVariableExpEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);

		tmapVariableExp_referredVariable_HelperEClass = createEClass(35);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);
		createEAttribute(tmapVariableExp_referredVariable_HelperEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5);

		tmapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(36);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		createEAttribute(tmapVariableExp_referredVariable_VariableDeclarationEClass, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4);

		txATL2QVTrEClass = createEClass(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		QVTtracePackage theQVTtracePackage = (QVTtracePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtracePackage.eNS_URI);
		ATLPackage theATLPackage = (ATLPackage)EPackage.Registry.INSTANCE.getEPackage(ATLPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTtemplatePackage theQVTtemplatePackage = (QVTtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtemplatePackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cmapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getDmapVariableExp_referredVariable());
		cmapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getDmapVariableExp_referredVariable());
		dmapHelperEClass.getESuperTypes().add(theQVTtracePackage.getDispatch());
		dmapOclExpressionEClass.getESuperTypes().add(theQVTtracePackage.getDispatch());
		dmapVariableExp_referredVariableEClass.getESuperTypes().add(theQVTtracePackage.getDispatch());
		imapHelperEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		imapOclExpressionEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		imapVariableExp_referredVariableEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapBindingEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapBooleanExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapHelper_AttributeEClass.getESuperTypes().add(this.getImapHelper());
		tmapHelper_ContextEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapHelper_OperationEClass.getESuperTypes().add(this.getImapHelper());
		tmapIfExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapInPatternEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapInPattern_filterEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapIntegerExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapMatchedRuleEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapMatchedRule_superEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapModuleEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapNavigationOrAttributeCallExp_HelperEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapNavigationOrAttributeCallExp_PropertyEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOclMetamodelEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapOclModel_INEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapOclModel_OUTEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapOclTypeEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOperationCallExp_HelperEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOperationCallExp_OperationEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOperationCallExp_argumentEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapOperatorCallExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapSimpleInPatternElementEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapSimpleOutPatternElementEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapStringExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapVariableEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapVariableExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getImapVariableExp_referredVariable());
		tmapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getImapVariableExp_referredVariable());
		txATL2QVTrEClass.getESuperTypes().add(theQVTtracePackage.getTransformationExecution());

		// Initialize classes, features, and operations; add parameters
		initEClass(cmapVariableExp_referredVariable_HelperEClass, CmapVariableExp_referredVariable_Helper.class, "CmapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cmapVariableExp_referredVariable_VariableDeclarationEClass, CmapVariableExp_referredVariable_VariableDeclaration.class, "CmapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dmapHelperEClass, DmapHelper.class, "DmapHelper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapHelper_D3atlHelper(), theATLPackage.getHelper(), null, "d3atlHelper", null, 1, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_D4qvtrFunction(), theQVTbasePackage.getFunction(), null, "d4qvtrFunction", null, 1, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_DomapHelper_Attribute(), this.getTmapHelper_Attribute(), this.getTmapHelper_Attribute_Dispatcher(), "domapHelper_Attribute", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_DomapHelper_Operation(), this.getTmapHelper_Operation(), this.getTmapHelper_Operation_Dispatcher(), "domapHelper_Operation", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_Result(), this.getImapHelper(), null, "result", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDmapHelper_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dmapOclExpressionEClass, DmapOclExpression.class, "DmapOclExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapOclExpression_D3atlExpression(), theOCLPackage.getOclExpression(), null, "d3atlExpression", null, 1, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_D4qvtrExpression(), thePivotPackage.getOCLExpression(), null, "d4qvtrExpression", null, 1, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapBooleanExp(), this.getTmapBooleanExp(), this.getTmapBooleanExp_Dispatcher(), "domapBooleanExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapIfExp(), this.getTmapIfExp(), this.getTmapIfExp_Dispatcher(), "domapIfExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapIntegerExp(), this.getTmapIntegerExp(), this.getTmapIntegerExp_Dispatcher(), "domapIntegerExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper(), this.getTmapNavigationOrAttributeCallExp_Helper(), this.getTmapNavigationOrAttributeCallExp_Helper_Dispatcher(), "domapNavigationOrAttributeCallExp_Helper", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property(), this.getTmapNavigationOrAttributeCallExp_Property(), this.getTmapNavigationOrAttributeCallExp_Property_Dispatcher(), "domapNavigationOrAttributeCallExp_Property", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOclType(), this.getTmapOclType(), this.getTmapOclType_Dispatcher(), "domapOclType", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperationCallExp_Helper(), this.getTmapOperationCallExp_Helper(), this.getTmapOperationCallExp_Helper_Dispatcher(), "domapOperationCallExp_Helper", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperationCallExp_Operation(), this.getTmapOperationCallExp_Operation(), this.getTmapOperationCallExp_Operation_Dispatcher(), "domapOperationCallExp_Operation", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperatorCallExp(), this.getTmapOperatorCallExp(), this.getTmapOperatorCallExp_Dispatcher(), "domapOperatorCallExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapStringExp(), this.getTmapStringExp(), this.getTmapStringExp_Dispatcher(), "domapStringExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapVariableExp(), this.getTmapVariableExp(), this.getTmapVariableExp_Dispatcher(), "domapVariableExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_Result(), this.getImapOclExpression(), null, "result", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDmapOclExpression_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dmapVariableExp_referredVariableEClass, DmapVariableExp_referredVariable.class, "DmapVariableExp_referredVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapVariableExp_referredVariable_D3atlExpression(), theOCLPackage.getVariableExp(), null, "d3atlExpression", null, 1, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_D4qvtrExpression(), thePivotPackage.getVariableExp(), null, "d4qvtrExpression", null, 1, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper(), this.getTmapVariableExp_referredVariable_Helper(), this.getTmapVariableExp_referredVariable_Helper_Dispatcher(), "domapVariableExp_referredVariable_Helper", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration(), this.getTmapVariableExp_referredVariable_VariableDeclaration(), this.getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher(), "domapVariableExp_referredVariable_VariableDeclaration", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_Result(), this.getImapVariableExp_referredVariable(), null, "result", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDmapVariableExp_referredVariable_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapHelperEClass, ImapHelper.class, "ImapHelper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapHelper_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, ImapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapOclExpressionEClass, ImapOclExpression.class, "ImapOclExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapOclExpression_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, ImapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapVariableExp_referredVariableEClass, ImapVariableExp_referredVariable.class, "ImapVariableExp_referredVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapVariableExp_referredVariable_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, ImapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapBindingEClass, TmapBinding.class, "TmapBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapBinding_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapBinding_T1propertyName(), ecorePackage.getEString(), "t1propertyName", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T3atlBinding(), theATLPackage.getBinding(), null, "t3atlBinding", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T3atlExpression(), theOCLPackage.getOclExpression(), null, "t3atlExpression", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T3atlOutPatternElement(), theATLPackage.getSimpleOutPatternElement(), null, "t3atlOutPatternElement", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T4qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t4qvtrExpression", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T4qvtrPart(), theQVTtemplatePackage.getPropertyTemplateItem(), null, "t4qvtrPart", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T4qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t4qvtrTemplate", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_WmapSimpleOutPatternElement(), this.getTmapSimpleOutPatternElement(), null, "wmapSimpleOutPatternElement", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapBooleanExpEClass, TmapBooleanExp.class, "TmapBooleanExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapBooleanExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapBooleanExp(), "dispatcher", null, 1, 1, TmapBooleanExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapBooleanExp_T1symbol(), ecorePackage.getEBoolean(), "t1symbol", null, 1, 1, TmapBooleanExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_AttributeEClass, TmapHelper_Attribute.class, "TmapHelper_Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapHelper_Attribute_Dispatcher(), this.getDmapHelper(), this.getDmapHelper_DomapHelper_Attribute(), "dispatcher", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Attribute_T1attributeName(), ecorePackage.getEString(), "t1attributeName", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T3atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t3atlDefinition", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T3atlExpression(), theOCLPackage.getOclExpression(), null, "t3atlExpression", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T3atlFeature(), theOCLPackage.getAttribute(), null, "t3atlFeature", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T3atlType(), theOCLPackage.getOclType(), null, "t3atlType", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T4qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t4qvtrExpression", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapHelper_Context(), this.getTmapHelper_Context(), null, "wmapHelper_Context", null, 0, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Attribute_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_ContextEClass, TmapHelper_Context.class, "TmapHelper_Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapHelper_Context_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T3atlContext(), theOCLPackage.getOclContextDefinition(), null, "t3atlContext", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T3atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t3atlDefinition", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T3atlHelper(), theATLPackage.getHelper(), null, "t3atlHelper", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T3atlReturnType(), theOCLPackage.getOclType(), null, "t3atlReturnType", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T4qvtrFunction(), theQVTbasePackage.getFunction(), null, "t4qvtrFunction", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T4qvtrParameter(), theQVTbasePackage.getFunctionParameter(), null, "t4qvtrParameter", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_OperationEClass, TmapHelper_Operation.class, "TmapHelper_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapHelper_Operation_Dispatcher(), this.getDmapHelper(), this.getDmapHelper_DomapHelper_Operation(), "dispatcher", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Operation_T1operationName(), ecorePackage.getEString(), "t1operationName", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T3atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t3atlDefinition", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T3atlExpression(), theOCLPackage.getOclExpression(), null, "t3atlExpression", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T3atlFeature(), theOCLPackage.getOperation(), null, "t3atlFeature", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T3atlType(), theOCLPackage.getOclType(), null, "t3atlType", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T4qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t4qvtrExpression", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapHelper_Context(), this.getTmapHelper_Context(), null, "wmapHelper_Context", null, 0, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Operation_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapIfExpEClass, TmapIfExp.class, "TmapIfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapIfExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapIfExp(), "dispatcher", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T3atlCondition(), theOCLPackage.getOclExpression(), null, "t3atlCondition", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T3atlElse(), theOCLPackage.getOclExpression(), null, "t3atlElse", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T3atlThen(), theOCLPackage.getOclExpression(), null, "t3atlThen", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T4qvtrCondition(), thePivotPackage.getOCLExpression(), null, "t4qvtrCondition", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T4qvtrElse(), thePivotPackage.getOCLExpression(), null, "t4qvtrElse", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T4qvtrThen(), thePivotPackage.getOCLExpression(), null, "t4qvtrThen", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression1(), this.getDmapOclExpression(), null, "wmapOclExpression1", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression2(), this.getDmapOclExpression(), null, "wmapOclExpression2", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapIfExp_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapInPatternEClass, TmapInPattern.class, "TmapInPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapInPattern_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T3atlModel(), theOCLPackage.getOclModel(), null, "t3atlModel", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T3atlPattern(), theATLPackage.getInPattern(), null, "t3atlPattern", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T3atlRule(), theATLPackage.getMatchedRule(), null, "t3atlRule", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T4qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t4qvtrDomain", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T4qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrRelation", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T4qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t4qvtrTypedModel", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapInPattern_filterEClass, TmapInPattern_filter.class, "TmapInPattern_filter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapInPattern_filter_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T3atlExpression(), theOCLPackage.getOclExpression(), null, "t3atlExpression", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T3atlPattern(), theATLPackage.getInPattern(), null, "t3atlPattern", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T3atlRule(), theATLPackage.getMatchedRule(), null, "t3atlRule", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T4p(), theQVTbasePackage.getPredicate(), null, "t4p", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T4qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t4qvtrDomain", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T4qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t4qvtrExpression", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T4qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrRelation", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T4w(), theQVTbasePackage.getPattern(), null, "t4w", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapInPattern(), this.getTmapInPattern(), null, "wmapInPattern", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapIntegerExpEClass, TmapIntegerExp.class, "TmapIntegerExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapIntegerExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapIntegerExp(), "dispatcher", null, 1, 1, TmapIntegerExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapIntegerExp_T1symbol(), ecorePackage.getEBigInteger(), "t1symbol", null, 1, 1, TmapIntegerExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapMatchedRuleEClass, TmapMatchedRule.class, "TmapMatchedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapMatchedRule_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapMatchedRule_T1ruleName(), ecorePackage.getEString(), "t1ruleName", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T3atlOutPattern(), theATLPackage.getOutPattern(), null, "t3atlOutPattern", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T3matchedRule(), theATLPackage.getMatchedRule(), null, "t3matchedRule", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T4_6(), theQVTrelationPackage.getSharedVariable(), null, "t4_6", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T4qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrRelation", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapMatchedRule_superEClass, TmapMatchedRule_super.class, "TmapMatchedRule_super", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapMatchedRule_super_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T3atlChildRule(), theATLPackage.getMatchedRule(), null, "t3atlChildRule", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T3atlSuperRule(), theATLPackage.getMatchedRule(), null, "t3atlSuperRule", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T4qvtrOverriddenRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrOverriddenRelation", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T4qvtrOverridesRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrOverridesRelation", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_WmapMatchedRule1(), this.getTmapMatchedRule(), null, "wmapMatchedRule1", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapModuleEClass, TmapModule.class, "TmapModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapModule_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapModule_T1txName(), ecorePackage.getEString(), "t1txName", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T4_3(), thePivotPackage.getPackage(), null, "t4_3", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T4_4(), theQVTrelationPackage.getRelationModel(), null, "t4_4", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T4_5(), thePivotPackage.getParameter(), null, "t4_5", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T4_6(), theQVTbasePackage.getTypedModel(), null, "t4_6", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapNavigationOrAttributeCallExp_HelperEClass, TmapNavigationOrAttributeCallExp_Helper.class, "TmapNavigationOrAttributeCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper(), "dispatcher", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Helper_T1propertyName(), ecorePackage.getEString(), "t1propertyName", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T3atlAttributes(), theOCLPackage.getAttribute(), null, "t3atlAttributes", null, 0, -1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T3atlSource(), theOCLPackage.getOclExpression(), null, "t3atlSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T4qvtrOperation(), thePivotPackage.getOperation(), null, "t4qvtrOperation", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSource(), thePivotPackage.getVariableExp(), null, "t4qvtrSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "t4qvtrSourceArgument", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T4qvtrThisVariable(), thePivotPackage.getVariableDeclaration(), null, "t4qvtrThisVariable", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapHelper(), this.getDmapHelper(), null, "wmapHelper", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Helper_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapNavigationOrAttributeCallExp_PropertyEClass, TmapNavigationOrAttributeCallExp_Property.class, "TmapNavigationOrAttributeCallExp_Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property(), "dispatcher", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Property_T1propertyName(), ecorePackage.getEString(), "t1propertyName", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T3atlAttributes(), theOCLPackage.getAttribute(), null, "t3atlAttributes", null, 0, -1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T3atlSource(), theOCLPackage.getOclExpression(), null, "t3atlSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T4qvtrProperty(), thePivotPackage.getProperty(), null, "t4qvtrProperty", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource(), thePivotPackage.getOCLExpression(), null, "t4qvtrSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Property_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclMetamodelEClass, TmapOclMetamodel.class, "TmapOclMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclMetamodel_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOclMetamodel_T1tmName(), ecorePackage.getEString(), "t1tmName", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclMetamodel_T3oclMetamodel(), theOCLPackage.getOclModel(), null, "t3oclMetamodel", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclMetamodel_T4qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t4qvtrTypedModel", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclModel_INEClass, TmapOclModel_IN.class, "TmapOclModel_IN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclModel_IN_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T3oclMetamodel(), theOCLPackage.getOclModel(), null, "t3oclMetamodel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T3oclModel(), theOCLPackage.getOclModel(), null, "t3oclModel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T4qvtrPackages(), thePivotPackage.getPackage(), null, "t4qvtrPackages", null, 0, -1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTmapOclModel_IN_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T4qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t4qvtrTypedModel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclModel_OUTEClass, TmapOclModel_OUT.class, "TmapOclModel_OUT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclModel_OUT_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T3oclMetamodel(), theOCLPackage.getOclModel(), null, "t3oclMetamodel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T3oclModel(), theOCLPackage.getOclModel(), null, "t3oclModel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T4qvtrPackages(), thePivotPackage.getPackage(), null, "t4qvtrPackages", null, 0, -1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T4qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t4qvtrTypedModel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclTypeEClass, TmapOclType.class, "TmapOclType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOclType_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOclType(), "dispatcher", null, 1, 1, TmapOclType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_HelperEClass, TmapOperationCallExp_Helper.class, "TmapOperationCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperationCallExp_Helper_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperationCallExp_Helper(), "dispatcher", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Helper_T1operationName(), ecorePackage.getEString(), "t1operationName", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T3atlOperations(), theOCLPackage.getOperation(), null, "t3atlOperations", null, 0, -1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T3atlSource(), theOCLPackage.getOclExpression(), null, "t3atlSource", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T4qvtrOperation(), thePivotPackage.getOperation(), null, "t4qvtrOperation", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T4qvtrSource(), thePivotPackage.getVariableExp(), null, "t4qvtrSource", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T4qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "t4qvtrSourceArgument", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T4qvtrThisVariable(), thePivotPackage.getVariableDeclaration(), null, "t4qvtrThisVariable", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T4qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t4qvtrTransformation", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapHelper(), this.getDmapHelper(), null, "wmapHelper", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Helper_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_OperationEClass, TmapOperationCallExp_Operation.class, "TmapOperationCallExp_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperationCallExp_Operation_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperationCallExp_Operation(), "dispatcher", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Operation_T1operationName(), ecorePackage.getEString(), "t1operationName", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T3atlModule(), theATLPackage.getModule(), null, "t3atlModule", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T3atlOperations(), theOCLPackage.getOperation(), null, "t3atlOperations", null, 0, -1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T3atlSource(), theOCLPackage.getOclExpression(), null, "t3atlSource", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T4qvtrOperation(), thePivotPackage.getOperation(), null, "t4qvtrOperation", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T4qvtrSource(), thePivotPackage.getOCLExpression(), null, "t4qvtrSource", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Operation_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_argumentEClass, TmapOperationCallExp_argument.class, "TmapOperationCallExp_argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOperationCallExp_argument_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T3atlArgument(), theOCLPackage.getOclExpression(), null, "t3atlArgument", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T3atlParent(), theOCLPackage.getOperationCallExp(), null, "t3atlParent", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T4qvtrArgument(), thePivotPackage.getOCLExpression(), null, "t4qvtrArgument", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T4qvtrParent(), thePivotPackage.getOperationCallExp(), null, "t4qvtrParent", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_WmapOclExpression1(), this.getDmapOclExpression(), null, "wmapOclExpression1", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperatorCallExpEClass, TmapOperatorCallExp.class, "TmapOperatorCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperatorCallExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperatorCallExp(), "dispatcher", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperatorCallExp_T1operationName(), ecorePackage.getEString(), "t1operationName", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T3atlSource(), theOCLPackage.getOclExpression(), null, "t3atlSource", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T4qvtrOperation(), thePivotPackage.getOperation(), null, "t4qvtrOperation", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T4qvtrSource(), thePivotPackage.getOCLExpression(), null, "t4qvtrSource", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperatorCallExp_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapSimpleInPatternElementEClass, TmapSimpleInPatternElement.class, "TmapSimpleInPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapSimpleInPatternElement_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapSimpleInPatternElement_T1elementName(), ecorePackage.getEString(), "t1elementName", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T3atlElement(), theATLPackage.getSimpleInPatternElement(), null, "t3atlElement", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T3atlPattern(), theATLPackage.getInPattern(), null, "t3atlPattern", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T3atlRule(), theATLPackage.getMatchedRule(), null, "t3atlRule", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T4qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t4qvtrDomain", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T4qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "t4qvtrPattern", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T4qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrRelation", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T4qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t4qvtrTemplate", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T4qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "t4qvtrVariable", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapInPattern(), this.getTmapInPattern(), null, "wmapInPattern", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapSimpleOutPatternElementEClass, TmapSimpleOutPatternElement.class, "TmapSimpleOutPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapSimpleOutPatternElement_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapSimpleOutPatternElement_T1elementName(), ecorePackage.getEString(), "t1elementName", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T3atlElement(), theATLPackage.getSimpleOutPatternElement(), null, "t3atlElement", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T3atlMetamodel(), theOCLPackage.getOclModel(), null, "t3atlMetamodel", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T3atlPattern(), theATLPackage.getOutPattern(), null, "t3atlPattern", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T3atlRule(), theATLPackage.getMatchedRule(), null, "t3atlRule", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T3atlType(), theOCLPackage.getOclModelElement(), null, "t3atlType", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t4qvtrDomain", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "t4qvtrPattern", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t4qvtrRelation", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t4qvtrTemplate", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrType(), thePivotPackage.getType(), null, "t4qvtrType", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t4qvtrTypedModel", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T4qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "t4qvtrVariable", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapStringExpEClass, TmapStringExp.class, "TmapStringExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapStringExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapStringExp(), "dispatcher", null, 1, 1, TmapStringExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapStringExp_T1symbol(), ecorePackage.getEString(), "t1symbol", null, 1, 1, TmapStringExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableEClass, TmapVariable.class, "TmapVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapVariable_S0global(), ecorePackage.getEBooleanObject(), "s0global", null, 0, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariable_T3atlVariable(), theATLPackage.getLocatedElement(), null, "t3atlVariable", null, 1, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariable_T4qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t4qvtrVariable", null, 1, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExpEClass, TmapVariableExp.class, "TmapVariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapVariableExp(), "dispatcher", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapVariableExp_T1varName(), ecorePackage.getEString(), "t1varName", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_T3atlVariable(), theOCLPackage.getVariableDeclaration(), null, "t3atlVariable", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_WmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable(), null, "wmapVariableExp_referredVariable", null, 0, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExp_referredVariable_HelperEClass, TmapVariableExp_referredVariable_Helper.class, "TmapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_referredVariable_Helper_Dispatcher(), this.getDmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper(), "dispatcher", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_Helper_T3atlHelper(), theATLPackage.getHelper(), null, "t3atlHelper", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_Helper_T3atlVariable(), theOCLPackage.getVariableDeclaration(), null, "t3atlVariable", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_Helper_T4qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t4qvtrVariable", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapVariableExp_referredVariable_Helper_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExp_referredVariable_VariableDeclarationEClass, TmapVariableExp_referredVariable_VariableDeclaration.class, "TmapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher(), this.getDmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration(), "dispatcher", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_T3atlVariable(), theATLPackage.getPatternElement(), null, "t3atlVariable", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_T4qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t4qvtrVariable", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapVariableExp_referredVariable_VariableDeclaration_S0local(), ecorePackage.getEBooleanObject(), "s0local", null, 0, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txATL2QVTrEClass, TxATL2QVTr.class, "TxATL2QVTr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
		// http://www.eclipse.org/qvt#Domains
		createQvtDomainsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";
		addAnnotation
		  (getDmapHelper_D3atlHelper(),
		   source,
		   new String[] {
			   "body", "DmapHelper"
		   });
		addAnnotation
		  (getDmapHelper_D4qvtrFunction(),
		   source,
		   new String[] {
			   "body", "DmapHelper"
		   });
		addAnnotation
		  (getDmapOclExpression_D3atlExpression(),
		   source,
		   new String[] {
			   "body", "DmapOclExpression"
		   });
		addAnnotation
		  (getDmapOclExpression_D4qvtrExpression(),
		   source,
		   new String[] {
			   "body", "DmapOclExpression"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_D3atlExpression(),
		   source,
		   new String[] {
			   "body", "DmapVariableExp_referredVariable"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_D4qvtrExpression(),
		   source,
		   new String[] {
			   "body", "DmapVariableExp_referredVariable"
		   });
		addAnnotation
		  (getTmapBinding_T3atlBinding(),
		   source,
		   new String[] {
			   "body", "TmapBinding"
		   });
		addAnnotation
		  (getTmapBinding_T3atlExpression(),
		   source,
		   new String[] {
			   "body", "TmapBinding"
		   });
		addAnnotation
		  (getTmapBinding_T4qvtrExpression(),
		   source,
		   new String[] {
			   "body", "TmapBinding"
		   });
		addAnnotation
		  (getTmapBinding_T4qvtrPart(),
		   source,
		   new String[] {
			   "body", "TmapBinding"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlDefinition(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Attribute"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlExpression(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Attribute"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlFeature(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Attribute"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlType(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Attribute"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlContext(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlDefinition(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlHelper(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlReturnType(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Context_T4qvtrFunction(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Context_T4qvtrParameter(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Context"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlDefinition(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Operation"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlExpression(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Operation"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlFeature(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Operation"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlType(),
		   source,
		   new String[] {
			   "body", "TmapHelper_Operation"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlCondition(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlElse(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlThen(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrCondition(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrElse(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrThen(),
		   source,
		   new String[] {
			   "body", "TmapIfExp"
		   });
		addAnnotation
		  (getTmapInPattern_T3atlPattern(),
		   source,
		   new String[] {
			   "body", "TmapInPattern"
		   });
		addAnnotation
		  (getTmapInPattern_T3atlRule(),
		   source,
		   new String[] {
			   "body", "TmapInPattern"
		   });
		addAnnotation
		  (getTmapInPattern_T4qvtrDomain(),
		   source,
		   new String[] {
			   "body", "TmapInPattern"
		   });
		addAnnotation
		  (getTmapMatchedRule_T3atlOutPattern(),
		   source,
		   new String[] {
			   "body", "TmapMatchedRule"
		   });
		addAnnotation
		  (getTmapMatchedRule_T3matchedRule(),
		   source,
		   new String[] {
			   "body", "TmapMatchedRule"
		   });
		addAnnotation
		  (getTmapMatchedRule_T4_6(),
		   source,
		   new String[] {
			   "body", "TmapMatchedRule"
		   });
		addAnnotation
		  (getTmapMatchedRule_T4qvtrRelation(),
		   source,
		   new String[] {
			   "body", "TmapMatchedRule"
		   });
		addAnnotation
		  (getTmapModule_T3atlModule(),
		   source,
		   new String[] {
			   "body", "TmapModule"
		   });
		addAnnotation
		  (getTmapModule_T4_6(),
		   source,
		   new String[] {
			   "body", "TmapModule"
		   });
		addAnnotation
		  (getTmapModule_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "body", "TmapModule"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T3atlSource(),
		   source,
		   new String[] {
			   "body", "TmapNavigationOrAttributeCallExp_Property"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource(),
		   source,
		   new String[] {
			   "body", "TmapNavigationOrAttributeCallExp_Property"
		   });
		addAnnotation
		  (getTmapOclMetamodel_T3oclMetamodel(),
		   source,
		   new String[] {
			   "body", "TmapOclMetamodel"
		   });
		addAnnotation
		  (getTmapOclMetamodel_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "body", "TmapOclMetamodel"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T3oclModel(),
		   source,
		   new String[] {
			   "body", "TmapOclModel_IN"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "body", "TmapOclModel_IN"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T3oclModel(),
		   source,
		   new String[] {
			   "body", "TmapOclModel_OUT"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "body", "TmapOclModel_OUT"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T3atlSource(),
		   source,
		   new String[] {
			   "body", "TmapOperationCallExp_Operation"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T4qvtrSource(),
		   source,
		   new String[] {
			   "body", "TmapOperationCallExp_Operation"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T3atlArgument(),
		   source,
		   new String[] {
			   "body", "TmapOperationCallExp_argument"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T4qvtrArgument(),
		   source,
		   new String[] {
			   "body", "TmapOperationCallExp_argument"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T3atlSource(),
		   source,
		   new String[] {
			   "body", "TmapOperatorCallExp"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T4qvtrSource(),
		   source,
		   new String[] {
			   "body", "TmapOperatorCallExp"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T3atlElement(),
		   source,
		   new String[] {
			   "body", "TmapSimpleInPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrPattern(),
		   source,
		   new String[] {
			   "body", "TmapSimpleInPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrTemplate(),
		   source,
		   new String[] {
			   "body", "TmapSimpleInPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrVariable(),
		   source,
		   new String[] {
			   "body", "TmapSimpleInPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlElement(),
		   source,
		   new String[] {
			   "body", "TmapSimpleOutPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlType(),
		   source,
		   new String[] {
			   "body", "TmapSimpleOutPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrPattern(),
		   source,
		   new String[] {
			   "body", "TmapSimpleOutPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrTemplate(),
		   source,
		   new String[] {
			   "body", "TmapSimpleOutPatternElement"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrVariable(),
		   source,
		   new String[] {
			   "body", "TmapSimpleOutPatternElement"
		   });
		addAnnotation
		  (getTmapVariable_T3atlVariable(),
		   source,
		   new String[] {
			   "body", "TmapVariable"
		   });
		addAnnotation
		  (getTmapVariable_T4qvtrVariable(),
		   source,
		   new String[] {
			   "body", "TmapVariable"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/qvt#Domains</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createQvtDomainsAnnotations() {
		String source = "http://www.eclipse.org/qvt#Domains";
		addAnnotation
		  (getDmapHelper_D3atlHelper(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getDmapHelper_D4qvtrFunction(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getDmapHelper_DomapHelper_Attribute(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapHelper_DomapHelper_Operation(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_D3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getDmapOclExpression_D4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapBooleanExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapIfExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapIntegerExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapOclType(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapOperationCallExp_Helper(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapOperationCallExp_Operation(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapOperatorCallExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapStringExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapOclExpression_DomapVariableExp(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_D3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_D4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration(),
		   source,
		   new String[] {
			   "referredDomain", "middle"
		   });
		addAnnotation
		  (getTmapBinding_T1propertyName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapBinding_T3atlBinding(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapBinding_T3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapBinding_T3atlOutPatternElement(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapBinding_T4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapBinding_T4qvtrPart(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapBinding_T4qvtrTemplate(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapBooleanExp_T1symbol(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T1attributeName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlDefinition(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlFeature(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T3atlType(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapHelper_Attribute_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlContext(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlDefinition(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlHelper(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Context_T3atlReturnType(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Context_T4qvtrFunction(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapHelper_Context_T4qvtrParameter(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T1operationName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlDefinition(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlFeature(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T3atlType(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapHelper_Operation_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlCondition(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlElse(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapIfExp_T3atlThen(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrCondition(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrElse(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapIfExp_T4qvtrThen(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_T3atlModel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_T3atlPattern(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_T3atlRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_T4qvtrDomain(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_T4qvtrRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T3atlExpression(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T3atlPattern(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T3atlRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T4p(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T4qvtrDomain(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T4qvtrExpression(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T4qvtrRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapInPattern_filter_T4w(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapIntegerExp_T1symbol(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapMatchedRule_T1ruleName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapMatchedRule_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapMatchedRule_T3atlOutPattern(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapMatchedRule_T3matchedRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapMatchedRule_T4_6(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapMatchedRule_T4qvtrRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapMatchedRule_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapMatchedRule_super_T3atlChildRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapMatchedRule_super_T3atlSuperRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapMatchedRule_super_T4qvtrOverriddenRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapMatchedRule_super_T4qvtrOverridesRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapModule_T1txName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapModule_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapModule_T4_3(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapModule_T4_4(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapModule_T4_5(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapModule_T4_6(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapModule_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T1propertyName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T3atlAttributes(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T3atlSource(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T4qvtrOperation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSource(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSourceArgument(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T4qvtrThisVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Helper_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T1propertyName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T3atlAttributes(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T3atlSource(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T4qvtrProperty(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclMetamodel_T1tmName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapOclMetamodel_T3oclMetamodel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclMetamodel_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T3oclMetamodel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T3oclModel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T4qvtrPackages(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_IN_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T3oclMetamodel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T3oclModel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T4qvtrPackages(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOclModel_OUT_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T1operationName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T3atlOperations(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T3atlSource(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T4qvtrOperation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T4qvtrSource(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T4qvtrSourceArgument(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T4qvtrThisVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Helper_T4qvtrTransformation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T1operationName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T3atlModule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T3atlOperations(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T3atlSource(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T4qvtrOperation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_Operation_T4qvtrSource(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T3atlArgument(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T3atlParent(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T4qvtrArgument(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperationCallExp_argument_T4qvtrParent(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T1operationName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T3atlSource(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T4qvtrOperation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapOperatorCallExp_T4qvtrSource(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T1elementName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T3atlElement(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T3atlPattern(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T3atlRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrDomain(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrPattern(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrTemplate(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleInPatternElement_T4qvtrVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T1elementName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlElement(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlMetamodel(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlPattern(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlRule(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T3atlType(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrDomain(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrPattern(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrRelation(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrTemplate(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrType(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrTypedModel(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapSimpleOutPatternElement_T4qvtrVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapStringExp_T1symbol(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapVariable_T3atlVariable(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapVariable_T4qvtrVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapVariableExp_T1varName(),
		   source,
		   new String[] {
			   "referredDomain", "$primitive$"
		   });
		addAnnotation
		  (getTmapVariableExp_T3atlVariable(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapVariableExp_referredVariable_Helper_T3atlHelper(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapVariableExp_referredVariable_Helper_T3atlVariable(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapVariableExp_referredVariable_Helper_T4qvtrVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
		addAnnotation
		  (getTmapVariableExp_referredVariable_VariableDeclaration_T3atlVariable(),
		   source,
		   new String[] {
			   "referredDomain", "atl"
		   });
		addAnnotation
		  (getTmapVariableExp_referredVariable_VariableDeclaration_T4qvtrVariable(),
		   source,
		   new String[] {
			   "referredDomain", "qvtr"
		   });
	}

} //trace_ATL2QVTrPackageImpl
