/**
 */
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getOwnedArguments <em>Owned Arguments</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends CallExp {
	/**
	 * Returns the value of the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Arguments</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperationCallExp_OwnedArguments()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!OperationCallExp!ownedArguments'"
	 * @generated
	 */
	EList<OCLExpression> getOwnedArguments();

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Operation)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperationCallExp_ReferredOperation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!OperationCallExp!referredOperation'"
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

} // OperationCallExp
