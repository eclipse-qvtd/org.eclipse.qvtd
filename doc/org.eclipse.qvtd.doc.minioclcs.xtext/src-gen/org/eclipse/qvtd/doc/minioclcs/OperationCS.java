/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getResultRef <em>Result Ref</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends CSTrace
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
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getOperationCS_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.doc.minioclcs.ParameterCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getOperationCS_Params()
	 * @model containment="true"
	 * @generated
	 */
  EList<ParameterCS> getParams();

  /**
	 * Returns the value of the '<em><b>Result Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Ref</em>' containment reference.
	 * @see #setResultRef(PathNameCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getOperationCS_ResultRef()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getResultRef();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getResultRef <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Ref</em>' containment reference.
	 * @see #getResultRef()
	 * @generated
	 */
  void setResultRef(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(ExpCS)
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getOperationCS_Body()
	 * @model containment="true"
	 * @generated
	 */
  ExpCS getBody();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.OperationCS#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
  void setBody(ExpCS value);

} // OperationCS
