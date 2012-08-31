/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcoreCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtcorecst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.9/QVTcoreCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtccs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcoreCSTPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.AreaCSImpl <em>Area CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.AreaCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getAreaCS()
	 * @generated
	 */
	int AREA_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__GUARD_PATTERN = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__BOTTOM_PATTERN = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Area CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.AssignmentCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getAssignmentCS()
	 * @generated
	 */
	int ASSIGNMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__DEFAULT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__TARGET = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__INITIALISER = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.PatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 9;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__CONSTRAINTS = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__UNREALIZED_VARIABLES = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getBottomPatternCS()
	 * @generated
	 */
	int BOTTOM_PATTERN_CS = 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__LOGICAL_PARENT = PATTERN_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__PIVOT = PATTERN_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__OWNED_ANNOTATION = PATTERN_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__ORIGINAL_XMI_ID = PATTERN_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__CSI = PATTERN_CS__CSI;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__CONSTRAINTS = PATTERN_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__UNREALIZED_VARIABLES = PATTERN_CS__UNREALIZED_VARIABLES;

	/**
	 * The feature id for the '<em><b>Enforcement Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS = PATTERN_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Realized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__REALIZED_VARIABLES = PATTERN_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bottom Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS_FEATURE_COUNT = PATTERN_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl <em>Direction CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getDirectionCS()
	 * @generated
	 */
	int DIRECTION_CS = 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__IMPORTS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__USES = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Direction CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__LOGICAL_PARENT = AREA_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PIVOT = AREA_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__OWNED_ANNOTATION = AREA_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ORIGINAL_XMI_ID = AREA_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CSI = AREA_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__NAME = AREA_CS__NAME;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__GUARD_PATTERN = AREA_CS__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__BOTTOM_PATTERN = AREA_CS__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CHECK = AREA_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ENFORCE = AREA_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__DIRECTION = AREA_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS_FEATURE_COUNT = AREA_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.EnforcementOperationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getEnforcementOperationCS()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Deletion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__DELETION = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__OPERATION_CALL = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enforcement Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.GuardPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getGuardPatternCS()
	 * @generated
	 */
	int GUARD_PATTERN_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__LOGICAL_PARENT = PATTERN_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__PIVOT = PATTERN_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__OWNED_ANNOTATION = PATTERN_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__ORIGINAL_XMI_ID = PATTERN_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__CSI = PATTERN_CS__CSI;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__CONSTRAINTS = PATTERN_CS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__UNREALIZED_VARIABLES = PATTERN_CS__UNREALIZED_VARIABLES;

	/**
	 * The number of structural features of the '<em>Guard Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS_FEATURE_COUNT = PATTERN_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl <em>Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getMappingCS()
	 * @generated
	 */
	int MAPPING_CS = 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Composed Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__COMPOSED_MAPPINGS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__DOMAINS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__IN = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__MIDDLE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS__REFINES = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__LOGICAL_PARENT = BaseCSTPackage.TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PIVOT = BaseCSTPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_ANNOTATION = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__CSI = BaseCSTPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__NAME = BaseCSTPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_TYPE = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_CONSTRAINT = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__QUALIFIER = BaseCSTPackage.TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OPTIONAL = BaseCSTPackage.TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 10;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__LOGICAL_PARENT = BaseCSTPackage.TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PIVOT = BaseCSTPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_ANNOTATION = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__ORIGINAL_XMI_ID = BaseCSTPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__CSI = BaseCSTPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__NAME = BaseCSTPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_TYPE = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_CONSTRAINT = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__QUALIFIER = BaseCSTPackage.TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OPTIONAL = BaseCSTPackage.TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PATH_NAME = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TRANSFORMATION = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATION = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__EXPRESSION = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizeableVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getRealizeableVariableCS()
	 * @generated
	 */
	int REALIZEABLE_VARIABLE_CS = 11;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__LOGICAL_PARENT = BaseCSTPackage.TYPED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__PIVOT = BaseCSTPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATION = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__CSI = BaseCSTPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__NAME = BaseCSTPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OWNED_TYPE = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OWNED_CONSTRAINT = BaseCSTPackage.TYPED_ELEMENT_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__QUALIFIER = BaseCSTPackage.TYPED_ELEMENT_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OPTIONAL = BaseCSTPackage.TYPED_ELEMENT_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Realizeable Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getRealizedVariableCS()
	 * @generated
	 */
	int REALIZED_VARIABLE_CS = 12;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__LOGICAL_PARENT = REALIZEABLE_VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__PIVOT = REALIZEABLE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__OWNED_ANNOTATION = REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__ORIGINAL_XMI_ID = REALIZEABLE_VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__CSI = REALIZEABLE_VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__NAME = REALIZEABLE_VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__OWNED_TYPE = REALIZEABLE_VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__OWNED_CONSTRAINT = REALIZEABLE_VARIABLE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__QUALIFIER = REALIZEABLE_VARIABLE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__OPTIONAL = REALIZEABLE_VARIABLE_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Realized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 13;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__LOGICAL_PARENT = BaseCSTPackage.ROOT_PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__PIVOT = BaseCSTPackage.ROOT_PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_ANNOTATION = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__ORIGINAL_XMI_ID = BaseCSTPackage.ROOT_PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__CSI = BaseCSTPackage.ROOT_PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__NAME = BaseCSTPackage.ROOT_PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_TYPE = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_NESTED_PACKAGE = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__NS_PREFIX = BaseCSTPackage.ROOT_PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__NS_URI = BaseCSTPackage.ROOT_PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_IMPORT = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__OWNED_LIBRARY = BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;

	/**
	 * The feature id for the '<em><b>Transformations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATIONS = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__QUERIES = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__MAPPINGS = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 14;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__LOGICAL_PARENT = BaseCSTPackage.PACKAGE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = BaseCSTPackage.PACKAGE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATION = BaseCSTPackage.PACKAGE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.PACKAGE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = BaseCSTPackage.PACKAGE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = BaseCSTPackage.PACKAGE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_TYPE = BaseCSTPackage.PACKAGE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_NESTED_PACKAGE = BaseCSTPackage.PACKAGE_CS__OWNED_NESTED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NS_PREFIX = BaseCSTPackage.PACKAGE_CS__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NS_URI = BaseCSTPackage.PACKAGE_CS__NS_URI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PATH_NAME = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PACKAGE = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Directions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__DIRECTIONS = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.UnrealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getUnrealizedVariableCS()
	 * @generated
	 */
	int UNREALIZED_VARIABLE_CS = 15;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__LOGICAL_PARENT = REALIZEABLE_VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__PIVOT = REALIZEABLE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__OWNED_ANNOTATION = REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__ORIGINAL_XMI_ID = REALIZEABLE_VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__CSI = REALIZEABLE_VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__NAME = REALIZEABLE_VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__OWNED_TYPE = REALIZEABLE_VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__OWNED_CONSTRAINT = REALIZEABLE_VARIABLE_CS__OWNED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__QUALIFIER = REALIZEABLE_VARIABLE_CS__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__OPTIONAL = REALIZEABLE_VARIABLE_CS__OPTIONAL;

	/**
	 * The number of structural features of the '<em>Unrealized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.AreaCS <em>Area CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AreaCS
	 * @generated
	 */
	EClass getAreaCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.AreaCS#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AreaCS#getGuardPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_GuardPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.AreaCS#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AreaCS#getBottomPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_BottomPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS <em>Assignment CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS
	 * @generated
	 */
	EClass getAssignmentCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#isDefault()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EAttribute getAssignmentCS_Default();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getTarget()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS#getInitialiser()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Initialiser();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS <em>Bottom Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS
	 * @generated
	 */
	EClass getBottomPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getEnforcementOperations <em>Enforcement Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getEnforcementOperations()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_EnforcementOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS#getRealizedVariables()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_RealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS <em>Direction CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS
	 * @generated
	 */
	EClass getDirectionCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getImports()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS#getUses()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Uses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#isCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#isCheck()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Check();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#isEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Enforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.DomainCS#getDirection()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS <em>Enforcement Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS
	 * @generated
	 */
	EClass getEnforcementOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#isDeletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deletion</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#isDeletion()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EAttribute getEnforcementOperationCS_Deletion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS#getOperationCall()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EReference getEnforcementOperationCS_OperationCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS <em>Guard Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS
	 * @generated
	 */
	EClass getGuardPatternCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS <em>Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS
	 * @generated
	 */
	EClass getMappingCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getComposedMappings <em>Composed Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composed Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getComposedMappings()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_ComposedMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getDomains()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Domains();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getIn()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getMiddle <em>Middle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Middle</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getMiddle()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Middle();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.MappingCS#getRefines()
	 * @see #getMappingCS()
	 * @generated
	 */
	EReference getMappingCS_Refines();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.PatternCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.PatternCS#getConstraints()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.PatternCS#getUnrealizedVariables <em>Unrealized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unrealized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.PatternCS#getUnrealizedVariables()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_UnrealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getTransformation()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Transformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declaration</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getInputParamDeclaration()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.QueryCS#getExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS <em>Realizeable Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realizeable Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS
	 * @generated
	 */
	EClass getRealizeableVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS <em>Realized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS
	 * @generated
	 */
	EClass getRealizedVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getTransformations <em>Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getQueries()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Queries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS#getMappings()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Mappings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getPathName()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getPackage()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getDirections <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Directions</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS#getDirections()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Directions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS <em>Unrealized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unrealized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS
	 * @generated
	 */
	EClass getUnrealizedVariableCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcoreCSTFactory getQVTcoreCSTFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.AreaCSImpl <em>Area CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.AreaCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getAreaCS()
		 * @generated
		 */
		EClass AREA_CS = eINSTANCE.getAreaCS();

		/**
		 * The meta object literal for the '<em><b>Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__GUARD_PATTERN = eINSTANCE.getAreaCS_GuardPattern();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA_CS__BOTTOM_PATTERN = eINSTANCE.getAreaCS_BottomPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.AssignmentCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getAssignmentCS()
		 * @generated
		 */
		EClass ASSIGNMENT_CS = eINSTANCE.getAssignmentCS();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_CS__DEFAULT = eINSTANCE.getAssignmentCS_Default();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_CS__TARGET = eINSTANCE.getAssignmentCS_Target();

		/**
		 * The meta object literal for the '<em><b>Initialiser</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_CS__INITIALISER = eINSTANCE.getAssignmentCS_Initialiser();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.BottomPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getBottomPatternCS()
		 * @generated
		 */
		EClass BOTTOM_PATTERN_CS = eINSTANCE.getBottomPatternCS();

		/**
		 * The meta object literal for the '<em><b>Enforcement Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__ENFORCEMENT_OPERATIONS = eINSTANCE.getBottomPatternCS_EnforcementOperations();

		/**
		 * The meta object literal for the '<em><b>Realized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN_CS__REALIZED_VARIABLES = eINSTANCE.getBottomPatternCS_RealizedVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl <em>Direction CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.DirectionCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getDirectionCS()
		 * @generated
		 */
		EClass DIRECTION_CS = eINSTANCE.getDirectionCS();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__IMPORTS = eINSTANCE.getDirectionCS_Imports();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTION_CS__USES = eINSTANCE.getDirectionCS_Uses();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__CHECK = eINSTANCE.getDomainCS_Check();

		/**
		 * The meta object literal for the '<em><b>Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__ENFORCE = eINSTANCE.getDomainCS_Enforce();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__DIRECTION = eINSTANCE.getDomainCS_Direction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.EnforcementOperationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getEnforcementOperationCS()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION_CS = eINSTANCE.getEnforcementOperationCS();

		/**
		 * The meta object literal for the '<em><b>Deletion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION_CS__DELETION = eINSTANCE.getEnforcementOperationCS_Deletion();

		/**
		 * The meta object literal for the '<em><b>Operation Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION_CS__OPERATION_CALL = eINSTANCE.getEnforcementOperationCS_OperationCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.GuardPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getGuardPatternCS()
		 * @generated
		 */
		EClass GUARD_PATTERN_CS = eINSTANCE.getGuardPatternCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl <em>Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getMappingCS()
		 * @generated
		 */
		EClass MAPPING_CS = eINSTANCE.getMappingCS();

		/**
		 * The meta object literal for the '<em><b>Composed Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__COMPOSED_MAPPINGS = eINSTANCE.getMappingCS_ComposedMappings();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__DOMAINS = eINSTANCE.getMappingCS_Domains();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__IN = eINSTANCE.getMappingCS_In();

		/**
		 * The meta object literal for the '<em><b>Middle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__MIDDLE = eINSTANCE.getMappingCS_Middle();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CS__REFINES = eINSTANCE.getMappingCS_Refines();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.PatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getPatternCS()
		 * @generated
		 */
		EClass PATTERN_CS = eINSTANCE.getPatternCS();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__CONSTRAINTS = eINSTANCE.getPatternCS_Constraints();

		/**
		 * The meta object literal for the '<em><b>Unrealized Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__UNREALIZED_VARIABLES = eINSTANCE.getPatternCS_UnrealizedVariables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__PATH_NAME = eINSTANCE.getQueryCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__TRANSFORMATION = eINSTANCE.getQueryCS_Transformation();

		/**
		 * The meta object literal for the '<em><b>Input Param Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__INPUT_PARAM_DECLARATION = eINSTANCE.getQueryCS_InputParamDeclaration();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__EXPRESSION = eINSTANCE.getQueryCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizeableVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getRealizeableVariableCS()
		 * @generated
		 */
		EClass REALIZEABLE_VARIABLE_CS = eINSTANCE.getRealizeableVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.RealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getRealizedVariableCS()
		 * @generated
		 */
		EClass REALIZED_VARIABLE_CS = eINSTANCE.getRealizedVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__TRANSFORMATIONS = eINSTANCE.getTopLevelCS_Transformations();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__QUERIES = eINSTANCE.getTopLevelCS_Queries();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__MAPPINGS = eINSTANCE.getTopLevelCS_Mappings();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PATH_NAME = eINSTANCE.getTransformationCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__PACKAGE = eINSTANCE.getTransformationCS_Package();

		/**
		 * The meta object literal for the '<em><b>Directions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__DIRECTIONS = eINSTANCE.getTransformationCS_Directions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.UnrealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorecst.impl.QVTcoreCSTPackageImpl#getUnrealizedVariableCS()
		 * @generated
		 */
		EClass UNREALIZED_VARIABLE_CS = eINSTANCE.getUnrealizedVariableCS();

	}

} //QVTcoreCSTPackage
