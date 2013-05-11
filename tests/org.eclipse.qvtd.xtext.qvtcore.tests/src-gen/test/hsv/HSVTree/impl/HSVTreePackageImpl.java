/**
 */
package test.hsv.HSVTree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import test.hls.HLSTree.HLSTreePackage;

import test.hls.HLSTree.impl.HLSTreePackageImpl;

import test.hsv.HSVTree.HSVNode;
import test.hsv.HSVTree.HSVTreeFactory;
import test.hsv.HSVTree.HSVTreePackage;

import test.middle.HSV2HLS.HSV2HLSPackage;

import test.middle.HSV2HLS.impl.HSV2HLSPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSVTreePackageImpl extends EPackageImpl implements HSVTreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hsvNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hsvEDataType = null;

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
	 * @see test.hsv.HSVTree.HSVTreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HSVTreePackageImpl() {
		super(eNS_URI, HSVTreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HSVTreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HSVTreePackage init() {
		if (isInited) return (HSVTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI);

		// Obtain or create and register package
		HSVTreePackageImpl theHSVTreePackage = (HSVTreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HSVTreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HSVTreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		HSV2HLSPackageImpl theHSV2HLSPackage = (HSV2HLSPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSV2HLSPackage.eNS_URI) instanceof HSV2HLSPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSV2HLSPackage.eNS_URI) : HSV2HLSPackage.eINSTANCE);
		HLSTreePackageImpl theHLSTreePackage = (HLSTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI) instanceof HLSTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI) : HLSTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHSVTreePackage.createPackageContents();
		theHSV2HLSPackage.createPackageContents();
		theHLSTreePackage.createPackageContents();

		// Initialize created meta-data
		theHSVTreePackage.initializePackageContents();
		theHSV2HLSPackage.initializePackageContents();
		theHLSTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHSVTreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HSVTreePackage.eNS_URI, theHSVTreePackage);
		return theHSVTreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHSVNode() {
		return hsvNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode_Parent() {
		return (EReference)hsvNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHSVNode_Name() {
		return (EAttribute)hsvNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode_Children() {
		return (EReference)hsvNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHSVNode_Hsv() {
		return (EAttribute)hsvNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHSV() {
		return hsvEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVTreeFactory getHSVTreeFactory() {
		return (HSVTreeFactory)getEFactoryInstance();
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
		hsvNodeEClass = createEClass(HSV_NODE);
		createEReference(hsvNodeEClass, HSV_NODE__PARENT);
		createEAttribute(hsvNodeEClass, HSV_NODE__NAME);
		createEReference(hsvNodeEClass, HSV_NODE__CHILDREN);
		createEAttribute(hsvNodeEClass, HSV_NODE__HSV);

		// Create data types
		hsvEDataType = createEDataType(HSV);
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
		initEClass(hsvNodeEClass, HSVNode.class, "HSVNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHSVNode_Parent(), this.getHSVNode(), this.getHSVNode_Children(), "parent", null, 0, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode_Children(), this.getHSVNode(), this.getHSVNode_Parent(), "children", null, 0, -1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHSVNode_Hsv(), this.getHSV(), "hsv", null, 1, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(hsvEDataType, test.hsv.HSV.class, "HSV", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HSVTreePackageImpl
