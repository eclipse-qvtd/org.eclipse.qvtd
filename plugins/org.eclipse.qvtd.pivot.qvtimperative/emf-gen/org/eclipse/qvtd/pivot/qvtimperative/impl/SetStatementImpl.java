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
import java.util.Iterator;
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
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsPartial <em>Is Partial</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsNotify <em>Is Notify</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getResolvedProperty <em>Resolved Property</em>}</li>
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
	 * The default value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PARTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean isPartial = IS_PARTIAL_EDEFAULT;

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
	public boolean isIsPartial() {
		return isPartial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPartial(boolean newIsPartial) {
		boolean oldIsPartial = isPartial;
		isPartial = newIsPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__IS_PARTIAL, oldIsPartial, isPartial));
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
	@Override
	public Property getResolvedProperty() {
		/**
		 * if isOpposite then targetProperty.opposite else targetProperty endif
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property targetProperty_0 = this.getTargetProperty();
		final /*@NonInvalid*/ boolean isOpposite = this.isIsOpposite();
		/*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property symbol_0;
		if (isOpposite) {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property opposite = targetProperty_0.getOpposite();
			symbol_0 = opposite;
		}
		else {
			symbol_0 = targetProperty_0;
		}
		if (symbol_0 == null) {
			throw new InvalidValueException("Null body for \'qvtimperative::SetStatement::resolvedProperty\'");
		}
		return symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		 *         result : OclAny[1] = let requiredType : Class[?] = resolvedProperty.owningClass
		 *         in
		 *           let actualType : Type[?] = targetVariable.type
		 *           in
		 *             let
		 *               status : Boolean[1] = actualType.conformsTo(requiredType)
		 *             in
		 *               if status = true
		 *               then true
		 *               else
		 *                 Tuple{status = status, message = 'SetStatement::CompatibleClassForProperty: ' + actualType?.name + ' must conform to ' + requiredType?.name
		 *                 }
		 *               endif
		 *       in
		 *         'SetStatement::CompatibleClassForProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_4;
		if (le) {
			symbol_4 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class requiredType = resolvedProperty.getOwningClass();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration targetVariable = this.getTargetVariable();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type actualType = targetVariable.getType();
				final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, actualType, requiredType).booleanValue();
				/*@Thrown*/ java.lang.@NonNull Object symbol_3;
				if (status) {
					symbol_3 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @NonNull Object symbol_0 = actualType == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source;
					if (symbol_0 == Boolean.TRUE) {
						safe_name_source = null;
					}
					else {
						assert actualType != null;
						final /*@Thrown*/ java.lang.@Nullable String name = actualType.getName();
						safe_name_source = name;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty_c_32, safe_name_source);
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
					final /*@NonInvalid*/ @NonNull Object symbol_1 = requiredType == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source_0;
					if (symbol_1 == Boolean.TRUE) {
						safe_name_source_0 = null;
					}
					else {
						assert requiredType != null;
						final /*@Thrown*/ java.lang.@Nullable String name_0 = requiredType.getName();
						safe_name_source_0 = name_0;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_2 = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, sum_1, status);
					symbol_3 = symbol_2;
				}
				CAUGHT_symbol_3 = symbol_3;
			}
			catch (Exception e) {
				CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_3, QVTimperativeTables.INT_0).booleanValue();
			symbol_4 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForPartialValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForPartialValue:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::CompatibleTypeForPartialValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = if isPartial
		 *         then
		 *           let
		 *             requiredType : Type[1] = resolvedProperty.type.oclAsType(CollectionType).elementType
		 *           in
		 *             let actualType : Type[?] = ownedExpression.type
		 *             in
		 *               let
		 *                 status : Boolean[1] = actualType.conformsTo(requiredType)
		 *               in
		 *                 if status = true
		 *                 then true
		 *                 else
		 *                   Tuple{status = status, message = 'SetStatement::CompatibleTypeForPartialValue: ' + actualType?.name + ' must conform to ' + requiredType.name
		 *                   }
		 *                 endif
		 *         else true
		 *         endif
		 *       in
		 *         'SetStatement::CompatibleTypeForPartialValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForPartialValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_3;
		if (le) {
			symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
				/*@Thrown*/ java.lang.@NonNull Object result;
				if (isPartial) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTimperativeTables.CLSSid_CollectionType, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = resolvedProperty.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0));
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type requiredType = oclAsType.getElementType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type actualType = ownedExpression.getType();
					final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, actualType, requiredType).booleanValue();
					/*@Thrown*/ java.lang.@NonNull Object symbol_2;
					if (status) {
						symbol_2 = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ @NonNull Object symbol_0 = actualType == null;
						/*@Thrown*/ java.lang.@Nullable String safe_name_source;
						if (symbol_0 == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert actualType != null;
							final /*@Thrown*/ java.lang.@Nullable String name = actualType.getName();
							safe_name_source = name;
						}
						final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForPartialValue_c_32, safe_name_source);
						final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
						final /*@Thrown*/ java.lang.@Nullable String name_0 = requiredType.getName();
						final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_1 = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, sum_1, status);
						symbol_2 = symbol_1;
					}
					result = symbol_2;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForPartialValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForTotalValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForTotalValue:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::CompatibleTypeForTotalValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = if not isPartial
		 *         then
		 *           let requiredType : Type[?] = resolvedProperty.type
		 *           in
		 *             let actualType : Type[?] = ownedExpression.type
		 *             in
		 *               let
		 *                 status : Boolean[1] = actualType.conformsTo(requiredType)
		 *               in
		 *                 if status = true
		 *                 then true
		 *                 else
		 *                   Tuple{status = status, message = 'SetStatement::CompatibleTypeForTotalValue: ' + actualType?.name + ' must conform to ' + requiredType?.name
		 *                   }
		 *                 endif
		 *         else true
		 *         endif
		 *       in
		 *         'SetStatement::CompatibleTypeForTotalValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForTotalValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_4;
		if (le) {
			symbol_4 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
				final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isPartial);
				if (not == null) {
					throw new InvalidValueException("Null if condition");
				}
				/*@Thrown*/ java.lang.@NonNull Object result;
				if (not) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type requiredType = resolvedProperty.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type actualType = ownedExpression.getType();
					final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, actualType, requiredType).booleanValue();
					/*@Thrown*/ java.lang.@NonNull Object symbol_3;
					if (status) {
						symbol_3 = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ @NonNull Object symbol_0 = actualType == null;
						/*@Thrown*/ java.lang.@Nullable String safe_name_source;
						if (symbol_0 == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert actualType != null;
							final /*@Thrown*/ java.lang.@Nullable String name = actualType.getName();
							safe_name_source = name;
						}
						final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForTotalValue_c_32, safe_name_source);
						final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
						final /*@NonInvalid*/ @NonNull Object symbol_1 = requiredType == null;
						/*@Thrown*/ java.lang.@Nullable String safe_name_source_0;
						if (symbol_1 == Boolean.TRUE) {
							safe_name_source_0 = null;
						}
						else {
							assert requiredType != null;
							final /*@Thrown*/ java.lang.@Nullable String name_0 = requiredType.getName();
							safe_name_source_0 = name_0;
						}
						final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_2 = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, sum_1, status);
						symbol_3 = symbol_2;
					}
					result = symbol_3;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForTotalValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
			symbol_4 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateValueDoesNotNavigateFromRealizedVariables(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv ValueDoesNotNavigateFromRealizedVariables:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::ValueDoesNotNavigateFromRealizedVariables'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = ownedExpression->closure(e | e.oclContents())
		 *         ->selectByKind(VariableExp)
		 *         ->select(referredVariable.oclIsKindOf(NewStatement))
		 *         ->select(s |
		 *           s.oclContainer()
		 *           .oclIsKindOf(CallExp) and
		 *           s.oclContainer()
		 *           .oclAsType(CallExp).ownedSource = s)
		 *         ->isEmpty()
		 *       in
		 *         'SetStatement::ValueDoesNotNavigateFromRealizedVariables'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_ValueDoesNotNavigateFromRealizedVariables);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_VariableExp = idResolver.getClass(QVTimperativeTables.CLSSid_VariableExp, null);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression ownedExpression = this.getOwnedExpression();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTimperativeTables.SET_CLSSid_OCLExpression, ownedExpression);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
				final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
				final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, QVTimperativeTables.SET_CLSSid_OclElement, QVTimperativeTables.SET_CLSSid_OclElement);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
					/**
					 * e.oclContents()
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@Nullable Object e_0) {
						final /*@NonInvalid*/ java.lang.@Nullable Object symbol_0 = (Object)e_0;
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclContents = ClassifierOclContentsOperation.INSTANCE.evaluate(executor, QVTimperativeTables.SET_CLSSid_OclElement, symbol_0);
						return oclContents;
					}
				};
				final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, QVTimperativeTables.SET_CLSSid_OclElement, BODY_closure_0, oclAsSet, ACC_closure_0);
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue selectByKind = (SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_VariableExp);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_VariableExp);
				@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue select_0;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						select_0 = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp _1 = (VariableExp)ITERATOR__1.next();
					/**
					 * referredVariable.oclIsKindOf(NewStatement)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtimperative_c_c_NewStatement = idResolver.getClass(QVTimperativeTables.CLSSid_NewStatement, null);
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable VariableDeclaration referredVariable = _1.getReferredVariable();
					final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredVariable, TYP_qvtimperative_c_c_NewStatement).booleanValue();
					//
					if (oclIsKindOf == ValueUtil.TRUE_VALUE) {
						accumulator.add(_1);
					}
				}
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_VariableExp);
				@NonNull Iterator<Object> ITERATOR_s = select_0.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue select;
				while (true) {
					if (!ITERATOR_s.hasNext()) {
						select = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableExp s = (VariableExp)ITERATOR_s.next();
					/**
					 *
					 * s.oclContainer()
					 * .oclIsKindOf(CallExp) and
					 * s.oclContainer()
					 * .oclAsType(CallExp).ownedSource = s
					 */
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CallExp = idResolver.getClass(QVTimperativeTables.CLSSid_CallExp, null);
						final /*@NonInvalid*/ java.lang.@Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, s);
						final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_CallExp).booleanValue();
						CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_eq;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CallExp_0 = idResolver.getClass(QVTimperativeTables.CLSSid_CallExp, null);
						final /*@NonInvalid*/ java.lang.@Nullable Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, s);
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CallExp oclAsType = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_CallExp_0));
						final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable OCLExpression ownedSource = oclAsType.getOwnedSource();
						final /*@Thrown*/ boolean eq = s.equals(ownedSource);
						CAUGHT_eq = eq;
					}
					catch (Exception e) {
						CAUGHT_eq = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ java.lang.@Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf_0, CAUGHT_eq);
					if (and == null) {
						throw new InvalidValueException("Null body for \'Set(T).select(Set.T[?] | Lambda T() : Boolean[1]) : Set(T)\'");
					}
					//
					if (and == ValueUtil.TRUE_VALUE) {
						accumulator_0.add(s);
					}
				}
				final /*@Thrown*/ boolean result = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_ValueDoesNotNavigateFromRealizedVariables, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
			symbol_1 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetPropertyIsNotReadOnly(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TargetPropertyIsNotReadOnly:
		 *   let
		 *     severity : Integer[1] = 'SetStatement::TargetPropertyIsNotReadOnly'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = not resolvedProperty.isReadOnly
		 *       in
		 *         'SetStatement::TargetPropertyIsNotReadOnly'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SetStatement_c_c_TargetPropertyIsNotReadOnly);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
			final /*@NonInvalid*/ boolean isReadOnly = resolvedProperty.isIsReadOnly();
			final /*@NonInvalid*/ java.lang.@Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(isReadOnly);
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SetStatement_c_c_TargetPropertyIsNotReadOnly, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTimperativeTables.INT_0).booleanValue();
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
			case QVTimperativePackage.SET_STATEMENT__IS_PARTIAL:
				return isIsPartial();
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				return isIsNotify();
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isIsOpposite();
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				return getOwnedExpression();
			case QVTimperativePackage.SET_STATEMENT__RESOLVED_PROPERTY:
				return getResolvedProperty();
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
			case QVTimperativePackage.SET_STATEMENT__IS_PARTIAL:
				setIsPartial((Boolean)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				setIsNotify((Boolean)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
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
			case QVTimperativePackage.SET_STATEMENT__IS_PARTIAL:
				setIsPartial(IS_PARTIAL_EDEFAULT);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				setIsNotify(IS_NOTIFY_EDEFAULT);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
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
			case QVTimperativePackage.SET_STATEMENT__IS_PARTIAL:
				return isPartial != IS_PARTIAL_EDEFAULT;
			case QVTimperativePackage.SET_STATEMENT__IS_NOTIFY:
				return isNotify != IS_NOTIFY_EDEFAULT;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case QVTimperativePackage.SET_STATEMENT__OWNED_EXPRESSION:
				return ownedExpression != null;
			case QVTimperativePackage.SET_STATEMENT__RESOLVED_PROPERTY:
				return getResolvedProperty() != null;
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
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForPartialValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForTotalValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_VALUE_DOES_NOT_NAVIGATE_FROM_REALIZED_VARIABLES__DIAGNOSTICCHAIN_MAP:
				return validateValueDoesNotNavigateFromRealizedVariables((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.SET_STATEMENT___VALIDATE_TARGET_PROPERTY_IS_NOT_READ_ONLY__DIAGNOSTICCHAIN_MAP:
				return validateTargetPropertyIsNotReadOnly((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
