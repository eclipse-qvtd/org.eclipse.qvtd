/**
 */
package example1.source;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Z</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.source.Z#getToY <em>To Y</em>}</li>
 *   <li>{@link example1.source.Z#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see example1.source.SourcePackage#getZ()
 * @model
 * @generated
 */
public interface Z extends SElement {
	/**
	 * Returns the value of the '<em><b>To Y</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.source.Y#getOwnsZ <em>Owns Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Y</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Y</em>' container reference.
	 * @see #setToY(Y)
	 * @see example1.source.SourcePackage#getZ_ToY()
	 * @see example1.source.Y#getOwnsZ
	 * @model opposite="ownsZ" transient="false"
	 * @generated
	 */
	Y getToY();

	/**
	 * Sets the value of the '{@link example1.source.Z#getToY <em>To Y</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Y</em>' container reference.
	 * @see #getToY()
	 * @generated
	 */
	void setToY(Y value);

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
	 * @see example1.source.SourcePackage#getZ_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link example1.source.Z#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Z
