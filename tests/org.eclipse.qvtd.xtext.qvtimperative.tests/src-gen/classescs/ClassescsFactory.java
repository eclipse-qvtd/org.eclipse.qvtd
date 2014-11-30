/**
 */
package classescs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see classescs.ClassescsPackage
 * @generated
 */
public interface ClassescsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassescsFactory eINSTANCE = classescs.impl.ClassescsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS</em>'.
	 * @generated
	 */
	PackageCS createPackageCS();

	/**
	 * Returns a new object of class '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS</em>'.
	 * @generated
	 */
	ClassCS createClassCS();

	/**
	 * Returns a new object of class '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Name CS</em>'.
	 * @generated
	 */
	PathNameCS createPathNameCS();

	/**
	 * Returns a new object of class '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Element CS</em>'.
	 * @generated
	 */
	PathElementCS createPathElementCS();

	/**
	 * Returns a new object of class '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root CS</em>'.
	 * @generated
	 */
	RootCS createRootCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassescsPackage getClassescsPackage();

} //ClassescsFactory
