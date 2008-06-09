/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProblemsFactory.java,v 1.1 2008/06/09 08:52:26 qglineur Exp $
 */
package org.eclipse.qvt.declarative.atlvm.problems.problems;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage
 * @generated
 */
public interface ProblemsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProblemsFactory eINSTANCE = org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Problem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Problem</em>'.
	 * @generated
	 */
	Problem createProblem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProblemsPackage getProblemsPackage();

} //ProblemsFactory
