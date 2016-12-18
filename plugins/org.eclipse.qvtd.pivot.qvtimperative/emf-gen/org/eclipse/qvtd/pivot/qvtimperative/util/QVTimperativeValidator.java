/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.pivot.util.PivotValidator;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseValidator;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage
 * @generated
 */
public class QVTimperativeValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTimperativeValidator INSTANCE = new QVTimperativeValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.pivot.qvtimperative";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'Add Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int ADD_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'Buffer Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int BUFFER_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Type Is Boolean' of 'Check Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CHECK_STATEMENT__VALIDATE_TYPE_IS_BOOLEAN = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Checked Value' of 'Declare Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DECLARE_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_CHECKED_VALUE = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Unchecked Value' of 'Declare Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int DECLARE_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_UNCHECKED_VALUE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validateall Rules Are Mappings' of 'Imperative Transformation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPERATIVE_TRANSFORMATION__VALIDATEALL_RULES_ARE_MAPPINGS = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Not Null' of 'Imperative Typed Model'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPERATIVE_TYPED_MODEL__VALIDATE_NAME_IS_NOT_NULL = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Both Checked And Enforced' of 'Imperative Typed Model'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int IMPERATIVE_TYPED_MODEL__VALIDATE_NOT_BOTH_CHECKED_AND_ENFORCED = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Name Is Not Null' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_NAME_IS_NOT_NULL = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Mapping Parameter Names Are Unique' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_MAPPING_PARAMETER_NAMES_ARE_UNIQUE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Local Variabel Names Are Unique' of 'Mapping'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING__VALIDATE_LOCAL_VARIABEL_NAMES_ARE_UNIQUE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Matching Call Bindings' of 'Mapping Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_CALL__VALIDATE_MATCHING_CALL_BINDINGS = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Both Install And Invoke' of 'Mapping Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_CALL__VALIDATE_NOT_BOTH_INSTALL_AND_INVOKE = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Unique Call Bindings' of 'Mapping Call'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_CALL__VALIDATE_UNIQUE_CALL_BINDINGS = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameter Is Mapping Parameter' of 'Mapping Parameter Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MAPPING_PARAMETER_BINDING__VALIDATE_PARAMETER_IS_MAPPING_PARAMETER = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'New Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NEW_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Non Data Type For Type' of 'New Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int NEW_STATEMENT__VALIDATE_NON_DATA_TYPE_FOR_TYPE = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Class For Property' of 'Set Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SET_STATEMENT__VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Value' of 'Set Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SET_STATEMENT__VALIDATE_COMPATIBLE_TYPE_FOR_VALUE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Value Does Not Navigate From Realized Variables' of 'Set Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SET_STATEMENT__VALIDATE_VALUE_DOES_NOT_NAVIGATE_FROM_REALIZED_VARIABLES = 20;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Target Property Is Not Read Only' of 'Set Statement'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SET_STATEMENT__VALIDATE_TARGET_PROPERTY_IS_NOT_READ_ONLY = 21;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Checked Value' of 'Simple Parameter Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIMPLE_PARAMETER_BINDING__VALIDATE_COMPATIBLE_TYPE_FOR_CHECKED_VALUE = 22;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Compatible Type For Unchecked Value' of 'Simple Parameter Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SIMPLE_PARAMETER_BINDING__VALIDATE_COMPATIBLE_TYPE_FOR_UNCHECKED_VALUE = 23;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 23;

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
	protected PivotValidator pivotValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTbaseValidator qvTbaseValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeValidator() {
		super();
		pivotValidator = PivotValidator.INSTANCE;
		qvTbaseValidator = QVTbaseValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return QVTimperativePackage.eINSTANCE;
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
			case QVTimperativePackage.ADD_STATEMENT:
				return validateAddStatement((AddStatement)value, diagnostics, context);
			case QVTimperativePackage.APPEND_PARAMETER:
				return validateAppendParameter((AppendParameter)value, diagnostics, context);
			case QVTimperativePackage.APPEND_PARAMETER_BINDING:
				return validateAppendParameterBinding((AppendParameterBinding)value, diagnostics, context);
			case QVTimperativePackage.BUFFER_STATEMENT:
				return validateBufferStatement((BufferStatement)value, diagnostics, context);
			case QVTimperativePackage.CHECK_STATEMENT:
				return validateCheckStatement((CheckStatement)value, diagnostics, context);
			case QVTimperativePackage.CONNECTION_VARIABLE:
				return validateConnectionVariable((ConnectionVariable)value, diagnostics, context);
			case QVTimperativePackage.DECLARE_STATEMENT:
				return validateDeclareStatement((DeclareStatement)value, diagnostics, context);
			case QVTimperativePackage.GUARD_PARAMETER:
				return validateGuardParameter((GuardParameter)value, diagnostics, context);
			case QVTimperativePackage.GUARD_PARAMETER_BINDING:
				return validateGuardParameterBinding((GuardParameterBinding)value, diagnostics, context);
			case QVTimperativePackage.IMPERATIVE_MODEL:
				return validateImperativeModel((ImperativeModel)value, diagnostics, context);
			case QVTimperativePackage.IMPERATIVE_TRANSFORMATION:
				return validateImperativeTransformation((ImperativeTransformation)value, diagnostics, context);
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL:
				return validateImperativeTypedModel((ImperativeTypedModel)value, diagnostics, context);
			case QVTimperativePackage.LOOP_PARAMETER_BINDING:
				return validateLoopParameterBinding((LoopParameterBinding)value, diagnostics, context);
			case QVTimperativePackage.LOOP_VARIABLE:
				return validateLoopVariable((LoopVariable)value, diagnostics, context);
			case QVTimperativePackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case QVTimperativePackage.MAPPING_CALL:
				return validateMappingCall((MappingCall)value, diagnostics, context);
			case QVTimperativePackage.MAPPING_LOOP:
				return validateMappingLoop((MappingLoop)value, diagnostics, context);
			case QVTimperativePackage.MAPPING_PARAMETER:
				return validateMappingParameter((MappingParameter)value, diagnostics, context);
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING:
				return validateMappingParameterBinding((MappingParameterBinding)value, diagnostics, context);
			case QVTimperativePackage.MAPPING_STATEMENT:
				return validateMappingStatement((MappingStatement)value, diagnostics, context);
			case QVTimperativePackage.NEW_STATEMENT:
				return validateNewStatement((NewStatement)value, diagnostics, context);
			case QVTimperativePackage.OBSERVABLE_STATEMENT:
				return validateObservableStatement((ObservableStatement)value, diagnostics, context);
			case QVTimperativePackage.SET_STATEMENT:
				return validateSetStatement((SetStatement)value, diagnostics, context);
			case QVTimperativePackage.SIMPLE_PARAMETER:
				return validateSimpleParameter((SimpleParameter)value, diagnostics, context);
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING:
				return validateSimpleParameterBinding((SimpleParameterBinding)value, diagnostics, context);
			case QVTimperativePackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case QVTimperativePackage.VARIABLE_STATEMENT:
				return validateVariableStatement((VariableStatement)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddStatement(AddStatement addStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(addStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(addStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateAddStatement_validateCompatibleTypeForValue(addStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>Add Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAddStatement_validateCompatibleTypeForValue(AddStatement addStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return addStatement.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAppendParameter(AppendParameter appendParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(appendParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(appendParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(appendParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAppendParameterBinding(AppendParameterBinding appendParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(appendParameterBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(appendParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingParameterBinding_validateParameterIsMappingParameter(appendParameterBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBufferStatement(BufferStatement bufferStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bufferStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(bufferStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateBufferStatement_validateCompatibleTypeForValue(bufferStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>Buffer Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBufferStatement_validateCompatibleTypeForValue(BufferStatement bufferStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return bufferStatement.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCheckStatement(CheckStatement checkStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(checkStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(checkStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateCheckStatement_validateTypeIsBoolean(checkStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTypeIsBoolean constraint of '<em>Check Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCheckStatement_validateTypeIsBoolean(CheckStatement checkStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkStatement.validateTypeIsBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionVariable(ConnectionVariable connectionVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(connectionVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(connectionVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(connectionVariable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclareStatement(DeclareStatement declareStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(declareStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclareStatement_validateCompatibleTypeForCheckedValue(declareStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateDeclareStatement_validateCompatibleTypeForUncheckedValue(declareStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForCheckedValue constraint of '<em>Declare Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclareStatement_validateCompatibleTypeForCheckedValue(DeclareStatement declareStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return declareStatement.validateCompatibleTypeForCheckedValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForUncheckedValue constraint of '<em>Declare Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclareStatement_validateCompatibleTypeForUncheckedValue(DeclareStatement declareStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return declareStatement.validateCompatibleTypeForUncheckedValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardParameter(GuardParameter guardParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(guardParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(guardParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(guardParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGuardParameterBinding(GuardParameterBinding guardParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(guardParameterBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(guardParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingParameterBinding_validateParameterIsMappingParameter(guardParameterBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeModel(ImperativeModel imperativeModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(imperativeModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeTransformation(ImperativeTransformation imperativeTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(imperativeTransformation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateNameIsNotNull(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateClass_validateUniqueInvariantName(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateContextTypeIsTransformation(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateExtendedTypedModelIsExtended(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateTransformation_validateModelParameterIsUnique(imperativeTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeTransformation_validateallRulesAreMappings(imperativeTransformation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateallRulesAreMappings constraint of '<em>Imperative Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeTransformation_validateallRulesAreMappings(ImperativeTransformation imperativeTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return imperativeTransformation.validateallRulesAreMappings(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeTypedModel(ImperativeTypedModel imperativeTypedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(imperativeTypedModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeTypedModel_validateNameIsNotNull(imperativeTypedModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateImperativeTypedModel_validateNotBothCheckedAndEnforced(imperativeTypedModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsNotNull constraint of '<em>Imperative Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeTypedModel_validateNameIsNotNull(ImperativeTypedModel imperativeTypedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return imperativeTypedModel.validateNameIsNotNull(diagnostics, context);
	}

	/**
	 * Validates the validateNotBothCheckedAndEnforced constraint of '<em>Imperative Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeTypedModel_validateNotBothCheckedAndEnforced(ImperativeTypedModel imperativeTypedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return imperativeTypedModel.validateNotBothCheckedAndEnforced(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopParameterBinding(LoopParameterBinding loopParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loopParameterBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingParameterBinding_validateParameterIsMappingParameter(loopParameterBinding, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopVariable(LoopVariable loopVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loopVariable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(loopVariable, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(loopVariable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mapping, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateDomainNameIsUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleIsExtendedRule(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= qvTbaseValidator.validateRule_validateOverridesRuleOverridesAllDomains(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateNameIsNotNull(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateMappingParameterNamesAreUnique(mapping, diagnostics, context);
		if (result || diagnostics != null) result &= validateMapping_validateLocalVariabelNamesAreUnique(mapping, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNameIsNotNull constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateNameIsNotNull(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateNameIsNotNull(diagnostics, context);
	}

	/**
	 * Validates the validateMappingParameterNamesAreUnique constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateMappingParameterNamesAreUnique(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateMappingParameterNamesAreUnique(diagnostics, context);
	}

	/**
	 * Validates the validateLocalVariabelNamesAreUnique constraint of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping_validateLocalVariabelNamesAreUnique(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mapping.validateLocalVariabelNamesAreUnique(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCall(MappingCall mappingCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingCall, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingCall_validateMatchingCallBindings(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingCall_validateNotBothInstallAndInvoke(mappingCall, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingCall_validateUniqueCallBindings(mappingCall, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMatchingCallBindings constraint of '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCall_validateMatchingCallBindings(MappingCall mappingCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingCall.validateMatchingCallBindings(diagnostics, context);
	}

	/**
	 * Validates the validateNotBothInstallAndInvoke constraint of '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCall_validateNotBothInstallAndInvoke(MappingCall mappingCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingCall.validateNotBothInstallAndInvoke(diagnostics, context);
	}

	/**
	 * Validates the validateUniqueCallBindings constraint of '<em>Mapping Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCall_validateUniqueCallBindings(MappingCall mappingCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingCall.validateUniqueCallBindings(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingLoop(MappingLoop mappingLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingLoop, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingParameter(MappingParameter mappingParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(mappingParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingParameterBinding(MappingParameterBinding mappingParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingParameterBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingParameterBinding_validateParameterIsMappingParameter(mappingParameterBinding, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParameterIsMappingParameter constraint of '<em>Mapping Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingParameterBinding_validateParameterIsMappingParameter(MappingParameterBinding mappingParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return mappingParameterBinding.validateParameterIsMappingParameter(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingStatement(MappingStatement mappingStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewStatement(NewStatement newStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(newStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateNewStatement_validateCompatibleTypeForValue(newStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateNewStatement_validateNonDataTypeForType(newStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>New Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewStatement_validateCompatibleTypeForValue(NewStatement newStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return newStatement.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * Validates the validateNonDataTypeForType constraint of '<em>New Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewStatement_validateNonDataTypeForType(NewStatement newStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return newStatement.validateNonDataTypeForType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObservableStatement(ObservableStatement observableStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(observableStatement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetStatement(SetStatement setStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(setStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSetStatement_validateCompatibleClassForProperty(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSetStatement_validateCompatibleTypeForValue(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSetStatement_validateValueDoesNotNavigateFromRealizedVariables(setStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validateSetStatement_validateTargetPropertyIsNotReadOnly(setStatement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleClassForProperty constraint of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetStatement_validateCompatibleClassForProperty(SetStatement setStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return setStatement.validateCompatibleClassForProperty(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForValue constraint of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetStatement_validateCompatibleTypeForValue(SetStatement setStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return setStatement.validateCompatibleTypeForValue(diagnostics, context);
	}

	/**
	 * Validates the validateValueDoesNotNavigateFromRealizedVariables constraint of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetStatement_validateValueDoesNotNavigateFromRealizedVariables(SetStatement setStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return setStatement.validateValueDoesNotNavigateFromRealizedVariables(diagnostics, context);
	}

	/**
	 * Validates the validateTargetPropertyIsNotReadOnly constraint of '<em>Set Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetStatement_validateTargetPropertyIsNotReadOnly(SetStatement setStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return setStatement.validateTargetPropertyIsNotReadOnly(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleParameter(SimpleParameter simpleParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(simpleParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(simpleParameter, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(simpleParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleParameterBinding(SimpleParameterBinding simpleParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(simpleParameterBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateMappingParameterBinding_validateParameterIsMappingParameter(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateSimpleParameterBinding_validateCompatibleTypeForCheckedValue(simpleParameterBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateSimpleParameterBinding_validateCompatibleTypeForUncheckedValue(simpleParameterBinding, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateCompatibleTypeForCheckedValue constraint of '<em>Simple Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleParameterBinding_validateCompatibleTypeForCheckedValue(SimpleParameterBinding simpleParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return simpleParameterBinding.validateCompatibleTypeForCheckedValue(diagnostics, context);
	}

	/**
	 * Validates the validateCompatibleTypeForUncheckedValue constraint of '<em>Simple Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleParameterBinding_validateCompatibleTypeForUncheckedValue(SimpleParameterBinding simpleParameterBinding, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return simpleParameterBinding.validateCompatibleTypeForUncheckedValue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement(Statement statement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableStatement(VariableStatement variableStatement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableStatement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateNameIsNotNull(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotInvalid(variableStatement, diagnostics, context);
		if (result || diagnostics != null) result &= pivotValidator.validateVariableDeclaration_validateTypeIsNotNull(variableStatement, diagnostics, context);
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

} //QVTimperativeValidator
