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
import astm.Expression;
import astm.IdentifierReference;
import astm.QualifiedIdentifierReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Identifier Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.QualifiedIdentifierReferenceImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link astm.impl.QualifiedIdentifierReferenceImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class QualifiedIdentifierReferenceImpl extends NameReferenceImpl implements QualifiedIdentifierReference {
	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected Expression qualifiers;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected IdentifierReference member;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedIdentifierReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.QUALIFIED_IDENTIFIER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getQualifiers() {
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualifiers(Expression newQualifiers, NotificationChain msgs) {
		Expression oldQualifiers = qualifiers;
		qualifiers = newQualifiers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS, oldQualifiers, newQualifiers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiers(Expression newQualifiers) {
		if (newQualifiers != qualifiers) {
			NotificationChain msgs = null;
			if (qualifiers != null)
				msgs = ((InternalEObject)qualifiers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS, null, msgs);
			if (newQualifiers != null)
				msgs = ((InternalEObject)newQualifiers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS, null, msgs);
			msgs = basicSetQualifiers(newQualifiers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS, newQualifiers, newQualifiers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierReference getMember() {
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMember(IdentifierReference newMember, NotificationChain msgs) {
		IdentifierReference oldMember = member;
		member = newMember;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, oldMember, newMember);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMember(IdentifierReference newMember) {
		if (newMember != member) {
			NotificationChain msgs = null;
			if (member != null)
				msgs = ((InternalEObject)member).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, null, msgs);
			if (newMember != null)
				msgs = ((InternalEObject)newMember).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, null, msgs);
			msgs = basicSetMember(newMember, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, newMember, newMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS:
				return basicSetQualifiers(null, msgs);
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				return basicSetMember(null, msgs);
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
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS:
				return getQualifiers();
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				return getMember();
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
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS:
				setQualifiers((Expression)newValue);
				return;
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				setMember((IdentifierReference)newValue);
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
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS:
				setQualifiers((Expression)null);
				return;
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				setMember((IdentifierReference)null);
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
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__QUALIFIERS:
				return qualifiers != null;
			case AstmPackage.QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				return member != null;
		}
		return super.eIsSet(featureID);
	}


} //QualifiedIdentifierReferenceImpl
