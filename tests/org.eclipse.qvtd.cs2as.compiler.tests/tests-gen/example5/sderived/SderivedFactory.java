/**
 */
package example5.sderived;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see example5.sderived.SderivedPackage
 * @generated
 */
public interface SderivedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SderivedFactory eINSTANCE = example5.sderived.impl.SderivedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>X2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>X2</em>'.
	 * @generated
	 */
	X2 createX2();

	/**
	 * Returns a new object of class '<em>Y2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Y2</em>'.
	 * @generated
	 */
	Y2 createY2();

	/**
	 * Returns a new object of class '<em>W</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>W</em>'.
	 * @generated
	 */
	W createW();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SderivedPackage getSderivedPackage();

} //SderivedFactory
