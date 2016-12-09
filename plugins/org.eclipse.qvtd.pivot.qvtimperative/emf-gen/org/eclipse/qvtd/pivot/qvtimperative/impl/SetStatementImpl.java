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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsNotify <em>Is Notify</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetStatementImpl extends ObservableStatementImpl implements SetStatement {
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
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected Property targetProperty;

	/**
	 * The default value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean isOpposite = IS_OPPOSITE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsNotify() <em>Is Notify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNotify()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NOTIFY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsNotify() <em>Is Notify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNotify()
	 * @generated
	 * @ordered
	 */
	protected boolean isNotify = IS_NOTIFY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.SET_STATEMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOpposite() {
		return isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOpposite(boolean newIsOpposite) {
		boolean oldIsOpposite = isOpposite;
		isOpposite = newIsOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE, oldIsOpposite, isOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNotify() {
		return isNotify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNotify(boolean newIsNotify) {
		boolean oldIsNotify = isNotify;
		isNotify = newIsNotify;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__IS_NOTIFY, oldIsNotify, isNotify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(OCLExpression newOwnedExpression, NotificationChain msgs) {
		OCLExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedExpression(OCLExpression newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompatibleClassForProperty(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleClassForProperty:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::CompatibleClassForProperty'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = let
		 *           propertySourceType : Type[?] = if isOpposite
		 *           then targetProperty.type
		 *           else targetProperty.owningClass
		 *           endif
		 *         in
		 *           targetVariable.type.conformsTo(propertySourceType)
		 *       in
		 *         'SetStatement::CompatibleClassForProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty_0 = this.getTargetProperty();
				final /*@Thrown*/ java.lang.@Nullable Boolean isOpposite = this.isIsOpposite();
				if (isOpposite == null) {
					throw new InvalidValueException("Null if condition");
				}
				/*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type propertySourceType;
				if (isOpposite) {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = targetProperty_0.getType();
					propertySourceType = type;
				}
				else {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = targetProperty_0.getOwningClass();
					propertySourceType = owningClass;
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration targetVariable = this.getTargetVariable();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = targetVariable.getType();
				final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, propertySourceType).booleanValue();
				CAUGHT_conformsTo = conformsTo;
			}
			catch (Exception e) {
				CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_conformsTo, QVTimperativeTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForValue:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::CompatibleTypeForValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = let
		 *           propertyTargetType : Type[?] = if isOpposite
		 *           then targetProperty.owningClass
		 *           else targetProperty.type
		 *           endif
		 *         in
		 *           ownedExpression.type.conformsTo(propertyTargetType)
		 *       in
		 *         'SetStatement::CompatibleTypeForValue'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty_0 = this.getTargetProperty();
				final /*@Thrown*/ java.lang.@Nullable Boolean isOpposite = this.isIsOpposite();
				if (isOpposite == null) {
					throw new InvalidValueException("Null if condition");
				}
				/*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type propertyTargetType;
				if (isOpposite) {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = targetProperty_0.getOwningClass();
					propertyTargetType = owningClass;
				}
				else {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = targetProperty_0.getType();
					propertyTargetType = type;
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression ownedExpression = this.getOwnedExpression();
				final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = ownedExpression.getType();
				final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, propertyTargetType).booleanValue();
				CAUGHT_conformsTo = conformsTo;
			}
			catch (Exception e) {
				CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_conformsTo, QVTimperativeTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isIsOpposite();
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				return isIsNotify();
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				return getOwnedExpression();
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
			case QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((VariableDeclaration)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				setTargetProperty((Property)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				setIsNotify((Boolean)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)newValue);
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
			case QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((VariableDeclaration)null);
				return;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				setTargetProperty((Property)null);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				setIsNotify(IS_NOTIFY_EDEFAULT);
				return;
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				setOwnedExpression((OCLExpression)null);
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
			case QVTimperativePackage.SET_STATEMENT__TARGET_VARIABLE:
				return targetVariable != null;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				return targetProperty != null;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				return isNotify != IS_NOTIFY_EDEFAULT;
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				return ownedExpression != null;
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
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleClassForProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP:
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitSetStatement(this);
	}

} //SetStatementImpl
