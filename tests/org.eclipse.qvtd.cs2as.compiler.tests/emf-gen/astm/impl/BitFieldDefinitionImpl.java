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
import astm.BitFieldDefinition;
import astm.Expression;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bit Field Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.BitFieldDefinitionImpl#getBitFieldSize <em>Bit Field Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BitFieldDefinitionImpl extends DataDefinitionImpl implements BitFieldDefinition {
	/**
	 * The cached value of the '{@link #getBitFieldSize() <em>Bit Field Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitFieldSize()
	 * @generated
	 * @ordered
	 */
	protected Expression bitFieldSize;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BitFieldDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.BIT_FIELD_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getBitFieldSize() {
		return bitFieldSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBitFieldSize(Expression newBitFieldSize, NotificationChain msgs) {
		Expression oldBitFieldSize = bitFieldSize;
		bitFieldSize = newBitFieldSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE, oldBitFieldSize, newBitFieldSize);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitFieldSize(Expression newBitFieldSize) {
		if (newBitFieldSize != bitFieldSize) {
			NotificationChain msgs = null;
			if (bitFieldSize != null)
				msgs = ((InternalEObject)bitFieldSize).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE, null, msgs);
			if (newBitFieldSize != null)
				msgs = ((InternalEObject)newBitFieldSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE, null, msgs);
			msgs = basicSetBitFieldSize(newBitFieldSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE, newBitFieldSize, newBitFieldSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE:
				return basicSetBitFieldSize(null, msgs);
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
			case AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE:
				return getBitFieldSize();
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
			case AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE:
				setBitFieldSize((Expression)newValue);
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
			case AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE:
				setBitFieldSize((Expression)null);
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
			case AstmPackage.BIT_FIELD_DEFINITION__BIT_FIELD_SIZE:
				return bitFieldSize != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBitFieldDefinition(this);
	}

} //BitFieldDefinitionImpl
