/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl;

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

import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.Graph;

import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Element2Element;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Graph2Graph;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph2 Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getGraph1 <em>Graph1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getGraph2 <em>Graph2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.impl.Graph2GraphImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Graph2GraphImpl extends MinimalEObjectImpl.Container implements Graph2Graph {
	/**
	 * The number of structural features of the '<em>Graph2 Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GRAPH2_GRAPH_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Graph2 Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GRAPH2_GRAPH_OPERATION_COUNT = 0;

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
	@Override
	public Graph getGraph1() {
		if (graph1 != null && graph1.eIsProxy()) {
			InternalEObject oldGraph1 = (InternalEObject)graph1;
			graph1 = (Graph)eResolveProxy(oldGraph1);
			if (graph1 != oldGraph1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 0, oldGraph1, graph1));
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
	@Override
	public void setGraph1(Graph newGraph1) {
		Graph oldGraph1 = graph1;
		graph1 = newGraph1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 0, oldGraph1, graph1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Graph getGraph2() {
		if (graph2 != null && graph2.eIsProxy()) {
			InternalEObject oldGraph2 = (InternalEObject)graph2;
			graph2 = (Graph)eResolveProxy(oldGraph2);
			if (graph2 != oldGraph2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 1, oldGraph2, graph2));
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
	@Override
	public void setGraph2(Graph newGraph2) {
		Graph oldGraph2 = graph2;
		graph2 = newGraph2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldGraph2, graph2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element2Element> getElement2Element() {
		if (element2Element == null) {
			element2Element = new EObjectContainmentWithInverseEList<Element2Element>(Element2Element.class, this, 2, 0);
		}
		return element2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldName, name));
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
			case 2:
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
			case 2:
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
			case 0:
				if (resolve) return getGraph1();
				return basicGetGraph1();
			case 1:
				if (resolve) return getGraph2();
				return basicGetGraph2();
			case 2:
				return getElement2Element();
			case 3:
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
			case 0:
				setGraph1((Graph)newValue);
				return;
			case 1:
				setGraph2((Graph)newValue);
				return;
			case 2:
				getElement2Element().clear();
				getElement2Element().addAll((Collection<? extends Element2Element>)newValue);
				return;
			case 3:
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
			case 0:
				setGraph1((Graph)null);
				return;
			case 1:
				setGraph2((Graph)null);
				return;
			case 2:
				getElement2Element().clear();
				return;
			case 3:
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
			case 0:
				return graph1 != null;
			case 1:
				return graph2 != null;
			case 2:
				return element2Element != null && !element2Element.isEmpty();
			case 3:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //Graph2GraphImpl
