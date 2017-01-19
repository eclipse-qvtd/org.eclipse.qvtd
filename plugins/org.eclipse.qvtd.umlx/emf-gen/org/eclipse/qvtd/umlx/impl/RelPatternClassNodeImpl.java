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

import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#getReferredEClassifier <em>Referred EClassifier</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl#getRelDomainNode <em>Rel Domain Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelPatternClassNodeImpl extends RelPatternNodeImpl implements RelPatternClassNode {
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
	 * The default value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMany() <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMany()
	 * @generated
	 * @ordered
	 */
	protected boolean isMany = IS_MANY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NULL_FREE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsNullFree() <em>Is Null Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsNullFree()
	 * @generated
	 * @ordered
	 */
	protected boolean isNullFree = IS_NULL_FREE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REQUIRED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsRequired() <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean isRequired = IS_REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredEClassifier() <em>Referred EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEClassifier()
	 * @generated
	 * @ordered
	 */
	protected EClassifier referredEClassifier;

	/**
	 * The cached value of the '{@link #getRelDomainNode() <em>Rel Domain Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelDomainNode()
	 * @generated
	 * @ordered
	 */
	protected RelDomainNode relDomainNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelPatternClassNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_PATTERN_CLASS_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsMany() {
		return isMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsMany(boolean newIsMany) {
		boolean oldIsMany = isMany;
		isMany = newIsMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__IS_MANY, oldIsMany, isMany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsNullFree() {
		return isNullFree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsNullFree(boolean newIsNullFree) {
		boolean oldIsNullFree = isNullFree;
		isNullFree = newIsNullFree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__IS_NULL_FREE, oldIsNullFree, isNullFree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRequired() {
		return isRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRequired(boolean newIsRequired) {
		boolean oldIsRequired = isRequired;
		isRequired = newIsRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__IS_REQUIRED, oldIsRequired, isRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsUnique(boolean newIsUnique) {
		boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassifier getReferredEClassifier() {
		if (referredEClassifier != null && referredEClassifier.eIsProxy()) {
			InternalEObject oldReferredEClassifier = (InternalEObject)referredEClassifier;
			referredEClassifier = (EClassifier)eResolveProxy(oldReferredEClassifier);
			if (referredEClassifier != oldReferredEClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER, oldReferredEClassifier, referredEClassifier));
			}
		}
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetReferredEClassifier() {
		return referredEClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEClassifier(EClassifier newReferredEClassifier) {
		EClassifier oldReferredEClassifier = referredEClassifier;
		referredEClassifier = newReferredEClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER, oldReferredEClassifier, referredEClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDomainNode getRelDomainNode() {
		if (relDomainNode != null && relDomainNode.eIsProxy()) {
			InternalEObject oldRelDomainNode = (InternalEObject)relDomainNode;
			relDomainNode = (RelDomainNode)eResolveProxy(oldRelDomainNode);
			if (relDomainNode != oldRelDomainNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE, oldRelDomainNode, relDomainNode));
			}
		}
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDomainNode basicGetRelDomainNode() {
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelDomainNode(RelDomainNode newRelDomainNode) {
		RelDomainNode oldRelDomainNode = relDomainNode;
		relDomainNode = newRelDomainNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE, oldRelDomainNode, relDomainNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean EClassifierIsInTypedModel(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv EClassifierIsInTypedModel:
		 *   let
		 *     severity : Integer[1] = 'RelPatternClassNode::EClassifierIsInTypedModel'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         result : Boolean[?] = let txTypedModelNode : TxTypedModelNode[?] = owningRelDomainNode.referredTxTypedModelNode
		 *         in txTypedModelNode <> null implies
		 *           txTypedModelNode.ownedTxPackageNodes.referredEPackage.eClassifiers->includes(referredEClassifier)
		 *       in
		 *         'RelPatternClassNode::EClassifierIsInTypedModel'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternClassNode_c_c_EClassifierIsInTypedModel);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_implies;
			try {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@NonNull RelDomainNode owningRelDomainNode = this.getOwningRelDomainNode();
				final /*@NonInvalid*/ org.eclipse.qvtd.umlx.@Nullable TxTypedModelNode txTypedModelNode = owningRelDomainNode.getReferredTxTypedModelNode();
				final /*@NonInvalid*/ boolean ne = txTypedModelNode != null;
				/*@Thrown*/ boolean implies;
				if (ne) {
					if (txTypedModelNode == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2016/UMLX\'::TxTypedModelNode::ownedTxPackageNodes\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ java.util.@NonNull List<TxPackageNode> ownedTxPackageNodes = txTypedModelNode.getOwnedTxPackageNodes();
					final /*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_ownedTxPackageNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxPackageNode, ownedTxPackageNodes);
					/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_EPackage);
					@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedTxPackageNodes.iterator();
					/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect_0;
					while (true) {
						if (!ITERATOR__1.hasNext()) {
							collect_0 = accumulator;
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
						accumulator.add(referredEPackage);
					}
					/*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_EClassifier);
					@NonNull Iterator<Object> ITERATOR__1_0 = collect_0.iterator();
					/*@Thrown*/ org.eclipse.ocl.pivot.values.@NonNull SequenceValue collect;
					while (true) {
						if (!ITERATOR__1_0.hasNext()) {
							collect = accumulator_0;
							break;
						}
						@SuppressWarnings("null")
						/*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EPackage _1_0 = (EPackage)ITERATOR__1_0.next();
						/**
						 * eClassifiers
						 */
						@SuppressWarnings("null")
						final /*@NonInvalid*/ java.util.@NonNull List<EClassifier> eClassifiers = _1_0.getEClassifiers();
						final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull OrderedSetValue BOXED_eClassifiers = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClassifier, eClassifiers);
						//
						for (Object value : BOXED_eClassifiers.flatten().getElements()) {
							accumulator_0.add(value);
						}
					}
					@SuppressWarnings("null")
					final /*@NonInvalid*/ org.eclipse.emf.ecore.@NonNull EClassifier referredEClassifier = this.getReferredEClassifier();
					final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(collect, referredEClassifier).booleanValue();
					implies = includes;
				}
				else {
					implies = ValueUtil.TRUE_VALUE;
				}
				CAUGHT_implies = implies;
			}
			catch (Exception e) {
				CAUGHT_implies = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternClassNode_c_c_EClassifierIsInTypedModel, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_implies, UMLXTables.INT_0).booleanValue();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_PATTERN_CLASS_NODE__NAME:
				return getName();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_MANY:
				return isIsMany();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_NULL_FREE:
				return isIsNullFree();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_ORDERED:
				return isIsOrdered();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_REQUIRED:
				return isIsRequired();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_UNIQUE:
				return isIsUnique();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER:
				if (resolve) return getReferredEClassifier();
				return basicGetReferredEClassifier();
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE:
				if (resolve) return getRelDomainNode();
				return basicGetRelDomainNode();
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
			case UMLXPackage.REL_PATTERN_CLASS_NODE__NAME:
				setName((String)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_MANY:
				setIsMany((Boolean)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_NULL_FREE:
				setIsNullFree((Boolean)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_REQUIRED:
				setIsRequired((Boolean)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER:
				setReferredEClassifier((EClassifier)newValue);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE:
				setRelDomainNode((RelDomainNode)newValue);
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
			case UMLXPackage.REL_PATTERN_CLASS_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_MANY:
				setIsMany(IS_MANY_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_NULL_FREE:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_REQUIRED:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER:
				setReferredEClassifier((EClassifier)null);
				return;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE:
				setRelDomainNode((RelDomainNode)null);
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
			case UMLXPackage.REL_PATTERN_CLASS_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_MANY:
				return isMany != IS_MANY_EDEFAULT;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_NULL_FREE:
				return isNullFree != IS_NULL_FREE_EDEFAULT;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_REQUIRED:
				return isRequired != IS_REQUIRED_EDEFAULT;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__IS_UNIQUE:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REFERRED_ECLASSIFIER:
				return referredEClassifier != null;
			case UMLXPackage.REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE:
				return relDomainNode != null;
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
				case UMLXPackage.REL_PATTERN_CLASS_NODE__NAME: return UMLXPackage.UMLX_NAMED_ELEMENT__NAME;
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
				case UMLXPackage.UMLX_NAMED_ELEMENT__NAME: return UMLXPackage.REL_PATTERN_CLASS_NODE__NAME;
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
		return visitor.visitRelPatternClassNode(this);
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

} //RelPatternNodeImpl
