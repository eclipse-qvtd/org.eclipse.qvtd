/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.ParameterDerivation;
import org.eclipse.qvtd.build.qvtschedule.SecondaryParameter;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Secondary Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl#isIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl#getDataParameter <em>Data Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl#getDerivationProperty <em>Derivation Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecondaryParameterImpl extends MinimalEObjectImpl.Container implements SecondaryParameter {
	/**
	 * The default value of the '{@link #isIsLoop() <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLoop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLoop() <em>Is Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLoop()
	 * @generated
	 * @ordered
	 */
	protected boolean isLoop = IS_LOOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataParameter() <em>Data Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataParameter()
	 * @generated
	 * @ordered
	 */
	protected DataParameter dataParameter;

	/**
	 * The cached value of the '{@link #getDerivationProperty() <em>Derivation Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivationProperty()
	 * @generated
	 * @ordered
	 */
	protected Property derivationProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecondaryParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.SECONDARY_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLoop() {
		return isLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLoop(boolean newIsLoop) {
		boolean oldIsLoop = isLoop;
		isLoop = newIsLoop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.SECONDARY_PARAMETER__IS_LOOP, oldIsLoop, isLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter getDataParameter() {
		if (dataParameter != null && dataParameter.eIsProxy()) {
			InternalEObject oldDataParameter = (InternalEObject)dataParameter;
			dataParameter = (DataParameter)eResolveProxy(oldDataParameter);
			if (dataParameter != oldDataParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, oldDataParameter, dataParameter));
			}
		}
		return dataParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter basicGetDataParameter() {
		return dataParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataParameter(DataParameter newDataParameter, NotificationChain msgs) {
		DataParameter oldDataParameter = dataParameter;
		dataParameter = newDataParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, oldDataParameter, newDataParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataParameter(DataParameter newDataParameter) {
		if (newDataParameter != dataParameter) {
			NotificationChain msgs = null;
			if (dataParameter != null)
				msgs = ((InternalEObject)dataParameter).eInverseRemove(this, qvtschedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, DataParameter.class, msgs);
			if (newDataParameter != null)
				msgs = ((InternalEObject)newDataParameter).eInverseAdd(this, qvtschedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, DataParameter.class, msgs);
			msgs = basicSetDataParameter(newDataParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, newDataParameter, newDataParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getDerivationProperty() {
		if (derivationProperty != null && derivationProperty.eIsProxy()) {
			InternalEObject oldDerivationProperty = (InternalEObject)derivationProperty;
			derivationProperty = (Property)eResolveProxy(oldDerivationProperty);
			if (derivationProperty != oldDerivationProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY, oldDerivationProperty, derivationProperty));
			}
		}
		return derivationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetDerivationProperty() {
		return derivationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivationProperty(Property newDerivationProperty) {
		Property oldDerivationProperty = derivationProperty;
		derivationProperty = newDerivationProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY, oldDerivationProperty, derivationProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDerivation getDerivation() {
		if (eContainerFeatureID() != qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION) return null;
		return (ParameterDerivation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDerivation(ParameterDerivation newDerivation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDerivation, qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivation(ParameterDerivation newDerivation) {
		if (newDerivation != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION && newDerivation != null)) {
			if (EcoreUtil.isAncestor(this, newDerivation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDerivation != null)
				msgs = ((InternalEObject)newDerivation).eInverseAdd(this, qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER, ParameterDerivation.class, msgs);
			msgs = basicSetDerivation(newDerivation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION, newDerivation, newDerivation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				if (dataParameter != null)
					msgs = ((InternalEObject)dataParameter).eInverseRemove(this, qvtschedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, DataParameter.class, msgs);
				return basicSetDataParameter((DataParameter)otherEnd, msgs);
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDerivation((ParameterDerivation)otherEnd, msgs);
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
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				return basicSetDataParameter(null, msgs);
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				return basicSetDerivation(null, msgs);
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
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER, ParameterDerivation.class, msgs);
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
			case qvtschedulePackage.SECONDARY_PARAMETER__IS_LOOP:
				return isIsLoop();
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				if (resolve) return getDataParameter();
				return basicGetDataParameter();
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY:
				if (resolve) return getDerivationProperty();
				return basicGetDerivationProperty();
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				return getDerivation();
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
			case qvtschedulePackage.SECONDARY_PARAMETER__IS_LOOP:
				setIsLoop((Boolean)newValue);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				setDataParameter((DataParameter)newValue);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY:
				setDerivationProperty((Property)newValue);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				setDerivation((ParameterDerivation)newValue);
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
			case qvtschedulePackage.SECONDARY_PARAMETER__IS_LOOP:
				setIsLoop(IS_LOOP_EDEFAULT);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				setDataParameter((DataParameter)null);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY:
				setDerivationProperty((Property)null);
				return;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				setDerivation((ParameterDerivation)null);
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
			case qvtschedulePackage.SECONDARY_PARAMETER__IS_LOOP:
				return isLoop != IS_LOOP_EDEFAULT;
			case qvtschedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER:
				return dataParameter != null;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION_PROPERTY:
				return derivationProperty != null;
			case qvtschedulePackage.SECONDARY_PARAMETER__DERIVATION:
				return getDerivation() != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isLoop: ");
		result.append(isLoop);
		result.append(')');
		return result.toString();
	}

} //SecondaryParameterImpl
