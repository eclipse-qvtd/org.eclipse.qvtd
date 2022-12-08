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
import org.eclipse.ocl.pivot.ids.IdResolver;
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
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreSupport;
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
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTcoreSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_or;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable_0 = this.getTargetVariable();
					final /*@NonInvalid*/ @Nullable Type type = targetVariable_0.getType();
					final /*@NonInvalid*/ @Nullable Type type_0 = value_0.getType();
					final /*@NonInvalid*/ Boolean IsEQ2_ = type == null;
					/*@Caught*/ @Nullable Object IF_IsEQ2_;
					if (IsEQ2_) {
						IF_IsEQ2_ = null;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_conformsTo;
						try {
							if (type == null) {
								throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' elementId");
							}
							final /*@Thrown*/ Boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception THROWN_CAUGHT_conformsTo) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
						}
						IF_IsEQ2_ = CAUGHT_conformsTo;
					}
					final /*@Thrown*/ @Nullable Boolean or;
					if (IF_IsEQ2_ == ValueUtil.TRUE_VALUE) {
						or = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ Boolean IsEQ2__0 = type_0 == null;
						/*@Caught*/ @Nullable Object IF_IsEQ2__0;
						if (IsEQ2__0) {
							IF_IsEQ2__0 = null;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_conformsTo_0;
							try {
								if (type_0 == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' elementId");
								}
								final /*@Thrown*/ Boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, type).booleanValue();
								CAUGHT_conformsTo_0 = conformsTo_0;
							}
							catch (Exception THROWN_CAUGHT_conformsTo_0) {
								CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo_0);
							}
							IF_IsEQ2__0 = CAUGHT_conformsTo_0;
						}
						if (IF_IsEQ2__0 == ValueUtil.TRUE_VALUE) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							if (IF_IsEQ2_ instanceof InvalidValueException) {
								throw (InvalidValueException)IF_IsEQ2_;
							}
							if (IF_IsEQ2__0 instanceof InvalidValueException) {
								throw (InvalidValueException)IF_IsEQ2__0;
							}
							if ((IF_IsEQ2_ == null) || (IF_IsEQ2__0 == null)) {
								or = null;
							}
							else {
								or = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_or = or;
				}
				catch (Exception THROWN_CAUGHT_or) {
					CAUGHT_or = ValueUtil.createInvalidValue(THROWN_CAUGHT_or);
				}
				/*@Caught*/ @Nullable Object CAUGHT_IsEQ_;
				try {
					if (CAUGHT_or instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_or;
					}
					final /*@Thrown*/ @Nullable Boolean THROWN_or = (Boolean)CAUGHT_or;
					final /*@Thrown*/ boolean IsEQ_ = THROWN_or == Boolean.TRUE;
					CAUGHT_IsEQ_ = IsEQ_;
				}
				catch (Exception THROWN_CAUGHT_IsEQ_) {
					CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
				}
				/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
				if (CAUGHT_IsEQ_ == Boolean.TRUE) {
					IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
				}
				else {
					/*@Caught*/ @Nullable Object CAUGHT_sum;
					try {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value_1 = this.getValue();
						final /*@NonInvalid*/ @Nullable Type type_1 = value_1.getType();
						final /*@NonInvalid*/ Boolean IsEQ2__1 = type_1 == null;
						/*@Thrown*/ @Nullable String IF_IsEQ2__1;
						if (IsEQ2__1) {
							IF_IsEQ2__1 = null;
						}
						else {
							assert type_1 != null;
							final /*@Thrown*/ @Nullable String name = type_1.getName();
							IF_IsEQ2__1 = name;
						}
						final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(QVTcoreSupport.STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32, IF_IsEQ2__1);
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_2, QVTcoreSupport.STR__32_must_32_conform_32_to_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable_1 = this.getTargetVariable();
						final /*@NonInvalid*/ @Nullable Type type_2 = targetVariable_1.getType();
						final /*@NonInvalid*/ Boolean IsEQ2__2 = type_2 == null;
						/*@Thrown*/ @Nullable String IF_IsEQ2__2;
						if (IsEQ2__2) {
							IF_IsEQ2__2 = null;
						}
						else {
							assert type_2 != null;
							final /*@Thrown*/ @Nullable String name_0 = type_2.getName();
							IF_IsEQ2__2 = name_0;
						}
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, IF_IsEQ2__2);
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTcoreSupport.STR__32_or_32_vice_m_versa);
						CAUGHT_sum = sum;
					}
					catch (Exception THROWN_CAUGHT_sum) {
						CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
					}
					final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTcoreSupport.TUPLid_, CAUGHT_sum, CAUGHT_or);
					IF_CAUGHT_IsEQ_ = TUP_;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_CAUGHT_IsEQ_, QVTcoreSupport.INT_0).booleanValue();
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
