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
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getImplementedBy <em>Implemented By</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#isIsCheckonly <em>Is Checkonly</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#isIsEnforce <em>Is Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#isIsReplace <em>Is Replace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedPattern <em>Owned Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedDefaultValues <em>Owned Default Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedImplementedBy <em>Owned Implemented By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainCSImpl extends AbstractDomainCSImpl implements DomainCS {
	/**
	 * The default value of the '{@link #getImplementedBy() <em>Implemented By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementedBy() <em>Implemented By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected String implementedBy = IMPLEMENTED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsCheckonly() <em>Is Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckonly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheckonly() <em>Is Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheckonly()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheckonly = IS_CHECKONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforce() <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforce() <em>Is Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforce = IS_ENFORCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelId() <em>Model Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelId()
	 * @generated
	 * @ordered
	 */
	protected TypedModel modelId;

	/**
	 * The default value of the '{@link #isIsReplace() <em>Is Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReplace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REPLACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReplace() <em>Is Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReplace()
	 * @generated
	 * @ordered
	 */
	protected boolean isReplace = IS_REPLACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedPattern() <em>Owned Pattern</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainPatternCS> ownedPattern;

	/**
	 * The cached value of the '{@link #getOwnedDefaultValues() <em>Owned Default Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDefaultValues()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultValueCS> ownedDefaultValues;

	/**
	 * The cached value of the '{@link #getOwnedImplementedBy() <em>Owned Implemented By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedImplementedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImplementedBy() {
		return implementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplementedBy(String newImplementedBy) {
		String oldImplementedBy = implementedBy;
		implementedBy = newImplementedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__IMPLEMENTED_BY, oldImplementedBy, implementedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCheckonly() {
		return isCheckonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCheckonly(boolean newIsCheckonly) {
		boolean oldIsCheckonly = isCheckonly;
		isCheckonly = newIsCheckonly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__IS_CHECKONLY, oldIsCheckonly, isCheckonly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforce() {
		return isEnforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforce(boolean newIsEnforce) {
		boolean oldIsEnforce = isEnforce;
		isEnforce = newIsEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__IS_ENFORCE, oldIsEnforce, isEnforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getModelId() {
		if (modelId != null && modelId.eIsProxy()) {
			InternalEObject oldModelId = (InternalEObject)modelId;
			modelId = (TypedModel)eResolveProxy(oldModelId);
			if (modelId != oldModelId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSPackage.DOMAIN_CS__MODEL_ID, oldModelId, modelId));
			}
		}
		return modelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetModelId() {
		return modelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelId(TypedModel newModelId) {
		TypedModel oldModelId = modelId;
		modelId = newModelId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__MODEL_ID, oldModelId, modelId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsReplace() {
		return isReplace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsReplace(boolean newIsReplace) {
		boolean oldIsReplace = isReplace;
		isReplace = newIsReplace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__IS_REPLACE, oldIsReplace, isReplace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainPatternCS> getOwnedPattern() {
		if (ownedPattern == null) {
			ownedPattern = new EObjectContainmentEList<DomainPatternCS>(DomainPatternCS.class, this, QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN);
		}
		return ownedPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DefaultValueCS> getOwnedDefaultValues() {
		if (ownedDefaultValues == null) {
			ownedDefaultValues = new EObjectContainmentEList<DefaultValueCS>(DefaultValueCS.class, this, QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES);
		}
		return ownedDefaultValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedImplementedBy() {
		return ownedImplementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedImplementedBy(ExpCS newOwnedImplementedBy, NotificationChain msgs) {
		ExpCS oldOwnedImplementedBy = ownedImplementedBy;
		ownedImplementedBy = newOwnedImplementedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY, oldOwnedImplementedBy, newOwnedImplementedBy);
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
	public void setOwnedImplementedBy(ExpCS newOwnedImplementedBy) {
		if (newOwnedImplementedBy != ownedImplementedBy) {
			NotificationChain msgs = null;
			if (ownedImplementedBy != null)
				msgs = ((InternalEObject)ownedImplementedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY, null, msgs);
			if (newOwnedImplementedBy != null)
				msgs = ((InternalEObject)newOwnedImplementedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY, null, msgs);
			msgs = basicSetOwnedImplementedBy(newOwnedImplementedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY, newOwnedImplementedBy, newOwnedImplementedBy));
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
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN:
				return ((InternalEList<?>)getOwnedPattern()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES:
				return ((InternalEList<?>)getOwnedDefaultValues()).basicRemove(otherEnd, msgs);
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY:
				return basicSetOwnedImplementedBy(null, msgs);
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
			case QVTrelationCSPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return getImplementedBy();
			case QVTrelationCSPackage.DOMAIN_CS__IS_CHECKONLY:
				return isIsCheckonly();
			case QVTrelationCSPackage.DOMAIN_CS__IS_ENFORCE:
				return isIsEnforce();
			case QVTrelationCSPackage.DOMAIN_CS__MODEL_ID:
				if (resolve) return getModelId();
				return basicGetModelId();
			case QVTrelationCSPackage.DOMAIN_CS__IS_REPLACE:
				return isIsReplace();
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN:
				return getOwnedPattern();
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES:
				return getOwnedDefaultValues();
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY:
				return getOwnedImplementedBy();
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
			case QVTrelationCSPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy((String)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_CHECKONLY:
				setIsCheckonly((Boolean)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_ENFORCE:
				setIsEnforce((Boolean)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__MODEL_ID:
				setModelId((TypedModel)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_REPLACE:
				setIsReplace((Boolean)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN:
				getOwnedPattern().clear();
				getOwnedPattern().addAll((Collection<? extends DomainPatternCS>)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES:
				getOwnedDefaultValues().clear();
				getOwnedDefaultValues().addAll((Collection<? extends DefaultValueCS>)newValue);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY:
				setOwnedImplementedBy((ExpCS)newValue);
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
			case QVTrelationCSPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy(IMPLEMENTED_BY_EDEFAULT);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_CHECKONLY:
				setIsCheckonly(IS_CHECKONLY_EDEFAULT);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_ENFORCE:
				setIsEnforce(IS_ENFORCE_EDEFAULT);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__MODEL_ID:
				setModelId((TypedModel)null);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__IS_REPLACE:
				setIsReplace(IS_REPLACE_EDEFAULT);
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN:
				getOwnedPattern().clear();
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES:
				getOwnedDefaultValues().clear();
				return;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY:
				setOwnedImplementedBy((ExpCS)null);
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
			case QVTrelationCSPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return IMPLEMENTED_BY_EDEFAULT == null ? implementedBy != null : !IMPLEMENTED_BY_EDEFAULT.equals(implementedBy);
			case QVTrelationCSPackage.DOMAIN_CS__IS_CHECKONLY:
				return isCheckonly != IS_CHECKONLY_EDEFAULT;
			case QVTrelationCSPackage.DOMAIN_CS__IS_ENFORCE:
				return isEnforce != IS_ENFORCE_EDEFAULT;
			case QVTrelationCSPackage.DOMAIN_CS__MODEL_ID:
				return modelId != null;
			case QVTrelationCSPackage.DOMAIN_CS__IS_REPLACE:
				return isReplace != IS_REPLACE_EDEFAULT;
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_PATTERN:
				return ownedPattern != null && !ownedPattern.isEmpty();
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_DEFAULT_VALUES:
				return ownedDefaultValues != null && !ownedDefaultValues.isEmpty();
			case QVTrelationCSPackage.DOMAIN_CS__OWNED_IMPLEMENTED_BY:
				return ownedImplementedBy != null;
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
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitDomainCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if ((modelId != null) && !modelId.eIsProxy()) {
			return modelId.getName();
		}
		return "null";
	}
} //DomainCSImpl
