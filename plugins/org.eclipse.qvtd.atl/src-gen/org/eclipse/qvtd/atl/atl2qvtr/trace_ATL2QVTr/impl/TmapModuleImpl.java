/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.pivot.ParameterVariable;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT0txName <em>T0tx Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_1 <em>T2 1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_2 <em>T2 2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_3 <em>T2 3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapModuleImpl extends ExecutionImpl implements TmapModule {
	/**
	 * The default value of the '{@link #getT0txName() <em>T0tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0txName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0TX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0txName() <em>T0tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0txName()
	 * @generated
	 * @ordered
	 */
	protected String t0txName = T0TX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlModule() <em>T1atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t1atlModule;

	/**
	 * The cached value of the '{@link #getT2_1() <em>T2 1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_1()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Package t2_1;

	/**
	 * The cached value of the '{@link #getT2_2() <em>T2 2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_2()
	 * @generated
	 * @ordered
	 */
	protected ParameterVariable t2_2;

	/**
	 * The cached value of the '{@link #getT2_3() <em>T2 3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_3()
	 * @generated
	 * @ordered
	 */
	protected RelationModel t2_3;

	/**
	 * The cached value of the '{@link #getT2qvtrTransformation() <em>T2qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t2qvtrTransformation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getT0txName() {
		return t0txName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT0txName(String newT0txName) {
		String oldT0txName = t0txName;
		t0txName = newT0txName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T0TX_NAME, oldT0txName, t0txName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = (InternalEObject)t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE, oldT1atlModule, t1atlModule));
			}
		}
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT1atlModule() {
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module newT1atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT1atlModule = t1atlModule;
		t1atlModule = newT1atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE, oldT1atlModule, t1atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package getT2_1() {
		if (t2_1 != null && t2_1.eIsProxy()) {
			InternalEObject oldT2_1 = (InternalEObject)t2_1;
			t2_1 = (org.eclipse.ocl.pivot.Package)eResolveProxy(oldT2_1);
			if (t2_1 != oldT2_1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MODULE__T2_1, oldT2_1, t2_1));
			}
		}
		return t2_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package basicGetT2_1() {
		return t2_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2_1(org.eclipse.ocl.pivot.Package newT2_1) {
		org.eclipse.ocl.pivot.Package oldT2_1 = t2_1;
		t2_1 = newT2_1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T2_1, oldT2_1, t2_1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVariable getT2_2() {
		if (t2_2 != null && t2_2.eIsProxy()) {
			InternalEObject oldT2_2 = (InternalEObject)t2_2;
			t2_2 = (ParameterVariable)eResolveProxy(oldT2_2);
			if (t2_2 != oldT2_2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MODULE__T2_2, oldT2_2, t2_2));
			}
		}
		return t2_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVariable basicGetT2_2() {
		return t2_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2_2(ParameterVariable newT2_2) {
		ParameterVariable oldT2_2 = t2_2;
		t2_2 = newT2_2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T2_2, oldT2_2, t2_2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel getT2_3() {
		if (t2_3 != null && t2_3.eIsProxy()) {
			InternalEObject oldT2_3 = (InternalEObject)t2_3;
			t2_3 = (RelationModel)eResolveProxy(oldT2_3);
			if (t2_3 != oldT2_3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MODULE__T2_3, oldT2_3, t2_3));
			}
		}
		return t2_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel basicGetT2_3() {
		return t2_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2_3(RelationModel newT2_3) {
		RelationModel oldT2_3 = t2_3;
		t2_3 = newT2_3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T2_3, oldT2_3, t2_3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation getT2qvtrTransformation() {
		if (t2qvtrTransformation != null && t2qvtrTransformation.eIsProxy()) {
			InternalEObject oldT2qvtrTransformation = (InternalEObject)t2qvtrTransformation;
			t2qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT2qvtrTransformation);
			if (t2qvtrTransformation != oldT2qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
			}
		}
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT2qvtrTransformation() {
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrTransformation(RelationalTransformation newT2qvtrTransformation) {
		RelationalTransformation oldT2qvtrTransformation = t2qvtrTransformation;
		t2qvtrTransformation = newT2qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_MODULE__T0TX_NAME:
				return getT0txName();
			case trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE:
				if (resolve) return getT1atlModule();
				return basicGetT1atlModule();
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_1:
				if (resolve) return getT2_1();
				return basicGetT2_1();
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_2:
				if (resolve) return getT2_2();
				return basicGetT2_2();
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_3:
				if (resolve) return getT2_3();
				return basicGetT2_3();
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
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
			case trace_ATL2QVTrPackage.TMAP_MODULE__T0TX_NAME:
				setT0txName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_1:
				setT2_1((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_2:
				setT2_2((ParameterVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_3:
				setT2_3((RelationModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_MODULE__T0TX_NAME:
				setT0txName(T0TX_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_1:
				setT2_1((org.eclipse.ocl.pivot.Package)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_2:
				setT2_2((ParameterVariable)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_3:
				setT2_3((RelationModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)null);
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
			case trace_ATL2QVTrPackage.TMAP_MODULE__T0TX_NAME:
				return T0TX_NAME_EDEFAULT == null ? t0txName != null : !T0TX_NAME_EDEFAULT.equals(t0txName);
			case trace_ATL2QVTrPackage.TMAP_MODULE__T1ATL_MODULE:
				return t1atlModule != null;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_1:
				return t2_1 != null;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_2:
				return t2_2 != null;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2_3:
				return t2_3 != null;
			case trace_ATL2QVTrPackage.TMAP_MODULE__T2QVTR_TRANSFORMATION:
				return t2qvtrTransformation != null;
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
		result.append(" (t0txName: ");
		result.append(t0txName);
		result.append(')');
		return result.toString();
	}

} //TmapModuleImpl
