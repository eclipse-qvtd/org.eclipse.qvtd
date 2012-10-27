/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.internal.impl.ParameterImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl#getRepresentedParameter <em>Represented Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl#isImplicit <em>Implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionParameterImpl extends ParameterImpl implements FunctionParameter {
	/**
	 * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression initExpression;

	/**
	 * The cached value of the '{@link #getRepresentedParameter() <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter representedParameter;

	/**
	 * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLICIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected boolean implicit = IMPLICIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.FUNCTION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getInitExpression() {
		return initExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExpression(OCLExpression newInitExpression, NotificationChain msgs) {
		OCLExpression oldInitExpression = initExpression;
		initExpression = newInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, oldInitExpression, newInitExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExpression(OCLExpression newInitExpression) {
		if (newInitExpression != initExpression) {
			NotificationChain msgs = null;
			if (initExpression != null)
				msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, null, msgs);
			if (newInitExpression != null)
				msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, null, msgs);
			msgs = basicSetInitExpression(newInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION, newInitExpression, newInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getRepresentedParameter() {
		if (representedParameter != null && ((EObject)representedParameter).eIsProxy()) {
			InternalEObject oldRepresentedParameter = (InternalEObject)representedParameter;
			representedParameter = (Parameter)eResolveProxy(oldRepresentedParameter);
			if (representedParameter != oldRepresentedParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
			}
		}
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetRepresentedParameter() {
		return representedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedParameter(Parameter newRepresentedParameter) {
		Parameter oldRepresentedParameter = representedParameter;
		representedParameter = newRepresentedParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER, oldRepresentedParameter, representedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplicit() {
		return implicit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicit(boolean newImplicit) {
		boolean oldImplicit = implicit;
		implicit = newImplicit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT, oldImplicit, implicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return basicSetInitExpression(null, msgs);
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
			case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return getInitExpression();
			case QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER:
				if (resolve) return getRepresentedParameter();
				return basicGetRepresentedParameter();
			case QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT:
				return isImplicit();
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
			case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				setInitExpression((OCLExpression)newValue);
				return;
			case QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER:
				setRepresentedParameter((Parameter)newValue);
				return;
			case QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT:
				setImplicit((Boolean)newValue);
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
			case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				setInitExpression((OCLExpression)null);
				return;
			case QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER:
				setRepresentedParameter((Parameter)null);
				return;
			case QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
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
			case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION:
				return initExpression != null;
			case QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER:
				return representedParameter != null;
			case QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT:
				return implicit != IMPLICIT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Variable.class) {
			switch (derivedFeatureID) {
				case QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION: return PivotPackage.VARIABLE__INIT_EXPRESSION;
				case QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER: return PivotPackage.VARIABLE__REPRESENTED_PARAMETER;
				case QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT: return PivotPackage.VARIABLE__IMPLICIT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Variable.class) {
			switch (baseFeatureID) {
				case PivotPackage.VARIABLE__INIT_EXPRESSION: return QVTbasePackage.FUNCTION_PARAMETER__INIT_EXPRESSION;
				case PivotPackage.VARIABLE__REPRESENTED_PARAMETER: return QVTbasePackage.FUNCTION_PARAMETER__REPRESENTED_PARAMETER;
				case PivotPackage.VARIABLE__IMPLICIT: return QVTbasePackage.FUNCTION_PARAMETER__IMPLICIT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	public OCLExpression createInitExpression(EClass eClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTbaseVisitor<R>)visitor).visitFunctionParameter(this);
	}
} //FunctionParameterImpl
