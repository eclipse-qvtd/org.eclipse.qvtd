/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl;

import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl#getContextType <em>Context Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImperativeTransformationImpl extends TransformationImpl implements ImperativeTransformation {
	/**
	 * The number of structural features of the '<em>Imperative Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IMPERATIVE_TRANSFORMATION_FEATURE_COUNT = TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Imperative Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IMPERATIVE_TRANSFORMATION_OPERATION_COUNT = TransformationImpl.TRANSFORMATION_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class contextType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getContextType() {
		if (contextType != null && contextType.eIsProxy()) {
			InternalEObject oldContextType = (InternalEObject)contextType;
			contextType = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldContextType);
			if (contextType != oldContextType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0, oldContextType, contextType));
			}
		}
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetContextType() {
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContextType(org.eclipse.ocl.pivot.Class newContextType) {
		org.eclipse.ocl.pivot.Class oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0, oldContextType, contextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAllRulesAreMappings(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "ImperativeTransformation::AllRulesAreMappings";
		try {
			/**
			 *
			 * inv AllRulesAreMappings:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = rule->forAll(oclIsKindOf(Mapping))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION___VALIDATE_ALL_RULES_ARE_MAPPINGS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @NonNull List<Rule> rule = this.getRule();
				final /*@NonInvalid*/ @NonNull SetValue BOXED_rule = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_Rule, rule);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITER__1 = BOXED_rule.iterator();
				/*@NonInvalid*/ @Nullable Boolean forAll;
				while (true) {
					if (!ITER__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Rule _1 = (@NonNull Rule)ITER__1.next();
					/**
					 * oclIsKindOf(Mapping)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtimperative_c_c_Mapping = idResolver.getClass(QVTimperativeTables.CLSSid_Mapping, null);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, TYP_qvtimperative_c_c_Mapping).booleanValue();
					//
					if (!oclIsKindOf) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (oclIsKindOf) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, forAll, QVTimperativeTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateUniqueTargetNames(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "ImperativeTransformation::UniqueTargetNames";
		try {
			/**
			 *
			 * inv UniqueTargetNames:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = rule->selectByKind(EntryPoint)
			 *         ->select(targetName <> null)
			 *         ->isUnique(targetName)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.IMPERATIVE_TRANSFORMATION___VALIDATE_UNIQUE_TARGET_NAMES__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_isUnique;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtimperative_c_c_EntryPoint = idResolver.getClass(QVTimperativeTables.CLSSid_EntryPoint, null);
					final /*@NonInvalid*/ @NonNull List<Rule> rule = this.getRule();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_rule = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_Rule, rule);
					final /*@NonInvalid*/ @NonNull SetValue selectByKind = (@Nullable SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_rule, TYP_qvtimperative_c_c_EntryPoint);
					/*@NonInvalid*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_EntryPoint);
					@NonNull Iterator<Object> ITER__1 = selectByKind.iterator();
					/*@NonInvalid*/ @NonNull SetValue select;
					while (true) {
						if (!ITER__1.hasNext()) {
							select = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull EntryPoint _1 = (@NonNull EntryPoint)ITER__1.next();
						/**
						 * targetName <> null
						 */
						final /*@NonInvalid*/ @Nullable String targetName = _1.getTargetName();
						final /*@NonInvalid*/ boolean IsEQ_ = targetName != null;
						//
						if (IsEQ_) {
							accumulator.add(_1);
						}
					}
					/*@NonInvalid*/ @NonNull Accumulator accumulator_0 = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_EntryPoint);
					@NonNull Iterator<Object> ITER__1_0 = select.iterator();
					/*@Thrown*/ boolean isUnique;
					while (true) {
						if (!ITER__1_0.hasNext()) {
							isUnique = true;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull EntryPoint _1_0 = (@NonNull EntryPoint)ITER__1_0.next();
						/**
						 * targetName
						 */
						final /*@NonInvalid*/ @Nullable String targetName_0 = _1_0.getTargetName();
						//
						if (accumulator_0.includes(targetName_0) == ValueUtil.TRUE_VALUE) {
							isUnique = false;
							break;			// Abort after second find
						}
						else {
							accumulator_0.add(targetName_0);
						}
					}
					CAUGHT_isUnique = isUnique;
				}
				catch (Exception THROWN_CAUGHT_isUnique) {
					CAUGHT_isUnique = ValueUtil.createInvalidValue(THROWN_CAUGHT_isUnique);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_isUnique, QVTimperativeTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0:
				if (resolve) return getContextType();
				return basicGetContextType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0:
				setContextType((org.eclipse.ocl.pivot.Class)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0:
				setContextType((org.eclipse.ocl.pivot.Class)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0:
				return contextType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TransformationImpl.TRANSFORMATION_OPERATION_COUNT + 0:
				return validateAllRulesAreMappings((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case TransformationImpl.TRANSFORMATION_OPERATION_COUNT + 1:
				return validateUniqueTargetNames((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTimperativeVisitor) {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitImperativeTransformation(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //ImperativeTransformationImpl
