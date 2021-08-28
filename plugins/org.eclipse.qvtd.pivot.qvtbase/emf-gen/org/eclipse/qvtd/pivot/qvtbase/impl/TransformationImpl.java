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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesAllOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue.Accumulator;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.Target;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedTargets <em>Owned Targets</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedContext <em>Owned Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends ClassImpl implements Transformation {
	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMATION_FEATURE_COUNT = ClassImpl.CLASS_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSFORMATION_OPERATION_COUNT = ClassImpl.CLASS_OPERATION_COUNT + 6;

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
	 * The cached value of the '{@link #getOwnedTargets() <em>Owned Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<Target> ownedTargets;

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
	protected Parameter ownedContext;

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
			ownedTag = new EObjectContainmentEList<Annotation>(Annotation.class, this, ClassImpl.CLASS_FEATURE_COUNT + 0);
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
			modelParameter = new EObjectContainmentWithInverseEList<TypedModel>(TypedModel.class, this, ClassImpl.CLASS_FEATURE_COUNT + 1, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		}
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Target> getOwnedTargets() {
		if (ownedTargets == null) {
			ownedTargets = new EObjectContainmentWithInverseEList<Target>(Target.class, this, ClassImpl.CLASS_FEATURE_COUNT + 2, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0);
		}
		return ownedTargets;
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
			rule = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, ClassImpl.CLASS_FEATURE_COUNT + 3, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassImpl.CLASS_FEATURE_COUNT + 4, oldExtends, extends_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassImpl.CLASS_FEATURE_COUNT + 4, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getOwnedContext() {
		return ownedContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContext(Parameter newOwnedContext, NotificationChain msgs) {
		Parameter oldOwnedContext = ownedContext;
		ownedContext = newOwnedContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassImpl.CLASS_FEATURE_COUNT + 5, oldOwnedContext, newOwnedContext);
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
	public void setOwnedContext(Parameter newOwnedContext) {
		if (newOwnedContext != ownedContext) {
			NotificationChain msgs = null;
			if (ownedContext != null)
				msgs = ((InternalEObject)ownedContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ClassImpl.CLASS_FEATURE_COUNT + 5), null, msgs);
			if (newOwnedContext != null)
				msgs = ((InternalEObject)newOwnedContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ClassImpl.CLASS_FEATURE_COUNT + 5), null, msgs);
			msgs = basicSetOwnedContext(newOwnedContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassImpl.CLASS_FEATURE_COUNT + 5, newOwnedContext, newOwnedContext));
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
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelParameter()).basicAdd(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTargets()).basicAdd(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
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
			case ClassImpl.CLASS_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedTargets()).basicRemove(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getRule()).basicRemove(otherEnd, msgs);
			case ClassImpl.CLASS_FEATURE_COUNT + 5:
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
			case ClassImpl.CLASS_FEATURE_COUNT + 0:
				return getOwnedTag();
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				return getModelParameter();
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				return getOwnedTargets();
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
				return getRule();
			case ClassImpl.CLASS_FEATURE_COUNT + 4:
				if (resolve) return getExtends();
				return basicGetExtends();
			case ClassImpl.CLASS_FEATURE_COUNT + 5:
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
			case ClassImpl.CLASS_FEATURE_COUNT + 0:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				getOwnedTargets().clear();
				getOwnedTargets().addAll((Collection<? extends Target>)newValue);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 4:
				setExtends((Transformation)newValue);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 5:
				setOwnedContext((Parameter)newValue);
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
			case ClassImpl.CLASS_FEATURE_COUNT + 0:
				getOwnedTag().clear();
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				getModelParameter().clear();
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				getOwnedTargets().clear();
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
				getRule().clear();
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 4:
				setExtends((Transformation)null);
				return;
			case ClassImpl.CLASS_FEATURE_COUNT + 5:
				setOwnedContext((Parameter)null);
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
			case ClassImpl.CLASS_FEATURE_COUNT + 0:
				return ownedTag != null && !ownedTag.isEmpty();
			case ClassImpl.CLASS_FEATURE_COUNT + 1:
				return modelParameter != null && !modelParameter.isEmpty();
			case ClassImpl.CLASS_FEATURE_COUNT + 2:
				return ownedTargets != null && !ownedTargets.isEmpty();
			case ClassImpl.CLASS_FEATURE_COUNT + 3:
				return rule != null && !rule.isEmpty();
			case ClassImpl.CLASS_FEATURE_COUNT + 4:
				return extends_ != null;
			case ClassImpl.CLASS_FEATURE_COUNT + 5:
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
			case ClassImpl.CLASS_OPERATION_COUNT + 0:
				return getFunction((String)arguments.get(0));
			case ClassImpl.CLASS_OPERATION_COUNT + 1:
				return getModelParameter((String)arguments.get(0));
			case ClassImpl.CLASS_OPERATION_COUNT + 2:
				return validateContextTypeIsTransformation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ClassImpl.CLASS_OPERATION_COUNT + 3:
				return validateExtendedTypedModelIsExtended((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ClassImpl.CLASS_OPERATION_COUNT + 4:
				return validateModelParameterIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ClassImpl.CLASS_OPERATION_COUNT + 5:
				return validateNoExtendsCycle((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitTransformation(this);
		}
		else {
			return super.accept(visitor);
		}
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
		final @NonNull String constraintName = "Transformation::ContextTypeIsTransformation";
		try {
			/**
			 *
			 * inv ContextTypeIsTransformation:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedContext <> null implies
			 *         ownedContext.type.oclIsKindOf(Transformation)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable Parameter ownedContext = this.getOwnedContext();
					final /*@NonInvalid*/ boolean ne = ownedContext != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Transformation_0 = idResolver.getClass(QVTbaseTables.CLSSid_Transformation, null);
							if (ownedContext == null) {
								throw new InvalidValueException("Null source for \'TypedElement::type\'");
							}
							final /*@Thrown*/ @Nullable Type type = ownedContext.getType();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_qvtbase_c_c_Transformation_0).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							result = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateExtendedTypedModelIsExtended(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Transformation::ExtendedTypedModelIsExtended";
		try {
			/**
			 *
			 * inv ExtendedTypedModelIsExtended:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = extends <> null implies
			 *         extends.modelParameter->forAll(etm |
			 *           self.modelParameter->select(name = etm.name)
			 *           .usedPackage->includesAll(etm.usedPackage))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_2;
			if (le) {
				symbol_2 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable Transformation symbol_0 = this.getExtends();
					final /*@NonInvalid*/ boolean ne = symbol_0 != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_forAll;
						try {
							if (symbol_0 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::modelParameter\'");
							}
							final /*@Thrown*/ @NonNull List<TypedModel> modelParameter = symbol_0.getModelParameter();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter);
							/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
							@NonNull Iterator<Object> ITERATOR_etm = BOXED_modelParameter.iterator();
							/*@Thrown*/ @Nullable Boolean forAll;
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
								/*@NonInvalid*/ @NonNull TypedModel etm = (@NonNull TypedModel)ITERATOR_etm.next();
								/**
								 *
								 * self.modelParameter->select(name = etm.name)
								 * .usedPackage->includesAll(etm.usedPackage)
								 */
								final /*@NonInvalid*/ @NonNull List<TypedModel> modelParameter_0 = this.getModelParameter();
								final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_modelParameter_0 = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter_0);
								/*@Thrown*/ @NonNull Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(QVTbaseTables.ORD_CLSSid_TypedModel);
								@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter_0.iterator();
								/*@NonInvalid*/ @NonNull OrderedSetValue select;
								while (true) {
									if (!ITERATOR__1.hasNext()) {
										select = accumulator_0;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull TypedModel _1 = (@NonNull TypedModel)ITERATOR__1.next();
									/**
									 * name = etm.name
									 */
									final /*@NonInvalid*/ @Nullable String name = _1.getName();
									final /*@NonInvalid*/ @Nullable String name_0 = etm.getName();
									final /*@NonInvalid*/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);
									//
									if (eq) {
										accumulator_0.add(_1);
									}
								}
								/*@Thrown*/ org.eclipse.ocl.pivot.values.SequenceValue.@NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(QVTbaseTables.SEQ_CLSSid_Package);
								@NonNull Iterator<Object> ITERATOR__1_0 = select.iterator();
								/*@NonInvalid*/ @NonNull SequenceValue collect;
								while (true) {
									if (!ITERATOR__1_0.hasNext()) {
										collect = accumulator_1;
										break;
									}
									@SuppressWarnings("null")
									/*@NonInvalid*/ @NonNull TypedModel _1_0 = (@NonNull TypedModel)ITERATOR__1_0.next();
									/**
									 * usedPackage
									 */
									final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = _1_0.getUsedPackage();
									final /*@NonInvalid*/ @NonNull SetValue BOXED_usedPackage = idResolver.createSetOfAll(QVTbaseTables.SET_CLSSid_Package, usedPackage);
									//
									for (Object value : BOXED_usedPackage.flatten().getElements()) {
										accumulator_1.add(value);
									}
								}
								final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Package> usedPackage_0 = etm.getUsedPackage();
								final /*@NonInvalid*/ @NonNull SetValue BOXED_usedPackage_0 = idResolver.createSetOfAll(QVTbaseTables.SET_CLSSid_Package, usedPackage_0);
								final /*@NonInvalid*/ boolean includesAll = CollectionIncludesAllOperation.INSTANCE.evaluate(collect, BOXED_usedPackage_0).booleanValue();
								//
								if (!includesAll) {					// Normal unsuccessful body evaluation result
									forAll = ValueUtil.FALSE_VALUE;
									break;														// Stop immediately
								}
								else if (includesAll) {				// Normal successful body evaluation result
									;															// Carry on
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
						if (CAUGHT_forAll == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_forAll instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_forAll;
							}
							if (CAUGHT_forAll == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
				symbol_2 = logDiagnostic;
			}
			return symbol_2;
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
	public boolean validateModelParameterIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Transformation::ModelParameterIsUnique";
		try {
			/**
			 *
			 * inv ModelParameterIsUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = modelParameter->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @NonNull List<TypedModel> modelParameter = this.getModelParameter();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_TypedModel, modelParameter);
					/*@Thrown*/ org.eclipse.ocl.pivot.values.SetValue.@NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTbaseTables.ORD_CLSSid_TypedModel);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = true;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull TypedModel _1 = (@NonNull TypedModel)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
						//
						if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
							result = false;
							break;			// Abort after second find
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateNoExtendsCycle(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Transformation::NoExtendsCycle";
		try {
			/**
			 *
			 * inv NoExtendsCycle:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = extends->closure(extends)
			 *         ->excludes(self)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.TRANSFORMATION___VALIDATE_NO_EXTENDS_CYCLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_3;
			if (le) {
				symbol_3 = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable Transformation symbol_0 = this.getExtends();
					final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTbaseTables.SET_CLSSid_Transformation, symbol_0);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, oclAsSet);
					final @NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
					final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, QVTbaseTables.SET_CLSSid_Transformation, QVTbaseTables.CLSSid_Transformation);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
						/**
						 * extends
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
							final /*@NonInvalid*/ @Nullable Transformation symbol_1 = (Transformation)_1;
							if (symbol_1 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::extends\'");
							}
							final /*@Thrown*/ @Nullable Transformation symbol_2 = symbol_1.getExtends();
							return symbol_2;
						}
					};
					final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, QVTbaseTables.SET_CLSSid_Transformation, BODY_closure_0, oclAsSet, ACC_closure_0);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
					final /*@Thrown*/ boolean result = CollectionExcludesOperation.INSTANCE.evaluate(closure, this).booleanValue();
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
				symbol_3 = logDiagnostic;
			}
			return symbol_3;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}
} //TransformationImpl
