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
	 * The number of operations of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM_OPERATION_COUNT = UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_OPERATION_COUNT + 4;

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
			ownedRelDiagrams = new EObjectContainmentWithInverseEList<RelDiagram>(RelDiagram.class, this, 2, 6);
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
			ownedTxKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, 3, 2);
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
			ownedTxPackageNodes = new EObjectContainmentWithInverseEList<TxPackageNode>(TxPackageNode.class, this, 4, 2);
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
			ownedTxQueryNodes = new EObjectContainmentWithInverseEList<TxQueryNode>(TxQueryNode.class, this, 5, 10);
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
			ownedTxTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, 6, 6);
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
			eNotify(new ENotificationImpl(this, Notification.SET, 7, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTxQueryNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "TxDiagram::TxQueryNodeNamesAreUnique";
		try {
			/**
			 *
			 * inv TxQueryNodeNamesAreUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = ownedTxQueryNodes->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.TX_DIAGRAM___VALIDATE_TX_QUERY_NODE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
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
							result = true;
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
							result = false;
							break;			// Abort after second find
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateRelDiagramNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "TxDiagram::RelDiagramNamesAreUnique";
		try {
			/**
			 *
			 * inv RelDiagramNamesAreUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = ownedRelDiagrams->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.TX_DIAGRAM___VALIDATE_REL_DIAGRAM_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
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
							result = true;
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
							result = false;
							break;			// Abort after second find
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateNameIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "TxDiagram::NameIsRequired";
		try {
			/**
			 *
			 * inv NameIsRequired:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = name <> null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.TX_DIAGRAM___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable String name = this.getName();
				final /*@NonInvalid*/ boolean result = name != null;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateTxTypedModelNodeNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "TxDiagram::TxTypedModelNodeNamesAreUnique";
		try {
			/**
			 *
			 * inv TxTypedModelNodeNamesAreUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = ownedTxTypedModelNodes->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.TX_DIAGRAM___VALIDATE_TX_TYPED_MODEL_NODE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
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
							result = true;
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
							result = false;
							break;			// Abort after second find
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDiagrams()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxKeyNodes()).basicAdd(otherEnd, msgs);
			case 4:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxPackageNodes()).basicAdd(otherEnd, msgs);
			case 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxQueryNodes()).basicAdd(otherEnd, msgs);
			case 6:
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
			case 2:
				return ((InternalEList<?>)getOwnedRelDiagrams()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedTxKeyNodes()).basicRemove(otherEnd, msgs);
			case 4:
				return ((InternalEList<?>)getOwnedTxPackageNodes()).basicRemove(otherEnd, msgs);
			case 5:
				return ((InternalEList<?>)getOwnedTxQueryNodes()).basicRemove(otherEnd, msgs);
			case 6:
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
			case 2:
				return getOwnedRelDiagrams();
			case 3:
				return getOwnedTxKeyNodes();
			case 4:
				return getOwnedTxPackageNodes();
			case 5:
				return getOwnedTxQueryNodes();
			case 6:
				return getOwnedTxTypedModelNodes();
			case 7:
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
			case 2:
				getOwnedRelDiagrams().clear();
				getOwnedRelDiagrams().addAll((Collection<? extends RelDiagram>)newValue);
				return;
			case 3:
				getOwnedTxKeyNodes().clear();
				getOwnedTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
				return;
			case 4:
				getOwnedTxPackageNodes().clear();
				getOwnedTxPackageNodes().addAll((Collection<? extends TxPackageNode>)newValue);
				return;
			case 5:
				getOwnedTxQueryNodes().clear();
				getOwnedTxQueryNodes().addAll((Collection<? extends TxQueryNode>)newValue);
				return;
			case 6:
				getOwnedTxTypedModelNodes().clear();
				getOwnedTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case 7:
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
			case 2:
				getOwnedRelDiagrams().clear();
				return;
			case 3:
				getOwnedTxKeyNodes().clear();
				return;
			case 4:
				getOwnedTxPackageNodes().clear();
				return;
			case 5:
				getOwnedTxQueryNodes().clear();
				return;
			case 6:
				getOwnedTxTypedModelNodes().clear();
				return;
			case 7:
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
			case 2:
				return ownedRelDiagrams != null && !ownedRelDiagrams.isEmpty();
			case 3:
				return ownedTxKeyNodes != null && !ownedTxKeyNodes.isEmpty();
			case 4:
				return ownedTxPackageNodes != null && !ownedTxPackageNodes.isEmpty();
			case 5:
				return ownedTxQueryNodes != null && !ownedTxQueryNodes.isEmpty();
			case 6:
				return ownedTxTypedModelNodes != null && !ownedTxTypedModelNodes.isEmpty();
			case 7:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
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
				return validateTxQueryNodeNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 1:
				return validateRelDiagramNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 2:
				return validateNameIsRequired((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 3:
				return validateTxTypedModelNodeNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
