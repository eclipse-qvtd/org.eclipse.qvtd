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
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
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
