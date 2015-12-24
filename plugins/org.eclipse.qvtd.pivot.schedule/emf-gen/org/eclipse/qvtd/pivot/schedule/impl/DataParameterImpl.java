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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.SecondaryParameter;
import org.eclipse.qvtd.pivot.schedule.util.ScheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.DataParameterImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.DataParameterImpl#getSecondaryParameter <em>Secondary Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.DataParameterImpl#getDatum <em>Datum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataParameterImpl extends ScheduleElementImpl implements DataParameter {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getSecondaryParameter() <em>Secondary Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondaryParameter()
	 * @generated
	 * @ordered
	 */
	protected SecondaryParameter secondaryParameter;

	/**
	 * The cached value of the '{@link #getDatum() <em>Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatum()
	 * @generated
	 * @ordered
	 */
	protected AbstractDatum datum;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulePackage.Literals.DATA_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.DATA_PARAMETER__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.DATA_PARAMETER__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondaryParameter getSecondaryParameter() {
		if (secondaryParameter != null && secondaryParameter.eIsProxy()) {
			InternalEObject oldSecondaryParameter = (InternalEObject)secondaryParameter;
			secondaryParameter = (SecondaryParameter)eResolveProxy(oldSecondaryParameter);
			if (secondaryParameter != oldSecondaryParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, oldSecondaryParameter, secondaryParameter));
			}
		}
		return secondaryParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondaryParameter basicGetSecondaryParameter() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, oldSecondaryParameter, newSecondaryParameter);
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
				msgs = ((InternalEObject)secondaryParameter).eInverseRemove(this, SchedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, SecondaryParameter.class, msgs);
			if (newSecondaryParameter != null)
				msgs = ((InternalEObject)newSecondaryParameter).eInverseAdd(this, SchedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, SecondaryParameter.class, msgs);
			msgs = basicSetSecondaryParameter(newSecondaryParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER, newSecondaryParameter, newSecondaryParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDatum getDatum() {
		if (datum != null && datum.eIsProxy()) {
			InternalEObject oldDatum = (InternalEObject)datum;
			datum = (AbstractDatum)eResolveProxy(oldDatum);
			if (datum != oldDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.DATA_PARAMETER__DATUM, oldDatum, datum));
			}
		}
		return datum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractDatum basicGetDatum() {
		return datum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDatum(AbstractDatum newDatum, NotificationChain msgs) {
		AbstractDatum oldDatum = datum;
		datum = newDatum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulePackage.DATA_PARAMETER__DATUM, oldDatum, newDatum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatum(AbstractDatum newDatum) {
		if (newDatum != datum) {
			NotificationChain msgs = null;
			if (datum != null)
				msgs = ((InternalEObject)datum).eInverseRemove(this, SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
			if (newDatum != null)
				msgs = ((InternalEObject)newDatum).eInverseAdd(this, SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
			msgs = basicSetDatum(newDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.DATA_PARAMETER__DATUM, newDatum, newDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				if (secondaryParameter != null)
					msgs = ((InternalEObject)secondaryParameter).eInverseRemove(this, SchedulePackage.SECONDARY_PARAMETER__DATA_PARAMETER, SecondaryParameter.class, msgs);
				return basicSetSecondaryParameter((SecondaryParameter)otherEnd, msgs);
			case SchedulePackage.DATA_PARAMETER__DATUM:
				if (datum != null)
					msgs = ((InternalEObject)datum).eInverseRemove(this, SchedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
				return basicSetDatum((AbstractDatum)otherEnd, msgs);
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
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				return basicSetSecondaryParameter(null, msgs);
			case SchedulePackage.DATA_PARAMETER__DATUM:
				return basicSetDatum(null, msgs);
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
			case SchedulePackage.DATA_PARAMETER__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				if (resolve) return getSecondaryParameter();
				return basicGetSecondaryParameter();
			case SchedulePackage.DATA_PARAMETER__DATUM:
				if (resolve) return getDatum();
				return basicGetDatum();
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
			case SchedulePackage.DATA_PARAMETER__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				setSecondaryParameter((SecondaryParameter)newValue);
				return;
			case SchedulePackage.DATA_PARAMETER__DATUM:
				setDatum((AbstractDatum)newValue);
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
			case SchedulePackage.DATA_PARAMETER__VARIABLE:
				setVariable((Variable)null);
				return;
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				setSecondaryParameter((SecondaryParameter)null);
				return;
			case SchedulePackage.DATA_PARAMETER__DATUM:
				setDatum((AbstractDatum)null);
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
			case SchedulePackage.DATA_PARAMETER__VARIABLE:
				return variable != null;
			case SchedulePackage.DATA_PARAMETER__SECONDARY_PARAMETER:
				return secondaryParameter != null;
			case SchedulePackage.DATA_PARAMETER__DATUM:
				return datum != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull ScheduleVisitor<R> visitor) {
		return visitor.visitDataParameter(this);
	}

} //DataParameterImpl
