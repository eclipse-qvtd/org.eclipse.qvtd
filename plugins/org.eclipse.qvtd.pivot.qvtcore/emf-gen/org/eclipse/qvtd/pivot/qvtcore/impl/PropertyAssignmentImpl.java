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
import org.eclipse.ocl.pivot.Property;

import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyAssignmentImpl extends NavigationAssignmentImpl implements PropertyAssignment {
	/**
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected Property targetProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.PROPERTY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getTargetProperty() {
		if (targetProperty != null && targetProperty.eIsProxy()) {
			InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
			targetProperty = (Property)eResolveProxy(oldTargetProperty);
			if (targetProperty != oldTargetProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
			}
		}
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetTargetProperty() {
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetProperty(Property newTargetProperty) {
		Property oldTargetProperty = targetProperty;
		targetProperty = newTargetProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredTargetProperty() {
		/**
		 * targetProperty
		 */
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
		return targetProperty;
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
		 *     severity : Integer[1] = 'PropertyAssignment::CompatibleTypeForValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = let
		 *           status : Boolean[?] = let
		 *             propertyType : Type[?] = getReferredTargetProperty().type
		 *           in
		 *             let valueType : Type[?] = value.type
		 *             in
		 *               valueType.conformsTo(propertyType) or
		 *               propertyType.conformsTo(valueType)
		 *         in
		 *           if status = true
		 *           then true
		 *           else
		 *             Tuple{message = 'PropertyAssignment::CompatibleTypeForValue: ' + value.type?.name + ' must conform to ' +
		 *               getReferredTargetProperty().type?.name + ' or vice-versa', status = status
		 *             }
		 *           endif
		 *       in
		 *         'PropertyAssignment::CompatibleTypeForValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_5;
		if (le) {
			symbol_5 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_4;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_propertyType;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type propertyType = getReferredTargetProperty.getType();
					CAUGHT_propertyType = propertyType;
				}
				catch (Exception e) {
					CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @Nullable Object CAUGHT_valueType;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type valueType = value.getType();
					CAUGHT_valueType = valueType;
				}
				catch (Exception e) {
					CAUGHT_valueType = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
				try {
					if (CAUGHT_valueType instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_valueType;
					}
					if (CAUGHT_propertyType instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_propertyType;
					}
					final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, CAUGHT_valueType, CAUGHT_propertyType).booleanValue();
					CAUGHT_conformsTo = conformsTo;
				}
				catch (Exception e) {
					CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo_0;
				try {
					if (CAUGHT_propertyType instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_propertyType;
					}
					if (CAUGHT_valueType instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_valueType;
					}
					final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, CAUGHT_propertyType, CAUGHT_valueType).booleanValue();
					CAUGHT_conformsTo_0 = conformsTo_0;
				}
				catch (Exception e) {
					CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
				final /*@Thrown*/ boolean symbol_0 = or == Boolean.TRUE;
				/*@Thrown*/ java.lang.@NonNull Object symbol_4;
				if (symbol_0) {
					symbol_4 = ValueUtil.TRUE_VALUE;
				}
				else {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = value_0.getType();
					/*@Caught*/ @Nullable Object CAUGHT_type;
					try {
						CAUGHT_type = type;
					}
					catch (Exception e) {
						CAUGHT_type = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @NonNull Object symbol_1 = CAUGHT_type == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source;
					if (symbol_1 == Boolean.TRUE) {
						safe_name_source = null;
					}
					else {
						assert type != null;
						final /*@Thrown*/ java.lang.@Nullable String name = type.getName();
						safe_name_source = name;
					}
					final /*@NonInvalid*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForValue_c_32, safe_name_source);
					final /*@NonInvalid*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty_0 = this.getReferredTargetProperty();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = getReferredTargetProperty_0.getType();
					/*@Caught*/ @Nullable Object CAUGHT_type_0;
					try {
						CAUGHT_type_0 = type_0;
					}
					catch (Exception e) {
						CAUGHT_type_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ @NonNull Object symbol_2 = CAUGHT_type_0 == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source_0;
					if (symbol_2 == Boolean.TRUE) {
						safe_name_source_0 = null;
					}
					else {
						assert type_0 != null;
						final /*@Thrown*/ java.lang.@Nullable String name_0 = type_0.getName();
						safe_name_source_0 = name_0;
					}
					final /*@NonInvalid*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
					final /*@NonInvalid*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_3 = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, or);
					symbol_4 = symbol_3;
				}
				CAUGHT_symbol_4 = symbol_4;
			}
			catch (Exception e) {
				CAUGHT_symbol_4 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_4, QVTcoreTables.INT_0).booleanValue();
			symbol_5 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePropertyIsNotImplicit(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv PropertyIsNotImplicit:
		 *   let
		 *     severity : Integer[1] = 'PropertyAssignment::PropertyIsNotImplicit'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = not targetProperty.isImplicit
		 *       in
		 *         'PropertyAssignment::PropertyIsNotImplicit'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_PropertyIsNotImplicit);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_isImplicit;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
					final /*@Thrown*/ java.lang.@Nullable Boolean isImplicit = targetProperty.isIsImplicit();
					CAUGHT_isImplicit = isImplicit;
				}
				catch (Exception e) {
					CAUGHT_isImplicit = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_isImplicit);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_PropertyIsNotImplicit, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetPropetyIsSlotProperty(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TargetPropetyIsSlotProperty:
		 *   let
		 *     severity : Integer[1] = 'PropertyAssignment::TargetPropetyIsSlotProperty'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = slotExpression.type.conformsTo(
		 *           getReferredTargetProperty().owningClass)
		 *       in
		 *         'PropertyAssignment::TargetPropetyIsSlotProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_TargetPropetyIsSlotProperty);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression slotExpression = this.getSlotExpression();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = slotExpression.getType();
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = getReferredTargetProperty.getOwningClass();
				final /*@Thrown*/ boolean result = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_TargetPropetyIsSlotProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
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
			case QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				setTargetProperty((Property)newValue);
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
			case QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				setTargetProperty((Property)null);
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
			case QVTcorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				return targetProperty != null;
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
			case QVTcorePackage.PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY:
				return getReferredTargetProperty();
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP:
				return validatePropertyIsNotImplicit((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP:
				return validateTargetPropetyIsSlotProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTcoreVisitor<?>)visitor).visitPropertyAssignment(this);
	}

} //PropertyAssignmentImpl
