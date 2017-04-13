/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl#getOverridden <em>Overridden</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RuleImpl extends NamedElementImpl implements Rule {
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
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected Rule overrides;

	/**
	 * The cached value of the '{@link #getOverridden() <em>Overridden</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridden()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> overridden;

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
			domain = new EObjectContainmentWithInverseEList<Domain>(Domain.class, this, QVTbasePackage.RULE__DOMAIN, QVTbasePackage.DOMAIN__RULE);
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.RULE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject)overrides;
			overrides = (Rule)eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTbasePackage.RULE__OVERRIDES, oldOverrides, overrides));
			}
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOverrides(Rule newOverrides, NotificationChain msgs) {
		Rule oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTbasePackage.RULE__OVERRIDES, oldOverrides, newOverrides);
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
	public void setOverrides(Rule newOverrides) {
		if (newOverrides != overrides) {
			NotificationChain msgs = null;
			if (overrides != null)
				msgs = ((InternalEObject)overrides).eInverseRemove(this, QVTbasePackage.RULE__OVERRIDDEN, Rule.class, msgs);
			if (newOverrides != null)
				msgs = ((InternalEObject)newOverrides).eInverseAdd(this, QVTbasePackage.RULE__OVERRIDDEN, Rule.class, msgs);
			msgs = basicSetOverrides(newOverrides, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.RULE__OVERRIDES, newOverrides, newOverrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getTransformation() {
		if (eContainerFeatureID() != QVTbasePackage.RULE__TRANSFORMATION) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QVTbasePackage.RULE__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != QVTbasePackage.RULE__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QVTbasePackage.TRANSFORMATION__RULE, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.RULE__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Rule> getOverridden() {
		if (overridden == null) {
			overridden = new EObjectWithInverseResolvingEList<Rule>(Rule.class, this, QVTbasePackage.RULE__OVERRIDDEN, QVTbasePackage.RULE__OVERRIDES);
		}
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDomainNameIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv DomainNameIsUnique:
		 *   let severity : Integer[1] = 'Rule::DomainNameIsUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = domain->isUnique(name)
		 *       in
		 *         'Rule::DomainNameIsUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Rule_c_c_DomainNameIsUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<Domain> domain = this.getDomain();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_Domain, domain);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTbaseTables.ORD_CLSSid_Domain);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_domain.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain _1 = (Domain)ITERATOR__1.next();
					/**
					 * name
					 */
					final /*@NonInvalid*/ java.lang.@Nullable String name = _1.getName();
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
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Rule_c_c_DomainNameIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public boolean validateNoOverridesCycle(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NoOverridesCycle:
		 *   let severity : Integer[1] = 'Rule::NoOverridesCycle'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = overrides->closure(overrides)
		 *         ->excludes(self)
		 *       in
		 *         'Rule::NoOverridesCycle'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Rule_c_c_NoOverridesCycle);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Rule overrides = this.getOverrides();
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTbaseTables.SET_CLSSid_Rule, overrides);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
				final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
				final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, QVTbaseTables.SET_CLSSid_Rule, QVTbaseTables.CLSSid_Rule);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
					/**
					 * overrides
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@Nullable Object _1) {
						final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Rule symbol_0 = (Rule)_1;
						if (symbol_0 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Rule::overrides\'");
						}
						final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Rule overrides_0 = symbol_0.getOverrides();
						return overrides_0;
					}
				};
				final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, QVTbaseTables.SET_CLSSid_Rule, BODY_closure_0, oclAsSet, ACC_closure_0);
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
				final /*@Thrown*/ boolean result = CollectionExcludesOperation.INSTANCE.evaluate(closure, this).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Rule_c_c_NoOverridesCycle, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public boolean validateOverridesRuleIsExtendedRule(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv OverridesRuleIsExtendedRule:
		 *   let
		 *     severity : Integer[1] = 'Rule::OverridesRuleIsExtendedRule'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = overrides <> null and transformation <> null implies
		 *         let
		 *           extendedRules : Bag(qvtbase::Rule) = transformation->closure(extends)
		 *           ->excluding(transformation)
		 *           ?->collect(rule)
		 *         in extendedRules->includes(overrides)
		 *       in
		 *         'Rule::OverridesRuleIsExtendedRule'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Rule_c_c_OverridesRuleIsExtendedRule);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Rule overrides_0 = this.getOverrides();
				final /*@NonInvalid*/ boolean ne = overrides_0 != null;
				/*@NonInvalid*/ boolean and;
				if (ne) {
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne_0 = transformation != null;
					and = ne_0;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				/*@Thrown*/ boolean result;
				if (and) {
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation transformation_1 = this.getTransformation();
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTbaseTables.SET_CLSSid_Transformation, transformation_1);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
					final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
					final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, QVTbaseTables.SET_CLSSid_Transformation, QVTbaseTables.CLSSid_Transformation);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
						/**
						 * extends
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@Nullable Object _1) {
							final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation symbol_0 = (Transformation)_1;
							if (symbol_0 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::extends\'");
							}
							final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Transformation symbol_1 = symbol_0.getExtends();
							return symbol_1;
						}
					};
					final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, QVTbaseTables.SET_CLSSid_Transformation, BODY_closure_0, oclAsSet, ACC_closure_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue excluding = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(closure, transformation_1);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue safe_null_sources = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(excluding, (Object)null);
					/*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTbaseTables.BAG_CLSSid_Rule);
					@NonNull Iterator<Object> ITERATOR__1_0 = safe_null_sources.iterator();
					/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull BagValue extendedRules;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							extendedRules = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation _1_0 = (Transformation)ITERATOR__1_0.next();
						/**
						 * rule
						 */
						final /*@NonInvalid*/ java.util.@NonNull List<Rule> rule = _1_0.getRule();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_rule = idResolver.createSetOfAll(QVTbaseTables.SET_CLSSid_Rule, rule);
						//
						for (Object value : BOXED_rule.flatten().getElements()) {
							accumulator.add(value);
						}
					}
					final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(extendedRules, overrides_0).booleanValue();
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
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Rule_c_c_OverridesRuleIsExtendedRule, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
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
	public boolean validateOverridesRuleOverridesAllDomains(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv OverridesRuleOverridesAllDomains:
		 *   let
		 *     severity : Integer[1] = 'Rule::OverridesRuleOverridesAllDomains'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = overrides <> null implies
		 *         overrides.domain->forAll(od |
		 *           self.domain.name->includes(od.name))
		 *       in
		 *         'Rule::OverridesRuleOverridesAllDomains'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbaseTables.STR_Rule_c_c_OverridesRuleOverridesAllDomains);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Rule overrides = this.getOverrides();
				final /*@NonInvalid*/ boolean ne = overrides != null;
				/*@Thrown*/ boolean result;
				if (ne) {
					if (overrides == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Rule::domain\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ java.util.@NonNull List<Domain> domain = overrides.getDomain();
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_Domain, domain);
					/*@Thrown*/ java.lang.@Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR_od = BOXED_domain.iterator();
					/*@Thrown*/ boolean forAll;
					while (true) {
						if (!ITERATOR_od.hasNext()) {
							if (accumulator == ValueUtil.TRUE_VALUE) {
								forAll = ValueUtil.TRUE_VALUE;
							}
							else {
								throw (InvalidValueException)accumulator;
							}
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain od = (Domain)ITERATOR_od.next();
						/**
						 * self.domain.name->includes(od.name)
						 */
						/*@Caught*/ @NonNull Object CAUGHT_includes;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ java.util.@NonNull List<Domain> domain_0 = this.getDomain();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_domain_0 = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_Domain, domain_0);
							/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(QVTbaseTables.SEQ_PRIMid_String);
							@NonNull Iterator<Object> ITERATOR__1 = BOXED_domain_0.iterator();
							/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									collect = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain _1 = (Domain)ITERATOR__1.next();
								/**
								 * name
								 */
								final /*@NonInvalid*/ java.lang.@Nullable String name = _1.getName();
								//
								accumulator_0.add(name);
							}
							final /*@NonInvalid*/ java.lang.@Nullable String name_0 = od.getName();
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, name_0).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception e) {
							CAUGHT_includes = ValueUtil.createInvalidValue(e);
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
					result = forAll;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTbaseTables.STR_Rule_c_c_OverridesRuleOverridesAllDomains, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case QVTbasePackage.RULE__DOMAIN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDomain()).basicAdd(otherEnd, msgs);
			case QVTbasePackage.RULE__OVERRIDES:
				if (overrides != null)
					msgs = ((InternalEObject)overrides).eInverseRemove(this, QVTbasePackage.RULE__OVERRIDDEN, Rule.class, msgs);
				return basicSetOverrides((Rule)otherEnd, msgs);
			case QVTbasePackage.RULE__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
			case QVTbasePackage.RULE__OVERRIDDEN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOverridden()).basicAdd(otherEnd, msgs);
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
			case QVTbasePackage.RULE__DOMAIN:
				return ((InternalEList<?>)getDomain()).basicRemove(otherEnd, msgs);
			case QVTbasePackage.RULE__OVERRIDES:
				return basicSetOverrides(null, msgs);
			case QVTbasePackage.RULE__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
			case QVTbasePackage.RULE__OVERRIDDEN:
				return ((InternalEList<?>)getOverridden()).basicRemove(otherEnd, msgs);
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
			case QVTbasePackage.RULE__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTbasePackage.TRANSFORMATION__RULE, Transformation.class, msgs);
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
			case QVTbasePackage.RULE__DOMAIN:
				return getDomain();
			case QVTbasePackage.RULE__IS_ABSTRACT:
				return isIsAbstract();
			case QVTbasePackage.RULE__OVERRIDES:
				if (resolve) return getOverrides();
				return basicGetOverrides();
			case QVTbasePackage.RULE__TRANSFORMATION:
				return getTransformation();
			case QVTbasePackage.RULE__OVERRIDDEN:
				return getOverridden();
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
			case QVTbasePackage.RULE__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends Domain>)newValue);
				return;
			case QVTbasePackage.RULE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case QVTbasePackage.RULE__OVERRIDES:
				setOverrides((Rule)newValue);
				return;
			case QVTbasePackage.RULE__TRANSFORMATION:
				setTransformation((Transformation)newValue);
				return;
			case QVTbasePackage.RULE__OVERRIDDEN:
				getOverridden().clear();
				getOverridden().addAll((Collection<? extends Rule>)newValue);
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
			case QVTbasePackage.RULE__DOMAIN:
				getDomain().clear();
				return;
			case QVTbasePackage.RULE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case QVTbasePackage.RULE__OVERRIDES:
				setOverrides((Rule)null);
				return;
			case QVTbasePackage.RULE__TRANSFORMATION:
				setTransformation((Transformation)null);
				return;
			case QVTbasePackage.RULE__OVERRIDDEN:
				getOverridden().clear();
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
			case QVTbasePackage.RULE__DOMAIN:
				return domain != null && !domain.isEmpty();
			case QVTbasePackage.RULE__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case QVTbasePackage.RULE__OVERRIDES:
				return overrides != null;
			case QVTbasePackage.RULE__TRANSFORMATION:
				return getTransformation() != null;
			case QVTbasePackage.RULE__OVERRIDDEN:
				return overridden != null && !overridden.isEmpty();
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
			case QVTbasePackage.RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateDomainNameIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.RULE___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP:
				return validateNoOverridesCycle((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.RULE___VALIDATE_OVERRIDES_RULE_IS_EXTENDED_RULE__DIAGNOSTICCHAIN_MAP:
				return validateOverridesRuleIsExtendedRule((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTbasePackage.RULE___VALIDATE_OVERRIDES_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP:
				return validateOverridesRuleOverridesAllDomains((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}
} //RuleImpl
