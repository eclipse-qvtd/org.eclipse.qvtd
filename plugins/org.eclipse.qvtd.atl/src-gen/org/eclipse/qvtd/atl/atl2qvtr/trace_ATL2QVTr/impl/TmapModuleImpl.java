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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.pivot.Parameter;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT1txName <em>T1tx Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT3atlModule <em>T3atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT4_3 <em>T4 3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT4_4 <em>T4 4</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT4_5 <em>T4 5</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT4_6 <em>T4 6</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT4qvtrTransformation <em>T4qvtr Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapModuleImpl extends ExecutionImpl implements TmapModule {
	/**
	 * The number of structural features of the '<em>Tmap Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MODULE_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Tmap Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MODULE_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


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
	 * The default value of the '{@link #getT1txName() <em>T1tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1txName()
	 * @generated
	 * @ordered
	 */
	protected static final String T1TX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT1txName() <em>T1tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1txName()
	 * @generated
	 * @ordered
	 */
	protected String t1txName = T1TX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlModule() <em>T3atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t3atlModule;

	/**
	 * The cached value of the '{@link #getT4_3() <em>T4 3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4_3()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Package t4_3;

	/**
	 * The cached value of the '{@link #getT4_4() <em>T4 4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4_4()
	 * @generated
	 * @ordered
	 */
	protected RelationModel t4_4;

	/**
	 * The cached value of the '{@link #getT4_5() <em>T4 5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4_5()
	 * @generated
	 * @ordered
	 */
	protected Parameter t4_5;

	/**
	 * The cached value of the '{@link #getT4_6() <em>T4 6</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4_6()
	 * @generated
	 * @ordered
	 */
	protected TypedModel t4_6;

	/**
	 * The cached value of the '{@link #getT4qvtrTransformation() <em>T4qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t4qvtrTransformation;

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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldS0global, s0global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT1txName() {
		return t1txName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1txName(String newT1txName) {
		String oldT1txName = t1txName;
		t1txName = newT1txName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1txName, t1txName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT3atlModule() {
		if (t3atlModule != null && t3atlModule.eIsProxy()) {
			InternalEObject oldT3atlModule = t3atlModule;
			t3atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT3atlModule);
			if (t3atlModule != oldT3atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlModule, t3atlModule));
			}
		}
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT3atlModule() {
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlModule(org.eclipse.m2m.atl.common.ATL.Module newT3atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT3atlModule = t3atlModule;
		t3atlModule = newT3atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlModule, t3atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getT4_3() {
		if (t4_3 != null && t4_3.eIsProxy()) {
			InternalEObject oldT4_3 = (InternalEObject)t4_3;
			t4_3 = (org.eclipse.ocl.pivot.Package)eResolveProxy(oldT4_3);
			if (t4_3 != oldT4_3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4_3, t4_3));
			}
		}
		return t4_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package basicGetT4_3() {
		return t4_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4_3(org.eclipse.ocl.pivot.Package newT4_3) {
		org.eclipse.ocl.pivot.Package oldT4_3 = t4_3;
		t4_3 = newT4_3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4_3, t4_3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationModel getT4_4() {
		if (t4_4 != null && t4_4.eIsProxy()) {
			InternalEObject oldT4_4 = (InternalEObject)t4_4;
			t4_4 = (RelationModel)eResolveProxy(oldT4_4);
			if (t4_4 != oldT4_4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4_4, t4_4));
			}
		}
		return t4_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel basicGetT4_4() {
		return t4_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4_4(RelationModel newT4_4) {
		RelationModel oldT4_4 = t4_4;
		t4_4 = newT4_4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4_4, t4_4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getT4_5() {
		if (t4_5 != null && t4_5.eIsProxy()) {
			InternalEObject oldT4_5 = (InternalEObject)t4_5;
			t4_5 = (Parameter)eResolveProxy(oldT4_5);
			if (t4_5 != oldT4_5) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4_5, t4_5));
			}
		}
		return t4_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetT4_5() {
		return t4_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4_5(Parameter newT4_5) {
		Parameter oldT4_5 = t4_5;
		t4_5 = newT4_5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4_5, t4_5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getT4_6() {
		if (t4_6 != null && t4_6.eIsProxy()) {
			InternalEObject oldT4_6 = (InternalEObject)t4_6;
			t4_6 = (TypedModel)eResolveProxy(oldT4_6);
			if (t4_6 != oldT4_6) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4_6, t4_6));
			}
		}
		return t4_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetT4_6() {
		return t4_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4_6(TypedModel newT4_6) {
		TypedModel oldT4_6 = t4_6;
		t4_6 = newT4_6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4_6, t4_6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT4qvtrTransformation() {
		if (t4qvtrTransformation != null && t4qvtrTransformation.eIsProxy()) {
			InternalEObject oldT4qvtrTransformation = (InternalEObject)t4qvtrTransformation;
			t4qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT4qvtrTransformation);
			if (t4qvtrTransformation != oldT4qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTransformation, t4qvtrTransformation));
			}
		}
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT4qvtrTransformation() {
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrTransformation(RelationalTransformation newT4qvtrTransformation) {
		RelationalTransformation oldT4qvtrTransformation = t4qvtrTransformation;
		t4qvtrTransformation = newT4qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTransformation, t4qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return getS0global();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getT1txName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlModule();
				return basicGetT3atlModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT4_3();
				return basicGetT4_3();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT4_4();
				return basicGetT4_4();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4_5();
				return basicGetT4_5();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4_6();
				return basicGetT4_6();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrTransformation();
				return basicGetT4qvtrTransformation();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1txName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4_3((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4_4((RelationModel)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4_5((Parameter)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4_6((TypedModel)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTransformation((RelationalTransformation)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1txName(T1TX_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4_3((org.eclipse.ocl.pivot.Package)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4_4((RelationModel)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4_5((Parameter)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4_6((TypedModel)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTransformation((RelationalTransformation)null);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return T1TX_NAME_EDEFAULT == null ? t1txName != null : !T1TX_NAME_EDEFAULT.equals(t1txName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t4_3 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t4_4 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4_5 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4_6 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrTransformation != null;
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
		result.append(", t1txName: ");
		result.append(t1txName);
		result.append(')');
		return result.toString();
	}


} //TmapModuleImpl
