/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl#getObservedProperties <em>Observed Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl#isIsContained <em>Is Contained</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewStatementImpl extends VariableStatementImpl implements NewStatement {
	/**
	 * The number of structural features of the '<em>New Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEW_STATEMENT_FEATURE_COUNT = VariableStatementImpl.VARIABLE_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>New Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEW_STATEMENT_OPERATION_COUNT = VariableStatementImpl.VARIABLE_STATEMENT_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getObservedProperties() <em>Observed Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> observedProperties;

	/**
	 * The default value of the '{@link #isIsContained() <em>Is Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContained()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONTAINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsContained() <em>Is Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContained()
	 * @generated
	 * @ordered
	 */
	protected boolean isContained = IS_CONTAINED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredTypedModel() <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModel()
	 * @generated
	 * @ordered
	 */
	protected ImperativeTypedModel referredTypedModel;

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
	protected NewStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.NEW_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getObservedProperties() {
		if (observedProperties == null) {
			observedProperties = new EObjectResolvingEList<Property>(Property.class, this, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0);
		}
		return observedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsContained() {
		return isContained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsContained(boolean newIsContained) {
		boolean oldIsContained = isContained;
		isContained = newIsContained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1, oldIsContained, isContained));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImperativeTypedModel getReferredTypedModel() {
		if (referredTypedModel != null && referredTypedModel.eIsProxy()) {
			InternalEObject oldReferredTypedModel = (InternalEObject)referredTypedModel;
			referredTypedModel = (ImperativeTypedModel)eResolveProxy(oldReferredTypedModel);
			if (referredTypedModel != oldReferredTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, oldReferredTypedModel, referredTypedModel));
			}
		}
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeTypedModel basicGetReferredTypedModel() {
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTypedModel(ImperativeTypedModel newReferredTypedModel) {
		ImperativeTypedModel oldReferredTypedModel = referredTypedModel;
		referredTypedModel = newReferredTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, oldReferredTypedModel, referredTypedModel));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3, oldOwnedExpression, newOwnedExpression);
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
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "NewStatement::CompatibleTypeForValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedExpression <> null implies
			 *         ownedExpression.type?.conformsTo(type)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			/*@Caught*/ @NonNull Object CAUGHT_severity_0;
			try {
				final /*@Thrown*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.NEW_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
				CAUGHT_severity_0 = severity_0;
			}
			catch (Exception e) {
				CAUGHT_severity_0 = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_severity_0 instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_severity_0;
			}
			final /*@Thrown*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, CAUGHT_severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ boolean ne = ownedExpression != null;
					/*@Thrown*/ @Nullable Boolean result;
					if (ne) {
						if (ownedExpression == null) {
							throw new InvalidValueException("Null source for \'TypedElement::type\'");
						}
						final /*@Thrown*/ @Nullable Type type = ownedExpression.getType();
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							CAUGHT_type = type;
						}
						catch (Exception e) {
							CAUGHT_type = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object conformsTo = CAUGHT_type == null;
						/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
						if (conformsTo == Boolean.TRUE) {
							safe_conformsTo_source = null;
						}
						else {
							final /*@NonInvalid*/ @Nullable Type type_0 = this.getType();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
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
	public boolean validateNonDataTypeForType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "NewStatement::NonDataTypeForType";
		try {
			/**
			 *
			 * inv NonDataTypeForType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not type.oclIsKindOf(DataType)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_severity_0;
			try {
				final /*@Thrown*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.NEW_STATEMENT___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP);
				CAUGHT_severity_0 = severity_0;
			}
			catch (Exception e) {
				CAUGHT_severity_0 = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_severity_0 instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_severity_0;
			}
			final /*@Thrown*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, CAUGHT_severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_DataType = idResolver.getClass(QVTimperativeTables.CLSSid_DataType, null);
					final /*@NonInvalid*/ @Nullable Type type = this.getType();
					final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_DataType).booleanValue();
					CAUGHT_oclIsKindOf = oclIsKindOf;
				}
				catch (Exception e) {
					CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ @Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf);
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, result, QVTimperativeTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0:
				return getObservedProperties();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				return isIsContained();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
				return getOwnedExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0:
				getObservedProperties().clear();
				getObservedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				setIsContained((Boolean)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				setReferredTypedModel((ImperativeTypedModel)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0:
				getObservedProperties().clear();
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				setIsContained(IS_CONTAINED_EDEFAULT);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				setReferredTypedModel((ImperativeTypedModel)null);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0:
				return observedProperties != null && !observedProperties.isEmpty();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				return isContained != IS_CONTAINED_EDEFAULT;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				return referredTypedModel != null;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ObservableStatement.class) {
			switch (derivedFeatureID) {
				case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ObservableStatement.class) {
			switch (baseFeatureID) {
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0: return VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 1:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 2:
				return validateNonDataTypeForType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitNewStatement(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}

} //NewStatementImpl
