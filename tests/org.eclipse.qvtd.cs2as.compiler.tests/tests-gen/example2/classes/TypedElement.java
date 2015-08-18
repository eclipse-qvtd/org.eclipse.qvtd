/**
 */
package example2.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.TypedElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see example2.classes.ClassesPackage#getTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface TypedElement extends Element {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(example2.classes.Class)
	 * @see example2.classes.ClassesPackage#getTypedElement_Type()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/classes/1.0!TypedElement!type'"
	 * @generated
	 */
	example2.classes.Class getType();

	/**
	 * Sets the value of the '{@link example2.classes.TypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(example2.classes.Class value);

} // TypedElement
