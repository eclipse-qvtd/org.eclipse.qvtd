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
 * $Id: MappingCSImpl.java,v 1.1 2008/07/23 10:06:41 qglineur Exp $
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
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl#getComposedMappings <em>Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl#getMiddle <em>Middle</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.MappingCSImpl#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingCSImpl extends IdentifiedCSImpl implements MappingCS {
	/**
	 * The cached value of the '{@link #getComposedMappings() <em>Composed Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCS> composedMappings;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainCS> domains;

	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS in;

	/**
	 * The cached value of the '{@link #getMiddle() <em>Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddle()
	 * @generated
	 * @ordered
	 */
	protected DomainCS middle;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierCS> refines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcCSTPackage.Literals.MAPPING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIn(PathNameCS newIn, NotificationChain msgs) {
		PathNameCS oldIn = in;
		in = newIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.MAPPING_CS__IN, oldIn, newIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIn(PathNameCS newIn) {
		if (newIn != in) {
			NotificationChain msgs = null;
			if (in != null)
				msgs = ((InternalEObject)in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.MAPPING_CS__IN, null, msgs);
			if (newIn != null)
				msgs = ((InternalEObject)newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.MAPPING_CS__IN, null, msgs);
			msgs = basicSetIn(newIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.MAPPING_CS__IN, newIn, newIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainCS getMiddle()
	{
		return middle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMiddle(DomainCS newMiddle, NotificationChain msgs)
	{
		DomainCS oldMiddle = middle;
		middle = newMiddle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.MAPPING_CS__MIDDLE, oldMiddle, newMiddle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddle(DomainCS newMiddle)
	{
		if (newMiddle != middle) {
			NotificationChain msgs = null;
			if (middle != null)
				msgs = ((InternalEObject)middle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.MAPPING_CS__MIDDLE, null, msgs);
			if (newMiddle != null)
				msgs = ((InternalEObject)newMiddle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.MAPPING_CS__MIDDLE, null, msgs);
			msgs = basicSetMiddle(newMiddle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.MAPPING_CS__MIDDLE, newMiddle, newMiddle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierCS> getRefines() {
		if (refines == null) {
			refines = new EObjectContainmentEList<IdentifierCS>(IdentifierCS.class, this, QVTcCSTPackage.MAPPING_CS__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingCS> getComposedMappings() {
		if (composedMappings == null) {
			composedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS);
		}
		return composedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainCS> getDomains() {
		if (domains == null) {
			domains = new EObjectContainmentEList<DomainCS>(DomainCS.class, this, QVTcCSTPackage.MAPPING_CS__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return ((InternalEList<?>)getComposedMappings()).basicRemove(otherEnd, msgs);
			case QVTcCSTPackage.MAPPING_CS__DOMAINS:
				return ((InternalEList<?>)getDomains()).basicRemove(otherEnd, msgs);
			case QVTcCSTPackage.MAPPING_CS__IN:
				return basicSetIn(null, msgs);
			case QVTcCSTPackage.MAPPING_CS__MIDDLE:
				return basicSetMiddle(null, msgs);
			case QVTcCSTPackage.MAPPING_CS__REFINES:
				return ((InternalEList<?>)getRefines()).basicRemove(otherEnd, msgs);
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
			case QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return getComposedMappings();
			case QVTcCSTPackage.MAPPING_CS__DOMAINS:
				return getDomains();
			case QVTcCSTPackage.MAPPING_CS__IN:
				return getIn();
			case QVTcCSTPackage.MAPPING_CS__MIDDLE:
				return getMiddle();
			case QVTcCSTPackage.MAPPING_CS__REFINES:
				return getRefines();
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
			case QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				getComposedMappings().clear();
				getComposedMappings().addAll((Collection<? extends MappingCS>)newValue);
				return;
			case QVTcCSTPackage.MAPPING_CS__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends DomainCS>)newValue);
				return;
			case QVTcCSTPackage.MAPPING_CS__IN:
				setIn((PathNameCS)newValue);
				return;
			case QVTcCSTPackage.MAPPING_CS__MIDDLE:
				setMiddle((DomainCS)newValue);
				return;
			case QVTcCSTPackage.MAPPING_CS__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends IdentifierCS>)newValue);
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
			case QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				getComposedMappings().clear();
				return;
			case QVTcCSTPackage.MAPPING_CS__DOMAINS:
				getDomains().clear();
				return;
			case QVTcCSTPackage.MAPPING_CS__IN:
				setIn((PathNameCS)null);
				return;
			case QVTcCSTPackage.MAPPING_CS__MIDDLE:
				setMiddle((DomainCS)null);
				return;
			case QVTcCSTPackage.MAPPING_CS__REFINES:
				getRefines().clear();
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
			case QVTcCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return composedMappings != null && !composedMappings.isEmpty();
			case QVTcCSTPackage.MAPPING_CS__DOMAINS:
				return domains != null && !domains.isEmpty();
			case QVTcCSTPackage.MAPPING_CS__IN:
				return in != null;
			case QVTcCSTPackage.MAPPING_CS__MIDDLE:
				return middle != null;
			case QVTcCSTPackage.MAPPING_CS__REFINES:
				return refines != null && !refines.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingCSImpl
