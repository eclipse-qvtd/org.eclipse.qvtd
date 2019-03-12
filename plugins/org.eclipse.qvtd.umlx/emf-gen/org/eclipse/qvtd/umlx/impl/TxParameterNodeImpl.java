/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.umlx.TxParameterNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.UMLXTypedElement;

import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Parameter Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#getReferredEClassifier <em>Referred EClassifier</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl#getOwningTxQueryNode <em>Owning Tx Query Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxParameterNodeImpl extends TxNodeImpl implements TxParameterNode {
	/**
	 * The number of structural features of the '<em>Tx Parameter Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PARAMETER_NODE_FEATURE_COUNT = TxNodeImpl.TX_NODE_FEATURE_COUNT + 8;

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
	 * The default value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected boolean isMany = IS_MANY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFree = IS_NULL_FREE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean isRequired = IS_REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredEClassifier() <em>Referred EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEClassifier()
	 * @generated
	 * @ordered
	 */
	protected EClassifier referredEClassifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxParameterNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_PARAMETER_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 0, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsMany() {
		return isMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsMany(boolean newIsMany) {
		boolean oldIsMany = isMany;
		isMany = newIsMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1, oldIsMany, isMany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNullFree() {
		return isNullFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree) {
		boolean oldIsNullFree = isNullFree;
		isNullFree = newIsNullFree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 2, oldIsNullFree, isNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 3, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRequired() {
		return isRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRequired(boolean newIsRequired) {
		boolean oldIsRequired = isRequired;
		isRequired = newIsRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 4, oldIsRequired, isRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 5, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassifier getReferredEClassifier() {
		if (referredEClassifier != null && referredEClassifier.eIsProxy()) {
			InternalEObject oldReferredEClassifier = (InternalEObject)referredEClassifier;
			referredEClassifier = (EClassifier)eResolveProxy(oldReferredEClassifier);
			if (referredEClassifier != oldReferredEClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TxNodeImpl.TX_NODE_FEATURE_COUNT + 6, oldReferredEClassifier, referredEClassifier));
			}
		}
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetReferredEClassifier() {
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEClassifier(EClassifier newReferredEClassifier) {
		EClassifier oldReferredEClassifier = referredEClassifier;
		referredEClassifier = newReferredEClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 6, oldReferredEClassifier, referredEClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxQueryNode getOwningTxQueryNode() {
		if (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 7)) return null;
		return (TxQueryNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxQueryNode(TxQueryNode newOwningTxQueryNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxQueryNode, TxNodeImpl.TX_NODE_FEATURE_COUNT + 7, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxQueryNode(TxQueryNode newOwningTxQueryNode) {
		if (newOwningTxQueryNode != eInternalContainer() || (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 7) && newOwningTxQueryNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxQueryNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxQueryNode != null)
				msgs = ((InternalEObject)newOwningTxQueryNode).eInverseAdd(this, TxNodeImpl.TX_NODE_FEATURE_COUNT + 8, TxQueryNode.class, msgs);
			msgs = basicSetOwningTxQueryNode(newOwningTxQueryNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 7, newOwningTxQueryNode, newOwningTxQueryNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv NameIsRequired:
			 *   let severity : Integer[1] = 'TxParameterNode::NameIsRequired'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = name <> null
			 *       in
			 *         'TxParameterNode::NameIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxParameterNode_c_c_NameIsRequired);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable String name = this.getName();
				final /*@NonInvalid*/ boolean result = name != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxParameterNode_c_c_NameIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxParameterNode::NameIsRequired", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTypeIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv TypeIsRequired:
			 *   let severity : Integer[1] = 'TxParameterNode::TypeIsRequired'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = referredEClassifier <> null
			 *       in
			 *         'TxParameterNode::TypeIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxParameterNode_c_c_TypeIsRequired);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = this.getReferredEClassifier();
				final /*@NonInvalid*/ boolean result = referredEClassifier != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxParameterNode_c_c_TypeIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxParameterNode::TypeIsRequired", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", isMany: ");
		result.append(isMany);
		result.append(", isNullFree: ");
		result.append(isNullFree);
		result.append(", isOrdered: ");
		result.append(isOrdered);
		result.append(", isRequired: ");
		result.append(isRequired);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxQueryNode((TxQueryNode)otherEnd, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				return basicSetOwningTxQueryNode(null, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				return eInternalContainer().eInverseRemove(this, TxNodeImpl.TX_NODE_FEATURE_COUNT + 8, TxQueryNode.class, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return getName();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return isIsMany();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				return isIsNullFree();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 3:
				return isIsOrdered();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 4:
				return isIsRequired();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 5:
				return isIsUnique();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 6:
				if (resolve) return getReferredEClassifier();
				return basicGetReferredEClassifier();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				return getOwningTxQueryNode();
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				setName((String)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setIsMany((Boolean)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setIsNullFree((Boolean)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 3:
				setIsOrdered((Boolean)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 4:
				setIsRequired((Boolean)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 5:
				setIsUnique((Boolean)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 6:
				setReferredEClassifier((EClassifier)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				setOwningTxQueryNode((TxQueryNode)newValue);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				setName(NAME_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setIsMany(IS_MANY_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 3:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 4:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 5:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 6:
				setReferredEClassifier((EClassifier)null);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				setOwningTxQueryNode((TxQueryNode)null);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return isMany != IS_MANY_EDEFAULT;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				return isNullFree != IS_NULL_FREE_EDEFAULT;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 3:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 4:
				return isRequired != IS_REQUIRED_EDEFAULT;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 5:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 6:
				return referredEClassifier != null;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 7:
				return getOwningTxQueryNode() != null;
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
		if (baseClass == UMLXNamedElement.class) {
			switch (derivedFeatureID) {
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0: return UMLXElementImpl.UMLX_ELEMENT_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (derivedFeatureID) {
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0;
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1;
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 3: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2;
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 4: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3;
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 5: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4;
				case TxNodeImpl.TX_NODE_FEATURE_COUNT + 6: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5;
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
		if (baseClass == UMLXNamedElement.class) {
			switch (baseFeatureID) {
				case UMLXElementImpl.UMLX_ELEMENT_FEATURE_COUNT + 0: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (baseFeatureID) {
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 1;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 2;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 3;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 4;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 5;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5: return TxNodeImpl.TX_NODE_FEATURE_COUNT + 6;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxParameterNode(this);
	}

} //TxParameterNodeImpl
