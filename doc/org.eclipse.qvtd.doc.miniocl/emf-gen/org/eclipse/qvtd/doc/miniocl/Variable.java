/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Variable#getOwnedInitExp <em>Owned Init Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends NamedElement, TypedElement {

	/**
	 * Returns the value of the '<em><b>Owned Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Init Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Init Exp</em>' containment reference.
	 * @see #setOwnedInitExp(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getVariable_OwnedInitExp()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Variable!ownedInitExp'"
	 * @generated
	 */
	OCLExpression getOwnedInitExp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Variable#getOwnedInitExp <em>Owned Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Init Exp</em>' containment reference.
	 * @see #getOwnedInitExp()
	 * @generated
	 */
	void setOwnedInitExp(OCLExpression value);
} // Variable
