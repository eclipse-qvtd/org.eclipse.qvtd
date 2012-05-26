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
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtrelationcst.*;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTFactory;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrelationCSTFactoryImpl extends EFactoryImpl implements QVTrelationCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTrelationCSTFactory init() {
		try {
			QVTrelationCSTFactory theQVTrelationCSTFactory = (QVTrelationCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/0.9/QVTrelationCST"); 
			if (theQVTrelationCSTFactory != null) {
				return theQVTrelationCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTrelationCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS: return createCollectionTemplateCS();
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS: return createDefaultValueCS();
			case QVTrelationCSTPackage.DOMAIN_CS: return createDomainCS();
			case QVTrelationCSTPackage.DOMAIN_PATTERN_CS: return createDomainPatternCS();
			case QVTrelationCSTPackage.ELEMENT_TEMPLATE_CS: return createElementTemplateCS();
			case QVTrelationCSTPackage.KEY_DECL_CS: return createKeyDeclCS();
			case QVTrelationCSTPackage.MODEL_DECL_CS: return createModelDeclCS();
			case QVTrelationCSTPackage.OBJECT_TEMPLATE_CS: return createObjectTemplateCS();
			case QVTrelationCSTPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTrelationCSTPackage.PATTERN_CS: return createPatternCS();
			case QVTrelationCSTPackage.PREDICATE_CS: return createPredicateCS();
			case QVTrelationCSTPackage.PRIMITIVE_TYPE_DOMAIN_CS: return createPrimitiveTypeDomainCS();
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS: return createPropertyTemplateCS();
			case QVTrelationCSTPackage.QUERY_CS: return createQueryCS();
			case QVTrelationCSTPackage.RELATION_CS: return createRelationCS();
			case QVTrelationCSTPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTrelationCSTPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTrelationCSTPackage.UNIT_CS: return createUnitCS();
			case QVTrelationCSTPackage.VAR_DECLARATION_CS: return createVarDeclarationCS();
			case QVTrelationCSTPackage.VAR_DECLARATION_ID_CS: return createVarDeclarationIdCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTemplateCS createCollectionTemplateCS() {
		CollectionTemplateCSImpl collectionTemplateCS = new CollectionTemplateCSImpl();
		return collectionTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultValueCS createDefaultValueCS() {
		DefaultValueCSImpl defaultValueCS = new DefaultValueCSImpl();
		return defaultValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainCS createDomainCS() {
		DomainCSImpl domainCS = new DomainCSImpl();
		return domainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPatternCS createDomainPatternCS() {
		DomainPatternCSImpl domainPatternCS = new DomainPatternCSImpl();
		return domainPatternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTemplateCS createElementTemplateCS() {
		ElementTemplateCSImpl elementTemplateCS = new ElementTemplateCSImpl();
		return elementTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyDeclCS createKeyDeclCS() {
		KeyDeclCSImpl keyDeclCS = new KeyDeclCSImpl();
		return keyDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclCS createModelDeclCS() {
		ModelDeclCSImpl modelDeclCS = new ModelDeclCSImpl();
		return modelDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateCS createObjectTemplateCS() {
		ObjectTemplateCSImpl objectTemplateCS = new ObjectTemplateCSImpl();
		return objectTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamDeclarationCS createParamDeclarationCS() {
		ParamDeclarationCSImpl paramDeclarationCS = new ParamDeclarationCSImpl();
		return paramDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternCS createPatternCS() {
		PatternCSImpl patternCS = new PatternCSImpl();
		return patternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateCS createPredicateCS() {
		PredicateCSImpl predicateCS = new PredicateCSImpl();
		return predicateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeDomainCS createPrimitiveTypeDomainCS() {
		PrimitiveTypeDomainCSImpl primitiveTypeDomainCS = new PrimitiveTypeDomainCSImpl();
		return primitiveTypeDomainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateCS createPropertyTemplateCS() {
		PropertyTemplateCSImpl propertyTemplateCS = new PropertyTemplateCSImpl();
		return propertyTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryCS createQueryCS() {
		QueryCSImpl queryCS = new QueryCSImpl();
		return queryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationCS createRelationCS() {
		RelationCSImpl relationCS = new RelationCSImpl();
		return relationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitCS createUnitCS() {
		UnitCSImpl unitCS = new UnitCSImpl();
		return unitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDeclarationCS createVarDeclarationCS() {
		VarDeclarationCSImpl varDeclarationCS = new VarDeclarationCSImpl();
		return varDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDeclarationIdCS createVarDeclarationIdCS() {
		VarDeclarationIdCSImpl varDeclarationIdCS = new VarDeclarationIdCSImpl();
		return varDeclarationIdCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationCSTPackage getQVTrelationCSTPackage() {
		return (QVTrelationCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTrelationCSTPackage getPackage() {
		return QVTrelationCSTPackage.eINSTANCE;
	}

} //QVTrelationCSTFactoryImpl
