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
import astm.NamedType;
import astm.NamedTypeDefinition;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.NamedTypeDefinitionImpl#getDefinitionType <em>Definition Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedTypeDefinitionImpl extends TypeDefinitionImpl implements NamedTypeDefinition {
	/**
	 * The cached value of the '{@link #getDefinitionType() <em>Definition Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected NamedType definitionType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedTypeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.NAMED_TYPE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedType getDefinitionType() {
		return definitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinitionType(NamedType newDefinitionType, NotificationChain msgs) {
		NamedType oldDefinitionType = definitionType;
		definitionType = newDefinitionType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE, oldDefinitionType, newDefinitionType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionType(NamedType newDefinitionType) {
		if (newDefinitionType != definitionType) {
			NotificationChain msgs = null;
			if (definitionType != null)
				msgs = ((InternalEObject)definitionType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE, null, msgs);
			if (newDefinitionType != null)
				msgs = ((InternalEObject)newDefinitionType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE, null, msgs);
			msgs = basicSetDefinitionType(newDefinitionType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE, newDefinitionType, newDefinitionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE:
				return basicSetDefinitionType(null, msgs);
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
			case AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE:
				return getDefinitionType();
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
			case AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE:
				setDefinitionType((NamedType)newValue);
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
			case AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE:
				setDefinitionType((NamedType)null);
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
			case AstmPackage.NAMED_TYPE_DEFINITION__DEFINITION_TYPE:
				return definitionType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNamedTypeDefinition(this);
	}

} //NamedTypeDefinitionImpl
