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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE, oldForwardEReference, forwardEReference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE, oldForwardEReference, forwardEReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassStatus> getFromClassStatuses() {
		if (fromClassStatuses == null) {
			fromClassStatuses = new EObjectResolvingEList<ClassStatus>(ClassStatus.class, this, EvaluationStatusPackage.ASSOCIATION_STATUS__FROM_CLASS_STATUSES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ASSOCIATION_STATUS__IS_INPUT, oldIsInput, isInput));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ASSOCIATION_STATUS__IS_OUTPUT, oldIsOutput, isOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformationStatus getOwningTransformationStatus() {
		if (eContainerFeatureID() != EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS) return null;
		return (TransformationStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformationStatus(TransformationStatus newOwningTransformationStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformationStatus, EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformationStatus(TransformationStatus newOwningTransformationStatus) {
		if (newOwningTransformationStatus != eInternalContainer() || (eContainerFeatureID() != EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS && newOwningTransformationStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformationStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformationStatus != null)
				msgs = ((InternalEObject)newOwningTransformationStatus).eInverseAdd(this, EvaluationStatusPackage.TRANSFORMATION_STATUS__OWNED_ASSOCIATION_STATUSES, TransformationStatus.class, msgs);
			msgs = basicSetOwningTransformationStatus(newOwningTransformationStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS, newOwningTransformationStatus, newOwningTransformationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassStatus> getToClassStatuses() {
		if (toClassStatuses == null) {
			toClassStatuses = new EObjectResolvingEList<ClassStatus>(ClassStatus.class, this, EvaluationStatusPackage.ASSOCIATION_STATUS__TO_CLASS_STATUSES);
		}
		return toClassStatuses;
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
				return eInternalContainer().eInverseRemove(this, EvaluationStatusPackage.TRANSFORMATION_STATUS__OWNED_ASSOCIATION_STATUSES, TransformationStatus.class, msgs);
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE:
				if (resolve) return getForwardEReference();
				return basicGetForwardEReference();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FROM_CLASS_STATUSES:
				return getFromClassStatuses();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_INPUT:
				return isIsInput();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_OUTPUT:
				return isIsOutput();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
				return getOwningTransformationStatus();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__TO_CLASS_STATUSES:
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE:
				setForwardEReference((EReference)newValue);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FROM_CLASS_STATUSES:
				getFromClassStatuses().clear();
				getFromClassStatuses().addAll((Collection<? extends ClassStatus>)newValue);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_INPUT:
				setIsInput((Boolean)newValue);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_OUTPUT:
				setIsOutput((Boolean)newValue);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
				setOwningTransformationStatus((TransformationStatus)newValue);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__TO_CLASS_STATUSES:
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE:
				setForwardEReference((EReference)null);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FROM_CLASS_STATUSES:
				getFromClassStatuses().clear();
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_INPUT:
				setIsInput(IS_INPUT_EDEFAULT);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_OUTPUT:
				setIsOutput(IS_OUTPUT_EDEFAULT);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
				setOwningTransformationStatus((TransformationStatus)null);
				return;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__TO_CLASS_STATUSES:
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
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FORWARD_EREFERENCE:
				return forwardEReference != null;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__FROM_CLASS_STATUSES:
				return fromClassStatuses != null && !fromClassStatuses.isEmpty();
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_INPUT:
				return isInput != IS_INPUT_EDEFAULT;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__IS_OUTPUT:
				return isOutput != IS_OUTPUT_EDEFAULT;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__OWNING_TRANSFORMATION_STATUS:
				return getOwningTransformationStatus() != null;
			case EvaluationStatusPackage.ASSOCIATION_STATUS__TO_CLASS_STATUSES:
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
