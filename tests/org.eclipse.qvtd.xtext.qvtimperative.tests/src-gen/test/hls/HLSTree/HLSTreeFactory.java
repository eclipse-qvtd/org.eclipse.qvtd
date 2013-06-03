/**
 */
package test.hls.HLSTree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test.hls.HLSTree.HLSTreePackage
 * @generated
 */
public interface HLSTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HLSTreeFactory eINSTANCE = test.hls.HLSTree.impl.HLSTreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>HLS Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HLS Node</em>'.
	 * @generated
	 */
	HLSNode createHLSNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HLSTreePackage getHLSTreePackage();

} //HLSTreeFactory
