/**
 */
package test.middle.HSV2HLS;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see test.middle.HSV2HLS.HSV2HLSFactory
 * @model kind="package"
 * @generated
 */
public interface HSV2HLSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HSV2HLS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/ICMT2013/ColoredTree2Tree.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pfx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSV2HLSPackage eINSTANCE = test.middle.HSV2HLS.impl.HSV2HLSPackageImpl.init();

	/**
	 * The meta object id for the '{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl <em>HSV Node2 HLS Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl
	 * @see test.middle.HSV2HLS.impl.HSV2HLSPackageImpl#getHSVNode2HLSNode()
	 * @generated
	 */
	int HSV_NODE2_HLS_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Hsv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__HSV = 3;

	/**
	 * The feature id for the '<em><b>Hls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__HLS = 4;

	/**
	 * The feature id for the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE__RGB = 5;

	/**
	 * The number of structural features of the '<em>HSV Node2 HLS Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>HSV Node2 HLS Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HLS_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>RGB</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.middle.RGB
	 * @see test.middle.HSV2HLS.impl.HSV2HLSPackageImpl#getRGB()
	 * @generated
	 */
	int RGB = 1;


	/**
	 * Returns the meta object for class '{@link test.middle.HSV2HLS.HSVNode2HLSNode <em>HSV Node2 HLS Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HSV Node2 HLS Node</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode
	 * @generated
	 */
	EClass getHSVNode2HLSNode();

	/**
	 * Returns the meta object for the container reference '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getParent()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EReference getHSVNode2HLSNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getName()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EAttribute getHSVNode2HLSNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getChildren()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EReference getHSVNode2HLSNode_Children();

	/**
	 * Returns the meta object for the reference '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getHsv <em>Hsv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hsv</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getHsv()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EReference getHSVNode2HLSNode_Hsv();

	/**
	 * Returns the meta object for the reference '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getHls <em>Hls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hls</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getHls()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EReference getHSVNode2HLSNode_Hls();

	/**
	 * Returns the meta object for the attribute '{@link test.middle.HSV2HLS.HSVNode2HLSNode#getRgb <em>Rgb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rgb</em>'.
	 * @see test.middle.HSV2HLS.HSVNode2HLSNode#getRgb()
	 * @see #getHSVNode2HLSNode()
	 * @generated
	 */
	EAttribute getHSVNode2HLSNode_Rgb();

	/**
	 * Returns the meta object for data type '{@link test.middle.RGB <em>RGB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>RGB</em>'.
	 * @see test.middle.RGB
	 * @model instanceClass="test.middle.RGB"
	 * @generated
	 */
	EDataType getRGB();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HSV2HLSFactory getHSV2HLSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl <em>HSV Node2 HLS Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl
		 * @see test.middle.HSV2HLS.impl.HSV2HLSPackageImpl#getHSVNode2HLSNode()
		 * @generated
		 */
		EClass HSV_NODE2_HLS_NODE = eINSTANCE.getHSVNode2HLSNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HLS_NODE__PARENT = eINSTANCE.getHSVNode2HLSNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE2_HLS_NODE__NAME = eINSTANCE.getHSVNode2HLSNode_Name();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HLS_NODE__CHILDREN = eINSTANCE.getHSVNode2HLSNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hsv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HLS_NODE__HSV = eINSTANCE.getHSVNode2HLSNode_Hsv();

		/**
		 * The meta object literal for the '<em><b>Hls</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HLS_NODE__HLS = eINSTANCE.getHSVNode2HLSNode_Hls();

		/**
		 * The meta object literal for the '<em><b>Rgb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE2_HLS_NODE__RGB = eINSTANCE.getHSVNode2HLSNode_Rgb();

		/**
		 * The meta object literal for the '<em>RGB</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.middle.RGB
		 * @see test.middle.HSV2HLS.impl.HSV2HLSPackageImpl#getRGB()
		 * @generated
		 */
		EDataType RGB = eINSTANCE.getRGB();

	}

} //HSV2HLSPackage
