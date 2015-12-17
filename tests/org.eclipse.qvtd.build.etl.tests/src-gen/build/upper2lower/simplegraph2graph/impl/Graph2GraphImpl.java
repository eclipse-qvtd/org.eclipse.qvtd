/**
 */
package build.upper2lower.simplegraph2graph.impl;

import build.upper2lower.simplegraph.Graph;

import build.upper2lower.simplegraph2graph.Element2Element;
import build.upper2lower.simplegraph2graph.Graph2Graph;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph2 Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getGraph1 <em>Graph1</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getGraph2 <em>Graph2</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link build.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Graph2GraphImpl extends MinimalEObjectImpl.Container implements Graph2Graph {
	/**
	 * The cached value of the '{@link #getGraph1() <em>Graph1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph1()
	 * @generated
	 * @ordered
	 */
	protected Graph graph1;

	/**
	 * The cached value of the '{@link #getGraph2() <em>Graph2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph2()
	 * @generated
	 * @ordered
	 */
	protected Graph graph2;

	/**
	 * The cached value of the '{@link #getElement2Element() <em>Element2 Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement2Element()
	 * @generated
	 * @ordered
	 */
	protected EList<Element2Element> element2Element;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph2GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Simplegraph2graphPackage.Literals.GRAPH2_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph1() {
		if (graph1 != null && graph1.eIsProxy()) {
			InternalEObject oldGraph1 = (InternalEObject)graph1;
			graph1 = (Graph)eResolveProxy(oldGraph1);
			if (graph1 != oldGraph1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1, oldGraph1, graph1));
			}
		}
		return graph1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetGraph1() {
		return graph1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph1(Graph newGraph1) {
		Graph oldGraph1 = graph1;
		graph1 = newGraph1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1, oldGraph1, graph1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph2() {
		if (graph2 != null && graph2.eIsProxy()) {
			InternalEObject oldGraph2 = (InternalEObject)graph2;
			graph2 = (Graph)eResolveProxy(oldGraph2);
			if (graph2 != oldGraph2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2, oldGraph2, graph2));
			}
		}
		return graph2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetGraph2() {
		return graph2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph2(Graph newGraph2) {
		Graph oldGraph2 = graph2;
		graph2 = newGraph2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2, oldGraph2, graph2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element2Element> getElement2Element() {
		if (element2Element == null) {
			element2Element = new EObjectContainmentWithInverseEList<Element2Element>(Element2Element.class, this, Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT, Simplegraph2graphPackage.ELEMENT2_ELEMENT__OWNER);
		}
		return element2Element;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Simplegraph2graphPackage.GRAPH2_GRAPH__NAME, oldName, name));
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElement2Element()).basicAdd(otherEnd, msgs);
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				return ((InternalEList<?>)getElement2Element()).basicRemove(otherEnd, msgs);
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1:
				if (resolve) return getGraph1();
				return basicGetGraph1();
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2:
				if (resolve) return getGraph2();
				return basicGetGraph2();
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				return getElement2Element();
			case Simplegraph2graphPackage.GRAPH2_GRAPH__NAME:
				return getName();
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1:
				setGraph1((Graph)newValue);
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2:
				setGraph2((Graph)newValue);
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				getElement2Element().clear();
				getElement2Element().addAll((Collection<? extends Element2Element>)newValue);
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__NAME:
				setName((String)newValue);
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1:
				setGraph1((Graph)null);
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2:
				setGraph2((Graph)null);
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				getElement2Element().clear();
				return;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__NAME:
				setName(NAME_EDEFAULT);
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
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH1:
				return graph1 != null;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__GRAPH2:
				return graph2 != null;
			case Simplegraph2graphPackage.GRAPH2_GRAPH__ELEMENT2_ELEMENT:
				return element2Element != null && !element2Element.isEmpty();
			case Simplegraph2graphPackage.GRAPH2_GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //Graph2GraphImpl
