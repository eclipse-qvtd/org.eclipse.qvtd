/**
 */
package example5.tderived;

import example5.tbase.B;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.tderived.B2#getAnotherName <em>Another Name</em>}</li>
 * </ul>
 *
 * @see example5.tderived.TderivedPackage#getB2()
 * @model
 * @generated
 */
public interface B2 extends B {
	/**
	 * Returns the value of the '<em><b>Another Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Another Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Another Name</em>' attribute.
	 * @see #setAnotherName(String)
	 * @see example5.tderived.TderivedPackage#getB2_AnotherName()
	 * @model
	 * @generated
	 */
	String getAnotherName();

	/**
	 * Sets the value of the '{@link example5.tderived.B2#getAnotherName <em>Another Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Another Name</em>' attribute.
	 * @see #getAnotherName()
	 * @generated
	 */
	void setAnotherName(String value);

} // B2
