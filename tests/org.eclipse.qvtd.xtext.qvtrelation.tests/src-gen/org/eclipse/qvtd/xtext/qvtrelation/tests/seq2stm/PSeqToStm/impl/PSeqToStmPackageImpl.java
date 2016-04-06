/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmFactory;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TInteractionToStateMachine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.TStateToState;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl.SeqMMPackageImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PSeqToStmPackageImpl extends EPackageImpl implements PSeqToStmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInteractionToStateMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tStateToStateEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PSeqToStmPackageImpl() {
		super(eNS_URI, PSeqToStmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PSeqToStmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PSeqToStmPackage init() {
		if (isInited) return (PSeqToStmPackage)EPackage.Registry.INSTANCE.getEPackage(PSeqToStmPackage.eNS_URI);

		// Obtain or create and register package
		PSeqToStmPackageImpl thePSeqToStmPackage = (PSeqToStmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PSeqToStmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PSeqToStmPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SeqMMPackageImpl theSeqMMPackage = (SeqMMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeqMMPackage.eNS_URI) instanceof SeqMMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeqMMPackage.eNS_URI) : SeqMMPackage.eINSTANCE);
		StmcMMPackageImpl theStmcMMPackage = (StmcMMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StmcMMPackage.eNS_URI) instanceof StmcMMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StmcMMPackage.eNS_URI) : StmcMMPackage.eINSTANCE);

		// Create package meta-data objects
		thePSeqToStmPackage.createPackageContents();
		theSeqMMPackage.createPackageContents();
		theStmcMMPackage.createPackageContents();

		// Initialize created meta-data
		thePSeqToStmPackage.initializePackageContents();
		theSeqMMPackage.initializePackageContents();
		theStmcMMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePSeqToStmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PSeqToStmPackage.eNS_URI, thePSeqToStmPackage);
		return thePSeqToStmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInteractionToStateMachine() {
		return tInteractionToStateMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInteractionToStateMachine_Sn() {
		return (EAttribute)tInteractionToStateMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInteractionToStateMachine_I() {
		return (EReference)tInteractionToStateMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInteractionToStateMachine_S() {
		return (EReference)tInteractionToStateMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTStateToState() {
		return tStateToStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTStateToState_Sn() {
		return (EAttribute)tStateToStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_St1() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_Set() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_L() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_I() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState__4() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_St2() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTStateToState_S() {
		return (EReference)tStateToStateEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSeqToStmFactory getPSeqToStmFactory() {
		return (PSeqToStmFactory)getEFactoryInstance();
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
		tInteractionToStateMachineEClass = createEClass(TINTERACTION_TO_STATE_MACHINE);
		createEAttribute(tInteractionToStateMachineEClass, TINTERACTION_TO_STATE_MACHINE__SN);
		createEReference(tInteractionToStateMachineEClass, TINTERACTION_TO_STATE_MACHINE__I);
		createEReference(tInteractionToStateMachineEClass, TINTERACTION_TO_STATE_MACHINE__S);

		tStateToStateEClass = createEClass(TSTATE_TO_STATE);
		createEAttribute(tStateToStateEClass, TSTATE_TO_STATE__SN);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__ST1);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__SET);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__L);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__I);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__4);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__ST2);
		createEReference(tStateToStateEClass, TSTATE_TO_STATE__S);
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
		SeqMMPackage theSeqMMPackage = (SeqMMPackage)EPackage.Registry.INSTANCE.getEPackage(SeqMMPackage.eNS_URI);
		StmcMMPackage theStmcMMPackage = (StmcMMPackage)EPackage.Registry.INSTANCE.getEPackage(StmcMMPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(tInteractionToStateMachineEClass, TInteractionToStateMachine.class, "TInteractionToStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTInteractionToStateMachine_Sn(), ecorePackage.getEString(), "sn", null, 1, 1, TInteractionToStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInteractionToStateMachine_I(), theSeqMMPackage.getInteraction(), null, "i", null, 1, 1, TInteractionToStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInteractionToStateMachine_S(), theStmcMMPackage.getStateMachine(), null, "s", null, 1, 1, TInteractionToStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tStateToStateEClass, TStateToState.class, "TStateToState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTStateToState_Sn(), ecorePackage.getEString(), "sn", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTStateToState_St1(), theSeqMMPackage.getState(), null, "st1", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTStateToState_Set(), theSeqMMPackage.getLifeLine(), null, "set", null, 0, -1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTStateToState_L(), theSeqMMPackage.getLifeLine(), null, "l", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTStateToState_I(), theSeqMMPackage.getInteraction(), null, "i", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTStateToState__4(), theSeqMMPackage.getLifeLine(), null, "_4", null, 0, -1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTStateToState_St2(), theStmcMMPackage.getState(), null, "st2", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTStateToState_S(), theStmcMMPackage.getStateMachine(), null, "s", null, 1, 1, TStateToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
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
		  (getTInteractionToStateMachine_I(), 
		   source, 
		   new String[] {
			 "body", "TInteractionToStateMachine",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTInteractionToStateMachine_S(), 
		   source, 
		   new String[] {
			 "body", "TInteractionToStateMachine",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTStateToState_St1(), 
		   source, 
		   new String[] {
			 "body", "TStateToState",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTStateToState_L(), 
		   source, 
		   new String[] {
			 "body", "TStateToState",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTStateToState_I(), 
		   source, 
		   new String[] {
			 "body", "TStateToState",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTStateToState_St2(), 
		   source, 
		   new String[] {
			 "body", "TStateToState",
			 "lower", "1"
		   });	
		addAnnotation
		  (getTStateToState_S(), 
		   source, 
		   new String[] {
			 "body", "TStateToState",
			 "lower", "1"
		   });
	}

} //PSeqToStmPackageImpl
