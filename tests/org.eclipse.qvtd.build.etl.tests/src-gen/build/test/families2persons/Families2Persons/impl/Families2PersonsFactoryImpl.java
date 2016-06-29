/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
package build.test.families2persons.Families2Persons.impl;

import build.test.families2persons.Families2Persons.*;

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
public class Families2PersonsFactoryImpl extends EFactoryImpl implements Families2PersonsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Families2PersonsFactory init() {
		try {
			Families2PersonsFactory theFamilies2PersonsFactory = (Families2PersonsFactory)EPackage.Registry.INSTANCE.getEFactory(Families2PersonsPackage.eNS_URI);
			if (theFamilies2PersonsFactory != null) {
				return theFamilies2PersonsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Families2PersonsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Families2PersonsFactoryImpl() {
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
			case Families2PersonsPackage.MEMBER2_MALE: return createMember2Male();
			case Families2PersonsPackage.MEMBER2_FEMALE: return createMember2Female();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member2Male createMember2Male() {
		Member2MaleImpl member2Male = new Member2MaleImpl();
		return member2Male;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member2Female createMember2Female() {
		Member2FemaleImpl member2Female = new Member2FemaleImpl();
		return member2Female;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Families2PersonsPackage getFamilies2PersonsPackage() {
		return (Families2PersonsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Families2PersonsPackage getPackage() {
		return Families2PersonsPackage.eINSTANCE;
	}

} //Families2PersonsFactoryImpl
