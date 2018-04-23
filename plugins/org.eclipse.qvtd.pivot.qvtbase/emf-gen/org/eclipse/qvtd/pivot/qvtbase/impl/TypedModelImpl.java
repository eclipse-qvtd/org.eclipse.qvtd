/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getUsedPackage <em>Used Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getOwnedContext <em>Owned Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#isIsPrimitive <em>Is Primitive</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#isIsTrace <em>Is Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedModelImpl extends NamedElementImpl implements TypedModel {
	/**
	 * The cached value of the '{@link #getUsedPackage() <em>Used Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> usedPackage;

	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> dependsOn;

	/**
	 * The cached value of the '{@link #getOwnedContext() <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContext()
	 * @generated
	 * @ordered
	 */
	protected Variable ownedContext;

	/**
	 * The default value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRIMITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected boolean isPrimitive = IS_PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTrace() <em>Is Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTrace() <em>Is Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean isTrace = IS_TRACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.TYPED_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getTransformation() {
		if (eContainerFeatureID() != QVTbasePackage.TYPED_MODEL__TRANSFORMATION) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QVTbasePackage.TYPED_MODEL__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != QVTbasePackage.TYPED_MODEL__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TYPED_MODEL__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<org.eclipse.ocl.pivot.Package> getUsedPackage() {
		if (usedPackage == null) {
			usedPackage = new EObjectResolvingEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, QVTbasePackage.TYPED_MODEL__USED_PACKAGE);
		}
		return usedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<TypedModel> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, QVTbasePackage.TYPED_MODEL__DEPENDS_ON);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getOwnedContext() {
		return ownedContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContext(Variable newOwnedContext, NotificationChain msgs) {
		Variable oldOwnedContext = ownedContext;
		ownedContext = newOwnedContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT, oldOwnedContext, newOwnedContext);
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
	public void setOwnedContext(Variable newOwnedContext) {
		if (newOwnedContext != ownedContext) {
			NotificationChain msgs = null;
			if (ownedContext != null)
				msgs = ((InternalEObject)ownedContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT, null, msgs);
			if (newOwnedContext != null)
				msgs = ((InternalEObject)newOwnedContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT, null, msgs);
			msgs = basicSetOwnedContext(newOwnedContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT, newOwnedContext, newOwnedContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPrimitive() {
		return isPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPrimitive(boolean newIsPrimitive) {
		boolean oldIsPrimitive = isPrimitive;
		isPrimitive = newIsPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TYPED_MODEL__IS_PRIMITIVE, oldIsPrimitive, isPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTrace() {
		return isTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTrace(boolean newIsTrace) {
		boolean oldIsTrace = isTrace;
		isTrace = newIsTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.TYPED_MODEL__IS_TRACE, oldIsTrace, isTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
			case QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT:
				return basicSetOwnedContext(null, msgs);
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER, Transformation.class, msgs);
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				return getTransformation();
			case QVTbasePackage.TYPED_MODEL__USED_PACKAGE:
				return getUsedPackage();
			case QVTbasePackage.TYPED_MODEL__DEPENDS_ON:
				return getDependsOn();
			case QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT:
				return getOwnedContext();
			case QVTbasePackage.TYPED_MODEL__IS_PRIMITIVE:
				return isIsPrimitive();
			case QVTbasePackage.TYPED_MODEL__IS_TRACE:
				return isIsTrace();
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				setTransformation((Transformation)newValue);
				return;
			case QVTbasePackage.TYPED_MODEL__USED_PACKAGE:
				getUsedPackage().clear();
				getUsedPackage().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case QVTbasePackage.TYPED_MODEL__DEPENDS_ON:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT:
				setOwnedContext((Variable)newValue);
				return;
			case QVTbasePackage.TYPED_MODEL__IS_PRIMITIVE:
				setIsPrimitive((Boolean)newValue);
				return;
			case QVTbasePackage.TYPED_MODEL__IS_TRACE:
				setIsTrace((Boolean)newValue);
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				setTransformation((Transformation)null);
				return;
			case QVTbasePackage.TYPED_MODEL__USED_PACKAGE:
				getUsedPackage().clear();
				return;
			case QVTbasePackage.TYPED_MODEL__DEPENDS_ON:
				getDependsOn().clear();
				return;
			case QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT:
				setOwnedContext((Variable)null);
				return;
			case QVTbasePackage.TYPED_MODEL__IS_PRIMITIVE:
				setIsPrimitive(IS_PRIMITIVE_EDEFAULT);
				return;
			case QVTbasePackage.TYPED_MODEL__IS_TRACE:
				setIsTrace(IS_TRACE_EDEFAULT);
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
			case QVTbasePackage.TYPED_MODEL__TRANSFORMATION:
				return getTransformation() != null;
			case QVTbasePackage.TYPED_MODEL__USED_PACKAGE:
				return usedPackage != null && !usedPackage.isEmpty();
			case QVTbasePackage.TYPED_MODEL__DEPENDS_ON:
				return dependsOn != null && !dependsOn.isEmpty();
			case QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT:
				return ownedContext != null;
			case QVTbasePackage.TYPED_MODEL__IS_PRIMITIVE:
				return isPrimitive != IS_PRIMITIVE_EDEFAULT;
			case QVTbasePackage.TYPED_MODEL__IS_TRACE:
				return isTrace != IS_TRACE_EDEFAULT;
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTbaseVisitor<?>)visitor).visitTypedModel(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //TypedModelImpl
