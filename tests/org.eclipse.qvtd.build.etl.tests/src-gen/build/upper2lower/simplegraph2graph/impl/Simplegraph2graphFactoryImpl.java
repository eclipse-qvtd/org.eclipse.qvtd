/**
 */
package build.upper2lower.simplegraph2graph.impl;

import build.upper2lower.simplegraph2graph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Simplegraph2graphFactoryImpl extends EFactoryImpl implements Simplegraph2graphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Simplegraph2graphFactory init() {
		try {
			Simplegraph2graphFactory theSimplegraph2graphFactory = (Simplegraph2graphFactory)EPackage.Registry.INSTANCE.getEFactory(Simplegraph2graphPackage.eNS_URI);
			if (theSimplegraph2graphFactory != null) {
				return theSimplegraph2graphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Simplegraph2graphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simplegraph2graphFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Simplegraph2graphPackage.GRAPH2_GRAPH: return createGraph2Graph();
			case Simplegraph2graphPackage.EDGE2_EDGE: return createEdge2Edge();
			case Simplegraph2graphPackage.NODE2_NODE: return createNode2Node();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph2Graph createGraph2Graph() {
		Graph2GraphImpl graph2Graph = new Graph2GraphImpl();
		return graph2Graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge2Edge createEdge2Edge() {
		Edge2EdgeImpl edge2Edge = new Edge2EdgeImpl();
		return edge2Edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2Node createNode2Node() {
		Node2NodeImpl node2Node = new Node2NodeImpl();
		return node2Node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simplegraph2graphPackage getSimplegraph2graphPackage() {
		return (Simplegraph2graphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Simplegraph2graphPackage getPackage() {
		return Simplegraph2graphPackage.eINSTANCE;
	}

} //Simplegraph2graphFactoryImpl
