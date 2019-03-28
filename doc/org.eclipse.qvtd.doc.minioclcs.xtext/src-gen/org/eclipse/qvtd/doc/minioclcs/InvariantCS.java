/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.InvariantCS#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getInvariantCS()
 * @model
 * @generated
 */
public interface InvariantCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' containment reference.
	 * @see #setExp(ExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getInvariantCS_Exp()
	 * @model containment="true"
	 * @generated
	 */
  ExpCS getExp();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.InvariantCS#getExp <em>Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' containment reference.
	 * @see #getExp()
	 * @generated
	 */
  void setExp(ExpCS value);

} // InvariantCS
