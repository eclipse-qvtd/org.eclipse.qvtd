/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl#getOwnedSelfVar <em>Owned Self Var</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl#getOwnedBody <em>Owned Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionInOCLImpl extends OpaqueExpressionImpl implements ExpressionInOCL {
	/**
	 * The number of structural features of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_IN_OCL_FEATURE_COUNT = OpaqueExpressionImpl.OPAQUE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_IN_OCL_OPERATION_COUNT = OpaqueExpressionImpl.OPAQUE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getOwnedSelfVar() <em>Owned Self Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSelfVar()
	 * @generated
	 * @ordered
	 */
	protected Variable ownedSelfVar;

	/**
	 * The cached value of the '{@link #getOwnedBody() <em>Owned Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOCLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getOwnedSelfVar() {
		return ownedSelfVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSelfVar(Variable newOwnedSelfVar, NotificationChain msgs) {
		Variable oldOwnedSelfVar = ownedSelfVar;
		ownedSelfVar = newOwnedSelfVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 2, oldOwnedSelfVar, newOwnedSelfVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedSelfVar(Variable newOwnedSelfVar) {
		if (newOwnedSelfVar != ownedSelfVar) {
			NotificationChain msgs = null;
			if (ownedSelfVar != null)
				msgs = ((InternalEObject)ownedSelfVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			if (newOwnedSelfVar != null)
				msgs = ((InternalEObject)newOwnedSelfVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			msgs = basicSetOwnedSelfVar(newOwnedSelfVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newOwnedSelfVar, newOwnedSelfVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedBody() {
		return ownedBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBody(OCLExpression newOwnedBody, NotificationChain msgs) {
		OCLExpression oldOwnedBody = ownedBody;
		ownedBody = newOwnedBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 3, oldOwnedBody, newOwnedBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedBody(OCLExpression newOwnedBody) {
		if (newOwnedBody != ownedBody) {
			NotificationChain msgs = null;
			if (ownedBody != null)
				msgs = ((InternalEObject)ownedBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			if (newOwnedBody != null)
				msgs = ((InternalEObject)newOwnedBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			msgs = basicSetOwnedBody(newOwnedBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, newOwnedBody, newOwnedBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 2:
				return basicSetOwnedSelfVar(null, msgs);
			case 3:
				return basicSetOwnedBody(null, msgs);
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
			case 2:
				return getOwnedSelfVar();
			case 3:
				return getOwnedBody();
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
			case 2:
				setOwnedSelfVar((Variable)newValue);
				return;
			case 3:
				setOwnedBody((OCLExpression)newValue);
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
			case 2:
				setOwnedSelfVar((Variable)null);
				return;
			case 3:
				setOwnedBody((OCLExpression)null);
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
			case 2:
				return ownedSelfVar != null;
			case 3:
				return ownedBody != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitExpressionInOCL(this);
	}

} //ExpressionInOCLImpl
