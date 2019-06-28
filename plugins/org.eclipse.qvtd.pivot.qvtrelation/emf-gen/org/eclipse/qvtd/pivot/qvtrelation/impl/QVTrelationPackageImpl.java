/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.OCLExpressionImpl;
import org.eclipse.ocl.pivot.internal.VariableImpl;
import org.eclipse.ocl.pivot.internal.utilities.LazyXMIidAssigningResourceImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl;
import org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl;
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
		Object registeredQVTrelationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTrelationPackageImpl theQVTrelationPackage = registeredQVTrelationPackage instanceof QVTrelationPackageImpl ? (QVTrelationPackageImpl)registeredQVTrelationPackage : new QVTrelationPackageImpl();

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
	public EReference getDomainPattern_RelationDomain() {
		return (EReference)domainPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainPattern_TemplateExpression() {
		return (EReference)domainPatternEClass.getEStructuralFeatures().get(1);
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
	public EOperation getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateNoSuperKeys__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidatePartsAreParts__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getKey__ValidatePartsAreUnique__DiagnosticChain_Map() {
		return keyEClass.getEOperations().get(7);
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
	public EOperation getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map() {
		return relationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map() {
		return relationEClass.getEOperations().get(2);
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
	public EOperation getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map() {
		return relationCallExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map() {
		return relationCallExpEClass.getEOperations().get(2);
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
	public EReference getRelationDomainAssignment_Owner() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomainAssignment_ValueExp() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationDomainAssignment_Variable() {
		return (EReference)relationDomainAssignmentEClass.getEStructuralFeatures().get(2);
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
	public EReference getSharedVariable_TypedModel() {
		return (EReference)sharedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map() {
		return sharedVariableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map() {
		return sharedVariableEClass.getEOperations().get(1);
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
		domainPatternEClass = createEClass(0);
		createEReference(domainPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 0);
		createEReference(domainPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 1);

		keyEClass = createEClass(1);
		createEReference(keyEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(keyEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEReference(keyEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		createEReference(keyEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 3);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 1);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 2);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 3);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 4);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 5);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 6);
		createEOperation(keyEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 7);

		relationEClass = createEClass(2);
		createEAttribute(relationEClass, RuleImpl.RULE_FEATURE_COUNT + 0);
		createEReference(relationEClass, RuleImpl.RULE_FEATURE_COUNT + 1);
		createEReference(relationEClass, RuleImpl.RULE_FEATURE_COUNT + 2);
		createEReference(relationEClass, RuleImpl.RULE_FEATURE_COUNT + 3);
		createEReference(relationEClass, RuleImpl.RULE_FEATURE_COUNT + 4);
		createEOperation(relationEClass, RuleImpl.RULE_OPERATION_COUNT + 0);
		createEOperation(relationEClass, RuleImpl.RULE_OPERATION_COUNT + 1);
		createEOperation(relationEClass, RuleImpl.RULE_OPERATION_COUNT + 2);

		relationCallExpEClass = createEClass(3);
		createEReference(relationCallExpEClass, OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0);
		createEReference(relationCallExpEClass, OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1);
		createEOperation(relationCallExpEClass, OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 0);
		createEOperation(relationCallExpEClass, OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 1);
		createEOperation(relationCallExpEClass, OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 2);

		relationDomainEClass = createEClass(4);
		createEReference(relationDomainEClass, DomainImpl.DOMAIN_FEATURE_COUNT + 0);
		createEReference(relationDomainEClass, DomainImpl.DOMAIN_FEATURE_COUNT + 1);
		createEReference(relationDomainEClass, DomainImpl.DOMAIN_FEATURE_COUNT + 2);
		createEOperation(relationDomainEClass, DomainImpl.DOMAIN_OPERATION_COUNT + 0);

		relationDomainAssignmentEClass = createEClass(5);
		createEReference(relationDomainAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(relationDomainAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEReference(relationDomainAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		createEOperation(relationDomainAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);

		relationImplementationEClass = createEClass(6);
		createEReference(relationImplementationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(relationImplementationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEReference(relationImplementationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);

		relationModelEClass = createEClass(7);

		relationalTransformationEClass = createEClass(8);
		createEReference(relationalTransformationEClass, TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0);
		createEOperation(relationalTransformationEClass, TransformationImpl.TRANSFORMATION_OPERATION_COUNT + 0);

		sharedVariableEClass = createEClass(9);
		createEReference(sharedVariableEClass, VariableImpl.VARIABLE_FEATURE_COUNT + 0);
		createEOperation(sharedVariableEClass, VariableImpl.VARIABLE_OPERATION_COUNT + 0);
		createEOperation(sharedVariableEClass, VariableImpl.VARIABLE_OPERATION_COUNT + 1);

		templateVariableEClass = createEClass(10);
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
		initEReference(getDomainPattern_RelationDomain(), this.getRelationDomain(), this.getRelationDomain_Pattern(), "relationDomain", null, 1, 1, DomainPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainPattern_TemplateExpression(), theQVTtemplatePackage.getTemplateExp(), null, "templateExpression", null, 0, 1, DomainPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyEClass, Key.class, "Key", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKey_Identifies(), thePivotPackage.getClass_(), null, "identifies", null, 1, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_OppositePart(), thePivotPackage.getProperty(), null, "oppositePart", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKey_Part(), thePivotPackage.getProperty(), null, "part", null, 0, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getKey_Transformation(), this.getRelationalTransformation(), this.getRelationalTransformation_OwnedKey(), "transformation", null, 0, 1, Key.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIdentifiesIsNotAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
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

		op = initEOperation(getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTopRelationOverriddenByTopRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		initEReference(getRelationCallExp_Argument(), thePivotPackage.getOCLExpression(), null, "argument", null, 1, -1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCallExp_ReferredRelation(), this.getRelation(), null, "referredRelation", null, 1, 1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateMatchingArgumentCount", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateWhereInvocationIsANonTopRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDataTypeInvocationIsANonTopRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDomainEClass, RelationDomain.class, "RelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomain_DefaultAssignment(), this.getRelationDomainAssignment(), this.getRelationDomainAssignment_Owner(), "defaultAssignment", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelationDomain_Pattern(), this.getDomainPattern(), this.getDomainPattern_RelationDomain(), "pattern", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomain_RootVariable(), thePivotPackage.getVariable(), null, "rootVariable", null, 0, -1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRelationDomainAssignmentsAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDomainAssignmentEClass, RelationDomainAssignment.class, "RelationDomainAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomainAssignment_Owner(), this.getRelationDomain(), this.getRelationDomain_DefaultAssignment(), "owner", null, 1, 1, RelationDomainAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
		initEReference(getSharedVariable_TypedModel(), theQVTbasePackage.getTypedModel(), null, "typedModel", null, 0, 1, SharedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForInitializer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleNullityForInitializer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(templateVariableEClass, TemplateVariable.class, "TemplateVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
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
		  (getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TopRelationOverriddenByTopRelation"
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
		  (getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "WhereInvocationIsANonTopRelation"
		   });
		addAnnotation
		  (getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "DataTypeInvocationIsANonTopRelation"
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
		addAnnotation
		  (getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForInitializer"
		   });
		addAnnotation
		  (getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleNullityForInitializer"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\t\t\t-- see Bugzilla 512532 discussion\n\tnot identifies.isAbstract\n\n"
		   });
		addAnnotation
		  (getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttransformation<> null implies transformation.modelParameter.usedPackage->includes(identifies.owningPackage)\n\n"
		   });
		addAnnotation
		  (getKey__ValidateNoSuperKeys__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\t\t\t-- see Bugzilla 512532 discussion\n\ttransformation <> null implies \n\tlet superClasses = identifies.superClasses->closure(superClasses) in\n\tlet otherKeys = transformation?.ownedKey?->excluding(self) in\n\totherKeys.identifies->excludesAll(superClasses)\n\n"
		   });
		addAnnotation
		  (getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttransformation <> null implies \n\tlet otherKeys = transformation?.ownedKey?->excluding(self) in\n\totherKeys.identifies->excludes(identifies)\n\n"
		   });
		addAnnotation
		  (getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toppositePart->forAll(opposite <> null)\n\n"
		   });
		addAnnotation
		  (getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toppositePart->forAll(self.identifies.conformsTo(type))\n\n"
		   });
		addAnnotation
		  (getKey__ValidatePartsAreParts__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tpart->forAll(self.identifies.conformsTo(owningClass))\n\n"
		   });
		addAnnotation
		  (getKey__ValidatePartsAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tpart->excludesAll(oppositePart.opposite)\n\n"
		   });
		addAnnotation
		  (getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tdomain->forAll(oclIsKindOf(RelationDomain))\n"
		   });
		addAnnotation
		  (getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toverridden <> null and not overridden.oclAsType(Relation).isTopLevel implies not isTopLevel\n\n"
		   });
		addAnnotation
		  (getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttransformation.oclIsKindOf(RelationalTransformation)\n\n"
		   });
		addAnnotation
		  (getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tself.argument->size() = self.referredRelation.domain.oclAsType(RelationDomain).rootVariable->size()\n"
		   });
		addAnnotation
		  (getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tlet pattern : qvtbase::Pattern = self->asOrderedSet()->closure(e : ocl::OclElement | e.oclContainer())->selectByKind(qvtbase::Pattern)->first() in\n    let relation : Relation = pattern->asOrderedSet()->closure(e : ocl::OclElement | e.oclContainer())->selectByKind(Relation)->first() in\n\trelation._where = pattern implies not referredRelation.isTopLevel\n"
		   });
		addAnnotation
		  (getRelationCallExp__ValidateDataTypeInvocationIsANonTopRelation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tself.argument->exists(type.oclIsKindOf(pivot::DataType) and not type.oclIsKindOf(pivot::CollectionType))\n\timplies not referredRelation.isTopLevel\n\t\n"
		   });
		addAnnotation
		  (getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tdefaultAssignment->isUnique(variable)\n\n"
		   });
		addAnnotation
		  (getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tvalueExp.type?.conformsTo(variable.type)\n\n"
		   });
		addAnnotation
		  (getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\trule->forAll(oclIsKindOf(Relation))\n\n"
		   });
		addAnnotation
		  (getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedInit <> null implies ownedInit.type?.conformsTo(type)\n"
		   });
		addAnnotation
		  (getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedInit <> null implies ownedInit.isRequired = isRequired\n\n"
		   });
	}

	/**
	 * Overridden to populate the idToEObjectMap/eObjectToIDMap maps when an attempt is made to use them.
	 *
	 * @generated NOT
	 */
	@Override
	protected Resource createResource(/*@NonNull*/ String uri) {
		return LazyXMIidAssigningResourceImpl.createResource(uri, this);
	}
} //QVTrelationPackageImpl
