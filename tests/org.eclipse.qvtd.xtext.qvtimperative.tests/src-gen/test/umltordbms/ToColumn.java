/**
 */
package test.umltordbms;

import org.eclipse.emf.ecore.EObject;

import test.simplerdbms.Column;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>To Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.umltordbms.ToColumn#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.umltordbms.UmltordbmsPackage#getToColumn()
 * @model
 * @generated
 */
public interface ToColumn extends EObject {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(Column)
	 * @see test.umltordbms.UmltordbmsPackage#getToColumn_Column()
	 * @model
	 * @generated
	 */
	Column getColumn();

	/**
	 * Sets the value of the '{@link test.umltordbms.ToColumn#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Column value);

} // ToColumn
