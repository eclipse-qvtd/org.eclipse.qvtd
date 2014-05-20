/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSFactory;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.TopLevelCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreCSFactoryImpl extends EFactoryImpl implements QVTcoreCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreCSFactory init() {
		try {
			QVTcoreCSFactory theQVTcoreCSFactory = (QVTcoreCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTcoreCSPackage.eNS_URI);
			if (theQVTcoreCSFactory != null) {
				return theQVTcoreCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreCSFactoryImpl() {
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
			case QVTcoreCSPackage.MAPPING_CS: return createMappingCS();
			case QVTcoreCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCS createMappingCS() {
		MappingCSImpl mappingCS = new MappingCSImpl();
		return mappingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreCSPackage getQVTcoreCSPackage() {
		return (QVTcoreCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcoreCSPackage getPackage() {
		return QVTcoreCSPackage.eINSTANCE;
	}

} //QVTcoreCSTFactoryImpl
