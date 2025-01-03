/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Female;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Male;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.MemberToPerson;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsPackage
 * @generated
 */
public class Families2PersonsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Families2PersonsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Families2PersonsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Families2PersonsPackage.eINSTANCE;
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
	protected Families2PersonsSwitch<@Nullable Adapter> modelSwitch =
			new Families2PersonsSwitch<@Nullable Adapter>() {
		@Override
		public Adapter caseMemberToPerson(MemberToPerson object) {
			return createMemberToPersonAdapter();
		}
		@Override
		public Adapter caseMember2Male(Member2Male object) {
			return createMember2MaleAdapter();
		}
		@Override
		public Adapter caseMember2Female(Member2Female object) {
			return createMember2FemaleAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.MemberToPerson <em>Member To Person</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.MemberToPerson
	 * @generated
	 */
	public Adapter createMemberToPersonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Male <em>Member2 Male</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Male
	 * @generated
	 */
	public Adapter createMember2MaleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Female <em>Member2 Female</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Female
	 * @generated
	 */
	public Adapter createMember2FemaleAdapter() {
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

} //Families2PersonsAdapterFactory
