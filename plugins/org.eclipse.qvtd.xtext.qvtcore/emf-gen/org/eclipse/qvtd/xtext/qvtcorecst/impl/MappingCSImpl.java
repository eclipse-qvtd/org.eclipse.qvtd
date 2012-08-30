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
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl#getComposedMappings <em>Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl#getMiddle <em>Middle</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecst.impl.MappingCSImpl#getRefines <em>Refines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingCSImpl extends NamedElementCSImpl implements MappingCS {
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
	 * The cached value of the '{@link #getIn() <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected Transformation in;

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
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> refines;

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
		return QVTcoreCSTPackage.Literals.MAPPING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingCS> getComposedMappings() {
		if (composedMappings == null) {
			composedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS);
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
			domains = new EObjectContainmentEList<DomainCS>(DomainCS.class, this, QVTcoreCSTPackage.MAPPING_CS__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation getIn() {
		if (in != null && in.eIsProxy()) {
			InternalEObject oldIn = (InternalEObject)in;
			in = (Transformation)eResolveProxy(oldIn);
			if (in != oldIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcoreCSTPackage.MAPPING_CS__IN, oldIn, in));
			}
		}
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation basicGetIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIn(Transformation newIn) {
		Transformation oldIn = in;
		in = newIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.MAPPING_CS__IN, oldIn, in));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainCS getMiddle() {
		return middle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMiddle(DomainCS newMiddle, NotificationChain msgs) {
		DomainCS oldMiddle = middle;
		middle = newMiddle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.MAPPING_CS__MIDDLE, oldMiddle, newMiddle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddle(DomainCS newMiddle) {
		if (newMiddle != middle) {
			NotificationChain msgs = null;
			if (middle != null)
				msgs = ((InternalEObject)middle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSTPackage.MAPPING_CS__MIDDLE, null, msgs);
			if (newMiddle != null)
				msgs = ((InternalEObject)newMiddle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSTPackage.MAPPING_CS__MIDDLE, null, msgs);
			msgs = basicSetMiddle(newMiddle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSTPackage.MAPPING_CS__MIDDLE, newMiddle, newMiddle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<Mapping>(Mapping.class, this, QVTcoreCSTPackage.MAPPING_CS__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return ((InternalEList<?>)getComposedMappings()).basicRemove(otherEnd, msgs);
			case QVTcoreCSTPackage.MAPPING_CS__DOMAINS:
				return ((InternalEList<?>)getDomains()).basicRemove(otherEnd, msgs);
			case QVTcoreCSTPackage.MAPPING_CS__MIDDLE:
				return basicSetMiddle(null, msgs);
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
			case QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return getComposedMappings();
			case QVTcoreCSTPackage.MAPPING_CS__DOMAINS:
				return getDomains();
			case QVTcoreCSTPackage.MAPPING_CS__IN:
				if (resolve) return getIn();
				return basicGetIn();
			case QVTcoreCSTPackage.MAPPING_CS__MIDDLE:
				return getMiddle();
			case QVTcoreCSTPackage.MAPPING_CS__REFINES:
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
			case QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				getComposedMappings().clear();
				getComposedMappings().addAll((Collection<? extends MappingCS>)newValue);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends DomainCS>)newValue);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__IN:
				setIn((Transformation)newValue);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__MIDDLE:
				setMiddle((DomainCS)newValue);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends Mapping>)newValue);
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
			case QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				getComposedMappings().clear();
				return;
			case QVTcoreCSTPackage.MAPPING_CS__DOMAINS:
				getDomains().clear();
				return;
			case QVTcoreCSTPackage.MAPPING_CS__IN:
				setIn((Transformation)null);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__MIDDLE:
				setMiddle((DomainCS)null);
				return;
			case QVTcoreCSTPackage.MAPPING_CS__REFINES:
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
			case QVTcoreCSTPackage.MAPPING_CS__COMPOSED_MAPPINGS:
				return composedMappings != null && !composedMappings.isEmpty();
			case QVTcoreCSTPackage.MAPPING_CS__DOMAINS:
				return domains != null && !domains.isEmpty();
			case QVTcoreCSTPackage.MAPPING_CS__IN:
				return in != null;
			case QVTcoreCSTPackage.MAPPING_CS__MIDDLE:
				return middle != null;
			case QVTcoreCSTPackage.MAPPING_CS__REFINES:
				return refines != null && !refines.isEmpty();
		}
		return super.eIsSet(featureID);
	}


	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTcoreCSVisitor.class).visitMappingCS(this);
	}
} //MappingCSImpl
