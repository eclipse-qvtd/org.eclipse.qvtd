/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: RelationImplementationImpl.java,v 1.2 2009/02/17 21:44:33 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.impl.RelationImplementationImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.impl.RelationImplementationImpl#getImpl <em>Impl</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.impl.RelationImplementationImpl#getInDirectionOf <em>In Direction Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImplementationImpl extends EModelElementImpl implements RelationImplementation {
	/**
	 * The cached value of the '{@link #getImpl() <em>Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpl()
	 * @generated
	 * @ordered
	 */
	protected EOperation impl;

	/**
	 * The cached value of the '{@link #getInDirectionOf() <em>In Direction Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInDirectionOf()
	 * @generated
	 * @ordered
	 */
	protected TypedModel inDirectionOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTRelationPackage.Literals.RELATION_IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getRelation() {
		if (eContainerFeatureID() != QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION) return null;
		return (Relation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelation(Relation newRelation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRelation, QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(Relation newRelation) {
		if (newRelation != eInternalContainer() || (eContainerFeatureID() != QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION && newRelation != null)) {
			if (EcoreUtil.isAncestor(this, newRelation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRelation != null)
				msgs = ((InternalEObject)newRelation).eInverseAdd(this, QVTRelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
			msgs = basicSetRelation(newRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION, newRelation, newRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImpl() {
		if (impl != null && impl.eIsProxy()) {
			InternalEObject oldImpl = (InternalEObject)impl;
			impl = (EOperation)eResolveProxy(oldImpl);
			if (impl != oldImpl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
			}
		}
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetImpl() {
		return impl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpl(EOperation newImpl) {
		EOperation oldImpl = impl;
		impl = newImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL, oldImpl, impl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getInDirectionOf() {
		if (inDirectionOf != null && inDirectionOf.eIsProxy()) {
			InternalEObject oldInDirectionOf = (InternalEObject)inDirectionOf;
			inDirectionOf = (TypedModel)eResolveProxy(oldInDirectionOf);
			if (inDirectionOf != oldInDirectionOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
			}
		}
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetInDirectionOf() {
		return inDirectionOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInDirectionOf(TypedModel newInDirectionOf) {
		TypedModel oldInDirectionOf = inDirectionOf;
		inDirectionOf = newInDirectionOf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF, oldInDirectionOf, inDirectionOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRelation((Relation)otherEnd, msgs);
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return basicSetRelation(null, msgs);
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return eInternalContainer().eInverseRemove(this, QVTRelationPackage.RELATION__OPERATIONAL_IMPL, Relation.class, msgs);
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return getRelation();
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				if (resolve) return getImpl();
				return basicGetImpl();
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				if (resolve) return getInDirectionOf();
				return basicGetInDirectionOf();
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)newValue);
				return;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((EOperation)newValue);
				return;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)newValue);
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				setRelation((Relation)null);
				return;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				setImpl((EOperation)null);
				return;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				setInDirectionOf((TypedModel)null);
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
			case QVTRelationPackage.RELATION_IMPLEMENTATION__RELATION:
				return getRelation() != null;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IMPL:
				return impl != null;
			case QVTRelationPackage.RELATION_IMPLEMENTATION__IN_DIRECTION_OF:
				return inDirectionOf != null;
		}
		return super.eIsSet(featureID);
	}

} //RelationImplementationImpl
