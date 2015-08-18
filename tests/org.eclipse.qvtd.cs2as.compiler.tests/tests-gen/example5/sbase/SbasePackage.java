/**
 */
package example5.sbase;

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
 * @see example5.sbase.SbaseFactory
 * @model kind="package"
 * @generated
 */
public interface SbasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sbase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example5/sourceBaseMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sbase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SbasePackage eINSTANCE = example5.sbase.impl.SbasePackageImpl.init();

	/**
	 * The meta object id for the '{@link example5.sbase.impl.SElementImpl <em>SElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sbase.impl.SElementImpl
	 * @see example5.sbase.impl.SbasePackageImpl#getSElement()
	 * @generated
	 */
	int SELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__AST = 0;

	/**
	 * The number of structural features of the '<em>SElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>SElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link example5.sbase.impl.XImpl <em>X</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sbase.impl.XImpl
	 * @see example5.sbase.impl.SbasePackageImpl#getX()
	 * @generated
	 */
	int X = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X__AST = SELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Owns Y</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X__OWNS_Y = SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X__NAME = SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>X</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X_FEATURE_COUNT = SELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>X</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X_OPERATION_COUNT = SELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example5.sbase.impl.YImpl <em>Y</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sbase.impl.YImpl
	 * @see example5.sbase.impl.SbasePackageImpl#getY()
	 * @generated
	 */
	int Y = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y__AST = SELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Owns Z</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y__OWNS_Z = SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y__NAME = SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To X</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y__TO_X = SELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Y</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y_FEATURE_COUNT = SELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Y</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y_OPERATION_COUNT = SELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example5.sbase.impl.ZImpl <em>Z</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sbase.impl.ZImpl
	 * @see example5.sbase.impl.SbasePackageImpl#getZ()
	 * @generated
	 */
	int Z = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z__AST = SELEMENT__AST;

	/**
	 * The feature id for the '<em><b>To Y</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z__TO_Y = SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Z</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z_FEATURE_COUNT = SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Z</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z_OPERATION_COUNT = SELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example5.sbase.impl.SRootImpl <em>SRoot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sbase.impl.SRootImpl
	 * @see example5.sbase.impl.SbasePackageImpl#getSRoot()
	 * @generated
	 */
	int SROOT = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SROOT__AST = SELEMENT__AST;

	/**
	 * The feature id for the '<em><b>Owned X</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SROOT__OWNED_X = SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SRoot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SROOT_FEATURE_COUNT = SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>SRoot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SROOT_OPERATION_COUNT = SELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link example5.sbase.X <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>X</em>'.
	 * @see example5.sbase.X
	 * @generated
	 */
	EClass getX();

	/**
	 * Returns the meta object for the containment reference list '{@link example5.sbase.X#getOwnsY <em>Owns Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns Y</em>'.
	 * @see example5.sbase.X#getOwnsY()
	 * @see #getX()
	 * @generated
	 */
	EReference getX_OwnsY();

	/**
	 * Returns the meta object for the attribute '{@link example5.sbase.X#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see example5.sbase.X#getName()
	 * @see #getX()
	 * @generated
	 */
	EAttribute getX_Name();

	/**
	 * Returns the meta object for class '{@link example5.sbase.Y <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y</em>'.
	 * @see example5.sbase.Y
	 * @generated
	 */
	EClass getY();

	/**
	 * Returns the meta object for the containment reference '{@link example5.sbase.Y#getOwnsZ <em>Owns Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owns Z</em>'.
	 * @see example5.sbase.Y#getOwnsZ()
	 * @see #getY()
	 * @generated
	 */
	EReference getY_OwnsZ();

	/**
	 * Returns the meta object for the attribute '{@link example5.sbase.Y#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see example5.sbase.Y#getName()
	 * @see #getY()
	 * @generated
	 */
	EAttribute getY_Name();

	/**
	 * Returns the meta object for the container reference '{@link example5.sbase.Y#getToX <em>To X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To X</em>'.
	 * @see example5.sbase.Y#getToX()
	 * @see #getY()
	 * @generated
	 */
	EReference getY_ToX();

	/**
	 * Returns the meta object for class '{@link example5.sbase.Z <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Z</em>'.
	 * @see example5.sbase.Z
	 * @generated
	 */
	EClass getZ();

	/**
	 * Returns the meta object for the container reference '{@link example5.sbase.Z#getToY <em>To Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To Y</em>'.
	 * @see example5.sbase.Z#getToY()
	 * @see #getZ()
	 * @generated
	 */
	EReference getZ_ToY();

	/**
	 * Returns the meta object for class '{@link example5.sbase.SRoot <em>SRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRoot</em>'.
	 * @see example5.sbase.SRoot
	 * @generated
	 */
	EClass getSRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link example5.sbase.SRoot#getOwnedX <em>Owned X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned X</em>'.
	 * @see example5.sbase.SRoot#getOwnedX()
	 * @see #getSRoot()
	 * @generated
	 */
	EReference getSRoot_OwnedX();

	/**
	 * Returns the meta object for class '{@link example5.sbase.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SElement</em>'.
	 * @see example5.sbase.SElement
	 * @generated
	 */
	EClass getSElement();

	/**
	 * Returns the meta object for the reference '{@link example5.sbase.SElement#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see example5.sbase.SElement#getAst()
	 * @see #getSElement()
	 * @generated
	 */
	EReference getSElement_Ast();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SbaseFactory getSbaseFactory();

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
		 * The meta object literal for the '{@link example5.sbase.impl.XImpl <em>X</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sbase.impl.XImpl
		 * @see example5.sbase.impl.SbasePackageImpl#getX()
		 * @generated
		 */
		EClass X = eINSTANCE.getX();

		/**
		 * The meta object literal for the '<em><b>Owns Y</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference X__OWNS_Y = eINSTANCE.getX_OwnsY();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute X__NAME = eINSTANCE.getX_Name();

		/**
		 * The meta object literal for the '{@link example5.sbase.impl.YImpl <em>Y</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sbase.impl.YImpl
		 * @see example5.sbase.impl.SbasePackageImpl#getY()
		 * @generated
		 */
		EClass Y = eINSTANCE.getY();

		/**
		 * The meta object literal for the '<em><b>Owns Z</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Y__OWNS_Z = eINSTANCE.getY_OwnsZ();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Y__NAME = eINSTANCE.getY_Name();

		/**
		 * The meta object literal for the '<em><b>To X</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Y__TO_X = eINSTANCE.getY_ToX();

		/**
		 * The meta object literal for the '{@link example5.sbase.impl.ZImpl <em>Z</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sbase.impl.ZImpl
		 * @see example5.sbase.impl.SbasePackageImpl#getZ()
		 * @generated
		 */
		EClass Z = eINSTANCE.getZ();

		/**
		 * The meta object literal for the '<em><b>To Y</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Z__TO_Y = eINSTANCE.getZ_ToY();

		/**
		 * The meta object literal for the '{@link example5.sbase.impl.SRootImpl <em>SRoot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sbase.impl.SRootImpl
		 * @see example5.sbase.impl.SbasePackageImpl#getSRoot()
		 * @generated
		 */
		EClass SROOT = eINSTANCE.getSRoot();

		/**
		 * The meta object literal for the '<em><b>Owned X</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SROOT__OWNED_X = eINSTANCE.getSRoot_OwnedX();

		/**
		 * The meta object literal for the '{@link example5.sbase.impl.SElementImpl <em>SElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sbase.impl.SElementImpl
		 * @see example5.sbase.impl.SbasePackageImpl#getSElement()
		 * @generated
		 */
		EClass SELEMENT = eINSTANCE.getSElement();

		/**
		 * The meta object literal for the '<em><b>Ast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT__AST = eINSTANCE.getSElement_Ast();

	}

} //SbasePackage
