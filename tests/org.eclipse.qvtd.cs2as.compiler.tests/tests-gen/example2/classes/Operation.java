/**
 */
package example2.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example2.classes.Operation#getOwnedParameters <em>Owned Parameters</em>}</li>
 *   <li>{@link example2.classes.Operation#getOwnedExpressions <em>Owned Expressions</em>}</li>
 * </ul>
 *
 * @see example2.classes.ClassesPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends NamedElement, TypedElement {
	/**
	 * Returns the value of the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameters</em>' containment reference list.
	 * @see example2.classes.ClassesPackage#getOperation_OwnedParameters()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/classes/1.0!Operation!ownedParameters'"
	 * @generated
	 */
	EList<Parameter> getOwnedParameters();

	/**
	 * Returns the value of the '<em><b>Owned Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link example2.classes.CallExp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expressions</em>' containment reference list.
	 * @see example2.classes.ClassesPackage#getOperation_OwnedExpressions()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example2/classes/1.0!Operation!ownedExpressions'"
	 * @generated
	 */
	EList<CallExp> getOwnedExpressions();

} // Operation
