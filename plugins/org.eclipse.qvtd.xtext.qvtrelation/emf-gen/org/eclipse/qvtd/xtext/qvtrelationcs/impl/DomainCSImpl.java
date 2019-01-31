/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedPatterns <em>Owned Patterns</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedDefaultValues <em>Owned Default Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.DomainCSImpl#getOwnedImplementedBy <em>Owned Implemented By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainCSImpl extends AbstractDomainCSImpl implements DomainCS {
	/**
	 * The number of structural features of the '<em>Domain CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_CS_FEATURE_COUNT = AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 8;

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
	 * The cached value of the '{@link #getOwnedPatterns() <em>Owned Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainPatternCS> ownedPatterns;

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
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0, oldImplementedBy, implementedBy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1, oldIsCheckonly, isCheckonly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2, oldIsEnforce, isEnforce));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3, oldModelId, modelId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3, oldModelId, modelId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4, oldIsReplace, isReplace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainPatternCS> getOwnedPatterns() {
		if (ownedPatterns == null) {
			ownedPatterns = new EObjectContainmentEList<DomainPatternCS>(DomainPatternCS.class, this, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5);
		}
		return ownedPatterns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DefaultValueCS> getOwnedDefaultValues() {
		if (ownedDefaultValues == null) {
			ownedDefaultValues = new EObjectContainmentEList<DefaultValueCS>(DefaultValueCS.class, this, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7, oldOwnedImplementedBy, newOwnedImplementedBy);
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
				msgs = ((InternalEObject)ownedImplementedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7), null, msgs);
			if (newOwnedImplementedBy != null)
				msgs = ((InternalEObject)newOwnedImplementedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7), null, msgs);
			msgs = basicSetOwnedImplementedBy(newOwnedImplementedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7, newOwnedImplementedBy, newOwnedImplementedBy));
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
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5:
				return ((InternalEList<?>)getOwnedPatterns()).basicRemove(otherEnd, msgs);
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6:
				return ((InternalEList<?>)getOwnedDefaultValues()).basicRemove(otherEnd, msgs);
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7:
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
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0:
				return getImplementedBy();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1:
				return isIsCheckonly();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2:
				return isIsEnforce();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3:
				if (resolve) return getModelId();
				return basicGetModelId();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4:
				return isIsReplace();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5:
				return getOwnedPatterns();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6:
				return getOwnedDefaultValues();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7:
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
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0:
				setImplementedBy((String)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1:
				setIsCheckonly((Boolean)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2:
				setIsEnforce((Boolean)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3:
				setModelId((TypedModel)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4:
				setIsReplace((Boolean)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5:
				getOwnedPatterns().clear();
				getOwnedPatterns().addAll((Collection<? extends DomainPatternCS>)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6:
				getOwnedDefaultValues().clear();
				getOwnedDefaultValues().addAll((Collection<? extends DefaultValueCS>)newValue);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7:
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
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0:
				setImplementedBy(IMPLEMENTED_BY_EDEFAULT);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1:
				setIsCheckonly(IS_CHECKONLY_EDEFAULT);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2:
				setIsEnforce(IS_ENFORCE_EDEFAULT);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3:
				setModelId((TypedModel)null);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4:
				setIsReplace(IS_REPLACE_EDEFAULT);
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5:
				getOwnedPatterns().clear();
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6:
				getOwnedDefaultValues().clear();
				return;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7:
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
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 0:
				return IMPLEMENTED_BY_EDEFAULT == null ? implementedBy != null : !IMPLEMENTED_BY_EDEFAULT.equals(implementedBy);
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 1:
				return isCheckonly != IS_CHECKONLY_EDEFAULT;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 2:
				return isEnforce != IS_ENFORCE_EDEFAULT;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 3:
				return modelId != null;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 4:
				return isReplace != IS_REPLACE_EDEFAULT;
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 5:
				return ownedPatterns != null && !ownedPatterns.isEmpty();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 6:
				return ownedDefaultValues != null && !ownedDefaultValues.isEmpty();
			case AbstractDomainCSImpl.ABSTRACT_DOMAIN_CS_FEATURE_COUNT + 7:
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
