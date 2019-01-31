/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Integer Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl#getT0symbol <em>T0symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapIntegerExpImpl extends ImapOclExpressionImpl implements TmapIntegerExp {
	/**
	 * The number of structural features of the '<em>Tmap Integer Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_INTEGER_EXP_FEATURE_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tmap Integer Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_INTEGER_EXP_OPERATION_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getT0symbol() <em>T0symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0symbol()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger T0SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0symbol() <em>T0symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0symbol()
	 * @generated
	 * @ordered
	 */
	protected BigInteger t0symbol = T0SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapIntegerExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_INTEGER_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != (ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0)) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigInteger getT0symbol() {
		return t0symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0symbol(BigInteger newT0symbol) {
		BigInteger oldT0symbol = t0symbol;
		t0symbol = newT0symbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1, oldT0symbol, t0symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDispatcher((DmapOclExpression)otherEnd, msgs);
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				return basicSetDispatcher(null, msgs);
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, DmapOclExpression.class, msgs);
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				return getDispatcher();
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1:
				return getT0symbol();
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1:
				setT0symbol((BigInteger)newValue);
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				setDispatcher((DmapOclExpression)null);
				return;
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1:
				setT0symbol(T0SYMBOL_EDEFAULT);
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
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 0:
				return getDispatcher() != null;
			case ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 1:
				return T0SYMBOL_EDEFAULT == null ? t0symbol != null : !T0SYMBOL_EDEFAULT.equals(t0symbol);
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
		result.append(" (t0symbol: ");
		result.append(t0symbol);
		result.append(')');
		return result.toString();
	}


} //TmapIntegerExpImpl
