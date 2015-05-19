/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package simpleuml2rdbms.uml2rdbms.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import simpleuml2rdbms.uml.Attribute;

import simpleuml2rdbms.uml2rdbms.AttributeToColumn;
import simpleuml2rdbms.uml2rdbms.FromAttribute;
import simpleuml2rdbms.uml2rdbms.FromAttributeOwner;
import simpleuml2rdbms.uml2rdbms.NonLeafAttribute;
import simpleuml2rdbms.uml2rdbms.UML2RDBMSPackage;
import simpleuml2rdbms.uml2rdbms.UmlToRdbmsModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Leaf Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl#getLeafs <em>Leafs</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml2rdbms.impl.NonLeafAttributeImpl#getOwner <em>Owner</em>}</li>
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
		return UML2RDBMSPackage.Literals.NON_LEAF_ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND, oldKind, kind));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeToColumn> getLeafs() {
		if (leafs == null) {
			leafs = new EObjectResolvingEList<AttributeToColumn>(AttributeToColumn.class, this, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS);
		}
		return leafs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromAttributeOwner getOwner() {
		if (eContainerFeatureID() != UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER) return null;
		return (FromAttributeOwner)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(FromAttributeOwner newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(FromAttributeOwner newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, UML2RDBMSPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, UML2RDBMSPackage.FROM_ATTRIBUTE_OWNER__FROM_ATTRIBUTES, FromAttributeOwner.class, msgs);
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME:
				return getName();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND:
				return getKind();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return getLeafs();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind((String)newValue);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)newValue);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				getLeafs().addAll((Collection<? extends AttributeToColumn>)newValue);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				setAttribute((Attribute)null);
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				getLeafs().clear();
				return;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE:
				return attribute != null;
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS:
				return leafs != null && !leafs.isEmpty();
			case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER:
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
				case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME: return UML2RDBMSPackage.UML_TO_RDBMS_MODEL_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == FromAttribute.class) {
			switch (derivedFeatureID) {
				case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND: return UML2RDBMSPackage.FROM_ATTRIBUTE__KIND;
				case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE: return UML2RDBMSPackage.FROM_ATTRIBUTE__ATTRIBUTE;
				case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS: return UML2RDBMSPackage.FROM_ATTRIBUTE__LEAFS;
				case UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER: return UML2RDBMSPackage.FROM_ATTRIBUTE__OWNER;
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
				case UML2RDBMSPackage.UML_TO_RDBMS_MODEL_ELEMENT__NAME: return UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__NAME;
				default: return -1;
			}
		}
		if (baseClass == FromAttribute.class) {
			switch (baseFeatureID) {
				case UML2RDBMSPackage.FROM_ATTRIBUTE__KIND: return UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__KIND;
				case UML2RDBMSPackage.FROM_ATTRIBUTE__ATTRIBUTE: return UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__ATTRIBUTE;
				case UML2RDBMSPackage.FROM_ATTRIBUTE__LEAFS: return UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__LEAFS;
				case UML2RDBMSPackage.FROM_ATTRIBUTE__OWNER: return UML2RDBMSPackage.NON_LEAF_ATTRIBUTE__OWNER;
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
