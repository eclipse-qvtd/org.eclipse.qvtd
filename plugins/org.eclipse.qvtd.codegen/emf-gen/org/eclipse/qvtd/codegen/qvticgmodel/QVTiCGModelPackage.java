/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
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
	 * The feature id for the '<em><b>Connection Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

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
	int CG_ECORE_PROPERTY_ASSIGNMENT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
	 * @generated
	 */
	int CG_MAPPING = 9;

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable#getOwningMapping()
	 * @see #getCGGuardVariable()
	 * @generated
	 */
	EReference getCGGuardVariable_OwningMapping();

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
	int CG_MAPPING_CALL = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl <em>CG Mapping Call Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCallBinding()
	 * @generated
	 */
	int CG_MAPPING_CALL_BINDING = 11;

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
	int CG_ECORE_REALIZED_VARIABLE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl <em>CG Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunction()
	 * @generated
	 */
	int CG_FUNCTION = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl <em>CG Function Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionCallExp()
	 * @generated
	 */
	int CG_FUNCTION_CALL_EXP = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl <em>CG Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionParameter()
	 * @generated
	 */
	int CG_FUNCTION_PARAMETER = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl <em>CG Guard Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGGuardVariable()
	 * @generated
	 */
	int CG_GUARD_VARIABLE = 8;

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
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__OWNING_MAPPING = CGModelPackage.CG_PARAMETER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_CONNECTION_VARIABLE__OWNING_MAPPING = CG_GUARD_VARIABLE__OWNING_MAPPING;

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
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>CG Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl <em>CG Ecore Container Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreContainerAssignment()
	 * @generated
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__AST = CG_PROPERTY_ASSIGNMENT__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__NAME = CG_PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__TYPE_ID = CG_PROPERTY_ASSIGNMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__REQUIRED = CG_PROPERTY_ASSIGNMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__DEPENDS_ON = CG_PROPERTY_ASSIGNMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__OWNS = CG_PROPERTY_ASSIGNMENT__OWNS;

	/**
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__EXECUTOR_PROPERTY = CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__OWNED_INIT_VALUE = CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE;

	/**
	 * The feature id for the '<em><b>Owned Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__OWNED_SLOT_VALUE = CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__OWNING_MAPPING = CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__REFERRED_PROPERTY = CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT__ESTRUCTURAL_FEATURE = CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CG Ecore Container Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_CONTAINER_ASSIGNMENT_FEATURE_COUNT = CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE = CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE;

	/**
	 * The feature id for the '<em><b>Owned Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE = CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__OWNING_MAPPING = CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY;

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
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__OWNING_MAPPING = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__TYPED_MODEL = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CG Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE_FEATURE_COUNT = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__OWNING_MAPPING = CG_REALIZED_VARIABLE__OWNING_MAPPING;

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
	 * The feature id for the '<em><b>Owned Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNED_ASSIGNMENTS = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNED_BODY = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Connection Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNED_GUARD_VARIABLES = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Realized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNED_REALIZED_VARIABLES = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owning Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__OWNING_TRANSFORMATION = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Use Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__USE_CLASS = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>CG Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_FEATURE_COUNT = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 7;

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
	 * The feature id for the '<em><b>Owned Mapping Call Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__OWNED_MAPPING_CALL_BINDINGS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Owned Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__OWNED_VALUE = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__OWNING_MAPPING_CALL = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Mapping Call Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl <em>CG Mapping Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingExp()
	 * @generated
	 */
	int CG_MAPPING_EXP = 12;

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
	 * The feature id for the '<em><b>Owned Accumulators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__OWNED_ACCUMULATORS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP__OWNED_BODY = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Mapping Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_EXP_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl <em>CG Mapping Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingLoopImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingLoop()
	 * @generated
	 */
	int CG_MAPPING_LOOP = 13;

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
	int CG_MIDDLE_PROPERTY_ASSIGNMENT = 14;

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
	 * The feature id for the '<em><b>Executor Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = CG_ECORE_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY;

	/**
	 * The feature id for the '<em><b>Owned Init Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE = CG_ECORE_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE;

	/**
	 * The feature id for the '<em><b>Owned Slot Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE = CG_ECORE_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE;

	/**
	 * The feature id for the '<em><b>Owning Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__OWNING_MAPPING = CG_ECORE_PROPERTY_ASSIGNMENT__OWNING_MAPPING;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MIDDLE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = CG_ECORE_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY;

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
	int CG_MIDDLE_PROPERTY_CALL_EXP = 15;

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
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_SEQUENCE__OWNED_STATEMENTS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__CLASSES = CGModelPackage.CG_CLASS__CLASSES;

	/**
	 * The feature id for the '<em><b>Containing Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__CONTAINING_CLASS = CGModelPackage.CG_CLASS__CONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Owned Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__OWNED_MAPPINGS = CGModelPackage.CG_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Typed Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__OWNED_TYPED_MODELS = CGModelPackage.CG_CLASS_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Model Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__MODEL_INDEX = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__OWNING_TRANSFORMATION = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL_FEATURE_COUNT = CGModelPackage.CG_NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwningMapping()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_OwningMapping();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue <em>Owned Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment#getOwnedInitValue()
	 * @see #getCGConnectionAssignment()
	 * @generated
	 */
	EReference getCGConnectionAssignment_OwnedInitValue();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment <em>CG Ecore Container Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Ecore Container Assignment</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment
	 * @generated
	 */
	EClass getCGEcoreContainerAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment#getEStructuralFeature()
	 * @see #getCGEcoreContainerAssignment()
	 * @generated
	 */
	EReference getCGEcoreContainerAssignment_EStructuralFeature();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwningMapping()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwningMapping();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedInitValue <em>Owned Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedInitValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwnedInitValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedSlotValue <em>Owned Slot Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Slot Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getOwnedSlotValue()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_OwnedSlotValue();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedAssignments <em>Owned Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedAssignments()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedAssignments();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedBody()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedBody();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments <em>Owned Connection Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connection Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedConnectionAssignments()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedConnectionAssignments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedGuardVariables <em>Owned Guard Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Guard Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedGuardVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedGuardVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedRealizedVariables <em>Owned Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Realized Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwnedRealizedVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwnedRealizedVariables();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getOwningTransformation()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_OwningTransformation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass <em>Use Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Class</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#isUseClass()
	 * @see #getCGMapping()
	 * @generated
	 */
	EAttribute getCGMapping_UseClass();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings <em>Owned Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mappings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedMappings()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_OwnedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedTypedModels <em>Owned Typed Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Typed Models</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation#getOwnedTypedModels()
	 * @see #getCGTransformation()
	 * @generated
	 */
	EReference getCGTransformation_OwnedTypedModels();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation <em>Owning Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Transformation</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel#getOwningTransformation()
	 * @see #getCGTypedModel()
	 * @generated
	 */
	EReference getCGTypedModel_OwningTransformation();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings <em>Owned Mapping Call Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Call Bindings</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getOwnedMappingCallBindings()
	 * @see #getCGMappingCall()
	 * @generated
	 */
	EReference getCGMappingCall_OwnedMappingCallBindings();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue <em>Owned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Value</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwnedValue()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_OwnedValue();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall <em>Owning Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Call</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getOwningMappingCall()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_OwningMappingCall();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp#getOwnedBody()
	 * @see #getCGMappingExp()
	 * @generated
	 */
	EReference getCGMappingExp_OwnedBody();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGSequence#getOwnedStatements()
	 * @see #getCGSequence()
	 * @generated
	 */
	EReference getCGSequence_OwnedStatements();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping <em>Owning Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getOwningMapping()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_OwningMapping();

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
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__OWNING_MAPPING = eINSTANCE.getCGConnectionAssignment_OwningMapping();

		/**
		 * The meta object literal for the '<em><b>Connection Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE = eINSTANCE.getCGConnectionAssignment_ConnectionVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_CONNECTION_ASSIGNMENT__OWNED_INIT_VALUE = eINSTANCE.getCGConnectionAssignment_OwnedInitValue();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl <em>CG Ecore Container Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreContainerAssignmentImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreContainerAssignment()
		 * @generated
		 */
		EClass CG_ECORE_CONTAINER_ASSIGNMENT = eINSTANCE.getCGEcoreContainerAssignment();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_ECORE_CONTAINER_ASSIGNMENT__ESTRUCTURAL_FEATURE = eINSTANCE.getCGEcoreContainerAssignment_EStructuralFeature();

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
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_GUARD_VARIABLE__OWNING_MAPPING = eINSTANCE.getCGGuardVariable_OwningMapping();

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
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING = eINSTANCE.getCGPropertyAssignment_OwningMapping();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY = eINSTANCE.getCGPropertyAssignment_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Executor Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY = eINSTANCE.getCGPropertyAssignment_ExecutorProperty();

		/**
		 * The meta object literal for the '<em><b>Owned Init Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE = eINSTANCE.getCGPropertyAssignment_OwnedInitValue();

		/**
		 * The meta object literal for the '<em><b>Owned Slot Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE = eINSTANCE.getCGPropertyAssignment_OwnedSlotValue();

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
		 * The meta object literal for the '<em><b>Owned Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_ASSIGNMENTS = eINSTANCE.getCGMapping_OwnedAssignments();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_BODY = eINSTANCE.getCGMapping_OwnedBody();

		/**
		 * The meta object literal for the '<em><b>Owned Connection Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_CONNECTION_ASSIGNMENTS = eINSTANCE.getCGMapping_OwnedConnectionAssignments();

		/**
		 * The meta object literal for the '<em><b>Owned Guard Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_GUARD_VARIABLES = eINSTANCE.getCGMapping_OwnedGuardVariables();

		/**
		 * The meta object literal for the '<em><b>Owned Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNED_REALIZED_VARIABLES = eINSTANCE.getCGMapping_OwnedRealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__OWNING_TRANSFORMATION = eINSTANCE.getCGMapping_OwningTransformation();

		/**
		 * The meta object literal for the '<em><b>Use Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_MAPPING__USE_CLASS = eINSTANCE.getCGMapping_UseClass();

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
		 * The meta object literal for the '<em><b>Owned Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__OWNED_MAPPINGS = eINSTANCE.getCGTransformation_OwnedMappings();

		/**
		 * The meta object literal for the '<em><b>Owned Typed Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TRANSFORMATION__OWNED_TYPED_MODELS = eINSTANCE.getCGTransformation_OwnedTypedModels();

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
		 * The meta object literal for the '<em><b>Model Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_TYPED_MODEL__MODEL_INDEX = eINSTANCE.getCGTypedModel_ModelIndex();

		/**
		 * The meta object literal for the '<em><b>Owning Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_TYPED_MODEL__OWNING_TRANSFORMATION = eINSTANCE.getCGTypedModel_OwningTransformation();

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
		 * The meta object literal for the '<em><b>Owned Mapping Call Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL__OWNED_MAPPING_CALL_BINDINGS = eINSTANCE.getCGMappingCall_OwnedMappingCallBindings();

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
		 * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__OWNED_VALUE = eINSTANCE.getCGMappingCallBinding_OwnedValue();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__OWNING_MAPPING_CALL = eINSTANCE.getCGMappingCallBinding_OwningMappingCall();

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
		 * The meta object literal for the '<em><b>Owned Accumulators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__OWNED_ACCUMULATORS = eINSTANCE.getCGMappingExp_OwnedAccumulators();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_EXP__OWNED_BODY = eINSTANCE.getCGMappingExp_OwnedBody();

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
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_SEQUENCE__OWNED_STATEMENTS = eINSTANCE.getCGSequence_OwnedStatements();

		/**
		 * The meta object literal for the '<em><b>Executor Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__EXECUTOR_TYPE = eINSTANCE.getCGRealizedVariable_ExecutorType();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__OWNING_MAPPING = eINSTANCE.getCGRealizedVariable_OwningMapping();

	}

} //QVTiCGmodelPackage
