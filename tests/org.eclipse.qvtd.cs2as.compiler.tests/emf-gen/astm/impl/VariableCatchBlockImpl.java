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
import astm.DataDefinition;
import astm.VariableCatchBlock;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Catch Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.VariableCatchBlockImpl#getExceptionVariable <em>Exception Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableCatchBlockImpl extends CatchBlockImpl implements VariableCatchBlock {
	/**
	 * The cached value of the '{@link #getExceptionVariable() <em>Exception Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionVariable()
	 * @generated
	 * @ordered
	 */
	protected DataDefinition exceptionVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableCatchBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.VARIABLE_CATCH_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDefinition getExceptionVariable() {
		return exceptionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExceptionVariable(DataDefinition newExceptionVariable, NotificationChain msgs) {
		DataDefinition oldExceptionVariable = exceptionVariable;
		exceptionVariable = newExceptionVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE, oldExceptionVariable, newExceptionVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionVariable(DataDefinition newExceptionVariable) {
		if (newExceptionVariable != exceptionVariable) {
			NotificationChain msgs = null;
			if (exceptionVariable != null)
				msgs = ((InternalEObject)exceptionVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE, null, msgs);
			if (newExceptionVariable != null)
				msgs = ((InternalEObject)newExceptionVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE, null, msgs);
			msgs = basicSetExceptionVariable(newExceptionVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE, newExceptionVariable, newExceptionVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE:
				return basicSetExceptionVariable(null, msgs);
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
			case AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE:
				return getExceptionVariable();
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
			case AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE:
				setExceptionVariable((DataDefinition)newValue);
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
			case AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE:
				setExceptionVariable((DataDefinition)null);
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
			case AstmPackage.VARIABLE_CATCH_BLOCK__EXCEPTION_VARIABLE:
				return exceptionVariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitVariableCatchBlock(this);
	}

} //VariableCatchBlockImpl
