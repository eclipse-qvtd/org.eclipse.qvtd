/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.umltordbms.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import test.umltordbms.FromAttribute;
import test.umltordbms.FromAttributeOwner;
import test.umltordbms.UmltordbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Attribute Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test.umltordbms.impl.FromAttributeOwnerImpl#getFromAttributes <em>From Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FromAttributeOwnerImpl extends MinimalEObjectImpl.Container implements FromAttributeOwner {
	/**
	 * The cached value of the '{@link #getFromAttributes() <em>From Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<FromAttribute> fromAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FromAttributeOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmltordbmsPackage.Literals.FROM_ATTRIBUTE_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FromAttribute> getFromAttributes() {
		if (fromAttributes == null) {
			fromAttributes = new EObjectContainmentWithInverseEList<FromAttribute>(FromAttribute.class, this, UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, UmltordbmsPackage.FROM_ATTRIBUTE__OWNER);
		}
		return fromAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFromAttributes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return ((InternalEList<?>)getFromAttributes()).basicRemove(otherEnd, msgs);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return getFromAttributes();
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				getFromAttributes().clear();
				getFromAttributes().addAll((Collection<? extends FromAttribute>)newValue);
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				getFromAttributes().clear();
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
			case UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES:
				return fromAttributes != null && !fromAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FromAttributeOwnerImpl
