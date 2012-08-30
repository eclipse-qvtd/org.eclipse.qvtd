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
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#isCheckonly <em>Checkonly</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#isEnforce <em>Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#isReplace <em>Replace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#getDefaultValues <em>Default Values</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcst.impl.DomainCSImpl#getImplementedBy <em>Implemented By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainCSImpl extends AbstractDomainCSImpl implements DomainCS {
	/**
	 * The default value of the '{@link #isCheckonly() <em>Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckonly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckonly() <em>Checkonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheckonly()
	 * @generated
	 * @ordered
	 */
	protected boolean checkonly = CHECKONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean enforce = ENFORCE_EDEFAULT;

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
	 * The default value of the '{@link #isReplace() <em>Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReplace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REPLACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReplace() <em>Replace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReplace()
	 * @generated
	 * @ordered
	 */
	protected boolean replace = REPLACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected DomainPatternCS pattern;

	/**
	 * The cached value of the '{@link #getDefaultValues() <em>Default Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValues()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultValueCS> defaultValues;

	/**
	 * The cached value of the '{@link #getImplementedBy() <em>Implemented By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected ExpCS implementedBy;

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
		return QVTrelationCSTPackage.Literals.DOMAIN_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCheckonly() {
		return checkonly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheckonly(boolean newCheckonly) {
		boolean oldCheckonly = checkonly;
		checkonly = newCheckonly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__CHECKONLY, oldCheckonly, checkonly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnforce() {
		return enforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforce(boolean newEnforce) {
		boolean oldEnforce = enforce;
		enforce = newEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getModelId() {
		if (modelId != null && modelId.eIsProxy()) {
			InternalEObject oldModelId = (InternalEObject)modelId;
			modelId = (TypedModel)eResolveProxy(oldModelId);
			if (modelId != oldModelId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID, oldModelId, modelId));
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
	public void setModelId(TypedModel newModelId) {
		TypedModel oldModelId = modelId;
		modelId = newModelId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID, oldModelId, modelId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReplace() {
		return replace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplace(boolean newReplace) {
		boolean oldReplace = replace;
		replace = newReplace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__REPLACE, oldReplace, replace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPatternCS getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(DomainPatternCS newPattern, NotificationChain msgs) {
		DomainPatternCS oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__PATTERN, oldPattern, newPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(DomainPatternCS newPattern) {
		if (newPattern != pattern) {
			NotificationChain msgs = null;
			if (pattern != null)
				msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DOMAIN_CS__PATTERN, null, msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DOMAIN_CS__PATTERN, null, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultValueCS> getDefaultValues() {
		if (defaultValues == null) {
			defaultValues = new EObjectContainmentEList<DefaultValueCS>(DefaultValueCS.class, this, QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES);
		}
		return defaultValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getImplementedBy() {
		return implementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementedBy(ExpCS newImplementedBy, NotificationChain msgs) {
		ExpCS oldImplementedBy = implementedBy;
		implementedBy = newImplementedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, oldImplementedBy, newImplementedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementedBy(ExpCS newImplementedBy) {
		if (newImplementedBy != implementedBy) {
			NotificationChain msgs = null;
			if (implementedBy != null)
				msgs = ((InternalEObject)implementedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, null, msgs);
			if (newImplementedBy != null)
				msgs = ((InternalEObject)newImplementedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, null, msgs);
			msgs = basicSetImplementedBy(newImplementedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, newImplementedBy, newImplementedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSTPackage.DOMAIN_CS__PATTERN:
				return basicSetPattern(null, msgs);
			case QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES:
				return ((InternalEList<?>)getDefaultValues()).basicRemove(otherEnd, msgs);
			case QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return basicSetImplementedBy(null, msgs);
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
			case QVTrelationCSTPackage.DOMAIN_CS__CHECKONLY:
				return isCheckonly();
			case QVTrelationCSTPackage.DOMAIN_CS__ENFORCE:
				return isEnforce();
			case QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID:
				if (resolve) return getModelId();
				return basicGetModelId();
			case QVTrelationCSTPackage.DOMAIN_CS__REPLACE:
				return isReplace();
			case QVTrelationCSTPackage.DOMAIN_CS__PATTERN:
				return getPattern();
			case QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES:
				return getDefaultValues();
			case QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return getImplementedBy();
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
			case QVTrelationCSTPackage.DOMAIN_CS__CHECKONLY:
				setCheckonly((Boolean)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce((Boolean)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID:
				setModelId((TypedModel)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__REPLACE:
				setReplace((Boolean)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__PATTERN:
				setPattern((DomainPatternCS)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES:
				getDefaultValues().clear();
				getDefaultValues().addAll((Collection<? extends DefaultValueCS>)newValue);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy((ExpCS)newValue);
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
			case QVTrelationCSTPackage.DOMAIN_CS__CHECKONLY:
				setCheckonly(CHECKONLY_EDEFAULT);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID:
				setModelId((TypedModel)null);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__REPLACE:
				setReplace(REPLACE_EDEFAULT);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__PATTERN:
				setPattern((DomainPatternCS)null);
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES:
				getDefaultValues().clear();
				return;
			case QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy((ExpCS)null);
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
			case QVTrelationCSTPackage.DOMAIN_CS__CHECKONLY:
				return checkonly != CHECKONLY_EDEFAULT;
			case QVTrelationCSTPackage.DOMAIN_CS__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
			case QVTrelationCSTPackage.DOMAIN_CS__MODEL_ID:
				return modelId != null;
			case QVTrelationCSTPackage.DOMAIN_CS__REPLACE:
				return replace != REPLACE_EDEFAULT;
			case QVTrelationCSTPackage.DOMAIN_CS__PATTERN:
				return pattern != null;
			case QVTrelationCSTPackage.DOMAIN_CS__DEFAULT_VALUES:
				return defaultValues != null && !defaultValues.isEmpty();
			case QVTrelationCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return implementedBy != null;
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

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) visitor.getAdapter(QVTrelationCSVisitor.class).visitDomainCS(this);
	}

	public String getName() {
		if ((modelId != null) && !modelId.eIsProxy()) {
			return modelId.getName();
		}
		return "null";
	}
} //DomainCSImpl
