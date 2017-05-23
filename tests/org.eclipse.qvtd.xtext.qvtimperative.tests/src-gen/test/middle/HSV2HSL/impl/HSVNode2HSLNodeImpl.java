/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.middle.HSV2HSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import test.hsl.HSLTree.HSLNode;
import test.hsv.HSVTree.HSVNode;
import test.middle.HSV2HSL.HSV2HSLPackage;
import test.middle.HSV2HSL.HSVNode2HSLNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HSV Node2 HSL Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getHsv <em>Hsv</em>}</li>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getHsl <em>Hsl</em>}</li>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getRgb <em>Rgb</em>}</li>
 *   <li>{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HSVNode2HSLNodeImpl extends MinimalEObjectImpl.Container implements HSVNode2HSLNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<HSVNode2HSLNode> children;

	/**
	 * The cached value of the '{@link #getHsv() <em>Hsv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsv()
	 * @generated
	 * @ordered
	 */
	protected HSVNode hsv;

	/**
	 * The cached value of the '{@link #getHsl() <em>Hsl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsl()
	 * @generated
	 * @ordered
	 */
	protected HSLNode hsl;

	/**
	 * The default value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected static final String RGB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected String rgb = RGB_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HSVNode2HSLNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HSV2HSLPackage.Literals.HSV_NODE2_HSL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSVNode2HSLNode getParent() {
		if (eContainerFeatureID() != HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT) return null;
		return (HSVNode2HSLNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HSVNode2HSLNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(HSVNode2HSLNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN, HSVNode2HSLNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<HSVNode2HSLNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HSVNode2HSLNode>(HSVNode2HSLNode.class, this, HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN, HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSVNode getHsv() {
		if (hsv != null && hsv.eIsProxy()) {
			InternalEObject oldHsv = (InternalEObject)hsv;
			hsv = (HSVNode)eResolveProxy(oldHsv);
			if (hsv != oldHsv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV, oldHsv, hsv));
			}
		}
		return hsv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVNode basicGetHsv() {
		return hsv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHsv(HSVNode newHsv) {
		HSVNode oldHsv = hsv;
		hsv = newHsv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV, oldHsv, hsv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSLNode getHsl() {
		if (hsl != null && hsl.eIsProxy()) {
			InternalEObject oldHsl = (InternalEObject)hsl;
			hsl = (HSLNode)eResolveProxy(oldHsl);
			if (hsl != oldHsl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL, oldHsl, hsl));
			}
		}
		return hsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSLNode basicGetHsl() {
		return hsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHsl(HSLNode newHsl) {
		HSLNode oldHsl = hsl;
		hsl = newHsl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL, oldHsl, hsl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRgb() {
		return rgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRgb(String newRgb) {
		String oldRgb = rgb;
		rgb = newRgb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HSLPackage.HSV_NODE2_HSL_NODE__RGB, oldRgb, rgb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HSLPackage.HSV_NODE2_HSL_NODE__NAME, oldName, name));
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HSVNode2HSLNode)otherEnd, msgs);
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				return basicSetParent(null, msgs);
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN, HSVNode2HSLNode.class, msgs);
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				return getParent();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				return getChildren();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV:
				if (resolve) return getHsv();
				return basicGetHsv();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL:
				if (resolve) return getHsl();
				return basicGetHsl();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__RGB:
				return getRgb();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__NAME:
				return getName();
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				setParent((HSVNode2HSLNode)newValue);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HSVNode2HSLNode>)newValue);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV:
				setHsv((HSVNode)newValue);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL:
				setHsl((HSLNode)newValue);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__RGB:
				setRgb((String)newValue);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__NAME:
				setName((String)newValue);
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				setParent((HSVNode2HSLNode)null);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				getChildren().clear();
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV:
				setHsv((HSVNode)null);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL:
				setHsl((HSLNode)null);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__RGB:
				setRgb(RGB_EDEFAULT);
				return;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__NAME:
				setName(NAME_EDEFAULT);
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
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__PARENT:
				return getParent() != null;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSV:
				return hsv != null;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__HSL:
				return hsl != null;
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__RGB:
				return RGB_EDEFAULT == null ? rgb != null : !RGB_EDEFAULT.equals(rgb);
			case HSV2HSLPackage.HSV_NODE2_HSL_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (rgb: ");
		result.append(rgb);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //HSVNode2HSLNodeImpl
