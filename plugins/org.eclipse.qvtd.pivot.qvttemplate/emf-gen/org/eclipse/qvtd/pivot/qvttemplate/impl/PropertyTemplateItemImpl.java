/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
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
		if (eContainerFeatureID() != QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER) return null;
		return (ObjectTemplateExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjContainer(ObjectTemplateExp newObjContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjContainer, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObjContainer(ObjectTemplateExp newObjContainer) {
		if (newObjContainer != eInternalContainer() || (eContainerFeatureID() != QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER && newObjContainer != null)) {
			if (EcoreUtil.isAncestor(this, newObjContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjContainer != null)
				msgs = ((InternalEObject)newObjContainer).eInverseAdd(this, QVTtemplatePackage.OBJECT_TEMPLATE_EXP__PART, ObjectTemplateExp.class, msgs);
			msgs = basicSetObjContainer(newObjContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER, newObjContainer, newObjContainer));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, newValue, newValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE, oldIsOpposite, isOpposite));
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
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property referredProperty_0 = this.getReferredProperty();
		final /*@NonInvalid*/ boolean isOpposite = this.isIsOpposite();
		/*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property symbol_0;
		if (isOpposite) {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property opposite = referredProperty_0.getOpposite();
			symbol_0 = opposite;
		}
		else {
			symbol_0 = referredProperty_0;
		}
		if (symbol_0 == null) {
			throw new InvalidValueException("Null body for \'qvttemplate::PropertyTemplateItem::resolvedProperty\'");
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
		 *     severity : Integer[1] = 'PropertyTemplateItem::CompatibleClassForProperty'.getSeverity()
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
		 *         'PropertyTemplateItem::CompatibleClassForProperty'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleClassForProperty);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_3;
		if (le) {
			symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp objContainer = this.getObjContainer();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class referredClass = objContainer.getReferredClass();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = resolvedProperty.getOwningClass();
				final /*@Thrown*/ boolean status = OclTypeConformsToOperation.INSTANCE.evaluate(executor, referredClass, owningClass).booleanValue();
				/*@Thrown*/ java.lang.@NonNull Object symbol_2;
				if (status) {
					symbol_2 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ java.lang.@Nullable String name = referredClass.getName();
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
					final /*@NonInvalid*/ @NonNull Object symbol_0 = owningClass == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source;
					if (symbol_0 == Boolean.TRUE) {
						safe_name_source = null;
					}
					else {
						assert owningClass != null;
						final /*@Thrown*/ java.lang.@Nullable String name_0 = owningClass.getName();
						safe_name_source = name_0;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, safe_name_source);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_1 = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_0, status);
					symbol_2 = symbol_1;
				}
				CAUGHT_symbol_2 = symbol_2;
			}
			catch (Exception e) {
				CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleClassForProperty, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_2, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForObjectValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForObjectValue:
		 *   let
		 *     severity : Integer[1] = 'PropertyTemplateItem::CompatibleTypeForObjectValue'.getSeverity()
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
		 *               valueType.conformsTo(propertyType) or
		 *               propertyType.conformsTo(valueType)
		 *         in
		 *           if status = true
		 *           then true
		 *           else
		 *             Tuple{message = value.type?.name + ' must conform to ' + resolvedProperty.type?.name + ' or vice-versa', status = status
		 *             }
		 *           endif
		 *       in
		 *         'PropertyTemplateItem::CompatibleTypeForObjectValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForObjectValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_5;
		if (le) {
			symbol_5 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_4;
			try {
				/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = resolvedProperty.getType();
					final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType).booleanValue();
					CAUGHT_oclIsKindOf = oclIsKindOf;
				}
				catch (Exception e) {
					CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf);
				/*@Caught*/ @Nullable Object CAUGHT_or;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_0 = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type propertyType = resolvedProperty_0.getType();
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
					final /*@Thrown*/ java.lang.@Nullable Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
					CAUGHT_or = or;
				}
				catch (Exception e) {
					CAUGHT_or = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(not, CAUGHT_or);
				final /*@Thrown*/ boolean symbol_0 = status == Boolean.TRUE;
				/*@Thrown*/ java.lang.@NonNull Object symbol_4;
				if (symbol_0) {
					symbol_4 = ValueUtil.TRUE_VALUE;
				}
				else {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = value_0.getType();
					final /*@NonInvalid*/ @NonNull Object symbol_1 = type_0 == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source;
					if (symbol_1 == Boolean.TRUE) {
						safe_name_source = null;
					}
					else {
						assert type_0 != null;
						final /*@Thrown*/ java.lang.@Nullable String name = type_0.getName();
						safe_name_source = name;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(safe_name_source, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_1 = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_1 = resolvedProperty_1.getType();
					final /*@NonInvalid*/ @NonNull Object symbol_2 = type_1 == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source_0;
					if (symbol_2 == Boolean.TRUE) {
						safe_name_source_0 = null;
					}
					else {
						assert type_1 != null;
						final /*@Thrown*/ java.lang.@Nullable String name_0 = type_1.getName();
						safe_name_source_0 = name_0;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, safe_name_source_0);
					final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_3 = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
					symbol_4 = symbol_3;
				}
				CAUGHT_symbol_4 = symbol_4;
			}
			catch (Exception e) {
				CAUGHT_symbol_4 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForObjectValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_4, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForCollectionElementValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForCollectionElementValue:
		 *   let
		 *     severity : Integer[1] = 'PropertyTemplateItem::CompatibleTypeForCollectionElementValue'.getSeverity()
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
		 *               valueType.conformsTo(propertyType) or
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
		 *         'PropertyTemplateItem::CompatibleTypeForCollectionElementValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForCollectionElementValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_4;
		if (le) {
			symbol_4 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_3;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = resolvedProperty.getType();
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
						CAUGHT_oclIsKindOf = oclIsKindOf;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_1 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = value.getType();
						final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_1).booleanValue();
						CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf_0);
					final /*@Thrown*/ java.lang.@Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, not);
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @Nullable Object CAUGHT_or;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_propertyType;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_2 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_0 = this.getResolvedProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_1 = resolvedProperty_0.getType();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_1, TYP_CollectionType_2));
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type propertyType = oclAsType.getElementType();
						CAUGHT_propertyType = propertyType;
					}
					catch (Exception e) {
						CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type valueType = value_0.getType();
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
					final /*@Thrown*/ java.lang.@Nullable Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_conformsTo, CAUGHT_conformsTo_0);
					CAUGHT_or = or;
				}
				catch (Exception e) {
					CAUGHT_or = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_or);
				final /*@Thrown*/ boolean symbol_0 = status == Boolean.TRUE;
				/*@Thrown*/ java.lang.@NonNull Object symbol_3;
				if (symbol_0) {
					symbol_3 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_3 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_1 = this.getValue();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_2 = value_1.getType();
					final /*@NonInvalid*/ @NonNull Object symbol_1 = type_2 == null;
					/*@Thrown*/ java.lang.@Nullable String safe_name_source;
					if (symbol_1 == Boolean.TRUE) {
						safe_name_source = null;
					}
					else {
						assert type_2 != null;
						final /*@Thrown*/ java.lang.@Nullable String name = type_2.getName();
						safe_name_source = name;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(safe_name_source, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_1 = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_3 = resolvedProperty_1.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_3));
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type elementType = oclAsType_0.getElementType();
					final /*@Thrown*/ java.lang.@Nullable String name_0 = elementType.getName();
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
					final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_2 = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
					symbol_3 = symbol_2;
				}
				CAUGHT_symbol_3 = symbol_3;
			}
			catch (Exception e) {
				CAUGHT_symbol_3 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForCollectionElementValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_3, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForCollectionValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForCollectionValue:
		 *   let
		 *     severity : Integer[1] = 'PropertyTemplateItem::CompatibleTypeForCollectionValue'.getSeverity()
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
		 *         'PropertyTemplateItem::CompatibleTypeForCollectionValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForCollectionValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_3;
		if (le) {
			symbol_3 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_2;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty = this.getResolvedProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = resolvedProperty.getType();
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0).booleanValue();
						CAUGHT_oclIsKindOf = oclIsKindOf;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_1 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = value.getType();
						final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType_1).booleanValue();
						CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ java.lang.@Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_oclIsKindOf_0);
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @Nullable Object CAUGHT_or;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_propertyType;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_2 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_0 = this.getResolvedProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_1 = resolvedProperty_0.getType();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_1, TYP_CollectionType_2));
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type propertyType = oclAsType.getElementType();
						CAUGHT_propertyType = propertyType;
					}
					catch (Exception e) {
						CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_valueType;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_3 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_0 = this.getValue();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_2 = value_0.getType();
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType_0 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_2, TYP_CollectionType_3));
						@SuppressWarnings("null")
						final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type valueType = oclAsType_0.getElementType();
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
				final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_or);
				final /*@Thrown*/ boolean symbol_0 = status == Boolean.TRUE;
				/*@Thrown*/ java.lang.@NonNull Object symbol_2;
				if (symbol_0) {
					symbol_2 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_5 = idResolver.getClass(QVTtemplateTables.CLSSid_CollectionType, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value_1 = this.getValue();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_3 = value_1.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType_1 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_3, TYP_CollectionType_5));
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type elementType = oclAsType_1.getElementType();
					final /*@Thrown*/ java.lang.@Nullable String name = elementType.getName();
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(name, QVTtemplateTables.STR__32_must_32_conform_32_to_32);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property resolvedProperty_1 = this.getResolvedProperty();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_4 = resolvedProperty_1.getType();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull CollectionType oclAsType_2 = ClassUtil.nonNullState((CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type_4, TYP_CollectionType_5));
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Type elementType_0 = oclAsType_2.getElementType();
					final /*@Thrown*/ java.lang.@Nullable String name_0 = elementType_0.getName();
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, name_0);
					final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTtemplateTables.STR__32_or_32_vice_m_versa);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_1 = ValueUtil.createTupleOfEach(QVTtemplateTables.TUPLid_, sum_1, status);
					symbol_2 = symbol_1;
				}
				CAUGHT_symbol_2 = symbol_2;
			}
			catch (Exception e) {
				CAUGHT_symbol_2 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_PropertyTemplateItem_c_c_CompatibleTypeForCollectionValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_2, QVTtemplateTables.INT_0).booleanValue();
			symbol_3 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_3;
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return basicSetObjContainer(null, msgs);
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return eInternalContainer().eInverseRemove(this, QVTtemplatePackage.OBJECT_TEMPLATE_EXP__PART, ObjectTemplateExp.class, msgs);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return getObjContainer();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				return getValue();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				return isIsOpposite();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__RESOLVED_PROPERTY:
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				setObjContainer((ObjectTemplateExp)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				setValue((OCLExpression)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				setObjContainer((ObjectTemplateExp)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				setValue((OCLExpression)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return getObjContainer() != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				return referredProperty != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				return value != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__RESOLVED_PROPERTY:
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
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___GET_REFERRED_ELEMENT;
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_CLASS_FOR_PROPERTY__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleClassForProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_OBJECT_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForObjectValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_ELEMENT_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForCollectionElementValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___VALIDATE_COMPATIBLE_TYPE_FOR_COLLECTION_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForCollectionValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM___GET_REFERRED_ELEMENT:
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
		return (R) ((QVTtemplateVisitor<?>)visitor).visitPropertyTemplateItem(this);
	}

	@Override
	public Element getReferredElement() {
		return getReferredProperty();
	}
} //PropertyTemplateItemImpl
