/**
 */
package example2.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.Root#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @see example2.classes.ClassesPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends Element {
	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see example2.classes.ClassesPackage#getRoot_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<example2.classes.Package> getOwnedPackages();

} // Root
