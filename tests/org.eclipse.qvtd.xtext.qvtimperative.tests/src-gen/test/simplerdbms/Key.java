/**
 */
package test.simplerdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simplerdbms.Key#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.simplerdbms.Key#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simplerdbms.SimplerdbmsPackage#getKey()
 * @model
 * @generated
 */
public interface Key extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Table#getTheKey <em>The Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Table)
	 * @see test.simplerdbms.SimplerdbmsPackage#getKey_Owner()
	 * @see test.simplerdbms.Table#getTheKey
	 * @model opposite="theKey" required="true"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link test.simplerdbms.Key#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link test.simplerdbms.Column}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Column#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getKey_Column()
	 * @see test.simplerdbms.Column#getKey
	 * @model opposite="key"
	 * @generated
	 */
	EList<Column> getColumn();

} // Key
