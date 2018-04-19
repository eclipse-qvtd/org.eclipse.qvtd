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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;

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
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory
 * @model kind="package"
 * @generated
 */
public interface trace_ATL2QVTrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace_ATL2QVTr";

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
	trace_ATL2QVTrPackage eINSTANCE = org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl <em>Dmap Variable Exp referred Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapVariableExp_referredVariable()
	 * @generated
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL = QVTtracePackage.DISPATCH__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS = QVTtracePackage.DISPATCH__SUCCESS;

	/**
	 * The feature id for the '<em><b>D1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D1ATL_EXPRESSION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>D2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D2QVTR_EXPRESSION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = QVTtracePackage.DISPATCH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Dmap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Dmap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT = QVTtracePackage.DISPATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl <em>Cmap Variable Exp referred Variable Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = 0;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__OWNING_MODEL = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__SUCCESS = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS;

	/**
	 * The feature id for the '<em><b>D1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__D1ATL_EXPRESSION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D1ATL_EXPRESSION;

	/**
	 * The feature id for the '<em><b>D2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__D2QVTR_EXPRESSION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D2QVTR_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__RESULT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT;

	/**
	 * The number of structural features of the '<em>Cmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_FEATURE_COUNT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_OPERATION_COUNT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl <em>Cmap Variable Exp referred Variable Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = 1;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__OWNING_MODEL = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__SUCCESS = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS;

	/**
	 * The feature id for the '<em><b>D1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__D1ATL_EXPRESSION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D1ATL_EXPRESSION;

	/**
	 * The feature id for the '<em><b>D2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__D2QVTR_EXPRESSION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D2QVTR_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__RESULT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT;

	/**
	 * The number of structural features of the '<em>Cmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_FEATURE_COUNT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_OPERATION_COUNT = DMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl <em>Dmap Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapHelper()
	 * @generated
	 */
	int DMAP_HELPER = 2;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__OWNING_MODEL = QVTtracePackage.DISPATCH__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__SUCCESS = QVTtracePackage.DISPATCH__SUCCESS;

	/**
	 * The feature id for the '<em><b>D1atl Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__D1ATL_HELPER = QVTtracePackage.DISPATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>D2qvtr Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__D2QVTR_FUNCTION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domap Helper Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__DOMAP_HELPER_ATTRIBUTE = QVTtracePackage.DISPATCH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domap Helper Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__DOMAP_HELPER_OPERATION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER__RESULT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Dmap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER_FEATURE_COUNT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Dmap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_HELPER_OPERATION_COUNT = QVTtracePackage.DISPATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl <em>Dmap Ocl Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapOclExpression()
	 * @generated
	 */
	int DMAP_OCL_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__OWNING_MODEL = QVTtracePackage.DISPATCH__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__SUCCESS = QVTtracePackage.DISPATCH__SUCCESS;

	/**
	 * The feature id for the '<em><b>D1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>D2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domap Boolean Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domap If Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_IF_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Domap Integer Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Domap Navigation Or Attribute Call Exp Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = QVTtracePackage.DISPATCH_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Domap Navigation Or Attribute Call Exp Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = QVTtracePackage.DISPATCH_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Domap Operation Call Exp Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER = QVTtracePackage.DISPATCH_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Domap Operation Call Exp Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION = QVTtracePackage.DISPATCH_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Domap Operator Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Domap String Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Domap Variable Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP = QVTtracePackage.DISPATCH_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION__RESULT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION_FEATURE_COUNT = QVTtracePackage.DISPATCH_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Dmap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DMAP_OCL_EXPRESSION_OPERATION_COUNT = QVTtracePackage.DISPATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl <em>Imap Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapHelper()
	 * @generated
	 */
	int IMAP_HELPER = 5;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_HELPER__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_HELPER__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_HELPER_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_HELPER_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl <em>Imap Ocl Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapOclExpression()
	 * @generated
	 */
	int IMAP_OCL_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_OCL_EXPRESSION__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_OCL_EXPRESSION__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_OCL_EXPRESSION_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imap Ocl Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_OCL_EXPRESSION_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl <em>Imap Variable Exp referred Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapVariableExp_referredVariable()
	 * @generated
	 */
	int IMAP_VARIABLE_EXP_REFERRED_VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl <em>Tmap Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBinding()
	 * @generated
	 */
	int TMAP_BINDING = 8;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T0PROPERTY_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T1ATL_BINDING = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T1ATL_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Out Pattern Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T2QVTR_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T2QVTR_PART = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__T2QVTR_TEMPLATE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__WMAP_OCL_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap Simple Out Pattern Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Tmap Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Tmap Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BINDING_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl <em>Tmap Boolean Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBooleanExp()
	 * @generated
	 */
	int TMAP_BOOLEAN_EXP = 9;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP__T0SYMBOL = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tmap Boolean Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tmap Boolean Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_BOOLEAN_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl <em>Tmap Helper Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Attribute()
	 * @generated
	 */
	int TMAP_HELPER_ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__OWNING_MODEL = IMAP_HELPER__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__SUCCESS = IMAP_HELPER__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__DISPATCHER = IMAP_HELPER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T0ATTRIBUTE_NAME = IMAP_HELPER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T1ATL_DEFINITION = IMAP_HELPER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T1ATL_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T1atl Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T1ATL_FEATURE = IMAP_HELPER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T1ATL_MODULE = IMAP_HELPER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T1atl Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T1ATL_TYPE = IMAP_HELPER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T2QVTR_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__T2QVTR_TRANSFORMATION = IMAP_HELPER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Helper Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__WMAP_HELPER_CONTEXT = IMAP_HELPER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__WMAP_MODULE = IMAP_HELPER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Tmap Helper Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE_FEATURE_COUNT = IMAP_HELPER_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Tmap Helper Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_ATTRIBUTE_OPERATION_COUNT = IMAP_HELPER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl <em>Tmap Helper Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Context()
	 * @generated
	 */
	int TMAP_HELPER_CONTEXT = 11;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T1atl Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T1ATL_CONTEXT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T1ATL_DEFINITION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T1ATL_HELPER = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wmap Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT__WMAP_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Tmap Helper Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Helper Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_CONTEXT_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl <em>Tmap Helper Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Operation()
	 * @generated
	 */
	int TMAP_HELPER_OPERATION = 12;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__OWNING_MODEL = IMAP_HELPER__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__SUCCESS = IMAP_HELPER__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__DISPATCHER = IMAP_HELPER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T0OPERATION_NAME = IMAP_HELPER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T1ATL_DEFINITION = IMAP_HELPER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T1ATL_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T1atl Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T1ATL_FEATURE = IMAP_HELPER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T1ATL_MODULE = IMAP_HELPER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T1atl Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T1ATL_TYPE = IMAP_HELPER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION = IMAP_HELPER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Helper Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT = IMAP_HELPER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__WMAP_MODULE = IMAP_HELPER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION = IMAP_HELPER_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Tmap Helper Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION_FEATURE_COUNT = IMAP_HELPER_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Tmap Helper Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_HELPER_OPERATION_OPERATION_COUNT = IMAP_HELPER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl <em>Tmap If Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIfExp()
	 * @generated
	 */
	int TMAP_IF_EXP = 13;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T1ATL_CONDITION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Else</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T1ATL_ELSE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Then</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T1ATL_THEN = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T2QVTR_CONDITION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Else</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T2QVTR_ELSE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Then</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__T2QVTR_THEN = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__WMAP_OCL_EXPRESSION1 = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP__WMAP_OCL_EXPRESSION2 = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Tmap If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tmap If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IF_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl <em>Tmap In Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern()
	 * @generated
	 */
	int TMAP_IN_PATTERN = 14;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T1ATL_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T1ATL_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T1ATL_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T2QVTR_DOMAIN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__T2QVTR_TYPED_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN__WMAP_OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Tmap In Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Tmap In Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl <em>Tmap In Pattern filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern_filter()
	 * @generated
	 */
	int TMAP_IN_PATTERN_FILTER = 15;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T1ATL_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T1ATL_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T1ATL_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2p</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T2P = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T2QVTR_DOMAIN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T2QVTR_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>T2w</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__T2W = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap In Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__WMAP_IN_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER__WMAP_OCL_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Tmap In Pattern filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Tmap In Pattern filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_IN_PATTERN_FILTER_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl <em>Tmap Integer Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIntegerExp()
	 * @generated
	 */
	int TMAP_INTEGER_EXP = 16;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP__T0SYMBOL = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tmap Integer Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tmap Integer Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_INTEGER_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl <em>Tmap Matched Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule()
	 * @generated
	 */
	int TMAP_MATCHED_RULE = 17;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T0RULE_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T1ATL_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T1MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2 1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T2_1 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE__WMAP_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tmap Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Tmap Matched Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl <em>Tmap Matched Rule super</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule_super()
	 * @generated
	 */
	int TMAP_MATCHED_RULE_SUPER = 18;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T1atl Child Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Super Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2qvtr Overridden Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Overrides Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Tmap Matched Rule super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Tmap Matched Rule super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MATCHED_RULE_SUPER_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl <em>Tmap Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapModule()
	 * @generated
	 */
	int TMAP_MODULE = 19;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0tx Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T0TX_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T1ATL_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2 1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T2_1 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2 2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T2_2 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2 3</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T2_3 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2 4</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T2_4 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE__T2QVTR_TRANSFORMATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Tmap Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_MODULE_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl <em>Tmap Navigation Or Attribute Call Exp Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = 20;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1ATL_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_OPERATION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Source Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_MODULE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Tmap Navigation Or Attribute Call Exp Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tmap Navigation Or Attribute Call Exp Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl <em>Tmap Navigation Or Attribute Call Exp Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = 21;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tmap Navigation Or Attribute Call Exp Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Tmap Navigation Or Attribute Call Exp Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl <em>Tmap Ocl Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclMetamodel()
	 * @generated
	 */
	int TMAP_OCL_METAMODEL = 22;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL__T0TM_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL__T1OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tmap Ocl Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Tmap Ocl Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_METAMODEL_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl <em>Tmap Ocl Model IN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_IN()
	 * @generated
	 */
	int TMAP_OCL_MODEL_IN = 23;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T0TM_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T1ATL_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T1OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1ocl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T1OCL_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__WMAP_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tmap Ocl Model IN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Tmap Ocl Model IN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_IN_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl <em>Tmap Ocl Model OUT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_OUT()
	 * @generated
	 */
	int TMAP_OCL_MODEL_OUT = 24;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T0TM_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T1ATL_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T1OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1ocl Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T1OCL_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T2QVTR_TRANSFORMATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__T2QVTR_TYPED_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__WMAP_MODULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT__WMAP_OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tmap Ocl Model OUT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Tmap Ocl Model OUT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OCL_MODEL_OUT_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl <em>Tmap Operation Call Exp Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Helper()
	 * @generated
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER = 25;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Source Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Tmap Operation Call Exp Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tmap Operation Call Exp Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_HELPER_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl <em>Tmap Operation Call Exp Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Operation()
	 * @generated
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION = 26;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tmap Operation Call Exp Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Tmap Operation Call Exp Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_OPERATION_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl <em>Tmap Operation Call Exp argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_argument()
	 * @generated
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT = 27;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T1atl Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_ARGUMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_PARENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2qvtr Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_ARGUMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_PARENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION1 = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Tmap Operation Call Exp argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Tmap Operation Call Exp argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATION_CALL_EXP_ARGUMENT_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl <em>Tmap Operator Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperatorCallExp()
	 * @generated
	 */
	int TMAP_OPERATOR_CALL_EXP = 28;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__T0OPERATION_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__T1ATL_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__T2QVTR_SOURCE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__T2QVTR_TRANSFORMATION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wmap Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__WMAP_MODULE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Tmap Operator Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Operator Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OPERATOR_CALL_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl <em>Tmap Out Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOutPattern()
	 * @generated
	 */
	int TMAP_OUT_PATTERN = 29;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__T1ATL_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__T1ATL_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__T2QVTR_DOMAIN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wmap Ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tmap Out Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Tmap Out Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_OUT_PATTERN_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl <em>Tmap Simple In Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleInPatternElement()
	 * @generated
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT = 30;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>T0element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T0ELEMENT_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_ELEMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_DOMAIN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>T2qvtr Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_TEMPLATE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wmap In Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_IN_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Wmap Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Tmap Simple In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Tmap Simple In Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_IN_PATTERN_ELEMENT_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl <em>Tmap Simple Out Pattern Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleOutPatternElement()
	 * @generated
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT = 31;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T0ELEMENT_NAME = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_ELEMENT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_DOMAIN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>T2qvtr Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_RELATION = QVTtracePackage.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>T2qvtr Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_TEMPLATE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_MATCHED_RULE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Wmap Out Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_OUT_PATTERN = QVTtracePackage.EXECUTION_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Wmap Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Tmap Simple Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Tmap Simple Out Pattern Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_SIMPLE_OUT_PATTERN_ELEMENT_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl <em>Tmap String Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapStringExp()
	 * @generated
	 */
	int TMAP_STRING_EXP = 32;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP__T0SYMBOL = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tmap String Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tmap String Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_STRING_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl <em>Tmap Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariable()
	 * @generated
	 */
	int TMAP_VARIABLE = 33;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE__OWNING_MODEL = QVTtracePackage.EXECUTION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE__SUCCESS = QVTtracePackage.EXECUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE__T1ATL_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE__T2QVTR_VARIABLE = QVTtracePackage.EXECUTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tmap Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_FEATURE_COUNT = QVTtracePackage.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Tmap Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_OPERATION_COUNT = QVTtracePackage.EXECUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl <em>Tmap Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp()
	 * @generated
	 */
	int TMAP_VARIABLE_EXP = 34;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__OWNING_MODEL = IMAP_OCL_EXPRESSION__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__SUCCESS = IMAP_OCL_EXPRESSION__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__DISPATCHER = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T0var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__T0VAR_NAME = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__T1ATL_VARIABLE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wmap Variable Exp referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tmap Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_FEATURE_COUNT = IMAP_OCL_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Tmap Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_OPERATION_COUNT = IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl <em>Tmap Variable Exp referred Variable Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = 35;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__OWNING_MODEL = IMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__SUCCESS = IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_FEATURE_COUNT = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Tmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_OPERATION_COUNT = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl <em>Tmap Variable Exp referred Variable Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = 36;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__OWNING_MODEL = IMAP_VARIABLE_EXP_REFERRED_VARIABLE__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__SUCCESS = IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS;

	/**
	 * The feature id for the '<em><b>Dispatcher</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DISPATCHER = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>T1atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T1ATL_VARIABLE = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>T2qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T2QVTR_VARIABLE = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_FEATURE_COUNT = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Tmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_OPERATION_COUNT = IMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper <em>Cmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	EClass getCmapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration <em>Cmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	EClass getCmapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper <em>Dmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper
	 * @generated
	 */
	EClass getDmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD1atlHelper <em>D1atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D1atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD1atlHelper()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_D1atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD2qvtrFunction <em>D2qvtr Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D2qvtr Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD2qvtrFunction()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_D2qvtrFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Helper Attribute</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_DomapHelper_Attribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation <em>Domap Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Helper Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_DomapHelper_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression <em>Dmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression
	 * @generated
	 */
	EClass getDmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD1atlExpression <em>D1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD1atlExpression()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_D1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD2qvtrExpression <em>D2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD2qvtrExpression()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_D2qvtrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp <em>Domap Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Boolean Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapBooleanExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp <em>Domap If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap If Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp <em>Domap Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Integer Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapIntegerExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Navigation Or Attribute Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Navigation Or Attribute Call Exp Property</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operation Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperationCallExp_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operation Call Exp Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperationCallExp_Operation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operator Call Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperatorCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp <em>Domap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap String Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapStringExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp <em>Domap Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable <em>Dmap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable
	 * @generated
	 */
	EClass getDmapVariableExp_referredVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD1atlExpression <em>D1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD1atlExpression()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_D1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD2qvtrExpression <em>D2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD2qvtrExpression()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_D2qvtrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper <em>Imap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper
	 * @generated
	 */
	EClass getImapHelper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper#getSuccess()
	 * @see #getImapHelper()
	 * @generated
	 */
	EAttribute getImapHelper_Success();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression <em>Imap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression
	 * @generated
	 */
	EClass getImapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression#getSuccess()
	 * @see #getImapOclExpression()
	 * @generated
	 */
	EAttribute getImapOclExpression_Success();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable <em>Imap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable
	 * @generated
	 */
	EClass getImapVariableExp_referredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable#getSuccess()
	 * @see #getImapVariableExp_referredVariable()
	 * @generated
	 */
	EAttribute getImapVariableExp_referredVariable_Success();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding <em>Tmap Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Binding</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding
	 * @generated
	 */
	EClass getTmapBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT0propertyName <em>T0property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT0propertyName()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EAttribute getTmapBinding_T0propertyName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlBinding <em>T1atl Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Binding</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlBinding()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T1atlBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlExpression <em>T1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlOutPatternElement <em>T1atl Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1atlOutPatternElement()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T1atlOutPatternElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrExpression <em>T2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T2qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrPart <em>T2qvtr Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Part</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrPart()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T2qvtrPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrTemplate <em>T2qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT2qvtrTemplate()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T2qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Simple Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_WmapSimpleOutPatternElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp <em>Tmap Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Boolean Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp
	 * @generated
	 */
	EClass getTmapBooleanExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher()
	 * @see #getTmapBooleanExp()
	 * @generated
	 */
	EReference getTmapBooleanExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#isT0symbol <em>T0symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#isT0symbol()
	 * @see #getTmapBooleanExp()
	 * @generated
	 */
	EAttribute getTmapBooleanExp_T0symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute <em>Tmap Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Attribute</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute
	 * @generated
	 */
	EClass getTmapHelper_Attribute();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT0attributeName <em>T0attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0attribute Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT0attributeName()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EAttribute getTmapHelper_Attribute_T0attributeName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlDefinition <em>T1atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlDefinition()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T1atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlExpression <em>T1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlFeature <em>T1atl Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Feature</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlFeature()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T1atlFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlModule()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlType <em>T1atl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1atlType()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T1atlType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT2qvtrExpression <em>T2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT2qvtrExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T2qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT2qvtrTransformation()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapHelper_Context <em>Wmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapHelper_Context()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapHelper_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapModule()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapOclExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context <em>Tmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context
	 * @generated
	 */
	EClass getTmapHelper_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlContext <em>T1atl Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlContext()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T1atlContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlDefinition <em>T1atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlDefinition()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T1atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlHelper <em>T1atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlHelper()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T1atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlReturnType <em>T1atl Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Return Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT1atlReturnType()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T1atlReturnType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT2qvtrFunction <em>T2qvtr Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT2qvtrFunction()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T2qvtrFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT2qvtrParameter <em>T2qvtr Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Parameter</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT2qvtrParameter()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T2qvtrParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getWmapVariable()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation <em>Tmap Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation
	 * @generated
	 */
	EClass getTmapHelper_Operation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT0operationName <em>T0operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT0operationName()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EAttribute getTmapHelper_Operation_T0operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlDefinition <em>T1atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlDefinition()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T1atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlExpression <em>T1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlFeature <em>T1atl Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Feature</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlFeature()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T1atlFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlModule()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlType <em>T1atl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1atlType()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T1atlType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT2qvtrExpression <em>T2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT2qvtrExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T2qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT2qvtrTransformation()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapHelper_Context <em>Wmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapHelper_Context()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapHelper_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapModule()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapOclExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp <em>Tmap If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap If Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp
	 * @generated
	 */
	EClass getTmapIfExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlCondition <em>T1atl Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Condition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlCondition()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T1atlCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlElse <em>T1atl Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Else</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlElse()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T1atlElse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlThen <em>T1atl Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Then</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT1atlThen()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T1atlThen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrCondition <em>T2qvtr Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Condition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrCondition()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T2qvtrCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrElse <em>T2qvtr Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Else</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrElse()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T2qvtrElse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrThen <em>T2qvtr Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Then</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT2qvtrThen()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T2qvtrThen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression1()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression2 <em>Wmap Ocl Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression2</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression2()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern <em>Tmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern
	 * @generated
	 */
	EClass getTmapInPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getSuccess()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EAttribute getTmapInPattern_Success();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlModel <em>T1atl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlModel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T1atlModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlPattern <em>T1atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlPattern()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T1atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlRule <em>T1atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT1atlRule()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T1atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrDomain <em>T2qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrDomain()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T2qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrRelation()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT2qvtrTypedModel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T2qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapMatchedRule()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapOclMetamodel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter <em>Tmap In Pattern filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap In Pattern filter</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter
	 * @generated
	 */
	EClass getTmapInPattern_filter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlExpression <em>T1atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T1atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlPattern <em>T1atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlPattern()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T1atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlRule <em>T1atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlRule()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T1atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2p <em>T2p</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2p</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2p()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T2p();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrDomain <em>T2qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrDomain()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T2qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrExpression <em>T2qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T2qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrRelation()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2w <em>T2w</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2w</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2w()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T2w();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern <em>Wmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapInPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp <em>Tmap Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Integer Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp
	 * @generated
	 */
	EClass getTmapIntegerExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher()
	 * @see #getTmapIntegerExp()
	 * @generated
	 */
	EReference getTmapIntegerExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getT0symbol <em>T0symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getT0symbol()
	 * @see #getTmapIntegerExp()
	 * @generated
	 */
	EAttribute getTmapIntegerExp_T0symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule <em>Tmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule
	 * @generated
	 */
	EClass getTmapMatchedRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getSuccess()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EAttribute getTmapMatchedRule_Success();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT0ruleName <em>T0rule Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0rule Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT0ruleName()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EAttribute getTmapMatchedRule_T0ruleName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1atlModule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1matchedRule <em>T1matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1matchedRule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T1matchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2_1 <em>T2 1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2 1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2_1()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T2_1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2qvtrRelation()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT2qvtrTransformation()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getWmapModule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_WmapModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super <em>Tmap Matched Rule super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Matched Rule super</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super
	 * @generated
	 */
	EClass getTmapMatchedRule_super();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT1atlChildRule <em>T1atl Child Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Child Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT1atlChildRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T1atlChildRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT1atlSuperRule <em>T1atl Super Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Super Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT1atlSuperRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T1atlSuperRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT2qvtrOverriddenRelation <em>T2qvtr Overridden Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Overridden Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT2qvtrOverriddenRelation()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T2qvtrOverriddenRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT2qvtrOverridesRelation <em>T2qvtr Overrides Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Overrides Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT2qvtrOverridesRelation()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T2qvtrOverridesRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule1 <em>Wmap Matched Rule1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule1()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_WmapMatchedRule1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule <em>Tmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule
	 * @generated
	 */
	EClass getTmapModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT0txName <em>T0tx Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0tx Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT0txName()
	 * @see #getTmapModule()
	 * @generated
	 */
	EAttribute getTmapModule_T0txName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1atlModule()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_1 <em>T2 1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2 1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_1()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T2_1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_2 <em>T2 2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2 2</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_2()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T2_2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_3 <em>T2 3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2 3</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_3()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T2_3();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_4 <em>T2 4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2 4</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2_4()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T2_4();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT2qvtrTransformation()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T2qvtrTransformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper <em>Tmap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Navigation Or Attribute Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	EClass getTmapNavigationOrAttributeCallExp_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT0propertyName <em>T0property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT0propertyName()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Helper_T0propertyName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1atlSource <em>T1atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1atlSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T1atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrOperation <em>T2qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrOperation()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSource <em>T2qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSourceArgument <em>T2qvtr Source Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrSourceArgument()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT2qvtrTransformation()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property <em>Tmap Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Navigation Or Attribute Call Exp Property</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	EClass getTmapNavigationOrAttributeCallExp_Property();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT0propertyName <em>T0property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT0propertyName()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Property_T0propertyName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT1atlSource <em>T1atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT1atlSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T1atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT2qvtrSource <em>T2qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT2qvtrSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T2qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getWmapOclExpression()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel <em>Tmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel
	 * @generated
	 */
	EClass getTmapOclMetamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT0tmName <em>T0tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT0tmName()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EAttribute getTmapOclMetamodel_T0tmName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT1oclMetamodel <em>T1ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT1oclMetamodel()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EReference getTmapOclMetamodel_T1oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT2qvtrTypedModel()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EReference getTmapOclMetamodel_T2qvtrTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN <em>Tmap Ocl Model IN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Model IN</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN
	 * @generated
	 */
	EClass getTmapOclModel_IN();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT0tmName <em>T0tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT0tmName()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EAttribute getTmapOclModel_IN_T0tmName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1atlModule()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1oclMetamodel <em>T1ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1oclMetamodel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T1oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1oclModel <em>T1ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT1oclModel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T1oclModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT2qvtrTransformation()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT2qvtrTypedModel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T2qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapModule()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapOclMetamodel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT <em>Tmap Ocl Model OUT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Model OUT</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT
	 * @generated
	 */
	EClass getTmapOclModel_OUT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT0tmName <em>T0tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT0tmName()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EAttribute getTmapOclModel_OUT_T0tmName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1atlModule <em>T1atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1atlModule()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T1atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1oclMetamodel <em>T1ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1oclMetamodel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T1oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1oclModel <em>T1ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT1oclModel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T1oclModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT2qvtrTransformation()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT2qvtrTypedModel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T2qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapModule()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapOclMetamodel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper <em>Tmap Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper
	 * @generated
	 */
	EClass getTmapOperationCallExp_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT0operationName <em>T0operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT0operationName()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Helper_T0operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT1atlSource <em>T1atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT1atlSource()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T1atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrOperation <em>T2qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrOperation()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T2qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrSource <em>T2qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrSource()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T2qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrSourceArgument <em>T2qvtr Source Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrSourceArgument()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T2qvtrSourceArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT2qvtrTransformation()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapHelper()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapModule()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation <em>Tmap Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation
	 * @generated
	 */
	EClass getTmapOperationCallExp_Operation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT0operationName <em>T0operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT0operationName()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Operation_T0operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT1atlSource <em>T1atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT1atlSource()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T1atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT2qvtrSource <em>T2qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT2qvtrSource()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T2qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument <em>Tmap Operation Call Exp argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument
	 * @generated
	 */
	EClass getTmapOperationCallExp_argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlArgument <em>T1atl Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlArgument()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T1atlArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlParent <em>T1atl Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Parent</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlParent()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T1atlParent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrArgument <em>T2qvtr Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrArgument()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T2qvtrArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrParent <em>T2qvtr Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Parent</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrParent()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T2qvtrParent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_WmapOclExpression1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp <em>Tmap Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operator Call Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp
	 * @generated
	 */
	EClass getTmapOperatorCallExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT0operationName <em>T0operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT0operationName()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EAttribute getTmapOperatorCallExp_T0operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT1atlSource <em>T1atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT1atlSource()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T1atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT2qvtrSource <em>T2qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT2qvtrSource()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T2qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT2qvtrTransformation <em>T2qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT2qvtrTransformation()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T2qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapModule()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapOclExpression()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern <em>Tmap Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Out Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern
	 * @generated
	 */
	EClass getTmapOutPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getSuccess()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EAttribute getTmapOutPattern_Success();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlPattern <em>T1atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlPattern()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_T1atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlRule <em>T1atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlRule()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_T1atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrDomain <em>T2qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrDomain()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_T2qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrRelation()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrTypedModel()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_T2qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapMatchedRule()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapOclMetamodel()
	 * @see #getTmapOutPattern()
	 * @generated
	 */
	EReference getTmapOutPattern_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement <em>Tmap Simple In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Simple In Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement
	 * @generated
	 */
	EClass getTmapSimpleInPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT0elementName <em>T0element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0element Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT0elementName()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleInPatternElement_T0elementName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlElement <em>T1atl Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlElement()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T1atlElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlPattern <em>T1atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T1atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlRule <em>T1atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1atlRule()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T1atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrDomain <em>T2qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrDomain()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T2qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrPattern <em>T2qvtr Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T2qvtrPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrRelation()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrTemplate <em>T2qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrTemplate()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T2qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrVariable <em>T2qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT2qvtrVariable()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T2qvtrVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern <em>Wmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapInPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement <em>Tmap Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Simple Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement
	 * @generated
	 */
	EClass getTmapSimpleOutPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getSuccess()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleOutPatternElement_Success();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT0elementName <em>T0element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0element Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT0elementName()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleOutPatternElement_T0elementName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlElement <em>T1atl Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlElement()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T1atlElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlPattern <em>T1atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlPattern()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T1atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlRule <em>T1atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1atlRule()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T1atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrDomain <em>T2qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrDomain()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T2qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrPattern <em>T2qvtr Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrPattern()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T2qvtrPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrRelation <em>T2qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrRelation()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T2qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrTemplate <em>T2qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrTemplate()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T2qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrVariable <em>T2qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT2qvtrVariable()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T2qvtrVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapMatchedRule()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapOutPattern <em>Wmap Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Out Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapOutPattern()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapOutPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapVariable()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp <em>Tmap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap String Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp
	 * @generated
	 */
	EClass getTmapStringExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher()
	 * @see #getTmapStringExp()
	 * @generated
	 */
	EReference getTmapStringExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT0symbol <em>T0symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT0symbol()
	 * @see #getTmapStringExp()
	 * @generated
	 */
	EAttribute getTmapStringExp_T0symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable <em>Tmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable
	 * @generated
	 */
	EClass getTmapVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getSuccess()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EAttribute getTmapVariable_Success();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT1atlVariable <em>T1atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT1atlVariable()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EReference getTmapVariable_T1atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT2qvtrVariable <em>T2qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT2qvtrVariable()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EReference getTmapVariable_T2qvtrVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp <em>Tmap Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp
	 * @generated
	 */
	EClass getTmapVariableExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT0varName <em>T0var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T0var Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT0varName()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EAttribute getTmapVariableExp_T0varName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT1atlVariable <em>T1atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT1atlVariable()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_T1atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getWmapVariableExp_referredVariable <em>Wmap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getWmapVariableExp_referredVariable()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_WmapVariableExp_referredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper <em>Tmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	EClass getTmapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT1atlHelper <em>T1atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT1atlHelper()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T1atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT1atlVariable <em>T1atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT1atlVariable()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T1atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT2qvtrVariable <em>T2qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT2qvtrVariable()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T2qvtrVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration <em>Tmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	EClass getTmapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT1atlVariable <em>T1atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T1atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT1atlVariable()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT2qvtrVariable <em>T2qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T2qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT2qvtrVariable()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	trace_ATL2QVTrFactory gettrace_ATL2QVTrFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl <em>Cmap Variable Exp referred Variable Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_Helper()
		 * @generated
		 */
		EClass CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getCmapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl <em>Cmap Variable Exp referred Variable Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_VariableDeclaration()
		 * @generated
		 */
		EClass CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getCmapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl <em>Dmap Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapHelper()
		 * @generated
		 */
		EClass DMAP_HELPER = eINSTANCE.getDmapHelper();

		/**
		 * The meta object literal for the '<em><b>D1atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__D1ATL_HELPER = eINSTANCE.getDmapHelper_D1atlHelper();

		/**
		 * The meta object literal for the '<em><b>D2qvtr Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__D2QVTR_FUNCTION = eINSTANCE.getDmapHelper_D2qvtrFunction();

		/**
		 * The meta object literal for the '<em><b>Domap Helper Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__DOMAP_HELPER_ATTRIBUTE = eINSTANCE.getDmapHelper_DomapHelper_Attribute();

		/**
		 * The meta object literal for the '<em><b>Domap Helper Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__DOMAP_HELPER_OPERATION = eINSTANCE.getDmapHelper_DomapHelper_Operation();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__RESULT = eINSTANCE.getDmapHelper_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl <em>Dmap Ocl Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapOclExpression()
		 * @generated
		 */
		EClass DMAP_OCL_EXPRESSION = eINSTANCE.getDmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>D1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__D1ATL_EXPRESSION = eINSTANCE.getDmapOclExpression_D1atlExpression();

		/**
		 * The meta object literal for the '<em><b>D2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__D2QVTR_EXPRESSION = eINSTANCE.getDmapOclExpression_D2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>Domap Boolean Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP = eINSTANCE.getDmapOclExpression_DomapBooleanExp();

		/**
		 * The meta object literal for the '<em><b>Domap If Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_IF_EXP = eINSTANCE.getDmapOclExpression_DomapIfExp();

		/**
		 * The meta object literal for the '<em><b>Domap Integer Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP = eINSTANCE.getDmapOclExpression_DomapIntegerExp();

		/**
		 * The meta object literal for the '<em><b>Domap Navigation Or Attribute Call Exp Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = eINSTANCE.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Navigation Or Attribute Call Exp Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = eINSTANCE.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property();

		/**
		 * The meta object literal for the '<em><b>Domap Operation Call Exp Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER = eINSTANCE.getDmapOclExpression_DomapOperationCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Operation Call Exp Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION = eINSTANCE.getDmapOclExpression_DomapOperationCallExp_Operation();

		/**
		 * The meta object literal for the '<em><b>Domap Operator Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP = eINSTANCE.getDmapOclExpression_DomapOperatorCallExp();

		/**
		 * The meta object literal for the '<em><b>Domap String Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP = eINSTANCE.getDmapOclExpression_DomapStringExp();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP = eINSTANCE.getDmapOclExpression_DomapVariableExp();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__RESULT = eINSTANCE.getDmapOclExpression_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl <em>Dmap Variable Exp referred Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapVariableExp_referredVariable()
		 * @generated
		 */
		EClass DMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getDmapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '<em><b>D1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D1ATL_EXPRESSION = eINSTANCE.getDmapVariableExp_referredVariable_D1atlExpression();

		/**
		 * The meta object literal for the '<em><b>D2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D2QVTR_EXPRESSION = eINSTANCE.getDmapVariableExp_referredVariable_D2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT = eINSTANCE.getDmapVariableExp_referredVariable_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl <em>Imap Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapHelper()
		 * @generated
		 */
		EClass IMAP_HELPER = eINSTANCE.getImapHelper();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_HELPER__SUCCESS = eINSTANCE.getImapHelper_Success();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl <em>Imap Ocl Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapOclExpression()
		 * @generated
		 */
		EClass IMAP_OCL_EXPRESSION = eINSTANCE.getImapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_OCL_EXPRESSION__SUCCESS = eINSTANCE.getImapOclExpression_Success();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl <em>Imap Variable Exp referred Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapVariableExp_referredVariable()
		 * @generated
		 */
		EClass IMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getImapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_VARIABLE_EXP_REFERRED_VARIABLE__SUCCESS = eINSTANCE.getImapVariableExp_referredVariable_Success();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl <em>Tmap Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBinding()
		 * @generated
		 */
		EClass TMAP_BINDING = eINSTANCE.getTmapBinding();

		/**
		 * The meta object literal for the '<em><b>T0property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_BINDING__T0PROPERTY_NAME = eINSTANCE.getTmapBinding_T0propertyName();

		/**
		 * The meta object literal for the '<em><b>T1atl Binding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T1ATL_BINDING = eINSTANCE.getTmapBinding_T1atlBinding();

		/**
		 * The meta object literal for the '<em><b>T1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T1ATL_EXPRESSION = eINSTANCE.getTmapBinding_T1atlExpression();

		/**
		 * The meta object literal for the '<em><b>T1atl Out Pattern Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapBinding_T1atlOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T2QVTR_EXPRESSION = eINSTANCE.getTmapBinding_T2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T2QVTR_PART = eINSTANCE.getTmapBinding_T2qvtrPart();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T2QVTR_TEMPLATE = eINSTANCE.getTmapBinding_T2qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapBinding_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Simple Out Pattern Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapBinding_WmapSimpleOutPatternElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl <em>Tmap Boolean Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBooleanExp()
		 * @generated
		 */
		EClass TMAP_BOOLEAN_EXP = eINSTANCE.getTmapBooleanExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BOOLEAN_EXP__DISPATCHER = eINSTANCE.getTmapBooleanExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_BOOLEAN_EXP__T0SYMBOL = eINSTANCE.getTmapBooleanExp_T0symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl <em>Tmap Helper Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Attribute()
		 * @generated
		 */
		EClass TMAP_HELPER_ATTRIBUTE = eINSTANCE.getTmapHelper_Attribute();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__DISPATCHER = eINSTANCE.getTmapHelper_Attribute_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_ATTRIBUTE__T0ATTRIBUTE_NAME = eINSTANCE.getTmapHelper_Attribute_T0attributeName();

		/**
		 * The meta object literal for the '<em><b>T1atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T1ATL_DEFINITION = eINSTANCE.getTmapHelper_Attribute_T1atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T1ATL_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_T1atlExpression();

		/**
		 * The meta object literal for the '<em><b>T1atl Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T1ATL_FEATURE = eINSTANCE.getTmapHelper_Attribute_T1atlFeature();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T1ATL_MODULE = eINSTANCE.getTmapHelper_Attribute_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T1atl Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T1ATL_TYPE = eINSTANCE.getTmapHelper_Attribute_T1atlType();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T2QVTR_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_T2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapHelper_Attribute_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Attribute_WmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_MODULE = eINSTANCE.getTmapHelper_Attribute_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl <em>Tmap Helper Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Context()
		 * @generated
		 */
		EClass TMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>T1atl Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T1ATL_CONTEXT = eINSTANCE.getTmapHelper_Context_T1atlContext();

		/**
		 * The meta object literal for the '<em><b>T1atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T1ATL_DEFINITION = eINSTANCE.getTmapHelper_Context_T1atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T1atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T1ATL_HELPER = eINSTANCE.getTmapHelper_Context_T1atlHelper();

		/**
		 * The meta object literal for the '<em><b>T1atl Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE = eINSTANCE.getTmapHelper_Context_T1atlReturnType();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION = eINSTANCE.getTmapHelper_Context_T2qvtrFunction();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER = eINSTANCE.getTmapHelper_Context_T2qvtrParameter();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__WMAP_VARIABLE = eINSTANCE.getTmapHelper_Context_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl <em>Tmap Helper Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Operation()
		 * @generated
		 */
		EClass TMAP_HELPER_OPERATION = eINSTANCE.getTmapHelper_Operation();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__DISPATCHER = eINSTANCE.getTmapHelper_Operation_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_OPERATION__T0OPERATION_NAME = eINSTANCE.getTmapHelper_Operation_T0operationName();

		/**
		 * The meta object literal for the '<em><b>T1atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T1ATL_DEFINITION = eINSTANCE.getTmapHelper_Operation_T1atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T1ATL_EXPRESSION = eINSTANCE.getTmapHelper_Operation_T1atlExpression();

		/**
		 * The meta object literal for the '<em><b>T1atl Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T1ATL_FEATURE = eINSTANCE.getTmapHelper_Operation_T1atlFeature();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T1ATL_MODULE = eINSTANCE.getTmapHelper_Operation_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T1atl Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T1ATL_TYPE = eINSTANCE.getTmapHelper_Operation_T1atlType();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION = eINSTANCE.getTmapHelper_Operation_T2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapHelper_Operation_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Operation_WmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_MODULE = eINSTANCE.getTmapHelper_Operation_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapHelper_Operation_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl <em>Tmap If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIfExp()
		 * @generated
		 */
		EClass TMAP_IF_EXP = eINSTANCE.getTmapIfExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__DISPATCHER = eINSTANCE.getTmapIfExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1atl Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T1ATL_CONDITION = eINSTANCE.getTmapIfExp_T1atlCondition();

		/**
		 * The meta object literal for the '<em><b>T1atl Else</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T1ATL_ELSE = eINSTANCE.getTmapIfExp_T1atlElse();

		/**
		 * The meta object literal for the '<em><b>T1atl Then</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T1ATL_THEN = eINSTANCE.getTmapIfExp_T1atlThen();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T2QVTR_CONDITION = eINSTANCE.getTmapIfExp_T2qvtrCondition();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Else</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T2QVTR_ELSE = eINSTANCE.getTmapIfExp_T2qvtrElse();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Then</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T2QVTR_THEN = eINSTANCE.getTmapIfExp_T2qvtrThen();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapIfExp_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION1 = eINSTANCE.getTmapIfExp_WmapOclExpression1();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION2 = eINSTANCE.getTmapIfExp_WmapOclExpression2();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl <em>Tmap In Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern()
		 * @generated
		 */
		EClass TMAP_IN_PATTERN = eINSTANCE.getTmapInPattern();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_IN_PATTERN__SUCCESS = eINSTANCE.getTmapInPattern_Success();

		/**
		 * The meta object literal for the '<em><b>T1atl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T1ATL_MODEL = eINSTANCE.getTmapInPattern_T1atlModel();

		/**
		 * The meta object literal for the '<em><b>T1atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T1ATL_PATTERN = eINSTANCE.getTmapInPattern_T1atlPattern();

		/**
		 * The meta object literal for the '<em><b>T1atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T1ATL_RULE = eINSTANCE.getTmapInPattern_T1atlRule();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T2QVTR_DOMAIN = eINSTANCE.getTmapInPattern_T2qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T2QVTR_RELATION = eINSTANCE.getTmapInPattern_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T2QVTR_TYPED_MODEL = eINSTANCE.getTmapInPattern_T2qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__WMAP_MATCHED_RULE = eINSTANCE.getTmapInPattern_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__WMAP_OCL_METAMODEL = eINSTANCE.getTmapInPattern_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl <em>Tmap In Pattern filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern_filter()
		 * @generated
		 */
		EClass TMAP_IN_PATTERN_FILTER = eINSTANCE.getTmapInPattern_filter();

		/**
		 * The meta object literal for the '<em><b>T1atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T1ATL_EXPRESSION = eINSTANCE.getTmapInPattern_filter_T1atlExpression();

		/**
		 * The meta object literal for the '<em><b>T1atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T1ATL_PATTERN = eINSTANCE.getTmapInPattern_filter_T1atlPattern();

		/**
		 * The meta object literal for the '<em><b>T1atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T1ATL_RULE = eINSTANCE.getTmapInPattern_filter_T1atlRule();

		/**
		 * The meta object literal for the '<em><b>T2p</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T2P = eINSTANCE.getTmapInPattern_filter_T2p();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T2QVTR_DOMAIN = eINSTANCE.getTmapInPattern_filter_T2qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T2QVTR_EXPRESSION = eINSTANCE.getTmapInPattern_filter_T2qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T2QVTR_RELATION = eINSTANCE.getTmapInPattern_filter_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2w</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T2W = eINSTANCE.getTmapInPattern_filter_T2w();

		/**
		 * The meta object literal for the '<em><b>Wmap In Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_IN_PATTERN = eINSTANCE.getTmapInPattern_filter_WmapInPattern();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_MATCHED_RULE = eINSTANCE.getTmapInPattern_filter_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapInPattern_filter_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl <em>Tmap Integer Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIntegerExp()
		 * @generated
		 */
		EClass TMAP_INTEGER_EXP = eINSTANCE.getTmapIntegerExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_INTEGER_EXP__DISPATCHER = eINSTANCE.getTmapIntegerExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_INTEGER_EXP__T0SYMBOL = eINSTANCE.getTmapIntegerExp_T0symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl <em>Tmap Matched Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule()
		 * @generated
		 */
		EClass TMAP_MATCHED_RULE = eINSTANCE.getTmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MATCHED_RULE__SUCCESS = eINSTANCE.getTmapMatchedRule_Success();

		/**
		 * The meta object literal for the '<em><b>T0rule Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MATCHED_RULE__T0RULE_NAME = eINSTANCE.getTmapMatchedRule_T0ruleName();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T1ATL_MODULE = eINSTANCE.getTmapMatchedRule_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T1matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T1MATCHED_RULE = eINSTANCE.getTmapMatchedRule_T1matchedRule();

		/**
		 * The meta object literal for the '<em><b>T2 1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T2_1 = eINSTANCE.getTmapMatchedRule_T2_1();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T2QVTR_RELATION = eINSTANCE.getTmapMatchedRule_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapMatchedRule_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__WMAP_MODULE = eINSTANCE.getTmapMatchedRule_WmapModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl <em>Tmap Matched Rule super</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule_super()
		 * @generated
		 */
		EClass TMAP_MATCHED_RULE_SUPER = eINSTANCE.getTmapMatchedRule_super();

		/**
		 * The meta object literal for the '<em><b>T1atl Child Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T1ATL_CHILD_RULE = eINSTANCE.getTmapMatchedRule_super_T1atlChildRule();

		/**
		 * The meta object literal for the '<em><b>T1atl Super Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T1ATL_SUPER_RULE = eINSTANCE.getTmapMatchedRule_super_T1atlSuperRule();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Overridden Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDDEN_RELATION = eINSTANCE.getTmapMatchedRule_super_T2qvtrOverriddenRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Overrides Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T2QVTR_OVERRIDES_RELATION = eINSTANCE.getTmapMatchedRule_super_T2qvtrOverridesRelation();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE = eINSTANCE.getTmapMatchedRule_super_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1 = eINSTANCE.getTmapMatchedRule_super_WmapMatchedRule1();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl <em>Tmap Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapModule()
		 * @generated
		 */
		EClass TMAP_MODULE = eINSTANCE.getTmapModule();

		/**
		 * The meta object literal for the '<em><b>T0tx Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MODULE__T0TX_NAME = eINSTANCE.getTmapModule_T0txName();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T1ATL_MODULE = eINSTANCE.getTmapModule_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T2 1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T2_1 = eINSTANCE.getTmapModule_T2_1();

		/**
		 * The meta object literal for the '<em><b>T2 2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T2_2 = eINSTANCE.getTmapModule_T2_2();

		/**
		 * The meta object literal for the '<em><b>T2 3</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T2_3 = eINSTANCE.getTmapModule_T2_3();

		/**
		 * The meta object literal for the '<em><b>T2 4</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T2_4 = eINSTANCE.getTmapModule_T2_4();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapModule_T2qvtrTransformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl <em>Tmap Navigation Or Attribute Call Exp Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Helper()
		 * @generated
		 */
		EClass TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T0PROPERTY_NAME = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T0propertyName();

		/**
		 * The meta object literal for the '<em><b>T1atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1ATL_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T1atlSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_OPERATION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T2qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T2qvtrSourceArgument();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapHelper();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_MODULE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl <em>Tmap Navigation Or Attribute Call Exp Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Property()
		 * @generated
		 */
		EClass TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T0propertyName();

		/**
		 * The meta object literal for the '<em><b>T1atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T1atlSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T2qvtrSource();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl <em>Tmap Ocl Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclMetamodel()
		 * @generated
		 */
		EClass TMAP_OCL_METAMODEL = eINSTANCE.getTmapOclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T0tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_METAMODEL__T0TM_NAME = eINSTANCE.getTmapOclMetamodel_T0tmName();

		/**
		 * The meta object literal for the '<em><b>T1ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_METAMODEL__T1OCL_METAMODEL = eINSTANCE.getTmapOclMetamodel_T1oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL = eINSTANCE.getTmapOclMetamodel_T2qvtrTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl <em>Tmap Ocl Model IN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_IN()
		 * @generated
		 */
		EClass TMAP_OCL_MODEL_IN = eINSTANCE.getTmapOclModel_IN();

		/**
		 * The meta object literal for the '<em><b>T0tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_MODEL_IN__T0TM_NAME = eINSTANCE.getTmapOclModel_IN_T0tmName();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T1ATL_MODULE = eINSTANCE.getTmapOclModel_IN_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T1ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T1OCL_METAMODEL = eINSTANCE.getTmapOclModel_IN_T1oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T1ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T1OCL_MODEL = eINSTANCE.getTmapOclModel_IN_T1oclModel();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapOclModel_IN_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL = eINSTANCE.getTmapOclModel_IN_T2qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__WMAP_MODULE = eINSTANCE.getTmapOclModel_IN_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL = eINSTANCE.getTmapOclModel_IN_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl <em>Tmap Ocl Model OUT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_OUT()
		 * @generated
		 */
		EClass TMAP_OCL_MODEL_OUT = eINSTANCE.getTmapOclModel_OUT();

		/**
		 * The meta object literal for the '<em><b>T0tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_MODEL_OUT__T0TM_NAME = eINSTANCE.getTmapOclModel_OUT_T0tmName();

		/**
		 * The meta object literal for the '<em><b>T1atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T1ATL_MODULE = eINSTANCE.getTmapOclModel_OUT_T1atlModule();

		/**
		 * The meta object literal for the '<em><b>T1ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T1OCL_METAMODEL = eINSTANCE.getTmapOclModel_OUT_T1oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T1ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T1OCL_MODEL = eINSTANCE.getTmapOclModel_OUT_T1oclModel();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapOclModel_OUT_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T2QVTR_TYPED_MODEL = eINSTANCE.getTmapOclModel_OUT_T2qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__WMAP_MODULE = eINSTANCE.getTmapOclModel_OUT_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__WMAP_OCL_METAMODEL = eINSTANCE.getTmapOclModel_OUT_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl <em>Tmap Operation Call Exp Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Helper()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_HELPER = eINSTANCE.getTmapOperationCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER = eINSTANCE.getTmapOperationCallExp_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME = eINSTANCE.getTmapOperationCallExp_Helper_T0operationName();

		/**
		 * The meta object literal for the '<em><b>T1atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE = eINSTANCE.getTmapOperationCallExp_Helper_T1atlSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION = eINSTANCE.getTmapOperationCallExp_Helper_T2qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE = eINSTANCE.getTmapOperationCallExp_Helper_T2qvtrSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT = eINSTANCE.getTmapOperationCallExp_Helper_T2qvtrSourceArgument();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapOperationCallExp_Helper_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER = eINSTANCE.getTmapOperationCallExp_Helper_WmapHelper();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE = eINSTANCE.getTmapOperationCallExp_Helper_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_Helper_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl <em>Tmap Operation Call Exp Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Operation()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_OPERATION = eINSTANCE.getTmapOperationCallExp_Operation();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER = eINSTANCE.getTmapOperationCallExp_Operation_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME = eINSTANCE.getTmapOperationCallExp_Operation_T0operationName();

		/**
		 * The meta object literal for the '<em><b>T1atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE = eINSTANCE.getTmapOperationCallExp_Operation_T1atlSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE = eINSTANCE.getTmapOperationCallExp_Operation_T2qvtrSource();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_Operation_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl <em>Tmap Operation Call Exp argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_argument()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument();

		/**
		 * The meta object literal for the '<em><b>T1atl Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument_T1atlArgument();

		/**
		 * The meta object literal for the '<em><b>T1atl Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T1ATL_PARENT = eINSTANCE.getTmapOperationCallExp_argument_T1atlParent();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument_T2qvtrArgument();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T2QVTR_PARENT = eINSTANCE.getTmapOperationCallExp_argument_T2qvtrParent();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_argument_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION1 = eINSTANCE.getTmapOperationCallExp_argument_WmapOclExpression1();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl <em>Tmap Operator Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperatorCallExp()
		 * @generated
		 */
		EClass TMAP_OPERATOR_CALL_EXP = eINSTANCE.getTmapOperatorCallExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__DISPATCHER = eINSTANCE.getTmapOperatorCallExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATOR_CALL_EXP__T0OPERATION_NAME = eINSTANCE.getTmapOperatorCallExp_T0operationName();

		/**
		 * The meta object literal for the '<em><b>T1atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T1ATL_SOURCE = eINSTANCE.getTmapOperatorCallExp_T1atlSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T2QVTR_SOURCE = eINSTANCE.getTmapOperatorCallExp_T2qvtrSource();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T2QVTR_TRANSFORMATION = eINSTANCE.getTmapOperatorCallExp_T2qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__WMAP_MODULE = eINSTANCE.getTmapOperatorCallExp_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperatorCallExp_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl <em>Tmap Out Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOutPatternImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOutPattern()
		 * @generated
		 */
		EClass TMAP_OUT_PATTERN = eINSTANCE.getTmapOutPattern();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OUT_PATTERN__SUCCESS = eINSTANCE.getTmapOutPattern_Success();

		/**
		 * The meta object literal for the '<em><b>T1atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__T1ATL_PATTERN = eINSTANCE.getTmapOutPattern_T1atlPattern();

		/**
		 * The meta object literal for the '<em><b>T1atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__T1ATL_RULE = eINSTANCE.getTmapOutPattern_T1atlRule();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__T2QVTR_DOMAIN = eINSTANCE.getTmapOutPattern_T2qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__T2QVTR_RELATION = eINSTANCE.getTmapOutPattern_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__T2QVTR_TYPED_MODEL = eINSTANCE.getTmapOutPattern_T2qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__WMAP_MATCHED_RULE = eINSTANCE.getTmapOutPattern_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OUT_PATTERN__WMAP_OCL_METAMODEL = eINSTANCE.getTmapOutPattern_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl <em>Tmap Simple In Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleInPatternElement()
		 * @generated
		 */
		EClass TMAP_SIMPLE_IN_PATTERN_ELEMENT = eINSTANCE.getTmapSimpleInPatternElement();

		/**
		 * The meta object literal for the '<em><b>T0element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_IN_PATTERN_ELEMENT__T0ELEMENT_NAME = eINSTANCE.getTmapSimpleInPatternElement_T0elementName();

		/**
		 * The meta object literal for the '<em><b>T1atl Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_ELEMENT = eINSTANCE.getTmapSimpleInPatternElement_T1atlElement();

		/**
		 * The meta object literal for the '<em><b>T1atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_T1atlPattern();

		/**
		 * The meta object literal for the '<em><b>T1atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ATL_RULE = eINSTANCE.getTmapSimpleInPatternElement_T1atlRule();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_DOMAIN = eINSTANCE.getTmapSimpleInPatternElement_T2qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_T2qvtrPattern();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_RELATION = eINSTANCE.getTmapSimpleInPatternElement_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_TEMPLATE = eINSTANCE.getTmapSimpleInPatternElement_T2qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T2QVTR_VARIABLE = eINSTANCE.getTmapSimpleInPatternElement_T2qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap In Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_IN_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_WmapInPattern();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_MATCHED_RULE = eINSTANCE.getTmapSimpleInPatternElement_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_VARIABLE = eINSTANCE.getTmapSimpleInPatternElement_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl <em>Tmap Simple Out Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleOutPatternElement()
		 * @generated
		 */
		EClass TMAP_SIMPLE_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapSimpleOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_OUT_PATTERN_ELEMENT__SUCCESS = eINSTANCE.getTmapSimpleOutPatternElement_Success();

		/**
		 * The meta object literal for the '<em><b>T0element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T0ELEMENT_NAME = eINSTANCE.getTmapSimpleOutPatternElement_T0elementName();

		/**
		 * The meta object literal for the '<em><b>T1atl Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_ELEMENT = eINSTANCE.getTmapSimpleOutPatternElement_T1atlElement();

		/**
		 * The meta object literal for the '<em><b>T1atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_PATTERN = eINSTANCE.getTmapSimpleOutPatternElement_T1atlPattern();

		/**
		 * The meta object literal for the '<em><b>T1atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ATL_RULE = eINSTANCE.getTmapSimpleOutPatternElement_T1atlRule();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_DOMAIN = eINSTANCE.getTmapSimpleOutPatternElement_T2qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_PATTERN = eINSTANCE.getTmapSimpleOutPatternElement_T2qvtrPattern();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_RELATION = eINSTANCE.getTmapSimpleOutPatternElement_T2qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_TEMPLATE = eINSTANCE.getTmapSimpleOutPatternElement_T2qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T2QVTR_VARIABLE = eINSTANCE.getTmapSimpleOutPatternElement_T2qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_MATCHED_RULE = eINSTANCE.getTmapSimpleOutPatternElement_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Out Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_OUT_PATTERN = eINSTANCE.getTmapSimpleOutPatternElement_WmapOutPattern();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_VARIABLE = eINSTANCE.getTmapSimpleOutPatternElement_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl <em>Tmap String Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapStringExp()
		 * @generated
		 */
		EClass TMAP_STRING_EXP = eINSTANCE.getTmapStringExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_STRING_EXP__DISPATCHER = eINSTANCE.getTmapStringExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_STRING_EXP__T0SYMBOL = eINSTANCE.getTmapStringExp_T0symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl <em>Tmap Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariable()
		 * @generated
		 */
		EClass TMAP_VARIABLE = eINSTANCE.getTmapVariable();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE__SUCCESS = eINSTANCE.getTmapVariable_Success();

		/**
		 * The meta object literal for the '<em><b>T1atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE__T1ATL_VARIABLE = eINSTANCE.getTmapVariable_T1atlVariable();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE__T2QVTR_VARIABLE = eINSTANCE.getTmapVariable_T2qvtrVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl <em>Tmap Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP = eINSTANCE.getTmapVariableExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__DISPATCHER = eINSTANCE.getTmapVariableExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T0var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE_EXP__T0VAR_NAME = eINSTANCE.getTmapVariableExp_T0varName();

		/**
		 * The meta object literal for the '<em><b>T1atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__T1ATL_VARIABLE = eINSTANCE.getTmapVariableExp_T1atlVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable Exp referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getTmapVariableExp_WmapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl <em>Tmap Variable Exp referred Variable Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_Helper()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getTmapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER = eINSTANCE.getTmapVariableExp_referredVariable_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T1atlHelper();

		/**
		 * The meta object literal for the '<em><b>T1atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T1atlVariable();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T2qvtrVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl <em>Tmap Variable Exp referred Variable Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_VariableDeclaration()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DISPATCHER = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T1ATL_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_T1atlVariable();

		/**
		 * The meta object literal for the '<em><b>T2qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T2QVTR_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_T2qvtrVariable();

	}

} //trace_ATL2QVTrPackage
