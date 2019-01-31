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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
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
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxQueryNodes <em>Owned Tx Query Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxDiagramImpl extends UMLXNamedElementImpl implements TxDiagram {
	/**
	 * The number of structural features of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM_FEATURE_COUNT = UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 6;

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
	 * The cached value of the '{@link #getOwnedTxKeyNodes() <em>Owned Tx Key Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxKeyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxKeyNode> ownedTxKeyNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxPackageNodes() <em>Owned Tx Package Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxPackageNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxPackageNode> ownedTxPackageNodes;

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
			ownedRelDiagrams = new EObjectContainmentWithInverseEList<RelDiagram>(RelDiagram.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4);
		}
		return ownedRelDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxKeyNode> getOwnedTxKeyNodes() {
		if (ownedTxKeyNodes == null) {
			ownedTxKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1);
		}
		return ownedTxKeyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxPackageNode> getOwnedTxPackageNodes() {
		if (ownedTxPackageNodes == null) {
			ownedTxPackageNodes = new EObjectContainmentWithInverseEList<TxPackageNode>(TxPackageNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2, TxNodeImpl.TX_NODE_FEATURE_COUNT + 1);
		}
		return ownedTxPackageNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxQueryNode> getOwnedTxQueryNodes() {
		if (ownedTxQueryNodes == null) {
			ownedTxQueryNodes = new EObjectContainmentWithInverseEList<TxQueryNode>(TxQueryNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3, TxNodeImpl.TX_NODE_FEATURE_COUNT + 9);
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
			ownedTxTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4, TxNodeImpl.TX_NODE_FEATURE_COUNT + 4);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTxQueryNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_TxQueryNodeNamesAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<TxQueryNode> ownedTxQueryNodes = this.getOwnedTxQueryNodes();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedTxQueryNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxQueryNode, ownedTxQueryNodes);
					/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxQueryNode);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxQueryNodes.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = ValueUtil.TRUE_VALUE;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull TxQueryNode _1 = (@NonNull TxQueryNode)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
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
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxDiagram::TxQueryNodeNamesAreUnique", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRelDiagramNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_RelDiagramNamesAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<RelDiagram> ownedRelDiagrams = this.getOwnedRelDiagrams();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedRelDiagrams = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_RelDiagram, ownedRelDiagrams);
					/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_RelDiagram);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedRelDiagrams.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = ValueUtil.TRUE_VALUE;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull RelDiagram _1 = (@NonNull RelDiagram)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
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
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxDiagram::RelDiagramNamesAreUnique", this, diagnostics, context, e);
		}
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
			 *   let severity : Integer[1] = 'TxDiagram::NameIsRequired'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = name <> null
			 *       in
			 *         'TxDiagram::NameIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_NameIsRequired);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable String name = this.getName();
				final /*@NonInvalid*/ boolean result = name != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxDiagram_c_c_NameIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxDiagram::NameIsRequired", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTxTypedModelNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxDiagram_c_c_TxTypedModelNodeNamesAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<TxTypedModelNode> ownedTxTypedModelNodes = this.getOwnedTxTypedModelNodes();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedTxTypedModelNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxTypedModelNode, ownedTxTypedModelNodes);
					/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxTypedModelNode);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxTypedModelNodes.iterator();
					/*@Thrown*/ boolean result;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							result = ValueUtil.TRUE_VALUE;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull TxTypedModelNode _1 = (@NonNull TxTypedModelNode)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
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
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("TxDiagram::TxTypedModelNodeNamesAreUnique", this, diagnostics, context, e);
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
		result.append(" (package: ");
		result.append(package_);
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDiagrams()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxKeyNodes()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxPackageNodes()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxQueryNodes()).basicAdd(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedRelDiagrams()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedTxKeyNodes()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedTxPackageNodes()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedTxQueryNodes()).basicRemove(otherEnd, msgs);
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getOwnedRelDiagrams();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwnedTxKeyNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getOwnedTxPackageNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwnedTxQueryNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getOwnedTxTypedModelNodes();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				getOwnedRelDiagrams().clear();
				getOwnedRelDiagrams().addAll((Collection<? extends RelDiagram>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedTxKeyNodes().clear();
				getOwnedTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedTxPackageNodes().clear();
				getOwnedTxPackageNodes().addAll((Collection<? extends TxPackageNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedTxQueryNodes().clear();
				getOwnedTxQueryNodes().addAll((Collection<? extends TxQueryNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				getOwnedTxTypedModelNodes().clear();
				getOwnedTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				getOwnedRelDiagrams().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				getOwnedTxKeyNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				getOwnedTxPackageNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOwnedTxQueryNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				getOwnedTxTypedModelNodes().clear();
				return;
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
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
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0:
				return ownedRelDiagrams != null && !ownedRelDiagrams.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1:
				return ownedTxKeyNodes != null && !ownedTxKeyNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2:
				return ownedTxPackageNodes != null && !ownedTxPackageNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ownedTxQueryNodes != null && !ownedTxQueryNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4:
				return ownedTxTypedModelNodes != null && !ownedTxTypedModelNodes.isEmpty();
			case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5:
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
