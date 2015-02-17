/**
 */
package classescs;

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
 * @see classescs.ClassescsFactory
 * @model kind="package"
 * @generated
 */
public interface ClassescsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classescs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ocldependencyanalysis/classescs/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classescs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassescsPackage eINSTANCE = classescs.impl.ClassescsPackageImpl.init();

	/**
	 * The meta object id for the '{@link classescs.impl.ElementCSImpl <em>Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.ElementCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getElementCS()
	 * @generated
	 */
	int ELEMENT_CS = 0;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS__AST = 0;

	/**
	 * The number of structural features of the '<em>Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link classescs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.NamedElementCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getNamedElementCS()
	 * @generated
	 */
	int NAMED_ELEMENT_CS = 1;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__AST = ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS__NAME = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_CS_OPERATION_COUNT = ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link classescs.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.PackageCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 2;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__AST = NAMED_ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__OWNED_CLASSES = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_OPERATION_COUNT = NAMED_ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link classescs.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.ClassCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 3;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__AST = NAMED_ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__EXTENDS = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_OPERATION_COUNT = NAMED_ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link classescs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.PathNameCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getPathNameCS()
	 * @generated
	 */
	int PATH_NAME_CS = 4;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__AST = ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__PATH = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_OPERATION_COUNT = ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link classescs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.PathElementCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getPathElementCS()
	 * @generated
	 */
	int PATH_ELEMENT_CS = 5;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__AST = NAMED_ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__NAME = NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS_FEATURE_COUNT = NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS_OPERATION_COUNT = NAMED_ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link classescs.impl.RootCSImpl <em>Root CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see classescs.impl.RootCSImpl
	 * @see classescs.impl.ClassescsPackageImpl#getRootCS()
	 * @generated
	 */
	int ROOT_CS = 6;

	/**
	 * The feature id for the '<em><b>Ast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__AST = ELEMENT_CS__AST;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__OWNED_PACKAGES = ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_FEATURE_COUNT = ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_OPERATION_COUNT = ELEMENT_CS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link classescs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element CS</em>'.
	 * @see classescs.ElementCS
	 * @generated
	 */
	EClass getElementCS();

	/**
	 * Returns the meta object for the reference '{@link classescs.ElementCS#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see classescs.ElementCS#getAst()
	 * @see #getElementCS()
	 * @generated
	 */
	EReference getElementCS_Ast();

	/**
	 * Returns the meta object for class '{@link classescs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element CS</em>'.
	 * @see classescs.NamedElementCS
	 * @generated
	 */
	EClass getNamedElementCS();

	/**
	 * Returns the meta object for the attribute '{@link classescs.NamedElementCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see classescs.NamedElementCS#getName()
	 * @see #getNamedElementCS()
	 * @generated
	 */
	EAttribute getNamedElementCS_Name();

	/**
	 * Returns the meta object for class '{@link classescs.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see classescs.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the containment reference list '{@link classescs.PackageCS#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Classes</em>'.
	 * @see classescs.PackageCS#getOwnedClasses()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_OwnedClasses();

	/**
	 * Returns the meta object for class '{@link classescs.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see classescs.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the containment reference '{@link classescs.ClassCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see classescs.ClassCS#getExtends()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Extends();

	/**
	 * Returns the meta object for class '{@link classescs.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name CS</em>'.
	 * @see classescs.PathNameCS
	 * @generated
	 */
	EClass getPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link classescs.PathNameCS#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see classescs.PathNameCS#getPath()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Path();

	/**
	 * Returns the meta object for class '{@link classescs.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element CS</em>'.
	 * @see classescs.PathElementCS
	 * @generated
	 */
	EClass getPathElementCS();

	/**
	 * Returns the meta object for class '{@link classescs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS</em>'.
	 * @see classescs.RootCS
	 * @generated
	 */
	EClass getRootCS();

	/**
	 * Returns the meta object for the containment reference list '{@link classescs.RootCS#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see classescs.RootCS#getOwnedPackages()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_OwnedPackages();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassescsFactory getClassescsFactory();

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
		 * The meta object literal for the '{@link classescs.impl.ElementCSImpl <em>Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.ElementCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getElementCS()
		 * @generated
		 */
		EClass ELEMENT_CS = eINSTANCE.getElementCS();

		/**
		 * The meta object literal for the '<em><b>Ast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_CS__AST = eINSTANCE.getElementCS_Ast();

		/**
		 * The meta object literal for the '{@link classescs.impl.NamedElementCSImpl <em>Named Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.NamedElementCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getNamedElementCS()
		 * @generated
		 */
		EClass NAMED_ELEMENT_CS = eINSTANCE.getNamedElementCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT_CS__NAME = eINSTANCE.getNamedElementCS_Name();

		/**
		 * The meta object literal for the '{@link classescs.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.PackageCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getPackageCS()
		 * @generated
		 */
		EClass PACKAGE_CS = eINSTANCE.getPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__OWNED_CLASSES = eINSTANCE.getPackageCS_OwnedClasses();

		/**
		 * The meta object literal for the '{@link classescs.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.ClassCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__EXTENDS = eINSTANCE.getClassCS_Extends();

		/**
		 * The meta object literal for the '{@link classescs.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.PathNameCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getPathNameCS()
		 * @generated
		 */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__PATH = eINSTANCE.getPathNameCS_Path();

		/**
		 * The meta object literal for the '{@link classescs.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.PathElementCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getPathElementCS()
		 * @generated
		 */
		EClass PATH_ELEMENT_CS = eINSTANCE.getPathElementCS();

		/**
		 * The meta object literal for the '{@link classescs.impl.RootCSImpl <em>Root CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see classescs.impl.RootCSImpl
		 * @see classescs.impl.ClassescsPackageImpl#getRootCS()
		 * @generated
		 */
		EClass ROOT_CS = eINSTANCE.getRootCS();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__OWNED_PACKAGES = eINSTANCE.getRootCS_OwnedPackages();

	}

} //ClassescsPackage
