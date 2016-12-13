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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
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
		if (eContainerFeatureID() != QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL) return null;
		return (MappingCall)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMappingCall(MappingCall newOwningMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMappingCall, QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMappingCall(MappingCall newOwningMappingCall) {
		if (newOwningMappingCall != eInternalContainer() || (eContainerFeatureID() != QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL && newOwningMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMappingCall != null)
				msgs = ((InternalEObject)newOwningMappingCall).eInverseAdd(this, QVTimperativePackage.MAPPING_CALL__OWNED_MAPPING_PARAMETER_BINDINGS, MappingCall.class, msgs);
			msgs = basicSetOwningMappingCall(newOwningMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL, newOwningMappingCall, newOwningMappingCall));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateParameterIsMappingParameter(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv ParameterIsMappingParameter:
		 *   let
		 *     severity : Integer[1] = 'MappingParameterBinding::ParameterIsMappingParameter'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = owningMappingCall.referredMapping.ownedMappingParameters->includes(boundVariable)
		 *       in
		 *         'MappingParameterBinding::ParameterIsMappingParameter'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_MappingParameterBinding_c_c_ParameterIsMappingParameter);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_status;
			try {
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall owningMappingCall = this.getOwningMappingCall();
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping referredMapping = owningMappingCall.getReferredMapping();
				@SuppressWarnings("null")
				final /*@Thrown*/ java.util.@NonNull List<MappingParameter> ownedMappingParameters = referredMapping.getOwnedMappingParameters();
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_ownedMappingParameters = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_MappingParameter, ownedMappingParameters);
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter boundVariable = this.getBoundVariable();
				final /*@Thrown*/ boolean status = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownedMappingParameters, boundVariable).booleanValue();
				CAUGHT_status = status;
			}
			catch (Exception e) {
				CAUGHT_status = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_MappingParameterBinding_c_c_ParameterIsMappingParameter, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, QVTimperativeTables.INT_0).booleanValue();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
				return eInternalContainer().eInverseRemove(this, QVTimperativePackage.MAPPING_CALL__OWNED_MAPPING_PARAMETER_BINDINGS, MappingCall.class, msgs);
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
				return getOwningMappingCall();
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
				setOwningMappingCall((MappingCall)newValue);
				return;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
				setOwningMappingCall((MappingCall)null);
				return;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__OWNING_MAPPING_CALL:
				return getOwningMappingCall() != null;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING___VALIDATE_PARAMETER_IS_MAPPING_PARAMETER__DIAGNOSTICCHAIN_MAP:
				return validateParameterIsMappingParameter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}


} //MappingParameterBindingImpl
