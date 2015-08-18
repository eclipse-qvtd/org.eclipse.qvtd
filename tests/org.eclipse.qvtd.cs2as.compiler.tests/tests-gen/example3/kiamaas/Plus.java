/**
 */
package example3.kiamaas;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example3.kiamaas.Plus#getLeft <em>Left</em>}</li>
 *   <li>{@link example3.kiamaas.Plus#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see example3.kiamaas.KiamaasPackage#getPlus()
 * @model
 * @generated
 */
public interface Plus extends Node {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Node)
	 * @see example3.kiamaas.KiamaasPackage#getPlus_Left()
	 * @model containment="true"
	 * @generated
	 */
	Node getLeft();

	/**
	 * Sets the value of the '{@link example3.kiamaas.Plus#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Node value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Node)
	 * @see example3.kiamaas.KiamaasPackage#getPlus_Right()
	 * @model containment="true"
	 * @generated
	 */
	Node getRight();

	/**
	 * Sets the value of the '{@link example3.kiamaas.Plus#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Node value);

} // Plus
