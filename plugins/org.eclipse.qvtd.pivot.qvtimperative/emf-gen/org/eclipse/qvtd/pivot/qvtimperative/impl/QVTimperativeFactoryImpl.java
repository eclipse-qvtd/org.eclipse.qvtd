/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.*;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeFactoryImpl extends EFactoryImpl implements QVTimperativeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTimperativeFactory init() {
		try {
			QVTimperativeFactory theQVTimperativeFactory = (QVTimperativeFactory)EPackage.Registry.INSTANCE.getEFactory(QVTimperativePackage.eNS_URI);
			if (theQVTimperativeFactory != null) {
				return theQVTimperativeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTimperativeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QVTimperativePackage.BOTTOM_PATTERN: return createBottomPattern();
			case QVTimperativePackage.CONNECTION_ASSIGNMENT: return createConnectionAssignment();
			case QVTimperativePackage.CONNECTION_STATEMENT: return createConnectionStatement();
			case QVTimperativePackage.CONNECTION_VARIABLE: return createConnectionVariable();
			case QVTimperativePackage.CORE_DOMAIN: return createCoreDomain();
			case QVTimperativePackage.CORE_PATTERN: return createCorePattern();
			case QVTimperativePackage.ENFORCEMENT_OPERATION: return createEnforcementOperation();
			case QVTimperativePackage.GUARD_PATTERN: return createGuardPattern();
			case QVTimperativePackage.IMPERATIVE_BOTTOM_PATTERN: return createImperativeBottomPattern();
			case QVTimperativePackage.IMPERATIVE_DOMAIN: return createImperativeDomain();
			case QVTimperativePackage.IMPERATIVE_MODEL: return createImperativeModel();
			case QVTimperativePackage.MAPPING: return createMapping();
			case QVTimperativePackage.MAPPING_CALL: return createMappingCall();
			case QVTimperativePackage.MAPPING_CALL_BINDING: return createMappingCallBinding();
			case QVTimperativePackage.MAPPING_LOOP: return createMappingLoop();
			case QVTimperativePackage.MAPPING_SEQUENCE: return createMappingSequence();
			case QVTimperativePackage.OPPOSITE_PROPERTY_ASSIGNMENT: return createOppositePropertyAssignment();
			case QVTimperativePackage.PROPERTY_ASSIGNMENT: return createPropertyAssignment();
			case QVTimperativePackage.REALIZED_VARIABLE: return createRealizedVariable();
			case QVTimperativePackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
			case QVTimperativePackage.VARIABLE_PREDICATE: return createVariablePredicate();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QVTimperativePackage.ENFORCEMENT_MODE:
				return createEnforcementModeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QVTimperativePackage.ENFORCEMENT_MODE:
				return convertEnforcementModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottomPattern createBottomPattern() {
		BottomPatternImpl bottomPattern = new BottomPatternImpl();
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ConnectionAssignment createConnectionAssignment() {
		ConnectionAssignmentImpl connectionAssignment = new ConnectionAssignmentImpl();
		return connectionAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ConnectionStatement createConnectionStatement() {
		ConnectionStatementImpl connectionStatement = new ConnectionStatementImpl();
		return connectionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ConnectionVariable createConnectionVariable() {
		ConnectionVariableImpl connectionVariable = new ConnectionVariableImpl();
		return connectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CoreDomain createCoreDomain() {
		CoreDomainImpl coreDomain = new CoreDomainImpl();
		return coreDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CorePattern createCorePattern() {
		CorePatternImpl corePattern = new CorePatternImpl();
		return corePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnforcementOperation createEnforcementOperation() {
		EnforcementOperationImpl enforcementOperation = new EnforcementOperationImpl();
		return enforcementOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardPattern createGuardPattern() {
		GuardPatternImpl guardPattern = new GuardPatternImpl();
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ImperativeBottomPattern createImperativeBottomPattern() {
		ImperativeBottomPatternImpl imperativeBottomPattern = new ImperativeBottomPatternImpl();
		return imperativeBottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ImperativeDomain createImperativeDomain() {
		ImperativeDomainImpl imperativeDomain = new ImperativeDomainImpl();
		return imperativeDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public@NonNull ImperativeModel createImperativeModel() {
		ImperativeModelImpl imperativeModel = new ImperativeModelImpl();
		return imperativeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCall createMappingCall() {
		MappingCallImpl mappingCall = new MappingCallImpl();
		return mappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCallBinding createMappingCallBinding() {
		MappingCallBindingImpl mappingCallBinding = new MappingCallBindingImpl();
		return mappingCallBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingLoop createMappingLoop() {
		MappingLoopImpl mappingLoop = new MappingLoopImpl();
		return mappingLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingSequence createMappingSequence() {
		MappingSequenceImpl mappingSequence = new MappingSequenceImpl();
		return mappingSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OppositePropertyAssignment createOppositePropertyAssignment() {
		OppositePropertyAssignmentImpl oppositePropertyAssignment = new OppositePropertyAssignmentImpl();
		return oppositePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyAssignment createPropertyAssignment() {
		PropertyAssignmentImpl propertyAssignment = new PropertyAssignmentImpl();
		return propertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealizedVariable createRealizedVariable() {
		RealizedVariableImpl realizedVariable = new RealizedVariableImpl();
		return realizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableAssignment createVariableAssignment() {
		VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
		return variableAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull VariablePredicate createVariablePredicate() {
		VariablePredicateImpl variablePredicate = new VariablePredicateImpl();
		return variablePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforcementMode createEnforcementModeFromString(EDataType eDataType, String initialValue) {
		EnforcementMode result = EnforcementMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnforcementModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativePackage getQVTimperativePackage() {
		return (QVTimperativePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTimperativePackage getPackage() {
		return QVTimperativePackage.eINSTANCE;
	}

} //QVTimperativeFactoryImpl
