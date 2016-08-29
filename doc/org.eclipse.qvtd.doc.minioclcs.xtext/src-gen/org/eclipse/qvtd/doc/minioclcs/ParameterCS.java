/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.ParameterCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.minioclcs.ParameterCS#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getParameterCS()
 * @model
 * @generated
 */
public interface ParameterCS extends CSTrace
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
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getParameterCS_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.ParameterCS#getName <em>Name</em>}' attribute.
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
	 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage#getParameterCS_TypeRef()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getTypeRef();

  /**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.minioclcs.ParameterCS#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
  void setTypeRef(PathNameCS value);

} // ParameterCS
