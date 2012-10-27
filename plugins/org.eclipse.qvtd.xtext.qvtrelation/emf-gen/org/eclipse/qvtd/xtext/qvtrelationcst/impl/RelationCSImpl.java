/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

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
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#isTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#getVarDeclarations <em>Var Declarations</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.RelationCSImpl#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationCSImpl extends NamedElementCSImpl implements RelationCS {
	/**
	 * The default value of the '{@link #isTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTop()
	 * @generated
	 * @ordered
	 */
	protected boolean top = TOP_EDEFAULT;

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
	 * The cached value of the '{@link #getVarDeclarations() <em>Var Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclarationCS> varDeclarations;

	/**
	 * The cached value of the '{@link #getDomains() <em>Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDomainCS> domains;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected PatternCS when;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected PatternCS where;

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
		return QVTrelationCSTPackage.Literals.RELATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTop() {
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTop(boolean newTop) {
		boolean oldTop = top;
		top = newTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__TOP, oldTop, top));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject)overrides;
			overrides = (Relation)eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSTPackage.RELATION_CS__OVERRIDES, oldOverrides, overrides));
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
	public void setOverrides(Relation newOverrides) {
		Relation oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__OVERRIDES, oldOverrides, overrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarDeclarationCS> getVarDeclarations() {
		if (varDeclarations == null) {
			varDeclarations = new EObjectContainmentEList<VarDeclarationCS>(VarDeclarationCS.class, this, QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS);
		}
		return varDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDomainCS> getDomains() {
		if (domains == null) {
			domains = new EObjectContainmentEList<AbstractDomainCS>(AbstractDomainCS.class, this, QVTrelationCSTPackage.RELATION_CS__DOMAINS);
		}
		return domains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternCS getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(PatternCS newWhen, NotificationChain msgs) {
		PatternCS oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(PatternCS newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.RELATION_CS__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.RELATION_CS__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternCS getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(PatternCS newWhere, NotificationChain msgs) {
		PatternCS oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(PatternCS newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.RELATION_CS__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.RELATION_CS__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.RELATION_CS__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS:
				return ((InternalEList<?>)getVarDeclarations()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.RELATION_CS__DOMAINS:
				return ((InternalEList<?>)getDomains()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.RELATION_CS__WHEN:
				return basicSetWhen(null, msgs);
			case QVTrelationCSTPackage.RELATION_CS__WHERE:
				return basicSetWhere(null, msgs);
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
			case QVTrelationCSTPackage.RELATION_CS__TOP:
				return isTop();
			case QVTrelationCSTPackage.RELATION_CS__OVERRIDES:
				if (resolve) return getOverrides();
				return basicGetOverrides();
			case QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS:
				return getVarDeclarations();
			case QVTrelationCSTPackage.RELATION_CS__DOMAINS:
				return getDomains();
			case QVTrelationCSTPackage.RELATION_CS__WHEN:
				return getWhen();
			case QVTrelationCSTPackage.RELATION_CS__WHERE:
				return getWhere();
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
			case QVTrelationCSTPackage.RELATION_CS__TOP:
				setTop((Boolean)newValue);
				return;
			case QVTrelationCSTPackage.RELATION_CS__OVERRIDES:
				setOverrides((Relation)newValue);
				return;
			case QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS:
				getVarDeclarations().clear();
				getVarDeclarations().addAll((Collection<? extends VarDeclarationCS>)newValue);
				return;
			case QVTrelationCSTPackage.RELATION_CS__DOMAINS:
				getDomains().clear();
				getDomains().addAll((Collection<? extends AbstractDomainCS>)newValue);
				return;
			case QVTrelationCSTPackage.RELATION_CS__WHEN:
				setWhen((PatternCS)newValue);
				return;
			case QVTrelationCSTPackage.RELATION_CS__WHERE:
				setWhere((PatternCS)newValue);
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
			case QVTrelationCSTPackage.RELATION_CS__TOP:
				setTop(TOP_EDEFAULT);
				return;
			case QVTrelationCSTPackage.RELATION_CS__OVERRIDES:
				setOverrides((Relation)null);
				return;
			case QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS:
				getVarDeclarations().clear();
				return;
			case QVTrelationCSTPackage.RELATION_CS__DOMAINS:
				getDomains().clear();
				return;
			case QVTrelationCSTPackage.RELATION_CS__WHEN:
				setWhen((PatternCS)null);
				return;
			case QVTrelationCSTPackage.RELATION_CS__WHERE:
				setWhere((PatternCS)null);
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
			case QVTrelationCSTPackage.RELATION_CS__TOP:
				return top != TOP_EDEFAULT;
			case QVTrelationCSTPackage.RELATION_CS__OVERRIDES:
				return overrides != null;
			case QVTrelationCSTPackage.RELATION_CS__VAR_DECLARATIONS:
				return varDeclarations != null && !varDeclarations.isEmpty();
			case QVTrelationCSTPackage.RELATION_CS__DOMAINS:
				return domains != null && !domains.isEmpty();
			case QVTrelationCSTPackage.RELATION_CS__WHEN:
				return when != null;
			case QVTrelationCSTPackage.RELATION_CS__WHERE:
				return where != null;
		}
		return super.eIsSet(featureID);
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

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTrelationCSVisitor<R>)visitor).visitRelationCS(this);
	}
} //RelationCSImpl
