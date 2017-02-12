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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl#isNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConnectionRoleImpl extends ElementImpl implements ConnectionRole {
	/**
	 * The default value of the '{@link #isNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NODE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNode()
	 * @generated
	 * @ordered
	 */
	protected boolean node = NODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CONNECTION_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(boolean newNode) {
		boolean oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CONNECTION_ROLE__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.CONNECTION_ROLE__NODE:
				return isNode();
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
			case QVTschedulePackage.CONNECTION_ROLE__NODE:
				setNode((Boolean)newValue);
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
			case QVTschedulePackage.CONNECTION_ROLE__NODE:
				setNode(NODE_EDEFAULT);
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
			case QVTschedulePackage.CONNECTION_ROLE__NODE:
				return node != NODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	@Override
	public @Nullable String getArrowhead() {
		return null;
	}

	@Override
	public @NonNull String getColor() {
		return node ? QVTscheduleConstants.BINDING_COLOR : QVTscheduleConstants.ORDERING_COLOR;
	}

	@Override
	public @Nullable String getLabel() {
		return null;
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return QVTscheduleConstants.LINE_WIDTH;
	}

	@Override
	public @NonNull GraphNode getEdgeSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public @NonNull GraphNode getEdgeTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isMandatory() {
		return false;
	}

	@Override
	public boolean isPassed() {
		return false;
	}

	@Override
	public boolean isPreferred() {
		return false;
	}

	@Override
	public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
		throw new IllegalStateException(this + " cannot be merged with " + connectionRole);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
} //ConnectionRoleImpl
