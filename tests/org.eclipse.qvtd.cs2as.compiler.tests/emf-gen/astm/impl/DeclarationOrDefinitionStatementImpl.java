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
import astm.DeclarationOrDefinitionStatement;
import astm.DefinitionObject;

import astm.util.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Or Definition Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.DeclarationOrDefinitionStatementImpl#getDeclOrDefn <em>Decl Or Defn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclarationOrDefinitionStatementImpl extends StatementImpl implements DeclarationOrDefinitionStatement {
	/**
	 * The cached value of the '{@link #getDeclOrDefn() <em>Decl Or Defn</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclOrDefn()
	 * @generated
	 * @ordered
	 */
	protected DefinitionObject declOrDefn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationOrDefinitionStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.DECLARATION_OR_DEFINITION_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionObject getDeclOrDefn() {
		return declOrDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclOrDefn(DefinitionObject newDeclOrDefn, NotificationChain msgs) {
		DefinitionObject oldDeclOrDefn = declOrDefn;
		declOrDefn = newDeclOrDefn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN, oldDeclOrDefn, newDeclOrDefn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclOrDefn(DefinitionObject newDeclOrDefn) {
		if (newDeclOrDefn != declOrDefn) {
			NotificationChain msgs = null;
			if (declOrDefn != null)
				msgs = ((InternalEObject)declOrDefn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN, null, msgs);
			if (newDeclOrDefn != null)
				msgs = ((InternalEObject)newDeclOrDefn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN, null, msgs);
			msgs = basicSetDeclOrDefn(newDeclOrDefn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN, newDeclOrDefn, newDeclOrDefn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN:
				return basicSetDeclOrDefn(null, msgs);
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
			case AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN:
				return getDeclOrDefn();
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
			case AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN:
				setDeclOrDefn((DefinitionObject)newValue);
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
			case AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN:
				setDeclOrDefn((DefinitionObject)null);
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
			case AstmPackage.DECLARATION_OR_DEFINITION_STATEMENT__DECL_OR_DEFN:
				return declOrDefn != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitDeclarationOrDefinitionStatement(this);
	}

} //DeclarationOrDefinitionStatementImpl
