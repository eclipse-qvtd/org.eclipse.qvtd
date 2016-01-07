/**
 */
package build.test.families2persons.Families;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link build.test.families2persons.Families.Member#getFirstName <em>First Name</em>}</li>
 *   <li>{@link build.test.families2persons.Families.Member#getFamilyFather <em>Family Father</em>}</li>
 *   <li>{@link build.test.families2persons.Families.Member#getFamilyMother <em>Family Mother</em>}</li>
 *   <li>{@link build.test.families2persons.Families.Member#getFamilySon <em>Family Son</em>}</li>
 *   <li>{@link build.test.families2persons.Families.Member#getFamilyDaughter <em>Family Daughter</em>}</li>
 * </ul>
 *
 * @see build.test.families2persons.Families.FamiliesPackage#getMember()
 * @model
 * @generated
 */
public interface Member extends EObject {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see build.test.families2persons.Families.FamiliesPackage#getMember_FirstName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link build.test.families2persons.Families.Member#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Family Father</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.families2persons.Families.Family#getFather <em>Father</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Father</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Father</em>' container reference.
	 * @see #setFamilyFather(Family)
	 * @see build.test.families2persons.Families.FamiliesPackage#getMember_FamilyFather()
	 * @see build.test.families2persons.Families.Family#getFather
	 * @model opposite="father" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyFather();

	/**
	 * Sets the value of the '{@link build.test.families2persons.Families.Member#getFamilyFather <em>Family Father</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Father</em>' container reference.
	 * @see #getFamilyFather()
	 * @generated
	 */
	void setFamilyFather(Family value);

	/**
	 * Returns the value of the '<em><b>Family Mother</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.families2persons.Families.Family#getMother <em>Mother</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Mother</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Mother</em>' container reference.
	 * @see #setFamilyMother(Family)
	 * @see build.test.families2persons.Families.FamiliesPackage#getMember_FamilyMother()
	 * @see build.test.families2persons.Families.Family#getMother
	 * @model opposite="mother" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyMother();

	/**
	 * Sets the value of the '{@link build.test.families2persons.Families.Member#getFamilyMother <em>Family Mother</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Mother</em>' container reference.
	 * @see #getFamilyMother()
	 * @generated
	 */
	void setFamilyMother(Family value);

	/**
	 * Returns the value of the '<em><b>Family Son</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.families2persons.Families.Family#getSons <em>Sons</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Son</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Son</em>' container reference.
	 * @see #setFamilySon(Family)
	 * @see build.test.families2persons.Families.FamiliesPackage#getMember_FamilySon()
	 * @see build.test.families2persons.Families.Family#getSons
	 * @model opposite="sons" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilySon();

	/**
	 * Sets the value of the '{@link build.test.families2persons.Families.Member#getFamilySon <em>Family Son</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Son</em>' container reference.
	 * @see #getFamilySon()
	 * @generated
	 */
	void setFamilySon(Family value);

	/**
	 * Returns the value of the '<em><b>Family Daughter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link build.test.families2persons.Families.Family#getDaughters <em>Daughters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Daughter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Daughter</em>' container reference.
	 * @see #setFamilyDaughter(Family)
	 * @see build.test.families2persons.Families.FamiliesPackage#getMember_FamilyDaughter()
	 * @see build.test.families2persons.Families.Family#getDaughters
	 * @model opposite="daughters" transient="false" ordered="false"
	 * @generated
	 */
	Family getFamilyDaughter();

	/**
	 * Sets the value of the '{@link build.test.families2persons.Families.Member#getFamilyDaughter <em>Family Daughter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Daughter</em>' container reference.
	 * @see #getFamilyDaughter()
	 * @generated
	 */
	void setFamilyDaughter(Family value);

} // Member
