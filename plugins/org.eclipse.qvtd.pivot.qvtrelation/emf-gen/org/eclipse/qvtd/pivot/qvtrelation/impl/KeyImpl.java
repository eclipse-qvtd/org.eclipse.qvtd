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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration.LibraryIterationExtension;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionExcludingOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationSupport;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl#getOppositePart <em>Opposite Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeyImpl extends ElementImpl implements Key {
	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int KEY_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int KEY_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The cached value of the '{@link #getIdentifies() <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifies()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Class identifies;

	/**
	 * The cached value of the '{@link #getOppositePart() <em>Opposite Part</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositePart()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> oppositePart;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> part;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getIdentifies() {
		if (identifies != null && identifies.eIsProxy()) {
			InternalEObject oldIdentifies = (InternalEObject)identifies;
			identifies = (org.eclipse.ocl.pivot.Class)eResolveProxy(oldIdentifies);
			if (identifies != oldIdentifies) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldIdentifies, identifies));
			}
		}
		return identifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Class basicGetIdentifies() {
		return identifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifies(org.eclipse.ocl.pivot.Class newIdentifies) {
		org.eclipse.ocl.pivot.Class oldIdentifies = identifies;
		identifies = newIdentifies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldIdentifies, identifies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getPart() {
		if (part == null) {
			part = new EObjectResolvingEList<Property>(Property.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 2);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getTransformation() {
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 3)) return null;
		return (RelationalTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(RelationalTransformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, ElementImpl.ELEMENT_FEATURE_COUNT + 3, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(RelationalTransformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 3) && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0, RelationalTransformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIdentifiesIsNotAbstract(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::IdentifiesIsNotAbstract";
		try {
			/**
			 *
			 * inv IdentifiesIsNotAbstract:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not identifies.isAbstract
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
				final /*@NonInvalid*/ boolean isAbstract = identifies_0.isIsAbstract();
				final /*@NonInvalid*/ @Nullable Boolean not;
				if (!isAbstract) {
					not = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isAbstract) {
						not = ValueUtil.FALSE_VALUE;
					}
					else {
						not = null;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, not, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validateIdentifiesIsAUsedPackageClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::IdentifiesIsAUsedPackageClass";
		try {
			/**
			 *
			 * inv IdentifiesIsAUsedPackageClass:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         transformation.modelParameter.usedPackage->includes(identifies.owningPackage)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation_0 = this.getTransformation();
					final /*@NonInvalid*/ boolean IsEQ_ = transformation_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_includes;
						try {
							if (transformation_0 == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::modelParameter\'");
							}
							final /*@Thrown*/ @NonNull List<TypedModel> modelParameter = transformation_0.getModelParameter();
							final /*@Thrown*/ @Nullable OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTrelationSupport.ORD_CLSSid_TypedModel, modelParameter);
							/*@NonInvalid*/ @NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTrelationSupport.SEQ_CLSSid_Package);
							@NonNull Iterator<Object> ITER__1 = BOXED_modelParameter.iterator();
							/*@Thrown*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITER__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull TypedModel _1 = (@NonNull TypedModel)ITER__1.next();
								/**
								 * usedPackage
								 */
								final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = _1.getUsedPackage();
								final /*@NonInvalid*/ @Nullable SetValue BOXED_usedPackage = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Package, usedPackage);
								//
								for (Object value : BOXED_usedPackage.flatten().getElements()) {
									accumulator.add(value);
								}
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Package owningPackage = identifies_0.getOwningPackage();
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, owningPackage).booleanValue();
							CAUGHT_includes = includes;
						}
						catch (Exception THROWN_CAUGHT_includes) {
							CAUGHT_includes = ValueUtil.createInvalidValue(THROWN_CAUGHT_includes);
						}
						if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_includes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_includes;
							}
							implies = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validateNoSuperKeys(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::NoSuperKeys";
		try {
			/**
			 *
			 * inv NoSuperKeys:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         let
			 *           superClasses : Set(Class) = identifies.superClasses->closure(superClasses)
			 *         in
			 *           let
			 *             otherKeys : Set(qvtrelation::Key) = transformation?.ownedKey?->excluding(self)
			 *           in otherKeys.identifies->excludesAll(superClasses)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = executor.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation_0 = this.getTransformation();
					final /*@NonInvalid*/ boolean IsEQ_ = transformation_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_closure;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
							final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses = identifies_0.getSuperClasses();
							final /*@NonInvalid*/ @Nullable SetValue BOXED_superClasses = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Class, superClasses);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure = executor.getStaticTypeOfValue(null, BOXED_superClasses);
							final @NonNull LibraryIterationExtension IMPL_closure = (LibraryIterationExtension)TYPE_closure.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_closure = IMPL_closure.createAccumulatorValue(executor, QVTrelationSupport.SET_CLSSid_Class, QVTrelationSupport.SET_CLSSid_Class);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_closure = new AbstractBinaryOperation() {
								/**
								 * superClasses
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object BOXED_superClasses, final /*@NonInvalid*/ @Nullable Object _1_0) {
									@SuppressWarnings("null")
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class CAST_1_ = (org.eclipse.ocl.pivot.@NonNull Class)_1_0;
									final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses_0 = CAST_1_.getSuperClasses();
									final /*@NonInvalid*/ @Nullable SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Class, superClasses_0);
									return BOXED_superClasses_0;
								}
							};
							final @NonNull ExecutorSingleIterationManager MGR_closure = new ExecutorSingleIterationManager(executor, QVTrelationSupport.SET_CLSSid_Class, BODY_closure, BOXED_superClasses, ACC_closure);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull SetValue closure = (@NonNull SetValue)IMPL_closure.evaluateIteration(MGR_closure);
							CAUGHT_closure = closure;
						}
						catch (Exception THROWN_CAUGHT_closure) {
							CAUGHT_closure = ValueUtil.createInvalidValue(THROWN_CAUGHT_closure);
						}
						/*@Caught*/ @Nullable Object CAUGHT_excluding;
						try {
							final /*@NonInvalid*/ Boolean IsEQ2_ = transformation_0 == null;
							/*@Thrown*/ @Nullable SetValue IF_IsEQ2_;
							if (IsEQ2_) {
								IF_IsEQ2_ = null;
							}
							else {
								assert transformation_0 != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<Key> ownedKey = transformation_0.getOwnedKey();
								final /*@Thrown*/ @Nullable SetValue BOXED_ownedKey = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Key, ownedKey);
								IF_IsEQ2_ = BOXED_ownedKey;
							}
							if (IF_IsEQ2_ == null) {
								throw new InvalidValueException("Null \'\'Collection\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @NonNull SetValue excluding_0 = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(IF_IsEQ2_, (Object)null);
							final /*@Thrown*/ @NonNull SetValue excluding = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(excluding_0, this);
							CAUGHT_excluding = excluding;
						}
						catch (Exception THROWN_CAUGHT_excluding) {
							CAUGHT_excluding = ValueUtil.createInvalidValue(THROWN_CAUGHT_excluding);
						}
						/*@Caught*/ @Nullable Object CAUGHT_excludesAll;
						try {
							if (CAUGHT_excluding instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excluding;
							}
							final /*@Thrown*/ @Nullable SetValue THROWN_excluding = (@Nullable SetValue)CAUGHT_excluding;
							/*@NonInvalid*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationSupport.BAG_CLSSid_Class);
							@NonNull Iterator<Object> ITER__1 = THROWN_excluding.iterator();
							/*@Thrown*/ @NonNull BagValue collect;
							while (true) {
								if (!ITER__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Key _1 = (@NonNull Key)ITER__1.next();
								/**
								 * identifies
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_1 = _1.getIdentifies();
								//
								accumulator.add(identifies_1);
							}
							if (CAUGHT_closure instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_closure;
							}
							final /*@Thrown*/ @Nullable SetValue THROWN_closure = (@Nullable SetValue)CAUGHT_closure;
							final /*@Thrown*/ boolean excludesAll = CollectionExcludesAllOperation.INSTANCE.evaluate(collect, THROWN_closure).booleanValue();
							CAUGHT_excludesAll = excludesAll;
						}
						catch (Exception THROWN_CAUGHT_excludesAll) {
							CAUGHT_excludesAll = ValueUtil.createInvalidValue(THROWN_CAUGHT_excludesAll);
						}
						if (CAUGHT_excludesAll == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_excludesAll instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excludesAll;
							}
							implies = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validateIdentifiesIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::IdentifiesIsUnique";
		try {
			/**
			 *
			 * inv IdentifiesIsUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         let
			 *           otherKeys : Set(qvtrelation::Key) = transformation?.ownedKey?->excluding(self)
			 *         in otherKeys.identifies->excludes(identifies)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation_0 = this.getTransformation();
					final /*@NonInvalid*/ boolean IsEQ_ = transformation_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_excluding;
						try {
							final /*@NonInvalid*/ Boolean IsEQ2_ = transformation_0 == null;
							/*@Thrown*/ @Nullable SetValue IF_IsEQ2_;
							if (IsEQ2_) {
								IF_IsEQ2_ = null;
							}
							else {
								assert transformation_0 != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<Key> ownedKey = transformation_0.getOwnedKey();
								final /*@Thrown*/ @Nullable SetValue BOXED_ownedKey = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Key, ownedKey);
								IF_IsEQ2_ = BOXED_ownedKey;
							}
							if (IF_IsEQ2_ == null) {
								throw new InvalidValueException("Null \'\'Collection\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @NonNull SetValue excluding_0 = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(IF_IsEQ2_, (Object)null);
							final /*@Thrown*/ @NonNull SetValue excluding = (SetValue)CollectionExcludingOperation.INSTANCE.evaluate(excluding_0, this);
							CAUGHT_excluding = excluding;
						}
						catch (Exception THROWN_CAUGHT_excluding) {
							CAUGHT_excluding = ValueUtil.createInvalidValue(THROWN_CAUGHT_excluding);
						}
						/*@Caught*/ @Nullable Object CAUGHT_excludes;
						try {
							if (CAUGHT_excluding instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excluding;
							}
							final /*@Thrown*/ @Nullable SetValue THROWN_excluding = (@Nullable SetValue)CAUGHT_excluding;
							/*@NonInvalid*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationSupport.BAG_CLSSid_Class);
							@NonNull Iterator<Object> ITER__1 = THROWN_excluding.iterator();
							/*@Thrown*/ @NonNull BagValue collect;
							while (true) {
								if (!ITER__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Key _1 = (@NonNull Key)ITER__1.next();
								/**
								 * identifies
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_1 = _1.getIdentifies();
								//
								accumulator.add(identifies_1);
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
							final /*@Thrown*/ boolean excludes = CollectionExcludesOperation.INSTANCE.evaluate(collect, identifies_0).booleanValue();
							CAUGHT_excludes = excludes;
						}
						catch (Exception THROWN_CAUGHT_excludes) {
							CAUGHT_excludes = ValueUtil.createInvalidValue(THROWN_CAUGHT_excludes);
						}
						if (CAUGHT_excludes == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_excludes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excludes;
							}
							implies = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validateOppositePartsHaveOpposites(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::OppositePartsHaveOpposites";
		try {
			/**
			 *
			 * inv OppositePartsHaveOpposites:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = oppositePart->forAll(opposite <> null)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Property> oppositePart_0 = this.getOppositePart();
				final /*@NonInvalid*/ @Nullable SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Property, oppositePart_0);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITER__1 = BOXED_oppositePart.iterator();
				/*@NonInvalid*/ @Nullable Boolean forAll;
				while (true) {
					if (!ITER__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITER__1.next();
					/**
					 * opposite <> null
					 */
					final /*@NonInvalid*/ @Nullable Property opposite = _1.getOpposite();
					final /*@NonInvalid*/ boolean IsEQ_ = opposite != null;
					//
					if (!IsEQ_) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (IsEQ_) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, forAll, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validateOppositePartsAreOppositeParts(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::OppositePartsAreOppositeParts";
		try {
			/**
			 *
			 * inv OppositePartsAreOppositeParts:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = oppositePart->forAll(
			 *           self.identifies.conformsTo(type))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Property> oppositePart_0 = this.getOppositePart();
				final /*@NonInvalid*/ @Nullable SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Property, oppositePart_0);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITER__1 = BOXED_oppositePart.iterator();
				/*@NonInvalid*/ @Nullable Boolean forAll;
				while (true) {
					if (!ITER__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITER__1.next();
					/**
					 * self.identifies.conformsTo(type)
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
					final /*@NonInvalid*/ @Nullable Type type = _1.getType();
					final /*@NonInvalid*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, identifies_0, type).booleanValue();
					//
					if (!conformsTo) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (conformsTo) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, forAll, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validatePartsAreParts(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::PartsAreParts";
		try {
			/**
			 *
			 * inv PartsAreParts:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = part->forAll(
			 *           self.identifies.conformsTo(owningClass))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Property> part_0 = this.getPart();
				final /*@NonInvalid*/ @Nullable SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Property, part_0);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITER__1 = BOXED_part.iterator();
				/*@NonInvalid*/ @Nullable Boolean forAll;
				while (true) {
					if (!ITER__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITER__1.next();
					/**
					 * self.identifies.conformsTo(owningClass)
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = _1.getOwningClass();
					final /*@NonInvalid*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, identifies_0, owningClass).booleanValue();
					//
					if (!conformsTo) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (conformsTo) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, forAll, QVTrelationSupport.INT_0).booleanValue();
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
	public boolean validatePartsAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Key::PartsAreUnique";
		try {
			/**
			 *
			 * inv PartsAreUnique:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = part->excludesAll(oppositePart.opposite)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTrelationSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_excludesAll;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> part_0 = this.getPart();
					final /*@NonInvalid*/ @Nullable SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Property, part_0);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> oppositePart_0 = this.getOppositePart();
					final /*@NonInvalid*/ @Nullable SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationSupport.SET_CLSSid_Property, oppositePart_0);
					/*@NonInvalid*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationSupport.BAG_CLSSid_Property);
					@NonNull Iterator<Object> ITER__1 = BOXED_oppositePart.iterator();
					/*@Thrown*/ @NonNull BagValue collect;
					while (true) {
						if (!ITER__1.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITER__1.next();
						/**
						 * opposite
						 */
						final /*@NonInvalid*/ @Nullable Property opposite = _1.getOpposite();
						//
						accumulator.add(opposite);
					}
					final /*@Thrown*/ boolean excludesAll = CollectionExcludesAllOperation.INSTANCE.evaluate(BOXED_part, collect).booleanValue();
					CAUGHT_excludesAll = excludesAll;
				}
				catch (Exception THROWN_CAUGHT_excludesAll) {
					CAUGHT_excludesAll = ValueUtil.createInvalidValue(THROWN_CAUGHT_excludesAll);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_excludesAll, QVTrelationSupport.INT_0).booleanValue();
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
	public EList<Property> getOppositePart() {
		if (oppositePart == null) {
			oppositePart = new EObjectResolvingEList<Property>(Property.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		}
		return oppositePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((RelationalTransformation)otherEnd, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return eInternalContainer().eInverseRemove(this, TransformationImpl.TRANSFORMATION_FEATURE_COUNT + 0, RelationalTransformation.class, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getIdentifies();
				return basicGetIdentifies();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return getOppositePart();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return getPart();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setIdentifies((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				getOppositePart().clear();
				getOppositePart().addAll((Collection<? extends Property>)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				getPart().clear();
				getPart().addAll((Collection<? extends Property>)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setTransformation((RelationalTransformation)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setIdentifies((org.eclipse.ocl.pivot.Class)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				getOppositePart().clear();
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				getPart().clear();
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setTransformation((RelationalTransformation)null);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return identifies != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return oppositePart != null && !oppositePart.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return part != null && !part.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
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
			case ElementImpl.ELEMENT_OPERATION_COUNT + 0:
				return validateIdentifiesIsNotAbstract((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 1:
				return validateIdentifiesIsAUsedPackageClass((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 2:
				return validateNoSuperKeys((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 3:
				return validateIdentifiesIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 4:
				return validateOppositePartsHaveOpposites((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 5:
				return validateOppositePartsAreOppositeParts((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 6:
				return validatePartsAreParts((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 7:
				return validatePartsAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
			return (R) ((QVTrelationVisitor<?>)visitor).visitKey(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //KeyImpl
