/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package astm.lookup.impl;

import astm.AstmPackage;

import astm.lookup.LookupEnvironment;
import astm.lookup.LookupFactory;
import astm.lookup.LookupPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.pivot.evaluation.Executor;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LookupPackageImpl extends EPackageImpl implements LookupPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lookupEnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executorEClass = null;

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
	 * @see astm.lookup.LookupPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LookupPackageImpl() {
		super(eNS_URI, LookupFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LookupPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LookupPackage init() {
		if (isInited) return (LookupPackage)EPackage.Registry.INSTANCE.getEPackage(LookupPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		LookupPackageImpl theLookupPackage = (LookupPackageImpl)(ePackage instanceof LookupPackageImpl ? ePackage : new LookupPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AstmPackage.eINSTANCE.eClass();
		OCLstdlibPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLookupPackage.createPackageContents();

		// Initialize created meta-data
		theLookupPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLookupPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LookupPackage.eNS_URI, theLookupPackage);
		return theLookupPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLookupEnvironment() {
		return lookupEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLookupEnvironment_NamedElements() {
		return (EReference)lookupEnvironmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLookupEnvironment_ParentEnv() {
		return (EReference)lookupEnvironmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLookupEnvironment__AddElements__Collection() {
		return lookupEnvironmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLookupEnvironment__AddElement__Definition() {
		return lookupEnvironmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLookupEnvironment__HasFinalResult() {
		return lookupEnvironmentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLookupEnvironment__GetExecutor() {
		return lookupEnvironmentEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutor() {
		return executorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupFactory getLookupFactory() {
		return (LookupFactory)getEFactoryInstance();
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
		lookupEnvironmentEClass = createEClass(LOOKUP_ENVIRONMENT);
		createEReference(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT__NAMED_ELEMENTS);
		createEReference(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT__PARENT_ENV);
		createEOperation(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION);
		createEOperation(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT___ADD_ELEMENT__DEFINITION);
		createEOperation(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT);
		createEOperation(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT___GET_EXECUTOR);

		executorEClass = createEClass(EXECUTOR);
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
		AstmPackage theAstmPackage = (AstmPackage)EPackage.Registry.INSTANCE.getEPackage(AstmPackage.eNS_URI);
		OCLstdlibPackage theOCLstdlibPackage = (OCLstdlibPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(lookupEnvironmentEClass, LookupEnvironment.class, "LookupEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLookupEnvironment_NamedElements(), theAstmPackage.getDefinition(), null, "namedElements", null, 0, -1, LookupEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLookupEnvironment_ParentEnv(), this.getLookupEnvironment(), null, "parentEnv", null, 0, 1, LookupEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getLookupEnvironment__AddElements__Collection(), this.getLookupEnvironment(), "addElements", 1, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "NE");
		EGenericType g1 = createEGenericType(theAstmPackage.getDefinition());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(theOCLstdlibPackage.getCollection());
		EGenericType g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "elements", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLookupEnvironment__AddElement__Definition(), this.getLookupEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstmPackage.getDefinition(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLookupEnvironment__HasFinalResult(), ecorePackage.getEBoolean(), "hasFinalResult", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLookupEnvironment__GetExecutor(), this.getExecutor(), "getExecutor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(executorEClass, Executor.class, "Executor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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

} //LookupPackageImpl
