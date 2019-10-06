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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.VariableImpl;
import org.eclipse.ocl.pivot.internal.utilities.LazyXMIidAssigningResourceImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
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
		Object registeredQVTcorePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTcorePackageImpl theQVTcorePackage = registeredQVTcorePackage instanceof QVTcorePackageImpl ? (QVTcorePackageImpl)registeredQVTcorePackage : new QVTcorePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTcorePackage.createPackageContents();

		// Initialize created meta-data
		theQVTcorePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQVTcorePackage,
			 new EValidator.Descriptor() {
				 @Override
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
	public EAttribute getAssignment_IsPartial() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(3);
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
	public EOperation getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map() {
		return bottomVariableEClass.getEOperations().get(0);
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
	public EOperation getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map() {
		return guardVariableEClass.getEOperations().get(0);
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
	public EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map() {
		return oppositePropertyAssignmentEClass.getEOperations().get(4);
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
	public EOperation getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map() {
		return propertyAssignmentEClass.getEOperations().get(4);
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
	@Override
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
		areaEClass = createEClass(0);
		createEReference(areaEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(areaEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);

		assignmentEClass = createEClass(1);
		createEReference(assignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(assignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEAttribute(assignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		createEAttribute(assignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 3);

		bottomPatternEClass = createEClass(2);
		createEReference(bottomPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 1);
		createEReference(bottomPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 2);
		createEReference(bottomPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 3);
		createEReference(bottomPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 4);
		createEOperation(bottomPatternEClass, PatternImpl.PATTERN_OPERATION_COUNT + 1);

		bottomVariableEClass = createEClass(3);
		createEOperation(bottomVariableEClass, VariableImpl.VARIABLE_OPERATION_COUNT + 0);

		coreDomainEClass = createEClass(4);

		coreModelEClass = createEClass(5);

		corePatternEClass = createEClass(6);
		createEReference(corePatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 0);
		createEOperation(corePatternEClass, PatternImpl.PATTERN_OPERATION_COUNT + 0);

		enforcementOperationEClass = createEClass(7);
		createEAttribute(enforcementOperationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		createEReference(enforcementOperationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		createEReference(enforcementOperationEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 2);

		guardPatternEClass = createEClass(8);
		createEReference(guardPatternEClass, PatternImpl.PATTERN_FEATURE_COUNT + 1);
		createEOperation(guardPatternEClass, PatternImpl.PATTERN_OPERATION_COUNT + 1);

		guardVariableEClass = createEClass(9);
		createEOperation(guardVariableEClass, VariableImpl.VARIABLE_OPERATION_COUNT + 0);

		mappingEClass = createEClass(10);
		createEReference(mappingEClass, RuleImpl.RULE_FEATURE_COUNT + 2);
		createEReference(mappingEClass, RuleImpl.RULE_FEATURE_COUNT + 3);
		createEReference(mappingEClass, RuleImpl.RULE_FEATURE_COUNT + 4);
		createEReference(mappingEClass, RuleImpl.RULE_FEATURE_COUNT + 5);
		createEOperation(mappingEClass, RuleImpl.RULE_OPERATION_COUNT + 0);
		createEOperation(mappingEClass, RuleImpl.RULE_OPERATION_COUNT + 1);
		createEOperation(mappingEClass, RuleImpl.RULE_OPERATION_COUNT + 2);

		navigationAssignmentEClass = createEClass(11);
		createEReference(navigationAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 4);

		oppositePropertyAssignmentEClass = createEClass(12);
		createEReference(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
		createEOperation(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);
		createEOperation(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 1);
		createEOperation(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 2);
		createEOperation(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 3);
		createEOperation(oppositePropertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 4);

		propertyAssignmentEClass = createEClass(13);
		createEReference(propertyAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
		createEOperation(propertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);
		createEOperation(propertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 1);
		createEOperation(propertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 2);
		createEOperation(propertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 3);
		createEOperation(propertyAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 4);

		realizedVariableEClass = createEClass(14);
		createEOperation(realizedVariableEClass, VariableImpl.VARIABLE_OPERATION_COUNT + 0);

		variableAssignmentEClass = createEClass(15);
		createEReference(variableAssignmentEClass, ElementImpl.ELEMENT_FEATURE_COUNT + 4);
		createEOperation(variableAssignmentEClass, ElementImpl.ELEMENT_OPERATION_COUNT + 0);

		// Create enums
		enforcementModeEEnum = createEEnum(16);
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
		initEAttribute(getAssignment_IsDefault(), ecorePackage.getEBoolean(), "isDefault", "false", 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_IsPartial(), ecorePackage.getEBoolean(), "isPartial", "false", 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		op = initEOperation(getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForInitializer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(coreDomainEClass, CoreDomain.class, "CoreDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(coreModelEClass, CoreModel.class, "CoreModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(corePatternEClass, CorePattern.class, "CorePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorePattern_Variable(), thePivotPackage.getVariableDeclaration(), null, "variable", null, 0, -1, CorePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		op = initEOperation(getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoInitializer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

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

		op = initEOperation(getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForPartialValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForTotalValue", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForPartialValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleTypeForTotalValue", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetPropertyIsSlotProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		initEReference(getVariableAssignment_TargetVariable(), thePivotPackage.getVariableDeclaration(), null, "targetVariable", null, 1, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
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
		  (getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForInitializer"
		   });
		addAnnotation
		  (getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "VariablesAreGuardVariables"
		   });
		addAnnotation
		  (getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NoInitializer"
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
		  (getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForPartialValue"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForTotalValue"
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
		  (getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForPartialValue"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleTypeForTotalValue"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "PropertyIsNotImplicit"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TargetPropertyIsSlotProperty"
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

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tvariable->forAll(oclIsKindOf(BottomVariable))\n\n"
		   });
		addAnnotation
		  (getBottomVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedInit <> null implies ownedInit.type?.conformsTo(type)\n"
		   });
		addAnnotation
		  (getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tvariable->forAll(oclIsKindOf(GuardVariable))\n\n"
		   });
		addAnnotation
		  (getGuardVariable__ValidateNoInitializer__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedInit = null\n\n"
		   });
		addAnnotation
		  (getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tdomain->forAll(oclIsKindOf(CoreDomain))\n\n"
		   });
		addAnnotation
		  (getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t_context <> null implies name = null\n\n"
		   });
		addAnnotation
		  (getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\ttransformation <> null implies name <> null\n\n"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__GetReferredTargetProperty(),
		   source,
		   new String[] {
			   "body", "targetProperty.opposite\n\n"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tisPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForPartialValue: \' + valueType?.name + \' must conform to \' + propertyType.name + \' or vice-versa\'\n\t\t}.status\n\n"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tnot isPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType?.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForTotalValue: \' + valueType?.name + \' must conform to \' + propertyType?.name + \' or vice-versa\'\n\t\t}.status\n\n"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tgetReferredTargetProperty().isImplicit\n\t\n"
		   });
		addAnnotation
		  (getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tslotExpression.type?.conformsTo(getReferredTargetProperty().owningClass)\n\n"
		   });
		addAnnotation
		  (getPropertyAssignment__GetReferredTargetProperty(),
		   source,
		   new String[] {
			   "body", "targetProperty\n\n"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidateCompatibleTypeForPartialValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tisPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\tmessage : String = \'PropertyAssignment::CompatibleTypeForPartialValue: \' + valueType?.name + \' must conform to \' + propertyType.name + \' or vice-versa\'\n\t\t}.status\n\n"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidateCompatibleTypeForTotalValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tnot isPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType?.conformsTo(valueType),\n\t\t\tmessage : String = \'PropertyAssignment::CompatibleTypeForTotalValue: \' + valueType?.name + \' must conform to \' + propertyType?.name + \' or vice-versa\'\n\t\t}.status\n\n"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tnot targetProperty.isImplicit\n\n"
		   });
		addAnnotation
		  (getPropertyAssignment__ValidateTargetPropertyIsSlotProperty__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\tslotExpression.type?.conformsTo(getReferredTargetProperty().owningClass)\n\n"
		   });
		addAnnotation
		  (getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "not type.oclIsKindOf(ocl::DataType)\n\n"
		   });
		addAnnotation
		  (getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "Tuple {\n\tmessage : String = \'VariableAssignment::CompatibleTypeForValue: \' + value.type?.name + \' must conform to \' + targetVariable.type?.name + \' or vice-versa\',\n\tstatus : Boolean = \n\ttargetVariable.type?.conformsTo(value.type)\n\tor value.type?.conformsTo(targetVariable.type)\n\n\n}.status"
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
} //QVTcorePackageImpl
