/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSFactory;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationIdCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrelationCSFactoryImpl extends EFactoryImpl implements QVTrelationCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTrelationCSFactory init() {
		try {
			QVTrelationCSFactory theQVTrelationCSFactory = (QVTrelationCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTrelationCSPackage.eNS_URI);
			if (theQVTrelationCSFactory != null) {
				return theQVTrelationCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTrelationCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationCSFactoryImpl() {
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
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS: return createCollectionTemplateCS();
			case QVTrelationCSPackage.DEFAULT_VALUE_CS: return createDefaultValueCS();
			case QVTrelationCSPackage.DOMAIN_CS: return createDomainCS();
			case QVTrelationCSPackage.DOMAIN_PATTERN_CS: return createDomainPatternCS();
			case QVTrelationCSPackage.ELEMENT_TEMPLATE_CS: return createElementTemplateCS();
			case QVTrelationCSPackage.KEY_DECL_CS: return createKeyDeclCS();
			case QVTrelationCSPackage.MODEL_DECL_CS: return createModelDeclCS();
			case QVTrelationCSPackage.OBJECT_TEMPLATE_CS: return createObjectTemplateCS();
			case QVTrelationCSPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTrelationCSPackage.PATTERN_CS: return createPatternCS();
			case QVTrelationCSPackage.PREDICATE_CS: return createPredicateCS();
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS: return createPrimitiveTypeDomainCS();
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS: return createPropertyTemplateCS();
			case QVTrelationCSPackage.QUERY_CS: return createQueryCS();
			case QVTrelationCSPackage.RELATION_CS: return createRelationCS();
			case QVTrelationCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTrelationCSPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTrelationCSPackage.UNIT_CS: return createUnitCS();
			case QVTrelationCSPackage.VAR_DECLARATION_CS: return createVarDeclarationCS();
			case QVTrelationCSPackage.VAR_DECLARATION_ID_CS: return createVarDeclarationIdCS();
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
	public QVTrelationCSPackage getQVTrelationCSPackage() {
		return (QVTrelationCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTrelationCSPackage getPackage() {
		return QVTrelationCSPackage.eINSTANCE;
	}

} //QVTrelationCSTFactoryImpl
