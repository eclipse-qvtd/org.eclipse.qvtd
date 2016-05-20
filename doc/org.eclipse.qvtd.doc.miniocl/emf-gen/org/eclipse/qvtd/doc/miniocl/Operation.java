/**
 */
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression <em>Owned Body Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Feature {
	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperation_OwnedParameters()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Operation!ownedParameters'"
	 * @generated
	 */
	EList<Parameter> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see #setOwningClass(org.eclipse.qvtd.doc.miniocl.Class)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperation_OwningClass()
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations
	 * @model opposite="ownedOperations" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Operation!owningClass'"
	 * @generated
	 */
	org.eclipse.qvtd.doc.miniocl.Class getOwningClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass <em>Owning Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Class</em>' container reference.
	 * @see #getOwningClass()
	 * @generated
	 */
	void setOwningClass(org.eclipse.qvtd.doc.miniocl.Class value);

	/**
	 * Returns the value of the '<em><b>Owned Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body Expression</em>' containment reference.
	 * @see #setOwnedBodyExpression(ExpressionInOCL)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getOperation_OwnedBodyExpression()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Operation!ownedBodyExpression'"
	 * @generated
	 */
	ExpressionInOCL getOwnedBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression <em>Owned Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body Expression</em>' containment reference.
	 * @see #getOwnedBodyExpression()
	 * @generated
	 */
	void setOwnedBodyExpression(ExpressionInOCL value);

} // Operation
