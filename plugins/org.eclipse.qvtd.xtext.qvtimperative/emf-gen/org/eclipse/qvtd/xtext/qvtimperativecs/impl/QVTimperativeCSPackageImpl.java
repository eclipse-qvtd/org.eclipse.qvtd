/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ObservableStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeCSPackageImpl extends EPackageImpl implements QVTimperativeCSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declareStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inoutVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallBindingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingLoopCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observableStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationCSEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTimperativeCSPackageImpl() {
		super(eNS_URI, QVTimperativeCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTimperativeCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTimperativeCSPackage init() {
		if (isInited) return (QVTimperativeCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativeCSPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTimperativeCSPackageImpl theQVTimperativeCSPackage = (QVTimperativeCSPackageImpl)(ePackage instanceof QVTimperativeCSPackageImpl ? ePackage : new QVTimperativeCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSPackage.eINSTANCE.eClass();
		QVTimperativePackage.eINSTANCE.eClass();
		QVTbaseCSPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTimperativeCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTimperativeCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTimperativeCSPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTimperativeCSPackage.eNS_URI, theQVTimperativeCSPackage);
		return theQVTimperativeCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddStatementCS() {
		return addStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddStatementCS_OwnedExpression() {
		return (EReference)addStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddStatementCS_TargetVariable() {
		return (EReference)addStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCheckStatementCS() {
		return checkStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCheckStatementCS_OwnedCondition() {
		return (EReference)checkStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeclareStatementCS() {
		return declareStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeclareStatementCS_OwnedExpression() {
		return (EReference)declareStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeclareStatementCS_IsChecked() {
		return (EAttribute)declareStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDirectionCS() {
		return directionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDirectionCS_Imports() {
		return (EReference)directionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDirectionCS_IsChecked() {
		return (EAttribute)directionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDirectionCS_IsEnforced() {
		return (EAttribute)directionCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuardVariableCS() {
		return guardVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGuardVariableCS_ReferredTypedModel() {
		return (EReference)guardVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInoutVariableCS() {
		return inoutVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCS() {
		return mappingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedInPathName() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedGuardVariables() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedStatements() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedInoutVariables() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCallBindingCS() {
		return mappingCallBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_OwningMappingCall() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_ReferredVariable() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_OwnedValue() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCallCS() {
		return mappingCallCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCallCS_IsInfinite() {
		return (EAttribute)mappingCallCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_ReferredMapping() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_OwnedBindings() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_OwnedPathName() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingLoopCS() {
		return mappingLoopCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedIterator() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedInExpression() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedMappingStatements() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingStatementCS() {
		return mappingStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParamDeclarationCS() {
		return paramDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQueryCS() {
		return queryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_OwnedPathName() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_Transformation() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_OwnedParameters() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_OwnedExpression() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQueryCS_IsTransient() {
		return (EAttribute)queryCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNewStatementCS() {
		return newStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewStatementCS_OwnedExpression() {
		return (EReference)newStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewStatementCS_ReferredTypedModel() {
		return (EReference)newStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObservableStatementCS() {
		return observableStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObservableStatementCS_ObservedProperties() {
		return (EReference)observableStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutVariableCS() {
		return outVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetStatementCS() {
		return setStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatementCS_ReferredProperty() {
		return (EReference)setStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatementCS_ReferredVariable() {
		return (EReference)setStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatementCS_OwnedExpression() {
		return (EReference)setStatementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetStatementCS_IsNotify() {
		return (EAttribute)setStatementCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatementCS() {
		return statementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedMappings() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedQueries() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedTransformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_Package() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedDirections() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeCSFactory getQVTimperativeCSFactory() {
		return (QVTimperativeCSFactory)getEFactoryInstance();
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
		addStatementCSEClass = createEClass(ADD_STATEMENT_CS);
		createEReference(addStatementCSEClass, ADD_STATEMENT_CS__OWNED_EXPRESSION);
		createEReference(addStatementCSEClass, ADD_STATEMENT_CS__TARGET_VARIABLE);

		checkStatementCSEClass = createEClass(CHECK_STATEMENT_CS);
		createEReference(checkStatementCSEClass, CHECK_STATEMENT_CS__OWNED_CONDITION);

		declareStatementCSEClass = createEClass(DECLARE_STATEMENT_CS);
		createEReference(declareStatementCSEClass, DECLARE_STATEMENT_CS__OWNED_EXPRESSION);
		createEAttribute(declareStatementCSEClass, DECLARE_STATEMENT_CS__IS_CHECKED);

		directionCSEClass = createEClass(DIRECTION_CS);
		createEReference(directionCSEClass, DIRECTION_CS__IMPORTS);
		createEAttribute(directionCSEClass, DIRECTION_CS__IS_CHECKED);
		createEAttribute(directionCSEClass, DIRECTION_CS__IS_ENFORCED);

		guardVariableCSEClass = createEClass(GUARD_VARIABLE_CS);
		createEReference(guardVariableCSEClass, GUARD_VARIABLE_CS__REFERRED_TYPED_MODEL);

		inoutVariableCSEClass = createEClass(INOUT_VARIABLE_CS);

		mappingCSEClass = createEClass(MAPPING_CS);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_IN_PATH_NAME);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_GUARD_VARIABLES);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_INOUT_VARIABLES);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_STATEMENTS);

		mappingCallBindingCSEClass = createEClass(MAPPING_CALL_BINDING_CS);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__OWNED_VALUE);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE);

		mappingCallCSEClass = createEClass(MAPPING_CALL_CS);
		createEAttribute(mappingCallCSEClass, MAPPING_CALL_CS__IS_INFINITE);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__OWNED_BINDINGS);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__OWNED_PATH_NAME);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__REFERRED_MAPPING);

		mappingLoopCSEClass = createEClass(MAPPING_LOOP_CS);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_ITERATOR);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_IN_EXPRESSION);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_MAPPING_STATEMENTS);

		mappingStatementCSEClass = createEClass(MAPPING_STATEMENT_CS);

		newStatementCSEClass = createEClass(NEW_STATEMENT_CS);
		createEReference(newStatementCSEClass, NEW_STATEMENT_CS__OWNED_EXPRESSION);
		createEReference(newStatementCSEClass, NEW_STATEMENT_CS__REFERRED_TYPED_MODEL);

		observableStatementCSEClass = createEClass(OBSERVABLE_STATEMENT_CS);
		createEReference(observableStatementCSEClass, OBSERVABLE_STATEMENT_CS__OBSERVED_PROPERTIES);

		outVariableCSEClass = createEClass(OUT_VARIABLE_CS);

		paramDeclarationCSEClass = createEClass(PARAM_DECLARATION_CS);

		queryCSEClass = createEClass(QUERY_CS);
		createEReference(queryCSEClass, QUERY_CS__OWNED_PATH_NAME);
		createEReference(queryCSEClass, QUERY_CS__TRANSFORMATION);
		createEReference(queryCSEClass, QUERY_CS__OWNED_PARAMETERS);
		createEReference(queryCSEClass, QUERY_CS__OWNED_EXPRESSION);
		createEAttribute(queryCSEClass, QUERY_CS__IS_TRANSIENT);

		setStatementCSEClass = createEClass(SET_STATEMENT_CS);
		createEReference(setStatementCSEClass, SET_STATEMENT_CS__REFERRED_PROPERTY);
		createEReference(setStatementCSEClass, SET_STATEMENT_CS__REFERRED_VARIABLE);
		createEReference(setStatementCSEClass, SET_STATEMENT_CS__OWNED_EXPRESSION);
		createEAttribute(setStatementCSEClass, SET_STATEMENT_CS__IS_NOTIFY);

		statementCSEClass = createEClass(STATEMENT_CS);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_MAPPINGS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_QUERIES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__PACKAGE);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_DIRECTIONS);
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
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);
		QVTimperativePackage theQVTimperativePackage = (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		QVTbaseCSPackage theQVTbaseCSPackage = (QVTbaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTbaseCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		addStatementCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		addStatementCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		checkStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		checkStatementCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		declareStatementCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		declareStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		declareStatementCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		directionCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		guardVariableCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		inoutVariableCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		mappingCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		mappingCallBindingCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getExpCS());
		mappingCallCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		mappingLoopCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		mappingLoopCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		mappingStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		newStatementCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		newStatementCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		observableStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		outVariableCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		outVariableCSEClass.getESuperTypes().add(this.getStatementCS());
		paramDeclarationCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		queryCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		setStatementCSEClass.getESuperTypes().add(this.getObservableStatementCS());
		statementCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());
		transformationCSEClass.getESuperTypes().add(theQVTbaseCSPackage.getAbstractTransformationCS());

		// Initialize classes and features; add operations and parameters
		initEClass(addStatementCSEClass, AddStatementCS.class, "AddStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddStatementCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, AddStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddStatementCS_TargetVariable(), theQVTimperativePackage.getConnectionVariable(), null, "targetVariable", null, 1, 1, AddStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkStatementCSEClass, CheckStatementCS.class, "CheckStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckStatementCS_OwnedCondition(), theEssentialOCLCSPackage.getExpCS(), null, "ownedCondition", null, 1, 1, CheckStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declareStatementCSEClass, DeclareStatementCS.class, "DeclareStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclareStatementCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 1, 1, DeclareStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeclareStatementCS_IsChecked(), ecorePackage.getEBoolean(), "isChecked", "false", 0, 1, DeclareStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directionCSEClass, DirectionCS.class, "DirectionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectionCS_Imports(), thePivotPackage.getPackage(), null, "imports", null, 0, -1, DirectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectionCS_IsChecked(), ecorePackage.getEBoolean(), "isChecked", null, 0, 1, DirectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDirectionCS_IsEnforced(), ecorePackage.getEBoolean(), "isEnforced", null, 0, 1, DirectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardVariableCSEClass, GuardVariableCS.class, "GuardVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardVariableCS_ReferredTypedModel(), theQVTimperativePackage.getImperativeTypedModel(), null, "referredTypedModel", null, 1, 1, GuardVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inoutVariableCSEClass, InoutVariableCS.class, "InoutVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingCSEClass, MappingCS.class, "MappingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCS_OwnedInPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedInPathName", null, 0, 1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_OwnedGuardVariables(), this.getGuardVariableCS(), null, "ownedGuardVariables", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_OwnedInoutVariables(), this.getInoutVariableCS(), null, "ownedInoutVariables", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_OwnedStatements(), this.getStatementCS(), null, "ownedStatements", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallBindingCSEClass, MappingCallBindingCS.class, "MappingCallBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCallBindingCS_OwnedValue(), theEssentialOCLCSPackage.getExpCS(), null, "ownedValue", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_OwningMappingCall(), this.getMappingCallCS(), this.getMappingCallCS_OwnedBindings(), "owningMappingCall", null, 0, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_ReferredVariable(), thePivotPackage.getVariableDeclaration(), null, "referredVariable", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallCSEClass, MappingCallCS.class, "MappingCallCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallCS_IsInfinite(), ecorePackage.getEBoolean(), "isInfinite", "false", 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallCS_OwnedBindings(), this.getMappingCallBindingCS(), this.getMappingCallBindingCS_OwningMappingCall(), "ownedBindings", null, 0, -1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMappingCallCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallCS_ReferredMapping(), theQVTimperativePackage.getMapping(), null, "referredMapping", null, 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(mappingLoopCSEClass, MappingLoopCS.class, "MappingLoopCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingLoopCS_OwnedIterator(), theEssentialOCLCSPackage.getVariableCS(), null, "ownedIterator", null, 1, 1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoopCS_OwnedInExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInExpression", null, 1, 1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoopCS_OwnedMappingStatements(), this.getMappingStatementCS(), null, "ownedMappingStatements", null, 1, -1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingStatementCSEClass, MappingStatementCS.class, "MappingStatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newStatementCSEClass, NewStatementCS.class, "NewStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewStatementCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, NewStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewStatementCS_ReferredTypedModel(), theQVTimperativePackage.getImperativeTypedModel(), null, "referredTypedModel", null, 1, 1, NewStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observableStatementCSEClass, ObservableStatementCS.class, "ObservableStatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservableStatementCS_ObservedProperties(), theBaseCSPackage.getPathNameCS(), null, "observedProperties", null, 0, -1, ObservableStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outVariableCSEClass, OutVariableCS.class, "OutVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_Transformation(), theQVTbasePackage.getTransformation(), null, "transformation", null, 0, 1, QueryCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OwnedParameters(), this.getParamDeclarationCS(), null, "ownedParameters", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryCS_IsTransient(), ecorePackage.getEBoolean(), "isTransient", "false", 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setStatementCSEClass, SetStatementCS.class, "SetStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetStatementCS_ReferredProperty(), thePivotPackage.getProperty(), null, "referredProperty", null, 1, 1, SetStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetStatementCS_ReferredVariable(), thePivotPackage.getVariableDeclaration(), null, "referredVariable", null, 1, 1, SetStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetStatementCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 1, 1, SetStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetStatementCS_IsNotify(), ecorePackage.getEBoolean(), "isNotify", "false", 0, 1, SetStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementCSEClass, StatementCS.class, "StatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_OwnedMappings(), this.getMappingCS(), null, "ownedMappings", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_OwnedQueries(), this.getQueryCS(), null, "ownedQueries", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_OwnedTransformations(), this.getTransformationCS(), null, "ownedTransformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_Package(), thePivotPackage.getPackage(), null, "package", null, 0, 1, TransformationCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedDirections(), this.getDirectionCS(), null, "ownedDirections", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTimperativeCSTPackageImpl
