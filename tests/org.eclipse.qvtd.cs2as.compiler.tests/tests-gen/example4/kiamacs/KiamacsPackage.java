/**
 */
package example4.kiamacs;

import org.eclipse.emf.ecore.EClass;
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
 * @see example4.kiamacs.KiamacsFactory
 * @model kind="package"
 * @generated
 */
public interface KiamacsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kiamacs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example4/simplerkiamacs/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kiamacs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KiamacsPackage eINSTANCE = example4.kiamacs.impl.KiamacsPackageImpl.init();

	/**
	 * The meta object id for the '{@link example4.kiamacs.impl.BaseCSImpl <em>Base CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example4.kiamacs.impl.BaseCSImpl
	 * @see example4.kiamacs.impl.KiamacsPackageImpl#getBaseCS()
	 * @generated
	 */
	int BASE_CS = 4;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CS__AST = 0;

	/**
	 * The number of structural features of the '<em>Base CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link example4.kiamacs.impl.TopCSImpl <em>Top CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example4.kiamacs.impl.TopCSImpl
	 * @see example4.kiamacs.impl.KiamacsPackageImpl#getTopCS()
	 * @generated
	 */
	int TOP_CS = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CS__AST = BASE_CS__AST;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CS__NODE = BASE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Top CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CS_FEATURE_COUNT = BASE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Top CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_CS_OPERATION_COUNT = BASE_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example4.kiamacs.impl.NodeCSImpl <em>Node CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example4.kiamacs.impl.NodeCSImpl
	 * @see example4.kiamacs.impl.KiamacsPackageImpl#getNodeCS()
	 * @generated
	 */
	int NODE_CS = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CS__AST = BASE_CS__AST;

	/**
	 * The number of structural features of the '<em>Node CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CS_FEATURE_COUNT = BASE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Node CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CS_OPERATION_COUNT = BASE_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example4.kiamacs.impl.CompositeCSImpl <em>Composite CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example4.kiamacs.impl.CompositeCSImpl
	 * @see example4.kiamacs.impl.KiamacsPackageImpl#getCompositeCS()
	 * @generated
	 */
	int COMPOSITE_CS = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CS__AST = NODE_CS__AST;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CS__CHILD = NODE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CS_FEATURE_COUNT = NODE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CS_OPERATION_COUNT = NODE_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example4.kiamacs.impl.LeafCSImpl <em>Leaf CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example4.kiamacs.impl.LeafCSImpl
	 * @see example4.kiamacs.impl.KiamacsPackageImpl#getLeafCS()
	 * @generated
	 */
	int LEAF_CS = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CS__AST = NODE_CS__AST;

	/**
	 * The number of structural features of the '<em>Leaf CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CS_FEATURE_COUNT = NODE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Leaf CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CS_OPERATION_COUNT = NODE_CS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link example4.kiamacs.TopCS <em>Top CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top CS</em>'.
	 * @see example4.kiamacs.TopCS
	 * @generated
	 */
	EClass getTopCS();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamacs.TopCS#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see example4.kiamacs.TopCS#getNode()
	 * @see #getTopCS()
	 * @generated
	 */
	EReference getTopCS_Node();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.NodeCS <em>Node CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node CS</em>'.
	 * @see example4.kiamacs.NodeCS
	 * @generated
	 */
	EClass getNodeCS();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.CompositeCS <em>Composite CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite CS</em>'.
	 * @see example4.kiamacs.CompositeCS
	 * @generated
	 */
	EClass getCompositeCS();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamacs.CompositeCS#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see example4.kiamacs.CompositeCS#getChild()
	 * @see #getCompositeCS()
	 * @generated
	 */
	EReference getCompositeCS_Child();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.LeafCS <em>Leaf CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf CS</em>'.
	 * @see example4.kiamacs.LeafCS
	 * @generated
	 */
	EClass getLeafCS();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.BaseCS <em>Base CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base CS</em>'.
	 * @see example4.kiamacs.BaseCS
	 * @generated
	 */
	EClass getBaseCS();

	/**
	 * Returns the meta object for the reference '{@link example4.kiamacs.BaseCS#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see example4.kiamacs.BaseCS#getAst()
	 * @see #getBaseCS()
	 * @generated
	 */
	EReference getBaseCS_Ast();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KiamacsFactory getKiamacsFactory();

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
		 * The meta object literal for the '{@link example4.kiamacs.impl.TopCSImpl <em>Top CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.TopCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getTopCS()
		 * @generated
		 */
		EClass TOP_CS = eINSTANCE.getTopCS();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_CS__NODE = eINSTANCE.getTopCS_Node();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.NodeCSImpl <em>Node CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.NodeCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getNodeCS()
		 * @generated
		 */
		EClass NODE_CS = eINSTANCE.getNodeCS();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.CompositeCSImpl <em>Composite CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.CompositeCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getCompositeCS()
		 * @generated
		 */
		EClass COMPOSITE_CS = eINSTANCE.getCompositeCS();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_CS__CHILD = eINSTANCE.getCompositeCS_Child();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.LeafCSImpl <em>Leaf CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.LeafCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getLeafCS()
		 * @generated
		 */
		EClass LEAF_CS = eINSTANCE.getLeafCS();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.BaseCSImpl <em>Base CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.BaseCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getBaseCS()
		 * @generated
		 */
		EClass BASE_CS = eINSTANCE.getBaseCS();

		/**
		 * The meta object literal for the '<em><b>Ast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_CS__AST = eINSTANCE.getBaseCS_Ast();

	}

} //KiamacsPackage
