/**
 */
package build.test.middle.HSV2HLS;

import build.test.hls.HLSTree.HLSNode;

import build.test.hsv.HSVTree.HSVNode;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HSV Node2 HLS Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getParent <em>Parent</em>}</li>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getChildren <em>Children</em>}</li>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getHsv <em>Hsv</em>}</li>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getHls <em>Hls</em>}</li>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getRgb <em>Rgb</em>}</li>
 *   <li>{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode()
 * @model
 * @generated
 */
public interface HSVNode2HLSNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(HSVNode2HLSNode)
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Parent()
	 * @see build.test.middle.HSV2HLS.HSVNode2HLSNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	HSVNode2HLSNode getParent();

	/**
	 * Sets the value of the '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HSVNode2HLSNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link build.test.middle.HSV2HLS.HSVNode2HLSNode}.
	 * It is bidirectional and its opposite is '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Children()
	 * @see build.test.middle.HSV2HLS.HSVNode2HLSNode#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<HSVNode2HLSNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Hsv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hsv</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hsv</em>' reference.
	 * @see #setHsv(HSVNode)
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Hsv()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	HSVNode getHsv();

	/**
	 * Sets the value of the '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getHsv <em>Hsv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hsv</em>' reference.
	 * @see #getHsv()
	 * @generated
	 */
	void setHsv(HSVNode value);

	/**
	 * Returns the value of the '<em><b>Hls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hls</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hls</em>' reference.
	 * @see #setHls(HLSNode)
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Hls()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeUpper body='1'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle'"
	 * @generated
	 */
	HLSNode getHls();

	/**
	 * Sets the value of the '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getHls <em>Hls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hls</em>' reference.
	 * @see #getHls()
	 * @generated
	 */
	void setHls(HLSNode value);

	/**
	 * Returns the value of the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rgb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rgb</em>' attribute.
	 * @see #setRgb(String)
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Rgb()
	 * @model dataType="build.test.middle.HSV2HLS.RGB" required="true"
	 * @generated
	 */
	String getRgb();

	/**
	 * Sets the value of the '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getRgb <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rgb</em>' attribute.
	 * @see #getRgb()
	 * @generated
	 */
	void setRgb(String value);

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
	 * @see build.test.middle.HSV2HLS.HSV2HLSPackage#getHSVNode2HLSNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link build.test.middle.HSV2HLS.HSVNode2HLSNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // HSVNode2HLSNode
