/**
 */
package example2.classes.lookup;

import example2.classes.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Env Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.lookup.EnvEntry#getName <em>Name</em>}</li>
 *   <li>{@link example2.classes.lookup.EnvEntry#getNamedElements <em>Named Elements</em>}</li>
 *   <li>{@link example2.classes.lookup.EnvEntry#getEnv <em>Env</em>}</li>
 * </ul>
 *
 * @see example2.classes.lookup.EnvironmentPackage#getEnvEntry()
 * @model
 * @generated
 */
public interface EnvEntry extends EObject {
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
	 * @see example2.classes.lookup.EnvironmentPackage#getEnvEntry_Name()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!EnvEntry!name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link example2.classes.lookup.EnvEntry#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Named Elements</b></em>' reference list.
	 * The list contents are of type {@link example2.classes.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elements</em>' reference list.
	 * @see example2.classes.lookup.EnvironmentPackage#getEnvEntry_NamedElements()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!EnvEntry!namedElements'"
	 * @generated
	 */
	EList<NamedElement> getNamedElements();

	/**
	 * Returns the value of the '<em><b>Env</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example2.classes.lookup.LookupEnvironment#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env</em>' container reference.
	 * @see #setEnv(LookupEnvironment)
	 * @see example2.classes.lookup.EnvironmentPackage#getEnvEntry_Env()
	 * @see example2.classes.lookup.LookupEnvironment#getEntries
	 * @model opposite="entries" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/env/1.0!EnvEntry!env'"
	 * @generated
	 */
	LookupEnvironment getEnv();

	/**
	 * Sets the value of the '{@link example2.classes.lookup.EnvEntry#getEnv <em>Env</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Env</em>' container reference.
	 * @see #getEnv()
	 * @generated
	 */
	void setEnv(LookupEnvironment value);

} // EnvEntry
