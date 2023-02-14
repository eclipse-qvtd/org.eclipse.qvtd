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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getD3atlExpression <em>D3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getD4qvtrExpression <em>D4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl#getS0global <em>S0global</em>}</li>
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
	public static final int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Dmap Variable Exp referred Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getD3atlExpression() <em>D3atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD3atlExpression()
	 * @generated
	 * @ordered
	 */
	protected VariableExp d3atlExpression;

	/**
	 * The cached value of the '{@link #getD4qvtrExpression() <em>D4qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD4qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableExp d4qvtrExpression;

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
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

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
	public VariableExp getD3atlExpression() {
		if (d3atlExpression != null && d3atlExpression.eIsProxy()) {
			InternalEObject oldD3atlExpression = d3atlExpression;
			d3atlExpression = (VariableExp)eResolveProxy(oldD3atlExpression);
			if (d3atlExpression != oldD3atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlExpression, d3atlExpression));
			}
		}
		return d3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetD3atlExpression() {
		return d3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD3atlExpression(VariableExp newD3atlExpression) {
		VariableExp oldD3atlExpression = d3atlExpression;
		d3atlExpression = newD3atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlExpression, d3atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableExp getD4qvtrExpression() {
		if (d4qvtrExpression != null && d4qvtrExpression.eIsProxy()) {
			InternalEObject oldD4qvtrExpression = (InternalEObject)d4qvtrExpression;
			d4qvtrExpression = (org.eclipse.ocl.pivot.VariableExp)eResolveProxy(oldD4qvtrExpression);
			if (d4qvtrExpression != oldD4qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrExpression, d4qvtrExpression));
			}
		}
		return d4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableExp basicGetD4qvtrExpression() {
		return d4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD4qvtrExpression(org.eclipse.ocl.pivot.VariableExp newD4qvtrExpression) {
		org.eclipse.ocl.pivot.VariableExp oldD4qvtrExpression = d4qvtrExpression;
		d4qvtrExpression = newD4qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrExpression, d4qvtrExpression));
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
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 5, oldS0global, s0global));
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
				if (resolve) return getD3atlExpression();
				return basicGetD3atlExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD4qvtrExpression();
				return basicGetD4qvtrExpression();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return getDomapVariableExp_referredVariable_Helper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return getDomapVariableExp_referredVariable_VariableDeclaration();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				if (resolve) return getResult();
				return basicGetResult();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				return getS0global();
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
				setD3atlExpression((VariableExp)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrExpression((org.eclipse.ocl.pivot.VariableExp)newValue);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				setS0global((Boolean)newValue);
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
				setD3atlExpression((VariableExp)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrExpression((org.eclipse.ocl.pivot.VariableExp)null);
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
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				setS0global(S0GLOBAL_EDEFAULT);
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
				return d3atlExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d4qvtrExpression != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return domapVariableExp_referredVariable_Helper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return domapVariableExp_referredVariable_VariableDeclaration != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return result != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 5:
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
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
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(')');
		return result.toString();
	}


} //DmapVariableExp_referredVariableImpl
