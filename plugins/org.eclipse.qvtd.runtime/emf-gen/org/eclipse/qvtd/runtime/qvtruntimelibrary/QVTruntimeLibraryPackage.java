/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.runtime.qvtruntimelibrary;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryFactory
 * @model kind="package"
 * @generated
 */
public class QVTruntimeLibraryPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "qvtruntimelibrary"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipse.org/qvt/2019/QVTruntimeLibrary"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "qvtrtlib"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTruntimeLibraryPackage eINSTANCE = org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage.init();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationEClass = null;

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
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTruntimeLibraryPackage() {
		super(eNS_URI, QVTruntimeLibraryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTruntimeLibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTruntimeLibraryPackage init() {
		if (isInited) return (QVTruntimeLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(QVTruntimeLibraryPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTruntimeLibraryPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTruntimeLibraryPackage theQVTruntimeLibraryPackage = registeredQVTruntimeLibraryPackage instanceof QVTruntimeLibraryPackage ? (QVTruntimeLibraryPackage)registeredQVTruntimeLibraryPackage : new QVTruntimeLibraryPackage();

		isInited = true;

		// Initialize simple dependencies
		OCLstdlibPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTruntimeLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theQVTruntimeLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTruntimeLibraryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTruntimeLibraryPackage.eNS_URI, theQVTruntimeLibraryPackage);
		return theQVTruntimeLibraryPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extent</em>'.
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent
	 * @generated
	 */
	public EClass getExtent() {
		return extentEClass;
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent#getElements()
	 * @see #getExtent()
	 * @generated
	 */
	public EReference getExtent_Elements() {
		return (EReference)extentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Model
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation
	 * @generated
	 */
	public EClass getTransformation() {
		return transformationEClass;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public QVTruntimeLibraryFactory getQVTruntimeLibraryFactory() {
		return (QVTruntimeLibraryFactory)getEFactoryInstance();
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
		extentEClass = createEClass(0);
		createEReference(extentEClass, 0);

		modelEClass = createEClass(1);

		transformationEClass = createEClass(2);
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
		OCLstdlibPackage theOCLstdlibPackage = (OCLstdlibPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(extentEClass, Extent.class, "Extent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExtent_Elements(), theOCLstdlibPackage.getOclElement(), null, "elements", null, 0, -1, Extent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName"; //$NON-NLS-1$
		addAnnotation
		  (getExtent_Elements(),
		   source,
		   new String[] {
			   "body", "extent" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent <em>Extent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Extent
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#getExtent()
		 * @generated
		 */
		public static final EClass EXTENT = eINSTANCE.getExtent();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EXTENT__ELEMENTS = eINSTANCE.getExtent_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Model <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Model
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#getModel()
		 * @generated
		 */
		public static final EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation
		 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#getTransformation()
		 * @generated
		 */
		public static final EClass TRANSFORMATION = eINSTANCE.getTransformation();

	}

} //QVTruntimeLibraryPackage
