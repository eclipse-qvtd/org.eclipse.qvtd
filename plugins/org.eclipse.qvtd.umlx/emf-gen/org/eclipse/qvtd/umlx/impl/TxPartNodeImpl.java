/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Part Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl#getOwningTxKeyNode <em>Owning Tx Key Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl#isIsOpposite <em>Is Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxPartNodeImpl extends TxNodeImpl implements TxPartNode {
	/**
	 * The default value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean isOpposite = IS_OPPOSITE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredEStructuralFeature() <em>Referred EStructural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEStructuralFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature referredEStructuralFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxPartNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_PART_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxKeyNode getOwningTxKeyNode() {
		if (eContainerFeatureID() != UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE) return null;
		return (TxKeyNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxKeyNode(TxKeyNode newOwningTxKeyNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxKeyNode, UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxKeyNode(TxKeyNode newOwningTxKeyNode) {
		if (newOwningTxKeyNode != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE && newOwningTxKeyNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxKeyNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxKeyNode != null)
				msgs = ((InternalEObject)newOwningTxKeyNode).eInverseAdd(this, UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES, TxKeyNode.class, msgs);
			msgs = basicSetOwningTxKeyNode(newOwningTxKeyNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE, newOwningTxKeyNode, newOwningTxKeyNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOpposite() {
		return isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOpposite(boolean newIsOpposite) {
		boolean oldIsOpposite = isOpposite;
		isOpposite = newIsOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PART_NODE__IS_OPPOSITE, oldIsOpposite, isOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EStructuralFeature getReferredEStructuralFeature() {
		if (referredEStructuralFeature != null && referredEStructuralFeature.eIsProxy()) {
			InternalEObject oldReferredEStructuralFeature = (InternalEObject)referredEStructuralFeature;
			referredEStructuralFeature = (EStructuralFeature)eResolveProxy(oldReferredEStructuralFeature);
			if (referredEStructuralFeature != oldReferredEStructuralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE, oldReferredEStructuralFeature, referredEStructuralFeature));
			}
		}
		return referredEStructuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetReferredEStructuralFeature() {
		return referredEStructuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEStructuralFeature(EStructuralFeature newReferredEStructuralFeature) {
		EStructuralFeature oldReferredEStructuralFeature = referredEStructuralFeature;
		referredEStructuralFeature = newReferredEStructuralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE, oldReferredEStructuralFeature, referredEStructuralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean PartIsPropertyOfKey(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv PartIsPropertyOfKey:
		 *   let severity : Integer[1] = 'TxPartNode::PartIsPropertyOfKey'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = owningTxKeyNode.referredEClass.oclAsType(ecore::EClass)
		 *         ->closure(eSuperTypes)
		 *         ->includes(referredEStructuralFeature.eContainingClass)
		 *       in
		 *         'TxPartNode::PartIsPropertyOfKey'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxPartNode_c_c_PartIsPropertyOfKey);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_1;
		if (le) {
			symbol_1 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_ecore_c_c_EClass_0 = idResolver.getClass(UMLXTables.CLSSid_EClass, null);
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull TxKeyNode owningTxKeyNode = this.getOwningTxKeyNode();
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EClass referredEClass = owningTxKeyNode.getReferredEClass();
				final /*@Thrown*/ org.eclipse.emf.ecore.@NonNull EClass oclAsType = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, referredEClass, TYP_ecore_c_c_EClass_0));
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, UMLXTables.SET_CLSSid_EClass, oclAsType);
				final org.eclipse.ocl.pivot.@NonNull Class TYPE_closure_0 = executor.getStaticTypeOf(oclAsSet);
				final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_closure_0 = (LibraryIteration.LibraryIterationExtension)TYPE_closure_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
				final @NonNull Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(executor, UMLXTables.SET_CLSSid_EClass, UMLXTables.ORD_CLSSid_EClass);
				/**
				 * Implementation of the iterator body.
				 */
				final @NonNull AbstractBinaryOperation BODY_closure_0 = new AbstractBinaryOperation() {
					/**
					 * eSuperTypes
					 */
					@Override
					public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@Nullable Object _1) {
						final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClass symbol_0 = (EClass)_1;
						if (symbol_0 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/emf/2002/Ecore\'::EClass::eSuperTypes\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.util.@NonNull List<EClass> eSuperTypes = symbol_0.getESuperTypes();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_eSuperTypes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClass, eSuperTypes);
						return BOXED_eSuperTypes;
					}
				};
				final @NonNull  ExecutorSingleIterationManager MGR_closure_0 = new ExecutorSingleIterationManager(executor, UMLXTables.SET_CLSSid_EClass, BODY_closure_0, oclAsSet, ACC_closure_0);
				final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SetValue closure = ClassUtil.nonNullState((SetValue)IMPL_closure_0.evaluateIteration(MGR_closure_0));
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EStructuralFeature referredEStructuralFeature = this.getReferredEStructuralFeature();
				final /*@NonInvalid*/ org.eclipse.emf.ecore.@Nullable EClass eContainingClass = referredEStructuralFeature.getEContainingClass();
				final /*@Thrown*/ boolean result = CollectionIncludesOperation.INSTANCE.evaluate(closure, eContainingClass).booleanValue();
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxPartNode_c_c_PartIsPropertyOfKey, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
			symbol_1 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxKeyNode((TxKeyNode)otherEnd, msgs);
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				return basicSetOwningTxKeyNode(null, msgs);
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_KEY_NODE__OWNED_TX_PART_NODES, TxKeyNode.class, msgs);
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				return getOwningTxKeyNode();
			case UMLXPackage.TX_PART_NODE__IS_OPPOSITE:
				return isIsOpposite();
			case UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE:
				if (resolve) return getReferredEStructuralFeature();
				return basicGetReferredEStructuralFeature();
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				setOwningTxKeyNode((TxKeyNode)newValue);
				return;
			case UMLXPackage.TX_PART_NODE__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
				return;
			case UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE:
				setReferredEStructuralFeature((EStructuralFeature)newValue);
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				setOwningTxKeyNode((TxKeyNode)null);
				return;
			case UMLXPackage.TX_PART_NODE__IS_OPPOSITE:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
				return;
			case UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE:
				setReferredEStructuralFeature((EStructuralFeature)null);
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
			case UMLXPackage.TX_PART_NODE__OWNING_TX_KEY_NODE:
				return getOwningTxKeyNode() != null;
			case UMLXPackage.TX_PART_NODE__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
			case UMLXPackage.TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE:
				return referredEStructuralFeature != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxPartNode(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} //TxPartNodeImpl
