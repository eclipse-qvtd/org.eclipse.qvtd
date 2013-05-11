/**
 */
package test.hsv.HSVTree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import test.hsv.HSV;

import test.hsv.HSVTree.HSVNode;
import test.hsv.HSVTree.HSVTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HSV Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.hsv.HSVTree.impl.HSVNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link test.hsv.HSVTree.impl.HSVNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.hsv.HSVTree.impl.HSVNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link test.hsv.HSVTree.impl.HSVNodeImpl#getHsv <em>Hsv</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HSVNodeImpl extends MinimalEObjectImpl.Container implements HSVNode {
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
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<HSVNode> children;

	/**
	 * The default value of the '{@link #getHsv() <em>Hsv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsv()
	 * @generated
	 * @ordered
	 */
	protected static final HSV HSV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHsv() <em>Hsv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsv()
	 * @generated
	 * @ordered
	 */
	protected HSV hsv = HSV_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HSVNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HSVTreePackage.Literals.HSV_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVNode getParent() {
		if (eContainerFeatureID() != HSVTreePackage.HSV_NODE__PARENT) return null;
		return (HSVNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HSVNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, HSVTreePackage.HSV_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(HSVNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != HSVTreePackage.HSV_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, HSVTreePackage.HSV_NODE__CHILDREN, HSVNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSVTreePackage.HSV_NODE__PARENT, newParent, newParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HSVTreePackage.HSV_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HSVNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HSVNode>(HSVNode.class, this, HSVTreePackage.HSV_NODE__CHILDREN, HSVTreePackage.HSV_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSV getHsv() {
		return hsv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHsv(HSV newHsv) {
		HSV oldHsv = hsv;
		hsv = newHsv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSVTreePackage.HSV_NODE__HSV, oldHsv, hsv));
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
			case HSVTreePackage.HSV_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HSVNode)otherEnd, msgs);
			case HSVTreePackage.HSV_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
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
			case HSVTreePackage.HSV_NODE__PARENT:
				return basicSetParent(null, msgs);
			case HSVTreePackage.HSV_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case HSVTreePackage.HSV_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, HSVTreePackage.HSV_NODE__CHILDREN, HSVNode.class, msgs);
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
			case HSVTreePackage.HSV_NODE__PARENT:
				return getParent();
			case HSVTreePackage.HSV_NODE__NAME:
				return getName();
			case HSVTreePackage.HSV_NODE__CHILDREN:
				return getChildren();
			case HSVTreePackage.HSV_NODE__HSV:
				return getHsv();
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
			case HSVTreePackage.HSV_NODE__PARENT:
				setParent((HSVNode)newValue);
				return;
			case HSVTreePackage.HSV_NODE__NAME:
				setName((String)newValue);
				return;
			case HSVTreePackage.HSV_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HSVNode>)newValue);
				return;
			case HSVTreePackage.HSV_NODE__HSV:
				setHsv((HSV)newValue);
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
			case HSVTreePackage.HSV_NODE__PARENT:
				setParent((HSVNode)null);
				return;
			case HSVTreePackage.HSV_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HSVTreePackage.HSV_NODE__CHILDREN:
				getChildren().clear();
				return;
			case HSVTreePackage.HSV_NODE__HSV:
				setHsv(HSV_EDEFAULT);
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
			case HSVTreePackage.HSV_NODE__PARENT:
				return getParent() != null;
			case HSVTreePackage.HSV_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HSVTreePackage.HSV_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case HSVTreePackage.HSV_NODE__HSV:
				return HSV_EDEFAULT == null ? hsv != null : !HSV_EDEFAULT.equals(hsv);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", hsv: ");
		result.append(hsv);
		result.append(')');
		return result.toString();
	}

} //HSVNodeImpl
