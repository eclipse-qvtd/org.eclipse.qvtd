/**
 */
package classescstraces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see classescstraces.ClassescstracesPackage
 * @generated
 */
public interface ClassescstracesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassescstracesFactory eINSTANCE = classescstraces.impl.ClassescstracesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package CS2 Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS2 Package</em>'.
	 * @generated
	 */
	PackageCS2Package createPackageCS2Package();

	/**
	 * Returns a new object of class '<em>Class CS2 Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS2 Class</em>'.
	 * @generated
	 */
	ClassCS2Class createClassCS2Class();

	/**
	 * Returns a new object of class '<em>Root CS2 Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root CS2 Root</em>'.
	 * @generated
	 */
	RootCS2Root createRootCS2Root();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassescstracesPackage getClassescstracesPackage();

} //ClassescstracesFactory
