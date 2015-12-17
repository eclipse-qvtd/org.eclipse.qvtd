/**
 */
package build.upper2lower.simplegraph2graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element2 Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.Element2Element#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getElement2Element()
 * @model abstract="true"
 * @generated
 */
public interface Element2Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Graph2Graph)
	 * @see build.upper2lower.simplegraph2graph.Simplegraph2graphPackage#getElement2Element_Owner()
	 * @see build.upper2lower.simplegraph2graph.Graph2Graph#getElement2Element
	 * @model opposite="element2Element" transient="false"
	 * @generated
	 */
	Graph2Graph getOwner();

	/**
	 * Sets the value of the '{@link build.upper2lower.simplegraph2graph.Element2Element#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Graph2Graph value);

} // Element2Element
