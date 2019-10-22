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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyToStringOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
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
	 * The number of structural features of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE_FEATURE_COUNT = RelNodeImpl.REL_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE_OPERATION_COUNT = RelNodeImpl.REL_NODE_OPERATION_COUNT + 1;

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
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldIsThen, isThen));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 4, oldReferredRelDiagram, referredRelDiagram));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldReferredRelDiagram, referredRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleEdges(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelInvocationNode::CompatibleEdges";
		try {
			/**
			 *
			 * inv CompatibleEdges:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_severity_0;
			try {
				final /*@Thrown*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_INVOCATION_NODE___VALIDATE_COMPATIBLE_EDGES__DIAGNOSTICCHAIN_MAP);
				CAUGHT_severity_0 = severity_0;
			}
			catch (Exception e) {
				CAUGHT_severity_0 = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_severity_0 instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_severity_0;
			}
			final /*@Thrown*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, CAUGHT_severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ @NonNull Object symbol_2;
			if (le) {
				symbol_2 = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull RelDiagram referredRelDiagram = this.getReferredRelDiagram();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<RelDomainNode> ownedRelDomainNodes = referredRelDiagram.getOwnedRelDomainNodes();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedRelDomainNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelDomainNode, ownedRelDomainNodes);
				/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedRelDomainNodes.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull RelDomainNode _1 = (@NonNull RelDomainNode)ITERATOR__1.next();
					/**
					 * ownedRelPatternNodes
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<RelPatternNode> ownedRelPatternNodes = _1.getOwnedRelPatternNodes();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedRelPatternNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelPatternNode, ownedRelPatternNodes);
					//
					for (Object value : BOXED_ownedRelPatternNodes.flatten().getElements()) {
						accumulator.add(value);
					}
				}
				/*@Thrown*/ @NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1_0 = collect.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue select;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						select = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull RelPatternNode _1_0 = (@NonNull RelPatternNode)ITERATOR__1_0.next();
					/**
					 * isRoot
					 */
					final /*@NonInvalid*/ boolean isRoot = _1_0.isIsRoot();
					//
					if (isRoot == ValueUtil.TRUE_VALUE) {
						accumulator_0.add(_1_0);
					}
				}
				final /*@NonInvalid*/ @NonNull SetValue expectedNodes = CollectionAsSetOperation.INSTANCE.evaluate(select);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<RelInvocationEdge> ownedRelInvocationEdges = this.getOwnedRelInvocationEdges();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedRelInvocationEdges = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelInvocationEdge, ownedRelInvocationEdges);
				/*@Thrown*/ @NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1_1 = BOXED_ownedRelInvocationEdges.iterator();
				/*@NonInvalid*/ @NonNull SequenceValue collect_0;
				while (true) {
					if (!ITERATOR__1_1.hasNext()) {
						collect_0 = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull RelInvocationEdge _1_1 = (@NonNull RelInvocationEdge)ITERATOR__1_1.next();
					/**
					 * referredRelPatternNode
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelPatternNode referredRelPatternNode = _1_1.getReferredRelPatternNode();
					//
					accumulator_1.add(referredRelPatternNode);
				}
				final /*@NonInvalid*/ @NonNull SetValue actualNodes = CollectionAsSetOperation.INSTANCE.evaluate(collect_0);
				final /*@NonInvalid*/ boolean status = expectedNodes.equals(actualNodes);
				/*@NonInvalid*/ @NonNull Object symbol_1;
				if (status) {
					symbol_1 = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(expectedNodes);
					final /*@NonInvalid*/ @NonNull String toString_0 = OclAnyToStringOperation.INSTANCE.evaluate(size_0);
					final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(UMLXTables.STR_RelInvocationNode_c_c_CompatibleEdges_32, toString_0);
					final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, UMLXTables.STR_quot);
					final /*@NonInvalid*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, toString_0);
					final /*@NonInvalid*/ @NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(UMLXTables.TUPLid_, sum_1, status);
					symbol_1 = symbol_0;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, symbol_1, UMLXTables.INT_0).booleanValue();
				symbol_2 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_2;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getOwningRelDiagram() {
		if (eContainerFeatureID() != (2)) return null;
		return (RelDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDiagram(RelDiagram newOwningRelDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDiagram, 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDiagram(RelDiagram newOwningRelDiagram) {
		if (newOwningRelDiagram != eInternalContainer() || (eContainerFeatureID() != (2) && newOwningRelDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDiagram != null)
				msgs = ((InternalEObject)newOwningRelDiagram).eInverseAdd(this, 5, RelDiagram.class, msgs);
			msgs = basicSetOwningRelDiagram(newOwningRelDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newOwningRelDiagram, newOwningRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelInvocationEdge> getOwnedRelInvocationEdges() {
		if (ownedRelInvocationEdges == null) {
			ownedRelInvocationEdges = new EObjectContainmentWithInverseEList<RelInvocationEdge>(RelInvocationEdge.class, this, 3, 2);
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
			case 1:
				return isIsThen();
			case 2:
				return getOwningRelDiagram();
			case 3:
				return getOwnedRelInvocationEdges();
			case 4:
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
			case 1:
				setIsThen((Boolean)newValue);
				return;
			case 2:
				setOwningRelDiagram((RelDiagram)newValue);
				return;
			case 3:
				getOwnedRelInvocationEdges().clear();
				getOwnedRelInvocationEdges().addAll((Collection<? extends RelInvocationEdge>)newValue);
				return;
			case 4:
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
			case 1:
				setIsThen(IS_THEN_EDEFAULT);
				return;
			case 2:
				setOwningRelDiagram((RelDiagram)null);
				return;
			case 3:
				getOwnedRelInvocationEdges().clear();
				return;
			case 4:
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
			case 1:
				return isThen != IS_THEN_EDEFAULT;
			case 2:
				return getOwningRelDiagram() != null;
			case 3:
				return ownedRelInvocationEdges != null && !ownedRelInvocationEdges.isEmpty();
			case 4:
				return referredRelDiagram != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case 0:
				return validateCompatibleEdges((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isThen: ");
		result.append(isThen);
		result.append(')');
		return result.toString();
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
			case 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDiagram((RelDiagram)otherEnd, msgs);
			case 3:
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
			case 2:
				return basicSetOwningRelDiagram(null, msgs);
			case 3:
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
			case 2:
				return eInternalContainer().eInverseRemove(this, 5, RelDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelInvocationNodeImpl
