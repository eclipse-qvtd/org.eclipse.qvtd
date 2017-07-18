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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getDefaultAssignment <em>Default Assignment</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl#getRootVariable <em>Root Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationDomainImpl extends DomainImpl implements RelationDomain {
	/**
	 * The cached value of the '{@link #getDefaultAssignment() <em>Default Assignment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationDomainAssignment> defaultAssignment;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainPattern> pattern;

	/**
	 * The cached value of the '{@link #getRootVariable() <em>Root Variable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> rootVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<RelationDomainAssignment> getDefaultAssignment() {
		if (defaultAssignment == null) {
			defaultAssignment = new EObjectContainmentWithInverseEList<RelationDomainAssignment>(RelationDomainAssignment.class, this, QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER);
		}
		return defaultAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<DomainPattern> getPattern() {
		if (pattern == null) {
			pattern = new EObjectContainmentWithInverseEList<DomainPattern>(DomainPattern.class, this, QVTrelationPackage.RELATION_DOMAIN__PATTERN, QVTrelationPackage.DOMAIN_PATTERN__RELATION_DOMAIN);
		}
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<Variable> getRootVariable() {
		if (rootVariable == null) {
			rootVariable = new EObjectResolvingEList<Variable>(Variable.class, this, QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE);
		}
		return rootVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateRelationDomainAssignmentsAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv RelationDomainAssignmentsAreUnique:
		 *   let
		 *     severity : Integer[1] = 'RelationDomain::RelationDomainAssignmentsAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = defaultAssignment->isUnique(variable)
		 *       in
		 *         'RelationDomain::RelationDomainAssignmentsAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_RelationDomain_c_c_RelationDomainAssignmentsAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ java.util.@NonNull List<RelationDomainAssignment> defaultAssignment = this.getDefaultAssignment();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_defaultAssignment = idResolver.createSetOfAll(QVTrelationTables.SET_CLSSid_RelationDomainAssignment, defaultAssignment);
			/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTrelationTables.SET_CLSSid_RelationDomainAssignment);
			@NonNull Iterator<Object> ITERATOR__1 = BOXED_defaultAssignment.iterator();
			/*@NonInvalid*/ boolean result;
			while (true) {
				if (!ITERATOR__1.hasNext()) {
					result = ValueUtil.TRUE_VALUE;
					break;
				}
				@SuppressWarnings("null")
				/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment _1 = (RelationDomainAssignment)ITERATOR__1.next();
				/**
				 * variable
				 */
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Variable variable = _1.getVariable();
				//
				if (accumulator.includes(variable) == ValueUtil.TRUE_VALUE) {
					result = ValueUtil.FALSE_VALUE;			// Abort after second find
					break;
				}
				else {
					accumulator.add(variable);
				}
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_RelationDomain_c_c_RelationDomainAssignmentsAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTrelationTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaultAssignment()).basicAdd(otherEnd, msgs);
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPattern()).basicAdd(otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return ((InternalEList<?>)getDefaultAssignment()).basicRemove(otherEnd, msgs);
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return ((InternalEList<?>)getPattern()).basicRemove(otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return getDefaultAssignment();
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return getPattern();
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				return getRootVariable();
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				getDefaultAssignment().clear();
				getDefaultAssignment().addAll((Collection<? extends RelationDomainAssignment>)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				getPattern().clear();
				getPattern().addAll((Collection<? extends DomainPattern>)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				getRootVariable().clear();
				getRootVariable().addAll((Collection<? extends Variable>)newValue);
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				getDefaultAssignment().clear();
				return;
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				getPattern().clear();
				return;
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				getRootVariable().clear();
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
			case QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT:
				return defaultAssignment != null && !defaultAssignment.isEmpty();
			case QVTrelationPackage.RELATION_DOMAIN__PATTERN:
				return pattern != null && !pattern.isEmpty();
			case QVTrelationPackage.RELATION_DOMAIN__ROOT_VARIABLE:
				return rootVariable != null && !rootVariable.isEmpty();
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
			case QVTrelationPackage.RELATION_DOMAIN___VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateRelationDomainAssignmentsAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTrelationVisitor<?>)visitor).visitRelationDomain(this);
	}
} //RelationDomainImpl
