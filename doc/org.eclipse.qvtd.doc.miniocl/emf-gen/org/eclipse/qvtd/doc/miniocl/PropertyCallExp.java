/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getPropertyCallExp()
 * @model
 * @generated
 */
public interface PropertyCallExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getPropertyCallExp_ReferredProperty()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!PropertyCallExp!referredProperty'"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

} // PropertyCallExp
