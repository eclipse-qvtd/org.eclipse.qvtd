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
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OppositePropertyAssignmentImpl extends NavigationAssignmentImpl implements OppositePropertyAssignment {
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
	protected OppositePropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.OPPOSITE_PROPERTY_ASSIGNMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredTargetProperty() {
		/**
		 * targetProperty.opposite
		 */
		@SuppressWarnings("null")
		final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
		final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Property opposite = targetProperty.getOpposite();
		if (opposite == null) {
			throw new InvalidValueException("Null body for \'qvtcore::OppositePropertyAssignment::getReferredTargetProperty() : Property[1]\'");
		}
		return opposite;
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
		 *     severity : Integer[1] = 'OppositePropertyAssignment::CompatibleTypeForValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = let
		 *           propertyType : Type[?] = getReferredTargetProperty().type
		 *         in
		 *           let valueType : Type[?] = value.type
		 *           in
		 *             valueType.conformsTo(propertyType) or
		 *             propertyType.conformsTo(valueType)
		 *       in
		 *         let
		 *           message : String[?] = if status <> true
		 *           then 'OppositePropertyAssignment::CompatibleTypeForValue: ' + value.type.name + ' must conform to ' +
		 *             getReferredTargetProperty().type.name + ' or vice-versa'
		 *           else null
		 *           endif
		 *         in
		 *           'OppositePropertyAssignment::CompatibleTypeForValue'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_OppositePropertyAssignment_c_c_CompatibleTypeForValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_or;
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
				CAUGHT_or = or;
			}
			catch (Exception e) {
				CAUGHT_or = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_or instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_or;
			}
			final /*@Thrown*/ boolean ne = CAUGHT_or == Boolean.FALSE;
			/*@NonInvalid*/ java.lang.@Nullable String message_0;
			if (ne) {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = value_0.getType();
				if (type == null) {
					throw new InvalidValueException("Null source for \'NamedElement::name\'");
				}
				final /*@Thrown*/ java.lang.@Nullable String name = type.getName();
				final /*@NonInvalid*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_OppositePropertyAssignment_c_c_CompatibleTypeForValue_c_32, name);
				final /*@NonInvalid*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty_0 = this.getReferredTargetProperty();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = getReferredTargetProperty_0.getType();
				if (type_0 == null) {
					throw new InvalidValueException("Null source for \'NamedElement::name\'");
				}
				final /*@Thrown*/ java.lang.@Nullable String name_0 = type_0.getName();
				final /*@NonInvalid*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
				final /*@NonInvalid*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
				message_0 = sum_2;
			}
			else {
				message_0 = null;
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_OppositePropertyAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, message_0, severity_0, CAUGHT_or, QVTcoreTables.INT_0).booleanValue();
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
	public boolean validateOppositePropertyIsImplicit(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv OppositePropertyIsImplicit:
		 *   let
		 *     severity : Integer[1] = 'OppositePropertyAssignment::OppositePropertyIsImplicit'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = targetProperty.isImplicit
		 *       in
		 *         'OppositePropertyAssignment::OppositePropertyIsImplicit'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_OppositePropertyAssignment_c_c_OppositePropertyIsImplicit);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_status;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
				final /*@Thrown*/ java.lang.@Nullable Boolean status = targetProperty.isIsImplicit();
				CAUGHT_status = status;
			}
			catch (Exception e) {
				CAUGHT_status = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_OppositePropertyAssignment_c_c_OppositePropertyIsImplicit, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, QVTcoreTables.INT_0).booleanValue();
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
		 *     severity : Integer[1] = 'OppositePropertyAssignment::TargetPropetyIsSlotProperty'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = slotExpression.type.conformsTo(
		 *           getReferredTargetProperty().owningClass)
		 *       in
		 *         'OppositePropertyAssignment::TargetPropetyIsSlotProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_OppositePropertyAssignment_c_c_TargetPropetyIsSlotProperty);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_status;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression slotExpression = this.getSlotExpression();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = slotExpression.getType();
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = getReferredTargetProperty.getOwningClass();
				final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
				CAUGHT_status = status;
			}
			catch (Exception e) {
				CAUGHT_status = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_OppositePropertyAssignment_c_c_TargetPropetyIsSlotProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, QVTcoreTables.INT_0).booleanValue();
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
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
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
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
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
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
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
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
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
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY:
				return getReferredTargetProperty();
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT__DIAGNOSTICCHAIN_MAP:
				return validateOppositePropertyIsImplicit((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP:
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
		return (R) ((QVTcoreVisitor<?>)visitor).visitOppositePropertyAssignment(this);
	}

} //OppositePropertyAssignmentImpl
