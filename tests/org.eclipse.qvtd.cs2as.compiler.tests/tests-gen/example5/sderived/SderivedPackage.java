/**
 */
package example5.sderived;

import example5.sbase.SbasePackage;

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
 * @see example5.sderived.SderivedFactory
 * @model kind="package"
 * @generated
 */
public interface SderivedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sderived";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example5/sourceDerivedMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sderived";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SderivedPackage eINSTANCE = example5.sderived.impl.SderivedPackageImpl.init();

	/**
	 * The meta object id for the '{@link example5.sderived.impl.X2Impl <em>X2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sderived.impl.X2Impl
	 * @see example5.sderived.impl.SderivedPackageImpl#getX2()
	 * @generated
	 */
	int X2 = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2__AST = SbasePackage.X__AST;

	/**
	 * The feature id for the '<em><b>Owns Y</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2__OWNS_Y = SbasePackage.X__OWNS_Y;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2__NAME = SbasePackage.X__NAME;

	/**
	 * The feature id for the '<em><b>Owns W</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2__OWNS_W = SbasePackage.X_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>X2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2_FEATURE_COUNT = SbasePackage.X_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>X2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int X2_OPERATION_COUNT = SbasePackage.X_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example5.sderived.impl.Y2Impl <em>Y2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sderived.impl.Y2Impl
	 * @see example5.sderived.impl.SderivedPackageImpl#getY2()
	 * @generated
	 */
	int Y2 = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__AST = SbasePackage.Y__AST;

	/**
	 * The feature id for the '<em><b>Owns Z</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__OWNS_Z = SbasePackage.Y__OWNS_Z;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__NAME = SbasePackage.Y__NAME;

	/**
	 * The feature id for the '<em><b>To X</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__TO_X = SbasePackage.Y__TO_X;

	/**
	 * The feature id for the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2__NAME2 = SbasePackage.Y_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2_FEATURE_COUNT = SbasePackage.Y_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Y2_OPERATION_COUNT = SbasePackage.Y_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example5.sderived.impl.WImpl <em>W</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example5.sderived.impl.WImpl
	 * @see example5.sderived.impl.SderivedPackageImpl#getW()
	 * @generated
	 */
	int W = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int W__AST = SbasePackage.SELEMENT__AST;

	/**
	 * The number of structural features of the '<em>W</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int W_FEATURE_COUNT = SbasePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>W</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int W_OPERATION_COUNT = SbasePackage.SELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link example5.sderived.X2 <em>X2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>X2</em>'.
	 * @see example5.sderived.X2
	 * @generated
	 */
	EClass getX2();

	/**
	 * Returns the meta object for the containment reference list '{@link example5.sderived.X2#getOwnsW <em>Owns W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns W</em>'.
	 * @see example5.sderived.X2#getOwnsW()
	 * @see #getX2()
	 * @generated
	 */
	EReference getX2_OwnsW();

	/**
	 * Returns the meta object for class '{@link example5.sderived.Y2 <em>Y2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y2</em>'.
	 * @see example5.sderived.Y2
	 * @generated
	 */
	EClass getY2();

	/**
	 * Returns the meta object for the attribute '{@link example5.sderived.Y2#getName2 <em>Name2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name2</em>'.
	 * @see example5.sderived.Y2#getName2()
	 * @see #getY2()
	 * @generated
	 */
	EAttribute getY2_Name2();

	/**
	 * Returns the meta object for class '{@link example5.sderived.W <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>W</em>'.
	 * @see example5.sderived.W
	 * @generated
	 */
	EClass getW();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SderivedFactory getSderivedFactory();

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
		 * The meta object literal for the '{@link example5.sderived.impl.X2Impl <em>X2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.X2Impl
		 * @see example5.sderived.impl.SderivedPackageImpl#getX2()
		 * @generated
		 */
		EClass X2 = eINSTANCE.getX2();

		/**
		 * The meta object literal for the '<em><b>Owns W</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference X2__OWNS_W = eINSTANCE.getX2_OwnsW();

		/**
		 * The meta object literal for the '{@link example5.sderived.impl.Y2Impl <em>Y2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.Y2Impl
		 * @see example5.sderived.impl.SderivedPackageImpl#getY2()
		 * @generated
		 */
		EClass Y2 = eINSTANCE.getY2();

		/**
		 * The meta object literal for the '<em><b>Name2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Y2__NAME2 = eINSTANCE.getY2_Name2();

		/**
		 * The meta object literal for the '{@link example5.sderived.impl.WImpl <em>W</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.WImpl
		 * @see example5.sderived.impl.SderivedPackageImpl#getW()
		 * @generated
		 */
		EClass W = eINSTANCE.getW();

	}

} //SderivedPackage
