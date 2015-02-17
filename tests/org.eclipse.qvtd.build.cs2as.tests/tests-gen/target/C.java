/**
 */
package target;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link target.C#getToA2 <em>To A2</em>}</li>
 *   <li>{@link target.C#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @see target.TargetPackage#getC()
 * @model
 * @generated
 */
public interface C extends NamedElement {
	/**
	 * Returns the value of the '<em><b>To A2</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link target.A2#getOwnsC <em>Owns C</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To A2</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To A2</em>' container reference.
	 * @see #setToA2(A2)
	 * @see target.TargetPackage#getC_ToA2()
	 * @see target.A2#getOwnsC
	 * @model opposite="ownsC" transient="false"
	 * @generated
	 */
	A2 getToA2();

	/**
	 * Sets the value of the '{@link target.C#getToA2 <em>To A2</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To A2</em>' container reference.
	 * @see #getToA2()
	 * @generated
	 */
	void setToA2(A2 value);

	/**
	 * Returns the value of the '<em><b>Owns D</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link target.D#getToC <em>To C</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns D</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns D</em>' containment reference.
	 * @see #setOwnsD(D)
	 * @see target.TargetPackage#getC_OwnsD()
	 * @see target.D#getToC
	 * @model opposite="toC" containment="true"
	 * @generated
	 */
	D getOwnsD();

	/**
	 * Sets the value of the '{@link target.C#getOwnsD <em>Owns D</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns D</em>' containment reference.
	 * @see #getOwnsD()
	 * @generated
	 */
	void setOwnsD(D value);

} // C
