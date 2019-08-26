/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOwnedVarDeclarations <em>Owned Var Declarations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOwnedWhen <em>Owned When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOwnedWhere <em>Owned Where</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationCSImpl extends NamedElementCSImpl implements RelationCS {
	/**
	 * The number of structural features of the '<em>Relation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_CS_FEATURE_COUNT = NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected boolean isTop = IS_TOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected Relation overridden;

	/**
	 * The cached value of the '{@link #getOwnedVarDeclarations() <em>Owned Var Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVarDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclarationCS> ownedVarDeclarations;

	/**
	 * The cached value of the '{@link #getOwnedDomains() <em>Owned Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDomainCS> ownedDomains;

	/**
	 * The cached value of the '{@link #getOwnedWhen() <em>Owned When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedWhen()
	 * @generated
	 * @ordered
	 */
	protected PatternCS ownedWhen;

	/**
	 * The cached value of the '{@link #getOwnedWhere() <em>Owned Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedWhere()
	 * @generated
	 * @ordered
	 */
	protected PatternCS ownedWhere;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.RELATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTop() {
		return isTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTop(boolean newIsTop) {
		boolean oldIsTop = isTop;
		isTop = newIsTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getOverridden() {
		if (overridden != null && overridden.eIsProxy()) {
			InternalEObject oldOverridden = (InternalEObject)overridden;
			overridden = (Relation)eResolveProxy(oldOverridden);
			if (overridden != oldOverridden) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2, oldOverridden, overridden));
			}
		}
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverridden(Relation newOverridden) {
		Relation oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VarDeclarationCS> getOwnedVarDeclarations() {
		if (ownedVarDeclarations == null) {
			ownedVarDeclarations = new EObjectContainmentEList<VarDeclarationCS>(VarDeclarationCS.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3);
		}
		return ownedVarDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractDomainCS> getOwnedDomains() {
		if (ownedDomains == null) {
			ownedDomains = new EObjectContainmentEList<AbstractDomainCS>(AbstractDomainCS.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4);
		}
		return ownedDomains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternCS getOwnedWhen() {
		return ownedWhen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedWhen(PatternCS newOwnedWhen, NotificationChain msgs) {
		PatternCS oldOwnedWhen = ownedWhen;
		ownedWhen = newOwnedWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5, oldOwnedWhen, newOwnedWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedWhen(PatternCS newOwnedWhen) {
		if (newOwnedWhen != ownedWhen) {
			NotificationChain msgs = null;
			if (ownedWhen != null)
				msgs = ((InternalEObject)ownedWhen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5), null, msgs);
			if (newOwnedWhen != null)
				msgs = ((InternalEObject)newOwnedWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5), null, msgs);
			msgs = basicSetOwnedWhen(newOwnedWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5, newOwnedWhen, newOwnedWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternCS getOwnedWhere() {
		return ownedWhere;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedWhere(PatternCS newOwnedWhere, NotificationChain msgs) {
		PatternCS oldOwnedWhere = ownedWhere;
		ownedWhere = newOwnedWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6, oldOwnedWhere, newOwnedWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedWhere(PatternCS newOwnedWhere) {
		if (newOwnedWhere != ownedWhere) {
			NotificationChain msgs = null;
			if (ownedWhere != null)
				msgs = ((InternalEObject)ownedWhere).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6), null, msgs);
			if (newOwnedWhere != null)
				msgs = ((InternalEObject)newOwnedWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6), null, msgs);
			msgs = basicSetOwnedWhere(newOwnedWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6, newOwnedWhere, newOwnedWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedVarDeclarations()).basicRemove(otherEnd, msgs);
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getOwnedDomains()).basicRemove(otherEnd, msgs);
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				return basicSetOwnedWhen(null, msgs);
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return basicSetOwnedWhere(null, msgs);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				return isIsAbstract();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				return isIsTop();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2:
				if (resolve) return getOverridden();
				return basicGetOverridden();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3:
				return getOwnedVarDeclarations();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4:
				return getOwnedDomains();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				return getOwnedWhen();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return getOwnedWhere();
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				setIsAbstract((Boolean)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				setIsTop((Boolean)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOverridden((Relation)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3:
				getOwnedVarDeclarations().clear();
				getOwnedVarDeclarations().addAll((Collection<? extends VarDeclarationCS>)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4:
				getOwnedDomains().clear();
				getOwnedDomains().addAll((Collection<? extends AbstractDomainCS>)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				setOwnedWhen((PatternCS)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				setOwnedWhere((PatternCS)newValue);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2:
				setOverridden((Relation)null);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3:
				getOwnedVarDeclarations().clear();
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4:
				getOwnedDomains().clear();
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				setOwnedWhen((PatternCS)null);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				setOwnedWhere((PatternCS)null);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1:
				return isTop != IS_TOP_EDEFAULT;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2:
				return overridden != null;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3:
				return ownedVarDeclarations != null && !ownedVarDeclarations.isEmpty();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4:
				return ownedDomains != null && !ownedDomains.isEmpty();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				return ownedWhen != null;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return ownedWhere != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		try {
			return (R) ((QVTrelationCSVisitor<?>)visitor).visitRelationCS(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
	}
} //RelationCSImpl
