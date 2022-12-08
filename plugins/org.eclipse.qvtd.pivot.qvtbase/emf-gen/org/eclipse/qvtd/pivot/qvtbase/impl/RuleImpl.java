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
package org.eclipse.qvtd.pivot.qvtbase.impl;

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
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseSupport;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RuleImpl extends NamedElementImpl implements Rule {
	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domain;

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
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected Rule overridden;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> overrides;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Domain> getDomain() {
		if (domain == null) {
			domain = new EObjectContainmentWithInverseEList<Domain>(Domain.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		}
		return domain;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Rule> getOverrides() {
		if (overrides == null) {
			overrides = new EObjectWithInverseResolvingEList<Rule>(Rule.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getTransformation() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4)) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4) && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, ClassImpl.CLASS_FEATURE_COUNT + 3, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getOverridden() {
		if (overridden != null && overridden.eIsProxy()) {
			InternalEObject oldOverridden = (InternalEObject)overridden;
			overridden = (Rule)eResolveProxy(oldOverridden);
			if (overridden != oldOverridden) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldOverridden, overridden));
			}
		}
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOverridden(Rule newOverridden, NotificationChain msgs) {
		Rule oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldOverridden, newOverridden);
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
	public void setOverridden(Rule newOverridden) {
		if (newOverridden != overridden) {
			NotificationChain msgs = null;
			if (overridden != null)
				msgs = ((InternalEObject)overridden).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Rule.class, msgs);
			if (newOverridden != null)
				msgs = ((InternalEObject)newOverridden).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Rule.class, msgs);
			msgs = basicSetOverridden(newOverridden, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, newOverridden, newOverridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDomainNameIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Rule::DomainNameIsUnique";
		try {
			/**
			 *
			 * inv DomainNameIsUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = domain->isUnique(name)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_isUnique;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Domain> domain_0 = this.getDomain();
					final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_Domain, domain_0);
					/*@NonInvalid*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTbaseSupport.ORD_CLSSid_Domain);
					@NonNull Iterator<Object> ITER__1 = BOXED_domain.iterator();
					/*@Thrown*/ boolean isUnique;
					while (true) {
						if (!ITER__1.hasNext()) {
							isUnique = ValueUtil.TRUE_VALUE;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Domain _1 = (@NonNull Domain)ITER__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
						//
						if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
							isUnique = false;
							break;			// Abort after second find
						}
						else {
							accumulator.add(name);
						}
					}
					CAUGHT_isUnique = isUnique;
				}
				catch (Exception THROWN_CAUGHT_isUnique) {
					CAUGHT_isUnique = ValueUtil.createInvalidValue(THROWN_CAUGHT_isUnique);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_isUnique, QVTbaseSupport.INT_0).booleanValue();
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
	public boolean validateAtLeastOneDomainIsCheckableOrEnforceable(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Rule::AtLeastOneDomainIsCheckableOrEnforceable";
		try {
			/**
			 *
			 * inv AtLeastOneDomainIsCheckableOrEnforceable:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = domain->notEmpty() implies
			 *         domain->exists(isCheckable or isEnforceable)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.RULE___VALIDATE_AT_LEAST_ONE_DOMAIN_IS_CHECKABLE_OR_ENFORCEABLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Domain> domain_0 = this.getDomain();
					final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_Domain, domain_0);
					final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_domain).booleanValue();
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!notEmpty) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_exists;
						try {
							/*@Thrown*/ @Nullable Object accumulator = ValueUtil.FALSE_VALUE;
							@NonNull Iterator<Object> ITER__1 = BOXED_domain.iterator();
							/*@Thrown*/ @Nullable Boolean exists;
							while (true) {
								if (!ITER__1.hasNext()) {
									if (accumulator == null) {
										exists = null;
									}
									else if (accumulator == ValueUtil.FALSE_VALUE) {
										exists = ValueUtil.FALSE_VALUE;
									}
									else {
										throw (InvalidValueException)accumulator;
									}
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Domain _1 = (@NonNull Domain)ITER__1.next();
								/**
								 * isCheckable or isEnforceable
								 */
								final /*@NonInvalid*/ boolean isCheckable = _1.isIsCheckable();
								final /*@NonInvalid*/ @Nullable Boolean or;
								if (isCheckable) {
									or = ValueUtil.TRUE_VALUE;
								}
								else {
									final /*@NonInvalid*/ boolean isEnforceable = _1.isIsEnforceable();
									if (isEnforceable) {
										or = ValueUtil.TRUE_VALUE;
									}
									else {
										or = ValueUtil.FALSE_VALUE;
									}
								}
								//
								if (or == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
									exists = ValueUtil.TRUE_VALUE;
									break;														// Stop immediately
								}
								else if (or == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
									;															// Carry on
								}
								else if (or == null) {								// Abnormal null body evaluation result
									if (accumulator == ValueUtil.FALSE_VALUE) {
										accumulator = null;										// Cache a null failure
									}
								}
								else {															// Impossible badly typed result
									accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
								}
							}
							CAUGHT_exists = exists;
						}
						catch (Exception THROWN_CAUGHT_exists) {
							CAUGHT_exists = ValueUtil.createInvalidValue(THROWN_CAUGHT_exists);
						}
						if (CAUGHT_exists == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_exists instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_exists;
							}
							if (CAUGHT_exists == null) {
								implies = null;
							}
							else {
								implies = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTbaseSupport.INT_0).booleanValue();
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
	public boolean validateNoOverridesCycle(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Rule::NoOverridesCycle";
		try {
			/**
			 *
			 * inv NoOverridesCycle:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = overridden->closure(overridden)
			 *         ->excludes(self)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.RULE___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_excludes;
				try {
					final /*@NonInvalid*/ @Nullable Rule overridden_0 = this.getOverridden();
					final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTbaseSupport.SET_CLSSid_Rule_0, overridden_0);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure = executor.getStaticTypeOfValue(null, oclAsSet);
					final @NonNull LibraryIterationExtension IMPL_closure = (LibraryIterationExtension)TYPE_closure.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
					final @NonNull Object ACC_closure = IMPL_closure.createAccumulatorValue(executor, QVTbaseSupport.SET_CLSSid_Rule, QVTbaseSupport.CLSSid_Rule);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure = new AbstractBinaryOperation() {
						/**
						 * overridden
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ @Nullable Object _1) {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Rule CAST_1_ = (@NonNull Rule)_1;
							final /*@NonInvalid*/ @Nullable Rule overridden_1 = CAST_1_.getOverridden();
							return overridden_1;
						}
					};
					final @NonNull ExecutorSingleIterationManager MGR_closure = new ExecutorSingleIterationManager(executor, QVTbaseSupport.SET_CLSSid_Rule, BODY_closure, oclAsSet, ACC_closure);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure.evaluateIteration(MGR_closure);
					final /*@Thrown*/ boolean excludes = CollectionExcludesOperation.INSTANCE.evaluate(closure, this).booleanValue();
					CAUGHT_excludes = excludes;
				}
				catch (Exception THROWN_CAUGHT_excludes) {
					CAUGHT_excludes = ValueUtil.createInvalidValue(THROWN_CAUGHT_excludes);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_excludes, QVTbaseSupport.INT_0).booleanValue();
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
	public boolean validateAbstractRuleIsOverridden(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Rule::AbstractRuleIsOverridden";
		try {
			/**
			 *
			 * inv AbstractRuleIsOverridden:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = isAbstract implies overrides->notEmpty()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.RULE___VALIDATE_ABSTRACT_RULE_IS_OVERRIDDEN__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ boolean isAbstract_0 = this.isIsAbstract();
				final /*@NonInvalid*/ @Nullable Boolean implies;
				if (!isAbstract_0) {
					implies = ValueUtil.TRUE_VALUE;
				}
				else {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Rule> overrides_0 = this.getOverrides();
					final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_overrides = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_Rule, overrides_0);
					final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_overrides).booleanValue();
					if (notEmpty) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						implies = ValueUtil.FALSE_VALUE;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, implies, QVTbaseSupport.INT_0).booleanValue();
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
	public boolean validateOverridingRuleOverridesAllDomains(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Rule::OverridingRuleOverridesAllDomains";
		try {
			/**
			 *
			 * inv OverridingRuleOverridesAllDomains:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = overridden <> null implies
			 *         overridden.domain->forAll(od |
			 *           self.domain.name->includes(od.name))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.RULE___VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable Rule overridden_0 = this.getOverridden();
					final /*@NonInvalid*/ boolean IsEQ_ = overridden_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_forAll;
						try {
							if (overridden_0 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Rule::domain\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<Domain> domain_0 = overridden_0.getDomain();
							final /*@Thrown*/ @Nullable OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_Domain, domain_0);
							/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
							@NonNull Iterator<Object> ITER_od = BOXED_domain.iterator();
							/*@Thrown*/ @Nullable Boolean forAll;
							while (true) {
								if (!ITER_od.hasNext()) {
									if (accumulator == ValueUtil.TRUE_VALUE) {
										forAll = ValueUtil.TRUE_VALUE;
									}
									else {
										throw (InvalidValueException)accumulator;
									}
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Domain od = (@NonNull Domain)ITER_od.next();
								/**
								 * self.domain.name->includes(od.name)
								 */
								/*@Caught*/ @Nullable Object CAUGHT_includes;
								try {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ @NonNull List<Domain> domain_1 = this.getDomain();
									final /*@NonInvalid*/ @Nullable OrderedSetValue BOXED_domain_0 = idResolver.createOrderedSetOfAll(QVTbaseSupport.ORD_CLSSid_Domain, domain_1);
									/*@NonInvalid*/ org.eclipse.ocl.pivot.values.SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(QVTbaseSupport.SEQ_PRIMid_String);
									@NonNull Iterator<Object> ITER__1 = BOXED_domain_0.iterator();
									/*@Thrown*/ @NonNull SequenceValue collect;
									while (true) {
										if (!ITER__1.hasNext()) {
											collect = accumulator_0;
											break;
										}
										@SuppressWarnings("null")
										/*@NonInvalid*/ @NonNull Domain _1 = (@NonNull Domain)ITER__1.next();
										/**
										 * name
										 */
										final /*@NonInvalid*/ @Nullable String name_0 = _1.getName();
										//
										accumulator_0.add(name_0);
									}
									final /*@NonInvalid*/ @Nullable String name = od.getName();
									final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, name).booleanValue();
									CAUGHT_includes = includes;
								}
								catch (Exception THROWN_CAUGHT_includes) {
									CAUGHT_includes = ValueUtil.createInvalidValue(THROWN_CAUGHT_includes);
								}
								//
								if (CAUGHT_includes == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
									forAll = ValueUtil.FALSE_VALUE;
									break;														// Stop immediately
								}
								else if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
									;															// Carry on
								}
								else if (CAUGHT_includes instanceof InvalidValueException) {		// Abnormal exception evaluation result
									accumulator = CAUGHT_includes;									// Cache an exception failure
								}
								else {															// Impossible badly typed result
									accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
								}
							}
							CAUGHT_forAll = forAll;
						}
						catch (Exception THROWN_CAUGHT_forAll) {
							CAUGHT_forAll = ValueUtil.createInvalidValue(THROWN_CAUGHT_forAll);
						}
						if (CAUGHT_forAll == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_forAll instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_forAll;
							}
							if (CAUGHT_forAll == null) {
								implies = null;
							}
							else {
								implies = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTbaseSupport.INT_0).booleanValue();
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
	 * @generated NOT
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDomain()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (overridden != null)
					msgs = ((InternalEObject)overridden).eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, Rule.class, msgs);
				return basicSetOverridden((Rule)otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOverrides()).basicAdd(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getDomain()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return basicSetOverridden(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOverrides()).basicRemove(otherEnd, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return basicSetTransformation(null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return eInternalContainer().eInverseRemove(this, ClassImpl.CLASS_FEATURE_COUNT + 3, Transformation.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getDomain();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isIsAbstract();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (resolve) return getOverridden();
				return basicGetOverridden();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOverrides();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getTransformation();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getDomain().clear();
				getDomain().addAll((Collection<? extends Domain>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsAbstract((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOverridden((Rule)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOverrides().clear();
				getOverrides().addAll((Collection<? extends Rule>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setTransformation((Transformation)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				getDomain().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setOverridden((Rule)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				getOverrides().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setTransformation((Transformation)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return domain != null && !domain.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return overridden != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return overrides != null && !overrides.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getTransformation() != null;
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0:
				return validateDomainNameIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1:
				return validateAtLeastOneDomainIsCheckableOrEnforceable((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2:
				return validateNoOverridesCycle((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 3:
				return validateAbstractRuleIsOverridden((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 4:
				return validateOverridingRuleOverridesAllDomains((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}
} //RuleImpl
