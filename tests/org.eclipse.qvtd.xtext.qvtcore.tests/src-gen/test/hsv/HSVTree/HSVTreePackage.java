/**
 */
package test.hsv.HSVTree;

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
 * @see test.hsv.HSVTree.HSVTreeFactory
 * @model kind="package"
 * @generated
 */
public interface HSVTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HSVTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/ICMT2013/HSVTree.ecore";

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
	HSVTreePackage eINSTANCE = test.hsv.HSVTree.impl.HSVTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link test.hsv.HSVTree.impl.HSVNodeImpl <em>HSV Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.hsv.HSVTree.impl.HSVNodeImpl
	 * @see test.hsv.HSVTree.impl.HSVTreePackageImpl#getHSVNode()
	 * @generated
	 */
	int HSV_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Hsv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__HSV = 3;

	/**
	 * The number of structural features of the '<em>HSV Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>HSV Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>HSV</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.hsv.HSV
	 * @see test.hsv.HSVTree.impl.HSVTreePackageImpl#getHSV()
	 * @generated
	 */
	int HSV = 1;


	/**
	 * Returns the meta object for class '{@link test.hsv.HSVTree.HSVNode <em>HSV Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HSV Node</em>'.
	 * @see test.hsv.HSVTree.HSVNode
	 * @generated
	 */
	EClass getHSVNode();

	/**
	 * Returns the meta object for the container reference '{@link test.hsv.HSVTree.HSVNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see test.hsv.HSVTree.HSVNode#getParent()
	 * @see #getHSVNode()
	 * @generated
	 */
	EReference getHSVNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link test.hsv.HSVTree.HSVNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.hsv.HSVTree.HSVNode#getName()
	 * @see #getHSVNode()
	 * @generated
	 */
	EAttribute getHSVNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link test.hsv.HSVTree.HSVNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see test.hsv.HSVTree.HSVNode#getChildren()
	 * @see #getHSVNode()
	 * @generated
	 */
	EReference getHSVNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link test.hsv.HSVTree.HSVNode#getHsv <em>Hsv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hsv</em>'.
	 * @see test.hsv.HSVTree.HSVNode#getHsv()
	 * @see #getHSVNode()
	 * @generated
	 */
	EAttribute getHSVNode_Hsv();

	/**
	 * Returns the meta object for data type '{@link test.hsv.HSV <em>HSV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>HSV</em>'.
	 * @see test.hsv.HSV
	 * @model instanceClass="test.hsv.HSV"
	 * @generated
	 */
	EDataType getHSV();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HSVTreeFactory getHSVTreeFactory();

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
		 * The meta object literal for the '{@link test.hsv.HSVTree.impl.HSVNodeImpl <em>HSV Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.hsv.HSVTree.impl.HSVNodeImpl
		 * @see test.hsv.HSVTree.impl.HSVTreePackageImpl#getHSVNode()
		 * @generated
		 */
		EClass HSV_NODE = eINSTANCE.getHSVNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE__PARENT = eINSTANCE.getHSVNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE__NAME = eINSTANCE.getHSVNode_Name();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE__CHILDREN = eINSTANCE.getHSVNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hsv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE__HSV = eINSTANCE.getHSVNode_Hsv();

		/**
		 * The meta object literal for the '<em>HSV</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.hsv.HSV
		 * @see test.hsv.HSVTree.impl.HSVTreePackageImpl#getHSV()
		 * @generated
		 */
		EDataType HSV = eINSTANCE.getHSV();

	}

} //HSVTreePackage
