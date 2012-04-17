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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.AnyElementCSImpl <em>Any Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.AnyElementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getAnyElementCS()
	 * @generated
	 */
	int ANY_ELEMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__LOGICAL_PARENT = EssentialOCLCSTPackage.EXP_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__PIVOT = EssentialOCLCSTPackage.EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__OWNED_ANNOTATION = EssentialOCLCSTPackage.EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__ORIGINAL_XMI_ID = EssentialOCLCSTPackage.EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__CSI = EssentialOCLCSTPackage.EXP_CS__CSI;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS__PARENT = EssentialOCLCSTPackage.EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Any Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ELEMENT_CS_FEATURE_COUNT = EssentialOCLCSTPackage.EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateVariableCS()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_CS = 14;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__TYPE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__PROPERTY_ID = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl <em>Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTemplateCS()
	 * @generated
	 */
	int TEMPLATE_CS = 13;

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
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__PROPERTY_ID = TEMPLATE_VARIABLE_CS__PROPERTY_ID;

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
	int COLLECTION_TEMPLATE_CS = 2;

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
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__PROPERTY_ID = TEMPLATE_CS__PROPERTY_ID;

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
	 * The feature id for the '<em><b>Member Identifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER = TEMPLATE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rest Identifier</b></em>' containment reference.
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
	int DEFAULT_VALUE_CS = 3;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__INITIALISER = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__PROPERTY_ID = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Default Value CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getDomainCS()
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
	 * The feature id for the '<em><b>Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__TEMPLATE = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__DEFAULT_VALUE = ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.KeyDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getKeyDeclCS()
	 * @generated
	 */
	int KEY_DECL_CS = 5;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PATH_NAME = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PROPERTY_ID = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__CLASS_ID = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Key Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.ModelDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getModelDeclCS()
	 * @generated
	 */
	int MODEL_DECL_CS = 6;

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
	 * The feature id for the '<em><b>Meta Model Id</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__META_MODEL_ID = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

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
	int OBJECT_TEMPLATE_CS = 7;

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
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__PROPERTY_ID = TEMPLATE_CS__PROPERTY_ID;

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
	 * The feature id for the '<em><b>Property Template</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE = TEMPLATE_CS_FEATURE_COUNT + 0;

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
	int PARAM_DECLARATION_CS = 8;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__TYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PrimitiveTypeDomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPrimitiveTypeDomainCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS = 9;

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
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__PROPERTY_ID = TEMPLATE_VARIABLE_CS__PROPERTY_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__NAME = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS_FEATURE_COUNT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.PropertyTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getPropertyTemplateCS()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_CS = 10;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__PROPERTY_ID = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OCL_EXPRESSION = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OPPOSITE = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 11;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__LOGICAL_PARENT = BaseCSTPackage.MODEL_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__CSI = BaseCSTPackage.MODEL_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PATH_NAME = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATION = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OCL_EXPRESSION = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TYPE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl <em>Relation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getRelationCS()
	 * @generated
	 */
	int RELATION_CS = 12;

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
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__VAR_DECLARATION = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__DOMAIN = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

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
	int TOP_LEVEL_CS = 15;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Import Clause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__IMPORT_CLAUSE = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATION = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 16;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__LOGICAL_PARENT = BaseCSTPackage.NAMED_ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Csi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__CSI = BaseCSTPackage.NAMED_ELEMENT_CS__CSI;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Model Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__MODEL_DECL = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__EXTENDS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__KEY_DECL = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUERY = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__RELATION = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.UnitCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 17;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IDENTIFIER = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.VarDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getVarDeclarationCS()
	 * @generated
	 */
	int VAR_DECLARATION_CS = 18;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Var Declaration Id</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__VAR_DECLARATION_ID = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__TYPE = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Var Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhenCSImpl <em>When CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhenCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getWhenCS()
	 * @generated
	 */
	int WHEN_CS = 19;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__EXPR = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>When CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhereCSImpl <em>Where CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhereCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getWhereCS()
	 * @generated
	 */
	int WHERE_CS = 20;

	/**
	 * The feature id for the '<em><b>Logical Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__LOGICAL_PARENT = BaseCSTPackage.ELEMENT_CS__LOGICAL_PARENT;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__EXPR = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Where CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.AnyElementCS <em>Any Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Element CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.AnyElementCS
	 * @generated
	 */
	EClass getAnyElementCS();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getMemberIdentifier <em>Member Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Identifier</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getMemberIdentifier()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_MemberIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS#getRestIdentifier <em>Rest Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rest Identifier</em>'.
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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getTemplate()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Template();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Value</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS#getDefaultValue()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_DefaultValue();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS#getPropertyId()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_PropertyId();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS#getMetaModelId <em>Meta Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Meta Model Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS#getMetaModelId()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_MetaModelId();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplate <em>Property Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS#getPropertyTemplate()
	 * @see #getObjectTemplateCS()
	 * @generated
	 */
	EReference getObjectTemplateCS_PropertyTemplate();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS#getType()
	 * @see #getParamDeclarationCS()
	 * @generated
	 */
	EReference getParamDeclarationCS_Type();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS#getName()
	 * @see #getPrimitiveTypeDomainCS()
	 * @generated
	 */
	EAttribute getPrimitiveTypeDomainCS_Name();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS#getOclExpression()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_OclExpression();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_PathName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declaration</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getInputParamDeclaration()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getOclExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OclExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS#getType()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Type();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getVarDeclaration()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS#getDomain()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Domain();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS#getPropertyId()
	 * @see #getTemplateVariableCS()
	 * @generated
	 */
	EReference getTemplateVariableCS_PropertyId();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getImportClause <em>Import Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Clause</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getImportClause()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_ImportClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS#getTransformation()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformation();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getModelDecl <em>Model Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Decl</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getModelDecl()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_ModelDecl();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getKeyDecl <em>Key Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Decl</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getKeyDecl()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_KeyDecl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Query</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS#getQuery()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Query();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getVarDeclarationId <em>Var Declaration Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Var Declaration Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS#getVarDeclarationId()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_VarDeclarationId();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.WhenCS <em>When CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>When CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.WhenCS
	 * @generated
	 */
	EClass getWhenCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.WhenCS#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.WhenCS#getExpr()
	 * @see #getWhenCS()
	 * @generated
	 */
	EReference getWhenCS_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcst.WhereCS <em>Where CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Where CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.WhereCS
	 * @generated
	 */
	EClass getWhereCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcst.WhereCS#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.WhereCS#getExpr()
	 * @see #getWhereCS()
	 * @generated
	 */
	EReference getWhereCS_Expr();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.AnyElementCSImpl <em>Any Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.AnyElementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getAnyElementCS()
		 * @generated
		 */
		EClass ANY_ELEMENT_CS = eINSTANCE.getAnyElementCS();

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
		 * The meta object literal for the '<em><b>Member Identifier</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER = eINSTANCE.getCollectionTemplateCS_MemberIdentifier();

		/**
		 * The meta object literal for the '<em><b>Rest Identifier</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__TEMPLATE = eINSTANCE.getDomainCS_Template();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__DEFAULT_VALUE = eINSTANCE.getDomainCS_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Implemented By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__IMPLEMENTED_BY = eINSTANCE.getDomainCS_ImplementedBy();

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
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__PROPERTY_ID = eINSTANCE.getKeyDeclCS_PropertyId();

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
		 * The meta object literal for the '<em><b>Meta Model Id</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__META_MODEL_ID = eINSTANCE.getModelDeclCS_MetaModelId();

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
		 * The meta object literal for the '<em><b>Property Template</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE = eINSTANCE.getObjectTemplateCS_PropertyTemplate();

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
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_DECLARATION_CS__TYPE = eINSTANCE.getParamDeclarationCS_Type();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_DOMAIN_CS__NAME = eINSTANCE.getPrimitiveTypeDomainCS_Name();

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
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__PROPERTY_ID = eINSTANCE.getPropertyTemplateCS_PropertyId();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__OCL_EXPRESSION = eINSTANCE.getPropertyTemplateCS_OclExpression();

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
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__PATH_NAME = eINSTANCE.getQueryCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Input Param Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__INPUT_PARAM_DECLARATION = eINSTANCE.getQueryCS_InputParamDeclaration();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OCL_EXPRESSION = eINSTANCE.getQueryCS_OclExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__TYPE = eINSTANCE.getQueryCS_Type();

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
		 * The meta object literal for the '<em><b>Var Declaration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__VAR_DECLARATION = eINSTANCE.getRelationCS_VarDeclaration();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__DOMAIN = eINSTANCE.getRelationCS_Domain();

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
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_VARIABLE_CS__PROPERTY_ID = eINSTANCE.getTemplateVariableCS_PropertyId();

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
		 * The meta object literal for the '<em><b>Import Clause</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__IMPORT_CLAUSE = eINSTANCE.getTopLevelCS_ImportClause();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__TRANSFORMATION = eINSTANCE.getTopLevelCS_Transformation();

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
		 * The meta object literal for the '<em><b>Model Decl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__MODEL_DECL = eINSTANCE.getTransformationCS_ModelDecl();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__EXTENDS = eINSTANCE.getTransformationCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Key Decl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__KEY_DECL = eINSTANCE.getTransformationCS_KeyDecl();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__QUERY = eINSTANCE.getTransformationCS_Query();

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
		 * The meta object literal for the '<em><b>Var Declaration Id</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__VAR_DECLARATION_ID = eINSTANCE.getVarDeclarationCS_VarDeclarationId();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__TYPE = eINSTANCE.getVarDeclarationCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhenCSImpl <em>When CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhenCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getWhenCS()
		 * @generated
		 */
		EClass WHEN_CS = eINSTANCE.getWhenCS();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHEN_CS__EXPR = eINSTANCE.getWhenCS_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhereCSImpl <em>Where CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.WhereCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTPackageImpl#getWhereCS()
		 * @generated
		 */
		EClass WHERE_CS = eINSTANCE.getWhereCS();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHERE_CS__EXPR = eINSTANCE.getWhereCS_Expr();

	}

} //QVTrelationCSTPackage
