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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

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
	 * The cached value of the '{@link #getConnectionRole() <em>Connection Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRole()
	 * @generated
	 * @ordered
	 */
	protected ConnectionRole connectionRole;

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
		if (connectionRole != null && connectionRole.eIsProxy()) {
			InternalEObject oldConnectionRole = (InternalEObject)connectionRole;
			connectionRole = (ConnectionRole)eResolveProxy(oldConnectionRole);
			if (connectionRole != oldConnectionRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE, oldConnectionRole, connectionRole));
			}
		}
		return connectionRole;
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
				if (resolve) return getConnectionRole();
				return basicGetConnectionRole();
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
				setConnectionRole((ConnectionRole)null);
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
				return connectionRole != null;
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

	protected DatumConnectionImpl(@NonNull ScheduledRegion region, @NonNull Set<@NonNull CE> sourceEnds, @NonNull SymbolNameBuilder symbolNameBuilder) {
		setRegion(region);
		setName(region.getScheduleModel().reserveSymbolName(symbolNameBuilder, this));
		getSourceEnds().addAll(sourceEnds);
	}

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
		s.setColor(getColor());
		/*		if (isRegion2Region()) {
			String indexText = getIndexText();
			if (indexText != null) {
				s.setLabel(indexText);
			}
		} */
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
		s.setColor(getColor());
		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
	}

	protected @Nullable ConnectionRole basicGetConnectionRole() {
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
		connectionRole = newConnectionRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.DATUM_CONNECTION__CONNECTION_ROLE, oldConnectionRole, connectionRole));
	}

	@Override
	public void destroy() {
		setRegion(null);
	}

	@Override
	public String getArrowhead() {
		return getConnectionRole().getArrowhead();
	}

	@Override
	public @NonNull String getColor() {
		return getConnectionRole().getColor();
	}

	public @NonNull ConnectionRole getConnectionRole(@NonNull CE targetEnd) {
		ConnectionRole connectionRole = targetEnd2role.get(targetEnd);
		assert connectionRole != null;
		return connectionRole;
	}

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

	@Override
	public @NonNull String getLabel() {
		return QVTscheduleUtil.getName(this);
	}

	public @NonNull Integer getPenwidth() {
		Integer penwidth = getConnectionRole().getPenwidth();
		return /*connectionRole.isRealized() ? 2*penwidth :*/ penwidth;
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

	private boolean isRegion2Region(@NonNull Map<Region, Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles) {
		return (sourceRegion2count.size() == 1) && (targetRegion2roles.size() == 1) && (targetRegion2roles.values().iterator().next().size() == 1); //(targetEnd2role.size() == 1);
	}

	protected void mergeRole(@NonNull ConnectionRole connectionRole) {
		if (this.connectionRole == null) {
			this.connectionRole = connectionRole;
		}
		else if (this.connectionRole != connectionRole) {
			this.connectionRole = this.connectionRole.merge(connectionRole);
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.appendEdge(getEdgeSource(), this, getEdgeTarget());
	}

	@Override
	public void toRegionGraph(@NonNull ScheduledRegion scheduledRegion, @NonNull GraphStringBuilder s) {
		Map<@NonNull Region, @NonNull Integer> sourceRegion2count = new HashMap<>();
		for (@NonNull Node source : getSourceNodes()) {
			Region sourceRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getRegion(source));
			if (sourceRegion != null) {
				//				Integer count = sourceRegion2count.get(sourceRegion);
				sourceRegion2count.put(sourceRegion, 1); //(count != null ? count.intValue() : 0) + 1);
			}
		}
		Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles = new HashMap<>();
		for (@NonNull ConnectionEnd target : targetEnd2role.keySet()) {
			ConnectionRole role = targetEnd2role.get(target);
			assert role != null;
			Region targetRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getRegion(target));
			if (targetRegion != null) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				if (roles == null) {
					roles = new ArrayList<>();
					targetRegion2roles.put(targetRegion, roles);
				}
				if (!roles.contains(role)) {
					roles.add(role);
				}
			}
		}
		if (isRegion2Region(sourceRegion2count, targetRegion2roles)) {
			Region sourceRegion = sourceRegion2count.keySet().iterator().next();
			Region targetRegion = targetRegion2roles.keySet().iterator().next();
			s.appendEdge(sourceRegion, this, targetRegion);
		}
		else {
			s.appendNode(this);
			for (@NonNull Region sourceRegion : sourceRegion2count.keySet()) {
				Integer counts = sourceRegion2count.get(sourceRegion);
				assert counts != null;
				for (int i = counts; i > 0; i--) {
					s.appendEdge(sourceRegion, this, this);
				}
			}
			for (@NonNull Region targetRegion : targetRegion2roles.keySet()) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				assert roles != null;
				for (@NonNull ConnectionRole role : roles) {
					s.appendEdge(this, role, targetRegion);
					//				GraphNode targetNode = /*targetRegion.isCyclicRegion() ? getTarget(targetRegion) :*/ targetRegion;
					//				for (@SuppressWarnings("null")@NonNull ConnectionRole role : targetRegion2roles.get(targetRegion)) {
					//					s.appendEdge(this, role, targetNode);
				}
			}
			Node headNode = null;
			if (sourceRegion2count.size() == 0) {
				/*				@Nullable ConnectionEnd targetEnd = null;
				for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
					if (end.getRegion() == scheduledRegion) {
						assert targetEnd == null;
						targetEnd = end;
					}
				}
				if (targetEnd instanceof Node) {
					Node node = (Node)targetEnd;
					if (node.isHead()) {
						headNode = node;
						s.appendEdge(headNode, this, this);
					}
				} */
				@Nullable ConnectionEnd sourceEnd = null;
				for (@NonNull ConnectionEnd end : QVTscheduleUtil.getSourceEnds(this)) {
					if (end.getRegion() == scheduledRegion) {
						assert sourceEnd == null;
						sourceEnd = end;
					}
				}
				if (sourceEnd instanceof Node) {
					Node node = (Node)sourceEnd;
					if (node.isHead()) {
						headNode = node;
						s.appendEdge(headNode, this, this);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return getSymbolName();
	}

	public String toString2() {
		StringBuilder s = new StringBuilder();
		ConnectionRole connectionRole = basicGetConnectionRole();
		if (connectionRole != null) {
			s.append(connectionRole);
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
			s.append(targetConnectionRole);
			s.append(targetEnd.getDisplayName());
			isFirst = false;
		}
		s.append(")");
		return s.toString();
	}

} //DatumConnectionImpl
