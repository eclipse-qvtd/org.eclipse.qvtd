/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: TestQVTBasePackageImpl.java,v 1.3 2009/12/27 09:05:11 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;

import org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBaseFactory;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestRule;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;
import org.eclipse.qvt.declarative.test.TestQVTBase.util.TestQVTBaseValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestQVTBasePackageImpl extends EPackageImpl implements TestQVTBasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testTransformationEClass = null;

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
	 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestQVTBasePackageImpl() {
		super(eNS_URI, TestQVTBaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestQVTBasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestQVTBasePackage init() {
		if (isInited) return (TestQVTBasePackage)EPackage.Registry.INSTANCE.getEPackage(TestQVTBasePackage.eNS_URI);

		// Obtain or create and register package
		TestQVTBasePackageImpl theTestQVTBasePackage = (TestQVTBasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestQVTBasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestQVTBasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTBasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestQVTBasePackage.createPackageContents();

		// Initialize created meta-data
		theTestQVTBasePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTestQVTBasePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TestQVTBaseValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTestQVTBasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestQVTBasePackage.eNS_URI, theTestQVTBasePackage);
		return theTestQVTBasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestDomain() {
		return testDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestDomain_Contents() {
		return (EReference)testDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestExpression() {
		return testExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestPattern() {
		return testPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestPattern_Contents() {
		return (EReference)testPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestRule() {
		return testRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestRule_Contents() {
		return (EReference)testRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestTransformation() {
		return testTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestTransformation_Contents() {
		return (EReference)testTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestTransformation_StringBag() {
		return (EAttribute)testTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestTransformation_StringOrderedSet() {
		return (EAttribute)testTransformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestTransformation_StringSequence() {
		return (EAttribute)testTransformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestTransformation_StringSet() {
		return (EAttribute)testTransformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestTransformation_String() {
		return (EAttribute)testTransformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestQVTBaseFactory getTestQVTBaseFactory() {
		return (TestQVTBaseFactory)getEFactoryInstance();
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
		testDomainEClass = createEClass(TEST_DOMAIN);
		createEReference(testDomainEClass, TEST_DOMAIN__CONTENTS);

		testExpressionEClass = createEClass(TEST_EXPRESSION);

		testPatternEClass = createEClass(TEST_PATTERN);
		createEReference(testPatternEClass, TEST_PATTERN__CONTENTS);

		testRuleEClass = createEClass(TEST_RULE);
		createEReference(testRuleEClass, TEST_RULE__CONTENTS);

		testTransformationEClass = createEClass(TEST_TRANSFORMATION);
		createEReference(testTransformationEClass, TEST_TRANSFORMATION__CONTENTS);
		createEAttribute(testTransformationEClass, TEST_TRANSFORMATION__STRING_BAG);
		createEAttribute(testTransformationEClass, TEST_TRANSFORMATION__STRING_ORDERED_SET);
		createEAttribute(testTransformationEClass, TEST_TRANSFORMATION__STRING_SEQUENCE);
		createEAttribute(testTransformationEClass, TEST_TRANSFORMATION__STRING_SET);
		createEAttribute(testTransformationEClass, TEST_TRANSFORMATION__STRING);
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
		QVTBasePackage theQVTBasePackage = (QVTBasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTBasePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.ocl.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.ocl.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.ecore.EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testDomainEClass.getESuperTypes().add(theQVTBasePackage.getDomain());
		testExpressionEClass.getESuperTypes().add(theEcorePackage_1.getOCLExpression());
		testPatternEClass.getESuperTypes().add(theQVTBasePackage.getPattern());
		testRuleEClass.getESuperTypes().add(theQVTBasePackage.getRule());
		testTransformationEClass.getESuperTypes().add(theQVTBasePackage.getTransformation());

		// Initialize classes and features; add operations and parameters
		initEClass(testDomainEClass, TestDomain.class, "TestDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestDomain_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, TestDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testExpressionEClass, TestExpression.class, "TestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testPatternEClass, TestPattern.class, "TestPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestPattern_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, TestPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testRuleEClass, TestRule.class, "TestRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestRule_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, TestRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testTransformationEClass, TestTransformation.class, "TestTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestTransformation_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestTransformation_StringBag(), theEcorePackage.getEString(), "stringBag", null, 0, -1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTestTransformation_StringOrderedSet(), theEcorePackage.getEString(), "stringOrderedSet", null, 0, -1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestTransformation_StringSequence(), theEcorePackage.getEString(), "stringSequence", null, 0, -1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestTransformation_StringSet(), theEcorePackage.getEString(), "stringSet", null, 0, -1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTestTransformation_String(), theEcorePackage.getEString(), "string", null, 0, 1, TestTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
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
		  (testDomainEClass, 
		   source, 
		   new String[] {
			 "constraints", "DummyConstraint"
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
		  (getTestDomain_Contents(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });		
		addAnnotation
		  (getTestPattern_Contents(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });		
		addAnnotation
		  (getTestRule_Contents(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });		
		addAnnotation
		  (getTestTransformation_Contents(), 
		   source, 
		   new String[] {
			 "body", "owner"
		   });
	}

} //TestQVTBasePackageImpl
