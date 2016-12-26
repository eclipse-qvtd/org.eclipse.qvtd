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
package cs2as.companies.util;

import cs2as.companies.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cs2as.companies.CompaniesPackage
 * @generated
 */
public class CompaniesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompaniesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompaniesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CompaniesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompaniesSwitch<@Nullable Adapter> modelSwitch =
		new CompaniesSwitch<@Nullable Adapter>() {
			@Override
			public Adapter casecompany(company object) {
				return createcompanyAdapter();
			}
			@Override
			public Adapter casedepartment(department object) {
				return createdepartmentAdapter();
			}
			@Override
			public Adapter casedepartment_manager(department_manager object) {
				return createdepartment_managerAdapter();
			}
			@Override
			public Adapter casedepartment_employees(department_employees object) {
				return createdepartment_employeesAdapter();
			}
			@Override
			public Adapter caseemployee(employee object) {
				return createemployeeAdapter();
			}
			@Override
			public Adapter caseCSTrace(CSTrace object) {
				return createCSTraceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.company <em>company</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.company
	 * @generated
	 */
	public Adapter createcompanyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.department <em>department</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.department
	 * @generated
	 */
	public Adapter createdepartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.department_manager <em>department manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.department_manager
	 * @generated
	 */
	public Adapter createdepartment_managerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.department_employees <em>department employees</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.department_employees
	 * @generated
	 */
	public Adapter createdepartment_employeesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.employee <em>employee</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.employee
	 * @generated
	 */
	public Adapter createemployeeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cs2as.companies.CSTrace <em>CS Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cs2as.companies.CSTrace
	 * @generated
	 */
	public Adapter createCSTraceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CompaniesAdapterFactory
