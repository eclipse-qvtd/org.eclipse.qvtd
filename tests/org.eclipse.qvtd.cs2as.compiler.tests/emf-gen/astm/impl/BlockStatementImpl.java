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
import astm.BlockScope;
import astm.BlockStatement;
import astm.Statement;

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
 * An implementation of the model object '<em><b>Block Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.BlockStatementImpl#getSubStatements <em>Sub Statements</em>}</li>
 *   <li>{@link astm.impl.BlockStatementImpl#getOpensScope <em>Opens Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockStatementImpl extends StatementImpl implements BlockStatement {
	/**
	 * The cached value of the '{@link #getSubStatements() <em>Sub Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> subStatements;

	/**
	 * The cached value of the '{@link #getOpensScope() <em>Opens Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpensScope()
	 * @generated
	 * @ordered
	 */
	protected BlockScope opensScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.BLOCK_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getSubStatements() {
		if (subStatements == null) {
			subStatements = new EObjectContainmentEList<Statement>(Statement.class, this, AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS);
		}
		return subStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockScope getOpensScope() {
		return opensScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpensScope(BlockScope newOpensScope, NotificationChain msgs) {
		BlockScope oldOpensScope = opensScope;
		opensScope = newOpensScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE, oldOpensScope, newOpensScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpensScope(BlockScope newOpensScope) {
		if (newOpensScope != opensScope) {
			NotificationChain msgs = null;
			if (opensScope != null)
				msgs = ((InternalEObject)opensScope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE, null, msgs);
			if (newOpensScope != null)
				msgs = ((InternalEObject)newOpensScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE, null, msgs);
			msgs = basicSetOpensScope(newOpensScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE, newOpensScope, newOpensScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS:
				return ((InternalEList<?>)getSubStatements()).basicRemove(otherEnd, msgs);
			case AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE:
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
			case AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS:
				return getSubStatements();
			case AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE:
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
			case AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS:
				getSubStatements().clear();
				getSubStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE:
				setOpensScope((BlockScope)newValue);
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
			case AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS:
				getSubStatements().clear();
				return;
			case AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE:
				setOpensScope((BlockScope)null);
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
			case AstmPackage.BLOCK_STATEMENT__SUB_STATEMENTS:
				return subStatements != null && !subStatements.isEmpty();
			case AstmPackage.BLOCK_STATEMENT__OPENS_SCOPE:
				return opensScope != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitBlockStatement(this);
	}

} //BlockStatementImpl
