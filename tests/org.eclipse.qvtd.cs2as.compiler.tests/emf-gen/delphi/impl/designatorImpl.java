/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.designator;
import delphi.designatorSubPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>designator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.designatorImpl#getSubpart <em>Subpart</em>}</li>
 *   <li>{@link delphi.impl.designatorImpl#getDesignator <em>Designator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class designatorImpl extends CSTraceImpl implements designator {
	/**
	 * The cached value of the '{@link #getSubpart() <em>Subpart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpart()
	 * @generated
	 * @ordered
	 */
	protected designatorSubPart subpart;

	/**
	 * The cached value of the '{@link #getDesignator() <em>Designator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignator()
	 * @generated
	 * @ordered
	 */
	protected designator designator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected designatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.DESIGNATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designatorSubPart getSubpart() {
		return subpart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubpart(designatorSubPart newSubpart, NotificationChain msgs) {
		designatorSubPart oldSubpart = subpart;
		subpart = newSubpart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR__SUBPART, oldSubpart, newSubpart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubpart(designatorSubPart newSubpart) {
		if (newSubpart != subpart) {
			NotificationChain msgs = null;
			if (subpart != null)
				msgs = ((InternalEObject)subpart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR__SUBPART, null, msgs);
			if (newSubpart != null)
				msgs = ((InternalEObject)newSubpart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR__SUBPART, null, msgs);
			msgs = basicSetSubpart(newSubpart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR__SUBPART, newSubpart, newSubpart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designator getDesignator() {
		return designator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDesignator(designator newDesignator, NotificationChain msgs) {
		designator oldDesignator = designator;
		designator = newDesignator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR__DESIGNATOR, oldDesignator, newDesignator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesignator(designator newDesignator) {
		if (newDesignator != designator) {
			NotificationChain msgs = null;
			if (designator != null)
				msgs = ((InternalEObject)designator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR__DESIGNATOR, null, msgs);
			if (newDesignator != null)
				msgs = ((InternalEObject)newDesignator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR__DESIGNATOR, null, msgs);
			msgs = basicSetDesignator(newDesignator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR__DESIGNATOR, newDesignator, newDesignator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.DESIGNATOR__SUBPART:
				return basicSetSubpart(null, msgs);
			case DelphiPackage.DESIGNATOR__DESIGNATOR:
				return basicSetDesignator(null, msgs);
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
			case DelphiPackage.DESIGNATOR__SUBPART:
				return getSubpart();
			case DelphiPackage.DESIGNATOR__DESIGNATOR:
				return getDesignator();
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
			case DelphiPackage.DESIGNATOR__SUBPART:
				setSubpart((designatorSubPart)newValue);
				return;
			case DelphiPackage.DESIGNATOR__DESIGNATOR:
				setDesignator((designator)newValue);
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
			case DelphiPackage.DESIGNATOR__SUBPART:
				setSubpart((designatorSubPart)null);
				return;
			case DelphiPackage.DESIGNATOR__DESIGNATOR:
				setDesignator((designator)null);
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
			case DelphiPackage.DESIGNATOR__SUBPART:
				return subpart != null;
			case DelphiPackage.DESIGNATOR__DESIGNATOR:
				return designator != null;
		}
		return super.eIsSet(featureID);
	}


} //designatorImpl
