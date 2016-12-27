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
import astm.Scope;

import astm.util.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.ScopeImpl#getDefinitionObject <em>Definition Object</em>}</li>
 *   <li>{@link astm.impl.ScopeImpl#getChildScope <em>Child Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopeImpl extends GASTMSemanticObjectImpl implements Scope {
	/**
	 * The cached value of the '{@link #getDefinitionObject() <em>Definition Object</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionObject()
	 * @generated
	 * @ordered
	 */
	protected EList<DefinitionObject> definitionObject;

	/**
	 * The cached value of the '{@link #getChildScope() <em>Child Scope</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildScope()
	 * @generated
	 * @ordered
	 */
	protected EList<Scope> childScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefinitionObject> getDefinitionObject() {
		if (definitionObject == null) {
			definitionObject = new EObjectContainmentEList<DefinitionObject>(DefinitionObject.class, this, AstmPackage.SCOPE__DEFINITION_OBJECT);
		}
		return definitionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scope> getChildScope() {
		if (childScope == null) {
			childScope = new EObjectContainmentEList<Scope>(Scope.class, this, AstmPackage.SCOPE__CHILD_SCOPE);
		}
		return childScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.SCOPE__DEFINITION_OBJECT:
				return ((InternalEList<?>)getDefinitionObject()).basicRemove(otherEnd, msgs);
			case AstmPackage.SCOPE__CHILD_SCOPE:
				return ((InternalEList<?>)getChildScope()).basicRemove(otherEnd, msgs);
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
			case AstmPackage.SCOPE__DEFINITION_OBJECT:
				return getDefinitionObject();
			case AstmPackage.SCOPE__CHILD_SCOPE:
				return getChildScope();
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
			case AstmPackage.SCOPE__DEFINITION_OBJECT:
				getDefinitionObject().clear();
				getDefinitionObject().addAll((Collection<? extends DefinitionObject>)newValue);
				return;
			case AstmPackage.SCOPE__CHILD_SCOPE:
				getChildScope().clear();
				getChildScope().addAll((Collection<? extends Scope>)newValue);
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
			case AstmPackage.SCOPE__DEFINITION_OBJECT:
				getDefinitionObject().clear();
				return;
			case AstmPackage.SCOPE__CHILD_SCOPE:
				getChildScope().clear();
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
			case AstmPackage.SCOPE__DEFINITION_OBJECT:
				return definitionObject != null && !definitionObject.isEmpty();
			case AstmPackage.SCOPE__CHILD_SCOPE:
				return childScope != null && !childScope.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitScope(this);
	}

} //ScopeImpl
