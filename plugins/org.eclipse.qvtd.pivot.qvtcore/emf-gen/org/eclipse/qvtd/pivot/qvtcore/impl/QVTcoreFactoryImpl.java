/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtcore.*;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreFactoryImpl extends EFactoryImpl implements QVTcoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreFactory init() {
		try {
			QVTcoreFactory theQVTcoreFactory = (QVTcoreFactory)EPackage.Registry.INSTANCE.getEFactory(QVTcorePackage.eNS_URI);
			if (theQVTcoreFactory != null) {
				return theQVTcoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreFactoryImpl() {
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
			case QVTcorePackage.BOTTOM_PATTERN: return createBottomPattern();
			case QVTcorePackage.BOTTOM_VARIABLE: return createBottomVariable();
			case QVTcorePackage.CORE_DOMAIN: return createCoreDomain();
			case QVTcorePackage.CORE_MODEL: return createCoreModel();
			case QVTcorePackage.CORE_PATTERN: return createCorePattern();
			case QVTcorePackage.ENFORCEMENT_OPERATION: return createEnforcementOperation();
			case QVTcorePackage.GUARD_PATTERN: return createGuardPattern();
			case QVTcorePackage.GUARD_VARIABLE: return createGuardVariable();
			case QVTcorePackage.MAPPING: return createMapping();
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT: return createOppositePropertyAssignment();
			case QVTcorePackage.PROPERTY_ASSIGNMENT: return createPropertyAssignment();
			case QVTcorePackage.REALIZED_VARIABLE: return createRealizedVariable();
			case QVTcorePackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
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
			case QVTcorePackage.ENFORCEMENT_MODE:
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
			case QVTcorePackage.ENFORCEMENT_MODE:
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
	public @NonNull BottomPattern createBottomPattern() {
		BottomPatternImpl bottomPattern = new BottomPatternImpl();
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BottomVariable createBottomVariable() {
		BottomVariableImpl bottomVariable = new BottomVariableImpl();
		return bottomVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CoreDomain createCoreDomain() {
		CoreDomainImpl coreDomain = new CoreDomainImpl();
		return coreDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CoreModel createCoreModel() {
		CoreModelImpl coreModel = new CoreModelImpl();
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CorePattern createCorePattern() {
		CorePatternImpl corePattern = new CorePatternImpl();
		return corePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull EnforcementOperation createEnforcementOperation() {
		EnforcementOperationImpl enforcementOperation = new EnforcementOperationImpl();
		return enforcementOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardPattern createGuardPattern() {
		GuardPatternImpl guardPattern = new GuardPatternImpl();
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardVariable createGuardVariable() {
		GuardVariableImpl guardVariable = new GuardVariableImpl();
		return guardVariable;
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
	public @NonNull OppositePropertyAssignment createOppositePropertyAssignment() {
		OppositePropertyAssignmentImpl oppositePropertyAssignment = new OppositePropertyAssignmentImpl();
		return oppositePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PropertyAssignment createPropertyAssignment() {
		PropertyAssignmentImpl propertyAssignment = new PropertyAssignmentImpl();
		return propertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RealizedVariable createRealizedVariable() {
		RealizedVariableImpl realizedVariable = new RealizedVariableImpl();
		return realizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull VariableAssignment createVariableAssignment() {
		VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
		return variableAssignment;
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
	public QVTcorePackage getQVTcorePackage() {
		return (QVTcorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcorePackage getPackage() {
		return QVTcorePackage.eINSTANCE;
	}

} //QVTcoreFactoryImpl
