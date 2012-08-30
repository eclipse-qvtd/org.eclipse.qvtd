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
package org.eclipse.qvtd.xtext.qvtrelationcst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;

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
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTFactory
 * @model kind="package"
 * @generated
 */
public interface QVTrelationCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtrelationcst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.9/QVTrelationCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtrcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTrelationCSTPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.AbstractDomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getAbstractDomainCS()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_CS = 0;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The number of structural features of the '<em>Abstract Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateVariableCS()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_CS = 17;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__TYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl <em>Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateCS()
	 * @generated
	 */
	int TEMPLATE_CS = 16;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__LOGICAL_PARENT = TEMPLATE_VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__PIVOT = TEMPLATE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__OWNED_ANNOTATION = TEMPLATE_VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__ORIGINAL_XMI_ID = TEMPLATE_VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__CSI = TEMPLATE_VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__NAME = TEMPLATE_VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__PARENT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__GUARD_EXPRESSION = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getCollectionTemplateCS()
	 * @generated
	 */
	int COLLECTION_TEMPLATE_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__LOGICAL_PARENT = TEMPLATE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__PIVOT = TEMPLATE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__OWNED_ANNOTATION = TEMPLATE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__ORIGINAL_XMI_ID = TEMPLATE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__CSI = TEMPLATE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__NAME = TEMPLATE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__PARENT = TEMPLATE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__GUARD_EXPRESSION = TEMPLATE_CS__GUARD_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Member Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS = TEMPLATE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rest Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__REST_IDENTIFIER = TEMPLATE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDefaultValueCS()
	 * @generated
	 */
	int DEFAULT_VALUE_CS = 2;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__INITIALISER = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__PROPERTY_ID = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Default Value CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__LOGICAL_PARENT = ABSTRACT_DOMAIN_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PIVOT = ABSTRACT_DOMAIN_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__OWNED_ANNOTATION = ABSTRACT_DOMAIN_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ORIGINAL_XMI_ID = ABSTRACT_DOMAIN_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CSI = ABSTRACT_DOMAIN_CS__CSI;

	/**
	 * The feature id for the '<em><b>Checkonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__CHECKONLY = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__ENFORCE = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__MODEL_ID = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Replace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__REPLACE = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__PATTERN = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__DEFAULT_VALUES = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Implemented By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__IMPLEMENTED_BY = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS_FEATURE_COUNT = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainPatternCSImpl <em>Domain Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDomainPatternCS()
	 * @generated
	 */
	int DOMAIN_PATTERN_CS = 4;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS__TEMPLATE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Domain Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ElementTemplateCSImpl <em>Element Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ElementTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getElementTemplateCS()
	 * @generated
	 */
	int ELEMENT_TEMPLATE_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__LOGICAL_PARENT = TEMPLATE_VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__PIVOT = TEMPLATE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__OWNED_ANNOTATION = TEMPLATE_VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__ORIGINAL_XMI_ID = TEMPLATE_VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__CSI = TEMPLATE_VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__NAME = TEMPLATE_VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The number of structural features of the '<em>Element Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getKeyDeclCS()
	 * @generated
	 */
	int KEY_DECL_CS = 6;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PATH_NAME = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Ids</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PROPERTY_IDS = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__CLASS_ID = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Key Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getModelDeclCS()
	 * @generated
	 */
	int MODEL_DECL_CS = 7;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Meta Model Ids</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__META_MODEL_IDS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ObjectTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getObjectTemplateCS()
	 * @generated
	 */
	int OBJECT_TEMPLATE_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__LOGICAL_PARENT = TEMPLATE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__PIVOT = TEMPLATE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__OWNED_ANNOTATION = TEMPLATE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__ORIGINAL_XMI_ID = TEMPLATE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__CSI = TEMPLATE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__NAME = TEMPLATE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__PARENT = TEMPLATE_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__GUARD_EXPRESSION = TEMPLATE_CS__GUARD_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Property Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES = TEMPLATE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 9;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 10;

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
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS__PREDICATES = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PredicateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPredicateCS()
	 * @generated
	 */
	int PREDICATE_CS = 11;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS__EXPR = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Predicate CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPrimitiveTypeDomainCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS = 12;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__LOGICAL_PARENT = TEMPLATE_VARIABLE_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__PIVOT = TEMPLATE_VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__OWNED_ANNOTATION = TEMPLATE_VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__ORIGINAL_XMI_ID = TEMPLATE_VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__CSI = TEMPLATE_VARIABLE_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__NAME = TEMPLATE_VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The number of structural features of the '<em>Primitive Type Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS_FEATURE_COUNT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPropertyTemplateCS()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_CS = 13;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Object Template</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__PROPERTY_ID = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__EXPRESSION = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OPPOSITE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 14;

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
	 * The feature id for the '<em><b>Input Param Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATIONS = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__EXPRESSION = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl <em>Relation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getRelationCS()
	 * @generated
	 */
	int RELATION_CS = 15;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__TOP = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__OVERRIDES = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__VAR_DECLARATIONS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__DOMAINS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__WHEN = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__WHERE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Relation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 18;

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
	 * The feature id for the '<em><b>Import Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__IMPORT_CLAUSES = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATIONS = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSTPackage.ROOT_PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 19;

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
	 * The feature id for the '<em><b>Model Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__MODEL_DECLS = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__EXTENDS = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__KEY_DECLS = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUERIES = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__RELATION = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = BaseCSTPackage.PACKAGE_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 20;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IDENTIFIER = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getVarDeclarationCS()
	 * @generated
	 */
	int VAR_DECLARATION_CS = 21;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Var Declaration Ids</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__VAR_DECLARATION_IDS = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__TYPE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Var Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationIdCSImpl <em>Var Declaration Id CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationIdCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getVarDeclarationIdCS()
	 * @generated
	 */
	int VAR_DECLARATION_ID_CS = 22;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Var Declaration Id CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_ID_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS <em>Abstract Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS
	 * @generated
	 */
	EClass getAbstractDomainCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS <em>Collection Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS
	 * @generated
	 */
	EClass getCollectionTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getMemberIdentifiers <em>Member Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Identifiers</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getMemberIdentifiers()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_MemberIdentifiers();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getRestIdentifier <em>Rest Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rest Identifier</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getRestIdentifier()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_RestIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS <em>Default Value CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Value CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS
	 * @generated
	 */
	EClass getDefaultValueCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getInitialiser()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_Initialiser();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS#getPropertyId()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_PropertyId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isCheckonly <em>Checkonly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkonly</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isCheckonly()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Checkonly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Enforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getModelId()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_ModelId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isReplace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replace</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#isReplace()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Replace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getPattern()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Pattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getDefaultValues <em>Default Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Values</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getDefaultValues()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_DefaultValues();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getImplementedBy <em>Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implemented By</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getImplementedBy()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_ImplementedBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS <em>Domain Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS
	 * @generated
	 */
	EClass getDomainPatternCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS#getTemplate()
	 * @see #getDomainPatternCS()
	 * @generated
	 */
	EReference getDomainPatternCS_Template();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS <em>Element Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS
	 * @generated
	 */
	EClass getElementTemplateCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS <em>Key Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Decl CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS
	 * @generated
	 */
	EClass getKeyDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPathName()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_PathName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPropertyIds <em>Property Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPropertyIds()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_PropertyIds();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getClassId <em>Class Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getClassId()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_ClassId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS <em>Model Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Decl CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS
	 * @generated
	 */
	EClass getModelDeclCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS#getMetaModelIds <em>Meta Model Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Meta Model Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS#getMetaModelIds()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_MetaModelIds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS <em>Object Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS
	 * @generated
	 */
	EClass getObjectTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplates <em>Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Templates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplates()
	 * @see #getObjectTemplateCS()
	 * @generated
	 */
	EReference getObjectTemplateCS_PropertyTemplates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS#getPredicates()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_Predicates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS <em>Predicate CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS
	 * @generated
	 */
	EClass getPredicateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS#getExpr()
	 * @see #getPredicateCS()
	 * @generated
	 */
	EReference getPredicateCS_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS <em>Primitive Type Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS
	 * @generated
	 */
	EClass getPrimitiveTypeDomainCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS <em>Property Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS
	 * @generated
	 */
	EClass getPropertyTemplateCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate <em>Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Object Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getObjectTemplate()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_ObjectTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getPropertyId()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_PropertyId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getExpression()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#isOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#isOpposite()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EAttribute getPropertyTemplateCS_Opposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getInputParamDeclarations <em>Input Param Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declarations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getInputParamDeclarations()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS <em>Relation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS
	 * @generated
	 */
	EClass getRelationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#isTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#isTop()
	 * @see #getRelationCS()
	 * @generated
	 */
	EAttribute getRelationCS_Top();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overrides</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getOverrides()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Overrides();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getVarDeclarations <em>Var Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declarations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getVarDeclarations()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_VarDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getDomains()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Domains();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getWhen()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_When();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getWhere()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Where();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS <em>Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS
	 * @generated
	 */
	EClass getTemplateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS#getGuardExpression <em>Guard Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS#getGuardExpression()
	 * @see #getTemplateCS()
	 * @generated
	 */
	EReference getTemplateCS_GuardExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS <em>Template Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS
	 * @generated
	 */
	EClass getTemplateVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS#getType()
	 * @see #getTemplateVariableCS()
	 * @generated
	 */
	EReference getTemplateVariableCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getImportClauses <em>Import Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Clauses</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getImportClauses()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_ImportClauses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getTransformations <em>Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getModelDecls <em>Model Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Decls</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getModelDecls()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_ModelDecls();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getExtends()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getKeyDecls <em>Key Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Decls</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getKeyDecls()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_KeyDecls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getQueries()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Queries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getRelation()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Relation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS
	 * @generated
	 */
	EClass getUnitCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identifier</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS#getIdentifier()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS <em>Var Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS
	 * @generated
	 */
	EClass getVarDeclarationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getVarDeclarationIds <em>Var Declaration Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getVarDeclarationIds()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_VarDeclarationIds();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getType()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS <em>Var Declaration Id CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration Id CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS
	 * @generated
	 */
	EClass getVarDeclarationIdCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTrelationCSTFactory getQVTrelationCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.AbstractDomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getAbstractDomainCS()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_CS = eINSTANCE.getAbstractDomainCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.CollectionTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getCollectionTemplateCS()
		 * @generated
		 */
		EClass COLLECTION_TEMPLATE_CS = eINSTANCE.getCollectionTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Member Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS = eINSTANCE.getCollectionTemplateCS_MemberIdentifiers();

		/**
		 * The meta object literal for the '<em><b>Rest Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__REST_IDENTIFIER = eINSTANCE.getCollectionTemplateCS_RestIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DefaultValueCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDefaultValueCS()
		 * @generated
		 */
		EClass DEFAULT_VALUE_CS = eINSTANCE.getDefaultValueCS();

		/**
		 * The meta object literal for the '<em><b>Initialiser</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__INITIALISER = eINSTANCE.getDefaultValueCS_Initialiser();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__PROPERTY_ID = eINSTANCE.getDefaultValueCS_PropertyId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Checkonly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__CHECKONLY = eINSTANCE.getDomainCS_Checkonly();

		/**
		 * The meta object literal for the '<em><b>Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__ENFORCE = eINSTANCE.getDomainCS_Enforce();

		/**
		 * The meta object literal for the '<em><b>Model Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__MODEL_ID = eINSTANCE.getDomainCS_ModelId();

		/**
		 * The meta object literal for the '<em><b>Replace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__REPLACE = eINSTANCE.getDomainCS_Replace();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__PATTERN = eINSTANCE.getDomainCS_Pattern();

		/**
		 * The meta object literal for the '<em><b>Default Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__DEFAULT_VALUES = eINSTANCE.getDomainCS_DefaultValues();

		/**
		 * The meta object literal for the '<em><b>Implemented By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__IMPLEMENTED_BY = eINSTANCE.getDomainCS_ImplementedBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainPatternCSImpl <em>Domain Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDomainPatternCS()
		 * @generated
		 */
		EClass DOMAIN_PATTERN_CS = eINSTANCE.getDomainPatternCS();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN_CS__TEMPLATE = eINSTANCE.getDomainPatternCS_Template();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ElementTemplateCSImpl <em>Element Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ElementTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getElementTemplateCS()
		 * @generated
		 */
		EClass ELEMENT_TEMPLATE_CS = eINSTANCE.getElementTemplateCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getKeyDeclCS()
		 * @generated
		 */
		EClass KEY_DECL_CS = eINSTANCE.getKeyDeclCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__PATH_NAME = eINSTANCE.getKeyDeclCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Property Ids</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__PROPERTY_IDS = eINSTANCE.getKeyDeclCS_PropertyIds();

		/**
		 * The meta object literal for the '<em><b>Class Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__CLASS_ID = eINSTANCE.getKeyDeclCS_ClassId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getModelDeclCS()
		 * @generated
		 */
		EClass MODEL_DECL_CS = eINSTANCE.getModelDeclCS();

		/**
		 * The meta object literal for the '<em><b>Meta Model Ids</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__META_MODEL_IDS = eINSTANCE.getModelDeclCS_MetaModelIds();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ObjectTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getObjectTemplateCS()
		 * @generated
		 */
		EClass OBJECT_TEMPLATE_CS = eINSTANCE.getObjectTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Property Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES = eINSTANCE.getObjectTemplateCS_PropertyTemplates();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPatternCS()
		 * @generated
		 */
		EClass PATTERN_CS = eINSTANCE.getPatternCS();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__PREDICATES = eINSTANCE.getPatternCS_Predicates();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PredicateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPredicateCS()
		 * @generated
		 */
		EClass PREDICATE_CS = eINSTANCE.getPredicateCS();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_CS__EXPR = eINSTANCE.getPredicateCS_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPrimitiveTypeDomainCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_DOMAIN_CS = eINSTANCE.getPrimitiveTypeDomainCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPropertyTemplateCS()
		 * @generated
		 */
		EClass PROPERTY_TEMPLATE_CS = eINSTANCE.getPropertyTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Object Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE = eINSTANCE.getPropertyTemplateCS_ObjectTemplate();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__PROPERTY_ID = eINSTANCE.getPropertyTemplateCS_PropertyId();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__EXPRESSION = eINSTANCE.getPropertyTemplateCS_Expression();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TEMPLATE_CS__OPPOSITE = eINSTANCE.getPropertyTemplateCS_Opposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Input Param Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__INPUT_PARAM_DECLARATIONS = eINSTANCE.getQueryCS_InputParamDeclarations();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__EXPRESSION = eINSTANCE.getQueryCS_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl <em>Relation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getRelationCS()
		 * @generated
		 */
		EClass RELATION_CS = eINSTANCE.getRelationCS();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CS__TOP = eINSTANCE.getRelationCS_Top();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OVERRIDES = eINSTANCE.getRelationCS_Overrides();

		/**
		 * The meta object literal for the '<em><b>Var Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__VAR_DECLARATIONS = eINSTANCE.getRelationCS_VarDeclarations();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__DOMAINS = eINSTANCE.getRelationCS_Domains();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__WHEN = eINSTANCE.getRelationCS_When();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__WHERE = eINSTANCE.getRelationCS_Where();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl <em>Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateCS()
		 * @generated
		 */
		EClass TEMPLATE_CS = eINSTANCE.getTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_CS__GUARD_EXPRESSION = eINSTANCE.getTemplateCS_GuardExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateVariableCS()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE_CS = eINSTANCE.getTemplateVariableCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_VARIABLE_CS__TYPE = eINSTANCE.getTemplateVariableCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Import Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__IMPORT_CLAUSES = eINSTANCE.getTopLevelCS_ImportClauses();

		/**
		 * The meta object literal for the '<em><b>Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__TRANSFORMATIONS = eINSTANCE.getTopLevelCS_Transformations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Model Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__MODEL_DECLS = eINSTANCE.getTransformationCS_ModelDecls();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__EXTENDS = eINSTANCE.getTransformationCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Key Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__KEY_DECLS = eINSTANCE.getTransformationCS_KeyDecls();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__QUERIES = eINSTANCE.getTransformationCS_Queries();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__RELATION = eINSTANCE.getTransformationCS_Relation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl <em>Unit CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getUnitCS()
		 * @generated
		 */
		EClass UNIT_CS = eINSTANCE.getUnitCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__IDENTIFIER = eINSTANCE.getUnitCS_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getVarDeclarationCS()
		 * @generated
		 */
		EClass VAR_DECLARATION_CS = eINSTANCE.getVarDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Var Declaration Ids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__VAR_DECLARATION_IDS = eINSTANCE.getVarDeclarationCS_VarDeclarationIds();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__TYPE = eINSTANCE.getVarDeclarationCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationIdCSImpl <em>Var Declaration Id CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationIdCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getVarDeclarationIdCS()
		 * @generated
		 */
		EClass VAR_DECLARATION_ID_CS = eINSTANCE.getVarDeclarationIdCS();

	}

} //QVTrelationCSTPackage
