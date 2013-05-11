/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Guard Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGGuardVariableImpl#getTypedModel <em>Typed Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGGuardVariableImpl extends CGParameterImpl implements CGGuardVariable {
	/**
	 * The cached value of the '{@link #getTypedModel() <em>Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedModel()
	 * @generated
	 * @ordered
	 */
	protected CGTypedModel typedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGGuardVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_GUARD_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGMapping getMapping() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING) return null;
		return (CGMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(CGMapping newMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMapping, QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(CGMapping newMapping) {
		if (newMapping != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING && newMapping != null)) {
			if (EcoreUtil.isAncestor(this, newMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES, CGMapping.class, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGTypedModel getTypedModel() {
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedModel(CGTypedModel newTypedModel) {
		CGTypedModel oldTypedModel = typedModel;
		typedModel = newTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_GUARD_VARIABLE__TYPED_MODEL, oldTypedModel, typedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMapping((CGMapping)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				return basicSetMapping(null, msgs);
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
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING__GUARD_VARIABLES, CGMapping.class, msgs);
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
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				return getMapping();
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__TYPED_MODEL:
				return getTypedModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				setMapping((CGMapping)newValue);
				return;
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__TYPED_MODEL:
				setTypedModel((CGTypedModel)newValue);
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
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				setMapping((CGMapping)null);
				return;
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__TYPED_MODEL:
				setTypedModel((CGTypedModel)null);
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
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__MAPPING:
				return getMapping() != null;
			case QVTiCGModelPackage.CG_GUARD_VARIABLE__TYPED_MODEL:
				return typedModel != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGGuardVariable(this);
	}

	@Override
	public boolean isBoxed() {
		return false;
	}

	@Override
	public boolean isNonNull() {
		return true;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isUnboxed() {
		return true;
	}
} //CGGuardVariableImpl
