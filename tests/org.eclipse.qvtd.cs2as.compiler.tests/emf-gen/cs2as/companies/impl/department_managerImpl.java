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
package cs2as.companies.impl;

import cs2as.companies.CompaniesPackage;
import cs2as.companies.department_manager;
import cs2as.companies.employee;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>department manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.impl.department_managerImpl#getEmployee <em>Employee</em>}</li>
 * </ul>
 *
 * @generated
 */
public class department_managerImpl extends CSTraceImpl implements department_manager {
	/**
	 * The cached value of the '{@link #getEmployee() <em>Employee</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployee()
	 * @generated
	 * @ordered
	 */
	protected employee employee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected department_managerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompaniesPackage.Literals.DEPARTMENT_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public employee getEmployee() {
		return employee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmployee(employee newEmployee, NotificationChain msgs) {
		employee oldEmployee = employee;
		employee = newEmployee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE, oldEmployee, newEmployee);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployee(employee newEmployee) {
		if (newEmployee != employee) {
			NotificationChain msgs = null;
			if (employee != null)
				msgs = ((InternalEObject)employee).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE, null, msgs);
			if (newEmployee != null)
				msgs = ((InternalEObject)newEmployee).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE, null, msgs);
			msgs = basicSetEmployee(newEmployee, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE, newEmployee, newEmployee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE:
				return basicSetEmployee(null, msgs);
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
			case CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE:
				return getEmployee();
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
			case CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE:
				setEmployee((employee)newValue);
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
			case CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE:
				setEmployee((employee)null);
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
			case CompaniesPackage.DEPARTMENT_MANAGER__EMPLOYEE:
				return employee != null;
		}
		return super.eIsSet(featureID);
	}


} //department_managerImpl
