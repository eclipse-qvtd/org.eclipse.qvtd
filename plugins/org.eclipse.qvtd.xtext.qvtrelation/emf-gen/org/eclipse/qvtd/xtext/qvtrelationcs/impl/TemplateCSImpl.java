/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.TemplateCSImpl#getOwnedGuardExpression <em>Owned Guard Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TemplateCSImpl extends ExpCSImpl implements TemplateCS {
	/**
	 * The number of structural features of the '<em>Template CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_CS_FEATURE_COUNT = ExpCSImpl.EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedType;

	/**
	 * The cached value of the '{@link #getOwnedGuardExpression() <em>Owned Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedGuardExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 0, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedRefCS getOwnedType() {
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs) {
		TypedRefCS oldOwnedType = ownedType;
		ownedType = newOwnedType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 1, oldOwnedType, newOwnedType);
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
	public void setOwnedType(TypedRefCS newOwnedType) {
		if (newOwnedType != ownedType) {
			NotificationChain msgs = null;
			if (ownedType != null)
				msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 1, newOwnedType, newOwnedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedGuardExpression() {
		return ownedGuardExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedGuardExpression(ExpCS newOwnedGuardExpression, NotificationChain msgs) {
		ExpCS oldOwnedGuardExpression = ownedGuardExpression;
		ownedGuardExpression = newOwnedGuardExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 2, oldOwnedGuardExpression, newOwnedGuardExpression);
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
	public void setOwnedGuardExpression(ExpCS newOwnedGuardExpression) {
		if (newOwnedGuardExpression != ownedGuardExpression) {
			NotificationChain msgs = null;
			if (ownedGuardExpression != null)
				msgs = ((InternalEObject)ownedGuardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedGuardExpression != null)
				msgs = ((InternalEObject)newOwnedGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedGuardExpression(newOwnedGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 2, newOwnedGuardExpression, newOwnedGuardExpression));
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return basicSetOwnedType(null, msgs);
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				return basicSetOwnedGuardExpression(null, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return getName();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return getOwnedType();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				return getOwnedGuardExpression();
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setName((String)newValue);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				setOwnedType((TypedRefCS)newValue);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				setOwnedGuardExpression((ExpCS)newValue);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setName(NAME_EDEFAULT);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				setOwnedType((TypedRefCS)null);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				setOwnedGuardExpression((ExpCS)null);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return ownedType != null;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				return ownedGuardExpression != null;
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
		if (baseClass == NamedElementCS.class) {
			switch (derivedFeatureID) {
				case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0: return 5;
				default: return -1;
			}
		}
		if (baseClass == TemplateVariableCS.class) {
			switch (derivedFeatureID) {
				case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1: return NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;
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
		if (baseClass == NamedElementCS.class) {
			switch (baseFeatureID) {
				case 5: return ExpCSImpl.EXP_CS_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == TemplateVariableCS.class) {
			switch (baseFeatureID) {
				case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0: return ExpCSImpl.EXP_CS_FEATURE_COUNT + 1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
} //TemplateCSImpl
