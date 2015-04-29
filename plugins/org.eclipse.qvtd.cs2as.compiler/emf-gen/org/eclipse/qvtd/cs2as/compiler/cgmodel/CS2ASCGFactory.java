/**
 */
package org.eclipse.qvtd.cs2as.compiler.cgmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage
 * @generated
 */
public interface CS2ASCGFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CS2ASCGFactory eINSTANCE = org.eclipse.qvtd.cs2as.compiler.cgmodel.impl.CS2ASCGFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CG Lookup Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CG Lookup Call Exp</em>'.
	 * @generated
	 */
	CGLookupCallExp createCGLookupCallExp();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CS2ASCGPackage getCS2ASCGPackage();

} //CS2ASCGFactory
