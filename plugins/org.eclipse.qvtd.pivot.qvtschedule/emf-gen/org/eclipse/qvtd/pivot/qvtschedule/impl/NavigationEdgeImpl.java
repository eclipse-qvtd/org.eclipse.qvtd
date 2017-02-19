/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NavigationEdgeImpl extends NavigableEdgeImpl implements NavigationEdge {
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
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNavigationEdge(this);
	}
	private static @NonNull NavigationEdgeImpl create(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		if ("outTransition".equals(source2targetProperty.getName())) {
			edgeRole.toString();
		}
		NavigationEdgeImpl edge = new NavigationEdgeImpl();
		edge.initialize(edgeRole, sourceNode, source2targetProperty, targetNode, isPartial);
		return edge;
	}

	/**
	 * Create, install and return the edgeRole edge for source2targetProperty from sourceNode to targetNode. If
	 * source2targetProperty has an opposite, the opposite edge is also created and installed.
	 */
	public static @NonNull NavigableEdge createEdge(@NonNull EdgeRole edgeRole,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		NavigationEdgeImpl forwardEdge = create(edgeRole, sourceNode, source2targetProperty, targetNode, isPartial);
		Property target2sourceProperty = source2targetProperty.getOpposite();
		if ((target2sourceProperty != null) && !targetNode.isExplicitNull()) {
			assert (targetNode.getNavigationEdge(target2sourceProperty) == null) || target2sourceProperty.isIsMany() || (isPartial == Boolean.TRUE);
			if (!source2targetProperty.isIsMany() && !target2sourceProperty.isIsMany() /*&& target2sourceProperty.isIsRequired()*/) {		// FIXME do we need stronger type conformance here ??
				NavigationEdgeImpl reverseEdge = create(edgeRole, targetNode, target2sourceProperty, sourceNode, isPartial);
				forwardEdge.initializeOpposite(reverseEdge);
			}
		}
		return forwardEdge;
	}

	/**
	 * True if this edge is a partial many-to-one relationship.
	 */
	private boolean isPartial = false;

	@Override
	public @NonNull NavigableEdge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return createEdge(edgeRole, sourceNode, getProperty(), targetNode, isPartial);
	}

	@Override
	public @Nullable String getLabel() {
		if (isPartial) {
			return "«includes»\\n" + super.getLabel();
		}
		else {
			return super.getLabel();
		}
	}

	public void initialize(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty,
			@NonNull Node targetNode, @Nullable Boolean isPartial) {
		super.initialize(edgeRole, sourceNode, source2targetProperty, targetNode);
		boolean isComputedPartial = false;
		Type propertyTargetType = PivotUtil.getType(source2targetProperty);
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
		setIsPartial(isPartial);
	}

	@Override
	public final boolean isPartial() {
		return isPartial;
	}

	@Override
	public final boolean isNavigation() {
		return true;
	}

	public void setIsPartial(boolean isPartial) {
		this.isPartial  = isPartial;
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		assert (sourceNode == null) || !sourceNode.isExplicitNull();
		super.setSource(sourceNode);
	}
} //NavigationEdgeImpl
