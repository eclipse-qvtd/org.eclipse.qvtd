/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TargetImpl#getOwningTransformation <em>Owning Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TargetImpl#getOwnedTargetElements <em>Owned Target Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetImpl extends NamedElementImpl implements Target {
	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getOwnedTargetElements() <em>Owned Target Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetElement> ownedTargetElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getOwningTransformation() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0)) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTransformation(Transformation newOwningTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTransformation, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTransformation(Transformation newOwningTransformation) {
		if (newOwningTransformation != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0) && newOwningTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTransformation != null)
				msgs = ((InternalEObject)newOwningTransformation).eInverseAdd(this, ClassImpl.CLASS_FEATURE_COUNT + 2, Transformation.class, msgs);
			msgs = basicSetOwningTransformation(newOwningTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, newOwningTransformation, newOwningTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetElement> getOwnedTargetElements() {
		if (ownedTargetElements == null) {
			ownedTargetElements = new EObjectContainmentEList<TargetElement>(TargetElement.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		}
		return ownedTargetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
			return basicSetOwningTransformation((Transformation)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return basicSetOwningTransformation(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedTargetElements()).basicRemove(otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, ClassImpl.CLASS_FEATURE_COUNT + 2, Transformation.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getOwningTransformation();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwnedTargetElements();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setOwningTransformation((Transformation)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedTargetElements().clear();
			getOwnedTargetElements().addAll((Collection<? extends TargetElement>)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setOwningTransformation((Transformation)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedTargetElements().clear();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getOwningTransformation() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ownedTargetElements != null && !ownedTargetElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitTarget(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //TargetImpl
