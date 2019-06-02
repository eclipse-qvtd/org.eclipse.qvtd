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

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Model <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Model
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#getModel()
	 * @generated
	 */
	public static final int MODEL = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.Transformation
	 * @see org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage#getTransformation()
	 * @generated
	 */
	public static final int TRANSFORMATION = 1;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMATION_FEATURE_COUNT = 0;

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
		modelEClass = createEClass(MODEL);

		transformationEClass = createEClass(TRANSFORMATION);
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

		// Initialize classes and features; add operations and parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
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
