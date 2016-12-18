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
package org.eclipse.qvtd.pivot.qvtcore.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementMode;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcorePackageImpl extends EPackageImpl implements QVTcorePackage {
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
	private EClass bottomVariableEClass = null;
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
	private EClass coreModelEClass = null;
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
	private EClass guardVariableEClass = null;
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
	private EClass navigationAssignmentEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyAssignmentEClass = null;
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
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTcorePackageImpl() {
		super(eNS_URI, QVTcoreFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTcorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTcorePackage init() {
		if (isInited) return (QVTcorePackage)EPackage.Registry.INSTANCE.getEPackage(QVTcorePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTcorePackageImpl theQVTcorePackage = (QVTcorePackageImpl)(ePackage instanceof QVTcorePackageImpl ? ePackage : new QVTcorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTcorePackage.createPackageContents();

		// Initialize created meta-data
		theQVTcorePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTcorePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return QVTcoreValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQVTcorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTcorePackage.eNS_URI, theQVTcorePackage);
		return theQVTcorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArea() {
		return areaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArea_GuardPattern() {
		return (EReference)areaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArea_BottomPattern() {
		return (EReference)areaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignment_BottomPattern() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssignment_Value() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssignment_IsDefault() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBottomPattern() {
		return bottomPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottomPattern_Area() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottomPattern_Assignment() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottomPattern_EnforcementOperation() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBottomPattern_RealizedVariable() {
		return (EReference)bottomPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map() {
		return bottomPatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBottomVariable() {
		return bottomVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCoreDomain() {
		return coreDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCoreModel() {
		return coreModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCorePattern() {
		return corePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCorePattern_Variable() {
		return (EReference)corePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getCorePattern__GetArea() {
		return corePatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnforcementOperation() {
		return enforcementOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnforcementOperation_EnforcementMode() {
		return (EAttribute)enforcementOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnforcementOperation_BottomPattern() {
		return (EReference)enforcementOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnforcementOperation_OperationCallExp() {
		return (EReference)enforcementOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuardPattern() {
		return guardPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGuardPattern_Area() {
		return (EReference)guardPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map() {
		return guardPatternEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuardVariable() {
		return guardVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Context() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Specification() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationAssignment() {
		return navigationAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationAssignment_SlotExpression() {
		return (EReference)navigationAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOppositePropertyAssignment() {
		return oppositePropertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOppositePropertyAssignment_TargetProperty() {
		return (EReference)oppositePropertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__GetReferredTargetProperty() {
		return oppositePropertyAssignmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyAssignment() {
		return propertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyAssignment_TargetProperty() {
		return (EReference)propertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__GetReferredTargetProperty() {
		return propertyAssignmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRealizedVariable() {
		return realizedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map() {
		return realizedVariableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableAssignment() {
		return variableAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAssignment_TargetVariable() {
		return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map() {
		return variableAssignmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEnforcementMode() {
		return enforcementModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Local() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_Refinement() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTcoreFactory getQVTcoreFactory() {
		return (QVTcoreFactory)getEFactoryInstance();
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
		createEOperation(bottomPatternEClass, BOTTOM_PATTERN___VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES__DIAGNOSTICCHAIN_MAP);

		bottomVariableEClass = createEClass(BOTTOM_VARIABLE);

		coreDomainEClass = createEClass(CORE_DOMAIN);

		coreModelEClass = createEClass(CORE_MODEL);

		corePatternEClass = createEClass(CORE_PATTERN);
		createEReference(corePatternEClass, CORE_PATTERN__VARIABLE);
		createEOperation(corePatternEClass, CORE_PATTERN___GET_AREA);

		enforcementOperationEClass = createEClass(ENFORCEMENT_OPERATION);
		createEAttribute(enforcementOperationEClass, ENFORCEMENT_OPERATION__ENFORCEMENT_MODE);
		createEReference(enforcementOperationEClass, ENFORCEMENT_OPERATION__BOTTOM_PATTERN);
		createEReference(enforcementOperationEClass, ENFORCEMENT_OPERATION__OPERATION_CALL_EXP);

		guardPatternEClass = createEClass(GUARD_PATTERN);
		createEReference(guardPatternEClass, GUARD_PATTERN__AREA);
		createEOperation(guardPatternEClass, GUARD_PATTERN___VALIDATE_VARIABLES_ARE_GUARD_VARIABLES__DIAGNOSTICCHAIN_MAP);

		guardVariableEClass = createEClass(GUARD_VARIABLE);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__CONTEXT);
		createEReference(mappingEClass, MAPPING__LOCAL);
		createEReference(mappingEClass, MAPPING__REFINEMENT);
		createEReference(mappingEClass, MAPPING__SPECIFICATION);
		createEOperation(mappingEClass, MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingEClass, MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingEClass, MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP);

		navigationAssignmentEClass = createEClass(NAVIGATION_ASSIGNMENT);
		createEReference(navigationAssignmentEClass, NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION);

		oppositePropertyAssignmentEClass = createEClass(OPPOSITE_PROPERTY_ASSIGNMENT);
		createEReference(oppositePropertyAssignmentEClass, OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY);
		createEOperation(oppositePropertyAssignmentEClass, OPPOSITE_PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY);
		createEOperation(oppositePropertyAssignmentEClass, OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
		createEOperation(oppositePropertyAssignmentEClass, OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT__DIAGNOSTICCHAIN_MAP);
		createEOperation(oppositePropertyAssignmentEClass, OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP);

		propertyAssignmentEClass = createEClass(PROPERTY_ASSIGNMENT);
		createEReference(propertyAssignmentEClass, PROPERTY_ASSIGNMENT__TARGET_PROPERTY);
		createEOperation(propertyAssignmentEClass, PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY);
		createEOperation(propertyAssignmentEClass, PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
		createEOperation(propertyAssignmentEClass, PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP);
		createEOperation(propertyAssignmentEClass, PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP);

		realizedVariableEClass = createEClass(REALIZED_VARIABLE);
		createEOperation(realizedVariableEClass, REALIZED_VARIABLE___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP);

		variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
		createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__TARGET_VARIABLE);
		createEOperation(variableAssignmentEClass, VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);

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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		areaEClass.getESuperTypes().add(thePivotPackage.getElement());
		assignmentEClass.getESuperTypes().add(thePivotPackage.getElement());
		bottomPatternEClass.getESuperTypes().add(this.getCorePattern());
		bottomVariableEClass.getESuperTypes().add(thePivotPackage.getVariable());
		coreDomainEClass.getESuperTypes().add(theQVTbasePackage.getDomain());
		coreDomainEClass.getESuperTypes().add(this.getArea());
		coreModelEClass.getESuperTypes().add(theQVTbasePackage.getBaseModel());
		corePatternEClass.getESuperTypes().add(theQVTbasePackage.getPattern());
		enforcementOperationEClass.getESuperTypes().add(thePivotPackage.getElement());
		guardPatternEClass.getESuperTypes().add(this.getCorePattern());
		guardVariableEClass.getESuperTypes().add(thePivotPackage.getVariable());
		mappingEClass.getESuperTypes().add(theQVTbasePackage.getRule());
		mappingEClass.getESuperTypes().add(this.getArea());
		navigationAssignmentEClass.getESuperTypes().add(this.getAssignment());
		oppositePropertyAssignmentEClass.getESuperTypes().add(this.getNavigationAssignment());
		propertyAssignmentEClass.getESuperTypes().add(this.getNavigationAssignment());
		realizedVariableEClass.getESuperTypes().add(thePivotPackage.getVariable());
		variableAssignmentEClass.getESuperTypes().add(this.getAssignment());

		// Initialize classes, features, and operations; add parameters
		initEClass(areaEClass, Area.class, "Area", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArea_GuardPattern(), this.getGuardPattern(), this.getGuardPattern_Area(), "guardPattern", null, 1, 1, Area.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArea_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_Area(), "bottomPattern", null, 1, 1, Area.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_Assignment(), "bottomPattern", null, 1, 1, Assignment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_IsDefault(), ecorePackage.getEBoolean(), "isDefault", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bottomPatternEClass, BottomPattern.class, "BottomPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBottomPattern_Area(), this.getArea(), this.getArea_BottomPattern(), "area", null, 1, 1, BottomPattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBottomPattern_Assignment(), this.getAssignment(), this.getAssignment_BottomPattern(), "assignment", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBottomPattern_EnforcementOperation(), this.getEnforcementOperation(), this.getEnforcementOperation_BottomPattern(), "enforcementOperation", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBottomPattern_RealizedVariable(), this.getRealizedVariable(), null, "realizedVariable", null, 0, -1, BottomPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateVariablesAreBottomVariables", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bottomVariableEClass, BottomVariable.class, "BottomVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(coreDomainEClass, CoreDomain.class, "CoreDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(coreModelEClass, CoreModel.class, "CoreModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corePatternEClass, CorePattern.class, "CorePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorePattern_Variable(), thePivotPackage.getVariable(), null, "variable", null, 0, -1, CorePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getCorePattern__GetArea(), this.getArea(), "getArea", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(enforcementOperationEClass, EnforcementOperation.class, "EnforcementOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnforcementOperation_EnforcementMode(), this.getEnforcementMode(), "enforcementMode", null, 0, 1, EnforcementOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforcementOperation_BottomPattern(), this.getBottomPattern(), this.getBottomPattern_EnforcementOperation(), "bottomPattern", null, 0, 1, EnforcementOperation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforcementOperation_OperationCallExp(), thePivotPackage.getOperationCallExp(), null, "operationCallExp", null, 1, 1, EnforcementOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardPatternEClass, GuardPattern.class, "GuardPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardPattern_Area(), this.getArea(), this.getArea_GuardPattern(), "area", null, 1, 1, GuardPattern.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateVariablesAreGuardVariables", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(guardVariableEClass, GuardVariable.class, "GuardVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Context(), this.getMapping(), this.getMapping_Local(), "context", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_Local(), this.getMapping(), this.getMapping_Context(), "local", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_Refinement(), this.getMapping(), this.getMapping_Specification(), "refinement", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_Specification(), this.getMapping(), this.getMapping_Refinement(), "specification", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDomainsAreCoreDomains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNestedNameIsNull", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRootNameIsNotNull", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(navigationAssignmentEClass, NavigationAssignment.class, "NavigationAssignment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationAssignment_SlotExpression(), thePivotPackage.getOCLExpression(), null, "slotExpression", null, 1, 1, NavigationAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oppositePropertyAssignmentEClass, OppositePropertyAssignment.class, "OppositePropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOppositePropertyAssignment_TargetProperty(), thePivotPackage.getProperty(), null, "targetProperty", null, 1, 1, OppositePropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOppositePropertyAssignment__GetReferredTargetProperty(), thePivotPackage.getProperty(), "getReferredTargetProperty", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOppositePropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOppositePropertyIsImplicit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetPropetyIsSlotProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyAssignmentEClass, PropertyAssignment.class, "PropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyAssignment_TargetProperty(), thePivotPackage.getProperty(), null, "targetProperty", null, 1, 1, PropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPropertyAssignment__GetReferredTargetProperty(), thePivotPackage.getProperty(), "getReferredTargetProperty", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePropertyIsNotImplicit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetPropetyIsSlotProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(realizedVariableEClass, RealizedVariable.class, "RealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNonDataTypeForType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableAssignment_TargetVariable(), thePivotPackage.getVariable(), null, "targetVariable", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

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
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
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
		  (getAssignment_Value(), 
		   source, 
		   new String[] {
			 "body", "valueAssignment"
		   });	
		addAnnotation
		  (getNavigationAssignment_SlotExpression(), 
		   source, 
		   new String[] {
			 "body", "slotAssignment"
		   });	
		addAnnotation
		  (getOppositePropertyAssignment_TargetProperty(), 
		   source, 
		   new String[] {
			 "body", "assignment"
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

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";	
		addAnnotation
		  (getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "VariablesAreBottomVariables"
		   });	
		addAnnotation
		  (getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "VariablesAreGuardVariables"
		   });	
		addAnnotation
		  (getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "DomainsAreCoreDomains"
		   });	
		addAnnotation
		  (getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "NestedNameIsNull"
		   });	
		addAnnotation
		  (getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "RootNameIsNotNull"
		   });	
		addAnnotation
		  (getOppositePropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "CompatibleTypeForValue"
		   });	
		addAnnotation
		  (getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "OppositePropertyIsImplicit"
		   });	
		addAnnotation
		  (getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "TargetPropetyIsSlotProperty"
		   });	
		addAnnotation
		  (getPropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "CompatibleTypeForValue"
		   });	
		addAnnotation
		  (getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "PropertyIsNotImplicit"
		   });	
		addAnnotation
		  (getPropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "TargetPropetyIsSlotProperty"
		   });	
		addAnnotation
		  (getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "NonDataTypeForType"
		   });	
		addAnnotation
		  (getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "originalName", "CompatibleTypeForValue"
		   });
	}

} //QVTcorePackageImpl
