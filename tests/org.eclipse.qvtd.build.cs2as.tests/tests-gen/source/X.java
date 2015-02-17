/**
 */
package source;

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
 *   <li>{@link source.X#getOwnsY <em>Owns Y</em>}</li>
 *   <li>{@link source.X#isIsA1 <em>Is A1</em>}</li>
 * </ul>
 *
 * @see source.SourcePackage#getX()
 * @model
 * @generated
 */
public interface X extends SElement {
	/**
	 * Returns the value of the '<em><b>Owns Y</b></em>' containment reference list.
	 * The list contents are of type {@link source.Y}.
	 * It is bidirectional and its opposite is '{@link source.Y#getToX <em>To X</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns Y</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns Y</em>' containment reference list.
	 * @see source.SourcePackage#getX_OwnsY()
	 * @see source.Y#getToX
	 * @model opposite="toX" containment="true"
	 * @generated
	 */
	EList<Y> getOwnsY();

	/**
	 * Returns the value of the '<em><b>Is A1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is A1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is A1</em>' attribute.
	 * @see #setIsA1(boolean)
	 * @see source.SourcePackage#getX_IsA1()
	 * @model
	 * @generated
	 */
	boolean isIsA1();

	/**
	 * Sets the value of the '{@link source.X#isIsA1 <em>Is A1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is A1</em>' attribute.
	 * @see #isIsA1()
	 * @generated
	 */
	void setIsA1(boolean value);

} // X
