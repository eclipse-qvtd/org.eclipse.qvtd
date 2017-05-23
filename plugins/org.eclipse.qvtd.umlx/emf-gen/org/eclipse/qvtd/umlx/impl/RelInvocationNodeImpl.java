/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Invocation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#isIsThen <em>Is Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#getOwningRelDiagram <em>Owning Rel Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#getOwnedRelInvocationEdges <em>Owned Rel Invocation Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl#getReferredRelDiagram <em>Referred Rel Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelInvocationNodeImpl extends RelNodeImpl implements RelInvocationNode {
	/**
	 * The default value of the '{@link #isIsThen() <em>Is Then</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_THEN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsThen() <em>Is Then</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThen()
	 * @generated
	 * @ordered
	 */
	protected boolean isThen = IS_THEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedRelInvocationEdges() <em>Owned Rel Invocation Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelInvocationEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<RelInvocationEdge> ownedRelInvocationEdges;

	/**
	 * The cached value of the '{@link #getReferredRelDiagram() <em>Referred Rel Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelDiagram()
	 * @generated
	 * @ordered
	 */
	protected RelDiagram referredRelDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelInvocationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_INVOCATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsThen() {
		return isThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsThen(boolean newIsThen) {
		boolean oldIsThen = isThen;
		isThen = newIsThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_NODE__IS_THEN, oldIsThen, isThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getReferredRelDiagram() {
		if (referredRelDiagram != null && referredRelDiagram.eIsProxy()) {
			InternalEObject oldReferredRelDiagram = (InternalEObject)referredRelDiagram;
			referredRelDiagram = (RelDiagram)eResolveProxy(oldReferredRelDiagram);
			if (referredRelDiagram != oldReferredRelDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM, oldReferredRelDiagram, referredRelDiagram));
			}
		}
		return referredRelDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDiagram basicGetReferredRelDiagram() {
		return referredRelDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRelDiagram(RelDiagram newReferredRelDiagram) {
		RelDiagram oldReferredRelDiagram = referredRelDiagram;
		referredRelDiagram = newReferredRelDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM, oldReferredRelDiagram, referredRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleEdges(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleEdges:
		 *   let
		 *     severity : Integer[1] = 'RelInvocationNode::CompatibleEdges'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = let
		 *           expectedNodes : Set(umlx::RelPatternNode) = referredRelDiagram.ownedRelDomainNodes.ownedRelPatternNodes->select(isRoot)
		 *           ->asSet()
		 *         in
		 *           let
		 *             actualNodes : Set(umlx::RelPatternNode) = ownedRelInvocationEdges.referredRelPatternNode->asSet()
		 *           in
		 *             let status : Boolean[1] = expectedNodes = actualNodes
		 *             in
		 *               if status = true
		 *               then true
		 *               else
		 *                 Tuple{status = status, message = 'RelInvocationNode::CompatibleEdges ' +
		 *                   expectedNodes->size()
		 *                   .toString() + '/' +
		 *                   expectedNodes->size()
		 *                   .toString()
		 *                 }
		 *               endif
		 *       in
		 *         'RelInvocationNode::CompatibleEdges'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelInvocationNode_c_c_CompatibleEdges);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelDiagram referredRelDiagram = this.getReferredRelDiagram();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<RelDomainNode> ownedRelDomainNodes = referredRelDiagram.getOwnedRelDomainNodes();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedRelDomainNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelDomainNode, ownedRelDomainNodes);
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedRelDomainNodes.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelDomainNode _1 = (RelDomainNode)ITERATOR__1.next();
					/**
					 * ownedRelPatternNodes
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<RelPatternNode> ownedRelPatternNodes = _1.getOwnedRelPatternNodes();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedRelPatternNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelPatternNode, ownedRelPatternNodes);
					//
					for (Object value : BOXED_ownedRelPatternNodes.flatten().getElements()) {
						accumulator.add(value);
					}
				}
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue select;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						select = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode _1_0 = (RelPatternNode)ITERATOR__1_0.next();
					/**
					 * isRoot
					 */
					final /*@NonInvalid*/ boolean isRoot = _1_0.isIsRoot();
					//
					if (isRoot == ValueUtil.TRUE_VALUE) {
						accumulator_0.add(_1_0);
					}
				}
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue expectedNodes = CollectionAsSetOperation.INSTANCE.evaluate(select);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<RelInvocationEdge> ownedRelInvocationEdges = this.getOwnedRelInvocationEdges();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedRelInvocationEdges = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelInvocationEdge, ownedRelInvocationEdges);
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1_1 = BOXED_ownedRelInvocationEdges.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect_0;
				while (true) {
					if (!ITERATOR__1_1.hasNext()) {
						collect_0 = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelInvocationEdge _1_1 = (RelInvocationEdge)ITERATOR__1_1.next();
					/**
					 * referredRelPatternNode
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode referredRelPatternNode = _1_1.getReferredRelPatternNode();
					//
					accumulator_1.add(referredRelPatternNode);
				}
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue actualNodes = CollectionAsSetOperation.INSTANCE.evaluate(collect_0);
				final /*@Thrown*/ boolean status = expectedNodes.equals(actualNodes);
				/*@Thrown*/ java.lang.@NonNull Object symbol_1;
				if (status) {
					symbol_1 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(expectedNodes);
					final /*@Thrown*/ java.lang.@NonNull String toString_0 = OclAnyToStringOperation.INSTANCE.evaluate(size_0);
					final /*@Thrown*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(UMLXTables.STR_RelInvocationNode_c_c_CompatibleEdges_32, toString_0);
					final /*@Thrown*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, UMLXTables.STR_quot);
					final /*@Thrown*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, toString_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(UMLXTables.TUPLid_, sum_1, status);
					symbol_1 = symbol_0;
				}
				CAUGHT_symbol_1 = symbol_1;
			}
			catch (Exception e) {
				CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelInvocationNode_c_c_CompatibleEdges, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_1, UMLXTables.INT_0).booleanValue();
			symbol_2 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getOwningRelDiagram() {
		if (eContainerFeatureID() != UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM) return null;
		return (RelDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDiagram(RelDiagram newOwningRelDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDiagram, UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDiagram(RelDiagram newOwningRelDiagram) {
		if (newOwningRelDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM && newOwningRelDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDiagram != null)
				msgs = ((InternalEObject)newOwningRelDiagram).eInverseAdd(this, UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, RelDiagram.class, msgs);
			msgs = basicSetOwningRelDiagram(newOwningRelDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM, newOwningRelDiagram, newOwningRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelInvocationEdge> getOwnedRelInvocationEdges() {
		if (ownedRelInvocationEdges == null) {
			ownedRelInvocationEdges = new EObjectContainmentWithInverseEList<RelInvocationEdge>(RelInvocationEdge.class, this, UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES, UMLXPackage.REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE);
		}
		return ownedRelInvocationEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				return isIsThen();
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				return getOwningRelDiagram();
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				return getOwnedRelInvocationEdges();
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM:
				if (resolve) return getReferredRelDiagram();
				return basicGetReferredRelDiagram();
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				setIsThen((Boolean)newValue);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				setOwningRelDiagram((RelDiagram)newValue);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				getOwnedRelInvocationEdges().clear();
				getOwnedRelInvocationEdges().addAll((Collection<? extends RelInvocationEdge>)newValue);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM:
				setReferredRelDiagram((RelDiagram)newValue);
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				setIsThen(IS_THEN_EDEFAULT);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				setOwningRelDiagram((RelDiagram)null);
				return;
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				getOwnedRelInvocationEdges().clear();
				return;
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM:
				setReferredRelDiagram((RelDiagram)null);
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
			case UMLXPackage.REL_INVOCATION_NODE__IS_THEN:
				return isThen != IS_THEN_EDEFAULT;
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				return getOwningRelDiagram() != null;
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				return ownedRelInvocationEdges != null && !ownedRelInvocationEdges.isEmpty();
			case UMLXPackage.REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM:
				return referredRelDiagram != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelInvocationNode(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDiagram((RelDiagram)otherEnd, msgs);
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelInvocationEdges()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				return basicSetOwningRelDiagram(null, msgs);
			case UMLXPackage.REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES:
				return ((InternalEList<?>)getOwnedRelInvocationEdges()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, RelDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelInvocationNodeImpl
