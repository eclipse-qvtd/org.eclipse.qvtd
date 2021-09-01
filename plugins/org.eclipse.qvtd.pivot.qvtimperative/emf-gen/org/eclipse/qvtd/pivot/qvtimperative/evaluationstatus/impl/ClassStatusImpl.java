/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#getAssociationStatuses <em>Association Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#getEObject <em>EObject</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#isIsOutput <em>Is Output</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#getOwnedAttributeStatuses <em>Owned Attribute Statuses</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#getOwningTransformationStatus <em>Owning Transformation Status</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.ClassStatusImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassStatusImpl extends ElementStatusImpl implements ClassStatus {
	/**
	 * The number of structural features of the '<em>Class Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_STATUS_FEATURE_COUNT = ElementStatusImpl.ELEMENT_STATUS_FEATURE_COUNT + 7;

	/**
	 * The cached value of the '{@link #getAssociationStatuses() <em>Association Statuses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationStatus> associationStatuses;

	/**
	 * The cached value of the '{@link #getEObject() <em>EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject eObject;

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
	 * The cached value of the '{@link #getOwnedAttributeStatuses() <em>Owned Attribute Statuses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttributeStatuses()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeStatus> ownedAttributeStatuses;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.CLASS_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AssociationStatus> getAssociationStatuses() {
		if (associationStatuses == null) {
			associationStatuses = new EObjectResolvingEList<AssociationStatus>(AssociationStatus.class, this, 3);
		}
		return associationStatuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getEObject() {
		if (eObject != null && eObject.eIsProxy()) {
			InternalEObject oldEObject = (InternalEObject)eObject;
			eObject = eResolveProxy(oldEObject);
			if (eObject != oldEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 4, oldEObject, eObject));
			}
		}
		return eObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEObject() {
		return eObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEObject(EObject newEObject) {
		EObject oldEObject = eObject;
		eObject = newEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldEObject, eObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldIsInput, isInput));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldIsOutput, isOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeStatus> getOwnedAttributeStatuses() {
		if (ownedAttributeStatuses == null) {
			ownedAttributeStatuses = new EObjectContainmentWithInverseEList<AttributeStatus>(AttributeStatus.class, this, 7, 10);
		}
		return ownedAttributeStatuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransformationStatus getOwningTransformationStatus() {
		if (eContainerFeatureID() != (8)) return null;
		return (TransformationStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformationStatus(TransformationStatus newOwningTransformationStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformationStatus, 8, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformationStatus(TransformationStatus newOwningTransformationStatus) {
		if (newOwningTransformationStatus != eInternalContainer() || (eContainerFeatureID() != (8) && newOwningTransformationStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformationStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformationStatus != null)
				msgs = ((InternalEObject)newOwningTransformationStatus).eInverseAdd(this, 1, TransformationStatus.class, msgs);
			msgs = basicSetOwningTransformationStatus(newOwningTransformationStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 8, newOwningTransformationStatus, newOwningTransformationStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 9, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 9, oldType, type));
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
			case 7:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAttributeStatuses()).basicAdd(otherEnd, msgs);
			case 8:
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
			case 7:
				return ((InternalEList<?>)getOwnedAttributeStatuses()).basicRemove(otherEnd, msgs);
			case 8:
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
			case 8:
				return eInternalContainer().eInverseRemove(this, 1, TransformationStatus.class, msgs);
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
			case 3:
				return getAssociationStatuses();
			case 4:
				if (resolve) return getEObject();
				return basicGetEObject();
			case 5:
				return isIsInput();
			case 6:
				return isIsOutput();
			case 7:
				return getOwnedAttributeStatuses();
			case 8:
				return getOwningTransformationStatus();
			case 9:
				if (resolve) return getType();
				return basicGetType();
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
			case 3:
				getAssociationStatuses().clear();
				getAssociationStatuses().addAll((Collection<? extends AssociationStatus>)newValue);
				return;
			case 4:
				setEObject((EObject)newValue);
				return;
			case 5:
				setIsInput((Boolean)newValue);
				return;
			case 6:
				setIsOutput((Boolean)newValue);
				return;
			case 7:
				getOwnedAttributeStatuses().clear();
				getOwnedAttributeStatuses().addAll((Collection<? extends AttributeStatus>)newValue);
				return;
			case 8:
				setOwningTransformationStatus((TransformationStatus)newValue);
				return;
			case 9:
				setType((Type)newValue);
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
			case 3:
				getAssociationStatuses().clear();
				return;
			case 4:
				setEObject((EObject)null);
				return;
			case 5:
				setIsInput(IS_INPUT_EDEFAULT);
				return;
			case 6:
				setIsOutput(IS_OUTPUT_EDEFAULT);
				return;
			case 7:
				getOwnedAttributeStatuses().clear();
				return;
			case 8:
				setOwningTransformationStatus((TransformationStatus)null);
				return;
			case 9:
				setType((Type)null);
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
			case 3:
				return associationStatuses != null && !associationStatuses.isEmpty();
			case 4:
				return eObject != null;
			case 5:
				return isInput != IS_INPUT_EDEFAULT;
			case 6:
				return isOutput != IS_OUTPUT_EDEFAULT;
			case 7:
				return ownedAttributeStatuses != null && !ownedAttributeStatuses.isEmpty();
			case 8:
				return getOwningTransformationStatus() != null;
			case 9:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor) {
		return visitor.visitClassStatus(this);
	}

} //ClassStatusImpl
