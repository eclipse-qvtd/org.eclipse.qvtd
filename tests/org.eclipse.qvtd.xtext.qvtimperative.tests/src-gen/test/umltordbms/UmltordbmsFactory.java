/**
 */
package test.umltordbms;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test.umltordbms.UmltordbmsPackage
 * @generated
 */
public interface UmltordbmsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmltordbmsFactory eINSTANCE = test.umltordbms.impl.UmltordbmsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Attribute To Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute To Column</em>'.
	 * @generated
	 */
	AttributeToColumn createAttributeToColumn();

	/**
	 * Returns a new object of class '<em>Association To Foreign Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association To Foreign Key</em>'.
	 * @generated
	 */
	AssociationToForeignKey createAssociationToForeignKey();

	/**
	 * Returns a new object of class '<em>Class To Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class To Table</em>'.
	 * @generated
	 */
	ClassToTable createClassToTable();

	/**
	 * Returns a new object of class '<em>Non Leaf Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Leaf Attribute</em>'.
	 * @generated
	 */
	NonLeafAttribute createNonLeafAttribute();

	/**
	 * Returns a new object of class '<em>Package To Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package To Schema</em>'.
	 * @generated
	 */
	PackageToSchema createPackageToSchema();

	/**
	 * Returns a new object of class '<em>Primitive To Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive To Name</em>'.
	 * @generated
	 */
	PrimitiveToName createPrimitiveToName();

	/**
	 * Returns a new object of class '<em>To Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Column</em>'.
	 * @generated
	 */
	ToColumn createToColumn();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmltordbmsPackage getUmltordbmsPackage();

} //UmltordbmsFactory
