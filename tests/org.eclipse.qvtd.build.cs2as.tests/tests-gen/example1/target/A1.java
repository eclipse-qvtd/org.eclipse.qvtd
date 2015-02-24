/**
 */
package example1.target;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.target.A1#getOwnsB <em>Owns B</em>}</li>
 * </ul>
 *
 * @see example1.target.TargetPackage#getA1()
 * @model
 * @generated
 */
public interface A1 extends A {
	/**
	 * Returns the value of the '<em><b>Owns B</b></em>' containment reference list.
	 * The list contents are of type {@link example1.target.B}.
	 * It is bidirectional and its opposite is '{@link example1.target.B#getToA1 <em>To A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns B</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns B</em>' containment reference list.
	 * @see example1.target.TargetPackage#getA1_OwnsB()
	 * @see example1.target.B#getToA1
	 * @model opposite="toA1" containment="true"
	 * @generated
	 */
	EList<B> getOwnsB();

} // A1
