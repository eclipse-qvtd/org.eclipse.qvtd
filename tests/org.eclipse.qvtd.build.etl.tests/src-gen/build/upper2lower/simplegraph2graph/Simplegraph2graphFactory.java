/**
 */
package build.upper2lower.simplegraph2graph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage
 * @generated
 */
public interface Simplegraph2graphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Simplegraph2graphFactory eINSTANCE = build.upper2lower.simplegraph2graph.impl.Simplegraph2graphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph2 Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph2 Graph</em>'.
	 * @generated
	 */
	Graph2Graph createGraph2Graph();

	/**
	 * Returns a new object of class '<em>Edge2 Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge2 Edge</em>'.
	 * @generated
	 */
	Edge2Edge createEdge2Edge();

	/**
	 * Returns a new object of class '<em>Node2 Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node2 Node</em>'.
	 * @generated
	 */
	Node2Node createNode2Node();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Simplegraph2graphPackage getSimplegraph2graphPackage();

} //Simplegraph2graphFactory
