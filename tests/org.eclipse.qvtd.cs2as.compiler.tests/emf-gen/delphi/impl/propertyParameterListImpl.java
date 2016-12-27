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
package delphi.impl;

import delphi.DelphiPackage;
import delphi.identList;
import delphi.propertyParameterList;
import delphi.typeId;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>property Parameter List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.propertyParameterListImpl#getIdList <em>Id List</em>}</li>
 *   <li>{@link delphi.impl.propertyParameterListImpl#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class propertyParameterListImpl extends CSTraceImpl implements propertyParameterList {
	/**
	 * The cached value of the '{@link #getIdList() <em>Id List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdList()
	 * @generated
	 * @ordered
	 */
	protected EList<identList> idList;

	/**
	 * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeRef()
	 * @generated
	 * @ordered
	 */
	protected EList<typeId> typeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected propertyParameterListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.PROPERTY_PARAMETER_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<identList> getIdList() {
		if (idList == null) {
			idList = new EObjectContainmentEList<identList>(identList.class, this, DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST);
		}
		return idList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<typeId> getTypeRef() {
		if (typeRef == null) {
			typeRef = new EObjectContainmentEList<typeId>(typeId.class, this, DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF);
		}
		return typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST:
				return ((InternalEList<?>)getIdList()).basicRemove(otherEnd, msgs);
			case DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF:
				return ((InternalEList<?>)getTypeRef()).basicRemove(otherEnd, msgs);
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
			case DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST:
				return getIdList();
			case DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF:
				return getTypeRef();
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
			case DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST:
				getIdList().clear();
				getIdList().addAll((Collection<? extends identList>)newValue);
				return;
			case DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF:
				getTypeRef().clear();
				getTypeRef().addAll((Collection<? extends typeId>)newValue);
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
			case DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST:
				getIdList().clear();
				return;
			case DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF:
				getTypeRef().clear();
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
			case DelphiPackage.PROPERTY_PARAMETER_LIST__ID_LIST:
				return idList != null && !idList.isEmpty();
			case DelphiPackage.PROPERTY_PARAMETER_LIST__TYPE_REF:
				return typeRef != null && !typeRef.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //propertyParameterListImpl
