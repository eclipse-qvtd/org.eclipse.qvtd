/**
 * generated by Xtext 2.16.0
 */
package org.eclipse.qvtd.doc.minioclcs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.NameExpCS#getExpName <em>Exp Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends PrimaryExpCS, NavigationExpCS
{
  /**
	 * Returns the value of the '<em><b>Exp Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp Name</em>' containment reference.
	 * @see #setExpName(PathNameCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getNameExpCS_ExpName()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getExpName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.NameExpCS#getExpName <em>Exp Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp Name</em>' containment reference.
	 * @see #getExpName()
	 * @generated
	 */
  void setExpName(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>Rounded Brackets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #setRoundedBrackets(RoundedBracketClauseCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getNameExpCS_RoundedBrackets()
	 * @model containment="true"
	 * @generated
	 */
  RoundedBracketClauseCS getRoundedBrackets();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #getRoundedBrackets()
	 * @generated
	 */
  void setRoundedBrackets(RoundedBracketClauseCS value);

} // NameExpCS
