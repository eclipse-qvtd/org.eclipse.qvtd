/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTCorePackage.java,v 1.2 2009/11/19 10:33:33 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTCore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;

import org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage;

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
 * @see org.eclipse.qvt.declarative.emof.QVTCore.QVTCoreFactory
 * @model kind="package"
 * @generated
 */
public interface QVTCorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "QVTCore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schema.omg.org/spec/QVT/1.1/qvtcore.xml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtc";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvt.declarative.emof.qvtcore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTCorePackage eINSTANCE = org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.AreaImpl <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.AreaImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getArea()
	 * @generated
	 */
	int AREA = 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__BOTTOM_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__GUARD_PATTERN = 1;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.AssignmentImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__OWNED_COMMENT = EMOFPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__BOTTOM_PATTERN = EMOFPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__IS_DEFAULT = EMOFPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = EMOFPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = EMOFPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.CorePatternImpl <em>Core Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.CorePatternImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getCorePattern()
	 * @generated
	 */
	int CORE_PATTERN = 4;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__OWNED_COMMENT = QVTBasePackage.PATTERN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__BINDS_TO = QVTBasePackage.PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__PREDICATE = QVTBasePackage.PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__VARIABLE = QVTBasePackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN_FEATURE_COUNT = QVTBasePackage.PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.BottomPatternImpl <em>Bottom Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.BottomPatternImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getBottomPattern()
	 * @generated
	 */
	int BOTTOM_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__OWNED_COMMENT = CORE_PATTERN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__BINDS_TO = CORE_PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__PREDICATE = CORE_PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__VARIABLE = CORE_PATTERN__VARIABLE;

	/**
	 * The feature id for the '<em><b>Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__AREA = CORE_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__ASSIGNMENT = CORE_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__ENFORCEMENT_OPERATION = CORE_PATTERN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__REALIZED_VARIABLE = CORE_PATTERN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_FEATURE_COUNT = CORE_PATTERN_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.CoreDomainImpl <em>Core Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.CoreDomainImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getCoreDomain()
	 * @generated
	 */
	int CORE_DOMAIN = 3;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__OWNED_COMMENT = QVTBasePackage.DOMAIN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__NAME = QVTBasePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__IS_CHECKABLE = QVTBasePackage.DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__IS_ENFORCEABLE = QVTBasePackage.DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__RULE = QVTBasePackage.DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__TYPED_MODEL = QVTBasePackage.DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__BOTTOM_PATTERN = QVTBasePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__GUARD_PATTERN = QVTBasePackage.DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN_FEATURE_COUNT = QVTBasePackage.DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.EnforcementOperationImpl <em>Enforcement Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.EnforcementOperationImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getEnforcementOperation()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OWNED_COMMENT = EMOFPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__BOTTOM_PATTERN = EMOFPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforcement Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__ENFORCEMENT_MODE = EMOFPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OPERATION_CALL_EXP = EMOFPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enforcement Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_FEATURE_COUNT = EMOFPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.GuardPatternImpl <em>Guard Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.GuardPatternImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getGuardPattern()
	 * @generated
	 */
	int GUARD_PATTERN = 6;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__OWNED_COMMENT = CORE_PATTERN__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__BINDS_TO = CORE_PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__PREDICATE = CORE_PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__VARIABLE = CORE_PATTERN__VARIABLE;

	/**
	 * The feature id for the '<em><b>Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__AREA = CORE_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_FEATURE_COUNT = CORE_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.MappingImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 7;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_COMMENT = QVTBasePackage.RULE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = QVTBasePackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DOMAIN = QVTBasePackage.RULE__DOMAIN;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDES = QVTBasePackage.RULE__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TRANSFORMATION = QVTBasePackage.RULE__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__BOTTOM_PATTERN = QVTBasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GUARD_PATTERN = QVTBasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONTEXT = QVTBasePackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__LOCAL = QVTBasePackage.RULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refinement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__REFINEMENT = QVTBasePackage.RULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SPECIFICATION = QVTBasePackage.RULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTBasePackage.RULE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.PropertyAssignmentImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getPropertyAssignment()
	 * @generated
	 */
	int PROPERTY_ASSIGNMENT = 8;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__OWNED_COMMENT = ASSIGNMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__BOTTOM_PATTERN = ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__IS_DEFAULT = ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__SLOT_EXPRESSION = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__TARGET_PROPERTY = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.RealizedVariableImpl <em>Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.RealizedVariableImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getRealizedVariable()
	 * @generated
	 */
	int REALIZED_VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__OWNED_COMMENT = EssentialOCLPackage.VARIABLE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__NAME = EssentialOCLPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__TYPE = EssentialOCLPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__INIT_EXPRESSION = EssentialOCLPackage.VARIABLE__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__LET_EXP = EssentialOCLPackage.VARIABLE__LET_EXP;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__REPRESENTED_PARAMETER = EssentialOCLPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The number of structural features of the '<em>Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_FEATURE_COUNT = EssentialOCLPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.VariableAssignmentImpl
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 10;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__OWNED_COMMENT = ASSIGNMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__BOTTOM_PATTERN = ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__IS_DEFAULT = ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__TARGET_VARIABLE = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode <em>Enforcement Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getEnforcementMode()
	 * @generated
	 */
	int ENFORCEMENT_MODE = 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Area#getBottomPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.Area#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Area#getGuardPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_GuardPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getBottomPattern()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_BottomPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getIsDefault()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_IsDefault();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern
	 * @generated
	 */
	EClass getBottomPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getArea()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Area();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignment</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getAssignment()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Assignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getEnforcementOperation()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_EnforcementOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.BottomPattern#getRealizedVariable()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_RealizedVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.CoreDomain <em>Core Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Domain</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.CoreDomain
	 * @generated
	 */
	EClass getCoreDomain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.CorePattern <em>Core Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.CorePattern
	 * @generated
	 */
	EClass getCorePattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.CorePattern#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.CorePattern#getVariable()
	 * @see #getCorePattern()
	 * @generated
	 */
	EReference getCorePattern_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation
	 * @generated
	 */
	EClass getEnforcementOperation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getBottomPattern()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_BottomPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getEnforcementMode()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EAttribute getEnforcementOperation_EnforcementMode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementOperation#getOperationCallExp()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_OperationCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern
	 * @generated
	 */
	EClass getGuardPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.GuardPattern#getArea()
	 * @see #getGuardPattern()
	 * @generated
	 */
	EReference getGuardPattern_Area();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getContext()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Context();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getLocal()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Local();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refinement</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getRefinement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Refinement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.Mapping#getSpecification()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Specification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Assignment</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment
	 * @generated
	 */
	EClass getPropertyAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getSlotExpression <em>Slot Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Expression</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getSlotExpression()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_SlotExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.PropertyAssignment#getTargetProperty()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_TargetProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.RealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.RealizedVariable
	 * @generated
	 */
	EClass getRealizedVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.emof.QVTCore.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.emof.QVTCore.VariableAssignment#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.VariableAssignment#getTargetVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_TargetVariable();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode
	 * @generated
	 */
	EEnum getEnforcementMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTCoreFactory getQVTCoreFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.AreaImpl <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.AreaImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__BOTTOM_PATTERN = eINSTANCE.getArea_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__GUARD_PATTERN = eINSTANCE.getArea_GuardPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.AssignmentImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__BOTTOM_PATTERN = eINSTANCE.getAssignment_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__IS_DEFAULT = eINSTANCE.getAssignment_IsDefault();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.BottomPatternImpl <em>Bottom Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.BottomPatternImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getBottomPattern()
		 * @generated
		 */
		EClass BOTTOM_PATTERN = eINSTANCE.getBottomPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__AREA = eINSTANCE.getBottomPattern_Area();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ASSIGNMENT = eINSTANCE.getBottomPattern_Assignment();

		/**
		 * The meta object literal for the '<em><b>Enforcement Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ENFORCEMENT_OPERATION = eINSTANCE.getBottomPattern_EnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Realized Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__REALIZED_VARIABLE = eINSTANCE.getBottomPattern_RealizedVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.CoreDomainImpl <em>Core Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.CoreDomainImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getCoreDomain()
		 * @generated
		 */
		EClass CORE_DOMAIN = eINSTANCE.getCoreDomain();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.CorePatternImpl <em>Core Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.CorePatternImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getCorePattern()
		 * @generated
		 */
		EClass CORE_PATTERN = eINSTANCE.getCorePattern();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_PATTERN__VARIABLE = eINSTANCE.getCorePattern_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.EnforcementOperationImpl <em>Enforcement Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.EnforcementOperationImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getEnforcementOperation()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION = eINSTANCE.getEnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__BOTTOM_PATTERN = eINSTANCE.getEnforcementOperation_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Enforcement Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION__ENFORCEMENT_MODE = eINSTANCE.getEnforcementOperation_EnforcementMode();

		/**
		 * The meta object literal for the '<em><b>Operation Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__OPERATION_CALL_EXP = eINSTANCE.getEnforcementOperation_OperationCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.GuardPatternImpl <em>Guard Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.GuardPatternImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getGuardPattern()
		 * @generated
		 */
		EClass GUARD_PATTERN = eINSTANCE.getGuardPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PATTERN__AREA = eINSTANCE.getGuardPattern_Area();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.MappingImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONTEXT = eINSTANCE.getMapping_Context();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__LOCAL = eINSTANCE.getMapping_Local();

		/**
		 * The meta object literal for the '<em><b>Refinement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__REFINEMENT = eINSTANCE.getMapping_Refinement();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SPECIFICATION = eINSTANCE.getMapping_Specification();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.PropertyAssignmentImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getPropertyAssignment()
		 * @generated
		 */
		EClass PROPERTY_ASSIGNMENT = eINSTANCE.getPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Slot Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__SLOT_EXPRESSION = eINSTANCE.getPropertyAssignment_SlotExpression();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__TARGET_PROPERTY = eINSTANCE.getPropertyAssignment_TargetProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.RealizedVariableImpl <em>Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.RealizedVariableImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getRealizedVariable()
		 * @generated
		 */
		EClass REALIZED_VARIABLE = eINSTANCE.getRealizedVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.VariableAssignmentImpl
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__TARGET_VARIABLE = eINSTANCE.getVariableAssignment_TargetVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode <em>Enforcement Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.EnforcementMode
		 * @see org.eclipse.qvt.declarative.emof.QVTCore.impl.QVTCorePackageImpl#getEnforcementMode()
		 * @generated
		 */
		EEnum ENFORCEMENT_MODE = eINSTANCE.getEnforcementMode();

	}

} //QVTCorePackage
