/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedFirst <em>Owned First</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedLast <em>Owned Last</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getCollectionRange()
 * @model
 * @generated
 */
public interface CollectionRange extends CollectionLiteralPart {
	/**
	 * Returns the value of the '<em><b>Owned First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned First</em>' containment reference.
	 * @see #setOwnedFirst(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getCollectionRange_OwnedFirst()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!CollectionRange!ownedFirst'"
	 * @generated
	 */
	OCLExpression getOwnedFirst();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedFirst <em>Owned First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned First</em>' containment reference.
	 * @see #getOwnedFirst()
	 * @generated
	 */
	void setOwnedFirst(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Owned Last</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Last</em>' containment reference.
	 * @see #setOwnedLast(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getCollectionRange_OwnedLast()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!CollectionRange!ownedLast'"
	 * @generated
	 */
	OCLExpression getOwnedLast();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedLast <em>Owned Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Last</em>' containment reference.
	 * @see #getOwnedLast()
	 * @generated
	 */
	void setOwnedLast(OCLExpression value);

} // CollectionRange
