/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar <em>Owned Self Var</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody <em>Owned Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getExpressionInOCL()
 * @model
 * @generated
 */
public interface ExpressionInOCL extends OpaqueExpression {
	/**
	 * Returns the value of the '<em><b>Owned Self Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Self Var</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Self Var</em>' containment reference.
	 * @see #setOwnedSelfVar(Variable)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getExpressionInOCL_OwnedSelfVar()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!ExpressionInOCL!ownedSelfVar'"
	 * @generated
	 */
	Variable getOwnedSelfVar();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar <em>Owned Self Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Self Var</em>' containment reference.
	 * @see #getOwnedSelfVar()
	 * @generated
	 */
	void setOwnedSelfVar(Variable value);

	/**
	 * Returns the value of the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Body</em>' containment reference.
	 * @see #setOwnedBody(OCLExpression)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getExpressionInOCL_OwnedBody()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!ExpressionInOCL!ownedBody'"
	 * @generated
	 */
	OCLExpression getOwnedBody();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Body</em>' containment reference.
	 * @see #getOwnedBody()
	 * @generated
	 */
	void setOwnedBody(OCLExpression value);

} // ExpressionInOCL
