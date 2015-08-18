/**
 */
package example3.kiamacs;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see example3.kiamacs.KiamacsFactory
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
	String eNS_URI = "http://cs2as/tests/example3/kiamacs/1.0";

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
	KiamacsPackage eINSTANCE = example3.kiamacs.impl.KiamacsPackageImpl.init();

	/**
	 * The meta object id for the '{@link example3.kiamacs.impl.BaseCSImpl <em>Base CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example3.kiamacs.impl.BaseCSImpl
	 * @see example3.kiamacs.impl.KiamacsPackageImpl#getBaseCS()
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
	 * The meta object id for the '{@link example3.kiamacs.impl.TopCSImpl <em>Top CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example3.kiamacs.impl.TopCSImpl
	 * @see example3.kiamacs.impl.KiamacsPackageImpl#getTopCS()
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
	 * The meta object id for the '{@link example3.kiamacs.impl.NodeCSImpl <em>Node CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example3.kiamacs.impl.NodeCSImpl
	 * @see example3.kiamacs.impl.KiamacsPackageImpl#getNodeCS()
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
	 * The meta object id for the '{@link example3.kiamacs.impl.PlusCSImpl <em>Plus CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example3.kiamacs.impl.PlusCSImpl
	 * @see example3.kiamacs.impl.KiamacsPackageImpl#getPlusCS()
	 * @generated
	 */
	int PLUS_CS = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_CS__AST = NODE_CS__AST;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_CS__LEFT = NODE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_CS__RIGHT = NODE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Plus CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_CS_FEATURE_COUNT = NODE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Plus CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_CS_OPERATION_COUNT = NODE_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example3.kiamacs.impl.NumCSImpl <em>Num CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example3.kiamacs.impl.NumCSImpl
	 * @see example3.kiamacs.impl.KiamacsPackageImpl#getNumCS()
	 * @generated
	 */
	int NUM_CS = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUM_CS__AST = NODE_CS__AST;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUM_CS__VALUE = NODE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Num CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUM_CS_FEATURE_COUNT = NODE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Num CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUM_CS_OPERATION_COUNT = NODE_CS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link example3.kiamacs.TopCS <em>Top CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top CS</em>'.
	 * @see example3.kiamacs.TopCS
	 * @generated
	 */
	EClass getTopCS();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamacs.TopCS#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see example3.kiamacs.TopCS#getNode()
	 * @see #getTopCS()
	 * @generated
	 */
	EReference getTopCS_Node();

	/**
	 * Returns the meta object for class '{@link example3.kiamacs.NodeCS <em>Node CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node CS</em>'.
	 * @see example3.kiamacs.NodeCS
	 * @generated
	 */
	EClass getNodeCS();

	/**
	 * Returns the meta object for class '{@link example3.kiamacs.PlusCS <em>Plus CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus CS</em>'.
	 * @see example3.kiamacs.PlusCS
	 * @generated
	 */
	EClass getPlusCS();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamacs.PlusCS#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see example3.kiamacs.PlusCS#getLeft()
	 * @see #getPlusCS()
	 * @generated
	 */
	EReference getPlusCS_Left();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamacs.PlusCS#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see example3.kiamacs.PlusCS#getRight()
	 * @see #getPlusCS()
	 * @generated
	 */
	EReference getPlusCS_Right();

	/**
	 * Returns the meta object for class '{@link example3.kiamacs.NumCS <em>Num CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Num CS</em>'.
	 * @see example3.kiamacs.NumCS
	 * @generated
	 */
	EClass getNumCS();

	/**
	 * Returns the meta object for the attribute '{@link example3.kiamacs.NumCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see example3.kiamacs.NumCS#getValue()
	 * @see #getNumCS()
	 * @generated
	 */
	EAttribute getNumCS_Value();

	/**
	 * Returns the meta object for class '{@link example3.kiamacs.BaseCS <em>Base CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base CS</em>'.
	 * @see example3.kiamacs.BaseCS
	 * @generated
	 */
	EClass getBaseCS();

	/**
	 * Returns the meta object for the reference '{@link example3.kiamacs.BaseCS#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see example3.kiamacs.BaseCS#getAst()
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
		 * The meta object literal for the '{@link example3.kiamacs.impl.TopCSImpl <em>Top CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamacs.impl.TopCSImpl
		 * @see example3.kiamacs.impl.KiamacsPackageImpl#getTopCS()
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
		 * The meta object literal for the '{@link example3.kiamacs.impl.NodeCSImpl <em>Node CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamacs.impl.NodeCSImpl
		 * @see example3.kiamacs.impl.KiamacsPackageImpl#getNodeCS()
		 * @generated
		 */
		EClass NODE_CS = eINSTANCE.getNodeCS();

		/**
		 * The meta object literal for the '{@link example3.kiamacs.impl.PlusCSImpl <em>Plus CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamacs.impl.PlusCSImpl
		 * @see example3.kiamacs.impl.KiamacsPackageImpl#getPlusCS()
		 * @generated
		 */
		EClass PLUS_CS = eINSTANCE.getPlusCS();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUS_CS__LEFT = eINSTANCE.getPlusCS_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUS_CS__RIGHT = eINSTANCE.getPlusCS_Right();

		/**
		 * The meta object literal for the '{@link example3.kiamacs.impl.NumCSImpl <em>Num CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamacs.impl.NumCSImpl
		 * @see example3.kiamacs.impl.KiamacsPackageImpl#getNumCS()
		 * @generated
		 */
		EClass NUM_CS = eINSTANCE.getNumCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUM_CS__VALUE = eINSTANCE.getNumCS_Value();

		/**
		 * The meta object literal for the '{@link example3.kiamacs.impl.BaseCSImpl <em>Base CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamacs.impl.BaseCSImpl
		 * @see example3.kiamacs.impl.KiamacsPackageImpl#getBaseCS()
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
