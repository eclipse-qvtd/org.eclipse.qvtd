/**
 * <copyright>
 *
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore.impl;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
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
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;

import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bottom Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getEnforcementOperation <em>Enforcement Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl#getRealizedVariable <em>Realized Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BottomPatternImpl extends CorePatternImpl implements BottomPattern {
	/**
	 * The number of structural features of the '<em>Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_PATTERN_FEATURE_COUNT = CorePatternImpl.CORE_PATTERN_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_PATTERN_OPERATION_COUNT = CorePatternImpl.CORE_PATTERN_OPERATION_COUNT + 1;

	/**
	 * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignment;

	/**
	 * The cached value of the '{@link #getEnforcementOperation() <em>Enforcement Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcementOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<EnforcementOperation> enforcementOperation;

	/**
	 * The cached value of the '{@link #getRealizedVariable() <em>Realized Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<RealizedVariable> realizedVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BottomPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.BOTTOM_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Area getArea() {
		if (eContainerFeatureID() != (PatternImpl.PATTERN_FEATURE_COUNT + 1)) return null;
		return (Area)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArea(Area newArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newArea, PatternImpl.PATTERN_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArea(Area newArea) {
		if (newArea != eInternalContainer() || (eContainerFeatureID() != (PatternImpl.PATTERN_FEATURE_COUNT + 1) && newArea != null)) {
			if (EcoreUtil.isAncestor(this, newArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newArea != null)
				msgs = ((InternalEObject)newArea).eInverseAdd(this, ElementImpl.ELEMENT_FEATURE_COUNT + 1, Area.class, msgs);
			msgs = basicSetArea(newArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternImpl.PATTERN_FEATURE_COUNT + 1, newArea, newArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Assignment> getAssignment() {
		if (assignment == null) {
			assignment = new EObjectContainmentWithInverseEList<Assignment>(Assignment.class, this, PatternImpl.PATTERN_FEATURE_COUNT + 2, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		}
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnforcementOperation> getEnforcementOperation() {
		if (enforcementOperation == null) {
			enforcementOperation = new EObjectContainmentWithInverseEList<EnforcementOperation>(EnforcementOperation.class, this, PatternImpl.PATTERN_FEATURE_COUNT + 3, ElementImpl.ELEMENT_FEATURE_COUNT + 1);
		}
		return enforcementOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RealizedVariable> getRealizedVariable() {
		if (realizedVariable == null) {
			realizedVariable = new EObjectContainmentEList<RealizedVariable>(RealizedVariable.class, this, PatternImpl.PATTERN_FEATURE_COUNT + 4);
		}
		return realizedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateVariablesAreBottomVariables(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "BottomPattern::VariablesAreBottomVariables";
		try {
			/**
			 *
			 * inv VariablesAreBottomVariables:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = ownedVariables->forAll(
			 *           oclIsKindOf(BottomVariable))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.BOTTOM_PATTERN___VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull List<VariableDeclaration> ownedVariables = this.getOwnedVariables();
				final /*@NonInvalid*/ @NonNull SetValue BOXED_ownedVariables = idResolver.createSetOfAll(QVTcoreTables.SET_CLSSid_VariableDeclaration, ownedVariables);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedVariables.iterator();
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
					/*@NonInvalid*/ @NonNull VariableDeclaration _1 = (@NonNull VariableDeclaration)ITERATOR__1.next();
					/**
					 * oclIsKindOf(BottomVariable)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtcore_c_c_BottomVariable = idResolver.getClass(QVTcoreTables.CLSSid_BottomVariable, null);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, TYP_qvtcore_c_c_BottomVariable).booleanValue();
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
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetArea((Area)otherEnd, msgs);
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssignment()).basicAdd(otherEnd, msgs);
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnforcementOperation()).basicAdd(otherEnd, msgs);
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				return basicSetArea(null, msgs);
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getAssignment()).basicRemove(otherEnd, msgs);
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getEnforcementOperation()).basicRemove(otherEnd, msgs);
			case PatternImpl.PATTERN_FEATURE_COUNT + 4:
				return ((InternalEList<?>)getRealizedVariable()).basicRemove(otherEnd, msgs);
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, ElementImpl.ELEMENT_FEATURE_COUNT + 1, Area.class, msgs);
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				return getArea();
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				return getAssignment();
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				return getEnforcementOperation();
			case PatternImpl.PATTERN_FEATURE_COUNT + 4:
				return getRealizedVariable();
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				setArea((Area)newValue);
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				getAssignment().clear();
				getAssignment().addAll((Collection<? extends Assignment>)newValue);
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				getEnforcementOperation().clear();
				getEnforcementOperation().addAll((Collection<? extends EnforcementOperation>)newValue);
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 4:
				getRealizedVariable().clear();
				getRealizedVariable().addAll((Collection<? extends RealizedVariable>)newValue);
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				setArea((Area)null);
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				getAssignment().clear();
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				getEnforcementOperation().clear();
				return;
			case PatternImpl.PATTERN_FEATURE_COUNT + 4:
				getRealizedVariable().clear();
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
			case PatternImpl.PATTERN_FEATURE_COUNT + 1:
				return getArea() != null;
			case PatternImpl.PATTERN_FEATURE_COUNT + 2:
				return assignment != null && !assignment.isEmpty();
			case PatternImpl.PATTERN_FEATURE_COUNT + 3:
				return enforcementOperation != null && !enforcementOperation.isEmpty();
			case PatternImpl.PATTERN_FEATURE_COUNT + 4:
				return realizedVariable != null && !realizedVariable.isEmpty();
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
			case PatternImpl.PATTERN_OPERATION_COUNT + 1:
				return validateVariablesAreBottomVariables((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTcoreVisitor) {
			return (R) ((QVTcoreVisitor<?>)visitor).visitBottomPattern(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //BottomPatternImpl
