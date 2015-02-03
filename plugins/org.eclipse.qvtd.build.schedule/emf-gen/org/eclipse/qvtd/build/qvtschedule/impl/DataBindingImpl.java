/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.build.qvtschedule.DataBinding;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataBindingImpl#getSourceExp <em>Source Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataBindingImpl#getTargetDataParameter <em>Target Data Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataBindingImpl extends MinimalEObjectImpl.Container implements DataBinding {
	/**
	 * The cached value of the '{@link #getSourceExp() <em>Source Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceExp()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression sourceExp;

	/**
	 * The cached value of the '{@link #getTargetDataParameter() <em>Target Data Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDataParameter()
	 * @generated
	 * @ordered
	 */
	protected DataParameter targetDataParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.DATA_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getSourceExp() {
		if (sourceExp != null && sourceExp.eIsProxy()) {
			InternalEObject oldSourceExp = (InternalEObject)sourceExp;
			sourceExp = (OCLExpression)eResolveProxy(oldSourceExp);
			if (sourceExp != oldSourceExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.DATA_BINDING__SOURCE_EXP, oldSourceExp, sourceExp));
			}
		}
		return sourceExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetSourceExp() {
		return sourceExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceExp(OCLExpression newSourceExp) {
		OCLExpression oldSourceExp = sourceExp;
		sourceExp = newSourceExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_BINDING__SOURCE_EXP, oldSourceExp, sourceExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter getTargetDataParameter() {
		if (targetDataParameter != null && targetDataParameter.eIsProxy()) {
			InternalEObject oldTargetDataParameter = (InternalEObject)targetDataParameter;
			targetDataParameter = (DataParameter)eResolveProxy(oldTargetDataParameter);
			if (targetDataParameter != oldTargetDataParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER, oldTargetDataParameter, targetDataParameter));
			}
		}
		return targetDataParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter basicGetTargetDataParameter() {
		return targetDataParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetDataParameter(DataParameter newTargetDataParameter) {
		DataParameter oldTargetDataParameter = targetDataParameter;
		targetDataParameter = newTargetDataParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER, oldTargetDataParameter, targetDataParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case qvtschedulePackage.DATA_BINDING__SOURCE_EXP:
				if (resolve) return getSourceExp();
				return basicGetSourceExp();
			case qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER:
				if (resolve) return getTargetDataParameter();
				return basicGetTargetDataParameter();
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
			case qvtschedulePackage.DATA_BINDING__SOURCE_EXP:
				setSourceExp((OCLExpression)newValue);
				return;
			case qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER:
				setTargetDataParameter((DataParameter)newValue);
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
			case qvtschedulePackage.DATA_BINDING__SOURCE_EXP:
				setSourceExp((OCLExpression)null);
				return;
			case qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER:
				setTargetDataParameter((DataParameter)null);
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
			case qvtschedulePackage.DATA_BINDING__SOURCE_EXP:
				return sourceExp != null;
			case qvtschedulePackage.DATA_BINDING__TARGET_DATA_PARAMETER:
				return targetDataParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //DataBindingImpl
