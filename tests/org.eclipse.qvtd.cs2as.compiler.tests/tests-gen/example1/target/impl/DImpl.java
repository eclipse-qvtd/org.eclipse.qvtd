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
import example1.target.A;
import example1.target.B;
import example1.target.C;
import example1.target.D;
import example1.target.TargetPackage;
import example1.target.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example1.target.impl.DImpl#getToC <em>To C</em>}</li>
 *   <li>{@link example1.target.impl.DImpl#getToB <em>To B</em>}</li>
 *   <li>{@link example1.target.impl.DImpl#getToA <em>To A</em>}</li>
 *   <li>{@link example1.target.impl.DImpl#getRefsB <em>Refs B</em>}</li>
 *   <li>{@link example1.target.impl.DImpl#getRefsC <em>Refs C</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DImpl extends NamedElementImpl implements D {
	/**
	 * The cached value of the '{@link #getToA() <em>To A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToA()
	 * @generated
	 * @ordered
	 */
	protected A toA;

	/**
	 * The cached value of the '{@link #getRefsB() <em>Refs B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefsB()
	 * @generated
	 * @ordered
	 */
	protected B refsB;

	/**
	 * The cached value of the '{@link #getRefsC() <em>Refs C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefsC()
	 * @generated
	 * @ordered
	 */
	protected C refsC;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C getToC() {
		if (eContainerFeatureID() != TargetPackage.D__TO_C) return null;
		return (C)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToC(C newToC, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToC, TargetPackage.D__TO_C, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToC(C newToC) {
		if (newToC != eInternalContainer() || (eContainerFeatureID() != TargetPackage.D__TO_C && newToC != null)) {
			if (EcoreUtil.isAncestor(this, newToC))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToC != null)
				msgs = ((InternalEObject)newToC).eInverseAdd(this, TargetPackage.C__OWNS_D, C.class, msgs);
			msgs = basicSetToC(newToC, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.D__TO_C, newToC, newToC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B getToB() {
		if (eContainerFeatureID() != TargetPackage.D__TO_B) return null;
		return (B)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToB(B newToB, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newToB, TargetPackage.D__TO_B, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToB(B newToB) {
		if (newToB != eInternalContainer() || (eContainerFeatureID() != TargetPackage.D__TO_B && newToB != null)) {
			if (EcoreUtil.isAncestor(this, newToB))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToB != null)
				msgs = ((InternalEObject)newToB).eInverseAdd(this, TargetPackage.B__OWNS_D, B.class, msgs);
			msgs = basicSetToB(newToB, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.D__TO_B, newToB, newToB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A getToA() {
		if (toA != null && toA.eIsProxy()) {
			InternalEObject oldToA = (InternalEObject)toA;
			toA = (A)eResolveProxy(oldToA);
			if (toA != oldToA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetPackage.D__TO_A, oldToA, toA));
			}
		}
		return toA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A basicGetToA() {
		return toA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToA(A newToA) {
		A oldToA = toA;
		toA = newToA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.D__TO_A, oldToA, toA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B getRefsB() {
		if (refsB != null && refsB.eIsProxy()) {
			InternalEObject oldRefsB = (InternalEObject)refsB;
			refsB = (B)eResolveProxy(oldRefsB);
			if (refsB != oldRefsB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetPackage.D__REFS_B, oldRefsB, refsB));
			}
		}
		return refsB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B basicGetRefsB() {
		return refsB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefsB(B newRefsB) {
		B oldRefsB = refsB;
		refsB = newRefsB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.D__REFS_B, oldRefsB, refsB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C getRefsC() {
		if (refsC != null && refsC.eIsProxy()) {
			InternalEObject oldRefsC = (InternalEObject)refsC;
			refsC = (C)eResolveProxy(oldRefsC);
			if (refsC != oldRefsC) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetPackage.D__REFS_C, oldRefsC, refsC));
			}
		}
		return refsC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C basicGetRefsC() {
		return refsC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefsC(C newRefsC) {
		C oldRefsC = refsC;
		refsC = newRefsC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPackage.D__REFS_C, oldRefsC, refsC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPackage.D__TO_C:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToC((C)otherEnd, msgs);
			case TargetPackage.D__TO_B:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetToB((B)otherEnd, msgs);
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
			case TargetPackage.D__TO_C:
				return basicSetToC(null, msgs);
			case TargetPackage.D__TO_B:
				return basicSetToB(null, msgs);
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
			case TargetPackage.D__TO_C:
				return eInternalContainer().eInverseRemove(this, TargetPackage.C__OWNS_D, C.class, msgs);
			case TargetPackage.D__TO_B:
				return eInternalContainer().eInverseRemove(this, TargetPackage.B__OWNS_D, B.class, msgs);
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
			case TargetPackage.D__TO_C:
				return getToC();
			case TargetPackage.D__TO_B:
				return getToB();
			case TargetPackage.D__TO_A:
				if (resolve) return getToA();
				return basicGetToA();
			case TargetPackage.D__REFS_B:
				if (resolve) return getRefsB();
				return basicGetRefsB();
			case TargetPackage.D__REFS_C:
				if (resolve) return getRefsC();
				return basicGetRefsC();
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
			case TargetPackage.D__TO_C:
				setToC((C)newValue);
				return;
			case TargetPackage.D__TO_B:
				setToB((B)newValue);
				return;
			case TargetPackage.D__TO_A:
				setToA((A)newValue);
				return;
			case TargetPackage.D__REFS_B:
				setRefsB((B)newValue);
				return;
			case TargetPackage.D__REFS_C:
				setRefsC((C)newValue);
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
			case TargetPackage.D__TO_C:
				setToC((C)null);
				return;
			case TargetPackage.D__TO_B:
				setToB((B)null);
				return;
			case TargetPackage.D__TO_A:
				setToA((A)null);
				return;
			case TargetPackage.D__REFS_B:
				setRefsB((B)null);
				return;
			case TargetPackage.D__REFS_C:
				setRefsC((C)null);
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
			case TargetPackage.D__TO_C:
				return getToC() != null;
			case TargetPackage.D__TO_B:
				return getToB() != null;
			case TargetPackage.D__TO_A:
				return toA != null;
			case TargetPackage.D__REFS_B:
				return refsB != null;
			case TargetPackage.D__REFS_C:
				return refsC != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitD(this);
	}

} //DImpl
