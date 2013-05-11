/**
 */
package test.middle.HSV2HLS.impl;

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

import test.hls.HLSTree.HLSNode;

import test.hsv.HSVTree.HSVNode;

import test.middle.HSV2HLS.HSV2HLSPackage;
import test.middle.HSV2HLS.HSVNode2HLSNode;

import test.middle.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HSV Node2 HLS Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getHsv <em>Hsv</em>}</li>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getHls <em>Hls</em>}</li>
 *   <li>{@link test.middle.HSV2HLS.impl.HSVNode2HLSNodeImpl#getRgb <em>Rgb</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HSVNode2HLSNodeImpl extends MinimalEObjectImpl.Container implements HSVNode2HLSNode {
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
	protected EList<HSVNode2HLSNode> children;

	/**
	 * The cached value of the '{@link #getHsv() <em>Hsv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsv()
	 * @generated
	 * @ordered
	 */
	protected HSVNode hsv;

	/**
	 * The cached value of the '{@link #getHls() <em>Hls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHls()
	 * @generated
	 * @ordered
	 */
	protected HLSNode hls;

	/**
	 * The default value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected static final RGB RGB_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRgb() <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRgb()
	 * @generated
	 * @ordered
	 */
	protected RGB rgb = RGB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HSVNode2HLSNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HSV2HLSPackage.Literals.HSV_NODE2_HLS_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVNode2HLSNode getParent() {
		if (eContainerFeatureID() != HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT) return null;
		return (HSVNode2HLSNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HSVNode2HLSNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(HSVNode2HLSNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN, HSVNode2HLSNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT, newParent, newParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HLSPackage.HSV_NODE2_HLS_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HSVNode2HLSNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HSVNode2HLSNode>(HSVNode2HLSNode.class, this, HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN, HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVNode getHsv() {
		if (hsv != null && hsv.eIsProxy()) {
			InternalEObject oldHsv = (InternalEObject)hsv;
			hsv = (HSVNode)eResolveProxy(oldHsv);
			if (hsv != oldHsv) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV, oldHsv, hsv));
			}
		}
		return hsv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HSVNode basicGetHsv() {
		return hsv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHsv(HSVNode newHsv) {
		HSVNode oldHsv = hsv;
		hsv = newHsv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV, oldHsv, hsv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLSNode getHls() {
		if (hls != null && hls.eIsProxy()) {
			InternalEObject oldHls = (InternalEObject)hls;
			hls = (HLSNode)eResolveProxy(oldHls);
			if (hls != oldHls) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS, oldHls, hls));
			}
		}
		return hls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HLSNode basicGetHls() {
		return hls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHls(HLSNode newHls) {
		HLSNode oldHls = hls;
		hls = newHls;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS, oldHls, hls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RGB getRgb() {
		return rgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRgb(RGB newRgb) {
		RGB oldRgb = rgb;
		rgb = newRgb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSV2HLSPackage.HSV_NODE2_HLS_NODE__RGB, oldRgb, rgb));
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HSVNode2HLSNode)otherEnd, msgs);
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				return basicSetParent(null, msgs);
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN, HSVNode2HLSNode.class, msgs);
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				return getParent();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__NAME:
				return getName();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
				return getChildren();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV:
				if (resolve) return getHsv();
				return basicGetHsv();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS:
				if (resolve) return getHls();
				return basicGetHls();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__RGB:
				return getRgb();
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				setParent((HSVNode2HLSNode)newValue);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__NAME:
				setName((String)newValue);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HSVNode2HLSNode>)newValue);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV:
				setHsv((HSVNode)newValue);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS:
				setHls((HLSNode)newValue);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__RGB:
				setRgb((RGB)newValue);
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				setParent((HSVNode2HLSNode)null);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
				getChildren().clear();
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV:
				setHsv((HSVNode)null);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS:
				setHls((HLSNode)null);
				return;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__RGB:
				setRgb(RGB_EDEFAULT);
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
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__PARENT:
				return getParent() != null;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HSV:
				return hsv != null;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__HLS:
				return hls != null;
			case HSV2HLSPackage.HSV_NODE2_HLS_NODE__RGB:
				return RGB_EDEFAULT == null ? rgb != null : !RGB_EDEFAULT.equals(rgb);
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
		result.append(", rgb: ");
		result.append(rgb);
		result.append(')');
		return result.toString();
	}

} //HSVNode2HLSNodeImpl
