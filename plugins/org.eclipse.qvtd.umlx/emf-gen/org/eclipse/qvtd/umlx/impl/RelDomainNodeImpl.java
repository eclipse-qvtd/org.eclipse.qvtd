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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Domain Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwnedRelPatternEdges <em>Owned Rel Pattern Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwnedRelPatternNodes <em>Owned Rel Pattern Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwningRelDiagram <em>Owning Rel Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getReferredTxTypedModelNode <em>Referred Tx Typed Model Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDomainNodeImpl extends RelNodeImpl implements RelDomainNode {
	/**
	 * The cached value of the '{@link #getOwnedRelPatternEdges() <em>Owned Rel Pattern Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelPatternEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternEdge> ownedRelPatternEdges;

	/**
	 * The cached value of the '{@link #getOwnedRelPatternNodes() <em>Owned Rel Pattern Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelPatternNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternNode> ownedRelPatternNodes;

	/**
	 * The cached value of the '{@link #getReferredTxTypedModelNode() <em>Referred Tx Typed Model Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTxTypedModelNode()
	 * @generated
	 * @ordered
	 */
	protected TxTypedModelNode referredTxTypedModelNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelDomainNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_DOMAIN_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getOwnedRelPatternEdges() {
		if (ownedRelPatternEdges == null) {
			ownedRelPatternEdges = new EObjectContainmentWithInverseEList<RelPatternEdge>(RelPatternEdge.class, this, UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES, UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE);
		}
		return ownedRelPatternEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternNode> getOwnedRelPatternNodes() {
		if (ownedRelPatternNodes == null) {
			ownedRelPatternNodes = new EObjectContainmentWithInverseEList<RelPatternNode>(RelPatternNode.class, this, UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES, UMLXPackage.REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE);
		}
		return ownedRelPatternNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getOwningRelDiagram() {
		if (eContainerFeatureID() != UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM) return null;
		return (RelDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDiagram(RelDiagram newOwningRelDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDiagram, UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDiagram(RelDiagram newOwningRelDiagram) {
		if (newOwningRelDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM && newOwningRelDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDiagram != null)
				msgs = ((InternalEObject)newOwningRelDiagram).eInverseAdd(this, UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, RelDiagram.class, msgs);
			msgs = basicSetOwningRelDiagram(newOwningRelDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM, newOwningRelDiagram, newOwningRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxTypedModelNode getReferredTxTypedModelNode() {
		if (referredTxTypedModelNode != null && referredTxTypedModelNode.eIsProxy()) {
			InternalEObject oldReferredTxTypedModelNode = (InternalEObject)referredTxTypedModelNode;
			referredTxTypedModelNode = (TxTypedModelNode)eResolveProxy(oldReferredTxTypedModelNode);
			if (referredTxTypedModelNode != oldReferredTxTypedModelNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE, oldReferredTxTypedModelNode, referredTxTypedModelNode));
			}
		}
		return referredTxTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTypedModelNode basicGetReferredTxTypedModelNode() {
		return referredTxTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTxTypedModelNode(TxTypedModelNode newReferredTxTypedModelNode) {
		TxTypedModelNode oldReferredTxTypedModelNode = referredTxTypedModelNode;
		referredTxTypedModelNode = newReferredTxTypedModelNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE, oldReferredTxTypedModelNode, referredTxTypedModelNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean PrimitiveDomainHasNoClassNodes(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv PrimitiveDomainHasNoClassNodes:
		 *   let
		 *     severity : Integer[1] = 'RelDomainNode::PrimitiveDomainHasNoClassNodes'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredTxTypedModelNode = null implies
		 *         ownedRelPatternNodes->selectByKind(RelPatternClassNode)
		 *         ->forAll(
		 *           not referredEClassifier.oclIsKindOf(ecore::EClass))
		 *       in
		 *         'RelDomainNode::PrimitiveDomainHasNoClassNodes'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelDomainNode_c_c_PrimitiveDomainHasNoClassNodes);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@Nullable TxTypedModelNode referredTxTypedModelNode = this.getReferredTxTypedModelNode();
				final /*@NonInvalid*/ boolean eq = referredTxTypedModelNode == null;
				/*@Thrown*/ java.lang.@Nullable Boolean result;
				if (eq) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<RelPatternNode> ownedRelPatternNodes = this.getOwnedRelPatternNodes();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedRelPatternNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelPatternNode, ownedRelPatternNodes);
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedRelPatternNodes, TYP_umlx_c_c_RelPatternClassNode_0);
					/*@Thrown*/ java.lang.@Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR__1 = selectByKind.iterator();
					/*@Thrown*/ java.lang.@Nullable Boolean forAll;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							if (accumulator == null) {
								forAll = null;
							}
							else if (accumulator == ValueUtil.TRUE_VALUE) {
								forAll = ValueUtil.TRUE_VALUE;
							}
							else {
								throw (InvalidValueException)accumulator;
							}
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternClassNode _1 = (RelPatternClassNode)ITERATOR__1.next();
						/**
						 * not referredEClassifier.oclIsKindOf(ecore::EClass)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EClassifier referredEClassifier = _1.getReferredEClassifier();
						final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass).booleanValue();
						final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(oclIsKindOf);
						//
						if (not == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							forAll = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (not == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (not == null) {								// Abnormal null body evaluation result
							if (accumulator == ValueUtil.TRUE_VALUE) {
								accumulator = null;										// Cache a null failure
							}
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
						}
					}
					result = forAll;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelDomainNode_c_c_PrimitiveDomainHasNoClassNodes, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelPatternEdges()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelPatternNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDiagram((RelDiagram)otherEnd, msgs);
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				return ((InternalEList<?>)getOwnedRelPatternEdges()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				return ((InternalEList<?>)getOwnedRelPatternNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				return basicSetOwningRelDiagram(null, msgs);
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, RelDiagram.class, msgs);
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				return getOwnedRelPatternEdges();
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				return getOwnedRelPatternNodes();
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				return getOwningRelDiagram();
			case UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE:
				if (resolve) return getReferredTxTypedModelNode();
				return basicGetReferredTxTypedModelNode();
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				getOwnedRelPatternEdges().clear();
				getOwnedRelPatternEdges().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				getOwnedRelPatternNodes().clear();
				getOwnedRelPatternNodes().addAll((Collection<? extends RelPatternNode>)newValue);
				return;
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				setOwningRelDiagram((RelDiagram)newValue);
				return;
			case UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE:
				setReferredTxTypedModelNode((TxTypedModelNode)newValue);
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				getOwnedRelPatternEdges().clear();
				return;
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				getOwnedRelPatternNodes().clear();
				return;
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				setOwningRelDiagram((RelDiagram)null);
				return;
			case UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE:
				setReferredTxTypedModelNode((TxTypedModelNode)null);
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
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES:
				return ownedRelPatternEdges != null && !ownedRelPatternEdges.isEmpty();
			case UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES:
				return ownedRelPatternNodes != null && !ownedRelPatternNodes.isEmpty();
			case UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM:
				return getOwningRelDiagram() != null;
			case UMLXPackage.REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE:
				return referredTxTypedModelNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelDomainNode(this);
	}

} //RelDomainNodeImpl
