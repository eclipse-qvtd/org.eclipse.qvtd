/**
 */
package build.upper2lower.simplegraph2graph.impl;

import build.upper2lower.simplegraph.Edge;

import build.upper2lower.simplegraph2graph.Edge2Edge;
import build.upper2lower.simplegraph2graph.Node2Node;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge2 Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl#getEdge1 <em>Edge1</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl#getEdge2 <em>Edge2</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Edge2EdgeImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Edge2EdgeImpl extends Element2ElementImpl implements Edge2Edge {
	/**
	 * The cached value of the '{@link #getEdge1() <em>Edge1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge1()
	 * @generated
	 * @ordered
	 */
	protected Edge edge1;

	/**
	 * The cached value of the '{@link #getEdge2() <em>Edge2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge2()
	 * @generated
	 * @ordered
	 */
	protected Edge edge2;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node2Node target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node2Node source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Edge2EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simplegraph2graphPackage.Literals.EDGE2_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge1() {
		if (edge1 != null && edge1.eIsProxy()) {
			InternalEObject oldEdge1 = (InternalEObject)edge1;
			edge1 = (Edge)eResolveProxy(oldEdge1);
			if (edge1 != oldEdge1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.EDGE2_EDGE__EDGE1, oldEdge1, edge1));
			}
		}
		return edge1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge basicGetEdge1() {
		return edge1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge1(Edge newEdge1) {
		Edge oldEdge1 = edge1;
		edge1 = newEdge1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.EDGE2_EDGE__EDGE1, oldEdge1, edge1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge2() {
		if (edge2 != null && edge2.eIsProxy()) {
			InternalEObject oldEdge2 = (InternalEObject)edge2;
			edge2 = (Edge)eResolveProxy(oldEdge2);
			if (edge2 != oldEdge2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.EDGE2_EDGE__EDGE2, oldEdge2, edge2));
			}
		}
		return edge2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge basicGetEdge2() {
		return edge2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge2(Edge newEdge2) {
		Edge oldEdge2 = edge2;
		edge2 = newEdge2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.EDGE2_EDGE__EDGE2, oldEdge2, edge2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node2Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.EDGE2_EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node2Node newTarget) {
		Node2Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.EDGE2_EDGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node2Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.EDGE2_EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node2Node newSource) {
		Node2Node oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.EDGE2_EDGE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE1:
				if (resolve) return getEdge1();
				return basicGetEdge1();
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE2:
				if (resolve) return getEdge2();
				return basicGetEdge2();
			case Simplegraph2graphPackage.EDGE2_EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case Simplegraph2graphPackage.EDGE2_EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE1:
				setEdge1((Edge)newValue);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE2:
				setEdge2((Edge)newValue);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__TARGET:
				setTarget((Node2Node)newValue);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__SOURCE:
				setSource((Node2Node)newValue);
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
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE1:
				setEdge1((Edge)null);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE2:
				setEdge2((Edge)null);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__TARGET:
				setTarget((Node2Node)null);
				return;
			case Simplegraph2graphPackage.EDGE2_EDGE__SOURCE:
				setSource((Node2Node)null);
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
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE1:
				return edge1 != null;
			case Simplegraph2graphPackage.EDGE2_EDGE__EDGE2:
				return edge2 != null;
			case Simplegraph2graphPackage.EDGE2_EDGE__TARGET:
				return target != null;
			case Simplegraph2graphPackage.EDGE2_EDGE__SOURCE:
				return source != null;
		}
		return super.eIsSet(featureID);
	}

} //Edge2EdgeImpl
