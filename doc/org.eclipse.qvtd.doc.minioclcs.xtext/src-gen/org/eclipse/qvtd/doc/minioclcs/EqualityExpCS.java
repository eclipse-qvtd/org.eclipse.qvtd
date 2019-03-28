/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equality Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getOpName <em>Op Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getEqualityExpCS()
 * @model
 * @generated
 */
public interface EqualityExpCS extends ExpCS
{
  /**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(EqualityExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getEqualityExpCS_Left()
	 * @model containment="true"
	 * @generated
	 */
  EqualityExpCS getLeft();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
  void setLeft(EqualityExpCS value);

  /**
	 * Returns the value of the '<em><b>Op Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Op Name</em>' attribute.
	 * @see #setOpName(String)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getEqualityExpCS_OpName()
	 * @model
	 * @generated
	 */
  String getOpName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getOpName <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op Name</em>' attribute.
	 * @see #getOpName()
	 * @generated
	 */
  void setOpName(String value);

  /**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(CallExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getEqualityExpCS_Right()
	 * @model containment="true"
	 * @generated
	 */
  CallExpCS getRight();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.EqualityExpCS#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
  void setRight(CallExpCS value);

} // EqualityExpCS
