/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.SimplerdbmsPackage;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simplerdbms.impl.SimplerdbmsPackageImpl;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Classifier;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PackageElement;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PrimitiveDataType;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlFactory;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.UMLModelElement;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.Simpleuml2rdbmsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleumlPackageImpl extends EPackageImpl implements SimpleumlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlModelElementEClass = null;

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
	 * @see org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimpleumlPackageImpl() {
		super(eNS_URI, SimpleumlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SimpleumlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimpleumlPackage init() {
		if (isInited) return (SimpleumlPackage)EPackage.Registry.INSTANCE.getEPackage(SimpleumlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSimpleumlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SimpleumlPackageImpl theSimpleumlPackage = registeredSimpleumlPackage instanceof SimpleumlPackageImpl ? (SimpleumlPackageImpl)registeredSimpleumlPackage : new SimpleumlPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Simpleuml2rdbmsPackage.eNS_URI);
		Simpleuml2rdbmsPackageImpl theSimpleuml2rdbmsPackage = (Simpleuml2rdbmsPackageImpl)(registeredPackage instanceof Simpleuml2rdbmsPackageImpl ? registeredPackage : Simpleuml2rdbmsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SimplerdbmsPackage.eNS_URI);
		SimplerdbmsPackageImpl theSimplerdbmsPackage = (SimplerdbmsPackageImpl)(registeredPackage instanceof SimplerdbmsPackageImpl ? registeredPackage : SimplerdbmsPackage.eINSTANCE);

		// Create package meta-data objects
		theSimpleumlPackage.createPackageContents();
		theSimpleuml2rdbmsPackage.createPackageContents();
		theSimplerdbmsPackage.createPackageContents();

		// Initialize created meta-data
		theSimpleumlPackage.initializePackageContents();
		theSimpleuml2rdbmsPackage.initializePackageContents();
		theSimplerdbmsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimpleumlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimpleumlPackage.eNS_URI, theSimpleumlPackage);
		return theSimpleumlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Owner() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Type() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Destination() {
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Forward() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_General() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_GeneralOpposite() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Reverse() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_TypeOpposite() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Elements() {
		return (EReference)packageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageElement() {
		return packageElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageElement_Namespace() {
		return (EReference)packageElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveDataType() {
		return primitiveDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLModelElement() {
		return umlModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLModelElement_Kind() {
		return (EAttribute)umlModelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUMLModelElement_Name() {
		return (EAttribute)umlModelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleumlFactory getSimpleumlFactory() {
		return (SimpleumlFactory)getEFactoryInstance();
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
		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNER);
		createEReference(attributeEClass, ATTRIBUTE__TYPE);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__DESTINATION);
		createEReference(associationEClass, ASSOCIATION__SOURCE);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEReference(classEClass, CLASS__FORWARD);
		createEReference(classEClass, CLASS__GENERAL);
		createEReference(classEClass, CLASS__GENERAL_OPPOSITE);
		createEReference(classEClass, CLASS__REVERSE);

		classifierEClass = createEClass(CLASSIFIER);
		createEReference(classifierEClass, CLASSIFIER__TYPE_OPPOSITE);

		packageEClass = createEClass(PACKAGE);
		createEReference(packageEClass, PACKAGE__ELEMENTS);

		packageElementEClass = createEClass(PACKAGE_ELEMENT);
		createEReference(packageElementEClass, PACKAGE_ELEMENT__NAMESPACE);

		primitiveDataTypeEClass = createEClass(PRIMITIVE_DATA_TYPE);

		umlModelElementEClass = createEClass(UML_MODEL_ELEMENT);
		createEAttribute(umlModelElementEClass, UML_MODEL_ELEMENT__KIND);
		createEAttribute(umlModelElementEClass, UML_MODEL_ELEMENT__NAME);
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
		attributeEClass.getESuperTypes().add(this.getUMLModelElement());
		associationEClass.getESuperTypes().add(this.getPackageElement());
		classEClass.getESuperTypes().add(this.getClassifier());
		classifierEClass.getESuperTypes().add(this.getPackageElement());
		packageEClass.getESuperTypes().add(this.getPackageElement());
		packageElementEClass.getESuperTypes().add(this.getUMLModelElement());
		primitiveDataTypeEClass.getESuperTypes().add(this.getClassifier());

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Owner(), this.getClass_(), this.getClass_Attributes(), "owner", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Type(), this.getClassifier(), this.getClassifier_TypeOpposite(), "type", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Destination(), this.getClass_(), this.getClass_Reverse(), "destination", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Source(), this.getClass_(), this.getClass_Forward(), "source", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classEClass, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_Attributes(), this.getAttribute(), this.getAttribute_Owner(), "attributes", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Forward(), this.getAssociation(), this.getAssociation_Source(), "forward", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_General(), this.getClass_(), this.getClass_GeneralOpposite(), "general", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_GeneralOpposite(), this.getClass_(), this.getClass_General(), "generalOpposite", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Reverse(), this.getAssociation(), this.getAssociation_Destination(), "reverse", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifier_TypeOpposite(), this.getAttribute(), this.getAttribute_Type(), "typeOpposite", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageEClass, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackage_Elements(), this.getPackageElement(), this.getPackageElement_Namespace(), "elements", null, 0, -1, org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageElementEClass, PackageElement.class, "PackageElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageElement_Namespace(), this.getPackage(), this.getPackage_Elements(), "namespace", null, 0, 1, PackageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveDataTypeEClass, PrimitiveDataType.class, "PrimitiveDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlModelElementEClass, UMLModelElement.class, "UMLModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLModelElement_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, UMLModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLModelElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, UMLModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SimpleumlPackageImpl
