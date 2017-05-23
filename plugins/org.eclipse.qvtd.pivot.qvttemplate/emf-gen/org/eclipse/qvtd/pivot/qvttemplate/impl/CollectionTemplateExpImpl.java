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
package org.eclipse.qvtd.pivot.qvttemplate.impl;

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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateTables;
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
			member = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE, oldReferredCollectionType, referredCollectionType));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST, oldRest, rest));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST, oldRest, rest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateMemberTypeisCollectionElementType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv MemberTypeisCollectionElementType:
		 *   let
		 *     severity : Integer[1] = 'CollectionTemplateExp::MemberTypeisCollectionElementType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[?] = member->forAll(
		 *           type.conformsTo(referredCollectionType.elementType))
		 *       in
		 *         'CollectionTemplateExp::MemberTypeisCollectionElementType'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_CollectionTemplateExp_c_c_MemberTypeisCollectionElementType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<OCLExpression> member = this.getMember();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_member = idResolver.createSetOfAll(QVTtemplateTables.SET_CLSSid_OCLExpression, member);
				/*@Thrown*/ java.lang.@Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_member.iterator();
				/*@Thrown*/ boolean result;
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
					/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression _1 = (OCLExpression)ITERATOR__1.next();
					/**
					 *
					 * type.conformsTo(referredCollectionType.elementType)
					 */
					/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = _1.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull CollectionType referredCollectionType = this.getReferredCollectionType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Type elementType = referredCollectionType.getElementType();
						final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, elementType).booleanValue();
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
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_CollectionTemplateExp_c_c_MemberTypeisCollectionElementType, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateRestTypeisCollectionType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv RestTypeisCollectionType:
		 *   let
		 *     severity : Integer[1] = 'CollectionTemplateExp::RestTypeisCollectionType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = rest <> null implies rest.type = referredCollectionType
		 *       in
		 *         'CollectionTemplateExp::RestTypeisCollectionType'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_CollectionTemplateExp_c_c_RestTypeisCollectionType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Variable rest = this.getRest();
				final /*@NonInvalid*/ boolean ne = rest != null;
				/*@Thrown*/ boolean result;
				if (ne) {
					if (rest == null) {
						throw new InvalidValueException("Null source for \'TypedElement::type\'");
					}
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = rest.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull CollectionType referredCollectionType = this.getReferredCollectionType();
					final /*@Thrown*/ boolean eq = (type != null) ? (type.getTypeId() == referredCollectionType.getTypeId()) : false;
					result = eq;
				}
				else {
					result = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_CollectionTemplateExp_c_c_RestTypeisCollectionType, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTtemplateTables.INT_0).booleanValue();
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
	public boolean validateTypeisCollectionType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TypeisCollectionType:
		 *   let
		 *     severity : Integer[1] = 'CollectionTemplateExp::TypeisCollectionType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = type = referredCollectionType
		 *       in
		 *         'CollectionTemplateExp::TypeisCollectionType'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTtemplateTables.STR_CollectionTemplateExp_c_c_TypeisCollectionType);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTtemplateTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = this.getType();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull CollectionType referredCollectionType = this.getReferredCollectionType();
			final /*@NonInvalid*/ boolean result = (type != null) ? (type.getTypeId() == referredCollectionType.getTypeId()) : false;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTtemplateTables.STR_CollectionTemplateExp_c_c_TypeisCollectionType, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTtemplateTables.INT_0).booleanValue();
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
				return getMember();
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				if (resolve) return getReferredCollectionType();
				return basicGetReferredCollectionType();
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST:
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((CollectionType)newValue);
				return;
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST:
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
				getMember().clear();
				return;
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				setReferredCollectionType((CollectionType)null);
				return;
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST:
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
				return member != null && !member.isEmpty();
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE:
				return referredCollectionType != null;
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP__REST:
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
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP___VALIDATE_MEMBER_TYPEIS_COLLECTION_ELEMENT_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateMemberTypeisCollectionElementType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP___VALIDATE_REST_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateRestTypeisCollectionType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTtemplatePackage.COLLECTION_TEMPLATE_EXP___VALIDATE_TYPEIS_COLLECTION_TYPE__DIAGNOSTICCHAIN_MAP:
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
		return (R) ((QVTtemplateVisitor<?>)visitor).visitCollectionTemplateExp(this);
	}
} //CollectionTemplateExpImpl
