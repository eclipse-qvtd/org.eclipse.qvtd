/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.OperationImpl;
import org.eclipse.ocl.pivot.internal.utilities.LazyXMIidAssigningResourceImpl;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.TargetElementKind;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTbasePackageImpl extends EPackageImpl implements QVTbasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundTargetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTargetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetElementKindEEnum = null;

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
	 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTbasePackageImpl() {
		super(eNS_URI, QVTbaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTbasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTbasePackage init() {
		if (isInited) return (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTbasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTbasePackageImpl theQVTbasePackage = registeredQVTbasePackage instanceof QVTbasePackageImpl ? (QVTbasePackageImpl)registeredQVTbasePackage : new QVTbasePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTbasePackage.createPackageContents();

		// Initialize created meta-data
		theQVTbasePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTbasePackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return QVTbaseValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQVTbasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTbasePackage.eNS_URI, theQVTbasePackage);
		return theQVTbasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBaseModel() {
		return baseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompoundTargetElement() {
		return compoundTargetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompoundTargetElement_OwnedTargetElements() {
		return (EReference)compoundTargetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_IsCheckable() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomain_IsEnforceable() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomain_Rule() {
		return (EReference)domainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomain_TypedModel() {
		return (EReference)domainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map() {
		return domainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map() {
		return domainEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunction_QueryExpression() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map() {
		return functionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map() {
		return functionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionBody() {
		return functionBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionParameter() {
		return functionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_Predicate() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPattern_BindsTo() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_ConditionExpression() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_Pattern() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map() {
		return predicateEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Domain() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRule_IsAbstract() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Overrides() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Transformation() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_OwnedContext() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRule_Overridden() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map() {
		return ruleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRule__ValidateAtLeastOneDomainIsCheckableOrEnforceable__DiagnosticChain_Map() {
		return ruleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRule__ValidateNoOverridesCycle__DiagnosticChain_Map() {
		return ruleEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRule__ValidateAbstractRuleIsOverridden__DiagnosticChain_Map() {
		return ruleEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map() {
		return ruleEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleTargetElement() {
		return simpleTargetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleTargetElement_TypedModel() {
		return (EReference)simpleTargetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleTargetElement_Iterates() {
		return (EReference)simpleTargetElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleTargetElement_Kind() {
		return (EAttribute)simpleTargetElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTarget_OwningTransformation() {
		return (EReference)targetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTarget_OwnedTargetElements() {
		return (EReference)targetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetElement() {
		return targetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransformation() {
		return transformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_OwnedTag() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_ModelParameter() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_OwnedTargets() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_Rule() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_Extends() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformation_OwnedContext() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__GetFunction__String() {
		return transformationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__GetModelParameter__String() {
		return transformationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map() {
		return transformationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map() {
		return transformationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map() {
		return transformationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map() {
		return transformationEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedModel() {
		return typedModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedModel_Transformation() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedModel_UsedPackage() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedModel_DependsOn() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedModel_OwnedContext() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypedModel_IsPrimitive() {
		return (EAttribute)typedModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypedModel_IsThis() {
		return (EAttribute)typedModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypedModel_IsTrace() {
		return (EAttribute)typedModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedModel_Iterates() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypedModel__ValidateExclusivePrimitiveThisTrace__DiagnosticChain_Map() {
		return typedModelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTargetElementKind() {
		return targetElementKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTbaseFactory getQVTbaseFactory() {
		return (QVTbaseFactory)getEFactoryInstance();
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
		baseModelEClass = createEClass(0);

		compoundTargetElementEClass = createEClass(1);
		createEReference(compoundTargetElementEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);

		domainEClass = createEClass(2);
		createEAttribute(domainEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		createEAttribute(domainEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(domainEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		createEReference(domainEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3);
		createEOperation(domainEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1);
		createEOperation(domainEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2);

		functionEClass = createEClass(3);
		createEReference(functionEClass, OperationImpl.OPERATION_FEATURE_COUNT + 0);
		createEOperation(functionEClass, OperationImpl.OPERATION_OPERATION_COUNT + 0);
		createEOperation(functionEClass, OperationImpl.OPERATION_OPERATION_COUNT + 1);

		functionBodyEClass = createEClass(4);

		functionParameterEClass = createEClass(5);

		patternEClass = createEClass(6);
		createEReference(patternEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(patternEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);

		predicateEClass = createEClass(7);
		createEReference(predicateEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(predicateEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEOperation(predicateEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);

		ruleEClass = createEClass(8);
		createEReference(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		createEAttribute(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		createEReference(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3);
		createEReference(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4);
		createEReference(ruleEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5);
		createEOperation(ruleEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0);
		createEOperation(ruleEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1);
		createEOperation(ruleEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2);
		createEOperation(ruleEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 3);
		createEOperation(ruleEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 4);

		simpleTargetElementEClass = createEClass(9);
		createEReference(simpleTargetElementEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(simpleTargetElementEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEAttribute(simpleTargetElementEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);

		targetEClass = createEClass(10);
		createEReference(targetEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(targetEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);

		targetElementEClass = createEClass(11);

		transformationEClass = createEClass(12);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 0);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 1);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 2);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 3);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 4);
		createEReference(transformationEClass, ClassImpl.CLASS_FEATURE_COUNT + 5);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 0);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 1);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 2);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 3);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 4);
		createEOperation(transformationEClass, ClassImpl.CLASS_OPERATION_COUNT + 5);

		typedModelEClass = createEClass(13);
		createEReference(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		createEReference(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3);
		createEAttribute(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4);
		createEAttribute(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5);
		createEAttribute(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6);
		createEReference(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7);
		createEOperation(typedModelEClass, NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0);

		// Create enums
		targetElementKindEEnum = createEEnum(14);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		baseModelEClass.getESuperTypes().add(thePivotPackage.getModel());
		compoundTargetElementEClass.getESuperTypes().add(this.getTargetElement());
		domainEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		domainEClass.getESuperTypes().add(thePivotPackage.getReferringElement());
		functionEClass.getESuperTypes().add(thePivotPackage.getOperation());
		functionBodyEClass.getESuperTypes().add(thePivotPackage.getExpressionInOCL());
		functionParameterEClass.getESuperTypes().add(thePivotPackage.getParameter());
		patternEClass.getESuperTypes().add(thePivotPackage.getElement());
		predicateEClass.getESuperTypes().add(thePivotPackage.getElement());
		ruleEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		simpleTargetElementEClass.getESuperTypes().add(this.getTargetElement());
		targetEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		targetElementEClass.getESuperTypes().add(thePivotPackage.getElement());
		transformationEClass.getESuperTypes().add(thePivotPackage.getClass_());
		typedModelEClass.getESuperTypes().add(thePivotPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(baseModelEClass, BaseModel.class, "BaseModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundTargetElementEClass, CompoundTargetElement.class, "CompoundTargetElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundTargetElement_OwnedTargetElements(), this.getSimpleTargetElement(), null, "ownedTargetElements", null, 2, -1, CompoundTargetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_IsCheckable(), ecorePackage.getEBoolean(), "isCheckable", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_IsEnforceable(), ecorePackage.getEBoolean(), "isEnforceable", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_Rule(), this.getRule(), this.getRule_Domain(), "rule", null, 1, 1, Domain.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_TypedModel(), this.getTypedModel(), null, "typedModel", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsTypedModelName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypedModelIsTransformationModelParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_QueryExpression(), thePivotPackage.getOCLExpression(), null, "queryExpression", null, 0, 1, Function.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateParametersAreFunctionParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateReturnTypeIsQueryType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionBodyEClass, FunctionBody.class, "FunctionBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionParameterEClass, FunctionParameter.class, "FunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Predicate(), this.getPredicate(), this.getPredicate_Pattern(), "predicate", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPattern_BindsTo(), thePivotPackage.getVariable(), null, "bindsTo", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicate_ConditionExpression(), thePivotPackage.getOCLExpression(), null, "conditionExpression", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Pattern(), this.getPattern(), this.getPattern_Predicate(), "pattern", null, 1, 1, Predicate.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateConditionIsBoolean", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Domain(), this.getDomain(), this.getDomain_Rule(), "domain", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRule_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", "false", 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Overridden(), this.getRule(), this.getRule_Overrides(), "overridden", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Overrides(), this.getRule(), this.getRule_Overridden(), "overrides", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Transformation(), this.getTransformation(), this.getTransformation_Rule(), "transformation", null, 0, 1, Rule.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_OwnedContext(), thePivotPackage.getParameterVariable(), null, "ownedContext", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDomainNameIsUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRule__ValidateAtLeastOneDomainIsCheckableOrEnforceable__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAtLeastOneDomainIsCheckableOrEnforceable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRule__ValidateNoOverridesCycle__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoOverridesCycle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRule__ValidateAbstractRuleIsOverridden__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAbstractRuleIsOverridden", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOverridingRuleOverridesAllDomains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simpleTargetElementEClass, SimpleTargetElement.class, "SimpleTargetElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleTargetElement_TypedModel(), this.getTypedModel(), null, "typedModel", null, 1, 1, SimpleTargetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleTargetElement_Iterates(), this.getTypedModel(), null, "iterates", null, 0, -1, SimpleTargetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSimpleTargetElement_Kind(), this.getTargetElementKind(), "kind", null, 1, 1, SimpleTargetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTarget_OwningTransformation(), this.getTransformation(), this.getTransformation_OwnedTargets(), "owningTransformation", null, 1, 1, Target.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTarget_OwnedTargetElements(), this.getTargetElement(), null, "ownedTargetElements", null, 2, -1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(targetElementEClass, TargetElement.class, "TargetElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformation_OwnedTag(), thePivotPackage.getAnnotation(), null, "ownedTag", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransformation_ModelParameter(), this.getTypedModel(), this.getTypedModel_Transformation(), "modelParameter", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_OwnedTargets(), this.getTarget(), this.getTarget_OwningTransformation(), "ownedTargets", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransformation_Rule(), this.getRule(), this.getRule_Transformation(), "rule", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransformation_Extends(), this.getTransformation(), null, "extends", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_OwnedContext(), thePivotPackage.getParameter(), null, "ownedContext", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTransformation__GetFunction__String(), this.getFunction(), "getFunction", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTransformation__GetModelParameter__String(), this.getTypedModel(), "getModelParameter", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContextTypeIsTransformation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExtendedTypedModelIsExtended", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateModelParameterIsUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoExtendsCycle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typedModelEClass, TypedModel.class, "TypedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedModel_Transformation(), this.getTransformation(), this.getTransformation_ModelParameter(), "transformation", null, 1, 1, TypedModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedModel_UsedPackage(), thePivotPackage.getPackage(), null, "usedPackage", null, 0, -1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTypedModel_DependsOn(), this.getTypedModel(), null, "dependsOn", null, 0, -1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTypedModel_OwnedContext(), thePivotPackage.getParameter(), null, "ownedContext", null, 0, 1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedModel_IsPrimitive(), ecorePackage.getEBoolean(), "isPrimitive", "false", 1, 1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedModel_IsThis(), ecorePackage.getEBoolean(), "isThis", "false", 1, 1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedModel_IsTrace(), ecorePackage.getEBoolean(), "isTrace", "false", 1, 1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedModel_Iterates(), this.getTypedModel(), null, "iterates", null, 0, -1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getTypedModel__ValidateExclusivePrimitiveThisTrace__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExclusivePrimitiveThisTrace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(targetElementKindEEnum, TargetElementKind.class, "TargetElementKind");
		addEEnumLiteral(targetElementKindEEnum, TargetElementKind.INPUT);
		addEEnumLiteral(targetElementKindEEnum, TargetElementKind.VIA);
		addEEnumLiteral(targetElementKindEEnum, TargetElementKind.OUTPUT);

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
		  (getPredicate_ConditionExpression(),
		   source,
		   new String[] {
			   "body", "predicate"
		   });
		addAnnotation
		  (getTransformation_Extends(),
		   source,
		   new String[] {
			   "body", "extendedBy"
		   });
		addAnnotation
		  (getTypedModel_DependsOn(),
		   source,
		   new String[] {
			   "body", "dependent"
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
		  (getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsTypedModelName"
		   });
		addAnnotation
		  (getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypedModelIsTransformationModelParameter"
		   });
		addAnnotation
		  (getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ParametersAreFunctionParameter"
		   });
		addAnnotation
		  (getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ReturnTypeIsQueryType"
		   });
		addAnnotation
		  (getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ConditionIsBoolean"
		   });
		addAnnotation
		  (getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "DomainNameIsUnique"
		   });
		addAnnotation
		  (getRule__ValidateAtLeastOneDomainIsCheckableOrEnforceable__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "AtLeastOneDomainIsCheckableOrEnforceable"
		   });
		addAnnotation
		  (getRule__ValidateNoOverridesCycle__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NoOverridesCycle"
		   });
		addAnnotation
		  (getRule__ValidateAbstractRuleIsOverridden__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "AbstractRuleIsOverridden"
		   });
		addAnnotation
		  (getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "OverridingRuleOverridesAllDomains"
		   });
		addAnnotation
		  (getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ContextTypeIsTransformation"
		   });
		addAnnotation
		  (getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ExtendedTypedModelIsExtended"
		   });
		addAnnotation
		  (getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ModelParameterIsUnique"
		   });
		addAnnotation
		  (getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NoExtendsCycle"
		   });
		addAnnotation
		  (getTypedModel__ValidateExclusivePrimitiveThisTrace__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ExclusivePrimitiveThisTrace"
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
		  (getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttypedModel <> null implies name = typedModel.name\n\n"
		   });
		addAnnotation
		  (getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toclContainer().oclIsKindOf(Transformation) and typedModel <> null implies\n\toclContainer().oclAsType(Transformation).modelParameter->includes(typedModel)\n\n"
		   });
		addAnnotation
		  (getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\townedParameters->forAll(oclIsKindOf(FunctionParameter))\n\n"
		   });
		addAnnotation
		  (getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tqueryExpression <> null implies queryExpression.type?.conformsTo(type)\n\n"
		   });
		addAnnotation
		  (getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\nconditionExpression.type = Boolean\n\n"
		   });
		addAnnotation
		  (getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tdomain->isUnique(name)\n\n"
		   });
		addAnnotation
		  (getRule__ValidateAtLeastOneDomainIsCheckableOrEnforceable__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tdomain->notEmpty() implies domain->exists(isCheckable or isEnforceable)\n\n"
		   });
		addAnnotation
		  (getRule__ValidateNoOverridesCycle__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toverridden->closure(overridden)->excludes(self)\n\n"
		   });
		addAnnotation
		  (getRule__ValidateAbstractRuleIsOverridden__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tisAbstract implies overrides->notEmpty()\n\n"
		   });
		addAnnotation
		  (getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\toverridden <> null implies\n\toverridden.domain->forAll(od | self.domain.name->includes(od.name))\n\n"
		   });
		addAnnotation
		  (getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\townedContext <> null implies ownedContext.type.oclIsKindOf(Transformation)\n\n"
		   });
		addAnnotation
		  (getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t_extends <> null implies\n\t_extends.modelParameter->forAll(etm |\n\t\tself.modelParameter->select(name = etm.name).usedPackage->includesAll(etm.usedPackage)\n\t)\n\n"
		   });
		addAnnotation
		  (getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tmodelParameter->isUnique(name)\n\n"
		   });
		addAnnotation
		  (getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t_extends->closure(_extends)->excludes(self)\n\n"
		   });
		addAnnotation
		  (getTypedModel__ValidateExclusivePrimitiveThisTrace__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tif isPrimitive then 1 else 0 endif + if isThis then 1 else 0 endif + if isTrace then 1 else 0 endif <= 1\n\n"
		   });
	}

	/**
	 * Overridden to populate the idToEObjectMap/eObjectToIDMap maps when an attempt is made to use them.
	 *
	 * @generated NOT
	 */
	@Override
	protected Resource createResource(/*@NonNull*/ String uri) {
		Resource resource = eResource();
		if (resource == null) {
			resource = LazyXMIidAssigningResourceImpl.createResource(uri, this);
		}
		return resource;
	}
} //QVTbasePackageImpl
