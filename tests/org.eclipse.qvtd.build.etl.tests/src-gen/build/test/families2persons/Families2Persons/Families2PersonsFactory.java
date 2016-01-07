/**
 */
package build.test.families2persons.Families2Persons;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see build.test.families2persons.Families2Persons.Families2PersonsPackage
 * @generated
 */
public interface Families2PersonsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Families2PersonsFactory eINSTANCE = build.test.families2persons.Families2Persons.impl.Families2PersonsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Member2 Male</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member2 Male</em>'.
	 * @generated
	 */
	Member2Male createMember2Male();

	/**
	 * Returns a new object of class '<em>Member2 Female</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member2 Female</em>'.
	 * @generated
	 */
	Member2Female createMember2Female();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Families2PersonsPackage getFamilies2PersonsPackage();

} //Families2PersonsFactory
