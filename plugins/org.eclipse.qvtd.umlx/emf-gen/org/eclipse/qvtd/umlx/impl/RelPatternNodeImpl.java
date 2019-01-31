/**
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionNotEmptyOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTables;
import org.eclipse.qvtd.umlx.UMLXTypedElement;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsMany <em>Is Many</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsNullFree <em>Is Null Free</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getReferredEClassifier <em>Referred EClassifier</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getInitExpressionLines <em>Init Expression Lines</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getInvokingRelInvocationEdges <em>Invoking Rel Invocation Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsAnon <em>Is Anon</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelPatternNodeImpl extends RelNodeImpl implements RelPatternNode {
	/**
	 * The number of structural features of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE_FEATURE_COUNT = RelNodeImpl.REL_NODE_FEATURE_COUNT + 14;
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
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternEdge> incoming;
	/**
	 * The cached value of the '{@link #getInitExpressionLines() <em>Init Expression Lines</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExpressionLines()
	 * @generated
	 * @ordered
	 */
	protected EList<String> initExpressionLines;
	/**
	 * The cached value of the '{@link #getInvokingRelInvocationEdges() <em>Invoking Rel Invocation Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokingRelInvocationEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<RelInvocationEdge> invokingRelInvocationEdges;
	/**
	 * The default value of the '{@link #isIsAnon() <em>Is Anon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnon()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ANON_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsAnon() <em>Is Anon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnon()
	 * @generated
	 * @ordered
	 */
	protected boolean isAnon = IS_ANON_EDEFAULT;
	/**
	 * The default value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ROOT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected boolean isRoot = IS_ROOT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternEdge> outgoing;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelPatternNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_PATTERN_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 0, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 1, oldIsMany, isMany));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 2, oldIsNullFree, isNullFree));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 3, oldIsOrdered, isOrdered));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 4, oldIsRequired, isRequired));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 5, oldIsUnique, isUnique));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelNodeImpl.REL_NODE_FEATURE_COUNT + 6, oldReferredEClassifier, referredEClassifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 6, oldReferredEClassifier, referredEClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<RelPatternEdge>(RelPatternEdge.class, this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 7, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 4);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getInitExpressionLines() {
		if (initExpressionLines == null) {
			initExpressionLines = new EDataTypeUniqueEList<String>(String.class, this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 8);
		}
		return initExpressionLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsRoot() {
		return isRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsRoot(boolean newIsRoot) {
		boolean oldIsRoot = isRoot;
		isRoot = newIsRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 11, oldIsRoot, isRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<RelPatternEdge>(RelPatternEdge.class, this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 12, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDomainNode getOwningRelDomainNode() {
		if (eContainerFeatureID() != (RelNodeImpl.REL_NODE_FEATURE_COUNT + 13)) return null;
		return (RelDomainNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDomainNode(RelDomainNode newOwningRelDomainNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDomainNode, RelNodeImpl.REL_NODE_FEATURE_COUNT + 13, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDomainNode(RelDomainNode newOwningRelDomainNode) {
		if (newOwningRelDomainNode != eInternalContainer() || (eContainerFeatureID() != (RelNodeImpl.REL_NODE_FEATURE_COUNT + 13) && newOwningRelDomainNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDomainNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDomainNode != null)
				msgs = ((InternalEObject)newOwningRelDomainNode).eInverseAdd(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 2, RelDomainNode.class, msgs);
			msgs = basicSetOwningRelDomainNode(newOwningRelDomainNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 13, newOwningRelDomainNode, newOwningRelDomainNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean isExpression() {
		/**
		 * name = null and initExpressionLines->notEmpty()
		 */
		final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ @Nullable String name = this.getName();
		final /*@NonInvalid*/ boolean eq = name == null;
		/*@NonInvalid*/ boolean and;
		if (eq) {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<String> initExpressionLines = this.getInitExpressionLines();
			final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_initExpressionLines = idResolver.createOrderedSetOfAll(UMLXTables.ORD_PRIMid_String, initExpressionLines);
			final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_initExpressionLines).booleanValue();
			and = notEmpty;
		}
		else {
			and = ValueUtil.FALSE_VALUE;
		}
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAnonIsUnnamed(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv AnonIsUnnamed:
			 *   let severity : Integer[1] = 'RelPatternNode::AnonIsUnnamed'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not isExpression() implies isAnon = name = ''
			 *       in
			 *         'RelPatternNode::AnonIsUnnamed'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternNode_c_c_AnonIsUnnamed);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					final /*@NonInvalid*/ boolean isAnon = this.isIsAnon();
					final /*@NonInvalid*/ @Nullable String name = this.getName();
					final /*@NonInvalid*/ boolean eq = UMLXTables.STR_.equals(name);
					final /*@NonInvalid*/ boolean eq_0 = isAnon == eq;
					final /*@Thrown*/ @Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(not, eq_0);
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternNode_c_c_AnonIsUnnamed, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("RelPatternNode::AnonIsUnnamed", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTypeIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv TypeIsRequired:
			 *   let severity : Integer[1] = 'RelPatternNode::TypeIsRequired'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = not isExpression() implies referredEClassifier <> null
			 *       in
			 *         'RelPatternNode::TypeIsRequired'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternNode_c_c_TypeIsRequired);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = this.getReferredEClassifier();
					final /*@NonInvalid*/ boolean ne = referredEClassifier != null;
					final /*@Thrown*/ @Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(not, ne);
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternNode_c_c_TypeIsRequired, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("RelPatternNode::TypeIsRequired", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateEClassifierIsInTypedModel(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		try {
			/**
			 *
			 * inv EClassifierIsInTypedModel:
			 *   let
			 *     severity : Integer[1] = 'RelPatternNode::EClassifierIsInTypedModel'.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = not isExpression() implies
			 *         let txTypedModelNode : TxTypedModelNode[?] = owningRelDomainNode.referredTxTypedModelNode
			 *         in txTypedModelNode <> null implies
			 *           txTypedModelNode.usedTxPackageNodes.referredEPackage.eClassifiers->includes(referredEClassifier)
			 *       in
			 *         'RelPatternNode::EClassifierIsInTypedModel'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXTables.STR_RelPatternNode_c_c_EClassifierIsInTypedModel);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isExpression);
					/*@Caught*/ @NonNull Object CAUGHT_implies;
					try {
						@SuppressWarnings("null")
						final /*@NonInvalid*/ @NonNull RelDomainNode owningRelDomainNode = this.getOwningRelDomainNode();
						final /*@NonInvalid*/ @Nullable TxTypedModelNode txTypedModelNode = owningRelDomainNode.getReferredTxTypedModelNode();
						final /*@NonInvalid*/ boolean ne = txTypedModelNode != null;
						/*@Thrown*/ boolean implies;
						if (ne) {
							if (txTypedModelNode == null) {
								throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2016/UMLX\'::TxTypedModelNode::usedTxPackageNodes\'");
							}
							@SuppressWarnings("null")
							final /*@Thrown*/ @NonNull List<TxPackageNode> usedTxPackageNodes = txTypedModelNode.getUsedTxPackageNodes();
							final /*@Thrown*/ @NonNull OrderedSetValue BOXED_usedTxPackageNodes = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_TxPackageNode, usedTxPackageNodes);
							/*@Thrown*/ @NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_EPackage);
							@NonNull Iterator<Object> ITERATOR__1 = BOXED_usedTxPackageNodes.iterator();
							/*@Thrown*/ @NonNull SequenceValue collect_0;
							while (true) {
								if (!ITERATOR__1.hasNext()) {
									collect_0 = accumulator;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull TxPackageNode _1 = (@NonNull TxPackageNode)ITERATOR__1.next();
								/**
								 * referredEPackage
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull EPackage referredEPackage = _1.getReferredEPackage();
								//
								accumulator.add(referredEPackage);
							}
							/*@Thrown*/ @NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(UMLXTables.SEQ_CLSSid_EClassifier);
							@NonNull Iterator<Object> ITERATOR__1_0 = collect_0.iterator();
							/*@Thrown*/ @NonNull SequenceValue collect;
							while (true) {
								if (!ITERATOR__1_0.hasNext()) {
									collect = accumulator_0;
									break;
								}
								@SuppressWarnings("null")
								/*@NonInvalid*/ @NonNull EPackage _1_0 = (@NonNull EPackage)ITERATOR__1_0.next();
								/**
								 * eClassifiers
								 */
								@SuppressWarnings("null")
								final /*@NonInvalid*/ @NonNull List<EClassifier> eClassifiers = _1_0.getEClassifiers();
								final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_eClassifiers = idResolver.createOrderedSetOfAll(UMLXTables.ORD_CLSSid_EClassifier, eClassifiers);
								//
								for (Object value : BOXED_eClassifiers.flatten().getElements()) {
									accumulator_0.add(value);
								}
							}
							final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = this.getReferredEClassifier();
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
					final /*@Thrown*/ @Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(not, CAUGHT_implies);
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, UMLXTables.STR_RelPatternNode_c_c_EClassifierIsInTypedModel, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic("RelPatternNode::EClassifierIsInTypedModel", this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelInvocationEdge> getInvokingRelInvocationEdges() {
		if (invokingRelInvocationEdges == null) {
			invokingRelInvocationEdges = new EObjectWithInverseResolvingEList<RelInvocationEdge>(RelInvocationEdge.class, this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 9, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0);
		}
		return invokingRelInvocationEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAnon() {
		return isAnon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAnon(boolean newIsAnon) {
		boolean oldIsAnon = isAnon;
		isAnon = newIsAnon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelNodeImpl.REL_NODE_FEATURE_COUNT + 10, oldIsAnon, isAnon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", isMany: ");
		result.append(isMany);
		result.append(", isNullFree: ");
		result.append(isNullFree);
		result.append(", isOrdered: ");
		result.append(isOrdered);
		result.append(", isRequired: ");
		result.append(isRequired);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(", initExpressionLines: ");
		result.append(initExpressionLines);
		result.append(", isAnon: ");
		result.append(isAnon);
		result.append(", isRoot: ");
		result.append(isRoot);
		result.append(')');
		return result.toString();
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInvokingRelInvocationEdges()).basicAdd(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDomainNode((RelDomainNode)otherEnd, msgs);
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				return ((InternalEList<?>)getInvokingRelInvocationEdges()).basicRemove(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				return basicSetOwningRelDomainNode(null, msgs);
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				return eInternalContainer().eInverseRemove(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 2, RelDomainNode.class, msgs);
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 0:
				return getName();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 1:
				return isIsMany();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 2:
				return isIsNullFree();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 3:
				return isIsOrdered();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 4:
				return isIsRequired();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 5:
				return isIsUnique();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 6:
				if (resolve) return getReferredEClassifier();
				return basicGetReferredEClassifier();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				return getIncoming();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 8:
				return getInitExpressionLines();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				return getInvokingRelInvocationEdges();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 10:
				return isIsAnon();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 11:
				return isIsRoot();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				return getOutgoing();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				return getOwningRelDomainNode();
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 0:
				setName((String)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 1:
				setIsMany((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 2:
				setIsNullFree((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 3:
				setIsOrdered((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 4:
				setIsRequired((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 5:
				setIsUnique((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 6:
				setReferredEClassifier((EClassifier)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 8:
				getInitExpressionLines().clear();
				getInitExpressionLines().addAll((Collection<? extends String>)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				getInvokingRelInvocationEdges().clear();
				getInvokingRelInvocationEdges().addAll((Collection<? extends RelInvocationEdge>)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 10:
				setIsAnon((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 11:
				setIsRoot((Boolean)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				setOwningRelDomainNode((RelDomainNode)newValue);
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 0:
				setName(NAME_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 1:
				setIsMany(IS_MANY_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 2:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 3:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 4:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 5:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 6:
				setReferredEClassifier((EClassifier)null);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				getIncoming().clear();
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 8:
				getInitExpressionLines().clear();
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				getInvokingRelInvocationEdges().clear();
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 10:
				setIsAnon(IS_ANON_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 11:
				setIsRoot(IS_ROOT_EDEFAULT);
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				getOutgoing().clear();
				return;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				setOwningRelDomainNode((RelDomainNode)null);
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
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 0:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 1:
				return isMany != IS_MANY_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 2:
				return isNullFree != IS_NULL_FREE_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 3:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 4:
				return isRequired != IS_REQUIRED_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 5:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 6:
				return referredEClassifier != null;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 7:
				return incoming != null && !incoming.isEmpty();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 8:
				return initExpressionLines != null && !initExpressionLines.isEmpty();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 9:
				return invokingRelInvocationEdges != null && !invokingRelInvocationEdges.isEmpty();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 10:
				return isAnon != IS_ANON_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 11:
				return isRoot != IS_ROOT_EDEFAULT;
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 12:
				return outgoing != null && !outgoing.isEmpty();
			case RelNodeImpl.REL_NODE_FEATURE_COUNT + 13:
				return getOwningRelDomainNode() != null;
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
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 0: return UMLXElementImpl.UMLX_ELEMENT_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (derivedFeatureID) {
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 1: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0;
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 2: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1;
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 3: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2;
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 4: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3;
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 5: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4;
				case RelNodeImpl.REL_NODE_FEATURE_COUNT + 6: return UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5;
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
				case UMLXElementImpl.UMLX_ELEMENT_FEATURE_COUNT + 0: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (baseFeatureID) {
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 1;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 2;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 3;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 4;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 5;
				case UMLXNamedElementImpl.UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5: return RelNodeImpl.REL_NODE_FEATURE_COUNT + 6;
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
		return visitor.visitRelPatternNode(this);
	}

} //RelNodeImpl
