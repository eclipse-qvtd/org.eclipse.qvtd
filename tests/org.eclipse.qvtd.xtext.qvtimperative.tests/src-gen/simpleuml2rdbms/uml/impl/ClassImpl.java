/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package simpleuml2rdbms.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml2rdbms.uml.Association;
import simpleuml2rdbms.uml.Attribute;
import simpleuml2rdbms.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simpleuml2rdbms.uml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.impl.ClassImpl#getForward <em>Forward</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.impl.ClassImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.impl.ClassImpl#getGeneralOpposite <em>General Opposite</em>}</li>
 *   <li>{@link simpleuml2rdbms.uml.impl.ClassImpl#getReverse <em>Reverse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements simpleuml2rdbms.uml.Class {
	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_FEATURE_COUNT = ClassifierImpl.CLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_OPERATION_COUNT = ClassifierImpl.CLASSIFIER_OPERATION_COUNT + 0;

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
	protected EList<simpleuml2rdbms.uml.Class> general;

	/**
	 * The cached value of the '{@link #getGeneralOpposite() <em>General Opposite</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralOpposite()
	 * @generated
	 * @ordered
	 */
	protected EList<simpleuml2rdbms.uml.Class> generalOpposite;

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
		return UMLPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, 4, 2);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Association> getForward() {
		if (forward == null) {
			forward = new EObjectWithInverseResolvingEList<Association>(Association.class, this, 5, 4);
		}
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<simpleuml2rdbms.uml.Class> getGeneral() {
		if (general == null) {
			general = new EObjectWithInverseResolvingEList.ManyInverse<simpleuml2rdbms.uml.Class>(simpleuml2rdbms.uml.Class.class, this, 6, 7);
		}
		return general;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<simpleuml2rdbms.uml.Class> getGeneralOpposite() {
		if (generalOpposite == null) {
			generalOpposite = new EObjectWithInverseResolvingEList.ManyInverse<simpleuml2rdbms.uml.Class>(simpleuml2rdbms.uml.Class.class, this, 7, 6);
		}
		return generalOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Association> getReverse() {
		if (reverse == null) {
			reverse = new EObjectWithInverseResolvingEList<Association>(Association.class, this, 8, 3);
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
			case 4:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForward()).basicAdd(otherEnd, msgs);
			case 6:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneral()).basicAdd(otherEnd, msgs);
			case 7:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralOpposite()).basicAdd(otherEnd, msgs);
			case 8:
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
			case 4:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case 5:
				return ((InternalEList<?>)getForward()).basicRemove(otherEnd, msgs);
			case 6:
				return ((InternalEList<?>)getGeneral()).basicRemove(otherEnd, msgs);
			case 7:
				return ((InternalEList<?>)getGeneralOpposite()).basicRemove(otherEnd, msgs);
			case 8:
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
			case 4:
				return getAttributes();
			case 5:
				return getForward();
			case 6:
				return getGeneral();
			case 7:
				return getGeneralOpposite();
			case 8:
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
			case 4:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case 5:
				getForward().clear();
				getForward().addAll((Collection<? extends Association>)newValue);
				return;
			case 6:
				getGeneral().clear();
				getGeneral().addAll((Collection<? extends simpleuml2rdbms.uml.Class>)newValue);
				return;
			case 7:
				getGeneralOpposite().clear();
				getGeneralOpposite().addAll((Collection<? extends simpleuml2rdbms.uml.Class>)newValue);
				return;
			case 8:
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
			case 4:
				getAttributes().clear();
				return;
			case 5:
				getForward().clear();
				return;
			case 6:
				getGeneral().clear();
				return;
			case 7:
				getGeneralOpposite().clear();
				return;
			case 8:
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
			case 4:
				return attributes != null && !attributes.isEmpty();
			case 5:
				return forward != null && !forward.isEmpty();
			case 6:
				return general != null && !general.isEmpty();
			case 7:
				return generalOpposite != null && !generalOpposite.isEmpty();
			case 8:
				return reverse != null && !reverse.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassImpl
