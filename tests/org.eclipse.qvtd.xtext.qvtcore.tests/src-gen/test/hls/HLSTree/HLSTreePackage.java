/**
 */
package test.hls.HLSTree;

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
 * @see test.hls.HLSTree.HLSTreeFactory
 * @model kind="package"
 * @generated
 */
public interface HLSTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HLSTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/ICMT2013/HLSTree.ecore";

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
	HLSTreePackage eINSTANCE = test.hls.HLSTree.impl.HLSTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link test.hls.HLSTree.impl.HLSNodeImpl <em>HLS Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.hls.HLSTree.impl.HLSNodeImpl
	 * @see test.hls.HLSTree.impl.HLSTreePackageImpl#getHLSNode()
	 * @generated
	 */
	int HLS_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Hls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE__HLS = 3;

	/**
	 * The number of structural features of the '<em>HLS Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>HLS Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HLS_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>HLS</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.hls.HLS
	 * @see test.hls.HLSTree.impl.HLSTreePackageImpl#getHLS()
	 * @generated
	 */
	int HLS = 1;


	/**
	 * Returns the meta object for class '{@link test.hls.HLSTree.HLSNode <em>HLS Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HLS Node</em>'.
	 * @see test.hls.HLSTree.HLSNode
	 * @generated
	 */
	EClass getHLSNode();

	/**
	 * Returns the meta object for the container reference '{@link test.hls.HLSTree.HLSNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see test.hls.HLSTree.HLSNode#getParent()
	 * @see #getHLSNode()
	 * @generated
	 */
	EReference getHLSNode_Parent();

	/**
	 * Returns the meta object for the attribute '{@link test.hls.HLSTree.HLSNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.hls.HLSTree.HLSNode#getName()
	 * @see #getHLSNode()
	 * @generated
	 */
	EAttribute getHLSNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link test.hls.HLSTree.HLSNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see test.hls.HLSTree.HLSNode#getChildren()
	 * @see #getHLSNode()
	 * @generated
	 */
	EReference getHLSNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link test.hls.HLSTree.HLSNode#getHls <em>Hls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hls</em>'.
	 * @see test.hls.HLSTree.HLSNode#getHls()
	 * @see #getHLSNode()
	 * @generated
	 */
	EAttribute getHLSNode_Hls();

	/**
	 * Returns the meta object for data type '{@link test.hls.HLS <em>HLS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>HLS</em>'.
	 * @see test.hls.HLS
	 * @model instanceClass="test.hls.HLS"
	 * @generated
	 */
	EDataType getHLS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HLSTreeFactory getHLSTreeFactory();

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
		 * The meta object literal for the '{@link test.hls.HLSTree.impl.HLSNodeImpl <em>HLS Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.hls.HLSTree.impl.HLSNodeImpl
		 * @see test.hls.HLSTree.impl.HLSTreePackageImpl#getHLSNode()
		 * @generated
		 */
		EClass HLS_NODE = eINSTANCE.getHLSNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HLS_NODE__PARENT = eINSTANCE.getHLSNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HLS_NODE__NAME = eINSTANCE.getHLSNode_Name();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HLS_NODE__CHILDREN = eINSTANCE.getHLSNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HLS_NODE__HLS = eINSTANCE.getHLSNode_Hls();

		/**
		 * The meta object literal for the '<em>HLS</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.hls.HLS
		 * @see test.hls.HLSTree.impl.HLSTreePackageImpl#getHLS()
		 * @generated
		 */
		EDataType HLS = eINSTANCE.getHLS();

	}

} //HLSTreePackage
