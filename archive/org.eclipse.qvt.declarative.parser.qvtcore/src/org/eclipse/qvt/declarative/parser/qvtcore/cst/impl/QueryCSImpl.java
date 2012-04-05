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
 * $Id: QueryCSImpl.java,v 1.2 2009/10/21 07:48:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.utils.StringUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl#getInputParamDeclaration <em>Input Param Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.QueryCSImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryCSImpl extends CSTNodeImpl implements QueryCS {
	/**
	 * The cached value of the '{@link #getInputParamDeclaration() <em>Input Param Declaration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParamDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<ParamDeclarationCS> inputParamDeclaration;

	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS oclExpression;

	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathName;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeCS type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcCSTPackage.Literals.QUERY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathName() {
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs) {
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(PathNameCS newPathName) {
		if (newPathName != pathName) {
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__PATH_NAME, newPathName, newPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamDeclarationCS> getInputParamDeclaration() {
		if (inputParamDeclaration == null) {
			inputParamDeclaration = new EObjectContainmentEList<ParamDeclarationCS>(ParamDeclarationCS.class, this, QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION);
		}
		return inputParamDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(OCLExpressionCS newOclExpression, NotificationChain msgs) {
		OCLExpressionCS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(OCLExpressionCS newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeCS newType, NotificationChain msgs) {
		TypeCS oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeCS newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.QUERY_CS__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.QUERY_CS__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return ((InternalEList<?>)getInputParamDeclaration()).basicRemove(otherEnd, msgs);
			case QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
			case QVTcCSTPackage.QUERY_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case QVTcCSTPackage.QUERY_CS__TYPE:
				return basicSetType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return getInputParamDeclaration();
			case QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return getOclExpression();
			case QVTcCSTPackage.QUERY_CS__PATH_NAME:
				return getPathName();
			case QVTcCSTPackage.QUERY_CS__TYPE:
				return getType();
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
			case QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				getInputParamDeclaration().addAll((Collection<? extends ParamDeclarationCS>)newValue);
				return;
			case QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((OCLExpressionCS)newValue);
				return;
			case QVTcCSTPackage.QUERY_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case QVTcCSTPackage.QUERY_CS__TYPE:
				setType((TypeCS)newValue);
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
			case QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				return;
			case QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((OCLExpressionCS)null);
				return;
			case QVTcCSTPackage.QUERY_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case QVTcCSTPackage.QUERY_CS__TYPE:
				setType((TypeCS)null);
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
			case QVTcCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return inputParamDeclaration != null && !inputParamDeclaration.isEmpty();
			case QVTcCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return oclExpression != null;
			case QVTcCSTPackage.QUERY_CS__PATH_NAME:
				return pathName != null;
			case QVTcCSTPackage.QUERY_CS__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	public String getName() {
		return StringUtils.splice(AbstractQVTAnalyzer.createSequenceOfNames(pathName, null), "::");
	}
} //QueryCSImpl
