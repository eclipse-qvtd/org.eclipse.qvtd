/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseSupport;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DomainImpl extends NamedElementImpl implements Domain {
	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The default value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckable = IS_CHECKABLE_EDEFAULT;

	/**
	 * This is true if the Is Checkable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckableESet;

	/**
	 * The default value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceable = IS_ENFORCEABLE_EDEFAULT;

	/**
	 * This is true if the Is Enforceable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceableESet;

	/**
	 * The cached value of the '{@link #getTypedModel() <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel typedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCheckable() {
		return isCheckable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCheckable(boolean newIsCheckable) {
		boolean oldIsCheckable = isCheckable;
		isCheckable = newIsCheckable;
		boolean oldIsCheckableESet = isCheckableESet;
		isCheckableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldIsCheckable, isCheckable, !oldIsCheckableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsCheckable() {
		boolean oldIsCheckable = isCheckable;
		boolean oldIsCheckableESet = isCheckableESet;
		isCheckable = IS_CHECKABLE_EDEFAULT;
		isCheckableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldIsCheckable, IS_CHECKABLE_EDEFAULT, oldIsCheckableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsCheckable() {
		return isCheckableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforceable() {
		return isEnforceable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforceable(boolean newIsEnforceable) {
		boolean oldIsEnforceable = isEnforceable;
		isEnforceable = newIsEnforceable;
		boolean oldIsEnforceableESet = isEnforceableESet;
		isEnforceableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsEnforceable, isEnforceable, !oldIsEnforceableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsEnforceable() {
		boolean oldIsEnforceable = isEnforceable;
		boolean oldIsEnforceableESet = isEnforceableESet;
		isEnforceable = IS_ENFORCEABLE_EDEFAULT;
		isEnforceableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsEnforceable, IS_ENFORCEABLE_EDEFAULT, oldIsEnforceableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsEnforceable() {
		return isEnforceableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getRule() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2)) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRule(Rule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2) && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, Rule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getTypedModel() {
		if (typedModel != null && typedModel.eIsProxy()) {
			InternalEObject oldTypedModel = (InternalEObject)typedModel;
			typedModel = (TypedModel)eResolveProxy(oldTypedModel);
			if (typedModel != oldTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldTypedModel, typedModel));
			}
		}
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetTypedModel() {
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypedModel(TypedModel newTypedModel) {
		TypedModel oldTypedModel = typedModel;
		typedModel = newTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsTypedModelName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Domain::NameIsTypedModelName";
		try {
			/**
			 *
			 * inv NameIsTypedModelName:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = typedModel <> null implies name = typedModel.name
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable TypedModel typedModel_0 = this.getTypedModel();
					final /*@NonInvalid*/ boolean IsEQ_ = typedModel_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_IsEQ_;
						try {
							final /*@NonInvalid*/ @Nullable String name = this.getName();
							if (typedModel_0 == null) {
								throw new InvalidValueException("Null source for \'NamedElement::name\'");
							}
							final /*@Thrown*/ @Nullable String name_0 = typedModel_0.getName();
							final /*@Thrown*/ boolean IsEQ__0 = (name != null) ? idResolver.oclEquals(name, name_0) : (name_0 == null);
							CAUGHT_IsEQ_ = IsEQ__0;
						}
						catch (Exception THROWN_CAUGHT_IsEQ_) {
							CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
						}
						if (CAUGHT_IsEQ_ == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_IsEQ_ instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IsEQ_;
							}
							implies = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTbaseSupport.INT_0).booleanValue();
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
	public boolean validateTypedModelIsTransformationModelParameter(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Domain::TypedModelIsTransformationModelParameter";
		try {
			/**
			 *
			 * inv TypedModelIsTransformationModelParameter:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = oclContainer()
			 *         .oclIsKindOf(Transformation) and typedModel <> null implies
			 *         oclContainer()
			 *         .oclAsType(Transformation)
			 *         .modelParameter->includes(typedModel)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Transformation = idResolver.getClass(QVTbaseSupport.CLSSid_Transformation, null);
					final /*@NonInvalid*/ @Nullable TypedModel typedModel_0 = this.getTypedModel();
					final /*@NonInvalid*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtbase_c_c_Transformation).booleanValue();
					final /*@NonInvalid*/ @Nullable Boolean and;
					if (!oclIsKindOf) {
						and = ValueUtil.FALSE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean IsEQ_ = typedModel_0 != null;
						if (!IsEQ_) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							and = ValueUtil.TRUE_VALUE;
						}
					}
					final /*@Thrown*/ @Nullable Boolean implies;
					if (and == ValueUtil.FALSE_VALUE) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_includes;
						try {
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Transformation oclAsType = (@NonNull Transformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtbase_c_c_Transformation);
							final /*@Thrown*/ @NonNull List<TypedModel> modelParameter = oclAsType.getModelParameter();
							final /*@Thrown*/ @Nullable OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_TypedModel, modelParameter);
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_modelParameter, typedModel_0).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception THROWN_CAUGHT_includes) {
							CAUGHT_includes = ValueUtil.createInvalidValue(THROWN_CAUGHT_includes);
						}
						if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_includes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_includes;
							}
							if (and == null) {
								implies = null;
							}
							else {
								implies = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTbaseSupport.INT_0).booleanValue();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRule((Rule)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return basicSetRule(null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, Rule.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isIsCheckable();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isIsEnforceable();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getRule();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				if (resolve) return getTypedModel();
				return basicGetTypedModel();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setIsCheckable((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsEnforceable((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setRule((Rule)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setTypedModel((TypedModel)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				unsetIsCheckable();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				unsetIsEnforceable();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setRule((Rule)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setTypedModel((TypedModel)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isSetIsCheckable();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isSetIsEnforceable();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getRule() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return typedModel != null;
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
				case 0: return NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0;
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1:
				return validateNameIsTypedModelName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2:
				return validateTypedModelIsTransformationModelParameter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0:
				return getReferredElement();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if ((typedModel != null) && !typedModel.eIsProxy()) {
			return typedModel.getName();
		}
		return String.valueOf(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getReferredElement() {
		return getTypedModel();
	}

	@Override
	public boolean isNotOutput() {
		return !isCheckable && !isEnforceable;
	}
} //DomainImpl
