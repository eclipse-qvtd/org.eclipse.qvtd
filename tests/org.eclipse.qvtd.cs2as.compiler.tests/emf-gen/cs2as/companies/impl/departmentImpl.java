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
import cs2as.companies.department;
import cs2as.companies.department_employees;
import cs2as.companies.department_manager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>department</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link cs2as.companies.impl.departmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link cs2as.companies.impl.departmentImpl#getDepartment_manager <em>Department manager</em>}</li>
 *   <li>{@link cs2as.companies.impl.departmentImpl#getDepartment_employees <em>Department employees</em>}</li>
 *   <li>{@link cs2as.companies.impl.departmentImpl#getDeparment <em>Deparment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class departmentImpl extends CSTraceImpl implements department {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDepartment_manager() <em>Department manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment_manager()
	 * @generated
	 * @ordered
	 */
	protected department_manager department_manager;

	/**
	 * The cached value of the '{@link #getDepartment_employees() <em>Department employees</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartment_employees()
	 * @generated
	 * @ordered
	 */
	protected department_employees department_employees;

	/**
	 * The cached value of the '{@link #getDeparment() <em>Deparment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeparment()
	 * @generated
	 * @ordered
	 */
	protected EList<department> deparment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected departmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompaniesPackage.Literals.DEPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public department_manager getDepartment_manager() {
		return department_manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartment_manager(department_manager newDepartment_manager, NotificationChain msgs) {
		department_manager oldDepartment_manager = department_manager;
		department_manager = newDepartment_manager;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER, oldDepartment_manager, newDepartment_manager);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment_manager(department_manager newDepartment_manager) {
		if (newDepartment_manager != department_manager) {
			NotificationChain msgs = null;
			if (department_manager != null)
				msgs = ((InternalEObject)department_manager).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER, null, msgs);
			if (newDepartment_manager != null)
				msgs = ((InternalEObject)newDepartment_manager).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER, null, msgs);
			msgs = basicSetDepartment_manager(newDepartment_manager, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER, newDepartment_manager, newDepartment_manager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public department_employees getDepartment_employees() {
		return department_employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepartment_employees(department_employees newDepartment_employees, NotificationChain msgs) {
		department_employees oldDepartment_employees = department_employees;
		department_employees = newDepartment_employees;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES, oldDepartment_employees, newDepartment_employees);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartment_employees(department_employees newDepartment_employees) {
		if (newDepartment_employees != department_employees) {
			NotificationChain msgs = null;
			if (department_employees != null)
				msgs = ((InternalEObject)department_employees).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES, null, msgs);
			if (newDepartment_employees != null)
				msgs = ((InternalEObject)newDepartment_employees).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES, null, msgs);
			msgs = basicSetDepartment_employees(newDepartment_employees, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES, newDepartment_employees, newDepartment_employees));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<department> getDeparment() {
		if (deparment == null) {
			deparment = new EObjectContainmentEList<department>(department.class, this, CompaniesPackage.DEPARTMENT__DEPARMENT);
		}
		return deparment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER:
				return basicSetDepartment_manager(null, msgs);
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES:
				return basicSetDepartment_employees(null, msgs);
			case CompaniesPackage.DEPARTMENT__DEPARMENT:
				return ((InternalEList<?>)getDeparment()).basicRemove(otherEnd, msgs);
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
			case CompaniesPackage.DEPARTMENT__NAME:
				return getName();
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER:
				return getDepartment_manager();
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES:
				return getDepartment_employees();
			case CompaniesPackage.DEPARTMENT__DEPARMENT:
				return getDeparment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompaniesPackage.DEPARTMENT__NAME:
				setName((String)newValue);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER:
				setDepartment_manager((department_manager)newValue);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES:
				setDepartment_employees((department_employees)newValue);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARMENT:
				getDeparment().clear();
				getDeparment().addAll((Collection<? extends department>)newValue);
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
			case CompaniesPackage.DEPARTMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER:
				setDepartment_manager((department_manager)null);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES:
				setDepartment_employees((department_employees)null);
				return;
			case CompaniesPackage.DEPARTMENT__DEPARMENT:
				getDeparment().clear();
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
			case CompaniesPackage.DEPARTMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_MANAGER:
				return department_manager != null;
			case CompaniesPackage.DEPARTMENT__DEPARTMENT_EMPLOYEES:
				return department_employees != null;
			case CompaniesPackage.DEPARTMENT__DEPARMENT:
				return deparment != null && !deparment.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //departmentImpl
