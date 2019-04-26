/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigable Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl#getOppositeEdge <em>Opposite Edge</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl#isSecondary <em>Secondary</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NavigableEdgeImpl extends EdgeImpl implements NavigableEdge {
	/**
	 * The number of structural features of the '<em>Navigable Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGABLE_EDGE_FEATURE_COUNT = EdgeImpl.EDGE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Navigable Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGABLE_EDGE_OPERATION_COUNT = EdgeImpl.EDGE_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getIncomingConnection() <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConnection()
	 * @generated
	 * @ordered
	 */
	protected EdgeConnection incomingConnection;

	/**
	 * The cached value of the '{@link #getOppositeEdge() <em>Opposite Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeEdge()
	 * @generated
	 * @ordered
	 */
	protected NavigableEdge oppositeEdge;

	/**
	 * The cached value of the '{@link #getOutgoingConnections() <em>Outgoing Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeConnection> outgoingConnections;

	/**
	 * The default value of the '{@link #isSecondary() <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECONDARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSecondary() <em>Secondary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondary()
	 * @generated
	 * @ordered
	 */
	protected boolean secondary = SECONDARY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigableEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NAVIGABLE_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdgeConnection getIncomingConnection() {
		if (incomingConnection != null && incomingConnection.eIsProxy()) {
			InternalEObject oldIncomingConnection = (InternalEObject)incomingConnection;
			incomingConnection = (EdgeConnection)eResolveProxy(oldIncomingConnection);
			if (incomingConnection != oldIncomingConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldIncomingConnection, incomingConnection));
			}
		}
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeConnection basicGetIncomingConnection() {
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncomingConnection(EdgeConnection newIncomingConnection) {
		EdgeConnection oldIncomingConnection = incomingConnection;
		incomingConnection = newIncomingConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldIncomingConnection, incomingConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<EdgeConnection> getOutgoingConnections() {
		if (outgoingConnections == null) {
			outgoingConnections = new EObjectResolvingEList<EdgeConnection>(EdgeConnection.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 8);
		}
		return outgoingConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSecondary() {
		return secondary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecondary(boolean newSecondary) {
		boolean oldSecondary = secondary;
		secondary = newSecondary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 9, oldSecondary, secondary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NavigableEdge getOppositeEdge() {
		if (oppositeEdge != null && oppositeEdge.eIsProxy()) {
			InternalEObject oldOppositeEdge = (InternalEObject)oppositeEdge;
			oppositeEdge = (NavigableEdge)eResolveProxy(oldOppositeEdge);
			if (oppositeEdge != oldOppositeEdge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldOppositeEdge, oppositeEdge));
			}
		}
		return oppositeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigableEdge basicGetOppositeEdge() {
		return oppositeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOppositeEdge(NavigableEdge newOppositeEdge) {
		NavigableEdge oldOppositeEdge = oppositeEdge;
		oppositeEdge = newOppositeEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldOppositeEdge, oppositeEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				if (resolve) return getIncomingConnection();
				return basicGetIncomingConnection();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				if (resolve) return getOppositeEdge();
				return basicGetOppositeEdge();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return getOutgoingConnections();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				return isSecondary();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setIncomingConnection((EdgeConnection)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				setOppositeEdge((NavigableEdge)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				getOutgoingConnections().clear();
				getOutgoingConnections().addAll((Collection<? extends EdgeConnection>)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setSecondary((Boolean)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setIncomingConnection((EdgeConnection)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				setOppositeEdge((NavigableEdge)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				getOutgoingConnections().clear();
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				setSecondary(SECONDARY_EDEFAULT);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return incomingConnection != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
				return oppositeEdge != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 8:
				return outgoingConnections != null && !outgoingConnections.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 9:
				return secondary != SECONDARY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	@Override
	public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setColor(this);
		@Nullable
		NavigableEdge oppositeEdge2 = oppositeEdge;
		if (oppositeEdge2 != null) {
			String oppositeLabel = oppositeEdge2.getLabel();
			if ((oppositeLabel != null) && !oppositeEdge2.getProperty().getName().equals(getSourceNode().getClassDatum().getCompleteClass().getName())) {
				s.setTaillabel(oppositeLabel);
			}
		}
		String label = getLabel();
		if (label != null) {
			s.setHeadlabel(label);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		if (!isSecondary() && (oppositeEdge2 != null)) {
			s.setDir("both");
			s.setArrowtail("vee");
		}
		s.setArrowhead("normal");
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(sourceName, this, targetName);
	}

	@Override
	public void destroy() {
		NavigableEdge oppositeEdge = this.oppositeEdge;
		if (oppositeEdge != null) {
			this.oppositeEdge = null;
			oppositeEdge.destroy();
		}
		else {
			super.destroy();
		}
	}

	@Override
	public @NonNull String getDisplayName() {
		Property source2targetProperty2 = getProperty();
		if (source2targetProperty2 != null) {
			org.eclipse.ocl.pivot.Class owningClass = source2targetProperty2.getOwningClass();
			if (owningClass != null) {
				return owningClass.getName() + "::" + source2targetProperty2.getName();
			}
			else {
				return "" + source2targetProperty2.getName();
			}
		}
		else {
			return "null";
		}
	}

	@Override
	public @NonNull NavigableEdge getForwardEdge() {
		if (secondary) {
			assert oppositeEdge != null;
			return oppositeEdge;
		}
		else {
			return this;
		}
	}

	@Override
	public @Nullable String getLabel() {
		Property source2targetProperty2 = getProperty();
		if (source2targetProperty2 == null) {
			return "null";
		}
		else if (source2targetProperty2.eContainer() != null) {
			return source2targetProperty2.getName() + "\\n" + PivotUtil.getMultiplicity(source2targetProperty2);
		}
		else {
			return source2targetProperty2.getName();
		}
	}

	protected void initializeOpposite(@NonNull NavigableEdge oppositeEdge) {
		this.oppositeEdge = oppositeEdge;
		((NavigableEdgeImpl)oppositeEdge).oppositeEdge = this;
		// This differs from QVTscheduleUtil.getPrimaryProperty(property) which returns a context-independent forward/reverse choice as a baseProperty.
		// The secondary here favours the calling usage as primary unlss it must be reversed.
		// This makes a difference for the StructuredCladsses JUnit test that gets an NPE when assigning a not-null/null containment relationship backwards.
		if (this.getProperty().isIsImplicit()) {
			this.secondary = true;
		}
		else {
			((NavigableEdgeImpl)oppositeEdge).secondary = true;
		}
	}
} //NavigableEdgeImpl
