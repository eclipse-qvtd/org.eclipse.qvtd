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
 * $Id: QVTRelationFactoryImpl.java,v 1.3 2009/11/19 10:34:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTRelation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.emof.QVTRelation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTRelationFactoryImpl extends EFactoryImpl implements QVTRelationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTRelationFactory init() {
		try {
			QVTRelationFactory theQVTRelationFactory = (QVTRelationFactory)EPackage.Registry.INSTANCE.getEFactory("http://schema.omg.org/spec/QVT/1.1/qvtrelation.xml"); 
			if (theQVTRelationFactory != null) {
				return theQVTRelationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTRelationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTRelationFactoryImpl() {
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
			case QVTRelationPackage.DOMAIN_PATTERN: return createDomainPattern();
			case QVTRelationPackage.KEY: return createKey();
			case QVTRelationPackage.OPPOSITE_PROPERTY_CALL_EXP: return createOppositePropertyCallExp();
			case QVTRelationPackage.RELATION: return createRelation();
			case QVTRelationPackage.RELATION_CALL_EXP: return createRelationCallExp();
			case QVTRelationPackage.RELATION_DOMAIN: return createRelationDomain();
			case QVTRelationPackage.RELATION_DOMAIN_ASSIGNMENT: return createRelationDomainAssignment();
			case QVTRelationPackage.RELATION_IMPLEMENTATION: return createRelationImplementation();
			case QVTRelationPackage.RELATIONAL_TRANSFORMATION: return createRelationalTransformation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPattern createDomainPattern() {
		DomainPatternImpl domainPattern = new DomainPatternImpl();
		return domainPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key createKey() {
		KeyImpl key = new KeyImpl();
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCallExp createOppositePropertyCallExp() {
		OppositePropertyCallExpImpl oppositePropertyCallExp = new OppositePropertyCallExpImpl();
		return oppositePropertyCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationCallExp createRelationCallExp() {
		RelationCallExpImpl relationCallExp = new RelationCallExpImpl();
		return relationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomain createRelationDomain() {
		RelationDomainImpl relationDomain = new RelationDomainImpl();
		return relationDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomainAssignment createRelationDomainAssignment() {
		RelationDomainAssignmentImpl relationDomainAssignment = new RelationDomainAssignmentImpl();
		return relationDomainAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationImplementation createRelationImplementation() {
		RelationImplementationImpl relationImplementation = new RelationImplementationImpl();
		return relationImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation createRelationalTransformation() {
		RelationalTransformationImpl relationalTransformation = new RelationalTransformationImpl();
		return relationalTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTRelationPackage getQVTRelationPackage() {
		return (QVTRelationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTRelationPackage getPackage() {
		return QVTRelationPackage.eINSTANCE;
	}

} //QVTRelationFactoryImpl
