/**
 * <copyright>
 *
 * Copyright (c) 2013, 2022 Willink Transformations and others.
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
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionElementTypeProperty;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;

import org.eclipse.qvtd.pivot.qvtcore.QVTcoreTables;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertyAssignmentImpl extends NavigationAssignmentImpl implements PropertyAssignment {
	/**
	 * The number of structural features of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_ASSIGNMENT_FEATURE_COUNT = NavigationAssignmentImpl.NAVIGATION_ASSIGNMENT_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_ASSIGNMENT_OPERATION_COUNT = NavigationAssignmentImpl.NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 5;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.PROPERTY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredTargetProperty() {
		/**
		 * targetProperty
		 */
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull Property targetProperty = this.getTargetProperty();
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForPartialValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyAssignment::CompatibleTypeForPartialValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForPartialValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = if isPartial
			 *         then
			 *           let
			 *             propertyType : Type[1] = getReferredTargetProperty()
			 *             .type.oclAsType(CollectionType).elementType
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               let
			 *                 status : Boolean[?] = valueType?.conformsTo(propertyType) or
			 *                 propertyType.conformsTo(valueType)
			 *               in
			 *                 if status = true
			 *                 then true
			 *                 else
			 *                   Tuple{status = status, message = 'PropertyAssignment::CompatibleTypeForPartialValue: ' + valueType?.name + ' must conform to ' + propertyType.name + ' or vice-versa'
			 *                   }
			 *                 endif
			 *         else true
			 *         endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
					/*@Thrown*/ @NonNull Object result;
					if (isPartial) {
						/*@Caught*/ @NonNull Object CAUGHT_propertyType;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType_0 = idResolver.getClass(QVTcoreTables.CLSSid_CollectionType, null);
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
							final /*@NonInvalid*/ @Nullable Type type = getReferredTargetProperty.getType();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull CollectionType oclAsType = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType_0);
							final /*@Thrown*/ @NonNull Type propertyType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTcoreTables.CLSSid_Type, oclAsType);
							CAUGHT_propertyType = propertyType;
						}
						catch (Exception e) {
							CAUGHT_propertyType = ValueUtil.createInvalidValue(e);
						}
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ @Nullable Type valueType = value.getType();
						/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
						try {
							final /*@NonInvalid*/ @NonNull Object conformsTo = valueType == null;
							/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
							if (conformsTo == Boolean.TRUE) {
								safe_conformsTo_source = null;
							}
							else {
								if (valueType == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								if (CAUGHT_propertyType instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_propertyType;
								}
								final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, CAUGHT_propertyType).booleanValue();
								safe_conformsTo_source = conformsTo_0;
							}
							CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
						}
						catch (Exception e) {
							CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean status;
						if (CAUGHT_safe_conformsTo_source == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_conformsTo_1;
							try {
								if (CAUGHT_propertyType instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_propertyType;
								}
								final /*@Thrown*/ boolean conformsTo_1 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, CAUGHT_propertyType, valueType).booleanValue();
								CAUGHT_conformsTo_1 = conformsTo_1;
							}
							catch (Exception e) {
								CAUGHT_conformsTo_1 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_conformsTo_1 == ValueUtil.TRUE_VALUE) {
								status = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_safe_conformsTo_source instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_safe_conformsTo_source;
								}
								if (CAUGHT_conformsTo_1 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_conformsTo_1;
								}
								if (CAUGHT_safe_conformsTo_source == null) {
									status = null;
								}
								else {
									status = ValueUtil.FALSE_VALUE;
								}
							}
						}
						final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
						/*@Thrown*/ @NonNull Object IF_eq;
						if (eq) {
							IF_eq = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ @NonNull Object name = valueType == null;
							/*@Thrown*/ @Nullable String safe_name_source;
							if (name == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert valueType != null;
								final /*@Thrown*/ @Nullable String name_0 = valueType.getName();
								safe_name_source = name_0;
							}
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32, safe_name_source);
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							if (CAUGHT_propertyType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_propertyType;
							}
							final /*@Thrown*/ @Nullable String name_1 = ((Nameable)CAUGHT_propertyType).getName();
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_1);
							final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
							final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
							IF_eq = TUP_;
						}
						result = IF_eq;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
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
	public boolean validateCompatibleTypeForTotalValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyAssignment::CompatibleTypeForTotalValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForTotalValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : OclAny[1] = if not isPartial
			 *         then
			 *           let propertyType : Type[?] = getReferredTargetProperty().type
			 *           in
			 *             let valueType : Type[?] = value.type
			 *             in
			 *               let
			 *                 status : Boolean[?] = valueType?.conformsTo(propertyType) or
			 *                 propertyType?.conformsTo(valueType)
			 *               in
			 *                 if status = true
			 *                 then true
			 *                 else
			 *                   Tuple{status = status, message = 'PropertyAssignment::CompatibleTypeForTotalValue: ' + valueType?.name + ' must conform to ' + propertyType?.name + ' or vice-versa'
			 *                   }
			 *                 endif
			 *         else true
			 *         endif
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @NonNull Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
					final /*@NonInvalid*/ @Nullable Boolean not;
					if (!isPartial) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (isPartial) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					if (not == null) {
						throw new InvalidValueException("Null if condition");
					}
					/*@Thrown*/ @NonNull Object result;
					if (not) {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
						final /*@NonInvalid*/ @Nullable Type propertyType = getReferredTargetProperty.getType();
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull OCLExpression value = this.getValue();
						final /*@NonInvalid*/ @Nullable Type valueType = value.getType();
						/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
						try {
							final /*@NonInvalid*/ @NonNull Object conformsTo = valueType == null;
							/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
							if (conformsTo == Boolean.TRUE) {
								safe_conformsTo_source = null;
							}
							else {
								if (valueType == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, valueType, propertyType).booleanValue();
								safe_conformsTo_source = conformsTo_0;
							}
							CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
						}
						catch (Exception e) {
							CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
						}
						final /*@Thrown*/ @Nullable Boolean status;
						if (CAUGHT_safe_conformsTo_source == ValueUtil.TRUE_VALUE) {
							status = ValueUtil.TRUE_VALUE;
						}
						else {
							/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source_0;
							try {
								final /*@NonInvalid*/ @NonNull Object conformsTo_1 = propertyType == null;
								/*@Thrown*/ @Nullable Boolean safe_conformsTo_source_0;
								if (conformsTo_1 == Boolean.TRUE) {
									safe_conformsTo_source_0 = null;
								}
								else {
									if (propertyType == null) {
										throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
									}
									final /*@Thrown*/ boolean conformsTo_2 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, propertyType, valueType).booleanValue();
									safe_conformsTo_source_0 = conformsTo_2;
								}
								CAUGHT_safe_conformsTo_source_0 = safe_conformsTo_source_0;
							}
							catch (Exception e) {
								CAUGHT_safe_conformsTo_source_0 = ValueUtil.createInvalidValue(e);
							}
							if (CAUGHT_safe_conformsTo_source_0 == ValueUtil.TRUE_VALUE) {
								status = ValueUtil.TRUE_VALUE;
							}
							else {
								if (CAUGHT_safe_conformsTo_source instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_safe_conformsTo_source;
								}
								if (CAUGHT_safe_conformsTo_source_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_safe_conformsTo_source_0;
								}
								if ((CAUGHT_safe_conformsTo_source == null) || (CAUGHT_safe_conformsTo_source_0 == null)) {
									status = null;
								}
								else {
									status = ValueUtil.FALSE_VALUE;
								}
							}
						}
						final /*@Thrown*/ boolean eq = status == Boolean.TRUE;
						/*@Thrown*/ @NonNull Object IF_eq;
						if (eq) {
							IF_eq = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ @NonNull Object name = valueType == null;
							/*@Thrown*/ @Nullable String safe_name_source;
							if (name == Boolean.TRUE) {
								safe_name_source = null;
							}
							else {
								assert valueType != null;
								final /*@Thrown*/ @Nullable String name_0 = valueType.getName();
								safe_name_source = name_0;
							}
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32, safe_name_source);
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							final /*@NonInvalid*/ @NonNull Object name_1 = propertyType == null;
							/*@Thrown*/ @Nullable String safe_name_source_0;
							if (name_1 == Boolean.TRUE) {
								safe_name_source_0 = null;
							}
							else {
								assert propertyType != null;
								final /*@Thrown*/ @Nullable String name_2 = propertyType.getName();
								safe_name_source_0 = name_2;
							}
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, safe_name_source_0);
							final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTcoreTables.STR__32_or_32_vice_m_versa);
							final /*@Thrown*/ @NonNull TupleValue TUP_ = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, sum_2, status);
							IF_eq = TUP_;
						}
						result = IF_eq;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTcoreTables.INT_0).booleanValue();
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
	public boolean validatePropertyIsNotImplicit(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyAssignment::PropertyIsNotImplicit";
		try {
			/**
			 *
			 * inv PropertyIsNotImplicit:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not targetProperty.isImplicit
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Property targetProperty = this.getTargetProperty();
				final /*@NonInvalid*/ boolean isImplicit = targetProperty.isIsImplicit();
				final /*@NonInvalid*/ @Nullable Boolean result;
				if (!isImplicit) {
					result = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isImplicit) {
						result = ValueUtil.FALSE_VALUE;
					}
					else {
						result = null;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTcoreTables.INT_0).booleanValue();
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
	public boolean validateTargetPropertyIsSlotProperty(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "PropertyAssignment::TargetPropertyIsSlotProperty";
		try {
			/**
			 *
			 * inv TargetPropertyIsSlotProperty:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = slotExpression.type?.conformsTo(
			 *           getReferredTargetProperty().owningClass)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPERTY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_safe_conformsTo_source;
				try {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression slotExpression = this.getSlotExpression();
					final /*@NonInvalid*/ @Nullable Type type = slotExpression.getType();
					final /*@NonInvalid*/ @NonNull Object conformsTo = type == null;
					/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
					if (conformsTo == Boolean.TRUE) {
						safe_conformsTo_source = null;
					}
					else {
						if (type == null) {
							throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
						}
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty = this.getReferredTargetProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = getReferredTargetProperty.getOwningClass();
						final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
						safe_conformsTo_source = conformsTo_0;
					}
					CAUGHT_safe_conformsTo_source = safe_conformsTo_source;
				}
				catch (Exception e) {
					CAUGHT_safe_conformsTo_source = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_safe_conformsTo_source, QVTcoreTables.INT_0).booleanValue();
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ElementImpl.ELEMENT_OPERATION_COUNT + 0:
				return getReferredTargetProperty();
			case ElementImpl.ELEMENT_OPERATION_COUNT + 1:
				return validateCompatibleTypeForPartialValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 2:
				return validateCompatibleTypeForTotalValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 3:
				return validatePropertyIsNotImplicit((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case ElementImpl.ELEMENT_OPERATION_COUNT + 4:
				return validateTargetPropertyIsSlotProperty((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
			return (R) ((QVTcoreVisitor<?>)visitor).visitPropertyAssignment(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public boolean isIsRequired() {
		return targetProperty != null && targetProperty.isIsRequired();
	}
} //PropertyAssignmentImpl
