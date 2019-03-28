/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
	 * The number of structural features of the '<em>HSV Node2 HSL Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HSV_NODE2_HSL_NODE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>HSV Node2 HSL Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int HSV_NODE2_HSL_NODE_OPERATION_COUNT = 0;

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
		if (eContainerFeatureID() != (0)) return null;
		return (HSVNode2HSLNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HSVNode2HSLNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(HSVNode2HSLNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != (0) && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, 1, HSVNode2HSLNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 0, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<HSVNode2HSLNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HSVNode2HSLNode>(HSVNode2HSLNode.class, this, 1, 0);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 2, oldHsv, hsv));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldHsv, hsv));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 3, oldHsl, hsl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldHsl, hsl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldRgb, rgb));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldName, name));
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
			case 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HSVNode2HSLNode)otherEnd, msgs);
			case 1:
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
			case 0:
				return basicSetParent(null, msgs);
			case 1:
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
			case 0:
				return eInternalContainer().eInverseRemove(this, 1, HSVNode2HSLNode.class, msgs);
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
				return getParent();
			case 1:
				return getChildren();
			case 2:
				if (resolve) return getHsv();
				return basicGetHsv();
			case 3:
				if (resolve) return getHsl();
				return basicGetHsl();
			case 4:
				return getRgb();
			case 5:
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
			case 0:
				setParent((HSVNode2HSLNode)newValue);
				return;
			case 1:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HSVNode2HSLNode>)newValue);
				return;
			case 2:
				setHsv((HSVNode)newValue);
				return;
			case 3:
				setHsl((HSLNode)newValue);
				return;
			case 4:
				setRgb((String)newValue);
				return;
			case 5:
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
			case 0:
				setParent((HSVNode2HSLNode)null);
				return;
			case 1:
				getChildren().clear();
				return;
			case 2:
				setHsv((HSVNode)null);
				return;
			case 3:
				setHsl((HSLNode)null);
				return;
			case 4:
				setRgb(RGB_EDEFAULT);
				return;
			case 5:
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
			case 0:
				return getParent() != null;
			case 1:
				return children != null && !children.isEmpty();
			case 2:
				return hsv != null;
			case 3:
				return hsl != null;
			case 4:
				return RGB_EDEFAULT == null ? rgb != null : !RGB_EDEFAULT.equals(rgb);
			case 5:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (rgb: ");
		result.append(rgb);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //HSVNode2HSLNodeImpl
