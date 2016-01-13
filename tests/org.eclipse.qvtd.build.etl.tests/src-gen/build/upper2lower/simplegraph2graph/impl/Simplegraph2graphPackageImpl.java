/**
 */
package build.upper2lower.simplegraph2graph.impl;

import build.upper2lower.simplegraph.SimplegraphPackage;

import build.upper2lower.simplegraph.impl.SimplegraphPackageImpl;

import build.upper2lower.simplegraph2graph.Edge2Edge;
import build.upper2lower.simplegraph2graph.Element2Element;
import build.upper2lower.simplegraph2graph.Graph2Graph;
import build.upper2lower.simplegraph2graph.Node2Node;
import build.upper2lower.simplegraph2graph.Simplegraph2graphFactory;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;

import org.eclipse.emf.ecore.EAttribute;
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
public class Simplegraph2graphPackageImpl extends EPackageImpl implements Simplegraph2graphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graph2GraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass element2ElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edge2EdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass node2NodeEClass = null;

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
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Simplegraph2graphPackageImpl() {
		super(eNS_URI, Simplegraph2graphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Simplegraph2graphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Simplegraph2graphPackage init() {
		if (isInited) return (Simplegraph2graphPackage)EPackage.Registry.INSTANCE.getEPackage(Simplegraph2graphPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Simplegraph2graphPackageImpl theSimplegraph2graphPackage = (Simplegraph2graphPackageImpl)(ePackage instanceof Simplegraph2graphPackageImpl ? ePackage : new Simplegraph2graphPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SimplegraphPackageImpl theSimplegraphPackage = (SimplegraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimplegraphPackage.eNS_URI) instanceof SimplegraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimplegraphPackage.eNS_URI) : SimplegraphPackage.eINSTANCE);

		// Create package meta-data objects
		theSimplegraph2graphPackage.createPackageContents();
		theSimplegraphPackage.createPackageContents();

		// Initialize created meta-data
		theSimplegraph2graphPackage.initializePackageContents();
		theSimplegraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimplegraph2graphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Simplegraph2graphPackage.eNS_URI, theSimplegraph2graphPackage);
		return theSimplegraph2graphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraph2Graph() {
		return graph2GraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph2Graph_Graph1() {
		return (EReference)graph2GraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph2Graph_Graph2() {
		return (EReference)graph2GraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph2Graph_Element2Element() {
		return (EReference)graph2GraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph2Graph_Name() {
		return (EAttribute)graph2GraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement2Element() {
		return element2ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement2Element_Owner() {
		return (EReference)element2ElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge2Edge() {
		return edge2EdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge2Edge_Edge1() {
		return (EReference)edge2EdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge2Edge_Edge2() {
		return (EReference)edge2EdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge2Edge_Target() {
		return (EReference)edge2EdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge2Edge_Source() {
		return (EReference)edge2EdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode2Node() {
		return node2NodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2Node_Node1() {
		return (EReference)node2NodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2Node_Node2() {
		return (EReference)node2NodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode2Node_Label() {
		return (EAttribute)node2NodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simplegraph2graphFactory getSimplegraph2graphFactory() {
		return (Simplegraph2graphFactory)getEFactoryInstance();
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
		graph2GraphEClass = createEClass(GRAPH2_GRAPH);
		createEReference(graph2GraphEClass, GRAPH2_GRAPH__GRAPH1);
		createEReference(graph2GraphEClass, GRAPH2_GRAPH__GRAPH2);
		createEReference(graph2GraphEClass, GRAPH2_GRAPH__ELEMENT2_ELEMENT);
		createEAttribute(graph2GraphEClass, GRAPH2_GRAPH__NAME);

		element2ElementEClass = createEClass(ELEMENT2_ELEMENT);
		createEReference(element2ElementEClass, ELEMENT2_ELEMENT__OWNER);

		edge2EdgeEClass = createEClass(EDGE2_EDGE);
		createEReference(edge2EdgeEClass, EDGE2_EDGE__EDGE1);
		createEReference(edge2EdgeEClass, EDGE2_EDGE__EDGE2);
		createEReference(edge2EdgeEClass, EDGE2_EDGE__TARGET);
		createEReference(edge2EdgeEClass, EDGE2_EDGE__SOURCE);

		node2NodeEClass = createEClass(NODE2_NODE);
		createEReference(node2NodeEClass, NODE2_NODE__NODE1);
		createEReference(node2NodeEClass, NODE2_NODE__NODE2);
		createEAttribute(node2NodeEClass, NODE2_NODE__LABEL);
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
		SimplegraphPackage theSimplegraphPackage = (SimplegraphPackage)EPackage.Registry.INSTANCE.getEPackage(SimplegraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		edge2EdgeEClass.getESuperTypes().add(this.getElement2Element());
		node2NodeEClass.getESuperTypes().add(this.getElement2Element());

		// Initialize classes, features, and operations; add parameters
		initEClass(graph2GraphEClass, Graph2Graph.class, "Graph2Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph2Graph_Graph1(), theSimplegraphPackage.getGraph(), null, "graph1", null, 0, 1, Graph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph2Graph_Graph2(), theSimplegraphPackage.getGraph(), null, "graph2", null, 0, 1, Graph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph2Graph_Element2Element(), this.getElement2Element(), this.getElement2Element_Owner(), "element2Element", null, 0, -1, Graph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraph2Graph_Name(), ecorePackage.getEString(), "name", null, 0, 1, Graph2Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(element2ElementEClass, Element2Element.class, "Element2Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElement2Element_Owner(), this.getGraph2Graph(), this.getGraph2Graph_Element2Element(), "owner", null, 0, 1, Element2Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edge2EdgeEClass, Edge2Edge.class, "Edge2Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge2Edge_Edge1(), theSimplegraphPackage.getEdge(), null, "edge1", null, 0, 1, Edge2Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge2Edge_Edge2(), theSimplegraphPackage.getEdge(), null, "edge2", null, 0, 1, Edge2Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge2Edge_Target(), this.getNode2Node(), null, "target", null, 0, 1, Edge2Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge2Edge_Source(), this.getNode2Node(), null, "source", null, 0, 1, Edge2Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(node2NodeEClass, Node2Node.class, "Node2Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode2Node_Node1(), theSimplegraphPackage.getNode(), null, "node1", null, 0, 1, Node2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode2Node_Node2(), theSimplegraphPackage.getNode(), null, "node2", null, 0, 1, Node2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode2Node_Label(), ecorePackage.getEString(), "label", null, 0, 1, Node2Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper
		createEmofAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmof_1Annotations();
		// http://www.eclipse.org/qvt#Domains
		createQvtDomainsAnnotations();
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
		  (getGraph2Graph_Graph1(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getGraph2Graph_Graph2(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge1(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge2(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getNode2Node_Node1(), 
		   source, 
		   new String[] {
			 "body", "1"
		   });	
		addAnnotation
		  (getNode2Node_Node2(), 
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
		  (getGraph2Graph_Graph1(), 
		   source, 
		   new String[] {
			 "body", "middle1"
		   });	
		addAnnotation
		  (getGraph2Graph_Graph2(), 
		   source, 
		   new String[] {
			 "body", "middle2"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge1(), 
		   source, 
		   new String[] {
			 "body", "middle1"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge2(), 
		   source, 
		   new String[] {
			 "body", "middle2"
		   });	
		addAnnotation
		  (getNode2Node_Node1(), 
		   source, 
		   new String[] {
			 "body", "middle1"
		   });	
		addAnnotation
		  (getNode2Node_Node2(), 
		   source, 
		   new String[] {
			 "body", "middle2"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/qvt#Domains</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createQvtDomainsAnnotations() {
		String source = "http://www.eclipse.org/qvt#Domains";	
		addAnnotation
		  (getGraph2Graph_Graph1(), 
		   source, 
		   new String[] {
			 "referredDomain", "upperGraph"
		   });	
		addAnnotation
		  (getGraph2Graph_Graph2(), 
		   source, 
		   new String[] {
			 "referredDomain", "lowerGraph"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge1(), 
		   source, 
		   new String[] {
			 "referredDomain", "upperGraph"
		   });	
		addAnnotation
		  (getEdge2Edge_Edge2(), 
		   source, 
		   new String[] {
			 "referredDomain", "lowerGraph"
		   });	
		addAnnotation
		  (getNode2Node_Node1(), 
		   source, 
		   new String[] {
			 "referredDomain", "upperGraph"
		   });	
		addAnnotation
		  (getNode2Node_Node2(), 
		   source, 
		   new String[] {
			 "referredDomain", "lowerGraph"
		   });
	}

} //Simplegraph2graphPackageImpl
