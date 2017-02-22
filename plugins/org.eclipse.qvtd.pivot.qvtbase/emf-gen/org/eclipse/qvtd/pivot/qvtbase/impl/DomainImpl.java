/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, isCheckable, !oldIsCheckableESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTbasePackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, IS_CHECKABLE_EDEFAULT, oldIsCheckableESet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DOMAIN__IS_ENFORCEABLE, oldIsEnforceable, isEnforceable, !oldIsEnforceableESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTbasePackage.DOMAIN__IS_ENFORCEABLE, oldIsEnforceable, IS_ENFORCEABLE_EDEFAULT, oldIsEnforceableESet));
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
		if (eContainerFeatureID() != QVTbasePackage.DOMAIN__RULE) return null;
		return (Rule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, QVTbasePackage.DOMAIN__RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRule(Rule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != QVTbasePackage.DOMAIN__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, QVTbasePackage.RULE__DOMAIN, Rule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DOMAIN__RULE, newRule, newRule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsTypedModelName(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NameIsTypedModelName:
		 *   let severity : Integer[1] = 'Domain::NameIsTypedModelName'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = typedModel <> null implies name = typedModel.name
		 *       in
		 *         'Domain::NameIsTypedModelName'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Domain_c_c_NameIsTypedModelName);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable TypedModel typedModel = this.getTypedModel();
				final /*@NonInvalid*/ boolean ne = typedModel != null;
				/*@Thrown*/ boolean result;
				if (ne) {
					final /*@NonInvalid*/ java.lang.@Nullable String name = this.getName();
					if (typedModel == null) {
						throw new InvalidValueException("Null source for \'NamedElement::name\'");
					}
					final /*@Thrown*/ java.lang.@Nullable String name_0 = typedModel.getName();
					final /*@Thrown*/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);
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
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Domain_c_c_NameIsTypedModelName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public boolean validateTypedModelIsTransformationModelParameter(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TypedModelIsTransformationModelParameter:
		 *   let
		 *     severity : Integer[1] = 'Domain::TypedModelIsTransformationModelParameter'.getSeverity()
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
		 *         'Domain::TypedModelIsTransformationModelParameter'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Domain_c_c_TypedModelIsTransformationModelParameter);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Transformation = idResolver.getClass(QVTbaseTables.CLSSid_Transformation, null);
						final /*@NonInvalid*/ java.lang.@Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
						final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_qvtbase_c_c_Transformation).booleanValue();
						CAUGHT_oclIsKindOf = oclIsKindOf;
					}
					catch (Exception e) {
						CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable TypedModel typedModel = this.getTypedModel();
					final /*@NonInvalid*/ boolean ne = typedModel != null;
					final /*@Thrown*/ java.lang.@Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, ne);
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_includes;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Transformation_0 = idResolver.getClass(QVTbaseTables.CLSSid_Transformation, null);
					final /*@NonInvalid*/ java.lang.@Nullable Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation oclAsType = ClassUtil.nonNullState((Transformation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_qvtbase_c_c_Transformation_0));
					final /*@Thrown*/ java.util.@NonNull List<TypedModel> modelParameter = oclAsType.getModelParameter();
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter);
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable TypedModel typedModel_0 = this.getTypedModel();
					final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_modelParameter, typedModel_0).booleanValue();
					CAUGHT_includes = includes;
				}
				catch (Exception e) {
					CAUGHT_includes = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and, CAUGHT_includes);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Domain_c_c_TypedModelIsTransformationModelParameter, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.DOMAIN__RULE:
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
			case QVTbasePackage.DOMAIN__RULE:
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
			case QVTbasePackage.DOMAIN__RULE:
				return eInternalContainer().eInverseRemove(this, QVTbasePackage.RULE__DOMAIN, Rule.class, msgs);
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
			case QVTbasePackage.DOMAIN__IS_CHECKABLE:
				return isIsCheckable();
			case QVTbasePackage.DOMAIN__IS_ENFORCEABLE:
				return isIsEnforceable();
			case QVTbasePackage.DOMAIN__RULE:
				return getRule();
			case QVTbasePackage.DOMAIN__TYPED_MODEL:
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
			case QVTbasePackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable((Boolean)newValue);
				return;
			case QVTbasePackage.DOMAIN__IS_ENFORCEABLE:
				setIsEnforceable((Boolean)newValue);
				return;
			case QVTbasePackage.DOMAIN__RULE:
				setRule((Rule)newValue);
				return;
			case QVTbasePackage.DOMAIN__TYPED_MODEL:
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
			case QVTbasePackage.DOMAIN__IS_CHECKABLE:
				unsetIsCheckable();
				return;
			case QVTbasePackage.DOMAIN__IS_ENFORCEABLE:
				unsetIsEnforceable();
				return;
			case QVTbasePackage.DOMAIN__RULE:
				setRule((Rule)null);
				return;
			case QVTbasePackage.DOMAIN__TYPED_MODEL:
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
			case QVTbasePackage.DOMAIN__IS_CHECKABLE:
				return isSetIsCheckable();
			case QVTbasePackage.DOMAIN__IS_ENFORCEABLE:
				return isSetIsEnforceable();
			case QVTbasePackage.DOMAIN__RULE:
				return getRule() != null;
			case QVTbasePackage.DOMAIN__TYPED_MODEL:
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
				case PivotPackage.REFERRING_ELEMENT___GET_REFERRED_ELEMENT: return QVTbasePackage.DOMAIN___GET_REFERRED_ELEMENT;
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
			case QVTbasePackage.DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP:
				return validateNameIsTypedModelName((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP:
				return validateTypedModelIsTransformationModelParameter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.DOMAIN___GET_REFERRED_ELEMENT:
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
} //DomainImpl
