/**
 */
package example5.tbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.tbase.A#getOwnsB <em>Owns B</em>}</li>
 * </ul>
 *
 * @see example5.tbase.TbasePackage#getA()
 * @model
 * @generated
 */
public interface A extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owns B</b></em>' containment reference list.
	 * The list contents are of type {@link example5.tbase.B}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns B</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns B</em>' containment reference list.
	 * @see example5.tbase.TbasePackage#getA_OwnsB()
	 * @model containment="true"
	 * @generated
	 */
	EList<B> getOwnsB();

} // A
