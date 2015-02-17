/**
 */
package classescstraces.impl;

import classes.ClassesPackage;

import classes.impl.ClassesPackageImpl;

import classescs.ClassescsPackage;

import classescs.impl.ClassescsPackageImpl;

import classescstraces.ClassCS2Class;
import classescstraces.ClassescstracesFactory;
import classescstraces.ClassescstracesPackage;
import classescstraces.PackageCS2Package;
import classescstraces.RootCS2Root;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassescstracesPackageImpl extends EPackageImpl implements ClassescstracesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageCS2PackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCS2ClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootCS2RootEClass = null;

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
	 * @see classescstraces.ClassescstracesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ClassescstracesPackageImpl() {
		super(eNS_URI, ClassescstracesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ClassescstracesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ClassescstracesPackage init() {
		if (isInited) return (ClassescstracesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassescstracesPackage.eNS_URI);

		// Obtain or create and register package
		ClassescstracesPackageImpl theClassescstracesPackage = (ClassescstracesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClassescstracesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClassescstracesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ClassescsPackageImpl theClassescsPackage = (ClassescsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassescsPackage.eNS_URI) instanceof ClassescsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassescsPackage.eNS_URI) : ClassescsPackage.eINSTANCE);
		ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);

		// Create package meta-data objects
		theClassescstracesPackage.createPackageContents();
		theClassescsPackage.createPackageContents();
		theClassesPackage.createPackageContents();

		// Initialize created meta-data
		theClassescstracesPackage.initializePackageContents();
		theClassescsPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theClassescstracesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ClassescstracesPackage.eNS_URI, theClassescstracesPackage);
		return theClassescstracesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageCS2Package() {
		return packageCS2PackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS2Package_PackageCS() {
		return (EReference)packageCS2PackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS2Package_Package() {
		return (EReference)packageCS2PackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassCS2Class() {
		return classCS2ClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS2Class_ClassCS() {
		return (EReference)classCS2ClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS2Class_Class() {
		return (EReference)classCS2ClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootCS2Root() {
		return rootCS2RootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS2Root_RootCS() {
		return (EReference)rootCS2RootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS2Root_Root() {
		return (EReference)rootCS2RootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassescstracesFactory getClassescstracesFactory() {
		return (ClassescstracesFactory)getEFactoryInstance();
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
		packageCS2PackageEClass = createEClass(PACKAGE_CS2_PACKAGE);
		createEReference(packageCS2PackageEClass, PACKAGE_CS2_PACKAGE__PACKAGE_CS);
		createEReference(packageCS2PackageEClass, PACKAGE_CS2_PACKAGE__PACKAGE);

		classCS2ClassEClass = createEClass(CLASS_CS2_CLASS);
		createEReference(classCS2ClassEClass, CLASS_CS2_CLASS__CLASS_CS);
		createEReference(classCS2ClassEClass, CLASS_CS2_CLASS__CLASS);

		rootCS2RootEClass = createEClass(ROOT_CS2_ROOT);
		createEReference(rootCS2RootEClass, ROOT_CS2_ROOT__ROOT_CS);
		createEReference(rootCS2RootEClass, ROOT_CS2_ROOT__ROOT);
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
		ClassescsPackage theClassescsPackage = (ClassescsPackage)EPackage.Registry.INSTANCE.getEPackage(ClassescsPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(packageCS2PackageEClass, PackageCS2Package.class, "PackageCS2Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageCS2Package_PackageCS(), theClassescsPackage.getPackageCS(), null, "packageCS", null, 1, 1, PackageCS2Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageCS2Package_Package(), theClassesPackage.getPackage(), null, "package", null, 1, 1, PackageCS2Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classCS2ClassEClass, ClassCS2Class.class, "ClassCS2Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassCS2Class_ClassCS(), theClassescsPackage.getClassCS(), null, "classCS", null, 1, 1, ClassCS2Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS2Class_Class(), theClassesPackage.getClass_(), null, "class", null, 1, 1, ClassCS2Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootCS2RootEClass, RootCS2Root.class, "RootCS2Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootCS2Root_RootCS(), theClassescsPackage.getRootCS(), null, "rootCS", null, 1, 1, RootCS2Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootCS2Root_Root(), theClassesPackage.getRoot(), null, "root", null, 1, 1, RootCS2Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "classes", "Classes.ecore#/",
			 "classescs", "ClassesCS.ecore#/"
		   });
	}

} //ClassescstracesPackageImpl
