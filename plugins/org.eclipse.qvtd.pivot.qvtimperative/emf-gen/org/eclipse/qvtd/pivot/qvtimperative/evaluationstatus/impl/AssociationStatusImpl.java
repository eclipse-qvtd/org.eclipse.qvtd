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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#getForwardEReference <em>Forward EReference</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#getFromClassStatuses <em>From Class Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#isIsOutput <em>Is Output</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#getOwningTransformationStatus <em>Owning Transformation Status</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AssociationStatusImpl#getToClassStatuses <em>To Class Statuses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationStatusImpl extends PropertyStatusImpl implements AssociationStatus {
	/**
	 * The number of structural features of the '<em>Association Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSOCIATION_STATUS_FEATURE_COUNT = PropertyStatusImpl.PROPERTY_STATUS_FEATURE_COUNT + 6;

	/**
	 * The cached value of the '{@link #getForwardEReference() <em>Forward EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference forwardEReference;

	/**
	 * The cached value of the '{@link #getFromClassStatuses() <em>From Class Statuses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromClassStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassStatus> fromClassStatuses;

	/**
	 * The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected boolean isInput = IS_INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOutput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OUTPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOutput()
	 * @generated
	 * @ordered
	 */
	protected boolean isOutput = IS_OUTPUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getToClassStatuses() <em>To Class Statuses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToClassStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassStatus> toClassStatuses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.ASSOCIATION_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForwardEReference() {
		if (forwardEReference != null && forwardEReference.eIsProxy()) {
			InternalEObject oldForwardEReference = (InternalEObject)forwardEReference;
			forwardEReference = (EReference)eResolveProxy(oldForwardEReference);
			if (forwardEReference != oldForwardEReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 8, oldForwardEReference, forwardEReference));
			}
		}
		return forwardEReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetForwardEReference() {
		return forwardEReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForwardEReference(EReference newForwardEReference) {
		EReference oldForwardEReference = forwardEReference;
		forwardEReference = newForwardEReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, oldForwardEReference, forwardEReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassStatus> getFromClassStatuses() {
		if (fromClassStatuses == null) {
			fromClassStatuses = new EObjectResolvingEList<ClassStatus>(ClassStatus.class, this, 9);
		}
		return fromClassStatuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInput() {
		return isInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInput(boolean newIsInput) {
		boolean oldIsInput = isInput;
		isInput = newIsInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 10, oldIsInput, isInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOutput() {
		return isOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOutput(boolean newIsOutput) {
		boolean oldIsOutput = isOutput;
		isOutput = newIsOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 11, oldIsOutput, isOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformationStatus getOwningTransformationStatus() {
		if (eContainerFeatureID() != (12)) return null;
		return (TransformationStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformationStatus(TransformationStatus newOwningTransformationStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformationStatus, 12, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformationStatus(TransformationStatus newOwningTransformationStatus) {
		if (newOwningTransformationStatus != eInternalContainer() || (eContainerFeatureID() != (12) && newOwningTransformationStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformationStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformationStatus != null)
				msgs = ((InternalEObject)newOwningTransformationStatus).eInverseAdd(this, 0, TransformationStatus.class, msgs);
			msgs = basicSetOwningTransformationStatus(newOwningTransformationStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 12, newOwningTransformationStatus, newOwningTransformationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassStatus> getToClassStatuses() {
		if (toClassStatuses == null) {
			toClassStatuses = new EObjectResolvingEList<ClassStatus>(ClassStatus.class, this, 13);
		}
		return toClassStatuses;
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
			case 12:
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
			case 12:
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
			case 12:
				return eInternalContainer().eInverseRemove(this, 0, TransformationStatus.class, msgs);
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
			case 8:
				if (resolve) return getForwardEReference();
				return basicGetForwardEReference();
			case 9:
				return getFromClassStatuses();
			case 10:
				return isIsInput();
			case 11:
				return isIsOutput();
			case 12:
				return getOwningTransformationStatus();
			case 13:
				return getToClassStatuses();
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
			case 8:
				setForwardEReference((EReference)newValue);
				return;
			case 9:
				getFromClassStatuses().clear();
				getFromClassStatuses().addAll((Collection<? extends ClassStatus>)newValue);
				return;
			case 10:
				setIsInput((Boolean)newValue);
				return;
			case 11:
				setIsOutput((Boolean)newValue);
				return;
			case 12:
				setOwningTransformationStatus((TransformationStatus)newValue);
				return;
			case 13:
				getToClassStatuses().clear();
				getToClassStatuses().addAll((Collection<? extends ClassStatus>)newValue);
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
			case 8:
				setForwardEReference((EReference)null);
				return;
			case 9:
				getFromClassStatuses().clear();
				return;
			case 10:
				setIsInput(IS_INPUT_EDEFAULT);
				return;
			case 11:
				setIsOutput(IS_OUTPUT_EDEFAULT);
				return;
			case 12:
				setOwningTransformationStatus((TransformationStatus)null);
				return;
			case 13:
				getToClassStatuses().clear();
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
			case 8:
				return forwardEReference != null;
			case 9:
				return fromClassStatuses != null && !fromClassStatuses.isEmpty();
			case 10:
				return isInput != IS_INPUT_EDEFAULT;
			case 11:
				return isOutput != IS_OUTPUT_EDEFAULT;
			case 12:
				return getOwningTransformationStatus() != null;
			case 13:
				return toClassStatuses != null && !toClassStatuses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor) {
		return visitor.visitAssociationStatus(this);
	}

} //AssociationStatusImpl
