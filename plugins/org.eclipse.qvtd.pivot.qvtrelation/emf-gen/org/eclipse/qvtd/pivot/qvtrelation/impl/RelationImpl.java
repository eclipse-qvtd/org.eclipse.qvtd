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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
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
	public static final int RELATION_OPERATION_COUNT = RuleImpl.RULE_OPERATION_COUNT + 3;

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
			/*@NonInvalid*/ boolean symbol_1;
			if (le) {
				symbol_1 = true;
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
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class symbol_0 = (org.eclipse.ocl.pivot.Class)TYP_qvtrelation_c_c_RelationDomain;
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTrelationTables.INT_0).booleanValue();
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
			/*@NonInvalid*/ boolean symbol_1;
			if (le) {
				symbol_1 = true;
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
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class symbol_0 = (org.eclipse.ocl.pivot.Class)TYP_qvtrelation_c_c_Relation;
									@SuppressWarnings("null")
									final /*@Thrown*/ @NonNull Relation oclAsType = (@NonNull Relation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, overridden, symbol_0);
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
			/*@NonInvalid*/ boolean symbol_1;
			if (le) {
				symbol_1 = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_RelationalTransformation = idResolver.getClass(QVTrelationTables.CLSSid_RelationalTransformation, null);
					final /*@NonInvalid*/ @Nullable Transformation transformation = this.getTransformation();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class symbol_0 = (org.eclipse.ocl.pivot.Class)TYP_qvtrelation_c_c_RelationalTransformation;
					final /*@Thrown*/ boolean result = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, transformation, symbol_0).booleanValue();
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
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
