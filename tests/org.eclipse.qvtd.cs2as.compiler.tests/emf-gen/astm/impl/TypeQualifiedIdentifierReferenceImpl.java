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
import astm.IdentifierReference;
import astm.TypeQualifiedIdentifierReference;
import astm.TypeReference;

import astm.util.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Qualified Identifier Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.TypeQualifiedIdentifierReferenceImpl#getAggregateType <em>Aggregate Type</em>}</li>
 *   <li>{@link astm.impl.TypeQualifiedIdentifierReferenceImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeQualifiedIdentifierReferenceImpl extends NameReferenceImpl implements TypeQualifiedIdentifierReference {
	/**
	 * The cached value of the '{@link #getAggregateType() <em>Aggregate Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregateType()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeReference> aggregateType;

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
	protected TypeQualifiedIdentifierReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.TYPE_QUALIFIED_IDENTIFIER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeReference> getAggregateType() {
		if (aggregateType == null) {
			aggregateType = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE);
		}
		return aggregateType;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, oldMember, newMember);
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
				msgs = ((InternalEObject)member).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, null, msgs);
			if (newMember != null)
				msgs = ((InternalEObject)newMember).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, null, msgs);
			msgs = basicSetMember(newMember, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER, newMember, newMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE:
				return ((InternalEList<?>)getAggregateType()).basicRemove(otherEnd, msgs);
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
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
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE:
				return getAggregateType();
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				return getMember();
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
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE:
				getAggregateType().clear();
				getAggregateType().addAll((Collection<? extends TypeReference>)newValue);
				return;
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
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
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE:
				getAggregateType().clear();
				return;
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
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
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__AGGREGATE_TYPE:
				return aggregateType != null && !aggregateType.isEmpty();
			case AstmPackage.TYPE_QUALIFIED_IDENTIFIER_REFERENCE__MEMBER:
				return member != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitTypeQualifiedIdentifierReference(this);
	}

} //TypeQualifiedIdentifierReferenceImpl
