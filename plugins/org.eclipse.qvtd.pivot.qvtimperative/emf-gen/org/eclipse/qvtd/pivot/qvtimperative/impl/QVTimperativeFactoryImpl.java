/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.pivot.qvtimperative.*;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;

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
			case 0: return createAddStatement();
			case 1: return createAppendParameter();
			case 2: return createAppendParameterBinding();
			case 3: return createBufferStatement();
			case 4: return createCheckStatement();
			case 6: return createDeclareStatement();
			case 7: return createEntryPoint();
			case 8: return createGuardParameter();
			case 9: return createGuardParameterBinding();
			case 10: return createImperativeModel();
			case 11: return createImperativeTransformation();
			case 12: return createLoopParameterBinding();
			case 13: return createLoopVariable();
			case 14: return createMapping();
			case 15: return createMappingCall();
			case 16: return createMappingLoop();
			case 20: return createNewStatement();
			case 21: return createNewStatementPart();
			case 23: return createSetStatement();
			case 24: return createSimpleParameter();
			case 25: return createSimpleParameterBinding();
			case 26: return createSpeculateStatement();
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
	public @NonNull AppendParameter createAppendParameter() {
		AppendParameterImpl appendParameter = new AppendParameterImpl();
		return appendParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull AppendParameterBinding createAppendParameterBinding() {
		AppendParameterBindingImpl appendParameterBinding = new AppendParameterBindingImpl();
		return appendParameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BufferStatement createBufferStatement() {
		BufferStatementImpl bufferStatement = new BufferStatementImpl();
		return bufferStatement;
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
	public @NonNull EntryPoint createEntryPoint() {
		EntryPointImpl entryPoint = new EntryPointImpl();
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardParameter createGuardParameter() {
		GuardParameterImpl guardParameter = new GuardParameterImpl();
		return guardParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardParameterBinding createGuardParameterBinding() {
		GuardParameterBindingImpl guardParameterBinding = new GuardParameterBindingImpl();
		return guardParameterBinding;
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
	public @NonNull ImperativeTransformation createImperativeTransformation() {
		ImperativeTransformationImpl imperativeTransformation = new ImperativeTransformationImpl();
		return imperativeTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LoopParameterBinding createLoopParameterBinding() {
		LoopParameterBindingImpl loopParameterBinding = new LoopParameterBindingImpl();
		return loopParameterBinding;
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
	public NewStatementPart createNewStatementPart() {
		NewStatementPartImpl newStatementPart = new NewStatementPartImpl();
		return newStatementPart;
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
	public @NonNull SimpleParameter createSimpleParameter() {
		SimpleParameterImpl simpleParameter = new SimpleParameterImpl();
		return simpleParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SimpleParameterBinding createSimpleParameterBinding() {
		SimpleParameterBindingImpl simpleParameterBinding = new SimpleParameterBindingImpl();
		return simpleParameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SpeculateStatement createSpeculateStatement() {
		SpeculateStatementImpl speculateStatement = new SpeculateStatementImpl();
		return speculateStatement;
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
