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
package org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Association;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Attribute;
import org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl#getGeneralOpposite <em>General Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.impl.ClassImpl#getReverse <em>Reverse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getForward() <em>Forward</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForward()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> forward;

	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class> general;

	/**
	 * The cached value of the '{@link #getGeneralOpposite() <em>General Opposite</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralOpposite()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class> generalOpposite;

	/**
	 * The cached value of the '{@link #getReverse() <em>Reverse</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverse()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> reverse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleumlPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, SimpleumlPackage.CLASS__ATTRIBUTES, SimpleumlPackage.ATTRIBUTE__OWNER);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getForward() {
		if (forward == null) {
			forward = new EObjectWithInverseResolvingEList<Association>(Association.class, this, SimpleumlPackage.CLASS__FORWARD, SimpleumlPackage.ASSOCIATION__SOURCE);
		}
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class> getGeneral() {
		if (general == null) {
			general = new EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class>(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, this, SimpleumlPackage.CLASS__GENERAL, SimpleumlPackage.CLASS__GENERAL_OPPOSITE);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class> getGeneralOpposite() {
		if (generalOpposite == null) {
			generalOpposite = new EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class>(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class.class, this, SimpleumlPackage.CLASS__GENERAL_OPPOSITE, SimpleumlPackage.CLASS__GENERAL);
		}
		return generalOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getReverse() {
		if (reverse == null) {
			reverse = new EObjectWithInverseResolvingEList<Association>(Association.class, this, SimpleumlPackage.CLASS__REVERSE, SimpleumlPackage.ASSOCIATION__DESTINATION);
		}
		return reverse;
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case SimpleumlPackage.CLASS__FORWARD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForward()).basicAdd(otherEnd, msgs);
			case SimpleumlPackage.CLASS__GENERAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneral()).basicAdd(otherEnd, msgs);
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralOpposite()).basicAdd(otherEnd, msgs);
			case SimpleumlPackage.CLASS__REVERSE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReverse()).basicAdd(otherEnd, msgs);
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case SimpleumlPackage.CLASS__FORWARD:
				return ((InternalEList<?>)getForward()).basicRemove(otherEnd, msgs);
			case SimpleumlPackage.CLASS__GENERAL:
				return ((InternalEList<?>)getGeneral()).basicRemove(otherEnd, msgs);
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				return ((InternalEList<?>)getGeneralOpposite()).basicRemove(otherEnd, msgs);
			case SimpleumlPackage.CLASS__REVERSE:
				return ((InternalEList<?>)getReverse()).basicRemove(otherEnd, msgs);
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case SimpleumlPackage.CLASS__FORWARD:
				return getForward();
			case SimpleumlPackage.CLASS__GENERAL:
				return getGeneral();
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				return getGeneralOpposite();
			case SimpleumlPackage.CLASS__REVERSE:
				return getReverse();
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case SimpleumlPackage.CLASS__FORWARD:
				getForward().clear();
				getForward().addAll((Collection<? extends Association>)newValue);
				return;
			case SimpleumlPackage.CLASS__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class>)newValue);
				return;
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				getGeneralOpposite().clear();
				getGeneralOpposite().addAll((Collection<? extends org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml.Class>)newValue);
				return;
			case SimpleumlPackage.CLASS__REVERSE:
				getReverse().clear();
				getReverse().addAll((Collection<? extends Association>)newValue);
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case SimpleumlPackage.CLASS__FORWARD:
				getForward().clear();
				return;
			case SimpleumlPackage.CLASS__GENERAL:
				getGeneral().clear();
				return;
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				getGeneralOpposite().clear();
				return;
			case SimpleumlPackage.CLASS__REVERSE:
				getReverse().clear();
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
			case SimpleumlPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case SimpleumlPackage.CLASS__FORWARD:
				return forward != null && !forward.isEmpty();
			case SimpleumlPackage.CLASS__GENERAL:
				return general != null && !general.isEmpty();
			case SimpleumlPackage.CLASS__GENERAL_OPPOSITE:
				return generalOpposite != null && !generalOpposite.isEmpty();
			case SimpleumlPackage.CLASS__REVERSE:
				return reverse != null && !reverse.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
