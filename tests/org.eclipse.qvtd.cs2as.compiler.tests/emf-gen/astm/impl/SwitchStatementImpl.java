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
import astm.SwitchCase;
import astm.SwitchStatement;

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
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.SwitchStatementImpl#getSwitchExpression <em>Switch Expression</em>}</li>
 *   <li>{@link astm.impl.SwitchStatementImpl#getCases <em>Cases</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwitchStatementImpl extends StatementImpl implements SwitchStatement {
	/**
	 * The cached value of the '{@link #getSwitchExpression() <em>Switch Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression switchExpression;

	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchCase> cases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.SWITCH_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSwitchExpression() {
		return switchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitchExpression(Expression newSwitchExpression, NotificationChain msgs) {
		Expression oldSwitchExpression = switchExpression;
		switchExpression = newSwitchExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION, oldSwitchExpression, newSwitchExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchExpression(Expression newSwitchExpression) {
		if (newSwitchExpression != switchExpression) {
			NotificationChain msgs = null;
			if (switchExpression != null)
				msgs = ((InternalEObject)switchExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION, null, msgs);
			if (newSwitchExpression != null)
				msgs = ((InternalEObject)newSwitchExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION, null, msgs);
			msgs = basicSetSwitchExpression(newSwitchExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION, newSwitchExpression, newSwitchExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchCase> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<SwitchCase>(SwitchCase.class, this, AstmPackage.SWITCH_STATEMENT__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION:
				return basicSetSwitchExpression(null, msgs);
			case AstmPackage.SWITCH_STATEMENT__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION:
				return getSwitchExpression();
			case AstmPackage.SWITCH_STATEMENT__CASES:
				return getCases();
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
			case AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION:
				setSwitchExpression((Expression)newValue);
				return;
			case AstmPackage.SWITCH_STATEMENT__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends SwitchCase>)newValue);
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
			case AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION:
				setSwitchExpression((Expression)null);
				return;
			case AstmPackage.SWITCH_STATEMENT__CASES:
				getCases().clear();
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
			case AstmPackage.SWITCH_STATEMENT__SWITCH_EXPRESSION:
				return switchExpression != null;
			case AstmPackage.SWITCH_STATEMENT__CASES:
				return cases != null && !cases.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSwitchStatement(this);
	}

} //SwitchStatementImpl
