/**
 */
package example2.classescs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.ClassCS#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getClassCS()
 * @model
 * @generated
 */
public interface ClassCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference.
	 * @see #setExtends(PathNameCS)
	 * @see example2.classescs.ClassescsPackage#getClassCS_Extends()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getExtends();

	/**
	 * Sets the value of the '{@link example2.classescs.ClassCS#getExtends <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' containment reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(PathNameCS value);

} // ClassCS
