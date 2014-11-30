/**
 */
package classescstraces;

import classescs.PackageCS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package CS2 Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link classescstraces.PackageCS2Package#getPackageCS <em>Package CS</em>}</li>
 *   <li>{@link classescstraces.PackageCS2Package#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see classescstraces.ClassescstracesPackage#getPackageCS2Package()
 * @model
 * @generated
 */
public interface PackageCS2Package extends EObject {
	/**
	 * Returns the value of the '<em><b>Package CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package CS</em>' reference.
	 * @see #setPackageCS(PackageCS)
	 * @see classescstraces.ClassescstracesPackage#getPackageCS2Package_PackageCS()
	 * @model required="true"
	 * @generated
	 */
	PackageCS getPackageCS();

	/**
	 * Sets the value of the '{@link classescstraces.PackageCS2Package#getPackageCS <em>Package CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package CS</em>' reference.
	 * @see #getPackageCS()
	 * @generated
	 */
	void setPackageCS(PackageCS value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(classes.Package)
	 * @see classescstraces.ClassescstracesPackage#getPackageCS2Package_Package()
	 * @model required="true"
	 * @generated
	 */
	classes.Package getPackage();

	/**
	 * Sets the value of the '{@link classescstraces.PackageCS2Package#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(classes.Package value);

} // PackageCS2Package
