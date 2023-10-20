/**
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl#getBoundVariable <em>Bound Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingParameterBindingImpl extends ElementImpl implements MappingParameterBinding {
	/**
	 * The number of structural features of the '<em>Mapping Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_PARAMETER_BINDING_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 2;
	/**
	 * The number of operations of the '<em>Mapping Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_PARAMETER_BINDING_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 1;
	/**
	 * The cached value of the '{@link #getBoundVariable() <em>Bound Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundVariable()
	 * @generated
	 * @ordered
	 */
	protected MappingParameter boundVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCall getOwningMappingCall() {
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 0)) return null;
		return (MappingCall)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMappingCall(MappingCall newOwningMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMappingCall, ElementImpl.ELEMENT_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMappingCall(MappingCall newOwningMappingCall) {
		if (newOwningMappingCall != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 0) && newOwningMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMappingCall != null)
				msgs = ((InternalEObject)newOwningMappingCall).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, MappingCall.class, msgs);
			msgs = basicSetOwningMappingCall(newOwningMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, newOwningMappingCall, newOwningMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingParameter getBoundVariable() {
		if (boundVariable != null && boundVariable.eIsProxy()) {
			InternalEObject oldBoundVariable = (InternalEObject)boundVariable;
			boundVariable = (MappingParameter)eResolveProxy(oldBoundVariable);
			if (boundVariable != oldBoundVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldBoundVariable, boundVariable));
			}
		}
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingParameter basicGetBoundVariable() {
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundVariable(MappingParameter newBoundVariable) {
		MappingParameter oldBoundVariable = boundVariable;
		boundVariable = newBoundVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, oldBoundVariable, boundVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateParameterIsMappingParameter(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "MappingParameterBinding::ParameterIsMappingParameter";
		try {
			/**
			 *
			 * inv ParameterIsMappingParameter:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = owningMappingCall.referredMapping.ownedMappingParameters->includes(boundVariable)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING___VALIDATE_PARAMETER_IS_MAPPING_PARAMETER__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull MappingCall owningMappingCall = this.getOwningMappingCall();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Mapping referredMapping = owningMappingCall.getReferredMapping();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<MappingParameter> ownedMappingParameters = referredMapping.getOwnedMappingParameters();
				final /*@NonInvalid*/ @NonNull SetValue BOXED_ownedMappingParameters = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_MappingParameter, ownedMappingParameters);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull MappingParameter boundVariable = this.getBoundVariable();
				final /*@NonInvalid*/ boolean result = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedMappingParameters, boundVariable).booleanValue();
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTimperativeTables.INT_0).booleanValue();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMappingCall((MappingCall)otherEnd, msgs);
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
				return basicSetOwningMappingCall(null, msgs);
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
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, MappingCall.class, msgs);
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
				return getOwningMappingCall();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				if (resolve) return getBoundVariable();
				return basicGetBoundVariable();
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
				setOwningMappingCall((MappingCall)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setBoundVariable((MappingParameter)newValue);
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
				setOwningMappingCall((MappingCall)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setBoundVariable((MappingParameter)null);
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
				return getOwningMappingCall() != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return boundVariable != null;
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
			case ElementImpl.ELEMENT_OPERATION_COUNT + 0:
				return validateParameterIsMappingParameter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}


} //MappingParameterBindingImpl
