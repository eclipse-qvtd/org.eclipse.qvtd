/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Collection;

import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;
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
			ownedTxPartNodes = new EObjectContainmentWithInverseEList<TxPartNode>(TxPartNode.class, this, UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES, UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE);
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
		if (eContainerFeatureID() != UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM, newOwningTxDiagram, newOwningTxDiagram));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS, oldReferredEClass, referredEClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS, oldReferredEClass, referredEClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePartsAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
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
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxKeyNode_c_c_PartsAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<TxPartNode> ownedTxPartNodes = this.getOwnedTxPartNodes();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedTxPartNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxPartNode, ownedTxPartNodes);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxPartNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxPartNodes.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull TxPartNode _1 = (TxPartNode)ITERATOR__1.next();
					/**
					 * referredEStructuralFeature
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EStructuralFeature referredEStructuralFeature = _1.getReferredEStructuralFeature();
					//
					if (accumulator.includes(referredEStructuralFeature) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(referredEStructuralFeature);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxKeyNode_c_c_PartsAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxPartNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				return ((InternalEList<?>)getOwnedTxPartNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES, TxDiagram.class, msgs);
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				return getOwnedTxPartNodes();
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram();
			case UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS:
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				getOwnedTxPartNodes().clear();
				getOwnedTxPartNodes().addAll((Collection<? extends TxPartNode>)newValue);
				return;
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)newValue);
				return;
			case UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS:
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				getOwnedTxPartNodes().clear();
				return;
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)null);
				return;
			case UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS:
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
			case UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES:
				return ownedTxPartNodes != null && !ownedTxPartNodes.isEmpty();
			case UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram() != null;
			case UMLXPackage.TX_KEY_NODE__REFERRED_ECLASS:
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
