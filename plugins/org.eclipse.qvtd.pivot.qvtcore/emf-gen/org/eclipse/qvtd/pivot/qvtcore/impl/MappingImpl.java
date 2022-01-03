/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.impl;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getRefinement <em>Refinement</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends RuleImpl implements Mapping {
	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_FEATURE_COUNT = RuleImpl.RULE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_OPERATION_COUNT = RuleImpl.RULE_OPERATION_COUNT + 3;

	/**
	 * The cached value of the '{@link #getGuardPattern() <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPattern guardPattern;

	/**
	 * The cached value of the '{@link #getBottomPattern() <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPattern bottomPattern;

	/**
	 * The cached value of the '{@link #getLocal() <em>Local</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocal()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> local;

	/**
	 * The cached value of the '{@link #getRefinement() <em>Refinement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinement()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> refinement;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> specification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardPattern getGuardPattern() {
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardPattern(GuardPattern newGuardPattern, NotificationChain msgs) {
		GuardPattern oldGuardPattern = guardPattern;
		guardPattern = newGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 0, oldGuardPattern, newGuardPattern);
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
	public void setGuardPattern(GuardPattern newGuardPattern) {
		if (newGuardPattern != guardPattern) {
			NotificationChain msgs = null;
			if (guardPattern != null)
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, PatternImpl.PATTERN_FEATURE_COUNT + 1, GuardPattern.class, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, PatternImpl.PATTERN_FEATURE_COUNT + 1, GuardPattern.class, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 0, newGuardPattern, newGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottomPattern getBottomPattern() {
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPattern newBottomPattern, NotificationChain msgs) {
		BottomPattern oldBottomPattern = bottomPattern;
		bottomPattern = newBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 1, oldBottomPattern, newBottomPattern);
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
	public void setBottomPattern(BottomPattern newBottomPattern) {
		if (newBottomPattern != bottomPattern) {
			NotificationChain msgs = null;
			if (bottomPattern != null)
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, PatternImpl.PATTERN_FEATURE_COUNT + 1, BottomPattern.class, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, PatternImpl.PATTERN_FEATURE_COUNT + 1, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 1, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getSpecification() {
		if (specification == null) {
			specification = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, RuleImpl.RULE_FEATURE_COUNT + 5, RuleImpl.RULE_FEATURE_COUNT + 4);
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDomainsAreCoreDomains(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Mapping::DomainsAreCoreDomains";
		try {
			/**
			 *
			 * inv DomainsAreCoreDomains:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = domain->forAll(oclIsKindOf(CoreDomain))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_1;
			if (le) {
				symbol_1 = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Domain> domain = this.getDomain();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTcoreTables.ORD_CLSSid_Domain, domain);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_domain.iterator();
				/*@NonInvalid*/ @Nullable Boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Domain _1 = (@NonNull Domain)ITERATOR__1.next();
					/**
					 * oclIsKindOf(CoreDomain)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtcore_c_c_CoreDomain = idResolver.getClass(QVTcoreTables.CLSSid_CoreDomain, null);
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class symbol_0 = (org.eclipse.ocl.pivot.Class)TYP_qvtcore_c_c_CoreDomain;
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, symbol_0).booleanValue();
					//
					if (!oclIsKindOf) {					// Normal unsuccessful body evaluation result
						result = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (oclIsKindOf) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
				symbol_1 = logDiagnostic;
			}
			return symbol_1;
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
	public boolean validateNestedNameIsNull(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Mapping::NestedNameIsNull";
		try {
			/**
			 *
			 * inv NestedNameIsNull:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = context <> null implies name = null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable Mapping context_0 = this.getContext();
				final /*@NonInvalid*/ boolean ne = context_0 != null;
				final /*@NonInvalid*/ @Nullable Boolean result;
				if (!ne) {
					result = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @Nullable String name = this.getName();
					final /*@NonInvalid*/ boolean eq = name == null;
					if (eq) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						result = ValueUtil.FALSE_VALUE;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
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
	public boolean validateRootNameIsNotNull(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Mapping::RootNameIsNotNull";
		try {
			/**
			 *
			 * inv RootNameIsNotNull:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies name <> null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable Transformation transformation = this.getTransformation();
				final /*@NonInvalid*/ boolean ne = transformation != null;
				final /*@NonInvalid*/ @Nullable Boolean result;
				if (!ne) {
					result = ValueUtil.TRUE_VALUE;
				}
				else {
					final /*@NonInvalid*/ @Nullable String name = this.getName();
					final /*@NonInvalid*/ boolean ne_0 = name != null;
					if (ne_0) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						result = ValueUtil.FALSE_VALUE;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
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
	public EList<Mapping> getLocal() {
		if (local == null) {
			local = new EObjectContainmentWithInverseEList<Mapping>(Mapping.class, this, RuleImpl.RULE_FEATURE_COUNT + 3, RuleImpl.RULE_FEATURE_COUNT + 2);
		}
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping getContext() {
		if (eContainerFeatureID() != (RuleImpl.RULE_FEATURE_COUNT + 2)) return null;
		return (Mapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Mapping newContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContext, RuleImpl.RULE_FEATURE_COUNT + 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(Mapping newContext) {
		if (newContext != eInternalContainer() || (eContainerFeatureID() != (RuleImpl.RULE_FEATURE_COUNT + 2) && newContext != null)) {
			if (EcoreUtil.isAncestor(this, newContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, RuleImpl.RULE_FEATURE_COUNT + 3, Mapping.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 2, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getRefinement() {
		if (refinement == null) {
			refinement = new EObjectWithInverseResolvingEList.ManyInverse<Mapping>(Mapping.class, this, RuleImpl.RULE_FEATURE_COUNT + 4, RuleImpl.RULE_FEATURE_COUNT + 5);
		}
		return refinement;
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				if (guardPattern != null)
					msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 0), null, msgs);
				return basicSetGuardPattern((GuardPattern)otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				if (bottomPattern != null)
					msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 1), null, msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContext((Mapping)otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocal()).basicAdd(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefinement()).basicAdd(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecification()).basicAdd(otherEnd, msgs);
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				return basicSetGuardPattern(null, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return basicSetBottomPattern(null, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return basicSetContext(null, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getLocal()).basicRemove(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getRefinement()).basicRemove(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return ((InternalEList<?>)getSpecification()).basicRemove(otherEnd, msgs);
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
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return eInternalContainer().eInverseRemove(this, RuleImpl.RULE_FEATURE_COUNT + 3, Mapping.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				return getGuardPattern();
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return getBottomPattern();
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return getContext();
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return getLocal();
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return getRefinement();
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return getSpecification();
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				setGuardPattern((GuardPattern)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				setBottomPattern((BottomPattern)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				setContext((Mapping)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				getLocal().clear();
				getLocal().addAll((Collection<? extends Mapping>)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				getRefinement().clear();
				getRefinement().addAll((Collection<? extends Mapping>)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				getSpecification().clear();
				getSpecification().addAll((Collection<? extends Mapping>)newValue);
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				setGuardPattern((GuardPattern)null);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				setBottomPattern((BottomPattern)null);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				setContext((Mapping)null);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				getLocal().clear();
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				getRefinement().clear();
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				getSpecification().clear();
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				return guardPattern != null;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return bottomPattern != null;
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return getContext() != null;
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return local != null && !local.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return refinement != null && !refinement.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return specification != null && !specification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Area.class) {
			switch (derivedFeatureID) {
				case RuleImpl.RULE_FEATURE_COUNT + 0: return ElementImpl.ELEMENT_FEATURE_COUNT + 0;
				case RuleImpl.RULE_FEATURE_COUNT + 1: return ElementImpl.ELEMENT_FEATURE_COUNT + 1;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Area.class) {
			switch (baseFeatureID) {
				case ElementImpl.ELEMENT_FEATURE_COUNT + 0: return RuleImpl.RULE_FEATURE_COUNT + 0;
				case ElementImpl.ELEMENT_FEATURE_COUNT + 1: return RuleImpl.RULE_FEATURE_COUNT + 1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
			case RuleImpl.RULE_OPERATION_COUNT + 0:
				return validateDomainsAreCoreDomains((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case RuleImpl.RULE_OPERATION_COUNT + 1:
				return validateNestedNameIsNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case RuleImpl.RULE_OPERATION_COUNT + 2:
				return validateRootNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTcoreVisitor) {
			return (R) ((QVTcoreVisitor<?>)visitor).visitMapping(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //MappingImpl
