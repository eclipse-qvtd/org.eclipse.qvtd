/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.cs2as.compiler.cgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGFactory;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CS2ASCGPackageImpl extends EPackageImpl implements CS2ASCGPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgLookupCallExpEClass = null;

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
	 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CS2ASCGPackageImpl() {
		super(eNS_URI, CS2ASCGFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CS2ASCGPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CS2ASCGPackage init() {
		if (isInited) return (CS2ASCGPackage)EPackage.Registry.INSTANCE.getEPackage(CS2ASCGPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CS2ASCGPackageImpl theCS2ASCGPackage = (CS2ASCGPackageImpl)(ePackage instanceof CS2ASCGPackageImpl ? ePackage : new CS2ASCGPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CGModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCS2ASCGPackage.createPackageContents();

		// Initialize created meta-data
		theCS2ASCGPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCS2ASCGPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CS2ASCGPackage.eNS_URI, theCS2ASCGPackage);
		return theCS2ASCGPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCGLookupCallExp() {
		return cgLookupCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CS2ASCGFactory getCS2ASCGFactory() {
		return (CS2ASCGFactory)getEFactoryInstance();
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
		cgLookupCallExpEClass = createEClass(CG_LOOKUP_CALL_EXP);
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
		CGModelPackage theCGModelPackage = (CGModelPackage)EPackage.Registry.INSTANCE.getEPackage(CGModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cgLookupCallExpEClass.getESuperTypes().add(theCGModelPackage.getCGOperationCallExp());

		// Initialize classes and features; add operations and parameters
		initEClass(cgLookupCallExpEClass, CGLookupCallExp.class, "CGLookupCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CS2ASCGPackageImpl
