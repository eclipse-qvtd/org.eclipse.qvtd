/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.IteratorExp#getIterator <em>Iterator</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getIteratorExp()
 * @model
 * @generated
 */
public interface IteratorExp extends LoopExp {

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' attribute.
	 * @see #setIterator(String)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getIteratorExp_Iterator()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!IteratorExp!iterator'"
	 * @generated
	 */
	String getIterator();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.IteratorExp#getIterator <em>Iterator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' attribute.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(String value);
} // IteratorExp
