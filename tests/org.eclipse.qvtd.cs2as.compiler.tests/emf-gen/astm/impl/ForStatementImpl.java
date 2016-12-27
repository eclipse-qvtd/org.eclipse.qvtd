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
import astm.ForStatement;

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
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.ForStatementImpl#getInitBody <em>Init Body</em>}</li>
 *   <li>{@link astm.impl.ForStatementImpl#getIterationBody <em>Iteration Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ForStatementImpl extends LoopStatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getInitBody() <em>Init Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitBody()
	 * @generated
	 * @ordered
	 */
	protected Expression initBody;

	/**
	 * The cached value of the '{@link #getIterationBody() <em>Iteration Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationBody()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> iterationBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitBody() {
		return initBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitBody(Expression newInitBody, NotificationChain msgs) {
		Expression oldInitBody = initBody;
		initBody = newInitBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.FOR_STATEMENT__INIT_BODY, oldInitBody, newInitBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitBody(Expression newInitBody) {
		if (newInitBody != initBody) {
			NotificationChain msgs = null;
			if (initBody != null)
				msgs = ((InternalEObject)initBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.FOR_STATEMENT__INIT_BODY, null, msgs);
			if (newInitBody != null)
				msgs = ((InternalEObject)newInitBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.FOR_STATEMENT__INIT_BODY, null, msgs);
			msgs = basicSetInitBody(newInitBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.FOR_STATEMENT__INIT_BODY, newInitBody, newInitBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getIterationBody() {
		if (iterationBody == null) {
			iterationBody = new EObjectContainmentEList<Expression>(Expression.class, this, AstmPackage.FOR_STATEMENT__ITERATION_BODY);
		}
		return iterationBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.FOR_STATEMENT__INIT_BODY:
				return basicSetInitBody(null, msgs);
			case AstmPackage.FOR_STATEMENT__ITERATION_BODY:
				return ((InternalEList<?>)getIterationBody()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.FOR_STATEMENT__INIT_BODY:
				return getInitBody();
			case AstmPackage.FOR_STATEMENT__ITERATION_BODY:
				return getIterationBody();
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
			case AstmPackage.FOR_STATEMENT__INIT_BODY:
				setInitBody((Expression)newValue);
				return;
			case AstmPackage.FOR_STATEMENT__ITERATION_BODY:
				getIterationBody().clear();
				getIterationBody().addAll((Collection<? extends Expression>)newValue);
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
			case AstmPackage.FOR_STATEMENT__INIT_BODY:
				setInitBody((Expression)null);
				return;
			case AstmPackage.FOR_STATEMENT__ITERATION_BODY:
				getIterationBody().clear();
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
			case AstmPackage.FOR_STATEMENT__INIT_BODY:
				return initBody != null;
			case AstmPackage.FOR_STATEMENT__ITERATION_BODY:
				return iterationBody != null && !iterationBody.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //ForStatementImpl
