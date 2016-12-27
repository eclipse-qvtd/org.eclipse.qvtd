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

import astm.AggregateScope;
import astm.AggregateType;
import astm.AstmPackage;
import astm.DefinitionObject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregate Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.AggregateTypeImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link astm.impl.AggregateTypeImpl#getOpensScope <em>Opens Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AggregateTypeImpl extends DataTypeImpl implements AggregateType {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<DefinitionObject> members;

	/**
	 * The cached value of the '{@link #getOpensScope() <em>Opens Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpensScope()
	 * @generated
	 * @ordered
	 */
	protected AggregateScope opensScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregateTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.AGGREGATE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefinitionObject> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<DefinitionObject>(DefinitionObject.class, this, AstmPackage.AGGREGATE_TYPE__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateScope getOpensScope() {
		return opensScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpensScope(AggregateScope newOpensScope, NotificationChain msgs) {
		AggregateScope oldOpensScope = opensScope;
		opensScope = newOpensScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE, oldOpensScope, newOpensScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpensScope(AggregateScope newOpensScope) {
		if (newOpensScope != opensScope) {
			NotificationChain msgs = null;
			if (opensScope != null)
				msgs = ((InternalEObject)opensScope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE, null, msgs);
			if (newOpensScope != null)
				msgs = ((InternalEObject)newOpensScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE, null, msgs);
			msgs = basicSetOpensScope(newOpensScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE, newOpensScope, newOpensScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.AGGREGATE_TYPE__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
			case AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE:
				return basicSetOpensScope(null, msgs);
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
			case AstmPackage.AGGREGATE_TYPE__MEMBERS:
				return getMembers();
			case AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE:
				return getOpensScope();
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
			case AstmPackage.AGGREGATE_TYPE__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends DefinitionObject>)newValue);
				return;
			case AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE:
				setOpensScope((AggregateScope)newValue);
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
			case AstmPackage.AGGREGATE_TYPE__MEMBERS:
				getMembers().clear();
				return;
			case AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE:
				setOpensScope((AggregateScope)null);
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
			case AstmPackage.AGGREGATE_TYPE__MEMBERS:
				return members != null && !members.isEmpty();
			case AstmPackage.AGGREGATE_TYPE__OPENS_SCOPE:
				return opensScope != null;
		}
		return super.eIsSet(featureID);
	}


} //AggregateTypeImpl
