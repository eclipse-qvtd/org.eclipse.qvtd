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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.AttributeToColumn;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.FromAttribute;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.FromAttributeOwner;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.NonLeafAttribute;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Leaf Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.NonLeafAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.NonLeafAttributeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.NonLeafAttributeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.NonLeafAttributeImpl#getLeafs <em>Leafs</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.impl.NonLeafAttributeImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonLeafAttributeImpl extends FromAttributeOwnerImpl implements NonLeafAttribute {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected Attribute attribute;

	/**
	 * The cached value of the '{@link #getLeafs() <em>Leafs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafs()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeToColumn> leafs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonLeafAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simpleuml2rdbmsPackage.Literals.NON_LEAF_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (Attribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(Attribute newAttribute) {
		Attribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeToColumn> getLeafs() {
		if (leafs == null) {
			leafs = new EObjectResolvingEList<AttributeToColumn>(AttributeToColumn.class, this, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS);
		}
		return leafs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromAttributeOwner getOwner() {
		if (eContainerFeatureID() != Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER) return null;
		return (FromAttributeOwner)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(FromAttributeOwner newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(FromAttributeOwner newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Simpleuml2rdbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((FromAttributeOwner)otherEnd, msgs);
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, Simpleuml2rdbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				return getName();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				return getKind();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return getLeafs();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return getOwner();
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind((String)newValue);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)newValue);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				getLeafs().addAll((Collection<? extends AttributeToColumn>)newValue);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				setOwner((FromAttributeOwner)newValue);
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)null);
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				return;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				setOwner((FromAttributeOwner)null);
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
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				return attribute != null;
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return leafs != null && !leafs.isEmpty();
			case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return getOwner() != null;
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
		if (baseClass == UmlToRdbmsModelElement.class) {
			switch (derivedFeatureID) {
				case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME: return Simpleuml2rdbmsPackage.UML_TO_RDBMS_MODEL_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == FromAttribute.class) {
			switch (derivedFeatureID) {
				case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND: return Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__KIND;
				case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE: return Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__ATTRIBUTE;
				case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS: return Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__LEAFS;
				case Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER: return Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__OWNER;
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
		if (baseClass == UmlToRdbmsModelElement.class) {
			switch (baseFeatureID) {
				case Simpleuml2rdbmsPackage.UML_TO_RDBMS_MODEL_ELEMENT__NAME: return Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__NAME;
				default: return -1;
			}
		}
		if (baseClass == FromAttribute.class) {
			switch (baseFeatureID) {
				case Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__KIND: return Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__KIND;
				case Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__ATTRIBUTE: return Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE;
				case Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__LEAFS: return Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS;
				case Simpleuml2rdbmsPackage.FROM_ATTRIBUTE__OWNER: return Simpleuml2rdbmsPackage.NON_LEAF_ATTRIBUTE__OWNER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //NonLeafAttributeImpl
