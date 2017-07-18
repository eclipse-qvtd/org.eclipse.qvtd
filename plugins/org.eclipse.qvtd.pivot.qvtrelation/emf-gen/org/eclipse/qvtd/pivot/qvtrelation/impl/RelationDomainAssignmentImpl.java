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
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationTables;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Domain Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl#getValueExp <em>Value Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationDomainAssignmentImpl extends ElementImpl implements RelationDomainAssignment {
	/**
	 * The cached value of the '{@link #getValueExp() <em>Value Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExp()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression valueExp;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationDomainAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationDomain getOwner() {
		if (eContainerFeatureID() != QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER) return null;
		return (RelationDomain)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(RelationDomain newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(RelationDomain newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT, RelationDomain.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getValueExp() {
		return valueExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExp(OCLExpression newValueExp, NotificationChain msgs) {
		OCLExpression oldValueExp = valueExp;
		valueExp = newValueExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP, oldValueExp, newValueExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueExp(OCLExpression newValueExp) {
		if (newValueExp != valueExp) {
			NotificationChain msgs = null;
			if (valueExp != null)
				msgs = ((InternalEObject)valueExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP, null, msgs);
			if (newValueExp != null)
				msgs = ((InternalEObject)newValueExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP, null, msgs);
			msgs = basicSetValueExp(newValueExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP, newValueExp, newValueExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForValue:
		 *   let
		 *     severity : Integer[1] = 'RelationDomainAssignment::CompatibleTypeForValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = valueExp.type.conformsTo(variable.type)
		 *       in
		 *         'RelationDomainAssignment::CompatibleTypeForValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTrelationTables.STR_RelationDomainAssignment_c_c_CompatibleTypeForValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTrelationTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull OCLExpression valueExp = this.getValueExp();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type = valueExp.getType();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Variable variable = this.getVariable();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = variable.getType();
				final /*@Thrown*/ boolean result = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTrelationTables.STR_RelationDomainAssignment_c_c_CompatibleTypeForValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTrelationTables.INT_0).booleanValue();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((RelationDomain)otherEnd, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				return basicSetOwner(null, msgs);
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				return basicSetValueExp(null, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				return eInternalContainer().eInverseRemove(this, QVTrelationPackage.RELATION_DOMAIN__DEFAULT_ASSIGNMENT, RelationDomain.class, msgs);
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				return getOwner();
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				return getValueExp();
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				setOwner((RelationDomain)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				setValueExp((OCLExpression)newValue);
				return;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE:
				setVariable((Variable)newValue);
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				setOwner((RelationDomain)null);
				return;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				setValueExp((OCLExpression)null);
				return;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE:
				setVariable((Variable)null);
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__OWNER:
				return getOwner() != null;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				return valueExp != null;
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT__VARIABLE:
				return variable != null;
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
			case QVTrelationPackage.RELATION_DOMAIN_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTrelationVisitor<?>)visitor).visitRelationDomainAssignment(this);
	}
} //RelationDomainAssignmentImpl
