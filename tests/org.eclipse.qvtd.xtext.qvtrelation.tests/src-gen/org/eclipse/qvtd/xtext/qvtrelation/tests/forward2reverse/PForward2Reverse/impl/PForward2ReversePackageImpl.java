/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReverseFactory;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.Telement2element;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.TemptyList2emptyList;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.Tlist2list;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl.doublylinkedlistPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PForward2ReversePackageImpl extends EPackageImpl implements PForward2ReversePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass telement2elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temptyList2emptyListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tlist2listEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PForward2ReversePackageImpl() {
		super(eNS_URI, PForward2ReverseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PForward2ReversePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PForward2ReversePackage init() {
		if (isInited) return (PForward2ReversePackage)EPackage.Registry.INSTANCE.getEPackage(PForward2ReversePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PForward2ReversePackageImpl thePForward2ReversePackage = (PForward2ReversePackageImpl)(ePackage instanceof PForward2ReversePackageImpl ? ePackage : new PForward2ReversePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		doublylinkedlistPackageImpl thedoublylinkedlistPackage = (doublylinkedlistPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(doublylinkedlistPackage.eNS_URI) instanceof doublylinkedlistPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(doublylinkedlistPackage.eNS_URI) : doublylinkedlistPackage.eINSTANCE);

		// Create package meta-data objects
		thePForward2ReversePackage.createPackageContents();
		thedoublylinkedlistPackage.createPackageContents();

		// Initialize created meta-data
		thePForward2ReversePackage.initializePackageContents();
		thedoublylinkedlistPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePForward2ReversePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PForward2ReversePackage.eNS_URI, thePForward2ReversePackage);
		return thePForward2ReversePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTelement2element() {
		return telement2elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelement2element_ElementName() {
		return (EAttribute)telement2elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ForwardElement() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ForwardList() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ForwardTarget() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ReverseElement() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ReverseList() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelement2element_ReverseSource() {
		return (EReference)telement2elementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemptyList2emptyList() {
		return temptyList2emptyListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemptyList2emptyList_ForwardList() {
		return (EReference)temptyList2emptyListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemptyList2emptyList_ListName() {
		return (EAttribute)temptyList2emptyListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemptyList2emptyList_ReverseList() {
		return (EReference)temptyList2emptyListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTlist2list() {
		return tlist2listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTlist2list_ForwardHead() {
		return (EReference)tlist2listEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTlist2list_ForwardList() {
		return (EReference)tlist2listEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTlist2list_ListName() {
		return (EAttribute)tlist2listEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTlist2list_ReverseHead() {
		return (EReference)tlist2listEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTlist2list_ReverseList() {
		return (EReference)tlist2listEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PForward2ReverseFactory getPForward2ReverseFactory() {
		return (PForward2ReverseFactory)getEFactoryInstance();
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
		telement2elementEClass = createEClass(TELEMENT2ELEMENT);
		createEAttribute(telement2elementEClass, TELEMENT2ELEMENT__ELEMENT_NAME);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__FORWARD_ELEMENT);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__FORWARD_LIST);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__FORWARD_TARGET);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__REVERSE_ELEMENT);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__REVERSE_LIST);
		createEReference(telement2elementEClass, TELEMENT2ELEMENT__REVERSE_SOURCE);

		temptyList2emptyListEClass = createEClass(TEMPTY_LIST2EMPTY_LIST);
		createEReference(temptyList2emptyListEClass, TEMPTY_LIST2EMPTY_LIST__FORWARD_LIST);
		createEAttribute(temptyList2emptyListEClass, TEMPTY_LIST2EMPTY_LIST__LIST_NAME);
		createEReference(temptyList2emptyListEClass, TEMPTY_LIST2EMPTY_LIST__REVERSE_LIST);

		tlist2listEClass = createEClass(TLIST2LIST);
		createEReference(tlist2listEClass, TLIST2LIST__FORWARD_HEAD);
		createEReference(tlist2listEClass, TLIST2LIST__FORWARD_LIST);
		createEAttribute(tlist2listEClass, TLIST2LIST__LIST_NAME);
		createEReference(tlist2listEClass, TLIST2LIST__REVERSE_HEAD);
		createEReference(tlist2listEClass, TLIST2LIST__REVERSE_LIST);
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
		doublylinkedlistPackage thedoublylinkedlistPackage = (doublylinkedlistPackage)EPackage.Registry.INSTANCE.getEPackage(doublylinkedlistPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(telement2elementEClass, Telement2element.class, "Telement2element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTelement2element_ElementName(), ecorePackage.getEString(), "elementName", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ForwardElement(), thedoublylinkedlistPackage.getElement(), null, "forwardElement", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ForwardList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "forwardList", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ForwardTarget(), thedoublylinkedlistPackage.getElement(), null, "forwardTarget", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ReverseElement(), thedoublylinkedlistPackage.getElement(), null, "reverseElement", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ReverseList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "reverseList", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelement2element_ReverseSource(), thedoublylinkedlistPackage.getElement(), null, "reverseSource", null, 1, 1, Telement2element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temptyList2emptyListEClass, TemptyList2emptyList.class, "TemptyList2emptyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemptyList2emptyList_ForwardList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "forwardList", null, 1, 1, TemptyList2emptyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemptyList2emptyList_ListName(), ecorePackage.getEString(), "listName", null, 1, 1, TemptyList2emptyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemptyList2emptyList_ReverseList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "reverseList", null, 1, 1, TemptyList2emptyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tlist2listEClass, Tlist2list.class, "Tlist2list", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTlist2list_ForwardHead(), thedoublylinkedlistPackage.getElement(), null, "forwardHead", null, 1, 1, Tlist2list.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTlist2list_ForwardList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "forwardList", null, 1, 1, Tlist2list.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTlist2list_ListName(), ecorePackage.getEString(), "listName", null, 1, 1, Tlist2list.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTlist2list_ReverseHead(), thedoublylinkedlistPackage.getElement(), null, "reverseHead", null, 1, 1, Tlist2list.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTlist2list_ReverseList(), thedoublylinkedlistPackage.getDoublyLinkedList(), null, "reverseList", null, 1, 1, Tlist2list.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/qvt#Domains
		createQvtDomainsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/qvt#Domains</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createQvtDomainsAnnotations() {
		String source = "http://www.eclipse.org/qvt#Domains";	
		addAnnotation
		  (getTelement2element_ForwardElement(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTelement2element_ForwardList(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTelement2element_ForwardTarget(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTelement2element_ReverseElement(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });	
		addAnnotation
		  (getTelement2element_ReverseList(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });	
		addAnnotation
		  (getTelement2element_ReverseSource(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });	
		addAnnotation
		  (getTemptyList2emptyList_ForwardList(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTemptyList2emptyList_ReverseList(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });	
		addAnnotation
		  (getTlist2list_ForwardHead(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTlist2list_ForwardList(), 
		   source, 
		   new String[] {
			 "referredDomain", "forward"
		   });	
		addAnnotation
		  (getTlist2list_ReverseHead(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });	
		addAnnotation
		  (getTlist2list_ReverseList(), 
		   source, 
		   new String[] {
			 "referredDomain", "reverse"
		   });
	}

} //PForward2ReversePackageImpl
