/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
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
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesAllOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedContext <em>Owned Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends ClassImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> ownedTag;

	/**
	 * The cached value of the '{@link #getModelParameter() <em>Model Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> modelParameter;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rule;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected Transformation extends_;

	/**
	 * The cached value of the '{@link #getOwnedContext() <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContext()
	 * @generated
	 * @ordered
	 */
	protected Variable ownedContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<Annotation> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<Annotation>(Annotation.class, this, QVTbasePackage.TRANSFORMATION__OWNED_TAG);
		}
		return ownedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<TypedModel> getModelParameter() {
		if (modelParameter == null) {
			modelParameter = new EObjectContainmentWithInverseEList<TypedModel>(TypedModel.class, this, QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER, QVTbasePackage.TYPED_MODEL__TRANSFORMATION);
		}
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull EList<Rule> getRule() {
		if (rule == null) {
			rule = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, QVTbasePackage.TRANSFORMATION__RULE, QVTbasePackage.RULE__TRANSFORMATION);
		}
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull Transformation getExtends() {
		if (extends_ != null && extends_.eIsProxy()) {
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (Transformation)eResolveProxy(oldExtends);
			if (extends_ != oldExtends) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation basicGetExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtends(Transformation newExtends) {
		Transformation oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getOwnedContext() {
		return ownedContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContext(Variable newOwnedContext, NotificationChain msgs) {
		Variable oldOwnedContext = ownedContext;
		ownedContext = newOwnedContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT, oldOwnedContext, newOwnedContext);
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
	public void setOwnedContext(Variable newOwnedContext) {
		if (newOwnedContext != ownedContext) {
			NotificationChain msgs = null;
			if (ownedContext != null)
				msgs = ((InternalEObject)ownedContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT, null, msgs);
			if (newOwnedContext != null)
				msgs = ((InternalEObject)newOwnedContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT, null, msgs);
			msgs = basicSetOwnedContext(newOwnedContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT, newOwnedContext, newOwnedContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getFunction(final String name) {
		throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2015/QVTbase!Transformation!getFunction(String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelParameter()).basicAdd(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__RULE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRule()).basicAdd(otherEnd, msgs);
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
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__RULE:
				return ((InternalEList<?>)getRule()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT:
				return basicSetOwnedContext(null, msgs);
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
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return getOwnedTag();
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case QVTbasePackage.TRANSFORMATION__RULE:
				return getRule();
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
			case QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT:
				return getOwnedContext();
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
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends Annotation>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT:
				setOwnedContext((Variable)newValue);
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
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)null);
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT:
				setOwnedContext((Variable)null);
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
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case QVTbasePackage.TRANSFORMATION__RULE:
				return rule != null && !rule.isEmpty();
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
				return extends_ != null;
			case QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT:
				return ownedContext != null;
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
			case QVTbasePackage.TRANSFORMATION___GET_FUNCTION__STRING:
				return getFunction((String)arguments.get(0));
			case QVTbasePackage.TRANSFORMATION___GET_MODEL_PARAMETER__STRING:
				return getModelParameter((String)arguments.get(0));
			case QVTbasePackage.TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP:
				return validateContextTypeIsTransformation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP:
				return validateExtendedTypedModelIsExtended((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateModelParameterIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTbaseVisitor<?>)visitor).visitTransformation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public TypedModel getModelParameter(String name) {
		return NameUtil.getNameable(getModelParameter(), name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateContextTypeIsTransformation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv ContextTypeIsTransformation:
		 *   let
		 *     severity : Integer[1] = 'Transformation::ContextTypeIsTransformation'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = ownedContext <> null implies ownedContext.type = self
		 *       in
		 *         'Transformation::ContextTypeIsTransformation'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Transformation_c_c_ContextTypeIsTransformation);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @NonNull Object CAUGHT_ne;
				try {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Variable ownedContext = this.getOwnedContext();
					final /*@Thrown*/ boolean ne = ownedContext != null;
					CAUGHT_ne = ne;
				}
				catch (Exception e) {
					CAUGHT_ne = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_eq;
				try {
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Variable ownedContext_0 = this.getOwnedContext();
					if (ownedContext_0 == null) {
						throw new InvalidValueException("Null source for \'TypedElement::type\'");
					}
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = ownedContext_0.getType();
					final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == this.getTypeId()) : false;
					CAUGHT_eq = eq;
				}
				catch (Exception e) {
					CAUGHT_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Transformation_c_c_ContextTypeIsTransformation, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public boolean validateExtendedTypedModelIsExtended(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv ExtendedTypedModelIsExtended:
		 *   let
		 *     severity : Integer[1] = 'Transformation::ExtendedTypedModelIsExtended'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = extends <> null implies
		 *         extends.modelParameter->forAll(etm |
		 *           self.modelParameter->select(name = etm.name)
		 *           .usedPackage->includesAll(etm.usedPackage))
		 *       in
		 *         'Transformation::ExtendedTypedModelIsExtended'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Transformation_c_c_ExtendedTypedModelIsExtended);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @NonNull Object CAUGHT_ne;
				try {
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation symbol_0 = this.getExtends();
					final /*@Thrown*/ boolean ne = symbol_0 != null;
					CAUGHT_ne = ne;
				}
				catch (Exception e) {
					CAUGHT_ne = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_forAll;
				try {
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation symbol_1 = this.getExtends();
					if (symbol_1 == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::modelParameter\'");
					}
					final /*@Thrown*/ java.util.@NonNull List<TypedModel> modelParameter = symbol_1.getModelParameter();
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter);
					/*@Thrown*/ java.lang.@Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR_etm = BOXED_modelParameter.iterator();
					/*@Thrown*/ boolean forAll;
					while (true) {
						if (!ITERATOR_etm.hasNext()) {
							if (accumulator == ValueUtil.TRUE_VALUE) {
								forAll = ValueUtil.TRUE_VALUE;
							}
							else {
								throw (InvalidValueException)accumulator;
							}
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel etm = (TypedModel)ITERATOR_etm.next();
						/**
						 *
						 * self.modelParameter->select(name = etm.name)
						 * .usedPackage->includesAll(etm.usedPackage)
						 */
						/*@Caught*/ @NonNull Object CAUGHT_includesAll;
						try {
							final /*@Thrown*/ java.util.@NonNull List<TypedModel> modelParameter_0 = this.getModelParameter();
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_modelParameter_0 = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter_0);
							/*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(QVTbaseTables.ORD_CLSSid_TypedModel);
							@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter_0.iterator();
							/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue select;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									select = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel _1 = (TypedModel)ITERATOR__1.next();
								/**
								 * name = etm.name
								 */
								final /*@Thrown*/ java.lang.@Nullable String name = _1.getName();
								final /*@Thrown*/ java.lang.@Nullable String name_0 = etm.getName();
								final /*@Thrown*/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);
								//
								if (eq == ValueUtil.TRUE_VALUE) {
									accumulator_0.add(_1);
								}
							}
							/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(QVTbaseTables.SEQ_CLSSid_Package);
							@NonNull Iterator<Object> ITERATOR__1_0 = select.iterator();
							/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
							while (true) {
								if (!ITERATOR__1_0.hasNext()) {
									collect = accumulator_1;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel _1_0 = (TypedModel)ITERATOR__1_0.next();
								/**
								 * usedPackage
								 */
								final /*@Thrown*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = _1_0.getUsedPackage();
								final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_usedPackage = idResolver.createSetOfAll(QVTbaseTables.SET_CLSSid_Package, usedPackage);
								//
								for (Object value : BOXED_usedPackage.flatten().getElements()) {
									accumulator_1.add(value);
								}
							}
							final /*@Thrown*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage_0 = etm.getUsedPackage();
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_usedPackage_0 = idResolver.createSetOfAll(QVTbaseTables.SET_CLSSid_Package, usedPackage_0);
							final /*@Thrown*/ boolean includesAll = CollectionIncludesAllOperation.INSTANCE.evaluate(collect, BOXED_usedPackage_0).booleanValue();
							CAUGHT_includesAll = includesAll;
						}
						catch (Exception e) {
							CAUGHT_includesAll = ValueUtil.createInvalidValue(e);
						}
						//
						if (CAUGHT_includesAll == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							forAll = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (CAUGHT_includesAll == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (CAUGHT_includesAll instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = CAUGHT_includesAll;									// Cache an exception failure
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
						}
					}
					CAUGHT_forAll = forAll;
				}
				catch (Exception e) {
					CAUGHT_forAll = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_forAll);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Transformation_c_c_ExtendedTypedModelIsExtended, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
			symbol_2 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateModelParameterIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv ModelParameterIsUnique:
		 *   let
		 *     severity : Integer[1] = 'Transformation::ModelParameterIsUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = modelParameter->isUnique(name)
		 *       in
		 *         'Transformation::ModelParameterIsUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Transformation_c_c_ModelParameterIsUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@Thrown*/ java.util.@NonNull List<TypedModel> modelParameter = this.getModelParameter();
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTbaseTables.ORD_CLSSid_TypedModel);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel _1 = (TypedModel)ITERATOR__1.next();
					/**
					 * name
					 */
					final /*@Thrown*/ java.lang.@Nullable String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Transformation_c_c_ModelParameterIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}
} //TransformationImpl
