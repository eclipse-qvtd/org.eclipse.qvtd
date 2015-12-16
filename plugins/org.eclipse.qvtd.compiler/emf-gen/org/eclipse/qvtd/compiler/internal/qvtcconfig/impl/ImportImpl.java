/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.compiler.internal.qvtcconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.qvtd.compiler.internal.qvtcconfig.Import;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl#getMetamodelFile <em>Metamodel File</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ImportImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportImpl extends NamedElementImpl implements Import {
	/**
	 * The default value of the '{@link #getMetamodelFile() <em>Metamodel File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelFile()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_FILE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMetamodelFile() <em>Metamodel File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelFile()
	 * @generated
	 * @ordered
	 */
	protected String metamodelFile = METAMODEL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_URI_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodelUri()
	 * @generated
	 * @ordered
	 */
	protected String metamodelUri = METAMODEL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<String> package_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcConfigPackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetamodelFile() {
		return metamodelFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetamodelFile(String newMetamodelFile) {
		String oldMetamodelFile = metamodelFile;
		metamodelFile = newMetamodelFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.IMPORT__METAMODEL_FILE, oldMetamodelFile, metamodelFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetamodelUri() {
		return metamodelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetamodelUri(String newMetamodelUri) {
		String oldMetamodelUri = metamodelUri;
		metamodelUri = newMetamodelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.IMPORT__METAMODEL_URI, oldMetamodelUri, metamodelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPackage() {
		if (package_ == null) {
			package_ = new EDataTypeUniqueEList<String>(String.class, this, QVTcConfigPackage.IMPORT__PACKAGE);
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcConfigPackage.IMPORT__METAMODEL_FILE:
				return getMetamodelFile();
			case QVTcConfigPackage.IMPORT__METAMODEL_URI:
				return getMetamodelUri();
			case QVTcConfigPackage.IMPORT__PACKAGE:
				return getPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTcConfigPackage.IMPORT__METAMODEL_FILE:
				setMetamodelFile((String)newValue);
				return;
			case QVTcConfigPackage.IMPORT__METAMODEL_URI:
				setMetamodelUri((String)newValue);
				return;
			case QVTcConfigPackage.IMPORT__PACKAGE:
				getPackage().clear();
				getPackage().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QVTcConfigPackage.IMPORT__METAMODEL_FILE:
				setMetamodelFile(METAMODEL_FILE_EDEFAULT);
				return;
			case QVTcConfigPackage.IMPORT__METAMODEL_URI:
				setMetamodelUri(METAMODEL_URI_EDEFAULT);
				return;
			case QVTcConfigPackage.IMPORT__PACKAGE:
				getPackage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QVTcConfigPackage.IMPORT__METAMODEL_FILE:
				return METAMODEL_FILE_EDEFAULT == null ? metamodelFile != null : !METAMODEL_FILE_EDEFAULT.equals(metamodelFile);
			case QVTcConfigPackage.IMPORT__METAMODEL_URI:
				return METAMODEL_URI_EDEFAULT == null ? metamodelUri != null : !METAMODEL_URI_EDEFAULT.equals(metamodelUri);
			case QVTcConfigPackage.IMPORT__PACKAGE:
				return package_ != null && !package_.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (metamodelFile: ");
		result.append(metamodelFile);
		result.append(", metamodelUri: ");
		result.append(metamodelUri);
		result.append(", package: ");
		result.append(package_);
		result.append(')');
		return result.toString();
	}

} //ImportImpl
