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
import astm.DefinitionObject;
import astm.DelphiFunctionCallExpression;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delphi Function Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DelphiFunctionCallExpressionImpl#getApplyTo <em>Apply To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DelphiFunctionCallExpressionImpl extends FunctionCallExpressionImpl implements DelphiFunctionCallExpression {
	/**
	 * The cached value of the '{@link #getApplyTo() <em>Apply To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyTo()
	 * @generated
	 * @ordered
	 */
	protected DefinitionObject applyTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelphiFunctionCallExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DELPHI_FUNCTION_CALL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionObject getApplyTo() {
		if (applyTo != null && applyTo.eIsProxy()) {
			InternalEObject oldApplyTo = (InternalEObject)applyTo;
			applyTo = (DefinitionObject)eResolveProxy(oldApplyTo);
			if (applyTo != oldApplyTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO, oldApplyTo, applyTo));
			}
		}
		return applyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionObject basicGetApplyTo() {
		return applyTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplyTo(DefinitionObject newApplyTo) {
		DefinitionObject oldApplyTo = applyTo;
		applyTo = newApplyTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO, oldApplyTo, applyTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO:
				if (resolve) return getApplyTo();
				return basicGetApplyTo();
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
			case AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO:
				setApplyTo((DefinitionObject)newValue);
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
			case AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO:
				setApplyTo((DefinitionObject)null);
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
			case AstmPackage.DELPHI_FUNCTION_CALL_EXPRESSION__APPLY_TO:
				return applyTo != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDelphiFunctionCallExpression(this);
	}

} //DelphiFunctionCallExpressionImpl
