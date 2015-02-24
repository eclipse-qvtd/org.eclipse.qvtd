/**
 */
package example1.target;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.target.B#getToA1 <em>To A1</em>}</li>
 *   <li>{@link example1.target.B#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @see example1.target.TargetPackage#getB()
 * @model
 * @generated
 */
public interface B extends NamedElement {
	/**
	 * Returns the value of the '<em><b>To A1</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.target.A1#getOwnsB <em>Owns B</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To A1</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To A1</em>' container reference.
	 * @see #setToA1(A1)
	 * @see example1.target.TargetPackage#getB_ToA1()
	 * @see example1.target.A1#getOwnsB
	 * @model opposite="ownsB" transient="false"
	 * @generated
	 */
	A1 getToA1();

	/**
	 * Sets the value of the '{@link example1.target.B#getToA1 <em>To A1</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To A1</em>' container reference.
	 * @see #getToA1()
	 * @generated
	 */
	void setToA1(A1 value);

	/**
	 * Returns the value of the '<em><b>Owns D</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link example1.target.D#getToB <em>To B</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns D</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns D</em>' containment reference.
	 * @see #setOwnsD(D)
	 * @see example1.target.TargetPackage#getB_OwnsD()
	 * @see example1.target.D#getToB
	 * @model opposite="toB" containment="true"
	 * @generated
	 */
	D getOwnsD();

	/**
	 * Sets the value of the '{@link example1.target.B#getOwnsD <em>Owns D</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns D</em>' containment reference.
	 * @see #getOwnsD()
	 * @generated
	 */
	void setOwnsD(D value);

} // B
