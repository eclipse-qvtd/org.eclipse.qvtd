/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#isCheckonly <em>Checkonly</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#isEnforce <em>Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#isReplace <em>Replace</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.DomainCSImpl#getImplementedBy <em>Implemented By</em>}</li>
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
	 * The cached value of the '{@link #getModelId() <em>Model Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelId()
	 * @generated
	 * @ordered
	 */
	protected IdentifierCS modelId;

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
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected TemplateCS template;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultValueCS> defaultValue;

	/**
	 * The cached value of the '{@link #getImplementedBy() <em>Implemented By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementedBy()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExpCS implementedBy;

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
		return QVTrCSTPackage.Literals.DOMAIN_CS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__CHECKONLY, oldCheckonly, checkonly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCS getModelId() {
		return modelId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelId(IdentifierCS newModelId, NotificationChain msgs) {
		IdentifierCS oldModelId = modelId;
		modelId = newModelId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__MODEL_ID, oldModelId, newModelId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelId(IdentifierCS newModelId) {
		if (newModelId != modelId) {
			NotificationChain msgs = null;
			if (modelId != null)
				msgs = ((InternalEObject)modelId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__MODEL_ID, null, msgs);
			if (newModelId != null)
				msgs = ((InternalEObject)newModelId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__MODEL_ID, null, msgs);
			msgs = basicSetModelId(newModelId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__MODEL_ID, newModelId, newModelId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__REPLACE, oldReplace, replace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateCS getTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(TemplateCS newTemplate, NotificationChain msgs) {
		TemplateCS oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(TemplateCS newTemplate) {
		if (newTemplate != template) {
			NotificationChain msgs = null;
			if (template != null)
				msgs = ((InternalEObject)template).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__TEMPLATE, null, msgs);
			if (newTemplate != null)
				msgs = ((InternalEObject)newTemplate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__TEMPLATE, null, msgs);
			msgs = basicSetTemplate(newTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__TEMPLATE, newTemplate, newTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultValueCS> getDefaultValue() {
		if (defaultValue == null) {
			defaultValue = new EObjectContainmentEList<DefaultValueCS>(DefaultValueCS.class, this, QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE);
		}
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExpCS getImplementedBy() {
		return implementedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementedBy(OperationCallExpCS newImplementedBy, NotificationChain msgs) {
		OperationCallExpCS oldImplementedBy = implementedBy;
		implementedBy = newImplementedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, oldImplementedBy, newImplementedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementedBy(OperationCallExpCS newImplementedBy) {
		if (newImplementedBy != implementedBy) {
			NotificationChain msgs = null;
			if (implementedBy != null)
				msgs = ((InternalEObject)implementedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, null, msgs);
			if (newImplementedBy != null)
				msgs = ((InternalEObject)newImplementedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, null, msgs);
			msgs = basicSetImplementedBy(newImplementedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY, newImplementedBy, newImplementedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.DOMAIN_CS__MODEL_ID:
				return basicSetModelId(null, msgs);
			case QVTrCSTPackage.DOMAIN_CS__TEMPLATE:
				return basicSetTemplate(null, msgs);
			case QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE:
				return ((InternalEList<?>)getDefaultValue()).basicRemove(otherEnd, msgs);
			case QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
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
			case QVTrCSTPackage.DOMAIN_CS__CHECKONLY:
				return isCheckonly() ? Boolean.TRUE : Boolean.FALSE;
			case QVTrCSTPackage.DOMAIN_CS__ENFORCE:
				return isEnforce() ? Boolean.TRUE : Boolean.FALSE;
			case QVTrCSTPackage.DOMAIN_CS__MODEL_ID:
				return getModelId();
			case QVTrCSTPackage.DOMAIN_CS__REPLACE:
				return isReplace() ? Boolean.TRUE : Boolean.FALSE;
			case QVTrCSTPackage.DOMAIN_CS__TEMPLATE:
				return getTemplate();
			case QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE:
				return getDefaultValue();
			case QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
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
			case QVTrCSTPackage.DOMAIN_CS__CHECKONLY:
				setCheckonly(((Boolean)newValue).booleanValue());
				return;
			case QVTrCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(((Boolean)newValue).booleanValue());
				return;
			case QVTrCSTPackage.DOMAIN_CS__MODEL_ID:
				setModelId((IdentifierCS)newValue);
				return;
			case QVTrCSTPackage.DOMAIN_CS__REPLACE:
				setReplace(((Boolean)newValue).booleanValue());
				return;
			case QVTrCSTPackage.DOMAIN_CS__TEMPLATE:
				setTemplate((TemplateCS)newValue);
				return;
			case QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE:
				getDefaultValue().clear();
				getDefaultValue().addAll((Collection<? extends DefaultValueCS>)newValue);
				return;
			case QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy((OperationCallExpCS)newValue);
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
			case QVTrCSTPackage.DOMAIN_CS__CHECKONLY:
				setCheckonly(CHECKONLY_EDEFAULT);
				return;
			case QVTrCSTPackage.DOMAIN_CS__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
				return;
			case QVTrCSTPackage.DOMAIN_CS__MODEL_ID:
				setModelId((IdentifierCS)null);
				return;
			case QVTrCSTPackage.DOMAIN_CS__REPLACE:
				setReplace(REPLACE_EDEFAULT);
				return;
			case QVTrCSTPackage.DOMAIN_CS__TEMPLATE:
				setTemplate((TemplateCS)null);
				return;
			case QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE:
				getDefaultValue().clear();
				return;
			case QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				setImplementedBy((OperationCallExpCS)null);
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
			case QVTrCSTPackage.DOMAIN_CS__CHECKONLY:
				return checkonly != CHECKONLY_EDEFAULT;
			case QVTrCSTPackage.DOMAIN_CS__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
			case QVTrCSTPackage.DOMAIN_CS__MODEL_ID:
				return modelId != null;
			case QVTrCSTPackage.DOMAIN_CS__REPLACE:
				return replace != REPLACE_EDEFAULT;
			case QVTrCSTPackage.DOMAIN_CS__TEMPLATE:
				return template != null;
			case QVTrCSTPackage.DOMAIN_CS__DEFAULT_VALUE:
				return defaultValue != null && !defaultValue.isEmpty();
			case QVTrCSTPackage.DOMAIN_CS__IMPLEMENTED_BY:
				return implementedBy != null;
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
		result.append(" (checkonly: ");
		result.append(checkonly);
		result.append(", enforce: ");
		result.append(enforce);
		result.append(", replace: ");
		result.append(replace);
		result.append(')');
		return result.toString();
	}

} //DomainCSImpl
