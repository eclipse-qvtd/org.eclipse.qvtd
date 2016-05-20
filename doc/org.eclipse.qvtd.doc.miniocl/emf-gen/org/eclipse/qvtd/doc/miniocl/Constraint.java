/**
 */
package org.eclipse.qvtd.doc.miniocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification <em>Owned Specification</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Specification</em>' reference.
	 * @see #setOwnedSpecification(ExpressionInOCL)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getConstraint_OwnedSpecification()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Constraint!ownedSpecification'"
	 * @generated
	 */
	ExpressionInOCL getOwnedSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification <em>Owned Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Specification</em>' reference.
	 * @see #getOwnedSpecification()
	 * @generated
	 */
	void setOwnedSpecification(ExpressionInOCL value);

} // Constraint
