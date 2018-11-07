/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#isPartial <em>Partial</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigationEdgeImpl extends NavigableEdgeImpl implements NavigationEdge {
	/**
	 * The default value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTIAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean partial = PARTIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NAVIGATION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPartial() {
		return partial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartial(boolean newPartial) {
		boolean oldPartial = partial;
		partial = newPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NAVIGATION_EDGE__PARTIAL, oldPartial, partial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.NAVIGATION_EDGE__PARTIAL:
				return isPartial();
			case QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
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
			case QVTschedulePackage.NAVIGATION_EDGE__PARTIAL:
				setPartial((Boolean)newValue);
				return;
			case QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case QVTschedulePackage.NAVIGATION_EDGE__PARTIAL:
				setPartial(PARTIAL_EDEFAULT);
				return;
			case QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
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
			case QVTschedulePackage.NAVIGATION_EDGE__PARTIAL:
				return partial != PARTIAL_EDEFAULT;
			case QVTschedulePackage.NAVIGATION_EDGE__REFERRED_PROPERTY:
				return referredProperty != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNavigationEdge(this);
	}

	@Override
	public @NonNull NavigableEdge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		NavigationEdge edge = (NavigationEdge)super.createEdge(edgeRole, sourceNode, targetNode);
		edge.initializeProperty(QVTscheduleUtil.getProperty(this), isPartial());
		return edge;
	}

	@Override
	public @Nullable String getLabel() {
		if (partial) {
			return "«includes»\\n" + super.getLabel();
		}
		else {
			return super.getLabel();
		}
	}

	@Override
	public Property getProperty() {
		return getReferredProperty();
	}

	private void initializeIsPartial(@Nullable Boolean isPartial) {
		boolean isComputedPartial = false;
		Type propertyTargetType = PivotUtil.getType(QVTscheduleUtil.getProperty(this));
		CompleteClass targetClass = targetNode.getCompleteClass();
		if (!targetClass.conformsTo(propertyTargetType)) {
			if (propertyTargetType instanceof CollectionType) {
				Type elementType = PivotUtil.getElementType(((CollectionType)propertyTargetType));
				if (targetClass.conformsTo(elementType)) {
					isComputedPartial = true;
				}
			}
		}
		if (isPartial == null) {
			isPartial = isComputedPartial;
		}
		assert isPartial == isComputedPartial;
		setPartial(isPartial);
	}

	@Override
	public void initializeProperty(@NonNull Property property, @Nullable Boolean isPartial) {
		setReferredProperty(property);
		Property target2sourceProperty = property.getOpposite();
		if (target2sourceProperty != null)  {
			Node targetNode2 = targetNode;
			assert targetNode2 != null;
			if (!targetNode2.isNullLiteral()) {
				assert (targetNode2.getNavigableEdge(target2sourceProperty) == null) || target2sourceProperty.isIsMany() || (isPartial() == Boolean.TRUE);
				boolean isClassComposite = property.isIsComposite() && targetNode.isClass();
				boolean isBidirectionalOneToOne = !property.isIsMany() && !target2sourceProperty.isIsMany();
				if (isClassComposite || isBidirectionalOneToOne /*&& target2sourceProperty.isIsRequired()*/) {		// FIXME do we need stronger type conformance here ??
					Role edgeRole2 = edgeRole;
					Node sourceNode2 = sourceNode;
					assert (edgeRole2 != null) && (sourceNode2 != null);
					NavigationEdge reverseEdge = QVTscheduleFactory.eINSTANCE.createNavigationEdge();
					reverseEdge.initialize(edgeRole2, targetNode2, target2sourceProperty.getName(), sourceNode2);
					reverseEdge.setReferredProperty(target2sourceProperty);
					((NavigationEdgeImpl)reverseEdge).initializeIsPartial(isPartial());
					initializeOpposite(reverseEdge);
				}
			}
		}
		initializeIsPartial(isPartial);
	}

	@Override
	public final boolean isNavigation() {
		return true;
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		assert (sourceNode == null) || !sourceNode.isNullLiteral();
		super.setSource(sourceNode);
	}

} //NavigationEdgeImpl
