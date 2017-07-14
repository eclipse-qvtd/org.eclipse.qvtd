/**
 * generated by Xtext 2.12.0
 */
package org.eclipse.qvtd.doc.minioclcs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Var CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getInitExp <em>Init Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getLetVarCS()
 * @model
 * @generated
 */
public interface LetVarCS extends CSTrace
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getLetVarCS_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

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
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getLetVarCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getTypeRef();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
  void setTypeRef(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Exp</em>' containment reference.
	 * @see #setInitExp(ExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getLetVarCS_InitExp()
	 * @model containment="true"
	 * @generated
	 */
  ExpCS getInitExp();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.LetVarCS#getInitExp <em>Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Exp</em>' containment reference.
	 * @see #getInitExp()
	 * @generated
	 */
  void setInitExp(ExpCS value);

} // LetVarCS
