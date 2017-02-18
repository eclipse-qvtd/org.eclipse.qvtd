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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Datum Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl#getConnectionRole <em>Connection Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl#getSourceEnds <em>Source Ends</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DatumConnectionImpl<CE extends ConnectionEnd> extends ConnectionImpl implements DatumConnection<CE> {
	/**
	 * The default value of the '{@link #getConnectionRole() <em>Connection Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRole()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionRole CONNECTION_ROLE_EDEFAULT = ConnectionRole.UNDEFINED;

	/**
	 * The cached value of the '{@link #getConnectionRole() <em>Connection Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRole()
	 * @generated
	 * @ordered
	 */
	protected ConnectionRole connectionRole = CONNECTION_ROLE_EDEFAULT;

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
	 * The cached value of the '{@link #getSourceEnds() <em>Source Ends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEnds()
	 * @generated
	 * @ordered
	 */
	protected EList<CE> sourceEnds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DatumConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.DATUM_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionRole getConnectionRole() {
		return connectionRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionRole(ConnectionRole newConnectionRole) {
		ConnectionRole oldConnectionRole = connectionRole;
		connectionRole = newConnectionRole == null ? CONNECTION_ROLE_EDEFAULT : newConnectionRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE, oldConnectionRole, connectionRole));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.DATUM_CONNECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CE> getSourceEnds() {
		if (sourceEnds == null) {
			sourceEnds = new EObjectResolvingEList<CE>(ConnectionEnd.class, this, QVTschedulePackage.DATUM_CONNECTION__SOURCE_ENDS);
		}
		return sourceEnds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE:
				return getConnectionRole();
			case QVTschedulePackage.DATUM_CONNECTION__NAME:
				return getName();
			case QVTschedulePackage.DATUM_CONNECTION__SOURCE_ENDS:
				return getSourceEnds();
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
			case QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE:
				setConnectionRole((ConnectionRole)newValue);
				return;
			case QVTschedulePackage.DATUM_CONNECTION__NAME:
				setName((String)newValue);
				return;
			case QVTschedulePackage.DATUM_CONNECTION__SOURCE_ENDS:
				getSourceEnds().clear();
				getSourceEnds().addAll((Collection<? extends CE>)newValue);
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
			case QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE:
				setConnectionRole(CONNECTION_ROLE_EDEFAULT);
				return;
			case QVTschedulePackage.DATUM_CONNECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case QVTschedulePackage.DATUM_CONNECTION__SOURCE_ENDS:
				getSourceEnds().clear();
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
			case QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE:
				return connectionRole != CONNECTION_ROLE_EDEFAULT;
			case QVTschedulePackage.DATUM_CONNECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case QVTschedulePackage.DATUM_CONNECTION__SOURCE_ENDS:
				return sourceEnds != null && !sourceEnds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	protected final @NonNull Map<@NonNull CE, @NonNull ConnectionRole> targetEnd2role = new HashMap<>();

	/**
	 * The indexes in the overall schedule at which this connection propagates additional values.
	 */
	private final @NonNull List<@NonNull Integer> indexes = new ArrayList<>();

	@Override
	public boolean addIndex(int index) {
		for (int i = 0; i < indexes.size(); i++) {
			Integer anIndex = indexes.get(i);
			if (index == anIndex) {
				return false;
			}
			if (index < anIndex) {
				indexes.add(i, index);
				return true;
			}
		}
		indexes.add(index);
		return true;
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getConnectionRole().getColor());
		/*		if (isRegion2Region()) {
			String indexText = getIndexText();
			if (indexText != null) {
				s.setLabel(indexText);
			}
		} */
		String style = getConnectionRole().getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getConnectionRole().getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		s.setPenwidth(getConnectionRole().getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getName();
		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		}
		s.setLabel(name);
		s.setShape(getShape());
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		s.setColor(getConnectionRole().getColor());
		s.setPenwidth(getConnectionRole().getPenwidth());
		s.appendAttributedNode(nodeName);
	}

	@Override
	public void destroy() {
		setRegion(null);
	}

	/*	public @NonNull ConnectionRole getConnectionRole(@NonNull CE targetEnd) {
		ConnectionRoleEnum connectionRoleEnum = targetEnd2role.get(targetEnd);
		assert connectionRoleEnum != null;
		return connectionRoleEnum.getConnectionRole();
	} */

	public @Nullable String getIndexText() {
		StringBuilder s = null;
		for (@NonNull Integer index : indexes) {
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(",");
			}
			s.append(index.toString());
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull List<@NonNull Integer> getIndexes() {
		return indexes;
	}

	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public @NonNull GraphNode getEdgeSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CE getSource(@NonNull Region sourceRegion) {
		@Nullable CE sourceEnd = null;
		for (@NonNull CE end : QVTscheduleUtil.getSourceEnds(this)) {
			if (end.getRegion() == sourceRegion) {
				assert sourceEnd == null;
				sourceEnd = end;
			}
		}
		assert sourceEnd != null;
		return sourceEnd;
	}

	@Override
	public @NonNull String getSourceDisplayNames() {
		StringBuilder s = new StringBuilder();
		for (@NonNull CE source : QVTscheduleUtil.getSourceEnds(this)) {
			if (s.length() > 0) {
				s.append(",");
			}
			s.append(source.getDisplayName());
		}
		return s.toString();
	}

	@Override
	public @NonNull Set<@NonNull Region> getSourceRegions() {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(this)) {
			Region sourceRegion = QVTscheduleUtil.getRegion(sourceEnd);
			sourceRegions.add(sourceRegion);
		}
		return sourceRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> sourceRegions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(this)) {
			Region sourceRegion = QVTscheduleUtil.getRegion(sourceEnd);
			sourceRegion = scheduledRegion.getNormalizedRegion(sourceRegion);
			if (sourceRegion != null) {
				sourceRegions.add(sourceRegion);
			}
		}
		return sourceRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull CE> getSources() {
		return QVTscheduleUtil.getSourceEnds(this);
	}

	public @Nullable String getStyle() {
		return getConnectionRole().getStyle();
	}

	@Override
	public @NonNull String getSymbolName() {
		return QVTscheduleUtil.getName(this);
	}

	@Override
	public @NonNull GraphNode getEdgeTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CE getTarget(@NonNull Region targetRegion) {
		@Nullable CE targetEnd = null;
		for (@NonNull CE end : targetEnd2role.keySet()) {
			if (end.getRegion() == targetRegion) {
				assert targetEnd == null;
				targetEnd = end;
			}
		}
		assert targetEnd != null;
		return targetEnd;
	}

	@Override
	public @NonNull Set<@NonNull Region> getTargetRegions() {
		Set<@NonNull Region> targetRegions = new HashSet<>();
		for (@NonNull ConnectionEnd targetEnd : getTargets().keySet()) {
			Region targetRegion = QVTscheduleUtil.getRegion(targetEnd);
			targetRegions.add(targetRegion);
		}
		return targetRegions;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull ScheduledRegion scheduledRegion) {
		Set<@NonNull Region> targetRegions = new HashSet<>();
		for (@NonNull ConnectionEnd targetEnd : getTargets().keySet()) {
			Region targetRegion = QVTscheduleUtil.getRegion(targetEnd);
			targetRegion = scheduledRegion.getNormalizedRegion(targetRegion);
			if (targetRegion != null) {
				targetRegions.add(targetRegion);
			}
		}
		return targetRegions;
	}

	@Override
	public @NonNull Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> getTargets() {
		return targetEnd2role;
	}

	//	private boolean isRegion2Region() {
	//		return isRegion2Region(getSourceRegion2count());
	//	}

	@Override
	public boolean isRegion2Region(@NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
		return (sourceRegion2count.size() == 1) && (targetRegion2roles.size() == 1) && (targetRegion2roles.values().iterator().next().size() == 1); //(targetEnd2role.size() == 1);
	}

	protected void mergeRole(@NonNull ConnectionRole connectionRoleEnum) {
		//		assert connectionRole != null;
		if (getConnectionRole() == ConnectionRole.UNDEFINED) {
			setConnectionRole(connectionRoleEnum);
		}
		else if (getConnectionRole() != connectionRoleEnum) {
			setConnectionRole(getConnectionRole().merge(connectionRoleEnum));
		}
	}

	@Override
	public String toString() {
		return getSymbolName();
	}

	public String toString2() {
		StringBuilder s = new StringBuilder();
		ConnectionRole connectionRole = getConnectionRole();
		if (connectionRole != null) {
			s.append(connectionRole.getStereotype());
		}
		s.append(getName());
		s.append("(");
		boolean isFirst = true;
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(this)) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(sourceEnd.getDisplayName());
			isFirst = false;
		}
		s.append(" => ");
		isFirst = true;
		for (@NonNull ConnectionEnd targetEnd : targetEnd2role.keySet()) {
			if (!isFirst) {
				s.append(",");
			}
			ConnectionRole targetConnectionRole = targetEnd2role.get(targetEnd);
			assert targetConnectionRole != null;
			s.append(targetConnectionRole.getStereotype());
			s.append(targetEnd.getDisplayName());
			isFirst = false;
		}
		s.append(")");
		return s.toString();
	}

} //DatumConnectionImpl
