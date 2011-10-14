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
 * $Id: QVTRelationPackageImpl.java,v 1.9 2009/12/29 07:34:21 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;

import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;

import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationValidator;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTRelationPackageImpl extends EPackageImpl implements QVTRelationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationDomainAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalTransformationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTRelationPackageImpl() {
		super(eNS_URI, QVTRelationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QVTRelationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTRelationPackage init() {
		if (isInited) return (QVTRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTRelationPackage.eNS_URI);

		// Obtain or create and register package
		QVTRelationPackageImpl theQVTRelationPackage = (QVTRelationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTRelationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTRelationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTBasePackage.eINSTANCE.eClass();
		QVTTemplatePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTRelationPackage.createPackageContents();

		// Initialize created meta-data
		theQVTRelationPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTRelationPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return QVTRelationValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQVTRelationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTRelationPackage.eNS_URI, theQVTRelationPackage);
		return theQVTRelationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainPattern() {
		return domainPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainPattern_TemplateExpression() {
		return (EReference)domainPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKey() {
		return keyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Identifies() {
		return (EReference)keyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Part() {
		return (EReference)keyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Transformation() {
		return (EReference)keyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_OppositePart() {
		return (EReference)keyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOppositePropertyCallExp() {
		return oppositePropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelation_IsTopLevel() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_Variable() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_OperationalImpl() {
		return (EReference)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_When() {
		return (EReference)relationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_Where() {
		return (EReference)relationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationDomain() {
		return relationDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomain_Pattern() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomain_RootVariable() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomain_DefaultAssignment() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationDomainAssignment() {
		return relationDomainAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomainAssignment_Variable() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomainAssignment_ValueExp() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationImplementation() {
		return relationImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_Relation() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_Impl() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_InDirectionOf() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationCallExp() {
		return relationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCallExp_Argument() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCallExp_ReferredRelation() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalTransformation() {
		return relationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalTransformation_OwnedKey() {
		return (EReference)relationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTRelationFactory getQVTRelationFactory() {
		return (QVTRelationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		domainPatternEClass = createEClass(DOMAIN_PATTERN);
		createEReference(domainPatternEClass, DOMAIN_PATTERN__TEMPLATE_EXPRESSION);

		keyEClass = createEClass(KEY);
		createEReference(keyEClass, KEY__IDENTIFIES);
		createEReference(keyEClass, KEY__PART);
		createEReference(keyEClass, KEY__TRANSFORMATION);
		createEReference(keyEClass, KEY__OPPOSITE_PART);

		oppositePropertyCallExpEClass = createEClass(OPPOSITE_PROPERTY_CALL_EXP);

		relationEClass = createEClass(RELATION);
		createEAttribute(relationEClass, RELATION__IS_TOP_LEVEL);
		createEReference(relationEClass, RELATION__VARIABLE);
		createEReference(relationEClass, RELATION__OPERATIONAL_IMPL);
		createEReference(relationEClass, RELATION__WHEN);
		createEReference(relationEClass, RELATION__WHERE);

		relationDomainEClass = createEClass(RELATION_DOMAIN);
		createEReference(relationDomainEClass, RELATION_DOMAIN__PATTERN);
		createEReference(relationDomainEClass, RELATION_DOMAIN__ROOT_VARIABLE);
		createEReference(relationDomainEClass, RELATION_DOMAIN__DEFAULT_ASSIGNMENT);

		relationDomainAssignmentEClass = createEClass(RELATION_DOMAIN_ASSIGNMENT);
		createEReference(relationDomainAssignmentEClass, RELATION_DOMAIN_ASSIGNMENT__VARIABLE);
		createEReference(relationDomainAssignmentEClass, RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP);

		relationImplementationEClass = createEClass(RELATION_IMPLEMENTATION);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__RELATION);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IMPL);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IN_DIRECTION_OF);

		relationCallExpEClass = createEClass(RELATION_CALL_EXP);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__ARGUMENT);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__REFERRED_RELATION);

		relationalTransformationEClass = createEClass(RELATIONAL_TRANSFORMATION);
		createEReference(relationalTransformationEClass, RELATIONAL_TRANSFORMATION__OWNED_KEY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		QVTBasePackage theQVTBasePackage = (QVTBasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTBasePackage.eNS_URI);
		QVTTemplatePackage theQVTTemplatePackage = (QVTTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTTemplatePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.ocl.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.ocl.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.ecore.EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		domainPatternEClass.getESuperTypes().add(theQVTBasePackage.getPattern());
		keyEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		oppositePropertyCallExpEClass.getESuperTypes().add(theEcorePackage_1.getPropertyCallExp());
		relationEClass.getESuperTypes().add(theQVTBasePackage.getRule());
		relationDomainEClass.getESuperTypes().add(theQVTBasePackage.getDomain());
		relationDomainAssignmentEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		relationImplementationEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		relationCallExpEClass.getESuperTypes().add(theEcorePackage_1.getOCLExpression());
		relationalTransformationEClass.getESuperTypes().add(theQVTBasePackage.getTransformation());

		// Initialize classes and features; add operations and parameters
		initEClass(domainPatternEClass, DomainPattern.class, "DomainPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPattern_TemplateExpression(), theQVTTemplatePackage.getTemplateExp(), null, "templateExpression", null, 0, 1, DomainPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyEClass, Key.class, "Key", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKey_Identifies(), theEcorePackage.getEClass(), null, "identifies", null, 1, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_Part(), theEcorePackage.getEStructuralFeature(), null, "part", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKey_Transformation(), this.getRelationalTransformation(), this.getRelationalTransformation_OwnedKey(), "transformation", null, 0, 1, Key.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_OppositePart(), theEcorePackage.getEReference(), null, "oppositePart", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(oppositePropertyCallExpEClass, OppositePropertyCallExp.class, "OppositePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelation_IsTopLevel(), ecorePackage.getEBoolean(), "isTopLevel", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Variable(), theEcorePackage_1.getVariable(), null, "variable", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelation_OperationalImpl(), this.getRelationImplementation(), this.getRelationImplementation_Relation(), "operationalImpl", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelation_When(), theQVTBasePackage.getPattern(), null, "when", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Where(), theQVTBasePackage.getPattern(), null, "where", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(relationEClass, this.getRelationalTransformation(), "getRelationalTransformation", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDomainEClass, RelationDomain.class, "RelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomain_Pattern(), this.getDomainPattern(), null, "pattern", null, 0, 1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomain_RootVariable(), theEcorePackage_1.getVariable(), null, "rootVariable", null, 1, 1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomain_DefaultAssignment(), this.getRelationDomainAssignment(), null, "defaultAssignment", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(relationDomainAssignmentEClass, RelationDomainAssignment.class, "RelationDomainAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomainAssignment_Variable(), theEcorePackage_1.getVariable(), null, "variable", null, 1, 1, RelationDomainAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomainAssignment_ValueExp(), theEcorePackage_1.getOCLExpression(), null, "valueExp", null, 1, 1, RelationDomainAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationImplementationEClass, RelationImplementation.class, "RelationImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationImplementation_Relation(), this.getRelation(), this.getRelation_OperationalImpl(), "relation", null, 0, 1, RelationImplementation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_Impl(), theEcorePackage.getEOperation(), null, "impl", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_InDirectionOf(), theQVTBasePackage.getTypedModel(), null, "inDirectionOf", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCallExpEClass, RelationCallExp.class, "RelationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationCallExp_Argument(), theEcorePackage_1.getOCLExpression(), null, "argument", null, 2, -1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCallExp_ReferredRelation(), this.getRelation(), null, "referredRelation", null, 1, 1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationalTransformationEClass, RelationalTransformation.class, "RelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalTransformation_OwnedKey(), this.getKey(), this.getKey_Transformation(), "ownedKey", null, 0, -1, RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(relationalTransformationEClass, this.getRelation(), "getRelation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";				
		addAnnotation
		  (getKey_OppositePart(), 
		   source, 
		   new String[] {
			 "body", "oppositeKey"
		   });				
		addAnnotation
		  (getRelation_When(), 
		   source, 
		   new String[] {
			 "body", "whenOwner"
		   });		
		addAnnotation
		  (getRelation_Where(), 
		   source, 
		   new String[] {
			 "body", "whereOwner"
		   });			
		addAnnotation
		  (getRelationDomain_DefaultAssignment(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });			
		addAnnotation
		  (getRelationDomainAssignment_Variable(), 
		   source, 
		   new String[] {
			 "body", "domainAssignment"
		   });		
		addAnnotation
		  (getRelationDomainAssignment_ValueExp(), 
		   source, 
		   new String[] {
			 "body", "domainAssignment"
		   });			
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (domainPatternEClass, 
		   source, 
		   new String[] {
			 "constraints", "EveryVariableIsDefinedByRelation\r\nRootTemplateExpressionIsBoundToRootVariable\r\nRootTemplateExpressionTypeIsRootVariableType\r\n"
		   });		
		addAnnotation
		  (keyEClass, 
		   source, 
		   new String[] {
			 "constraints", "AtLeastOnePart\r\nIdentifiesTypeIsDeclaredByTransformation\r\nEveryPartIsDeclaredByIdentifies\r\nEveryOppositePartReferencesIdentifies\r\n"
		   });			
		addAnnotation
		  (oppositePropertyCallExpEClass, 
		   source, 
		   new String[] {
			 "constraints", "PropertyIsReference\r\nPropertyIsUnidirectional"
		   });		
		addAnnotation
		  (relationEClass, 
		   source, 
		   new String[] {
			 "constraints", "AtLeastTwoDomains\r\nDomainTypedModelsMatchModelParameters\r\nEveryDomainIsARelationDomain\r\nNonTopLevelIsNotInvokedWarning\r\nRelationImplsAreUniqueWarning\r\nVariablesAreUnique\r\nWhenTypesAreDeclaredByRelation\r\nWhenVariablesAreDefinedByRelation\r\nWhereTypesAreDeclaredByRelation\r\nWhereVariablesAreDefinedByRelation\r\n"
		   });				
		addAnnotation
		  (relationDomainEClass, 
		   source, 
		   new String[] {
			 "constraints", "WellFormedName\r\nTypedModelExistsWarning\r\nPrimitiveDomainIsUnnamed\r\nRootVariableIsDefinedByRelation\r\nRootVariableTypeIsDeclaredByDomainTypedModel\r\nEveryEnforceableVariableIsMatchedOrAssigned\r\n"
		   });			
		addAnnotation
		  (relationDomainAssignmentEClass, 
		   source, 
		   new String[] {
			 "constraints", "VariableDefinedByRelation\r\nVariableTypeMatchesValueType\r\n"
		   });				
		addAnnotation
		  (relationImplementationEClass, 
		   source, 
		   new String[] {
			 "constraints", "InDirectionOfIsDefinedByTransformation\r\nEveryParameterTypeMatchesDomainRootVariableType\r\n"
		   });		
		addAnnotation
		  (relationCallExpEClass, 
		   source, 
		   new String[] {
			 "constraints", "PatternExists\r\nRelationExists\r\nInvokedFromWhenOrWhereClause\r\nReferredRelationDeclaredByTransformation\r\nReferredRelationArgumentNumberMatches\r\nEveryWhenReferredRelationArgumentTypeMatches\r\nEveryWhereReferredRelationArgumentTypeIsMatchableWarning\r\nTypeIsBoolean\r\n"
		   });		
		addAnnotation
		  (relationalTransformationEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueClassifierNames\r\nEveryRuleIsARelation\r\nKeysAreUnique"
		   });
	}

} //QVTRelationPackageImpl
