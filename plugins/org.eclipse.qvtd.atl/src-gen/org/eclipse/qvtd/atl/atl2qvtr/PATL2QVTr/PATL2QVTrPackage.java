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
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrFactory
 * @model kind="package"
 * @generated
 */
public interface PATL2QVTrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PATL2QVTr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PATL2QVTr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PATL2QVTrPackage eINSTANCE = org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl <em>SIn Pattern2 Relation Domain guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getSInPattern2RelationDomain_guard()
	 * @generated
	 */
	int SIN_PATTERN2_RELATION_DOMAIN_GUARD = 0;

	/**
	 * The feature id for the '<em><b>APattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN = 0;

	/**
	 * The feature id for the '<em><b>RRule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE = 1;

	/**
	 * The number of structural features of the '<em>SIn Pattern2 Relation Domain guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIN_PATTERN2_RELATION_DOMAIN_GUARD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>SIn Pattern2 Relation Domain guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIN_PATTERN2_RELATION_DOMAIN_GUARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl <em>SOcl Expression2 OCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getSOclExpression2OCLExpression()
	 * @generated
	 */
	int SOCL_EXPRESSION2_OCL_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>SOcl Expression2 OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCL_EXPRESSION2_OCL_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>SOcl Expression2 OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCL_EXPRESSION2_OCL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl <em>THelper2 Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTHelper2Function()
	 * @generated
	 */
	int THELPER2_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>ADef</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__ADEF = 0;

	/**
	 * The feature id for the '<em><b>AFeat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__AFEAT = 1;

	/**
	 * The feature id for the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__AMODULE = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__HELPER = 4;

	/**
	 * The feature id for the '<em><b>Op Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__OP_NAME = 5;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION__REL_TX = 6;

	/**
	 * The number of structural features of the '<em>THelper2 Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>THelper2 Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THELPER2_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl <em>TIn Pattern2 Relation Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTInPattern2RelationDomain()
	 * @generated
	 */
	int TIN_PATTERN2_RELATION_DOMAIN = 3;

	/**
	 * The feature id for the '<em><b>APattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__APATTERN = 0;

	/**
	 * The feature id for the '<em><b>ARule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__ARULE = 1;

	/**
	 * The feature id for the '<em><b>RDomain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN = 2;

	/**
	 * The feature id for the '<em><b>RRule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__RRULE = 3;

	/**
	 * The feature id for the '<em><b>Tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__TM_NAME = 4;

	/**
	 * The feature id for the '<em><b>Where In Pattern2 Relation Domain guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD = 5;

	/**
	 * The number of structural features of the '<em>TIn Pattern2 Relation Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>TIn Pattern2 Relation Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl <em>TIn Pattern2 Relation Domain guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD = 4;

	/**
	 * The feature id for the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>APattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN = 1;

	/**
	 * The feature id for the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__P = 2;

	/**
	 * The feature id for the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>RRule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE = 4;

	/**
	 * The feature id for the '<em><b>W</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__W = 5;

	/**
	 * The feature id for the '<em><b>When Ocl Expression2 OCL Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION = 6;

	/**
	 * The number of structural features of the '<em>TIn Pattern2 Relation Domain guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>TIn Pattern2 Relation Domain guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIN_PATTERN2_RELATION_DOMAIN_GUARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl <em>TMatched Rule2 Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTMatchedRule2Relation()
	 * @generated
	 */
	int TMATCHED_RULE2_RELATION = 5;

	/**
	 * The feature id for the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION__AMODULE = 0;

	/**
	 * The feature id for the '<em><b>Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION__MATCHED_RULE = 1;

	/**
	 * The feature id for the '<em><b>RRule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION__RRULE = 2;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION__REL_TX = 3;

	/**
	 * The feature id for the '<em><b>Rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION__RULE_NAME = 4;

	/**
	 * The number of structural features of the '<em>TMatched Rule2 Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TMatched Rule2 Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMATCHED_RULE2_RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl <em>TModel2 Relational Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTModel2RelationalTransformation()
	 * @generated
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION = 6;

	/**
	 * The feature id for the '<em><b>3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__3 = 0;

	/**
	 * The feature id for the '<em><b>4</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__4 = 1;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__MODULE = 2;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__REL_TX = 3;

	/**
	 * The feature id for the '<em><b>Tx Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME = 4;

	/**
	 * The number of structural features of the '<em>TModel2 Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TModel2 Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMODEL2_RELATIONAL_TRANSFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclExpression2OCLExpressionImpl <em>TOcl Expression2 OCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclExpression2OCLExpressionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclExpression2OCLExpression()
	 * @generated
	 */
	int TOCL_EXPRESSION2_OCL_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>TOcl Expression2 OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_EXPRESSION2_OCL_EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>TOcl Expression2 OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_EXPRESSION2_OCL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_createImpl <em>TOcl Model2 Model Parameter create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_createImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclModel2ModelParameter_create()
	 * @generated
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE = 8;

	/**
	 * The feature id for the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE__AMODULE = 0;

	/**
	 * The feature id for the '<em><b>Ocl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE__OCL_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Rel TM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TM = 2;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TX = 3;

	/**
	 * The feature id for the '<em><b>Tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE__TM_NAME = 4;

	/**
	 * The number of structural features of the '<em>TOcl Model2 Model Parameter create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TOcl Model2 Model Parameter create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_CREATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl <em>TOcl Model2 Model Parameter from</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclModel2ModelParameter_from()
	 * @generated
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM = 9;

	/**
	 * The feature id for the '<em><b>AModule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE = 0;

	/**
	 * The feature id for the '<em><b>Ocl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Rel TM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM = 2;

	/**
	 * The feature id for the '<em><b>Rel Tx</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX = 3;

	/**
	 * The feature id for the '<em><b>Tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME = 4;

	/**
	 * The number of structural features of the '<em>TOcl Model2 Model Parameter from</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TOcl Model2 Model Parameter from</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOCL_MODEL2_MODEL_PARAMETER_FROM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl <em>TOperation Call Exp2 Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOperationCallExp2OperationCallExp()
	 * @generated
	 */
	int TOPERATION_CALL_EXP2_OPERATION_CALL_EXP = 10;

	/**
	 * The feature id for the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>TOperation Call Exp2 Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION_CALL_EXP2_OPERATION_CALL_EXP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>TOperation Call Exp2 Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION_CALL_EXP2_OPERATION_CALL_EXP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard <em>SIn Pattern2 Relation Domain guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIn Pattern2 Relation Domain guard</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard
	 * @generated
	 */
	EClass getSInPattern2RelationDomain_guard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard#getAPattern <em>APattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>APattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard#getAPattern()
	 * @see #getSInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getSInPattern2RelationDomain_guard_APattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard#getRRule <em>RRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RRule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SInPattern2RelationDomain_guard#getRRule()
	 * @see #getSInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getSInPattern2RelationDomain_guard_RRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression <em>SOcl Expression2 OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOcl Expression2 OCL Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression
	 * @generated
	 */
	EClass getSOclExpression2OCLExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getAExpression <em>AExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getAExpression()
	 * @see #getSOclExpression2OCLExpression()
	 * @generated
	 */
	EReference getSOclExpression2OCLExpression_AExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getRExpression <em>RExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getRExpression()
	 * @see #getSOclExpression2OCLExpression()
	 * @generated
	 */
	EReference getSOclExpression2OCLExpression_RExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function <em>THelper2 Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>THelper2 Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function
	 * @generated
	 */
	EClass getTHelper2Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef <em>ADef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>ADef</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getADef()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_ADef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat <em>AFeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AFeat</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAFeat()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_AFeat();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule <em>AModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AModule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getAModule()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_AModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getFunction()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getHelper()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_Helper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getOpName <em>Op Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getOpName()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EAttribute getTHelper2Function_OpName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function#getRelTx()
	 * @see #getTHelper2Function()
	 * @generated
	 */
	EReference getTHelper2Function_RelTx();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain <em>TIn Pattern2 Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TIn Pattern2 Relation Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain
	 * @generated
	 */
	EClass getTInPattern2RelationDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getAPattern <em>APattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>APattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getAPattern()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_APattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getARule <em>ARule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>ARule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getARule()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_ARule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRDomain <em>RDomain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RDomain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRDomain()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_RDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRRule <em>RRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RRule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRRule()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_RRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getTmName <em>Tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getTmName()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EAttribute getTInPattern2RelationDomain_TmName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getWhere_InPattern2RelationDomain_guard <em>Where In Pattern2 Relation Domain guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Where In Pattern2 Relation Domain guard</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getWhere_InPattern2RelationDomain_guard()
	 * @see #getTInPattern2RelationDomain()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_Where_InPattern2RelationDomain_guard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard <em>TIn Pattern2 Relation Domain guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TIn Pattern2 Relation Domain guard</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard
	 * @generated
	 */
	EClass getTInPattern2RelationDomain_guard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAExpression <em>AExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAExpression()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_AExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAPattern <em>APattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>APattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAPattern()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_APattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getP <em>P</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>P</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getP()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_P();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRExpression <em>RExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRExpression()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_RExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRRule <em>RRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RRule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRRule()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_RRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getW <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>W</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getW()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_W();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getWhen_OclExpression2OCLExpression <em>When Ocl Expression2 OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>When Ocl Expression2 OCL Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getWhen_OclExpression2OCLExpression()
	 * @see #getTInPattern2RelationDomain_guard()
	 * @generated
	 */
	EReference getTInPattern2RelationDomain_guard_When_OclExpression2OCLExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation <em>TMatched Rule2 Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMatched Rule2 Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation
	 * @generated
	 */
	EClass getTMatchedRule2Relation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getAModule <em>AModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AModule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getAModule()
	 * @see #getTMatchedRule2Relation()
	 * @generated
	 */
	EReference getTMatchedRule2Relation_AModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getMatchedRule <em>Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getMatchedRule()
	 * @see #getTMatchedRule2Relation()
	 * @generated
	 */
	EReference getTMatchedRule2Relation_MatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRRule <em>RRule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RRule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRRule()
	 * @see #getTMatchedRule2Relation()
	 * @generated
	 */
	EReference getTMatchedRule2Relation_RRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRelTx()
	 * @see #getTMatchedRule2Relation()
	 * @generated
	 */
	EReference getTMatchedRule2Relation_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRuleName <em>Rule Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TMatchedRule2Relation#getRuleName()
	 * @see #getTMatchedRule2Relation()
	 * @generated
	 */
	EAttribute getTMatchedRule2Relation_RuleName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation <em>TModel2 Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TModel2 Relational Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation
	 * @generated
	 */
	EClass getTModel2RelationalTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_3 <em>3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>3</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_3()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation__3();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_4 <em>4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>4</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#get_4()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation__4();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getModule()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation_Module();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getRelTx()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EReference getTModel2RelationalTransformation_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getTxName <em>Tx Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tx Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation#getTxName()
	 * @see #getTModel2RelationalTransformation()
	 * @generated
	 */
	EAttribute getTModel2RelationalTransformation_TxName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression <em>TOcl Expression2 OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOcl Expression2 OCL Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression
	 * @generated
	 */
	EClass getTOclExpression2OCLExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression#getAExpression <em>AExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression#getAExpression()
	 * @see #getTOclExpression2OCLExpression()
	 * @generated
	 */
	EReference getTOclExpression2OCLExpression_AExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression#getRExpression <em>RExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclExpression2OCLExpression#getRExpression()
	 * @see #getTOclExpression2OCLExpression()
	 * @generated
	 */
	EReference getTOclExpression2OCLExpression_RExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create <em>TOcl Model2 Model Parameter create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOcl Model2 Model Parameter create</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create
	 * @generated
	 */
	EClass getTOclModel2ModelParameter_create();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getAModule <em>AModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AModule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getAModule()
	 * @see #getTOclModel2ModelParameter_create()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_create_AModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getOclModel <em>Ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getOclModel()
	 * @see #getTOclModel2ModelParameter_create()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_create_OclModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getRelTM <em>Rel TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel TM</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getRelTM()
	 * @see #getTOclModel2ModelParameter_create()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_create_RelTM();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getRelTx()
	 * @see #getTOclModel2ModelParameter_create()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_create_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getTmName <em>Tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_create#getTmName()
	 * @see #getTOclModel2ModelParameter_create()
	 * @generated
	 */
	EAttribute getTOclModel2ModelParameter_create_TmName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from <em>TOcl Model2 Model Parameter from</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOcl Model2 Model Parameter from</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from
	 * @generated
	 */
	EClass getTOclModel2ModelParameter_from();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getAModule <em>AModule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AModule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getAModule()
	 * @see #getTOclModel2ModelParameter_from()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_from_AModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getOclModel <em>Ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getOclModel()
	 * @see #getTOclModel2ModelParameter_from()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_from_OclModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTM <em>Rel TM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel TM</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTM()
	 * @see #getTOclModel2ModelParameter_from()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_from_RelTM();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTx <em>Rel Tx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Tx</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getRelTx()
	 * @see #getTOclModel2ModelParameter_from()
	 * @generated
	 */
	EReference getTOclModel2ModelParameter_from_RelTx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getTmName <em>Tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from#getTmName()
	 * @see #getTOclModel2ModelParameter_from()
	 * @generated
	 */
	EAttribute getTOclModel2ModelParameter_from_TmName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp <em>TOperation Call Exp2 Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOperation Call Exp2 Operation Call Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp
	 * @generated
	 */
	EClass getTOperationCallExp2OperationCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getAExpression <em>AExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>AExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getAExpression()
	 * @see #getTOperationCallExp2OperationCallExp()
	 * @generated
	 */
	EReference getTOperationCallExp2OperationCallExp_AExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getRExpression <em>RExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RExpression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getRExpression()
	 * @see #getTOperationCallExp2OperationCallExp()
	 * @generated
	 */
	EReference getTOperationCallExp2OperationCallExp_RExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PATL2QVTrFactory getPATL2QVTrFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl <em>SIn Pattern2 Relation Domain guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SInPattern2RelationDomain_guardImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getSInPattern2RelationDomain_guard()
		 * @generated
		 */
		EClass SIN_PATTERN2_RELATION_DOMAIN_GUARD = eINSTANCE.getSInPattern2RelationDomain_guard();

		/**
		 * The meta object literal for the '<em><b>APattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN = eINSTANCE.getSInPattern2RelationDomain_guard_APattern();

		/**
		 * The meta object literal for the '<em><b>RRule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE = eINSTANCE.getSInPattern2RelationDomain_guard_RRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl <em>SOcl Expression2 OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getSOclExpression2OCLExpression()
		 * @generated
		 */
		EClass SOCL_EXPRESSION2_OCL_EXPRESSION = eINSTANCE.getSOclExpression2OCLExpression();

		/**
		 * The meta object literal for the '<em><b>AExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION = eINSTANCE.getSOclExpression2OCLExpression_AExpression();

		/**
		 * The meta object literal for the '<em><b>RExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION = eINSTANCE.getSOclExpression2OCLExpression_RExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl <em>THelper2 Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTHelper2Function()
		 * @generated
		 */
		EClass THELPER2_FUNCTION = eINSTANCE.getTHelper2Function();

		/**
		 * The meta object literal for the '<em><b>ADef</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__ADEF = eINSTANCE.getTHelper2Function_ADef();

		/**
		 * The meta object literal for the '<em><b>AFeat</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__AFEAT = eINSTANCE.getTHelper2Function_AFeat();

		/**
		 * The meta object literal for the '<em><b>AModule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__AMODULE = eINSTANCE.getTHelper2Function_AModule();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__FUNCTION = eINSTANCE.getTHelper2Function_Function();

		/**
		 * The meta object literal for the '<em><b>Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__HELPER = eINSTANCE.getTHelper2Function_Helper();

		/**
		 * The meta object literal for the '<em><b>Op Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THELPER2_FUNCTION__OP_NAME = eINSTANCE.getTHelper2Function_OpName();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THELPER2_FUNCTION__REL_TX = eINSTANCE.getTHelper2Function_RelTx();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl <em>TIn Pattern2 Relation Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomainImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTInPattern2RelationDomain()
		 * @generated
		 */
		EClass TIN_PATTERN2_RELATION_DOMAIN = eINSTANCE.getTInPattern2RelationDomain();

		/**
		 * The meta object literal for the '<em><b>APattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN__APATTERN = eINSTANCE.getTInPattern2RelationDomain_APattern();

		/**
		 * The meta object literal for the '<em><b>ARule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN__ARULE = eINSTANCE.getTInPattern2RelationDomain_ARule();

		/**
		 * The meta object literal for the '<em><b>RDomain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN__RDOMAIN = eINSTANCE.getTInPattern2RelationDomain_RDomain();

		/**
		 * The meta object literal for the '<em><b>RRule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN__RRULE = eINSTANCE.getTInPattern2RelationDomain_RRule();

		/**
		 * The meta object literal for the '<em><b>Tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIN_PATTERN2_RELATION_DOMAIN__TM_NAME = eINSTANCE.getTInPattern2RelationDomain_TmName();

		/**
		 * The meta object literal for the '<em><b>Where In Pattern2 Relation Domain guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN__WHERE_IN_PATTERN2_RELATION_DOMAIN_GUARD = eINSTANCE.getTInPattern2RelationDomain_Where_InPattern2RelationDomain_guard();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl <em>TIn Pattern2 Relation Domain guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TInPattern2RelationDomain_guardImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTInPattern2RelationDomain_guard()
		 * @generated
		 */
		EClass TIN_PATTERN2_RELATION_DOMAIN_GUARD = eINSTANCE.getTInPattern2RelationDomain_guard();

		/**
		 * The meta object literal for the '<em><b>AExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__AEXPRESSION = eINSTANCE.getTInPattern2RelationDomain_guard_AExpression();

		/**
		 * The meta object literal for the '<em><b>APattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__APATTERN = eINSTANCE.getTInPattern2RelationDomain_guard_APattern();

		/**
		 * The meta object literal for the '<em><b>P</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__P = eINSTANCE.getTInPattern2RelationDomain_guard_P();

		/**
		 * The meta object literal for the '<em><b>RExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__REXPRESSION = eINSTANCE.getTInPattern2RelationDomain_guard_RExpression();

		/**
		 * The meta object literal for the '<em><b>RRule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__RRULE = eINSTANCE.getTInPattern2RelationDomain_guard_RRule();

		/**
		 * The meta object literal for the '<em><b>W</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__W = eINSTANCE.getTInPattern2RelationDomain_guard_W();

		/**
		 * The meta object literal for the '<em><b>When Ocl Expression2 OCL Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIN_PATTERN2_RELATION_DOMAIN_GUARD__WHEN_OCL_EXPRESSION2_OCL_EXPRESSION = eINSTANCE.getTInPattern2RelationDomain_guard_When_OclExpression2OCLExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl <em>TMatched Rule2 Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TMatchedRule2RelationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTMatchedRule2Relation()
		 * @generated
		 */
		EClass TMATCHED_RULE2_RELATION = eINSTANCE.getTMatchedRule2Relation();

		/**
		 * The meta object literal for the '<em><b>AModule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMATCHED_RULE2_RELATION__AMODULE = eINSTANCE.getTMatchedRule2Relation_AModule();

		/**
		 * The meta object literal for the '<em><b>Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMATCHED_RULE2_RELATION__MATCHED_RULE = eINSTANCE.getTMatchedRule2Relation_MatchedRule();

		/**
		 * The meta object literal for the '<em><b>RRule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMATCHED_RULE2_RELATION__RRULE = eINSTANCE.getTMatchedRule2Relation_RRule();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMATCHED_RULE2_RELATION__REL_TX = eINSTANCE.getTMatchedRule2Relation_RelTx();

		/**
		 * The meta object literal for the '<em><b>Rule Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMATCHED_RULE2_RELATION__RULE_NAME = eINSTANCE.getTMatchedRule2Relation_RuleName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl <em>TModel2 Relational Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTModel2RelationalTransformation()
		 * @generated
		 */
		EClass TMODEL2_RELATIONAL_TRANSFORMATION = eINSTANCE.getTModel2RelationalTransformation();

		/**
		 * The meta object literal for the '<em><b>3</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__3 = eINSTANCE.getTModel2RelationalTransformation__3();

		/**
		 * The meta object literal for the '<em><b>4</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__4 = eINSTANCE.getTModel2RelationalTransformation__4();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__MODULE = eINSTANCE.getTModel2RelationalTransformation_Module();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMODEL2_RELATIONAL_TRANSFORMATION__REL_TX = eINSTANCE.getTModel2RelationalTransformation_RelTx();

		/**
		 * The meta object literal for the '<em><b>Tx Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME = eINSTANCE.getTModel2RelationalTransformation_TxName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclExpression2OCLExpressionImpl <em>TOcl Expression2 OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclExpression2OCLExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclExpression2OCLExpression()
		 * @generated
		 */
		EClass TOCL_EXPRESSION2_OCL_EXPRESSION = eINSTANCE.getTOclExpression2OCLExpression();

		/**
		 * The meta object literal for the '<em><b>AExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION = eINSTANCE.getTOclExpression2OCLExpression_AExpression();

		/**
		 * The meta object literal for the '<em><b>RExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION = eINSTANCE.getTOclExpression2OCLExpression_RExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_createImpl <em>TOcl Model2 Model Parameter create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_createImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclModel2ModelParameter_create()
		 * @generated
		 */
		EClass TOCL_MODEL2_MODEL_PARAMETER_CREATE = eINSTANCE.getTOclModel2ModelParameter_create();

		/**
		 * The meta object literal for the '<em><b>AModule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_CREATE__AMODULE = eINSTANCE.getTOclModel2ModelParameter_create_AModule();

		/**
		 * The meta object literal for the '<em><b>Ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_CREATE__OCL_MODEL = eINSTANCE.getTOclModel2ModelParameter_create_OclModel();

		/**
		 * The meta object literal for the '<em><b>Rel TM</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TM = eINSTANCE.getTOclModel2ModelParameter_create_RelTM();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_CREATE__REL_TX = eINSTANCE.getTOclModel2ModelParameter_create_RelTx();

		/**
		 * The meta object literal for the '<em><b>Tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOCL_MODEL2_MODEL_PARAMETER_CREATE__TM_NAME = eINSTANCE.getTOclModel2ModelParameter_create_TmName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl <em>TOcl Model2 Model Parameter from</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOclModel2ModelParameter_from()
		 * @generated
		 */
		EClass TOCL_MODEL2_MODEL_PARAMETER_FROM = eINSTANCE.getTOclModel2ModelParameter_from();

		/**
		 * The meta object literal for the '<em><b>AModule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE = eINSTANCE.getTOclModel2ModelParameter_from_AModule();

		/**
		 * The meta object literal for the '<em><b>Ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL = eINSTANCE.getTOclModel2ModelParameter_from_OclModel();

		/**
		 * The meta object literal for the '<em><b>Rel TM</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM = eINSTANCE.getTOclModel2ModelParameter_from_RelTM();

		/**
		 * The meta object literal for the '<em><b>Rel Tx</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX = eINSTANCE.getTOclModel2ModelParameter_from_RelTx();

		/**
		 * The meta object literal for the '<em><b>Tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME = eINSTANCE.getTOclModel2ModelParameter_from_TmName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl <em>TOperation Call Exp2 Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.PATL2QVTrPackageImpl#getTOperationCallExp2OperationCallExp()
		 * @generated
		 */
		EClass TOPERATION_CALL_EXP2_OPERATION_CALL_EXP = eINSTANCE.getTOperationCallExp2OperationCallExp();

		/**
		 * The meta object literal for the '<em><b>AExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION = eINSTANCE.getTOperationCallExp2OperationCallExp_AExpression();

		/**
		 * The meta object literal for the '<em><b>RExpression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION = eINSTANCE.getTOperationCallExp2OperationCallExp_RExpression();

	}

} //PATL2QVTrPackage
