/**
 */
package example2.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.CallExp#getOwnedCallExp <em>Owned Call Exp</em>}</li>
 *   <li>{@link example2.classes.CallExp#getOwningSource <em>Owning Source</em>}</li>
 * </ul>
 *
 * @see example2.classes.ClassesPackage#getCallExp()
 * @model abstract="true"
 * @generated
 */
public interface CallExp extends TypedElement {
	/**
	 * Returns the value of the '<em><b>Owned Call Exp</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link example2.classes.CallExp#getOwningSource <em>Owning Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Call Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Call Exp</em>' containment reference.
	 * @see #setOwnedCallExp(CallExp)
	 * @see example2.classes.ClassesPackage#getCallExp_OwnedCallExp()
	 * @see example2.classes.CallExp#getOwningSource
	 * @model opposite="owningSource" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/classes/1.0!CallExp!ownedCallExp'"
	 * @generated
	 */
	CallExp getOwnedCallExp();

	/**
	 * Sets the value of the '{@link example2.classes.CallExp#getOwnedCallExp <em>Owned Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Call Exp</em>' containment reference.
	 * @see #getOwnedCallExp()
	 * @generated
	 */
	void setOwnedCallExp(CallExp value);

	/**
	 * Returns the value of the '<em><b>Owning Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example2.classes.CallExp#getOwnedCallExp <em>Owned Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Source</em>' container reference.
	 * @see #setOwningSource(CallExp)
	 * @see example2.classes.ClassesPackage#getCallExp_OwningSource()
	 * @see example2.classes.CallExp#getOwnedCallExp
	 * @model opposite="ownedCallExp" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/classes/1.0!CallExp!owningSource'"
	 * @generated
	 */
	CallExp getOwningSource();

	/**
	 * Sets the value of the '{@link example2.classes.CallExp#getOwningSource <em>Owning Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Source</em>' container reference.
	 * @see #getOwningSource()
	 * @generated
	 */
	void setOwningSource(CallExp value);

} // CallExp
