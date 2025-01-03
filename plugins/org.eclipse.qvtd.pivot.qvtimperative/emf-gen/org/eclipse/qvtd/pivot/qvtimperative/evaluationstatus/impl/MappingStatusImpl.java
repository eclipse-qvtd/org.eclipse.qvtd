/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
	 * The number of structural features of the '<em>Mapping Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_STATUS_FEATURE_COUNT = EvaluationElementImpl.EVALUATION_ELEMENT_FEATURE_COUNT + 8;

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
			boundValues = new EDataTypeUniqueEList<Object>(Object.class, this, 0);
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
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldDepth, depth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ElementStatus> getInputs() {
		if (inputs == null) {
			inputs = new EObjectWithInverseResolvingEList.ManyInverse<ElementStatus>(ElementStatus.class, this, 2, 2);
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
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldIsBlocked, isBlocked));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldIsDirty, isDirty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ElementStatus> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectWithInverseResolvingEList.ManyInverse<ElementStatus>(ElementStatus.class, this, 5, 1);
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
		if (eContainerFeatureID() != (6)) return null;
		return (TransformationStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformationStatus(TransformationStatus newOwningTransformationStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformationStatus, 6, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformationStatus(TransformationStatus newOwningTransformationStatus) {
		if (newOwningTransformationStatus != eInternalContainer() || (eContainerFeatureID() != (6) && newOwningTransformationStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformationStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformationStatus != null)
				msgs = ((InternalEObject)newOwningTransformationStatus).eInverseAdd(this, 2, TransformationStatus.class, msgs);
			msgs = basicSetOwningTransformationStatus(newOwningTransformationStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 6, newOwningTransformationStatus, newOwningTransformationStatus));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 7, oldReferredMappingCall, referredMappingCall));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 7, oldReferredMappingCall, referredMappingCall));
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputs()).basicAdd(otherEnd, msgs);
			case 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
			case 6:
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
			case 2:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case 5:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case 6:
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
			case 6:
				return eInternalContainer().eInverseRemove(this, 2, TransformationStatus.class, msgs);
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
			case 0:
				return getBoundValues();
			case 1:
				return getDepth();
			case 2:
				return getInputs();
			case 3:
				return isIsBlocked();
			case 4:
				return isIsDirty();
			case 5:
				return getOutputs();
			case 6:
				return getOwningTransformationStatus();
			case 7:
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
			case 0:
				getBoundValues().clear();
				getBoundValues().addAll((Collection<? extends Object>)newValue);
				return;
			case 1:
				setDepth((Integer)newValue);
				return;
			case 2:
				getInputs().clear();
				getInputs().addAll((Collection<? extends ElementStatus>)newValue);
				return;
			case 3:
				setIsBlocked((Boolean)newValue);
				return;
			case 4:
				setIsDirty((Boolean)newValue);
				return;
			case 5:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends ElementStatus>)newValue);
				return;
			case 6:
				setOwningTransformationStatus((TransformationStatus)newValue);
				return;
			case 7:
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
			case 0:
				getBoundValues().clear();
				return;
			case 1:
				setDepth(DEPTH_EDEFAULT);
				return;
			case 2:
				getInputs().clear();
				return;
			case 3:
				setIsBlocked(IS_BLOCKED_EDEFAULT);
				return;
			case 4:
				setIsDirty(IS_DIRTY_EDEFAULT);
				return;
			case 5:
				getOutputs().clear();
				return;
			case 6:
				setOwningTransformationStatus((TransformationStatus)null);
				return;
			case 7:
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
			case 0:
				return boundValues != null && !boundValues.isEmpty();
			case 1:
				return DEPTH_EDEFAULT == null ? depth != null : !DEPTH_EDEFAULT.equals(depth);
			case 2:
				return inputs != null && !inputs.isEmpty();
			case 3:
				return isBlocked != IS_BLOCKED_EDEFAULT;
			case 4:
				return isDirty != IS_DIRTY_EDEFAULT;
			case 5:
				return outputs != null && !outputs.isEmpty();
			case 6:
				return getOwningTransformationStatus() != null;
			case 7:
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
