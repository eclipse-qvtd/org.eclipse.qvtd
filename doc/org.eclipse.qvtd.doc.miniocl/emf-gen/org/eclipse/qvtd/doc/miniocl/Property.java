/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Property#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends Feature {

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' reference.
	 * @see #setOwningClass(org.eclipse.qvtd.doc.miniocl.Class)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getProperty_OwningClass()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Property!owningClass'"
	 * @generated
	 */
	org.eclipse.qvtd.doc.miniocl.Class getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Property#getOwningClass <em>Owning Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(org.eclipse.qvtd.doc.miniocl.Class value);
} // Property
