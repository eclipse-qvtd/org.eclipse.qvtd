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
import astm.NewExpression;
import astm.OtherSyntaxObject;
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
 * An implementation of the model object '<em><b>New Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.NewExpressionImpl#getNewType <em>New Type</em>}</li>
 *   <li>{@link astm.impl.NewExpressionImpl#getActualParams <em>Actual Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NewExpressionImpl extends ExpressionImpl implements NewExpression {
	/**
	 * The cached value of the '{@link #getNewType() <em>New Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewType()
	 * @generated
	 * @ordered
	 */
	protected TypeReference newType;

	/**
	 * The cached value of the '{@link #getActualParams() <em>Actual Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualParams()
	 * @generated
	 * @ordered
	 */
	protected EList<OtherSyntaxObject> actualParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.NEW_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeReference getNewType() {
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewType(TypeReference newNewType, NotificationChain msgs) {
		TypeReference oldNewType = newType;
		newType = newNewType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.NEW_EXPRESSION__NEW_TYPE, oldNewType, newNewType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewType(TypeReference newNewType) {
		if (newNewType != newType) {
			NotificationChain msgs = null;
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.NEW_EXPRESSION__NEW_TYPE, null, msgs);
			if (newNewType != null)
				msgs = ((InternalEObject)newNewType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.NEW_EXPRESSION__NEW_TYPE, null, msgs);
			msgs = basicSetNewType(newNewType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.NEW_EXPRESSION__NEW_TYPE, newNewType, newNewType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OtherSyntaxObject> getActualParams() {
		if (actualParams == null) {
			actualParams = new EObjectContainmentEList<OtherSyntaxObject>(OtherSyntaxObject.class, this, AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS);
		}
		return actualParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.NEW_EXPRESSION__NEW_TYPE:
				return basicSetNewType(null, msgs);
			case AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS:
				return ((InternalEList<?>)getActualParams()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.NEW_EXPRESSION__NEW_TYPE:
				return getNewType();
			case AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS:
				return getActualParams();
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
			case AstmPackage.NEW_EXPRESSION__NEW_TYPE:
				setNewType((TypeReference)newValue);
				return;
			case AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS:
				getActualParams().clear();
				getActualParams().addAll((Collection<? extends OtherSyntaxObject>)newValue);
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
			case AstmPackage.NEW_EXPRESSION__NEW_TYPE:
				setNewType((TypeReference)null);
				return;
			case AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS:
				getActualParams().clear();
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
			case AstmPackage.NEW_EXPRESSION__NEW_TYPE:
				return newType != null;
			case AstmPackage.NEW_EXPRESSION__ACTUAL_PARAMS:
				return actualParams != null && !actualParams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitNewExpression(this);
	}

} //NewExpressionImpl
