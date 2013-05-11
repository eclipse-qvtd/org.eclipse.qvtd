/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
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
	@NonNull String eNS_URI = "http://www.eclipse.org/qvti/1.0.0/CG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvticg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@NonNull QVTiCGModelPackage eINSTANCE = org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl <em>CG Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPropertyAssignment()
	 * @generated
	 */
	int CG_PROPERTY_ASSIGNMENT = 10;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__PARENT = CGModelPackage.CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__PIVOT = CGModelPackage.CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__PIVOT_TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__BOXED = CGModelPackage.CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__CAUGHT = CGModelPackage.CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__CONSTANT = CGModelPackage.CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__FALSE = CGModelPackage.CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__GLOBAL = CGModelPackage.CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__INLINEABLE = CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__INVALID = CGModelPackage.CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__NULL = CGModelPackage.CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__NON_NULL = CGModelPackage.CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__SETTABLE = CGModelPackage.CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__TRUE = CGModelPackage.CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__UNBOXED = CGModelPackage.CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__VALUE = CGModelPackage.CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__VALUE_NAME = CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT__MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>CG Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT___SET_NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT___SET_NON_NULL = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PROPERTY_ASSIGNMENT_OPERATION_COUNT = CGModelPackage.CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl <em>CG Ecore Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcorePropertyAssignmentImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcorePropertyAssignment()
	 * @generated
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__PARENT = CG_PROPERTY_ASSIGNMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__NAME = CG_PROPERTY_ASSIGNMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__PIVOT = CG_PROPERTY_ASSIGNMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__PIVOT_TYPE_ID = CG_PROPERTY_ASSIGNMENT__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__BOXED = CG_PROPERTY_ASSIGNMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__CAUGHT = CG_PROPERTY_ASSIGNMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__CONSTANT = CG_PROPERTY_ASSIGNMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__DEPENDS_ON = CG_PROPERTY_ASSIGNMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__FALSE = CG_PROPERTY_ASSIGNMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__GLOBAL = CG_PROPERTY_ASSIGNMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__INLINEABLE = CG_PROPERTY_ASSIGNMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__INVALID = CG_PROPERTY_ASSIGNMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__NULL = CG_PROPERTY_ASSIGNMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__NON_INVALID = CG_PROPERTY_ASSIGNMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__NON_NULL = CG_PROPERTY_ASSIGNMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__REFERRED_VALUED_ELEMENT = CG_PROPERTY_ASSIGNMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__SETTABLE = CG_PROPERTY_ASSIGNMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__TRUE = CG_PROPERTY_ASSIGNMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__UNBOXED = CG_PROPERTY_ASSIGNMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__VALUE = CG_PROPERTY_ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__VALUE_NAME = CG_PROPERTY_ASSIGNMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT__MAPPING = CG_PROPERTY_ASSIGNMENT__MAPPING;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT___SET_NON_INVALID = CG_PROPERTY_ASSIGNMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT___SET_NON_NULL = CG_PROPERTY_ASSIGNMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_PROPERTY_ASSIGNMENT_OPERATION_COUNT = CG_PROPERTY_ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
	 * @generated
	 */
	int CG_MAPPING = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl <em>CG Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTransformationImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTransformation()
	 * @generated
	 */
	int CG_TRANSFORMATION = 12;

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
	int CG_MAPPING_CALL = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl <em>CG Mapping Call Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallBindingImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCallBinding()
	 * @generated
	 */
	int CG_MAPPING_CALL_BINDING = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl <em>CG Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPredicateImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGPredicate()
	 * @generated
	 */
	int CG_PREDICATE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl <em>CG Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGRealizedVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGRealizedVariable()
	 * @generated
	 */
	int CG_REALIZED_VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__PARENT = CGModelPackage.CG_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__NAME = CGModelPackage.CG_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__PIVOT = CGModelPackage.CG_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__PIVOT_TYPE_ID = CGModelPackage.CG_VARIABLE__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__BOXED = CGModelPackage.CG_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__CAUGHT = CGModelPackage.CG_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__CONSTANT = CGModelPackage.CG_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__DEPENDS_ON = CGModelPackage.CG_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__FALSE = CGModelPackage.CG_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__GLOBAL = CGModelPackage.CG_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__INLINEABLE = CGModelPackage.CG_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__INVALID = CGModelPackage.CG_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__NULL = CGModelPackage.CG_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__NON_INVALID = CGModelPackage.CG_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__NON_NULL = CGModelPackage.CG_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__SETTABLE = CGModelPackage.CG_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__TRUE = CGModelPackage.CG_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__UNBOXED = CGModelPackage.CG_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__VALUE = CGModelPackage.CG_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__VALUE_NAME = CGModelPackage.CG_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__INIT = CGModelPackage.CG_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE__MAPPING = CGModelPackage.CG_VARIABLE_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE___SET_NON_INVALID = CGModelPackage.CG_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE___SET_NON_NULL = CGModelPackage.CG_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_REALIZED_VARIABLE_OPERATION_COUNT = CGModelPackage.CG_VARIABLE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl <em>CG Ecore Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGEcoreRealizedVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGEcoreRealizedVariable()
	 * @generated
	 */
	int CG_ECORE_REALIZED_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__PARENT = CG_REALIZED_VARIABLE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__NAME = CG_REALIZED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__PIVOT = CG_REALIZED_VARIABLE__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__PIVOT_TYPE_ID = CG_REALIZED_VARIABLE__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__BOXED = CG_REALIZED_VARIABLE__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__CAUGHT = CG_REALIZED_VARIABLE__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__CONSTANT = CG_REALIZED_VARIABLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__DEPENDS_ON = CG_REALIZED_VARIABLE__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__FALSE = CG_REALIZED_VARIABLE__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__GLOBAL = CG_REALIZED_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__INLINEABLE = CG_REALIZED_VARIABLE__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__INVALID = CG_REALIZED_VARIABLE__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__NULL = CG_REALIZED_VARIABLE__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__NON_INVALID = CG_REALIZED_VARIABLE__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__NON_NULL = CG_REALIZED_VARIABLE__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__REFERRED_VALUED_ELEMENT = CG_REALIZED_VARIABLE__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__SETTABLE = CG_REALIZED_VARIABLE__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__TRUE = CG_REALIZED_VARIABLE__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__UNBOXED = CG_REALIZED_VARIABLE__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__VALUE = CG_REALIZED_VARIABLE__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__VALUE_NAME = CG_REALIZED_VARIABLE__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__INIT = CG_REALIZED_VARIABLE__INIT;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE__MAPPING = CG_REALIZED_VARIABLE__MAPPING;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE___SET_NON_INVALID = CG_REALIZED_VARIABLE___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE___SET_NON_NULL = CG_REALIZED_VARIABLE___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Ecore Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_ECORE_REALIZED_VARIABLE_OPERATION_COUNT = CG_REALIZED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl <em>CG Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunction()
	 * @generated
	 */
	int CG_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__PARENT = CGModelPackage.CG_OPERATION__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__NAME = CGModelPackage.CG_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__PIVOT = CGModelPackage.CG_OPERATION__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION__PIVOT_TYPE_ID = CGModelPackage.CG_OPERATION__PIVOT_TYPE_ID;

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
	 * The number of operations of the '<em>CG Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_OPERATION_COUNT = CGModelPackage.CG_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl <em>CG Function Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionCallExpImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionCallExp()
	 * @generated
	 */
	int CG_FUNCTION_CALL_EXP = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__PARENT = CGModelPackage.CG_OPERATION_CALL_EXP__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__NAME = CGModelPackage.CG_OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__PIVOT = CGModelPackage.CG_OPERATION_CALL_EXP__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__PIVOT_TYPE_ID = CGModelPackage.CG_OPERATION_CALL_EXP__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__BOXED = CGModelPackage.CG_OPERATION_CALL_EXP__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__CAUGHT = CGModelPackage.CG_OPERATION_CALL_EXP__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__CONSTANT = CGModelPackage.CG_OPERATION_CALL_EXP__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__DEPENDS_ON = CGModelPackage.CG_OPERATION_CALL_EXP__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__FALSE = CGModelPackage.CG_OPERATION_CALL_EXP__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__GLOBAL = CGModelPackage.CG_OPERATION_CALL_EXP__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__INLINEABLE = CGModelPackage.CG_OPERATION_CALL_EXP__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__INVALID = CGModelPackage.CG_OPERATION_CALL_EXP__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__NULL = CGModelPackage.CG_OPERATION_CALL_EXP__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__NON_INVALID = CGModelPackage.CG_OPERATION_CALL_EXP__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__NON_NULL = CGModelPackage.CG_OPERATION_CALL_EXP__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_OPERATION_CALL_EXP__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__SETTABLE = CGModelPackage.CG_OPERATION_CALL_EXP__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__TRUE = CGModelPackage.CG_OPERATION_CALL_EXP__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__UNBOXED = CGModelPackage.CG_OPERATION_CALL_EXP__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__VALUE = CGModelPackage.CG_OPERATION_CALL_EXP__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__VALUE_NAME = CGModelPackage.CG_OPERATION_CALL_EXP__VALUE_NAME;

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
	 * The feature id for the '<em><b>Referred Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__REFERRED_OPERATION = CGModelPackage.CG_OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP__ARGUMENTS = CGModelPackage.CG_OPERATION_CALL_EXP__ARGUMENTS;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP___SET_NON_INVALID = CGModelPackage.CG_OPERATION_CALL_EXP___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP___SET_NON_NULL = CGModelPackage.CG_OPERATION_CALL_EXP___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Function Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_CALL_EXP_OPERATION_COUNT = CGModelPackage.CG_OPERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl <em>CG Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGFunctionParameterImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGFunctionParameter()
	 * @generated
	 */
	int CG_FUNCTION_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__PARENT = CGModelPackage.CG_PARAMETER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__NAME = CGModelPackage.CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__PIVOT = CGModelPackage.CG_PARAMETER__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__PIVOT_TYPE_ID = CGModelPackage.CG_PARAMETER__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__BOXED = CGModelPackage.CG_PARAMETER__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__CAUGHT = CGModelPackage.CG_PARAMETER__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__CONSTANT = CGModelPackage.CG_PARAMETER__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__DEPENDS_ON = CGModelPackage.CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__FALSE = CGModelPackage.CG_PARAMETER__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__GLOBAL = CGModelPackage.CG_PARAMETER__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__INLINEABLE = CGModelPackage.CG_PARAMETER__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__INVALID = CGModelPackage.CG_PARAMETER__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__NULL = CGModelPackage.CG_PARAMETER__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__NON_INVALID = CGModelPackage.CG_PARAMETER__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__NON_NULL = CGModelPackage.CG_PARAMETER__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_PARAMETER__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__SETTABLE = CGModelPackage.CG_PARAMETER__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__TRUE = CGModelPackage.CG_PARAMETER__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__UNBOXED = CGModelPackage.CG_PARAMETER__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__VALUE = CGModelPackage.CG_PARAMETER__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__VALUE_NAME = CGModelPackage.CG_PARAMETER__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__INIT = CGModelPackage.CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER__OPERATION = CGModelPackage.CG_PARAMETER__OPERATION;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER___SET_NON_INVALID = CGModelPackage.CG_PARAMETER___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER___SET_NON_NULL = CGModelPackage.CG_PARAMETER___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_FUNCTION_PARAMETER_OPERATION_COUNT = CGModelPackage.CG_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl <em>CG Guard Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGGuardVariable()
	 * @generated
	 */
	int CG_GUARD_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__PARENT = CGModelPackage.CG_PARAMETER__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__NAME = CGModelPackage.CG_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__PIVOT = CGModelPackage.CG_PARAMETER__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__PIVOT_TYPE_ID = CGModelPackage.CG_PARAMETER__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__BOXED = CGModelPackage.CG_PARAMETER__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__CAUGHT = CGModelPackage.CG_PARAMETER__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__CONSTANT = CGModelPackage.CG_PARAMETER__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__DEPENDS_ON = CGModelPackage.CG_PARAMETER__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__FALSE = CGModelPackage.CG_PARAMETER__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__GLOBAL = CGModelPackage.CG_PARAMETER__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__INLINEABLE = CGModelPackage.CG_PARAMETER__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__INVALID = CGModelPackage.CG_PARAMETER__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__NULL = CGModelPackage.CG_PARAMETER__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__NON_INVALID = CGModelPackage.CG_PARAMETER__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__NON_NULL = CGModelPackage.CG_PARAMETER__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_PARAMETER__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__SETTABLE = CGModelPackage.CG_PARAMETER__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__TRUE = CGModelPackage.CG_PARAMETER__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__UNBOXED = CGModelPackage.CG_PARAMETER__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__VALUE = CGModelPackage.CG_PARAMETER__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__VALUE_NAME = CGModelPackage.CG_PARAMETER__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__INIT = CGModelPackage.CG_PARAMETER__INIT;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE__OPERATION = CGModelPackage.CG_PARAMETER__OPERATION;

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
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE___SET_NON_INVALID = CGModelPackage.CG_PARAMETER___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE___SET_NON_NULL = CGModelPackage.CG_PARAMETER___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_GUARD_VARIABLE_OPERATION_COUNT = CGModelPackage.CG_PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__PARENT = CGModelPackage.CG_TYPED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__NAME = CGModelPackage.CG_TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__PIVOT = CGModelPackage.CG_TYPED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__PIVOT_TYPE_ID = CGModelPackage.CG_TYPED_ELEMENT__PIVOT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__TYPE_ID = CGModelPackage.CG_TYPED_ELEMENT__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__REQUIRED = CGModelPackage.CG_TYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__TRANSFORMATION = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__GUARD_VARIABLES = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__PREDICATES = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__REALIZED_VARIABLES = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__ASSIGNMENTS = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mapping Calls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING__MAPPING_CALLS = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>CG Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_FEATURE_COUNT = CGModelPackage.CG_TYPED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>CG Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_OPERATION_COUNT = CGModelPackage.CG_TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__PARENT = CGModelPackage.CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__PIVOT = CGModelPackage.CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__PIVOT_TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__BOXED = CGModelPackage.CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__CAUGHT = CGModelPackage.CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__CONSTANT = CGModelPackage.CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__FALSE = CGModelPackage.CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__GLOBAL = CGModelPackage.CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__INLINEABLE = CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__INVALID = CGModelPackage.CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__NULL = CGModelPackage.CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__NON_NULL = CGModelPackage.CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__SETTABLE = CGModelPackage.CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__TRUE = CGModelPackage.CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__UNBOXED = CGModelPackage.CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__VALUE = CGModelPackage.CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__VALUE_NAME = CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Call Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL__MAPPING_CALL_BINDINGS = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL___SET_NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL___SET_NON_NULL = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_OPERATION_COUNT = CGModelPackage.CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__PARENT = CGModelPackage.CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__PIVOT = CGModelPackage.CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__PIVOT_TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__BOXED = CGModelPackage.CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__CAUGHT = CGModelPackage.CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__CONSTANT = CGModelPackage.CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__FALSE = CGModelPackage.CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__GLOBAL = CGModelPackage.CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__INLINEABLE = CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__INVALID = CGModelPackage.CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__NULL = CGModelPackage.CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__NON_NULL = CGModelPackage.CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__SETTABLE = CGModelPackage.CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__TRUE = CGModelPackage.CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__UNBOXED = CGModelPackage.CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__VALUE = CGModelPackage.CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__VALUE_NAME = CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Value Or Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING__LOOP = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Mapping Call Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING___SET_NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING___SET_NON_NULL = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Mapping Call Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_MAPPING_CALL_BINDING_OPERATION_COUNT = CGModelPackage.CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__PARENT = CGModelPackage.CG_VALUED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__NAME = CGModelPackage.CG_VALUED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__PIVOT = CGModelPackage.CG_VALUED_ELEMENT__PIVOT;

	/**
	 * The feature id for the '<em><b>Pivot Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__PIVOT_TYPE_ID = CGModelPackage.CG_VALUED_ELEMENT__PIVOT_TYPE_ID;

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
	 * The feature id for the '<em><b>Boxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__BOXED = CGModelPackage.CG_VALUED_ELEMENT__BOXED;

	/**
	 * The feature id for the '<em><b>Caught</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__CAUGHT = CGModelPackage.CG_VALUED_ELEMENT__CAUGHT;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__CONSTANT = CGModelPackage.CG_VALUED_ELEMENT__CONSTANT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__DEPENDS_ON = CGModelPackage.CG_VALUED_ELEMENT__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>False</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__FALSE = CGModelPackage.CG_VALUED_ELEMENT__FALSE;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__GLOBAL = CGModelPackage.CG_VALUED_ELEMENT__GLOBAL;

	/**
	 * The feature id for the '<em><b>Inlineable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__INLINEABLE = CGModelPackage.CG_VALUED_ELEMENT__INLINEABLE;

	/**
	 * The feature id for the '<em><b>Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__INVALID = CGModelPackage.CG_VALUED_ELEMENT__INVALID;

	/**
	 * The feature id for the '<em><b>Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__NULL = CGModelPackage.CG_VALUED_ELEMENT__NULL;

	/**
	 * The feature id for the '<em><b>Non Invalid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT__NON_INVALID;

	/**
	 * The feature id for the '<em><b>Non Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__NON_NULL = CGModelPackage.CG_VALUED_ELEMENT__NON_NULL;

	/**
	 * The feature id for the '<em><b>Referred Valued Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__REFERRED_VALUED_ELEMENT = CGModelPackage.CG_VALUED_ELEMENT__REFERRED_VALUED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Settable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__SETTABLE = CGModelPackage.CG_VALUED_ELEMENT__SETTABLE;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__TRUE = CGModelPackage.CG_VALUED_ELEMENT__TRUE;

	/**
	 * The feature id for the '<em><b>Unboxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__UNBOXED = CGModelPackage.CG_VALUED_ELEMENT__UNBOXED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__VALUE = CGModelPackage.CG_VALUED_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__VALUE_NAME = CGModelPackage.CG_VALUED_ELEMENT__VALUE_NAME;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__MAPPING = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE__CONDITION_EXPRESSION = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CG Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE_FEATURE_COUNT = CGModelPackage.CG_VALUED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Set Non Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE___SET_NON_INVALID = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_INVALID;

	/**
	 * The operation id for the '<em>Set Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE___SET_NON_NULL = CGModelPackage.CG_VALUED_ELEMENT___SET_NON_NULL;

	/**
	 * The number of operations of the '<em>CG Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_PREDICATE_OPERATION_COUNT = CGModelPackage.CG_VALUED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__PARENT = CGModelPackage.CG_CLASS__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__NAME = CGModelPackage.CG_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION__PIVOT = CGModelPackage.CG_CLASS__PIVOT;

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
	 * The number of operations of the '<em>CG Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TRANSFORMATION_OPERATION_COUNT = CGModelPackage.CG_CLASS_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl <em>CG Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGTypedModelImpl
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGTypedModel()
	 * @generated
	 */
	int CG_TYPED_MODEL = 13;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__PARENT = CGModelPackage.CG_NAMED_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__NAME = CGModelPackage.CG_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL__PIVOT = CGModelPackage.CG_NAMED_ELEMENT__PIVOT;

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
	 * The number of operations of the '<em>CG Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CG_TYPED_MODEL_OPERATION_COUNT = CGModelPackage.CG_NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment#getMapping()
	 * @see #getCGPropertyAssignment()
	 * @generated
	 */
	EReference getCGPropertyAssignment_Mapping();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping <em>CG Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping
	 * @generated
	 */
	EClass getCGMapping();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getGuardVariables <em>Guard Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Guard Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getGuardVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_GuardVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getPredicates()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_Predicates();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getMappingCalls <em>Mapping Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Calls</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getMappingCalls()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_MappingCalls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getRealizedVariables()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_RealizedVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping#getAssignments()
	 * @see #getCGMapping()
	 * @generated
	 */
	EReference getCGMapping_Assignments();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall <em>CG Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Mapping Call</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall
	 * @generated
	 */
	EClass getCGMappingCall();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall#getMapping()
	 * @see #getCGMappingCall()
	 * @generated
	 */
	EReference getCGMappingCall_Mapping();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValueOrValues <em>Value Or Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Or Values</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#getValueOrValues()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EReference getCGMappingCallBinding_ValueOrValues();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#isLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding#isLoop()
	 * @see #getCGMappingCallBinding()
	 * @generated
	 */
	EAttribute getCGMappingCallBinding_Loop();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate#getMapping()
	 * @see #getCGPredicate()
	 * @generated
	 */
	EReference getCGPredicate_Mapping();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable <em>CG Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CG Realized Variable</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable
	 * @generated
	 */
	EClass getCGRealizedVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable#getMapping()
	 * @see #getCGRealizedVariable()
	 * @generated
	 */
	EReference getCGRealizedVariable_Mapping();

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
		 * The meta object literal for the '<em><b>Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PROPERTY_ASSIGNMENT__MAPPING = eINSTANCE.getCGPropertyAssignment_Mapping();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl <em>CG Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMapping()
		 * @generated
		 */
		EClass CG_MAPPING = eINSTANCE.getCGMapping();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__TRANSFORMATION = eINSTANCE.getCGMapping_Transformation();

		/**
		 * The meta object literal for the '<em><b>Guard Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__GUARD_VARIABLES = eINSTANCE.getCGMapping_GuardVariables();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__PREDICATES = eINSTANCE.getCGMapping_Predicates();

		/**
		 * The meta object literal for the '<em><b>Mapping Calls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__MAPPING_CALLS = eINSTANCE.getCGMapping_MappingCalls();

		/**
		 * The meta object literal for the '<em><b>Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__REALIZED_VARIABLES = eINSTANCE.getCGMapping_RealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING__ASSIGNMENTS = eINSTANCE.getCGMapping_Assignments();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl <em>CG Mapping Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.CGMappingCallImpl
		 * @see org.eclipse.qvtd.codegen.qvticgmodel.impl.QVTiCGModelPackageImpl#getCGMappingCall()
		 * @generated
		 */
		EClass CG_MAPPING_CALL = eINSTANCE.getCGMappingCall();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL__MAPPING = eINSTANCE.getCGMappingCall_Mapping();

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
		 * The meta object literal for the '<em><b>Value Or Values</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_MAPPING_CALL_BINDING__VALUE_OR_VALUES = eINSTANCE.getCGMappingCallBinding_ValueOrValues();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CG_MAPPING_CALL_BINDING__LOOP = eINSTANCE.getCGMappingCallBinding_Loop();

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
		 * The meta object literal for the '<em><b>Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PREDICATE__MAPPING = eINSTANCE.getCGPredicate_Mapping();

		/**
		 * The meta object literal for the '<em><b>Condition Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_PREDICATE__CONDITION_EXPRESSION = eINSTANCE.getCGPredicate_ConditionExpression();

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
		 * The meta object literal for the '<em><b>Mapping</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__MAPPING = eINSTANCE.getCGRealizedVariable_Mapping();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CG_REALIZED_VARIABLE__TYPED_MODEL = eINSTANCE.getCGRealizedVariable_TypedModel();

	}

} //QVTiCGmodelPackage
