/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.target.lookup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import example1.target.lookup.EnvironmentFactory;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentFactoryImpl extends EFactoryImpl implements EnvironmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnvironmentFactory init() {
		try {
			EnvironmentFactory theEnvironmentFactory = (EnvironmentFactory)EPackage.Registry.INSTANCE.getEFactory(EnvironmentPackage.eNS_URI);
			if (theEnvironmentFactory != null) {
				return theEnvironmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EnvironmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentFactoryImpl() {
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
			case 0: return createLookupEnvironment();
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
	public LookupEnvironment createLookupEnvironment() {
		LookupEnvironmentImpl lookupEnvironment = new LookupEnvironmentImpl();
		return lookupEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnvironmentPackage getEnvironmentPackage() {
		return (EnvironmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EnvironmentPackage getPackage() {
		return EnvironmentPackage.eINSTANCE;
	}

} //EnvironmentFactoryImpl
