/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getVariableExp()
 * @model
 * @generated
 */
public interface VariableExp extends OCLExpression {

	/**
	 * Returns the value of the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Variable</em>' reference.
	 * @see #setReferredVariable(Variable)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getVariableExp_ReferredVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!VariableExp!referredVariable'"
	 * @generated
	 */
	Variable getReferredVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Variable</em>' reference.
	 * @see #getReferredVariable()
	 * @generated
	 */
	void setReferredVariable(Variable value);
} // VariableExp
