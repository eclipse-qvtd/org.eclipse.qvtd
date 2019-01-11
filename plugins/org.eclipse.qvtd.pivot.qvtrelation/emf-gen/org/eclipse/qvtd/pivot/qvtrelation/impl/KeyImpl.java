/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.KEY__IDENTIFIES, oldIdentifies, identifies));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.KEY__IDENTIFIES, oldIdentifies, identifies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getPart() {
		if (part == null) {
			part = new EObjectResolvingEList<Property>(Property.class, this, QVTrelationPackage.KEY__PART);
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
		if (eContainerFeatureID() != QVTrelationPackage.KEY__TRANSFORMATION) return null;
		return (RelationalTransformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(RelationalTransformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QVTrelationPackage.KEY__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(RelationalTransformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != QVTrelationPackage.KEY__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QVTrelationPackage.RELATIONAL_TRANSFORMATION__OWNED_KEY, RelationalTransformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.KEY__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIdentifiesIsNotAbstract(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv IdentifiesIsNotAbstract:
			 *   let severity : Integer[1] = 'Key::IdentifiesIsNotAbstract'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not identifies.isAbstract
			 *       in
			 *         'Key::IdentifiesIsNotAbstract'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_IdentifiesIsNotAbstract);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
				final /*@NonInvalid*/ boolean isAbstract = identifies.isIsAbstract();
				final /*@NonInvalid*/ java.lang.@Nullable Boolean result = BooleanNotOperation.INSTANCE.evaluate(isAbstract);
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_IdentifiesIsNotAbstract, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::IdentifiesIsNotAbstract", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIdentifiesIsAUsedPackageClass(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv IdentifiesIsAUsedPackageClass:
			 *   let
			 *     severity : Integer[1] = 'Key::IdentifiesIsAUsedPackageClass'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         transformation.modelParameter.usedPackage->includes(identifies.owningPackage)
			 *       in
			 *         'Key::IdentifiesIsAUsedPackageClass'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_IdentifiesIsAUsedPackageClass);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					/*@Thrown*/ boolean result;
					if (ne) {
						if (transformation == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTbase\'::Transformation::modelParameter\'");
						}
						final /*@Thrown*/ java.util.@NonNull List<TypedModel> modelParameter = transformation.getModelParameter();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_modelParameter = idResolver.createOrderedSetOfAll(QVTrelationTables.ORD_CLSSid_TypedModel, modelParameter);
						/*@Thrown*/ org.eclipse.ocl.pivot.values.SequenceValue.@NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(QVTrelationTables.SEQ_CLSSid_Package);
						java.util.@NonNull Iterator<Object> ITERATOR__1 = BOXED_modelParameter.iterator();
						/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
						while (true) {
							if (!ITERATOR__1.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel _1 = (org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel)ITERATOR__1.next();
							/**
							 * usedPackage
							 */
							final /*@NonInvalid*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = _1.getUsedPackage();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_usedPackage = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Package, usedPackage);
							//
							for (Object value : BOXED_usedPackage.flatten().getElements()) {
								accumulator.add(value);
							}
						}
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Package owningPackage = identifies.getOwningPackage();
						final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, owningPackage).booleanValue();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_IdentifiesIsAUsedPackageClass, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::IdentifiesIsAUsedPackageClass", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNoSuperKeys(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv NoSuperKeys:
			 *   let severity : Integer[1] = 'Key::NoSuperKeys'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         let
			 *           superClasses : Set(Class) = identifies.superClasses->closure(superClasses)
			 *         in
			 *           let
			 *             otherKeys : Set(qvtrelation::Key) = transformation.ownedKey->excluding(self)
			 *           in otherKeys.identifies->excludesAll(superClasses)
			 *       in
			 *         'Key::NoSuperKeys'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_NoSuperKeys);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_1;
			if (le) {
				symbol_1 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					/*@Thrown*/ boolean result;
					if (ne) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
						final /*@NonInvalid*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Class> superClasses_0 = identifies.getSuperClasses();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_superClasses_0 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Class, superClasses_0);
						final org.eclipse.ocl.pivot.@NonNull Class TYPE_superClasses_2 = executor.getStaticTypeOf(BOXED_superClasses_0);
						final org.eclipse.ocl.pivot.library.LibraryIteration.@NonNull LibraryIterationExtension IMPL_superClasses_2 = (LibraryIterationExtension)TYPE_superClasses_2.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
						final @NonNull Object ACC_superClasses_2 = IMPL_superClasses_2.createAccumulatorValue(executor, QVTrelationTables.SET_CLSSid_Class, QVTrelationTables.SET_CLSSid_Class);
						/**
						 * Implementation of the iterator body.
						 */
						final org.eclipse.ocl.pivot.library.@NonNull AbstractBinaryOperation BODY_superClasses_2 = new AbstractBinaryOperation() {
							/**
							 * superClasses
							 */
							@Override
							public @Nullable Object evaluate(final org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor, final org.eclipse.ocl.pivot.ids.@NonNull TypeId typeId, final @Nullable Object BOXED_superClasses_0, final /*@NonInvalid*/ @Nullable Object _1) {
								final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class symbol_0 = (org.eclipse.ocl.pivot.Class)_1;
								if (symbol_0 == null) {
									throw new InvalidValueException("Null source for \'Class::superClasses\'");
								}
								final /*@Thrown*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Class> superClasses_1 = symbol_0.getSuperClasses();
								final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_superClasses_1 = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Class, superClasses_1);
								return BOXED_superClasses_1;
							}
						};
						final org.eclipse.ocl.pivot.internal.library.executor.@NonNull ExecutorSingleIterationManager MGR_superClasses_2 = new ExecutorSingleIterationManager(executor, QVTrelationTables.SET_CLSSid_Class, BODY_superClasses_2, BOXED_superClasses_0, ACC_superClasses_2);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue superClasses = (org.eclipse.ocl.pivot.values.@NonNull SetValue)IMPL_superClasses_2.evaluateIteration(MGR_superClasses_2);
						if (transformation == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTrelation\'::RelationalTransformation::ownedKey\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.util.@NonNull List<Key> ownedKey = transformation.getOwnedKey();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_ownedKey = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Key, ownedKey);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue otherKeys = (org.eclipse.ocl.pivot.values.@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedKey, this);
						/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Class);
						java.util.@NonNull Iterator<Object> ITERATOR__1_0 = otherKeys.iterator();
						/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull BagValue collect;
						while (true) {
							if (!ITERATOR__1_0.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key _1_0 = (org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key)ITERATOR__1_0.next();
							/**
							 * identifies
							 */
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies_0 = _1_0.getIdentifies();
							//
							accumulator.add(identifies_0);
						}
						final /*@Thrown*/ boolean excludesAll = CollectionExcludesAllOperation.INSTANCE.evaluate(collect, superClasses).booleanValue();
						result = excludesAll;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_NoSuperKeys, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_1 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_1;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::NoSuperKeys", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIdentifiesIsUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv IdentifiesIsUnique:
			 *   let severity : Integer[1] = 'Key::IdentifiesIsUnique'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = transformation <> null implies
			 *         let
			 *           otherKeys : Set(qvtrelation::Key) = transformation.ownedKey->excluding(self)
			 *         in otherKeys.identifies->excludes(identifies)
			 *       in
			 *         'Key::IdentifiesIsUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_IdentifiesIsUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@Nullable RelationalTransformation transformation = this.getTransformation();
					final /*@NonInvalid*/ boolean ne = transformation != null;
					/*@Thrown*/ boolean result;
					if (ne) {
						if (transformation == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTrelation\'::RelationalTransformation::ownedKey\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.util.@NonNull List<Key> ownedKey = transformation.getOwnedKey();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_ownedKey = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Key, ownedKey);
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue otherKeys = (org.eclipse.ocl.pivot.values.@Nullable SetValue)CollectionExcludingOperation.INSTANCE.evaluate(BOXED_ownedKey, this);
						/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Class);
						java.util.@NonNull Iterator<Object> ITERATOR__1 = otherKeys.iterator();
						/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull BagValue collect;
						while (true) {
							if (!ITERATOR__1.hasNext()) {
								collect = accumulator;
								break;
							}
							@SuppressWarnings("null")
							/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key _1 = (org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key)ITERATOR__1.next();
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
						result = excludes;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_IdentifiesIsUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::IdentifiesIsUnique", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOppositePartsHaveOpposites(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv OppositePartsHaveOpposites:
			 *   let severity : Integer[1] = 'Key::OppositePartsHaveOpposites'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = oppositePart->forAll(opposite <> null)
			 *       in
			 *         'Key::OppositePartsHaveOpposites'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_OppositePartsHaveOpposites);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<Property> oppositePart = this.getOppositePart();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				java.util.@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
				/*@NonInvalid*/ java.lang.@Nullable Boolean result;
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
					/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property _1 = (org.eclipse.ocl.pivot.@NonNull Property)ITERATOR__1.next();
					/**
					 * opposite <> null
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property opposite = _1.getOpposite();
					final /*@NonInvalid*/ boolean ne = opposite != null;
					//
					if (ne == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
						result = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (ne == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_OppositePartsHaveOpposites, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::OppositePartsHaveOpposites", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOppositePartsAreOppositeParts(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv OppositePartsAreOppositeParts:
			 *   let
			 *     severity : Integer[1] = 'Key::OppositePartsAreOppositeParts'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = oppositePart->forAll(
			 *           self.identifies.conformsTo(type))
			 *       in
			 *         'Key::OppositePartsAreOppositeParts'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_OppositePartsAreOppositeParts);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<Property> oppositePart = this.getOppositePart();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					java.util.@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
					/*@Thrown*/ java.lang.@Nullable Boolean result;
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
						/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property _1 = (org.eclipse.ocl.pivot.@NonNull Property)ITERATOR__1.next();
						/**
						 * self.identifies.conformsTo(type)
						 */
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class identifies = this.getIdentifies();
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = _1.getType();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_OppositePartsAreOppositeParts, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::OppositePartsAreOppositeParts", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePartsAreParts(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv PartsAreParts:
			 *   let severity : Integer[1] = 'Key::PartsAreParts'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = part->forAll(
			 *           self.identifies.conformsTo(owningClass))
			 *       in
			 *         'Key::PartsAreParts'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_PartsAreParts);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<Property> part = this.getPart();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, part);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					java.util.@NonNull Iterator<Object> ITERATOR__1 = BOXED_part.iterator();
					/*@Thrown*/ java.lang.@Nullable Boolean result;
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
						/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property _1 = (org.eclipse.ocl.pivot.@NonNull Property)ITERATOR__1.next();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_PartsAreParts, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::PartsAreParts", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validatePartsAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv PartsAreUnique:
			 *   let severity : Integer[1] = 'Key::PartsAreUnique'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = part->excludesAll(oppositePart.opposite)
			 *       in
			 *         'Key::PartsAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_Key_c_c_PartsAreUnique);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<Property> part = this.getPart();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_part = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, part);
					@SuppressWarnings("null")
					final /*@NonInvalid*/ java.util.@NonNull List<Property> oppositePart = this.getOppositePart();
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_oppositePart = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_Property, oppositePart);
					/*@Thrown*/ org.eclipse.ocl.pivot.values.BagValue.@NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(QVTrelationTables.BAG_CLSSid_Property);
					java.util.@NonNull Iterator<Object> ITERATOR__1 = BOXED_oppositePart.iterator();
					/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull BagValue collect;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect = accumulator;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Property _1 = (org.eclipse.ocl.pivot.@NonNull Property)ITERATOR__1.next();
						/**
						 * opposite
						 */
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Property opposite = _1.getOpposite();
						//
						accumulator.add(opposite);
					}
					final /*@Thrown*/ boolean result = CollectionExcludesAllOperation.INSTANCE.evaluate(BOXED_part, collect).booleanValue();
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_Key_c_c_PartsAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("Key::PartsAreUnique", this, diagnostics, context, e);
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
			oppositePart = new EObjectResolvingEList<Property>(Property.class, this, QVTrelationPackage.KEY__OPPOSITE_PART);
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
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QVTrelationPackage.RELATIONAL_TRANSFORMATION__OWNED_KEY, RelationalTransformation.class, msgs);
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
			case QVTrelationPackage.KEY__IDENTIFIES:
				if (resolve) return getIdentifies();
				return basicGetIdentifies();
			case QVTrelationPackage.KEY__OPPOSITE_PART:
				return getOppositePart();
			case QVTrelationPackage.KEY__PART:
				return getPart();
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY__IDENTIFIES:
				setIdentifies((org.eclipse.ocl.pivot.Class)newValue);
				return;
			case QVTrelationPackage.KEY__OPPOSITE_PART:
				getOppositePart().clear();
				getOppositePart().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTrelationPackage.KEY__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY__IDENTIFIES:
				setIdentifies((org.eclipse.ocl.pivot.Class)null);
				return;
			case QVTrelationPackage.KEY__OPPOSITE_PART:
				getOppositePart().clear();
				return;
			case QVTrelationPackage.KEY__PART:
				getPart().clear();
				return;
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY__IDENTIFIES:
				return identifies != null;
			case QVTrelationPackage.KEY__OPPOSITE_PART:
				return oppositePart != null && !oppositePart.isEmpty();
			case QVTrelationPackage.KEY__PART:
				return part != null && !part.isEmpty();
			case QVTrelationPackage.KEY__TRANSFORMATION:
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
			case QVTrelationPackage.KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP:
				return validateIdentifiesIsNotAbstract((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP:
				return validateIdentifiesIsAUsedPackageClass((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP:
				return validateNoSuperKeys((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateIdentifiesIsUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP:
				return validateOppositePartsHaveOpposites((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP:
				return validateOppositePartsAreOppositeParts((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP:
				return validatePartsAreParts((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTrelationPackage.KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP:
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
		return (R) ((QVTrelationVisitor<?>)visitor).visitKey(this);
	}
} //KeyImpl
