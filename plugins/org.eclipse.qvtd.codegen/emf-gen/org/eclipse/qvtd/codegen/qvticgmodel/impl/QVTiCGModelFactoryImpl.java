/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreContainerAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSequence;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcoreContainerAssignmentImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGEcorePropertyAssignmentImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGPropertyAssignmentImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGSequenceImpl;
import org.eclipse.qvtd.codegen.qvticgmodel.*;

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
			case 0: return createCGConnectionAssignment();
			case 1: return createCGConnectionVariable();
			case 2: return createCGEcoreRealizedVariable();
			case 3: return createCGFunction();
			case 4: return createCGFunctionCallExp();
			case 5: return createCGFunctionParameter();
			case 6: return createCGGuardVariable();
			case 7: return createCGMapping();
			case 8: return createCGMappingCall();
			case 9: return createCGMappingCallBinding();
			case 10: return createCGMappingExp();
			case 11: return createCGMappingLoop();
			case 12: return createCGMiddlePropertyAssignment();
			case 13: return createCGMiddlePropertyCallExp();
			case 14: return createCGRealizedVariable();
			case 15: return createCGRealizedVariablePart();
			case 16: return createCGSpeculateExp();
			case 17: return createCGSpeculatePart();
			case 18: return createCGTransformation();
			case 19: return createCGTypedModel();
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
	public @NonNull CGRealizedVariablePart createCGRealizedVariablePart() {
		CGRealizedVariablePartImpl cgRealizedVariablePart = new CGRealizedVariablePartImpl();
		return cgRealizedVariablePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGSpeculateExp createCGSpeculateExp() {
		CGSpeculateExpImpl cgSpeculateExp = new CGSpeculateExpImpl();
		return cgSpeculateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CGSpeculatePart createCGSpeculatePart() {
		CGSpeculatePartImpl cgSpeculatePart = new CGSpeculatePartImpl();
		return cgSpeculatePart;
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
