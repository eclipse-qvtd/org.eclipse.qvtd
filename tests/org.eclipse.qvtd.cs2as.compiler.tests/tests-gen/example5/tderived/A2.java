/**
 */
package example5.tderived;

import example5.tbase.A;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.tderived.A2#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @see example5.tderived.TderivedPackage#getA2()
 * @model
 * @generated
 */
public interface A2 extends A {
	/**
	 * Returns the value of the '<em><b>Owns D</b></em>' containment reference list.
	 * The list contents are of type {@link example5.tderived.D}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns D</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns D</em>' containment reference list.
	 * @see example5.tderived.TderivedPackage#getA2_OwnsD()
	 * @model containment="true"
	 * @generated
	 */
	EList<D> getOwnsD();

} // A2
