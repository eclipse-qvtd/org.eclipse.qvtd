/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionUnionOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#isIsStrict <em>Is Strict</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getOwnedMappingParameters <em>Owned Mapping Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl#getOwnedStatements <em>Owned Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingImpl extends RuleImpl implements Mapping {
	/**
	 * The default value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrict = IS_STRICT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedMappingParameters() <em>Owned Mapping Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingParameter> ownedMappingParameters;

	/**
	 * The cached value of the '{@link #getOwnedStatements() <em>Owned Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> ownedStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsStrict() {
		return isStrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsStrict(boolean newIsStrict) {
		boolean oldIsStrict = isStrict;
		isStrict = newIsStrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING__IS_STRICT, oldIsStrict, isStrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingParameter> getOwnedMappingParameters() {
		if (ownedMappingParameters == null) {
			ownedMappingParameters = new EObjectContainmentWithInverseEList<MappingParameter>(MappingParameter.class, this, QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS, QVTimperativePackage.MAPPING_PARAMETER__OWNING_MAPPING);
		}
		return ownedMappingParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Statement> getOwnedStatements() {
		if (ownedStatements == null) {
			ownedStatements = new EObjectContainmentEList<Statement>(Statement.class, this, QVTimperativePackage.MAPPING__OWNED_STATEMENTS);
		}
		return ownedStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsNotNull(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NameIsNotNull:
		 *   let severity : Integer[1] = 'Mapping::NameIsNotNull'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = name <> null
		 *       in
		 *         'Mapping::NameIsNotNull'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_Mapping_c_c_NameIsNotNull);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ java.lang.@Nullable String name = this.getName();
			final /*@NonInvalid*/ boolean result = name != null;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_Mapping_c_c_NameIsNotNull, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateMappingParameterNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv MappingParameterNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'Mapping::MappingParameterNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = ownedMappingParameters->isUnique(name)
		 *       in
		 *         'Mapping::MappingParameterNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_Mapping_c_c_MappingParameterNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<MappingParameter> ownedMappingParameters = this.getOwnedMappingParameters();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_ownedMappingParameters = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_MappingParameter, ownedMappingParameters);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_MappingParameter);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedMappingParameters.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter _1 = (MappingParameter)ITERATOR__1.next();
					/**
					 * name
					 */
					final /*@NonInvalid*/ java.lang.@Nullable String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_Mapping_c_c_MappingParameterNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateLocalVariableNamesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv LocalVariableNamesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'Mapping::LocalVariableNamesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = ownedMappingParameters->union(
		 *           ownedStatements->selectByKind(VariableStatement))
		 *         ->isUnique(name)
		 *       in
		 *         'Mapping::LocalVariableNamesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_Mapping_c_c_LocalVariableNamesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtimperative_c_c_VariableStatement = idResolver.getClass(QVTimperativeTables.CLSSid_VariableStatement, null);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<MappingParameter> ownedMappingParameters = this.getOwnedMappingParameters();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue BOXED_ownedMappingParameters = idResolver.createSetOfAll(QVTimperativeTables.SET_CLSSid_MappingParameter, ownedMappingParameters);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<Statement> ownedStatements = this.getOwnedStatements();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedStatements = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_CLSSid_Statement, ownedStatements);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedStatements, TYP_qvtimperative_c_c_VariableStatement);
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull SetValue union = (SetValue)CollectionUnionOperation.INSTANCE.evaluate(BOXED_ownedMappingParameters, selectByKind);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(QVTimperativeTables.SET_CLSSid_VariableDeclaration);
				@NonNull Iterator<Object> ITERATOR__1 = union.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull VariableDeclaration _1 = (VariableDeclaration)ITERATOR__1.next();
					/**
					 * name
					 */
					final /*@NonInvalid*/ java.lang.@Nullable String name = _1.getName();
					//
					if (accumulator.includes(name) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(name);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_Mapping_c_c_LocalVariableNamesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
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
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingParameters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				return ((InternalEList<?>)getOwnedMappingParameters()).basicRemove(otherEnd, msgs);
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				return ((InternalEList<?>)getOwnedStatements()).basicRemove(otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING__IS_STRICT:
				return isIsStrict();
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				return getOwnedMappingParameters();
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				return getOwnedStatements();
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
			case QVTimperativePackage.MAPPING__IS_STRICT:
				setIsStrict((Boolean)newValue);
				return;
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				getOwnedMappingParameters().clear();
				getOwnedMappingParameters().addAll((Collection<? extends MappingParameter>)newValue);
				return;
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				getOwnedStatements().clear();
				getOwnedStatements().addAll((Collection<? extends Statement>)newValue);
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
			case QVTimperativePackage.MAPPING__IS_STRICT:
				setIsStrict(IS_STRICT_EDEFAULT);
				return;
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				getOwnedMappingParameters().clear();
				return;
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				getOwnedStatements().clear();
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
			case QVTimperativePackage.MAPPING__IS_STRICT:
				return isStrict != IS_STRICT_EDEFAULT;
			case QVTimperativePackage.MAPPING__OWNED_MAPPING_PARAMETERS:
				return ownedMappingParameters != null && !ownedMappingParameters.isEmpty();
			case QVTimperativePackage.MAPPING__OWNED_STATEMENTS:
				return ownedStatements != null && !ownedStatements.isEmpty();
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
			case QVTimperativePackage.MAPPING___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.MAPPING___VALIDATE_MAPPING_PARAMETER_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateMappingParameterNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.MAPPING___VALIDATE_LOCAL_VARIABLE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP:
				return validateLocalVariableNamesAreUnique((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMapping(this);
	}
} //MappingImpl
