/**
 */
package env;

import classes.NamedElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link env.Environment#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link env.Environment#getParentEnv <em>Parent Env</em>}</li>
 * </ul>
 *
 * @see env.EnvironmentPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends EObject {

	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link classes.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see env.EnvironmentPackage#getEnvironment_NamedElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getNamedElements();

	/**
	 * Returns the value of the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Env</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Env</em>' reference.
	 * @see #setParentEnv(Environment)
	 * @see env.EnvironmentPackage#getEnvironment_ParentEnv()
	 * @model
	 * @generated
	 */
	Environment getParentEnv();

	/**
	 * Sets the value of the '{@link env.Environment#getParentEnv <em>Parent Env</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Env</em>' reference.
	 * @see #getParentEnv()
	 * @generated
	 */
	void setParentEnv(Environment value);
} // Environment
