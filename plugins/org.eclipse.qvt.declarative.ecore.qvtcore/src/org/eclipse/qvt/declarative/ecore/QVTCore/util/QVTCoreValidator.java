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
 * $Id: QVTCoreValidator.java,v 1.2 2008/10/30 06:10:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.Assignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;
import org.eclipse.qvt.declarative.ecore.QVTCore.VariableAssignment;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * @extends EValidatorWithOperations
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage
 * @generated
 */
public class QVTCoreValidator extends EObjectValidator implements EValidatorWithOperations {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTCoreValidator INSTANCE = new QVTCoreValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvt.declarative.ecore.QVTCore";

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
	protected ExpressionsValidator expressionsValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * The cached OCL environment.
	 * @generated NOT
	 */
	protected Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> oclEnvironment;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTCoreValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
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
	  return QVTCorePackage.eINSTANCE;
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
			case QVTCorePackage.AREA:
				return validateArea((Area)value, diagnostics, context);
			case QVTCorePackage.ASSIGNMENT:
				return validateAssignment((Assignment)value, diagnostics, context);
			case QVTCorePackage.BOTTOM_PATTERN:
				return validateBottomPattern((BottomPattern)value, diagnostics, context);
			case QVTCorePackage.CORE_DOMAIN:
				return validateCoreDomain((CoreDomain)value, diagnostics, context);
			case QVTCorePackage.CORE_PATTERN:
				return validateCorePattern((CorePattern)value, diagnostics, context);
			case QVTCorePackage.ENFORCEMENT_OPERATION:
				return validateEnforcementOperation((EnforcementOperation)value, diagnostics, context);
			case QVTCorePackage.GUARD_PATTERN:
				return validateGuardPattern((GuardPattern)value, diagnostics, context);
			case QVTCorePackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case QVTCorePackage.PROPERTY_ASSIGNMENT:
				return validatePropertyAssignment((PropertyAssignment)value, diagnostics, context);
			case QVTCorePackage.REALIZED_VARIABLE:
				return validateRealizedVariable((RealizedVariable)value, diagnostics, context);
			case QVTCorePackage.VARIABLE_ASSIGNMENT:
				return validateVariableAssignment((VariableAssignment)value, diagnostics, context);
			case QVTCorePackage.ENFORCEMENT_MODE:
				return validateEnforcementMode((EnforcementMode)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArea(Area area, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(area, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(assignment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MappingIsEnforceable constraint of '<em>Assignment</em>'.
	 * @generated NOT
	 */
	public boolean validateAssignment_MappingIsEnforceable(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		String message = null;
		if (assignment.isIsDefault()) {
			Area area = getArea(assignment);
			if ((area != null) && !getIsEnforceable(area)) {
				if (area instanceof Domain)
					message = "Assignment can only be default within an enforceable domain";
				else
					message = "Assignment can only be default when some domain is enforceable";
			}
		}
		if (message != null)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.WARNING,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message, //EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "MappingIsEnforceable", getObjectLabel(assignment, context) }),
						 new Object[] { assignment }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBottomPattern(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(bottomPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateBottomPattern_RealizedVariableNamesAreUnique(bottomPattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RealizedVariableNamesAreUnique constraint of '<em>Bottom Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validateBottomPattern_RealizedVariableNamesAreUnique(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EList<RealizedVariable> myVariables = bottomPattern.getRealizedVariable();
		List<List<Variable>> conflicts = findVariableNameConflicts(bottomPattern, myVariables);
		if (conflicts.size() > 0) {
			if (diagnostics != null) {
				for (List<Variable> conflict : conflicts) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.WARNING,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_Redefinition_diagnostic",
							 new Object[] { getObjectLabel(conflict.get(1), context) },
							 new Object[] { conflict.get(0) },
							 context));
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCoreDomain(CoreDomain coreDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coreDomain, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(coreDomain, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCorePattern(CorePattern corePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(corePattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(corePattern, diagnostics, context);
		return result;
	}

	/**
	 * Validates the VariableNamesAreUnique constraint of '<em>Core Pattern</em>'.
	 * @generated NOT
	 */
	public boolean validateCorePattern_VariableNamesAreUnique(CorePattern corePattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EList<Variable> myVariables = corePattern.getVariable();
		List<List<Variable>> conflicts = findVariableNameConflicts(corePattern, myVariables);
		if (conflicts.size() > 0) {
			if (diagnostics != null) {
				for (List<Variable> conflict : conflicts) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.WARNING,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_Redefinition_diagnostic",
							 new Object[] { getObjectLabel(conflict.get(1), context) },
							 new Object[] { conflict.get(0) },
							 context));
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnforcementOperation(EnforcementOperation enforcementOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enforcementOperation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardPattern(GuardPattern guardPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardPattern, diagnostics, context);
		if (result || diagnostics != null) result &= validateCorePattern_VariableNamesAreUnique(guardPattern, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_WellFormedName(mapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateMapping_WellFormedName(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		String message = null;
		if (mapping.getContext() != null) {
			if (mapping.getName() != null)
				message = "Composed mapping '" + mapping.getName() + "' must be unnamed";
		}
		else {
			if (mapping.getName() == null)
				message = "Non-composed mapping must be named";
			else
				return ecoreValidator.validateENamedElement_WellFormedName(mapping, diagnostics, context);
		}
		if (message != null)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message, //EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "WellFormedName", getObjectLabel(mapping, context) }),
						 new Object[] { mapping }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyAssignment(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(propertyAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validatePropertyAssignment_TypeIsConsistent(propertyAssignment, diagnostics, context);
		return result;
	}

	/**
	 * @generated NOT
	 */
	public boolean validatePropertyAssignment_TypeIsConsistent(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = propertyAssignment.getValue();
		EStructuralFeature property = propertyAssignment.getTargetProperty();
		if ((value != null) && (property != null)) {
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = getOclEnvironment(context);
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> umlReflection = env.getUMLReflection();
			EClassifier propertyType = property.getEType();
			EClassifier resolvedPropertyType = umlReflection.getOCLType(property);
			EClassifier resolvedValueType = umlReflection.getOCLType(value);
			if (!TypeUtil.compatibleTypeMatch(env, resolvedValueType, resolvedPropertyType)
			 && !TypeUtil.compatibleTypeMatch(env, resolvedValueType, propertyType)) {
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_InconsistentPropertyType_diagnostic",
							 new Object[] { getObjectLabel(resolvedValueType, context), getObjectLabel(resolvedPropertyType, context) },
							 new Object[] { propertyAssignment },
							 context));
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealizedVariable(RealizedVariable realizedVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateVariable_WellFormedName(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateVariable_checkInitType(realizedVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validateRealizedVariable_MappingIsEnforceable(realizedVariable, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MappingIsEnforceable constraint of '<em>Realized Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateRealizedVariable_MappingIsEnforceable(RealizedVariable realizedVariable, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		String message = null;
		Area area = getArea(realizedVariable);
		if ((area != null) && !getIsEnforceable(area)) {
			EValidator.SubstitutionLabelProvider substitutionLabelProvider = (EValidator.SubstitutionLabelProvider) context.get(EValidator.SubstitutionLabelProvider.class);
			if (substitutionLabelProvider == null)
				substitutionLabelProvider = Diagnostician.INSTANCE;
			if (area instanceof Domain)
				message = "Variable '" + substitutionLabelProvider.getObjectLabel(realizedVariable) + "' can only be realized within an enforceable domain";
			else
				message = "Variable '" + substitutionLabelProvider.getObjectLabel(realizedVariable) + "' can only be realized when some domain is enforceable";
		}
		if (message != null)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.WARNING,
						 DIAGNOSTIC_SOURCE,
						 0,
						 message, //EcorePlugin.INSTANCE.getString("_UI_GenericConstraint_diagnostic", new Object[] { "MappingIsEnforceable", getObjectLabel(realizedVariable, context) }),
						 new Object[] { realizedVariable }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableAssignment(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_MappingIsEnforceable(variableAssignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateVariableAssignment_TypeIsConsistent(variableAssignment, diagnostics, context);
		return result;
	}

	/**
	 * @generated NOT
	 */
	public boolean validateVariableAssignment_TypeIsConsistent(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = variableAssignment.getValue();
		Variable variable = variableAssignment.getTargetVariable();
		if ((value != null) && (variable != null)) {
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = getOclEnvironment(context);
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> umlReflection = env.getUMLReflection();
			EClassifier variableType = variable.getEType();
			EClassifier resolvedVariableType = umlReflection.getOCLType(variable);
			EClassifier resolvedValueType = umlReflection.getOCLType(value);
			if (!TypeUtil.compatibleTypeMatch(env, resolvedValueType, resolvedVariableType)
			 && !TypeUtil.compatibleTypeMatch(env, resolvedValueType, variableType)) {
				if (diagnostics != null) {
					diagnostics.add
						(createDiagnostic
							(Diagnostic.ERROR,
							 DIAGNOSTIC_SOURCE,
							 0,
							 "_UI_InconsistentVariableType_diagnostic",
							 new Object[] { getObjectLabel(resolvedValueType, context), getObjectLabel(resolvedVariableType, context) },
							 new Object[] { variableAssignment },
							 context));
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnforcementMode(EnforcementMode enforcementMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
	    return QVTCorePlugin.INSTANCE;
	}
	
	/**
	 * @generated NOT
	 */
	protected List<List<Variable>> findVariableNameConflicts(CorePattern corePattern, EList<? extends Variable> myVariables) {
		List<List<Variable>> conflicts = Collections.emptyList();
		if (myVariables.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			EList<Variable> allVariables = corePattern.getAllVariables();
			for (Variable variable : allVariables) {
				String key = variable.getName();
				Object entry = map.get(key);
				if (entry == null)
					map.put(key, variable);
				else {
					List<Variable> list = null;
					if (entry instanceof Variable) {
						list = new ArrayList<Variable>();
						list.add((Variable) entry);
						map.put(key, list);
						if (myVariables.contains(entry)) {
							if (conflicts.size() <= 0)
								conflicts = new ArrayList<List<Variable>>();
							conflicts.add(list);
						}
					}
					else {
						@SuppressWarnings("unchecked")
						List<Variable> castList = (List<Variable>) entry;
						list = castList;
					}
					if (myVariables.contains(variable)) {
						if (conflicts.size() <= 0)
							conflicts = new ArrayList<List<Variable>>();
						conflicts.add(list);
						list.add(0, variable);
					}
					else
						list.add(variable);
				}
			}
		}
		return conflicts;
	}

	/**
	 * @generated NOT
	 */
	public Area getArea(EObject object) {
		for (EObject o = object; o != null; o = o.eContainer()) {
			if (o instanceof Area)
				return (Area) o;
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	public boolean getIsEnforceable(Area area) {
		if (area instanceof Domain)
			return ((Domain) area).isIsEnforceable();
		else if (area instanceof Mapping) {
			for (Domain domain : ((Mapping) area).getDomain())
				if (domain.isIsEnforceable())
					return true;
			return false;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getOclEnvironment(Map<Object, Object> context) {
		if (oclEnvironment == null) {
			if (context != null) {
				Object env = context.get(Environment.class);
				if (env instanceof Environment) {
					@SuppressWarnings("unchecked")
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
							EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env2 = (Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
							EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>) env;
					oclEnvironment = env2;
				}
			}
			if (oclEnvironment == null)
				oclEnvironment = new EcoreEnvironment((EcoreEnvironment)null) {};
		}
		return oclEnvironment;
	}

} //QVTCoreValidator
