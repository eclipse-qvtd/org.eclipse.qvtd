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
 * $Id: QVTrCSTPackage.java,v 1.6 2008/11/28 17:22:53 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage;

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
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTFactory
 * @model kind="package"
 * @generated
 */
public interface QVTrCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/QVTRelationcst";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtrcst";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTrCSTPackage eINSTANCE = org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.AbstractDomainCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getAbstractDomainCS()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_CS = 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The number of structural features of the '<em>Abstract Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateVariableCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTemplateVariableCS()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_CS = 13;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__START_OFFSET = QVTCSTPackage.IDENTIFIED_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__END_OFFSET = QVTCSTPackage.IDENTIFIED_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__START_TOKEN = QVTCSTPackage.IDENTIFIED_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__END_TOKEN = QVTCSTPackage.IDENTIFIED_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__AST = QVTCSTPackage.IDENTIFIED_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__IDENTIFIER = QVTCSTPackage.IDENTIFIED_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__AST_NODE = QVTCSTPackage.IDENTIFIED_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS__TYPE = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_CS_FEATURE_COUNT = QVTCSTPackage.IDENTIFIED_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateCSImpl <em>Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTemplateCS()
	 * @generated
	 */
	int TEMPLATE_CS = 12;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__START_OFFSET = TEMPLATE_VARIABLE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__END_OFFSET = TEMPLATE_VARIABLE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__START_TOKEN = TEMPLATE_VARIABLE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__END_TOKEN = TEMPLATE_VARIABLE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__AST = TEMPLATE_VARIABLE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__IDENTIFIER = TEMPLATE_VARIABLE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__AST_NODE = TEMPLATE_VARIABLE_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__TYPE = TEMPLATE_VARIABLE_CS__TYPE;

	/**
	 * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS__GUARD_EXPRESSION = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_VARIABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getCollectionTemplateCS()
	 * @generated
	 */
	int COLLECTION_TEMPLATE_CS = 1;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__START_OFFSET = TEMPLATE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__END_OFFSET = TEMPLATE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__START_TOKEN = TEMPLATE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__END_TOKEN = TEMPLATE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__AST = TEMPLATE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__IDENTIFIER = TEMPLATE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__AST_NODE = TEMPLATE_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

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
	 * The feature id for the '<em><b>Referred Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE = TEMPLATE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rest Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS__REST_IDENTIFIER = TEMPLATE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getDefaultValueCS()
	 * @generated
	 */
	int DEFAULT_VALUE_CS = 2;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialiser</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS__INITIALISER = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Default Value CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 3;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__START_OFFSET = ABSTRACT_DOMAIN_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__END_OFFSET = ABSTRACT_DOMAIN_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__START_TOKEN = ABSTRACT_DOMAIN_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__END_TOKEN = ABSTRACT_DOMAIN_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CS__AST = ABSTRACT_DOMAIN_CS__AST;

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
	 * The feature id for the '<em><b>Model Id</b></em>' containment reference.
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
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.UnitCSImpl <em>Unit CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.UnitCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getUnitCS()
	 * @generated
	 */
	int UNIT_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getKeyDeclCS()
	 * @generated
	 */
	int KEY_DECL_CS = 4;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Class Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__CLASS_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS__PROPERTY_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Key Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECL_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getModelDeclCS()
	 * @generated
	 */
	int MODEL_DECL_CS = 5;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Model Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__MODEL_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Meta Model Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS__META_MODEL_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Decl CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECL_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getObjectTemplateCS()
	 * @generated
	 */
	int OBJECT_TEMPLATE_CS = 6;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__START_OFFSET = TEMPLATE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__END_OFFSET = TEMPLATE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__START_TOKEN = TEMPLATE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__END_TOKEN = TEMPLATE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__AST = TEMPLATE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__IDENTIFIER = TEMPLATE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__AST_NODE = TEMPLATE_CS__AST_NODE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__TYPE = TEMPLATE_CS__TYPE;

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
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS__REFERRED_CLASS = TEMPLATE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_CS_FEATURE_COUNT = TEMPLATE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 7;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS__TYPE = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Param Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_DECLARATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PrimitiveTypeDomainCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getPrimitiveTypeDomainCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS = 8;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__START_OFFSET = TEMPLATE_VARIABLE_CS__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__END_OFFSET = TEMPLATE_VARIABLE_CS__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__START_TOKEN = TEMPLATE_VARIABLE_CS__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__END_TOKEN = TEMPLATE_VARIABLE_CS__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__AST = TEMPLATE_VARIABLE_CS__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__IDENTIFIER = TEMPLATE_VARIABLE_CS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Ast Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS__AST_NODE = TEMPLATE_VARIABLE_CS__AST_NODE;

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
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getPropertyTemplateCS()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_CS = 9;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Property Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__PROPERTY_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OCL_EXPRESSION = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS__OPPOSITE = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QueryCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 10;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__PATH_NAME = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Param Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__INPUT_PARAM_DECLARATION = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__OCL_EXPRESSION = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS__TYPE = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl <em>Relation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getRelationCS()
	 * @generated
	 */
	int RELATION_CS = 11;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__TOP = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__OVERRIDES = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Var Declaration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__VAR_DECLARATION = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__DOMAIN = CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__WHEN = CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS__WHERE = CSTPackage.CST_NODE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Relation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 14;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Import Clause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__IMPORT_CLAUSE = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS__TRANSFORMATION = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Top Level CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 15;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Model Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__MODEL_DECL = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__EXTENDS = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Key Decl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__KEY_DECL = CSTPackage.CST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__QUERY = CSTPackage.CST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS__RELATION = CSTPackage.CST_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS__IDENTIFIER = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.VarDeclarationCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getVarDeclarationCS()
	 * @generated
	 */
	int VAR_DECLARATION_CS = 17;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Var Declaration Id</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__VAR_DECLARATION_ID = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS__TYPE = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Var Declaration CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECLARATION_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhenCSImpl <em>When CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhenCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getWhenCS()
	 * @generated
	 */
	int WHEN_CS = 18;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS__EXPR = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>When CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHEN_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhereCSImpl <em>Where CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhereCSImpl
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getWhereCS()
	 * @generated
	 */
	int WHERE_CS = 19;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__START_OFFSET = CSTPackage.CST_NODE__START_OFFSET;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__END_OFFSET = CSTPackage.CST_NODE__END_OFFSET;

	/**
	 * The feature id for the '<em><b>Start Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__START_TOKEN = CSTPackage.CST_NODE__START_TOKEN;

	/**
	 * The feature id for the '<em><b>End Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__END_TOKEN = CSTPackage.CST_NODE__END_TOKEN;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__AST = CSTPackage.CST_NODE__AST;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS__EXPR = CSTPackage.CST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Where CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHERE_CS_FEATURE_COUNT = CSTPackage.CST_NODE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS <em>Abstract Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS
	 * @generated
	 */
	EClass getAbstractDomainCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS <em>Collection Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Template CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS
	 * @generated
	 */
	EClass getCollectionTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getMemberIdentifier <em>Member Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getMemberIdentifier()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_MemberIdentifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getReferredCollectionType <em>Referred Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Collection Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getReferredCollectionType()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_ReferredCollectionType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getRestIdentifier <em>Rest Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rest Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getRestIdentifier()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_RestIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS <em>Default Value CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Value CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS
	 * @generated
	 */
	EClass getDefaultValueCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS#getIdentifier()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS#getInitialiser <em>Initialiser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialiser</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS#getInitialiser()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_Initialiser();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isCheckonly <em>Checkonly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkonly</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isCheckonly()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Checkonly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Enforce();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getModelId()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_ModelId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isReplace <em>Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replace</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#isReplace()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_Replace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getTemplate()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_Template();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Value</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getDefaultValue()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_DefaultValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getImplementedBy <em>Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implemented By</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS#getImplementedBy()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_ImplementedBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS
	 * @generated
	 */
	EClass getUnitCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS#getIdentifier()
	 * @see #getUnitCS()
	 * @generated
	 */
	EReference getUnitCS_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS <em>Key Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Decl CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS
	 * @generated
	 */
	EClass getKeyDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getClassId <em>Class Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Class Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getClassId()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_ClassId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS#getPropertyId()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_PropertyId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS <em>Model Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Decl CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS
	 * @generated
	 */
	EClass getModelDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS#getModelId()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_ModelId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS#getMetaModelId <em>Meta Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Model Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS#getMetaModelId()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_MetaModelId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS <em>Object Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS
	 * @generated
	 */
	EClass getObjectTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS#getPropertyTemplate <em>Property Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Template</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS#getPropertyTemplate()
	 * @see #getObjectTemplateCS()
	 * @generated
	 */
	EReference getObjectTemplateCS_PropertyTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS#getReferredClass()
	 * @see #getObjectTemplateCS()
	 * @generated
	 */
	EReference getObjectTemplateCS_ReferredClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS#getIdentifier()
	 * @see #getParamDeclarationCS()
	 * @generated
	 */
	EReference getParamDeclarationCS_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS#getType()
	 * @see #getParamDeclarationCS()
	 * @generated
	 */
	EReference getParamDeclarationCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS <em>Primitive Type Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Domain CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS
	 * @generated
	 */
	EClass getPrimitiveTypeDomainCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS <em>Property Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS
	 * @generated
	 */
	EClass getPropertyTemplateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getPropertyId()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_PropertyId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getOclExpression()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_OclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#getReferredProperty()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_ReferredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#isOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS#isOpposite()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EAttribute getPropertyTemplateCS_Opposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getPathName()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_PathName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getInputParamDeclaration <em>Input Param Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Param Declaration</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getInputParamDeclaration()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_InputParamDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ocl Expression</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getOclExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OclExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS#getType()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS <em>Relation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS
	 * @generated
	 */
	EClass getRelationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#isTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#isTop()
	 * @see #getRelationCS()
	 * @generated
	 */
	EAttribute getRelationCS_Top();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getIdentifier()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Overrides</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getOverrides()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Overrides();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getVarDeclaration <em>Var Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getVarDeclaration()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_VarDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getDomain()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Domain();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getWhen()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_When();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS#getWhere()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Where();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS <em>Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS
	 * @generated
	 */
	EClass getTemplateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS#getGuardExpression <em>Guard Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Expression</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS#getGuardExpression()
	 * @see #getTemplateCS()
	 * @generated
	 */
	EReference getTemplateCS_GuardExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS <em>Template Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS
	 * @generated
	 */
	EClass getTemplateVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS#getType()
	 * @see #getTemplateVariableCS()
	 * @generated
	 */
	EReference getTemplateVariableCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS#getImportClause <em>Import Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Clause</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS#getImportClause()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_ImportClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS#getTransformation()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_Transformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getModelDecl <em>Model Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Decl</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getModelDecl()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_ModelDecl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getExtends()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getIdentifier()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getKeyDecl <em>Key Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Decl</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getKeyDecl()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_KeyDecl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Query</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getQuery()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Query();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relation</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS#getRelation()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Relation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS <em>Var Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS
	 * @generated
	 */
	EClass getVarDeclarationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getVarDeclarationId <em>Var Declaration Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Declaration Id</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getVarDeclarationId()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_VarDeclarationId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS#getType()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS <em>When CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>When CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS
	 * @generated
	 */
	EClass getWhenCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS#getExpr()
	 * @see #getWhenCS()
	 * @generated
	 */
	EReference getWhenCS_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS <em>Where CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Where CS</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS
	 * @generated
	 */
	EClass getWhereCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expr</em>'.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS#getExpr()
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
	QVTrCSTFactory getQVTrCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.AbstractDomainCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getAbstractDomainCS()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_CS = eINSTANCE.getAbstractDomainCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.CollectionTemplateCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getCollectionTemplateCS()
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
		 * The meta object literal for the '<em><b>Referred Collection Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE = eINSTANCE.getCollectionTemplateCS_ReferredCollectionType();

		/**
		 * The meta object literal for the '<em><b>Rest Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__REST_IDENTIFIER = eINSTANCE.getCollectionTemplateCS_RestIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DefaultValueCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getDefaultValueCS()
		 * @generated
		 */
		EClass DEFAULT_VALUE_CS = eINSTANCE.getDefaultValueCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__IDENTIFIER = eINSTANCE.getDefaultValueCS_Identifier();

		/**
		 * The meta object literal for the '<em><b>Initialiser</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__INITIALISER = eINSTANCE.getDefaultValueCS_Initialiser();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getDomainCS()
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
		 * The meta object literal for the '<em><b>Model Id</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.UnitCSImpl <em>Unit CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.UnitCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getUnitCS()
		 * @generated
		 */
		EClass UNIT_CS = eINSTANCE.getUnitCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CS__IDENTIFIER = eINSTANCE.getUnitCS_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.KeyDeclCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getKeyDeclCS()
		 * @generated
		 */
		EClass KEY_DECL_CS = eINSTANCE.getKeyDeclCS();

		/**
		 * The meta object literal for the '<em><b>Class Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__CLASS_ID = eINSTANCE.getKeyDeclCS_ClassId();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__PROPERTY_ID = eINSTANCE.getKeyDeclCS_PropertyId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ModelDeclCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getModelDeclCS()
		 * @generated
		 */
		EClass MODEL_DECL_CS = eINSTANCE.getModelDeclCS();

		/**
		 * The meta object literal for the '<em><b>Model Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__MODEL_ID = eINSTANCE.getModelDeclCS_ModelId();

		/**
		 * The meta object literal for the '<em><b>Meta Model Id</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__META_MODEL_ID = eINSTANCE.getModelDeclCS_MetaModelId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getObjectTemplateCS()
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
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_CS__REFERRED_CLASS = eINSTANCE.getObjectTemplateCS_ReferredClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_DECLARATION_CS__IDENTIFIER = eINSTANCE.getParamDeclarationCS_Identifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_DECLARATION_CS__TYPE = eINSTANCE.getParamDeclarationCS_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PrimitiveTypeDomainCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getPrimitiveTypeDomainCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_DOMAIN_CS = eINSTANCE.getPrimitiveTypeDomainCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.PropertyTemplateCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getPropertyTemplateCS()
		 * @generated
		 */
		EClass PROPERTY_TEMPLATE_CS = eINSTANCE.getPropertyTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' containment reference feature.
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
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY = eINSTANCE.getPropertyTemplateCS_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TEMPLATE_CS__OPPOSITE = eINSTANCE.getPropertyTemplateCS_Opposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QueryCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getQueryCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl <em>Relation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getRelationCS()
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
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__IDENTIFIER = eINSTANCE.getRelationCS_Identifier();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' containment reference feature.
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateCSImpl <em>Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTemplateCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateVariableCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTemplateVariableCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TopLevelCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTopLevelCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TransformationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getTransformationCS()
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
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__EXTENDS = eINSTANCE.getTransformationCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__IDENTIFIER = eINSTANCE.getTransformationCS_Identifier();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.VarDeclarationCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getVarDeclarationCS()
		 * @generated
		 */
		EClass VAR_DECLARATION_CS = eINSTANCE.getVarDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Var Declaration Id</b></em>' containment reference list feature.
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhenCSImpl <em>When CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhenCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getWhenCS()
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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhereCSImpl <em>Where CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.WhereCSImpl
		 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.QVTrCSTPackageImpl#getWhereCS()
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

} //EqvtrCSTPackage
