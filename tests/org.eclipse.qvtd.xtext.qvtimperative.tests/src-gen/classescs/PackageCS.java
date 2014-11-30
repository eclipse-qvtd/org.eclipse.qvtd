/**
 */
package classescs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link classescs.PackageCS#getOwnedClasses <em>Owned Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see classescs.ClassescsPackage#getPackageCS()
 * @model
 * @generated
 */
public interface PackageCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Owned Classes</b></em>' containment reference list.
	 * The list contents are of type {@link classescs.ClassCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Classes</em>' containment reference list.
	 * @see classescs.ClassescsPackage#getPackageCS_OwnedClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassCS> getOwnedClasses();

} // PackageCS
