/**
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtcore.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;

import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl#getTargetVariable <em>Target Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableAssignmentImpl extends AssignmentImpl implements VariableAssignment {
	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_ASSIGNMENT_FEATURE_COUNT = AssignmentImpl.ASSIGNMENT_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_ASSIGNMENT_OPERATION_COUNT = AssignmentImpl.ASSIGNMENT_OPERATION_COUNT + 1;
	/**
	 * The cached value of the '{@link #getTargetVariable() <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration targetVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.VARIABLE_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getTargetVariable() {
		if (targetVariable != null && targetVariable.eIsProxy()) {
			InternalEObject oldTargetVariable = (InternalEObject)targetVariable;
			targetVariable = (VariableDeclaration)eResolveProxy(oldTargetVariable);
			if (targetVariable != oldTargetVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldTargetVariable, targetVariable));
			}
		}
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetTargetVariable() {
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetVariable(VariableDeclaration newTargetVariable) {
		VariableDeclaration oldTargetVariable = targetVariable;
		targetVariable = newTargetVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 4, oldTargetVariable, targetVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "VariableAssignment::CompatibleTypeForValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[?] = targetVariable.type?.conformsTo(value.type) or
			 *           value.type?.conformsTo(targetVariable.type)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = 'VariableAssignment::CompatibleTypeForValue: ' + value.type?.name + ' must conform to ' + targetVariable.type?.name + ' or vice-versa', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_eq;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
					try {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable = this.getTargetVariable();
						final /*@NonInvalid*/ @Nullable Type type = targetVariable.getType();
						final /*@NonInvalid*/ @NonNull Object conformsTo = type == null;
						/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
						if (conformsTo == Boolean.TRUE) {
							safe_conformsTo_source = null;
						}
						else {
							if (type == null) {
								throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
							final /*@NonInvalid*/ @Nullable Type type_0 = value.getType();
							final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
							safe_conformsTo_source = conformsTo_0;
						}
						CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
					}
					catch (Exception e) {
						CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean status;
					if (CAUGHT_safe_conformsTo_source == ValueUtil.TRUE_VALUE) {
						status = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source_0;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
							final /*@NonInvalid*/ @Nullable Type type_1 = value_0.getType();
							final /*@NonInvalid*/ @NonNull Object conformsTo_1 = type_1 == null;
							/*@Thrown*/ @Nullable Boolean safe_conformsTo_source_0;
							if (conformsTo_1 == Boolean.TRUE) {
								safe_conformsTo_source_0 = null;
							}
							else {
								if (type_1 == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable_0 = this.getTargetVariable();
								final /*@NonInvalid*/ @Nullable Type type_2 = targetVariable_0.getType();
								final /*@Thrown*/ boolean conformsTo_2 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_1, type_2).booleanValue();
								safe_conformsTo_source_0 = conformsTo_2;
							}
							CAUGHT_safe_conformsTo_source_0 = safe_conformsTo_source_0;
						}
						catch (Exception e) {
							CAUGHT_safe_conformsTo_source_0 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_safe_conformsTo_source_0 == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_safe_conformsTo_source instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_safe_conformsTo_source;
							}
							if (CAUGHT_safe_conformsTo_source_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_safe_conformsTo_source_0;
							}
							if ((CAUGHT_safe_conformsTo_source == null) || (CAUGHT_safe_conformsTo_source_0 == null)) {
								status = null;
							}
							else {
								status = ValueUtil.FALSE_VALUE;
							}
						}
					}
					final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
					/*@Thrown*/ @NonNull Object IF_eq;
					if (eq) {
						IF_eq = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value_1 = this.getValue();
						final /*@NonInvalid*/ @Nullable Type type_3 = value_1.getType();
						final /*@NonInvalid*/ @NonNull Object name = type_3 == null;
						/*@Thrown*/ @Nullable String safe_name_source;
						if (name == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert type_3 != null;
							final /*@Thrown*/ @Nullable String name_0 = type_3.getName();
							safe_name_source = name_0;
						}
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32, safe_name_source);
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable_1 = this.getTargetVariable();
						final /*@NonInvalid*/ @Nullable Type type_4 = targetVariable_1.getType();
						final /*@NonInvalid*/ @NonNull Object name_1 = type_4 == null;
						/*@Thrown*/ @Nullable String safe_name_source_0;
						if (name_1 == Boolean.TRUE) {
							safe_name_source_0 = null;
						}
						else {
							assert type_4 != null;
							final /*@Thrown*/ @Nullable String name_2 = type_4.getName();
							safe_name_source_0 = name_2;
						}
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
						final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
						IF_eq = TUP_;
					}
					CAUGHT_IF_eq = IF_eq;
				}
				catch (Exception e) {
					CAUGHT_IF_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_eq, QVTcoreTables.INT_0).booleanValue();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setTargetVariable((VariableDeclaration)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				setTargetVariable((VariableDeclaration)null);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return targetVariable != null;
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
			case ElementImpl.ELEMENT_OPERATION_COUNT + 0:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		if (visitor instanceof QVTcoreVisitor) {
			return (R) ((QVTcoreVisitor<?>)visitor).visitVariableAssignment(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public boolean isIsRequired() {
		return targetVariable != null && targetVariable.isIsRequired();
	}
} //VariableAssignmentImpl
