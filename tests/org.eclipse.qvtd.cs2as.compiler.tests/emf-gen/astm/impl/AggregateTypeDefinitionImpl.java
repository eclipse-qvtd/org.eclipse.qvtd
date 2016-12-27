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

import astm.AggregateType;
import astm.AggregateTypeDefinition;
import astm.AstmPackage;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.AggregateTypeDefinitionImpl#getAggregateType <em>Aggregate Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregateTypeDefinitionImpl extends TypeDefinitionImpl implements AggregateTypeDefinition {
	/**
	 * The cached value of the '{@link #getAggregateType() <em>Aggregate Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregateType()
	 * @generated
	 * @ordered
	 */
	protected AggregateType aggregateType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregateTypeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.AGGREGATE_TYPE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateType getAggregateType() {
		return aggregateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregateType(AggregateType newAggregateType, NotificationChain msgs) {
		AggregateType oldAggregateType = aggregateType;
		aggregateType = newAggregateType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE, oldAggregateType, newAggregateType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregateType(AggregateType newAggregateType) {
		if (newAggregateType != aggregateType) {
			NotificationChain msgs = null;
			if (aggregateType != null)
				msgs = ((InternalEObject)aggregateType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE, null, msgs);
			if (newAggregateType != null)
				msgs = ((InternalEObject)newAggregateType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE, null, msgs);
			msgs = basicSetAggregateType(newAggregateType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE, newAggregateType, newAggregateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE:
				return basicSetAggregateType(null, msgs);
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
			case AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE:
				return getAggregateType();
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
			case AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE:
				setAggregateType((AggregateType)newValue);
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
			case AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE:
				setAggregateType((AggregateType)null);
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
			case AstmPackage.AGGREGATE_TYPE_DEFINITION__AGGREGATE_TYPE:
				return aggregateType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitAggregateTypeDefinition(this);
	}

} //AggregateTypeDefinitionImpl
