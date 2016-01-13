/**
 */
package build.test.middle.HSV2HLS.impl;

import build.test.hls.HLSTree.HLSTreePackage;

import build.test.hls.HLSTree.impl.HLSTreePackageImpl;

import build.test.hsv.HSVTree.HSVTreePackage;

import build.test.hsv.HSVTree.impl.HSVTreePackageImpl;

import build.test.middle.HSV2HLS.HSV2HLSFactory;
import build.test.middle.HSV2HLS.HSV2HLSPackage;
import build.test.middle.HSV2HLS.HSVNode2HLSNode;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSV2HLSPackageImpl extends EPackageImpl implements HSV2HLSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hsvNode2HLSNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rgbEDataType = null;

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
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HSV2HLSPackageImpl() {
		super(eNS_URI, HSV2HLSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HSV2HLSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HSV2HLSPackage init() {
		if (isInited) return (HSV2HLSPackage)EPackage.Registry.INSTANCE.getEPackage(HSV2HLSPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HSV2HLSPackageImpl theHSV2HLSPackage = (HSV2HLSPackageImpl)(ePackage instanceof HSV2HLSPackageImpl ? ePackage : new HSV2HLSPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		HSVTreePackageImpl theHSVTreePackage = (HSVTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) instanceof HSVTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) : HSVTreePackage.eINSTANCE);
		HLSTreePackageImpl theHLSTreePackage = (HLSTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI) instanceof HLSTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI) : HLSTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHSV2HLSPackage.createPackageContents();
		theHSVTreePackage.createPackageContents();
		theHLSTreePackage.createPackageContents();

		// Initialize created meta-data
		theHSV2HLSPackage.initializePackageContents();
		theHSVTreePackage.initializePackageContents();
		theHLSTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHSV2HLSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HSV2HLSPackage.eNS_URI, theHSV2HLSPackage);
		return theHSV2HLSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHSVNode2HLSNode() {
		return hsvNode2HLSNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode2HLSNode_Parent() {
		return (EReference)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode2HLSNode_Children() {
		return (EReference)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode2HLSNode_Hsv() {
		return (EReference)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHSVNode2HLSNode_Hls() {
		return (EReference)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHSVNode2HLSNode_Rgb() {
		return (EAttribute)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHSVNode2HLSNode_Name() {
		return (EAttribute)hsvNode2HLSNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRGB() {
		return rgbEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSV2HLSFactory getHSV2HLSFactory() {
		return (HSV2HLSFactory)getEFactoryInstance();
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
		hsvNode2HLSNodeEClass = createEClass(HSV_NODE2_HLS_NODE);
		createEReference(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__PARENT);
		createEReference(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__CHILDREN);
		createEReference(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__HSV);
		createEReference(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__HLS);
		createEAttribute(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__RGB);
		createEAttribute(hsvNode2HLSNodeEClass, HSV_NODE2_HLS_NODE__NAME);

		// Create data types
		rgbEDataType = createEDataType(RGB);
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
		HSVTreePackage theHSVTreePackage = (HSVTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI);
		HLSTreePackage theHLSTreePackage = (HLSTreePackage)EPackage.Registry.INSTANCE.getEPackage(HLSTreePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(hsvNode2HLSNodeEClass, HSVNode2HLSNode.class, "HSVNode2HLSNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHSVNode2HLSNode_Parent(), this.getHSVNode2HLSNode(), this.getHSVNode2HLSNode_Children(), "parent", null, 0, 1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HLSNode_Children(), this.getHSVNode2HLSNode(), this.getHSVNode2HLSNode_Parent(), "children", null, 0, -1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HLSNode_Hsv(), theHSVTreePackage.getHSVNode(), null, "hsv", null, 1, 1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HLSNode_Hls(), theHLSTreePackage.getHLSNode(), null, "hls", null, 1, 1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode2HLSNode_Rgb(), this.getRGB(), "rgb", null, 1, 1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode2HLSNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, HSVNode2HLSNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(rgbEDataType, String.class, "RGB", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper
		createEmofAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmof_1Annotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper";	
		addAnnotation
		  (getHSVNode2HLSNode_Hsv(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getHSVNode2HLSNode_Hls(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmof_1Annotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";	
		addAnnotation
		  (getHSVNode2HLSNode_Hsv(), 
		   source, 
		   new String[] {
			 "body", "middle"
		   });	
		addAnnotation
		  (getHSVNode2HLSNode_Hls(), 
		   source, 
		   new String[] {
			 "body", "middle"
		   });
	}

} //HSV2HLSPackageImpl
