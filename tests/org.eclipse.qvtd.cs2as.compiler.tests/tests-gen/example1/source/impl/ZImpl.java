/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package example1.source.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import example1.source.PathNameCS;
import example1.source.SourcePackage;
import example1.source.Y;
import example1.source.Z;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Z</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example1.source.impl.ZImpl#getToY <em>To Y</em>}</li>
 *   <li>{@link example1.source.impl.ZImpl#getRefers <em>Refers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ZImpl extends SElementImpl implements Z {
	/**
	 * The cached value of the '{@link #getRefers() <em>Refers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefers()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS refers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ZImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.Z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Y getToY() {
		if (eContainerFeatureID() != SourcePackage.Z__TO_Y) return null;
		return (Y)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToY(Y newToY, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToY, SourcePackage.Z__TO_Y, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToY(Y newToY) {
		if (newToY != eInternalContainer() || (eContainerFeatureID() != SourcePackage.Z__TO_Y && newToY != null)) {
			if (EcoreUtil.isAncestor(this, newToY))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToY != null)
				msgs = ((InternalEObject)newToY).eInverseAdd(this, SourcePackage.Y__OWNS_Z, Y.class, msgs);
			msgs = basicSetToY(newToY, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.Z__TO_Y, newToY, newToY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getRefers() {
		return refers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefers(PathNameCS newRefers, NotificationChain msgs) {
		PathNameCS oldRefers = refers;
		refers = newRefers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SourcePackage.Z__REFERS, oldRefers, newRefers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefers(PathNameCS newRefers) {
		if (newRefers != refers) {
			NotificationChain msgs = null;
			if (refers != null)
				msgs = ((InternalEObject)refers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SourcePackage.Z__REFERS, null, msgs);
			if (newRefers != null)
				msgs = ((InternalEObject)newRefers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SourcePackage.Z__REFERS, null, msgs);
			msgs = basicSetRefers(newRefers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.Z__REFERS, newRefers, newRefers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SourcePackage.Z__TO_Y:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToY((Y)otherEnd, msgs);
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
			case SourcePackage.Z__TO_Y:
				return basicSetToY(null, msgs);
			case SourcePackage.Z__REFERS:
				return basicSetRefers(null, msgs);
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
			case SourcePackage.Z__TO_Y:
				return eInternalContainer().eInverseRemove(this, SourcePackage.Y__OWNS_Z, Y.class, msgs);
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
			case SourcePackage.Z__TO_Y:
				return getToY();
			case SourcePackage.Z__REFERS:
				return getRefers();
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
			case SourcePackage.Z__TO_Y:
				setToY((Y)newValue);
				return;
			case SourcePackage.Z__REFERS:
				setRefers((PathNameCS)newValue);
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
			case SourcePackage.Z__TO_Y:
				setToY((Y)null);
				return;
			case SourcePackage.Z__REFERS:
				setRefers((PathNameCS)null);
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
			case SourcePackage.Z__TO_Y:
				return getToY() != null;
			case SourcePackage.Z__REFERS:
				return refers != null;
		}
		return super.eIsSet(featureID);
	}

} //ZImpl
