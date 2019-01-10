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
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.Nameable;
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
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForPartialValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv CompatibleTypeForPartialValue:
			 *   let
			 *     severity : Integer[1] = 'PropertyAssignment::CompatibleTypeForPartialValue'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = if isPartial
			 *         then
			 *           let
			 *             propertyType : Type[1] = getReferredTargetProperty()
			 *             .type.oclAsType(CollectionType).elementType
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               let
			 *                 status : Boolean[?] = valueType.conformsTo(propertyType) or
			 *                 propertyType.conformsTo(valueType)
			 *               in
			 *                 if status = true
			 *                 then true
			 *                 else
			 *                   Tuple{status = status, message = 'PropertyAssignment::CompatibleTypeForPartialValue: ' + valueType?.name + ' must conform to ' + propertyType.name + ' or vice-versa'
			 *                   }
			 *                 endif
			 *         else true
			 *         endif
			 *       in
			 *         'PropertyAssignment::CompatibleTypeForPartialValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ @NonNull Object symbol_2;
			if (le) {
				symbol_2 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
					/*@Thrown*/ @NonNull Object result;
					if (isPartial) {
						/*@Caught*/ @NonNull Object CAUGHT_propertyType;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTcoreTables.CLSSid_CollectionType, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = getReferredTargetProperty.getType();
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType = (org.eclipse.ocl.pivot.@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0);
							@SuppressWarnings("null")
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type propertyType = oclAsType.getElementType();
							CAUGHT_propertyType = propertyType;
						}
						catch (Exception e) {
							CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
						}
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type valueType = value.getType();
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							if (CAUGHT_propertyType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_propertyType;
							}
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, CAUGHT_propertyType).booleanValue();
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
							final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, CAUGHT_propertyType, valueType).booleanValue();
							CAUGHT_conformsTo_0 = conformsTo_0;
						}
						catch (Exception e) {
							CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
						final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
						/*@Thrown*/ @NonNull Object symbol_1;
						if (eq) {
							symbol_1 = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ @NonNull Object name = valueType == null;
							/*@Thrown*/ java.lang.@Nullable String safe_name_source;
							if (name == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert valueType != null;
								final /*@Thrown*/ java.lang.@Nullable String name_0 = valueType.getName();
								safe_name_source = name_0;
							}
							final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32, safe_name_source);
							final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							if (CAUGHT_propertyType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_propertyType;
							}
							final /*@Thrown*/ java.lang.@Nullable String name_1 = ((Nameable)CAUGHT_propertyType).getName();
							final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_1);
							final /*@Thrown*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
							symbol_1 = symbol_0;
						}
						result = symbol_1;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
				symbol_2 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_2;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("PropertyAssignment::CompatibleTypeForPartialValue", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForTotalValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv CompatibleTypeForTotalValue:
			 *   let
			 *     severity : Integer[1] = 'PropertyAssignment::CompatibleTypeForTotalValue'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = if not isPartial
			 *         then
			 *           let propertyType : Type[?] = getReferredTargetProperty().type
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               let
			 *                 status : Boolean[?] = valueType.conformsTo(propertyType) or
			 *                 propertyType.conformsTo(valueType)
			 *               in
			 *                 if status = true
			 *                 then true
			 *                 else
			 *                   Tuple{status = status, message = 'PropertyAssignment::CompatibleTypeForTotalValue: ' + valueType?.name + ' must conform to ' + propertyType?.name + ' or vice-versa'
			 *                   }
			 *                 endif
			 *         else true
			 *         endif
			 *       in
			 *         'PropertyAssignment::CompatibleTypeForTotalValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ @NonNull Object symbol_2;
			if (le) {
				symbol_2 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isPartial);
					if (not == null) {
						throw new InvalidValueException("Null if condition");
					}
					/*@Thrown*/ @NonNull Object result;
					if (not) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type propertyType = getReferredTargetProperty.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type valueType = value.getType();
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, propertyType).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception e) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
						}
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo_0;
						try {
							final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, propertyType, valueType).booleanValue();
							CAUGHT_conformsTo_0 = conformsTo_0;
						}
						catch (Exception e) {
							CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
						final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
						/*@Thrown*/ @NonNull Object symbol_1;
						if (eq) {
							symbol_1 = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ @NonNull Object name = valueType == null;
							/*@Thrown*/ java.lang.@Nullable String safe_name_source;
							if (name == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert valueType != null;
								final /*@Thrown*/ java.lang.@Nullable String name_0 = valueType.getName();
								safe_name_source = name_0;
							}
							final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32, safe_name_source);
							final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							final /*@NonInvalid*/ @NonNull Object name_1 = propertyType == null;
							/*@Thrown*/ java.lang.@Nullable String safe_name_source_0;
							if (name_1 == Boolean.TRUE) {
								safe_name_source_0 = null;
							}
							else {
								assert propertyType != null;
								final /*@Thrown*/ java.lang.@Nullable String name_2 = propertyType.getName();
								safe_name_source_0 = name_2;
							}
							final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
							final /*@Thrown*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
							symbol_1 = symbol_0;
						}
						result = symbol_1;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
				symbol_2 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_2;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("PropertyAssignment::CompatibleTypeForTotalValue", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePropertyIsNotImplicit(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
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
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty = this.getTargetProperty();
				final /*@NonInvalid*/ boolean isImplicit = targetProperty.isIsImplicit();
				final /*@NonInvalid*/ java.lang.@Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(isImplicit);
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_PropertyIsNotImplicit, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("PropertyAssignment::PropertyIsNotImplicit", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetPropertyIsSlotProperty(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv TargetPropertyIsSlotProperty:
			 *   let
			 *     severity : Integer[1] = 'PropertyAssignment::TargetPropertyIsSlotProperty'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = slotExpression.type.conformsTo(
			 *           getReferredTargetProperty().owningClass)
			 *       in
			 *         'PropertyAssignment::TargetPropertyIsSlotProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcoreTables.STR_PropertyAssignment_c_c_TargetPropertyIsSlotProperty);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression slotExpression = this.getSlotExpression();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = slotExpression.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = getReferredTargetProperty.getOwningClass();
					final /*@Thrown*/ boolean result = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTcoreTables.STR_PropertyAssignment_c_c_TargetPropertyIsSlotProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("PropertyAssignment::TargetPropertyIsSlotProperty", this, diagnostics, context, e);
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
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForPartialValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForTotalValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP:
				return validatePropertyIsNotImplicit((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTcorePackage.PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPERTY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP:
				return validateTargetPropertyIsSlotProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
