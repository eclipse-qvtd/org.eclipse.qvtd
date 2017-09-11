/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.OCLExpressionImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl#getReferredRelation <em>Referred Relation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationCallExpImpl extends OCLExpressionImpl implements RelationCallExp {
	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> argument;

	/**
	 * The cached value of the '{@link #getReferredRelation() <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelation()
	 * @generated
	 * @ordered
	 */
	protected Relation referredRelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OCLExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Relation getReferredRelation() {
		if (referredRelation != null && referredRelation.eIsProxy()) {
			InternalEObject oldReferredRelation = (InternalEObject)referredRelation;
			referredRelation = (Relation)eResolveProxy(oldReferredRelation);
			if (referredRelation != oldReferredRelation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
			}
		}
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation basicGetReferredRelation() {
		return referredRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRelation(Relation newReferredRelation) {
		Relation oldReferredRelation = referredRelation;
		referredRelation = newReferredRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION, oldReferredRelation, referredRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMatchingArgumentCount(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv MatchingArgumentCount:
		 *   let
		 *     severity : Integer[1] = 'RelationCallExp::MatchingArgumentCount'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = self.argument->size() =
		 *         self.referredRelation.domain.oclAsType(RelationDomain)
		 *         .rootVariable->size()
		 *       in
		 *         'RelationCallExp::MatchingArgumentCount'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_RelationCallExp_c_c_MatchingArgumentCount);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<OCLExpression> argument = this.getArgument();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_OCLExpression, argument);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_argument);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation referredRelation = this.getReferredRelation();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<Domain> domain = referredRelation.getDomain();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_Domain, domain);
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_RelationDomain);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_domain.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect_0;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						collect_0 = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain _1 = (Domain)ITERATOR__1.next();
					/**
					 * oclAsType(RelationDomain)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_RelationDomain_0 = idResolver.getClass(QVTrelationTables.CLSSid_RelationDomain, null);
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain oclAsType = ClassUtil.nonNullState((RelationDomain)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_RelationDomain_0));
					//
					accumulator.add(oclAsType);
				}
				/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_Variable);
				@NonNull Iterator<Object> ITERATOR__1_0 = collect_0.iterator();
				/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
				while (true) {
					if (!ITERATOR__1_0.hasNext()) {
						collect = accumulator_0;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain _1_0 = (RelationDomain)ITERATOR__1_0.next();
					/**
					 * rootVariable
					 */
					final /*@NonInvalid*/ java.util.@NonNull List<Variable> rootVariable = _1_0.getRootVariable();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_rootVariable = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_Variable, rootVariable);
					//
					for (Object value : BOXED_rootVariable.flatten().getElements()) {
						accumulator_0.add(value);
					}
				}
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(collect);
				final /*@Thrown*/ boolean result = size.equals(size_0);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_RelationCallExp_c_c_MatchingArgumentCount, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateWhereInvocationIsANonTopRelation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv WhereInvocationIsANonTopRelation:
		 *   let
		 *     severity : Integer[1] = 'RelationCallExp::WhereInvocationIsANonTopRelation'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[?] = let
		 *           pattern : qvtbase::Pattern[1] = self->asOrderedSet()
		 *           ->closure(e | e.oclContainer())
		 *           ->selectByKind(qvtbase::Pattern)
		 *           ->first()
		 *         in
		 *           let
		 *             relation : Relation[1] = pattern->asOrderedSet()
		 *             ->closure(e | e.oclContainer())
		 *             ->selectByKind(Relation)
		 *             ->first()
		 *           in relation.where = pattern implies not referredRelation.isTopLevel
		 *       in
		 *         'RelationCallExp::WhereInvocationIsANonTopRelation'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_RelationCallExp_c_c_WhereInvocationIsANonTopRelation);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_2;
		if (le) {
			symbol_2 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_implies;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_pattern;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Pattern = idResolver.getClass(QVTrelationTables.CLSSid_Pattern, null);
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTrelationTables.SET_CLSSid_RelationCallExp, this);
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_1 = executor.getStaticTypeOf(asOrderedSet);
					final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_1 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_1.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
					final @NonNull Object ACC_closure_1 = IMPL_closure_1.createAccumulatorValue(executor, QVTrelationTables.ORD_CLSSid_OclElement, QVTrelationTables.CLSSid_OclElement);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure_1 = new AbstractBinaryOperation() {
						/**
						 * e.oclContainer()
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet, final /*@NonInvalid*/ java.lang.@Nullable Object e_0) {
							final /*@NonInvalid*/ java.lang.@Nullable Object symbol_0 = e_0;
							final /*@Thrown*/ java.lang.@Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, symbol_0);
							return oclContainer;
						}
					};
					final @NonNull  ExecutorSingleIterationManager MGR_closure_1 = new ExecutorSingleIterationManager(executor, QVTrelationTables.ORD_CLSSid_OclElement, BODY_closure_1, asOrderedSet, ACC_closure_1);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue closure = ClassUtil.nonNullState((OrderedSetValue)IMPL_closure_1.evaluateIteration(MGR_closure_1));
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_qvtbase_c_c_Pattern);
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Pattern pattern = (Pattern)OrderedCollectionFirstOperation.INSTANCE.evaluate(selectByKind);
					CAUGHT_pattern = pattern;
				}
				catch (Exception e) {
					CAUGHT_pattern = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @Nullable Object CAUGHT_relation;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_Relation_0 = idResolver.getClass(QVTrelationTables.CLSSid_Relation, null);
					if (CAUGHT_pattern instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_pattern;
					}
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTrelationTables.SET_CLSSid_Pattern, CAUGHT_pattern);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet_0);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0_0 = executor.getStaticTypeOf(asOrderedSet_0);
					final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
					final @NonNull Object ACC_closure_0_0 = IMPL_closure_0_0.createAccumulatorValue(executor, QVTrelationTables.ORD_CLSSid_OclElement, QVTrelationTables.CLSSid_OclElement);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure_0_0 = new AbstractBinaryOperation() {
						/**
						 * e.oclContainer()
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet_0, final /*@NonInvalid*/ java.lang.@Nullable Object e_1) {
							final /*@NonInvalid*/ java.lang.@Nullable Object symbol_1 = e_1;
							final /*@Thrown*/ java.lang.@Nullable Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, symbol_1);
							return oclContainer_0;
						}
					};
					final @NonNull  ExecutorSingleIterationManager MGR_closure_0_0 = new ExecutorSingleIterationManager(executor, QVTrelationTables.ORD_CLSSid_OclElement, BODY_closure_0_0, asOrderedSet_0, ACC_closure_0_0);
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue closure_0 = ClassUtil.nonNullState((OrderedSetValue)IMPL_closure_0_0.evaluateIteration(MGR_closure_0_0));
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure_0, TYP_qvtrelation_c_c_Relation_0);
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtrelation.@Nullable Relation relation = (Relation)OrderedCollectionFirstOperation.INSTANCE.evaluate(selectByKind_0);
					CAUGHT_relation = relation;
				}
				catch (Exception e) {
					CAUGHT_relation = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_eq;
				try {
					if (CAUGHT_relation == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTrelation\'::Relation::where\'");
					}
					if (CAUGHT_relation instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_relation;
					}
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtbase.@Nullable Pattern where = ((Relation)CAUGHT_relation).getWhere();
					if (CAUGHT_pattern instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_pattern;
					}
					final /*@Thrown*/ boolean eq = (where != null) ? where.equals(CAUGHT_pattern) : (CAUGHT_pattern == null);
					CAUGHT_eq = eq;
				}
				catch (Exception e) {
					CAUGHT_eq = ValueUtil.createInvalidValue(e);
				}
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation referredRelation = this.getReferredRelation();
				final /*@NonInvalid*/ boolean isTopLevel = referredRelation.isIsTopLevel();
				final /*@NonInvalid*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isTopLevel);
				final /*@Thrown*/ java.lang.@Nullable Boolean implies = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_eq, not);
				CAUGHT_implies = implies;
			}
			catch (Exception e) {
				CAUGHT_implies = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_RelationCallExp_c_c_WhereInvocationIsANonTopRelation, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_implies, QVTrelationTables.INT_0).booleanValue();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return getArgument();
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				if (resolve) return getReferredRelation();
				return basicGetReferredRelation();
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)newValue);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				setReferredRelation((Relation)null);
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
			case QVTrelationPackage.RELATION_CALL_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case QVTrelationPackage.RELATION_CALL_EXP__REFERRED_RELATION:
				return referredRelation != null;
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
			case QVTrelationPackage.RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP:
				return validateMatchingArgumentCount((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.RELATION_CALL_EXP___VALIDATE_WHERE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP:
				return validateWhereInvocationIsANonTopRelation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTrelationVisitor<?>)visitor).visitRelationCallExp(this);
	}
} //RelationCallExpImpl
