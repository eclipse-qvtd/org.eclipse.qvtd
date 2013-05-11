/**
 */
package test.hls.HLSTree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import test.hls.HLSTree.HLSNode;
import test.hls.HLSTree.HLSTreeFactory;
import test.hls.HLSTree.HLSTreePackage;

import test.hsv.HSVTree.HSVTreePackage;

import test.hsv.HSVTree.impl.HSVTreePackageImpl;

import test.middle.HSV2HLS.HSV2HLSPackage;

import test.middle.HSV2HLS.impl.HSV2HLSPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HLSTreePackageImpl extends EPackageImpl implements HLSTreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hlsNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hlsEDataType = null;

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
	 * @see test.hls.HLSTree.HLSTreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HLSTreePackageImpl() {
		super(eNS_URI, HLSTreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HLSTreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HLSTreePackage init() {
		if (isInited) return (HLSTreePackage)EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI);

		// Obtain or create and register package
		HLSTreePackageImpl theHLSTreePackage = (HLSTreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HLSTreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HLSTreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		HSV2HLSPackageImpl theHSV2HLSPackage = (HSV2HLSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSV2HLSPackage.eNS_URI) instanceof HSV2HLSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSV2HLSPackage.eNS_URI) : HSV2HLSPackage.eINSTANCE);
		HSVTreePackageImpl theHSVTreePackage = (HSVTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) instanceof HSVTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) : HSVTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHLSTreePackage.createPackageContents();
		theHSV2HLSPackage.createPackageContents();
		theHSVTreePackage.createPackageContents();

		// Initialize created meta-data
		theHLSTreePackage.initializePackageContents();
		theHSV2HLSPackage.initializePackageContents();
		theHSVTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHLSTreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HLSTreePackage.eNS_URI, theHLSTreePackage);
		return theHLSTreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHLSNode() {
		return hlsNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHLSNode_Parent() {
		return (EReference)hlsNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHLSNode_Name() {
		return (EAttribute)hlsNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHLSNode_Children() {
		return (EReference)hlsNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHLSNode_Hls() {
		return (EAttribute)hlsNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHLS() {
		return hlsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLSTreeFactory getHLSTreeFactory() {
		return (HLSTreeFactory)getEFactoryInstance();
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
		hlsNodeEClass = createEClass(HLS_NODE);
		createEReference(hlsNodeEClass, HLS_NODE__PARENT);
		createEAttribute(hlsNodeEClass, HLS_NODE__NAME);
		createEReference(hlsNodeEClass, HLS_NODE__CHILDREN);
		createEAttribute(hlsNodeEClass, HLS_NODE__HLS);

		// Create data types
		hlsEDataType = createEDataType(HLS);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(hlsNodeEClass, HLSNode.class, "HLSNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHLSNode_Parent(), this.getHLSNode(), this.getHLSNode_Children(), "parent", null, 0, 1, HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHLSNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHLSNode_Children(), this.getHLSNode(), this.getHLSNode_Parent(), "children", null, 0, -1, HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHLSNode_Hls(), this.getHLS(), "hls", "HLS", 1, 1, HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(hlsEDataType, test.hls.HLS.class, "HLS", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HLSTreePackageImpl
