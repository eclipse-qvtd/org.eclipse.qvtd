/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContentsOperation;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionElementTypeProperty;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;
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
	 * The number of structural features of the '<em>Set Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SET_STATEMENT_FEATURE_COUNT = ObservableStatementImpl.OBSERVABLE_STATEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Set Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SET_STATEMENT_OPERATION_COUNT = ObservableStatementImpl.OBSERVABLE_STATEMENT_OPERATION_COUNT + 5;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldTargetVariable, targetVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldTargetVariable, targetVariable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldTargetProperty, targetProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldTargetProperty, targetProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldIsPartial, isPartial));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldIsOpposite, isOpposite));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldIsNotify, isNotify));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, oldOwnedExpression, newOwnedExpression);
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
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, newOwnedExpression, newOwnedExpression));
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
		final /*@NonInvalid*/ @NonNull Property targetProperty = this.getTargetProperty();
		final /*@NonInvalid*/ boolean isOpposite = this.isIsOpposite();
		/*@NonInvalid*/ @Nullable Property IF_isOpposite;
		if (isOpposite) {
			final /*@NonInvalid*/ @Nullable Property opposite = targetProperty.getOpposite();
			IF_isOpposite = opposite;
		}
		else {
			IF_isOpposite = targetProperty;
		}
		return IF_isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleClassForProperty(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "SetStatement::CompatibleClassForProperty";
		try {
			/**
			 *
			 * inv CompatibleClassForProperty:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *               status : Boolean[?] = actualType?.conformsTo(requiredType)
			 *             in
			 *               if status = true
			 *               then true
			 *               else
			 *                 Tuple{status = status, message = 'SetStatement::CompatibleClassForProperty: ' + actualType?.name + ' must conform to ' + requiredType?.name
			 *                 }
			 *               endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.SET_STATEMENT___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = resolvedProperty.getOwningClass();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull VariableDeclaration targetVariable = this.getTargetVariable();
				final /*@NonInvalid*/ @Nullable Type type = targetVariable.getType();
				final /*@NonInvalid*/ boolean IsEQ2_ = type == null;
				/*@Caught*/ @Nullable Object IF_IsEQ2_;
				if (IsEQ2_) {
					IF_IsEQ2_ = null;
				}
				else {
					/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
					try {
						if (type == null) {
							throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
						}
						final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
						CAUGHT_conformsTo = conformsTo;
					}
					catch (Exception THROWN_CAUGHT_conformsTo) {
						CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
					}
					IF_IsEQ2_ = CAUGHT_conformsTo;
				}
				/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
				try {
					if (IF_IsEQ2_ instanceof InvalidValueException) {
						throw (InvalidValueException)IF_IsEQ2_;
					}
					final /*@Thrown*/ @Nullable Boolean THROWN_IF_IsEQ2_ = (Boolean)IF_IsEQ2_;
					final /*@Thrown*/ boolean IsEQ_ = THROWN_IF_IsEQ2_ == Boolean.TRUE;
					CAUGHT_IsEQ_ = IsEQ_;
				}
				catch (Exception THROWN_CAUGHT_IsEQ_) {
					CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
				}
				/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
				if (CAUGHT_IsEQ_ == Boolean.TRUE) {
					IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
				}
				else {
					/*@Caught*/ @NonNull Object CAUGHT_sum;
					try {
						final /*@NonInvalid*/ boolean IsEQ2__0 = type == null;
						/*@Thrown*/ @Nullable String IF_IsEQ2__0;
						if (IsEQ2__0) {
							IF_IsEQ2__0 = null;
						}
						else {
							assert type != null;
							final /*@Thrown*/ @Nullable String name = type.getName();
							IF_IsEQ2__0 = name;
						}
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleClassForProperty_c_32, IF_IsEQ2__0);
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
						final /*@NonInvalid*/ boolean IsEQ2__1 = owningClass == null;
						/*@Thrown*/ @Nullable String IF_IsEQ2__1;
						if (IsEQ2__1) {
							IF_IsEQ2__1 = null;
						}
						else {
							assert owningClass != null;
							final /*@Thrown*/ @Nullable String name_0 = owningClass.getName();
							IF_IsEQ2__1 = name_0;
						}
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, IF_IsEQ2__1);
						CAUGHT_sum = sum;
					}
					catch (Exception THROWN_CAUGHT_sum) {
						CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
					}
					final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, CAUGHT_sum, IF_IsEQ2_);
					IF_CAUGHT_IsEQ_ = TUP_;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_CAUGHT_IsEQ_, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForPartialValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "SetStatement::CompatibleTypeForPartialValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForPartialValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *                 status : Boolean[?] = actualType?.conformsTo(requiredType)
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
				/*@Caught*/ @NonNull Object IF_isPartial;
				if (isPartial) {
					/*@Caught*/ @NonNull Object CAUGHT_elementType;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTimperativeTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
						final /*@NonInvalid*/ @Nullable Type type = resolvedProperty.getType();
						final /*@Thrown*/ @Nullable CollectionType oclAsType = (@Nullable CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType);
						if (oclAsType == null) {
							throw new InvalidValueException("Null source for \'CollectionType::elementType\'");
						}
						final /*@Thrown*/ @NonNull Type elementType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTimperativeTables.CLSSid_Type, oclAsType);
						CAUGHT_elementType = elementType;
					}
					catch (Exception THROWN_CAUGHT_elementType) {
						CAUGHT_elementType = ValueUtil.createInvalidValue(THROWN_CAUGHT_elementType);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ @Nullable Type type_0 = ownedExpression.getType();
					final /*@NonInvalid*/ boolean IsEQ2_ = type_0 == null;
					/*@Caught*/ @Nullable Object IF_IsEQ2_;
					if (IsEQ2_) {
						IF_IsEQ2_ = null;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							if (type_0 == null) {
								throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
							}
							if (CAUGHT_elementType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_elementType;
							}
							final /*@Thrown*/ @NonNull Type THROWN_elementType = (@NonNull Type)CAUGHT_elementType;
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, THROWN_elementType).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception THROWN_CAUGHT_conformsTo) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
						}
						IF_IsEQ2_ = CAUGHT_conformsTo;
					}
					/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
					try {
						if (IF_IsEQ2_ instanceof InvalidValueException) {
							throw (InvalidValueException)IF_IsEQ2_;
						}
						final /*@Thrown*/ @Nullable Boolean THROWN_IF_IsEQ2_ = (Boolean)IF_IsEQ2_;
						final /*@Thrown*/ boolean IsEQ_ = THROWN_IF_IsEQ2_ == Boolean.TRUE;
						CAUGHT_IsEQ_ = IsEQ_;
					}
					catch (Exception THROWN_CAUGHT_IsEQ_) {
						CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
					}
					/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
					if (CAUGHT_IsEQ_ == Boolean.TRUE) {
						IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_sum;
						try {
							final /*@NonInvalid*/ boolean IsEQ2__0 = type_0 == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								assert type_0 != null;
								final /*@Thrown*/ @Nullable String name = type_0.getName();
								IF_IsEQ2__0 = name;
							}
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForPartialValue_c_32, IF_IsEQ2__0);
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
							if (CAUGHT_elementType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_elementType;
							}
							final /*@Thrown*/ @NonNull Type THROWN_elementType_0 = (@NonNull Type)CAUGHT_elementType;
							final /*@Thrown*/ @Nullable String name_0 = THROWN_elementType_0.getName();
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
							CAUGHT_sum = sum;
						}
						catch (Exception THROWN_CAUGHT_sum) {
							CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
						}
						final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, CAUGHT_sum, IF_IsEQ2_);
						IF_CAUGHT_IsEQ_ = TUP_;
					}
					IF_isPartial = IF_CAUGHT_IsEQ_;
				}
				else {
					IF_isPartial = ValueUtil.TRUE_VALUE;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_isPartial, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForTotalValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "SetStatement::CompatibleTypeForTotalValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForTotalValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *                 status : Boolean[?] = actualType?.conformsTo(requiredType)
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.SET_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
				final /*@NonInvalid*/ @Nullable Boolean not;
				if (!isPartial) {
					not = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isPartial) {
						not = ValueUtil.FALSE_VALUE;
					}
					else {
						not = null;
					}
				}
				if (not == null) {
					throw new InvalidValueException("Null if condition");
				}
				/*@Caught*/ @NonNull Object IF_not;
				if (not) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
					final /*@NonInvalid*/ @Nullable Type type = resolvedProperty.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ @Nullable Type type_0 = ownedExpression.getType();
					final /*@NonInvalid*/ boolean IsEQ2_ = type_0 == null;
					/*@Caught*/ @Nullable Object IF_IsEQ2_;
					if (IsEQ2_) {
						IF_IsEQ2_ = null;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							if (type_0 == null) {
								throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, type).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception THROWN_CAUGHT_conformsTo) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
						}
						IF_IsEQ2_ = CAUGHT_conformsTo;
					}
					/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
					try {
						if (IF_IsEQ2_ instanceof InvalidValueException) {
							throw (InvalidValueException)IF_IsEQ2_;
						}
						final /*@Thrown*/ @Nullable Boolean THROWN_IF_IsEQ2_ = (Boolean)IF_IsEQ2_;
						final /*@Thrown*/ boolean IsEQ_ = THROWN_IF_IsEQ2_ == Boolean.TRUE;
						CAUGHT_IsEQ_ = IsEQ_;
					}
					catch (Exception THROWN_CAUGHT_IsEQ_) {
						CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
					}
					/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
					if (CAUGHT_IsEQ_ == Boolean.TRUE) {
						IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_sum;
						try {
							final /*@NonInvalid*/ boolean IsEQ2__0 = type_0 == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								assert type_0 != null;
								final /*@Thrown*/ @Nullable String name = type_0.getName();
								IF_IsEQ2__0 = name;
							}
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_SetStatement_c_c_CompatibleTypeForTotalValue_c_32, IF_IsEQ2__0);
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__32_must_32_conform_32_to_32);
							final /*@NonInvalid*/ boolean IsEQ2__1 = type == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__1;
							if (IsEQ2__1) {
								IF_IsEQ2__1 = null;
							}
							else {
								assert type != null;
								final /*@Thrown*/ @Nullable String name_0 = type.getName();
								IF_IsEQ2__1 = name_0;
							}
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, IF_IsEQ2__1);
							CAUGHT_sum = sum;
						}
						catch (Exception THROWN_CAUGHT_sum) {
							CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
						}
						final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, CAUGHT_sum, IF_IsEQ2_);
						IF_CAUGHT_IsEQ_ = TUP_;
					}
					IF_not = IF_CAUGHT_IsEQ_;
				}
				else {
					IF_not = ValueUtil.TRUE_VALUE;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_not, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateValueDoesNotNavigateFromRealizedVariables(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "SetStatement::ValueDoesNotNavigateFromRealizedVariables";
		try {
			/**
			 *
			 * inv ValueDoesNotNavigateFromRealizedVariables:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.SET_STATEMENT___VALIDATE_VALUE_DOES_NOT_NAVIGATE_FROM_REALIZED_VARIABLES__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_isEmpty;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_VariableExp = idResolver.getClass(QVTimperativeTables.CLSSid_VariableExp, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTimperativeTables.SET_CLSSid_OCLExpression, ownedExpression);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure = executor.getStaticTypeOfValue(null, oclAsSet);
					final @NonNull LibraryIterationExtension IMPL_closure = (LibraryIterationExtension)TYPE_closure.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
					final @NonNull Object ACC_closure = IMPL_closure.createAccumulatorValue(executor, QVTimperativeTables.SET_CLSSid_OclElement, QVTimperativeTables.SET_CLSSid_OclElement);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure = new AbstractBinaryOperation() {
						/**
						 * e.oclContents()
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object e) {
							if (e == null) {
								throw new InvalidValueException("Null \'\'OclElement\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @NonNull SetValue oclContents = ClassifierOclContentsOperation.INSTANCE.evaluate(executor, QVTimperativeTables.SET_CLSSid_OclElement, e);
							return oclContents;
						}
					};
					final @NonNull ExecutorSingleIterationManager MGR_closure = new ExecutorSingleIterationManager(executor, QVTimperativeTables.SET_CLSSid_OclElement, BODY_closure, oclAsSet, ACC_closure);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure.evaluateIteration(MGR_closure);
					final /*@Thrown*/ @NonNull SetValue selectByKind = (@Nullable SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_VariableExp);
					/*@NonInvalid*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_VariableExp);
					@NonNull Iterator<Object> ITER__1 = selectByKind.iterator();
					/*@Thrown*/ @NonNull SetValue select_0;
					while (true) {
						if (!ITER__1.hasNext()) {
							select_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull VariableExp _1 = (@NonNull VariableExp)ITER__1.next();
						/**
						 * referredVariable.oclIsKindOf(NewStatement)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtimperative_c_c_NewStatement = idResolver.getClass(QVTimperativeTables.CLSSid_NewStatement, null);
						final /*@NonInvalid*/ @Nullable VariableDeclaration referredVariable = _1.getReferredVariable();
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredVariable, TYP_qvtimperative_c_c_NewStatement).booleanValue();
						//
						if (oclIsKindOf == ValueUtil.TRUE_VALUE) {
							accumulator.add(_1);
						}
					}
					/*@NonInvalid*/ @NonNull Accumulator accumulator_0 = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_VariableExp);
					@NonNull Iterator<Object> ITER_s = select_0.iterator();
					/*@Thrown*/ @NonNull SetValue select;
					while (true) {
						if (!ITER_s.hasNext()) {
							select = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull VariableExp s = (@NonNull VariableExp)ITER_s.next();
						/**
						 *
						 * s.oclContainer()
						 * .oclIsKindOf(CallExp) and
						 * s.oclContainer()
						 * .oclAsType(CallExp).ownedSource = s
						 */
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CallExp = idResolver.getClass(QVTimperativeTables.CLSSid_CallExp, null);
							final /*@NonInvalid*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, s);
							final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_CallExp).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf_0;
						}
						catch (Exception THROWN_CAUGHT_oclIsKindOf) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(THROWN_CAUGHT_oclIsKindOf);
						}
						final /*@Thrown*/ @Nullable Boolean and;
						if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CallExp_0 = idResolver.getClass(QVTimperativeTables.CLSSid_CallExp, null);
								final /*@NonInvalid*/ @Nullable Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, s);
								final /*@Thrown*/ @Nullable CallExp oclAsType = (@Nullable CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_CallExp_0);
								if (oclAsType == null) {
									throw new InvalidValueException("Null source for \'CallExp::ownedSource\'");
								}
								final /*@Thrown*/ @Nullable OCLExpression ownedSource = oclAsType.getOwnedSource();
								final /*@Thrown*/ boolean IsEQ_ = s.equals(ownedSource);
								CAUGHT_IsEQ_ = IsEQ_;
							}
							catch (Exception THROWN_CAUGHT_IsEQ_) {
								CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
							}
							if (CAUGHT_IsEQ_ == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf;
								}
								if (CAUGHT_IsEQ_ instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_IsEQ_;
								}
								and = ValueUtil.TRUE_VALUE;
							}
						}
						if (and == null) {
							throw new InvalidValueException("Null body for \'Set(T).select(Set.T[?] | Lambda T() : Boolean[1]) : Set(T)\'");
						}
						//
						if (and == ValueUtil.TRUE_VALUE) {
							accumulator_0.add(s);
						}
					}
					final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(select).booleanValue();
					CAUGHT_isEmpty = isEmpty;
				}
				catch (Exception THROWN_CAUGHT_isEmpty) {
					CAUGHT_isEmpty = ValueUtil.createInvalidValue(THROWN_CAUGHT_isEmpty);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_isEmpty, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateTargetPropertyIsNotReadOnly(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "SetStatement::TargetPropertyIsNotReadOnly";
		try {
			/**
			 *
			 * inv TargetPropertyIsNotReadOnly:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not resolvedProperty.isReadOnly
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.SET_STATEMENT___VALIDATE_TARGET_PROPERTY_IS_NOT_READ_ONLY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
				final /*@NonInvalid*/ boolean isReadOnly = resolvedProperty.isIsReadOnly();
				final /*@NonInvalid*/ @Nullable Boolean not;
				if (!isReadOnly) {
					not = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isReadOnly) {
						not = ValueUtil.FALSE_VALUE;
					}
					else {
						not = null;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, not, QVTimperativeTables.INT_0).booleanValue();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return isIsPartial();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isIsNotify();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return isIsOpposite();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return getOwnedExpression();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setTargetVariable((VariableDeclaration)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setTargetProperty((Property)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setIsPartial((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsNotify((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setIsOpposite((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setTargetVariable((VariableDeclaration)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setTargetProperty((Property)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setIsPartial(IS_PARTIAL_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsNotify(IS_NOTIFY_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return targetVariable != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return targetProperty != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return isPartial != IS_PARTIAL_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isNotify != IS_NOTIFY_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return ownedExpression != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1:
				return validateCompatibleClassForProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2:
				return validateCompatibleTypeForPartialValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 3:
				return validateCompatibleTypeForTotalValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 4:
				return validateValueDoesNotNavigateFromRealizedVariables((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 5:
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
		if (visitor instanceof QVTimperativeVisitor) {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitSetStatement(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //SetStatementImpl
