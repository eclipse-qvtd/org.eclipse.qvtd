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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.atl.common.ATL.ATLPackage;

import org.eclipse.m2m.atl.common.OCL.OCLPackage;

import org.eclipse.m2m.atl.common.PrimitiveTypes.PrimitiveTypesPackage;

import org.eclipse.ocl.pivot.PivotPackage;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapInPattern_filter;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule_super;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_OUT;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapBooleanExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

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
	private EClass tC_mapBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapBooleanExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapHelper_AttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapHelper_ContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapHelper_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapIfExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapInPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapInPattern_filterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapIntegerExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapMatchedRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapMatchedRule_superEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapNavigationOrAttributeCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapNavigationOrAttributeCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapNavigationOrAttributeCallExp_PropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOclMetamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOclModel_INEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOclModel_OUTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOperationCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOperationCallExp_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOperationCallExp_argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOperatorCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapOutPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapSimpleInPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapSimpleOutPatternElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapStringExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapVariableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tC_mapVariableExp_referredVariable_VariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapBooleanExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapHelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapHelper_AttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapHelper_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapIfExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapIntegerExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapNavigationOrAttributeCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapNavigationOrAttributeCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapNavigationOrAttributeCallExp_PropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapOclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapOperationCallExp_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapOperationCallExp_OperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapOperatorCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapStringExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapVariableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tI_mapVariableExp_referredVariable_VariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wC_mapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wC_mapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wC_mapVariableExp_referredVariable_VariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wI_mapVariableExp_referredVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wI_mapVariableExp_referredVariable_HelperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wI_mapVariableExp_referredVariable_VariableDeclarationEClass = null;

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
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();

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
	public EClass getTC_mapBinding() {
		return tC_mapBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Atl_atlBinding() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Atl_atlExpression() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Atl_atlOutPatternElement() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapBinding_Primitive_propertyName() {
		return (EAttribute)tC_mapBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Qvtr_qvtrExpression() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Qvtr_qvtrPart() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapBinding_Qvtr_qvtrTemplate() {
		return (EReference)tC_mapBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapBooleanExp() {
		return tC_mapBooleanExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapBooleanExp_Primitive_symbol() {
		return (EAttribute)tC_mapBooleanExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapHelper() {
		return tC_mapHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapHelper_Attribute() {
		return tC_mapHelper_AttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Atl_atlDefinition() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Atl_atlExpression() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Atl_atlFeature() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Atl_atlModule() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Atl_atlType() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Invocation_mapHelper_Context() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapHelper_Attribute_Primitive_attributeName() {
		return (EAttribute)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Qvtr_qvtrExpression() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Attribute_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapHelper_AttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapHelper_Context() {
		return tC_mapHelper_ContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Atl_atlContext() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Atl_atlDefinition() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Atl_atlHelper() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Atl_atlReturnType() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Invocation_mapVariable() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Qvtr_qvtrFunction() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Context_Qvtr_qvtrParameter() {
		return (EReference)tC_mapHelper_ContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapHelper_Operation() {
		return tC_mapHelper_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Atl_atlDefinition() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Atl_atlExpression() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Atl_atlFeature() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Atl_atlModule() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Atl_atlType() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Invocation_mapHelper_Context() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapHelper_Operation_Primitive_operationName() {
		return (EAttribute)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Qvtr_qvtrExpression() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapHelper_Operation_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapHelper_OperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapIfExp() {
		return tC_mapIfExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Atl_atlCondition() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Atl_atlElse() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Atl_atlThen() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Qvtr_qvtrCondition() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Qvtr_qvtrElse() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapIfExp_Qvtr_qvtrThen() {
		return (EReference)tC_mapIfExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapInPattern() {
		return tC_mapInPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Atl_atlModel() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Atl_atlModule() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Atl_atlPattern() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Atl_atlRule() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Qvtr_qvtrDomain() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Qvtr_qvtrRelation() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_Qvtr_qvtrTypedModel() {
		return (EReference)tC_mapInPatternEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapInPattern_Status() {
		return (EAttribute)tC_mapInPatternEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapInPattern_filter() {
		return tC_mapInPattern_filterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Atl_atlExpression() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Atl_atlPattern() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Atl_atlRule() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Qvtr_p() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Qvtr_qvtrDomain() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Qvtr_qvtrExpression() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Qvtr_qvtrRelation() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapInPattern_filter_Qvtr_w() {
		return (EReference)tC_mapInPattern_filterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapIntegerExp() {
		return tC_mapIntegerExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapIntegerExp_Primitive_symbol() {
		return (EAttribute)tC_mapIntegerExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapMatchedRule() {
		return tC_mapMatchedRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_Atl_atlModule() {
		return (EReference)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_Atl_matchedRule() {
		return (EReference)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapMatchedRule_Primitive_ruleName() {
		return (EAttribute)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_Qvtr_qvtrRelation() {
		return (EReference)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapMatchedRule_Status() {
		return (EAttribute)tC_mapMatchedRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapMatchedRule_super() {
		return tC_mapMatchedRule_superEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_super_Atl_atlChildRule() {
		return (EReference)tC_mapMatchedRule_superEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_super_Atl_atlSuperRule() {
		return (EReference)tC_mapMatchedRule_superEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_super_Qvtr_qvtrOverriddenRelation() {
		return (EReference)tC_mapMatchedRule_superEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapMatchedRule_super_Qvtr_qvtrOverridesRelation() {
		return (EReference)tC_mapMatchedRule_superEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapModule() {
		return tC_mapModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapModule_Atl_atlModule() {
		return (EReference)tC_mapModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapModule_Primitive_txName() {
		return (EAttribute)tC_mapModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapModule_Qvtr__3() {
		return (EReference)tC_mapModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapModule_Qvtr__4() {
		return (EReference)tC_mapModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapModule_Qvtr__5() {
		return (EReference)tC_mapModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapModule_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapModule_Status() {
		return (EAttribute)tC_mapModuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapNavigationOrAttributeCallExp() {
		return tC_mapNavigationOrAttributeCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapNavigationOrAttributeCallExp_Helper() {
		return tC_mapNavigationOrAttributeCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlAttributes() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlModule() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlSource() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapNavigationOrAttributeCallExp_Helper_Primitive_propertyName() {
		return (EAttribute)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrOperation() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSource() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSourceArgument() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrThisVariable() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapNavigationOrAttributeCallExp_Property() {
		return tC_mapNavigationOrAttributeCallExp_PropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlAttributes() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlModule() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlSource() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapNavigationOrAttributeCallExp_Property_Primitive_propertyName() {
		return (EAttribute)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrProperty() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrSource() {
		return (EReference)tC_mapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOclExpression() {
		return tC_mapOclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOclMetamodel() {
		return tC_mapOclMetamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclMetamodel_Atl_oclMetamodel() {
		return (EReference)tC_mapOclMetamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOclMetamodel_Primitive_tmName() {
		return (EAttribute)tC_mapOclMetamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclMetamodel_Qvtr_qvtrTypedModel() {
		return (EReference)tC_mapOclMetamodelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOclMetamodel_Status() {
		return (EAttribute)tC_mapOclMetamodelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOclModel_IN() {
		return tC_mapOclModel_INEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_IN_Atl_atlModule() {
		return (EReference)tC_mapOclModel_INEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_IN_Atl_oclMetamodel() {
		return (EReference)tC_mapOclModel_INEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_IN_Atl_oclModel() {
		return (EReference)tC_mapOclModel_INEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOclModel_IN_Primitive_tmName() {
		return (EAttribute)tC_mapOclModel_INEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_IN_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapOclModel_INEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_IN_Qvtr_qvtrTypedModel() {
		return (EReference)tC_mapOclModel_INEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOclModel_OUT() {
		return tC_mapOclModel_OUTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_OUT_Atl_atlModule() {
		return (EReference)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_OUT_Atl_oclMetamodel() {
		return (EReference)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_OUT_Atl_oclModel() {
		return (EReference)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOclModel_OUT_Primitive_tmName() {
		return (EAttribute)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_OUT_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOclModel_OUT_Qvtr_qvtrTypedModel() {
		return (EReference)tC_mapOclModel_OUTEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOperationCallExp() {
		return tC_mapOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOperationCallExp_Helper() {
		return tC_mapOperationCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Atl_atlModule() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Atl_atlOperations() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Atl_atlSource() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOperationCallExp_Helper_Primitive_operationName() {
		return (EAttribute)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Qvtr_qvtrOperation() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Qvtr_qvtrSource() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Qvtr_qvtrSourceArgument() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Qvtr_qvtrThisVariable() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Helper_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapOperationCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOperationCallExp_Operation() {
		return tC_mapOperationCallExp_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Operation_Atl_atlModule() {
		return (EReference)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Operation_Atl_atlOperations() {
		return (EReference)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Operation_Atl_atlSource() {
		return (EReference)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOperationCallExp_Operation_Primitive_operationName() {
		return (EAttribute)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Operation_Qvtr_qvtrOperation() {
		return (EReference)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_Operation_Qvtr_qvtrSource() {
		return (EReference)tC_mapOperationCallExp_OperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOperationCallExp_argument() {
		return tC_mapOperationCallExp_argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_argument_Atl_atlArgument() {
		return (EReference)tC_mapOperationCallExp_argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_argument_Atl_atlParent() {
		return (EReference)tC_mapOperationCallExp_argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_argument_Qvtr_qvtrArgument() {
		return (EReference)tC_mapOperationCallExp_argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperationCallExp_argument_Qvtr_qvtrParent() {
		return (EReference)tC_mapOperationCallExp_argumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOperatorCallExp() {
		return tC_mapOperatorCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperatorCallExp_Atl_atlModule() {
		return (EReference)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperatorCallExp_Atl_atlSource() {
		return (EReference)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOperatorCallExp_Primitive_operationName() {
		return (EAttribute)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperatorCallExp_Qvtr_qvtrOperation() {
		return (EReference)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperatorCallExp_Qvtr_qvtrSource() {
		return (EReference)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOperatorCallExp_Qvtr_qvtrTransformation() {
		return (EReference)tC_mapOperatorCallExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapOutPattern() {
		return tC_mapOutPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Atl_atlModule() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Atl_atlPattern() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Atl_atlRule() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Qvtr_qvtrDomain() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Qvtr_qvtrRelation() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapOutPattern_Qvtr_qvtrTypedModel() {
		return (EReference)tC_mapOutPatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapOutPattern_Status() {
		return (EAttribute)tC_mapOutPatternEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapSimpleInPatternElement() {
		return tC_mapSimpleInPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Atl_atlElement() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Atl_atlPattern() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Atl_atlRule() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Invocation_mapVariable() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapSimpleInPatternElement_Primitive_elementName() {
		return (EAttribute)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain1() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrPattern() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrRelation() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrTemplate() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleInPatternElement_Qvtr_qvtrVariable() {
		return (EReference)tC_mapSimpleInPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapSimpleOutPatternElement() {
		return tC_mapSimpleOutPatternElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Atl_atlElement() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Atl_atlPattern() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Atl_atlRule() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Invocation_mapVariable() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapSimpleOutPatternElement_Primitive_elementName() {
		return (EAttribute)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain1() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrPattern() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrRelation() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrTemplate() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapSimpleOutPatternElement_Qvtr_qvtrVariable() {
		return (EReference)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapSimpleOutPatternElement_Status() {
		return (EAttribute)tC_mapSimpleOutPatternElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapStringExp() {
		return tC_mapStringExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapStringExp_Primitive_symbol() {
		return (EAttribute)tC_mapStringExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapVariable() {
		return tC_mapVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariable_Atl_atlVariable() {
		return (EReference)tC_mapVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariable_Qvtr_qvtrVariable() {
		return (EReference)tC_mapVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapVariableExp() {
		return tC_mapVariableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_Atl_atlVariable() {
		return (EReference)tC_mapVariableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_Invocation_mapVariableExp_referredVariable() {
		return (EReference)tC_mapVariableExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTC_mapVariableExp_Primitive_varName() {
		return (EAttribute)tC_mapVariableExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapVariableExp_referredVariable() {
		return tC_mapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Atl_atlExpression1() {
		return (EReference)tC_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Qvtr_qvtrExpression1() {
		return (EReference)tC_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapVariableExp_referredVariable_Helper() {
		return tC_mapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Atl_atlExpression() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Atl_atlHelper() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Atl_atlVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Invocation_mapVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrExpression() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTC_mapVariableExp_referredVariable_VariableDeclaration() {
		return tC_mapVariableExp_referredVariable_VariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlExpression() {
		return (EReference)tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_VariableDeclaration_Invocation_mapVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrExpression() {
		return (EReference)tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrVariable() {
		return (EReference)tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapBooleanExp() {
		return tI_mapBooleanExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapHelper() {
		return tI_mapHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTI_mapHelper_Atl_atlHelper() {
		return (EReference)tI_mapHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTI_mapHelper_Qvtr_qvtrFunction() {
		return (EReference)tI_mapHelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTI_mapHelper_Status() {
		return (EAttribute)tI_mapHelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapHelper_Attribute() {
		return tI_mapHelper_AttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapHelper_Operation() {
		return tI_mapHelper_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapIfExp() {
		return tI_mapIfExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapIntegerExp() {
		return tI_mapIntegerExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapNavigationOrAttributeCallExp() {
		return tI_mapNavigationOrAttributeCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapNavigationOrAttributeCallExp_Helper() {
		return tI_mapNavigationOrAttributeCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapNavigationOrAttributeCallExp_Property() {
		return tI_mapNavigationOrAttributeCallExp_PropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapOclExpression() {
		return tI_mapOclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTI_mapOclExpression_Atl_atlExpression() {
		return (EReference)tI_mapOclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTI_mapOclExpression_Qvtr_qvtrExpression() {
		return (EReference)tI_mapOclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTI_mapOclExpression_Status() {
		return (EAttribute)tI_mapOclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapOperationCallExp() {
		return tI_mapOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapOperationCallExp_Helper() {
		return tI_mapOperationCallExp_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapOperationCallExp_Operation() {
		return tI_mapOperationCallExp_OperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapOperatorCallExp() {
		return tI_mapOperatorCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapStringExp() {
		return tI_mapStringExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapVariableExp() {
		return tI_mapVariableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapVariableExp_referredVariable() {
		return tI_mapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTI_mapVariableExp_referredVariable_Status() {
		return (EAttribute)tI_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapVariableExp_referredVariable_Helper() {
		return tI_mapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTI_mapVariableExp_referredVariable_VariableDeclaration() {
		return tI_mapVariableExp_referredVariable_VariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWC_mapVariableExp_referredVariable() {
		return wC_mapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWC_mapVariableExp_referredVariable_Helper() {
		return wC_mapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWC_mapVariableExp_referredVariable_VariableDeclaration() {
		return wC_mapVariableExp_referredVariable_VariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWI_mapVariableExp_referredVariable() {
		return wI_mapVariableExp_referredVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWI_mapVariableExp_referredVariable_Atl_atlExpression() {
		return (EReference)wI_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWI_mapVariableExp_referredVariable_Qvtr_qvtrExpression() {
		return (EReference)wI_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWI_mapVariableExp_referredVariable_Result() {
		return (EReference)wI_mapVariableExp_referredVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWI_mapVariableExp_referredVariable_Helper() {
		return wI_mapVariableExp_referredVariable_HelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWI_mapVariableExp_referredVariable_VariableDeclaration() {
		return wI_mapVariableExp_referredVariable_VariableDeclarationEClass;
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
		tC_mapBindingEClass = createEClass(TC_MAP_BINDING);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__ATL_ATL_BINDING);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__ATL_ATL_EXPRESSION);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT);
		createEAttribute(tC_mapBindingEClass, TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__QVTR_QVTR_PART);
		createEReference(tC_mapBindingEClass, TC_MAP_BINDING__QVTR_QVTR_TEMPLATE);

		tC_mapBooleanExpEClass = createEClass(TC_MAP_BOOLEAN_EXP);
		createEAttribute(tC_mapBooleanExpEClass, TC_MAP_BOOLEAN_EXP__PRIMITIVE_SYMBOL);

		tC_mapHelperEClass = createEClass(TC_MAP_HELPER);

		tC_mapHelper_AttributeEClass = createEClass(TC_MAP_HELPER_ATTRIBUTE);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_DEFINITION);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_EXPRESSION);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_FEATURE);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_MODULE);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__ATL_ATL_TYPE);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__INVOCATION_MAP_HELPER_CONTEXT);
		createEAttribute(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__PRIMITIVE_ATTRIBUTE_NAME);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapHelper_AttributeEClass, TC_MAP_HELPER_ATTRIBUTE__QVTR_QVTR_TRANSFORMATION);

		tC_mapHelper_ContextEClass = createEClass(TC_MAP_HELPER_CONTEXT);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION);
		createEReference(tC_mapHelper_ContextEClass, TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER);

		tC_mapHelper_OperationEClass = createEClass(TC_MAP_HELPER_OPERATION);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__ATL_ATL_DEFINITION);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__ATL_ATL_EXPRESSION);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__ATL_ATL_FEATURE);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__ATL_ATL_MODULE);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__ATL_ATL_TYPE);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__INVOCATION_MAP_HELPER_CONTEXT);
		createEAttribute(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__PRIMITIVE_OPERATION_NAME);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapHelper_OperationEClass, TC_MAP_HELPER_OPERATION__QVTR_QVTR_TRANSFORMATION);

		tC_mapIfExpEClass = createEClass(TC_MAP_IF_EXP);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__ATL_ATL_CONDITION);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__ATL_ATL_ELSE);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__ATL_ATL_THEN);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__QVTR_QVTR_CONDITION);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__QVTR_QVTR_ELSE);
		createEReference(tC_mapIfExpEClass, TC_MAP_IF_EXP__QVTR_QVTR_THEN);

		tC_mapInPatternEClass = createEClass(TC_MAP_IN_PATTERN);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__ATL_ATL_MODEL);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__ATL_ATL_MODULE);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__ATL_ATL_PATTERN);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__ATL_ATL_RULE);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__QVTR_QVTR_DOMAIN);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__QVTR_QVTR_RELATION);
		createEReference(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__QVTR_QVTR_TYPED_MODEL);
		createEAttribute(tC_mapInPatternEClass, TC_MAP_IN_PATTERN__STATUS);

		tC_mapInPattern_filterEClass = createEClass(TC_MAP_IN_PATTERN_FILTER);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__ATL_ATL_EXPRESSION);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__ATL_ATL_PATTERN);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__ATL_ATL_RULE);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__QVTR_P);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_DOMAIN);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__QVTR_QVTR_RELATION);
		createEReference(tC_mapInPattern_filterEClass, TC_MAP_IN_PATTERN_FILTER__QVTR_W);

		tC_mapIntegerExpEClass = createEClass(TC_MAP_INTEGER_EXP);
		createEAttribute(tC_mapIntegerExpEClass, TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL);

		tC_mapMatchedRuleEClass = createEClass(TC_MAP_MATCHED_RULE);
		createEReference(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__ATL_ATL_MODULE);
		createEReference(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__ATL_MATCHED_RULE);
		createEAttribute(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__PRIMITIVE_RULE_NAME);
		createEReference(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__QVTR_QVTR_RELATION);
		createEReference(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__QVTR_QVTR_TRANSFORMATION);
		createEAttribute(tC_mapMatchedRuleEClass, TC_MAP_MATCHED_RULE__STATUS);

		tC_mapMatchedRule_superEClass = createEClass(TC_MAP_MATCHED_RULE_SUPER);
		createEReference(tC_mapMatchedRule_superEClass, TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_CHILD_RULE);
		createEReference(tC_mapMatchedRule_superEClass, TC_MAP_MATCHED_RULE_SUPER__ATL_ATL_SUPER_RULE);
		createEReference(tC_mapMatchedRule_superEClass, TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDDEN_RELATION);
		createEReference(tC_mapMatchedRule_superEClass, TC_MAP_MATCHED_RULE_SUPER__QVTR_QVTR_OVERRIDES_RELATION);

		tC_mapModuleEClass = createEClass(TC_MAP_MODULE);
		createEReference(tC_mapModuleEClass, TC_MAP_MODULE__ATL_ATL_MODULE);
		createEAttribute(tC_mapModuleEClass, TC_MAP_MODULE__PRIMITIVE_TX_NAME);
		createEReference(tC_mapModuleEClass, TC_MAP_MODULE__QVTR_3);
		createEReference(tC_mapModuleEClass, TC_MAP_MODULE__QVTR_4);
		createEReference(tC_mapModuleEClass, TC_MAP_MODULE__QVTR_5);
		createEReference(tC_mapModuleEClass, TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION);
		createEAttribute(tC_mapModuleEClass, TC_MAP_MODULE__STATUS);

		tC_mapNavigationOrAttributeCallExpEClass = createEClass(TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP);

		tC_mapNavigationOrAttributeCallExp_HelperEClass = createEClass(TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_ATTRIBUTES);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_MODULE);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__ATL_ATL_SOURCE);
		createEAttribute(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__PRIMITIVE_PROPERTY_NAME);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_OPERATION);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE);
		createEReference(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION);

		tC_mapNavigationOrAttributeCallExp_PropertyEClass = createEClass(TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY);
		createEReference(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__ATL_ATL_ATTRIBUTES);
		createEReference(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__ATL_ATL_MODULE);
		createEReference(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__ATL_ATL_SOURCE);
		createEAttribute(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__PRIMITIVE_PROPERTY_NAME);
		createEReference(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__QVTR_QVTR_PROPERTY);
		createEReference(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__QVTR_QVTR_SOURCE);

		tC_mapOclExpressionEClass = createEClass(TC_MAP_OCL_EXPRESSION);

		tC_mapOclMetamodelEClass = createEClass(TC_MAP_OCL_METAMODEL);
		createEReference(tC_mapOclMetamodelEClass, TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL);
		createEAttribute(tC_mapOclMetamodelEClass, TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME);
		createEReference(tC_mapOclMetamodelEClass, TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL);
		createEAttribute(tC_mapOclMetamodelEClass, TC_MAP_OCL_METAMODEL__STATUS);

		tC_mapOclModel_INEClass = createEClass(TC_MAP_OCL_MODEL_IN);
		createEReference(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE);
		createEReference(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL);
		createEReference(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL);
		createEAttribute(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME);
		createEReference(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION);
		createEReference(tC_mapOclModel_INEClass, TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL);

		tC_mapOclModel_OUTEClass = createEClass(TC_MAP_OCL_MODEL_OUT);
		createEReference(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__ATL_ATL_MODULE);
		createEReference(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__ATL_OCL_METAMODEL);
		createEReference(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__ATL_OCL_MODEL);
		createEAttribute(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__PRIMITIVE_TM_NAME);
		createEReference(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__QVTR_QVTR_TRANSFORMATION);
		createEReference(tC_mapOclModel_OUTEClass, TC_MAP_OCL_MODEL_OUT__QVTR_QVTR_TYPED_MODEL);

		tC_mapOperationCallExpEClass = createEClass(TC_MAP_OPERATION_CALL_EXP);

		tC_mapOperationCallExp_HelperEClass = createEClass(TC_MAP_OPERATION_CALL_EXP_HELPER);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__ATL_ATL_MODULE);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__ATL_ATL_OPERATIONS);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__ATL_ATL_SOURCE);
		createEAttribute(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__PRIMITIVE_OPERATION_NAME);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__QVTR_QVTR_OPERATION);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__QVTR_QVTR_SOURCE);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__QVTR_QVTR_SOURCE_ARGUMENT);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__QVTR_QVTR_THIS_VARIABLE);
		createEReference(tC_mapOperationCallExp_HelperEClass, TC_MAP_OPERATION_CALL_EXP_HELPER__QVTR_QVTR_TRANSFORMATION);

		tC_mapOperationCallExp_OperationEClass = createEClass(TC_MAP_OPERATION_CALL_EXP_OPERATION);
		createEReference(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_MODULE);
		createEReference(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_OPERATIONS);
		createEReference(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__ATL_ATL_SOURCE);
		createEAttribute(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__PRIMITIVE_OPERATION_NAME);
		createEReference(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_OPERATION);
		createEReference(tC_mapOperationCallExp_OperationEClass, TC_MAP_OPERATION_CALL_EXP_OPERATION__QVTR_QVTR_SOURCE);

		tC_mapOperationCallExp_argumentEClass = createEClass(TC_MAP_OPERATION_CALL_EXP_ARGUMENT);
		createEReference(tC_mapOperationCallExp_argumentEClass, TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT);
		createEReference(tC_mapOperationCallExp_argumentEClass, TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT);
		createEReference(tC_mapOperationCallExp_argumentEClass, TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT);
		createEReference(tC_mapOperationCallExp_argumentEClass, TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT);

		tC_mapOperatorCallExpEClass = createEClass(TC_MAP_OPERATOR_CALL_EXP);
		createEReference(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_MODULE);
		createEReference(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__ATL_ATL_SOURCE);
		createEAttribute(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__PRIMITIVE_OPERATION_NAME);
		createEReference(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_OPERATION);
		createEReference(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_SOURCE);
		createEReference(tC_mapOperatorCallExpEClass, TC_MAP_OPERATOR_CALL_EXP__QVTR_QVTR_TRANSFORMATION);

		tC_mapOutPatternEClass = createEClass(TC_MAP_OUT_PATTERN);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__ATL_ATL_MODULE);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__ATL_ATL_PATTERN);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__ATL_ATL_RULE);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__QVTR_QVTR_DOMAIN);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__QVTR_QVTR_RELATION);
		createEReference(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__QVTR_QVTR_TYPED_MODEL);
		createEAttribute(tC_mapOutPatternEClass, TC_MAP_OUT_PATTERN__STATUS);

		tC_mapSimpleInPatternElementEClass = createEClass(TC_MAP_SIMPLE_IN_PATTERN_ELEMENT);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_ELEMENT);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_PATTERN);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__ATL_ATL_RULE);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE);
		createEAttribute(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_PATTERN);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_RELATION);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE);
		createEReference(tC_mapSimpleInPatternElementEClass, TC_MAP_SIMPLE_IN_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE);

		tC_mapSimpleOutPatternElementEClass = createEClass(TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__ATL_ATL_ELEMENT);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__ATL_ATL_PATTERN);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__ATL_ATL_RULE);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__INVOCATION_MAP_VARIABLE);
		createEAttribute(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__PRIMITIVE_ELEMENT_NAME);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_DOMAIN1);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_PATTERN);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_RELATION);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_TEMPLATE);
		createEReference(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__QVTR_QVTR_VARIABLE);
		createEAttribute(tC_mapSimpleOutPatternElementEClass, TC_MAP_SIMPLE_OUT_PATTERN_ELEMENT__STATUS);

		tC_mapStringExpEClass = createEClass(TC_MAP_STRING_EXP);
		createEAttribute(tC_mapStringExpEClass, TC_MAP_STRING_EXP__PRIMITIVE_SYMBOL);

		tC_mapVariableEClass = createEClass(TC_MAP_VARIABLE);
		createEReference(tC_mapVariableEClass, TC_MAP_VARIABLE__ATL_ATL_VARIABLE);
		createEReference(tC_mapVariableEClass, TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE);

		tC_mapVariableExpEClass = createEClass(TC_MAP_VARIABLE_EXP);
		createEReference(tC_mapVariableExpEClass, TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE);
		createEReference(tC_mapVariableExpEClass, TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEAttribute(tC_mapVariableExpEClass, TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME);

		tC_mapVariableExp_referredVariableEClass = createEClass(TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEReference(tC_mapVariableExp_referredVariableEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1);
		createEReference(tC_mapVariableExp_referredVariableEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1);

		tC_mapVariableExp_referredVariable_HelperEClass = createEClass(TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__ATL_ATL_EXPRESSION);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__ATL_ATL_HELPER);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__ATL_ATL_VARIABLE);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__INVOCATION_MAP_VARIABLE);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapVariableExp_referredVariable_HelperEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__QVTR_QVTR_VARIABLE);

		tC_mapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);
		createEReference(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION);
		createEReference(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE);
		createEReference(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE);
		createEReference(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION);
		createEReference(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE);

		tI_mapBooleanExpEClass = createEClass(TI_MAP_BOOLEAN_EXP);

		tI_mapHelperEClass = createEClass(TI_MAP_HELPER);
		createEReference(tI_mapHelperEClass, TI_MAP_HELPER__ATL_ATL_HELPER);
		createEReference(tI_mapHelperEClass, TI_MAP_HELPER__QVTR_QVTR_FUNCTION);
		createEAttribute(tI_mapHelperEClass, TI_MAP_HELPER__STATUS);

		tI_mapHelper_AttributeEClass = createEClass(TI_MAP_HELPER_ATTRIBUTE);

		tI_mapHelper_OperationEClass = createEClass(TI_MAP_HELPER_OPERATION);

		tI_mapIfExpEClass = createEClass(TI_MAP_IF_EXP);

		tI_mapIntegerExpEClass = createEClass(TI_MAP_INTEGER_EXP);

		tI_mapNavigationOrAttributeCallExpEClass = createEClass(TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP);

		tI_mapNavigationOrAttributeCallExp_HelperEClass = createEClass(TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER);

		tI_mapNavigationOrAttributeCallExp_PropertyEClass = createEClass(TI_MAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY);

		tI_mapOclExpressionEClass = createEClass(TI_MAP_OCL_EXPRESSION);
		createEReference(tI_mapOclExpressionEClass, TI_MAP_OCL_EXPRESSION__ATL_ATL_EXPRESSION);
		createEReference(tI_mapOclExpressionEClass, TI_MAP_OCL_EXPRESSION__QVTR_QVTR_EXPRESSION);
		createEAttribute(tI_mapOclExpressionEClass, TI_MAP_OCL_EXPRESSION__STATUS);

		tI_mapOperationCallExpEClass = createEClass(TI_MAP_OPERATION_CALL_EXP);

		tI_mapOperationCallExp_HelperEClass = createEClass(TI_MAP_OPERATION_CALL_EXP_HELPER);

		tI_mapOperationCallExp_OperationEClass = createEClass(TI_MAP_OPERATION_CALL_EXP_OPERATION);

		tI_mapOperatorCallExpEClass = createEClass(TI_MAP_OPERATOR_CALL_EXP);

		tI_mapStringExpEClass = createEClass(TI_MAP_STRING_EXP);

		tI_mapVariableExpEClass = createEClass(TI_MAP_VARIABLE_EXP);

		tI_mapVariableExp_referredVariableEClass = createEClass(TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEAttribute(tI_mapVariableExp_referredVariableEClass, TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__STATUS);

		tI_mapVariableExp_referredVariable_HelperEClass = createEClass(TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);

		tI_mapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(TI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);

		wC_mapVariableExp_referredVariableEClass = createEClass(WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE);

		wC_mapVariableExp_referredVariable_HelperEClass = createEClass(WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);

		wC_mapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(WC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);

		wI_mapVariableExp_referredVariableEClass = createEClass(WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEReference(wI_mapVariableExp_referredVariableEClass, WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION);
		createEReference(wI_mapVariableExp_referredVariableEClass, WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION);
		createEReference(wI_mapVariableExp_referredVariableEClass, WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT);

		wI_mapVariableExp_referredVariable_HelperEClass = createEClass(WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);

		wI_mapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);
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
		ATLPackage theATLPackage = (ATLPackage)EPackage.Registry.INSTANCE.getEPackage(ATLPackage.eNS_URI);
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTtemplatePackage theQVTtemplatePackage = (QVTtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtemplatePackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tC_mapBooleanExpEClass.getESuperTypes().add(this.getTI_mapBooleanExp());
		tC_mapHelperEClass.getESuperTypes().add(this.getTI_mapHelper());
		tC_mapHelper_AttributeEClass.getESuperTypes().add(this.getTI_mapHelper_Attribute());
		tC_mapHelper_OperationEClass.getESuperTypes().add(this.getTI_mapHelper_Operation());
		tC_mapIfExpEClass.getESuperTypes().add(this.getTI_mapIfExp());
		tC_mapIntegerExpEClass.getESuperTypes().add(this.getTI_mapIntegerExp());
		tC_mapNavigationOrAttributeCallExpEClass.getESuperTypes().add(this.getTI_mapNavigationOrAttributeCallExp());
		tC_mapNavigationOrAttributeCallExp_HelperEClass.getESuperTypes().add(this.getTI_mapNavigationOrAttributeCallExp_Helper());
		tC_mapNavigationOrAttributeCallExp_PropertyEClass.getESuperTypes().add(this.getTI_mapNavigationOrAttributeCallExp_Property());
		tC_mapOclExpressionEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tC_mapOperationCallExpEClass.getESuperTypes().add(this.getTI_mapOperationCallExp());
		tC_mapOperationCallExp_HelperEClass.getESuperTypes().add(this.getTI_mapOperationCallExp_Helper());
		tC_mapOperationCallExp_OperationEClass.getESuperTypes().add(this.getTI_mapOperationCallExp_Operation());
		tC_mapOperatorCallExpEClass.getESuperTypes().add(this.getTI_mapOperatorCallExp());
		tC_mapStringExpEClass.getESuperTypes().add(this.getTI_mapStringExp());
		tC_mapVariableExpEClass.getESuperTypes().add(this.getTI_mapVariableExp());
		tC_mapVariableExp_referredVariableEClass.getESuperTypes().add(this.getTI_mapVariableExp_referredVariable());
		tC_mapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getTI_mapVariableExp_referredVariable_Helper());
		tC_mapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getTI_mapVariableExp_referredVariable_VariableDeclaration());
		tI_mapBooleanExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapHelper_AttributeEClass.getESuperTypes().add(this.getTI_mapHelper());
		tI_mapHelper_OperationEClass.getESuperTypes().add(this.getTI_mapHelper());
		tI_mapIfExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapIntegerExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapNavigationOrAttributeCallExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapNavigationOrAttributeCallExp_HelperEClass.getESuperTypes().add(this.getTI_mapNavigationOrAttributeCallExp());
		tI_mapNavigationOrAttributeCallExp_PropertyEClass.getESuperTypes().add(this.getTI_mapNavigationOrAttributeCallExp());
		tI_mapOperationCallExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapOperationCallExp_HelperEClass.getESuperTypes().add(this.getTI_mapOperationCallExp());
		tI_mapOperationCallExp_OperationEClass.getESuperTypes().add(this.getTI_mapOperationCallExp());
		tI_mapOperatorCallExpEClass.getESuperTypes().add(this.getTI_mapOperationCallExp());
		tI_mapStringExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapVariableExpEClass.getESuperTypes().add(this.getTI_mapOclExpression());
		tI_mapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getTI_mapVariableExp_referredVariable());
		tI_mapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getTI_mapVariableExp_referredVariable());
		wC_mapVariableExp_referredVariableEClass.getESuperTypes().add(this.getWI_mapVariableExp_referredVariable());
		wC_mapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getWI_mapVariableExp_referredVariable_Helper());
		wC_mapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getWI_mapVariableExp_referredVariable_VariableDeclaration());
		wI_mapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getWI_mapVariableExp_referredVariable());
		wI_mapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getWI_mapVariableExp_referredVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(tC_mapBindingEClass, TC_mapBinding.class, "TC_mapBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapBinding_Atl_atlBinding(), theATLPackage.getBinding(), null, "atl_atlBinding", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapBinding_Atl_atlExpression(), theOCLPackage.getOclExpression(), null, "atl_atlExpression", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapBinding_Atl_atlOutPatternElement(), theATLPackage.getSimpleOutPatternElement(), null, "atl_atlOutPatternElement", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapBinding_Primitive_propertyName(), ecorePackage.getEString(), "primitive_propertyName", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapBinding_Qvtr_qvtrExpression(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapBinding_Qvtr_qvtrPart(), theQVTtemplatePackage.getPropertyTemplateItem(), null, "qvtr_qvtrPart", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapBinding_Qvtr_qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "qvtr_qvtrTemplate", null, 1, 1, TC_mapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapBooleanExpEClass, TC_mapBooleanExp.class, "TC_mapBooleanExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTC_mapBooleanExp_Primitive_symbol(), ecorePackage.getEBoolean(), "primitive_symbol", null, 1, 1, TC_mapBooleanExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapHelperEClass, TC_mapHelper.class, "TC_mapHelper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tC_mapHelper_AttributeEClass, TC_mapHelper_Attribute.class, "TC_mapHelper_Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapHelper_Attribute_Atl_atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "atl_atlDefinition", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Atl_atlExpression(), theOCLPackage.getOclExpression(), null, "atl_atlExpression", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Atl_atlFeature(), theOCLPackage.getAttribute(), null, "atl_atlFeature", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Atl_atlType(), theOCLPackage.getOclType(), null, "atl_atlType", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Invocation_mapHelper_Context(), this.getTC_mapHelper_Context(), null, "invocation_mapHelper_Context", null, 0, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapHelper_Attribute_Primitive_attributeName(), ecorePackage.getEString(), "primitive_attributeName", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Qvtr_qvtrExpression(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Attribute_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapHelper_ContextEClass, TC_mapHelper_Context.class, "TC_mapHelper_Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapHelper_Context_Atl_atlContext(), theOCLPackage.getOclContextDefinition(), null, "atl_atlContext", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Atl_atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "atl_atlDefinition", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Atl_atlHelper(), theATLPackage.getHelper(), null, "atl_atlHelper", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Atl_atlReturnType(), theOCLPackage.getOclType(), null, "atl_atlReturnType", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Invocation_mapVariable(), this.getTC_mapVariable(), null, "invocation_mapVariable", null, 0, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Qvtr_qvtrFunction(), theQVTbasePackage.getFunction(), null, "qvtr_qvtrFunction", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Context_Qvtr_qvtrParameter(), theQVTbasePackage.getFunctionParameter(), null, "qvtr_qvtrParameter", null, 1, 1, TC_mapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapHelper_OperationEClass, TC_mapHelper_Operation.class, "TC_mapHelper_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapHelper_Operation_Atl_atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "atl_atlDefinition", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Atl_atlExpression(), theOCLPackage.getOclExpression(), null, "atl_atlExpression", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Atl_atlFeature(), theOCLPackage.getOperation(), null, "atl_atlFeature", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Atl_atlType(), theOCLPackage.getOclType(), null, "atl_atlType", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Invocation_mapHelper_Context(), this.getTC_mapHelper_Context(), null, "invocation_mapHelper_Context", null, 0, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapHelper_Operation_Primitive_operationName(), ecorePackage.getEString(), "primitive_operationName", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Qvtr_qvtrExpression(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapHelper_Operation_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapIfExpEClass, TC_mapIfExp.class, "TC_mapIfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapIfExp_Atl_atlCondition(), theOCLPackage.getOclExpression(), null, "atl_atlCondition", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapIfExp_Atl_atlElse(), theOCLPackage.getOclExpression(), null, "atl_atlElse", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapIfExp_Atl_atlThen(), theOCLPackage.getOclExpression(), null, "atl_atlThen", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapIfExp_Qvtr_qvtrCondition(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrCondition", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapIfExp_Qvtr_qvtrElse(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrElse", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapIfExp_Qvtr_qvtrThen(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrThen", null, 1, 1, TC_mapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapInPatternEClass, TC_mapInPattern.class, "TC_mapInPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapInPattern_Atl_atlModel(), theOCLPackage.getOclModel(), null, "atl_atlModel", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Atl_atlPattern(), theATLPackage.getInPattern(), null, "atl_atlPattern", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Atl_atlRule(), theATLPackage.getMatchedRule(), null, "atl_atlRule", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Qvtr_qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_Qvtr_qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "qvtr_qvtrTypedModel", null, 1, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapInPattern_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapInPattern_filterEClass, TC_mapInPattern_filter.class, "TC_mapInPattern_filter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapInPattern_filter_Atl_atlExpression(), theOCLPackage.getOclExpression(), null, "atl_atlExpression", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Atl_atlPattern(), theATLPackage.getInPattern(), null, "atl_atlPattern", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Atl_atlRule(), theATLPackage.getMatchedRule(), null, "atl_atlRule", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Qvtr_p(), theQVTbasePackage.getPredicate(), null, "qvtr_p", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Qvtr_qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Qvtr_qvtrExpression(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapInPattern_filter_Qvtr_w(), theQVTbasePackage.getPattern(), null, "qvtr_w", null, 1, 1, TC_mapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapIntegerExpEClass, TC_mapIntegerExp.class, "TC_mapIntegerExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTC_mapIntegerExp_Primitive_symbol(), ecorePackage.getEBigInteger(), "primitive_symbol", null, 1, 1, TC_mapIntegerExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapMatchedRuleEClass, TC_mapMatchedRule.class, "TC_mapMatchedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapMatchedRule_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_Atl_matchedRule(), theATLPackage.getMatchedRule(), null, "atl_matchedRule", null, 1, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapMatchedRule_Primitive_ruleName(), ecorePackage.getEString(), "primitive_ruleName", null, 1, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapMatchedRule_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapMatchedRule_superEClass, TC_mapMatchedRule_super.class, "TC_mapMatchedRule_super", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapMatchedRule_super_Atl_atlChildRule(), theATLPackage.getMatchedRule(), null, "atl_atlChildRule", null, 1, 1, TC_mapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_super_Atl_atlSuperRule(), theATLPackage.getMatchedRule(), null, "atl_atlSuperRule", null, 1, 1, TC_mapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_super_Qvtr_qvtrOverriddenRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrOverriddenRelation", null, 1, 1, TC_mapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapMatchedRule_super_Qvtr_qvtrOverridesRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrOverridesRelation", null, 1, 1, TC_mapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapModuleEClass, TC_mapModule.class, "TC_mapModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapModule_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapModule_Primitive_txName(), ecorePackage.getEString(), "primitive_txName", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapModule_Qvtr__3(), thePivotPackage.getPackage(), null, "qvtr__3", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapModule_Qvtr__4(), theQVTrelationPackage.getRelationModel(), null, "qvtr__4", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapModule_Qvtr__5(), thePivotPackage.getParameterVariable(), null, "qvtr__5", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapModule_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapModule_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapNavigationOrAttributeCallExpEClass, TC_mapNavigationOrAttributeCallExp.class, "TC_mapNavigationOrAttributeCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tC_mapNavigationOrAttributeCallExp_HelperEClass, TC_mapNavigationOrAttributeCallExp_Helper.class, "TC_mapNavigationOrAttributeCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlAttributes(), theOCLPackage.getAttribute(), null, "atl_atlAttributes", null, 0, -1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlSource(), theOCLPackage.getOclExpression(), null, "atl_atlSource", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapNavigationOrAttributeCallExp_Helper_Primitive_propertyName(), ecorePackage.getEString(), "primitive_propertyName", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrOperation(), thePivotPackage.getOperation(), null, "qvtr_qvtrOperation", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSource(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrSource", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrSourceArgument", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrThisVariable(), thePivotPackage.getVariableDeclaration(), null, "qvtr_qvtrThisVariable", null, 0, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapNavigationOrAttributeCallExp_PropertyEClass, TC_mapNavigationOrAttributeCallExp_Property.class, "TC_mapNavigationOrAttributeCallExp_Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlAttributes(), theOCLPackage.getAttribute(), null, "atl_atlAttributes", null, 0, -1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlSource(), theOCLPackage.getOclExpression(), null, "atl_atlSource", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapNavigationOrAttributeCallExp_Property_Primitive_propertyName(), ecorePackage.getEString(), "primitive_propertyName", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrProperty(), thePivotPackage.getProperty(), null, "qvtr_qvtrProperty", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrSource(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrSource", null, 1, 1, TC_mapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOclExpressionEClass, TC_mapOclExpression.class, "TC_mapOclExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tC_mapOclMetamodelEClass, TC_mapOclMetamodel.class, "TC_mapOclMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOclMetamodel_Atl_oclMetamodel(), theOCLPackage.getOclModel(), null, "atl_oclMetamodel", null, 1, 1, TC_mapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOclMetamodel_Primitive_tmName(), ecorePackage.getEString(), "primitive_tmName", null, 1, 1, TC_mapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclMetamodel_Qvtr_qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "qvtr_qvtrTypedModel", null, 1, 1, TC_mapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOclMetamodel_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOclModel_INEClass, TC_mapOclModel_IN.class, "TC_mapOclModel_IN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOclModel_IN_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_IN_Atl_oclMetamodel(), theOCLPackage.getOclModel(), null, "atl_oclMetamodel", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_IN_Atl_oclModel(), theOCLPackage.getOclModel(), null, "atl_oclModel", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOclModel_IN_Primitive_tmName(), ecorePackage.getEString(), "primitive_tmName", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_IN_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_IN_Qvtr_qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "qvtr_qvtrTypedModel", null, 1, 1, TC_mapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOclModel_OUTEClass, TC_mapOclModel_OUT.class, "TC_mapOclModel_OUT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOclModel_OUT_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_OUT_Atl_oclMetamodel(), theOCLPackage.getOclModel(), null, "atl_oclMetamodel", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_OUT_Atl_oclModel(), theOCLPackage.getOclModel(), null, "atl_oclModel", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOclModel_OUT_Primitive_tmName(), ecorePackage.getEString(), "primitive_tmName", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_OUT_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOclModel_OUT_Qvtr_qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "qvtr_qvtrTypedModel", null, 1, 1, TC_mapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOperationCallExpEClass, TC_mapOperationCallExp.class, "TC_mapOperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tC_mapOperationCallExp_HelperEClass, TC_mapOperationCallExp_Helper.class, "TC_mapOperationCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOperationCallExp_Helper_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Atl_atlOperations(), theOCLPackage.getOperation(), null, "atl_atlOperations", null, 0, -1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Atl_atlSource(), theOCLPackage.getOclExpression(), null, "atl_atlSource", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOperationCallExp_Helper_Primitive_operationName(), ecorePackage.getEString(), "primitive_operationName", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Qvtr_qvtrOperation(), thePivotPackage.getOperation(), null, "qvtr_qvtrOperation", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Qvtr_qvtrSource(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrSource", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Qvtr_qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrSourceArgument", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Qvtr_qvtrThisVariable(), thePivotPackage.getVariableDeclaration(), null, "qvtr_qvtrThisVariable", null, 0, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Helper_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOperationCallExp_OperationEClass, TC_mapOperationCallExp_Operation.class, "TC_mapOperationCallExp_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOperationCallExp_Operation_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Operation_Atl_atlOperations(), theOCLPackage.getOperation(), null, "atl_atlOperations", null, 0, -1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Operation_Atl_atlSource(), theOCLPackage.getOclExpression(), null, "atl_atlSource", null, 1, 1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOperationCallExp_Operation_Primitive_operationName(), ecorePackage.getEString(), "primitive_operationName", null, 1, 1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Operation_Qvtr_qvtrOperation(), thePivotPackage.getOperation(), null, "qvtr_qvtrOperation", null, 1, 1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_Operation_Qvtr_qvtrSource(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrSource", null, 1, 1, TC_mapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOperationCallExp_argumentEClass, TC_mapOperationCallExp_argument.class, "TC_mapOperationCallExp_argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOperationCallExp_argument_Atl_atlArgument(), theOCLPackage.getOclExpression(), null, "atl_atlArgument", null, 1, 1, TC_mapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_argument_Atl_atlParent(), theOCLPackage.getOperationCallExp(), null, "atl_atlParent", null, 1, 1, TC_mapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_argument_Qvtr_qvtrArgument(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrArgument", null, 1, 1, TC_mapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperationCallExp_argument_Qvtr_qvtrParent(), thePivotPackage.getOperationCallExp(), null, "qvtr_qvtrParent", null, 1, 1, TC_mapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOperatorCallExpEClass, TC_mapOperatorCallExp.class, "TC_mapOperatorCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOperatorCallExp_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperatorCallExp_Atl_atlSource(), theOCLPackage.getOclExpression(), null, "atl_atlSource", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOperatorCallExp_Primitive_operationName(), ecorePackage.getEString(), "primitive_operationName", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperatorCallExp_Qvtr_qvtrOperation(), thePivotPackage.getOperation(), null, "qvtr_qvtrOperation", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperatorCallExp_Qvtr_qvtrSource(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrSource", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOperatorCallExp_Qvtr_qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "qvtr_qvtrTransformation", null, 1, 1, TC_mapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapOutPatternEClass, TC_mapOutPattern.class, "TC_mapOutPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapOutPattern_Atl_atlModule(), theATLPackage.getModule(), null, "atl_atlModule", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOutPattern_Atl_atlPattern(), theATLPackage.getOutPattern(), null, "atl_atlPattern", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOutPattern_Atl_atlRule(), theATLPackage.getMatchedRule(), null, "atl_atlRule", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOutPattern_Qvtr_qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOutPattern_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapOutPattern_Qvtr_qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "qvtr_qvtrTypedModel", null, 1, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapOutPattern_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapSimpleInPatternElementEClass, TC_mapSimpleInPatternElement.class, "TC_mapSimpleInPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapSimpleInPatternElement_Atl_atlElement(), theATLPackage.getSimpleInPatternElement(), null, "atl_atlElement", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Atl_atlPattern(), theATLPackage.getInPattern(), null, "atl_atlPattern", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Atl_atlRule(), theATLPackage.getMatchedRule(), null, "atl_atlRule", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Invocation_mapVariable(), this.getTC_mapVariable(), null, "invocation_mapVariable", null, 0, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapSimpleInPatternElement_Primitive_elementName(), ecorePackage.getEString(), "primitive_elementName", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain1(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain1", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "qvtr_qvtrPattern", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "qvtr_qvtrTemplate", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleInPatternElement_Qvtr_qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "qvtr_qvtrVariable", null, 1, 1, TC_mapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapSimpleOutPatternElementEClass, TC_mapSimpleOutPatternElement.class, "TC_mapSimpleOutPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapSimpleOutPatternElement_Atl_atlElement(), theATLPackage.getSimpleOutPatternElement(), null, "atl_atlElement", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Atl_atlPattern(), theATLPackage.getOutPattern(), null, "atl_atlPattern", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Atl_atlRule(), theATLPackage.getMatchedRule(), null, "atl_atlRule", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Invocation_mapVariable(), this.getTC_mapVariable(), null, "invocation_mapVariable", null, 0, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapSimpleOutPatternElement_Primitive_elementName(), ecorePackage.getEString(), "primitive_elementName", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain1(), theQVTrelationPackage.getRelationDomain(), null, "qvtr_qvtrDomain1", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "qvtr_qvtrPattern", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrRelation(), theQVTrelationPackage.getRelation(), null, "qvtr_qvtrRelation", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "qvtr_qvtrTemplate", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapSimpleOutPatternElement_Qvtr_qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "qvtr_qvtrVariable", null, 1, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapSimpleOutPatternElement_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TC_mapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapStringExpEClass, TC_mapStringExp.class, "TC_mapStringExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTC_mapStringExp_Primitive_symbol(), ecorePackage.getEString(), "primitive_symbol", null, 1, 1, TC_mapStringExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapVariableEClass, TC_mapVariable.class, "TC_mapVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapVariable_Atl_atlVariable(), theATLPackage.getLocatedElement(), null, "atl_atlVariable", null, 1, 1, TC_mapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariable_Qvtr_qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "qvtr_qvtrVariable", null, 1, 1, TC_mapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapVariableExpEClass, TC_mapVariableExp.class, "TC_mapVariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapVariableExp_Atl_atlVariable(), theOCLPackage.getVariableDeclaration(), null, "atl_atlVariable", null, 1, 1, TC_mapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_Invocation_mapVariableExp_referredVariable(), this.getWC_mapVariableExp_referredVariable(), null, "invocation_mapVariableExp_referredVariable", null, 0, 1, TC_mapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTC_mapVariableExp_Primitive_varName(), ecorePackage.getEString(), "primitive_varName", null, 1, 1, TC_mapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapVariableExp_referredVariableEClass, TC_mapVariableExp_referredVariable.class, "TC_mapVariableExp_referredVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapVariableExp_referredVariable_Atl_atlExpression1(), theOCLPackage.getVariableExp(), null, "atl_atlExpression1", null, 1, 1, TC_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Qvtr_qvtrExpression1(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrExpression1", null, 1, 1, TC_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapVariableExp_referredVariable_HelperEClass, TC_mapVariableExp_referredVariable_Helper.class, "TC_mapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Atl_atlExpression(), theOCLPackage.getVariableExp(), null, "atl_atlExpression", null, 1, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Atl_atlHelper(), theATLPackage.getHelper(), null, "atl_atlHelper", null, 1, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Atl_atlVariable(), theOCLPackage.getVariableDeclaration(), null, "atl_atlVariable", null, 1, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Invocation_mapVariable(), this.getTC_mapVariable(), null, "invocation_mapVariable", null, 0, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrExpression(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "qvtr_qvtrVariable", null, 1, 1, TC_mapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tC_mapVariableExp_referredVariable_VariableDeclarationEClass, TC_mapVariableExp_referredVariable_VariableDeclaration.class, "TC_mapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlExpression(), theOCLPackage.getVariableExp(), null, "atl_atlExpression", null, 1, 1, TC_mapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlVariable(), theATLPackage.getPatternElement(), null, "atl_atlVariable", null, 1, 1, TC_mapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_VariableDeclaration_Invocation_mapVariable(), this.getTC_mapVariable(), null, "invocation_mapVariable", null, 0, 1, TC_mapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrExpression(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrExpression", null, 1, 1, TC_mapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "qvtr_qvtrVariable", null, 1, 1, TC_mapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tI_mapBooleanExpEClass, TI_mapBooleanExp.class, "TI_mapBooleanExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapHelperEClass, TI_mapHelper.class, "TI_mapHelper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTI_mapHelper_Atl_atlHelper(), theATLPackage.getHelper(), null, "atl_atlHelper", null, 1, 1, TI_mapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTI_mapHelper_Qvtr_qvtrFunction(), theQVTbasePackage.getFunction(), null, "qvtr_qvtrFunction", null, 1, 1, TI_mapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTI_mapHelper_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TI_mapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tI_mapHelper_AttributeEClass, TI_mapHelper_Attribute.class, "TI_mapHelper_Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapHelper_OperationEClass, TI_mapHelper_Operation.class, "TI_mapHelper_Operation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapIfExpEClass, TI_mapIfExp.class, "TI_mapIfExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapIntegerExpEClass, TI_mapIntegerExp.class, "TI_mapIntegerExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapNavigationOrAttributeCallExpEClass, TI_mapNavigationOrAttributeCallExp.class, "TI_mapNavigationOrAttributeCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapNavigationOrAttributeCallExp_HelperEClass, TI_mapNavigationOrAttributeCallExp_Helper.class, "TI_mapNavigationOrAttributeCallExp_Helper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapNavigationOrAttributeCallExp_PropertyEClass, TI_mapNavigationOrAttributeCallExp_Property.class, "TI_mapNavigationOrAttributeCallExp_Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapOclExpressionEClass, TI_mapOclExpression.class, "TI_mapOclExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTI_mapOclExpression_Atl_atlExpression(), theOCLPackage.getOclExpression(), null, "atl_atlExpression", null, 1, 1, TI_mapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTI_mapOclExpression_Qvtr_qvtrExpression(), thePivotPackage.getOCLExpression(), null, "qvtr_qvtrExpression", null, 1, 1, TI_mapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTI_mapOclExpression_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TI_mapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tI_mapOperationCallExpEClass, TI_mapOperationCallExp.class, "TI_mapOperationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapOperationCallExp_HelperEClass, TI_mapOperationCallExp_Helper.class, "TI_mapOperationCallExp_Helper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapOperationCallExp_OperationEClass, TI_mapOperationCallExp_Operation.class, "TI_mapOperationCallExp_Operation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapOperatorCallExpEClass, TI_mapOperatorCallExp.class, "TI_mapOperatorCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapStringExpEClass, TI_mapStringExp.class, "TI_mapStringExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapVariableExpEClass, TI_mapVariableExp.class, "TI_mapVariableExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapVariableExp_referredVariableEClass, TI_mapVariableExp_referredVariable.class, "TI_mapVariableExp_referredVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTI_mapVariableExp_referredVariable_Status(), ecorePackage.getEBooleanObject(), "status", null, 0, 1, TI_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tI_mapVariableExp_referredVariable_HelperEClass, TI_mapVariableExp_referredVariable_Helper.class, "TI_mapVariableExp_referredVariable_Helper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tI_mapVariableExp_referredVariable_VariableDeclarationEClass, TI_mapVariableExp_referredVariable_VariableDeclaration.class, "TI_mapVariableExp_referredVariable_VariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wC_mapVariableExp_referredVariableEClass, WC_mapVariableExp_referredVariable.class, "WC_mapVariableExp_referredVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wC_mapVariableExp_referredVariable_HelperEClass, WC_mapVariableExp_referredVariable_Helper.class, "WC_mapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wC_mapVariableExp_referredVariable_VariableDeclarationEClass, WC_mapVariableExp_referredVariable_VariableDeclaration.class, "WC_mapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wI_mapVariableExp_referredVariableEClass, WI_mapVariableExp_referredVariable.class, "WI_mapVariableExp_referredVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWI_mapVariableExp_referredVariable_Atl_atlExpression(), theOCLPackage.getVariableExp(), null, "atl_atlExpression", null, 1, 1, WI_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWI_mapVariableExp_referredVariable_Qvtr_qvtrExpression(), thePivotPackage.getVariableExp(), null, "qvtr_qvtrExpression", null, 1, 1, WI_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWI_mapVariableExp_referredVariable_Result(), this.getTI_mapVariableExp_referredVariable(), null, "result", null, 0, 1, WI_mapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wI_mapVariableExp_referredVariable_HelperEClass, WI_mapVariableExp_referredVariable_Helper.class, "WI_mapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wI_mapVariableExp_referredVariable_VariableDeclarationEClass, WI_mapVariableExp_referredVariable_VariableDeclaration.class, "WI_mapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		(getTC_mapBinding_Atl_atlBinding(),
			source,
			new String[] {
				"body", "TC_mapBinding"
		});
		addAnnotation
		(getTC_mapBinding_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapBinding"
		});
		addAnnotation
		(getTC_mapBinding_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapBinding"
		});
		addAnnotation
		(getTC_mapBinding_Qvtr_qvtrPart(),
			source,
			new String[] {
				"body", "TC_mapBinding"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlDefinition(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlFeature(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlType(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Invocation_mapHelper_Context(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapHelper_Attribute"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlContext(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlDefinition(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlHelper(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlReturnType(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context"
		});
		addAnnotation
		(getTC_mapHelper_Context_Invocation_mapVariable(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapHelper_Context_Qvtr_qvtrFunction(),
			source,
			new String[] {
				"body", "TC_mapHelper_Context"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlDefinition(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlFeature(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlType(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Invocation_mapHelper_Context(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapHelper_Operation"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlCondition(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlElse(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlThen(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrCondition(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrElse(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrThen(),
			source,
			new String[] {
				"body", "TC_mapIfExp"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlPattern(),
			source,
			new String[] {
				"body", "TC_mapInPattern"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlRule(),
			source,
			new String[] {
				"body", "TC_mapInPattern"
		});
		addAnnotation
		(getTC_mapInPattern_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"body", "TC_mapInPattern"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlPattern(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlRule(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_w(),
			source,
			new String[] {
				"body", "TC_mapInPattern_filter"
		});
		addAnnotation
		(getTC_mapMatchedRule_Atl_matchedRule(),
			source,
			new String[] {
				"body", "TC_mapMatchedRule"
		});
		addAnnotation
		(getTC_mapMatchedRule_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"body", "TC_mapMatchedRule"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Atl_atlChildRule(),
			source,
			new String[] {
				"body", "TC_mapMatchedRule_super"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Qvtr_qvtrOverridesRelation(),
			source,
			new String[] {
				"body", "TC_mapMatchedRule_super"
		});
		addAnnotation
		(getTC_mapModule_Atl_atlModule(),
			source,
			new String[] {
				"body", "TC_mapModule"
		});
		addAnnotation
		(getTC_mapModule_Qvtr__5(),
			source,
			new String[] {
				"body", "TC_mapModule"
		});
		addAnnotation
		(getTC_mapModule_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"body", "TC_mapModule"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlSource(),
			source,
			new String[] {
				"body", "TC_mapNavigationOrAttributeCallExp_Helper"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSource(),
			source,
			new String[] {
				"body", "TC_mapNavigationOrAttributeCallExp_Helper"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlSource(),
			source,
			new String[] {
				"body", "TC_mapNavigationOrAttributeCallExp_Property"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrSource(),
			source,
			new String[] {
				"body", "TC_mapNavigationOrAttributeCallExp_Property"
		});
		addAnnotation
		(getTC_mapOclMetamodel_Atl_oclMetamodel(),
			source,
			new String[] {
				"body", "TC_mapOclMetamodel"
		});
		addAnnotation
		(getTC_mapOclMetamodel_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"body", "TC_mapOclMetamodel"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Atl_oclModel(),
			source,
			new String[] {
				"body", "TC_mapOclModel_IN"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"body", "TC_mapOclModel_IN"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Atl_oclModel(),
			source,
			new String[] {
				"body", "TC_mapOclModel_OUT"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"body", "TC_mapOclModel_OUT"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Atl_atlSource(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_Helper"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrSource(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_Helper"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Atl_atlSource(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_Operation"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Qvtr_qvtrSource(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_Operation"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Atl_atlArgument(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_argument"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Qvtr_qvtrArgument(),
			source,
			new String[] {
				"body", "TC_mapOperationCallExp_argument"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Atl_atlSource(),
			source,
			new String[] {
				"body", "TC_mapOperatorCallExp"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Qvtr_qvtrSource(),
			source,
			new String[] {
				"body", "TC_mapOperatorCallExp"
		});
		addAnnotation
		(getTC_mapOutPattern_Atl_atlPattern(),
			source,
			new String[] {
				"body", "TC_mapOutPattern"
		});
		addAnnotation
		(getTC_mapOutPattern_Atl_atlRule(),
			source,
			new String[] {
				"body", "TC_mapOutPattern"
		});
		addAnnotation
		(getTC_mapOutPattern_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"body", "TC_mapOutPattern"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Atl_atlElement(),
			source,
			new String[] {
				"body", "TC_mapSimpleInPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Atl_atlRule(),
			source,
			new String[] {
				"body", "TC_mapSimpleInPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Invocation_mapVariable(),
			source,
			new String[] {
				"body", "TC_mapSimpleInPatternElement",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrTemplate(),
			source,
			new String[] {
				"body", "TC_mapSimpleInPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"body", "TC_mapSimpleInPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Atl_atlElement(),
			source,
			new String[] {
				"body", "TC_mapSimpleOutPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Atl_atlRule(),
			source,
			new String[] {
				"body", "TC_mapSimpleOutPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Invocation_mapVariable(),
			source,
			new String[] {
				"body", "TC_mapSimpleOutPatternElement",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrTemplate(),
			source,
			new String[] {
				"body", "TC_mapSimpleOutPatternElement"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"body", "TC_mapSimpleOutPatternElement"
		});
		addAnnotation
		(getTC_mapVariable_Atl_atlVariable(),
			source,
			new String[] {
				"body", "TC_mapVariable"
		});
		addAnnotation
		(getTC_mapVariable_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"body", "TC_mapVariable"
		});
		addAnnotation
		(getTC_mapVariableExp_Invocation_mapVariableExp_referredVariable(),
			source,
			new String[] {
				"body", "TC_mapVariableExp",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Atl_atlExpression1(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Qvtr_qvtrExpression1(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_Helper"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Invocation_mapVariable(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_Helper",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_Helper"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_VariableDeclaration"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Invocation_mapVariable(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_VariableDeclaration",
				"unique", "false",
				"upper", "*"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TC_mapVariableExp_referredVariable_VariableDeclaration"
		});
		addAnnotation
		(getTI_mapHelper_Atl_atlHelper(),
			source,
			new String[] {
				"body", "TI_mapHelper"
		});
		addAnnotation
		(getTI_mapHelper_Qvtr_qvtrFunction(),
			source,
			new String[] {
				"body", "TI_mapHelper"
		});
		addAnnotation
		(getTI_mapOclExpression_Atl_atlExpression(),
			source,
			new String[] {
				"body", "TI_mapOclExpression"
		});
		addAnnotation
		(getTI_mapOclExpression_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "TI_mapOclExpression"
		});
		addAnnotation
		(getWI_mapVariableExp_referredVariable_Atl_atlExpression(),
			source,
			new String[] {
				"body", "WI_mapVariableExp_referredVariable"
		});
		addAnnotation
		(getWI_mapVariableExp_referredVariable_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"body", "WI_mapVariableExp_referredVariable"
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
		(getTC_mapBinding_Atl_atlBinding(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapBinding_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapBinding_Atl_atlOutPatternElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapBinding_Primitive_propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapBinding_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapBinding_Qvtr_qvtrPart(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapBinding_Qvtr_qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapBooleanExp_Primitive_symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlFeature(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Atl_atlType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Primitive_attributeName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapHelper_Attribute_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlContext(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlHelper(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Context_Atl_atlReturnType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Context_Qvtr_qvtrFunction(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapHelper_Context_Qvtr_qvtrParameter(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlFeature(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Atl_atlType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Primitive_operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapHelper_Operation_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlCondition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlElse(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapIfExp_Atl_atlThen(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrCondition(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrElse(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapIfExp_Qvtr_qvtrThen(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_Atl_atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Atl_atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_p(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapInPattern_filter_Qvtr_w(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapIntegerExp_Primitive_symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapMatchedRule_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapMatchedRule_Atl_matchedRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapMatchedRule_Primitive_ruleName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapMatchedRule_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapMatchedRule_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Atl_atlChildRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Atl_atlSuperRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Qvtr_qvtrOverriddenRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapMatchedRule_super_Qvtr_qvtrOverridesRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapModule_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapModule_Primitive_txName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapModule_Qvtr__3(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapModule_Qvtr__4(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapModule_Qvtr__5(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapModule_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlAttributes(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Atl_atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Primitive_propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrSourceArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrThisVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Helper_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlAttributes(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Atl_atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Primitive_propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrProperty(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapNavigationOrAttributeCallExp_Property_Qvtr_qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOclMetamodel_Atl_oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclMetamodel_Primitive_tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOclMetamodel_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Atl_oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Atl_oclModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Primitive_tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOclModel_IN_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Atl_oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Atl_oclModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Primitive_tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOclModel_OUT_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Atl_atlOperations(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Atl_atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Primitive_operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrSourceArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrThisVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Helper_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Atl_atlOperations(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Atl_atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Primitive_operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Qvtr_qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_Operation_Qvtr_qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Atl_atlArgument(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Atl_atlParent(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Qvtr_qvtrArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperationCallExp_argument_Qvtr_qvtrParent(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Atl_atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Primitive_operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Qvtr_qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Qvtr_qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOperatorCallExp_Qvtr_qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOutPattern_Atl_atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOutPattern_Atl_atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOutPattern_Atl_atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapOutPattern_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOutPattern_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapOutPattern_Qvtr_qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Atl_atlElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Atl_atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Atl_atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Primitive_elementName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrDomain1(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrPattern(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleInPatternElement_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Atl_atlElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Atl_atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Atl_atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Primitive_elementName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrDomain1(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrPattern(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapSimpleOutPatternElement_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapStringExp_Primitive_symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapVariable_Atl_atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariable_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapVariableExp_Atl_atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_Primitive_varName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Atl_atlExpression1(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Qvtr_qvtrExpression1(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Atl_atlHelper(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Atl_atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_Helper_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTI_mapHelper_Atl_atlHelper(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTI_mapHelper_Qvtr_qvtrFunction(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTI_mapOclExpression_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTI_mapOclExpression_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getWI_mapVariableExp_referredVariable_Atl_atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getWI_mapVariableExp_referredVariable_Qvtr_qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
	}

} //trace_ATL2QVTrPackageImpl
