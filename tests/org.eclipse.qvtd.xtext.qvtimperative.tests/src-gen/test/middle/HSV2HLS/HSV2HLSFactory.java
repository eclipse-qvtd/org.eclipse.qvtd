/**
 */
package test.middle.HSV2HLS;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test.middle.HSV2HLS.HSV2HLSPackage
 * @generated
 */
public interface HSV2HLSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSV2HLSFactory eINSTANCE = test.middle.HSV2HLS.impl.HSV2HLSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>HSV Node2 HLS Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HSV Node2 HLS Node</em>'.
	 * @generated
	 */
	HSVNode2HLSNode createHSVNode2HLSNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HSV2HLSPackage getHSV2HLSPackage();

} //HSV2HLSFactory
