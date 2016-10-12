/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PForward2ReverseFactoryImpl extends EFactoryImpl implements PForward2ReverseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PForward2ReverseFactory init() {
		try {
			PForward2ReverseFactory thePForward2ReverseFactory = (PForward2ReverseFactory)EPackage.Registry.INSTANCE.getEFactory(PForward2ReversePackage.eNS_URI);
			if (thePForward2ReverseFactory != null) {
				return thePForward2ReverseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PForward2ReverseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PForward2ReverseFactoryImpl() {
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
			case PForward2ReversePackage.TELEMENT2ELEMENT: return createTelement2element();
			case PForward2ReversePackage.TEMPTY_LIST2EMPTY_LIST: return createTemptyList2emptyList();
			case PForward2ReversePackage.TLIST2LIST: return createTlist2list();
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
	public Telement2element createTelement2element() {
		Telement2elementImpl telement2element = new Telement2elementImpl();
		return telement2element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemptyList2emptyList createTemptyList2emptyList() {
		TemptyList2emptyListImpl temptyList2emptyList = new TemptyList2emptyListImpl();
		return temptyList2emptyList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tlist2list createTlist2list() {
		Tlist2listImpl tlist2list = new Tlist2listImpl();
		return tlist2list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PForward2ReversePackage getPForward2ReversePackage() {
		return (PForward2ReversePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PForward2ReversePackage getPackage() {
		return PForward2ReversePackage.eINSTANCE;
	}

} //PForward2ReverseFactoryImpl
