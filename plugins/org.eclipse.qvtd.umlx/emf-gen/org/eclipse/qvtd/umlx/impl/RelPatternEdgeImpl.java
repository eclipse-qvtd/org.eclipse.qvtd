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
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
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
	public boolean validateSourceIsEClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv SourceIsEClass:
		 *   let severity : Integer[1] = 'RelPatternEdge::SourceIsEClass'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[?] = not source.isExpression() implies
		 *         source.referredEClassifier.oclIsKindOf(ecore::EClassifier)
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
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
				final /*@NonInvalid*/ boolean isExpression = source.isExpression();
				final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
				/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClassifier = idResolver.getClass(UMLXTables.CLSSid_EClassifier, null);
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
					final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClassifier).booleanValue();
					CAUGHT_oclIsKindOf = oclIsKindOf;
				}
				catch (Exception e) {
					CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(not, CAUGHT_oclIsKindOf);
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
	public boolean validateSourceIsClassNode(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv SourceIsClassNode:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::SourceIsClassNode'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = not source.isExpression()
		 *       in
		 *         'RelPatternEdge::SourceIsClassNode'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_SourceIsClassNode);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
			final /*@NonInvalid*/ boolean isExpression = source.isExpression();
			final /*@NonInvalid*/ java.lang.@Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(isExpression);
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
	public boolean validateCompatibleEAttributePropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleEAttributePropertyTarget:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleEAttributePropertyTarget'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredEStructuralFeature <> null and
		 *         referredEStructuralFeature.oclIsKindOf(ecore::EAttribute) and
		 *         not target.isExpression() implies referredEStructuralFeature.eType = target.referredEClassifier
		 *       in
		 *         'RelPatternEdge::CompatibleEAttributePropertyTarget'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleEAttributePropertyTarget);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature_0 = this.getReferredEStructuralFeature();
						final /*@NonInvalid*/ boolean ne = referredEStructuralFeature_0 != null;
						/*@Thrown*/ boolean and;
						if (ne) {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EAttribute = idResolver.getClass(UMLXTables.CLSSid_EAttribute, null);
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEStructuralFeature_0, TYP_ecore_c_c_EAttribute).booleanValue();
							and = oclIsKindOf;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
					final /*@NonInvalid*/ boolean isExpression = target.isExpression();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					final /*@Thrown*/ java.lang.@Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, not);
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_eq;
				try {
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature_1 = this.getReferredEStructuralFeature();
					if (referredEStructuralFeature_1 == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::ETypedElement::eType\'");
					}
					final /*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClassifier eType = referredEStructuralFeature_1.getEType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target_0 = this.getTarget();
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = target_0.getReferredEClassifier();
					final /*@Thrown*/ boolean eq = (eType != null) ? eType.equals(referredEClassifier) : (referredEClassifier == null);
					CAUGHT_eq = eq;
				}
				catch (Exception e) {
					CAUGHT_eq = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_eq);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleEAttributePropertyTarget, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatibleSourceMultiplicity(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleSourceMultiplicity:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleSourceMultiplicity'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = referredEStructuralFeature = null = source.isMany
		 *       in
		 *         'RelPatternEdge::CompatibleSourceMultiplicity'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleSourceMultiplicity);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
			final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
			final /*@NonInvalid*/ boolean isMany = source.isIsMany();
			final /*@NonInvalid*/ boolean result = eq == isMany;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleSourceMultiplicity, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatibleEReferencePropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleEReferencePropertyTarget:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleEReferencePropertyTarget'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredEStructuralFeature <> null and
		 *         referredEStructuralFeature.oclIsKindOf(ecore::EReference) and
		 *         not target.isExpression() implies
		 *         let
		 *           sourceEClass : ecore::EClass[1] = target.referredEClassifier.oclAsType(ecore::EClass)
		 *         in
		 *           sourceEClass->closure(eSuperTypes)
		 *           ->includes(referredEStructuralFeature.eType)
		 *       in
		 *         'RelPatternEdge::CompatibleEReferencePropertyTarget'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleEReferencePropertyTarget);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and_0;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature_0 = this.getReferredEStructuralFeature();
						final /*@NonInvalid*/ boolean ne = referredEStructuralFeature_0 != null;
						/*@Thrown*/ boolean and;
						if (ne) {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EReference = idResolver.getClass(UMLXTables.CLSSid_EReference, null);
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEStructuralFeature_0, TYP_ecore_c_c_EReference).booleanValue();
							and = oclIsKindOf;
						}
						else {
							and = ValueUtil.FALSE_VALUE;
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
					final /*@NonInvalid*/ boolean isExpression = target.isExpression();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					final /*@Thrown*/ java.lang.@Nullable Boolean and_0 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and, not);
					CAUGHT_and_0 = and_0;
				}
				catch (Exception e) {
					CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_includes;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target_0 = this.getTarget();
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = target_0.getReferredEClassifier();
					final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass sourceEClass = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_0));
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, sourceEClass);
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
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
							return BOXED_eSuperTypes;
						}
					};
					final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue closure = ClassUtil.nonNullState((CollectionValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature_1 = this.getReferredEStructuralFeature();
					if (referredEStructuralFeature_1 == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::ETypedElement::eType\'");
					}
					final /*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClassifier eType = referredEStructuralFeature_1.getEType();
					final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, eType).booleanValue();
					CAUGHT_includes = includes;
				}
				catch (Exception e) {
					CAUGHT_includes = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_and_0, CAUGHT_includes);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleEReferencePropertyTarget, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatiblePropertySource(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatiblePropertySource:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatiblePropertySource'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredEStructuralFeature <> null implies
		 *         source.referredEClassifier.oclAsType(ecore::EClass)
		 *         ->closure(eSuperTypes)
		 *         ->includes(referredEStructuralFeature.eContainingClass)
		 *       in
		 *         'RelPatternEdge::CompatiblePropertySource'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertySource);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
				/*@Thrown*/ boolean result;
				if (ne) {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
					final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass oclAsType = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass));
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, oclAsType);
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
							final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
							return BOXED_eSuperTypes;
						}
					};
					final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue closure = ClassUtil.nonNullState((CollectionValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
					if (referredEStructuralFeature == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EStructuralFeature::eContainingClass\'");
					}
					final /*@Thrown*/ org.eclipse.emf.ecore.@Nullable EClass eContainingClass = referredEStructuralFeature.getEContainingClass();
					final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, eContainingClass).booleanValue();
					result = includes;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatiblePropertySource, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatibleSourceIndex(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleSourceIndex:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleSourceIndex'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = referredEStructuralFeature <> null = sourceIndex = 0
		 *       in
		 *         'RelPatternEdge::CompatibleSourceIndex'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleSourceIndex);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
			final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
			final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
			final /*@NonInvalid*/ boolean eq = BOXED_sourceIndex.equals(UMLXTables.INT_0);
			final /*@NonInvalid*/ boolean result = ne == eq;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleSourceIndex, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatibleRestPropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleRestPropertyTarget:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleRestPropertyTarget'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredEStructuralFeature = null and sourceIndex < 0 and
		 *         not target.isExpression() implies
		 *         let
		 *           sourceEClass : ecore::EClass[1] = source.referredEClassifier.oclAsType(ecore::EClass)
		 *         in
		 *           let
		 *             targetEClass : ecore::EClass[1] = target.referredEClassifier.oclAsType(ecore::EClass)
		 *           in sourceEClass = targetEClass and source.isMany = target.isMany and source.isNullFree = target.isNullFree and source.isOrdered = target.isOrdered and source.isUnique = target.isUnique
		 *       in
		 *         'RelPatternEdge::CompatibleRestPropertyTarget'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleRestPropertyTarget);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
				/*@NonInvalid*/ boolean and;
				if (eq) {
					final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
					final /*@NonInvalid*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, BOXED_sourceIndex, UMLXTables.INT_0).booleanValue();
					and = lt;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@NonInvalid*/ java.lang.@Nullable Boolean and_0;
				if (and) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
					final /*@NonInvalid*/ boolean isExpression = target.isExpression();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					and_0 = not;
				}
				else {
					and_0 = ValueUtil.FALSE_VALUE;
				}
				/*@Caught*/ @Nullable Object CAUGHT_and_4;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_sourceEClass;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_3 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
						final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass sourceEClass = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_3));
						CAUGHT_sourceEClass = sourceEClass;
					}
					catch (Exception e) {
						CAUGHT_sourceEClass = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_targetEClass;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_4 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target_0 = this.getTarget();
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier_0 = target_0.getReferredEClassifier();
						final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass targetEClass = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier_0, TYP_ecore_c_c_EClass_4));
						CAUGHT_targetEClass = targetEClass;
					}
					catch (Exception e) {
						CAUGHT_targetEClass = ValueUtil.createInvalidValue(e);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source_3 = this.getSource();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target_4 = this.getTarget();
					/*@Caught*/ @Nullable Object CAUGHT_and_3;
					try {
						/*@Caught*/ @Nullable Object CAUGHT_and_2;
						try {
							/*@Caught*/ @Nullable Object CAUGHT_and_1;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_eq_0;
								try {
									if (CAUGHT_sourceEClass instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_sourceEClass;
									}
									if (CAUGHT_targetEClass instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_targetEClass;
									}
									final /*@Thrown*/ boolean eq_0 = CAUGHT_sourceEClass.equals(CAUGHT_targetEClass);
									CAUGHT_eq_0 = eq_0;
								}
								catch (Exception e) {
									CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
								}
								final /*@NonInvalid*/ boolean isMany = source_3.isIsMany();
								final /*@NonInvalid*/ boolean isMany_0 = target_4.isIsMany();
								final /*@NonInvalid*/ boolean eq_1 = isMany == isMany_0;
								final /*@Thrown*/ java.lang.@Nullable Boolean and_1 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_eq_0, eq_1);
								CAUGHT_and_1 = and_1;
							}
							catch (Exception e) {
								CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
							}
							final /*@NonInvalid*/ boolean isNullFree = source_3.isIsNullFree();
							final /*@NonInvalid*/ boolean isNullFree_0 = target_4.isIsNullFree();
							final /*@NonInvalid*/ boolean eq_2 = isNullFree == isNullFree_0;
							final /*@Thrown*/ java.lang.@Nullable Boolean and_2 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_1, eq_2);
							CAUGHT_and_2 = and_2;
						}
						catch (Exception e) {
							CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ boolean isOrdered = source_3.isIsOrdered();
						final /*@NonInvalid*/ boolean isOrdered_0 = target_4.isIsOrdered();
						final /*@NonInvalid*/ boolean eq_3 = isOrdered == isOrdered_0;
						final /*@Thrown*/ java.lang.@Nullable Boolean and_3 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_2, eq_3);
						CAUGHT_and_3 = and_3;
					}
					catch (Exception e) {
						CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ boolean isUnique = source_3.isIsUnique();
					final /*@NonInvalid*/ boolean isUnique_0 = target_4.isIsUnique();
					final /*@NonInvalid*/ boolean eq_4 = isUnique == isUnique_0;
					final /*@Thrown*/ java.lang.@Nullable Boolean and_4 = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_and_3, eq_4);
					CAUGHT_and_4 = and_4;
				}
				catch (Exception e) {
					CAUGHT_and_4 = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(and_0, CAUGHT_and_4);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleRestPropertyTarget, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateCompatibleMemberPropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleMemberPropertyTarget:
		 *   let
		 *     severity : Integer[1] = 'RelPatternEdge::CompatibleMemberPropertyTarget'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = referredEStructuralFeature = null and sourceIndex > 0 and
		 *         not target.isExpression() implies
		 *         let
		 *           sourceEClass : ecore::EClass[1] = source.referredEClassifier.oclAsType(ecore::EClass)
		 *         in
		 *           let
		 *             targetEClass : ecore::EClass[1] = target.referredEClassifier.oclAsType(ecore::EClass)
		 *           in
		 *             sourceEClass->closure(eSuperTypes)
		 *             ->includes(targetEClass) or
		 *             targetEClass->closure(eSuperTypes)
		 *             ->includes(sourceEClass)
		 *       in
		 *         'RelPatternEdge::CompatibleMemberPropertyTarget'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternEdge_c_c_CompatibleMemberPropertyTarget);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
				/*@NonInvalid*/ boolean and;
				if (eq) {
					final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
					final /*@NonInvalid*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, BOXED_sourceIndex, UMLXTables.INT_0).booleanValue();
					and = gt;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@NonInvalid*/ java.lang.@Nullable Boolean and_0;
				if (and) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target = this.getTarget();
					final /*@NonInvalid*/ boolean isExpression = target.isExpression();
					final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					and_0 = not;
				}
				else {
					and_0 = ValueUtil.FALSE_VALUE;
				}
				/*@Caught*/ @Nullable Object CAUGHT_or;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_sourceEClass;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_1 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode source = this.getSource();
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
						final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass sourceEClass = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_1));
						CAUGHT_sourceEClass = sourceEClass;
					}
					catch (Exception e) {
						CAUGHT_sourceEClass = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_targetEClass;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_2 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelPatternNode target_0 = this.getTarget();
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClassifier referredEClassifier_0 = target_0.getReferredEClassifier();
						final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass targetEClass = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier_0, TYP_ecore_c_c_EClass_2));
						CAUGHT_targetEClass = targetEClass;
					}
					catch (Exception e) {
						CAUGHT_targetEClass = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_includes;
					try {
						if (CAUGHT_sourceEClass instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_sourceEClass;
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, CAUGHT_sourceEClass);
						final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_1 = executor.getStaticTypeOf(oclAsSet);
						final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_1 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
						final @NonNull Object ACC_closure_1 = IMPL_closure_1.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
						/**
						 * Implementation of the iterator body.
						 */
						final @NonNull AbstractBinaryOperation BODY_closure_1 = new AbstractBinaryOperation() {
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
								final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
								return BOXED_eSuperTypes;
							}
						};
						final @NonNull  ExecutorSingleIterationManager MGR_closure_1 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_1, oclAsSet, ACC_closure_1);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue closure = ClassUtil.nonNullState((CollectionValue)IMPL_closure_1.evaluateIteration(MGR_closure_1));
						if (CAUGHT_targetEClass instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_targetEClass;
						}
						final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, CAUGHT_targetEClass).booleanValue();
						CAUGHT_includes = includes;
					}
					catch (Exception e) {
						CAUGHT_includes = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @NonNull Object CAUGHT_includes_0;
					try {
						if (CAUGHT_targetEClass instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_targetEClass;
						}
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, CAUGHT_targetEClass);
						final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0_0 = executor.getStaticTypeOf(oclAsSet_0);
						final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
						final @NonNull Object ACC_closure_0_0 = IMPL_closure_0_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
						/**
						 * Implementation of the iterator body.
						 */
						final @NonNull AbstractBinaryOperation BODY_closure_0_0 = new AbstractBinaryOperation() {
							/**
							 * eSuperTypes
							 */
							@Override
							public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet_0, final /*@NonInvalid*/ java.lang.@Nullable Object _1_0) {
								final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClass symbol_1 = (EClass)_1_0;
								if (symbol_1 == null) {
									throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
								}
								@SuppressWarnings("null")
								final /*@Thrown*/ java.util.@NonNull List<EClass> eSuperTypes_0 = symbol_1.getESuperTypes();
								final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue BOXED_eSuperTypes_0 = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes_0);
								return BOXED_eSuperTypes_0;
							}
						};
						final @NonNull  ExecutorSingleIterationManager MGR_closure_0_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0_0, oclAsSet_0, ACC_closure_0_0);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull CollectionValue closure_0 = ClassUtil.nonNullState((CollectionValue)IMPL_closure_0_0.evaluateIteration(MGR_closure_0_0));
						if (CAUGHT_sourceEClass instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_sourceEClass;
						}
						final /*@Thrown*/ boolean includes_0 = CollectionIncludesOperation.INSTANCE.evaluate(closure_0, CAUGHT_sourceEClass).booleanValue();
						CAUGHT_includes_0 = includes_0;
					}
					catch (Exception e) {
						CAUGHT_includes_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ java.lang.@Nullable Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_includes, CAUGHT_includes_0);
					CAUGHT_or = or;
				}
				catch (Exception e) {
					CAUGHT_or = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(and_0, CAUGHT_or);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternEdge_c_c_CompatibleMemberPropertyTarget, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
