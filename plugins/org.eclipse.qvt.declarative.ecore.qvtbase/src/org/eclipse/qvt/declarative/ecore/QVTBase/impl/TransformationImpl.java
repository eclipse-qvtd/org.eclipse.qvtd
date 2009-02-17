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
 * $Id: TransformationImpl.java,v 1.2 2009/02/17 21:44:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getEFactoryInstance <em>EFactory Instance</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getEClassifiers <em>EClassifiers</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getESubpackages <em>ESubpackages</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getESuperPackage <em>ESuper Package</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTBase.impl.TransformationImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationImpl extends EClassImpl implements Transformation {
	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEFactoryInstance() <em>EFactory Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactoryInstance()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactoryInstance;

	/**
	 * The cached value of the '{@link #getEClassifiers() <em>EClassifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> eClassifiers;

	/**
	 * The cached value of the '{@link #getESubpackages() <em>ESubpackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESubpackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> eSubpackages;

	/**
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<EAnnotation> ownedTag;

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
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rule;

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
	 * The map from name to 
	 * @generated BY COPY from EPackageImpl
	 */
	protected Map<String, EClassifier> eNameToEClassifierMap; 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TransformationImpl() {
		super();
	    setEFactoryInstance(new EFactoryImpl() {});	// FIXME this avoids a validation error
	    											//  it should really be a factory that supports
	    											//   creation of elements defined by the Transformation
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
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory getEFactoryInstance() {
		return eFactoryInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEFactoryInstance(EFactory newEFactoryInstance, NotificationChain msgs) {
		EFactory oldEFactoryInstance = eFactoryInstance;
		eFactoryInstance = newEFactoryInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE, oldEFactoryInstance, newEFactoryInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEFactoryInstance(EFactory newEFactoryInstance) {
		if (newEFactoryInstance != eFactoryInstance) {
			NotificationChain msgs = null;
			if (eFactoryInstance != null)
				msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			if (newEFactoryInstance != null)
				msgs = ((InternalEObject)newEFactoryInstance).eInverseAdd(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			msgs = basicSetEFactoryInstance(newEFactoryInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE, newEFactoryInstance, newEFactoryInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getEClassifiers() {
		if (eClassifiers == null) {
			eClassifiers = new EObjectContainmentWithInverseEList.Resolving<EClassifier>(EClassifier.class, this, QVTBasePackage.TRANSFORMATION__ECLASSIFIERS, EcorePackage.ECLASSIFIER__EPACKAGE);
		}
		return eClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getESubpackages() {
		if (eSubpackages == null) {
			eSubpackages = new EObjectContainmentWithInverseEList.Resolving<EPackage>(EPackage.class, this, QVTBasePackage.TRANSFORMATION__ESUBPACKAGES, EcorePackage.EPACKAGE__ESUPER_PACKAGE);
		}
		return eSubpackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getESuperPackage() {
		if (eContainerFeatureID() != QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE) return null;
		return (EPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetESuperPackage() {
		if (eContainerFeatureID() != QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE) return null;
		return (EPackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAnnotation> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<EAnnotation>(EAnnotation.class, this, QVTBasePackage.TRANSFORMATION__OWNED_TAG);
		}
		return ownedTag;
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
	 * @generated NOT
	 */
	public Function getFunction(String name) {
		if (name == null)
			return null;
		for (EOperation eOperation : getEOperations()) {
			if ((eOperation instanceof Function) && name.equals(eOperation.getName()))
				return (Function) eOperation;
		}
		Transformation extended = getExtends();
		if (extended != null)
			return extended.getFunction(name);
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypedModel getModelParameter(String name) {
		if (name == null)
			return null;
		for (TypedModel modelParameter : getModelParameter()) {
			if (name.equals(modelParameter.getName()))
				return modelParameter;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT (BY COPY from EPackageImpl)
	 */
	public EClassifier getEClassifier(String name) {
	    return getEClassifierGen(name);
	}

	/**
	 * @generated NOT (BY COPY from EPackageImpl)
	 */
	public EClassifier getEClassifierGen(String name)
	{
		if (eNameToEClassifierMap == null)
		{
			List<EClassifier> eClassifiers = getEClassifiers();
			Map<String, EClassifier> result = new HashMap<String, EClassifier>(eClassifiers.size());
			for (EClassifier eClassifier : eClassifiers)
			{
				result.put(eClassifier.getName(), eClassifier);
			}
			eNameToEClassifierMap = result;
		}

		return eNameToEClassifierMap.get(name);
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
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				if (eFactoryInstance != null)
					msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
				return basicSetEFactoryInstance((EFactory)otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEClassifiers()).basicAdd(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESubpackages()).basicAdd(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE, msgs);
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
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				return basicSetEFactoryInstance(null, msgs);
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				return ((InternalEList<?>)getEClassifiers()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				return ((InternalEList<?>)getESubpackages()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE:
				return eBasicSetContainer(null, QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE, msgs);
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE:
				return eInternalContainer().eInverseRemove(this, EcorePackage.EPACKAGE__ESUBPACKAGES, EPackage.class, msgs);
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
			case QVTBasePackage.TRANSFORMATION__NS_URI:
				return getNsURI();
			case QVTBasePackage.TRANSFORMATION__NS_PREFIX:
				return getNsPrefix();
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				return getEFactoryInstance();
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				return getEClassifiers();
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				return getESubpackages();
			case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE:
				if (resolve) return getESuperPackage();
				return basicGetESuperPackage();
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return getOwnedTag();
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case QVTBasePackage.TRANSFORMATION__RULE:
				return getRule();
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				if (resolve) return getExtends();
				return basicGetExtends();
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
			case QVTBasePackage.TRANSFORMATION__NS_URI:
				setNsURI((String)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				getEClassifiers().clear();
				getEClassifiers().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				getESubpackages().clear();
				getESubpackages().addAll((Collection<? extends EPackage>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends EAnnotation>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
				return;
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)newValue);
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
			case QVTBasePackage.TRANSFORMATION__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case QVTBasePackage.TRANSFORMATION__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)null);
				return;
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				getEClassifiers().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				getESubpackages().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				return;
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				setExtends((Transformation)null);
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
			case QVTBasePackage.TRANSFORMATION__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case QVTBasePackage.TRANSFORMATION__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				return eFactoryInstance != null;
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
				return eClassifiers != null && !eClassifiers.isEmpty();
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
				return eSubpackages != null && !eSubpackages.isEmpty();
			case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE:
				return basicGetESuperPackage() != null;
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case QVTBasePackage.TRANSFORMATION__RULE:
				return rule != null && !rule.isEmpty();
			case QVTBasePackage.TRANSFORMATION__EXTENDS:
				return extends_ != null;
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
		if (baseClass == EPackage.class) {
			switch (derivedFeatureID) {
				case QVTBasePackage.TRANSFORMATION__NS_URI: return EcorePackage.EPACKAGE__NS_URI;
				case QVTBasePackage.TRANSFORMATION__NS_PREFIX: return EcorePackage.EPACKAGE__NS_PREFIX;
				case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE: return EcorePackage.EPACKAGE__EFACTORY_INSTANCE;
				case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS: return EcorePackage.EPACKAGE__ECLASSIFIERS;
				case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES: return EcorePackage.EPACKAGE__ESUBPACKAGES;
				case QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE: return EcorePackage.EPACKAGE__ESUPER_PACKAGE;
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
		if (baseClass == EPackage.class) {
			switch (baseFeatureID) {
				case EcorePackage.EPACKAGE__NS_URI: return QVTBasePackage.TRANSFORMATION__NS_URI;
				case EcorePackage.EPACKAGE__NS_PREFIX: return QVTBasePackage.TRANSFORMATION__NS_PREFIX;
				case EcorePackage.EPACKAGE__EFACTORY_INSTANCE: return QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE;
				case EcorePackage.EPACKAGE__ECLASSIFIERS: return QVTBasePackage.TRANSFORMATION__ECLASSIFIERS;
				case EcorePackage.EPACKAGE__ESUBPACKAGES: return QVTBasePackage.TRANSFORMATION__ESUBPACKAGES;
				case EcorePackage.EPACKAGE__ESUPER_PACKAGE: return QVTBasePackage.TRANSFORMATION__ESUPER_PACKAGE;
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
		result.append(" (nsURI: ");
		result.append(nsURI);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(')');
		return result.toString();
	}

} //TransformationImpl
