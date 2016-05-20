/**
 */
package org.eclipse.qvtd.doc.miniocl;

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
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Root#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends Element {
	/**
	 * Returns the value of the '<em><b>Owned Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Packages</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getRoot_OwnedPackages()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Root!ownedPackages'"
	 * @generated
	 */
	EList<org.eclipse.qvtd.doc.miniocl.Package> getOwnedPackages();

} // Root
