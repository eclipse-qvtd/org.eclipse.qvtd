/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dmap Variable Exp referred Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getD1atlExpression <em>D1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getD2qvtrExpression <em>D2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DmapVariableExp_referredVariableImpl extends DispatchImpl implements DmapVariableExp_referredVariable {
	/**
	 * The number of structural features of the '<em>Dmap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Dmap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getD1atlExpression() <em>D1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD1atlExpression()
	 * @generated
	 * @ordered
	 */
	protected VariableExp d1atlExpression;

	/**
	 * The cached value of the '{@link #getD2qvtrExpression() <em>D2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD2qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableExp d2qvtrExpression;

	/**
	 * The cached value of the '{@link #getDomapVariableExp_referredVariable_Helper() <em>Domap Variable Exp referred Variable Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapVariableExp_referredVariable_Helper()
	 * @generated
	 * @ordered
	 */
	protected TmapVariableExp_referredVariable_Helper domapVariableExp_referredVariable_Helper;

	/**
	 * The cached value of the '{@link #getDomapVariableExp_referredVariable_VariableDeclaration() <em>Domap Variable Exp referred Variable Variable Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 * @ordered
	 */
	protected TmapVariableExp_referredVariable_VariableDeclaration domapVariableExp_referredVariable_VariableDeclaration;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ImapVariableExp_referredVariable result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DmapVariableExp_referredVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.DMAP_VARIABLE_EXP_REFERRED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getD1atlExpression() {
		if (d1atlExpression != null && d1atlExpression.eIsProxy()) {
			InternalEObject oldD1atlExpression = d1atlExpression;
			d1atlExpression = (VariableExp)eResolveProxy(oldD1atlExpression);
			if (d1atlExpression != oldD1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlExpression, d1atlExpression));
			}
		}
		return d1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetD1atlExpression() {
		return d1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD1atlExpression(VariableExp newD1atlExpression) {
		VariableExp oldD1atlExpression = d1atlExpression;
		d1atlExpression = newD1atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlExpression, d1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableExp getD2qvtrExpression() {
		if (d2qvtrExpression != null && d2qvtrExpression.eIsProxy()) {
			InternalEObject oldD2qvtrExpression = (InternalEObject)d2qvtrExpression;
			d2qvtrExpression = (org.eclipse.ocl.pivot.VariableExp)eResolveProxy(oldD2qvtrExpression);
			if (d2qvtrExpression != oldD2qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrExpression, d2qvtrExpression));
			}
		}
		return d2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableExp basicGetD2qvtrExpression() {
		return d2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD2qvtrExpression(org.eclipse.ocl.pivot.VariableExp newD2qvtrExpression) {
		org.eclipse.ocl.pivot.VariableExp oldD2qvtrExpression = d2qvtrExpression;
		d2qvtrExpression = newD2qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrExpression, d2qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp_referredVariable_Helper getDomapVariableExp_referredVariable_Helper() {
		return domapVariableExp_referredVariable_Helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper newDomapVariableExp_referredVariable_Helper, NotificationChain msgs) {
		TmapVariableExp_referredVariable_Helper oldDomapVariableExp_referredVariable_Helper = domapVariableExp_referredVariable_Helper;
		domapVariableExp_referredVariable_Helper = newDomapVariableExp_referredVariable_Helper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, oldDomapVariableExp_referredVariable_Helper, newDomapVariableExp_referredVariable_Helper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapVariableExp_referredVariable_Helper(TmapVariableExp_referredVariable_Helper newDomapVariableExp_referredVariable_Helper) {
		if (newDomapVariableExp_referredVariable_Helper != domapVariableExp_referredVariable_Helper) {
			NotificationChain msgs = null;
			if (domapVariableExp_referredVariable_Helper != null)
				msgs = ((InternalEObject)domapVariableExp_referredVariable_Helper).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp_referredVariable_Helper.class, msgs);
			if (newDomapVariableExp_referredVariable_Helper != null)
				msgs = ((InternalEObject)newDomapVariableExp_referredVariable_Helper).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp_referredVariable_Helper.class, msgs);
			msgs = basicSetDomapVariableExp_referredVariable_Helper(newDomapVariableExp_referredVariable_Helper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, newDomapVariableExp_referredVariable_Helper, newDomapVariableExp_referredVariable_Helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariableExp_referredVariable_VariableDeclaration getDomapVariableExp_referredVariable_VariableDeclaration() {
		return domapVariableExp_referredVariable_VariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration newDomapVariableExp_referredVariable_VariableDeclaration, NotificationChain msgs) {
		TmapVariableExp_referredVariable_VariableDeclaration oldDomapVariableExp_referredVariable_VariableDeclaration = domapVariableExp_referredVariable_VariableDeclaration;
		domapVariableExp_referredVariable_VariableDeclaration = newDomapVariableExp_referredVariable_VariableDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, oldDomapVariableExp_referredVariable_VariableDeclaration, newDomapVariableExp_referredVariable_VariableDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomapVariableExp_referredVariable_VariableDeclaration(TmapVariableExp_referredVariable_VariableDeclaration newDomapVariableExp_referredVariable_VariableDeclaration) {
		if (newDomapVariableExp_referredVariable_VariableDeclaration != domapVariableExp_referredVariable_VariableDeclaration) {
			NotificationChain msgs = null;
			if (domapVariableExp_referredVariable_VariableDeclaration != null)
				msgs = ((InternalEObject)domapVariableExp_referredVariable_VariableDeclaration).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp_referredVariable_VariableDeclaration.class, msgs);
			if (newDomapVariableExp_referredVariable_VariableDeclaration != null)
				msgs = ((InternalEObject)newDomapVariableExp_referredVariable_VariableDeclaration).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapVariableExp_referredVariable_VariableDeclaration.class, msgs);
			msgs = basicSetDomapVariableExp_referredVariable_VariableDeclaration(newDomapVariableExp_referredVariable_VariableDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, newDomapVariableExp_referredVariable_VariableDeclaration, newDomapVariableExp_referredVariable_VariableDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImapVariableExp_referredVariable getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ImapVariableExp_referredVariable)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImapVariableExp_referredVariable basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(ImapVariableExp_referredVariable newResult) {
		ImapVariableExp_referredVariable oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 4, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				if (domapVariableExp_referredVariable_Helper != null)
					msgs = ((InternalEObject)domapVariableExp_referredVariable_Helper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 2), null, msgs);
				return basicSetDomapVariableExp_referredVariable_Helper((TmapVariableExp_referredVariable_Helper)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				if (domapVariableExp_referredVariable_VariableDeclaration != null)
					msgs = ((InternalEObject)domapVariableExp_referredVariable_VariableDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 3), null, msgs);
				return basicSetDomapVariableExp_referredVariable_VariableDeclaration((TmapVariableExp_referredVariable_VariableDeclaration)otherEnd, msgs);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return basicSetDomapVariableExp_referredVariable_Helper(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return basicSetDomapVariableExp_referredVariable_VariableDeclaration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				if (resolve) return getD1atlExpression();
				return basicGetD1atlExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD2qvtrExpression();
				return basicGetD2qvtrExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return getDomapVariableExp_referredVariable_Helper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return getDomapVariableExp_referredVariable_VariableDeclaration();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				if (resolve) return getResult();
				return basicGetResult();
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD1atlExpression((VariableExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrExpression((org.eclipse.ocl.pivot.VariableExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapVariableExp_referredVariable_Helper((TmapVariableExp_referredVariable_Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapVariableExp_referredVariable_VariableDeclaration((TmapVariableExp_referredVariable_VariableDeclaration)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setResult((ImapVariableExp_referredVariable)newValue);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				setD1atlExpression((VariableExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrExpression((org.eclipse.ocl.pivot.VariableExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapVariableExp_referredVariable_Helper((TmapVariableExp_referredVariable_Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapVariableExp_referredVariable_VariableDeclaration((TmapVariableExp_referredVariable_VariableDeclaration)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setResult((ImapVariableExp_referredVariable)null);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 0:
				return d1atlExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d2qvtrExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return domapVariableExp_referredVariable_Helper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return domapVariableExp_referredVariable_VariableDeclaration != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return result != null;
		}
		return super.eIsSet(featureID);
	}


} //DmapVariableExp_referredVariableImpl
