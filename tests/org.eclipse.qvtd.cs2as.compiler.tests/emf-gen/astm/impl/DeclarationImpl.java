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
import astm.Declaration;
import astm.Definition;
import astm.Name;
import astm.TypeReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DeclarationImpl#getDefRef <em>Def Ref</em>}</li>
 *   <li>{@link astm.impl.DeclarationImpl#getIdentifierName <em>Identifier Name</em>}</li>
 *   <li>{@link astm.impl.DeclarationImpl#getDeclarationType <em>Declaration Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DeclarationImpl extends DeclarationOrDefinitionImpl implements Declaration {
	/**
	 * The cached value of the '{@link #getDefRef() <em>Def Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefRef()
	 * @generated
	 * @ordered
	 */
	protected Definition defRef;

	/**
	 * The cached value of the '{@link #getIdentifierName() <em>Identifier Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierName()
	 * @generated
	 * @ordered
	 */
	protected Name identifierName;

	/**
	 * The cached value of the '{@link #getDeclarationType() <em>Declaration Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarationType()
	 * @generated
	 * @ordered
	 */
	protected TypeReference declarationType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definition getDefRef() {
		return defRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefRef(Definition newDefRef, NotificationChain msgs) {
		Definition oldDefRef = defRef;
		defRef = newDefRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__DEF_REF, oldDefRef, newDefRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefRef(Definition newDefRef) {
		if (newDefRef != defRef) {
			NotificationChain msgs = null;
			if (defRef != null)
				msgs = ((InternalEObject)defRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__DEF_REF, null, msgs);
			if (newDefRef != null)
				msgs = ((InternalEObject)newDefRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__DEF_REF, null, msgs);
			msgs = basicSetDefRef(newDefRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__DEF_REF, newDefRef, newDefRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getIdentifierName() {
		return identifierName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifierName(Name newIdentifierName, NotificationChain msgs) {
		Name oldIdentifierName = identifierName;
		identifierName = newIdentifierName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__IDENTIFIER_NAME, oldIdentifierName, newIdentifierName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierName(Name newIdentifierName) {
		if (newIdentifierName != identifierName) {
			NotificationChain msgs = null;
			if (identifierName != null)
				msgs = ((InternalEObject)identifierName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__IDENTIFIER_NAME, null, msgs);
			if (newIdentifierName != null)
				msgs = ((InternalEObject)newIdentifierName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__IDENTIFIER_NAME, null, msgs);
			msgs = basicSetIdentifierName(newIdentifierName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__IDENTIFIER_NAME, newIdentifierName, newIdentifierName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeReference getDeclarationType() {
		return declarationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclarationType(TypeReference newDeclarationType, NotificationChain msgs) {
		TypeReference oldDeclarationType = declarationType;
		declarationType = newDeclarationType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__DECLARATION_TYPE, oldDeclarationType, newDeclarationType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarationType(TypeReference newDeclarationType) {
		if (newDeclarationType != declarationType) {
			NotificationChain msgs = null;
			if (declarationType != null)
				msgs = ((InternalEObject)declarationType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__DECLARATION_TYPE, null, msgs);
			if (newDeclarationType != null)
				msgs = ((InternalEObject)newDeclarationType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION__DECLARATION_TYPE, null, msgs);
			msgs = basicSetDeclarationType(newDeclarationType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION__DECLARATION_TYPE, newDeclarationType, newDeclarationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.DECLARATION__DEF_REF:
				return basicSetDefRef(null, msgs);
			case AstmPackage.DECLARATION__IDENTIFIER_NAME:
				return basicSetIdentifierName(null, msgs);
			case AstmPackage.DECLARATION__DECLARATION_TYPE:
				return basicSetDeclarationType(null, msgs);
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
			case AstmPackage.DECLARATION__DEF_REF:
				return getDefRef();
			case AstmPackage.DECLARATION__IDENTIFIER_NAME:
				return getIdentifierName();
			case AstmPackage.DECLARATION__DECLARATION_TYPE:
				return getDeclarationType();
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
			case AstmPackage.DECLARATION__DEF_REF:
				setDefRef((Definition)newValue);
				return;
			case AstmPackage.DECLARATION__IDENTIFIER_NAME:
				setIdentifierName((Name)newValue);
				return;
			case AstmPackage.DECLARATION__DECLARATION_TYPE:
				setDeclarationType((TypeReference)newValue);
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
			case AstmPackage.DECLARATION__DEF_REF:
				setDefRef((Definition)null);
				return;
			case AstmPackage.DECLARATION__IDENTIFIER_NAME:
				setIdentifierName((Name)null);
				return;
			case AstmPackage.DECLARATION__DECLARATION_TYPE:
				setDeclarationType((TypeReference)null);
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
			case AstmPackage.DECLARATION__DEF_REF:
				return defRef != null;
			case AstmPackage.DECLARATION__IDENTIFIER_NAME:
				return identifierName != null;
			case AstmPackage.DECLARATION__DECLARATION_TYPE:
				return declarationType != null;
		}
		return super.eIsSet(featureID);
	}


} //DeclarationImpl
