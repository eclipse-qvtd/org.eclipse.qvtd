/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.pivot.qvtimperative.*;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

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
			case QVTimperativePackage.IMPERATIVE_MODEL: return createImperativeModel();
			case QVTimperativePackage.MAPPING: return createMapping();
			case QVTimperativePackage.MAPPING_CALL: return createMappingCall();
			case QVTimperativePackage.MAPPING_CALL_BINDING: return createMappingCallBinding();
			case QVTimperativePackage.MAPPING_LOOP: return createMappingLoop();
			case QVTimperativePackage.MAPPING_SEQUENCE: return createMappingSequence();
			case QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT: return createMiddlePropertyAssignment();
			case QVTimperativePackage.MIDDLE_PROPERTY_CALL_EXP: return createMiddlePropertyCallExp();
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
	public ImperativeModel createImperativeModel() {
		ImperativeModelImpl imperativeModel = new ImperativeModelImpl();
		return imperativeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCall createMappingCall() {
		MappingCallImpl mappingCall = new MappingCallImpl();
		return mappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallBinding createMappingCallBinding() {
		MappingCallBindingImpl mappingCallBinding = new MappingCallBindingImpl();
		return mappingCallBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingLoop createMappingLoop() {
		MappingLoopImpl mappingLoop = new MappingLoopImpl();
		return mappingLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSequence createMappingSequence() {
		MappingSequenceImpl mappingSequence = new MappingSequenceImpl();
		return mappingSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiddlePropertyAssignment createMiddlePropertyAssignment() {
		MiddlePropertyAssignmentImpl middlePropertyAssignment = new MiddlePropertyAssignmentImpl();
		return middlePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiddlePropertyCallExp createMiddlePropertyCallExp() {
		MiddlePropertyCallExpImpl middlePropertyCallExp = new MiddlePropertyCallExpImpl();
		return middlePropertyCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariablePredicate createVariablePredicate() {
		VariablePredicateImpl variablePredicate = new VariablePredicateImpl();
		return variablePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
