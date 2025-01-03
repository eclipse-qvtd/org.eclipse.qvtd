/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtrelationcs.*;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSFactory;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;

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
			case 1: return createCollectionTemplateCS();
			case 2: return createDefaultValueCS();
			case 3: return createDomainCS();
			case 4: return createDomainPatternCS();
			case 5: return createElementTemplateCS();
			case 6: return createKeyDeclCS();
			case 7: return createModelDeclCS();
			case 8: return createObjectTemplateCS();
			case 9: return createParamDeclarationCS();
			case 10: return createPatternCS();
			case 11: return createPredicateCS();
			case 12: return createPrimitiveTypeDomainCS();
			case 13: return createPrimitiveTypeDomainPatternCS();
			case 14: return createPropertyTemplateCS();
			case 15: return createQueryCS();
			case 16: return createRelationCS();
			case 19: return createTopLevelCS();
			case 20: return createTransformationCS();
			case 21: return createVarDeclarationCS();
			case 22: return createVarDeclarationIdCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionTemplateCS createCollectionTemplateCS() {
		CollectionTemplateCSImpl collectionTemplateCS = new CollectionTemplateCSImpl();
		return collectionTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefaultValueCS createDefaultValueCS() {
		DefaultValueCSImpl defaultValueCS = new DefaultValueCSImpl();
		return defaultValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainCS createDomainCS() {
		DomainCSImpl domainCS = new DomainCSImpl();
		return domainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainPatternCS createDomainPatternCS() {
		DomainPatternCSImpl domainPatternCS = new DomainPatternCSImpl();
		return domainPatternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementTemplateCS createElementTemplateCS() {
		ElementTemplateCSImpl elementTemplateCS = new ElementTemplateCSImpl();
		return elementTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public KeyDeclCS createKeyDeclCS() {
		KeyDeclCSImpl keyDeclCS = new KeyDeclCSImpl();
		return keyDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelDeclCS createModelDeclCS() {
		ModelDeclCSImpl modelDeclCS = new ModelDeclCSImpl();
		return modelDeclCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateCS createObjectTemplateCS() {
		ObjectTemplateCSImpl objectTemplateCS = new ObjectTemplateCSImpl();
		return objectTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParamDeclarationCS createParamDeclarationCS() {
		ParamDeclarationCSImpl paramDeclarationCS = new ParamDeclarationCSImpl();
		return paramDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternCS createPatternCS() {
		PatternCSImpl patternCS = new PatternCSImpl();
		return patternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PredicateCS createPredicateCS() {
		PredicateCSImpl predicateCS = new PredicateCSImpl();
		return predicateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveTypeDomainCS createPrimitiveTypeDomainCS() {
		PrimitiveTypeDomainCSImpl primitiveTypeDomainCS = new PrimitiveTypeDomainCSImpl();
		return primitiveTypeDomainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyTemplateCS createPropertyTemplateCS() {
		PropertyTemplateCSImpl propertyTemplateCS = new PropertyTemplateCSImpl();
		return propertyTemplateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueryCS createQueryCS() {
		QueryCSImpl queryCS = new QueryCSImpl();
		return queryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationCS createRelationCS() {
		RelationCSImpl relationCS = new RelationCSImpl();
		return relationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VarDeclarationCS createVarDeclarationCS() {
		VarDeclarationCSImpl varDeclarationCS = new VarDeclarationCSImpl();
		return varDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VarDeclarationIdCS createVarDeclarationIdCS() {
		VarDeclarationIdCSImpl varDeclarationIdCS = new VarDeclarationIdCSImpl();
		return varDeclarationIdCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveTypeDomainPatternCS createPrimitiveTypeDomainPatternCS() {
		PrimitiveTypeDomainPatternCSImpl primitiveTypeDomainPatternCS = new PrimitiveTypeDomainPatternCSImpl();
		return primitiveTypeDomainPatternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
