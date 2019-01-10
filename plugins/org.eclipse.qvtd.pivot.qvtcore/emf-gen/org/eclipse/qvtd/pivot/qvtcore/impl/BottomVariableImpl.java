/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.VariableImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BottomVariableImpl extends VariableImpl implements BottomVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BottomVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.BOTTOM_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForInitializer(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv CompatibleTypeForInitializer:
			 *   let
			 *     severity : Integer[1] = 'BottomVariable::CompatibleTypeForInitializer'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedInit <> null implies
			 *         ownedInit.type?.conformsTo(type)
			 *       in
			 *         'BottomVariable::CompatibleTypeForInitializer'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_BottomVariable_c_c_CompatibleTypeForInitializer);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable OCLExpression ownedInit = this.getOwnedInit();
					final /*@NonInvalid*/ boolean ne = ownedInit != null;
					/*@Thrown*/ java.lang.@Nullable Boolean result;
					if (ne) {
						if (ownedInit == null) {
							throw new InvalidValueException("Null source for \'TypedElement::type\'");
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = ownedInit.getType();
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							CAUGHT_type = type;
						}
						catch (Exception e) {
							CAUGHT_type = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object conformsTo = CAUGHT_type == null;
						/*@Thrown*/ java.lang.@Nullable Boolean safe_conformsTo_source;
						if (conformsTo == Boolean.TRUE) {
							safe_conformsTo_source = null;
						}
						else {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = this.getType();
							final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
							safe_conformsTo_source = conformsTo_0;
						}
						result = safe_conformsTo_source;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_BottomVariable_c_c_CompatibleTypeForInitializer, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("BottomVariable::CompatibleTypeForInitializer", this, diagnostics, context, e);
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
			case QVTcorePackage.BOTTOM_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForInitializer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTcoreVisitor<?>)visitor).visitBottomVariable(this);
	}

} //BottomVariableImpl
