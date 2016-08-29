/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedIn <em>Owned In</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedVariable <em>Owned Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getLetExp()
 * @model
 * @generated
 */
public interface LetExp extends OCLExpression {
	/**
	 * Returns the value of the '<em><b>Owned In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned In</em>' containment reference.
	 * @see #setOwnedIn(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getLetExp_OwnedIn()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!LetExp!ownedIn'"
	 * @generated
	 */
	OCLExpression getOwnedIn();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedIn <em>Owned In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned In</em>' containment reference.
	 * @see #getOwnedIn()
	 * @generated
	 */
	void setOwnedIn(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Variable</em>' containment reference.
	 * @see #setOwnedVariable(Variable)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getLetExp_OwnedVariable()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!LetExp!ownedVariable'"
	 * @generated
	 */
	Variable getOwnedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedVariable <em>Owned Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Variable</em>' containment reference.
	 * @see #getOwnedVariable()
	 * @generated
	 */
	void setOwnedVariable(Variable value);

} // LetExp
