/**
 * generated by Xtext 2.12.0
 */
package org.eclipse.qvtd.doc.minioclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Var CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.IteratorVarCS#getItName <em>It Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.IteratorVarCS#getItType <em>It Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getIteratorVarCS()
 * @model
 * @generated
 */
public interface IteratorVarCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>It Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>It Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>It Name</em>' attribute.
	 * @see #setItName(String)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getIteratorVarCS_ItName()
	 * @model
	 * @generated
	 */
  String getItName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.IteratorVarCS#getItName <em>It Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It Name</em>' attribute.
	 * @see #getItName()
	 * @generated
	 */
  void setItName(String value);

  /**
	 * Returns the value of the '<em><b>It Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>It Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>It Type</em>' containment reference.
	 * @see #setItType(PathNameCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getIteratorVarCS_ItType()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getItType();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.IteratorVarCS#getItType <em>It Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>It Type</em>' containment reference.
	 * @see #getItType()
	 * @generated
	 */
  void setItType(PathNameCS value);

} // IteratorVarCS
