/**
 */
package build.upper2lower.simplegraph2graph.impl;

import build.upper2lower.simplegraph.Node;

import build.upper2lower.simplegraph2graph.Node2Node;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node2 Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Node2NodeImpl#getNode1 <em>Node1</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Node2NodeImpl#getNode2 <em>Node2</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Node2NodeImpl#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Node2NodeImpl extends Element2ElementImpl implements Node2Node {
	/**
	 * The cached value of the '{@link #getNode1() <em>Node1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode1()
	 * @generated
	 * @ordered
	 */
	protected Node node1;

	/**
	 * The cached value of the '{@link #getNode2() <em>Node2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode2()
	 * @generated
	 * @ordered
	 */
	protected Node node2;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Node2NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simplegraph2graphPackage.Literals.NODE2_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode1() {
		if (node1 != null && node1.eIsProxy()) {
			InternalEObject oldNode1 = (InternalEObject)node1;
			node1 = (Node)eResolveProxy(oldNode1);
			if (node1 != oldNode1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.NODE2_NODE__NODE1, oldNode1, node1));
			}
		}
		return node1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode1() {
		return node1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode1(Node newNode1) {
		Node oldNode1 = node1;
		node1 = newNode1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.NODE2_NODE__NODE1, oldNode1, node1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode2() {
		if (node2 != null && node2.eIsProxy()) {
			InternalEObject oldNode2 = (InternalEObject)node2;
			node2 = (Node)eResolveProxy(oldNode2);
			if (node2 != oldNode2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.NODE2_NODE__NODE2, oldNode2, node2));
			}
		}
		return node2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode2() {
		return node2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode2(Node newNode2) {
		Node oldNode2 = node2;
		node2 = newNode2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.NODE2_NODE__NODE2, oldNode2, node2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.NODE2_NODE__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Simplegraph2graphPackage.NODE2_NODE__NODE1:
				if (resolve) return getNode1();
				return basicGetNode1();
			case Simplegraph2graphPackage.NODE2_NODE__NODE2:
				if (resolve) return getNode2();
				return basicGetNode2();
			case Simplegraph2graphPackage.NODE2_NODE__LABEL:
				return getLabel();
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
			case Simplegraph2graphPackage.NODE2_NODE__NODE1:
				setNode1((Node)newValue);
				return;
			case Simplegraph2graphPackage.NODE2_NODE__NODE2:
				setNode2((Node)newValue);
				return;
			case Simplegraph2graphPackage.NODE2_NODE__LABEL:
				setLabel((String)newValue);
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
			case Simplegraph2graphPackage.NODE2_NODE__NODE1:
				setNode1((Node)null);
				return;
			case Simplegraph2graphPackage.NODE2_NODE__NODE2:
				setNode2((Node)null);
				return;
			case Simplegraph2graphPackage.NODE2_NODE__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case Simplegraph2graphPackage.NODE2_NODE__NODE1:
				return node1 != null;
			case Simplegraph2graphPackage.NODE2_NODE__NODE2:
				return node2 != null;
			case Simplegraph2graphPackage.NODE2_NODE__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //Node2NodeImpl
