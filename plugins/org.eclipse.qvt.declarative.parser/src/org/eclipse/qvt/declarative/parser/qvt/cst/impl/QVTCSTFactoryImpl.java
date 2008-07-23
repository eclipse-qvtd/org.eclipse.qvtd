/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTCSTFactoryImpl.java,v 1.1 2008/07/23 10:05:08 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.parser.qvt.cst.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTCSTFactoryImpl extends EFactoryImpl implements QVTCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTCSTFactory init() {
		try {
			QVTCSTFactory theQVTCSTFactory = (QVTCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/QVTcst"); 
			if (theQVTCSTFactory != null) {
				return theQVTCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTCSTFactoryImpl() {
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
			case QVTCSTPackage.IDENTIFIED_CS: return createIdentifiedCS();
			case QVTCSTPackage.IDENTIFIER_CS: return createIdentifierCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiedCS createIdentifiedCS() {
		IdentifiedCSImpl identifiedCS = new IdentifiedCSImpl();
		return identifiedCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS createIdentifierCS() {
		IdentifierCSImpl identifierCS = new IdentifierCSImpl();
		return identifierCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTCSTPackage getQVTCSTPackage() {
		return (QVTCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTCSTPackage getPackage() {
		return QVTCSTPackage.eINSTANCE;
	}

} //EqvtCSTFactoryImpl
