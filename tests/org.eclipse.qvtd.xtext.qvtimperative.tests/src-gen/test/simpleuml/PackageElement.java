/**
 */
package test.simpleuml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simpleuml.PackageElement#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simpleuml.SimpleumlPackage#getPackageElement()
 * @model abstract="true"
 * @generated
 */
public interface PackageElement extends UMLModelElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.simpleuml.Package#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' container reference.
	 * @see #setNamespace(test.simpleuml.Package)
	 * @see test.simpleuml.SimpleumlPackage#getPackageElement_Namespace()
	 * @see test.simpleuml.Package#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	test.simpleuml.Package getNamespace();

	/**
	 * Sets the value of the '{@link test.simpleuml.PackageElement#getNamespace <em>Namespace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' container reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(test.simpleuml.Package value);

} // PackageElement
