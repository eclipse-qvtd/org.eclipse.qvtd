/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.PrimitiveDataType;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.PackageToSchema;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.PrimitiveToName;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive To Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.PrimitiveToNameImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.PrimitiveToNameImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.PrimitiveToNameImpl#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimitiveToNameImpl extends UmlToRdbmsModelElementImpl implements PrimitiveToName {
	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveDataType primitive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveToNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simpleuml2rdbmsPackage.Literals.PRIMITIVE_TO_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageToSchema getOwner() {
		if (eContainerFeatureID() != Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER) return null;
		return (PackageToSchema)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(PackageToSchema newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(PackageToSchema newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Simpleuml2rdbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES, PackageToSchema.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveDataType getPrimitive() {
		if (primitive != null && primitive.eIsProxy()) {
			InternalEObject oldPrimitive = (InternalEObject)primitive;
			primitive = (PrimitiveDataType)eResolveProxy(oldPrimitive);
			if (primitive != oldPrimitive) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE, oldPrimitive, primitive));
			}
		}
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveDataType basicGetPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive(PrimitiveDataType newPrimitive) {
		PrimitiveDataType oldPrimitive = primitive;
		primitive = newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((PackageToSchema)otherEnd, msgs);
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
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				return eInternalContainer().eInverseRemove(this, Simpleuml2rdbmsPackage.PACKAGE_TO_SCHEMA__PRIMITIVES_TO_NAMES, PackageToSchema.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__TYPE_NAME:
				return getTypeName();
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				return getOwner();
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE:
				if (resolve) return getPrimitive();
				return basicGetPrimitive();
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
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__TYPE_NAME:
				setTypeName((String)newValue);
				return;
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				setOwner((PackageToSchema)newValue);
				return;
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE:
				setPrimitive((PrimitiveDataType)newValue);
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
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
				return;
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				setOwner((PackageToSchema)null);
				return;
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE:
				setPrimitive((PrimitiveDataType)null);
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
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__OWNER:
				return getOwner() != null;
			case Simpleuml2rdbmsPackage.PRIMITIVE_TO_NAME__PRIMITIVE:
				return primitive != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (typeName: ");
		result.append(typeName);
		result.append(')');
		return result.toString();
	}

} //PrimitiveToNameImpl
