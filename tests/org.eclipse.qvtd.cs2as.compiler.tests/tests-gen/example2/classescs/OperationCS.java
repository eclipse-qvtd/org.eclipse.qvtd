/**
 */
package example2.classescs;

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
 *   <li>{@link example2.classescs.OperationCS#getParams <em>Params</em>}</li>
 *   <li>{@link example2.classescs.OperationCS#getBodyExps <em>Body Exps</em>}</li>
 *   <li>{@link example2.classescs.OperationCS#getResultRef <em>Result Ref</em>}</li>
 * </ul>
 *
 * @see example2.classescs.ClassescsPackage#getOperationCS()
 * @model
 * @generated
 */
public interface OperationCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Params</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' attribute list.
	 * @see example2.classescs.ClassescsPackage#getOperationCS_Params()
	 * @model
	 * @generated
	 */
	EList<String> getParams();

	/**
	 * Returns the value of the '<em><b>Body Exps</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classescs.NameExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Exps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Exps</em>' containment reference list.
	 * @see example2.classescs.ClassescsPackage#getOperationCS_BodyExps()
	 * @model containment="true"
	 * @generated
	 */
	EList<NameExpCS> getBodyExps();

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
	 * @see example2.classescs.ClassescsPackage#getOperationCS_ResultRef()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getResultRef();

	/**
	 * Sets the value of the '{@link example2.classescs.OperationCS#getResultRef <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Ref</em>' containment reference.
	 * @see #getResultRef()
	 * @generated
	 */
	void setResultRef(PathNameCS value);

} // OperationCS
