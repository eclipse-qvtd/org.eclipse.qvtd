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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PATL2QVTrFactoryImpl extends EFactoryImpl implements PATL2QVTrFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PATL2QVTrFactory init() {
		try {
			PATL2QVTrFactory thePATL2QVTrFactory = (PATL2QVTrFactory)EPackage.Registry.INSTANCE.getEFactory(PATL2QVTrPackage.eNS_URI);
			if (thePATL2QVTrFactory != null) {
				return thePATL2QVTrFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PATL2QVTrFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PATL2QVTrFactoryImpl() {
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
			case PATL2QVTrPackage.SIN_PATTERN2_RELATION_DOMAIN_GUARD: return createSInPattern2RelationDomain_guard();
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION: return createSOclExpression2OCLExpression();
			case PATL2QVTrPackage.THELPER2_FUNCTION: return createTHelper2Function();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN: return createTInPattern2RelationDomain();
			case PATL2QVTrPackage.TIN_PATTERN2_RELATION_DOMAIN_GUARD: return createTInPattern2RelationDomain_guard();
			case PATL2QVTrPackage.TMATCHED_RULE2_RELATION: return createTMatchedRule2Relation();
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION: return createTModel2RelationalTransformation();
			case PATL2QVTrPackage.TOCL_EXPRESSION2_OCL_EXPRESSION: return createTOclExpression2OCLExpression();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_CREATE: return createTOclModel2ModelParameter_create();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM: return createTOclModel2ModelParameter_from();
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP: return createTOperationCallExp2OperationCallExp();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SInPattern2RelationDomain_guard createSInPattern2RelationDomain_guard() {
		SInPattern2RelationDomain_guardImpl sInPattern2RelationDomain_guard = new SInPattern2RelationDomain_guardImpl();
		return sInPattern2RelationDomain_guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOclExpression2OCLExpression createSOclExpression2OCLExpression() {
		SOclExpression2OCLExpressionImpl sOclExpression2OCLExpression = new SOclExpression2OCLExpressionImpl();
		return sOclExpression2OCLExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public THelper2Function createTHelper2Function() {
		THelper2FunctionImpl tHelper2Function = new THelper2FunctionImpl();
		return tHelper2Function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInPattern2RelationDomain createTInPattern2RelationDomain() {
		TInPattern2RelationDomainImpl tInPattern2RelationDomain = new TInPattern2RelationDomainImpl();
		return tInPattern2RelationDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInPattern2RelationDomain_guard createTInPattern2RelationDomain_guard() {
		TInPattern2RelationDomain_guardImpl tInPattern2RelationDomain_guard = new TInPattern2RelationDomain_guardImpl();
		return tInPattern2RelationDomain_guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TMatchedRule2Relation createTMatchedRule2Relation() {
		TMatchedRule2RelationImpl tMatchedRule2Relation = new TMatchedRule2RelationImpl();
		return tMatchedRule2Relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TModel2RelationalTransformation createTModel2RelationalTransformation() {
		TModel2RelationalTransformationImpl tModel2RelationalTransformation = new TModel2RelationalTransformationImpl();
		return tModel2RelationalTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOclExpression2OCLExpression createTOclExpression2OCLExpression() {
		TOclExpression2OCLExpressionImpl tOclExpression2OCLExpression = new TOclExpression2OCLExpressionImpl();
		return tOclExpression2OCLExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOclModel2ModelParameter_create createTOclModel2ModelParameter_create() {
		TOclModel2ModelParameter_createImpl tOclModel2ModelParameter_create = new TOclModel2ModelParameter_createImpl();
		return tOclModel2ModelParameter_create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOclModel2ModelParameter_from createTOclModel2ModelParameter_from() {
		TOclModel2ModelParameter_fromImpl tOclModel2ModelParameter_from = new TOclModel2ModelParameter_fromImpl();
		return tOclModel2ModelParameter_from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOperationCallExp2OperationCallExp createTOperationCallExp2OperationCallExp() {
		TOperationCallExp2OperationCallExpImpl tOperationCallExp2OperationCallExp = new TOperationCallExp2OperationCallExpImpl();
		return tOperationCallExp2OperationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PATL2QVTrPackage getPATL2QVTrPackage() {
		return (PATL2QVTrPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PATL2QVTrPackage getPackage() {
		return PATL2QVTrPackage.eINSTANCE;
	}

} //PATL2QVTrFactoryImpl
