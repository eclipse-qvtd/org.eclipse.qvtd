/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSFactory
 * @model kind="package"
 * @generated
 */
public interface QVTrelationCSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtrelationcs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTrelationCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtrcs";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.xtext.qvtrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTrelationCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.AbstractDomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getAbstractDomainCS()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateVariableCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTemplateVariableCS()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl <em>Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTemplateCS()
	 * @generated
	 */
	int TEMPLATE_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getCollectionTemplateCS()
	 * @generated
	 */
	int COLLECTION_TEMPLATE_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DefaultValueCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDefaultValueCS()
	 * @generated
	 */
	int DEFAULT_VALUE_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl <em>Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDomainCS()
	 * @generated
	 */
	int DOMAIN_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainPatternCSImpl <em>Domain Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDomainPatternCS()
	 * @generated
	 */
	int DOMAIN_PATTERN_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ElementTemplateCSImpl <em>Element Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ElementTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getElementTemplateCS()
	 * @generated
	 */
	int ELEMENT_TEMPLATE_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getKeyDeclCS()
	 * @generated
	 */
	int KEY_DECL_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ModelDeclCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getModelDeclCS()
	 * @generated
	 */
	int MODEL_DECL_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ObjectTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getObjectTemplateCS()
	 * @generated
	 */
	int OBJECT_TEMPLATE_CS = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ParamDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getParamDeclarationCS()
	 * @generated
	 */
	int PARAM_DECLARATION_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPatternCS()
	 * @generated
	 */
	int PATTERN_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PredicateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPredicateCS()
	 * @generated
	 */
	int PREDICATE_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPrimitiveTypeDomainCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DOMAIN_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPropertyTemplateCS()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.QueryCSImpl <em>Query CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QueryCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getQueryCS()
	 * @generated
	 */
	int QUERY_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl <em>Relation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getRelationCS()
	 * @generated
	 */
	int RELATION_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTopLevelCS()
	 * @generated
	 */
	int TOP_LEVEL_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTransformationCS()
	 * @generated
	 */
	int TRANSFORMATION_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getVarDeclarationCS()
	 * @generated
	 */
	int VAR_DECLARATION_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationIdCSImpl <em>Var Declaration Id CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationIdCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getVarDeclarationIdCS()
	 * @generated
	 */
	int VAR_DECLARATION_ID_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainPatternCSImpl <em>Primitive Type Domain Pattern CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainPatternCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPrimitiveTypeDomainPatternCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DOMAIN_PATTERN_CS = 13;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS <em>Abstract Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS
	 * @generated
	 */
	EClass getAbstractDomainCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS <em>Collection Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS
	 * @generated
	 */
	EClass getCollectionTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedMemberIdentifiers <em>Owned Member Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Member Identifiers</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedMemberIdentifiers()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_OwnedMemberIdentifiers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedRestIdentifier <em>Owned Rest Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Rest Identifier</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedRestIdentifier()
	 * @see #getCollectionTemplateCS()
	 * @generated
	 */
	EReference getCollectionTemplateCS_OwnedRestIdentifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS <em>Default Value CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Value CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS
	 * @generated
	 */
	EClass getDefaultValueCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS#getOwnedInitExpression()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_OwnedInitExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS#getPropertyId()
	 * @see #getDefaultValueCS()
	 * @generated
	 */
	EReference getDefaultValueCS_PropertyId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS
	 * @generated
	 */
	EClass getDomainCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getImplementedBy <em>Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implemented By</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getImplementedBy()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_ImplementedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsCheckonly <em>Is Checkonly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checkonly</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsCheckonly()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsCheckonly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsEnforce <em>Is Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforce</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsEnforce()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsEnforce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getModelId()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_ModelId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsReplace <em>Is Replace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Replace</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#isIsReplace()
	 * @see #getDomainCS()
	 * @generated
	 */
	EAttribute getDomainCS_IsReplace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedPatterns <em>Owned Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Patterns</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedPatterns()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_OwnedPatterns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedDefaultValues <em>Owned Default Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Default Values</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedDefaultValues()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_OwnedDefaultValues();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedImplementedBy <em>Owned Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Implemented By</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS#getOwnedImplementedBy()
	 * @see #getDomainCS()
	 * @generated
	 */
	EReference getDomainCS_OwnedImplementedBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS <em>Domain Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS
	 * @generated
	 */
	EClass getDomainPatternCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS#getOwnedTemplate <em>Owned Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS#getOwnedTemplate()
	 * @see #getDomainPatternCS()
	 * @generated
	 */
	EReference getDomainPatternCS_OwnedTemplate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS <em>Element Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS
	 * @generated
	 */
	EClass getElementTemplateCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS#getIdentifier()
	 * @see #getElementTemplateCS()
	 * @generated
	 */
	EReference getElementTemplateCS_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS <em>Key Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Decl CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS
	 * @generated
	 */
	EClass getKeyDeclCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getOwnedPathName()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_OwnedPathName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getPropertyIds <em>Property Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getPropertyIds()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_PropertyIds();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getOwnedOppositePropertyIds <em>Owned Opposite Property Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Opposite Property Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getOwnedOppositePropertyIds()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_OwnedOppositePropertyIds();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getClassId <em>Class Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS#getClassId()
	 * @see #getKeyDeclCS()
	 * @generated
	 */
	EReference getKeyDeclCS_ClassId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS <em>Model Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Decl CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS
	 * @generated
	 */
	EClass getModelDeclCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getMetamodelIds <em>Metamodel Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metamodel Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getMetamodelIds()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_MetamodelIds();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS#getDependsOn()
	 * @see #getModelDeclCS()
	 * @generated
	 */
	EReference getModelDeclCS_DependsOn();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS <em>Object Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS
	 * @generated
	 */
	EClass getObjectTemplateCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS#getOwnedPropertyTemplates <em>Owned Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Templates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS#getOwnedPropertyTemplates()
	 * @see #getObjectTemplateCS()
	 * @generated
	 */
	EReference getObjectTemplateCS_OwnedPropertyTemplates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS
	 * @generated
	 */
	EClass getParamDeclarationCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS <em>Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS
	 * @generated
	 */
	EClass getPatternCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS#getOwnedPredicates <em>Owned Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Predicates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS#getOwnedPredicates()
	 * @see #getPatternCS()
	 * @generated
	 */
	EReference getPatternCS_OwnedPredicates();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS <em>Predicate CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS
	 * @generated
	 */
	EClass getPredicateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS#getOwnedCondition()
	 * @see #getPredicateCS()
	 * @generated
	 */
	EReference getPredicateCS_OwnedCondition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS <em>Primitive Type Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Domain CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS
	 * @generated
	 */
	EClass getPrimitiveTypeDomainCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS#getOwnedPatterns <em>Owned Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Patterns</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS#getOwnedPatterns()
	 * @see #getPrimitiveTypeDomainCS()
	 * @generated
	 */
	EReference getPrimitiveTypeDomainCS_OwnedPatterns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS <em>Property Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS
	 * @generated
	 */
	EClass getPropertyTemplateCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate <em>Owning Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Object Template</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwningObjectTemplate()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_OwningObjectTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getPropertyId <em>Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getPropertyId()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_PropertyId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedOppositePropertyId <em>Owned Opposite Property Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Opposite Property Id</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedOppositePropertyId()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_OwnedOppositePropertyId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS#getOwnedExpression()
	 * @see #getPropertyTemplateCS()
	 * @generated
	 */
	EReference getPropertyTemplateCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS
	 * @generated
	 */
	EClass getQueryCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#getOwnedParameters()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#getOwnedExpression()
	 * @see #getQueryCS()
	 * @generated
	 */
	EReference getQueryCS_OwnedExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#isIsTransient <em>Is Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transient</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS#isIsTransient()
	 * @see #getQueryCS()
	 * @generated
	 */
	EAttribute getQueryCS_IsTransient();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS <em>Relation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS
	 * @generated
	 */
	EClass getRelationCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsAbstract()
	 * @see #getRelationCS()
	 * @generated
	 */
	EAttribute getRelationCS_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsTop <em>Is Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#isIsTop()
	 * @see #getRelationCS()
	 * @generated
	 */
	EAttribute getRelationCS_IsTop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overridden</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOverridden()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_Overridden();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedVarDeclarations <em>Owned Var Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Var Declarations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedVarDeclarations()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_OwnedVarDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedDomains <em>Owned Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Domains</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedDomains()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_OwnedDomains();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhen <em>Owned When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned When</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhen()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_OwnedWhen();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhere <em>Owned Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Where</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS#getOwnedWhere()
	 * @see #getRelationCS()
	 * @generated
	 */
	EReference getRelationCS_OwnedWhere();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS <em>Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS
	 * @generated
	 */
	EClass getTemplateCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS#getOwnedGuardExpression <em>Owned Guard Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Guard Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS#getOwnedGuardExpression()
	 * @see #getTemplateCS()
	 * @generated
	 */
	EReference getTemplateCS_OwnedGuardExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS <em>Template Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS
	 * @generated
	 */
	EClass getTemplateVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS#getOwnedType()
	 * @see #getTemplateVariableCS()
	 * @generated
	 */
	EReference getTemplateVariableCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS
	 * @generated
	 */
	EClass getTopLevelCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS#getOwnedTransformations <em>Owned Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transformations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS#getOwnedTransformations()
	 * @see #getTopLevelCS()
	 * @generated
	 */
	EReference getTopLevelCS_OwnedTransformations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS
	 * @generated
	 */
	EClass getTransformationCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedModelDecls <em>Owned Model Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Model Decls</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedModelDecls()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedModelDecls();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getExtends()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedKeyDecls <em>Owned Key Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Key Decls</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedKeyDecls()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedKeyDecls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedQueries <em>Owned Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Queries</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedQueries()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedQueries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedRelations <em>Owned Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Relations</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS#getOwnedRelations()
	 * @see #getTransformationCS()
	 * @generated
	 */
	EReference getTransformationCS_OwnedRelations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS <em>Var Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS
	 * @generated
	 */
	EClass getVarDeclarationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedInitExpression <em>Owned Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Expression</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedInitExpression()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_OwnedInitExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedVarDeclarationIds <em>Owned Var Declaration Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Var Declaration Ids</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedVarDeclarationIds()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_OwnedVarDeclarationIds();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS#getOwnedType()
	 * @see #getVarDeclarationCS()
	 * @generated
	 */
	EReference getVarDeclarationCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS <em>Var Declaration Id CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Declaration Id CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS
	 * @generated
	 */
	EClass getVarDeclarationIdCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS <em>Primitive Type Domain Pattern CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Domain Pattern CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS
	 * @generated
	 */
	EClass getPrimitiveTypeDomainPatternCS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTrelationCSFactory getQVTrelationCSFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.AbstractDomainCSImpl <em>Abstract Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.AbstractDomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getAbstractDomainCS()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_CS = eINSTANCE.getAbstractDomainCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl <em>Collection Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.CollectionTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getCollectionTemplateCS()
		 * @generated
		 */
		EClass COLLECTION_TEMPLATE_CS = eINSTANCE.getCollectionTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Owned Member Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS = eINSTANCE.getCollectionTemplateCS_OwnedMemberIdentifiers();

		/**
		 * The meta object literal for the '<em><b>Owned Rest Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER = eINSTANCE.getCollectionTemplateCS_OwnedRestIdentifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DefaultValueCSImpl <em>Default Value CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DefaultValueCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDefaultValueCS()
		 * @generated
		 */
		EClass DEFAULT_VALUE_CS = eINSTANCE.getDefaultValueCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getDefaultValueCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_VALUE_CS__PROPERTY_ID = eINSTANCE.getDefaultValueCS_PropertyId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl <em>Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDomainCS()
		 * @generated
		 */
		EClass DOMAIN_CS = eINSTANCE.getDomainCS();

		/**
		 * The meta object literal for the '<em><b>Implemented By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IMPLEMENTED_BY = eINSTANCE.getDomainCS_ImplementedBy();

		/**
		 * The meta object literal for the '<em><b>Is Checkonly</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_CHECKONLY = eINSTANCE.getDomainCS_IsCheckonly();

		/**
		 * The meta object literal for the '<em><b>Is Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_ENFORCE = eINSTANCE.getDomainCS_IsEnforce();

		/**
		 * The meta object literal for the '<em><b>Model Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__MODEL_ID = eINSTANCE.getDomainCS_ModelId();

		/**
		 * The meta object literal for the '<em><b>Is Replace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_CS__IS_REPLACE = eINSTANCE.getDomainCS_IsReplace();

		/**
		 * The meta object literal for the '<em><b>Owned Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__OWNED_PATTERNS = eINSTANCE.getDomainCS_OwnedPatterns();

		/**
		 * The meta object literal for the '<em><b>Owned Default Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__OWNED_DEFAULT_VALUES = eINSTANCE.getDomainCS_OwnedDefaultValues();

		/**
		 * The meta object literal for the '<em><b>Owned Implemented By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_CS__OWNED_IMPLEMENTED_BY = eINSTANCE.getDomainCS_OwnedImplementedBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainPatternCSImpl <em>Domain Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getDomainPatternCS()
		 * @generated
		 */
		EClass DOMAIN_PATTERN_CS = eINSTANCE.getDomainPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Template</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN_CS__OWNED_TEMPLATE = eINSTANCE.getDomainPatternCS_OwnedTemplate();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ElementTemplateCSImpl <em>Element Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ElementTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getElementTemplateCS()
		 * @generated
		 */
		EClass ELEMENT_TEMPLATE_CS = eINSTANCE.getElementTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_TEMPLATE_CS__IDENTIFIER = eINSTANCE.getElementTemplateCS_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl <em>Key Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getKeyDeclCS()
		 * @generated
		 */
		EClass KEY_DECL_CS = eINSTANCE.getKeyDeclCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__OWNED_PATH_NAME = eINSTANCE.getKeyDeclCS_OwnedPathName();

		/**
		 * The meta object literal for the '<em><b>Property Ids</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__PROPERTY_IDS = eINSTANCE.getKeyDeclCS_PropertyIds();

		/**
		 * The meta object literal for the '<em><b>Owned Opposite Property Ids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS = eINSTANCE.getKeyDeclCS_OwnedOppositePropertyIds();

		/**
		 * The meta object literal for the '<em><b>Class Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_DECL_CS__CLASS_ID = eINSTANCE.getKeyDeclCS_ClassId();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ModelDeclCSImpl <em>Model Decl CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ModelDeclCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getModelDeclCS()
		 * @generated
		 */
		EClass MODEL_DECL_CS = eINSTANCE.getModelDeclCS();

		/**
		 * The meta object literal for the '<em><b>Metamodel Ids</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__METAMODEL_IDS = eINSTANCE.getModelDeclCS_MetamodelIds();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECL_CS__DEPENDS_ON = eINSTANCE.getModelDeclCS_DependsOn();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ObjectTemplateCSImpl <em>Object Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ObjectTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getObjectTemplateCS()
		 * @generated
		 */
		EClass OBJECT_TEMPLATE_CS = eINSTANCE.getObjectTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Owned Property Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES = eINSTANCE.getObjectTemplateCS_OwnedPropertyTemplates();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.ParamDeclarationCSImpl <em>Param Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.ParamDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getParamDeclarationCS()
		 * @generated
		 */
		EClass PARAM_DECLARATION_CS = eINSTANCE.getParamDeclarationCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PatternCSImpl <em>Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPatternCS()
		 * @generated
		 */
		EClass PATTERN_CS = eINSTANCE.getPatternCS();

		/**
		 * The meta object literal for the '<em><b>Owned Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_CS__OWNED_PREDICATES = eINSTANCE.getPatternCS_OwnedPredicates();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PredicateCSImpl <em>Predicate CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PredicateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPredicateCS()
		 * @generated
		 */
		EClass PREDICATE_CS = eINSTANCE.getPredicateCS();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_CS__OWNED_CONDITION = eINSTANCE.getPredicateCS_OwnedCondition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainCSImpl <em>Primitive Type Domain CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPrimitiveTypeDomainCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_DOMAIN_CS = eINSTANCE.getPrimitiveTypeDomainCS();

		/**
		 * The meta object literal for the '<em><b>Owned Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE_DOMAIN_CS__OWNED_PATTERNS = eINSTANCE.getPrimitiveTypeDomainCS_OwnedPatterns();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl <em>Property Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PropertyTemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPropertyTemplateCS()
		 * @generated
		 */
		EClass PROPERTY_TEMPLATE_CS = eINSTANCE.getPropertyTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Owning Object Template</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE = eINSTANCE.getPropertyTemplateCS_OwningObjectTemplate();

		/**
		 * The meta object literal for the '<em><b>Property Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__PROPERTY_ID = eINSTANCE.getPropertyTemplateCS_PropertyId();

		/**
		 * The meta object literal for the '<em><b>Owned Opposite Property Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID = eINSTANCE.getPropertyTemplateCS_OwnedOppositePropertyId();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION = eINSTANCE.getPropertyTemplateCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.QueryCSImpl <em>Query CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QueryCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getQueryCS()
		 * @generated
		 */
		EClass QUERY_CS = eINSTANCE.getQueryCS();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_PARAMETERS = eINSTANCE.getQueryCS_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_CS__OWNED_EXPRESSION = eINSTANCE.getQueryCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Is Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_CS__IS_TRANSIENT = eINSTANCE.getQueryCS_IsTransient();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl <em>Relation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getRelationCS()
		 * @generated
		 */
		EClass RELATION_CS = eINSTANCE.getRelationCS();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CS__IS_ABSTRACT = eINSTANCE.getRelationCS_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CS__IS_TOP = eINSTANCE.getRelationCS_IsTop();

		/**
		 * The meta object literal for the '<em><b>Overridden</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OVERRIDDEN = eINSTANCE.getRelationCS_Overridden();

		/**
		 * The meta object literal for the '<em><b>Owned Var Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OWNED_VAR_DECLARATIONS = eINSTANCE.getRelationCS_OwnedVarDeclarations();

		/**
		 * The meta object literal for the '<em><b>Owned Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OWNED_DOMAINS = eINSTANCE.getRelationCS_OwnedDomains();

		/**
		 * The meta object literal for the '<em><b>Owned When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OWNED_WHEN = eINSTANCE.getRelationCS_OwnedWhen();

		/**
		 * The meta object literal for the '<em><b>Owned Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CS__OWNED_WHERE = eINSTANCE.getRelationCS_OwnedWhere();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl <em>Template CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTemplateCS()
		 * @generated
		 */
		EClass TEMPLATE_CS = eINSTANCE.getTemplateCS();

		/**
		 * The meta object literal for the '<em><b>Owned Guard Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_CS__OWNED_GUARD_EXPRESSION = eINSTANCE.getTemplateCS_OwnedGuardExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateVariableCSImpl <em>Template Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateVariableCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTemplateVariableCS()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE_CS = eINSTANCE.getTemplateVariableCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_VARIABLE_CS__OWNED_TYPE = eINSTANCE.getTemplateVariableCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl <em>Top Level CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TopLevelCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTopLevelCS()
		 * @generated
		 */
		EClass TOP_LEVEL_CS = eINSTANCE.getTopLevelCS();

		/**
		 * The meta object literal for the '<em><b>Owned Transformations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_CS__OWNED_TRANSFORMATIONS = eINSTANCE.getTopLevelCS_OwnedTransformations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl <em>Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.TransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getTransformationCS()
		 * @generated
		 */
		EClass TRANSFORMATION_CS = eINSTANCE.getTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Model Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_MODEL_DECLS = eINSTANCE.getTransformationCS_OwnedModelDecls();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__EXTENDS = eINSTANCE.getTransformationCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Owned Key Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_KEY_DECLS = eINSTANCE.getTransformationCS_OwnedKeyDecls();

		/**
		 * The meta object literal for the '<em><b>Owned Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_QUERIES = eINSTANCE.getTransformationCS_OwnedQueries();

		/**
		 * The meta object literal for the '<em><b>Owned Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_CS__OWNED_RELATIONS = eINSTANCE.getTransformationCS_OwnedRelations();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl <em>Var Declaration CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getVarDeclarationCS()
		 * @generated
		 */
		EClass VAR_DECLARATION_CS = eINSTANCE.getVarDeclarationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION = eINSTANCE.getVarDeclarationCS_OwnedInitExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Var Declaration Ids</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS = eINSTANCE.getVarDeclarationCS_OwnedVarDeclarationIds();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECLARATION_CS__OWNED_TYPE = eINSTANCE.getVarDeclarationCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationIdCSImpl <em>Var Declaration Id CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.VarDeclarationIdCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getVarDeclarationIdCS()
		 * @generated
		 */
		EClass VAR_DECLARATION_ID_CS = eINSTANCE.getVarDeclarationIdCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainPatternCSImpl <em>Primitive Type Domain Pattern CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.PrimitiveTypeDomainPatternCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtrelationcs.impl.QVTrelationCSPackageImpl#getPrimitiveTypeDomainPatternCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_DOMAIN_PATTERN_CS = eINSTANCE.getPrimitiveTypeDomainPatternCS();

	}

} //QVTrelationCSTPackage
