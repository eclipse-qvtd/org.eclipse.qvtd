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
package example1.target.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import example1.target.A2;
import example1.target.C;
import example1.target.D;
import example1.target.TargetPackage;
import example1.target.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example1.target.impl.CImpl#getToA2 <em>To A2</em>}</li>
 *   <li>{@link example1.target.impl.CImpl#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CImpl extends NamespaceImpl implements C {
	/**
	 * The cached value of the '{@link #getOwnsD() <em>Owns D</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsD()
	 * @generated
	 * @ordered
	 */
	protected D ownsD;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A2 getToA2() {
		if (eContainerFeatureID() != TargetPackage.C__TO_A2) return null;
		return (A2)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToA2(A2 newToA2, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToA2, TargetPackage.C__TO_A2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToA2(A2 newToA2) {
		if (newToA2 != eInternalContainer() || (eContainerFeatureID() != TargetPackage.C__TO_A2 && newToA2 != null)) {
			if (EcoreUtil.isAncestor(this, newToA2))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToA2 != null)
				msgs = ((InternalEObject)newToA2).eInverseAdd(this, TargetPackage.A2__OWNS_C, A2.class, msgs);
			msgs = basicSetToA2(newToA2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.C__TO_A2, newToA2, newToA2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D getOwnsD() {
		return ownsD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnsD(D newOwnsD, NotificationChain msgs) {
		D oldOwnsD = ownsD;
		ownsD = newOwnsD;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPackage.C__OWNS_D, oldOwnsD, newOwnsD);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnsD(D newOwnsD) {
		if (newOwnsD != ownsD) {
			NotificationChain msgs = null;
			if (ownsD != null)
				msgs = ((InternalEObject)ownsD).eInverseRemove(this, TargetPackage.D__TO_C, D.class, msgs);
			if (newOwnsD != null)
				msgs = ((InternalEObject)newOwnsD).eInverseAdd(this, TargetPackage.D__TO_C, D.class, msgs);
			msgs = basicSetOwnsD(newOwnsD, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.C__OWNS_D, newOwnsD, newOwnsD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPackage.C__TO_A2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToA2((A2)otherEnd, msgs);
			case TargetPackage.C__OWNS_D:
				if (ownsD != null)
					msgs = ((InternalEObject)ownsD).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPackage.C__OWNS_D, null, msgs);
				return basicSetOwnsD((D)otherEnd, msgs);
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
			case TargetPackage.C__TO_A2:
				return basicSetToA2(null, msgs);
			case TargetPackage.C__OWNS_D:
				return basicSetOwnsD(null, msgs);
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
			case TargetPackage.C__TO_A2:
				return eInternalContainer().eInverseRemove(this, TargetPackage.A2__OWNS_C, A2.class, msgs);
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
			case TargetPackage.C__TO_A2:
				return getToA2();
			case TargetPackage.C__OWNS_D:
				return getOwnsD();
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
			case TargetPackage.C__TO_A2:
				setToA2((A2)newValue);
				return;
			case TargetPackage.C__OWNS_D:
				setOwnsD((D)newValue);
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
			case TargetPackage.C__TO_A2:
				setToA2((A2)null);
				return;
			case TargetPackage.C__OWNS_D:
				setOwnsD((D)null);
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
			case TargetPackage.C__TO_A2:
				return getToA2() != null;
			case TargetPackage.C__OWNS_D:
				return ownsD != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitC(this);
	}

} //CImpl
