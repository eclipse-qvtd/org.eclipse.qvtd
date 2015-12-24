/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.RelationCSImpl#getOverrides <em>Overrides</em>}</li>
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
	 * The default value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefault = IS_DEFAULT_EDEFAULT;

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
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected Relation overrides;

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
	public boolean isIsDefault() {
		return isDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDefault(boolean newIsDefault) {
		boolean oldIsDefault = isDefault;
		isDefault = newIsDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__IS_DEFAULT, oldIsDefault, isDefault));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__IS_TOP, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject)overrides;
			overrides = (Relation)eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSPackage.RELATION_CS__OVERRIDES, oldOverrides, overrides));
			}
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverrides(Relation newOverrides) {
		Relation oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__OVERRIDES, oldOverrides, overrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VarDeclarationCS> getOwnedVarDeclarations() {
		if (ownedVarDeclarations == null) {
			ownedVarDeclarations = new EObjectContainmentEList<VarDeclarationCS>(VarDeclarationCS.class, this, QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS);
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
			ownedDomains = new EObjectContainmentEList<AbstractDomainCS>(AbstractDomainCS.class, this, QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__OWNED_WHEN, oldOwnedWhen, newOwnedWhen);
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
				msgs = ((InternalEObject)ownedWhen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.RELATION_CS__OWNED_WHEN, null, msgs);
			if (newOwnedWhen != null)
				msgs = ((InternalEObject)newOwnedWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.RELATION_CS__OWNED_WHEN, null, msgs);
			msgs = basicSetOwnedWhen(newOwnedWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__OWNED_WHEN, newOwnedWhen, newOwnedWhen));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__OWNED_WHERE, oldOwnedWhere, newOwnedWhere);
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
				msgs = ((InternalEObject)ownedWhere).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.RELATION_CS__OWNED_WHERE, null, msgs);
			if (newOwnedWhere != null)
				msgs = ((InternalEObject)newOwnedWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.RELATION_CS__OWNED_WHERE, null, msgs);
			msgs = basicSetOwnedWhere(newOwnedWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.RELATION_CS__OWNED_WHERE, newOwnedWhere, newOwnedWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
			case QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS:
				return ((InternalEList<?>)getOwnedVarDeclarations()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS:
				return ((InternalEList<?>)getOwnedDomains()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHEN:
				return basicSetOwnedWhen(null, msgs);
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHERE:
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
			case QVTrelationCSPackage.RELATION_CS__IS_DEFAULT:
				return isIsDefault();
			case QVTrelationCSPackage.RELATION_CS__IS_TOP:
				return isIsTop();
			case QVTrelationCSPackage.RELATION_CS__OVERRIDES:
				if (resolve) return getOverrides();
				return basicGetOverrides();
			case QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS:
				return getOwnedVarDeclarations();
			case QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS:
				return getOwnedDomains();
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHEN:
				return getOwnedWhen();
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHERE:
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
			case QVTrelationCSPackage.RELATION_CS__IS_DEFAULT:
				setIsDefault((Boolean)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__IS_TOP:
				setIsTop((Boolean)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__OVERRIDES:
				setOverrides((Relation)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS:
				getOwnedVarDeclarations().clear();
				getOwnedVarDeclarations().addAll((Collection<? extends VarDeclarationCS>)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				getOwnedDomains().addAll((Collection<? extends AbstractDomainCS>)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHEN:
				setOwnedWhen((PatternCS)newValue);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHERE:
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
			case QVTrelationCSPackage.RELATION_CS__IS_DEFAULT:
				setIsDefault(IS_DEFAULT_EDEFAULT);
				return;
			case QVTrelationCSPackage.RELATION_CS__IS_TOP:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case QVTrelationCSPackage.RELATION_CS__OVERRIDES:
				setOverrides((Relation)null);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS:
				getOwnedVarDeclarations().clear();
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHEN:
				setOwnedWhen((PatternCS)null);
				return;
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHERE:
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
			case QVTrelationCSPackage.RELATION_CS__IS_DEFAULT:
				return isDefault != IS_DEFAULT_EDEFAULT;
			case QVTrelationCSPackage.RELATION_CS__IS_TOP:
				return isTop != IS_TOP_EDEFAULT;
			case QVTrelationCSPackage.RELATION_CS__OVERRIDES:
				return overrides != null;
			case QVTrelationCSPackage.RELATION_CS__OWNED_VAR_DECLARATIONS:
				return ownedVarDeclarations != null && !ownedVarDeclarations.isEmpty();
			case QVTrelationCSPackage.RELATION_CS__OWNED_DOMAINS:
				return ownedDomains != null && !ownedDomains.isEmpty();
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHEN:
				return ownedWhen != null;
			case QVTrelationCSPackage.RELATION_CS__OWNED_WHERE:
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
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitRelationCS(this);
	}
} //RelationCSImpl
