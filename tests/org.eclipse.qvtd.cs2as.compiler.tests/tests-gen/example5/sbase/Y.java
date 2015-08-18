/**
 */
package example5.sbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Y</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.sbase.Y#getOwnsZ <em>Owns Z</em>}</li>
 *   <li>{@link example5.sbase.Y#getName <em>Name</em>}</li>
 *   <li>{@link example5.sbase.Y#getToX <em>To X</em>}</li>
 * </ul>
 *
 * @see example5.sbase.SbasePackage#getY()
 * @model
 * @generated
 */
public interface Y extends SElement {
	/**
	 * Returns the value of the '<em><b>Owns Z</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link example5.sbase.Z#getToY <em>To Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns Z</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns Z</em>' containment reference.
	 * @see #setOwnsZ(Z)
	 * @see example5.sbase.SbasePackage#getY_OwnsZ()
	 * @see example5.sbase.Z#getToY
	 * @model opposite="toY" containment="true"
	 * @generated
	 */
	Z getOwnsZ();

	/**
	 * Sets the value of the '{@link example5.sbase.Y#getOwnsZ <em>Owns Z</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns Z</em>' containment reference.
	 * @see #getOwnsZ()
	 * @generated
	 */
	void setOwnsZ(Z value);

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
	 * @see example5.sbase.SbasePackage#getY_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link example5.sbase.Y#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>To X</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example5.sbase.X#getOwnsY <em>Owns Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To X</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To X</em>' container reference.
	 * @see #setToX(X)
	 * @see example5.sbase.SbasePackage#getY_ToX()
	 * @see example5.sbase.X#getOwnsY
	 * @model opposite="ownsY" transient="false"
	 * @generated
	 */
	X getToX();

	/**
	 * Sets the value of the '{@link example5.sbase.Y#getToX <em>To X</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To X</em>' container reference.
	 * @see #getToX()
	 * @generated
	 */
	void setToX(X value);

} // Y
