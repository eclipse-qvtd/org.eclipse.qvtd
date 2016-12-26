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

import cs2as.companies.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompaniesFactoryImpl extends EFactoryImpl implements CompaniesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompaniesFactory init() {
		try {
			CompaniesFactory theCompaniesFactory = (CompaniesFactory)EPackage.Registry.INSTANCE.getEFactory(CompaniesPackage.eNS_URI);
			if (theCompaniesFactory != null) {
				return theCompaniesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompaniesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompaniesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CompaniesPackage.COMPANY: return createcompany();
			case CompaniesPackage.DEPARTMENT: return createdepartment();
			case CompaniesPackage.DEPARTMENT_MANAGER: return createdepartment_manager();
			case CompaniesPackage.DEPARTMENT_EMPLOYEES: return createdepartment_employees();
			case CompaniesPackage.EMPLOYEE: return createemployee();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public company createcompany() {
		companyImpl company = new companyImpl();
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public department createdepartment() {
		departmentImpl department = new departmentImpl();
		return department;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public department_manager createdepartment_manager() {
		department_managerImpl department_manager = new department_managerImpl();
		return department_manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public department_employees createdepartment_employees() {
		department_employeesImpl department_employees = new department_employeesImpl();
		return department_employees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public employee createemployee() {
		employeeImpl employee = new employeeImpl();
		return employee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompaniesPackage getCompaniesPackage() {
		return (CompaniesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompaniesPackage getPackage() {
		return CompaniesPackage.eINSTANCE;
	}

} //CompaniesFactoryImpl
