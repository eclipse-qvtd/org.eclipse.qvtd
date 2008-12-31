/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: TestQVTBasePackage.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;

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
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBaseFactory
 * @model kind="package"
 * @generated
 */
public interface TestQVTBasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TestQVTBase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/TestQVTBase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tqvtb";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestQVTBasePackage eINSTANCE = org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestDomainImpl <em>Test Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestDomainImpl
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestDomain()
	 * @generated
	 */
	int TEST_DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__EANNOTATIONS = QVTBasePackage.DOMAIN__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__NAME = QVTBasePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__IS_CHECKABLE = QVTBasePackage.DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__IS_ENFORCEABLE = QVTBasePackage.DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__RULE = QVTBasePackage.DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__TYPED_MODEL = QVTBasePackage.DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN__CONTENTS = QVTBasePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_DOMAIN_FEATURE_COUNT = QVTBasePackage.DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestExpressionImpl <em>Test Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestExpressionImpl
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestExpression()
	 * @generated
	 */
	int TEST_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__EANNOTATIONS = EcorePackage.OCL_EXPRESSION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__NAME = EcorePackage.OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__ORDERED = EcorePackage.OCL_EXPRESSION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__UNIQUE = EcorePackage.OCL_EXPRESSION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__LOWER_BOUND = EcorePackage.OCL_EXPRESSION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__UPPER_BOUND = EcorePackage.OCL_EXPRESSION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__MANY = EcorePackage.OCL_EXPRESSION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__REQUIRED = EcorePackage.OCL_EXPRESSION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__ETYPE = EcorePackage.OCL_EXPRESSION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__EGENERIC_TYPE = EcorePackage.OCL_EXPRESSION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__START_POSITION = EcorePackage.OCL_EXPRESSION__START_POSITION;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION__END_POSITION = EcorePackage.OCL_EXPRESSION__END_POSITION;

	/**
	 * The number of structural features of the '<em>Test Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EXPRESSION_FEATURE_COUNT = EcorePackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestPatternImpl <em>Test Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestPatternImpl
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestPattern()
	 * @generated
	 */
	int TEST_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PATTERN__EANNOTATIONS = QVTBasePackage.PATTERN__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PATTERN__PREDICATE = QVTBasePackage.PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PATTERN__BINDS_TO = QVTBasePackage.PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PATTERN__CONTENTS = QVTBasePackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PATTERN_FEATURE_COUNT = QVTBasePackage.PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestRuleImpl <em>Test Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestRuleImpl
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestRule()
	 * @generated
	 */
	int TEST_RULE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__EANNOTATIONS = QVTBasePackage.RULE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__NAME = QVTBasePackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__DOMAIN = QVTBasePackage.RULE__DOMAIN;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__OVERRIDES = QVTBasePackage.RULE__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__TRANSFORMATION = QVTBasePackage.RULE__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE__CONTENTS = QVTBasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RULE_FEATURE_COUNT = QVTBasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl <em>Test Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestTransformation()
	 * @generated
	 */
	int TEST_TRANSFORMATION = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EANNOTATIONS = QVTBasePackage.TRANSFORMATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__NAME = QVTBasePackage.TRANSFORMATION__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__INSTANCE_CLASS_NAME = QVTBasePackage.TRANSFORMATION__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__INSTANCE_CLASS = QVTBasePackage.TRANSFORMATION__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__DEFAULT_VALUE = QVTBasePackage.TRANSFORMATION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__INSTANCE_TYPE_NAME = QVTBasePackage.TRANSFORMATION__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EPACKAGE = QVTBasePackage.TRANSFORMATION__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ETYPE_PARAMETERS = QVTBasePackage.TRANSFORMATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ABSTRACT = QVTBasePackage.TRANSFORMATION__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__INTERFACE = QVTBasePackage.TRANSFORMATION__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ESUPER_TYPES = QVTBasePackage.TRANSFORMATION__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EOPERATIONS = QVTBasePackage.TRANSFORMATION__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_ATTRIBUTES = QVTBasePackage.TRANSFORMATION__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_REFERENCES = QVTBasePackage.TRANSFORMATION__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EREFERENCES = QVTBasePackage.TRANSFORMATION__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EATTRIBUTES = QVTBasePackage.TRANSFORMATION__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_CONTAINMENTS = QVTBasePackage.TRANSFORMATION__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_OPERATIONS = QVTBasePackage.TRANSFORMATION__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_STRUCTURAL_FEATURES = QVTBasePackage.TRANSFORMATION__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_SUPER_TYPES = QVTBasePackage.TRANSFORMATION__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EID_ATTRIBUTE = QVTBasePackage.TRANSFORMATION__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ESTRUCTURAL_FEATURES = QVTBasePackage.TRANSFORMATION__ESTRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EGENERIC_SUPER_TYPES = QVTBasePackage.TRANSFORMATION__EGENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EALL_GENERIC_SUPER_TYPES = QVTBasePackage.TRANSFORMATION__EALL_GENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__NS_URI = QVTBasePackage.TRANSFORMATION__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__NS_PREFIX = QVTBasePackage.TRANSFORMATION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EFACTORY_INSTANCE = QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ECLASSIFIERS = QVTBasePackage.TRANSFORMATION__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ESUBPACKAGES = QVTBasePackage.TRANSFORMATION__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__ESUPER_PACKAGE = QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__OWNED_TAG = QVTBasePackage.TRANSFORMATION__OWNED_TAG;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__MODEL_PARAMETER = QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__RULE = QVTBasePackage.TRANSFORMATION__RULE;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__EXTENDS = QVTBasePackage.TRANSFORMATION__EXTENDS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__CONTENTS = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Bag</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__STRING_BAG = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>String Ordered Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__STRING_ORDERED_SET = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>String Sequence</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__STRING_SEQUENCE = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>String Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__STRING_SET = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION__STRING = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Test Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_TRANSFORMATION_FEATURE_COUNT = QVTBasePackage.TRANSFORMATION_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain <em>Test Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Domain</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain
	 * @generated
	 */
	EClass getTestDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain#getContents()
	 * @see #getTestDomain()
	 * @generated
	 */
	EReference getTestDomain_Contents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression <em>Test Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Expression</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression
	 * @generated
	 */
	EClass getTestExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern <em>Test Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Pattern</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern
	 * @generated
	 */
	EClass getTestPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern#getContents()
	 * @see #getTestPattern()
	 * @generated
	 */
	EReference getTestPattern_Contents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestRule <em>Test Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Rule</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestRule
	 * @generated
	 */
	EClass getTestRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestRule#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestRule#getContents()
	 * @see #getTestRule()
	 * @generated
	 */
	EReference getTestRule_Contents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation <em>Test Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Transformation</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation
	 * @generated
	 */
	EClass getTestTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getContents()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EReference getTestTransformation_Contents();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringBag <em>String Bag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>String Bag</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringBag()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EAttribute getTestTransformation_StringBag();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringOrderedSet <em>String Ordered Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>String Ordered Set</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringOrderedSet()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EAttribute getTestTransformation_StringOrderedSet();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSequence <em>String Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>String Sequence</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSequence()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EAttribute getTestTransformation_StringSequence();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSet <em>String Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>String Set</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getStringSet()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EAttribute getTestTransformation_StringSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation#getString()
	 * @see #getTestTransformation()
	 * @generated
	 */
	EAttribute getTestTransformation_String();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestQVTBaseFactory getTestQVTBaseFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestDomainImpl <em>Test Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestDomainImpl
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestDomain()
		 * @generated
		 */
		EClass TEST_DOMAIN = eINSTANCE.getTestDomain();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_DOMAIN__CONTENTS = eINSTANCE.getTestDomain_Contents();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestExpressionImpl <em>Test Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestExpressionImpl
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestExpression()
		 * @generated
		 */
		EClass TEST_EXPRESSION = eINSTANCE.getTestExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestPatternImpl <em>Test Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestPatternImpl
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestPattern()
		 * @generated
		 */
		EClass TEST_PATTERN = eINSTANCE.getTestPattern();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_PATTERN__CONTENTS = eINSTANCE.getTestPattern_Contents();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestRuleImpl <em>Test Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestRuleImpl
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestRule()
		 * @generated
		 */
		EClass TEST_RULE = eINSTANCE.getTestRule();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_RULE__CONTENTS = eINSTANCE.getTestRule_Contents();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl <em>Test Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestTransformationImpl
		 * @see org.eclipse.qvt.declarative.test.TestQVTBase.impl.TestQVTBasePackageImpl#getTestTransformation()
		 * @generated
		 */
		EClass TEST_TRANSFORMATION = eINSTANCE.getTestTransformation();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_TRANSFORMATION__CONTENTS = eINSTANCE.getTestTransformation_Contents();

		/**
		 * The meta object literal for the '<em><b>String Bag</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_TRANSFORMATION__STRING_BAG = eINSTANCE.getTestTransformation_StringBag();

		/**
		 * The meta object literal for the '<em><b>String Ordered Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_TRANSFORMATION__STRING_ORDERED_SET = eINSTANCE.getTestTransformation_StringOrderedSet();

		/**
		 * The meta object literal for the '<em><b>String Sequence</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_TRANSFORMATION__STRING_SEQUENCE = eINSTANCE.getTestTransformation_StringSequence();

		/**
		 * The meta object literal for the '<em><b>String Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_TRANSFORMATION__STRING_SET = eINSTANCE.getTestTransformation_StringSet();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_TRANSFORMATION__STRING = eINSTANCE.getTestTransformation_String();

	}

} //TestQVTBasePackage
