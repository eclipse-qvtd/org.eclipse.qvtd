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

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Pattern Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl#getSourceIndex <em>Source Index</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelPatternEdgeImpl extends RelEdgeImpl implements RelPatternEdge {
	/**
	 * The cached value of the '{@link #getReferredEStructuralFeature() <em>Referred EStructural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEStructuralFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature referredEStructuralFeature;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected RelPatternNode source;

	/**
	 * The default value of the '{@link #getSourceIndex() <em>Source Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceIndex() <em>Source Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceIndex()
	 * @generated
	 * @ordered
	 */
	protected int sourceIndex = SOURCE_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected RelPatternNode target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelPatternEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_PATTERN_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelPatternNode getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (RelPatternNode)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_PATTERN_EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(RelPatternNode newSource, NotificationChain msgs) {
		RelPatternNode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(RelPatternNode newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, UMLXPackage.REL_PATTERN_NODE__OUTGOING, RelPatternNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, UMLXPackage.REL_PATTERN_NODE__OUTGOING, RelPatternNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSourceIndex() {
		return sourceIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceIndex(int newSourceIndex) {
		int oldSourceIndex = sourceIndex;
		sourceIndex = newSourceIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__SOURCE_INDEX, oldSourceIndex, sourceIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDomainNode getOwningRelDomainNode() {
		if (eContainerFeatureID() != UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE) return null;
		return (RelDomainNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDomainNode(RelDomainNode newOwningRelDomainNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDomainNode, UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDomainNode(RelDomainNode newOwningRelDomainNode) {
		if (newOwningRelDomainNode != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE && newOwningRelDomainNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDomainNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDomainNode != null)
				msgs = ((InternalEObject)newOwningRelDomainNode).eInverseAdd(this, UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES, RelDomainNode.class, msgs);
			msgs = basicSetOwningRelDomainNode(newOwningRelDomainNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE, newOwningRelDomainNode, newOwningRelDomainNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EStructuralFeature getReferredEStructuralFeature() {
		if (referredEStructuralFeature != null && referredEStructuralFeature.eIsProxy()) {
			InternalEObject oldReferredEStructuralFeature = (InternalEObject)referredEStructuralFeature;
			referredEStructuralFeature = (EStructuralFeature)eResolveProxy(oldReferredEStructuralFeature);
			if (referredEStructuralFeature != oldReferredEStructuralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE, oldReferredEStructuralFeature, referredEStructuralFeature));
			}
		}
		return referredEStructuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetReferredEStructuralFeature() {
		return referredEStructuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEStructuralFeature(EStructuralFeature newReferredEStructuralFeature) {
		EStructuralFeature oldReferredEStructuralFeature = referredEStructuralFeature;
		referredEStructuralFeature = newReferredEStructuralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE, oldReferredEStructuralFeature, referredEStructuralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelPatternNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (RelPatternNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_PATTERN_EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(RelPatternNode newTarget, NotificationChain msgs) {
		RelPatternNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(RelPatternNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, UMLXPackage.REL_PATTERN_NODE__INCOMING, RelPatternNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, UMLXPackage.REL_PATTERN_NODE__INCOMING, RelPatternNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_EDGE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean SourceIsClassNode(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv SourceIsClassNode:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::SourceIsClassNode'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = source.oclIsKindOf(RelPatternClassNode)
		 *       in
		 *         'RelPatternEdge::SourceIsClassNode'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_SourceIsClassNode);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
			final /*@NonInvalid*/ boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, source, TYP_umlx_c_c_RelPatternClassNode_0).booleanValue();
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_SourceIsClassNode, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
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
	public boolean SourceIsEClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv SourceIsEClass:
		 *   let severity : Integer[1] = 'RelPatternEdge::SourceIsEClass'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[?] = source.oclIsKindOf(RelPatternClassNode) implies
		 *         source.oclAsType(RelPatternClassNode)
		 *         .referredEClassifier.oclIsKindOf(ecore::EClassifier)
		 *       in
		 *         'RelPatternEdge::SourceIsEClass'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_SourceIsEClass);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
				final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, source, TYP_umlx_c_c_RelPatternClassNode_0).booleanValue();
				/*@Thrown*/ boolean result;
				if (oclIsKindOf) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClassifier = idResolver.getClass(UMLXTables.CLSSid_EClassifier, null);
					final /*@Thrown*/ org.eclipse.qvtd.umlx.@NonNull RelPatternClassNode oclAsType = ClassUtil.nonNullState((RelPatternClassNode)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source, TYP_umlx_c_c_RelPatternClassNode_0));
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClassifier referredEClassifier = oclAsType.getReferredEClassifier();
					final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClassifier).booleanValue();
					result = oclIsKindOf_0;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_SourceIsEClass, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean TargetIsClassNode(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TargetIsClassNode:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::TargetIsClassNode'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = target.oclIsKindOf(RelPatternClassNode)
		 *       in
		 *         'RelPatternEdge::TargetIsClassNode'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_TargetIsClassNode);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
			final /*@NonInvalid*/ boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, target, TYP_umlx_c_c_RelPatternClassNode_0).booleanValue();
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_TargetIsClassNode, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
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
	public boolean CompatiblePropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatiblePropertyTarget:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatiblePropertyTarget'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = referredEStructuralFeature?.eType =
		 *         target.oclAsType(RelPatternClassNode).referredEClassifier
		 *       in
		 *         'RelPatternEdge::CompatiblePropertyTarget'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertyTarget);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ @NonNull Object symbol_0 = referredEStructuralFeature == null;
				/*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClassifier safe_eType_source;
				if (symbol_0 == Boolean.TRUE) {
					safe_eType_source = null;
				}
				else {
					assert referredEStructuralFeature != null;
					final /*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClassifier eType = referredEStructuralFeature.getEType();
					safe_eType_source = eType;
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
				final /*@Thrown*/ org.eclipse.qvtd.umlx.@NonNull RelPatternClassNode oclAsType = ClassUtil.nonNullState((RelPatternClassNode)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, target, TYP_umlx_c_c_RelPatternClassNode_0));
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClassifier referredEClassifier = oclAsType.getReferredEClassifier();
				final /*@Thrown*/ boolean result = referredEClassifier.equals(safe_eType_source);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertyTarget, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
			symbol_1 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean CompatiblePropertySource(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatiblePropertySource:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatiblePropertySource'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = source.oclAsType(RelPatternClassNode)
		 *         .referredEClassifier.oclAsType(ecore::EClass)
		 *         ->closure(eSuperTypes)
		 *         ->includes(referredEStructuralFeature?.eContainingClass)
		 *       in
		 *         'RelPatternEdge::CompatiblePropertySource'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertySource);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_umlx_c_c_RelPatternClassNode_0 = idResolver.getClass(UMLXTables.CLSSid_RelPatternClassNode, null);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
				final /*@Thrown*/ org.eclipse.qvtd.umlx.@NonNull RelPatternClassNode oclAsType = ClassUtil.nonNullState((RelPatternClassNode)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, source, TYP_umlx_c_c_RelPatternClassNode_0));
				@SuppressWarnings("null")
				final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClassifier referredEClassifier = oclAsType.getReferredEClassifier();
				final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass oclAsType_0 = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_0));
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, oclAsType_0);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
				final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
				final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
					/**
					 * eSuperTypes
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@Nullable Object _1) {
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClass symbol_0 = (EClass)_1;
						if (symbol_0 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.util.@NonNull List<EClass> eSuperTypes = symbol_0.getESuperTypes();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
						return BOXED_eSuperTypes;
					}
				};
				final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ @NonNull Object symbol_1 = referredEStructuralFeature == null;
				/*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClass safe_eContainingClass_source;
				if (symbol_1 == Boolean.TRUE) {
					safe_eContainingClass_source = null;
				}
				else {
					assert referredEStructuralFeature != null;
					final /*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClass eContainingClass = referredEStructuralFeature.getEContainingClass();
					safe_eContainingClass_source = eContainingClass;
				}
				final /*@Thrown*/ boolean result = CollectionIncludesOperation.INSTANCE.evaluate(closure, safe_eContainingClass_source).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertySource, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				return getOwningRelDomainNode();
			case UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE:
				if (resolve) return getReferredEStructuralFeature();
				return basicGetReferredEStructuralFeature();
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE_INDEX:
				return getSourceIndex();
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				setOwningRelDomainNode((RelDomainNode)newValue);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE:
				setReferredEStructuralFeature((EStructuralFeature)newValue);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				setSource((RelPatternNode)newValue);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE_INDEX:
				setSourceIndex((Integer)newValue);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				setTarget((RelPatternNode)newValue);
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
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				setOwningRelDomainNode((RelDomainNode)null);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE:
				setReferredEStructuralFeature((EStructuralFeature)null);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				setSource((RelPatternNode)null);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE_INDEX:
				setSourceIndex(SOURCE_INDEX_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				setTarget((RelPatternNode)null);
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
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				return getOwningRelDomainNode() != null;
			case UMLXPackage.REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE:
				return referredEStructuralFeature != null;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				return source != null;
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE_INDEX:
				return sourceIndex != SOURCE_INDEX_EDEFAULT;
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelPatternEdge(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDomainNode((RelDomainNode)otherEnd, msgs);
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, UMLXPackage.REL_PATTERN_NODE__OUTGOING, RelPatternNode.class, msgs);
				return basicSetSource((RelPatternNode)otherEnd, msgs);
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, UMLXPackage.REL_PATTERN_NODE__INCOMING, RelPatternNode.class, msgs);
				return basicSetTarget((RelPatternNode)otherEnd, msgs);
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
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				return basicSetOwningRelDomainNode(null, msgs);
			case UMLXPackage.REL_PATTERN_EDGE__SOURCE:
				return basicSetSource(null, msgs);
			case UMLXPackage.REL_PATTERN_EDGE__TARGET:
				return basicSetTarget(null, msgs);
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
			case UMLXPackage.REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES, RelDomainNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelPatternEdgeImpl
