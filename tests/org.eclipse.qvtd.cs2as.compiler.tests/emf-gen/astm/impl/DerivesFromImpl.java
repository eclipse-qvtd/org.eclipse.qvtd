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
package astm.impl;

import astm.AstmPackage;
import astm.DerivesFrom;
import astm.NamedType;
import astm.OtherSyntaxObject;

import astm.util.Visitor;

import java.lang.Boolean;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derives From</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DerivesFromImpl#isIsVirtual <em>Is Virtual</em>}</li>
 *   <li>{@link astm.impl.DerivesFromImpl#getAccessKind <em>Access Kind</em>}</li>
 *   <li>{@link astm.impl.DerivesFromImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DerivesFromImpl extends OtherSyntaxObjectImpl implements DerivesFrom {
	/**
	 * The default value of the '{@link #isIsVirtual() <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VIRTUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsVirtual() <em>Is Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean isVirtual = IS_VIRTUAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessKind() <em>Access Kind</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessKind()
	 * @generated
	 * @ordered
	 */
	protected OtherSyntaxObject accessKind;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected NamedType className;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivesFromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DERIVES_FROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsVirtual() {
		return isVirtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVirtual(boolean newIsVirtual) {
		boolean oldIsVirtual = isVirtual;
		isVirtual = newIsVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DERIVES_FROM__IS_VIRTUAL, oldIsVirtual, isVirtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherSyntaxObject getAccessKind() {
		return accessKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessKind(OtherSyntaxObject newAccessKind, NotificationChain msgs) {
		OtherSyntaxObject oldAccessKind = accessKind;
		accessKind = newAccessKind;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DERIVES_FROM__ACCESS_KIND, oldAccessKind, newAccessKind);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessKind(OtherSyntaxObject newAccessKind) {
		if (newAccessKind != accessKind) {
			NotificationChain msgs = null;
			if (accessKind != null)
				msgs = ((InternalEObject)accessKind).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DERIVES_FROM__ACCESS_KIND, null, msgs);
			if (newAccessKind != null)
				msgs = ((InternalEObject)newAccessKind).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DERIVES_FROM__ACCESS_KIND, null, msgs);
			msgs = basicSetAccessKind(newAccessKind, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DERIVES_FROM__ACCESS_KIND, newAccessKind, newAccessKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedType getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassName(NamedType newClassName, NotificationChain msgs) {
		NamedType oldClassName = className;
		className = newClassName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DERIVES_FROM__CLASS_NAME, oldClassName, newClassName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(NamedType newClassName) {
		if (newClassName != className) {
			NotificationChain msgs = null;
			if (className != null)
				msgs = ((InternalEObject)className).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DERIVES_FROM__CLASS_NAME, null, msgs);
			if (newClassName != null)
				msgs = ((InternalEObject)newClassName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DERIVES_FROM__CLASS_NAME, null, msgs);
			msgs = basicSetClassName(newClassName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DERIVES_FROM__CLASS_NAME, newClassName, newClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.DERIVES_FROM__ACCESS_KIND:
				return basicSetAccessKind(null, msgs);
			case AstmPackage.DERIVES_FROM__CLASS_NAME:
				return basicSetClassName(null, msgs);
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
			case AstmPackage.DERIVES_FROM__IS_VIRTUAL:
				return isIsVirtual();
			case AstmPackage.DERIVES_FROM__ACCESS_KIND:
				return getAccessKind();
			case AstmPackage.DERIVES_FROM__CLASS_NAME:
				return getClassName();
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
			case AstmPackage.DERIVES_FROM__IS_VIRTUAL:
				setIsVirtual((Boolean)newValue);
				return;
			case AstmPackage.DERIVES_FROM__ACCESS_KIND:
				setAccessKind((OtherSyntaxObject)newValue);
				return;
			case AstmPackage.DERIVES_FROM__CLASS_NAME:
				setClassName((NamedType)newValue);
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
			case AstmPackage.DERIVES_FROM__IS_VIRTUAL:
				setIsVirtual(IS_VIRTUAL_EDEFAULT);
				return;
			case AstmPackage.DERIVES_FROM__ACCESS_KIND:
				setAccessKind((OtherSyntaxObject)null);
				return;
			case AstmPackage.DERIVES_FROM__CLASS_NAME:
				setClassName((NamedType)null);
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
			case AstmPackage.DERIVES_FROM__IS_VIRTUAL:
				return isVirtual != IS_VIRTUAL_EDEFAULT;
			case AstmPackage.DERIVES_FROM__ACCESS_KIND:
				return accessKind != null;
			case AstmPackage.DERIVES_FROM__CLASS_NAME:
				return className != null;
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
		result.append(" (isVirtual: ");
		result.append(isVirtual);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDerivesFrom(this);
	}

} //DerivesFromImpl
