/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
package example1.source.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import example1.source.PathElementCS;
import example1.source.PathNameCS;
import example1.source.SElement;
import example1.source.SRoot;
import example1.source.SourceFactory;
import example1.source.SourcePackage;
import example1.source.X;
import example1.source.Y1;
import example1.source.Y2;
import example1.source.Z;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceFactoryImpl extends EFactoryImpl implements SourceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SourceFactory init() {
		try {
			SourceFactory theSourceFactory = (SourceFactory)EPackage.Registry.INSTANCE.getEFactory(SourcePackage.eNS_URI);
			if (theSourceFactory != null) {
				return theSourceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFactoryImpl() {
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
			case 0: return createX();
			case 2: return createY1();
			case 3: return createY2();
			case 4: return createZ();
			case 5: return createSRoot();
			case 6: return createSElement();
			case 7: return createPathNameCS();
			case 8: return createPathElementCS();
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
	public X createX() {
		XImpl x = new XImpl();
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Y1 createY1() {
		Y1Impl y1 = new Y1Impl();
		return y1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Y2 createY2() {
		Y2Impl y2 = new Y2Impl();
		return y2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Z createZ() {
		ZImpl z = new ZImpl();
		return z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SRoot createSRoot() {
		SRootImpl sRoot = new SRootImpl();
		return sRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SElement createSElement() {
		SElementImpl sElement = new SElementImpl();
		return sElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS createPathNameCS() {
		PathNameCSImpl pathNameCS = new PathNameCSImpl();
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathElementCS createPathElementCS() {
		PathElementCSImpl pathElementCS = new PathElementCSImpl();
		return pathElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourcePackage getSourcePackage() {
		return (SourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SourcePackage getPackage() {
		return SourcePackage.eINSTANCE;
	}

} //SourceFactoryImpl
