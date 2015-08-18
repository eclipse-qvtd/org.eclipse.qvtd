/**
 */
package example2.classescs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.NameExpCS#getName <em>Name</em>}</li>
 *   <li>{@link example2.classescs.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 *   <li>{@link example2.classescs.NameExpCS#getOwnedNameExp <em>Owned Name Exp</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends ElementCS {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(PathNameCS)
	 * @see example2.classescs.ClassescsPackage#getNameExpCS_Name()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getName();

	/**
	 * Sets the value of the '{@link example2.classescs.NameExpCS#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Rounded Brackets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounded Brackets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #setRoundedBrackets(RoundedBracketClause)
	 * @see example2.classescs.ClassescsPackage#getNameExpCS_RoundedBrackets()
	 * @model containment="true"
	 * @generated
	 */
	RoundedBracketClause getRoundedBrackets();

	/**
	 * Sets the value of the '{@link example2.classescs.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounded Brackets</em>' containment reference.
	 * @see #getRoundedBrackets()
	 * @generated
	 */
	void setRoundedBrackets(RoundedBracketClause value);

	/**
	 * Returns the value of the '<em><b>Owned Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Name Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Name Exp</em>' containment reference.
	 * @see #setOwnedNameExp(NameExpCS)
	 * @see example2.classescs.ClassescsPackage#getNameExpCS_OwnedNameExp()
	 * @model containment="true"
	 * @generated
	 */
	NameExpCS getOwnedNameExp();

	/**
	 * Sets the value of the '{@link example2.classescs.NameExpCS#getOwnedNameExp <em>Owned Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Name Exp</em>' containment reference.
	 * @see #getOwnedNameExp()
	 * @generated
	 */
	void setOwnedNameExp(NameExpCS value);

} // NameExpCS
