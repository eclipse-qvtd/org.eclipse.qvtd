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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

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
	private EClass tmapOutPatternEClass = null;

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
		QVTtracePackage.eINSTANCE.eClass();

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
	public EReference getDmapHelper_D1atlHelper() {
		return (EReference)dmapHelperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapHelper_D2qvtrFunction() {
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
	public EClass getDmapOclExpression() {
		return dmapOclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_D1atlExpression() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_D2qvtrExpression() {
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
	public EReference getDmapOclExpression_DomapOperationCallExp_Helper() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOperationCallExp_Operation() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapOperatorCallExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapStringExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_DomapVariableExp() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapOclExpression_Result() {
		return (EReference)dmapOclExpressionEClass.getEStructuralFeatures().get(12);
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
	public EReference getDmapVariableExp_referredVariable_D1atlExpression() {
		return (EReference)dmapVariableExp_referredVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDmapVariableExp_referredVariable_D2qvtrExpression() {
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
	public EClass getImapHelper() {
		return imapHelperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImapHelper_Success() {
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
	public EAttribute getImapOclExpression_Success() {
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
	public EAttribute getImapVariableExp_referredVariable_Success() {
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
	public EAttribute getTmapBinding_T0propertyName() {
		return (EAttribute)tmapBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T1atlBinding() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T1atlExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T1atlOutPatternElement() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T2qvtrExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T2qvtrPart() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_T2qvtrTemplate() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_WmapOclExpression() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapBinding_WmapSimpleOutPatternElement() {
		return (EReference)tmapBindingEClass.getEStructuralFeatures().get(8);
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
	public EAttribute getTmapBooleanExp_T0symbol() {
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
	public EAttribute getTmapHelper_Attribute_T0attributeName() {
		return (EAttribute)tmapHelper_AttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T1atlDefinition() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T1atlExpression() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T1atlFeature() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T1atlModule() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T1atlType() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T2qvtrExpression() {
		return (EReference)tmapHelper_AttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Attribute_T2qvtrTransformation() {
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
	public EClass getTmapHelper_Context() {
		return tmapHelper_ContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T1atlContext() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T1atlDefinition() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T1atlHelper() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T1atlReturnType() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T2qvtrFunction() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_T2qvtrParameter() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Context_WmapVariable() {
		return (EReference)tmapHelper_ContextEClass.getEStructuralFeatures().get(6);
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
	public EAttribute getTmapHelper_Operation_T0operationName() {
		return (EAttribute)tmapHelper_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T1atlDefinition() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T1atlExpression() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T1atlFeature() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T1atlModule() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T1atlType() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T2qvtrExpression() {
		return (EReference)tmapHelper_OperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapHelper_Operation_T2qvtrTransformation() {
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
	public EReference getTmapIfExp_T1atlCondition() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T1atlElse() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T1atlThen() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T2qvtrCondition() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T2qvtrElse() {
		return (EReference)tmapIfExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapIfExp_T2qvtrThen() {
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
	public EClass getTmapInPattern() {
		return tmapInPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapInPattern_Success() {
		return (EAttribute)tmapInPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T1atlModel() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T1atlPattern() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T1atlRule() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T2qvtrDomain() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T2qvtrRelation() {
		return (EReference)tmapInPatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_T2qvtrTypedModel() {
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
	public EReference getTmapInPattern_filter_T1atlExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T1atlPattern() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T1atlRule() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T2p() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T2qvtrDomain() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T2qvtrExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T2qvtrRelation() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_T2w() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapInPattern() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapMatchedRule() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapInPattern_filter_WmapOclExpression() {
		return (EReference)tmapInPattern_filterEClass.getEStructuralFeatures().get(10);
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
	public EAttribute getTmapIntegerExp_T0symbol() {
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
	public EAttribute getTmapMatchedRule_Success() {
		return (EAttribute)tmapMatchedRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapMatchedRule_T0ruleName() {
		return (EAttribute)tmapMatchedRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T1atlModule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T1matchedRule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T2_1() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T2qvtrRelation() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_T2qvtrTransformation() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_WmapModule() {
		return (EReference)tmapMatchedRuleEClass.getEStructuralFeatures().get(7);
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
	public EReference getTmapMatchedRule_super_T1atlChildRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T1atlSuperRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T2qvtrOverriddenRelation() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_T2qvtrOverridesRelation() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_WmapMatchedRule() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapMatchedRule_super_WmapMatchedRule1() {
		return (EReference)tmapMatchedRule_superEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getTmapModule_T0txName() {
		return (EAttribute)tmapModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T1atlModule() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T2_1() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T2_2() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T2_3() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T2_4() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapModule_T2qvtrTransformation() {
		return (EReference)tmapModuleEClass.getEStructuralFeatures().get(6);
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
	public EAttribute getTmapNavigationOrAttributeCallExp_Helper_T0propertyName() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T1atlSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapHelper() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapModule() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression() {
		return (EReference)tmapNavigationOrAttributeCallExp_HelperEClass.getEStructuralFeatures().get(9);
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
	public EAttribute getTmapNavigationOrAttributeCallExp_Property_T0propertyName() {
		return (EAttribute)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T1atlSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_T2qvtrSource() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression() {
		return (EReference)tmapNavigationOrAttributeCallExp_PropertyEClass.getEStructuralFeatures().get(4);
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
	public EAttribute getTmapOclMetamodel_T0tmName() {
		return (EAttribute)tmapOclMetamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclMetamodel_T1oclMetamodel() {
		return (EReference)tmapOclMetamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclMetamodel_T2qvtrTypedModel() {
		return (EReference)tmapOclMetamodelEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getTmapOclModel_IN_T0tmName() {
		return (EAttribute)tmapOclModel_INEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T1atlModule() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T1oclMetamodel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T1oclModel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T2qvtrTransformation() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_T2qvtrTypedModel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_WmapModule() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_IN_WmapOclMetamodel() {
		return (EReference)tmapOclModel_INEClass.getEStructuralFeatures().get(7);
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
	public EAttribute getTmapOclModel_OUT_T0tmName() {
		return (EAttribute)tmapOclModel_OUTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T1atlModule() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T1oclMetamodel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T1oclModel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T2qvtrTransformation() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_T2qvtrTypedModel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_WmapModule() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOclModel_OUT_WmapOclMetamodel() {
		return (EReference)tmapOclModel_OUTEClass.getEStructuralFeatures().get(7);
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
	public EAttribute getTmapOperationCallExp_Helper_T0operationName() {
		return (EAttribute)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T1atlSource() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T2qvtrOperation() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T2qvtrSource() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T2qvtrSourceArgument() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_T2qvtrTransformation() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapHelper() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapModule() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Helper_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_HelperEClass.getEStructuralFeatures().get(9);
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
	public EAttribute getTmapOperationCallExp_Operation_T0operationName() {
		return (EAttribute)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T1atlSource() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_T2qvtrSource() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_Operation_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_OperationEClass.getEStructuralFeatures().get(4);
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
	public EReference getTmapOperationCallExp_argument_T1atlArgument() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T1atlParent() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T2qvtrArgument() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_T2qvtrParent() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_WmapOclExpression() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperationCallExp_argument_WmapOclExpression1() {
		return (EReference)tmapOperationCallExp_argumentEClass.getEStructuralFeatures().get(5);
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
	public EAttribute getTmapOperatorCallExp_T0operationName() {
		return (EAttribute)tmapOperatorCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T1atlSource() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T2qvtrSource() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_T2qvtrTransformation() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_WmapModule() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOperatorCallExp_WmapOclExpression() {
		return (EReference)tmapOperatorCallExpEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTmapOutPattern() {
		return tmapOutPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapOutPattern_Success() {
		return (EAttribute)tmapOutPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_T1atlPattern() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_T1atlRule() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_T2qvtrDomain() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_T2qvtrRelation() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_T2qvtrTypedModel() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_WmapMatchedRule() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapOutPattern_WmapOclMetamodel() {
		return (EReference)tmapOutPatternEClass.getEStructuralFeatures().get(7);
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
	public EAttribute getTmapSimpleInPatternElement_T0elementName() {
		return (EAttribute)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T1atlElement() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T1atlPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T1atlRule() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T2qvtrDomain() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T2qvtrPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T2qvtrRelation() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T2qvtrTemplate() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_T2qvtrVariable() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapInPattern() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapMatchedRule() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleInPatternElement_WmapVariable() {
		return (EReference)tmapSimpleInPatternElementEClass.getEStructuralFeatures().get(11);
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
	public EAttribute getTmapSimpleOutPatternElement_Success() {
		return (EAttribute)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTmapSimpleOutPatternElement_T0elementName() {
		return (EAttribute)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T1atlElement() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T1atlPattern() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T1atlRule() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T2qvtrDomain() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T2qvtrPattern() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T2qvtrRelation() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T2qvtrTemplate() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_T2qvtrVariable() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapMatchedRule() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapOutPattern() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapSimpleOutPatternElement_WmapVariable() {
		return (EReference)tmapSimpleOutPatternElementEClass.getEStructuralFeatures().get(12);
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
	public EAttribute getTmapStringExp_T0symbol() {
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
	public EAttribute getTmapVariable_Success() {
		return (EAttribute)tmapVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariable_T1atlVariable() {
		return (EReference)tmapVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariable_T2qvtrVariable() {
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
	public EAttribute getTmapVariableExp_T0varName() {
		return (EAttribute)tmapVariableExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_T1atlVariable() {
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
	public EReference getTmapVariableExp_referredVariable_Helper_T1atlVariable() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_Helper_T2qvtrVariable() {
		return (EReference)tmapVariableExp_referredVariable_HelperEClass.getEStructuralFeatures().get(2);
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
	public EReference getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable() {
		return (EReference)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable() {
		return (EReference)tmapVariableExp_referredVariable_VariableDeclarationEClass.getEStructuralFeatures().get(2);
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
		cmapVariableExp_referredVariable_HelperEClass = createEClass(CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);

		cmapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);

		dmapHelperEClass = createEClass(DMAP_HELPER);
		createEReference(dmapHelperEClass, DMAP_HELPER__D1ATL_HELPER);
		createEReference(dmapHelperEClass, DMAP_HELPER__D2QVTR_FUNCTION);
		createEReference(dmapHelperEClass, DMAP_HELPER__DOMAP_HELPER_ATTRIBUTE);
		createEReference(dmapHelperEClass, DMAP_HELPER__DOMAP_HELPER_OPERATION);
		createEReference(dmapHelperEClass, DMAP_HELPER__RESULT);

		dmapOclExpressionEClass = createEClass(DMAP_OCL_EXPRESSION);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_IF_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP);
		createEReference(dmapOclExpressionEClass, DMAP_OCL_EXPRESSION__RESULT);

		dmapVariableExp_referredVariableEClass = createEClass(DMAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEReference(dmapVariableExp_referredVariableEClass, DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D1ATL_EXPRESSION);
		createEReference(dmapVariableExp_referredVariableEClass, DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D2QVTR_EXPRESSION);
		createEReference(dmapVariableExp_referredVariableEClass, DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);
		createEReference(dmapVariableExp_referredVariableEClass, DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);
		createEReference(dmapVariableExp_referredVariableEClass, DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT);

		imapHelperEClass = createEClass(IMAP_HELPER);
		createEAttribute(imapHelperEClass, IMAP_HELPER__SUCCESS);

		imapOclExpressionEClass = createEClass(IMAP_OCL_EXPRESSION);
		createEAttribute(imapOclExpressionEClass, IMAP_OCL_EXPRESSION__SUCCESS);

		imapVariableExp_referredVariableEClass = createEClass(IMAP_VARIABLE_EXP_REFERRED_VARIABLE);
		createEAttribute(imapVariableExp_referredVariableEClass, IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS);

		tmapBindingEClass = createEClass(TMAP_BINDING);
		createEAttribute(tmapBindingEClass, TMAP_BINDING__T0PROPERTY_NAME);
		createEReference(tmapBindingEClass, TMAP_BINDING__T1ATL_BINDING);
		createEReference(tmapBindingEClass, TMAP_BINDING__T1ATL_EXPRESSION);
		createEReference(tmapBindingEClass, TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT);
		createEReference(tmapBindingEClass, TMAP_BINDING__T2QVTR_EXPRESSION);
		createEReference(tmapBindingEClass, TMAP_BINDING__T2QVTR_PART);
		createEReference(tmapBindingEClass, TMAP_BINDING__T2QVTR_TEMPLATE);
		createEReference(tmapBindingEClass, TMAP_BINDING__WMAP_OCL_EXPRESSION);
		createEReference(tmapBindingEClass, TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT);

		tmapBooleanExpEClass = createEClass(TMAP_BOOLEAN_EXP);
		createEReference(tmapBooleanExpEClass, TMAP_BOOLEAN_EXP__DISPATCHER);
		createEAttribute(tmapBooleanExpEClass, TMAP_BOOLEAN_EXP__T0SYMBOL);

		tmapHelper_AttributeEClass = createEClass(TMAP_HELPER_ATTRIBUTE);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__DISPATCHER);
		createEAttribute(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T0ATTRIBUTE_NAME);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T1ATL_DEFINITION);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T1ATL_EXPRESSION);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T1ATL_FEATURE);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T1ATL_MODULE);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T1ATL_TYPE);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T2QVTR_EXPRESSION);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__T2QVTR_TRANSFORMATION);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__WMAP_HELPER_CONTEXT);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__WMAP_MODULE);
		createEReference(tmapHelper_AttributeEClass, TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION);

		tmapHelper_ContextEClass = createEClass(TMAP_HELPER_CONTEXT);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T1ATL_CONTEXT);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T1ATL_DEFINITION);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T1ATL_HELPER);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER);
		createEReference(tmapHelper_ContextEClass, TMAP_HELPER_CONTEXT__WMAP_VARIABLE);

		tmapHelper_OperationEClass = createEClass(TMAP_HELPER_OPERATION);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__DISPATCHER);
		createEAttribute(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T0OPERATION_NAME);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T1ATL_DEFINITION);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T1ATL_EXPRESSION);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T1ATL_FEATURE);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T1ATL_MODULE);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T1ATL_TYPE);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__WMAP_MODULE);
		createEReference(tmapHelper_OperationEClass, TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION);

		tmapIfExpEClass = createEClass(TMAP_IF_EXP);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__DISPATCHER);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T1ATL_CONDITION);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T1ATL_ELSE);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T1ATL_THEN);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T2QVTR_CONDITION);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T2QVTR_ELSE);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__T2QVTR_THEN);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__WMAP_OCL_EXPRESSION);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__WMAP_OCL_EXPRESSION1);
		createEReference(tmapIfExpEClass, TMAP_IF_EXP__WMAP_OCL_EXPRESSION2);

		tmapInPatternEClass = createEClass(TMAP_IN_PATTERN);
		createEAttribute(tmapInPatternEClass, TMAP_IN_PATTERN__SUCCESS);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T1ATL_MODEL);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T1ATL_PATTERN);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T1ATL_RULE);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T2QVTR_DOMAIN);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T2QVTR_RELATION);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__T2QVTR_TYPED_MODEL);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__WMAP_MATCHED_RULE);
		createEReference(tmapInPatternEClass, TMAP_IN_PATTERN__WMAP_OCL_METAMODEL);

		tmapInPattern_filterEClass = createEClass(TMAP_IN_PATTERN_FILTER);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T1ATL_EXPRESSION);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T1ATL_PATTERN);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T1ATL_RULE);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T2P);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T2QVTR_DOMAIN);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T2QVTR_EXPRESSION);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T2QVTR_RELATION);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__T2W);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__WMAP_IN_PATTERN);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__WMAP_MATCHED_RULE);
		createEReference(tmapInPattern_filterEClass, TMAP_IN_PATTERN_FILTER__WMAP_OCL_EXPRESSION);

		tmapIntegerExpEClass = createEClass(TMAP_INTEGER_EXP);
		createEReference(tmapIntegerExpEClass, TMAP_INTEGER_EXP__DISPATCHER);
		createEAttribute(tmapIntegerExpEClass, TMAP_INTEGER_EXP__T0SYMBOL);

		tmapMatchedRuleEClass = createEClass(TMAP_MATCHED_RULE);
		createEAttribute(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__SUCCESS);
		createEAttribute(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T0RULE_NAME);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T1ATL_MODULE);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T1MATCHED_RULE);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T2_1);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T2QVTR_RELATION);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION);
		createEReference(tmapMatchedRuleEClass, TMAP_MATCHED_RULE__WMAP_MODULE);

		tmapMatchedRule_superEClass = createEClass(TMAP_MATCHED_RULE_SUPER);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE);
		createEReference(tmapMatchedRule_superEClass, TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1);

		tmapModuleEClass = createEClass(TMAP_MODULE);
		createEAttribute(tmapModuleEClass, TMAP_MODULE__T0TX_NAME);
		createEReference(tmapModuleEClass, TMAP_MODULE__T1ATL_MODULE);
		createEReference(tmapModuleEClass, TMAP_MODULE__T2_1);
		createEReference(tmapModuleEClass, TMAP_MODULE__T2_2);
		createEReference(tmapModuleEClass, TMAP_MODULE__T2_3);
		createEReference(tmapModuleEClass, TMAP_MODULE__T2_4);
		createEReference(tmapModuleEClass, TMAP_MODULE__T2QVTR_TRANSFORMATION);

		tmapNavigationOrAttributeCallExp_HelperEClass = createEClass(TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER);
		createEAttribute(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1ATL_SOURCE);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_OPERATION);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_MODULE);
		createEReference(tmapNavigationOrAttributeCallExp_HelperEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION);

		tmapNavigationOrAttributeCallExp_PropertyEClass = createEClass(TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER);
		createEAttribute(tmapNavigationOrAttributeCallExp_PropertyEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE);
		createEReference(tmapNavigationOrAttributeCallExp_PropertyEClass, TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION);

		tmapOclMetamodelEClass = createEClass(TMAP_OCL_METAMODEL);
		createEAttribute(tmapOclMetamodelEClass, TMAP_OCL_METAMODEL__T0TM_NAME);
		createEReference(tmapOclMetamodelEClass, TMAP_OCL_METAMODEL__T1OCL_METAMODEL);
		createEReference(tmapOclMetamodelEClass, TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL);

		tmapOclModel_INEClass = createEClass(TMAP_OCL_MODEL_IN);
		createEAttribute(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T0TM_NAME);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T1ATL_MODULE);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T1OCL_METAMODEL);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T1OCL_MODEL);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__WMAP_MODULE);
		createEReference(tmapOclModel_INEClass, TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL);

		tmapOclModel_OUTEClass = createEClass(TMAP_OCL_MODEL_OUT);
		createEAttribute(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T0TM_NAME);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T1ATL_MODULE);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T1OCL_METAMODEL);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T1OCL_MODEL);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T2QVTR_TRANSFORMATION);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__T2QVTR_TYPED_MODEL);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__WMAP_MODULE);
		createEReference(tmapOclModel_OUTEClass, TMAP_OCL_MODEL_OUT__WMAP_OCL_METAMODEL);

		tmapOperationCallExp_HelperEClass = createEClass(TMAP_OPERATION_CALL_EXP_HELPER);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER);
		createEAttribute(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE);
		createEReference(tmapOperationCallExp_HelperEClass, TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION);

		tmapOperationCallExp_OperationEClass = createEClass(TMAP_OPERATION_CALL_EXP_OPERATION);
		createEReference(tmapOperationCallExp_OperationEClass, TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER);
		createEAttribute(tmapOperationCallExp_OperationEClass, TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME);
		createEReference(tmapOperationCallExp_OperationEClass, TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE);
		createEReference(tmapOperationCallExp_OperationEClass, TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE);
		createEReference(tmapOperationCallExp_OperationEClass, TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION);

		tmapOperationCallExp_argumentEClass = createEClass(TMAP_OPERATION_CALL_EXP_ARGUMENT);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_ARGUMENT);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_PARENT);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_ARGUMENT);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_PARENT);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION);
		createEReference(tmapOperationCallExp_argumentEClass, TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION1);

		tmapOperatorCallExpEClass = createEClass(TMAP_OPERATOR_CALL_EXP);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__DISPATCHER);
		createEAttribute(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__T0OPERATION_NAME);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__T1ATL_SOURCE);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__T2QVTR_SOURCE);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__T2QVTR_TRANSFORMATION);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__WMAP_MODULE);
		createEReference(tmapOperatorCallExpEClass, TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION);

		tmapOutPatternEClass = createEClass(TMAP_OUT_PATTERN);
		createEAttribute(tmapOutPatternEClass, TMAP_OUT_PATTERN__SUCCESS);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__T1ATL_PATTERN);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__T1ATL_RULE);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__T2QVTR_DOMAIN);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__T2QVTR_RELATION);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__WMAP_MATCHED_RULE);
		createEReference(tmapOutPatternEClass, TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL);

		tmapSimpleInPatternElementEClass = createEClass(TMAP_SIMPLE_IN_PATTERN_ELEMENT);
		createEAttribute(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T0ELEMENT_NAME);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_ELEMENT);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_PATTERN);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_RULE);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_DOMAIN);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_PATTERN);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_RELATION);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_TEMPLATE);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_VARIABLE);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_IN_PATTERN);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_MATCHED_RULE);
		createEReference(tmapSimpleInPatternElementEClass, TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_VARIABLE);

		tmapSimpleOutPatternElementEClass = createEClass(TMAP_SIMPLE_OUT_PATTERN_ELEMENT);
		createEAttribute(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__SUCCESS);
		createEAttribute(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T0ELEMENT_NAME);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_ELEMENT);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_PATTERN);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_RULE);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_DOMAIN);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_PATTERN);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_RELATION);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_TEMPLATE);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_VARIABLE);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_MATCHED_RULE);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_OUT_PATTERN);
		createEReference(tmapSimpleOutPatternElementEClass, TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_VARIABLE);

		tmapStringExpEClass = createEClass(TMAP_STRING_EXP);
		createEReference(tmapStringExpEClass, TMAP_STRING_EXP__DISPATCHER);
		createEAttribute(tmapStringExpEClass, TMAP_STRING_EXP__T0SYMBOL);

		tmapVariableEClass = createEClass(TMAP_VARIABLE);
		createEAttribute(tmapVariableEClass, TMAP_VARIABLE__SUCCESS);
		createEReference(tmapVariableEClass, TMAP_VARIABLE__T1ATL_VARIABLE);
		createEReference(tmapVariableEClass, TMAP_VARIABLE__T2QVTR_VARIABLE);

		tmapVariableExpEClass = createEClass(TMAP_VARIABLE_EXP);
		createEReference(tmapVariableExpEClass, TMAP_VARIABLE_EXP__DISPATCHER);
		createEAttribute(tmapVariableExpEClass, TMAP_VARIABLE_EXP__T0VAR_NAME);
		createEReference(tmapVariableExpEClass, TMAP_VARIABLE_EXP__T1ATL_VARIABLE);
		createEReference(tmapVariableExpEClass, TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE);

		tmapVariableExp_referredVariable_HelperEClass = createEClass(TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE);
		createEReference(tmapVariableExp_referredVariable_HelperEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE);

		tmapVariableExp_referredVariable_VariableDeclarationEClass = createEClass(TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DISPATCHER);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T1ATL_VARIABLE);
		createEReference(tmapVariableExp_referredVariable_VariableDeclarationEClass, TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T2QVTR_VARIABLE);
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
		tmapOperationCallExp_HelperEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOperationCallExp_OperationEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOperationCallExp_argumentEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapOperatorCallExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapOutPatternEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapSimpleInPatternElementEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapSimpleOutPatternElementEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapStringExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapVariableEClass.getESuperTypes().add(theQVTtracePackage.getExecution());
		tmapVariableExpEClass.getESuperTypes().add(this.getImapOclExpression());
		tmapVariableExp_referredVariable_HelperEClass.getESuperTypes().add(this.getImapVariableExp_referredVariable());
		tmapVariableExp_referredVariable_VariableDeclarationEClass.getESuperTypes().add(this.getImapVariableExp_referredVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(cmapVariableExp_referredVariable_HelperEClass, CmapVariableExp_referredVariable_Helper.class, "CmapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cmapVariableExp_referredVariable_VariableDeclarationEClass, CmapVariableExp_referredVariable_VariableDeclaration.class, "CmapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dmapHelperEClass, DmapHelper.class, "DmapHelper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapHelper_D1atlHelper(), theATLPackage.getHelper(), null, "d1atlHelper", null, 1, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_D2qvtrFunction(), theQVTbasePackage.getFunction(), null, "d2qvtrFunction", null, 1, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_DomapHelper_Attribute(), this.getTmapHelper_Attribute(), this.getTmapHelper_Attribute_Dispatcher(), "domapHelper_Attribute", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_DomapHelper_Operation(), this.getTmapHelper_Operation(), this.getTmapHelper_Operation_Dispatcher(), "domapHelper_Operation", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapHelper_Result(), this.getImapHelper(), null, "result", null, 0, 1, DmapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dmapOclExpressionEClass, DmapOclExpression.class, "DmapOclExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapOclExpression_D1atlExpression(), theOCLPackage.getOclExpression(), null, "d1atlExpression", null, 1, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_D2qvtrExpression(), thePivotPackage.getOCLExpression(), null, "d2qvtrExpression", null, 1, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapBooleanExp(), this.getTmapBooleanExp(), this.getTmapBooleanExp_Dispatcher(), "domapBooleanExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapIfExp(), this.getTmapIfExp(), this.getTmapIfExp_Dispatcher(), "domapIfExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapIntegerExp(), this.getTmapIntegerExp(), this.getTmapIntegerExp_Dispatcher(), "domapIntegerExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper(), this.getTmapNavigationOrAttributeCallExp_Helper(), this.getTmapNavigationOrAttributeCallExp_Helper_Dispatcher(), "domapNavigationOrAttributeCallExp_Helper", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property(), this.getTmapNavigationOrAttributeCallExp_Property(), this.getTmapNavigationOrAttributeCallExp_Property_Dispatcher(), "domapNavigationOrAttributeCallExp_Property", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperationCallExp_Helper(), this.getTmapOperationCallExp_Helper(), this.getTmapOperationCallExp_Helper_Dispatcher(), "domapOperationCallExp_Helper", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperationCallExp_Operation(), this.getTmapOperationCallExp_Operation(), this.getTmapOperationCallExp_Operation_Dispatcher(), "domapOperationCallExp_Operation", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapOperatorCallExp(), this.getTmapOperatorCallExp(), this.getTmapOperatorCallExp_Dispatcher(), "domapOperatorCallExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapStringExp(), this.getTmapStringExp(), this.getTmapStringExp_Dispatcher(), "domapStringExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_DomapVariableExp(), this.getTmapVariableExp(), this.getTmapVariableExp_Dispatcher(), "domapVariableExp", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapOclExpression_Result(), this.getImapOclExpression(), null, "result", null, 0, 1, DmapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dmapVariableExp_referredVariableEClass, DmapVariableExp_referredVariable.class, "DmapVariableExp_referredVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDmapVariableExp_referredVariable_D1atlExpression(), theOCLPackage.getVariableExp(), null, "d1atlExpression", null, 1, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_D2qvtrExpression(), thePivotPackage.getVariableExp(), null, "d2qvtrExpression", null, 1, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper(), this.getTmapVariableExp_referredVariable_Helper(), this.getTmapVariableExp_referredVariable_Helper_Dispatcher(), "domapVariableExp_referredVariable_Helper", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration(), this.getTmapVariableExp_referredVariable_VariableDeclaration(), this.getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher(), "domapVariableExp_referredVariable_VariableDeclaration", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDmapVariableExp_referredVariable_Result(), this.getImapVariableExp_referredVariable(), null, "result", null, 0, 1, DmapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapHelperEClass, ImapHelper.class, "ImapHelper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapHelper_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, ImapHelper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapOclExpressionEClass, ImapOclExpression.class, "ImapOclExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapOclExpression_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, ImapOclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imapVariableExp_referredVariableEClass, ImapVariableExp_referredVariable.class, "ImapVariableExp_referredVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImapVariableExp_referredVariable_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, ImapVariableExp_referredVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapBindingEClass, TmapBinding.class, "TmapBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapBinding_T0propertyName(), ecorePackage.getEString(), "t0propertyName", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T1atlBinding(), theATLPackage.getBinding(), null, "t1atlBinding", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T1atlExpression(), theOCLPackage.getOclExpression(), null, "t1atlExpression", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T1atlOutPatternElement(), theATLPackage.getSimpleOutPatternElement(), null, "t1atlOutPatternElement", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T2qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t2qvtrExpression", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T2qvtrPart(), theQVTtemplatePackage.getPropertyTemplateItem(), null, "t2qvtrPart", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_T2qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t2qvtrTemplate", null, 1, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapBinding_WmapSimpleOutPatternElement(), this.getTmapSimpleOutPatternElement(), null, "wmapSimpleOutPatternElement", null, 0, 1, TmapBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapBooleanExpEClass, TmapBooleanExp.class, "TmapBooleanExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapBooleanExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapBooleanExp(), "dispatcher", null, 1, 1, TmapBooleanExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapBooleanExp_T0symbol(), ecorePackage.getEBoolean(), "t0symbol", null, 1, 1, TmapBooleanExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_AttributeEClass, TmapHelper_Attribute.class, "TmapHelper_Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapHelper_Attribute_Dispatcher(), this.getDmapHelper(), this.getDmapHelper_DomapHelper_Attribute(), "dispatcher", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Attribute_T0attributeName(), ecorePackage.getEString(), "t0attributeName", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T1atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t1atlDefinition", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T1atlExpression(), theOCLPackage.getOclExpression(), null, "t1atlExpression", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T1atlFeature(), theOCLPackage.getAttribute(), null, "t1atlFeature", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T1atlType(), theOCLPackage.getOclType(), null, "t1atlType", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T2qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t2qvtrExpression", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapHelper_Context(), this.getTmapHelper_Context(), null, "wmapHelper_Context", null, 0, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Attribute_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapHelper_Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_ContextEClass, TmapHelper_Context.class, "TmapHelper_Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapHelper_Context_T1atlContext(), theOCLPackage.getOclContextDefinition(), null, "t1atlContext", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T1atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t1atlDefinition", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T1atlHelper(), theATLPackage.getHelper(), null, "t1atlHelper", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T1atlReturnType(), theOCLPackage.getOclType(), null, "t1atlReturnType", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T2qvtrFunction(), theQVTbasePackage.getFunction(), null, "t2qvtrFunction", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_T2qvtrParameter(), theQVTbasePackage.getFunctionParameter(), null, "t2qvtrParameter", null, 1, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Context_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapHelper_Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapHelper_OperationEClass, TmapHelper_Operation.class, "TmapHelper_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapHelper_Operation_Dispatcher(), this.getDmapHelper(), this.getDmapHelper_DomapHelper_Operation(), "dispatcher", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapHelper_Operation_T0operationName(), ecorePackage.getEString(), "t0operationName", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T1atlDefinition(), theOCLPackage.getOclFeatureDefinition(), null, "t1atlDefinition", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T1atlExpression(), theOCLPackage.getOclExpression(), null, "t1atlExpression", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T1atlFeature(), theOCLPackage.getOperation(), null, "t1atlFeature", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T1atlType(), theOCLPackage.getOclType(), null, "t1atlType", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T2qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t2qvtrExpression", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapHelper_Context(), this.getTmapHelper_Context(), null, "wmapHelper_Context", null, 0, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapHelper_Operation_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapHelper_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapIfExpEClass, TmapIfExp.class, "TmapIfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapIfExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapIfExp(), "dispatcher", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T1atlCondition(), theOCLPackage.getOclExpression(), null, "t1atlCondition", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T1atlElse(), theOCLPackage.getOclExpression(), null, "t1atlElse", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T1atlThen(), theOCLPackage.getOclExpression(), null, "t1atlThen", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T2qvtrCondition(), thePivotPackage.getOCLExpression(), null, "t2qvtrCondition", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T2qvtrElse(), thePivotPackage.getOCLExpression(), null, "t2qvtrElse", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_T2qvtrThen(), thePivotPackage.getOCLExpression(), null, "t2qvtrThen", null, 1, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression1(), this.getDmapOclExpression(), null, "wmapOclExpression1", null, 0, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapIfExp_WmapOclExpression2(), this.getDmapOclExpression(), null, "wmapOclExpression2", null, 0, 1, TmapIfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapInPatternEClass, TmapInPattern.class, "TmapInPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapInPattern_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T1atlModel(), theOCLPackage.getOclModel(), null, "t1atlModel", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T1atlPattern(), theATLPackage.getInPattern(), null, "t1atlPattern", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T1atlRule(), theATLPackage.getMatchedRule(), null, "t1atlRule", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T2qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t2qvtrDomain", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_T2qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t2qvtrTypedModel", null, 1, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 0, 1, TmapInPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapInPattern_filterEClass, TmapInPattern_filter.class, "TmapInPattern_filter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapInPattern_filter_T1atlExpression(), theOCLPackage.getOclExpression(), null, "t1atlExpression", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T1atlPattern(), theATLPackage.getInPattern(), null, "t1atlPattern", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T1atlRule(), theATLPackage.getMatchedRule(), null, "t1atlRule", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T2p(), theQVTbasePackage.getPredicate(), null, "t2p", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T2qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t2qvtrDomain", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T2qvtrExpression(), thePivotPackage.getOCLExpression(), null, "t2qvtrExpression", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_T2w(), theQVTbasePackage.getPattern(), null, "t2w", null, 1, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapInPattern(), this.getTmapInPattern(), null, "wmapInPattern", null, 0, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapInPattern_filter_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapInPattern_filter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapIntegerExpEClass, TmapIntegerExp.class, "TmapIntegerExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapIntegerExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapIntegerExp(), "dispatcher", null, 1, 1, TmapIntegerExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapIntegerExp_T0symbol(), ecorePackage.getEBigInteger(), "t0symbol", null, 1, 1, TmapIntegerExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapMatchedRuleEClass, TmapMatchedRule.class, "TmapMatchedRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapMatchedRule_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapMatchedRule_T0ruleName(), ecorePackage.getEString(), "t0ruleName", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T1matchedRule(), theATLPackage.getMatchedRule(), null, "t1matchedRule", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T2_1(), theQVTrelationPackage.getSharedVariable(), null, "t2_1", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapMatchedRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapMatchedRule_superEClass, TmapMatchedRule_super.class, "TmapMatchedRule_super", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapMatchedRule_super_T1atlChildRule(), theATLPackage.getMatchedRule(), null, "t1atlChildRule", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T1atlSuperRule(), theATLPackage.getMatchedRule(), null, "t1atlSuperRule", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T2qvtrOverriddenRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrOverriddenRelation", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_T2qvtrOverridesRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrOverridesRelation", null, 1, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapMatchedRule_super_WmapMatchedRule1(), this.getTmapMatchedRule(), null, "wmapMatchedRule1", null, 0, 1, TmapMatchedRule_super.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapModuleEClass, TmapModule.class, "TmapModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapModule_T0txName(), ecorePackage.getEString(), "t0txName", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T2_1(), thePivotPackage.getPackage(), null, "t2_1", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T2_2(), thePivotPackage.getParameterVariable(), null, "t2_2", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T2_3(), theQVTbasePackage.getTypedModel(), null, "t2_3", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T2_4(), theQVTrelationPackage.getRelationModel(), null, "t2_4", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapModule_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapNavigationOrAttributeCallExp_HelperEClass, TmapNavigationOrAttributeCallExp_Helper.class, "TmapNavigationOrAttributeCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper(), "dispatcher", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Helper_T0propertyName(), ecorePackage.getEString(), "t0propertyName", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T1atlSource(), theOCLPackage.getOclExpression(), null, "t1atlSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation(), thePivotPackage.getOperation(), null, "t2qvtrOperation", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource(), thePivotPackage.getVariableExp(), null, "t2qvtrSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "t2qvtrSourceArgument", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapHelper(), this.getDmapHelper(), null, "wmapHelper", null, 0, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapNavigationOrAttributeCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapNavigationOrAttributeCallExp_PropertyEClass, TmapNavigationOrAttributeCallExp_Property.class, "TmapNavigationOrAttributeCallExp_Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property(), "dispatcher", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapNavigationOrAttributeCallExp_Property_T0propertyName(), ecorePackage.getEString(), "t0propertyName", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T1atlSource(), theOCLPackage.getOclExpression(), null, "t1atlSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_T2qvtrSource(), thePivotPackage.getOCLExpression(), null, "t2qvtrSource", null, 1, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapNavigationOrAttributeCallExp_Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclMetamodelEClass, TmapOclMetamodel.class, "TmapOclMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclMetamodel_T0tmName(), ecorePackage.getEString(), "t0tmName", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclMetamodel_T1oclMetamodel(), theOCLPackage.getOclModel(), null, "t1oclMetamodel", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclMetamodel_T2qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t2qvtrTypedModel", null, 1, 1, TmapOclMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclModel_INEClass, TmapOclModel_IN.class, "TmapOclModel_IN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclModel_IN_T0tmName(), ecorePackage.getEString(), "t0tmName", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T1oclMetamodel(), theOCLPackage.getOclModel(), null, "t1oclMetamodel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T1oclModel(), theOCLPackage.getOclModel(), null, "t1oclModel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_T2qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t2qvtrTypedModel", null, 1, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_IN_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 0, 1, TmapOclModel_IN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOclModel_OUTEClass, TmapOclModel_OUT.class, "TmapOclModel_OUT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOclModel_OUT_T0tmName(), ecorePackage.getEString(), "t0tmName", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T1atlModule(), theATLPackage.getModule(), null, "t1atlModule", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T1oclMetamodel(), theOCLPackage.getOclModel(), null, "t1oclMetamodel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T1oclModel(), theOCLPackage.getOclModel(), null, "t1oclModel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_T2qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t2qvtrTypedModel", null, 1, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOclModel_OUT_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 0, 1, TmapOclModel_OUT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_HelperEClass, TmapOperationCallExp_Helper.class, "TmapOperationCallExp_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperationCallExp_Helper_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperationCallExp_Helper(), "dispatcher", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Helper_T0operationName(), ecorePackage.getEString(), "t0operationName", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T1atlSource(), theOCLPackage.getOclExpression(), null, "t1atlSource", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T2qvtrOperation(), thePivotPackage.getOperation(), null, "t2qvtrOperation", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T2qvtrSource(), thePivotPackage.getVariableExp(), null, "t2qvtrSource", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T2qvtrSourceArgument(), thePivotPackage.getOCLExpression(), null, "t2qvtrSourceArgument", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapHelper(), this.getDmapHelper(), null, "wmapHelper", null, 0, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Helper_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapOperationCallExp_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_OperationEClass, TmapOperationCallExp_Operation.class, "TmapOperationCallExp_Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperationCallExp_Operation_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperationCallExp_Operation(), "dispatcher", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperationCallExp_Operation_T0operationName(), ecorePackage.getEString(), "t0operationName", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T1atlSource(), theOCLPackage.getOclExpression(), null, "t1atlSource", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_T2qvtrSource(), thePivotPackage.getOCLExpression(), null, "t2qvtrSource", null, 1, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_Operation_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapOperationCallExp_Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperationCallExp_argumentEClass, TmapOperationCallExp_argument.class, "TmapOperationCallExp_argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperationCallExp_argument_T1atlArgument(), theOCLPackage.getOclExpression(), null, "t1atlArgument", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T1atlParent(), theOCLPackage.getOperationCallExp(), null, "t1atlParent", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T2qvtrArgument(), thePivotPackage.getOCLExpression(), null, "t2qvtrArgument", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_T2qvtrParent(), thePivotPackage.getOperationCallExp(), null, "t2qvtrParent", null, 1, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperationCallExp_argument_WmapOclExpression1(), this.getDmapOclExpression(), null, "wmapOclExpression1", null, 0, 1, TmapOperationCallExp_argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOperatorCallExpEClass, TmapOperatorCallExp.class, "TmapOperatorCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapOperatorCallExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapOperatorCallExp(), "dispatcher", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapOperatorCallExp_T0operationName(), ecorePackage.getEString(), "t0operationName", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T1atlSource(), theOCLPackage.getOclExpression(), null, "t1atlSource", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T2qvtrSource(), thePivotPackage.getOCLExpression(), null, "t2qvtrSource", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_T2qvtrTransformation(), theQVTrelationPackage.getRelationalTransformation(), null, "t2qvtrTransformation", null, 1, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_WmapModule(), this.getTmapModule(), null, "wmapModule", null, 0, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOperatorCallExp_WmapOclExpression(), this.getDmapOclExpression(), null, "wmapOclExpression", null, 0, 1, TmapOperatorCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapOutPatternEClass, TmapOutPattern.class, "TmapOutPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapOutPattern_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_T1atlPattern(), theATLPackage.getOutPattern(), null, "t1atlPattern", null, 1, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_T1atlRule(), theATLPackage.getMatchedRule(), null, "t1atlRule", null, 1, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_T2qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t2qvtrDomain", null, 1, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_T2qvtrTypedModel(), theQVTbasePackage.getTypedModel(), null, "t2qvtrTypedModel", null, 1, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapOutPattern_WmapOclMetamodel(), this.getTmapOclMetamodel(), null, "wmapOclMetamodel", null, 0, 1, TmapOutPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapSimpleInPatternElementEClass, TmapSimpleInPatternElement.class, "TmapSimpleInPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapSimpleInPatternElement_T0elementName(), ecorePackage.getEString(), "t0elementName", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T1atlElement(), theATLPackage.getSimpleInPatternElement(), null, "t1atlElement", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T1atlPattern(), theATLPackage.getInPattern(), null, "t1atlPattern", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T1atlRule(), theATLPackage.getMatchedRule(), null, "t1atlRule", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T2qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t2qvtrDomain", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T2qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "t2qvtrPattern", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T2qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t2qvtrTemplate", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_T2qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "t2qvtrVariable", null, 1, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapInPattern(), this.getTmapInPattern(), null, "wmapInPattern", null, 0, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleInPatternElement_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapSimpleInPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapSimpleOutPatternElementEClass, TmapSimpleOutPatternElement.class, "TmapSimpleOutPatternElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapSimpleOutPatternElement_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapSimpleOutPatternElement_T0elementName(), ecorePackage.getEString(), "t0elementName", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T1atlElement(), theATLPackage.getSimpleOutPatternElement(), null, "t1atlElement", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T1atlPattern(), theATLPackage.getOutPattern(), null, "t1atlPattern", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T1atlRule(), theATLPackage.getMatchedRule(), null, "t1atlRule", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T2qvtrDomain(), theQVTrelationPackage.getRelationDomain(), null, "t2qvtrDomain", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T2qvtrPattern(), theQVTrelationPackage.getDomainPattern(), null, "t2qvtrPattern", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T2qvtrRelation(), theQVTrelationPackage.getRelation(), null, "t2qvtrRelation", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T2qvtrTemplate(), theQVTtemplatePackage.getObjectTemplateExp(), null, "t2qvtrTemplate", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_T2qvtrVariable(), theQVTrelationPackage.getTemplateVariable(), null, "t2qvtrVariable", null, 1, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapMatchedRule(), this.getTmapMatchedRule(), null, "wmapMatchedRule", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapOutPattern(), this.getTmapOutPattern(), null, "wmapOutPattern", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapSimpleOutPatternElement_WmapVariable(), this.getTmapVariable(), null, "wmapVariable", null, 0, 1, TmapSimpleOutPatternElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapStringExpEClass, TmapStringExp.class, "TmapStringExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapStringExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapStringExp(), "dispatcher", null, 1, 1, TmapStringExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapStringExp_T0symbol(), ecorePackage.getEString(), "t0symbol", null, 1, 1, TmapStringExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableEClass, TmapVariable.class, "TmapVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTmapVariable_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariable_T1atlVariable(), theATLPackage.getLocatedElement(), null, "t1atlVariable", null, 1, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariable_T2qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t2qvtrVariable", null, 1, 1, TmapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExpEClass, TmapVariableExp.class, "TmapVariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_Dispatcher(), this.getDmapOclExpression(), this.getDmapOclExpression_DomapVariableExp(), "dispatcher", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTmapVariableExp_T0varName(), ecorePackage.getEString(), "t0varName", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_T1atlVariable(), theOCLPackage.getVariableDeclaration(), null, "t1atlVariable", null, 1, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_WmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable(), null, "wmapVariableExp_referredVariable", null, 0, 1, TmapVariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExp_referredVariable_HelperEClass, TmapVariableExp_referredVariable_Helper.class, "TmapVariableExp_referredVariable_Helper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_referredVariable_Helper_Dispatcher(), this.getDmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper(), "dispatcher", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_Helper_T1atlVariable(), theOCLPackage.getVariableDeclaration(), null, "t1atlVariable", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_Helper_T2qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t2qvtrVariable", null, 1, 1, TmapVariableExp_referredVariable_Helper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tmapVariableExp_referredVariable_VariableDeclarationEClass, TmapVariableExp_referredVariable_VariableDeclaration.class, "TmapVariableExp_referredVariable_VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher(), this.getDmapVariableExp_referredVariable(), this.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration(), "dispatcher", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable(), theATLPackage.getPatternElement(), null, "t1atlVariable", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable(), thePivotPackage.getVariableDeclaration(), null, "t2qvtrVariable", null, 1, 1, TmapVariableExp_referredVariable_VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		(getDmapHelper_D1atlHelper(),
			source,
			new String[] {
				"body", "DmapHelper"
		});
		addAnnotation
		(getDmapHelper_D2qvtrFunction(),
			source,
			new String[] {
				"body", "DmapHelper"
		});
		addAnnotation
		(getDmapOclExpression_D1atlExpression(),
			source,
			new String[] {
				"body", "DmapOclExpression"
		});
		addAnnotation
		(getDmapOclExpression_D2qvtrExpression(),
			source,
			new String[] {
				"body", "DmapOclExpression"
		});
		addAnnotation
		(getDmapVariableExp_referredVariable_D1atlExpression(),
			source,
			new String[] {
				"body", "DmapVariableExp_referredVariable"
		});
		addAnnotation
		(getDmapVariableExp_referredVariable_D2qvtrExpression(),
			source,
			new String[] {
				"body", "DmapVariableExp_referredVariable"
		});
		addAnnotation
		(getTmapBinding_T1atlBinding(),
			source,
			new String[] {
				"body", "TmapBinding"
		});
		addAnnotation
		(getTmapBinding_T2qvtrPart(),
			source,
			new String[] {
				"body", "TmapBinding"
		});
		addAnnotation
		(getTmapHelper_Context_T1atlHelper(),
			source,
			new String[] {
				"body", "TmapHelper_Context"
		});
		addAnnotation
		(getTmapHelper_Context_T2qvtrFunction(),
			source,
			new String[] {
				"body", "TmapHelper_Context"
		});
		addAnnotation
		(getTmapInPattern_T1atlPattern(),
			source,
			new String[] {
				"body", "TmapInPattern"
		});
		addAnnotation
		(getTmapInPattern_T2qvtrDomain(),
			source,
			new String[] {
				"body", "TmapInPattern"
		});
		addAnnotation
		(getTmapInPattern_filter_T1atlPattern(),
			source,
			new String[] {
				"body", "TmapInPattern_filter"
		});
		addAnnotation
		(getTmapInPattern_filter_T2qvtrDomain(),
			source,
			new String[] {
				"body", "TmapInPattern_filter"
		});
		addAnnotation
		(getTmapMatchedRule_T1matchedRule(),
			source,
			new String[] {
				"body", "TmapMatchedRule"
		});
		addAnnotation
		(getTmapMatchedRule_T2qvtrRelation(),
			source,
			new String[] {
				"body", "TmapMatchedRule"
		});
		addAnnotation
		(getTmapMatchedRule_super_T1atlChildRule(),
			source,
			new String[] {
				"body", "TmapMatchedRule_super"
		});
		addAnnotation
		(getTmapMatchedRule_super_T2qvtrOverridesRelation(),
			source,
			new String[] {
				"body", "TmapMatchedRule_super"
		});
		addAnnotation
		(getTmapModule_T1atlModule(),
			source,
			new String[] {
				"body", "TmapModule"
		});
		addAnnotation
		(getTmapModule_T2qvtrTransformation(),
			source,
			new String[] {
				"body", "TmapModule"
		});
		addAnnotation
		(getTmapOclMetamodel_T1oclMetamodel(),
			source,
			new String[] {
				"body", "TmapOclMetamodel"
		});
		addAnnotation
		(getTmapOclMetamodel_T2qvtrTypedModel(),
			source,
			new String[] {
				"body", "TmapOclMetamodel"
		});
		addAnnotation
		(getTmapOclModel_IN_T1oclModel(),
			source,
			new String[] {
				"body", "TmapOclModel_IN"
		});
		addAnnotation
		(getTmapOclModel_IN_T2qvtrTypedModel(),
			source,
			new String[] {
				"body", "TmapOclModel_IN"
		});
		addAnnotation
		(getTmapOclModel_OUT_T1oclModel(),
			source,
			new String[] {
				"body", "TmapOclModel_OUT"
		});
		addAnnotation
		(getTmapOclModel_OUT_T2qvtrTypedModel(),
			source,
			new String[] {
				"body", "TmapOclModel_OUT"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T1atlArgument(),
			source,
			new String[] {
				"body", "TmapOperationCallExp_argument"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T2qvtrArgument(),
			source,
			new String[] {
				"body", "TmapOperationCallExp_argument"
		});
		addAnnotation
		(getTmapOutPattern_T1atlPattern(),
			source,
			new String[] {
				"body", "TmapOutPattern"
		});
		addAnnotation
		(getTmapOutPattern_T2qvtrDomain(),
			source,
			new String[] {
				"body", "TmapOutPattern"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T1atlElement(),
			source,
			new String[] {
				"body", "TmapSimpleInPatternElement"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrTemplate(),
			source,
			new String[] {
				"body", "TmapSimpleInPatternElement"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T1atlElement(),
			source,
			new String[] {
				"body", "TmapSimpleOutPatternElement"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrTemplate(),
			source,
			new String[] {
				"body", "TmapSimpleOutPatternElement"
		});
		addAnnotation
		(getTmapVariable_T1atlVariable(),
			source,
			new String[] {
				"body", "TmapVariable"
		});
		addAnnotation
		(getTmapVariable_T2qvtrVariable(),
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
		(getDmapHelper_D1atlHelper(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getDmapHelper_D2qvtrFunction(),
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
		(getDmapOclExpression_D1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getDmapOclExpression_D2qvtrExpression(),
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
		(getDmapVariableExp_referredVariable_D1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getDmapVariableExp_referredVariable_D2qvtrExpression(),
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
		(getTmapBinding_T0propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapBinding_T1atlBinding(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapBinding_T1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapBinding_T1atlOutPatternElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapBinding_T2qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapBinding_T2qvtrPart(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapBinding_T2qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapBooleanExp_T0symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapHelper_Attribute_T0attributeName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapHelper_Attribute_T1atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Attribute_T1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Attribute_T1atlFeature(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Attribute_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Attribute_T1atlType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Attribute_T2qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapHelper_Attribute_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapHelper_Context_T1atlContext(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Context_T1atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Context_T1atlHelper(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Context_T1atlReturnType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Context_T2qvtrFunction(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapHelper_Context_T2qvtrParameter(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapHelper_Operation_T0operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapHelper_Operation_T1atlDefinition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Operation_T1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Operation_T1atlFeature(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Operation_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Operation_T1atlType(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapHelper_Operation_T2qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapHelper_Operation_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapIfExp_T1atlCondition(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapIfExp_T1atlElse(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapIfExp_T1atlThen(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapIfExp_T2qvtrCondition(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapIfExp_T2qvtrElse(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapIfExp_T2qvtrThen(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_T1atlModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_T1atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_T1atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_T2qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_T2qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_filter_T1atlExpression(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_filter_T1atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_filter_T1atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapInPattern_filter_T2p(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_filter_T2qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_filter_T2qvtrExpression(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_filter_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapInPattern_filter_T2w(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapIntegerExp_T0symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapMatchedRule_T0ruleName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapMatchedRule_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapMatchedRule_T1matchedRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapMatchedRule_T2_1(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapMatchedRule_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapMatchedRule_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapMatchedRule_super_T1atlChildRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapMatchedRule_super_T1atlSuperRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapMatchedRule_super_T2qvtrOverriddenRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapMatchedRule_super_T2qvtrOverridesRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapModule_T0txName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapModule_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapModule_T2_1(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapModule_T2_2(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapModule_T2_3(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapModule_T2_4(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapModule_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T0propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T1atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Property_T0propertyName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Property_T1atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapNavigationOrAttributeCallExp_Property_T2qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOclMetamodel_T0tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOclMetamodel_T1oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclMetamodel_T2qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOclModel_IN_T0tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOclModel_IN_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_IN_T1oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_IN_T1oclModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_IN_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOclModel_IN_T2qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOclModel_OUT_T0tmName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOclModel_OUT_T1atlModule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_OUT_T1oclMetamodel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_OUT_T1oclModel(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOclModel_OUT_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOclModel_OUT_T2qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T0operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T1atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T2qvtrOperation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T2qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T2qvtrSourceArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_Helper_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_Operation_T0operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOperationCallExp_Operation_T1atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOperationCallExp_Operation_T2qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T1atlArgument(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T1atlParent(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T2qvtrArgument(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperationCallExp_argument_T2qvtrParent(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperatorCallExp_T0operationName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapOperatorCallExp_T1atlSource(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOperatorCallExp_T2qvtrSource(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOperatorCallExp_T2qvtrTransformation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOutPattern_T1atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOutPattern_T1atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapOutPattern_T2qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOutPattern_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapOutPattern_T2qvtrTypedModel(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T0elementName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T1atlElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T1atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T1atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrPattern(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleInPatternElement_T2qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T0elementName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T1atlElement(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T1atlPattern(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T1atlRule(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrDomain(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrPattern(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrRelation(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrTemplate(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapSimpleOutPatternElement_T2qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapStringExp_T0symbol(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapVariable_T1atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapVariable_T2qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapVariableExp_T0varName(),
			source,
			new String[] {
				"referredDomain", "$primitive$"
		});
		addAnnotation
		(getTmapVariableExp_T1atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapVariableExp_referredVariable_Helper_T1atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapVariableExp_referredVariable_Helper_T2qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
		addAnnotation
		(getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable(),
			source,
			new String[] {
				"referredDomain", "atl"
		});
		addAnnotation
		(getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable(),
			source,
			new String[] {
				"referredDomain", "qvtr"
		});
	}

} //trace_ATL2QVTrPackageImpl
