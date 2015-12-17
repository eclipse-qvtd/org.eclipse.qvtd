/**
 */
package example4.kiamaas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example4.kiamaas.Composite#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see example4.kiamaas.KiamaasPackage#getComposite()
 * @model
 * @generated
 */
public interface Composite extends Node {
	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference.
	 * @see #setChild(Node)
	 * @see example4.kiamaas.KiamaasPackage#getComposite_Child()
	 * @model containment="true"
	 * @generated
	 */
	Node getChild();

	/**
	 * Sets the value of the '{@link example4.kiamaas.Composite#getChild <em>Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' containment reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(Node value);

} // Composite
