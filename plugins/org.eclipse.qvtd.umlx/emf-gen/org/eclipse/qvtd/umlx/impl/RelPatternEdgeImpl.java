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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
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
	 * The number of structural features of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE_FEATURE_COUNT = RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE_OPERATION_COUNT = RelEdgeImpl.REL_EDGE_OPERATION_COUNT + 9;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 3, oldSource, source));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 3, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, 13, RelPatternNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, 13, RelPatternNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, newSource, newSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldSourceIndex, sourceIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDomainNode getOwningRelDomainNode() {
		if (eContainerFeatureID() != (1)) return null;
		return (RelDomainNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDomainNode(RelDomainNode newOwningRelDomainNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDomainNode, 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDomainNode(RelDomainNode newOwningRelDomainNode) {
		if (newOwningRelDomainNode != eInternalContainer() || (eContainerFeatureID() != (1) && newOwningRelDomainNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDomainNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDomainNode != null)
				msgs = ((InternalEObject)newOwningRelDomainNode).eInverseAdd(this, 2, RelDomainNode.class, msgs);
			msgs = basicSetOwningRelDomainNode(newOwningRelDomainNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, newOwningRelDomainNode, newOwningRelDomainNode));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 2, oldReferredEStructuralFeature, referredEStructuralFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldReferredEStructuralFeature, referredEStructuralFeature));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 5, oldTarget, target));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 5, oldTarget, newTarget);
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
				msgs = ((InternalEObject)target).eInverseRemove(this, 8, RelPatternNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, 8, RelPatternNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceIsEClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::SourceIsEClass";
		try {
			/**
			 *
			 * inv SourceIsEClass:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = not source.isExpression() implies
			 *         source.referredEClassifier.oclIsKindOf(ecore::EClassifier)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_SOURCE_IS_ECLASS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
					final /*@NonInvalid*/ boolean isExpression = source.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not;
					if (!isExpression) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (isExpression) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (not == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClassifier = idResolver.getClass(UMLXTables.CLSSid_EClassifier, null);
							final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
							final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClassifier).booleanValue();
							CAUGHT_oclIsKindOf = oclIsKindOf;
						}
						catch (Exception e) {
							CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_oclIsKindOf == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_oclIsKindOf;
							}
							if (not == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateSourceIsClassNode(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::SourceIsClassNode";
		try {
			/**
			 *
			 * inv SourceIsClassNode:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not source.isExpression()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_SOURCE_IS_CLASS_NODE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
				final /*@NonInvalid*/ boolean isExpression = source.isExpression();
				final /*@NonInvalid*/ @Nullable Boolean result;
				if (!isExpression) {
					result = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isExpression) {
						result = ValueUtil.FALSE_VALUE;
					}
					else {
						result = null;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleEAttributePropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleEAttributePropertyTarget";
		try {
			/**
			 *
			 * inv CompatibleEAttributePropertyTarget:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = referredEStructuralFeature <> null and
			 *         referredEStructuralFeature.oclIsKindOf(ecore::EAttribute) and
			 *         not target.isExpression() implies
			 *         let t1 : Class[1] = referredEStructuralFeature.eType.oclType()
			 *         in
			 *           let t2 : Class[1] = target.referredEClassifier.oclType()
			 *           in t1.conformsTo(t2)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_EATTRIBUTE_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						/*@Caught*/ @Nullable Object CAUGHT_and;
						try {
							final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
							final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
							final /*@Thrown*/ @Nullable Boolean and;
							if (!ne) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
								try {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EAttribute = idResolver.getClass(UMLXTables.CLSSid_EAttribute, null);
									final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEStructuralFeature, TYP_ecore_c_c_EAttribute).booleanValue();
									CAUGHT_oclIsKindOf = oclIsKindOf;
								}
								catch (Exception e) {
									CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
									and = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclIsKindOf;
									}
									and = ValueUtil.TRUE_VALUE;
								}
							}
							CAUGHT_and = and;
						}
						catch (Exception e) {
							CAUGHT_and = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_0;
						if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target = this.getTarget();
							final /*@NonInvalid*/ boolean isExpression = target.isExpression();
							final /*@NonInvalid*/ @Nullable Boolean not;
							if (!isExpression) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (isExpression) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							if (not == ValueUtil.FALSE_VALUE) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_and instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_and;
								}
								if ((CAUGHT_and == null) || (not == null)) {
									and_0 = null;
								}
								else {
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature_1 = this.getReferredEStructuralFeature();
							if (referredEStructuralFeature_1 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::ETypedElement::eType\'");
							}
							final /*@Thrown*/ @Nullable EClassifier eType = referredEStructuralFeature_1.getEType();
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class t1 = (org.eclipse.ocl.pivot.@Nullable Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, eType);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target_0 = this.getTarget();
							final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = target_0.getReferredEClassifier();
							final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull Class t2 = (org.eclipse.ocl.pivot.@Nullable Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, referredEClassifier);
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, t1, t2).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception e) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_0;
							}
							if (CAUGHT_conformsTo instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_conformsTo;
							}
							if (CAUGHT_and_0 == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleSourceMultiplicity(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleSourceMultiplicity";
		try {
			/**
			 *
			 * inv CompatibleSourceMultiplicity:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = referredEStructuralFeature = null = source.isMany
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_SOURCE_MULTIPLICITY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
				final /*@NonInvalid*/ boolean isMany = source.isIsMany();
				final /*@NonInvalid*/ boolean result = eq == isMany;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleEReferencePropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleEReferencePropertyTarget";
		try {
			/**
			 *
			 * inv CompatibleEReferencePropertyTarget:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_EREFERENCE_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						/*@Caught*/ @Nullable Object CAUGHT_and;
						try {
							final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
							final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
							final /*@Thrown*/ @Nullable Boolean and;
							if (!ne) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
								try {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EReference = idResolver.getClass(UMLXTables.CLSSid_EReference, null);
									final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, referredEStructuralFeature, TYP_ecore_c_c_EReference).booleanValue();
									CAUGHT_oclIsKindOf = oclIsKindOf;
								}
								catch (Exception e) {
									CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
									and = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_oclIsKindOf;
									}
									and = ValueUtil.TRUE_VALUE;
								}
							}
							CAUGHT_and = and;
						}
						catch (Exception e) {
							CAUGHT_and = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean and_0;
						if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target = this.getTarget();
							final /*@NonInvalid*/ boolean isExpression = target.isExpression();
							final /*@NonInvalid*/ @Nullable Boolean not;
							if (!isExpression) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (isExpression) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							if (not == ValueUtil.FALSE_VALUE) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_and instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_and;
								}
								if ((CAUGHT_and == null) || (not == null)) {
									and_0 = null;
								}
								else {
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_includes;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target_0 = this.getTarget();
							final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = target_0.getReferredEClassifier();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull EClass sourceEClass = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_0);
							final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, sourceEClass);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, oclAsSet);
							final @NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
								/**
								 * eSuperTypes
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
									final /*@NonInvalid*/ @Nullable EClass CAST_null = (EClass)_1;
									if (CAST_null == null) {
										throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<EClass> eSuperTypes = CAST_null.getESuperTypes();
									final /*@Thrown*/ @NonNull OrderedSetValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
									return BOXED_eSuperTypes;
								}
							};
							final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
							final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature_1 = this.getReferredEStructuralFeature();
							if (referredEStructuralFeature_1 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::ETypedElement::eType\'");
							}
							final /*@Thrown*/ @Nullable EClassifier eType = referredEStructuralFeature_1.getEType();
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, eType).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception e) {
							CAUGHT_includes = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_0;
							}
							if (CAUGHT_includes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_includes;
							}
							if (CAUGHT_and_0 == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatiblePropertySource(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatiblePropertySource";
		try {
			/**
			 *
			 * inv CompatiblePropertySource:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = referredEStructuralFeature <> null implies
			 *         source.referredEClassifier.oclAsType(ecore::EClass)
			 *         ->closure(eSuperTypes)
			 *         ->includes(referredEStructuralFeature.eContainingClass)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_PROPERTY_SOURCE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
					final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_includes;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
							final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull EClass oclAsType = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass);
							final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, oclAsType);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, oclAsSet);
							final @NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
								/**
								 * eSuperTypes
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
									final /*@NonInvalid*/ @Nullable EClass CAST_null = (EClass)_1;
									if (CAST_null == null) {
										throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
									}
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull List<EClass> eSuperTypes = CAST_null.getESuperTypes();
									final /*@Thrown*/ @NonNull OrderedSetValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
									return BOXED_eSuperTypes;
								}
							};
							final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
							if (referredEStructuralFeature == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EStructuralFeature::eContainingClass\'");
							}
							final /*@Thrown*/ @Nullable EClass eContainingClass = referredEStructuralFeature.getEContainingClass();
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, eContainingClass).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception e) {
							CAUGHT_includes = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_includes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_includes;
							}
							result = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleSourceIndex(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleSourceIndex";
		try {
			/**
			 *
			 * inv CompatibleSourceIndex:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = referredEStructuralFeature <> null = sourceIndex = 0
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_SOURCE_INDEX__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ boolean ne = referredEStructuralFeature != null;
				final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
				final /*@NonInvalid*/ @NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
				final /*@NonInvalid*/ boolean eq = BOXED_sourceIndex.equals(UMLXTables.INT_0);
				final /*@NonInvalid*/ boolean result = ne == eq;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleRestPropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleRestPropertyTarget";
		try {
			/**
			 *
			 * inv CompatibleRestPropertyTarget:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_REST_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
						final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
						final /*@NonInvalid*/ @Nullable Boolean and;
						if (!eq) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
							final /*@NonInvalid*/ @NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
							final /*@NonInvalid*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, BOXED_sourceIndex, UMLXTables.INT_0).booleanValue();
							if (!lt) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								and = ValueUtil.TRUE_VALUE;
							}
						}
						final /*@Thrown*/ @Nullable Boolean and_0;
						if (and == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target = this.getTarget();
							final /*@NonInvalid*/ boolean isExpression = target.isExpression();
							final /*@NonInvalid*/ @Nullable Boolean not;
							if (!isExpression) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (isExpression) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							if (not == ValueUtil.FALSE_VALUE) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								if ((and == null) || (not == null)) {
									and_0 = null;
								}
								else {
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_and_4;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_sourceEClass;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
								final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull EClass sourceEClass = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_0);
								CAUGHT_sourceEClass = sourceEClass;
							}
							catch (Exception e) {
								CAUGHT_sourceEClass = ValueUtil.createInvalidValue(e);
							}
							/*@Caught*/ @NonNull Object CAUGHT_targetEClass;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_1 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull RelPatternNode target_0 = this.getTarget();
								final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier_0 = target_0.getReferredEClassifier();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull EClass targetEClass = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier_0, TYP_ecore_c_c_EClass_1);
								CAUGHT_targetEClass = targetEClass;
							}
							catch (Exception e) {
								CAUGHT_targetEClass = ValueUtil.createInvalidValue(e);
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode source_3 = this.getSource();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target_4 = this.getTarget();
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
										final /*@Thrown*/ @Nullable Boolean and_1;
										if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {
											and_1 = ValueUtil.FALSE_VALUE;
										}
										else {
											final /*@NonInvalid*/ boolean isMany = source_3.isIsMany();
											final /*@NonInvalid*/ boolean isMany_0 = target_4.isIsMany();
											final /*@NonInvalid*/ boolean eq_1 = isMany == isMany_0;
											if (!eq_1) {
												and_1 = ValueUtil.FALSE_VALUE;
											}
											else {
												if (CAUGHT_eq_0 instanceof InvalidValueException) {
													throw (InvalidValueException)CAUGHT_eq_0;
												}
												and_1 = ValueUtil.TRUE_VALUE;
											}
										}
										CAUGHT_and_1 = and_1;
									}
									catch (Exception e) {
										CAUGHT_and_1 = ValueUtil.createInvalidValue(e);
									}
									final /*@Thrown*/ @Nullable Boolean and_2;
									if (CAUGHT_and_1 == ValueUtil.FALSE_VALUE) {
										and_2 = ValueUtil.FALSE_VALUE;
									}
									else {
										final /*@NonInvalid*/ boolean isNullFree = source_3.isIsNullFree();
										final /*@NonInvalid*/ boolean isNullFree_0 = target_4.isIsNullFree();
										final /*@NonInvalid*/ boolean eq_2 = isNullFree == isNullFree_0;
										if (!eq_2) {
											and_2 = ValueUtil.FALSE_VALUE;
										}
										else {
											if (CAUGHT_and_1 instanceof InvalidValueException) {
												throw (InvalidValueException)CAUGHT_and_1;
											}
											if (CAUGHT_and_1 == null) {
												and_2 = null;
											}
											else {
												and_2 = ValueUtil.TRUE_VALUE;
											}
										}
									}
									CAUGHT_and_2 = and_2;
								}
								catch (Exception e) {
									CAUGHT_and_2 = ValueUtil.createInvalidValue(e);
								}
								final /*@Thrown*/ @Nullable Boolean and_3;
								if (CAUGHT_and_2 == ValueUtil.FALSE_VALUE) {
									and_3 = ValueUtil.FALSE_VALUE;
								}
								else {
									final /*@NonInvalid*/ boolean isOrdered = source_3.isIsOrdered();
									final /*@NonInvalid*/ boolean isOrdered_0 = target_4.isIsOrdered();
									final /*@NonInvalid*/ boolean eq_3 = isOrdered == isOrdered_0;
									if (!eq_3) {
										and_3 = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_and_2 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_and_2;
										}
										if (CAUGHT_and_2 == null) {
											and_3 = null;
										}
										else {
											and_3 = ValueUtil.TRUE_VALUE;
										}
									}
								}
								CAUGHT_and_3 = and_3;
							}
							catch (Exception e) {
								CAUGHT_and_3 = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean and_4;
							if (CAUGHT_and_3 == ValueUtil.FALSE_VALUE) {
								and_4 = ValueUtil.FALSE_VALUE;
							}
							else {
								final /*@NonInvalid*/ boolean isUnique = source_3.isIsUnique();
								final /*@NonInvalid*/ boolean isUnique_0 = target_4.isIsUnique();
								final /*@NonInvalid*/ boolean eq_4 = isUnique == isUnique_0;
								if (!eq_4) {
									and_4 = ValueUtil.FALSE_VALUE;
								}
								else {
									if (CAUGHT_and_3 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_and_3;
									}
									if (CAUGHT_and_3 == null) {
										and_4 = null;
									}
									else {
										and_4 = ValueUtil.TRUE_VALUE;
									}
								}
							}
							CAUGHT_and_4 = and_4;
						}
						catch (Exception e) {
							CAUGHT_and_4 = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_and_4 == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_0;
							}
							if (CAUGHT_and_4 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_4;
							}
							if ((CAUGHT_and_0 == null) || (CAUGHT_and_4 == null)) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
	public boolean validateCompatibleMemberPropertyTarget(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternEdge::CompatibleMemberPropertyTarget";
		try {
			/**
			 *
			 * inv CompatibleMemberPropertyTarget:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_MEMBER_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and_0;
					try {
						final /*@NonInvalid*/ @Nullable EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
						final /*@NonInvalid*/ boolean eq = referredEStructuralFeature == null;
						final /*@NonInvalid*/ @Nullable Boolean and;
						if (!eq) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							final /*@NonInvalid*/ int sourceIndex = this.getSourceIndex();
							final /*@NonInvalid*/ @NonNull IntegerValue BOXED_sourceIndex = ValueUtil.integerValueOf(sourceIndex);
							final /*@NonInvalid*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, BOXED_sourceIndex, UMLXTables.INT_0).booleanValue();
							if (!gt) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								and = ValueUtil.TRUE_VALUE;
							}
						}
						final /*@Thrown*/ @Nullable Boolean and_0;
						if (and == ValueUtil.FALSE_VALUE) {
							and_0 = ValueUtil.FALSE_VALUE;
						}
						else {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelPatternNode target = this.getTarget();
							final /*@NonInvalid*/ boolean isExpression = target.isExpression();
							final /*@NonInvalid*/ @Nullable Boolean not;
							if (!isExpression) {
								not = ValueUtil.TRUE_VALUE;
							}
							else {
								if (isExpression) {
									not = ValueUtil.FALSE_VALUE;
								}
								else {
									not = null;
								}
							}
							if (not == ValueUtil.FALSE_VALUE) {
								and_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								if ((and == null) || (not == null)) {
									and_0 = null;
								}
								else {
									and_0 = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and_0 = and_0;
					}
					catch (Exception e) {
						CAUGHT_and_0 = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and_0 == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_or;
						try {
							/*@Caught*/ @NonNull Object CAUGHT_sourceEClass;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull RelPatternNode source = this.getSource();
								final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = source.getReferredEClassifier();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull EClass sourceEClass = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier, TYP_ecore_c_c_EClass_0);
								CAUGHT_sourceEClass = sourceEClass;
							}
							catch (Exception e) {
								CAUGHT_sourceEClass = ValueUtil.createInvalidValue(e);
							}
							/*@Caught*/ @NonNull Object CAUGHT_targetEClass;
							try {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_1 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull RelPatternNode target_0 = this.getTarget();
								final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier_0 = target_0.getReferredEClassifier();
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull EClass targetEClass = (@NonNull EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClassifier_0, TYP_ecore_c_c_EClass_1);
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
								final /*@Thrown*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, CAUGHT_sourceEClass);
								final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_1 = executor.getStaticTypeOfValue(null, oclAsSet);
								final @NonNull LibraryIterationExtension IMPL_closure_1 = (LibraryIterationExtension)TYPE_closure_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
								final @NonNull Object ACC_closure_1 = IMPL_closure_1.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
								/**
								 * Implementation of the iterator body.
								 */
								final @NonNull AbstractBinaryOperation BODY_closure_1 = new AbstractBinaryOperation() {
									/**
									 * eSuperTypes
									 */
									@Override
									public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
										final /*@NonInvalid*/ @Nullable EClass CAST_null = (EClass)_1;
										if (CAST_null == null) {
											throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
										}
										@SuppressWarnings("null")
										final /*@Thrown*/ @NonNull List<EClass> eSuperTypes = CAST_null.getESuperTypes();
										final /*@Thrown*/ @NonNull OrderedSetValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
										return BOXED_eSuperTypes;
									}
								};
								final @NonNull ExecutorSingleIterationManager MGR_closure_1 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_1, oclAsSet, ACC_closure_1);
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure_1.evaluateIteration(MGR_closure_1);
								if (CAUGHT_targetEClass instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_targetEClass;
								}
								final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(closure, CAUGHT_targetEClass).booleanValue();
								CAUGHT_includes = includes;
							}
							catch (Exception e) {
								CAUGHT_includes = ValueUtil.createInvalidValue(e);
							}
							final /*@Thrown*/ @Nullable Boolean or;
							if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_includes_0;
								try {
									if (CAUGHT_targetEClass instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_targetEClass;
									}
									final /*@Thrown*/ @NonNull SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, CAUGHT_targetEClass);
									final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0_0 = executor.getStaticTypeOfValue(null, oclAsSet_0);
									final @NonNull LibraryIterationExtension IMPL_closure_0_0 = (LibraryIterationExtension)TYPE_closure_0_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
									final @NonNull Object ACC_closure_0_0 = IMPL_closure_0_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
									/**
									 * Implementation of the iterator body.
									 */
									final @NonNull AbstractBinaryOperation BODY_closure_0_0 = new AbstractBinaryOperation() {
										/**
										 * eSuperTypes
										 */
										@Override
										public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet_0, final /*@NonInvalid*/ @Nullable Object _1_0) {
											final /*@NonInvalid*/ @Nullable EClass CAST_null_0 = (EClass)_1_0;
											if (CAST_null_0 == null) {
												throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
											}
											@SuppressWarnings("null")
											final /*@Thrown*/ @NonNull List<EClass> eSuperTypes_0 = CAST_null_0.getESuperTypes();
											final /*@Thrown*/ @NonNull OrderedSetValue BOXED_eSuperTypes_0 = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes_0);
											return BOXED_eSuperTypes_0;
										}
									};
									final @NonNull ExecutorSingleIterationManager MGR_closure_0_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0_0, oclAsSet_0, ACC_closure_0_0);
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull SetValue closure_0 = (@NonNull SetValue)IMPL_closure_0_0.evaluateIteration(MGR_closure_0_0);
									if (CAUGHT_sourceEClass instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_sourceEClass;
									}
									final /*@Thrown*/ boolean includes_0 = CollectionIncludesOperation.INSTANCE.evaluate(closure_0, CAUGHT_sourceEClass).booleanValue();
									CAUGHT_includes_0 = includes_0;
								}
								catch (Exception e) {
									CAUGHT_includes_0 = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_includes_0 == ValueUtil.TRUE_VALUE) {
									or = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_includes instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_includes;
									}
									if (CAUGHT_includes_0 instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_includes_0;
									}
									or = ValueUtil.FALSE_VALUE;
								}
							}
							CAUGHT_or = or;
						}
						catch (Exception e) {
							CAUGHT_or = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_or == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and_0 instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and_0;
							}
							if (CAUGHT_or instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_or;
							}
							if ((CAUGHT_and_0 == null) || (CAUGHT_or == null)) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
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
		result.append(" (sourceIndex: ");
		result.append(sourceIndex);
		result.append(')');
		return result.toString();
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
				return getOwningRelDomainNode();
			case 2:
				if (resolve) return getReferredEStructuralFeature();
				return basicGetReferredEStructuralFeature();
			case 3:
				if (resolve) return getSource();
				return basicGetSource();
			case 4:
				return getSourceIndex();
			case 5:
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
			case 1:
				setOwningRelDomainNode((RelDomainNode)newValue);
				return;
			case 2:
				setReferredEStructuralFeature((EStructuralFeature)newValue);
				return;
			case 3:
				setSource((RelPatternNode)newValue);
				return;
			case 4:
				setSourceIndex((Integer)newValue);
				return;
			case 5:
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
			case 1:
				setOwningRelDomainNode((RelDomainNode)null);
				return;
			case 2:
				setReferredEStructuralFeature((EStructuralFeature)null);
				return;
			case 3:
				setSource((RelPatternNode)null);
				return;
			case 4:
				setSourceIndex(SOURCE_INDEX_EDEFAULT);
				return;
			case 5:
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
			case 1:
				return getOwningRelDomainNode() != null;
			case 2:
				return referredEStructuralFeature != null;
			case 3:
				return source != null;
			case 4:
				return sourceIndex != SOURCE_INDEX_EDEFAULT;
			case 5:
				return target != null;
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
				return validateSourceIsEClass((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 1:
				return validateSourceIsClassNode((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 2:
				return validateCompatibleEAttributePropertyTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 3:
				return validateCompatibleSourceMultiplicity((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 4:
				return validateCompatibleEReferencePropertyTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 5:
				return validateCompatiblePropertySource((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 6:
				return validateCompatibleSourceIndex((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 7:
				return validateCompatibleRestPropertyTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 8:
				return validateCompatibleMemberPropertyTarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
			case 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDomainNode((RelDomainNode)otherEnd, msgs);
			case 3:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, 13, RelPatternNode.class, msgs);
				return basicSetSource((RelPatternNode)otherEnd, msgs);
			case 5:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, 8, RelPatternNode.class, msgs);
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
			case 1:
				return basicSetOwningRelDomainNode(null, msgs);
			case 3:
				return basicSetSource(null, msgs);
			case 5:
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
			case 1:
				return eInternalContainer().eInverseRemove(this, 2, RelDomainNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelPatternEdgeImpl
