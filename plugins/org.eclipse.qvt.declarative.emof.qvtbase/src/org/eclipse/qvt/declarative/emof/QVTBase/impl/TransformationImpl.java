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
 * $Id: TransformationImpl.java,v 1.1 2008/07/23 09:57:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTBase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.Tag;
import org.eclipse.qvt.declarative.emof.EMOF.Type;

import org.eclipse.qvt.declarative.emof.EMOF.impl.ClassImpl;

import org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.emof.QVTBase.Rule;
import org.eclipse.qvt.declarative.emof.QVTBase.Transformation;
import org.eclipse.qvt.declarative.emof.QVTBase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTBase.impl.TransformationImpl#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationImpl extends ClassImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.qvt.declarative.emof.EMOF.Package> nestedPackage;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> ownedType;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected Transformation extends_;

	/**
	 * The cached value of the '{@link #getModelParameter() <em>Model Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> modelParameter;

	/**
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> ownedTag;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rule;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTBasePackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.qvt.declarative.emof.EMOF.Package> getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectContainmentEList<org.eclipse.qvt.declarative.emof.EMOF.Package>(org.eclipse.qvt.declarative.emof.EMOF.Package.class, this, QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentWithInverseEList<Type>(Type.class, this, QVTBasePackage.TRANSFORMATION__OWNED_TYPE, EMOFPackage.TYPE__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation getExtends() {
		if (extends_ != null && extends_.eIsProxy()) {
			InternalEObject oldExtends = (InternalEObject)extends_;
			extends_ = (Transformation)eResolveProxy(oldExtends);
			if (extends_ != oldExtends) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTBasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
			}
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation basicGetExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(Transformation newExtends) {
		Transformation oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedModel> getModelParameter() {
		if (modelParameter == null) {
			modelParameter = new EObjectContainmentWithInverseEList<TypedModel>(TypedModel.class, this, QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER, QVTBasePackage.TYPED_MODEL__TRANSFORMATION);
		}
		return modelParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<Tag>(Tag.class, this, QVTBasePackage.TRANSFORMATION__OWNED_TAG);
		}
		return ownedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRule() {
		if (rule == null) {
			rule = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, QVTBasePackage.TRANSFORMATION__RULE, QVTBasePackage.RULE__TRANSFORMATION);
		}
		return rule;
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
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelParameter()).basicAdd(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__RULE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRule()).basicAdd(otherEnd, msgs);
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
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__RULE:
				return ((InternalEList<?>)getRule()).basicRemove(otherEnd, msgs);
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
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return getNestedPackage();
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				return getOwnedType();
			case QVTBasePackage.TRANSFORMATION__URI:
				return getUri();
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return getOwnedTag();
			case QVTBasePackage.TRANSFORMATION__RULE:
				return getRule();
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
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.qvt.declarative.emof.EMOF.Package>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__URI:
				setUri((String)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends Tag>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
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
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__URI:
				setUri(URI_EDEFAULT);
				return;
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)null);
				return;
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__RULE:
				getRule().clear();
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
			case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case QVTBasePackage.TRANSFORMATION__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case QVTBasePackage.TRANSFORMATION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				return extends_ != null;
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTBasePackage.TRANSFORMATION__RULE:
				return rule != null && !rule.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.qvt.declarative.emof.EMOF.Package.class) {
			switch (derivedFeatureID) {
				case QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE: return EMOFPackage.PACKAGE__NESTED_PACKAGE;
				case QVTBasePackage.TRANSFORMATION__OWNED_TYPE: return EMOFPackage.PACKAGE__OWNED_TYPE;
				case QVTBasePackage.TRANSFORMATION__URI: return EMOFPackage.PACKAGE__URI;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.qvt.declarative.emof.EMOF.Package.class) {
			switch (baseFeatureID) {
				case EMOFPackage.PACKAGE__NESTED_PACKAGE: return QVTBasePackage.TRANSFORMATION__NESTED_PACKAGE;
				case EMOFPackage.PACKAGE__OWNED_TYPE: return QVTBasePackage.TRANSFORMATION__OWNED_TYPE;
				case EMOFPackage.PACKAGE__URI: return QVTBasePackage.TRANSFORMATION__URI;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //TransformationImpl
