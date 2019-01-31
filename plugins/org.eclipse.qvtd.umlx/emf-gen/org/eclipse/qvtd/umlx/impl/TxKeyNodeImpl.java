/**
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Key Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getOwnedTxPartNodes <em>Owned Tx Part Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getReferredEClass <em>Referred EClass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxKeyNodeImpl extends TxNodeImpl implements TxKeyNode {
	/**
	 * The number of structural features of the '<em>Tx Key Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_KEY_NODE_FEATURE_COUNT = TxNodeImpl.TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getOwnedTxPartNodes() <em>Owned Tx Part Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxPartNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxPartNode> ownedTxPartNodes;

	/**
	 * The cached value of the '{@link #getReferredEClass() <em>Referred EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass referredEClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxKeyNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_KEY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxPartNode> getOwnedTxPartNodes() {
		if (ownedTxPartNodes == null) {
			ownedTxPartNodes = new EObjectContainmentWithInverseEList<TxPartNode>(TxPartNode.class, this, TxNodeImpl.TX_NODE_FEATURE_COUNT + 0, TxNodeImpl.TX_NODE_FEATURE_COUNT + 0);
		}
		return ownedTxPartNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getOwningTxDiagram() {
		if (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 1)) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != (TxNodeImpl.TX_NODE_FEATURE_COUNT + 1) && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1, newOwningTxDiagram, newOwningTxDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReferredEClass() {
		if (referredEClass != null && referredEClass.eIsProxy()) {
			InternalEObject oldReferredEClass = (InternalEObject)referredEClass;
			referredEClass = (EClass)eResolveProxy(oldReferredEClass);
			if (referredEClass != oldReferredEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TxNodeImpl.TX_NODE_FEATURE_COUNT + 2, oldReferredEClass, referredEClass));
			}
		}
		return referredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetReferredEClass() {
		return referredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEClass(EClass newReferredEClass) {
		EClass oldReferredEClass = referredEClass;
		referredEClass = newReferredEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TxNodeImpl.TX_NODE_FEATURE_COUNT + 2, oldReferredEClass, referredEClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePartsAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv PartsAreUnique:
			 *   let severity : Integer[1] = 'TxKeyNode::PartsAreUnique'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = ownedTxPartNodes->isUnique(referredEStructuralFeature)
			 *       in
			 *         'TxKeyNode::PartsAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxKeyNode_c_c_PartsAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<TxPartNode> ownedTxPartNodes = this.getOwnedTxPartNodes();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedTxPartNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxPartNode, ownedTxPartNodes);
				/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxPartNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxPartNodes.iterator();
				/*@NonInvalid*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull TxPartNode _1 = (@NonNull TxPartNode)ITERATOR__1.next();
					/**
					 * referredEStructuralFeature
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull EStructuralFeature referredEStructuralFeature = _1.getReferredEStructuralFeature();
					//
					if (accumulator.includes(referredEStructuralFeature) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(referredEStructuralFeature);
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxKeyNode_c_c_PartsAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxKeyNode::PartsAreUnique", this, diagnostics, context, e);
		}
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxPartNodes()).basicAdd(otherEnd, msgs);
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxDiagram((TxDiagram)otherEnd, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedTxPartNodes()).basicRemove(otherEnd, msgs);
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return basicSetOwningTxDiagram(null, msgs);
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1, TxDiagram.class, msgs);
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
				return getOwnedTxPartNodes();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return getOwningTxDiagram();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				if (resolve) return getReferredEClass();
				return basicGetReferredEClass();
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
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 0:
				getOwnedTxPartNodes().clear();
				getOwnedTxPartNodes().addAll((Collection<? extends TxPartNode>)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setOwningTxDiagram((TxDiagram)newValue);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setReferredEClass((EClass)newValue);
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
				getOwnedTxPartNodes().clear();
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				setOwningTxDiagram((TxDiagram)null);
				return;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				setReferredEClass((EClass)null);
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
				return ownedTxPartNodes != null && !ownedTxPartNodes.isEmpty();
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 1:
				return getOwningTxDiagram() != null;
			case TxNodeImpl.TX_NODE_FEATURE_COUNT + 2:
				return referredEClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxKeyNode(this);
	}

} //TxKeyNodeImpl
