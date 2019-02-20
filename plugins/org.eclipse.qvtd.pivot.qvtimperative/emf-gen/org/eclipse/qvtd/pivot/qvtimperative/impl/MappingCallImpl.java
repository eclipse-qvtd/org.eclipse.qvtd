/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ReferringElement;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.BagValue.Accumulator;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getOwnedMappingParameterBindings <em>Owned Mapping Parameter Bindings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#isIsInstall <em>Is Install</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#isIsInvoke <em>Is Invoke</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getReferredMapping <em>Referred Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getReferredNames <em>Referred Names</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl#getReferringNames <em>Referring Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCallImpl extends MappingStatementImpl implements MappingCall {
	/**
	 * The number of structural features of the '<em>Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_CALL_FEATURE_COUNT = MappingStatementImpl.MAPPING_STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPING_CALL_OPERATION_COUNT = MappingStatementImpl.MAPPING_STATEMENT_OPERATION_COUNT + 4;

	/**
	 * The cached value of the '{@link #getOwnedMappingParameterBindings() <em>Owned Mapping Parameter Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingParameterBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingParameterBinding> ownedMappingParameterBindings;

	/**
	 * The default value of the '{@link #isIsInstall() <em>Is Install</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInstall()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INSTALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInstall() <em>Is Install</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInstall()
	 * @generated
	 * @ordered
	 */
	protected boolean isInstall = IS_INSTALL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInvoke() <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvoke()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVOKE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInvoke() <em>Is Invoke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInvoke()
	 * @generated
	 * @ordered
	 */
	protected boolean isInvoke = IS_INVOKE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredMapping() <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping referredMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingParameterBinding> getOwnedMappingParameterBindings() {
		if (ownedMappingParameterBindings == null) {
			ownedMappingParameterBindings = new EObjectContainmentWithInverseEList<MappingParameterBinding>(MappingParameterBinding.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		}
		return ownedMappingParameterBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping getReferredMapping() {
		if (referredMapping != null && referredMapping.eIsProxy()) {
			InternalEObject oldReferredMapping = (InternalEObject)referredMapping;
			referredMapping = (Mapping)eResolveProxy(oldReferredMapping);
			if (referredMapping != oldReferredMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldReferredMapping, referredMapping));
			}
		}
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetReferredMapping() {
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredMapping(Mapping newReferredMapping) {
		Mapping oldReferredMapping = referredMapping;
		referredMapping = newReferredMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldReferredMapping, referredMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getReferredNames() {
		/**
		 * referredMapping.ownedMappingParameters.name->asSet()->sortedBy(n | n)
		 */
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Mapping referredMapping = this.getReferredMapping();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<MappingParameter> ownedMappingParameters = referredMapping.getOwnedMappingParameters();
		final /*@NonInvalid*/ @NonNull SetValue BOXED_ownedMappingParameters = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_MappingParameter, ownedMappingParameters);
		/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTimperativeTables.BAG_PRIMid_String);
		@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedMappingParameters.iterator();
		/*@Thrown*/ @NonNull BagValue collect;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				collect = accumulator;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull MappingParameter _1 = (@NonNull MappingParameter)ITERATOR__1.next();
			/**
			 * name
			 */
			final /*@NonInvalid*/ @Nullable String name = _1.getName();
			//
			accumulator.add(name);
		}
		final /*@Thrown*/ @NonNull SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
		final org.eclipse.ocl.pivot.@NonNull Class TYPE_sortedBy_0 = executor.getStaticTypeOfValue(null, asSet);
		final @NonNull LibraryIterationExtension IMPL_sortedBy_0 = (LibraryIterationExtension)TYPE_sortedBy_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
		final @NonNull Object ACC_sortedBy_0 = IMPL_sortedBy_0.createAccumulatorValue(executor, QVTimperativeTables.ORD_PRIMid_String, TypeId.STRING);
		/**
		 * Implementation of the iterator body.
		 */
		final @NonNull AbstractBinaryOperation BODY_sortedBy_0 = new AbstractBinaryOperation() {
			/**
			 * n
			 */
			@Override
			public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asSet, final /*@NonInvalid*/ @Nullable Object n) {
				final /*@NonInvalid*/ @Nullable String symbol_0 = (String)n;
				return symbol_0;
			}
		};
		final @NonNull ExecutorSingleIterationManager MGR_sortedBy_0 = new ExecutorSingleIterationManager(executor, QVTimperativeTables.ORD_PRIMid_String, BODY_sortedBy_0, asSet, ACC_sortedBy_0);
		@SuppressWarnings("null")
		final /*@Thrown*/ @NonNull OrderedSetValue sortedBy = (@NonNull OrderedSetValue)IMPL_sortedBy_0.evaluateIteration(MGR_sortedBy_0);
		final /*@Thrown*/ @NonNull List<String> ECORE_sortedBy = ((IdResolverExtension)idResolver).ecoreValueOfAll(String.class, sortedBy);
		return (EList<String>)ECORE_sortedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getReferringNames() {
		/**
		 * ownedMappingParameterBindings.boundVariable.name->asSet()->sortedBy(n | n)
		 */
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull List<MappingParameterBinding> ownedMappingParameterBindings = this.getOwnedMappingParameterBindings();
		final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedMappingParameterBindings = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_CLSSid_MappingParameterBinding, ownedMappingParameterBindings);
		/*@Thrown*/ org.eclipse.ocl.pivot.values.SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTimperativeTables.SEQ_CLSSid_MappingParameter);
		@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedMappingParameterBindings.iterator();
		/*@NonInvalid*/ @NonNull SequenceValue collect_0;
		while (true) {
			if (!ITERATOR__1.hasNext()) {
				collect_0 = accumulator;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull MappingParameterBinding _1 = (@NonNull MappingParameterBinding)ITERATOR__1.next();
			/**
			 * boundVariable
			 */
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull MappingParameter boundVariable = _1.getBoundVariable();
			//
			accumulator.add(boundVariable);
		}
		/*@Thrown*/ org.eclipse.ocl.pivot.values.SequenceValue.@NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(QVTimperativeTables.SEQ_PRIMid_String);
		@NonNull Iterator<Object> ITERATOR__1_0 = collect_0.iterator();
		/*@Thrown*/ @NonNull SequenceValue collect;
		while (true) {
			if (!ITERATOR__1_0.hasNext()) {
				collect = accumulator_0;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull MappingParameter _1_0 = (@NonNull MappingParameter)ITERATOR__1_0.next();
			/**
			 * name
			 */
			final /*@NonInvalid*/ @Nullable String name = _1_0.getName();
			//
			accumulator_0.add(name);
		}
		final /*@Thrown*/ @NonNull SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(collect);
		final org.eclipse.ocl.pivot.@NonNull Class TYPE_sortedBy_0 = executor.getStaticTypeOfValue(null, asSet);
		final @NonNull LibraryIterationExtension IMPL_sortedBy_0 = (LibraryIterationExtension)TYPE_sortedBy_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__sortedBy);
		final @NonNull Object ACC_sortedBy_0 = IMPL_sortedBy_0.createAccumulatorValue(executor, QVTimperativeTables.ORD_PRIMid_String, TypeId.STRING);
		/**
		 * Implementation of the iterator body.
		 */
		final @NonNull AbstractBinaryOperation BODY_sortedBy_0 = new AbstractBinaryOperation() {
			/**
			 * n
			 */
			@Override
			public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object asSet, final /*@NonInvalid*/ @Nullable Object n) {
				final /*@NonInvalid*/ @Nullable String symbol_0 = (String)n;
				return symbol_0;
			}
		};
		final @NonNull ExecutorSingleIterationManager MGR_sortedBy_0 = new ExecutorSingleIterationManager(executor, QVTimperativeTables.ORD_PRIMid_String, BODY_sortedBy_0, asSet, ACC_sortedBy_0);
		@SuppressWarnings("null")
		final /*@Thrown*/ @NonNull OrderedSetValue sortedBy = (@NonNull OrderedSetValue)IMPL_sortedBy_0.evaluateIteration(MGR_sortedBy_0);
		final /*@Thrown*/ @NonNull List<String> ECORE_sortedBy = ((IdResolverExtension)idResolver).ecoreValueOfAll(String.class, sortedBy);
		return (EList<String>)ECORE_sortedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMatchingCallBindings(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv MatchingCallBindings:
			 *   let
			 *     severity : Integer[1] = 'MappingCall::MatchingCallBindings'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = let status : Boolean[1] = referredNames = referringNames
			 *         in
			 *           if status = true
			 *           then true
			 *           else
			 *             Tuple{message = 'MappingCall::MatchingCallBindings: ' + referredMapping.name +
			 *               joinNames(referredNames) + ' <= ' +
			 *               joinNames(referringNames), status = status
			 *             }
			 *           endif
			 *       in
			 *         'MappingCall::MatchingCallBindings'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_MappingCall_c_c_MatchingCallBindings);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ @NonNull Object symbol_2;
			if (le) {
				symbol_2 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_symbol_1;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<String> referredNames = this.getReferredNames();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<String> referringNames = this.getReferringNames();
					final /*@NonInvalid*/ boolean status = referredNames.equals(referringNames);
					/*@Thrown*/ @NonNull Object symbol_1;
					if (status) {
						symbol_1 = ValueUtil.TRUE_VALUE;
					}
					else {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Mapping referredMapping = this.getReferredMapping();
						final /*@NonInvalid*/ @Nullable String name = referredMapping.getName();
						final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR_MappingCall_c_c_MatchingCallBindings_c_32, name);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String joinNames = this.joinNames((EList<String>)referredNames);
						final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, joinNames);
						final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTimperativeTables.STR__32_l_q_32);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull String joinNames_0 = this.joinNames((EList<String>)referringNames);
						final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, joinNames_0);
						final /*@Thrown*/ @NonNull TupleValue symbol_0 = ValueUtil.createTupleOfEach(QVTimperativeTables.TUPLid_, sum_2, status);
						symbol_1 = symbol_0;
					}
					CAUGHT_symbol_1 = symbol_1;
				}
				catch (Exception e) {
					CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_MappingCall_c_c_MatchingCallBindings, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_symbol_1, QVTimperativeTables.INT_0).booleanValue();
				symbol_2 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_2;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("MappingCall::MatchingCallBindings", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNotBothInstallAndInvoke(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv NotBothInstallAndInvoke:
			 *   let
			 *     severity : Integer[1] = 'MappingCall::NotBothInstallAndInvoke'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not (isInstall and isInvoke)
			 *       in
			 *         'MappingCall::NotBothInstallAndInvoke'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_MappingCall_c_c_NotBothInstallAndInvoke);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ boolean isInstall = this.isIsInstall();
				/*@NonInvalid*/ boolean and;
				if (isInstall) {
					final /*@NonInvalid*/ boolean isInvoke = this.isIsInvoke();
					and = isInvoke;
				}
				else {
					and = ValueUtil.FALSE_VALUE;
				}
				final /*@NonInvalid*/ @Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(and);
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_MappingCall_c_c_NotBothInstallAndInvoke, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTimperativeTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("MappingCall::NotBothInstallAndInvoke", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateUniqueCallBindings(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv UniqueCallBindings:
			 *   let severity : Integer[1] = 'MappingCall::UniqueCallBindings'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = ownedMappingParameterBindings->isUnique(boundVariable)
			 *       in
			 *         'MappingCall::UniqueCallBindings'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_MappingCall_c_c_UniqueCallBindings);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<MappingParameterBinding> ownedMappingParameterBindings = this.getOwnedMappingParameterBindings();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedMappingParameterBindings = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_CLSSid_MappingParameterBinding, ownedMappingParameterBindings);
				/*@Thrown*/ org.eclipse.ocl.pivot.values.SetValue.@NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.ORD_CLSSid_MappingParameterBinding);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedMappingParameterBindings.iterator();
				/*@NonInvalid*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull MappingParameterBinding _1 = (@NonNull MappingParameterBinding)ITERATOR__1.next();
					/**
					 * boundVariable
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull MappingParameter boundVariable = _1.getBoundVariable();
					//
					if (accumulator.includes(boundVariable) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(boundVariable);
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_MappingCall_c_c_UniqueCallBindings, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTimperativeTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("MappingCall::UniqueCallBindings", this, diagnostics, context, e);
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
	@Override
	public boolean isIsInstall() {
		return isInstall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInstall(boolean newIsInstall) {
		boolean oldIsInstall = isInstall;
		isInstall = newIsInstall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, oldIsInstall, isInstall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsInvoke() {
		return isInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsInvoke(boolean newIsInvoke) {
		boolean oldIsInvoke = isInvoke;
		isInvoke = newIsInvoke;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldIsInvoke, isInvoke));
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
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingParameterBindings()).basicAdd(otherEnd, msgs);
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
				return ((InternalEList<?>)getOwnedMappingParameterBindings()).basicRemove(otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getOwnedMappingParameterBindings();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isIsInstall();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return isIsInvoke();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				if (resolve) return getReferredMapping();
				return basicGetReferredMapping();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return getReferredNames();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return getReferringNames();
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
				getOwnedMappingParameterBindings().clear();
				getOwnedMappingParameterBindings().addAll((Collection<? extends MappingParameterBinding>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsInstall((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setIsInvoke((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setReferredMapping((Mapping)newValue);
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
				getOwnedMappingParameterBindings().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setIsInstall(IS_INSTALL_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setIsInvoke(IS_INVOKE_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setReferredMapping((Mapping)null);
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
				return ownedMappingParameterBindings != null && !ownedMappingParameterBindings.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return isInstall != IS_INSTALL_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return isInvoke != IS_INVOKE_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return referredMapping != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return !getReferredNames().isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return !getReferringNames().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ReferringElement.class) {
			switch (baseOperationID) {
				case 0: return NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 2:
				return validateMatchingCallBindings((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 3:
				return validateNotBothInstallAndInvoke((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 4:
				return validateUniqueCallBindings((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1:
				return getReferredElement();
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMappingCall(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Element getReferredElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
} //MappingCallImpl
