/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl#getInputParamDeclaration <em>Input Param Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.QueryCSImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryCSImpl extends ModelElementCSImpl implements QueryCS {
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
	protected ExpCS oclExpression;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypedTypeRefCS type;

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
		return QVTrelationCSTPackage.Literals.QUERY_CS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__PATH_NAME, oldPathName, newPathName);
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
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__PATH_NAME, newPathName, newPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParamDeclarationCS> getInputParamDeclaration() {
		if (inputParamDeclaration == null) {
			inputParamDeclaration = new EObjectContainmentEList<ParamDeclarationCS>(ParamDeclarationCS.class, this, QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION);
		}
		return inputParamDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(ExpCS newOclExpression, NotificationChain msgs) {
		ExpCS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(ExpCS newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedTypeRefCS getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypedTypeRefCS newType, NotificationChain msgs) {
		TypedTypeRefCS oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypedTypeRefCS newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.QUERY_CS__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.QUERY_CS__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.QUERY_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return ((InternalEList<?>)getInputParamDeclaration()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
			case QVTrelationCSTPackage.QUERY_CS__TYPE:
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
			case QVTrelationCSTPackage.QUERY_CS__PATH_NAME:
				return getPathName();
			case QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return getInputParamDeclaration();
			case QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return getOclExpression();
			case QVTrelationCSTPackage.QUERY_CS__TYPE:
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
			case QVTrelationCSTPackage.QUERY_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				getInputParamDeclaration().addAll((Collection<? extends ParamDeclarationCS>)newValue);
				return;
			case QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((ExpCS)newValue);
				return;
			case QVTrelationCSTPackage.QUERY_CS__TYPE:
				setType((TypedTypeRefCS)newValue);
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
			case QVTrelationCSTPackage.QUERY_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				getInputParamDeclaration().clear();
				return;
			case QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION:
				setOclExpression((ExpCS)null);
				return;
			case QVTrelationCSTPackage.QUERY_CS__TYPE:
				setType((TypedTypeRefCS)null);
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
			case QVTrelationCSTPackage.QUERY_CS__PATH_NAME:
				return pathName != null;
			case QVTrelationCSTPackage.QUERY_CS__INPUT_PARAM_DECLARATION:
				return inputParamDeclaration != null && !inputParamDeclaration.isEmpty();
			case QVTrelationCSTPackage.QUERY_CS__OCL_EXPRESSION:
				return oclExpression != null;
			case QVTrelationCSTPackage.QUERY_CS__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitQueryCS(this);
	}

	public String getName() {
//		if ((pathName != null) && !pathName.eIsProxy()) {
//			return pathName.getName();
//		}
		return "null";
	}
} //QueryCSImpl
