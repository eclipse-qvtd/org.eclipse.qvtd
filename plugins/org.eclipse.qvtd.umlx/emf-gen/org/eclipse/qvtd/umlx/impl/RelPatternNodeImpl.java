/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import java.lang.reflect.InvocationTargetException;
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
	 * The number of operations of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE_OPERATION_COUNT = RelNodeImpl.REL_NODE_OPERATION_COUNT + 4;
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
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 2, oldIsMany, isMany));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldIsNullFree, isNullFree));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 4, oldIsOrdered, isOrdered));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldIsRequired, isRequired));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 6, oldIsUnique, isUnique));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 7, oldReferredEClassifier, referredEClassifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 7, oldReferredEClassifier, referredEClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<RelPatternEdge>(RelPatternEdge.class, this, 8, 5);
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
			initExpressionLines = new EDataTypeUniqueEList<String>(String.class, this, 9);
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
			eNotify(new ENotificationImpl(this, Notification.SET, 12, oldIsRoot, isRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<RelPatternEdge>(RelPatternEdge.class, this, 13, 3);
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
		if (eContainerFeatureID() != (14)) return null;
		return (RelDomainNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDomainNode(RelDomainNode newOwningRelDomainNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDomainNode, 14, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDomainNode(RelDomainNode newOwningRelDomainNode) {
		if (newOwningRelDomainNode != eInternalContainer() || (eContainerFeatureID() != (14) && newOwningRelDomainNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDomainNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDomainNode != null)
				msgs = ((InternalEObject)newOwningRelDomainNode).eInverseAdd(this, 3, RelDomainNode.class, msgs);
			msgs = basicSetOwningRelDomainNode(newOwningRelDomainNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 14, newOwningRelDomainNode, newOwningRelDomainNode));
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
		final /*@NonInvalid*/ @Nullable Boolean and;
		if (!eq) {
			and = ValueUtil.FALSE_VALUE;
		}
		else {
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<String> initExpressionLines = this.getInitExpressionLines();
			final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_initExpressionLines = idResolver.createOrderedSetOfAll(UMLXTables.ORD_PRIMid_String, initExpressionLines);
			final /*@NonInvalid*/ boolean notEmpty = CollectionNotEmptyOperation.INSTANCE.evaluate(BOXED_initExpressionLines).booleanValue();
			if (!notEmpty) {
				and = ValueUtil.FALSE_VALUE;
			}
			else {
				and = ValueUtil.TRUE_VALUE;
			}
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
		final @NonNull String constraintName = "RelPatternNode::AnonIsUnnamed";
		try {
			/**
			 *
			 * inv AnonIsUnnamed:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = not isExpression() implies isAnon = name = ''
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_NODE___VALIDATE_ANON_IS_UNNAMED__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not;
					if (!isExpression) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (isExpression) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (not == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ boolean isAnon = this.isIsAnon();
						final /*@NonInvalid*/ @Nullable String name = this.getName();
						final /*@NonInvalid*/ boolean eq = UMLXTables.STR_.equals(name);
						final /*@NonInvalid*/ boolean eq_0 = isAnon == eq;
						if (eq_0) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (not == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateTypeIsRequired(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternNode::TypeIsRequired";
		try {
			/**
			 *
			 * inv TypeIsRequired:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = not isExpression() implies referredEClassifier <> null
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_NODE___VALIDATE_TYPE_IS_REQUIRED__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not;
					if (!isExpression) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (isExpression) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (not == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						final /*@NonInvalid*/ @Nullable EClassifier referredEClassifier = this.getReferredEClassifier();
						final /*@NonInvalid*/ boolean ne = referredEClassifier != null;
						if (ne) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (not == null) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public boolean validateEClassifierIsInTypedModel(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "RelPatternNode::EClassifierIsInTypedModel";
		try {
			/**
			 *
			 * inv EClassifierIsInTypedModel:
			 *   let severity : Integer[1] = constraintName.getSeverity()
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
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, UMLXPackage.Literals.REL_PATTERN_NODE___VALIDATE_ECLASSIFIER_IS_IN_TYPED_MODEL__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, UMLXTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ boolean isExpression = this.isExpression();
					final /*@NonInvalid*/ @Nullable Boolean not;
					if (!isExpression) {
						not = ValueUtil.TRUE_VALUE;
					}
					else {
						if (isExpression) {
							not = ValueUtil.FALSE_VALUE;
						}
						else {
							not = null;
						}
					}
					final /*@Thrown*/ @Nullable Boolean result;
					if (not == ValueUtil.FALSE_VALUE) {
						result = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_implies;
						try {
							@SuppressWarnings("null")
							final /*@NonInvalid*/ @NonNull RelDomainNode owningRelDomainNode = this.getOwningRelDomainNode();
							final /*@NonInvalid*/ @Nullable TxTypedModelNode txTypedModelNode = owningRelDomainNode.getReferredTxTypedModelNode();
							final /*@NonInvalid*/ boolean ne = txTypedModelNode != null;
							final /*@Thrown*/ @Nullable Boolean implies;
							if (!ne) {
								implies = ValueUtil.TRUE_VALUE;
							}
							else {
								/*@Caught*/ @NonNull Object CAUGHT_includes;
								try {
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
									CAUGHT_includes = includes;
								}
								catch (Exception e) {
									CAUGHT_includes = ValueUtil.createInvalidValue(e);
								}
								if (CAUGHT_includes == ValueUtil.TRUE_VALUE) {
									implies = ValueUtil.TRUE_VALUE;
								}
								else {
									if (CAUGHT_includes instanceof InvalidValueException) {
										throw (InvalidValueException)CAUGHT_includes;
									}
									implies = ValueUtil.FALSE_VALUE;
								}
							}
							CAUGHT_implies = implies;
						}
						catch (Exception e) {
							CAUGHT_implies = ValueUtil.createInvalidValue(e);
						}
						if (CAUGHT_implies == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							if (CAUGHT_implies instanceof InvalidValueException) {
								throw (InvalidValueException)CAUGHT_implies;
							}
							if ((not == null) || (CAUGHT_implies == null)) {
								result = null;
							}
							else {
								result = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, UMLXTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return symbol_0;
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
	public EList<RelInvocationEdge> getInvokingRelInvocationEdges() {
		if (invokingRelInvocationEdges == null) {
			invokingRelInvocationEdges = new EObjectWithInverseResolvingEList<RelInvocationEdge>(RelInvocationEdge.class, this, 10, 1);
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
			eNotify(new ENotificationImpl(this, Notification.SET, 11, oldIsAnon, isAnon));
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
			case 8:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case 10:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInvokingRelInvocationEdges()).basicAdd(otherEnd, msgs);
			case 13:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case 14:
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
			case 8:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case 10:
				return ((InternalEList<?>)getInvokingRelInvocationEdges()).basicRemove(otherEnd, msgs);
			case 13:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case 14:
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
			case 14:
				return eInternalContainer().eInverseRemove(this, 3, RelDomainNode.class, msgs);
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
			case 1:
				return getName();
			case 2:
				return isIsMany();
			case 3:
				return isIsNullFree();
			case 4:
				return isIsOrdered();
			case 5:
				return isIsRequired();
			case 6:
				return isIsUnique();
			case 7:
				if (resolve) return getReferredEClassifier();
				return basicGetReferredEClassifier();
			case 8:
				return getIncoming();
			case 9:
				return getInitExpressionLines();
			case 10:
				return getInvokingRelInvocationEdges();
			case 11:
				return isIsAnon();
			case 12:
				return isIsRoot();
			case 13:
				return getOutgoing();
			case 14:
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
			case 1:
				setName((String)newValue);
				return;
			case 2:
				setIsMany((Boolean)newValue);
				return;
			case 3:
				setIsNullFree((Boolean)newValue);
				return;
			case 4:
				setIsOrdered((Boolean)newValue);
				return;
			case 5:
				setIsRequired((Boolean)newValue);
				return;
			case 6:
				setIsUnique((Boolean)newValue);
				return;
			case 7:
				setReferredEClassifier((EClassifier)newValue);
				return;
			case 8:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case 9:
				getInitExpressionLines().clear();
				getInitExpressionLines().addAll((Collection<? extends String>)newValue);
				return;
			case 10:
				getInvokingRelInvocationEdges().clear();
				getInvokingRelInvocationEdges().addAll((Collection<? extends RelInvocationEdge>)newValue);
				return;
			case 11:
				setIsAnon((Boolean)newValue);
				return;
			case 12:
				setIsRoot((Boolean)newValue);
				return;
			case 13:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case 14:
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
			case 1:
				setName(NAME_EDEFAULT);
				return;
			case 2:
				setIsMany(IS_MANY_EDEFAULT);
				return;
			case 3:
				setIsNullFree(IS_NULL_FREE_EDEFAULT);
				return;
			case 4:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case 5:
				setIsRequired(IS_REQUIRED_EDEFAULT);
				return;
			case 6:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case 7:
				setReferredEClassifier((EClassifier)null);
				return;
			case 8:
				getIncoming().clear();
				return;
			case 9:
				getInitExpressionLines().clear();
				return;
			case 10:
				getInvokingRelInvocationEdges().clear();
				return;
			case 11:
				setIsAnon(IS_ANON_EDEFAULT);
				return;
			case 12:
				setIsRoot(IS_ROOT_EDEFAULT);
				return;
			case 13:
				getOutgoing().clear();
				return;
			case 14:
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
			case 1:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case 2:
				return isMany != IS_MANY_EDEFAULT;
			case 3:
				return isNullFree != IS_NULL_FREE_EDEFAULT;
			case 4:
				return isOrdered != IS_ORDERED_EDEFAULT;
			case 5:
				return isRequired != IS_REQUIRED_EDEFAULT;
			case 6:
				return isUnique != IS_UNIQUE_EDEFAULT;
			case 7:
				return referredEClassifier != null;
			case 8:
				return incoming != null && !incoming.isEmpty();
			case 9:
				return initExpressionLines != null && !initExpressionLines.isEmpty();
			case 10:
				return invokingRelInvocationEdges != null && !invokingRelInvocationEdges.isEmpty();
			case 11:
				return isAnon != IS_ANON_EDEFAULT;
			case 12:
				return isRoot != IS_ROOT_EDEFAULT;
			case 13:
				return outgoing != null && !outgoing.isEmpty();
			case 14:
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
				case 1: return 1;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (derivedFeatureID) {
				case 2: return 2;
				case 3: return 3;
				case 4: return 4;
				case 5: return 5;
				case 6: return 6;
				case 7: return 7;
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
				case 1: return 1;
				default: return -1;
			}
		}
		if (baseClass == UMLXTypedElement.class) {
			switch (baseFeatureID) {
				case 2: return 2;
				case 3: return 3;
				case 4: return 4;
				case 5: return 5;
				case 6: return 6;
				case 7: return 7;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case 0:
				return isExpression();
			case 1:
				return validateAnonIsUnnamed((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 2:
				return validateTypeIsRequired((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case 3:
				return validateEClassifierIsInTypedModel((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
