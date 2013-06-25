/**
 */
package test.simpleuml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simpleuml.Association#getSource <em>Source</em>}</li>
 *   <li>{@link test.simpleuml.Association#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simpleuml.SimpleumlPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Class#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(test.simpleuml.Class)
	 * @see test.simpleuml.SimpleumlPackage#getAssociation_Source()
	 * @see test.simpleuml.Class#getForward
	 * @model opposite="forward" required="true"
	 * @generated
	 */
	test.simpleuml.Class getSource();

	/**
	 * Sets the value of the '{@link test.simpleuml.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(test.simpleuml.Class value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(test.simpleuml.Class)
	 * @see test.simpleuml.SimpleumlPackage#getAssociation_Destination()
	 * @model required="true"
	 * @generated
	 */
	test.simpleuml.Class getDestination();

	/**
	 * Sets the value of the '{@link test.simpleuml.Association#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(test.simpleuml.Class value);

} // Association
