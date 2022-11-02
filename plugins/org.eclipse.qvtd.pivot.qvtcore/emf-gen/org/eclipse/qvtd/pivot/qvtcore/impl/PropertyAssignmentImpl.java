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

import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
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
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_PARTIAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ boolean isPartial = this.isIsPartial();
				/*@Caught*/ @NonNull Object IF_isPartial;
				if (isPartial) {
					/*@Caught*/ @NonNull Object CAUGHT_elementType;
					try {
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTcoreTables.CLSSid_CollectionType, null);
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty_0 = this.getReferredTargetProperty();
						final /*@NonInvalid*/ @Nullable Type type = getReferredTargetProperty_0.getType();
						final /*@Thrown*/ @Nullable CollectionType oclAsType = (@Nullable CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType);
						if (oclAsType == null) {
							throw new InvalidValueException("Null source for \'CollectionType::elementType\'");
						}
						final /*@Thrown*/ @NonNull Type elementType = CollectionElementTypeProperty.INSTANCE.evaluate(executor, QVTcoreTables.CLSSid_Type, oclAsType);
						CAUGHT_elementType = elementType;
					}
					catch (Exception THROWN_CAUGHT_elementType) {
						CAUGHT_elementType = ValueUtil.createInvalidValue(THROWN_CAUGHT_elementType);
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
					final /*@NonInvalid*/ @Nullable Type type_0 = value_0.getType();
					/*@Caught*/ @Nullable Object CAUGHT_or;
					try {
						final /*@NonInvalid*/ boolean IsEQ2_ = type_0 == null;
						/*@Caught*/ @Nullable Object IF_IsEQ2_;
						if (IsEQ2_) {
							IF_IsEQ2_ = null;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
							try {
								if (type_0 == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								if (CAUGHT_elementType instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_elementType;
								}
								final /*@Thrown*/ @NonNull Type THROWN_elementType = (@NonNull Type)CAUGHT_elementType;
								final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, THROWN_elementType).booleanValue();
								CAUGHT_conformsTo = conformsTo;
							}
							catch (Exception THROWN_CAUGHT_conformsTo) {
								CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
							}
							IF_IsEQ2_ = CAUGHT_conformsTo;
						}
						final /*@Thrown*/ @Nullable Boolean or;
						if (IF_IsEQ2_ == ValueUtil.TRUE_VALUE) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_conformsTo_0;
							try {
								if (CAUGHT_elementType instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_elementType;
								}
								final /*@Thrown*/ @NonNull Type THROWN_elementType_0 = (@NonNull Type)CAUGHT_elementType;
								final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, THROWN_elementType_0, type_0).booleanValue();
								CAUGHT_conformsTo_0 = conformsTo_0;
							}
							catch (Exception THROWN_CAUGHT_conformsTo_0) {
								CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo_0);
							}
							if (CAUGHT_conformsTo_0 == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								if (IF_IsEQ2_ instanceof InvalidValueException) {
									throw (InvalidValueException)IF_IsEQ2_;
								}
								if (CAUGHT_conformsTo_0 instanceof InvalidValueException) {
									throw (InvalidValueException)CAUGHT_conformsTo_0;
								}
								if (IF_IsEQ2_ == null) {
									or = null;
								}
								else {
									or = ValueUtil.FALSE_VALUE;
								}
							}
						}
						CAUGHT_or = or;
					}
					catch (Exception THROWN_CAUGHT_or) {
						CAUGHT_or = ValueUtil.createInvalidValue(THROWN_CAUGHT_or);
					}
					/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
					try {
						if (CAUGHT_or instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_or;
						}
						final /*@Thrown*/ @Nullable Boolean THROWN_or = (Boolean)CAUGHT_or;
						final /*@Thrown*/ boolean IsEQ_ = THROWN_or == Boolean.TRUE;
						CAUGHT_IsEQ_ = IsEQ_;
					}
					catch (Exception THROWN_CAUGHT_IsEQ_) {
						CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
					}
					/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
					if (CAUGHT_IsEQ_ == Boolean.TRUE) {
						IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_sum;
						try {
							final /*@NonInvalid*/ boolean IsEQ2__0 = type_0 == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								assert type_0 != null;
								final /*@Thrown*/ @Nullable String name = type_0.getName();
								IF_IsEQ2__0 = name;
							}
							final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForPartialValue_c_32, IF_IsEQ2__0);
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_2, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							if (CAUGHT_elementType instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_elementType;
							}
							final /*@Thrown*/ @NonNull Type THROWN_elementType_1 = (@NonNull Type)CAUGHT_elementType;
							final /*@Thrown*/ @Nullable String name_0 = THROWN_elementType_1.getName();
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, name_0);
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTcoreTables.STR__32_or_32_vice_m_versa);
							CAUGHT_sum = sum;
						}
						catch (Exception THROWN_CAUGHT_sum) {
							CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
						}
						final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, CAUGHT_sum, CAUGHT_or);
						IF_CAUGHT_IsEQ_ = TUP_;
					}
					IF_isPartial = IF_CAUGHT_IsEQ_;
				}
				else {
					IF_isPartial = ValueUtil.TRUE_VALUE;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_isPartial, QVTcoreTables.INT_0).booleanValue();
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
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_TOTAL_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
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
				/*@Caught*/ @NonNull Object IF_not;
				if (not) {
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty_0 = this.getReferredTargetProperty();
					final /*@NonInvalid*/ @Nullable Type type = getReferredTargetProperty_0.getType();
					@SuppressWarnings("null")
					final /*@NonInvalid*/ @NonNull OCLExpression value_0 = this.getValue();
					final /*@NonInvalid*/ @Nullable Type type_0 = value_0.getType();
					/*@Caught*/ @Nullable Object CAUGHT_or;
					try {
						final /*@NonInvalid*/ boolean IsEQ2_ = type_0 == null;
						/*@Caught*/ @Nullable Object IF_IsEQ2_;
						if (IsEQ2_) {
							IF_IsEQ2_ = null;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
							try {
								if (type_0 == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type_0, type).booleanValue();
								CAUGHT_conformsTo = conformsTo;
							}
							catch (Exception THROWN_CAUGHT_conformsTo) {
								CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
							}
							IF_IsEQ2_ = CAUGHT_conformsTo;
						}
						final /*@Thrown*/ @Nullable Boolean or;
						if (IF_IsEQ2_ == ValueUtil.TRUE_VALUE) {
							or = ValueUtil.TRUE_VALUE;
						}
						else {
							final /*@NonInvalid*/ boolean IsEQ2__0 = type == null;
							/*@Caught*/ @Nullable Object IF_IsEQ2__0;
							if (IsEQ2__0) {
								IF_IsEQ2__0 = null;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_conformsTo_0;
								try {
									if (type == null) {
										throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
									}
									final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
									CAUGHT_conformsTo_0 = conformsTo_0;
								}
								catch (Exception THROWN_CAUGHT_conformsTo_0) {
									CAUGHT_conformsTo_0 = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo_0);
								}
								IF_IsEQ2__0 = CAUGHT_conformsTo_0;
							}
							if (IF_IsEQ2__0 == ValueUtil.TRUE_VALUE) {
								or = ValueUtil.TRUE_VALUE;
							}
							else {
								if (IF_IsEQ2_ instanceof InvalidValueException) {
									throw (InvalidValueException)IF_IsEQ2_;
								}
								if (IF_IsEQ2__0 instanceof InvalidValueException) {
									throw (InvalidValueException)IF_IsEQ2__0;
								}
								if ((IF_IsEQ2_ == null) || (IF_IsEQ2__0 == null)) {
									or = null;
								}
								else {
									or = ValueUtil.FALSE_VALUE;
								}
							}
						}
						CAUGHT_or = or;
					}
					catch (Exception THROWN_CAUGHT_or) {
						CAUGHT_or = ValueUtil.createInvalidValue(THROWN_CAUGHT_or);
					}
					/*@Caught*/ @NonNull Object CAUGHT_IsEQ_;
					try {
						if (CAUGHT_or instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_or;
						}
						final /*@Thrown*/ @Nullable Boolean THROWN_or = (Boolean)CAUGHT_or;
						final /*@Thrown*/ boolean IsEQ_ = THROWN_or == Boolean.TRUE;
						CAUGHT_IsEQ_ = IsEQ_;
					}
					catch (Exception THROWN_CAUGHT_IsEQ_) {
						CAUGHT_IsEQ_ = ValueUtil.createInvalidValue(THROWN_CAUGHT_IsEQ_);
					}
					/*@Caught*/ @NonNull Object IF_CAUGHT_IsEQ_;
					if (CAUGHT_IsEQ_ == Boolean.TRUE) {
						IF_CAUGHT_IsEQ_ = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_sum;
						try {
							final /*@NonInvalid*/ boolean IsEQ2__1 = type_0 == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__1;
							if (IsEQ2__1) {
								IF_IsEQ2__1 = null;
							}
							else {
								assert type_0 != null;
								final /*@Thrown*/ @Nullable String name = type_0.getName();
								IF_IsEQ2__1 = name;
							}
							final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(QVTcoreTables.STR_PropertyAssignment_c_c_CompatibleTypeForTotalValue_c_32, IF_IsEQ2__1);
							final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_2, QVTcoreTables.STR__32_must_32_conform_32_to_32);
							final /*@NonInvalid*/ boolean IsEQ2__2 = type == null;
							/*@Thrown*/ @Nullable String IF_IsEQ2__2;
							if (IsEQ2__2) {
								IF_IsEQ2__2 = null;
							}
							else {
								assert type != null;
								final /*@Thrown*/ @Nullable String name_0 = type.getName();
								IF_IsEQ2__2 = name_0;
							}
							final /*@Thrown*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum_1, IF_IsEQ2__2);
							final /*@Thrown*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(sum_0, QVTcoreTables.STR__32_or_32_vice_m_versa);
							CAUGHT_sum = sum;
						}
						catch (Exception THROWN_CAUGHT_sum) {
							CAUGHT_sum = ValueUtil.createInvalidValue(THROWN_CAUGHT_sum);
						}
						final /*@Caught*/ @NonNull Object TUP_ = ValueUtil.createTupleOfEach(QVTcoreTables.TUPLid_, CAUGHT_sum, CAUGHT_or);
						IF_CAUGHT_IsEQ_ = TUP_;
					}
					IF_not = IF_CAUGHT_IsEQ_;
				}
				else {
					IF_not = ValueUtil.TRUE_VALUE;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_not, QVTcoreTables.INT_0).booleanValue();
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
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull Property targetProperty = this.getTargetProperty();
				final /*@NonInvalid*/ boolean isImplicit = targetProperty.isIsImplicit();
				final /*@NonInvalid*/ @Nullable Boolean not;
				if (!isImplicit) {
					not = ValueUtil.TRUE_VALUE;
				}
				else {
					if (isImplicit) {
						not = ValueUtil.FALSE_VALUE;
					}
					else {
						not = null;
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, not, QVTcoreTables.INT_0).booleanValue();
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
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTcorePackage.Literals.PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPERTY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTcoreTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull OCLExpression slotExpression = this.getSlotExpression();
				final /*@NonInvalid*/ @Nullable Type type = slotExpression.getType();
				final /*@NonInvalid*/ boolean IsEQ2_ = type == null;
				/*@Caught*/ @Nullable Object IF_IsEQ2_;
				if (IsEQ2_) {
					IF_IsEQ2_ = null;
				}
				else {
					/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
					try {
						if (type == null) {
							throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
						}
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull Property getReferredTargetProperty_0 = this.getReferredTargetProperty();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.@Nullable Class owningClass = getReferredTargetProperty_0.getOwningClass();
						final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, owningClass).booleanValue();
						CAUGHT_conformsTo = conformsTo;
					}
					catch (Exception THROWN_CAUGHT_conformsTo) {
						CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
					}
					IF_IsEQ2_ = CAUGHT_conformsTo;
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, IF_IsEQ2_, QVTcoreTables.INT_0).booleanValue();
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
