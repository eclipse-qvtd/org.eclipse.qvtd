/**
 */
package test.hls.HLSTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import test.hls.HLS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HLS Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.hls.HLSTree.HLSNode#getParent <em>Parent</em>}</li>
 *   <li>{@link test.hls.HLSTree.HLSNode#getName <em>Name</em>}</li>
 *   <li>{@link test.hls.HLSTree.HLSNode#getChildren <em>Children</em>}</li>
 *   <li>{@link test.hls.HLSTree.HLSNode#getHls <em>Hls</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.hls.HLSTree.HLSTreePackage#getHLSNode()
 * @model
 * @generated
 */
public interface HLSNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link test.hls.HLSTree.HLSNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HLSNode)
	 * @see test.hls.HLSTree.HLSTreePackage#getHLSNode_Parent()
	 * @see test.hls.HLSTree.HLSNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HLSNode getParent();

	/**
	 * Sets the value of the '{@link test.hls.HLSTree.HLSNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HLSNode value);

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
	 * @see test.hls.HLSTree.HLSTreePackage#getHLSNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link test.hls.HLSTree.HLSNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link test.hls.HLSTree.HLSNode}.
	 * It is bidirectional and its opposite is '{@link test.hls.HLSTree.HLSNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see test.hls.HLSTree.HLSTreePackage#getHLSNode_Children()
	 * @see test.hls.HLSTree.HLSNode#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	EList<HLSNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hls</b></em>' attribute.
	 * The default value is <code>"HLS"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hls</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hls</em>' attribute.
	 * @see #setHls(HLS)
	 * @see test.hls.HLSTree.HLSTreePackage#getHLSNode_Hls()
	 * @model default="HLS" dataType="test.hls.HLSTree.HLS" required="true"
	 * @generated
	 */
	HLS getHls();

	/**
	 * Sets the value of the '{@link test.hls.HLSTree.HLSNode#getHls <em>Hls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hls</em>' attribute.
	 * @see #getHls()
	 * @generated
	 */
	void setHls(HLS value);

} // HLSNode
