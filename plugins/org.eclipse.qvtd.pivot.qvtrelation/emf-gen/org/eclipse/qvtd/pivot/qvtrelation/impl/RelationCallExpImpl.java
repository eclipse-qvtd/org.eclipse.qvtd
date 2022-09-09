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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.OCLExpressionImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;
import org.eclipse.ocl.pivot.values.SetValue;
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
	 * The number of structural features of the '<em>Relation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_CALL_EXP_FEATURE_COUNT = OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RELATION_CALL_EXP_OPERATION_COUNT = OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 3;

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
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1, oldReferredRelation, referredRelation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1, oldReferredRelation, referredRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMatchingArgumentCount(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelationCallExp::MatchingArgumentCount";
		try {
			/**
			 *
			 * inv MatchingArgumentCount:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = self.argument->size() =
			 *         self.referredRelation.domain.oclAsType(RelationDomain)
			 *         .rootVariable->size()
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<OCLExpression> argument = this.getArgument();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_OCLExpression, argument);
					final /*@NonInvalid*/ @NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_argument);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Relation referredRelation = this.getReferredRelation();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Domain> domain = referredRelation.getDomain();
					final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_domain = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_Domain, domain);
					/*@NonInvalid*/ @NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_RelationDomain);
					@NonNull Iterator<Object> ITER__1 = BOXED_domain.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect_0;
					while (true) {
						if (!ITER__1.hasNext()) {
							collect_0 = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Domain _1 = (@NonNull Domain)ITER__1.next();
						/**
						 * oclAsType(RelationDomain)
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_RelationDomain = idResolver.getClass(QVTrelationTables.CLSSid_RelationDomain, null);
						final /*@Thrown*/ @Nullable RelationDomain oclAsType = (@Nullable RelationDomain)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, _1, TYP_qvtrelation_c_c_RelationDomain);
						//
						accumulator.add(oclAsType);
					}
					/*@NonInvalid*/ @NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_Variable);
					@NonNull Iterator<Object> ITER__1_0 = collect_0.iterator();
					/*@Thrown*/ @NonNull SequenceValue collect;
					while (true) {
						if (!ITER__1_0.hasNext()) {
							collect = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull RelationDomain _1_0 = (@NonNull RelationDomain)ITER__1_0.next();
						/**
						 * rootVariable
						 */
						final /*@NonInvalid*/ @NonNull List<Variable> rootVariable = _1_0.getRootVariable();
						final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_rootVariable = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_Variable, rootVariable);
						//
						for (Object value : BOXED_rootVariable.flatten().getElements()) {
							accumulator_0.add(value);
						}
					}
					final /*@Thrown*/ @NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(collect);
					final /*@Thrown*/ boolean IsEQ_ = size.equals(size_0);
					CAUGHT_IsEQ_ = IsEQ_;
				}
				catch (Exception THROWN_CAUGHT_IsEQ_) {
					CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_IsEQ_, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateWhereInvocationIsANonTopRelation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelationCallExp::WhereInvocationIsANonTopRelation";
		try {
			/**
			 *
			 * inv WhereInvocationIsANonTopRelation:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION_CALL_EXP___VALIDATE_WHERE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_first;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_Pattern = idResolver.getClass(QVTrelationTables.CLSSid_Pattern, null);
					final /*@NonInvalid*/ @NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTrelationTables.SET_CLSSid_RelationCallExp, this);
					final /*@NonInvalid*/ @NonNull OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure = executor.getStaticTypeOfValue(null, asOrderedSet);
					final @NonNull LibraryIterationExtension IMPL_closure = (LibraryIterationExtension)TYPE_closure.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
					final @NonNull Object ACC_closure = IMPL_closure.createAccumulatorValue(executor, QVTrelationTables.ORD_CLSSid_OclElement, QVTrelationTables.CLSSid_OclElement);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure = new AbstractBinaryOperation() {
						/**
						 * e.oclContainer()
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet, final /*@NonInvalid*/ @Nullable Object e) {
							if (e == null) {
								throw new InvalidValueException("Null \'\'OclElement\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @Nullable Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, e);
							return oclContainer;
						}
					};
					final @NonNull ExecutorSingleIterationManager MGR_closure = new ExecutorSingleIterationManager(executor, QVTrelationTables.ORD_CLSSid_OclElement, BODY_closure, asOrderedSet, ACC_closure);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OrderedSetValue closure = (@NonNull OrderedSetValue)IMPL_closure.evaluateIteration(MGR_closure);
					final /*@Thrown*/ @NonNull OrderedSetValue selectByKind = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure, TYP_qvtbase_c_c_Pattern);
					final /*@Thrown*/ @Nullable Pattern first = (@Nullable Pattern)OrderedCollectionFirstOperation.INSTANCE.evaluate(selectByKind);
					CAUGHT_first = first;
				}
				catch (Exception THROWN_CAUGHT_first) {
					CAUGHT_first = ValueUtil.createInvalidValue(THROWN_CAUGHT_first);
				}
				/*@Caught*/ @Nullable Object CAUGHT_first_0;
				try {
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtrelation_c_c_Relation = idResolver.getClass(QVTrelationTables.CLSSid_Relation, null);
					if (CAUGHT_first instanceof InvalidValueException) {
						throw (InvalidValueException)CAUGHT_first;
					}
					final /*@Thrown*/ @Nullable Pattern THROWN_first = (@Nullable Pattern)CAUGHT_first;
					final /*@Thrown*/ @NonNull SetValue oclAsSet_0 = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, QVTrelationTables.SET_CLSSid_Pattern, THROWN_first);
					final /*@Thrown*/ @NonNull OrderedSetValue asOrderedSet_0 = CollectionAsOrderedSetOperation.INSTANCE.evaluate(oclAsSet_0);
					final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOfValue(null, asOrderedSet_0);
					final @NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._OrderedSet__closure);
					final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, QVTrelationTables.ORD_CLSSid_OclElement, QVTrelationTables.CLSSid_OclElement);
					/**
					 * Implementation of the iterator body.
					 */
					final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
						/**
						 * e.oclContainer()
						 */
						@Override
						public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asOrderedSet_0, final /*@NonInvalid*/ @Nullable Object e_0) {
							if (e_0 == null) {
								throw new InvalidValueException("Null \'\'OclElement\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @Nullable Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, e_0);
							return oclContainer_0;
						}
					};
					final @NonNull ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, QVTrelationTables.ORD_CLSSid_OclElement, BODY_closure_0, asOrderedSet_0, ACC_closure_0);
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull OrderedSetValue closure_0 = (@NonNull OrderedSetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0);
					final /*@Thrown*/ @NonNull OrderedSetValue selectByKind_0 = (@Nullable OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, closure_0, TYP_qvtrelation_c_c_Relation);
					final /*@Thrown*/ @Nullable Relation first_0 = (@Nullable Relation)OrderedCollectionFirstOperation.INSTANCE.evaluate(selectByKind_0);
					CAUGHT_first_0 = first_0;
				}
				catch (Exception THROWN_CAUGHT_first_0) {
					CAUGHT_first_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_first_0);
				}
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
					try {
						if (CAUGHT_first_0 instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_first_0;
						}
						final /*@Thrown*/ @Nullable Relation THROWN_first_0 = (@Nullable Relation)CAUGHT_first_0;
						if (THROWN_first_0 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTrelation\'::Relation::where\'");
						}
						final /*@Thrown*/ @Nullable Pattern where = THROWN_first_0.getWhere();
						if (CAUGHT_first instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_first;
						}
						final /*@Thrown*/ @Nullable Pattern THROWN_first_1 = (@Nullable Pattern)CAUGHT_first;
						final /*@Thrown*/ boolean IsEQ_ = (where != null) ? where.equals(THROWN_first_1) : (THROWN_first_1 == null);
						CAUGHT_IsEQ_ = IsEQ_;
					}
					catch (Exception THROWN_CAUGHT_IsEQ_) {
						CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
					}
					final /*@Thrown*/ @Nullable Boolean implies;
					if (CAUGHT_IsEQ_ == ValueUtil.FALSE_VALUE) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Relation referredRelation = this.getReferredRelation();
						final /*@NonInvalid*/ boolean isTopLevel = referredRelation.isIsTopLevel();
						final /*@NonInvalid*/ @Nullable Boolean not;
						if (!isTopLevel) {
							not = ValueUtil.TRUE_VALUE;
						}
						else {
							if (isTopLevel) {
								not = ValueUtil.FALSE_VALUE;
							}
							else {
								not = null;
							}
						}
						if (not == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_IsEQ_ instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IsEQ_;
							}
							if (not == null) {
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTrelationTables.INT_0).booleanValue();
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
	public boolean validateDataTypeInvocationIsANonTopRelation(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelationCallExp::DataTypeInvocationIsANonTopRelation";
		try {
			/**
			 *
			 * inv DataTypeInvocationIsANonTopRelation:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = self.argument->exists(
			 *           type.oclIsKindOf(DataType) and
			 *           not type.oclIsKindOf(CollectionType)) implies not referredRelation.isTopLevel
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.RELATION_CALL_EXP___VALIDATE_DATA_TYPE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_exists;
					try {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull List<OCLExpression> argument = this.getArgument();
						final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_argument = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_OCLExpression, argument);
						/*@Thrown*/ @Nullable Object accumulator = ValueUtil.FALSE_VALUE;
						@NonNull Iterator<Object> ITER__1 = BOXED_argument.iterator();
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
							/*@NonInvalid*/ @NonNull OCLExpression _1 = (@NonNull OCLExpression)ITER__1.next();
							/**
							 *
							 * type.oclIsKindOf(DataType) and
							 * not type.oclIsKindOf(CollectionType)
							 */
							/*@Caught*/ @Nullable Object CAUGHT_and;
							try {
								/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf;
								try {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_DataType = idResolver.getClass(QVTrelationTables.CLSSid_DataType, null);
									final /*@NonInvalid*/ @Nullable Type type = _1.getType();
									final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type, TYP_DataType).booleanValue();
									CAUGHT_oclIsKindOf = oclIsKindOf;
								}
								catch (Exception THROWN_CAUGHT_oclIsKindOf) {
									CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(THROWN_CAUGHT_oclIsKindOf);
								}
								final /*@Thrown*/ @Nullable Boolean and;
								if (CAUGHT_oclIsKindOf == ValueUtil.FALSE_VALUE) {
									and = ValueUtil.FALSE_VALUE;
								}
								else {
									/*@Caught*/ @Nullable Object CAUGHT_not;
									try {
										/*@Caught*/ @NonNull Object CAUGHT_oclIsKindOf_0;
										try {
											final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTrelationTables.CLSSid_CollectionType, null);
											final /*@NonInvalid*/ @Nullable Type type_0 = _1.getType();
											final /*@Thrown*/ boolean oclIsKindOf_0 = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, type_0, TYP_CollectionType).booleanValue();
											CAUGHT_oclIsKindOf_0 = oclIsKindOf_0;
										}
										catch (Exception THROWN_CAUGHT_oclIsKindOf_0) {
											CAUGHT_oclIsKindOf_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_oclIsKindOf_0);
										}
										if (CAUGHT_oclIsKindOf_0 instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_oclIsKindOf_0;
										}
										final /*@Thrown*/ @Nullable Boolean not;
										if (CAUGHT_oclIsKindOf_0 == ValueUtil.FALSE_VALUE) {
											not = ValueUtil.TRUE_VALUE;
										}
										else {
											if (CAUGHT_oclIsKindOf_0 == ValueUtil.TRUE_VALUE) {
												not = ValueUtil.FALSE_VALUE;
											}
											else {
												not = null;
											}
										}
										CAUGHT_not = not;
									}
									catch (Exception THROWN_CAUGHT_not) {
										CAUGHT_not = ValueUtil.createInvalidValue(THROWN_CAUGHT_not);
									}
									if (CAUGHT_not == ValueUtil.FALSE_VALUE) {
										and = ValueUtil.FALSE_VALUE;
									}
									else {
										if (CAUGHT_oclIsKindOf instanceof InvalidValueException) {
											throw (InvalidValueException)CAUGHT_oclIsKindOf;
										}
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
							catch (Exception THROWN_CAUGHT_and) {
								CAUGHT_and = ValueUtil.createInvalidValue(THROWN_CAUGHT_and);
							}
							//
							if (CAUGHT_and == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
								exists = ValueUtil.TRUE_VALUE;
								break;														// Stop immediately
							}
							else if (CAUGHT_and == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
								;															// Carry on
							}
							else if (CAUGHT_and == null) {								// Abnormal null body evaluation result
								if (accumulator == ValueUtil.FALSE_VALUE) {
									accumulator = null;										// Cache a null failure
								}
							}
							else if (CAUGHT_and instanceof InvalidValueException) {		// Abnormal exception evaluation result
								accumulator = CAUGHT_and;									// Cache an exception failure
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
					final /*@Thrown*/ @Nullable Boolean implies;
					if (CAUGHT_exists == ValueUtil.FALSE_VALUE) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Relation referredRelation = this.getReferredRelation();
						final /*@NonInvalid*/ boolean isTopLevel = referredRelation.isIsTopLevel();
						final /*@NonInvalid*/ @Nullable Boolean not_0;
						if (!isTopLevel) {
							not_0 = ValueUtil.TRUE_VALUE;
						}
						else {
							if (isTopLevel) {
								not_0 = ValueUtil.FALSE_VALUE;
							}
							else {
								not_0 = null;
							}
						}
						if (not_0 == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_exists instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_exists;
							}
							if ((CAUGHT_exists == null) || (not_0 == null)) {
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTrelationTables.INT_0).booleanValue();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0:
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
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0:
				return getArgument();
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1:
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
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1:
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
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0:
				getArgument().clear();
				return;
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1:
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
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 0:
				return argument != null && !argument.isEmpty();
			case OCLExpressionImpl.OCL_EXPRESSION_FEATURE_COUNT + 1:
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
			case OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 0:
				return validateMatchingArgumentCount((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 1:
				return validateWhereInvocationIsANonTopRelation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OCLExpressionImpl.OCL_EXPRESSION_OPERATION_COUNT + 2:
				return validateDataTypeInvocationIsANonTopRelation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
			return (R) ((QVTrelationVisitor<?>)visitor).visitRelationCallExp(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //RelationCallExpImpl
