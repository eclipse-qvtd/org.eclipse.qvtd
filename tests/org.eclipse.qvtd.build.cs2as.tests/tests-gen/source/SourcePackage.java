/**
 */
package source;

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
 * @see source.SourceFactory
 * @model kind="package"
 * @generated
 */
public interface SourcePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "source";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example1/sourceMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "source";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourcePackage eINSTANCE = source.impl.SourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link source.impl.SElementImpl <em>SElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.SElementImpl
	 * @see source.impl.SourcePackageImpl#getSElement()
	 * @generated
	 */
	int SELEMENT = 6;

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
	 * The meta object id for the '{@link source.impl.XImpl <em>X</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.XImpl
	 * @see source.impl.SourcePackageImpl#getX()
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
	 * The feature id for the '<em><b>Is A1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X__IS_A1 = SELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link source.impl.YImpl <em>Y</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.YImpl
	 * @see source.impl.SourcePackageImpl#getY()
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
	 * The meta object id for the '{@link source.impl.Y1Impl <em>Y1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.Y1Impl
	 * @see source.impl.SourcePackageImpl#getY1()
	 * @generated
	 */
	int Y1 = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1__AST = Y__AST;

	/**
	 * The feature id for the '<em><b>Owns Z</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1__OWNS_Z = Y__OWNS_Z;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1__NAME = Y__NAME;

	/**
	 * The feature id for the '<em><b>To X</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1__TO_X = Y__TO_X;

	/**
	 * The number of structural features of the '<em>Y1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1_FEATURE_COUNT = Y_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Y1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y1_OPERATION_COUNT = Y_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link source.impl.Y2Impl <em>Y2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.Y2Impl
	 * @see source.impl.SourcePackageImpl#getY2()
	 * @generated
	 */
	int Y2 = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__AST = Y__AST;

	/**
	 * The feature id for the '<em><b>Owns Z</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__OWNS_Z = Y__OWNS_Z;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__NAME = Y__NAME;

	/**
	 * The feature id for the '<em><b>To X</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__TO_X = Y__TO_X;

	/**
	 * The number of structural features of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2_FEATURE_COUNT = Y_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2_OPERATION_COUNT = Y_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link source.impl.ZImpl <em>Z</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.ZImpl
	 * @see source.impl.SourcePackageImpl#getZ()
	 * @generated
	 */
	int Z = 4;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z__NAME = SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Z</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z_FEATURE_COUNT = SELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Z</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Z_OPERATION_COUNT = SELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link source.impl.SRootImpl <em>SRoot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see source.impl.SRootImpl
	 * @see source.impl.SourcePackageImpl#getSRoot()
	 * @generated
	 */
	int SROOT = 5;

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
	 * Returns the meta object for class '{@link source.X <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>X</em>'.
	 * @see source.X
	 * @generated
	 */
	EClass getX();

	/**
	 * Returns the meta object for the containment reference list '{@link source.X#getOwnsY <em>Owns Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns Y</em>'.
	 * @see source.X#getOwnsY()
	 * @see #getX()
	 * @generated
	 */
	EReference getX_OwnsY();

	/**
	 * Returns the meta object for the attribute '{@link source.X#isIsA1 <em>Is A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is A1</em>'.
	 * @see source.X#isIsA1()
	 * @see #getX()
	 * @generated
	 */
	EAttribute getX_IsA1();

	/**
	 * Returns the meta object for class '{@link source.Y <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y</em>'.
	 * @see source.Y
	 * @generated
	 */
	EClass getY();

	/**
	 * Returns the meta object for the containment reference '{@link source.Y#getOwnsZ <em>Owns Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owns Z</em>'.
	 * @see source.Y#getOwnsZ()
	 * @see #getY()
	 * @generated
	 */
	EReference getY_OwnsZ();

	/**
	 * Returns the meta object for the attribute '{@link source.Y#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see source.Y#getName()
	 * @see #getY()
	 * @generated
	 */
	EAttribute getY_Name();

	/**
	 * Returns the meta object for the container reference '{@link source.Y#getToX <em>To X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To X</em>'.
	 * @see source.Y#getToX()
	 * @see #getY()
	 * @generated
	 */
	EReference getY_ToX();

	/**
	 * Returns the meta object for class '{@link source.Y1 <em>Y1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y1</em>'.
	 * @see source.Y1
	 * @generated
	 */
	EClass getY1();

	/**
	 * Returns the meta object for class '{@link source.Y2 <em>Y2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y2</em>'.
	 * @see source.Y2
	 * @generated
	 */
	EClass getY2();

	/**
	 * Returns the meta object for class '{@link source.Z <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Z</em>'.
	 * @see source.Z
	 * @generated
	 */
	EClass getZ();

	/**
	 * Returns the meta object for the container reference '{@link source.Z#getToY <em>To Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To Y</em>'.
	 * @see source.Z#getToY()
	 * @see #getZ()
	 * @generated
	 */
	EReference getZ_ToY();

	/**
	 * Returns the meta object for the attribute '{@link source.Z#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see source.Z#getName()
	 * @see #getZ()
	 * @generated
	 */
	EAttribute getZ_Name();

	/**
	 * Returns the meta object for class '{@link source.SRoot <em>SRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRoot</em>'.
	 * @see source.SRoot
	 * @generated
	 */
	EClass getSRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link source.SRoot#getOwnedX <em>Owned X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned X</em>'.
	 * @see source.SRoot#getOwnedX()
	 * @see #getSRoot()
	 * @generated
	 */
	EReference getSRoot_OwnedX();

	/**
	 * Returns the meta object for class '{@link source.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SElement</em>'.
	 * @see source.SElement
	 * @generated
	 */
	EClass getSElement();

	/**
	 * Returns the meta object for the reference '{@link source.SElement#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see source.SElement#getAst()
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
	SourceFactory getSourceFactory();

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
		 * The meta object literal for the '{@link source.impl.XImpl <em>X</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.XImpl
		 * @see source.impl.SourcePackageImpl#getX()
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
		 * The meta object literal for the '<em><b>Is A1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute X__IS_A1 = eINSTANCE.getX_IsA1();

		/**
		 * The meta object literal for the '{@link source.impl.YImpl <em>Y</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.YImpl
		 * @see source.impl.SourcePackageImpl#getY()
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
		 * The meta object literal for the '{@link source.impl.Y1Impl <em>Y1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.Y1Impl
		 * @see source.impl.SourcePackageImpl#getY1()
		 * @generated
		 */
		EClass Y1 = eINSTANCE.getY1();

		/**
		 * The meta object literal for the '{@link source.impl.Y2Impl <em>Y2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.Y2Impl
		 * @see source.impl.SourcePackageImpl#getY2()
		 * @generated
		 */
		EClass Y2 = eINSTANCE.getY2();

		/**
		 * The meta object literal for the '{@link source.impl.ZImpl <em>Z</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.ZImpl
		 * @see source.impl.SourcePackageImpl#getZ()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Z__NAME = eINSTANCE.getZ_Name();

		/**
		 * The meta object literal for the '{@link source.impl.SRootImpl <em>SRoot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.SRootImpl
		 * @see source.impl.SourcePackageImpl#getSRoot()
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
		 * The meta object literal for the '{@link source.impl.SElementImpl <em>SElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see source.impl.SElementImpl
		 * @see source.impl.SourcePackageImpl#getSElement()
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

} //SourcePackage
