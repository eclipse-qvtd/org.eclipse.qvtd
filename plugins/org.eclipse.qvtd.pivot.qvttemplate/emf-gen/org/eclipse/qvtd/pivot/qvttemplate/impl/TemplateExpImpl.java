/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.impl;

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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.LiteralExpImpl;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.TemplateExpImpl#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.TemplateExpImpl#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TemplateExpImpl extends LiteralExpImpl implements TemplateExp {
	/**
	 * The number of structural features of the '<em>Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_EXP_FEATURE_COUNT = LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_EXP_OPERATION_COUNT = LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getBindsTo() <em>Binds To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindsTo()
	 * @generated
	 * @ordered
	 */
	protected Variable bindsTo;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression where;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtemplatePackage.Literals.TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getBindsTo() {
		if (bindsTo != null && bindsTo.eIsProxy()) {
			InternalEObject oldBindsTo = (InternalEObject)bindsTo;
			bindsTo = (Variable)eResolveProxy(oldBindsTo);
			if (bindsTo != oldBindsTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0, oldBindsTo, bindsTo));
			}
		}
		return bindsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetBindsTo() {
		return bindsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBindsTo(Variable newBindsTo) {
		Variable oldBindsTo = bindsTo;
		bindsTo = newBindsTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0, oldBindsTo, bindsTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(OCLExpression newWhere, NotificationChain msgs) {
		OCLExpression oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1, oldWhere, newWhere);
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
	public void setWhere(OCLExpression newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1), null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateWhereIsBoolean(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv WhereIsBoolean:
			 *   let severity : Integer[1] = 'TemplateExp::WhereIsBoolean'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = where <> null implies where.type = Boolean
			 *       in
			 *         'TemplateExp::WhereIsBoolean'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_TemplateExp_c_c_WhereIsBoolean);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable OCLExpression where = this.getWhere();
					final /*@NonInvalid*/ boolean ne = where != null;
					/*@Thrown*/ boolean result;
					if (ne) {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_Boolean = idResolver.getClass(TypeId.BOOLEAN, null);
						if (where == null) {
							throw new InvalidValueException("Null source for \'TypedElement::type\'");
						}
						final /*@Thrown*/ @Nullable Type type = where.getType();
						final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == TYP_Boolean.getTypeId()) : false;
						result = eq;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_TemplateExp_c_c_WhereIsBoolean, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTtemplateTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TemplateExp::WhereIsBoolean", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1:
				return basicSetWhere(null, msgs);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0:
				if (resolve) return getBindsTo();
				return basicGetBindsTo();
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1:
				return getWhere();
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0:
				setBindsTo((Variable)newValue);
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1:
				setWhere((OCLExpression)newValue);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0:
				setBindsTo((Variable)null);
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1:
				setWhere((OCLExpression)null);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 0:
				return bindsTo != null;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 1:
				return where != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ReferringElement.class) {
			switch (baseOperationID) {
				case 0: return LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 1:
				return validateWhereIsBoolean((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 0:
				return getReferredElement();
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public Element getReferredElement() {
		return getBindsTo();
	}
} //TemplateExpImpl
