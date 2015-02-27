/**
 */
package example2.classescs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.RootCS#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getRootCS()
 * @model
 * @generated
 */
public interface RootCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classescs.PackageCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see example2.classescs.ClassescsPackage#getRootCS_OwnedPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageCS> getOwnedPackages();

} // RootCS
