/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.schedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.ParameterDerivation;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.SecondaryParameter;
import org.eclipse.qvtd.pivot.schedule.util.ScheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Derivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ParameterDerivationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ParameterDerivationImpl#getPrimaryParameter <em>Primary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ParameterDerivationImpl#getSecondaryParameter <em>Secondary Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterDerivationImpl extends ScheduleElementImpl implements ParameterDerivation {
	/**
	 * The cached value of the '{@link #getPrimaryParameter() <em>Primary Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryParameter()
	 * @generated
	 * @ordered
	 */
	protected DataParameter primaryParameter;

	/**
	 * The cached value of the '{@link #getSecondaryParameter() <em>Secondary Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryParameter()
	 * @generated
	 * @ordered
	 */
	protected SecondaryParameter secondaryParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDerivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulePackage.Literals.PARAMETER_DERIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getTarget() {
		if (eContainerFeatureID() != SchedulePackage.PARAMETER_DERIVATION__TARGET) return null;
		return (AbstractAction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(AbstractAction newTarget, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTarget, SchedulePackage.PARAMETER_DERIVATION__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(AbstractAction newTarget) {
		if (newTarget != eInternalContainer() || (eContainerFeatureID() != SchedulePackage.PARAMETER_DERIVATION__TARGET && newTarget != null)) {
			if (EcoreUtil.isAncestor(this, newTarget))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, SchedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS, AbstractAction.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PARAMETER_DERIVATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter getPrimaryParameter() {
		if (primaryParameter != null && primaryParameter.eIsProxy()) {
			InternalEObject oldPrimaryParameter = (InternalEObject)primaryParameter;
			primaryParameter = (DataParameter)eResolveProxy(oldPrimaryParameter);
			if (primaryParameter != oldPrimaryParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, oldPrimaryParameter, primaryParameter));
			}
		}
		return primaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataParameter basicGetPrimaryParameter() {
		return primaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryParameter(DataParameter newPrimaryParameter) {
		DataParameter oldPrimaryParameter = primaryParameter;
		primaryParameter = newPrimaryParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER, oldPrimaryParameter, primaryParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondaryParameter getSecondaryParameter() {
		return secondaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondaryParameter(SecondaryParameter newSecondaryParameter, NotificationChain msgs) {
		SecondaryParameter oldSecondaryParameter = secondaryParameter;
		secondaryParameter = newSecondaryParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER, oldSecondaryParameter, newSecondaryParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondaryParameter(SecondaryParameter newSecondaryParameter) {
		if (newSecondaryParameter != secondaryParameter) {
			NotificationChain msgs = null;
			if (secondaryParameter != null)
				msgs = ((InternalEObject)secondaryParameter).eInverseRemove(this, SchedulePackage.SECONDARY_PARAMETER__DERIVATION, SecondaryParameter.class, msgs);
			if (newSecondaryParameter != null)
				msgs = ((InternalEObject)newSecondaryParameter).eInverseAdd(this, SchedulePackage.SECONDARY_PARAMETER__DERIVATION, SecondaryParameter.class, msgs);
			msgs = basicSetSecondaryParameter(newSecondaryParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER, newSecondaryParameter, newSecondaryParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTarget((AbstractAction)otherEnd, msgs);
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				if (secondaryParameter != null)
					msgs = ((InternalEObject)secondaryParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER, null, msgs);
				return basicSetSecondaryParameter((SecondaryParameter)otherEnd, msgs);
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				return basicSetTarget(null, msgs);
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				return basicSetSecondaryParameter(null, msgs);
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				return eInternalContainer().eInverseRemove(this, SchedulePackage.ABSTRACT_ACTION__PARAMETER_DERIVATIONS, AbstractAction.class, msgs);
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				return getTarget();
			case SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				if (resolve) return getPrimaryParameter();
				return basicGetPrimaryParameter();
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				return getSecondaryParameter();
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				setTarget((AbstractAction)newValue);
				return;
			case SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				setPrimaryParameter((DataParameter)newValue);
				return;
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				setSecondaryParameter((SecondaryParameter)newValue);
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				setTarget((AbstractAction)null);
				return;
			case SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				setPrimaryParameter((DataParameter)null);
				return;
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				setSecondaryParameter((SecondaryParameter)null);
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
			case SchedulePackage.PARAMETER_DERIVATION__TARGET:
				return getTarget() != null;
			case SchedulePackage.PARAMETER_DERIVATION__PRIMARY_PARAMETER:
				return primaryParameter != null;
			case SchedulePackage.PARAMETER_DERIVATION__SECONDARY_PARAMETER:
				return secondaryParameter != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull ScheduleVisitor<R> visitor) {
		return visitor.visitParameterDerivation(this);
	}

} //ParameterDerivationImpl
