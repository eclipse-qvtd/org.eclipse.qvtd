/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.codegen.qvticgmodel.*;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTiCGModelFactoryImpl extends EFactoryImpl implements QVTiCGModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTiCGModelFactory init() {
		try {
			QVTiCGModelFactory theQVTiCGModelFactory = (QVTiCGModelFactory)EPackage.Registry.INSTANCE.getEFactory(QVTiCGModelPackage.eNS_URI);
			if (theQVTiCGModelFactory != null) {
				return theQVTiCGModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTiCGModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTiCGModelFactoryImpl() {
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
			case QVTiCGModelPackage.CG_CONNECTION_ASSIGNMENT: return createCGConnectionAssignment();
			case QVTiCGModelPackage.CG_CONNECTION_VARIABLE: return createCGConnectionVariable();
			case QVTiCGModelPackage.CG_ECORE_PROPERTY_ASSIGNMENT: return createCGEcorePropertyAssignment();
			case QVTiCGModelPackage.CG_ECORE_REALIZED_VARIABLE: return createCGEcoreRealizedVariable();
			case QVTiCGModelPackage.CG_FUNCTION: return createCGFunction();
			case QVTiCGModelPackage.CG_FUNCTION_CALL_EXP: return createCGFunctionCallExp();
			case QVTiCGModelPackage.CG_FUNCTION_PARAMETER: return createCGFunctionParameter();
			case QVTiCGModelPackage.CG_GUARD_VARIABLE: return createCGGuardVariable();
			case QVTiCGModelPackage.CG_MAPPING: return createCGMapping();
			case QVTiCGModelPackage.CG_MAPPING_CALL: return createCGMappingCall();
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING: return createCGMappingCallBinding();
			case QVTiCGModelPackage.CG_MAPPING_EXP: return createCGMappingExp();
			case QVTiCGModelPackage.CG_MAPPING_LOOP: return createCGMappingLoop();
			case QVTiCGModelPackage.CG_MIDDLE_PROPERTY_ASSIGNMENT: return createCGMiddlePropertyAssignment();
			case QVTiCGModelPackage.CG_MIDDLE_PROPERTY_CALL_EXP: return createCGMiddlePropertyCallExp();
			case QVTiCGModelPackage.CG_PREDICATE: return createCGPredicate();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT: return createCGPropertyAssignment();
			case QVTiCGModelPackage.CG_REALIZED_VARIABLE: return createCGRealizedVariable();
			case QVTiCGModelPackage.CG_SEQUENCE: return createCGSequence();
			case QVTiCGModelPackage.CG_TRANSFORMATION: return createCGTransformation();
			case QVTiCGModelPackage.CG_TYPED_MODEL: return createCGTypedModel();
			case QVTiCGModelPackage.CG_VARIABLE_PREDICATE: return createCGVariablePredicate();
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
	public @NonNull CGConnectionAssignment createCGConnectionAssignment() {
		CGConnectionAssignmentImpl cgConnectionAssignment = new CGConnectionAssignmentImpl();
		return cgConnectionAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGConnectionVariable createCGConnectionVariable() {
		CGConnectionVariableImpl cgConnectionVariable = new CGConnectionVariableImpl();
		return cgConnectionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGEcorePropertyAssignment createCGEcorePropertyAssignment() {
		CGEcorePropertyAssignmentImpl cgEcorePropertyAssignment = new CGEcorePropertyAssignmentImpl();
		return cgEcorePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGEcoreRealizedVariable createCGEcoreRealizedVariable() {
		CGEcoreRealizedVariableImpl cgEcoreRealizedVariable = new CGEcoreRealizedVariableImpl();
		return cgEcoreRealizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGFunction createCGFunction() {
		CGFunctionImpl cgFunction = new CGFunctionImpl();
		return cgFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGFunctionCallExp createCGFunctionCallExp() {
		CGFunctionCallExpImpl cgFunctionCallExp = new CGFunctionCallExpImpl();
		return cgFunctionCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGFunctionParameter createCGFunctionParameter() {
		CGFunctionParameterImpl cgFunctionParameter = new CGFunctionParameterImpl();
		return cgFunctionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGGuardVariable createCGGuardVariable() {
		CGGuardVariableImpl cgGuardVariable = new CGGuardVariableImpl();
		return cgGuardVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMapping createCGMapping() {
		CGMappingImpl cgMapping = new CGMappingImpl();
		return cgMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMappingCall createCGMappingCall() {
		CGMappingCallImpl cgMappingCall = new CGMappingCallImpl();
		return cgMappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMappingCallBinding createCGMappingCallBinding() {
		CGMappingCallBindingImpl cgMappingCallBinding = new CGMappingCallBindingImpl();
		return cgMappingCallBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMappingExp createCGMappingExp() {
		CGMappingExpImpl cgMappingExp = new CGMappingExpImpl();
		return cgMappingExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMappingLoop createCGMappingLoop() {
		CGMappingLoopImpl cgMappingLoop = new CGMappingLoopImpl();
		return cgMappingLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMiddlePropertyAssignment createCGMiddlePropertyAssignment() {
		CGMiddlePropertyAssignmentImpl cgMiddlePropertyAssignment = new CGMiddlePropertyAssignmentImpl();
		return cgMiddlePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGMiddlePropertyCallExp createCGMiddlePropertyCallExp() {
		CGMiddlePropertyCallExpImpl cgMiddlePropertyCallExp = new CGMiddlePropertyCallExpImpl();
		return cgMiddlePropertyCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGPredicate createCGPredicate() {
		CGPredicateImpl cgPredicate = new CGPredicateImpl();
		return cgPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGPropertyAssignment createCGPropertyAssignment() {
		CGPropertyAssignmentImpl cgPropertyAssignment = new CGPropertyAssignmentImpl();
		return cgPropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGRealizedVariable createCGRealizedVariable() {
		CGRealizedVariableImpl cgRealizedVariable = new CGRealizedVariableImpl();
		return cgRealizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGSequence createCGSequence() {
		CGSequenceImpl cgSequence = new CGSequenceImpl();
		return cgSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGTransformation createCGTransformation() {
		CGTransformationImpl cgTransformation = new CGTransformationImpl();
		return cgTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGTypedModel createCGTypedModel() {
		CGTypedModelImpl cgTypedModel = new CGTypedModelImpl();
		return cgTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGVariablePredicate createCGVariablePredicate() {
		CGVariablePredicateImpl cgVariablePredicate = new CGVariablePredicateImpl();
		return cgVariablePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull QVTiCGModelPackage getQVTiCGModelPackage() {
		return (QVTiCGModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTiCGModelPackage getPackage() {
		return QVTiCGModelPackage.eINSTANCE;
	}

} //QVTiCGModelFactoryImpl
