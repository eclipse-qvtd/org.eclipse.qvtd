/**
 */
package example1.target.lookup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.evaluation.Executor;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import example1.target.TargetPackage;
import example1.target.impl.TargetPackageImpl;
import example1.target.lookup.Env4CG;
import example1.target.lookup.EnvironmentFactory;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentPackageImpl extends EPackageImpl implements EnvironmentPackage {
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
	private EClass env4CGEClass = null;

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
	 * @see example1.target.lookup.EnvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnvironmentPackageImpl() {
		super(eNS_URI, EnvironmentFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EnvironmentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnvironmentPackage init() {
		if (isInited) return (EnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl)(ePackage instanceof EnvironmentPackageImpl ? ePackage : new EnvironmentPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);

		// Create package meta-data objects
		theEnvironmentPackage.createPackageContents();
		theTargetPackage.createPackageContents();

		// Initialize created meta-data
		theEnvironmentPackage.initializePackageContents();
		theTargetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnvironmentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnvironmentPackage.eNS_URI, theEnvironmentPackage);
		return theEnvironmentPackage;
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
	public EOperation getLookupEnvironment__AddElement__NamedElement() {
		return lookupEnvironmentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnv4CG() {
		return env4CGEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnv4CG__HasFinalResult() {
		return env4CGEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEnv4CG__GetExecutor() {
		return env4CGEClass.getEOperations().get(1);
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
	public EnvironmentFactory getEnvironmentFactory() {
		return (EnvironmentFactory)getEFactoryInstance();
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
		createEOperation(lookupEnvironmentEClass, LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT);

		env4CGEClass = createEClass(ENV4_CG);
		createEOperation(env4CGEClass, ENV4_CG___HAS_FINAL_RESULT);
		createEOperation(env4CGEClass, ENV4_CG___GET_EXECUTOR);

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
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		OCLstdlibPackage theOCLstdlibPackage = (OCLstdlibPackage)EPackage.Registry.INSTANCE.getEPackage(OCLstdlibPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		lookupEnvironmentEClass.getESuperTypes().add(this.getEnv4CG());

		// Initialize classes, features, and operations; add parameters
		initEClass(lookupEnvironmentEClass, LookupEnvironment.class, "LookupEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLookupEnvironment_NamedElements(), theTargetPackage.getNamedElement(), null, "namedElements", null, 0, -1, LookupEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLookupEnvironment_ParentEnv(), this.getLookupEnvironment(), null, "parentEnv", null, 0, 1, LookupEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getLookupEnvironment__AddElements__Collection(), this.getLookupEnvironment(), "addElements", 1, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "NE");
		EGenericType g1 = createEGenericType(theTargetPackage.getNamedElement());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(theOCLstdlibPackage.getCollection());
		EGenericType g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "elements", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLookupEnvironment__AddElement__NamedElement(), this.getLookupEnvironment(), "addElement", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTargetPackage.getNamedElement(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(env4CGEClass, Env4CG.class, "Env4CG", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEnv4CG__HasFinalResult(), ecorePackage.getEBoolean(), "hasFinalResult", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEnv4CG__GetExecutor(), this.getExecutor(), "getExecutor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(executorEClass, Executor.class, "Executor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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
			 "target", "TargetMM1.ecore#/"
		   });
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

} //EnvironmentPackageImpl
