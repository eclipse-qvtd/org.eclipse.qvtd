/**
 */
package classescs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link classescs.PathNameCS#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see classescs.ClassescsPackage#getPathNameCS()
 * @model
 * @generated
 */
public interface PathNameCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link classescs.PathElementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see classescs.ClassescsPackage#getPathNameCS_Path()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PathElementCS> getPath();

} // PathNameCS
