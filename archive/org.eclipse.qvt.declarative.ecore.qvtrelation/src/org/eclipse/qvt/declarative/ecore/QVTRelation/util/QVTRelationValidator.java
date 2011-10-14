/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTRelationValidator.java,v 1.7 2009/03/05 22:04:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.DomainPatternOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.KeyOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.OppositePropertyCallExpOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.QueryOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationCallExpOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationDomainAssignmentOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationDomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationImplementationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.operations.RelationalTransformationOperations;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * @extends EValidatorWithOperations
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage
 * @generated
 */
public class QVTRelationValidator extends EObjectValidator implements EValidatorWithOperations  {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTRelationValidator INSTANCE = new QVTRelationValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.ecore.QVTRelation";

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
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsValidator expressionsValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTBaseValidator qvtBaseValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public QVTRelationValidator() {
		super();
		qvtBaseValidator = new QVTBaseValidator()
		{
			@Override
			public boolean validateFunction_IsSideEffectFree(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
				return QueryOperations.INSTANCE.checkIsSideEffectFree(function, diagnostics, context);
			}			
		};
		ecoreValidator = EcoreValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
	}

	public String getDiagnosticSource() {
		return DIAGNOSTIC_SOURCE;
	}
	
	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return QVTRelationPackage.eINSTANCE;
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
			case QVTRelationPackage.DOMAIN_PATTERN:
				return validateDomainPattern((DomainPattern)value, diagnostics, context);
			case QVTRelationPackage.KEY:
				return validateKey((Key)value, diagnostics, context);
			case QVTRelationPackage.OPPOSITE_PROPERTY_CALL_EXP:
				return validateOppositePropertyCallExp((OppositePropertyCallExp)value, diagnostics, context);
			case QVTRelationPackage.RELATION:
				return validateRelation((Relation)value, diagnostics, context);
			case QVTRelationPackage.RELATION_DOMAIN:
				return validateRelationDomain((RelationDomain)value, diagnostics, context);
			case QVTRelationPackage.RELATION_DOMAIN_ASSIGNMENT:
				return validateRelationDomainAssignment((RelationDomainAssignment)value, diagnostics, context);
			case QVTRelationPackage.RELATION_IMPLEMENTATION:
				return validateRelationImplementation((RelationImplementation)value, diagnostics, context);
			case QVTRelationPackage.RELATION_CALL_EXP:
				return validateRelationCallExp((RelationCallExp)value, diagnostics, context);
			case QVTRelationPackage.RELATIONAL_TRANSFORMATION:
				return validateRelationalTransformation((RelationalTransformation)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainPattern(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validatePattern_NoVariableIsAFunctionParameter(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainPattern_EveryVariableIsDefinedByRelation(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainPattern_RootTemplateExpressionIsBoundToRootVariable(domainPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainPattern_RootTemplateExpressionTypeIsRootVariableType(domainPattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EveryVariableIsDefinedByRelation constraint of '<em>Domain Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validateDomainPattern_EveryVariableIsDefinedByRelation(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainPatternOperations.INSTANCE.checkEveryVariableIsDefinedByRelation(domainPattern, diagnostics, context);
	}

	/**
	 * Validates the RootTemplateExpressionIsBoundToRootVariable constraint of '<em>Domain Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validateDomainPattern_RootTemplateExpressionIsBoundToRootVariable(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainPatternOperations.INSTANCE.checkRootTemplateExpressionIsBoundToRootVariable(domainPattern, diagnostics, context);
	}

	/**
	 * Validates the RootTemplateExpressionTypeIsRootVariableType constraint of '<em>Domain Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validateDomainPattern_RootTemplateExpressionTypeIsRootVariableType(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return DomainPatternOperations.INSTANCE.checkRootTemplateExpressionTypeIsRootVariableType(domainPattern, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKey(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_AtLeastOnePart(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_IdentifiesTypeIsDeclaredByTransformation(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_EveryPartIsDeclaredByIdentifies(key, diagnostics, context);
		if (result || diagnostics != null) result &= validateKey_EveryOppositePartReferencesIdentifies(key, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtLeastOnePart constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_AtLeastOnePart(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkAtLeastOnePart(key, diagnostics, context);
	}

	/**
	 * Validates the IdentifiesTypeIsDeclaredByTransformation constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_IdentifiesTypeIsDeclaredByTransformation(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkIdentifiesTypeIsDeclaredByTransformation(key, diagnostics, context);
	}

	/**
	 * Validates the EveryPartIsDeclaredByIdentifies constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_EveryPartIsDeclaredByIdentifies(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkEveryPartIsDeclaredByIdentifies(key, diagnostics, context);
	}

	/**
	 * Validates the EveryOppositePartReferencesIdentifies constraint of '<em>Key</em>'.
	 * @generated NOT
	 */
	public boolean validateKey_EveryOppositePartReferencesIdentifies(Key key, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return KeyOperations.INSTANCE.checkEveryOppositePartReferencesIdentifies(key, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOppositePropertyCallExp(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validatePropertyCallExp_checkPropertyType(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyCallExp_PropertyIsReference(oppositePropertyCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateOppositePropertyCallExp_PropertyIsUnidirectional(oppositePropertyCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PropertyIsReference constraint of '<em>Opposite Property Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateOppositePropertyCallExp_PropertyIsReference(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return OppositePropertyCallExpOperations.INSTANCE.checkPropertyIsReference(oppositePropertyCallExp, diagnostics, context);
	}

	/**
	 * Validates the PropertyIsUnidirectional constraint of '<em>Opposite Property Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateOppositePropertyCallExp_PropertyIsUnidirectional(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return OppositePropertyCallExpOperations.INSTANCE.checkPropertyIsUnidirectional(oppositePropertyCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_OverridesIsCompatible(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_OverridesDefinedByTransformation(relation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateRule_DomainNamesAreUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_DomainTypedModelsMatchModelParameters(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_AtLeastTwoDomains(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_EveryDomainIsARelationDomain(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_NonTopLevelIsNotInvokedWarning(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_RelationImplsAreUniqueWarning(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_VariablesAreUnique(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_WhenTypesAreDeclaredByRelation(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_WhenVariablesAreDefinedByRelation(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_WhereTypesAreDeclaredByRelation(relation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelation_WhereVariablesAreDefinedByRelation(relation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the EveryDomainIsARelationDomain constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_EveryDomainIsARelationDomain(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkEveryDomainIsARelationDomain(relation, diagnostics, context);
	}

	/**
	 * Validates the AtLeastTwoDomains constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_AtLeastTwoDomains(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkAtLeastTwoDomains(relation, diagnostics, context);
	}

	/**
	 * Validates the DomainTypedModelsMatchModelParameters constraint of '<em>Rule</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_DomainTypedModelsMatchModelParameters(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkDomainTypedModelsMatchModelParameters(relation, diagnostics, context);
	}

	/**
	 * Validates the NonTopLevelIsNotInvokedWarning constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_NonTopLevelIsNotInvokedWarning(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkNonTopLevelIsNotInvokedWarning(relation, diagnostics, context);
	}

	/**
	 * Validates the RelationImplsAreUniqueWarning constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_RelationImplsAreUniqueWarning(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkRelationImplsAreUniqueWarning(relation, diagnostics, context);
	}

	/**
	 * Validates the VariablesAreUnique constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_VariablesAreUnique(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkVariablesAreUnique(relation, diagnostics, context);
	}

	/**
	 * Validates the WhenTypesAreDeclaredByRelation constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_WhenTypesAreDeclaredByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkWhenTypesAreDeclaredByRelation(relation, diagnostics, context);
	}

	/**
	 * Validates the WhenVariablesAreDefinedByRelation constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_WhenVariablesAreDefinedByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkWhenVariablesAreDefinedByRelation(relation, diagnostics, context);
	}

	/**
	 * Validates the WhereTypesAreDeclaredByRelation constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_WhereTypesAreDeclaredByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkWhereTypesAreDeclaredByRelation(relation, diagnostics, context);
	}

	/**
	 * Validates the WhereVariablesAreDefinedByRelation constraint of '<em>Relation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelation_WhereVariablesAreDefinedByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationOperations.INSTANCE.checkWhereVariablesAreDefinedByRelation(relation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomain(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_WellFormedName(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_TypedModelExistsWarning(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateDomain_TypedModelDefinedByTransformation(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateDomain_CheckableOrEnforceable(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_PrimitiveDomainIsUnnamed(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_RootVariableIsDefinedByRelation(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_RootVariableTypeIsDeclaredByDomainTypedModel(relationDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomain_EveryEnforceableVariableIsMatchedOrAssigned(relationDomain, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_WellFormedName(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (relationDomain.getPattern() == null)
			return true;
		return ecoreValidator.validateENamedElement_WellFormedName(relationDomain, diagnostics, context);
	}

	/**
	 * Validates the TypedModelExistsWarning constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_TypedModelExistsWarning(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;		// Primitive Domains have null typed model
	}

	/**
	 * Validates the PrimitiveDomainIsUnnamed constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_PrimitiveDomainIsUnnamed(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainOperations.INSTANCE.checkPrimitiveDomainIsUnnamed(relationDomain, diagnostics, context);
	}

	/**
	 * Validates the RootVariableIsDefinedByRelation constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_RootVariableIsDefinedByRelation(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainOperations.INSTANCE.checkRootVariableIsDefinedByRelation(relationDomain, diagnostics, context);
	}
	
	/**
	 * Validates the RootVariableTypeIsDeclaredByDomainTypedModel constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_RootVariableTypeIsDeclaredByDomainTypedModel(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainOperations.INSTANCE.checkRootVariableTypeIsDeclaredByDomainTypedModel(relationDomain, diagnostics, context);
	}

	/**
	 * Validates the EveryEnforceableVariableIsMatchedOrAssigned constraint of '<em>Relation Domain</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomain_EveryEnforceableVariableIsMatchedOrAssigned(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainOperations.INSTANCE.checkEveryEnforceableVariableIsMatchedOrAssigned(relationDomain, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationDomainAssignment(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomainAssignment_VariableDefinedByRelation(relationDomainAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationDomainAssignment_VariableTypeMatchesValueType(relationDomainAssignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the VariableDefinedByRelation constraint of '<em>Relation Domain Assignment</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomainAssignment_VariableDefinedByRelation(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainAssignmentOperations.INSTANCE.checkVariableDefinedByRelation(relationDomainAssignment, diagnostics, context);
	}

	/**
	 * Validates the VariableTypeMatchesValueType constraint of '<em>Relation Domain Assignment</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationDomainAssignment_VariableTypeMatchesValueType(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationDomainAssignmentOperations.INSTANCE.checkVariableTypeMatchesValueType(relationDomainAssignment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationImplementation(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationImplementation_InDirectionOfIsDefinedByTransformation(relationImplementation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationImplementation_EveryParameterTypeMatchesDomainRootVariableType(relationImplementation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the InDirectionOfIsDefinedByTransformation constraint of '<em>Relation Implementation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationImplementation_InDirectionOfIsDefinedByTransformation(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationImplementationOperations.INSTANCE.checkInDirectionOfIsDefinedByTransformation(relationImplementation, diagnostics, context);
	}

	/**
	 * Validates the EveryParameterTypeMatchesDomainRootVariableType constraint of '<em>Relation Implementation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationImplementation_EveryParameterTypeMatchesDomainRootVariableType(RelationImplementation relationImplementation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationImplementationOperations.INSTANCE.checkEveryParameterTypeMatchesDomainRootVariableType(relationImplementation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationCallExp(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_PatternExists(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_RelationExists(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_InvokedFromWhenOrWhereClause(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_ReferredRelationDeclaredByTransformation(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_ReferredRelationArgumentNumberMatches(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_EveryWhenReferredRelationArgumentTypeMatches(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_EveryWhereReferredRelationArgumentTypeIsMatchableWarning(relationCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationCallExp_TypeIsBoolean(relationCallExp, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PatternExists constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_PatternExists(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkPatternExists(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the RelationExists constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_RelationExists(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkRelationExists(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the InvokedFromWhenOrWhereClause constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_InvokedFromWhenOrWhereClause(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkInvokedFromWhenOrWhereClause(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the ReferredRelationDeclaredByTransformation constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_ReferredRelationDeclaredByTransformation(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkReferredRelationDeclaredByTransformation(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the ReferredRelationArgumentNumberMatches constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_ReferredRelationArgumentNumberMatches(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkReferredRelationArgumentNumberMatches(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the EveryWhenReferredRelationArgumentTypeMatches constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_EveryWhenReferredRelationArgumentTypeMatches(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkEveryWhenReferredRelationArgumentTypeMatches(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the EveryWhereReferredRelationArgumentTypeIsMatchableWarning constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_EveryWhereReferredRelationArgumentTypeIsMatchableWarning(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkEveryWhereReferredRelationArgumentTypeIsMatchableWarning(relationCallExp, diagnostics, context);
	}

	/**
	 * Validates the TypeIsBoolean constraint of '<em>Relation Call Exp</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationCallExp_TypeIsBoolean(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationCallExpOperations.INSTANCE.checkTypeIsBoolean(relationCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationalTransformation(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsURI(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_WellFormedNsPrefix(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalTransformation_UniqueClassifierNames(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_UniqueNsURIs(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ExtendsIsAcyclic(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ModelParameterNamesAreCompatibleWithExtension(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_EveryModelParameterUsedPackagesIsCompatibleWithExtension(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_ModelParameterNamesAreUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_RuleNamesAreUnique(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvtBaseValidator.validateTransformation_SynthesizedTypesAreOwned(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalTransformation_EveryRuleIsARelation(relationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateRelationalTransformation_KeysAreUnique(relationalTransformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the KeysAreUnique constraint of '<em>Relational Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationalTransformation_KeysAreUnique(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationalTransformationOperations.INSTANCE.checkKeysAreUnique(relationalTransformation, diagnostics, context);
	}

	/**
	 * Validates the UniqueClassifierNames constraint of '<em>Relational Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationalTransformation_UniqueClassifierNames(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationalTransformationOperations.INSTANCE.checkUniqueClassifierNames(relationalTransformation, diagnostics, context);
	}

	/**
	 * Validates the EveryRuleIsARelation constraint of '<em>Relational Transformation</em>'.
	 * @generated NOT
	 */
	public boolean validateRelationalTransformation_EveryRuleIsARelation(RelationalTransformation relationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return RelationalTransformationOperations.INSTANCE.checkEveryRuleIsARelation(relationalTransformation, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTRelationPlugin.INSTANCE;
	}

} //QVTRelationValidator
