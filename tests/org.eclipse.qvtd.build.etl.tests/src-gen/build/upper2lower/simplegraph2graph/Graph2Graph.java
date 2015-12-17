/**
 */
package build.upper2lower.simplegraph2graph;

import build.upper2lower.simplegraph.Graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph2 Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.Graph2Graph#getGraph1 <em>Graph1</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Graph2Graph#getGraph2 <em>Graph2</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Graph2Graph#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph()
 * @model
 * @generated
 */
public interface Graph2Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph1</em>' reference.
	 * @see #setGraph1(Graph)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Graph1()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='upperGraph'"
	 * @generated
	 */
	Graph getGraph1();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Graph2Graph#getGraph1 <em>Graph1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph1</em>' reference.
	 * @see #getGraph1()
	 * @generated
	 */
	void setGraph1(Graph value);

	/**
	 * Returns the value of the '<em><b>Graph2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph2</em>' reference.
	 * @see #setGraph2(Graph)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Graph2()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='lowerGraph'"
	 * @generated
	 */
	Graph getGraph2();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Graph2Graph#getGraph2 <em>Graph2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph2</em>' reference.
	 * @see #getGraph2()
	 * @generated
	 */
	void setGraph2(Graph value);

	/**
	 * Returns the value of the '<em><b>Element2 Element</b></em>' containment reference list.
	 * The list contents are of type {@link build.upper2lower.simplegraph2graph.Element2Element}.
	 * It is bidirectional and its opposite is '{@link build.upper2lower.simplegraph2graph.Element2Element#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element2 Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element2 Element</em>' containment reference list.
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Element2Element()
	 * @see build.upper2lower.simplegraph2graph.Element2Element#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Element2Element> getElement2Element();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getGraph2Graph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Graph2Graph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Graph2Graph
