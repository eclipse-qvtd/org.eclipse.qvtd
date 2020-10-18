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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.PathNameCS;

import org.eclipse.ocl.xtext.basecs.impl.ClassCSImpl;

import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Transformation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl#getOwnedTargets <em>Owned Targets</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTransformationCSImpl extends ClassCSImpl implements AbstractTransformationCS
{
	/**
	 * The number of structural features of the '<em>Abstract Transformation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT = ClassCSImpl.CLASS_CS_FEATURE_COUNT + 2;
	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;

	/**
	 * The cached value of the '{@link #getOwnedTargets() <em>Owned Targets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargets()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetCS> ownedTargets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractTransformationCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return QVTbaseCSPackage.Literals.ABSTRACT_TRANSFORMATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedPathName()
	{
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs)
	{
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0, oldOwnedPathName, newOwnedPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedPathName(PathNameCS newOwnedPathName)
	{
		if (newOwnedPathName != ownedPathName)
		{
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0), null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0), null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetCS> getOwnedTargets()
	{
		if (ownedTargets == null)
		{
			ownedTargets = new EObjectContainmentEList<TargetCS>(TargetCS.class, this, ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1);
		}
		return ownedTargets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0:
				return basicSetOwnedPathName(null, msgs);
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedTargets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0:
				return getOwnedPathName();
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1:
				return getOwnedTargets();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1:
				getOwnedTargets().clear();
				getOwnedTargets().addAll((Collection<? extends TargetCS>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0:
				setOwnedPathName((PathNameCS)null);
				return;
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1:
				getOwnedTargets().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 0:
				return ownedPathName != null;
			case ClassCSImpl.CLASS_CS_FEATURE_COUNT + 1:
				return ownedTargets != null && !ownedTargets.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //AbstractTransformationCSImpl
