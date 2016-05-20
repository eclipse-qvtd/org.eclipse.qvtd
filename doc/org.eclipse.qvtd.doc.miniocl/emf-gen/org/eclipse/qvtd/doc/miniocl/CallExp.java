/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource <em>Owned Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getCallExp()
 * @model abstract="true"
 * @generated
 */
public interface CallExp extends OCLExpression {
	/**
	 * Returns the value of the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Source</em>' containment reference.
	 * @see #setOwnedSource(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getCallExp_OwnedSource()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!CallExp!ownedSource'"
	 * @generated
	 */
	OCLExpression getOwnedSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource <em>Owned Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Source</em>' containment reference.
	 * @see #getOwnedSource()
	 * @generated
	 */
	void setOwnedSource(OCLExpression value);

} // CallExp
