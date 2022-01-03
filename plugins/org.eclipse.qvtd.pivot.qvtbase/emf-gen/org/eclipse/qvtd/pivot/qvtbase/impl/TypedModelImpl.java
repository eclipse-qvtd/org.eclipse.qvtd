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
package org.eclipse.qvtd.pivot.qvtbase.impl;

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
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ClassImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.library.numeric.NumericPlusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getUsedPackage <em>Used Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getOwnedContext <em>Owned Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#isIsPrimitive <em>Is Primitive</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#isIsThis <em>Is This</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#isIsTrace <em>Is Trace</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl#getIterates <em>Iterates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedModelImpl extends NamedElementImpl implements TypedModel {
	/**
	 * The number of structural features of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPED_MODEL_FEATURE_COUNT = NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPED_MODEL_OPERATION_COUNT = NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The cached value of the '{@link #getUsedPackage() <em>Used Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.pivot.Package> usedPackage;

	/**
	 * The cached value of the '{@link #getDependsOn() <em>Depends On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOn()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> dependsOn;

	/**
	 * The cached value of the '{@link #getOwnedContext() <em>Owned Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContext()
	 * @generated
	 * @ordered
	 */
	protected Parameter ownedContext;

	/**
	 * The default value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRIMITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPrimitive() <em>Is Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimitive()
	 * @generated
	 * @ordered
	 */
	protected boolean isPrimitive = IS_PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsThis() <em>Is This</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThis()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_THIS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsThis() <em>Is This</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsThis()
	 * @generated
	 * @ordered
	 */
	protected boolean isThis = IS_THIS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTrace() <em>Is Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTrace()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTrace() <em>Is Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTrace()
	 * @generated
	 * @ordered
	 */
	protected boolean isTrace = IS_TRACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIterates() <em>Iterates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterates()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> iterates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.TYPED_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getTransformation() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0)) return null;
		return (Transformation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0) && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, ClassImpl.CLASS_FEATURE_COUNT + 1, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<org.eclipse.ocl.pivot.Package> getUsedPackage() {
		if (usedPackage == null) {
			usedPackage = new EObjectResolvingEList<org.eclipse.ocl.pivot.Package>(org.eclipse.ocl.pivot.Package.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1);
		}
		return usedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")
	@Override
	public @NonNull EList<TypedModel> getDependsOn() {
		if (dependsOn == null) {
			dependsOn = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2);
		}
		return dependsOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getOwnedContext() {
		return ownedContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedContext(Parameter newOwnedContext, NotificationChain msgs) {
		Parameter oldOwnedContext = ownedContext;
		ownedContext = newOwnedContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, oldOwnedContext, newOwnedContext);
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
	public void setOwnedContext(Parameter newOwnedContext) {
		if (newOwnedContext != ownedContext) {
			NotificationChain msgs = null;
			if (ownedContext != null)
				msgs = ((InternalEObject)ownedContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3), null, msgs);
			if (newOwnedContext != null)
				msgs = ((InternalEObject)newOwnedContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3), null, msgs);
			msgs = basicSetOwnedContext(newOwnedContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3, newOwnedContext, newOwnedContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPrimitive() {
		return isPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPrimitive(boolean newIsPrimitive) {
		boolean oldIsPrimitive = isPrimitive;
		isPrimitive = newIsPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldIsPrimitive, isPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsThis() {
		return isThis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsThis(boolean newIsThis) {
		boolean oldIsThis = isThis;
		isThis = newIsThis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldIsThis, isThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTrace() {
		return isTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTrace(boolean newIsTrace) {
		boolean oldIsTrace = isTrace;
		isTrace = newIsTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6, oldIsTrace, isTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedModel> getIterates() {
		if (iterates == null) {
			iterates = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7);
		}
		return iterates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExclusivePrimitiveThisTrace(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "TypedModel::ExclusivePrimitiveThisTrace";
		try {
			/**
			 *
			 * inv ExclusivePrimitiveThisTrace:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[1] = if isPrimitive
			 *         then 1
			 *         else 0
			 *         endif +
			 *         if isThis
			 *         then 1
			 *         else 0
			 *         endif +
			 *         if isTrace
			 *         then 1
			 *         else 0
			 *         endif <= 1
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.TYPED_MODEL___VALIDATE_EXCLUSIVE_PRIMITIVE_THIS_TRACE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_3;
			if (le) {
				symbol_3 = true;
			}
			else {
				final /*@NonInvalid*/ boolean isPrimitive = this.isIsPrimitive();
				/*@NonInvalid*/ @NonNull IntegerValue symbol_0;
				if (isPrimitive) {
					symbol_0 = QVTbaseTables.INT_1;
				}
				else {
					symbol_0 = QVTbaseTables.INT_0;
				}
				final /*@NonInvalid*/ boolean isThis = this.isIsThis();
				/*@NonInvalid*/ @NonNull IntegerValue symbol_1;
				if (isThis) {
					symbol_1 = QVTbaseTables.INT_1;
				}
				else {
					symbol_1 = QVTbaseTables.INT_0;
				}
				final /*@NonInvalid*/ @NonNull IntegerValue sum = (@Nullable IntegerValue)NumericPlusOperation.INSTANCE.evaluate(symbol_0, symbol_1);
				final /*@NonInvalid*/ boolean isTrace = this.isIsTrace();
				/*@NonInvalid*/ @NonNull IntegerValue symbol_2;
				if (isTrace) {
					symbol_2 = QVTbaseTables.INT_1;
				}
				else {
					symbol_2 = QVTbaseTables.INT_0;
				}
				final /*@NonInvalid*/ @NonNull IntegerValue sum_0 = (@Nullable IntegerValue)NumericPlusOperation.INSTANCE.evaluate(sum, symbol_2);
				final /*@NonInvalid*/ boolean result = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, sum_0, QVTbaseTables.INT_1).booleanValue();
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, QVTbaseTables.INT_0).booleanValue();
				symbol_3 = logDiagnostic;
			}
			return symbol_3;
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return basicSetTransformation(null, msgs);
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return basicSetOwnedContext(null, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, ClassImpl.CLASS_FEATURE_COUNT + 1, Transformation.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getTransformation();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getUsedPackage();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return getDependsOn();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getOwnedContext();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isIsPrimitive();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return isIsThis();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return isIsTrace();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return getIterates();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setTransformation((Transformation)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getUsedPackage().clear();
				getUsedPackage().addAll((Collection<? extends org.eclipse.ocl.pivot.Package>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getDependsOn().clear();
				getDependsOn().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwnedContext((Parameter)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsPrimitive((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setIsThis((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				setIsTrace((Boolean)newValue);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				getIterates().clear();
				getIterates().addAll((Collection<? extends TypedModel>)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setTransformation((Transformation)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				getUsedPackage().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				getDependsOn().clear();
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				setOwnedContext((Parameter)null);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setIsPrimitive(IS_PRIMITIVE_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setIsThis(IS_THIS_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				setIsTrace(IS_TRACE_EDEFAULT);
				return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				getIterates().clear();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return getTransformation() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return usedPackage != null && !usedPackage.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return dependsOn != null && !dependsOn.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return ownedContext != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isPrimitive != IS_PRIMITIVE_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return isThis != IS_THIS_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 6:
				return isTrace != IS_TRACE_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7:
				return iterates != null && !iterates.isEmpty();
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
			case NamedElementImpl.NAMED_ELEMENT_OPERATION_COUNT + 0:
				return validateExclusivePrimitiveThisTrace((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitTypedModel(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //TypedModelImpl
