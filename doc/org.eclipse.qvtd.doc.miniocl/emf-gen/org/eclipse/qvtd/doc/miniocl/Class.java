/**
 */
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Class#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedProperties <em>Owned Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedInvariants <em>Owned Invariants</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(Class)
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getClass_SuperClass()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Class!superClass'"
	 * @generated
	 */
	Class getSuperClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.miniocl.Class#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(Class value);

	/**
	 * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.Operation}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operations</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getClass_OwnedOperations()
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Class!ownedOperations'"
	 * @generated
	 */
	EList<Operation> getOwnedOperations();

	/**
	 * Returns the value of the '<em><b>Owned Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Properties</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getClass_OwnedProperties()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Class!ownedProperties'"
	 * @generated
	 */
	EList<Property> getOwnedProperties();

	/**
	 * Returns the value of the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.miniocl.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Invariants</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage#getClass_OwnedInvariants()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvtd/doc/MiniOCL/1.0!Class!ownedInvariants'"
	 * @generated
	 */
	EList<Constraint> getOwnedInvariants();

} // Class
