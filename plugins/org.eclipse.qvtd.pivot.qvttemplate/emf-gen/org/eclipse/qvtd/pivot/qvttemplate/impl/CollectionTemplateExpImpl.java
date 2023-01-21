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
package org.eclipse.qvtd.pivot.qvttemplate.impl;

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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.LiteralExpImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionElementTypeProperty;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateSupport;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.CollectionTemplateExpImpl#getMember <em>Member</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.CollectionTemplateExpImpl#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.CollectionTemplateExpImpl#getRest <em>Rest</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTemplateExpImpl extends TemplateExpImpl implements CollectionTemplateExp {
	/**
	 * The number of structural features of the '<em>Collection Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TEMPLATE_EXP_FEATURE_COUNT = TemplateExpImpl.TEMPLATE_EXP_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Collection Template Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION_TEMPLATE_EXP_OPERATION_COUNT = TemplateExpImpl.TEMPLATE_EXP_OPERATION_COUNT + 3;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> member;

	/**
	 * The cached value of the '{@link #getReferredCollectionType() <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredCollectionType()
	 * @generated
	 * @ordered
	 */
	protected CollectionType referredCollectionType;

	/**
	 * The cached value of the '{@link #getRest() <em>Rest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRest()
	 * @generated
	 * @ordered
	 */
	protected Variable rest;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OCLExpression> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionType getReferredCollectionType() {
		if (referredCollectionType != null && referredCollectionType.eIsProxy()) {
			InternalEObject oldReferredCollectionType = (InternalEObject)referredCollectionType;
			referredCollectionType = (CollectionType)eResolveProxy(oldReferredCollectionType);
			if (referredCollectionType != oldReferredCollectionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3, oldReferredCollectionType, referredCollectionType));
			}
		}
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType basicGetReferredCollectionType() {
		return referredCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredCollectionType(CollectionType newReferredCollectionType) {
		CollectionType oldReferredCollectionType = referredCollectionType;
		referredCollectionType = newReferredCollectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3, oldReferredCollectionType, referredCollectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getRest() {
		if (rest != null && rest.eIsProxy()) {
			InternalEObject oldRest = (InternalEObject)rest;
			rest = (Variable)eResolveProxy(oldRest);
			if (rest != oldRest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4, oldRest, rest));
			}
		}
		return rest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetRest() {
		return rest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRest(Variable newRest) {
		Variable oldRest = rest;
		rest = newRest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4, oldRest, rest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMemberTypeisCollectionElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "CollectionTemplateExp::MemberTypeisCollectionElementType";
		try {
			/**
			 *
			 * inv MemberTypeisCollectionElementType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = member->forAll(
			 *           type?.conformsTo(referredCollectionType.elementType))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP___VALIDATE_MEMBER_TYPEIS_COLLECTION_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTtemplateSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_forAll;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull List<OCLExpression> member_0 = this.getMember();
					final /*@NonInvalid*/ @Nullable SetValue BOXED_member = idResolver.createSetOfAll(QVTtemplateSupport.SET_CLSSid_OCLExpression, member_0);
					/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
					@NonNull Iterator<Object> ITER__1 = BOXED_member.iterator();
					/*@Thrown*/ @Nullable Boolean forAll;
					while (true) {
						if (!ITER__1.hasNext()) {
							if (accumulator == null) {
								forAll = null;
							}
							else if (accumulator == ValueUtil.TRUE_VALUE) {
								forAll = ValueUtil.TRUE_VALUE;
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
						 * type?.conformsTo(referredCollectionType.elementType)
						 */
						final /*@NonInvalid*/ @Nullable Type type = _1.getType();
						final /*@NonInvalid*/ Boolean IsEQ2_ = type == null;
						/*@Caught*/ @Nullable Object IF_IsEQ2_;
						if (IsEQ2_) {
							IF_IsEQ2_ = null;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_conformsTo;
							try {
								if (type == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' elementId");
								}
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull CollectionType referredCollectionType_0 = this.getReferredCollectionType();
								final /*@NonInvalid*/ @NonNull Type elementType = (@Nullable Type)CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTtemplateSupport.CLSSid_Type, referredCollectionType_0);
								final /*@Thrown*/ Boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, elementType).booleanValue();
								CAUGHT_conformsTo = conformsTo;
							}
							catch (Exception THROWN_CAUGHT_conformsTo) {
								CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
							}
							IF_IsEQ2_ = CAUGHT_conformsTo;
						}
						//
						if (IF_IsEQ2_ == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
							forAll = ValueUtil.FALSE_VALUE;
							break;														// Stop immediately
						}
						else if (IF_IsEQ2_ == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
							;															// Carry on
						}
						else if (IF_IsEQ2_ == null) {								// Abnormal null body evaluation result
							if (accumulator == ValueUtil.TRUE_VALUE) {
								accumulator = null;										// Cache a null failure
							}
						}
						else if (IF_IsEQ2_ instanceof InvalidValueException) {		// Abnormal exception evaluation result
							accumulator = IF_IsEQ2_;									// Cache an exception failure
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_forAll, QVTtemplateSupport.INT_0).booleanValue();
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
	public boolean validateRestTypeisCollectionType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "CollectionTemplateExp::RestTypeisCollectionType";
		try {
			/**
			 *
			 * inv RestTypeisCollectionType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = rest <> null implies rest.type = referredCollectionType
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP___VALIDATE_REST_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTtemplateSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable Variable rest_0 = this.getRest();
					final /*@NonInvalid*/ boolean IsEQ_ = rest_0 != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_IsEQ_;
						try {
							if (rest_0 == null) {
								throw new InvalidValueException("Null source for \'TypedElement::type\'");
							}
							final /*@Thrown*/ @Nullable Type type = rest_0.getType();
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull CollectionType referredCollectionType_0 = this.getReferredCollectionType();
							final /*@Thrown*/ boolean IsEQ__0 = (type != null) ? (type.getTypeId() == referredCollectionType_0.getTypeId()) : false;
							CAUGHT_IsEQ_ = IsEQ__0;
						}
						catch (Exception THROWN_CAUGHT_IsEQ_) {
							CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
						}
						if (CAUGHT_IsEQ_ == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_IsEQ_ instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_IsEQ_;
							}
							implies = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTtemplateSupport.INT_0).booleanValue();
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
	public boolean validateTypeisCollectionType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "CollectionTemplateExp::TypeisCollectionType";
		try {
			/**
			 *
			 * inv TypeisCollectionType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[1] = type = referredCollectionType
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplatePackage.Literals.COLLECTION_TEMPLATE_EXP___VALIDATE_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTtemplateSupport.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable Type type = this.getType();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull CollectionType referredCollectionType_0 = this.getReferredCollectionType();
				final /*@NonInvalid*/ boolean IsEQ_ = (type != null) ? (type.getTypeId() == referredCollectionType_0.getTypeId()) : false;
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IsEQ_, QVTtemplateSupport.INT_0).booleanValue();
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2:
				return getMember();
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3:
				if (resolve) return getReferredCollectionType();
				return basicGetReferredCollectionType();
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4:
				if (resolve) return getRest();
				return basicGetRest();
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2:
				getMember().clear();
				getMember().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3:
				setReferredCollectionType((CollectionType)newValue);
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4:
				setRest((Variable)newValue);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2:
				getMember().clear();
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3:
				setReferredCollectionType((CollectionType)null);
				return;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4:
				setRest((Variable)null);
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
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 2:
				return member != null && !member.isEmpty();
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 3:
				return referredCollectionType != null;
			case LiteralExpImpl.LITERAL_EXP_FEATURE_COUNT + 4:
				return rest != null;
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
			case LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 2:
				return validateMemberTypeisCollectionElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 3:
				return validateRestTypeisCollectionType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case LiteralExpImpl.LITERAL_EXP_OPERATION_COUNT + 4:
				return validateTypeisCollectionType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		if (visitor instanceof QVTtemplateVisitor) {
			return (R) ((QVTtemplateVisitor<?>)visitor).visitCollectionTemplateExp(this);
		}
		else {
			return super.accept(visitor);
		}
	}
} //CollectionTemplateExpImpl
