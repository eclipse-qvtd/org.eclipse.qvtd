/**
 */
package build.test.hsv.HSVTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HSV Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.test.hsv.HSVTree.HSVNode#getParent <em>Parent</em>}</li>
 *   <li>{@link build.test.hsv.HSVTree.HSVNode#getChildren <em>Children</em>}</li>
 *   <li>{@link build.test.hsv.HSVTree.HSVNode#getHsv <em>Hsv</em>}</li>
 *   <li>{@link build.test.hsv.HSVTree.HSVNode#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see build.test.hsv.HSVTree.HSVTreePackage#getHSVNode()
 * @model
 * @generated
 */
public interface HSVNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.hsv.HSVTree.HSVNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HSVNode)
	 * @see build.test.hsv.HSVTree.HSVTreePackage#getHSVNode_Parent()
	 * @see build.test.hsv.HSVTree.HSVNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HSVNode getParent();

	/**
	 * Sets the value of the '{@link build.test.hsv.HSVTree.HSVNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HSVNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link build.test.hsv.HSVTree.HSVNode}.
	 * It is bidirectional and its opposite is '{@link build.test.hsv.HSVTree.HSVNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see build.test.hsv.HSVTree.HSVTreePackage#getHSVNode_Children()
	 * @see build.test.hsv.HSVTree.HSVNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<HSVNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hsv</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hsv</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hsv</em>' attribute.
	 * @see #setHsv(String)
	 * @see build.test.hsv.HSVTree.HSVTreePackage#getHSVNode_Hsv()
	 * @model default="" dataType="build.test.hsv.HSVTree.HSV" required="true"
	 * @generated
	 */
	String getHsv();

	/**
	 * Sets the value of the '{@link build.test.hsv.HSVTree.HSVNode#getHsv <em>Hsv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hsv</em>' attribute.
	 * @see #getHsv()
	 * @generated
	 */
	void setHsv(String value);

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
	 * @see build.test.hsv.HSVTree.HSVTreePackage#getHSVNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link build.test.hsv.HSVTree.HSVNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // HSVNode
