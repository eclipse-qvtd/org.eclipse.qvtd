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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionCountOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
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
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#isIsAbstract <em>Is Abstract</em>}</li>
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
	 * The number of structural features of the '<em>Rel Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DIAGRAM_FEATURE_COUNT = UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5;
	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;
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
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0, oldIsAbstract, isAbstract));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelDomainNode> getOwnedRelDomainNodes() {
		if (ownedRelDomainNodes == null) {
			ownedRelDomainNodes = new EObjectContainmentWithInverseEList<RelDomainNode>(RelDomainNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2, RelNodeImpl.REL_NODE_FEATURE_COUNT + 3);
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
			ownedRelInvocationNodes = new EObjectContainmentWithInverseEList<RelInvocationNode>(RelInvocationNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3, RelNodeImpl.REL_NODE_FEATURE_COUNT + 1);
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
		if (eContainerFeatureID() != (UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4)) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != (UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4) && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4, newOwningTxDiagram, newOwningTxDiagram));
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelDiagram_c_c_NameIsRequired);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable String name = this.getName();
				final /*@NonInvalid*/ boolean result = name != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelDiagram_c_c_NameIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("RelDiagram::NameIsRequired", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRelPatternNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
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
			 *           allNames : Sequence(String[*|?]) = ownedRelDomainNodes.ownedRelPatternNodes->select(
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
			 *                   repeatedNames : Set(String[*|?]) = allNames->select(n |
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ @NonNull Object symbol_2;
			if (le) {
				symbol_2 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<RelDomainNode> ownedRelDomainNodes = this.getOwnedRelDomainNodes();
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
					/*@Thrown*/ @NonNull SequenceValue select_0;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							select_0 = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull RelPatternNode _1_0 = (@NonNull RelPatternNode)ITERATOR__1_0.next();
						/**
						 * not isExpression()
						 */
						final /*@NonInvalid*/ boolean isExpression = _1_0.isExpression();
						final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
						if (not == null) {
							throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
						}
						//
						if (not == ValueUtil.TRUE_VALUE) {
							accumulator_0.add(_1_0);
						}
					}
					/*@Thrown*/ @NonNull Accumulator accumulator_1 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_RelPatternNode);
					@NonNull Iterator<Object> ITERATOR__1_1 = select_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue select;
					while (true) {
						if (!ITERATOR__1_1.hasNext()) {
							select = accumulator_1;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull RelPatternNode _1_1 = (@NonNull RelPatternNode)ITERATOR__1_1.next();
						/**
						 * not isAnon
						 */
						final /*@NonInvalid*/ boolean isAnon = _1_1.isIsAnon();
						final /*@NonInvalid*/ @Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(isAnon);
						if (not_0 == null) {
							throw new InvalidValueException("Null body for \'Sequence(T).select(Sequence.T[?] | Lambda T() : Boolean[1]) : Sequence(T)\'");
						}
						//
						if (not_0 == ValueUtil.TRUE_VALUE) {
							accumulator_1.add(_1_1);
						}
					}
					/*@Thrown*/ @NonNull Accumulator accumulator_2 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
					@NonNull Iterator<Object> ITERATOR__1_2 = select.iterator();
					/*@Thrown*/ @NonNull SequenceValue allNames;
					while (true) {
						if (!ITERATOR__1_2.hasNext()) {
							allNames = accumulator_2;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull RelPatternNode _1_2 = (@NonNull RelPatternNode)ITERATOR__1_2.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1_2.getName();
						//
						accumulator_2.add(name);
					}
					/*@Thrown*/ org.eclipse.ocl.pivot.values.SetValue.@NonNull Accumulator accumulator_3 = ValueUtil.createSetAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
					@Nullable Iterator<Object> ITERATOR_n = allNames.iterator();
					/*@Thrown*/ boolean status;
					while (true) {
						if (!ITERATOR_n.hasNext()) {
							status = ValueUtil.TRUE_VALUE;
							break;
						}
						/*@NonInvalid*/ @Nullable String n = (@Nullable String)ITERATOR_n.next();
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
					/*@Thrown*/ @NonNull Object symbol_1;
					if (status) {
						symbol_1 = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Thrown*/ @NonNull Accumulator accumulator_4 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_PRIMid_String);
						@Nullable Iterator<Object> ITERATOR_n_0 = allNames.iterator();
						/*@Thrown*/ @NonNull SequenceValue select_1;
						while (true) {
							if (!ITERATOR_n_0.hasNext()) {
								select_1 = accumulator_4;
								break;
							}
							/*@NonInvalid*/ @Nullable String n_0 = (@Nullable String)ITERATOR_n_0.next();
							/**
							 * allNames->count(n) > 1
							 */
							final /*@Thrown*/ @NonNull IntegerValue count = CollectionCountOperation.INSTANCE.evaluate(allNames, n_0);
							final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, count, UMLXTables.INT_1).booleanValue();
							//
							if (gt == ValueUtil.TRUE_VALUE) {
								accumulator_4.add(n_0);
							}
						}
						final /*@Thrown*/ @NonNull SetValue repeatedNames = CollectionAsSetOperation.INSTANCE.evaluate(select_1);
						/*@NonInvalid*/ @NonNull String acc = UMLXTables.STR_RelDiagram_c_c_RelPatternNodeNamesAreUnique_c;
						@Nullable Iterator<Object> ITERATOR_n_1 = repeatedNames.iterator();
						/*@Thrown*/ @Nullable String iterate;
						while (true) {
							if (!ITERATOR_n_1.hasNext()) {
								iterate = acc;
								break;
							}
							/*@NonInvalid*/ @Nullable String n_1 = (@Nullable String)ITERATOR_n_1.next();
							/**
							 * acc + ' \'' + n + '\''
							 */
							final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(acc, UMLXTables.STR__32_39);
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, n_1);
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, UMLXTables.STR__39);
							//
							acc = sum_1;
						}
						final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(iterate, UMLXTables.STR__32_are_32_not_32_unique_32_for_32);
						final /*@NonInvalid*/ @Nullable String name_0 = this.getName();
						final /*@Thrown*/ @NonNull String sum_3 = StringConcatOperation.INSTANCE.evaluate(sum_2, name_0);
						final /*@Thrown*/ @NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(UMLXTables.TUPLid_, sum_3, status);
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
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("RelDiagram::RelPatternNodeNamesAreUnique", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isIsAbstract();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isIsTop();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwnedRelDomainNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwnedRelInvocationNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setIsAbstract((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsTop((Boolean)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedRelDomainNodes().clear();
				getOwnedRelDomainNodes().addAll((Collection<? extends RelDomainNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedRelInvocationNodes().clear();
				getOwnedRelInvocationNodes().addAll((Collection<? extends RelInvocationNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedRelDomainNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedRelInvocationNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isTop != IS_TOP_EDEFAULT;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ownedRelDomainNodes != null && !ownedRelDomainNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ownedRelInvocationNodes != null && !ownedRelInvocationNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isAbstract: ");
		result.append(isAbstract);
		result.append(", isTop: ");
		result.append(isTop);
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDomainNodes()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelInvocationNodes()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedRelDomainNodes()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedRelInvocationNodes()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				return eInternalContainer().eInverseRemove(this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0, TxDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelDiagramImpl
