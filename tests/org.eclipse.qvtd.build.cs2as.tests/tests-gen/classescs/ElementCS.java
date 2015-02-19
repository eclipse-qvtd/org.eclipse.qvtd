/**
 */
package classescs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link classescs.ElementCS#getAst <em>Ast</em>}</li>
 * </ul>
 *
 * @see classescs.ClassescsPackage#getElementCS()
 * @model abstract="true"
 * @generated
 */
public interface ElementCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ast</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ast</em>' reference.
	 * @see #setAst(EObject)
	 * @see classescs.ClassescsPackage#getElementCS_Ast()
	 * @model
	 * @generated
	 */
	EObject getAst();

	/**
	 * Sets the value of the '{@link classescs.ElementCS#getAst <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ast</em>' reference.
	 * @see #getAst()
	 * @generated
	 */
	void setAst(EObject value);

} // ElementCS
