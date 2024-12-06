/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtbasecs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTbaseCSFactoryImpl extends EFactoryImpl implements QVTbaseCSFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTbaseCSFactory init()
	{
		try
		{
			QVTbaseCSFactory theQVTbaseCSFactory = (QVTbaseCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTbaseCSPackage.eNS_URI);
			if (theQVTbaseCSFactory != null)
			{
				return theQVTbaseCSFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTbaseCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTbaseCSFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case 1: return createCompoundTargetElementCS();
			case 3: return createQualifiedPackageCS();
			case 4: return createSimpleTargetElementCS();
			case 5: return createTargetCS();
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
	public CompoundTargetElementCS createCompoundTargetElementCS()
	{
		CompoundTargetElementCSImpl compoundTargetElementCS = new CompoundTargetElementCSImpl();
		return compoundTargetElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull QualifiedPackageCS createQualifiedPackageCS()
	{
		QualifiedPackageCSImpl qualifiedPackageCS = new QualifiedPackageCSImpl();
		return qualifiedPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleTargetElementCS createSimpleTargetElementCS()
	{
		SimpleTargetElementCSImpl simpleTargetElementCS = new SimpleTargetElementCSImpl();
		return simpleTargetElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetCS createTargetCS()
	{
		TargetCSImpl targetCS = new TargetCSImpl();
		return targetCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTbaseCSPackage getQVTbaseCSPackage()
	{
		return (QVTbaseCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTbaseCSPackage getPackage()
	{
		return QVTbaseCSPackage.eINSTANCE;
	}

} //QVTbaseCSFactoryImpl
