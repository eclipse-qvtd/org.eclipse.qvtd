/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.implementationSection;
import delphi.initSection;
import delphi.interfaceSection;
import delphi.unit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.unitImpl#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.impl.unitImpl#getInterfaceSect <em>Interface Sect</em>}</li>
 *   <li>{@link delphi.impl.unitImpl#getImplementationSect <em>Implementation Sect</em>}</li>
 *   <li>{@link delphi.impl.unitImpl#getInitSect <em>Init Sect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class unitImpl extends fileImpl implements unit {
	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected String port = PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterfaceSect() <em>Interface Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceSect()
	 * @generated
	 * @ordered
	 */
	protected interfaceSection interfaceSect;

	/**
	 * The cached value of the '{@link #getImplementationSect() <em>Implementation Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationSect()
	 * @generated
	 * @ordered
	 */
	protected implementationSection implementationSect;

	/**
	 * The cached value of the '{@link #getInitSect() <em>Init Sect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitSect()
	 * @generated
	 * @ordered
	 */
	protected initSection initSect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected unitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interfaceSection getInterfaceSect() {
		return interfaceSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceSect(interfaceSection newInterfaceSect, NotificationChain msgs) {
		interfaceSection oldInterfaceSect = interfaceSect;
		interfaceSect = newInterfaceSect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__INTERFACE_SECT, oldInterfaceSect, newInterfaceSect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceSect(interfaceSection newInterfaceSect) {
		if (newInterfaceSect != interfaceSect) {
			NotificationChain msgs = null;
			if (interfaceSect != null)
				msgs = ((InternalEObject)interfaceSect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__INTERFACE_SECT, null, msgs);
			if (newInterfaceSect != null)
				msgs = ((InternalEObject)newInterfaceSect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__INTERFACE_SECT, null, msgs);
			msgs = basicSetInterfaceSect(newInterfaceSect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__INTERFACE_SECT, newInterfaceSect, newInterfaceSect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public implementationSection getImplementationSect() {
		return implementationSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementationSect(implementationSection newImplementationSect, NotificationChain msgs) {
		implementationSection oldImplementationSect = implementationSect;
		implementationSect = newImplementationSect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__IMPLEMENTATION_SECT, oldImplementationSect, newImplementationSect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationSect(implementationSection newImplementationSect) {
		if (newImplementationSect != implementationSect) {
			NotificationChain msgs = null;
			if (implementationSect != null)
				msgs = ((InternalEObject)implementationSect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__IMPLEMENTATION_SECT, null, msgs);
			if (newImplementationSect != null)
				msgs = ((InternalEObject)newImplementationSect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__IMPLEMENTATION_SECT, null, msgs);
			msgs = basicSetImplementationSect(newImplementationSect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__IMPLEMENTATION_SECT, newImplementationSect, newImplementationSect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public initSection getInitSect() {
		return initSect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitSect(initSection newInitSect, NotificationChain msgs) {
		initSection oldInitSect = initSect;
		initSect = newInitSect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__INIT_SECT, oldInitSect, newInitSect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitSect(initSection newInitSect) {
		if (newInitSect != initSect) {
			NotificationChain msgs = null;
			if (initSect != null)
				msgs = ((InternalEObject)initSect).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__INIT_SECT, null, msgs);
			if (newInitSect != null)
				msgs = ((InternalEObject)newInitSect).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.UNIT__INIT_SECT, null, msgs);
			msgs = basicSetInitSect(newInitSect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.UNIT__INIT_SECT, newInitSect, newInitSect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.UNIT__INTERFACE_SECT:
				return basicSetInterfaceSect(null, msgs);
			case DelphiPackage.UNIT__IMPLEMENTATION_SECT:
				return basicSetImplementationSect(null, msgs);
			case DelphiPackage.UNIT__INIT_SECT:
				return basicSetInitSect(null, msgs);
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
			case DelphiPackage.UNIT__PORT:
				return getPort();
			case DelphiPackage.UNIT__INTERFACE_SECT:
				return getInterfaceSect();
			case DelphiPackage.UNIT__IMPLEMENTATION_SECT:
				return getImplementationSect();
			case DelphiPackage.UNIT__INIT_SECT:
				return getInitSect();
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
			case DelphiPackage.UNIT__PORT:
				setPort((String)newValue);
				return;
			case DelphiPackage.UNIT__INTERFACE_SECT:
				setInterfaceSect((interfaceSection)newValue);
				return;
			case DelphiPackage.UNIT__IMPLEMENTATION_SECT:
				setImplementationSect((implementationSection)newValue);
				return;
			case DelphiPackage.UNIT__INIT_SECT:
				setInitSect((initSection)newValue);
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
			case DelphiPackage.UNIT__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case DelphiPackage.UNIT__INTERFACE_SECT:
				setInterfaceSect((interfaceSection)null);
				return;
			case DelphiPackage.UNIT__IMPLEMENTATION_SECT:
				setImplementationSect((implementationSection)null);
				return;
			case DelphiPackage.UNIT__INIT_SECT:
				setInitSect((initSection)null);
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
			case DelphiPackage.UNIT__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case DelphiPackage.UNIT__INTERFACE_SECT:
				return interfaceSect != null;
			case DelphiPackage.UNIT__IMPLEMENTATION_SECT:
				return implementationSect != null;
			case DelphiPackage.UNIT__INIT_SECT:
				return initSect != null;
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
		result.append(" (port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}


} //unitImpl
