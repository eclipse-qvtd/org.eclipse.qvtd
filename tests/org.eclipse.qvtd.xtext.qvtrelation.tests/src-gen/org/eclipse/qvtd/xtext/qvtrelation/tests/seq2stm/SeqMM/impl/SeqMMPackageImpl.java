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
package org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.PSeqToStmPackage;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.PSeqToStm.impl.PSeqToStmPackageImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Dummy;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Event;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Interaction;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.LifeLine;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.Message;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEvent;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.MessageEventType;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMFactory;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.State;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.StmcMMPackage;

import org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.StmcMM.impl.StmcMMPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SeqMMPackageImpl extends EPackageImpl implements SeqMMPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dummyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifeLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum messageEventTypeEEnum = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.seq2stm.SeqMM.SeqMMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SeqMMPackageImpl() {
		super(eNS_URI, SeqMMFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SeqMMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SeqMMPackage init() {
		if (isInited) return (SeqMMPackage)EPackage.Registry.INSTANCE.getEPackage(SeqMMPackage.eNS_URI);

		// Obtain or create and register package
		SeqMMPackageImpl theSeqMMPackage = (SeqMMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SeqMMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SeqMMPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PSeqToStmPackageImpl thePSeqToStmPackage = (PSeqToStmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PSeqToStmPackage.eNS_URI) instanceof PSeqToStmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PSeqToStmPackage.eNS_URI) : PSeqToStmPackage.eINSTANCE);
		StmcMMPackageImpl theStmcMMPackage = (StmcMMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StmcMMPackage.eNS_URI) instanceof StmcMMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StmcMMPackage.eNS_URI) : StmcMMPackage.eINSTANCE);

		// Create package meta-data objects
		theSeqMMPackage.createPackageContents();
		thePSeqToStmPackage.createPackageContents();
		theStmcMMPackage.createPackageContents();

		// Initialize created meta-data
		theSeqMMPackage.initializePackageContents();
		thePSeqToStmPackage.initializePackageContents();
		theStmcMMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSeqMMPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SeqMMPackage.eNS_URI, theSeqMMPackage);
		return theSeqMMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDummy() {
		return dummyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDummy_HasInteraction() {
		return (EReference)dummyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDummy_ContainedState() {
		return (EReference)dummyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteraction_Name() {
		return (EAttribute)interactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Lifeline() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Message() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifeLine() {
		return lifeLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifeLine_Name() {
		return (EAttribute)lifeLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeLine_MsgEvent() {
		return (EReference)lifeLineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeLine_State() {
		return (EReference)lifeLineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLifeLine_Interaction() {
		return (EReference)lifeLineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessage_MessageId() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Interaction() {
		return (EReference)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_Event() {
		return (EReference)messageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Name() {
		return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_Messageevent() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_Lifeline() {
		return (EReference)stateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageEvent() {
		return messageEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageEvent_Type() {
		return (EAttribute)messageEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEvent_Prev() {
		return (EReference)messageEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEvent_Next() {
		return (EReference)messageEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEvent_Message() {
		return (EReference)messageEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEvent_Lifeline() {
		return (EReference)messageEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEvent_State() {
		return (EReference)messageEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMessageEventType() {
		return messageEventTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeqMMFactory getSeqMMFactory() {
		return (SeqMMFactory)getEFactoryInstance();
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
		dummyEClass = createEClass(DUMMY);
		createEReference(dummyEClass, DUMMY__HAS_INTERACTION);
		createEReference(dummyEClass, DUMMY__CONTAINED_STATE);

		interactionEClass = createEClass(INTERACTION);
		createEAttribute(interactionEClass, INTERACTION__NAME);
		createEReference(interactionEClass, INTERACTION__LIFELINE);
		createEReference(interactionEClass, INTERACTION__MESSAGE);

		lifeLineEClass = createEClass(LIFE_LINE);
		createEAttribute(lifeLineEClass, LIFE_LINE__NAME);
		createEReference(lifeLineEClass, LIFE_LINE__MSG_EVENT);
		createEReference(lifeLineEClass, LIFE_LINE__STATE);
		createEReference(lifeLineEClass, LIFE_LINE__INTERACTION);

		messageEClass = createEClass(MESSAGE);
		createEAttribute(messageEClass, MESSAGE__MESSAGE_ID);
		createEReference(messageEClass, MESSAGE__INTERACTION);
		createEReference(messageEClass, MESSAGE__EVENT);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__NAME);
		createEReference(stateEClass, STATE__MESSAGEEVENT);
		createEReference(stateEClass, STATE__LIFELINE);

		eventEClass = createEClass(EVENT);

		messageEventEClass = createEClass(MESSAGE_EVENT);
		createEAttribute(messageEventEClass, MESSAGE_EVENT__TYPE);
		createEReference(messageEventEClass, MESSAGE_EVENT__PREV);
		createEReference(messageEventEClass, MESSAGE_EVENT__NEXT);
		createEReference(messageEventEClass, MESSAGE_EVENT__MESSAGE);
		createEReference(messageEventEClass, MESSAGE_EVENT__LIFELINE);
		createEReference(messageEventEClass, MESSAGE_EVENT__STATE);

		// Create enums
		messageEventTypeEEnum = createEEnum(MESSAGE_EVENT_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		messageEventEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes, features, and operations; add parameters
		initEClass(dummyEClass, Dummy.class, "Dummy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDummy_HasInteraction(), this.getInteraction(), null, "hasInteraction", null, 1, -1, Dummy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDummy_ContainedState(), this.getState(), null, "containedState", null, 1, -1, Dummy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteraction_Name(), ecorePackage.getEString(), "name", null, 1, 1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInteraction_Lifeline(), this.getLifeLine(), this.getLifeLine_Interaction(), "lifeline", null, 1, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInteraction_Message(), this.getMessage(), this.getMessage_Interaction(), "message", null, 1, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lifeLineEClass, LifeLine.class, "LifeLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLifeLine_Name(), ecorePackage.getEString(), "name", null, 1, 1, LifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLifeLine_MsgEvent(), this.getMessageEvent(), this.getMessageEvent_Lifeline(), "msgEvent", null, 1, -1, LifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLifeLine_State(), this.getState(), this.getState_Lifeline(), "state", null, 1, -1, LifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLifeLine_Interaction(), this.getInteraction(), this.getInteraction_Lifeline(), "interaction", null, 1, 1, LifeLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessage_MessageId(), ecorePackage.getEString(), "messageId", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessage_Interaction(), this.getInteraction(), this.getInteraction_Message(), "interaction", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessage_Event(), this.getMessageEvent(), this.getMessageEvent_Message(), "event", null, 1, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_Messageevent(), this.getMessageEvent(), this.getMessageEvent_State(), "messageevent", null, 1, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_Lifeline(), this.getLifeLine(), this.getLifeLine_State(), "lifeline", null, 1, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageEventEClass, MessageEvent.class, "MessageEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageEvent_Type(), this.getMessageEventType(), "type", "Send", 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEvent_Prev(), this.getMessageEvent(), null, "prev", null, 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEvent_Next(), this.getMessageEvent(), null, "next", null, 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEvent_Message(), this.getMessage(), this.getMessage_Event(), "message", null, 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEvent_Lifeline(), this.getLifeLine(), this.getLifeLine_MsgEvent(), "lifeline", null, 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEvent_State(), this.getState(), this.getState_Messageevent(), "state", null, 1, 1, MessageEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(messageEventTypeEEnum, MessageEventType.class, "MessageEventType");
		addEEnumLiteral(messageEventTypeEEnum, MessageEventType.SEND);
		addEEnumLiteral(messageEventTypeEEnum, MessageEventType.RECEIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //SeqMMPackageImpl
