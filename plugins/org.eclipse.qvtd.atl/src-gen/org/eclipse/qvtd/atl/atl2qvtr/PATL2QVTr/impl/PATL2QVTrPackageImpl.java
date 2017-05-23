/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.atl.common.ATL.ATLPackage;

import org.eclipse.m2m.atl.common.OCL.OCLPackage;

import org.eclipse.m2m.atl.common.PrimitiveTypes.PrimitiveTypesPackage;

import org.eclipse.ocl.pivot.PivotPackage;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;

import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PATL2QVTrPackageImpl extends EPackageImpl implements PATL2QVTrPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sInPattern2RelationDomain_guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sOclExpression2OCLExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tHelper2FunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInPattern2RelationDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInPattern2RelationDomain_guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tMatchedRule2RelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tModel2RelationalTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOclExpression2OCLExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOclModel2ModelParameter_createEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOclModel2ModelParameter_fromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOperationCallExp2OperationCallExpEClass = null;

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PATL2QVTrPackageImpl() {
		super(eNS_URI, PATL2QVTrFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PATL2QVTrPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PATL2QVTrPackage init() {
		if (isInited) return (PATL2QVTrPackage)EPackage.Registry.INSTANCE.getEPackage(PATL2QVTrPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PATL2QVTrPackageImpl thePATL2QVTrPackage = (PATL2QVTrPackageImpl)(ePackage instanceof PATL2QVTrPackageImpl ? ePackage : new PATL2QVTrPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PATL2QVTrPackageImpl thePATL2QVTrPackage_1 = (PATL2QVTrPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PATL2QVTrPackage.eNS_URI) instanceof PATL2QVTrPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PATL2QVTrPackage.eNS_URI) : PATL2QVTrPackage.eINSTANCE);

		// Create package meta-data objects
		thePATL2QVTrPackage.createPackageContents();
		thePATL2QVTrPackage_1.createPackageContents();

		// Initialize created meta-data
		thePATL2QVTrPackage.initializePackageContents();
		thePATL2QVTrPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePATL2QVTrPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PATL2QVTrPackage.eNS_URI, thePATL2QVTrPackage);
		return thePATL2QVTrPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSInPattern2RelationDomain_guard() {
		return sInPattern2RelationDomain_guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSInPattern2RelationDomain_guard_APattern() {
		return (EReference)sInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSInPattern2RelationDomain_guard_RRule() {
		return (EReference)sInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSOclExpression2OCLExpression() {
		return sOclExpression2OCLExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSOclExpression2OCLExpression_AExpression() {
		return (EReference)sOclExpression2OCLExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSOclExpression2OCLExpression_RExpression() {
		return (EReference)sOclExpression2OCLExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTHelper2Function() {
		return tHelper2FunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_ADef() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_AFeat() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_AModule() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_Function() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_Helper() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTHelper2Function_OpName() {
		return (EAttribute)tHelper2FunctionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHelper2Function_RelTx() {
		return (EReference)tHelper2FunctionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInPattern2RelationDomain() {
		return tInPattern2RelationDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_APattern() {
		return (EReference)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_ARule() {
		return (EReference)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_RDomain() {
		return (EReference)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_RRule() {
		return (EReference)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInPattern2RelationDomain_TmName() {
		return (EAttribute)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_Where_InPattern2RelationDomain_guard() {
		return (EReference)tInPattern2RelationDomainEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInPattern2RelationDomain_guard() {
		return tInPattern2RelationDomain_guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_AExpression() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_APattern() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_P() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_RExpression() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_RRule() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_W() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInPattern2RelationDomain_guard_When_OclExpression2OCLExpression() {
		return (EReference)tInPattern2RelationDomain_guardEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTMatchedRule2Relation() {
		return tMatchedRule2RelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTMatchedRule2Relation_AModule() {
		return (EReference)tMatchedRule2RelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTMatchedRule2Relation_MatchedRule() {
		return (EReference)tMatchedRule2RelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTMatchedRule2Relation_RRule() {
		return (EReference)tMatchedRule2RelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTMatchedRule2Relation_RelTx() {
		return (EReference)tMatchedRule2RelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTMatchedRule2Relation_RuleName() {
		return (EAttribute)tMatchedRule2RelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTModel2RelationalTransformation() {
		return tModel2RelationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTModel2RelationalTransformation__3() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTModel2RelationalTransformation__4() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTModel2RelationalTransformation_Module() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTModel2RelationalTransformation_RelTx() {
		return (EReference)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTModel2RelationalTransformation_TxName() {
		return (EAttribute)tModel2RelationalTransformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOclExpression2OCLExpression() {
		return tOclExpression2OCLExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclExpression2OCLExpression_AExpression() {
		return (EReference)tOclExpression2OCLExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclExpression2OCLExpression_RExpression() {
		return (EReference)tOclExpression2OCLExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOclModel2ModelParameter_create() {
		return tOclModel2ModelParameter_createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_create_AModule() {
		return (EReference)tOclModel2ModelParameter_createEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_create_OclModel() {
		return (EReference)tOclModel2ModelParameter_createEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_create_RelTM() {
		return (EReference)tOclModel2ModelParameter_createEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_create_RelTx() {
		return (EReference)tOclModel2ModelParameter_createEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOclModel2ModelParameter_create_TmName() {
		return (EAttribute)tOclModel2ModelParameter_createEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOclModel2ModelParameter_from() {
		return tOclModel2ModelParameter_fromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_from_AModule() {
		return (EReference)tOclModel2ModelParameter_fromEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_from_OclModel() {
		return (EReference)tOclModel2ModelParameter_fromEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_from_RelTM() {
		return (EReference)tOclModel2ModelParameter_fromEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOclModel2ModelParameter_from_RelTx() {
		return (EReference)tOclModel2ModelParameter_fromEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOclModel2ModelParameter_from_TmName() {
		return (EAttribute)tOclModel2ModelParameter_fromEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOperationCallExp2OperationCallExp() {
		return tOperationCallExp2OperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperationCallExp2OperationCallExp_AExpression() {
		return (EReference)tOperationCallExp2OperationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperationCallExp2OperationCallExp_RExpression() {
		return (EReference)tOperationCallExp2OperationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PATL2QVTrFactory getPATL2QVTrFactory() {
		return (PATL2QVTrFactory)getEFactoryInstance();
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
		sInPattern2RelationDomain_guardEClass = createEClass(SIN_PATTERN2_RELATION_DOMAIN_GUARD);
		createEReference(sInPattern2RelationDomain_guardEClass, SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN);
		createEReference(sInPattern2RelationDomain_guardEClass, SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE);

		sOclExpression2OCLExpressionEClass = createEClass(SOCL_EXPRESSION2_OCL_EXPRESSION);
		createEReference(sOclExpression2OCLExpressionEClass, SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION);
		createEReference(sOclExpression2OCLExpressionEClass, SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION);

		tHelper2FunctionEClass = createEClass(THELPER2_FUNCTION);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__ADEF);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__AFEAT);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__AMODULE);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__FUNCTION);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__HELPER);
		createEAttribute(tHelper2FunctionEClass, THELPER2_FUNCTION__OP_NAME);
		createEReference(tHelper2FunctionEClass, THELPER2_FUNCTION__REL_TX);

		tInPattern2RelationDomainEClass = createEClass(TIN_PATTERN2_RELATION_DOMAIN);
		createEReference(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__APATTERN);
		createEReference(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__ARULE);
		createEReference(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN);
		createEReference(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__RRULE);
		createEAttribute(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__TM_NAME);
		createEReference(tInPattern2RelationDomainEClass, TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD);

		tInPattern2RelationDomain_guardEClass = createEClass(TIN_PATTERN2_RELATION_DOMAIN_GUARD);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__P);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__W);
		createEReference(tInPattern2RelationDomain_guardEClass, TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION);

		tMatchedRule2RelationEClass = createEClass(TMATCHED_RULE2_RELATION);
		createEReference(tMatchedRule2RelationEClass, TMATCHED_RULE2_RELATION__AMODULE);
		createEReference(tMatchedRule2RelationEClass, TMATCHED_RULE2_RELATION__MATCHED_RULE);
		createEReference(tMatchedRule2RelationEClass, TMATCHED_RULE2_RELATION__RRULE);
		createEReference(tMatchedRule2RelationEClass, TMATCHED_RULE2_RELATION__REL_TX);
		createEAttribute(tMatchedRule2RelationEClass, TMATCHED_RULE2_RELATION__RULE_NAME);

		tModel2RelationalTransformationEClass = createEClass(TMODEL2_RELATIONAL_TRANSFORMATION);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__3);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__4);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__MODULE);
		createEReference(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__REL_TX);
		createEAttribute(tModel2RelationalTransformationEClass, TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME);

		tOclExpression2OCLExpressionEClass = createEClass(TOCL_EXPRESSION2_OCL_EXPRESSION);
		createEReference(tOclExpression2OCLExpressionEClass, TOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION);
		createEReference(tOclExpression2OCLExpressionEClass, TOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION);

		tOclModel2ModelParameter_createEClass = createEClass(TOCL_MODEL2_MODEL_PARAMETER_CREATE);
		createEReference(tOclModel2ModelParameter_createEClass, TOCL_MODEL2_MODEL_PARAMETER_CREATE__AMODULE);
		createEReference(tOclModel2ModelParameter_createEClass, TOCL_MODEL2_MODEL_PARAMETER_CREATE__OCL_MODEL);
		createEReference(tOclModel2ModelParameter_createEClass, TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TM);
		createEReference(tOclModel2ModelParameter_createEClass, TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TX);
		createEAttribute(tOclModel2ModelParameter_createEClass, TOCL_MODEL2_MODEL_PARAMETER_CREATE__TM_NAME);

		tOclModel2ModelParameter_fromEClass = createEClass(TOCL_MODEL2_MODEL_PARAMETER_FROM);
		createEReference(tOclModel2ModelParameter_fromEClass, TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE);
		createEReference(tOclModel2ModelParameter_fromEClass, TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL);
		createEReference(tOclModel2ModelParameter_fromEClass, TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM);
		createEReference(tOclModel2ModelParameter_fromEClass, TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX);
		createEAttribute(tOclModel2ModelParameter_fromEClass, TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME);

		tOperationCallExp2OperationCallExpEClass = createEClass(TOPERATION_CALL_EXP2_OPERATION_CALL_EXP);
		createEReference(tOperationCallExp2OperationCallExpEClass, TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION);
		createEReference(tOperationCallExp2OperationCallExpEClass, TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION);
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
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		PATL2QVTrPackage thePATL2QVTrPackage_1 = (PATL2QVTrPackage)EPackage.Registry.INSTANCE.getEPackage(PATL2QVTrPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(sInPattern2RelationDomain_guardEClass, SInPattern2RelationDomain_guard.class, "SInPattern2RelationDomain_guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSInPattern2RelationDomain_guard_APattern(), theATLPackage.getInPattern(), null, "aPattern", null, 1, 1, SInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSInPattern2RelationDomain_guard_RRule(), theQVTrelationPackage.getRelation(), null, "rRule", null, 1, 1, SInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sOclExpression2OCLExpressionEClass, SOclExpression2OCLExpression.class, "SOclExpression2OCLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOclExpression2OCLExpression_AExpression(), theOCLPackage.getOclExpression(), null, "aExpression", null, 1, 1, SOclExpression2OCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOclExpression2OCLExpression_RExpression(), thePivotPackage.getOCLExpression(), null, "rExpression", null, 1, 1, SOclExpression2OCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tHelper2FunctionEClass, THelper2Function.class, "THelper2Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTHelper2Function_ADef(), theOCLPackage.getOclFeatureDefinition(), null, "aDef", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHelper2Function_AFeat(), theOCLPackage.getOperation(), null, "aFeat", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHelper2Function_AModule(), theATLPackage.getModule(), null, "aModule", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHelper2Function_Function(), theQVTbasePackage.getFunction(), null, "function", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHelper2Function_Helper(), theATLPackage.getHelper(), null, "helper", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTHelper2Function_OpName(), ecorePackage.getEString(), "opName", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHelper2Function_RelTx(), theQVTrelationPackage.getRelationalTransformation(), null, "relTx", null, 1, 1, THelper2Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tInPattern2RelationDomainEClass, TInPattern2RelationDomain.class, "TInPattern2RelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTInPattern2RelationDomain_APattern(), theATLPackage.getInPattern(), null, "aPattern", null, 1, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_ARule(), theATLPackage.getMatchedRule(), null, "aRule", null, 1, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_RDomain(), theQVTrelationPackage.getRelationDomain(), null, "rDomain", null, 1, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_RRule(), theQVTrelationPackage.getRelation(), null, "rRule", null, 1, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInPattern2RelationDomain_TmName(), ecorePackage.getEString(), "tmName", null, 1, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_Where_InPattern2RelationDomain_guard(), thePATL2QVTrPackage_1.getSInPattern2RelationDomain_guard(), null, "where_InPattern2RelationDomain_guard", null, 0, 1, TInPattern2RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tInPattern2RelationDomain_guardEClass, TInPattern2RelationDomain_guard.class, "TInPattern2RelationDomain_guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTInPattern2RelationDomain_guard_AExpression(), theOCLPackage.getOperationCallExp(), null, "aExpression", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_APattern(), theATLPackage.getInPattern(), null, "aPattern", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_P(), theQVTbasePackage.getPredicate(), null, "p", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_RExpression(), thePivotPackage.getOperationCallExp(), null, "rExpression", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_RRule(), theQVTrelationPackage.getRelation(), null, "rRule", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_W(), theQVTbasePackage.getPattern(), null, "w", null, 1, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInPattern2RelationDomain_guard_When_OclExpression2OCLExpression(), thePATL2QVTrPackage_1.getSOclExpression2OCLExpression(), null, "when_OclExpression2OCLExpression", null, 0, 1, TInPattern2RelationDomain_guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tMatchedRule2RelationEClass, TMatchedRule2Relation.class, "TMatchedRule2Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTMatchedRule2Relation_AModule(), theATLPackage.getModule(), null, "aModule", null, 1, 1, TMatchedRule2Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTMatchedRule2Relation_MatchedRule(), theATLPackage.getMatchedRule(), null, "matchedRule", null, 1, 1, TMatchedRule2Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTMatchedRule2Relation_RRule(), theQVTrelationPackage.getRelation(), null, "rRule", null, 1, 1, TMatchedRule2Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTMatchedRule2Relation_RelTx(), theQVTrelationPackage.getRelationalTransformation(), null, "relTx", null, 1, 1, TMatchedRule2Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTMatchedRule2Relation_RuleName(), ecorePackage.getEString(), "ruleName", null, 1, 1, TMatchedRule2Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tModel2RelationalTransformationEClass, TModel2RelationalTransformation.class, "TModel2RelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTModel2RelationalTransformation__3(), thePivotPackage.getPackage(), null, "_3", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation__4(), theQVTrelationPackage.getRelationModel(), null, "_4", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation_Module(), theATLPackage.getModule(), null, "module", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTModel2RelationalTransformation_RelTx(), theQVTrelationPackage.getRelationalTransformation(), null, "relTx", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTModel2RelationalTransformation_TxName(), ecorePackage.getEString(), "txName", null, 1, 1, TModel2RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOclExpression2OCLExpressionEClass, TOclExpression2OCLExpression.class, "TOclExpression2OCLExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOclExpression2OCLExpression_AExpression(), theOCLPackage.getOclExpression(), null, "aExpression", null, 1, 1, TOclExpression2OCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclExpression2OCLExpression_RExpression(), thePivotPackage.getOCLExpression(), null, "rExpression", null, 1, 1, TOclExpression2OCLExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOclModel2ModelParameter_createEClass, TOclModel2ModelParameter_create.class, "TOclModel2ModelParameter_create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOclModel2ModelParameter_create_AModule(), theATLPackage.getModule(), null, "aModule", null, 1, 1, TOclModel2ModelParameter_create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_create_OclModel(), theOCLPackage.getOclModel(), null, "oclModel", null, 1, 1, TOclModel2ModelParameter_create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_create_RelTM(), theQVTbasePackage.getTypedModel(), null, "relTM", null, 1, 1, TOclModel2ModelParameter_create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_create_RelTx(), theQVTrelationPackage.getRelationalTransformation(), null, "relTx", null, 1, 1, TOclModel2ModelParameter_create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOclModel2ModelParameter_create_TmName(), ecorePackage.getEString(), "tmName", null, 1, 1, TOclModel2ModelParameter_create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOclModel2ModelParameter_fromEClass, TOclModel2ModelParameter_from.class, "TOclModel2ModelParameter_from", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOclModel2ModelParameter_from_AModule(), theATLPackage.getModule(), null, "aModule", null, 1, 1, TOclModel2ModelParameter_from.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_from_OclModel(), theOCLPackage.getOclModel(), null, "oclModel", null, 1, 1, TOclModel2ModelParameter_from.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_from_RelTM(), theQVTbasePackage.getTypedModel(), null, "relTM", null, 1, 1, TOclModel2ModelParameter_from.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOclModel2ModelParameter_from_RelTx(), theQVTrelationPackage.getRelationalTransformation(), null, "relTx", null, 1, 1, TOclModel2ModelParameter_from.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOclModel2ModelParameter_from_TmName(), ecorePackage.getEString(), "tmName", null, 1, 1, TOclModel2ModelParameter_from.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOperationCallExp2OperationCallExpEClass, TOperationCallExp2OperationCallExp.class, "TOperationCallExp2OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOperationCallExp2OperationCallExp_AExpression(), theOCLPackage.getOperationCallExp(), null, "aExpression", null, 1, 1, TOperationCallExp2OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperationCallExp2OperationCallExp_RExpression(), thePivotPackage.getOperationCallExp(), null, "rExpression", null, 1, 1, TOperationCallExp2OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getSInPattern2RelationDomain_guard_APattern(), 
		   source, 
		   new String[] {
			 "body", "SInPattern2RelationDomain_guard",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getSInPattern2RelationDomain_guard_RRule(), 
		   source, 
		   new String[] {
			 "body", "SInPattern2RelationDomain_guard",
			 "unique", "false",
			 "upper", "*"
		   });	
		addAnnotation
		  (getSOclExpression2OCLExpression_AExpression(), 
		   source, 
		   new String[] {
			 "body", "SOclExpression2OCLExpression"
		   });	
		addAnnotation
		  (getSOclExpression2OCLExpression_RExpression(), 
		   source, 
		   new String[] {
			 "body", "SOclExpression2OCLExpression"
		   });	
		addAnnotation
		  (getTHelper2Function_ADef(), 
		   source, 
		   new String[] {
			 "body", "THelper2Function"
		   });	
		addAnnotation
		  (getTHelper2Function_AFeat(), 
		   source, 
		   new String[] {
			 "body", "THelper2Function"
		   });	
		addAnnotation
		  (getTHelper2Function_Function(), 
		   source, 
		   new String[] {
			 "body", "THelper2Function"
		   });	
		addAnnotation
		  (getTHelper2Function_Helper(), 
		   source, 
		   new String[] {
			 "body", "THelper2Function"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_APattern(), 
		   source, 
		   new String[] {
			 "body", "TInPattern2RelationDomain"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_ARule(), 
		   source, 
		   new String[] {
			 "body", "TInPattern2RelationDomain"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_RDomain(), 
		   source, 
		   new String[] {
			 "body", "TInPattern2RelationDomain"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_MatchedRule(), 
		   source, 
		   new String[] {
			 "body", "TMatchedRule2Relation"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_RRule(), 
		   source, 
		   new String[] {
			 "body", "TMatchedRule2Relation"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation_Module(), 
		   source, 
		   new String[] {
			 "body", "TModel2RelationalTransformation"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation_RelTx(), 
		   source, 
		   new String[] {
			 "body", "TModel2RelationalTransformation"
		   });	
		addAnnotation
		  (getTOclExpression2OCLExpression_AExpression(), 
		   source, 
		   new String[] {
			 "body", "TOclExpression2OCLExpression"
		   });	
		addAnnotation
		  (getTOclExpression2OCLExpression_RExpression(), 
		   source, 
		   new String[] {
			 "body", "TOclExpression2OCLExpression"
		   });	
		addAnnotation
		  (getTOperationCallExp2OperationCallExp_AExpression(), 
		   source, 
		   new String[] {
			 "body", "TOperationCallExp2OperationCallExp"
		   });	
		addAnnotation
		  (getTOperationCallExp2OperationCallExp_RExpression(), 
		   source, 
		   new String[] {
			 "body", "TOperationCallExp2OperationCallExp"
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
		  (getSInPattern2RelationDomain_guard_APattern(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getSInPattern2RelationDomain_guard_RRule(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getSOclExpression2OCLExpression_AExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getSOclExpression2OCLExpression_RExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTHelper2Function_ADef(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTHelper2Function_AFeat(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTHelper2Function_AModule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTHelper2Function_Function(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTHelper2Function_Helper(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTHelper2Function_RelTx(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_APattern(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_ARule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_RDomain(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_RRule(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_AExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_APattern(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_P(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_RExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_RRule(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTInPattern2RelationDomain_guard_W(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_AModule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_MatchedRule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_RRule(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTMatchedRule2Relation_RelTx(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation__3(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation__4(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation_Module(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTModel2RelationalTransformation_RelTx(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOclExpression2OCLExpression_AExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOclExpression2OCLExpression_RExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_create_AModule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_create_OclModel(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_create_RelTM(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_create_RelTx(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_from_AModule(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_from_OclModel(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_from_RelTM(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOclModel2ModelParameter_from_RelTx(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });	
		addAnnotation
		  (getTOperationCallExp2OperationCallExp_AExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "atl"
		   });	
		addAnnotation
		  (getTOperationCallExp2OperationCallExp_RExpression(), 
		   source, 
		   new String[] {
			 "referredDomain", "qvtr"
		   });
	}

} //PATL2QVTrPackageImpl
