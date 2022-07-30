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
package org.eclipse.qvtd.pivot.qvtrelation.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionCountOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableGreaterThanOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.SetValue.Accumulator;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl#getWhere <em>Where</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends RuleImpl implements Relation {
	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_FEATURE_COUNT = RuleImpl.RULE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_OPERATION_COUNT = RuleImpl.RULE_OPERATION_COUNT + 4;

	/**
	 * The default value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean isTopLevel = IS_TOP_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperationalImpl() <em>Operational Impl</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationalImpl()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationImplementation> operationalImpl;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected Pattern when;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected Pattern where;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTopLevel() {
		return isTopLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTopLevel(boolean newIsTopLevel) {
		boolean oldIsTopLevel = isTopLevel;
		isTopLevel = newIsTopLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 0, oldIsTopLevel, isTopLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelationImplementation> getOperationalImpl() {
		if (operationalImpl == null) {
			operationalImpl = new EObjectContainmentWithInverseEList<RelationImplementation>(RelationImplementation.class, this, RuleImpl.RULE_FEATURE_COUNT + 1, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		}
		return operationalImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, RuleImpl.RULE_FEATURE_COUNT + 2);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(Pattern newWhen, NotificationChain msgs) {
		Pattern oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 3, oldWhen, newWhen);
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
	public void setWhen(Pattern newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 3), null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 3), null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 3, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(Pattern newWhere, NotificationChain msgs) {
		Pattern oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 4, oldWhere, newWhere);
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
	public void setWhere(Pattern newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 4), null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (RuleImpl.RULE_FEATURE_COUNT + 4), null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 4, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDomainsAreRelationDomains(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Relation::DomainsAreRelationDomains";
		try {
			/**
			 *
			 * inv DomainsAreRelationDomains:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = domain->forAll(
			 *           oclIsKindOf(RelationDomain))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION___VALIDATE_DOMAINS_ARE_RELATION_DOMAINS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Domain> domain = this.getDomain();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_Domain, domain);
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
					 * oclIsKindOf(RelationDomain)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_RelationDomain = idResolver.getClass(QVTrelationTables.CLSSid_RelationDomain, null);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_RelationDomain).booleanValue();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateTopRelationOverriddenByTopRelation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Relation::TopRelationOverriddenByTopRelation";
		try {
			/**
			 *
			 * inv TopRelationOverriddenByTopRelation:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = overridden <> null and
			 *         not overridden.oclAsType(Relation).isTopLevel implies not isTopLevel
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION___VALIDATE_TOP_RELATION_OVERRIDDEN_BY_TOP_RELATION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_and;
					try {
						final /*@NonInvalid*/ @Nullable Rule overridden = this.getOverridden();
						final /*@NonInvalid*/ boolean ne = overridden != null;
						final /*@Thrown*/ @Nullable Boolean and;
						if (!ne) {
							and = ValueUtil.FALSE_VALUE;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_not;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_isTopLevel;
								try {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_Relation = idResolver.getClass(QVTrelationTables.CLSSid_Relation, null);
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull Relation oclAsType = (@NonNull Relation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, overridden, TYP_qvtrelation_c_c_Relation);
									final /*@Thrown*/ boolean isTopLevel = oclAsType.isIsTopLevel();
									CAUGHT_isTopLevel = isTopLevel;
								}
								catch (Exception e) {
									CAUGHT_isTopLevel = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_isTopLevel instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_isTopLevel;
								}
								final /*@Thrown*/ @Nullable Boolean not;
								if (CAUGHT_isTopLevel == ValueUtil.FALSE_VALUE) {
									not = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_isTopLevel == ValueUtil.TRUE_VALUE) {
										not = ValueUtil.FALSE_VALUE;
									}
									else {
										not = null;
									}
								}
								CAUGHT_not = not;
							}
							catch (Exception e) {
								CAUGHT_not = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
								and = ValueUtil.FALSE_VALUE;
							}
							else {
								if (CAUGHT_not instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_not;
								}
								if (CAUGHT_not == null) {
									and = null;
								}
								else {
									and = ValueUtil.TRUE_VALUE;
								}
							}
						}
						CAUGHT_and = and;
					}
					catch (Exception e) {
						CAUGHT_and = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (CAUGHT_and == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean isTopLevel_0 = this.isIsTopLevel();
						final /*@NonInvalid*/ @Nullable Boolean not_0;
						if (!isTopLevel_0) {
							not_0 = ValueUtil.TRUE_VALUE;
						}
						else {
							if (isTopLevel_0) {
								not_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								not_0 = null;
							}
						}
						if (not_0 == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_and instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_and;
							}
							if ((CAUGHT_and == null) || (not_0 == null)) {
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateTransformationIsRelationalTransformation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Relation::TransformationIsRelationalTransformation";
		try {
			/**
			 *
			 * inv TransformationIsRelationalTransformation:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = transformation.oclIsKindOf(RelationalTransformation)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION___VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_RelationalTransformation = idResolver.getClass(QVTrelationTables.CLSSid_RelationalTransformation, null);
					final /*@NonInvalid*/ @Nullable Transformation transformation = this.getTransformation();
					final /*@Thrown*/ boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, transformation, TYP_qvtrelation_c_c_RelationalTransformation).booleanValue();
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateVariablesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Relation::VariablesAreUnique";
		try {
			/**
			 *
			 * inv VariablesAreUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let
			 *           status : Boolean[1] = variable->isUnique(name)
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{
			 *               message = let
			 *                 namesBag : Bag(String[*|?]) = variable->collect(name)
			 *               in
			 *                 let namesSet : Set(String[*|?]) = namesBag->asSet()
			 *                 in
			 *                   let
			 *                     multiNames : OrderedSet(String) = namesSet->select(n |
			 *                       namesBag->count(n) > 1)
			 *                     ->sortedBy(n | n)
			 *                   in 'Relation::VariablesAreUnique: Multiple definitions of ' +
			 *                     multiNames->iterate(b; acc : String[1] = '' |
			 *                       let
			 *                         s : String[1] = if (b <> null)
			 *                         then '"' + b + '"'
			 *                         else 'null'
			 *                         endif
			 *                       in
			 *                         if (acc <> '')
			 *                         then acc + ',' + s
			 *                         else s
			 *                         endif) + ' in "' + transformation.name + '::' + name + '"', status = status
			 *             }
			 *           endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION___VALIDATE_VARIABLES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IF_status;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Variable> variable = this.getVariable();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_variable = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Variable, variable);
					/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTrelationTables.SET_CLSSid_Variable);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_variable.iterator();
					/*@Thrown*/ boolean status;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							status = true;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Variable _1 = (@NonNull Variable)ITERATOR__1.next();
						/**
						 * name
						 */
						final /*@NonInvalid*/ @Nullable String name = _1.getName();
						//
						if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
							status = false;
							break;			// Abort after second find
						}
						else {
							accumulator.add(name);
						}
					}
					/*@Thrown*/ @NonNull Object IF_status;
					if (status) {
						IF_status = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator_0 = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_PRIMid_String);
						@NonNull Iterator<Object> ITERATOR__1_0 = BOXED_variable.iterator();
						/*@Thrown*/ @NonNull BagValue namesBag;
						while (true) {
							if (!ITERATOR__1_0.hasNext()) {
								namesBag = accumulator_0;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull Variable _1_0 = (@NonNull Variable)ITERATOR__1_0.next();
							/**
							 * name
							 */
							final /*@NonInvalid*/ @Nullable String name_0 = _1_0.getName();
							//
							accumulator_0.add(name_0);
						}
						final /*@Thrown*/ @NonNull SetValue namesSet = CollectionAsSetOperation.INSTANCE.evaluate(namesBag);
						/*@Thrown*/ @NonNull Accumulator accumulator_1 = ValueUtil.createSetAccumulatorValue(QVTrelationTables.SET_PRIMid_String);
						@Nullable Iterator<Object> ITERATOR_n = namesSet.iterator();
						/*@Thrown*/ @NonNull SetValue select;
						while (true) {
							if (!ITERATOR_n.hasNext()) {
								select = accumulator_1;
								break;
							}
							/*@NonInvalid*/ @Nullable String n = (@Nullable String)ITERATOR_n.next();
							/**
							 * namesBag->count(n) > 1
							 */
							final /*@Thrown*/ @NonNull IntegerValue count = CollectionCountOperation.INSTANCE.evaluate(namesBag, n);
							final /*@Thrown*/ boolean gt = OclComparableGreaterThanOperation.INSTANCE.evaluate(executor, count, QVTrelationTables.INT_1).booleanValue();
							//
							if (gt == ValueUtil.TRUE_VALUE) {
								accumulator_1.add(n);
							}
						}
						final org.eclipse.ocl.pivot.@NonNull Class TYPE_multiNames_0 = executor.getStaticTypeOfValue(null, select);
						final @NonNull LibraryIterationExtension IMPL_multiNames_0 = (LibraryIterationExtension)TYPE_multiNames_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
						final @NonNull Object ACC_multiNames_0 = IMPL_multiNames_0.createAccumulatorValue(executor, QVTrelationTables.ORD_PRIMid_String, TypeId.STRING);
						/**
						 * Implementation of the iterator body.
						 */
						final @NonNull AbstractBinaryOperation BODY_multiNames_0 = new AbstractBinaryOperation() {
							/**
							 * n
							 */
							@Override
							public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object select, final /*@NonInvalid*/ @Nullable Object n_0) {
								final /*@NonInvalid*/ @Nullable String CAST_null = (String)n_0;
								return CAST_null;
							}
						};
						final @NonNull ExecutorSingleIterationManager MGR_multiNames_0 = new ExecutorSingleIterationManager(executor, QVTrelationTables.ORD_PRIMid_String, BODY_multiNames_0, select, ACC_multiNames_0);
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull OrderedSetValue multiNames = (@NonNull OrderedSetValue)IMPL_multiNames_0.evaluateIteration(MGR_multiNames_0);
						/*@NonInvalid*/ @NonNull String acc = QVTrelationTables.STR_;
						@NonNull Iterator<Object> ITERATOR_b = multiNames.iterator();
						/*@Thrown*/ @Nullable String iterate;
						while (true) {
							if (!ITERATOR_b.hasNext()) {
								iterate = acc;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ @NonNull String b = (@NonNull String)ITERATOR_b.next();
							/**
							 *
							 * let s : String[1] = if b <> null then '"' + b + '"' else 'null' endif
							 * in if acc <> '' then acc + ',' + s else s endif
							 */
							final /*@NonInvalid*/ boolean ne = true;
							/*@NonInvalid*/ @NonNull String s;
							if (ne) {
								final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTrelationTables.STR__34, b);
								final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTrelationTables.STR__34);
								s = sum_0;
							}
							else {
								s = QVTrelationTables.STR_null;
							}
							final /*@NonInvalid*/ boolean ne_0 = !acc.equals(QVTrelationTables.STR_);
							/*@NonInvalid*/ @NonNull String IF_ne_0;
							if (ne_0) {
								final /*@NonInvalid*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(acc, QVTrelationTables.STR__44);
								final /*@NonInvalid*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, s);
								IF_ne_0 = sum_2;
							}
							else {
								IF_ne_0 = s;
							}
							//
							acc = IF_ne_0;
						}
						final /*@Thrown*/ @NonNull String sum_3 = StringConcatOperation.INSTANCE.evaluate(QVTrelationTables.STR_Relation_c_c_VariablesAreUnique_c_32_Multiple_32_definitions_32_of_32, iterate);
						final /*@Thrown*/ @NonNull String sum_4 = StringConcatOperation.INSTANCE.evaluate(sum_3, QVTrelationTables.STR__32_in_32_34);
						final /*@NonInvalid*/ @Nullable Transformation transformation = this.getTransformation();
						if (transformation == null) {
							throw new InvalidValueException("Null source for \'NamedElement::name\'");
						}
						final /*@Thrown*/ @Nullable String name_1 = transformation.getName();
						final /*@Thrown*/ @NonNull String sum_5 = StringConcatOperation.INSTANCE.evaluate(sum_4, name_1);
						final /*@Thrown*/ @NonNull String sum_6 = StringConcatOperation.INSTANCE.evaluate(sum_5, QVTrelationTables.STR__c_c);
						final /*@NonInvalid*/ @Nullable String name_2 = this.getName();
						final /*@Thrown*/ @NonNull String sum_7 = StringConcatOperation.INSTANCE.evaluate(sum_6, name_2);
						final /*@Thrown*/ @NonNull String sum_8 = StringConcatOperation.INSTANCE.evaluate(sum_7, QVTrelationTables.STR__34);
						final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTrelationTables.TUPLid_, sum_8, status);
						IF_status = TUP_;
					}
					CAUGHT_IF_status = IF_status;
				}
				catch (Exception e) {
					CAUGHT_IF_status = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_IF_status, QVTrelationTables.INT_0).booleanValue();
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
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperationalImpl()).basicAdd(otherEnd, msgs);
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
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOperationalImpl()).basicRemove(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return basicSetWhen(null, msgs);
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return basicSetWhere(null, msgs);
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
			case RuleImpl.RULE_FEATURE_COUNT + 0:
				return isIsTopLevel();
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return getOperationalImpl();
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return getVariable();
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return getWhen();
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return getWhere();
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
				setIsTopLevel((Boolean)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				getOperationalImpl().clear();
				getOperationalImpl().addAll((Collection<? extends RelationImplementation>)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				setWhen((Pattern)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				setWhere((Pattern)newValue);
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
				setIsTopLevel(IS_TOP_LEVEL_EDEFAULT);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				getOperationalImpl().clear();
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				getVariable().clear();
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				setWhen((Pattern)null);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				setWhere((Pattern)null);
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
				return isTopLevel != IS_TOP_LEVEL_EDEFAULT;
			case RuleImpl.RULE_FEATURE_COUNT + 1:
				return operationalImpl != null && !operationalImpl.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 2:
				return variable != null && !variable.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 3:
				return when != null;
			case RuleImpl.RULE_FEATURE_COUNT + 4:
				return where != null;
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
			case RuleImpl.RULE_OPERATION_COUNT + 0:
				return validateDomainsAreRelationDomains((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case RuleImpl.RULE_OPERATION_COUNT + 1:
				return validateTopRelationOverriddenByTopRelation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case RuleImpl.RULE_OPERATION_COUNT + 2:
				return validateTransformationIsRelationalTransformation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case RuleImpl.RULE_OPERATION_COUNT + 3:
				return validateVariablesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		if (visitor instanceof QVTrelationVisitor) {
			return (R) ((QVTrelationVisitor<?>)visitor).visitRelation(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //RelationImpl
