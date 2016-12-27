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
import delphi.functionHeading;
import delphi.procedureHeading;
import delphi.procedureType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>procedure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.procedureTypeImpl#getPHeading <em>PHeading</em>}</li>
 *   <li>{@link delphi.impl.procedureTypeImpl#getFHeading <em>FHeading</em>}</li>
 * </ul>
 *
 * @generated
 */
public class procedureTypeImpl extends typeImpl implements procedureType {
	/**
	 * The cached value of the '{@link #getPHeading() <em>PHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPHeading()
	 * @generated
	 * @ordered
	 */
	protected procedureHeading pHeading;

	/**
	 * The cached value of the '{@link #getFHeading() <em>FHeading</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFHeading()
	 * @generated
	 * @ordered
	 */
	protected functionHeading fHeading;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected procedureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.PROCEDURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public procedureHeading getPHeading() {
		return pHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPHeading(procedureHeading newPHeading, NotificationChain msgs) {
		procedureHeading oldPHeading = pHeading;
		pHeading = newPHeading;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROCEDURE_TYPE__PHEADING, oldPHeading, newPHeading);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPHeading(procedureHeading newPHeading) {
		if (newPHeading != pHeading) {
			NotificationChain msgs = null;
			if (pHeading != null)
				msgs = ((InternalEObject)pHeading).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROCEDURE_TYPE__PHEADING, null, msgs);
			if (newPHeading != null)
				msgs = ((InternalEObject)newPHeading).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROCEDURE_TYPE__PHEADING, null, msgs);
			msgs = basicSetPHeading(newPHeading, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROCEDURE_TYPE__PHEADING, newPHeading, newPHeading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public functionHeading getFHeading() {
		return fHeading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFHeading(functionHeading newFHeading, NotificationChain msgs) {
		functionHeading oldFHeading = fHeading;
		fHeading = newFHeading;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.PROCEDURE_TYPE__FHEADING, oldFHeading, newFHeading);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFHeading(functionHeading newFHeading) {
		if (newFHeading != fHeading) {
			NotificationChain msgs = null;
			if (fHeading != null)
				msgs = ((InternalEObject)fHeading).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROCEDURE_TYPE__FHEADING, null, msgs);
			if (newFHeading != null)
				msgs = ((InternalEObject)newFHeading).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.PROCEDURE_TYPE__FHEADING, null, msgs);
			msgs = basicSetFHeading(newFHeading, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.PROCEDURE_TYPE__FHEADING, newFHeading, newFHeading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.PROCEDURE_TYPE__PHEADING:
				return basicSetPHeading(null, msgs);
			case DelphiPackage.PROCEDURE_TYPE__FHEADING:
				return basicSetFHeading(null, msgs);
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
			case DelphiPackage.PROCEDURE_TYPE__PHEADING:
				return getPHeading();
			case DelphiPackage.PROCEDURE_TYPE__FHEADING:
				return getFHeading();
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
			case DelphiPackage.PROCEDURE_TYPE__PHEADING:
				setPHeading((procedureHeading)newValue);
				return;
			case DelphiPackage.PROCEDURE_TYPE__FHEADING:
				setFHeading((functionHeading)newValue);
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
			case DelphiPackage.PROCEDURE_TYPE__PHEADING:
				setPHeading((procedureHeading)null);
				return;
			case DelphiPackage.PROCEDURE_TYPE__FHEADING:
				setFHeading((functionHeading)null);
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
			case DelphiPackage.PROCEDURE_TYPE__PHEADING:
				return pHeading != null;
			case DelphiPackage.PROCEDURE_TYPE__FHEADING:
				return fHeading != null;
		}
		return super.eIsSet(featureID);
	}


} //procedureTypeImpl
