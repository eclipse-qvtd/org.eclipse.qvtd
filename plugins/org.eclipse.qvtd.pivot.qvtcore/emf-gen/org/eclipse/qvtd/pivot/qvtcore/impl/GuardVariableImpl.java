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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.VariableImpl;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GuardVariableImpl extends VariableImpl implements GuardVariable {
	/**
	 * The number of structural features of the '<em>Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_VARIABLE_FEATURE_COUNT = VariableImpl.VARIABLE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_VARIABLE_OPERATION_COUNT = VariableImpl.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.GUARD_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNoInitializer(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "GuardVariable::NoInitializer";
		try {
			/**
			 *
			 * inv NoInitializer:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = ownedInit = null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.GUARD_VARIABLE___VALIDATE_NO_INITIALIZER__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable OCLExpression ownedInit = this.getOwnedInit();
				final /*@NonInvalid*/ boolean result = ownedInit == null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case VariableImpl.VARIABLE_OPERATION_COUNT + 0:
				return validateNoInitializer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
			return (R) ((QVTcoreVisitor<?>)visitor).visitGuardVariable(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //GuardVariableImpl
