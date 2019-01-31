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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dmap Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getD1atlHelper <em>D1atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getD2qvtrFunction <em>D2qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getDomapHelper_Operation <em>Domap Helper Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl#getResult <em>Result</em>}</li>
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
	public static final int DMAP_HELPER_FEATURE_COUNT = DispatchImpl.DISPATCH_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Dmap Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DMAP_HELPER_OPERATION_COUNT = DispatchImpl.DISPATCH_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getD1atlHelper() <em>D1atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD1atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper d1atlHelper;

	/**
	 * The cached value of the '{@link #getD2qvtrFunction() <em>D2qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD2qvtrFunction()
	 * @generated
	 * @ordered
	 */
	protected Function d2qvtrFunction;

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
	public Helper getD1atlHelper() {
		if (d1atlHelper != null && d1atlHelper.eIsProxy()) {
			InternalEObject oldD1atlHelper = d1atlHelper;
			d1atlHelper = (Helper)eResolveProxy(oldD1atlHelper);
			if (d1atlHelper != oldD1atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlHelper, d1atlHelper));
			}
		}
		return d1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetD1atlHelper() {
		return d1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD1atlHelper(Helper newD1atlHelper) {
		Helper oldD1atlHelper = d1atlHelper;
		d1atlHelper = newD1atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 0, oldD1atlHelper, d1atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getD2qvtrFunction() {
		if (d2qvtrFunction != null && d2qvtrFunction.eIsProxy()) {
			InternalEObject oldD2qvtrFunction = (InternalEObject)d2qvtrFunction;
			d2qvtrFunction = (Function)eResolveProxy(oldD2qvtrFunction);
			if (d2qvtrFunction != oldD2qvtrFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrFunction, d2qvtrFunction));
			}
		}
		return d2qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetD2qvtrFunction() {
		return d2qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setD2qvtrFunction(Function newD2qvtrFunction) {
		Function oldD2qvtrFunction = d2qvtrFunction;
		d2qvtrFunction = newD2qvtrFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DispatchImpl.DISPATCH_FEATURE_COUNT + 1, oldD2qvtrFunction, d2qvtrFunction));
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
				msgs = ((InternalEObject)domapHelper_Attribute).eInverseRemove(this, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, TmapHelper_Attribute.class, msgs);
			if (newDomapHelper_Attribute != null)
				msgs = ((InternalEObject)newDomapHelper_Attribute).eInverseAdd(this, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, TmapHelper_Attribute.class, msgs);
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
				msgs = ((InternalEObject)domapHelper_Operation).eInverseRemove(this, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, TmapHelper_Operation.class, msgs);
			if (newDomapHelper_Operation != null)
				msgs = ((InternalEObject)newDomapHelper_Operation).eInverseAdd(this, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, TmapHelper_Operation.class, msgs);
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
				if (resolve) return getD1atlHelper();
				return basicGetD1atlHelper();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				if (resolve) return getD2qvtrFunction();
				return basicGetD2qvtrFunction();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return getDomapHelper_Attribute();
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return getDomapHelper_Operation();
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
				setD1atlHelper((Helper)newValue);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrFunction((Function)newValue);
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
				setD1atlHelper((Helper)null);
				return;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				setD2qvtrFunction((Function)null);
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
				return d1atlHelper != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 1:
				return d2qvtrFunction != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 2:
				return domapHelper_Attribute != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 3:
				return domapHelper_Operation != null;
			case DispatchImpl.DISPATCH_FEATURE_COUNT + 4:
				return result != null;
		}
		return super.eIsSet(featureID);
	}


} //DmapHelperImpl
