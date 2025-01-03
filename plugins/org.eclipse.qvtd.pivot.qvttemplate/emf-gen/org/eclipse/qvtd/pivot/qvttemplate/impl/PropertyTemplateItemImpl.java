/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.LiteralExpImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionElementTypeProperty;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getObjContainer <em>Obj Container</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getResolvedProperty <em>Resolved Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyTemplateItemImpl extends ElementImpl implements PropertyTemplateItem {
	/**
	 * The number of structural features of the '<em>Property Template Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_TEMPLATE_ITEM_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Property Template Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_TEMPLATE_ITEM_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression value;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyTemplateItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateExp getObjContainer() {
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 0)) return null;
		return (ObjectTemplateExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjContainer(ObjectTemplateExp newObjContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjContainer, ElementImpl.ELEMENT_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjContainer(ObjectTemplateExp newObjContainer) {
		if (newObjContainer != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 0) && newObjContainer != null)) {
			if (EcoreUtil.isAncestor(this, newObjContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjContainer != null)
				msgs = ((InternalEObject)newObjContainer).eInverseAdd(this, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2, ObjectTemplateExp.class, msgs);
			msgs = basicSetObjContainer(newObjContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, newObjContainer, newObjContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
		OCLExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldValue, newValue);
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
	public void setValue(OCLExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 2), null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ElementImpl.ELEMENT_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, newValue, newValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, oldIsOpposite, isOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getResolvedProperty() {
		/**
		 * if isOpposite then referredProperty.opposite else referredProperty endif
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Property referredProperty_0 = this.getReferredProperty();
		final /*@NonInvalid*/ boolean isOpposite = this.isIsOpposite();
		/*@NonInvalid*/ @Nullable Property IF_isOpposite;
		if (isOpposite) {
			final /*@NonInvalid*/ @Nullable Property opposite = referredProperty_0.getOpposite();
			IF_isOpposite = opposite;
		}
		else {
			IF_isOpposite = referredProperty_0;
		}
		if (IF_isOpposite == null) {
			throw new InvalidValueException("Null body for \'qvttemplate::PropertyTemplateItem::resolvedProperty\'");
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
		final @NonNull String constraintName = "PropertyTemplateItem::CompatibleClassForProperty";
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
			 *         result : OclAny[1] = let
			 *           status : Boolean[1] = objContainer.referredClass.conformsTo(resolvedProperty.owningClass)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = objContainer.referredClass.name + ' must conform to ' + resolvedProperty.owningClass?.name, status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_status;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull ObjectTemplateExp objContainer = this.getObjContainer();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = resolvedProperty.getOwningClass();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class referredClass = objContainer.getReferredClass();
					final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, referredClass, owningClass).booleanValue();
					/*@Thrown*/ @NonNull Object IF_status;
					if (status) {
						IF_status = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ @Nullable String name = referredClass.getName();
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
						final /*@NonInvalid*/ @NonNull Object name_0 = owningClass == null;
						/*@Thrown*/ @Nullable String safe_name_source;
						if (name_0 == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert owningClass != null;
							final /*@Thrown*/ @Nullable String name_1 = owningClass.getName();
							safe_name_source = name_1;
						}
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, safe_name_source);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_0, status);
						IF_status = TUP_;
					}
					CAUGHT_IF_status = IF_status;
				}
				catch (Exception e) {
					CAUGHT_IF_status = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_status, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForObjectValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyTemplateItem::CompatibleTypeForObjectValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForObjectValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[?] = not resolvedProperty.type.oclIsKindOf(CollectionType) implies
			 *           let propertyType : Type[?] = resolvedProperty.type
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               valueType?.conformsTo(propertyType) or
			 *               propertyType?.conformsTo(valueType)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = value.type?.name + ' must conform to ' + resolvedProperty.type?.name + ' or vice-versa', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_OBJECT_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_eq;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_not;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
							final /*@NonInvalid*/ @Nullable Type type = resolvedProperty.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_oclIsKindOf;
						}
						final /*@Thrown*/ @Nullable Boolean not;
						if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
							not = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
								not = ValueUtil.FALSE_VALUE;
							}
							else {
								not = null;
							}
						}
						CAUGHT_not = not;
					}
					catch (Exception e) {
						CAUGHT_not = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean status;
					if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
						status = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_or;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Property resolvedProperty_0 = this.getResolvedProperty();
							final /*@NonInvalid*/ @Nullable Type propertyType = resolvedProperty_0.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
							final /*@NonInvalid*/ @Nullable Type valueType = value.getType();
							/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
							try {
								final /*@NonInvalid*/ @NonNull Object conformsTo = valueType == null;
								/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
								if (conformsTo == Boolean.TRUE) {
									safe_conformsTo_source = null;
								}
								else {
									if (valueType == null) {
										throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
									}
									final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, propertyType).booleanValue();
									safe_conformsTo_source = conformsTo_0;
								}
								CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
							}
							catch (Exception e) {
								CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean or;
							if (CAUGHT_safe_conformsTo_source == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source_0;
								try {
									final /*@NonInvalid*/ @NonNull Object conformsTo_1 = propertyType == null;
									/*@Thrown*/ @Nullable Boolean safe_conformsTo_source_0;
									if (conformsTo_1 == Boolean.TRUE) {
										safe_conformsTo_source_0 = null;
									}
									else {
										if (propertyType == null) {
											throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
										}
										final /*@Thrown*/ boolean conformsTo_2 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, propertyType, valueType).booleanValue();
										safe_conformsTo_source_0 = conformsTo_2;
									}
									CAUGHT_safe_conformsTo_source_0 = safe_conformsTo_source_0;
								}
								catch (Exception e) {
									CAUGHT_safe_conformsTo_source_0 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_safe_conformsTo_source_0 == ValueUtil.TRUE_VALUE) {
									or = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_safe_conformsTo_source instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_safe_conformsTo_source;
									}
									if (CAUGHT_safe_conformsTo_source_0 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_safe_conformsTo_source_0;
									}
									if ((CAUGHT_safe_conformsTo_source == null) || (CAUGHT_safe_conformsTo_source_0 == null)) {
										or = null;
									}
									else {
										or = ValueUtil.FALSE_VALUE;
									}
								}
							}
							CAUGHT_or = or;
						}
						catch (Exception e) {
							CAUGHT_or = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_or == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_not instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_not;
							}
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if ((CAUGHT_not == null) || (CAUGHT_or == null)) {
								status = null;
							}
							else {
								status = ValueUtil.FALSE_VALUE;
							}
						}
					}
					final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
					/*@Thrown*/ @NonNull Object IF_eq;
					if (eq) {
						IF_eq = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
						final /*@NonInvalid*/ @Nullable Type type_0 = value_0.getType();
						final /*@NonInvalid*/ @NonNull Object name = type_0 == null;
						/*@Thrown*/ @Nullable String safe_name_source;
						if (name == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert type_0 != null;
							final /*@Thrown*/ @Nullable String name_0 = type_0.getName();
							safe_name_source = name_0;
						}
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(safe_name_source, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property resolvedProperty_1 = this.getResolvedProperty();
						final /*@NonInvalid*/ @Nullable Type type_1 = resolvedProperty_1.getType();
						final /*@NonInvalid*/ @NonNull Object name_1 = type_1 == null;
						/*@Thrown*/ @Nullable String safe_name_source_0;
						if (name_1 == Boolean.TRUE) {
							safe_name_source_0 = null;
						}
						else {
							assert type_1 != null;
							final /*@Thrown*/ @Nullable String name_2 = type_1.getName();
							safe_name_source_0 = name_2;
						}
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, safe_name_source_0);
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
						IF_eq = TUP_;
					}
					CAUGHT_IF_eq = IF_eq;
				}
				catch (Exception e) {
					CAUGHT_IF_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_eq, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForCollectionElementValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyTemplateItem::CompatibleTypeForCollectionElementValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForCollectionElementValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[?] = resolvedProperty.type.oclIsKindOf(CollectionType) and
			 *           not value.type.oclIsKindOf(CollectionType) implies
			 *           let
			 *             propertyType : Type[1] = resolvedProperty.type.oclAsType(CollectionType).elementType
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               valueType?.conformsTo(propertyType) or
			 *               propertyType.conformsTo(valueType)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = value.type?.name + ' must conform to ' +
			 *               resolvedProperty.type.oclAsType(CollectionType).elementType.name + ' or vice-versa', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_ELEMENT_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_eq;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
							final /*@NonInvalid*/ @Nullable Type type = resolvedProperty.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and;
						if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_not;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
								try {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_1 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
									final /*@NonInvalid*/ @Nullable Type type_0 = value.getType();
									final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_1).booleanValue();
									CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
								}
								catch (Exception e) {
									CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_oclIsKindOf_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf_0;
								}
								final /*@Thrown*/ @Nullable Boolean not;
								if (CAUGHT_oclIsKindOf_0 == ValueUtil.FALSE_VALUE) {
									not = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_oclIsKindOf_0 == ValueUtil.TRUE_VALUE) {
										not = ValueUtil.FALSE_VALUE;
									}
									else {
										not = null;
									}
								}
								CAUGHT_not = not;
							}
							catch (Exception e) {
								CAUGHT_not = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf;
								}
								if (CAUGHT_not instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_not;
								}
								if (CAUGHT_not == null) {
									and = null;
								}
								else {
									and = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean status;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						status = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_or;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_propertyType;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_2 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull Property resolvedProperty_0 = this.getResolvedProperty();
								final /*@NonInvalid*/ @Nullable Type type_1 = resolvedProperty_0.getType();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull CollectionType oclAsType = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_1, TYP_CollectionType_2);
								final /*@Thrown*/ @NonNull Type propertyType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType);
								CAUGHT_propertyType = propertyType;
							}
							catch (Exception e) {
								CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
							final /*@NonInvalid*/ @Nullable Type valueType = value_0.getType();
							/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
							try {
								final /*@NonInvalid*/ @NonNull Object conformsTo = valueType == null;
								/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
								if (conformsTo == Boolean.TRUE) {
									safe_conformsTo_source = null;
								}
								else {
									if (valueType == null) {
										throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
									}
									if (CAUGHT_propertyType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_propertyType;
									}
									final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, CAUGHT_propertyType).booleanValue();
									safe_conformsTo_source = conformsTo_0;
								}
								CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
							}
							catch (Exception e) {
								CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean or;
							if (CAUGHT_safe_conformsTo_source == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_conformsTo_1;
								try {
									if (CAUGHT_propertyType instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_propertyType;
									}
									final /*@Thrown*/ boolean conformsTo_1 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, CAUGHT_propertyType, valueType).booleanValue();
									CAUGHT_conformsTo_1 = conformsTo_1;
								}
								catch (Exception e) {
									CAUGHT_conformsTo_1 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_conformsTo_1 == ValueUtil.TRUE_VALUE) {
									or = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_safe_conformsTo_source instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_safe_conformsTo_source;
									}
									if (CAUGHT_conformsTo_1 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_conformsTo_1;
									}
									if (CAUGHT_safe_conformsTo_source == null) {
										or = null;
									}
									else {
										or = ValueUtil.FALSE_VALUE;
									}
								}
							}
							CAUGHT_or = or;
						}
						catch (Exception e) {
							CAUGHT_or = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_or == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if ((CAUGHT_and == null) || (CAUGHT_or == null)) {
								status = null;
							}
							else {
								status = ValueUtil.FALSE_VALUE;
							}
						}
					}
					final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
					/*@Thrown*/ @NonNull Object IF_eq;
					if (eq) {
						IF_eq = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_3 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value_1 = this.getValue();
						final /*@NonInvalid*/ @Nullable Type type_2 = value_1.getType();
						final /*@NonInvalid*/ @NonNull Object name = type_2 == null;
						/*@Thrown*/ @Nullable String safe_name_source;
						if (name == Boolean.TRUE) {
							safe_name_source = null;
						}
						else {
							assert type_2 != null;
							final /*@Thrown*/ @Nullable String name_0 = type_2.getName();
							safe_name_source = name_0;
						}
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(safe_name_source, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property resolvedProperty_1 = this.getResolvedProperty();
						final /*@NonInvalid*/ @Nullable Type type_3 = resolvedProperty_1.getType();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull CollectionType oclAsType_0 = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_3);
						final /*@Thrown*/ @NonNull Type elementType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType_0);
						final /*@Thrown*/ @Nullable String name_1 = elementType.getName();
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_1);
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
						IF_eq = TUP_;
					}
					CAUGHT_IF_eq = IF_eq;
				}
				catch (Exception e) {
					CAUGHT_IF_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_eq, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForCollectionValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyTemplateItem::CompatibleTypeForCollectionValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForCollectionValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[?] = resolvedProperty.type.oclIsKindOf(CollectionType) and
			 *           value.type.oclIsKindOf(CollectionType) implies
			 *           let
			 *             propertyType : Type[1] = resolvedProperty.type.oclAsType(CollectionType).elementType
			 *           in
			 *             let
			 *               valueType : Type[1] = value.type.oclAsType(CollectionType).elementType
			 *             in
			 *               valueType.conformsTo(propertyType) or
			 *               propertyType.conformsTo(valueType)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{
			 *               message = value.type.oclAsType(CollectionType).elementType.name + ' must conform to ' +
			 *               resolvedProperty.type.oclAsType(CollectionType).elementType.name + ' or vice-versa', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_eq;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Property resolvedProperty = this.getResolvedProperty();
							final /*@NonInvalid*/ @Nullable Type type = resolvedProperty.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and;
						if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_1 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
								final /*@NonInvalid*/ @Nullable Type type_0 = value.getType();
								final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_1).booleanValue();
								CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
							}
							catch (Exception e) {
								CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_oclIsKindOf_0 == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf;
								}
								if (CAUGHT_oclIsKindOf_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_oclIsKindOf_0;
								}
								and = ValueUtil.TRUE_VALUE;
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean status;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						status = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_or;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_propertyType;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_2 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull Property resolvedProperty_0 = this.getResolvedProperty();
								final /*@NonInvalid*/ @Nullable Type type_1 = resolvedProperty_0.getType();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull CollectionType oclAsType = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_1, TYP_CollectionType_2);
								final /*@Thrown*/ @NonNull Type propertyType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType);
								CAUGHT_propertyType = propertyType;
							}
							catch (Exception e) {
								CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
							}
							/*@Caught*/ @NonNull Object CAUGHT_valueType;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_3 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
								final /*@NonInvalid*/ @Nullable Type type_2 = value_0.getType();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull CollectionType oclAsType_0 = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_2, TYP_CollectionType_3);
								final /*@Thrown*/ @NonNull Type valueType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType_0);
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
							final /*@Thrown*/ @Nullable Boolean or;
							if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
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
								if (CAUGHT_conformsTo_0 == ValueUtil.TRUE_VALUE) {
									or = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_conformsTo instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_conformsTo;
									}
									if (CAUGHT_conformsTo_0 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_conformsTo_0;
									}
									or = ValueUtil.FALSE_VALUE;
								}
							}
							CAUGHT_or = or;
						}
						catch (Exception e) {
							CAUGHT_or = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_or == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if ((CAUGHT_and == null) || (CAUGHT_or == null)) {
								status = null;
							}
							else {
								status = ValueUtil.FALSE_VALUE;
							}
						}
					}
					final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
					/*@Thrown*/ @NonNull Object IF_eq;
					if (eq) {
						IF_eq = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_5 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value_1 = this.getValue();
						final /*@NonInvalid*/ @Nullable Type type_3 = value_1.getType();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull CollectionType oclAsType_1 = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_5);
						final /*@Thrown*/ @NonNull Type elementType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType_1);
						final /*@Thrown*/ @Nullable String name = elementType.getName();
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property resolvedProperty_1 = this.getResolvedProperty();
						final /*@NonInvalid*/ @Nullable Type type_4 = resolvedProperty_1.getType();
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull CollectionType oclAsType_2 = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_4, TYP_CollectionType_5);
						final /*@Thrown*/ @NonNull Type elementType_0 = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateTables.CLSSid_Type, oclAsType_2);
						final /*@Thrown*/ @Nullable String name_0 = elementType_0.getName();
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
						IF_eq = TUP_;
					}
					CAUGHT_IF_eq = IF_eq;
				}
				catch (Exception e) {
					CAUGHT_IF_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_eq, QVTtemplateTables.INT_0).booleanValue();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetObjContainer((ObjectTemplateExp)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return basicSetObjContainer(null, msgs);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2, ObjectTemplateExp.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return getObjContainer();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return getValue();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return isIsOpposite();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setObjContainer((ObjectTemplateExp)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setReferredProperty((Property)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setValue((OCLExpression)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setIsOpposite((Boolean)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setObjContainer((ObjectTemplateExp)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setReferredProperty((Property)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setValue((OCLExpression)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return getObjContainer() != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return referredProperty != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return value != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ReferringElement.class) {
			switch (baseOperationID) {
				case 0: return ElementImpl.ELEMENT_OPERATION_COUNT + 0;
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
			case ElementImpl.ELEMENT_OPERATION_COUNT + 1:
				return validateCompatibleClassForProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 2:
				return validateCompatibleTypeForObjectValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 3:
				return validateCompatibleTypeForCollectionElementValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 4:
				return validateCompatibleTypeForCollectionValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 0:
				return getReferredElement();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTtemplateVisitor) {
			return (R) ((QVTtemplateVisitor<?>)visitor).visitPropertyTemplateItem(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public Element getReferredElement() {
		Property referredProperty = getReferredProperty();
		return isOpposite && (referredProperty != null) ? referredProperty.getOpposite() : referredProperty;
	}
} //PropertyTemplateItemImpl
