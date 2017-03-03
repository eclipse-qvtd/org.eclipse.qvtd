/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationValidator;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrelationPackageImpl extends EPackageImpl implements QVTrelationPackage {
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
	private EClass relationEClass = null;

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
	private EClass relationModelEClass = null;

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
	private EClass relationalTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateVariableEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTrelationPackageImpl() {
		super(eNS_URI, QVTrelationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTrelationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTrelationPackage init() {
		if (isInited) return (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTrelationPackageImpl theQVTrelationPackage = (QVTrelationPackageImpl)(ePackage instanceof QVTrelationPackageImpl ? ePackage : new QVTrelationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTrelationPackage.createPackageContents();

		// Initialize created meta-data
		theQVTrelationPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
		(theQVTrelationPackage,
			new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return QVTrelationValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theQVTrelationPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTrelationPackage.eNS_URI, theQVTrelationPackage);
		return theQVTrelationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainPattern() {
		return domainPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainPattern_TemplateExpression() {
		return (EReference)domainPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKey() {
		return keyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKey_Identifies() {
		return (EReference)keyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKey_Part() {
		return (EReference)keyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKey_Transformation() {
		return (EReference)keyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidatePartsIncludesContainer__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateNoSuperKeys__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidatePartsAreParts__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidatePartsAreUnique__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKey_OppositePart() {
		return (EReference)keyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_IsTopLevel() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_OperationalImpl() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Variable() {
		return (EReference)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_When() {
		return (EReference)relationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Where() {
		return (EReference)relationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map() {
		return relationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map() {
		return relationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationCallExp() {
		return relationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCallExp_Argument() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCallExp_ReferredRelation() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map() {
		return relationCallExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationDomain() {
		return relationDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomain_DefaultAssignment() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomain_Pattern() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomain_RootVariable() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map() {
		return relationDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationDomainAssignment() {
		return relationDomainAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomainAssignment_ValueExp() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomainAssignment_Variable() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map() {
		return relationDomainAssignmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationModel() {
		return relationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationImplementation() {
		return relationImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationImplementation_Impl() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationImplementation_InDirectionOf() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationImplementation_Relation() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationalTransformation() {
		return relationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationalTransformation_OwnedKey() {
		return (EReference)relationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map() {
		return relationalTransformationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSharedVariable() {
		return sharedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateVariable() {
		return templateVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTrelationFactory getQVTrelationFactory() {
		return (QVTrelationFactory)getEFactoryInstance();
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
		createEReference(keyEClass, KEY__OPPOSITE_PART);
		createEReference(keyEClass, KEY__PART);
		createEReference(keyEClass, KEY__TRANSFORMATION);
		createEOperation(keyEClass, KEY___VALIDATE_PARTS_INCLUDES_CONTAINER__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(keyEClass, KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);

		relationEClass = createEClass(RELATION);
		createEAttribute(relationEClass, RELATION__IS_TOP_LEVEL);
		createEReference(relationEClass, RELATION__OPERATIONAL_IMPL);
		createEReference(relationEClass, RELATION__VARIABLE);
		createEReference(relationEClass, RELATION__WHEN);
		createEReference(relationEClass, RELATION__WHERE);
		createEOperation(relationEClass, RELATION___VALIDATE_DOMAINS_ARE_RELATION_DOMAINS__DIAGNOSTICCHAIN_MAP);
		createEOperation(relationEClass, RELATION___VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION__DIAGNOSTICCHAIN_MAP);

		relationCallExpEClass = createEClass(RELATION_CALL_EXP);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__ARGUMENT);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__REFERRED_RELATION);
		createEOperation(relationCallExpEClass, RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP);

		relationDomainEClass = createEClass(RELATION_DOMAIN);
		createEReference(relationDomainEClass, RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		createEReference(relationDomainEClass, RELATION_DOMAIN__PATTERN);
		createEReference(relationDomainEClass, RELATION_DOMAIN__ROOT_VARIABLE);
		createEOperation(relationDomainEClass, RELATION_DOMAIN___VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);

		relationDomainAssignmentEClass = createEClass(RELATION_DOMAIN_ASSIGNMENT);
		createEReference(relationDomainAssignmentEClass, RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP);
		createEReference(relationDomainAssignmentEClass, RELATION_DOMAIN_ASSIGNMENT__VARIABLE);
		createEOperation(relationDomainAssignmentEClass, RELATION_DOMAIN_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);

		relationImplementationEClass = createEClass(RELATION_IMPLEMENTATION);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IMPL);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IN_DIRECTION_OF);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__RELATION);

		relationModelEClass = createEClass(RELATION_MODEL);

		relationalTransformationEClass = createEClass(RELATIONAL_TRANSFORMATION);
		createEReference(relationalTransformationEClass, RELATIONAL_TRANSFORMATION__OWNED_KEY);
		createEOperation(relationalTransformationEClass, RELATIONAL_TRANSFORMATION___VALIDATE_RULES_ARE_RELATIONS__DIAGNOSTICCHAIN_MAP);

		sharedVariableEClass = createEClass(SHARED_VARIABLE);

		templateVariableEClass = createEClass(TEMPLATE_VARIABLE);
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
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		QVTtemplatePackage theQVTtemplatePackage = (QVTtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtemplatePackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		domainPatternEClass.getESuperTypes().add(theQVTbasePackage.getPattern());
		keyEClass.getESuperTypes().add(thePivotPackage.getElement());
		relationEClass.getESuperTypes().add(theQVTbasePackage.getRule());
		relationCallExpEClass.getESuperTypes().add(thePivotPackage.getOCLExpression());
		relationDomainEClass.getESuperTypes().add(theQVTbasePackage.getDomain());
		relationDomainAssignmentEClass.getESuperTypes().add(thePivotPackage.getElement());
		relationImplementationEClass.getESuperTypes().add(thePivotPackage.getElement());
		relationModelEClass.getESuperTypes().add(theQVTbasePackage.getBaseModel());
		relationalTransformationEClass.getESuperTypes().add(theQVTbasePackage.getTransformation());
		sharedVariableEClass.getESuperTypes().add(thePivotPackage.getVariable());
		templateVariableEClass.getESuperTypes().add(thePivotPackage.getVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainPatternEClass, DomainPattern.class, "DomainPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPattern_TemplateExpression(), theQVTtemplatePackage.getTemplateExp(), null, "templateExpression", null, 0, 1, DomainPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyEClass, Key.class, "Key", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKey_Identifies(), thePivotPackage.getClass_(), null, "identifies", null, 1, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_OppositePart(), thePivotPackage.getProperty(), null, "oppositePart", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKey_Part(), thePivotPackage.getProperty(), null, "part", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKey_Transformation(), this.getRelationalTransformation(), this.getRelationalTransformation_OwnedKey(), "transformation", null, 0, 1, Key.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getKey__ValidatePartsIncludesContainer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartsIncludesContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIdentifiesIsNotAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIdentifiesIsAUsedPackageClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateNoSuperKeys__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoSuperKeys", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIdentifiesIsUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOppositePartsHaveOpposites", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOppositePartsAreOppositeParts", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidatePartsAreParts__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartsAreParts", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getKey__ValidatePartsAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartsAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelation_IsTopLevel(), ecorePackage.getEBoolean(), "isTopLevel", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_OperationalImpl(), this.getRelationImplementation(), this.getRelationImplementation_Relation(), "operationalImpl", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelation_Variable(), thePivotPackage.getVariable(), null, "variable", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelation_When(), theQVTbasePackage.getPattern(), null, "when", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Where(), theQVTbasePackage.getPattern(), null, "where", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDomainsAreRelationDomains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTransformationIsRelationalTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationCallExpEClass, RelationCallExp.class, "RelationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationCallExp_Argument(), thePivotPackage.getOCLExpression(), null, "argument", null, 2, -1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCallExp_ReferredRelation(), this.getRelation(), null, "referredRelation", null, 1, 1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateMatchingArgumentCount", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDomainEClass, RelationDomain.class, "RelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomain_DefaultAssignment(), this.getRelationDomainAssignment(), null, "defaultAssignment", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelationDomain_Pattern(), this.getDomainPattern(), null, "pattern", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomain_RootVariable(), thePivotPackage.getVariable(), null, "rootVariable", null, 1, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRelationDomainAssignmentsAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDomainAssignmentEClass, RelationDomainAssignment.class, "RelationDomainAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomainAssignment_ValueExp(), thePivotPackage.getOCLExpression(), null, "valueExp", null, 1, 1, RelationDomainAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomainAssignment_Variable(), thePivotPackage.getVariable(), null, "variable", null, 1, 1, RelationDomainAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationImplementationEClass, RelationImplementation.class, "RelationImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationImplementation_Impl(), thePivotPackage.getOperation(), null, "impl", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_InDirectionOf(), theQVTbasePackage.getTypedModel(), null, "inDirectionOf", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_Relation(), this.getRelation(), this.getRelation_OperationalImpl(), "relation", null, 0, 1, RelationImplementation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationModelEClass, RelationModel.class, "RelationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalTransformationEClass, RelationalTransformation.class, "RelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalTransformation_OwnedKey(), this.getKey(), this.getKey_Transformation(), "ownedKey", null, 0, -1, RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRulesAreRelations", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sharedVariableEClass, SharedVariable.class, "SharedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateVariableEClass, TemplateVariable.class, "TemplateVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
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
		(this,
			source,
			new String[] {
		});
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
		(getKey_Identifies(),
			source,
			new String[] {
				"body", "key"
		});
		addAnnotation
		(getKey_OppositePart(),
			source,
			new String[] {
				"body", "oppKey"
		});
		addAnnotation
		(getKey_Part(),
			source,
			new String[] {
				"body", "key"
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
		(getRelationCallExp_Argument(),
			source,
			new String[] {
				"body", "relationCallExp"
		});
		addAnnotation
		(getRelationCallExp_ReferredRelation(),
			source,
			new String[] {
				"body", "relationCallExp"
		});
		addAnnotation
		(getRelationDomain_DefaultAssignment(),
			source,
			new String[] {
				"body", "owner"
		});
		addAnnotation
		(getRelationDomainAssignment_ValueExp(),
			source,
			new String[] {
				"body", "domainAssignment"
		});
		addAnnotation
		(getRelationDomainAssignment_Variable(),
			source,
			new String[] {
				"body", "domainAssignment"
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		(getKey__ValidatePartsIncludesContainer__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "PartsIncludesContainer"
		});
		addAnnotation
		(getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "IdentifiesIsNotAbstract"
		});
		addAnnotation
		(getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "IdentifiesIsAUsedPackageClass"
		});
		addAnnotation
		(getKey__ValidateNoSuperKeys__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "NoSuperKeys"
		});
		addAnnotation
		(getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "IdentifiesIsUnique"
		});
		addAnnotation
		(getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "OppositePartsHaveOpposites"
		});
		addAnnotation
		(getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "OppositePartsAreOppositeParts"
		});
		addAnnotation
		(getKey__ValidatePartsAreParts__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "PartsAreParts"
		});
		addAnnotation
		(getKey__ValidatePartsAreUnique__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "PartsAreUnique"
		});
		addAnnotation
		(getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "DomainsAreRelationDomains"
		});
		addAnnotation
		(getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "TransformationIsRelationalTransformation"
		});
		addAnnotation
		(getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "MatchingArgumentCount"
		});
		addAnnotation
		(getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "RelationDomainAssignmentsAreUnique"
		});
		addAnnotation
		(getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "CompatibleTypeForValue"
		});
		addAnnotation
		(getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "RulesAreRelations"
		});
	}

} //QVTrelationPackageImpl
