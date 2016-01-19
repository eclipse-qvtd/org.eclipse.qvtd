/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Association;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.impl.AssociationImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.impl.AssociationImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationImpl extends PackageElementImpl implements Association {
	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class destination;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleumlPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.ASSOCIATION__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class newDestination, NotificationChain msgs) {
		org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, SimpleumlPackage.CLASS__REVERSE, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, SimpleumlPackage.CLASS__REVERSE, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class newSource, NotificationChain msgs) {
		org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, SimpleumlPackage.CLASS__FORWARD, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, SimpleumlPackage.CLASS__FORWARD, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, SimpleumlPackage.CLASS__REVERSE, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
				return basicSetDestination((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)otherEnd, msgs);
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, SimpleumlPackage.CLASS__FORWARD, org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class.class, msgs);
				return basicSetSource((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				return basicSetDestination(null, msgs);
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				return basicSetSource(null, msgs);
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
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				setDestination((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)newValue);
				return;
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				setSource((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)newValue);
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
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				setDestination((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)null);
				return;
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				setSource((org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.Class)null);
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
			case SimpleumlPackage.ASSOCIATION__DESTINATION:
				return destination != null;
			case SimpleumlPackage.ASSOCIATION__SOURCE:
				return source != null;
		}
		return super.eIsSet(featureID);
	}


} //AssociationImpl
