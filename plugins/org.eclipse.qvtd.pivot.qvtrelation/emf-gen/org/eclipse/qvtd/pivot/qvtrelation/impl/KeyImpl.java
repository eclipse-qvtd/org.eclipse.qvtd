/*******************************************************************************
 * Copyright (c) 2011, 2022 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
				final /*@NonInvalid*/ boolean isAbstract = identifies.isIsAbstract();
				final /*@NonInvalid*/ @Nullable Boolean result;
				if (!isAbstract) {
					result = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isAbstract) {
						result = ValueUtil.FALSE_VALUE;
					}
					else {
						result = null;
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_includes;
						try {
							if (transformation == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::modelParameter\'");
							}
							final /*@Thrown*/ @NonNull List<TypedModel> modelParameter = transformation.getModelParameter();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_TypedModel, modelParameter);
							/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_Package);
							@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter.iterator();
							/*@Thrown*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull TypedModel _1 = (@NonNull TypedModel)ITERATOR__1.next();
								/**
								 * usedPackage
								 */
								final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = _1.getUsedPackage();
								final /*@NonInvalid*/ @NonNull SetValue BOXED_usedPackage = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Package, usedPackage);
								//
								for (Object value : BOXED_usedPackage.flatten().getElements()) {
									accumulator.add(value);
								}
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Package owningPackage = identifies.getOwningPackage();
							final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, owningPackage).booleanValue();
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
			final /*@NonInvalid*/ @NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_excludesAll;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
							final /*@NonInvalid*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses_0 = identifies.getSuperClasses();
							final /*@NonInvalid*/ @NonNull SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Class, superClasses_0);
							final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_2 = executor.getStaticTypeOfValue(null, BOXED_superClasses_0);
							final @NonNull LibraryIterationExtension IMPL_superClasses_2 = (LibraryIterationExtension)TYPE_superClasses_2.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
							final @NonNull Object ACC_superClasses_2 = IMPL_superClasses_2.createAccumulatorValue(executor, QVTrelationTables.SET_CLSSid_Class, QVTrelationTables.SET_CLSSid_Class);
							/**
							 * Implementation of the iterator body.
							 */
							final @NonNull AbstractBinaryOperation BODY_superClasses_2 = new AbstractBinaryOperation() {
								/**
								 * superClasses
								 */
								@Override
								public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object BOXED_superClasses_0, final /*@NonInvalid*/ @Nullable Object _1) {
									final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class CAST_null = (org.eclipse.ocl.pivot.Class)_1;
									if (CAST_null == null) {
										throw new InvalidValueException("Null source for \'Class::superClasses\'");
									}
									final /*@Thrown*/ @NonNull List<org.eclipse.ocl.pivot.Class> superClasses_1 = CAST_null.getSuperClasses();
									final /*@Thrown*/ @NonNull SetValue BOXED_superClasses_1 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Class, superClasses_1);
									return BOXED_superClasses_1;
								}
							};
							final @NonNull ExecutorSingleIterationManager MGR_superClasses_2 = new ExecutorSingleIterationManager(executor, QVTrelationTables.SET_CLSSid_Class, BODY_superClasses_2, BOXED_superClasses_0, ACC_superClasses_2);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull SetValue superClasses = (@NonNull SetValue)IMPL_superClasses_2.evaluateIteration(MGR_superClasses_2);
							final /*@NonInvalid*/ @NonNull Object ownedKey = transformation == null;
							/*@Thrown*/ @Nullable SetValue safe_ownedKey_source;
							if (ownedKey == Boolean.TRUE) {
								safe_ownedKey_source = null;
							}
							else {
								assert transformation != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<Key> ownedKey_0 = transformation.getOwnedKey();
								final /*@Thrown*/ @NonNull SetValue BOXED_ownedKey_0 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Key, ownedKey_0);
								safe_ownedKey_source = BOXED_ownedKey_0;
							}
							if (safe_ownedKey_source == null) {
								throw new InvalidValueException("Null \'\'Collection\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @NonNull SetValue safe_excluding_sources = (@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(safe_ownedKey_source, (Object)null);
							final /*@Thrown*/ @NonNull SetValue otherKeys = (@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(safe_excluding_sources, this);
							/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Class);
							@NonNull Iterator<Object> ITERATOR__1_0 = otherKeys.iterator();
							/*@Thrown*/ @NonNull BagValue collect;
							while (true) {
								if (!ITERATOR__1_0.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Key _1_0 = (@NonNull Key)ITERATOR__1_0.next();
								/**
								 * identifies
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = _1_0.getIdentifies();
								//
								accumulator.add(identifies_0);
							}
							if (superClasses instanceof InvalidValueException) {
								throw (InvalidValueException)superClasses;
							}
							final /*@Thrown*/ boolean excludesAll = CollectionExcludesAllOperation.INSTANCE.evaluate(collect, superClasses).booleanValue();
							CAUGHT_excludesAll = excludesAll;
						}
						catch (Exception e) {
							CAUGHT_excludesAll = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_excludesAll == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_excludesAll instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excludesAll;
							}
							result = ValueUtil.FALSE_VALUE;
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_excludes;
						try {
							final /*@NonInvalid*/ @NonNull Object ownedKey = transformation == null;
							/*@Thrown*/ @Nullable SetValue safe_ownedKey_source;
							if (ownedKey == Boolean.TRUE) {
								safe_ownedKey_source = null;
							}
							else {
								assert transformation != null;
								@SuppressWarnings("null")
								final /*@Thrown*/ @NonNull List<Key> ownedKey_0 = transformation.getOwnedKey();
								final /*@Thrown*/ @NonNull SetValue BOXED_ownedKey_0 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Key, ownedKey_0);
								safe_ownedKey_source = BOXED_ownedKey_0;
							}
							if (safe_ownedKey_source == null) {
								throw new InvalidValueException("Null \'\'Collection\'\' rather than \'\'OclVoid\'\' value required");
							}
							final /*@Thrown*/ @NonNull SetValue safe_excluding_sources = (@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(safe_ownedKey_source, (Object)null);
							final /*@Thrown*/ @NonNull SetValue otherKeys = (@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(safe_excluding_sources, this);
							/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Class);
							@NonNull Iterator<Object> ITERATOR__1 = otherKeys.iterator();
							/*@Thrown*/ @NonNull BagValue collect;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									collect = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull Key _1 = (@NonNull Key)ITERATOR__1.next();
								/**
								 * identifies
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = _1.getIdentifies();
								//
								accumulator.add(identifies);
							}
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = this.getIdentifies();
							final /*@Thrown*/ boolean excludes = CollectionExcludesOperation.INSTANCE.evaluate(collect, identifies_0).booleanValue();
							CAUGHT_excludes = excludes;
						}
						catch (Exception e) {
							CAUGHT_excludes = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_excludes == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_excludes instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_excludes;
							}
							result = ValueUtil.FALSE_VALUE;
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<Property> oppositePart = this.getOppositePart();
				final /*@NonInvalid*/ @NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
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
					/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITERATOR__1.next();
					/**
					 * opposite <> null
					 */
					final /*@NonInvalid*/ @Nullable Property opposite = _1.getOpposite();
					final /*@NonInvalid*/ boolean ne = opposite != null;
					//
					if (!ne) {					// Normal unsuccessful body evaluation result
						result = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (ne) {				// Normal successful body evaluation result
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> oppositePart = this.getOppositePart();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
					/*@Thrown*/ @Nullable Boolean result;
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
						/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITERATOR__1.next();
						/**
						 * self.identifies.conformsTo(type)
						 */
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
							final /*@NonInvalid*/ @Nullable Type type = _1.getType();
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, identifies, type).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception e) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
						}
						//
						if (CAUGHT_conformsTo == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							result = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (CAUGHT_conformsTo instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = CAUGHT_conformsTo;									// Cache an exception failure
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> part = this.getPart();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, part);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_part.iterator();
					/*@Thrown*/ @Nullable Boolean result;
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
						/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITERATOR__1.next();
						/**
						 * self.identifies.conformsTo(owningClass)
						 */
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = _1.getOwningClass();
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, identifies, owningClass).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception e) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
						}
						//
						if (CAUGHT_conformsTo == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							result = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (CAUGHT_conformsTo instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = CAUGHT_conformsTo;									// Cache an exception failure
						}
						else {															// Impossible badly typed result
							accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
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
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationPackage.Literals.KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> part = this.getPart();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, part);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<Property> oppositePart = this.getOppositePart();
					final /*@NonInvalid*/ @NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
					/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Property);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
					/*@Thrown*/ @NonNull BagValue collect;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ @NonNull Property _1 = (@NonNull Property)ITERATOR__1.next();
						/**
						 * opposite
						 */
						final /*@NonInvalid*/ @Nullable Property opposite = _1.getOpposite();
						//
						accumulator.add(opposite);
					}
					if (collect instanceof InvalidValueException) {
						throw (InvalidValueException)collect;
					}
					final /*@Thrown*/ boolean result = CollectionExcludesAllOperation.INSTANCE.evaluate(BOXED_part, collect).booleanValue();
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
