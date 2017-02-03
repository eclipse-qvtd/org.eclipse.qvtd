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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Typed Model Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getDependsOns <em>Depends Ons</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#isEnforce <em>Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxTypedModelNodeImpl extends TxNodeImpl implements TxTypedModelNode {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean check = CHECK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependsOns() <em>Depends Ons</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependsOns()
	 * @generated
	 * @ordered
	 */
	protected EList<TxTypedModelNode> dependsOns;

	/**
	 * The default value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean enforce = ENFORCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedTxPackageNodes() <em>Owned Tx Package Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxPackageNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxPackageNode> ownedTxPackageNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxTypedModelNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_TYPED_MODEL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCheck(boolean newCheck) {
		boolean oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxTypedModelNode> getDependsOns() {
		if (dependsOns == null) {
			dependsOns = new EObjectResolvingEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXPackage.TX_TYPED_MODEL_NODE__DEPENDS_ONS);
		}
		return dependsOns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnforce() {
		return enforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnforce(boolean newEnforce) {
		boolean oldEnforce = enforce;
		enforce = newEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxPackageNode> getOwnedTxPackageNodes() {
		if (ownedTxPackageNodes == null) {
			ownedTxPackageNodes = new EObjectContainmentWithInverseEList<TxPackageNode>(TxPackageNode.class, this, UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES, UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE);
		}
		return ownedTxPackageNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getOwningTxDiagram() {
		if (eContainerFeatureID() != UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM, newOwningTxDiagram, newOwningTxDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTxPackageNodePackagesAreUnique(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv TxPackageNodePackagesAreUnique:
		 *   let
		 *     severity : Integer[1] = 'TxTypedModelNode::TxPackageNodePackagesAreUnique'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[1] = ownedTxPackageNodes->isUnique(referredEPackage)
		 *       in
		 *         'TxTypedModelNode::TxPackageNodePackagesAreUnique'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxTypedModelNode_c_c_TxPackageNodePackagesAreUnique);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_result;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ java.util.@NonNull List<TxPackageNode> ownedTxPackageNodes = this.getOwnedTxPackageNodes();
				final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedTxPackageNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxPackageNode, ownedTxPackageNodes);
				/*@Thrown*/ SetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSetAccumulatorValue(UMLXTables.ORD_CLSSid_TxPackageNode);
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxPackageNodes.iterator();
				/*@Thrown*/ boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						result = ValueUtil.TRUE_VALUE;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull TxPackageNode _1 = (TxPackageNode)ITERATOR__1.next();
					/**
					 * referredEPackage
					 */
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EPackage referredEPackage = _1.getReferredEPackage();
					//
					if (accumulator.includes(referredEPackage) == ValueUtil.TRUE_VALUE) {
						result = ValueUtil.FALSE_VALUE;			// Abort after second find
						break;
					}
					else {
						accumulator.add(referredEPackage);
					}
				}
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxTypedModelNode_c_c_TxPackageNodePackagesAreUnique, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
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
	public boolean validateNameIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NameIsRequired:
		 *   let severity : Integer[1] = 'TxTypedModelNode::NameIsRequired'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[1] = name <> null
		 *       in
		 *         'TxTypedModelNode::NameIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_TxTypedModelNode_c_c_NameIsRequired);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			final /*@NonInvalid*/ java.lang.@Nullable String name = this.getName();
			final /*@NonInvalid*/ boolean result = name != null;
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_TxTypedModelNode_c_c_NameIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, result, UMLXTables.INT_0).booleanValue();
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxPackageNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxDiagram((TxDiagram)otherEnd, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				return ((InternalEList<?>)getOwnedTxPackageNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				return basicSetOwningTxDiagram(null, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, TxDiagram.class, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				return getName();
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				return isCheck();
			case UMLXPackage.TX_TYPED_MODEL_NODE__DEPENDS_ONS:
				return getDependsOns();
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				return isEnforce();
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				return getOwnedTxPackageNodes();
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram();
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				setName((String)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				setCheck((Boolean)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__DEPENDS_ONS:
				getDependsOns().clear();
				getDependsOns().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				setEnforce((Boolean)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				getOwnedTxPackageNodes().clear();
				getOwnedTxPackageNodes().addAll((Collection<? extends TxPackageNode>)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)newValue);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__DEPENDS_ONS:
				getDependsOns().clear();
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				getOwnedTxPackageNodes().clear();
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)null);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				return check != CHECK_EDEFAULT;
			case UMLXPackage.TX_TYPED_MODEL_NODE__DEPENDS_ONS:
				return dependsOns != null && !dependsOns.isEmpty();
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES:
				return ownedTxPackageNodes != null && !ownedTxPackageNodes.isEmpty();
			case UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram() != null;
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
		if (baseClass == UMLXNamedElement.class) {
			switch (derivedFeatureID) {
				case UMLXPackage.TX_TYPED_MODEL_NODE__NAME: return UMLXPackage.UMLX_NAMED_ELEMENT__NAME;
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
		if (baseClass == UMLXNamedElement.class) {
			switch (baseFeatureID) {
				case UMLXPackage.UMLX_NAMED_ELEMENT__NAME: return UMLXPackage.TX_TYPED_MODEL_NODE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxTypedModelNode(this);
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

} //TxTypedModelNodeImpl
