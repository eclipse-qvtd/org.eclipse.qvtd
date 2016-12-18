/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.Variable;

import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
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
	 * The cached value of the '{@link #getTargetVariable() <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable targetVariable;

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
	public Variable getTargetVariable() {
		if (targetVariable != null && targetVariable.eIsProxy()) {
			InternalEObject oldTargetVariable = (InternalEObject)targetVariable;
			targetVariable = (Variable)eResolveProxy(oldTargetVariable);
			if (targetVariable != oldTargetVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
			}
		}
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetTargetVariable() {
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetVariable(Variable newTargetVariable) {
		Variable oldTargetVariable = targetVariable;
		targetVariable = newTargetVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForValue:
		 *   let
		 *     severity : Integer[1] = 'VariableAssignment::CompatibleTypeForValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = let
		 *           status : Boolean[?] = targetVariable.type.conformsTo(value.type) or
		 *           value.type.conformsTo(targetVariable.type)
		 *         in
		 *           if status = true
		 *           then true
		 *           else
		 *             Tuple{message = 'VariableAssignment::CompatibleTypeForValue: ' + value.type.name + ' must conform to ' + targetVariable.type.name + ' or vice-versa', status = status
		 *             }
		 *           endif
		 *       in
		 *         'VariableAssignment::CompatibleTypeForValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_VariableAssignment_c_c_CompatibleTypeForValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_3;
		if (le) {
			symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
			try {
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Variable targetVariable = this.getTargetVariable();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = targetVariable.getType();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = value.getType();
					final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
					CAUGHT_conformsTo = conformsTo;
				}
				catch (Exception e) {
					CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo_0;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_1 = value_0.getType();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Variable targetVariable_0 = this.getTargetVariable();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_2 = targetVariable_0.getType();
					final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_1, type_2).booleanValue();
					CAUGHT_conformsTo_0 = conformsTo_0;
				}
				catch (Exception e) {
					CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
				final /*@Thrown*/ boolean symbol_0 = status == Boolean.TRUE;
				/*@Thrown*/ java.lang.@NonNull Object symbol_2;
				if (symbol_0) {
					symbol_2 = ValueUtil.TRUE_VALUE;
				}
				else {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_1 = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_3 = value_1.getType();
					if (type_3 == null) {
						throw new InvalidValueException("Null source for \'NamedElement::name\'");
					}
					final /*@Thrown*/ java.lang.@Nullable String name = type_3.getName();
					final /*@NonInvalid*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_VariableAssignment_c_c_CompatibleTypeForValue_c_32, name);
					final /*@NonInvalid*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Variable targetVariable_1 = this.getTargetVariable();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_4 = targetVariable_1.getType();
					if (type_4 == null) {
						throw new InvalidValueException("Null source for \'NamedElement::name\'");
					}
					final /*@Thrown*/ java.lang.@Nullable String name_0 = type_4.getName();
					final /*@NonInvalid*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
					final /*@NonInvalid*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_1 = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
					symbol_2 = symbol_1;
				}
				CAUGHT_symbol_2 = symbol_2;
			}
			catch (Exception e) {
				CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_VariableAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_2, QVTcoreTables.INT_0).booleanValue();
			symbol_3 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE:
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
			case QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE:
				setTargetVariable((Variable)newValue);
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
			case QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE:
				setTargetVariable((Variable)null);
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
			case QVTcorePackage.VARIABLE_ASSIGNMENT__TARGET_VARIABLE:
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
			case QVTcorePackage.VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP:
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
		return (R) ((QVTcoreVisitor<?>)visitor).visitVariableAssignment(this);
	}

} //VariableAssignmentImpl
