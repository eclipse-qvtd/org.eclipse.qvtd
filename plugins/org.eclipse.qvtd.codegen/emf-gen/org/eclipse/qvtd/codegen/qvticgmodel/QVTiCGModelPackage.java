/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;

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
 * <!-- begin-model-doc -->
 * The CGModel provides a Code Generation friendly form of the OCL Pivot model, with distinct classes
 * such as LibraryPropertyCallExp and EcorePropertyCallExp for distinct purposes. Additional classes
 * such as BoxExpr, CatchExpr and CastParameter support rewrite optimizations.
 * <p>
 * References to the Pivot model are expressed as attributes with datatype values in order to avoid
 * confusion as to whether the new or old pivot mosdel is in use while code generating the pivot model.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface QVTiCGModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvticgmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvti/0.12.0/CG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvticg";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.codegen.qvticgmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@NonNull QVTiCGModelPackage eINSTANCE = org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl <em>CG Connection Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionAssignment()
	 * @generated
	 */
	int CG_CONNECTION_ASSIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__MAPPING_EXP = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__INIT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connection Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Connection Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl <em>CG Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPropertyAssignment()
	 * @generated
	 */
	int CG_PROPERTY_ASSIGNMENT = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl <em>CG Ecore Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcorePropertyAssignment()
	 * @generated
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
	 * @generated
	 */
	int CG_MAPPING = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl <em>CG Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTransformation()
	 * @generated
	 */
	int CG_TRANSFORMATION = 19;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment <em>CG Ecore Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment
	 * @generated
	 */
	EClass getCGEcorePropertyAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment#getEStructuralFeature()
	 * @see #getCGEcorePropertyAssignment()
	 * @generated
	 */
	EReference getCGEcorePropertyAssignment_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable <em>CG Ecore Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable
	 * @generated
	 */
	EClass getCGEcoreRealizedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier <em>EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClassifier</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable#getEClassifier()
	 * @see #getCGEcoreRealizedVariable()
	 * @generated
	 */
	EReference getCGEcoreRealizedVariable_EClassifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunction <em>CG Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunction
	 * @generated
	 */
	EClass getCGFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp <em>CG Function Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function Call Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp
	 * @generated
	 */
	EClass getCGFunctionCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp#getFunction()
	 * @see #getCGFunctionCallExp()
	 * @generated
	 */
	EReference getCGFunctionCallExp_Function();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter <em>CG Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Function Parameter</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter
	 * @generated
	 */
	EClass getCGFunctionParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter#getFunction()
	 * @see #getCGFunctionParameter()
	 * @generated
	 */
	EReference getCGFunctionParameter_Function();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable <em>CG Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Guard Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable
	 * @generated
	 */
	EClass getCGGuardVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getMapping()
	 * @see #getCGGuardVariable()
	 * @generated
	 */
	EReference getCGGuardVariable_Mapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getTypedModel()
	 * @see #getCGGuardVariable()
	 * @generated
	 */
	EReference getCGGuardVariable_TypedModel();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl <em>CG Mapping Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCall()
	 * @generated
	 */
	int CG_MAPPING_CALL = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl <em>CG Mapping Call Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCallBinding()
	 * @generated
	 */
	int CG_MAPPING_CALL_BINDING = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl <em>CG Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPredicate()
	 * @generated
	 */
	int CG_PREDICATE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl <em>CG Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGRealizedVariable()
	 * @generated
	 */
	int CG_REALIZED_VARIABLE = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl <em>CG Ecore Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreRealizedVariable()
	 * @generated
	 */
	int CG_ECORE_REALIZED_VARIABLE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl <em>CG Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunction()
	 * @generated
	 */
	int CG_FUNCTION = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl <em>CG Function Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionCallExp()
	 * @generated
	 */
	int CG_FUNCTION_CALL_EXP = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl <em>CG Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionParameter()
	 * @generated
	 */
	int CG_FUNCTION_PARAMETER = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl <em>CG Guard Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGGuardVariable()
	 * @generated
	 */
	int CG_GUARD_VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__AST = CGModelPackage.CG_PARAMETER__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__NAME = CGModelPackage.CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__TYPE_ID = CGModelPackage.CG_PARAMETER__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__REQUIRED = CGModelPackage.CG_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__DEPENDS_ON = CGModelPackage.CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__OWNS = CGModelPackage.CG_PARAMETER__OWNS;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__INIT = CGModelPackage.CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Callable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__CALLABLE = CGModelPackage.CG_PARAMETER__CALLABLE;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__MAPPING = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__TYPED_MODEL = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE_FEATURE_COUNT = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl <em>CG Connection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionVariable()
	 * @generated
	 */
	int CG_CONNECTION_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__AST = CG_GUARD_VARIABLE__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__NAME = CG_GUARD_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__TYPE_ID = CG_GUARD_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__REQUIRED = CG_GUARD_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__DEPENDS_ON = CG_GUARD_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__OWNS = CG_GUARD_VARIABLE__OWNS;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__INIT = CG_GUARD_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Callable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__CALLABLE = CG_GUARD_VARIABLE__CALLABLE;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__MAPPING = CG_GUARD_VARIABLE__MAPPING;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__TYPED_MODEL = CG_GUARD_VARIABLE__TYPED_MODEL;

	/**
	 * The number of structural features of the '<em>CG Connection Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE_FEATURE_COUNT = CG_GUARD_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__MAPPING_EXP = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__SLOT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__INIT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>CG Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__AST = CG_PROPERTY_ASSIGNMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__NAME = CG_PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__TYPE_ID = CG_PROPERTY_ASSIGNMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__REQUIRED = CG_PROPERTY_ASSIGNMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__DEPENDS_ON = CG_PROPERTY_ASSIGNMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__OWNS = CG_PROPERTY_ASSIGNMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__MAPPING_EXP = CG_PROPERTY_ASSIGNMENT__MAPPING_EXP;

	/**
	 * The feature id for the '<em><b>Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__SLOT_VALUE = CG_PROPERTY_ASSIGNMENT__SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__INIT_VALUE = CG_PROPERTY_ASSIGNMENT__INIT_VALUE;

	/**
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE = CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__AST = CGModelPackage.CG_VARIABLE__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__NAME = CGModelPackage.CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__TYPE_ID = CGModelPackage.CG_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__REQUIRED = CGModelPackage.CG_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__DEPENDS_ON = CGModelPackage.CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__OWNS = CGModelPackage.CG_VARIABLE__OWNS;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__INIT = CGModelPackage.CG_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Executor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__EXECUTOR_TYPE = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__TYPED_MODEL = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE_FEATURE_COUNT = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__AST = CG_REALIZED_VARIABLE__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__NAME = CG_REALIZED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__TYPE_ID = CG_REALIZED_VARIABLE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__REQUIRED = CG_REALIZED_VARIABLE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__DEPENDS_ON = CG_REALIZED_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__OWNS = CG_REALIZED_VARIABLE__OWNS;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__INIT = CG_REALIZED_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Executor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__EXECUTOR_TYPE = CG_REALIZED_VARIABLE__EXECUTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__TYPED_MODEL = CG_REALIZED_VARIABLE__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__ECLASSIFIER = CG_REALIZED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE_FEATURE_COUNT = CG_REALIZED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__AST = CGModelPackage.CG_OPERATION__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__NAME = CGModelPackage.CG_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__TYPE_ID = CGModelPackage.CG_OPERATION__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__REQUIRED = CGModelPackage.CG_OPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__DEPENDS_ON = CGModelPackage.CG_OPERATION__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__OWNS = CGModelPackage.CG_OPERATION__OWNS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__PARAMETERS = CGModelPackage.CG_OPERATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__BODY = CGModelPackage.CG_OPERATION__BODY;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__PRECONDITIONS = CGModelPackage.CG_OPERATION__PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__POSTCONDITIONS = CGModelPackage.CG_OPERATION__POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__CONTAINING_CLASS = CGModelPackage.CG_OPERATION__CONTAINING_CLASS;

	/**
	 * The number of structural features of the '<em>CG Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_FEATURE_COUNT = CGModelPackage.CG_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__AST = CGModelPackage.CG_OPERATION_CALL_EXP__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__NAME = CGModelPackage.CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__TYPE_ID = CGModelPackage.CG_OPERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__REQUIRED = CGModelPackage.CG_OPERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__DEPENDS_ON = CGModelPackage.CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__OWNS = CGModelPackage.CG_OPERATION_CALL_EXP__OWNS;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__INVALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__VALIDATING = CGModelPackage.CG_OPERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__SOURCE = CGModelPackage.CG_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__ARGUMENTS = CGModelPackage.CG_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__REFERRED_OPERATION = CGModelPackage.CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__FUNCTION = CGModelPackage.CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Function Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP_FEATURE_COUNT = CGModelPackage.CG_OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__AST = CGModelPackage.CG_PARAMETER__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__NAME = CGModelPackage.CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__TYPE_ID = CGModelPackage.CG_PARAMETER__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__REQUIRED = CGModelPackage.CG_PARAMETER__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__DEPENDS_ON = CGModelPackage.CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__OWNS = CGModelPackage.CG_PARAMETER__OWNS;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__INIT = CGModelPackage.CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Callable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__CALLABLE = CGModelPackage.CG_PARAMETER__CALLABLE;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__FUNCTION = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER_FEATURE_COUNT = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__AST = CGModelPackage.CG_NAMED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__NAME = CGModelPackage.CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__BODY = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Free Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__FREE_VARIABLES = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__TRANSFORMATION = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_FEATURE_COUNT = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Mapping Call Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__MAPPING_CALL_BINDINGS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Mapping Call Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl <em>CG Mapping Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingExp()
	 * @generated
	 */
	int CG_MAPPING_EXP = 11;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__ASSIGNMENTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__PREDICATES = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__REALIZED_VARIABLES = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__BODY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Variable Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Connection Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Accumulators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__OWNED_ACCUMULATORS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>CG Mapping Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl <em>CG Mapping Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingLoop()
	 * @generated
	 */
	int CG_MAPPING_LOOP = 12;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__AST = CGModelPackage.CG_ITERATION_CALL_EXP__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__NAME = CGModelPackage.CG_ITERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__TYPE_ID = CGModelPackage.CG_ITERATION_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__REQUIRED = CGModelPackage.CG_ITERATION_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__DEPENDS_ON = CGModelPackage.CG_ITERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__OWNS = CGModelPackage.CG_ITERATION_CALL_EXP__OWNS;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__INVALIDATING = CGModelPackage.CG_ITERATION_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__VALIDATING = CGModelPackage.CG_ITERATION_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__SOURCE = CGModelPackage.CG_ITERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__REFERRED_ITERATION = CGModelPackage.CG_ITERATION_CALL_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__ITERATORS = CGModelPackage.CG_ITERATION_CALL_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP__BODY = CGModelPackage.CG_ITERATION_CALL_EXP__BODY;

	/**
	 * The number of structural features of the '<em>CG Mapping Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_LOOP_FEATURE_COUNT = CGModelPackage.CG_ITERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl <em>CG Middle Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyAssignment()
	 * @generated
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT = 13;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__AST = CG_ECORE_PROPERTY_ASSIGNMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__NAME = CG_ECORE_PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__TYPE_ID = CG_ECORE_PROPERTY_ASSIGNMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__REQUIRED = CG_ECORE_PROPERTY_ASSIGNMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__DEPENDS_ON = CG_ECORE_PROPERTY_ASSIGNMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__OWNS = CG_ECORE_PROPERTY_ASSIGNMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__MAPPING_EXP = CG_ECORE_PROPERTY_ASSIGNMENT__MAPPING_EXP;

	/**
	 * The feature id for the '<em><b>Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__SLOT_VALUE = CG_ECORE_PROPERTY_ASSIGNMENT__SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CG_ECORE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__INIT_VALUE = CG_ECORE_PROPERTY_ASSIGNMENT__INIT_VALUE;

	/**
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CG_ECORE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE = CG_ECORE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>CG Middle Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CG_ECORE_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl <em>CG Middle Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyCallExp()
	 * @generated
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP = 14;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__AST = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__NAME = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__TYPE_ID = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__REQUIRED = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__DEPENDS_ON = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__OWNS = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__OWNS;

	/**
	 * The feature id for the '<em><b>Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__INVALIDATING = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__INVALIDATING;

	/**
	 * The feature id for the '<em><b>Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__VALIDATING = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__VALIDATING;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__SOURCE = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP__REFERRED_PROPERTY = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP__REFERRED_PROPERTY;

	/**
	 * The number of structural features of the '<em>CG Middle Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_CALL_EXP_FEATURE_COUNT = CGModelPackage.CG_OPPOSITE_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__CONDITION_EXPRESSION = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__MAPPING_EXP = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__THEN_EXPRESSION = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl <em>CG Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGSequence()
	 * @generated
	 */
	int CG_SEQUENCE = 18;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__AST = CGModelPackage.CG_VALUED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__REQUIRED = CGModelPackage.CG_VALUED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__OWNS = CGModelPackage.CG_VALUED_ELEMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__STATEMENTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__AST = CGModelPackage.CG_CLASS__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__NAME = CGModelPackage.CG_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Containing Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__CONTAINING_PACKAGE = CGModelPackage.CG_CLASS__CONTAINING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__OPERATIONS = CGModelPackage.CG_CLASS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__PROPERTIES = CGModelPackage.CG_CLASS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__INVARIANTS = CGModelPackage.CG_CLASS__INVARIANTS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__SUPER_TYPES = CGModelPackage.CG_CLASS__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__INTERFACE = CGModelPackage.CG_CLASS__INTERFACE;

	/**
	 * The feature id for the '<em><b>Template Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__TEMPLATE_PARAMETERS = CGModelPackage.CG_CLASS__TEMPLATE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__MAPPINGS = CGModelPackage.CG_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__TYPED_MODELS = CGModelPackage.CG_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION_FEATURE_COUNT = CGModelPackage.CG_CLASS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl <em>CG Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTypedModel()
	 * @generated
	 */
	int CG_TYPED_MODEL = 20;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__AST = CGModelPackage.CG_NAMED_ELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__NAME = CGModelPackage.CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__TRANSFORMATION = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__MODEL_INDEX = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL_FEATURE_COUNT = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGVariablePredicateImpl <em>CG Variable Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGVariablePredicateImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGVariablePredicate()
	 * @generated
	 */
	int CG_VARIABLE_PREDICATE = 21;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__AST = CG_PREDICATE__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__NAME = CG_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__TYPE_ID = CG_PREDICATE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__REQUIRED = CG_PREDICATE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__DEPENDS_ON = CG_PREDICATE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__OWNS = CG_PREDICATE__OWNS;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__CONDITION_EXPRESSION = CG_PREDICATE__CONDITION_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Mapping Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__MAPPING_EXP = CG_PREDICATE__MAPPING_EXP;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__THEN_EXPRESSION = CG_PREDICATE__THEN_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Predicate Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE__PREDICATE_VARIABLE = CG_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Variable Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_VARIABLE_PREDICATE_FEATURE_COUNT = CG_PREDICATE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment <em>CG Connection Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Connection Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment
	 * @generated
	 */
	EClass getCGConnectionAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getMappingExp()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_MappingExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getInitValue <em>Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getInitValue()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_InitValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable <em>Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getConnectionVariable()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_ConnectionVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable <em>CG Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Connection Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable
	 * @generated
	 */
	EClass getCGConnectionVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment <em>CG Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment
	 * @generated
	 */
	EClass getCGPropertyAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMappingExp()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_MappingExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getSlotValue <em>Slot Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getSlotValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_SlotValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getReferredProperty()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EAttribute getCGPropertyAssignment_ReferredProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getInitValue <em>Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getInitValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_InitValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty <em>Executor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Property</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getExecutorProperty()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_ExecutorProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping <em>CG Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping
	 * @generated
	 */
	EClass getCGMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getBody()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getFreeVariables <em>Free Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Free Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getFreeVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_FreeVariables();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getTransformation()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_Transformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation <em>CG Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation
	 * @generated
	 */
	EClass getCGTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getMappings()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getTypedModels <em>Typed Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Typed Models</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getTypedModels()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_TypedModels();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel <em>CG Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel
	 * @generated
	 */
	EClass getCGTypedModel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getTransformation()
	 * @see #getCGTypedModel()
	 * @generated
	 */
	EReference getCGTypedModel_Transformation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex <em>Model Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Index</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getModelIndex()
	 * @see #getCGTypedModel()
	 * @generated
	 */
	EAttribute getCGTypedModel_ModelIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate <em>CG Variable Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Variable Predicate</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate
	 * @generated
	 */
	EClass getCGVariablePredicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate#getPredicateVariable <em>Predicate Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate#getPredicateVariable()
	 * @see #getCGVariablePredicate()
	 * @generated
	 */
	EReference getCGVariablePredicate_PredicateVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall <em>CG Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Call</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall
	 * @generated
	 */
	EClass getCGMappingCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMappingCallBindings <em>Mapping Call Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Call Bindings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMappingCallBindings()
	 * @see #getCGMappingCall()
	 * @generated
	 */
	EReference getCGMappingCall_MappingCallBindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding <em>CG Mapping Call Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Call Binding</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding
	 * @generated
	 */
	EClass getCGMappingCallBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValue()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp <em>CG Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp
	 * @generated
	 */
	EClass getCGMappingExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getAssignments()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_Assignments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getMapping()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_Mapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getPredicates()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_Predicates();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getRealizedVariables()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_RealizedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getBody()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getVariableAssignments <em>Variable Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getVariableAssignments()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_VariableAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getConnectionAssignments <em>Connection Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getConnectionAssignments()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_ConnectionAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedAccumulators <em>Owned Accumulators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Accumulators</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedAccumulators()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_OwnedAccumulators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop <em>CG Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop
	 * @generated
	 */
	EClass getCGMappingLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment <em>CG Middle Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Middle Property Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment
	 * @generated
	 */
	EClass getCGMiddlePropertyAssignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp <em>CG Middle Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Middle Property Call Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp
	 * @generated
	 */
	EClass getCGMiddlePropertyCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate <em>CG Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Predicate</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate
	 * @generated
	 */
	EClass getCGPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getConditionExpression <em>Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition Expression</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getConditionExpression()
	 * @see #getCGPredicate()
	 * @generated
	 */
	EReference getCGPredicate_ConditionExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMappingExp <em>Mapping Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Exp</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMappingExp()
	 * @see #getCGPredicate()
	 * @generated
	 */
	EReference getCGPredicate_MappingExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getThenExpression()
	 * @see #getCGPredicate()
	 * @generated
	 */
	EReference getCGPredicate_ThenExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable <em>CG Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable
	 * @generated
	 */
	EClass getCGRealizedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getTypedModel()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_TypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSequence <em>CG Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Sequence</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSequence
	 * @generated
	 */
	EClass getCGSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getStatements()
	 * @see #getCGSequence()
	 * @generated
	 */
	EReference getCGSequence_Statements();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType <em>Executor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor Type</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getExecutorType()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_ExecutorType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTiCGModelFactory getQVTiCGModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl <em>CG Connection Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionAssignment()
		 * @generated
		 */
		EClass CG_CONNECTION_ASSIGNMENT = eINSTANCE.getCGConnectionAssignment();

		/**
		 * The meta object literal for the '<em><b>Mapping Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__MAPPING_EXP = eINSTANCE.getCGConnectionAssignment_MappingExp();

		/**
		 * The meta object literal for the '<em><b>Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__INIT_VALUE = eINSTANCE.getCGConnectionAssignment_InitValue();

		/**
		 * The meta object literal for the '<em><b>Connection Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE = eINSTANCE.getCGConnectionAssignment_ConnectionVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl <em>CG Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGConnectionVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGConnectionVariable()
		 * @generated
		 */
		EClass CG_CONNECTION_VARIABLE = eINSTANCE.getCGConnectionVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl <em>CG Ecore Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcorePropertyAssignment()
		 * @generated
		 */
		EClass CG_ECORE_PROPERTY_ASSIGNMENT = eINSTANCE.getCGEcorePropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE = eINSTANCE.getCGEcorePropertyAssignment_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl <em>CG Ecore Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreRealizedVariable()
		 * @generated
		 */
		EClass CG_ECORE_REALIZED_VARIABLE = eINSTANCE.getCGEcoreRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>EClassifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_REALIZED_VARIABLE__ECLASSIFIER = eINSTANCE.getCGEcoreRealizedVariable_EClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl <em>CG Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunction()
		 * @generated
		 */
		EClass CG_FUNCTION = eINSTANCE.getCGFunction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl <em>CG Function Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionCallExp()
		 * @generated
		 */
		EClass CG_FUNCTION_CALL_EXP = eINSTANCE.getCGFunctionCallExp();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_FUNCTION_CALL_EXP__FUNCTION = eINSTANCE.getCGFunctionCallExp_Function();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl <em>CG Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionParameter()
		 * @generated
		 */
		EClass CG_FUNCTION_PARAMETER = eINSTANCE.getCGFunctionParameter();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_FUNCTION_PARAMETER__FUNCTION = eINSTANCE.getCGFunctionParameter_Function();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl <em>CG Guard Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGGuardVariable()
		 * @generated
		 */
		EClass CG_GUARD_VARIABLE = eINSTANCE.getCGGuardVariable();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_GUARD_VARIABLE__MAPPING = eINSTANCE.getCGGuardVariable_Mapping();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_GUARD_VARIABLE__TYPED_MODEL = eINSTANCE.getCGGuardVariable_TypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl <em>CG Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPropertyAssignment()
		 * @generated
		 */
		EClass CG_PROPERTY_ASSIGNMENT = eINSTANCE.getCGPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Mapping Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__MAPPING_EXP = eINSTANCE.getCGPropertyAssignment_MappingExp();

		/**
		 * The meta object literal for the '<em><b>Slot Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__SLOT_VALUE = eINSTANCE.getCGPropertyAssignment_SlotValue();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = eINSTANCE.getCGPropertyAssignment_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__INIT_VALUE = eINSTANCE.getCGPropertyAssignment_InitValue();

		/**
		 * The meta object literal for the '<em><b>Executor Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = eINSTANCE.getCGPropertyAssignment_ExecutorProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
		 * @generated
		 */
		EClass CG_MAPPING = eINSTANCE.getCGMapping();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__BODY = eINSTANCE.getCGMapping_Body();

		/**
		 * The meta object literal for the '<em><b>Free Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__FREE_VARIABLES = eINSTANCE.getCGMapping_FreeVariables();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__TRANSFORMATION = eINSTANCE.getCGMapping_Transformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl <em>CG Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTransformation()
		 * @generated
		 */
		EClass CG_TRANSFORMATION = eINSTANCE.getCGTransformation();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__MAPPINGS = eINSTANCE.getCGTransformation_Mappings();

		/**
		 * The meta object literal for the '<em><b>Typed Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__TYPED_MODELS = eINSTANCE.getCGTransformation_TypedModels();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl <em>CG Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTypedModel()
		 * @generated
		 */
		EClass CG_TYPED_MODEL = eINSTANCE.getCGTypedModel();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TYPED_MODEL__TRANSFORMATION = eINSTANCE.getCGTypedModel_Transformation();

		/**
		 * The meta object literal for the '<em><b>Model Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TYPED_MODEL__MODEL_INDEX = eINSTANCE.getCGTypedModel_ModelIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGVariablePredicateImpl <em>CG Variable Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGVariablePredicateImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGVariablePredicate()
		 * @generated
		 */
		EClass CG_VARIABLE_PREDICATE = eINSTANCE.getCGVariablePredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_VARIABLE_PREDICATE__PREDICATE_VARIABLE = eINSTANCE.getCGVariablePredicate_PredicateVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl <em>CG Mapping Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCall()
		 * @generated
		 */
		EClass CG_MAPPING_CALL = eINSTANCE.getCGMappingCall();

		/**
		 * The meta object literal for the '<em><b>Mapping Call Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL__MAPPING_CALL_BINDINGS = eINSTANCE.getCGMappingCall_MappingCallBindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl <em>CG Mapping Call Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCallBinding()
		 * @generated
		 */
		EClass CG_MAPPING_CALL_BINDING = eINSTANCE.getCGMappingCallBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__VALUE = eINSTANCE.getCGMappingCallBinding_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl <em>CG Mapping Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingExp()
		 * @generated
		 */
		EClass CG_MAPPING_EXP = eINSTANCE.getCGMappingExp();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__ASSIGNMENTS = eINSTANCE.getCGMappingExp_Assignments();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__MAPPING = eINSTANCE.getCGMappingExp_Mapping();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__PREDICATES = eINSTANCE.getCGMappingExp_Predicates();

		/**
		 * The meta object literal for the '<em><b>Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__REALIZED_VARIABLES = eINSTANCE.getCGMappingExp_RealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__BODY = eINSTANCE.getCGMappingExp_Body();

		/**
		 * The meta object literal for the '<em><b>Variable Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS = eINSTANCE.getCGMappingExp_VariableAssignments();

		/**
		 * The meta object literal for the '<em><b>Connection Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS = eINSTANCE.getCGMappingExp_ConnectionAssignments();

		/**
		 * The meta object literal for the '<em><b>Owned Accumulators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__OWNED_ACCUMULATORS = eINSTANCE.getCGMappingExp_OwnedAccumulators();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl <em>CG Mapping Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingLoop()
		 * @generated
		 */
		EClass CG_MAPPING_LOOP = eINSTANCE.getCGMappingLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl <em>CG Middle Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyAssignment()
		 * @generated
		 */
		EClass CG_MIDDLE_PROPERTY_ASSIGNMENT = eINSTANCE.getCGMiddlePropertyAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl <em>CG Middle Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMiddlePropertyCallExpImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMiddlePropertyCallExp()
		 * @generated
		 */
		EClass CG_MIDDLE_PROPERTY_CALL_EXP = eINSTANCE.getCGMiddlePropertyCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl <em>CG Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPredicate()
		 * @generated
		 */
		EClass CG_PREDICATE = eINSTANCE.getCGPredicate();

		/**
		 * The meta object literal for the '<em><b>Condition Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PREDICATE__CONDITION_EXPRESSION = eINSTANCE.getCGPredicate_ConditionExpression();

		/**
		 * The meta object literal for the '<em><b>Mapping Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PREDICATE__MAPPING_EXP = eINSTANCE.getCGPredicate_MappingExp();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PREDICATE__THEN_EXPRESSION = eINSTANCE.getCGPredicate_ThenExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl <em>CG Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGRealizedVariable()
		 * @generated
		 */
		EClass CG_REALIZED_VARIABLE = eINSTANCE.getCGRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__TYPED_MODEL = eINSTANCE.getCGRealizedVariable_TypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl <em>CG Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGSequenceImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGSequence()
		 * @generated
		 */
		EClass CG_SEQUENCE = eINSTANCE.getCGSequence();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SEQUENCE__STATEMENTS = eINSTANCE.getCGSequence_Statements();

		/**
		 * The meta object literal for the '<em><b>Executor Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__EXECUTOR_TYPE = eINSTANCE.getCGRealizedVariable_ExecutorType();

	}

} //QVTiCGmodelPackage
