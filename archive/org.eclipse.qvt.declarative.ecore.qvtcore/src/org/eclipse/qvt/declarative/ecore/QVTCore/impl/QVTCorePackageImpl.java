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
 * $Id: QVTCorePackageImpl.java,v 1.4 2009/12/29 07:34:18 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.Assignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;
import org.eclipse.qvt.declarative.ecore.QVTCore.VariableAssignment;

import org.eclipse.qvt.declarative.ecore.QVTCore.util.QVTCoreValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTCorePackageImpl extends EPackageImpl implements QVTCorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bottomPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass corePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforcementOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realizedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enforcementModeEEnum = null;

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
	 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTCorePackageImpl() {
		super(eNS_URI, QVTCoreFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTCorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTCorePackage init() {
		if (isInited) return (QVTCorePackage)EPackage.Registry.INSTANCE.getEPackage(QVTCorePackage.eNS_URI);

		// Obtain or create and register package
		QVTCorePackageImpl theQVTCorePackage = (QVTCorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTCorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTCorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTBasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTCorePackage.createPackageContents();

		// Initialize created meta-data
		theQVTCorePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTCorePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return QVTCoreValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQVTCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTCorePackage.eNS_URI, theQVTCorePackage);
		return theQVTCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArea() {
		return areaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArea_GuardPattern() {
		return (EReference)areaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArea_BottomPattern() {
		return (EReference)areaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_BottomPattern() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Value() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_IsDefault() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBottomPattern() {
		return bottomPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPattern_Area() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPattern_Assignment() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPattern_EnforcementOperation() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBottomPattern_RealizedVariable() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreDomain() {
		return coreDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorePattern() {
		return corePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorePattern_Variable() {
		return (EReference)corePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforcementOperation() {
		return enforcementOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnforcementOperation_EnforcementMode() {
		return (EAttribute)enforcementOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforcementOperation_BottomPattern() {
		return (EReference)enforcementOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforcementOperation_OperationCallExp() {
		return (EReference)enforcementOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardPattern() {
		return guardPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuardPattern_Area() {
		return (EReference)guardPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Specification() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Local() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Context() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Refinement() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyAssignment() {
		return propertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssignment_SlotExpression() {
		return (EReference)propertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAssignment_TargetProperty() {
		return (EReference)propertyAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealizedVariable() {
		return realizedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableAssignment() {
		return variableAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableAssignment_TargetVariable() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnforcementMode() {
		return enforcementModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTCoreFactory getQVTCoreFactory() {
		return (QVTCoreFactory)getEFactoryInstance();
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
		areaEClass = createEClass(AREA);
		createEReference(areaEClass, AREA__GUARD_PATTERN);
		createEReference(areaEClass, AREA__BOTTOM_PATTERN);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__BOTTOM_PATTERN);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);
		createEAttribute(assignmentEClass, ASSIGNMENT__IS_DEFAULT);

		bottomPatternEClass = createEClass(BOTTOM_PATTERN);
		createEReference(bottomPatternEClass, BOTTOM_PATTERN__AREA);
		createEReference(bottomPatternEClass, BOTTOM_PATTERN__ASSIGNMENT);
		createEReference(bottomPatternEClass, BOTTOM_PATTERN__ENFORCEMENT_OPERATION);
		createEReference(bottomPatternEClass, BOTTOM_PATTERN__REALIZED_VARIABLE);

		coreDomainEClass = createEClass(CORE_DOMAIN);

		corePatternEClass = createEClass(CORE_PATTERN);
		createEReference(corePatternEClass, CORE_PATTERN__VARIABLE);

		enforcementOperationEClass = createEClass(ENFORCEMENT_OPERATION);
		createEAttribute(enforcementOperationEClass, ENFORCEMENT_OPERATION__ENFORCEMENT_MODE);
		createEReference(enforcementOperationEClass, ENFORCEMENT_OPERATION__BOTTOM_PATTERN);
		createEReference(enforcementOperationEClass, ENFORCEMENT_OPERATION__OPERATION_CALL_EXP);

		guardPatternEClass = createEClass(GUARD_PATTERN);
		createEReference(guardPatternEClass, GUARD_PATTERN__AREA);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__SPECIFICATION);
		createEReference(mappingEClass, MAPPING__LOCAL);
		createEReference(mappingEClass, MAPPING__CONTEXT);
		createEReference(mappingEClass, MAPPING__REFINEMENT);

		propertyAssignmentEClass = createEClass(PROPERTY_ASSIGNMENT);
		createEReference(propertyAssignmentEClass, PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		createEReference(propertyAssignmentEClass, PROPERTY_ASSIGNMENT__TARGET_PROPERTY);

		realizedVariableEClass = createEClass(REALIZED_VARIABLE);

		variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__TARGET_VARIABLE);

		// Create enums
		enforcementModeEEnum = createEEnum(ENFORCEMENT_MODE);
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
	public void initializePackageContentsGen() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
		QVTBasePackage theQVTBasePackage = (QVTBasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTBasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assignmentEClass.getESuperTypes().add(theEcorePackage_1.getEModelElement());
		bottomPatternEClass.getESuperTypes().add(this.getCorePattern());
		coreDomainEClass.getESuperTypes().add(theQVTBasePackage.getDomain());
		coreDomainEClass.getESuperTypes().add(this.getArea());
		corePatternEClass.getESuperTypes().add(theQVTBasePackage.getPattern());
		enforcementOperationEClass.getESuperTypes().add(theEcorePackage_1.getEModelElement());
		guardPatternEClass.getESuperTypes().add(this.getCorePattern());
		mappingEClass.getESuperTypes().add(theQVTBasePackage.getRule());
		mappingEClass.getESuperTypes().add(this.getArea());
		propertyAssignmentEClass.getESuperTypes().add(this.getAssignment());
		realizedVariableEClass.getESuperTypes().add(theEcorePackage.getVariable());
		variableAssignmentEClass.getESuperTypes().add(this.getAssignment());

		// Initialize classes and features; add operations and parameters
		initEClass(areaEClass, Area.class, "Area", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArea_GuardPattern(), this.getGuardPattern(), this.getGuardPattern_Area(), "guardPattern", null, 1, 1, Area.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArea_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_Area(), "bottomPattern", null, 1, 1, Area.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(areaEClass, theEcorePackage.getVariable(), "getAllVariables", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_Assignment(), "bottomPattern", null, 1, 1, Assignment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Value(), theEcorePackage.getOCLExpression(), null, "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_IsDefault(), theEcorePackage_1.getEBoolean(), "isDefault", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bottomPatternEClass, BottomPattern.class, "BottomPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBottomPattern_Area(), this.getArea(), this.getArea_BottomPattern(), "area", null, 1, 1, BottomPattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBottomPattern_Assignment(), this.getAssignment(), this.getAssignment_BottomPattern(), "assignment", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBottomPattern_EnforcementOperation(), this.getEnforcementOperation(), this.getEnforcementOperation_BottomPattern(), "enforcementOperation", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBottomPattern_RealizedVariable(), this.getRealizedVariable(), null, "realizedVariable", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(coreDomainEClass, CoreDomain.class, "CoreDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corePatternEClass, CorePattern.class, "CorePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorePattern_Variable(), theEcorePackage.getVariable(), null, "variable", null, 0, -1, CorePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(corePatternEClass, theEcorePackage.getVariable(), "getAllVariables", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(corePatternEClass, this.getArea(), "getArea", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(enforcementOperationEClass, EnforcementOperation.class, "EnforcementOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnforcementOperation_EnforcementMode(), this.getEnforcementMode(), "enforcementMode", null, 0, 1, EnforcementOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforcementOperation_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_EnforcementOperation(), "bottomPattern", null, 0, 1, EnforcementOperation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforcementOperation_OperationCallExp(), theEcorePackage.getOperationCallExp(), null, "operationCallExp", null, 1, 1, EnforcementOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardPatternEClass, GuardPattern.class, "GuardPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardPattern_Area(), this.getArea(), this.getArea_GuardPattern(), "area", null, 1, 1, GuardPattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Specification(), this.getMapping(), this.getMapping_Refinement(), "specification", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_Local(), this.getMapping(), this.getMapping_Context(), "local", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_Context(), this.getMapping(), this.getMapping_Local(), "context", null, 0, 1, Mapping.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Refinement(), this.getMapping(), this.getMapping_Specification(), "refinement", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(mappingEClass, this.getMapping(), "getAllMappings", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(propertyAssignmentEClass, PropertyAssignment.class, "PropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyAssignment_SlotExpression(), theEcorePackage.getOCLExpression(), null, "slotExpression", null, 1, 1, PropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyAssignment_TargetProperty(), theEcorePackage_1.getEStructuralFeature(), null, "targetProperty", null, 1, 1, PropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realizedVariableEClass, RealizedVariable.class, "RealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableAssignment_TargetVariable(), theEcorePackage.getVariable(), null, "targetVariable", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(enforcementModeEEnum, EnforcementMode.class, "EnforcementMode");
		addEEnumLiteral(enforcementModeEEnum, EnforcementMode.CREATION);
		addEEnumLiteral(enforcementModeEEnum, EnforcementMode.DELETION);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}
	public void initializePackageContents() {
		initializePackageContentsGen();
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/gmt/umlx/EQVTcore", this);		// FIXME Deprecate use of obsolete namespace
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
		  (assignmentEClass, 
		   source, 
		   new String[] {
			 "constraints", "MappingIsEnforceable"
		   });			
		addAnnotation
		  (bottomPatternEClass, 
		   source, 
		   new String[] {
			 "constraints", "RealizedVariableNamesAreUnique"
		   });		
		addAnnotation
		  (corePatternEClass, 
		   source, 
		   new String[] {
			 "constraints", "VariableNamesAreUnique"
		   });		
		addAnnotation
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "WellFormedName\r\nDomainTypedModelsMatchModelParameters"
		   });		
		addAnnotation
		  (propertyAssignmentEClass, 
		   source, 
		   new String[] {
			 "constraints", "TypeIsConsistent"
		   });				
		addAnnotation
		  (realizedVariableEClass, 
		   source, 
		   new String[] {
			 "constraints", "MappingIsEnforceable"
		   });		
		addAnnotation
		  (variableAssignmentEClass, 
		   source, 
		   new String[] {
			 "constraints", "TypeIsConsistent"
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
		  (getAssignment_Value(), 
		   source, 
		   new String[] {
			 "body", "valueAssignment"
		   });						
		addAnnotation
		  (getPropertyAssignment_SlotExpression(), 
		   source, 
		   new String[] {
			 "body", "slotAssignment"
		   });		
		addAnnotation
		  (getPropertyAssignment_TargetProperty(), 
		   source, 
		   new String[] {
			 "body", "assignment"
		   });				
		addAnnotation
		  (getVariableAssignment_TargetVariable(), 
		   source, 
		   new String[] {
			 "body", "assignment"
		   });
	}

} //QVTCorePackageImpl
