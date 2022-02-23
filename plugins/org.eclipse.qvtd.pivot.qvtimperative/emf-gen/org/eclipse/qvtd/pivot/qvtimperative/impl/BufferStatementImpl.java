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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
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
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl#getObservedProperties <em>Observed Properties</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl#getFirstPass <em>First Pass</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl#getLastPass <em>Last Pass</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferStatementImpl extends ConnectionVariableImpl implements BufferStatement {
	/**
	 * The number of structural features of the '<em>Buffer Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BUFFER_STATEMENT_FEATURE_COUNT = ConnectionVariableImpl.CONNECTION_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BUFFER_STATEMENT_OPERATION_COUNT = ConnectionVariableImpl.CONNECTION_VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The cached value of the '{@link #getObservedProperties() <em>Observed Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> observedProperties;

	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression ownedExpression;

	/**
	 * The default value of the '{@link #getFirstPass() <em>First Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstPass()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FIRST_PASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstPass() <em>First Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstPass()
	 * @generated
	 * @ordered
	 */
	protected Integer firstPass = FIRST_PASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastPass() <em>Last Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastPass()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LAST_PASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastPass() <em>Last Pass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastPass()
	 * @generated
	 * @ordered
	 */
	protected Integer lastPass = LAST_PASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.BUFFER_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getObservedProperties() {
		if (observedProperties == null) {
			observedProperties = new EObjectResolvingEList<Property>(Property.class, this, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1);
		}
		return observedProperties;
	}

	@Override
	public @Nullable EList<Property> basicGetObservedProperties() {
		return observedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getOwnedExpression() {
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(OCLExpression newOwnedExpression, NotificationChain msgs) {
		OCLExpression oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, oldOwnedExpression, newOwnedExpression);
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
	public void setOwnedExpression(OCLExpression newOwnedExpression) {
		if (newOwnedExpression != ownedExpression) {
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2), null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2), null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getFirstPass() {
		return firstPass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstPass(Integer newFirstPass) {
		Integer oldFirstPass = firstPass;
		firstPass = newFirstPass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3, oldFirstPass, firstPass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getLastPass() {
		return lastPass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastPass(Integer newLastPass) {
		Integer oldLastPass = lastPass;
		lastPass = newLastPass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4, oldLastPass, lastPass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "BufferStatement::CompatibleTypeForValue";
		try {
			/**
			 *
			 * inv CompatibleTypeForValue:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = ownedExpression <> null implies
			 *         ownedExpression.type.oclAsType(CollectionType)
			 *         .elementType.conformsTo(type)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativePackage.Literals.BUFFER_STATEMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean local_0;
			if (le) {
				local_0 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable OCLExpression ownedExpression = this.getOwnedExpression();
					final /*@NonInvalid*/ boolean ne = ownedExpression != null;
					final /*@Thrown*/ @Nullable Boolean result;
					if (!ne) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
						try {
							final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_CollectionType = idResolver.getClass(QVTimperativeTables.CLSSid_CollectionType, null);
							if (ownedExpression == null) {
								throw new InvalidValueException("Null source for \'TypedElement::type\'");
							}
							final /*@Thrown*/ @Nullable Type type = ownedExpression.getType();
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull CollectionType oclAsType = (@NonNull CollectionType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, type, TYP_CollectionType);
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull Type elementType = oclAsType.getElementType();
							final /*@NonInvalid*/ @Nullable Type type_0 = this.getType();
							final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, elementType, type_0).booleanValue();
							CAUGHT_conformsTo = conformsTo;
						}
						catch (Exception e) {
							CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_conformsTo == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_conformsTo instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_conformsTo;
							}
							result = ValueUtil.FALSE_VALUE;
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
				local_0 = logDiagnostic;
			}
			return local_0;
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
	public String joinNames(final EList<String> names) {
		/**
		 * '{' + names->iterate(n; s : String[1] = '' |
		 *   if (s = '')
		 *   then n
		 *   else s + ';' + n
		 *   endif) + '}'
		 */
		assert names != null;
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_names = idResolver.createOrderedSetOfAll(QVTimperativeTables.ORD_PRIMid_String, names);
		/*@NonInvalid*/ @NonNull String s = QVTimperativeTables.STR_;
		@NonNull Iterator<Object> ITERATOR_n = BOXED_names.iterator();
		/*@NonInvalid*/ @Nullable String iterate;
		while (true) {
			if (!ITERATOR_n.hasNext()) {
				iterate = s;
				break;
			}
			@SuppressWarnings("null")
			/*@NonInvalid*/ @NonNull String n = (@NonNull String)ITERATOR_n.next();
			/**
			 * if s = '' then n else s + ';' + n endif
			 */
			final /*@NonInvalid*/ boolean eq = s.equals(QVTimperativeTables.STR_);
			/*@NonInvalid*/ @NonNull String local_0;
			if (eq) {
				local_0 = n;
			}
			else {
				final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(s, QVTimperativeTables.STR__59);
				final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, n);
				local_0 = sum_0;
			}
			//
			s = local_0;
		}
		final /*@Thrown*/ @NonNull String sum_1 = StringConcatOperation.INSTANCE.evaluate(QVTimperativeTables.STR__123, iterate);
		final /*@Thrown*/ @NonNull String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, QVTimperativeTables.STR__125);
		return sum_2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				return basicSetOwnedExpression(null, msgs);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				return getObservedProperties();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				return getOwnedExpression();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
				return getFirstPass();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4:
				return getLastPass();
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				getObservedProperties().clear();
				getObservedProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				setOwnedExpression((OCLExpression)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
				setFirstPass((Integer)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4:
				setLastPass((Integer)newValue);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				getObservedProperties().clear();
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				setOwnedExpression((OCLExpression)null);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
				setFirstPass(FIRST_PASS_EDEFAULT);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4:
				setLastPass(LAST_PASS_EDEFAULT);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				return observedProperties != null && !observedProperties.isEmpty();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
				return ownedExpression != null;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 3:
				return FIRST_PASS_EDEFAULT == null ? firstPass != null : !FIRST_PASS_EDEFAULT.equals(firstPass);
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 4:
				return LAST_PASS_EDEFAULT == null ? lastPass != null : !LAST_PASS_EDEFAULT.equals(lastPass);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VariableStatement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObservableStatement.class) {
			switch (derivedFeatureID) {
				case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1: return NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == VariableStatement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ObservableStatement.class) {
			switch (baseFeatureID) {
				case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0: return VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Statement.class) {
			switch (baseOperationID) {
				case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0: return VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == VariableStatement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ObservableStatement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 1:
				return validateCompatibleTypeForValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case VariableDeclarationImpl.VARIABLE_DECLARATION_OPERATION_COUNT + 0:
				return joinNames((EList<String>)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTimperativeVisitor) {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitBufferStatement(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //BufferStatementImpl
