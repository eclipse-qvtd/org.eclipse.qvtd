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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedRelDiagrams <em>Owned Rel Diagrams</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxImportNodes <em>Owned Tx Import Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxQueryNodes <em>Owned Tx Query Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxDiagramImpl extends UMLXNamedElementImpl implements TxDiagram {
	/**
	 * The cached value of the '{@link #getOwnedRelDiagrams() <em>Owned Rel Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<RelDiagram> ownedRelDiagrams;

	/**
	 * The cached value of the '{@link #getOwnedTxImportNodes() <em>Owned Tx Import Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxImportNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxImportNode> ownedTxImportNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxKeyNodes() <em>Owned Tx Key Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxKeyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxKeyNode> ownedTxKeyNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxQueryNodes() <em>Owned Tx Query Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxQueryNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxQueryNode> ownedTxQueryNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxTypedModelNodes() <em>Owned Tx Typed Model Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxTypedModelNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxTypedModelNode> ownedTxTypedModelNodes;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelDiagram> getOwnedRelDiagrams() {
		if (ownedRelDiagrams == null) {
			ownedRelDiagrams = new EObjectContainmentWithInverseEList<RelDiagram>(RelDiagram.class, this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM);
		}
		return ownedRelDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxImportNode> getOwnedTxImportNodes() {
		if (ownedTxImportNodes == null) {
			ownedTxImportNodes = new EObjectContainmentWithInverseEList<TxImportNode>(TxImportNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES, UMLXPackage.TX_IMPORT_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxImportNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxKeyNode> getOwnedTxKeyNodes() {
		if (ownedTxKeyNodes == null) {
			ownedTxKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES, UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxKeyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxQueryNode> getOwnedTxQueryNodes() {
		if (ownedTxQueryNodes == null) {
			ownedTxQueryNodes = new EObjectContainmentWithInverseEList<TxQueryNode>(TxQueryNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES, UMLXPackage.TX_QUERY_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxQueryNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxTypedModelNode> getOwnedTxTypedModelNodes() {
		if (ownedTxTypedModelNodes == null) {
			ownedTxTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxTypedModelNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_DIAGRAM__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRelDiagramNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv RelDiagramNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'TxDiagram::RelDiagramNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = ownedRelDiagrams->isUnique(name)
		 *       in
		 *         'TxDiagram::RelDiagramNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_RelDiagramNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<RelDiagram> ownedRelDiagrams = this.getOwnedRelDiagrams();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedRelDiagrams = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelDiagram, ownedRelDiagrams);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_RelDiagram);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedRelDiagrams.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelDiagram _1 = (RelDiagram)ITERATOR__1.next();
					/**
					 * name
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.lang.@NonNull String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxDiagram_c_c_RelDiagramNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateTxTypedModelNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TxTypedModelNodeNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'TxDiagram::TxTypedModelNodeNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = ownedTxTypedModelNodes->isUnique(name)
		 *       in
		 *         'TxDiagram::TxTypedModelNodeNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_TxTypedModelNodeNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<TxTypedModelNode> ownedTxTypedModelNodes = this.getOwnedTxTypedModelNodes();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedTxTypedModelNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxTypedModelNode, ownedTxTypedModelNodes);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxTypedModelNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxTypedModelNodes.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull TxTypedModelNode _1 = (TxTypedModelNode)ITERATOR__1.next();
					/**
					 * name
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.lang.@NonNull String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxDiagram_c_c_TxTypedModelNodeNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateTxQueryNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TxQueryNodeNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'TxDiagram::TxQueryNodeNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = ownedTxQueryNodes->isUnique(name)
		 *       in
		 *         'TxDiagram::TxQueryNodeNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_TxQueryNodeNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<TxQueryNode> ownedTxQueryNodes = this.getOwnedTxQueryNodes();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedTxQueryNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxQueryNode, ownedTxQueryNodes);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxQueryNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxQueryNodes.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull TxQueryNode _1 = (TxQueryNode)ITERATOR__1.next();
					/**
					 * name
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.lang.@NonNull String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxDiagram_c_c_TxQueryNodeNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDiagrams()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxImportNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxKeyNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxQueryNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxTypedModelNodes()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ((InternalEList<?>)getOwnedRelDiagrams()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ((InternalEList<?>)getOwnedTxImportNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ((InternalEList<?>)getOwnedTxKeyNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				return ((InternalEList<?>)getOwnedTxQueryNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ((InternalEList<?>)getOwnedTxTypedModelNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return getOwnedRelDiagrams();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return getOwnedTxImportNodes();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return getOwnedTxKeyNodes();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				return getOwnedTxQueryNodes();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return getOwnedTxTypedModelNodes();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return getPackage();
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				getOwnedRelDiagrams().clear();
				getOwnedRelDiagrams().addAll((Collection<? extends RelDiagram>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				getOwnedTxImportNodes().clear();
				getOwnedTxImportNodes().addAll((Collection<? extends TxImportNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				getOwnedTxKeyNodes().clear();
				getOwnedTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				getOwnedTxQueryNodes().clear();
				getOwnedTxQueryNodes().addAll((Collection<? extends TxQueryNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				getOwnedTxTypedModelNodes().clear();
				getOwnedTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage((String)newValue);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				getOwnedRelDiagrams().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				getOwnedTxImportNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				getOwnedTxKeyNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				getOwnedTxQueryNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				getOwnedTxTypedModelNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ownedRelDiagrams != null && !ownedRelDiagrams.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ownedTxImportNodes != null && !ownedTxImportNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ownedTxKeyNodes != null && !ownedTxKeyNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_QUERY_NODES:
				return ownedTxQueryNodes != null && !ownedTxQueryNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ownedTxTypedModelNodes != null && !ownedTxTypedModelNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxDiagram(this);
	}

} //TxDiagramImpl
