/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.FamiliesPackageImpl;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Member2Female;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Member2Male;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.MemberToPerson;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.impl.PersonsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Families2PersonsPackageImpl extends EPackageImpl implements Families2PersonsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberToPersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass member2MaleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass member2FemaleEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Families2PersonsPackageImpl() {
		super(eNS_URI, Families2PersonsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Families2PersonsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Families2PersonsPackage init() {
		if (isInited) return (Families2PersonsPackage)EPackage.Registry.INSTANCE.getEPackage(Families2PersonsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFamilies2PersonsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Families2PersonsPackageImpl theFamilies2PersonsPackage = registeredFamilies2PersonsPackage instanceof Families2PersonsPackageImpl ? (Families2PersonsPackageImpl)registeredFamilies2PersonsPackage : new Families2PersonsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(FamiliesPackage.eNS_URI);
		FamiliesPackageImpl theFamiliesPackage = (FamiliesPackageImpl)(registeredPackage instanceof FamiliesPackageImpl ? registeredPackage : FamiliesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PersonsPackage.eNS_URI);
		PersonsPackageImpl thePersonsPackage = (PersonsPackageImpl)(registeredPackage instanceof PersonsPackageImpl ? registeredPackage : PersonsPackage.eINSTANCE);

		// Create package meta-data objects
		theFamilies2PersonsPackage.createPackageContents();
		theFamiliesPackage.createPackageContents();
		thePersonsPackage.createPackageContents();

		// Initialize created meta-data
		theFamilies2PersonsPackage.initializePackageContents();
		theFamiliesPackage.initializePackageContents();
		thePersonsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFamilies2PersonsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Families2PersonsPackage.eNS_URI, theFamilies2PersonsPackage);
		return theFamilies2PersonsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMemberToPerson() {
		return memberToPersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemberToPerson_Member() {
		return (EReference)memberToPersonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMemberToPerson_Person() {
		return (EReference)memberToPersonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMemberToPerson_FirstName() {
		return (EAttribute)memberToPersonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMemberToPerson_FamilyName() {
		return (EAttribute)memberToPersonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMember2Male() {
		return member2MaleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMember2Female() {
		return member2FemaleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Families2PersonsFactory getFamilies2PersonsFactory() {
		return (Families2PersonsFactory)getEFactoryInstance();
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
		memberToPersonEClass = createEClass(0);
		createEReference(memberToPersonEClass, 0);
		createEReference(memberToPersonEClass, 1);
		createEAttribute(memberToPersonEClass, 2);
		createEAttribute(memberToPersonEClass, 3);

		member2MaleEClass = createEClass(1);

		member2FemaleEClass = createEClass(2);
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
		FamiliesPackage theFamiliesPackage = (FamiliesPackage)EPackage.Registry.INSTANCE.getEPackage(FamiliesPackage.eNS_URI);
		PersonsPackage thePersonsPackage = (PersonsPackage)EPackage.Registry.INSTANCE.getEPackage(PersonsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		member2MaleEClass.getESuperTypes().add(this.getMemberToPerson());
		member2FemaleEClass.getESuperTypes().add(this.getMemberToPerson());

		// Initialize classes, features, and operations; add parameters
		initEClass(memberToPersonEClass, MemberToPerson.class, "MemberToPerson", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemberToPerson_Member(), theFamiliesPackage.getMember(), null, "member", null, 0, 1, MemberToPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemberToPerson_Person(), thePersonsPackage.getPerson(), null, "person", null, 0, 1, MemberToPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberToPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, MemberToPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberToPerson_FamilyName(), ecorePackage.getEString(), "familyName", null, 0, 1, MemberToPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(member2MaleEClass, Member2Male.class, "Member2Male", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(member2FemaleEClass, Member2Female.class, "Member2Female", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (getMemberToPerson_Member(),
		   source,
		   new String[] {
			   "body", "middle",
			   "upper", "1"
		   });
		addAnnotation
		  (getMemberToPerson_Person(),
		   source,
		   new String[] {
			   "body", "middle",
			   "upper", "1"
		   });
	}

} //Families2PersonsPackageImpl
