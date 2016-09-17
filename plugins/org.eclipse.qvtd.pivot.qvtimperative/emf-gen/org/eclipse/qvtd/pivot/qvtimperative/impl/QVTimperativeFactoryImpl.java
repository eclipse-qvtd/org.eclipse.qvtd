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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;

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
			case QVTimperativePackage.ADD_STATEMENT: return createAddStatement();
			case QVTimperativePackage.CHECK_STATEMENT: return createCheckStatement();
			case QVTimperativePackage.DECLARE_STATEMENT: return createDeclareStatement();
			case QVTimperativePackage.GUARD_VARIABLE: return createGuardVariable();
			case QVTimperativePackage.IMPERATIVE_MODEL: return createImperativeModel();
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL: return createImperativeTypedModel();
			case QVTimperativePackage.IN_CONNECTION_VARIABLE: return createInConnectionVariable();
			case QVTimperativePackage.LOOP_VARIABLE: return createLoopVariable();
			case QVTimperativePackage.MAPPING: return createMapping();
			case QVTimperativePackage.MAPPING_CALL: return createMappingCall();
			case QVTimperativePackage.MAPPING_CALL_BINDING: return createMappingCallBinding();
			case QVTimperativePackage.MAPPING_LOOP: return createMappingLoop();
			case QVTimperativePackage.NEW_STATEMENT: return createNewStatement();
			case QVTimperativePackage.OUT_CONNECTION_VARIABLE: return createOutConnectionVariable();
			case QVTimperativePackage.SET_STATEMENT: return createSetStatement();
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
	public @NonNull AddStatement createAddStatement() {
		AddStatementImpl addStatement = new AddStatementImpl();
		return addStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CheckStatement createCheckStatement() {
		CheckStatementImpl checkStatement = new CheckStatementImpl();
		return checkStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DeclareStatement createDeclareStatement() {
		DeclareStatementImpl declareStatement = new DeclareStatementImpl();
		return declareStatement;
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
	public @NonNull ImperativeModel createImperativeModel() {
		ImperativeModelImpl imperativeModel = new ImperativeModelImpl();
		return imperativeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ImperativeTypedModel createImperativeTypedModel() {
		ImperativeTypedModelImpl imperativeTypedModel = new ImperativeTypedModelImpl();
		return imperativeTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull InConnectionVariable createInConnectionVariable() {
		InConnectionVariableImpl inConnectionVariable = new InConnectionVariableImpl();
		return inConnectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LoopVariable createLoopVariable() {
		LoopVariableImpl loopVariable = new LoopVariableImpl();
		return loopVariable;
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
	public @NonNull NewStatement createNewStatement() {
		NewStatementImpl newStatement = new NewStatementImpl();
		return newStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OutConnectionVariable createOutConnectionVariable() {
		OutConnectionVariableImpl outConnectionVariable = new OutConnectionVariableImpl();
		return outConnectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SetStatement createSetStatement() {
		SetStatementImpl setStatement = new SetStatementImpl();
		return setStatement;
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
