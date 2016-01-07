/**
 */
package build.test.families2persons.Families2Persons;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see build.test.families2persons.Families2Persons.Families2PersonsFactory
 * @model kind="package"
 * @generated
 */
public interface Families2PersonsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Families2Persons";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTcore/examples/Families2Persons";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "families2Persons";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Families2PersonsPackage eINSTANCE = build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl.init();

	/**
	 * The meta object id for the '{@link build.test.families2persons.Families2Persons.impl.MemberToPersonImpl <em>Member To Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see build.test.families2persons.Families2Persons.impl.MemberToPersonImpl
	 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMemberToPerson()
	 * @generated
	 */
	int MEMBER_TO_PERSON = 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON__MEMBER = 0;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON__PERSON = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON__FIRST_NAME = 2;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON__FAMILY_NAME = 3;

	/**
	 * The number of structural features of the '<em>Member To Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Member To Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_TO_PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link build.test.families2persons.Families2Persons.impl.Member2MaleImpl <em>Member2 Male</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see build.test.families2persons.Families2Persons.impl.Member2MaleImpl
	 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMember2Male()
	 * @generated
	 */
	int MEMBER2_MALE = 1;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE__MEMBER = MEMBER_TO_PERSON__MEMBER;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE__PERSON = MEMBER_TO_PERSON__PERSON;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE__FIRST_NAME = MEMBER_TO_PERSON__FIRST_NAME;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE__FAMILY_NAME = MEMBER_TO_PERSON__FAMILY_NAME;

	/**
	 * The number of structural features of the '<em>Member2 Male</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE_FEATURE_COUNT = MEMBER_TO_PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Member2 Male</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_MALE_OPERATION_COUNT = MEMBER_TO_PERSON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link build.test.families2persons.Families2Persons.impl.Member2FemaleImpl <em>Member2 Female</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see build.test.families2persons.Families2Persons.impl.Member2FemaleImpl
	 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMember2Female()
	 * @generated
	 */
	int MEMBER2_FEMALE = 2;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE__MEMBER = MEMBER_TO_PERSON__MEMBER;

	/**
	 * The feature id for the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE__PERSON = MEMBER_TO_PERSON__PERSON;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE__FIRST_NAME = MEMBER_TO_PERSON__FIRST_NAME;

	/**
	 * The feature id for the '<em><b>Family Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE__FAMILY_NAME = MEMBER_TO_PERSON__FAMILY_NAME;

	/**
	 * The number of structural features of the '<em>Member2 Female</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE_FEATURE_COUNT = MEMBER_TO_PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Member2 Female</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER2_FEMALE_OPERATION_COUNT = MEMBER_TO_PERSON_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link build.test.families2persons.Families2Persons.MemberToPerson <em>Member To Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member To Person</em>'.
	 * @see build.test.families2persons.Families2Persons.MemberToPerson
	 * @generated
	 */
	EClass getMemberToPerson();

	/**
	 * Returns the meta object for the reference '{@link build.test.families2persons.Families2Persons.MemberToPerson#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see build.test.families2persons.Families2Persons.MemberToPerson#getMember()
	 * @see #getMemberToPerson()
	 * @generated
	 */
	EReference getMemberToPerson_Member();

	/**
	 * Returns the meta object for the reference '{@link build.test.families2persons.Families2Persons.MemberToPerson#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Person</em>'.
	 * @see build.test.families2persons.Families2Persons.MemberToPerson#getPerson()
	 * @see #getMemberToPerson()
	 * @generated
	 */
	EReference getMemberToPerson_Person();

	/**
	 * Returns the meta object for the attribute '{@link build.test.families2persons.Families2Persons.MemberToPerson#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see build.test.families2persons.Families2Persons.MemberToPerson#getFirstName()
	 * @see #getMemberToPerson()
	 * @generated
	 */
	EAttribute getMemberToPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link build.test.families2persons.Families2Persons.MemberToPerson#getFamilyName <em>Family Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family Name</em>'.
	 * @see build.test.families2persons.Families2Persons.MemberToPerson#getFamilyName()
	 * @see #getMemberToPerson()
	 * @generated
	 */
	EAttribute getMemberToPerson_FamilyName();

	/**
	 * Returns the meta object for class '{@link build.test.families2persons.Families2Persons.Member2Male <em>Member2 Male</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member2 Male</em>'.
	 * @see build.test.families2persons.Families2Persons.Member2Male
	 * @generated
	 */
	EClass getMember2Male();

	/**
	 * Returns the meta object for class '{@link build.test.families2persons.Families2Persons.Member2Female <em>Member2 Female</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member2 Female</em>'.
	 * @see build.test.families2persons.Families2Persons.Member2Female
	 * @generated
	 */
	EClass getMember2Female();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Families2PersonsFactory getFamilies2PersonsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link build.test.families2persons.Families2Persons.impl.MemberToPersonImpl <em>Member To Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see build.test.families2persons.Families2Persons.impl.MemberToPersonImpl
		 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMemberToPerson()
		 * @generated
		 */
		EClass MEMBER_TO_PERSON = eINSTANCE.getMemberToPerson();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_TO_PERSON__MEMBER = eINSTANCE.getMemberToPerson_Member();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_TO_PERSON__PERSON = eINSTANCE.getMemberToPerson_Person();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_TO_PERSON__FIRST_NAME = eINSTANCE.getMemberToPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Family Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMBER_TO_PERSON__FAMILY_NAME = eINSTANCE.getMemberToPerson_FamilyName();

		/**
		 * The meta object literal for the '{@link build.test.families2persons.Families2Persons.impl.Member2MaleImpl <em>Member2 Male</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see build.test.families2persons.Families2Persons.impl.Member2MaleImpl
		 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMember2Male()
		 * @generated
		 */
		EClass MEMBER2_MALE = eINSTANCE.getMember2Male();

		/**
		 * The meta object literal for the '{@link build.test.families2persons.Families2Persons.impl.Member2FemaleImpl <em>Member2 Female</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see build.test.families2persons.Families2Persons.impl.Member2FemaleImpl
		 * @see build.test.families2persons.Families2Persons.impl.Families2PersonsPackageImpl#getMember2Female()
		 * @generated
		 */
		EClass MEMBER2_FEMALE = eINSTANCE.getMember2Female();

	}

} //Families2PersonsPackage
