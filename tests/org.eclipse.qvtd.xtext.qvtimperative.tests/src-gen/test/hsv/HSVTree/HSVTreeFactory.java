/**
 */
package test.hsv.HSVTree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test.hsv.HSVTree.HSVTreePackage
 * @generated
 */
public interface HSVTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSVTreeFactory eINSTANCE = test.hsv.HSVTree.impl.HSVTreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>HSV Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HSV Node</em>'.
	 * @generated
	 */
	HSVNode createHSVNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HSVTreePackage getHSVTreePackage();

} //HSVTreeFactory
