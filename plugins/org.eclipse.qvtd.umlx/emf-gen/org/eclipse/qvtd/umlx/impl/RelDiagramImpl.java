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
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionCountOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwnedRelDomainNodes <em>Owned Rel Domain Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwnedRelInvocationNodes <em>Owned Rel Invocation Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDiagramImpl extends UMLXNamedElementImpl implements RelDiagram {
	/**
	 * The default value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected boolean isTop = IS_TOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedRelDomainNodes() <em>Owned Rel Domain Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelDomainNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelDomainNode> ownedRelDomainNodes;
	/**
	 * The cached value of the '{@link #getOwnedRelInvocationNodes() <em>Owned Rel Invocation Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelInvocationNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelInvocationNode> ownedRelInvocationNodes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTop() {
		return isTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTop(boolean newIsTop) {
		boolean oldIsTop = isTop;
		isTop = newIsTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DIAGRAM__IS_TOP, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelDomainNode> getOwnedRelDomainNodes() {
		if (ownedRelDomainNodes == null) {
			ownedRelDomainNodes = new EObjectContainmentWithInverseEList<RelDomainNode>(RelDomainNode.class, this, UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM);
		}
		return ownedRelDomainNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelInvocationNode> getOwnedRelInvocationNodes() {
		if (ownedRelInvocationNodes == null) {
			ownedRelInvocationNodes = new EObjectContainmentWithInverseEList<RelInvocationNode>(RelInvocationNode.class, this, UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM);
		}
		return ownedRelInvocationNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getOwningTxDiagram() {
		if (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM, newOwningTxDiagram, newOwningTxDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NameIsRequired:
		 *   let severity : Integer[1] = 'RelDiagram::NameIsRequired'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = name <> null
		 *       in
		 *         'RelDiagram::NameIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelDiagram_c_c_NameIsRequired);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ java.lang.@Nullable String name = this.getName();
			final /*@NonInvalid*/ boolean result = name != null;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelDiagram_c_c_NameIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRelPatternNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv RelPatternNodeNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'RelDiagram::RelPatternNodeNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : OclAny[1] = let
		 *           allNames : Sequence(String)[*|?] = ownedRelDomainNodes.ownedRelPatternNodes->select(
		 *             not isExpression())
		 *           ->select(not isAnon).name
		 *         in
		 *           let status : Boolean[1] = allNames->isUnique(n | n)
		 *           in
		 *             if status = true
		 *             then true
		 *             else
		 *               Tuple{
		 *                 status = status, message = let
		 *                   repeatedNames : Set(String) = allNames->select(n |
		 *                     allNames->count(n) > 1)
		 *                   ->asSet()
		 *                 in
		 *                   repeatedNames->iterate(n; acc : String[1] = 'RelDiagram::RelPatternNodeNamesAreUnique:' | acc + ' \'' + n + '\'') + ' are not unique for ' + name
		 *               }
		 *             endif
		 *       in
		 *         'RelDiagram::RelPatternNodeNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ java.lang.@NonNull Object symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<RelDomainNode> ownedRelDomainNodes = this.getOwnedRelDomainNodes();
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
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue select_0;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						select_0 = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode _1_0 = (RelPatternNode)ITERATOR__1_0.next();
					/**
					 * not isExpression()
					 */
					final /*@NonInvalid*/ boolean isExpression = _1_0.isExpression();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					if (not == null) {
						throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
					}
					//
					if (not == ValueUtil.TRUE_VALUE) {
						accumulator_0.add(_1_0);
					}
				}
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
				@NonNull Iterator<Object> ITERATOR__1_1 = select_0.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue select;
				while (true) {
					if (!ITERATOR__1_1.hasNext()) {
						select = accumulator_1;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode _1_1 = (RelPatternNode)ITERATOR__1_1.next();
					/**
					 * not isAnon
					 */
					final /*@NonInvalid*/ boolean isAnon = _1_1.isIsAnon();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isAnon);
					if (not_0 == null) {
						throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
					}
					//
					if (not_0 == ValueUtil.TRUE_VALUE) {
						accumulator_1.add(_1_1);
					}
				}
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_2 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
				@NonNull Iterator<Object> ITERATOR__1_2 = select.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue allNames;
				while (true) {
					if (!ITERATOR__1_2.hasNext()) {
						allNames = accumulator_2;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode _1_2 = (RelPatternNode)ITERATOR__1_2.next();
					/**
					 * name
					 */
					final /*@NonInvalid*/ java.lang.@Nullable String name = _1_2.getName();
					//
					accumulator_2.add(name);
				}
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_3 = ValueUtil.createSetAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
				@Nullable Iterator<Object> ITERATOR_n = allNames.iterator();
				/*@Thrown*/ boolean status;
				while (true) {
					if (!ITERATOR_n.hasNext()) {
						status = ValueUtil.TRUE_VALUE;
						break;
					}
					/*@NonInvalid*/ java.lang.@Nullable String n = (String)ITERATOR_n.next();
					/**
					 * n
					 */
					//
					if (accumulator_3.includes(n) == ValueUtil.TRUE_VALUE) {
						status = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator_3.add(n);
					}
				}
				/*@Thrown*/ java.lang.@NonNull Object symbol_1;
				if (status) {
					symbol_1 = ValueUtil.TRUE_VALUE;
				}
				else {
					/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_4 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
					@Nullable Iterator<Object> ITERATOR_n_0 = allNames.iterator();
					/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue select_1;
					while (true) {
						if (!ITERATOR_n_0.hasNext()) {
							select_1 = accumulator_4;
							break;
						}
						/*@NonInvalid*/ java.lang.@Nullable String n_0 = (String)ITERATOR_n_0.next();
						/**
						 * allNames->count(n) > 1
						 */
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue count = CollectionCountOperation.INSTANCE.evaluate(allNames, n_0);
						final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, count, UMLXTables.INT_1).booleanValue();
						//
						if (gt == ValueUtil.TRUE_VALUE) {
							accumulator_4.add(n_0);
						}
					}
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue repeatedNames = CollectionAsSetOperation.INSTANCE.evaluate(select_1);
					/*@NonInvalid*/ java.lang.@NonNull String acc = UMLXTables.STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique_c;
					@NonNull Iterator<Object> ITERATOR_n_1 = repeatedNames.iterator();
					/*@Thrown*/ java.lang.@Nullable String iterate;
					while (true) {
						if (!ITERATOR_n_1.hasNext()) {
							iterate = acc;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ java.lang.@NonNull String n_1 = (String)ITERATOR_n_1.next();
						/**
						 * acc + ' \'' + n + '\''
						 */
						final /*@NonInvalid*/ java.lang.@NonNull String sum = StringConcatOperation.INSTANCE.evaluate(acc, UMLXTables.STR__32_39);
						final /*@NonInvalid*/ java.lang.@NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, n_1);
						final /*@NonInvalid*/ java.lang.@NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, UMLXTables.STR__39);
						//
						acc = sum_1;
					}
					final /*@Thrown*/ java.lang.@NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(iterate, UMLXTables.STR__32_are_32_not_32_unique_32_for_32);
					final /*@NonInvalid*/ java.lang.@Nullable String name_0 = this.getName();
					final /*@Thrown*/ java.lang.@NonNull String sum_3 = StringConcatOperation.INSTANCE.evaluate(sum_2, name_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(UMLXTables.TUPLid_, sum_3, status);
					symbol_1 = symbol_0;
				}
				CAUGHT_symbol_1 = symbol_1;
			}
			catch (Exception e) {
				CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_1, UMLXTables.INT_0).booleanValue();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				return isIsTop();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return getOwnedRelDomainNodes();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return getOwnedRelInvocationNodes();
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram();
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				setIsTop((Boolean)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				getOwnedRelDomainNodes().clear();
				getOwnedRelDomainNodes().addAll((Collection<? extends RelDomainNode>)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				getOwnedRelInvocationNodes().clear();
				getOwnedRelInvocationNodes().addAll((Collection<? extends RelInvocationNode>)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)newValue);
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				getOwnedRelDomainNodes().clear();
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				getOwnedRelInvocationNodes().clear();
				return;
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)null);
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				return isTop != IS_TOP_EDEFAULT;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ownedRelDomainNodes != null && !ownedRelDomainNodes.isEmpty();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ownedRelInvocationNodes != null && !ownedRelInvocationNodes.isEmpty();
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelDiagram(this);
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
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDomainNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelInvocationNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ((InternalEList<?>)getOwnedRelDomainNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ((InternalEList<?>)getOwnedRelInvocationNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
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
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, TxDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelDiagramImpl
