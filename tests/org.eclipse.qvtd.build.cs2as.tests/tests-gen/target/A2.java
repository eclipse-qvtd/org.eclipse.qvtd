/**
 */
package target;

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
 *   <li>{@link target.A2#getOwnsC <em>Owns C</em>}</li>
 * </ul>
 *
 * @see target.TargetPackage#getA2()
 * @model
 * @generated
 */
public interface A2 extends A {
	/**
	 * Returns the value of the '<em><b>Owns C</b></em>' containment reference list.
	 * The list contents are of type {@link target.C}.
	 * It is bidirectional and its opposite is '{@link target.C#getToA2 <em>To A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns C</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns C</em>' containment reference list.
	 * @see target.TargetPackage#getA2_OwnsC()
	 * @see target.C#getToA2
	 * @model opposite="toA2" containment="true"
	 * @generated
	 */
	EList<C> getOwnsC();

} // A2
