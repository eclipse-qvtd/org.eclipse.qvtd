/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: DomainImpl.java,v 1.3 2009/02/17 21:44:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl#isIsCheckable <em>Is Checkable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl#isIsEnforceable <em>Is Enforceable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DomainImpl extends ENamedElementImpl implements Domain {
	/**
	 * The default value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheckable() <em>Is Checkable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckable()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckable = IS_CHECKABLE_EDEFAULT;

	/**
	 * This is true if the Is Checkable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckableESet;

	/**
	 * The default value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforceable() <em>Is Enforceable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceable()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceable = IS_ENFORCEABLE_EDEFAULT;

	/**
	 * This is true if the Is Enforceable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceableESet;

	/**
	 * The cached value of the '{@link #getTypedModel() <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel typedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTBasePackage.Literals.DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCheckable() {
		return isCheckable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCheckable(boolean newIsCheckable) {
		boolean oldIsCheckable = isCheckable;
		isCheckable = newIsCheckable;
		boolean oldIsCheckableESet = isCheckableESet;
		isCheckableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, isCheckable, !oldIsCheckableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsCheckable() {
		boolean oldIsCheckable = isCheckable;
		boolean oldIsCheckableESet = isCheckableESet;
		isCheckable = IS_CHECKABLE_EDEFAULT;
		isCheckableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTBasePackage.DOMAIN__IS_CHECKABLE, oldIsCheckable, IS_CHECKABLE_EDEFAULT, oldIsCheckableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsCheckable() {
		return isCheckableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEnforceable() {
		return isEnforceable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnforceable(boolean newIsEnforceable) {
		boolean oldIsEnforceable = isEnforceable;
		isEnforceable = newIsEnforceable;
		boolean oldIsEnforceableESet = isEnforceableESet;
		isEnforceableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.DOMAIN__IS_ENFORCEABLE, oldIsEnforceable, isEnforceable, !oldIsEnforceableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsEnforceable() {
		boolean oldIsEnforceable = isEnforceable;
		boolean oldIsEnforceableESet = isEnforceableESet;
		isEnforceable = IS_ENFORCEABLE_EDEFAULT;
		isEnforceableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTBasePackage.DOMAIN__IS_ENFORCEABLE, oldIsEnforceable, IS_ENFORCEABLE_EDEFAULT, oldIsEnforceableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsEnforceable() {
		return isEnforceableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getRule() {
		if (eContainerFeatureID() != QVTBasePackage.DOMAIN__RULE) return null;
		return (Rule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRule(Rule newRule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRule, QVTBasePackage.DOMAIN__RULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(Rule newRule) {
		if (newRule != eInternalContainer() || (eContainerFeatureID() != QVTBasePackage.DOMAIN__RULE && newRule != null)) {
			if (EcoreUtil.isAncestor(this, newRule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRule != null)
				msgs = ((InternalEObject)newRule).eInverseAdd(this, QVTBasePackage.RULE__DOMAIN, Rule.class, msgs);
			msgs = basicSetRule(newRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.DOMAIN__RULE, newRule, newRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getTypedModel() {
		if (typedModel != null && typedModel.eIsProxy()) {
			InternalEObject oldTypedModel = (InternalEObject)typedModel;
			typedModel = (TypedModel)eResolveProxy(oldTypedModel);
			if (typedModel != oldTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTBasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
			}
		}
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetTypedModel() {
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedModel(TypedModel newTypedModel) {
		TypedModel oldTypedModel = typedModel;
		typedModel = newTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.DOMAIN__TYPED_MODEL, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTBasePackage.DOMAIN__RULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRule((Rule)otherEnd, msgs);
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
			case QVTBasePackage.DOMAIN__RULE:
				return basicSetRule(null, msgs);
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
			case QVTBasePackage.DOMAIN__RULE:
				return eInternalContainer().eInverseRemove(this, QVTBasePackage.RULE__DOMAIN, Rule.class, msgs);
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
			case QVTBasePackage.DOMAIN__IS_CHECKABLE:
				return isIsCheckable();
			case QVTBasePackage.DOMAIN__IS_ENFORCEABLE:
				return isIsEnforceable();
			case QVTBasePackage.DOMAIN__RULE:
				return getRule();
			case QVTBasePackage.DOMAIN__TYPED_MODEL:
				if (resolve) return getTypedModel();
				return basicGetTypedModel();
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
			case QVTBasePackage.DOMAIN__IS_CHECKABLE:
				setIsCheckable((Boolean)newValue);
				return;
			case QVTBasePackage.DOMAIN__IS_ENFORCEABLE:
				setIsEnforceable((Boolean)newValue);
				return;
			case QVTBasePackage.DOMAIN__RULE:
				setRule((Rule)newValue);
				return;
			case QVTBasePackage.DOMAIN__TYPED_MODEL:
				setTypedModel((TypedModel)newValue);
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
			case QVTBasePackage.DOMAIN__IS_CHECKABLE:
				unsetIsCheckable();
				return;
			case QVTBasePackage.DOMAIN__IS_ENFORCEABLE:
				unsetIsEnforceable();
				return;
			case QVTBasePackage.DOMAIN__RULE:
				setRule((Rule)null);
				return;
			case QVTBasePackage.DOMAIN__TYPED_MODEL:
				setTypedModel((TypedModel)null);
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
			case QVTBasePackage.DOMAIN__IS_CHECKABLE:
				return isSetIsCheckable();
			case QVTBasePackage.DOMAIN__IS_ENFORCEABLE:
				return isSetIsEnforceable();
			case QVTBasePackage.DOMAIN__RULE:
				return getRule() != null;
			case QVTBasePackage.DOMAIN__TYPED_MODEL:
				return typedModel != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCheckable: ");
		if (isCheckableESet) result.append(isCheckable); else result.append("<unset>");
		result.append(", isEnforceable: ");
		if (isEnforceableESet) result.append(isEnforceable); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //DomainImpl
