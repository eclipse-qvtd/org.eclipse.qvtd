/**
 */
package source;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link source.SRoot#getOwnedX <em>Owned X</em>}</li>
 * </ul>
 *
 * @see source.SourcePackage#getSRoot()
 * @model
 * @generated
 */
public interface SRoot extends SElement {
	/**
	 * Returns the value of the '<em><b>Owned X</b></em>' containment reference list.
	 * The list contents are of type {@link source.X}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned X</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned X</em>' containment reference list.
	 * @see source.SourcePackage#getSRoot_OwnedX()
	 * @model containment="true"
	 * @generated
	 */
	EList<X> getOwnedX();

} // SRoot
