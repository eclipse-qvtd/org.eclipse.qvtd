/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.domain.ids.IdManager;
import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getImportedPackage <em>Imported Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl#getExtends <em>Extends</em>}</li>
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
	protected EList<org.eclipse.ocl.examples.pivot.Package> nestedPackage;

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
	 * The cached value of the '{@link #getImportedPackage() <em>Imported Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> importedPackage;

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
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> ownedTag;

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
		return QVTbasePackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.ocl.examples.pivot.Package> getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectContainmentWithInverseEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE, PivotPackage.PACKAGE__NESTING_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getNestingPackage() {
		if (eContainerFeatureID() != QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE) return null;
		return (org.eclipse.ocl.examples.pivot.Package)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestingPackage(org.eclipse.ocl.examples.pivot.Package newNestingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestingPackage, QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingPackage(org.eclipse.ocl.examples.pivot.Package newNestingPackage) {
		if (newNestingPackage != eInternalContainer() || (eContainerFeatureID() != QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE && newNestingPackage != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newNestingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNestingPackage != null)
				msgs = ((InternalEObject)newNestingPackage).eInverseAdd(this, PivotPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			msgs = basicSetNestingPackage(newNestingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE, newNestingPackage, newNestingPackage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__NS_PREFIX, oldNsPrefix, nsPrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.ocl.examples.pivot.Package> getImportedPackage() {
		if (importedPackage == null) {
			importedPackage = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE);
		}
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentWithInverseEList<Type>(Type.class, this, QVTbasePackage.TRANSFORMATION__OWNED_TYPE, PivotPackage.TYPE__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<Annotation>(Annotation.class, this, QVTbasePackage.TRANSFORMATION__OWNED_TAG);
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
			modelParameter = new EObjectContainmentWithInverseEList<TypedModel>(TypedModel.class, this, QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER, QVTbasePackage.TYPED_MODEL__TRANSFORMATION);
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
			rule = new EObjectContainmentWithInverseEList<Rule>(Rule.class, this, QVTbasePackage.TRANSFORMATION__RULE, QVTbasePackage.RULE__TRANSFORMATION);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TRANSFORMATION__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackage()).basicAdd(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNestingPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelParameter()).basicAdd(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__RULE:
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return ((InternalEList<?>)getModelParameter()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.TRANSFORMATION__RULE:
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
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return getNestedPackage();
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				return getNestingPackage();
			case QVTbasePackage.TRANSFORMATION__NS_PREFIX:
				return getNsPrefix();
			case QVTbasePackage.TRANSFORMATION__NS_URI:
				return getNsURI();
			case QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE:
				return getImportedPackage();
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				return getOwnedType();
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return getOwnedTag();
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return getModelParameter();
			case QVTbasePackage.TRANSFORMATION__RULE:
				return getRule();
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__NS_URI:
				setNsURI((String)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				getImportedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends Annotation>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				getModelParameter().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
				return;
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case QVTbasePackage.TRANSFORMATION__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case QVTbasePackage.TRANSFORMATION__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				getModelParameter().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__RULE:
				getRule().clear();
				return;
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
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
			case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case QVTbasePackage.TRANSFORMATION__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case QVTbasePackage.TRANSFORMATION__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE:
				return importedPackage != null && !importedPackage.isEmpty();
			case QVTbasePackage.TRANSFORMATION__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case QVTbasePackage.TRANSFORMATION__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER:
				return modelParameter != null && !modelParameter.isEmpty();
			case QVTbasePackage.TRANSFORMATION__RULE:
				return rule != null && !rule.isEmpty();
			case QVTbasePackage.TRANSFORMATION__EXTENDS:
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
		if (baseClass == org.eclipse.ocl.examples.pivot.Package.class) {
			switch (derivedFeatureID) {
				case QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE: return PivotPackage.PACKAGE__NESTED_PACKAGE;
				case QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE: return PivotPackage.PACKAGE__NESTING_PACKAGE;
				case QVTbasePackage.TRANSFORMATION__NS_PREFIX: return PivotPackage.PACKAGE__NS_PREFIX;
				case QVTbasePackage.TRANSFORMATION__NS_URI: return PivotPackage.PACKAGE__NS_URI;
				case QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE: return PivotPackage.PACKAGE__IMPORTED_PACKAGE;
				case QVTbasePackage.TRANSFORMATION__OWNED_TYPE: return PivotPackage.PACKAGE__OWNED_TYPE;
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
		if (baseClass == org.eclipse.ocl.examples.pivot.Package.class) {
			switch (baseFeatureID) {
				case PivotPackage.PACKAGE__NESTED_PACKAGE: return QVTbasePackage.TRANSFORMATION__NESTED_PACKAGE;
				case PivotPackage.PACKAGE__NESTING_PACKAGE: return QVTbasePackage.TRANSFORMATION__NESTING_PACKAGE;
				case PivotPackage.PACKAGE__NS_PREFIX: return QVTbasePackage.TRANSFORMATION__NS_PREFIX;
				case PivotPackage.PACKAGE__NS_URI: return QVTbasePackage.TRANSFORMATION__NS_URI;
				case PivotPackage.PACKAGE__IMPORTED_PACKAGE: return QVTbasePackage.TRANSFORMATION__IMPORTED_PACKAGE;
				case PivotPackage.PACKAGE__OWNED_TYPE: return QVTbasePackage.TRANSFORMATION__OWNED_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	public Precedence createOwnedPrecedence() {
		// TODO Auto-generated method stub
		return null;
	}

	public Package createNestedPackage(EClass eClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Package createNestedPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Type createOwnedType(EClass eClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type createOwnedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) visitor.getAdapter(QVTbaseVisitor.class).visitTransformation(this);
	}

	public TypedModel getModelParameter(String name) {
		return PivotUtil.getNamedElement(getModelParameter(), name);
	}

	@Override
	public Package getPackage() {
		return this;
	}

	private PackageId packageId = null;
	
	public @NonNull PackageId getPackageId() {
		PackageId packageId2 = packageId;
		if (packageId2 == null) {
			synchronized (this) {
				packageId2 = packageId;
				if (packageId2 == null) {
					synchronized (this) {
						packageId = packageId2 = IdManager.INSTANCE.getPackageId(this);
					}
				}
			}
		}
		return packageId2;
	}
} //TransformationImpl
