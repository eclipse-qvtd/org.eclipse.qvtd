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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT0txName <em>T0tx Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_3 <em>T2 3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_4 <em>T2 4</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_5 <em>T2 5</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2_6 <em>T2 6</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
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
	public static final int TMAP_MODULE_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_MODULE_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


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
	 * The cached value of the '{@link #getT2_3() <em>T2 3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_3()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Package t2_3;

	/**
	 * The cached value of the '{@link #getT2_4() <em>T2 4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_4()
	 * @generated
	 * @ordered
	 */
	protected RelationModel t2_4;

	/**
	 * The cached value of the '{@link #getT2_5() <em>T2 5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_5()
	 * @generated
	 * @ordered
	 */
	protected Parameter t2_5;

	/**
	 * The cached value of the '{@link #getT2_6() <em>T2 6</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2_6()
	 * @generated
	 * @ordered
	 */
	protected TypedModel t2_6;

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
	@Override
	public String getT0txName() {
		return t0txName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0txName(String newT0txName) {
		String oldT0txName = t0txName;
		t0txName = newT0txName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldT0txName, t0txName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlModule, t1atlModule));
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
	@Override
	public void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module newT1atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT1atlModule = t1atlModule;
		t1atlModule = newT1atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlModule, t1atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getT2_3() {
		if (t2_3 != null && t2_3.eIsProxy()) {
			InternalEObject oldT2_3 = (InternalEObject)t2_3;
			t2_3 = (org.eclipse.ocl.pivot.Package)eResolveProxy(oldT2_3);
			if (t2_3 != oldT2_3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2_3, t2_3));
			}
		}
		return t2_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package basicGetT2_3() {
		return t2_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2_3(org.eclipse.ocl.pivot.Package newT2_3) {
		org.eclipse.ocl.pivot.Package oldT2_3 = t2_3;
		t2_3 = newT2_3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2_3, t2_3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationModel getT2_4() {
		if (t2_4 != null && t2_4.eIsProxy()) {
			InternalEObject oldT2_4 = (InternalEObject)t2_4;
			t2_4 = (RelationModel)eResolveProxy(oldT2_4);
			if (t2_4 != oldT2_4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2_4, t2_4));
			}
		}
		return t2_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel basicGetT2_4() {
		return t2_4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2_4(RelationModel newT2_4) {
		RelationModel oldT2_4 = t2_4;
		t2_4 = newT2_4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2_4, t2_4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getT2_5() {
		if (t2_5 != null && t2_5.eIsProxy()) {
			InternalEObject oldT2_5 = (InternalEObject)t2_5;
			t2_5 = (Parameter)eResolveProxy(oldT2_5);
			if (t2_5 != oldT2_5) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT2_5, t2_5));
			}
		}
		return t2_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetT2_5() {
		return t2_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2_5(Parameter newT2_5) {
		Parameter oldT2_5 = t2_5;
		t2_5 = newT2_5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT2_5, t2_5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getT2_6() {
		if (t2_6 != null && t2_6.eIsProxy()) {
			InternalEObject oldT2_6 = (InternalEObject)t2_6;
			t2_6 = (TypedModel)eResolveProxy(oldT2_6);
			if (t2_6 != oldT2_6) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2_6, t2_6));
			}
		}
		return t2_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetT2_6() {
		return t2_6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2_6(TypedModel newT2_6) {
		TypedModel oldT2_6 = t2_6;
		t2_6 = newT2_6;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT2_6, t2_6));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT2qvtrTransformation() {
		if (t2qvtrTransformation != null && t2qvtrTransformation.eIsProxy()) {
			InternalEObject oldT2qvtrTransformation = (InternalEObject)t2qvtrTransformation;
			t2qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT2qvtrTransformation);
			if (t2qvtrTransformation != oldT2qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrTransformation, t2qvtrTransformation));
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
	@Override
	public void setT2qvtrTransformation(RelationalTransformation newT2qvtrTransformation) {
		RelationalTransformation oldT2qvtrTransformation = t2qvtrTransformation;
		t2qvtrTransformation = newT2qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT2qvtrTransformation, t2qvtrTransformation));
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
				return getT0txName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT1atlModule();
			return basicGetT1atlModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT2_3();
			return basicGetT2_3();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT2_4();
			return basicGetT2_4();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT2_5();
			return basicGetT2_5();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT2_6();
			return basicGetT2_6();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setT0txName((String)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT2_3((org.eclipse.ocl.pivot.Package)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2_4((RelationModel)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT2_5((Parameter)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2_6((TypedModel)newValue);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setT0txName(T0TX_NAME_EDEFAULT);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT2_3((org.eclipse.ocl.pivot.Package)null);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2_4((RelationModel)null);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT2_5((Parameter)null);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT2_6((TypedModel)null);
			return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return T0TX_NAME_EDEFAULT == null ? t0txName != null : !T0TX_NAME_EDEFAULT.equals(t0txName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t1atlModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t2_3 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t2_4 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t2_5 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t2_6 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
