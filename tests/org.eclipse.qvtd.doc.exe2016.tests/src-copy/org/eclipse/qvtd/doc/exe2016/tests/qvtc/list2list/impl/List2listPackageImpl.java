/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listFactory;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class List2listPackageImpl extends EPackageImpl implements List2listPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass list2ListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass element2ElementEClass = null;

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
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private List2listPackageImpl() {
		super(eNS_URI, List2listFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link List2listPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static List2listPackage init() {
		if (isInited) return (List2listPackage)EPackage.Registry.INSTANCE.getEPackage(List2listPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		List2listPackageImpl theList2listPackage = (List2listPackageImpl)(ePackage instanceof List2listPackageImpl ? ePackage : new List2listPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DoublylinkedlistPackageImpl theDoublylinkedlistPackage = (DoublylinkedlistPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DoublylinkedlistPackage.eNS_URI) instanceof DoublylinkedlistPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DoublylinkedlistPackage.eNS_URI) : DoublylinkedlistPackage.eINSTANCE);

		// Create package meta-data objects
		theList2listPackage.createPackageContents();
		theDoublylinkedlistPackage.createPackageContents();

		// Initialize created meta-data
		theList2listPackage.initializePackageContents();
		theDoublylinkedlistPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theList2listPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(List2listPackage.eNS_URI, theList2listPackage);
		return theList2listPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getList2List() {
		return list2ListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getList2List_List1() {
		return (EReference)list2ListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getList2List_List2() {
		return (EReference)list2ListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getList2List_Element2Element() {
		return (EReference)list2ListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getList2List_Name() {
		return (EAttribute)list2ListEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElement2Element() {
		return element2ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElement2Element_Element1() {
		return (EReference)element2ElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElement2Element_Element2() {
		return (EReference)element2ElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElement2Element_List2list() {
		return (EReference)element2ElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElement2Element_Name() {
		return (EAttribute)element2ElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List2listFactory getList2listFactory() {
		return (List2listFactory)getEFactoryInstance();
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
		list2ListEClass = createEClass(LIST2_LIST);
		createEReference(list2ListEClass, LIST2_LIST__LIST1);
		createEReference(list2ListEClass, LIST2_LIST__LIST2);
		createEReference(list2ListEClass, LIST2_LIST__ELEMENT2_ELEMENT);
		createEAttribute(list2ListEClass, LIST2_LIST__NAME);

		element2ElementEClass = createEClass(ELEMENT2_ELEMENT);
		createEReference(element2ElementEClass, ELEMENT2_ELEMENT__ELEMENT1);
		createEReference(element2ElementEClass, ELEMENT2_ELEMENT__ELEMENT2);
		createEReference(element2ElementEClass, ELEMENT2_ELEMENT__LIST2LIST);
		createEAttribute(element2ElementEClass, ELEMENT2_ELEMENT__NAME);
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
		DoublylinkedlistPackage theDoublylinkedlistPackage = (DoublylinkedlistPackage)EPackage.Registry.INSTANCE.getEPackage(DoublylinkedlistPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(list2ListEClass, List2List.class, "List2List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getList2List_List1(), theDoublylinkedlistPackage.getDoublyLinkedList(), null, "list1", null, 1, 1, List2List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getList2List_List2(), theDoublylinkedlistPackage.getDoublyLinkedList(), null, "list2", null, 1, 1, List2List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getList2List_Element2Element(), this.getElement2Element(), this.getElement2Element_List2list(), "element2Element", null, 0, -1, List2List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getList2List_Name(), ecorePackage.getEString(), "name", null, 1, 1, List2List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(element2ElementEClass, Element2Element.class, "Element2Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElement2Element_Element1(), theDoublylinkedlistPackage.getElement(), null, "element1", null, 1, 1, Element2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement2Element_Element2(), theDoublylinkedlistPackage.getElement(), null, "element2", null, 1, 1, Element2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement2Element_List2list(), this.getList2List(), this.getList2List_Element2Element(), "list2list", null, 1, 1, Element2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement2Element_Name(), ecorePackage.getEString(), "name", null, 1, 1, Element2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
		// http://www.eclipse.org/qvt#Domains
		createQvtDomainsAnnotations();
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
		(getList2List_List1(),
			source,
			new String[] {
				"body", "middle1",
				"lower", "1",
				"upper", "1"
		});
		addAnnotation
		(getList2List_List2(),
			source,
			new String[] {
				"body", "middle2",
				"lower", "1",
				"upper", "1"
		});
		addAnnotation
		(getElement2Element_Element1(),
			source,
			new String[] {
				"body", "middle1",
				"lower", "1",
				"upper", "1"
		});
		addAnnotation
		(getElement2Element_Element2(),
			source,
			new String[] {
				"body", "middle2",
				"lower", "1",
				"upper", "1"
		});
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
		(getList2List_List1(),
			source,
			new String[] {
				"referredDomain", "forward"
		});
		addAnnotation
		(getList2List_List2(),
			source,
			new String[] {
				"referredDomain", "reverse"
		});
		addAnnotation
		(getElement2Element_Element1(),
			source,
			new String[] {
				"referredDomain", "forward"
		});
		addAnnotation
		(getElement2Element_Element2(),
			source,
			new String[] {
				"referredDomain", "reverse"
		});
	}

} //List2listPackageImpl
