/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getBoundValues <em>Bound Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getDepth <em>Depth</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#isIsBlocked <em>Is Blocked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#isIsDirty <em>Is Dirty</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getOwningTransformationStatus <em>Owning Transformation Status</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.MappingStatusImpl#getReferredMappingCall <em>Referred Mapping Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingStatusImpl extends EvaluationElementImpl implements MappingStatus {
	/**
	 * The cached value of the '{@link #getBoundValues() <em>Bound Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> boundValues;

	/**
	 * The default value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DEPTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected Integer depth = DEPTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementStatus> inputs;

	/**
	 * The default value of the '{@link #isIsBlocked() <em>Is Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlocked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BLOCKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBlocked() <em>Is Blocked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlocked()
	 * @generated
	 * @ordered
	 */
	protected boolean isBlocked = IS_BLOCKED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDirty() <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDirty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DIRTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDirty() <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDirty()
	 * @generated
	 * @ordered
	 */
	protected boolean isDirty = IS_DIRTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementStatus> outputs;

	/**
	 * The cached value of the '{@link #getReferredMappingCall() <em>Referred Mapping Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredMappingCall()
	 * @generated
	 * @ordered
	 */
	protected MappingCall referredMappingCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.MAPPING_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<Object> getBoundValues() {
		if (boundValues == null) {
			boundValues = new EDataTypeUniqueEList<Object>(Object.class, this, EvaluationStatusPackage.MAPPING_STATUS__BOUND_VALUES);
		}
		return boundValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getDepth() {
		return depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepth(Integer newDepth) {
		Integer oldDepth = depth;
		depth = newDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.MAPPING_STATUS__DEPTH, oldDepth, depth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ElementStatus> getInputs() {
		if (inputs == null) {
			inputs = new EObjectWithInverseResolvingEList.ManyInverse<ElementStatus>(ElementStatus.class, this, EvaluationStatusPackage.MAPPING_STATUS__INPUTS, EvaluationStatusPackage.ELEMENT_STATUS__TARGETS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsBlocked() {
		return isBlocked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsBlocked(boolean newIsBlocked) {
		boolean oldIsBlocked = isBlocked;
		isBlocked = newIsBlocked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.MAPPING_STATUS__IS_BLOCKED, oldIsBlocked, isBlocked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDirty() {
		return isDirty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDirty(boolean newIsDirty) {
		boolean oldIsDirty = isDirty;
		isDirty = newIsDirty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.MAPPING_STATUS__IS_DIRTY, oldIsDirty, isDirty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ElementStatus> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectWithInverseResolvingEList.ManyInverse<ElementStatus>(ElementStatus.class, this, EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS, EvaluationStatusPackage.ELEMENT_STATUS__SOURCES);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformationStatus getOwningTransformationStatus() {
		if (eContainerFeatureID() != EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS) return null;
		return (TransformationStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformationStatus(TransformationStatus newOwningTransformationStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformationStatus, EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformationStatus(TransformationStatus newOwningTransformationStatus) {
		if (newOwningTransformationStatus != eInternalContainer() || (eContainerFeatureID() != EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS && newOwningTransformationStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformationStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformationStatus != null)
				msgs = ((InternalEObject)newOwningTransformationStatus).eInverseAdd(this, EvaluationStatusPackage.TRANSFORMATION_STATUS__OWNED_MAPPING_STATUSES, TransformationStatus.class, msgs);
			msgs = basicSetOwningTransformationStatus(newOwningTransformationStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS, newOwningTransformationStatus, newOwningTransformationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCall getReferredMappingCall() {
		if (referredMappingCall != null && referredMappingCall.eIsProxy()) {
			InternalEObject oldReferredMappingCall = (InternalEObject)referredMappingCall;
			referredMappingCall = (MappingCall)eResolveProxy(oldReferredMappingCall);
			if (referredMappingCall != oldReferredMappingCall) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL, oldReferredMappingCall, referredMappingCall));
			}
		}
		return referredMappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCall basicGetReferredMappingCall() {
		return referredMappingCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredMappingCall(MappingCall newReferredMappingCall) {
		MappingCall oldReferredMappingCall = referredMappingCall;
		referredMappingCall = newReferredMappingCall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL, oldReferredMappingCall, referredMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputs()).basicAdd(otherEnd, msgs);
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTransformationStatus((TransformationStatus)otherEnd, msgs);
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
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				return basicSetOwningTransformationStatus(null, msgs);
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
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				return eInternalContainer().eInverseRemove(this, EvaluationStatusPackage.TRANSFORMATION_STATUS__OWNED_MAPPING_STATUSES, TransformationStatus.class, msgs);
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
			case EvaluationStatusPackage.MAPPING_STATUS__BOUND_VALUES:
				return getBoundValues();
			case EvaluationStatusPackage.MAPPING_STATUS__DEPTH:
				return getDepth();
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				return getInputs();
			case EvaluationStatusPackage.MAPPING_STATUS__IS_BLOCKED:
				return isIsBlocked();
			case EvaluationStatusPackage.MAPPING_STATUS__IS_DIRTY:
				return isIsDirty();
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				return getOutputs();
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				return getOwningTransformationStatus();
			case EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL:
				if (resolve) return getReferredMappingCall();
				return basicGetReferredMappingCall();
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
			case EvaluationStatusPackage.MAPPING_STATUS__BOUND_VALUES:
				getBoundValues().clear();
				getBoundValues().addAll((Collection<? extends Object>)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__DEPTH:
				setDepth((Integer)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends ElementStatus>)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__IS_BLOCKED:
				setIsBlocked((Boolean)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__IS_DIRTY:
				setIsDirty((Boolean)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends ElementStatus>)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				setOwningTransformationStatus((TransformationStatus)newValue);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL:
				setReferredMappingCall((MappingCall)newValue);
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
			case EvaluationStatusPackage.MAPPING_STATUS__BOUND_VALUES:
				getBoundValues().clear();
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__DEPTH:
				setDepth(DEPTH_EDEFAULT);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				getInputs().clear();
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__IS_BLOCKED:
				setIsBlocked(IS_BLOCKED_EDEFAULT);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__IS_DIRTY:
				setIsDirty(IS_DIRTY_EDEFAULT);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				getOutputs().clear();
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				setOwningTransformationStatus((TransformationStatus)null);
				return;
			case EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL:
				setReferredMappingCall((MappingCall)null);
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
			case EvaluationStatusPackage.MAPPING_STATUS__BOUND_VALUES:
				return boundValues != null && !boundValues.isEmpty();
			case EvaluationStatusPackage.MAPPING_STATUS__DEPTH:
				return DEPTH_EDEFAULT == null ? depth != null : !DEPTH_EDEFAULT.equals(depth);
			case EvaluationStatusPackage.MAPPING_STATUS__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case EvaluationStatusPackage.MAPPING_STATUS__IS_BLOCKED:
				return isBlocked != IS_BLOCKED_EDEFAULT;
			case EvaluationStatusPackage.MAPPING_STATUS__IS_DIRTY:
				return isDirty != IS_DIRTY_EDEFAULT;
			case EvaluationStatusPackage.MAPPING_STATUS__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case EvaluationStatusPackage.MAPPING_STATUS__OWNING_TRANSFORMATION_STATUS:
				return getOwningTransformationStatus() != null;
			case EvaluationStatusPackage.MAPPING_STATUS__REFERRED_MAPPING_CALL:
				return referredMappingCall != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor) {
		return visitor.visitMappingStatus(this);
	}
} //MappingStatusImpl
