/**
 */
package example5.sbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>X</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.sbase.X#getOwnsY <em>Owns Y</em>}</li>
 *   <li>{@link example5.sbase.X#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see example5.sbase.SbasePackage#getX()
 * @model
 * @generated
 */
public interface X extends SElement {
	/**
	 * Returns the value of the '<em><b>Owns Y</b></em>' containment reference list.
	 * The list contents are of type {@link example5.sbase.Y}.
	 * It is bidirectional and its opposite is '{@link example5.sbase.Y#getToX <em>To X</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns Y</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns Y</em>' containment reference list.
	 * @see example5.sbase.SbasePackage#getX_OwnsY()
	 * @see example5.sbase.Y#getToX
	 * @model opposite="toX" containment="true"
	 * @generated
	 */
	EList<Y> getOwnsY();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see example5.sbase.SbasePackage#getX_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link example5.sbase.X#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // X
