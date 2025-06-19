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

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Function;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dmap Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getD3atlHelper <em>D3atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getD4qvtrFunction <em>D4qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getDomapHelper_Operation <em>Domap Helper Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getS0global <em>S0global</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DmapHelperImpl extends DispatchImpl implements DmapHelper {
	/**
	 * The number of structural features of the '<em>Dmap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_HELPER_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Dmap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_HELPER_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getD3atlHelper() <em>D3atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD3atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper d3atlHelper;

	/**
	 * The cached value of the '{@link #getD4qvtrFunction() <em>D4qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD4qvtrFunction()
	 * @generated
	 * @ordered
	 */
	protected Function d4qvtrFunction;

	/**
	 * The cached value of the '{@link #getDomapHelper_Attribute() <em>Domap Helper Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapHelper_Attribute()
	 * @generated
	 * @ordered
	 */
	protected TmapHelper_Attribute domapHelper_Attribute;

	/**
	 * The cached value of the '{@link #getDomapHelper_Operation() <em>Domap Helper Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomapHelper_Operation()
	 * @generated
	 * @ordered
	 */
	protected TmapHelper_Operation domapHelper_Operation;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ImapHelper result;

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
	protected DmapHelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.DMAP_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Helper getD3atlHelper() {
		if (d3atlHelper != null && d3atlHelper.eIsProxy()) {
			InternalEObject oldD3atlHelper = d3atlHelper;
			d3atlHelper = (Helper)eResolveProxy(oldD3atlHelper);
			if (d3atlHelper != oldD3atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlHelper, d3atlHelper));
			}
		}
		return d3atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetD3atlHelper() {
		return d3atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD3atlHelper(Helper newD3atlHelper) {
		Helper oldD3atlHelper = d3atlHelper;
		d3atlHelper = newD3atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD3atlHelper, d3atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getD4qvtrFunction() {
		if (d4qvtrFunction != null && d4qvtrFunction.eIsProxy()) {
			InternalEObject oldD4qvtrFunction = (InternalEObject)d4qvtrFunction;
			d4qvtrFunction = (Function)eResolveProxy(oldD4qvtrFunction);
			if (d4qvtrFunction != oldD4qvtrFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrFunction, d4qvtrFunction));
			}
		}
		return d4qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetD4qvtrFunction() {
		return d4qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD4qvtrFunction(Function newD4qvtrFunction) {
		Function oldD4qvtrFunction = d4qvtrFunction;
		d4qvtrFunction = newD4qvtrFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD4qvtrFunction, d4qvtrFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Attribute getDomapHelper_Attribute() {
		return domapHelper_Attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapHelper_Attribute(TmapHelper_Attribute newDomapHelper_Attribute, NotificationChain msgs) {
		TmapHelper_Attribute oldDomapHelper_Attribute = domapHelper_Attribute;
		domapHelper_Attribute = newDomapHelper_Attribute;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, oldDomapHelper_Attribute, newDomapHelper_Attribute);
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
	public void setDomapHelper_Attribute(TmapHelper_Attribute newDomapHelper_Attribute) {
		if (newDomapHelper_Attribute != domapHelper_Attribute) {
			NotificationChain msgs = null;
			if (domapHelper_Attribute != null)
				msgs = ((InternalEObject)domapHelper_Attribute).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapHelper_Attribute.class, msgs);
			if (newDomapHelper_Attribute != null)
				msgs = ((InternalEObject)newDomapHelper_Attribute).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapHelper_Attribute.class, msgs);
			msgs = basicSetDomapHelper_Attribute(newDomapHelper_Attribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, newDomapHelper_Attribute, newDomapHelper_Attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Operation getDomapHelper_Operation() {
		return domapHelper_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomapHelper_Operation(TmapHelper_Operation newDomapHelper_Operation, NotificationChain msgs) {
		TmapHelper_Operation oldDomapHelper_Operation = domapHelper_Operation;
		domapHelper_Operation = newDomapHelper_Operation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, oldDomapHelper_Operation, newDomapHelper_Operation);
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
	public void setDomapHelper_Operation(TmapHelper_Operation newDomapHelper_Operation) {
		if (newDomapHelper_Operation != domapHelper_Operation) {
			NotificationChain msgs = null;
			if (domapHelper_Operation != null)
				msgs = ((InternalEObject)domapHelper_Operation).eInverseRemove(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapHelper_Operation.class, msgs);
			if (newDomapHelper_Operation != null)
				msgs = ((InternalEObject)newDomapHelper_Operation).eInverseAdd(this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, TmapHelper_Operation.class, msgs);
			msgs = basicSetDomapHelper_Operation(newDomapHelper_Operation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, newDomapHelper_Operation, newDomapHelper_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImapHelper getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ImapHelper)eResolveProxy(oldResult);
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
	public ImapHelper basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(ImapHelper newResult) {
		ImapHelper oldResult = result;
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
				if (domapHelper_Attribute != null)
					msgs = ((InternalEObject)domapHelper_Attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 2), null, msgs);
				return basicSetDomapHelper_Attribute((TmapHelper_Attribute)otherEnd, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				if (domapHelper_Operation != null)
					msgs = ((InternalEObject)domapHelper_Operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (DispatchImpl.DISPATCH_FEATURE_COUNT + 3), null, msgs);
				return basicSetDomapHelper_Operation((TmapHelper_Operation)otherEnd, msgs);
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
				return basicSetDomapHelper_Attribute(null, msgs);
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return basicSetDomapHelper_Operation(null, msgs);
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
				if (resolve) return getD3atlHelper();
				return basicGetD3atlHelper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD4qvtrFunction();
				return basicGetD4qvtrFunction();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return getDomapHelper_Attribute();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return getDomapHelper_Operation();
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
				setD3atlHelper((Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrFunction((Function)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapHelper_Attribute((TmapHelper_Attribute)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapHelper_Operation((TmapHelper_Operation)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setResult((ImapHelper)newValue);
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
				setD3atlHelper((Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD4qvtrFunction((Function)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				setDomapHelper_Attribute((TmapHelper_Attribute)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				setDomapHelper_Operation((TmapHelper_Operation)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				setResult((ImapHelper)null);
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
				return d3atlHelper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d4qvtrFunction != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return domapHelper_Attribute != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return domapHelper_Operation != null;
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


} //DmapHelperImpl
