/**
 * <copyright>
 * </copyright>
 *
 * $Id: TestQVTBaseValidator.java,v 1.1 2009/12/27 09:05:11 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestRule;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage
 * @generated
 */
public class TestQVTBaseValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TestQVTBaseValidator INSTANCE = new TestQVTBaseValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.test.TestQVTBase";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreValidator ecoreValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTBaseValidator qvtBaseValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestQVTBaseValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		qvtBaseValidator = QVTBaseValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TestQVTBasePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case TestQVTBasePackage.TEST_DOMAIN:
				return validateTestDomain((TestDomain)value, diagnostics, context);
			case TestQVTBasePackage.TEST_EXPRESSION:
				return validateTestExpression((TestExpression)value, diagnostics, context);
			case TestQVTBasePackage.TEST_PATTERN:
				return validateTestPattern((TestPattern)value, diagnostics, context);
			case TestQVTBasePackage.TEST_RULE:
				return validateTestRule((TestRule)value, diagnostics, context);
			case TestQVTBasePackage.TEST_TRANSFORMATION:
				return validateTestTransformation((TestTransformation)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestDomain(TestDomain testDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateDomain_TypedModelExistsWarning(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateDomain_TypedModelDefinedByTransformation(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateDomain_CheckableOrEnforceable(testDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestDomain_DummyConstraint(testDomain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DummyConstraint constraint of '<em>Test Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This exists to ensure that genmodel generates a Validator.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateTestDomain_DummyConstraint(TestDomain testDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestExpression(TestExpression testExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(testExpression, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(testExpression, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestPattern(TestPattern testPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testPattern, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validatePattern_NoVariableIsAFunctionParameter(testPattern, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestRule(TestRule testRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_OverridesIsCompatible(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_OverridesDefinedByTransformation(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_DomainNamesAreUnique(testRule, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_DomainTypedModelsMatchModelParameters(testRule, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestTransformation(TestTransformation testTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsURI(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsPrefix(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_UniqueNsURIs(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ExtendsIsAcyclic(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ModelParameterNamesAreCompatibleWithExtension(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ModelParameterNamesAreUnique(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_RuleNamesAreUnique(testTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_SynthesizedTypesAreOwned(testTransformation, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //TestQVTBaseValidator
