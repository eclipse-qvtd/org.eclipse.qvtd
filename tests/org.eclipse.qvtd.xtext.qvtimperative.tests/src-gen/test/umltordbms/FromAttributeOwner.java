/**
 */
package test.umltordbms;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Attribute Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.umltordbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.umltordbms.UmltordbmsPackage#getFromAttributeOwner()
 * @model abstract="true"
 * @generated
 */
public interface FromAttributeOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>From Attributes</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link test.umltordbms.FromAttribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Attributes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Attributes</em>' containment reference.
	 * @see #setFromAttributes(FromAttribute)
	 * @see test.umltordbms.UmltordbmsPackage#getFromAttributeOwner_FromAttributes()
	 * @see test.umltordbms.FromAttribute#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	FromAttribute getFromAttributes();

	/**
	 * Sets the value of the '{@link test.umltordbms.FromAttributeOwner#getFromAttributes <em>From Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Attributes</em>' containment reference.
	 * @see #getFromAttributes()
	 * @generated
	 */
	void setFromAttributes(FromAttribute value);

} // FromAttributeOwner
