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
 * $Id: RelationCSImpl.java,v 1.2 2008/08/18 07:55:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.impl.CSTNodeImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#isTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.RelationCSImpl#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationCSImpl extends CSTNodeImpl implements RelationCS {
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
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS identifier;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS overrides;

	/**
	 * The cached value of the '{@link #getVarDeclaration() <em>Var Declaration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDeclaration()
	 * @generated
	 * @ordered
	 */
	protected EList<VarDeclarationCS> varDeclaration;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDomainCS> domain;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected WhenCS when;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected WhereCS where;

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
		return QVTrCSTPackage.Literals.RELATION_CS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__TOP, oldTop, top));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(IdentifierCS newIdentifier, NotificationChain msgs) {
		IdentifierCS oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__IDENTIFIER, oldIdentifier, newIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(IdentifierCS newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__IDENTIFIER, newIdentifier, newIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOverrides(IdentifierCS newOverrides, NotificationChain msgs) {
		IdentifierCS oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__OVERRIDES, oldOverrides, newOverrides);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverrides(IdentifierCS newOverrides) {
		if (newOverrides != overrides) {
			NotificationChain msgs = null;
			if (overrides != null)
				msgs = ((InternalEObject)overrides).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__OVERRIDES, null, msgs);
			if (newOverrides != null)
				msgs = ((InternalEObject)newOverrides).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__OVERRIDES, null, msgs);
			msgs = basicSetOverrides(newOverrides, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__OVERRIDES, newOverrides, newOverrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarDeclarationCS> getVarDeclaration() {
		if (varDeclaration == null) {
			varDeclaration = new EObjectContainmentEList<VarDeclarationCS>(VarDeclarationCS.class, this, QVTrCSTPackage.RELATION_CS__VAR_DECLARATION);
		}
		return varDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDomainCS> getDomain() {
		if (domain == null) {
			domain = new EObjectContainmentEList<AbstractDomainCS>(AbstractDomainCS.class, this, QVTrCSTPackage.RELATION_CS__DOMAIN);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhenCS getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(WhenCS newWhen, NotificationChain msgs) {
		WhenCS oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(WhenCS newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhereCS getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(WhereCS newWhere, NotificationChain msgs) {
		WhereCS oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(WhereCS newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.RELATION_CS__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.RELATION_CS__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.RELATION_CS__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
			case QVTrCSTPackage.RELATION_CS__OVERRIDES:
				return basicSetOverrides(null, msgs);
			case QVTrCSTPackage.RELATION_CS__VAR_DECLARATION:
				return ((InternalEList<?>)getVarDeclaration()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.RELATION_CS__DOMAIN:
				return ((InternalEList<?>)getDomain()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.RELATION_CS__WHEN:
				return basicSetWhen(null, msgs);
			case QVTrCSTPackage.RELATION_CS__WHERE:
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
			case QVTrCSTPackage.RELATION_CS__TOP:
				return isTop() ? Boolean.TRUE : Boolean.FALSE;
			case QVTrCSTPackage.RELATION_CS__IDENTIFIER:
				return getIdentifier();
			case QVTrCSTPackage.RELATION_CS__OVERRIDES:
				return getOverrides();
			case QVTrCSTPackage.RELATION_CS__VAR_DECLARATION:
				return getVarDeclaration();
			case QVTrCSTPackage.RELATION_CS__DOMAIN:
				return getDomain();
			case QVTrCSTPackage.RELATION_CS__WHEN:
				return getWhen();
			case QVTrCSTPackage.RELATION_CS__WHERE:
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
			case QVTrCSTPackage.RELATION_CS__TOP:
				setTop(((Boolean)newValue).booleanValue());
				return;
			case QVTrCSTPackage.RELATION_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.RELATION_CS__OVERRIDES:
				setOverrides((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.RELATION_CS__VAR_DECLARATION:
				getVarDeclaration().clear();
				getVarDeclaration().addAll((Collection<? extends VarDeclarationCS>)newValue);
				return;
			case QVTrCSTPackage.RELATION_CS__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends AbstractDomainCS>)newValue);
				return;
			case QVTrCSTPackage.RELATION_CS__WHEN:
				setWhen((WhenCS)newValue);
				return;
			case QVTrCSTPackage.RELATION_CS__WHERE:
				setWhere((WhereCS)newValue);
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
			case QVTrCSTPackage.RELATION_CS__TOP:
				setTop(TOP_EDEFAULT);
				return;
			case QVTrCSTPackage.RELATION_CS__IDENTIFIER:
				setIdentifier((IdentifierCS)null);
				return;
			case QVTrCSTPackage.RELATION_CS__OVERRIDES:
				setOverrides((IdentifierCS)null);
				return;
			case QVTrCSTPackage.RELATION_CS__VAR_DECLARATION:
				getVarDeclaration().clear();
				return;
			case QVTrCSTPackage.RELATION_CS__DOMAIN:
				getDomain().clear();
				return;
			case QVTrCSTPackage.RELATION_CS__WHEN:
				setWhen((WhenCS)null);
				return;
			case QVTrCSTPackage.RELATION_CS__WHERE:
				setWhere((WhereCS)null);
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
			case QVTrCSTPackage.RELATION_CS__TOP:
				return top != TOP_EDEFAULT;
			case QVTrCSTPackage.RELATION_CS__IDENTIFIER:
				return identifier != null;
			case QVTrCSTPackage.RELATION_CS__OVERRIDES:
				return overrides != null;
			case QVTrCSTPackage.RELATION_CS__VAR_DECLARATION:
				return varDeclaration != null && !varDeclaration.isEmpty();
			case QVTrCSTPackage.RELATION_CS__DOMAIN:
				return domain != null && !domain.isEmpty();
			case QVTrCSTPackage.RELATION_CS__WHEN:
				return when != null;
			case QVTrCSTPackage.RELATION_CS__WHERE:
				return where != null;
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
		result.append(" (top: ");
		result.append(top);
		result.append(')');
		return result.toString();
	}

} //RelationCSImpl
