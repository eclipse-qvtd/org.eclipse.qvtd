/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.basecs.BaseCSPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.EssentialOCLCSPackage;

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
 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import basecs='../../org.eclipse.ocl.examples.xtext.base/model/BaseCS.ecore#/' essentialoclcs='../../org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCS.ecore#/' qvtb='../../org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore#/' qvtcb='../../org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore#/'"
 * @generated
 */
public interface QVTcoreBaseCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtcorebasecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.9/QVTcoreBaseCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtcbcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTcoreBaseCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AbstractMappingCSImpl <em>Abstract Mapping CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->S
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AbstractMappingCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.impl.QVTcoreBaseCSPackageImpl#getAbstractMappingCS()
	 * @generated
	 */
	int ABSTRACT_MAPPING_CS = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__DOMAINS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__IN = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Middle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS__MIDDLE = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Mapping CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MAPPING_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AreaCSImpl <em>Area CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AreaCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getAreaCS()
	 * @generated
	 */
	int AREA_CS = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__GUARD_PATTERN = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS__BOTTOM_PATTERN = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Area CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AssignmentCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getAssignmentCS()
	 * @generated
	 */
	int ASSIGNMENT_CS = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__PARENT = EssentialOCLCSPackage.EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__PIVOT = EssentialOCLCSPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__OWNED_ANNOTATIONS = EssentialOCLCSPackage.EXP_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__ORIGINAL_XMI_ID = EssentialOCLCSPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__CSI = EssentialOCLCSPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Has Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__HAS_ERROR = EssentialOCLCSPackage.EXP_CS__HAS_ERROR;

	/**
	 * The feature id for the '<em><b>Local Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOCAL_LEFT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFT;

	/**
	 * The feature id for the '<em><b>Local Leftmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOCAL_LEFTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_LEFTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Local Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOCAL_PARENT = EssentialOCLCSPackage.EXP_CS__LOCAL_PARENT;

	/**
	 * The feature id for the '<em><b>Local Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOCAL_RIGHT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHT;

	/**
	 * The feature id for the '<em><b>Local Rightmost Descendant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__LOCAL_RIGHTMOST_DESCENDANT = EssentialOCLCSPackage.EXP_CS__LOCAL_RIGHTMOST_DESCENDANT;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__PRECEDENCE = EssentialOCLCSPackage.EXP_CS__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__DEFAULT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__TARGET = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS__INITIALISER = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_CS_FEATURE_COUNT = EssentialOCLCSPackage.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.PatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 9;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__PARENT = BaseCSPackage.MODEL_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__CONSTRAINTS = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unrealized Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__UNREALIZED_VARIABLES = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.BottomPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getBottomPatternCS()
	 * @generated
	 */
	int BOTTOM_PATTERN_CS = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__PARENT = PATTERN_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__PIVOT = PATTERN_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_CS__OWNED_ANNOTATIONS = PATTERN_CS__OWNED_ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DirectionCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getDirectionCS()
	 * @generated
	 */
	int DIRECTION_CS = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__PARENT = BaseCSPackage.NAMED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__PIVOT = BaseCSPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__OWNED_ANNOTATIONS = BaseCSPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__ORIGINAL_XMI_ID = BaseCSPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__CSI = BaseCSPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__NAME = BaseCSPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__IMPORTS = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS__USES = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Direction CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTION_CS_FEATURE_COUNT = BaseCSPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PARENT = AREA_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PIVOT = AREA_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__OWNED_ANNOTATIONS = AREA_CS__OWNED_ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.EnforcementOperationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getEnforcementOperationCS()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION_CS = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__PARENT = BaseCSPackage.MODEL_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__PIVOT = BaseCSPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__CSI = BaseCSPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Deletion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__DELETION = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS__OPERATION_CALL = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enforcement Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_CS_FEATURE_COUNT = BaseCSPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.GuardPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getGuardPatternCS()
	 * @generated
	 */
	int GUARD_PATTERN_CS = 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__PARENT = PATTERN_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__PIVOT = PATTERN_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_CS__OWNED_ANNOTATIONS = PATTERN_CS__OWNED_ANNOTATIONS;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 8;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 10;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PATH_NAME = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TRANSFORMATION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__EXPRESSION = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizeableVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getRealizeableVariableCS()
	 * @generated
	 */
	int REALIZEABLE_VARIABLE_CS = 11;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__PARENT = BaseCSPackage.TYPED_ELEMENT_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__PIVOT = BaseCSPackage.TYPED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATIONS = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSPackage.TYPED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__CSI = BaseCSPackage.TYPED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__NAME = BaseCSPackage.TYPED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__OWNED_TYPE = BaseCSPackage.TYPED_ELEMENT_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__QUALIFIERS = BaseCSPackage.TYPED_ELEMENT_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS__IS_OPTIONAL = BaseCSPackage.TYPED_ELEMENT_CS__IS_OPTIONAL;

	/**
	 * The number of structural features of the '<em>Realizeable Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZEABLE_VARIABLE_CS_FEATURE_COUNT = BaseCSPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getRealizedVariableCS()
	 * @generated
	 */
	int REALIZED_VARIABLE_CS = 12;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__PARENT = REALIZEABLE_VARIABLE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__PIVOT = REALIZEABLE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__OWNED_ANNOTATIONS = REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATIONS;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__QUALIFIERS = REALIZEABLE_VARIABLE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS__IS_OPTIONAL = REALIZEABLE_VARIABLE_CS__IS_OPTIONAL;

	/**
	 * The number of structural features of the '<em>Realized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 13;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PARENT = BaseCSPackage.CLASS_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = BaseCSPackage.CLASS_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATIONS = BaseCSPackage.CLASS_CS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = BaseCSPackage.CLASS_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = BaseCSPackage.CLASS_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = BaseCSPackage.CLASS_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_SIGNATURE = BaseCSPackage.CLASS_CS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNING_PACKAGE = BaseCSPackage.CLASS_CS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__INSTANCE_CLASS_NAME = BaseCSPackage.CLASS_CS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_CONSTRAINTS = BaseCSPackage.CLASS_CS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUALIFIERS = BaseCSPackage.CLASS_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PATH_NAME = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PACKAGE = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Directions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__DIRECTIONS = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = BaseCSPackage.CLASS_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.UnrealizedVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getUnrealizedVariableCS()
	 * @generated
	 */
	int UNREALIZED_VARIABLE_CS = 14;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__PARENT = REALIZEABLE_VARIABLE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__PIVOT = REALIZEABLE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__OWNED_ANNOTATIONS = REALIZEABLE_VARIABLE_CS__OWNED_ANNOTATIONS;

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
	 * The feature id for the '<em><b>Qualifiers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__QUALIFIERS = REALIZEABLE_VARIABLE_CS__QUALIFIERS;

	/**
	 * The feature id for the '<em><b>Is Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS__IS_OPTIONAL = REALIZEABLE_VARIABLE_CS__IS_OPTIONAL;

	/**
	 * The number of structural features of the '<em>Unrealized Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNREALIZED_VARIABLE_CS_FEATURE_COUNT = REALIZEABLE_VARIABLE_CS_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS <em>Abstract Mapping CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Mapping CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS
	 * @generated
	 */
	EClass getAbstractMappingCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getDomains()
	 * @see #getAbstractMappingCS()
	 * @generated
	 */
	EReference getAbstractMappingCS_Domains();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getIn()
	 * @see #getAbstractMappingCS()
	 * @generated
	 */
	EReference getAbstractMappingCS_In();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getMiddle <em>Middle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Middle</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AbstractMappingCS#getMiddle()
	 * @see #getAbstractMappingCS()
	 * @generated
	 */
	EReference getAbstractMappingCS_Middle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS <em>Area CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS
	 * @generated
	 */
	EClass getAreaCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS#getGuardPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_GuardPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AreaCS#getBottomPattern()
	 * @see #getAreaCS()
	 * @generated
	 */
	EReference getAreaCS_BottomPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS <em>Assignment CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS
	 * @generated
	 */
	EClass getAssignmentCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#isDefault()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EAttribute getAssignmentCS_Default();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#getTarget()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS#getInitialiser()
	 * @see #getAssignmentCS()
	 * @generated
	 */
	EReference getAssignmentCS_Initialiser();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS <em>Bottom Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS
	 * @generated
	 */
	EClass getBottomPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS#getEnforcementOperations <em>Enforcement Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS#getEnforcementOperations()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_EnforcementOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS#getRealizedVariables()
	 * @see #getBottomPatternCS()
	 * @generated
	 */
	EReference getBottomPatternCS_RealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS <em>Direction CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direction CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS
	 * @generated
	 */
	EClass getDirectionCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS#getImports()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS#getUses()
	 * @see #getDirectionCS()
	 * @generated
	 */
	EReference getDirectionCS_Uses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#isCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#isCheck()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Check();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#isEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Enforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Direction</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS#getDirection()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Direction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS <em>Enforcement Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS
	 * @generated
	 */
	EClass getEnforcementOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS#isDeletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deletion</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS#isDeletion()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EAttribute getEnforcementOperationCS_Deletion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS#getOperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS#getOperationCall()
	 * @see #getEnforcementOperationCS()
	 * @generated
	 */
	EReference getEnforcementOperationCS_OperationCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS <em>Guard Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS
	 * @generated
	 */
	EClass getGuardPatternCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS#getConstraints()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS#getUnrealizedVariables <em>Unrealized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unrealized Variables</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.PatternCS#getUnrealizedVariables()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_UnrealizedVariables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getTransformation()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Transformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declaration</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getInputParamDeclaration()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS#getExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizeableVariableCS <em>Realizeable Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realizeable Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizeableVariableCS
	 * @generated
	 */
	EClass getRealizeableVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS <em>Realized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS
	 * @generated
	 */
	EClass getRealizedVariableCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getPathName()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getPackage()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getDirections <em>Directions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Directions</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS#getDirections()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Directions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS <em>Unrealized Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unrealized Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS
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
	QVTcoreBaseCSFactory getQVTcoreBaseCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AbstractMappingCSImpl <em>Abstract Mapping CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AbstractMappingCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getAbstractMappingCS()
		 * @generated
		 */
		EClass ABSTRACT_MAPPING_CS = eINSTANCE.getAbstractMappingCS();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MAPPING_CS__DOMAINS = eINSTANCE.getAbstractMappingCS_Domains();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MAPPING_CS__IN = eINSTANCE.getAbstractMappingCS_In();

		/**
		 * The meta object literal for the '<em><b>Middle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MAPPING_CS__MIDDLE = eINSTANCE.getAbstractMappingCS_Middle();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AreaCSImpl <em>Area CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AreaCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getAreaCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AssignmentCSImpl <em>Assignment CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AssignmentCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getAssignmentCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.BottomPatternCSImpl <em>Bottom Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.BottomPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getBottomPatternCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DirectionCSImpl <em>Direction CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DirectionCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getDirectionCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getDomainCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.EnforcementOperationCSImpl <em>Enforcement Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.EnforcementOperationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getEnforcementOperationCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.GuardPatternCSImpl <em>Guard Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.GuardPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getGuardPatternCS()
		 * @generated
		 */
		EClass GUARD_PATTERN_CS = eINSTANCE.getGuardPatternCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.PatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getPatternCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getQueryCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizeableVariableCSImpl <em>Realizeable Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizeableVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getRealizeableVariableCS()
		 * @generated
		 */
		EClass REALIZEABLE_VARIABLE_CS = eINSTANCE.getRealizeableVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizedVariableCSImpl <em>Realized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.RealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getRealizedVariableCS()
		 * @generated
		 */
		EClass REALIZED_VARIABLE_CS = eINSTANCE.getRealizedVariableCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getTransformationCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.UnrealizedVariableCSImpl <em>Unrealized Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.UnrealizedVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.QVTcoreBaseCSPackageImpl#getUnrealizedVariableCS()
		 * @generated
		 */
		EClass UNREALIZED_VARIABLE_CS = eINSTANCE.getUnrealizedVariableCS();

	}

} //QVTcoreBaseCSPackage
