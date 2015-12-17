/**
 */
package build.upper2lower.simplegraph2graph;

import build.upper2lower.simplegraph.Edge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge2 Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.Edge2Edge#getEdge1 <em>Edge1</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Edge2Edge#getEdge2 <em>Edge2</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Edge2Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.Edge2Edge#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getEdge2Edge()
 * @model
 * @generated
 */
public interface Edge2Edge extends Element2Element {
	/**
	 * Returns the value of the '<em><b>Edge1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge1</em>' reference.
	 * @see #setEdge1(Edge)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getEdge2Edge_Edge1()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='upperGraph'"
	 * @generated
	 */
	Edge getEdge1();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Edge2Edge#getEdge1 <em>Edge1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge1</em>' reference.
	 * @see #getEdge1()
	 * @generated
	 */
	void setEdge1(Edge value);

	/**
	 * Returns the value of the '<em><b>Edge2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge2</em>' reference.
	 * @see #setEdge2(Edge)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getEdge2Edge_Edge2()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='lowerGraph'"
	 * @generated
	 */
	Edge getEdge2();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Edge2Edge#getEdge2 <em>Edge2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge2</em>' reference.
	 * @see #getEdge2()
	 * @generated
	 */
	void setEdge2(Edge value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node2Node)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getEdge2Edge_Target()
	 * @model
	 * @generated
	 */
	Node2Node getTarget();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Edge2Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node2Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node2Node)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getEdge2Edge_Source()
	 * @model
	 * @generated
	 */
	Node2Node getSource();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Edge2Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node2Node value);

} // Edge2Edge
