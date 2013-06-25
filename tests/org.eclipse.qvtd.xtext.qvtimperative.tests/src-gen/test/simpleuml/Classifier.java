/**
 */
package test.simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simpleuml.Classifier#getTypeOpposite <em>Type Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simpleuml.SimpleumlPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends PackageElement {
	/**
	 * Returns the value of the '<em><b>Type Opposite</b></em>' reference list.
	 * The list contents are of type {@link test.simpleuml.Attribute}.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Opposite</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Opposite</em>' reference list.
	 * @see test.simpleuml.SimpleumlPackage#getClassifier_TypeOpposite()
	 * @see test.simpleuml.Attribute#getType
	 * @model opposite="type"
	 * @generated
	 */
	EList<Attribute> getTypeOpposite();

} // Classifier
