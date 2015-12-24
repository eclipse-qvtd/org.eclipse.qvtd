/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getCheckedProperties <em>Checked Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getEnforcedProperties <em>Enforced Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getMappingStatement <em>Mapping Statement</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getPolledClasses <em>Polled Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends RuleImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getGuardPattern() <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPattern guardPattern;

	/**
	 * The cached value of the '{@link #getBottomPattern() <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPattern bottomPattern;

	/**
	 * The cached value of the '{@link #getCheckedProperties() <em>Checked Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> checkedProperties;

	/**
	 * The cached value of the '{@link #getEnforcedProperties() <em>Enforced Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> enforcedProperties;

	/**
	 * The cached value of the '{@link #getMappingStatement() <em>Mapping Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingStatement()
	 * @generated
	 * @ordered
	 */
	protected MappingStatement mappingStatement;

	/**
	 * The cached value of the '{@link #getPolledClasses() <em>Polled Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolledClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Class> polledClasses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardPattern getGuardPattern() {
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardPattern(GuardPattern newGuardPattern, NotificationChain msgs) {
		GuardPattern oldGuardPattern = guardPattern;
		guardPattern = newGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__GUARD_PATTERN, oldGuardPattern, newGuardPattern);
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
	public void setGuardPattern(GuardPattern newGuardPattern) {
		if (newGuardPattern != guardPattern) {
			NotificationChain msgs = null;
			if (guardPattern != null)
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, QVTcoreBasePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, QVTcoreBasePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__GUARD_PATTERN, newGuardPattern, newGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottomPattern getBottomPattern() {
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPattern newBottomPattern, NotificationChain msgs) {
		BottomPattern oldBottomPattern = bottomPattern;
		bottomPattern = newBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__BOTTOM_PATTERN, oldBottomPattern, newBottomPattern);
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
	public void setBottomPattern(BottomPattern newBottomPattern) {
		if (newBottomPattern != bottomPattern) {
			NotificationChain msgs = null;
			if (bottomPattern != null)
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, QVTcoreBasePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, QVTcoreBasePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getCheckedProperties() {
		if (checkedProperties == null) {
			checkedProperties = new EObjectResolvingEList<Property>(Property.class, this, QVTimperativePackage.MAPPING__CHECKED_PROPERTIES);
		}
		return checkedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getEnforcedProperties() {
		if (enforcedProperties == null) {
			enforcedProperties = new EObjectResolvingEList<Property>(Property.class, this, QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES);
		}
		return enforcedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingStatement getMappingStatement() {
		return mappingStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingStatement(MappingStatement newMappingStatement, NotificationChain msgs) {
		MappingStatement oldMappingStatement = mappingStatement;
		mappingStatement = newMappingStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__MAPPING_STATEMENT, oldMappingStatement, newMappingStatement);
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
	public void setMappingStatement(MappingStatement newMappingStatement) {
		if (newMappingStatement != mappingStatement) {
			NotificationChain msgs = null;
			if (mappingStatement != null)
				msgs = ((InternalEObject)mappingStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING__MAPPING_STATEMENT, null, msgs);
			if (newMappingStatement != null)
				msgs = ((InternalEObject)newMappingStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING__MAPPING_STATEMENT, null, msgs);
			msgs = basicSetMappingStatement(newMappingStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__MAPPING_STATEMENT, newMappingStatement, newMappingStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.ocl.pivot.Class> getPolledClasses() {
		if (polledClasses == null) {
			polledClasses = new EObjectResolvingEList<org.eclipse.ocl.pivot.Class>(org.eclipse.ocl.pivot.Class.class, this, QVTimperativePackage.MAPPING__POLLED_CLASSES);
		}
		return polledClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getAllMappings() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getAllVariables() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				if (guardPattern != null)
					msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING__GUARD_PATTERN, null, msgs);
				return basicSetGuardPattern((GuardPattern)otherEnd, msgs);
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				if (bottomPattern != null)
					msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING__BOTTOM_PATTERN, null, msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				return basicSetGuardPattern(null, msgs);
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				return basicSetBottomPattern(null, msgs);
			case QVTimperativePackage.MAPPING__MAPPING_STATEMENT:
				return basicSetMappingStatement(null, msgs);
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
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				return getGuardPattern();
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				return getBottomPattern();
			case QVTimperativePackage.MAPPING__CHECKED_PROPERTIES:
				return getCheckedProperties();
			case QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES:
				return getEnforcedProperties();
			case QVTimperativePackage.MAPPING__MAPPING_STATEMENT:
				return getMappingStatement();
			case QVTimperativePackage.MAPPING__POLLED_CLASSES:
				return getPolledClasses();
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
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)newValue);
				return;
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)newValue);
				return;
			case QVTimperativePackage.MAPPING__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				getCheckedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES:
				getEnforcedProperties().clear();
				getEnforcedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTimperativePackage.MAPPING__MAPPING_STATEMENT:
				setMappingStatement((MappingStatement)newValue);
				return;
			case QVTimperativePackage.MAPPING__POLLED_CLASSES:
				getPolledClasses().clear();
				getPolledClasses().addAll((Collection<? extends org.eclipse.ocl.pivot.Class>)newValue);
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
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				setGuardPattern((GuardPattern)null);
				return;
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)null);
				return;
			case QVTimperativePackage.MAPPING__CHECKED_PROPERTIES:
				getCheckedProperties().clear();
				return;
			case QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES:
				getEnforcedProperties().clear();
				return;
			case QVTimperativePackage.MAPPING__MAPPING_STATEMENT:
				setMappingStatement((MappingStatement)null);
				return;
			case QVTimperativePackage.MAPPING__POLLED_CLASSES:
				getPolledClasses().clear();
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
			case QVTimperativePackage.MAPPING__GUARD_PATTERN:
				return guardPattern != null;
			case QVTimperativePackage.MAPPING__BOTTOM_PATTERN:
				return bottomPattern != null;
			case QVTimperativePackage.MAPPING__CHECKED_PROPERTIES:
				return checkedProperties != null && !checkedProperties.isEmpty();
			case QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES:
				return enforcedProperties != null && !enforcedProperties.isEmpty();
			case QVTimperativePackage.MAPPING__MAPPING_STATEMENT:
				return mappingStatement != null;
			case QVTimperativePackage.MAPPING__POLLED_CLASSES:
				return polledClasses != null && !polledClasses.isEmpty();
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
		if (baseClass == Area.class) {
			switch (derivedFeatureID) {
				case QVTimperativePackage.MAPPING__GUARD_PATTERN: return QVTcoreBasePackage.AREA__GUARD_PATTERN;
				case QVTimperativePackage.MAPPING__BOTTOM_PATTERN: return QVTcoreBasePackage.AREA__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		if (baseClass == ImperativeArea.class) {
			switch (derivedFeatureID) {
				case QVTimperativePackage.MAPPING__CHECKED_PROPERTIES: return QVTimperativePackage.IMPERATIVE_AREA__CHECKED_PROPERTIES;
				case QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES: return QVTimperativePackage.IMPERATIVE_AREA__ENFORCED_PROPERTIES;
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
		if (baseClass == Area.class) {
			switch (baseFeatureID) {
				case QVTcoreBasePackage.AREA__GUARD_PATTERN: return QVTimperativePackage.MAPPING__GUARD_PATTERN;
				case QVTcoreBasePackage.AREA__BOTTOM_PATTERN: return QVTimperativePackage.MAPPING__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		if (baseClass == ImperativeArea.class) {
			switch (baseFeatureID) {
				case QVTimperativePackage.IMPERATIVE_AREA__CHECKED_PROPERTIES: return QVTimperativePackage.MAPPING__CHECKED_PROPERTIES;
				case QVTimperativePackage.IMPERATIVE_AREA__ENFORCED_PROPERTIES: return QVTimperativePackage.MAPPING__ENFORCED_PROPERTIES;
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
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMapping(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AbstractMapping getContext() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private static EList<AbstractMapping> NO_MAPPINGS = new BasicEList<AbstractMapping>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<AbstractMapping> getRefinement() {
		return NO_MAPPINGS;
	}
} //MappingImpl
