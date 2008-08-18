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
 * $Id: QVTrCSTFactoryImpl.java,v 1.3 2008/08/18 07:55:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTFactory;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrCSTFactoryImpl extends EFactoryImpl implements QVTrCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTrCSTFactory init() {
		try {
			QVTrCSTFactory theQVTrCSTFactory = (QVTrCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/QVTRelationcst"); 
			if (theQVTrCSTFactory != null) {
				return theQVTrCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTrCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrCSTFactoryImpl() {
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
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS: return createCollectionTemplateCS();
			case QVTrCSTPackage.DEFAULT_VALUE_CS: return createDefaultValueCS();
			case QVTrCSTPackage.DOMAIN_CS: return createDomainCS();
			case QVTrCSTPackage.KEY_DECL_CS: return createKeyDeclCS();
			case QVTrCSTPackage.MODEL_DECL_CS: return createModelDeclCS();
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS: return createObjectTemplateCS();
			case QVTrCSTPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTrCSTPackage.PRIMITIVE_TYPE_DOMAIN_CS: return createPrimitiveTypeDomainCS();
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS: return createPropertyTemplateCS();
			case QVTrCSTPackage.QUERY_CS: return createQueryCS();
			case QVTrCSTPackage.RELATION_CS: return createRelationCS();
			case QVTrCSTPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTrCSTPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTrCSTPackage.UNIT_CS: return createUnitCS();
			case QVTrCSTPackage.VAR_DECLARATION_CS: return createVarDeclarationCS();
			case QVTrCSTPackage.WHEN_CS: return createWhenCS();
			case QVTrCSTPackage.WHERE_CS: return createWhereCS();
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
	public DomainCS createDomainCS() {
		DomainCSImpl domainCS = new DomainCSImpl();
		return domainCS;
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
	public VarDeclarationCS createVarDeclarationCS() {
		VarDeclarationCSImpl varDeclarationCS = new VarDeclarationCSImpl();
		return varDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhenCS createWhenCS() {
		WhenCSImpl whenCS = new WhenCSImpl();
		return whenCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhereCS createWhereCS() {
		WhereCSImpl whereCS = new WhereCSImpl();
		return whereCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrCSTPackage getQVTrCSTPackage() {
		return (QVTrCSTPackage)getEPackage();
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
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTrCSTPackage getPackage() {
		return QVTrCSTPackage.eINSTANCE;
	}

} //EqvtrCSTFactoryImpl
