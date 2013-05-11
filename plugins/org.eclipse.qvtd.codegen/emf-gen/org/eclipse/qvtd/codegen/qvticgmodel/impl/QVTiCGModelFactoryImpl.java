/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
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
	public static @NonNull QVTiCGModelFactory init() {
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
			case QVTiCGModelPackage.CG_ECORE_PROPERTY_ASSIGNMENT: return createCGEcorePropertyAssignment();
			case QVTiCGModelPackage.CG_ECORE_REALIZED_VARIABLE: return createCGEcoreRealizedVariable();
			case QVTiCGModelPackage.CG_FUNCTION: return createCGFunction();
			case QVTiCGModelPackage.CG_FUNCTION_CALL_EXP: return createCGFunctionCallExp();
			case QVTiCGModelPackage.CG_FUNCTION_PARAMETER: return createCGFunctionParameter();
			case QVTiCGModelPackage.CG_GUARD_VARIABLE: return createCGGuardVariable();
			case QVTiCGModelPackage.CG_MAPPING: return createCGMapping();
			case QVTiCGModelPackage.CG_MAPPING_CALL: return createCGMappingCall();
			case QVTiCGModelPackage.CG_MAPPING_CALL_BINDING: return createCGMappingCallBinding();
			case QVTiCGModelPackage.CG_PREDICATE: return createCGPredicate();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT: return createCGPropertyAssignment();
			case QVTiCGModelPackage.CG_REALIZED_VARIABLE: return createCGRealizedVariable();
			case QVTiCGModelPackage.CG_TRANSFORMATION: return createCGTransformation();
			case QVTiCGModelPackage.CG_TYPED_MODEL: return createCGTypedModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGEcorePropertyAssignment createCGEcorePropertyAssignment() {
		CGEcorePropertyAssignmentImpl cgEcorePropertyAssignment = new CGEcorePropertyAssignmentImpl();
		return cgEcorePropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGEcoreRealizedVariable createCGEcoreRealizedVariable() {
		CGEcoreRealizedVariableImpl cgEcoreRealizedVariable = new CGEcoreRealizedVariableImpl();
		return cgEcoreRealizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGFunction createCGFunction() {
		CGFunctionImpl cgFunction = new CGFunctionImpl();
		return cgFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGFunctionCallExp createCGFunctionCallExp() {
		CGFunctionCallExpImpl cgFunctionCallExp = new CGFunctionCallExpImpl();
		return cgFunctionCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGFunctionParameter createCGFunctionParameter() {
		CGFunctionParameterImpl cgFunctionParameter = new CGFunctionParameterImpl();
		return cgFunctionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGGuardVariable createCGGuardVariable() {
		CGGuardVariableImpl cgGuardVariable = new CGGuardVariableImpl();
		return cgGuardVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGPropertyAssignment createCGPropertyAssignment() {
		CGPropertyAssignmentImpl cgPropertyAssignment = new CGPropertyAssignmentImpl();
		return cgPropertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGMapping createCGMapping() {
		CGMappingImpl cgMapping = new CGMappingImpl();
		return cgMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGTransformation createCGTransformation() {
		CGTransformationImpl cgTransformation = new CGTransformationImpl();
		return cgTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGTypedModel createCGTypedModel() {
		CGTypedModelImpl cgTypedModel = new CGTypedModelImpl();
		return cgTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGMappingCall createCGMappingCall() {
		CGMappingCallImpl cgMappingCall = new CGMappingCallImpl();
		return cgMappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGMappingCallBinding createCGMappingCallBinding() {
		CGMappingCallBindingImpl cgMappingCallBinding = new CGMappingCallBindingImpl();
		return cgMappingCallBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGPredicate createCGPredicate() {
		CGPredicateImpl cgPredicate = new CGPredicateImpl();
		return cgPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public @NonNull CGRealizedVariable createCGRealizedVariable() {
		CGRealizedVariableImpl cgRealizedVariable = new CGRealizedVariableImpl();
		return cgRealizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public static @NonNull QVTiCGModelPackage getPackage() {
		return QVTiCGModelPackage.eINSTANCE;
	}

} //QVTiCGmodelFactoryImpl
