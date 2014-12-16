/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.pivot.Variable;

import org.eclipse.qvtd.build.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.build.qvtschedule.DataParameter;
import org.eclipse.qvtd.build.qvtschedule.DistinctData;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl#isIsLoop <em>Is Loop</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl#getPrimaryDistinctData <em>Primary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl#getSecondaryDistinctData <em>Secondary Distinct Data</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl#getDatum <em>Datum</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataParameterImpl extends MinimalEObjectImpl.Container implements DataParameter {
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
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

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
		return qvtschedulePackage.Literals.DATA_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__IS_LOOP, oldIsLoop, isLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && ((EObject)variable).eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.DATA_PARAMETER__VARIABLE, oldVariable, variable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctData getPrimaryDistinctData() {
		if (eContainerFeatureID() != qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA) return null;
		return (DistinctData)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryDistinctData(DistinctData newPrimaryDistinctData, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPrimaryDistinctData, qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryDistinctData(DistinctData newPrimaryDistinctData) {
		if (newPrimaryDistinctData != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA && newPrimaryDistinctData != null)) {
			if (EcoreUtil.isAncestor(this, newPrimaryDistinctData))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPrimaryDistinctData != null)
				msgs = ((InternalEObject)newPrimaryDistinctData).eInverseAdd(this, qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS, DistinctData.class, msgs);
			msgs = basicSetPrimaryDistinctData(newPrimaryDistinctData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA, newPrimaryDistinctData, newPrimaryDistinctData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistinctData getSecondaryDistinctData() {
		if (eContainerFeatureID() != qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA) return null;
		return (DistinctData)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondaryDistinctData(DistinctData newSecondaryDistinctData, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSecondaryDistinctData, qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondaryDistinctData(DistinctData newSecondaryDistinctData) {
		if (newSecondaryDistinctData != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA && newSecondaryDistinctData != null)) {
			if (EcoreUtil.isAncestor(this, newSecondaryDistinctData))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSecondaryDistinctData != null)
				msgs = ((InternalEObject)newSecondaryDistinctData).eInverseAdd(this, qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS, DistinctData.class, msgs);
			msgs = basicSetSecondaryDistinctData(newSecondaryDistinctData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA, newSecondaryDistinctData, newSecondaryDistinctData));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.DATA_PARAMETER__DATUM, oldDatum, datum));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__DATUM, oldDatum, newDatum);
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
				msgs = ((InternalEObject)datum).eInverseRemove(this, qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
			if (newDatum != null)
				msgs = ((InternalEObject)newDatum).eInverseAdd(this, qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
			msgs = basicSetDatum(newDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.DATA_PARAMETER__DATUM, newDatum, newDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPrimaryDistinctData((DistinctData)otherEnd, msgs);
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSecondaryDistinctData((DistinctData)otherEnd, msgs);
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
				if (datum != null)
					msgs = ((InternalEObject)datum).eInverseRemove(this, qvtschedulePackage.ABSTRACT_DATUM__DATA_PARAMETER, AbstractDatum.class, msgs);
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
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				return basicSetPrimaryDistinctData(null, msgs);
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				return basicSetSecondaryDistinctData(null, msgs);
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.DISTINCT_DATA__PRIMARY_ARGUMENTS, DistinctData.class, msgs);
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.DISTINCT_DATA__SECONDARY_ARGUMENTS, DistinctData.class, msgs);
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
			case qvtschedulePackage.DATA_PARAMETER__IS_LOOP:
				return isIsLoop();
			case qvtschedulePackage.DATA_PARAMETER__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				return getPrimaryDistinctData();
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				return getSecondaryDistinctData();
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
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
			case qvtschedulePackage.DATA_PARAMETER__IS_LOOP:
				setIsLoop((Boolean)newValue);
				return;
			case qvtschedulePackage.DATA_PARAMETER__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				setPrimaryDistinctData((DistinctData)newValue);
				return;
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				setSecondaryDistinctData((DistinctData)newValue);
				return;
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
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
			case qvtschedulePackage.DATA_PARAMETER__IS_LOOP:
				setIsLoop(IS_LOOP_EDEFAULT);
				return;
			case qvtschedulePackage.DATA_PARAMETER__VARIABLE:
				setVariable((Variable)null);
				return;
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				setPrimaryDistinctData((DistinctData)null);
				return;
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				setSecondaryDistinctData((DistinctData)null);
				return;
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
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
			case qvtschedulePackage.DATA_PARAMETER__IS_LOOP:
				return isLoop != IS_LOOP_EDEFAULT;
			case qvtschedulePackage.DATA_PARAMETER__VARIABLE:
				return variable != null;
			case qvtschedulePackage.DATA_PARAMETER__PRIMARY_DISTINCT_DATA:
				return getPrimaryDistinctData() != null;
			case qvtschedulePackage.DATA_PARAMETER__SECONDARY_DISTINCT_DATA:
				return getSecondaryDistinctData() != null;
			case qvtschedulePackage.DATA_PARAMETER__DATUM:
				return datum != null;
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

} //DataParameterImpl
