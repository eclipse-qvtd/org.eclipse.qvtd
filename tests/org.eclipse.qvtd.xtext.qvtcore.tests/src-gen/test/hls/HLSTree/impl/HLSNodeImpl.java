/**
 */
package test.hls.HLSTree.impl;

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

import test.hls.HLS;

import test.hls.HLSTree.HLSNode;
import test.hls.HLSTree.HLSTreeFactory;
import test.hls.HLSTree.HLSTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HLS Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.hls.HLSTree.impl.HLSNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link test.hls.HLSTree.impl.HLSNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.hls.HLSTree.impl.HLSNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link test.hls.HLSTree.impl.HLSNodeImpl#getHls <em>Hls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HLSNodeImpl extends MinimalEObjectImpl.Container implements HLSNode {
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
	protected EList<HLSNode> children;

	/**
	 * The default value of the '{@link #getHls() <em>Hls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHls()
	 * @generated
	 * @ordered
	 */
	protected static final HLS HLS_EDEFAULT = (HLS)HLSTreeFactory.eINSTANCE.createFromString(HLSTreePackage.eINSTANCE.getHLS(), "HLS");

	/**
	 * The cached value of the '{@link #getHls() <em>Hls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHls()
	 * @generated
	 * @ordered
	 */
	protected HLS hls = HLS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HLSNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLSTreePackage.Literals.HLS_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLSNode getParent() {
		if (eContainerFeatureID() != HLSTreePackage.HLS_NODE__PARENT) return null;
		return (HLSNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HLSNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, HLSTreePackage.HLS_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(HLSNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != HLSTreePackage.HLS_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, HLSTreePackage.HLS_NODE__CHILDREN, HLSNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLSTreePackage.HLS_NODE__PARENT, newParent, newParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLSTreePackage.HLS_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HLSNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HLSNode>(HLSNode.class, this, HLSTreePackage.HLS_NODE__CHILDREN, HLSTreePackage.HLS_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLS getHls() {
		return hls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHls(HLS newHls) {
		HLS oldHls = hls;
		hls = newHls;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLSTreePackage.HLS_NODE__HLS, oldHls, hls));
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
			case HLSTreePackage.HLS_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HLSNode)otherEnd, msgs);
			case HLSTreePackage.HLS_NODE__CHILDREN:
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
			case HLSTreePackage.HLS_NODE__PARENT:
				return basicSetParent(null, msgs);
			case HLSTreePackage.HLS_NODE__CHILDREN:
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
			case HLSTreePackage.HLS_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, HLSTreePackage.HLS_NODE__CHILDREN, HLSNode.class, msgs);
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
			case HLSTreePackage.HLS_NODE__PARENT:
				return getParent();
			case HLSTreePackage.HLS_NODE__NAME:
				return getName();
			case HLSTreePackage.HLS_NODE__CHILDREN:
				return getChildren();
			case HLSTreePackage.HLS_NODE__HLS:
				return getHls();
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
			case HLSTreePackage.HLS_NODE__PARENT:
				setParent((HLSNode)newValue);
				return;
			case HLSTreePackage.HLS_NODE__NAME:
				setName((String)newValue);
				return;
			case HLSTreePackage.HLS_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HLSNode>)newValue);
				return;
			case HLSTreePackage.HLS_NODE__HLS:
				setHls((HLS)newValue);
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
			case HLSTreePackage.HLS_NODE__PARENT:
				setParent((HLSNode)null);
				return;
			case HLSTreePackage.HLS_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HLSTreePackage.HLS_NODE__CHILDREN:
				getChildren().clear();
				return;
			case HLSTreePackage.HLS_NODE__HLS:
				setHls(HLS_EDEFAULT);
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
			case HLSTreePackage.HLS_NODE__PARENT:
				return getParent() != null;
			case HLSTreePackage.HLS_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HLSTreePackage.HLS_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case HLSTreePackage.HLS_NODE__HLS:
				return HLS_EDEFAULT == null ? hls != null : !HLS_EDEFAULT.equals(hls);
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
		result.append(", hls: ");
		result.append(hls);
		result.append(')');
		return result.toString();
	}

} //HLSNodeImpl
