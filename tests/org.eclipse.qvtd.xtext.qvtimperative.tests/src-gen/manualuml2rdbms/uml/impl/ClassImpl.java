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
package manualuml2rdbms.uml.impl;

import java.util.Collection;

import manualuml2rdbms.uml.Association;
import manualuml2rdbms.uml.Attribute;
import manualuml2rdbms.uml.UMLPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link manualuml2rdbms.uml.impl.ClassImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.impl.ClassImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.impl.ClassImpl#getReverse <em>Reverse</em>}</li>
 *   <li>{@link manualuml2rdbms.uml.impl.ClassImpl#getGeneralOpposite <em>General Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements manualuml2rdbms.uml.Class {
	/**
	 * The cached value of the '{@link #getGeneral() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneral()
	 * @generated
	 * @ordered
	 */
	protected EList<manualuml2rdbms.uml.Class> general;

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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

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
	 * The cached value of the '{@link #getGeneralOpposite() <em>General Opposite</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralOpposite()
	 * @generated
	 * @ordered
	 */
	protected EList<manualuml2rdbms.uml.Class> generalOpposite;

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
		return UMLPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<manualuml2rdbms.uml.Class> getGeneral() {
		if (general == null) {
			general = new EObjectWithInverseResolvingEList.ManyInverse<manualuml2rdbms.uml.Class>(manualuml2rdbms.uml.Class.class, this, UMLPackage.CLASS__GENERAL, UMLPackage.CLASS__GENERAL_OPPOSITE);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getForward() {
		if (forward == null) {
			forward = new EObjectWithInverseResolvingEList<Association>(Association.class, this, UMLPackage.CLASS__FORWARD, UMLPackage.ASSOCIATION__SOURCE);
		}
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, UMLPackage.CLASS__ATTRIBUTES, UMLPackage.ATTRIBUTE__OWNER);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getReverse() {
		if (reverse == null) {
			reverse = new EObjectResolvingEList<Association>(Association.class, this, UMLPackage.CLASS__REVERSE);
		}
		return reverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<manualuml2rdbms.uml.Class> getGeneralOpposite() {
		if (generalOpposite == null) {
			generalOpposite = new EObjectWithInverseResolvingEList.ManyInverse<manualuml2rdbms.uml.Class>(manualuml2rdbms.uml.Class.class, this, UMLPackage.CLASS__GENERAL_OPPOSITE, UMLPackage.CLASS__GENERAL);
		}
		return generalOpposite;
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
			case UMLPackage.CLASS__GENERAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneral()).basicAdd(otherEnd, msgs);
			case UMLPackage.CLASS__FORWARD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForward()).basicAdd(otherEnd, msgs);
			case UMLPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralOpposite()).basicAdd(otherEnd, msgs);
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
			case UMLPackage.CLASS__GENERAL:
				return ((InternalEList<?>)getGeneral()).basicRemove(otherEnd, msgs);
			case UMLPackage.CLASS__FORWARD:
				return ((InternalEList<?>)getForward()).basicRemove(otherEnd, msgs);
			case UMLPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				return ((InternalEList<?>)getGeneralOpposite()).basicRemove(otherEnd, msgs);
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
			case UMLPackage.CLASS__GENERAL:
				return getGeneral();
			case UMLPackage.CLASS__FORWARD:
				return getForward();
			case UMLPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case UMLPackage.CLASS__REVERSE:
				return getReverse();
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				return getGeneralOpposite();
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
			case UMLPackage.CLASS__GENERAL:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends manualuml2rdbms.uml.Class>)newValue);
				return;
			case UMLPackage.CLASS__FORWARD:
				getForward().clear();
				getForward().addAll((Collection<? extends Association>)newValue);
				return;
			case UMLPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case UMLPackage.CLASS__REVERSE:
				getReverse().clear();
				getReverse().addAll((Collection<? extends Association>)newValue);
				return;
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				getGeneralOpposite().clear();
				getGeneralOpposite().addAll((Collection<? extends manualuml2rdbms.uml.Class>)newValue);
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
			case UMLPackage.CLASS__GENERAL:
				getGeneral().clear();
				return;
			case UMLPackage.CLASS__FORWARD:
				getForward().clear();
				return;
			case UMLPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case UMLPackage.CLASS__REVERSE:
				getReverse().clear();
				return;
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				getGeneralOpposite().clear();
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
			case UMLPackage.CLASS__GENERAL:
				return general != null && !general.isEmpty();
			case UMLPackage.CLASS__FORWARD:
				return forward != null && !forward.isEmpty();
			case UMLPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case UMLPackage.CLASS__REVERSE:
				return reverse != null && !reverse.isEmpty();
			case UMLPackage.CLASS__GENERAL_OPPOSITE:
				return generalOpposite != null && !generalOpposite.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
