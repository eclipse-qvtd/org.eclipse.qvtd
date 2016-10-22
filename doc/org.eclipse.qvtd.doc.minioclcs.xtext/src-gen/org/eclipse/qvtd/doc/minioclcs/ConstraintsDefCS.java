/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraints Def CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.ConstraintsDefCS#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.ConstraintsDefCS#getInvariants <em>Invariants</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getConstraintsDefCS()
 * @model
 * @generated
 */
public interface ConstraintsDefCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(PathNameCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getConstraintsDefCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getTypeRef();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.ConstraintsDefCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
  void setTypeRef(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.minioclcs.InvariantCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getConstraintsDefCS_Invariants()
	 * @model containment="true"
	 * @generated
	 */
  EList<InvariantCS> getInvariants();

} // ConstraintsDefCS
