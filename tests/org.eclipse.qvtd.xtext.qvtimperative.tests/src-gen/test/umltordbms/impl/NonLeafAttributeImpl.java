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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import test.simpleuml.Attribute;
import test.umltordbms.AttributeToColumn;
import test.umltordbms.FromAttribute;
import test.umltordbms.FromAttributeOwner;
import test.umltordbms.NonLeafAttribute;
import test.umltordbms.UmltordbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Leaf Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link test.umltordbms.impl.NonLeafAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.umltordbms.impl.NonLeafAttributeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link test.umltordbms.impl.NonLeafAttributeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.umltordbms.impl.NonLeafAttributeImpl#getLeafs <em>Leafs</em>}</li>
 *   <li>{@link test.umltordbms.impl.NonLeafAttributeImpl#getAttribute <em>Attribute</em>}</li>
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
	 * The cached value of the '{@link #getLeafs() <em>Leafs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafs()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeToColumn> leafs;

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
		return UmltordbmsPackage.Literals.NON_LEAF_ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromAttributeOwner getOwner() {
		if (eContainerFeatureID() != UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER) return null;
		return (FromAttributeOwner)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(FromAttributeOwner newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(FromAttributeOwner newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeToColumn> getLeafs() {
		if (leafs == null) {
			leafs = new EObjectResolvingEList<AttributeToColumn>(AttributeToColumn.class, this, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS);
		}
		return leafs;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, UmltordbmsPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				return getName();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				return getKind();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return getOwner();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return getLeafs();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind((String)newValue);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				setOwner((FromAttributeOwner)newValue);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				getLeafs().addAll((Collection<? extends AttributeToColumn>)newValue);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)newValue);
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				setOwner((FromAttributeOwner)null);
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				return;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)null);
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
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return getOwner() != null;
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return leafs != null && !leafs.isEmpty();
			case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				return attribute != null;
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
		if (baseClass == FromAttribute.class) {
			switch (derivedFeatureID) {
				case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME: return UmltordbmsPackage.FROM_ATTRIBUTE__NAME;
				case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND: return UmltordbmsPackage.FROM_ATTRIBUTE__KIND;
				case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER: return UmltordbmsPackage.FROM_ATTRIBUTE__OWNER;
				case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS: return UmltordbmsPackage.FROM_ATTRIBUTE__LEAFS;
				case UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE: return UmltordbmsPackage.FROM_ATTRIBUTE__ATTRIBUTE;
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
		if (baseClass == FromAttribute.class) {
			switch (baseFeatureID) {
				case UmltordbmsPackage.FROM_ATTRIBUTE__NAME: return UmltordbmsPackage.NON_LEAF_ATTRIBUTE__NAME;
				case UmltordbmsPackage.FROM_ATTRIBUTE__KIND: return UmltordbmsPackage.NON_LEAF_ATTRIBUTE__KIND;
				case UmltordbmsPackage.FROM_ATTRIBUTE__OWNER: return UmltordbmsPackage.NON_LEAF_ATTRIBUTE__OWNER;
				case UmltordbmsPackage.FROM_ATTRIBUTE__LEAFS: return UmltordbmsPackage.NON_LEAF_ATTRIBUTE__LEAFS;
				case UmltordbmsPackage.FROM_ATTRIBUTE__ATTRIBUTE: return UmltordbmsPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE;
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
