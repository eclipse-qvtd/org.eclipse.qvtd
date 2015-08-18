/**
 */
package example2.classescs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.PropertyCS#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getPropertyCS()
 * @model
 * @generated
 */
public interface PropertyCS extends NamedElementCS {

	/**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(PathNameCS)
	 * @see example2.classescs.ClassescsPackage#getPropertyCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getTypeRef();

	/**
	 * Sets the value of the '{@link example2.classescs.PropertyCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(PathNameCS value);
} // PropertyCS
