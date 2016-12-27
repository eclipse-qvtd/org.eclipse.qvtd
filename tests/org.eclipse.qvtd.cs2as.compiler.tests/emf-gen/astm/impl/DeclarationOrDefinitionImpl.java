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
import astm.DeclarationOrDefinition;
import astm.OtherSyntaxObject;

import java.lang.Boolean;
import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Or Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DeclarationOrDefinitionImpl#isIsRegister <em>Is Register</em>}</li>
 *   <li>{@link astm.impl.DeclarationOrDefinitionImpl#getLinkageSpecifier <em>Linkage Specifier</em>}</li>
 *   <li>{@link astm.impl.DeclarationOrDefinitionImpl#getStorageSpecifiers <em>Storage Specifiers</em>}</li>
 *   <li>{@link astm.impl.DeclarationOrDefinitionImpl#getAccessKind <em>Access Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DeclarationOrDefinitionImpl extends DefinitionObjectImpl implements DeclarationOrDefinition {
	/**
	 * The default value of the '{@link #isIsRegister() <em>Is Register</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRegister()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REGISTER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRegister() <em>Is Register</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRegister()
	 * @generated
	 * @ordered
	 */
	protected boolean isRegister = IS_REGISTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkageSpecifier() <em>Linkage Specifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkageSpecifier()
	 * @generated
	 * @ordered
	 */
	protected static final String LINKAGE_SPECIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkageSpecifier() <em>Linkage Specifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkageSpecifier()
	 * @generated
	 * @ordered
	 */
	protected String linkageSpecifier = LINKAGE_SPECIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStorageSpecifiers() <em>Storage Specifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageSpecifiers()
	 * @generated
	 * @ordered
	 */
	protected OtherSyntaxObject storageSpecifiers;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationOrDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DECLARATION_OR_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsRegister() {
		return isRegister;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRegister(boolean newIsRegister) {
		boolean oldIsRegister = isRegister;
		isRegister = newIsRegister;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__IS_REGISTER, oldIsRegister, isRegister));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkageSpecifier() {
		return linkageSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkageSpecifier(String newLinkageSpecifier) {
		String oldLinkageSpecifier = linkageSpecifier;
		linkageSpecifier = newLinkageSpecifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__LINKAGE_SPECIFIER, oldLinkageSpecifier, linkageSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherSyntaxObject getStorageSpecifiers() {
		return storageSpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStorageSpecifiers(OtherSyntaxObject newStorageSpecifiers, NotificationChain msgs) {
		OtherSyntaxObject oldStorageSpecifiers = storageSpecifiers;
		storageSpecifiers = newStorageSpecifiers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS, oldStorageSpecifiers, newStorageSpecifiers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageSpecifiers(OtherSyntaxObject newStorageSpecifiers) {
		if (newStorageSpecifiers != storageSpecifiers) {
			NotificationChain msgs = null;
			if (storageSpecifiers != null)
				msgs = ((InternalEObject)storageSpecifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS, null, msgs);
			if (newStorageSpecifiers != null)
				msgs = ((InternalEObject)newStorageSpecifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS, null, msgs);
			msgs = basicSetStorageSpecifiers(newStorageSpecifiers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS, newStorageSpecifiers, newStorageSpecifiers));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND, oldAccessKind, newAccessKind);
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
				msgs = ((InternalEObject)accessKind).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND, null, msgs);
			if (newAccessKind != null)
				msgs = ((InternalEObject)newAccessKind).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND, null, msgs);
			msgs = basicSetAccessKind(newAccessKind, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND, newAccessKind, newAccessKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS:
				return basicSetStorageSpecifiers(null, msgs);
			case AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND:
				return basicSetAccessKind(null, msgs);
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
			case AstmPackage.DECLARATION_OR_DEFINITION__IS_REGISTER:
				return isIsRegister();
			case AstmPackage.DECLARATION_OR_DEFINITION__LINKAGE_SPECIFIER:
				return getLinkageSpecifier();
			case AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS:
				return getStorageSpecifiers();
			case AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND:
				return getAccessKind();
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
			case AstmPackage.DECLARATION_OR_DEFINITION__IS_REGISTER:
				setIsRegister((Boolean)newValue);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__LINKAGE_SPECIFIER:
				setLinkageSpecifier((String)newValue);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS:
				setStorageSpecifiers((OtherSyntaxObject)newValue);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND:
				setAccessKind((OtherSyntaxObject)newValue);
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
			case AstmPackage.DECLARATION_OR_DEFINITION__IS_REGISTER:
				setIsRegister(IS_REGISTER_EDEFAULT);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__LINKAGE_SPECIFIER:
				setLinkageSpecifier(LINKAGE_SPECIFIER_EDEFAULT);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS:
				setStorageSpecifiers((OtherSyntaxObject)null);
				return;
			case AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND:
				setAccessKind((OtherSyntaxObject)null);
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
			case AstmPackage.DECLARATION_OR_DEFINITION__IS_REGISTER:
				return isRegister != IS_REGISTER_EDEFAULT;
			case AstmPackage.DECLARATION_OR_DEFINITION__LINKAGE_SPECIFIER:
				return LINKAGE_SPECIFIER_EDEFAULT == null ? linkageSpecifier != null : !LINKAGE_SPECIFIER_EDEFAULT.equals(linkageSpecifier);
			case AstmPackage.DECLARATION_OR_DEFINITION__STORAGE_SPECIFIERS:
				return storageSpecifiers != null;
			case AstmPackage.DECLARATION_OR_DEFINITION__ACCESS_KIND:
				return accessKind != null;
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
		result.append(" (isRegister: ");
		result.append(isRegister);
		result.append(", linkageSpecifier: ");
		result.append(linkageSpecifier);
		result.append(')');
		return result.toString();
	}


} //DeclarationOrDefinitionImpl
