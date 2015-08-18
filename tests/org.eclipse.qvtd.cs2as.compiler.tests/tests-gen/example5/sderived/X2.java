/**
 */
package example5.sderived;

import example5.sbase.X;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>X2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.sderived.X2#getOwnsW <em>Owns W</em>}</li>
 * </ul>
 *
 * @see example5.sderived.SderivedPackage#getX2()
 * @model
 * @generated
 */
public interface X2 extends X {
	/**
	 * Returns the value of the '<em><b>Owns W</b></em>' containment reference list.
	 * The list contents are of type {@link example5.sderived.W}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns W</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns W</em>' containment reference list.
	 * @see example5.sderived.SderivedPackage#getX2_OwnsW()
	 * @model containment="true"
	 * @generated
	 */
	EList<W> getOwnsW();

} // X2
