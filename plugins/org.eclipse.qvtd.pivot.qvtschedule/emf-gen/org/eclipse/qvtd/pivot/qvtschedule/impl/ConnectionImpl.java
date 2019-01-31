/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getSymbolName <em>Symbol Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getOwningRootRegion <em>Owning Root Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getConnectionRole <em>Connection Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getSourceEnds <em>Source Ends</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getIntermediatePartitions <em>Intermediate Partitions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl#getCommonPartition <em>Common Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConnectionImpl extends ElementImpl implements Connection {
	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FEATURE_COUNT = ElementImpl.ELEMENT_FEATURE_COUNT + 7;
	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_OPERATION_COUNT = ElementImpl.ELEMENT_OPERATION_COUNT + 0;
	/**
	 * The default value of the '{@link #getSymbolName() <em>Symbol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSymbolName() <em>Symbol Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolName()
	 * @generated
	 * @ordered
	 */
	protected String symbolName = SYMBOL_NAME_EDEFAULT;

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
	protected EList<ConnectionEnd> sourceEnds;

	/**
	 * The cached value of the '{@link #getIntermediatePartitions() <em>Intermediate Partitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediatePartitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Partition> intermediatePartitions;
	/**
	 * The cached value of the '{@link #getCommonPartition() <em>Common Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonPartition()
	 * @generated
	 * @ordered
	 */
	protected Partition commonPartition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymbolName(String newSymbolName) {
		String oldSymbolName = symbolName;
		symbolName = newSymbolName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 0, oldSymbolName, symbolName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootRegion getOwningRootRegion() {
		if (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 1)) return null;
		return (RootRegion)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRootRegion(RootRegion newOwningRootRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRootRegion, ElementImpl.ELEMENT_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRootRegion(RootRegion newOwningRootRegion) {
		if (newOwningRootRegion != eInternalContainer() || (eContainerFeatureID() != (ElementImpl.ELEMENT_FEATURE_COUNT + 1) && newOwningRootRegion != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRootRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRootRegion != null)
				msgs = ((InternalEObject)newOwningRootRegion).eInverseAdd(this, RegionImpl.REGION_FEATURE_COUNT + 1, RootRegion.class, msgs);
			msgs = basicSetOwningRootRegion(newOwningRootRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 1, newOwningRootRegion, newOwningRootRegion));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 2, oldConnectionRole, connectionRole));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 3, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<ConnectionEnd> getSourceEnds() {
		if (sourceEnds == null) {
			sourceEnds = new EObjectResolvingEList<ConnectionEnd>(ConnectionEnd.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 4);
		}
		return sourceEnds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<Partition> getIntermediatePartitions() {
		if (intermediatePartitions == null) {
			intermediatePartitions = new EObjectResolvingEList<Partition>(Partition.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 5);
		}
		return intermediatePartitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Partition getCommonPartition() {
		if (commonPartition != null && commonPartition.eIsProxy()) {
			InternalEObject oldCommonPartition = (InternalEObject)commonPartition;
			commonPartition = (Partition)eResolveProxy(oldCommonPartition);
			if (commonPartition != oldCommonPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldCommonPartition, commonPartition));
			}
		}
		return commonPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partition basicGetCommonPartition() {
		return commonPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommonPartition(Partition newCommonPartition) {
		Partition oldCommonPartition = commonPartition;
		commonPartition = newCommonPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldCommonPartition, commonPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRootRegion((RootRegion)otherEnd, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return basicSetOwningRootRegion(null, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, RegionImpl.REGION_FEATURE_COUNT + 1, RootRegion.class, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return getSymbolName();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return getOwningRootRegion();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return getConnectionRole();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return getName();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return getSourceEnds();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return getIntermediatePartitions();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				if (resolve) return getCommonPartition();
				return basicGetCommonPartition();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setSymbolName((String)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setOwningRootRegion((RootRegion)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setConnectionRole((ConnectionRole)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setName((String)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				getSourceEnds().clear();
				getSourceEnds().addAll((Collection<? extends ConnectionEnd>)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				getIntermediatePartitions().clear();
				getIntermediatePartitions().addAll((Collection<? extends Partition>)newValue);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setCommonPartition((Partition)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				setSymbolName(SYMBOL_NAME_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				setOwningRootRegion((RootRegion)null);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				setConnectionRole(CONNECTION_ROLE_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				setName(NAME_EDEFAULT);
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				getSourceEnds().clear();
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				getIntermediatePartitions().clear();
				return;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setCommonPartition((Partition)null);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return SYMBOL_NAME_EDEFAULT == null ? symbolName != null : !SYMBOL_NAME_EDEFAULT.equals(symbolName);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 1:
				return getOwningRootRegion() != null;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 2:
				return connectionRole != CONNECTION_ROLE_EDEFAULT;
			case ElementImpl.ELEMENT_FEATURE_COUNT + 3:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ElementImpl.ELEMENT_FEATURE_COUNT + 4:
				return sourceEnds != null && !sourceEnds.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 5:
				return intermediatePartitions != null && !intermediatePartitions.isEmpty();
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return commonPartition != null;
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
		if (baseClass == Symbolable.class) {
			switch (derivedFeatureID) {
				case ElementImpl.ELEMENT_FEATURE_COUNT + 0: return 0;
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
		if (baseClass == Symbolable.class) {
			switch (baseFeatureID) {
				case 0: return ElementImpl.ELEMENT_FEATURE_COUNT + 0;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}


	/**
	 * The indexes in the overall schedule at which this connection propagates additional values.
	 */
	private final @NonNull List<@NonNull Integer> passes = new ArrayList<>();

	@Override
	public boolean addPass(int pass) {
		for (int i = 0; i < passes.size(); i++) {
			Integer aPass = passes.get(i);
			if (pass == aPass) {
				return false;
			}
			if (pass < aPass) {
				passes.add(i, pass);
				return true;
			}
		}
		passes.add(pass);
		return true;
	}

	@Override
	public void appendEdgeAttributes(@NonNull ToGraphHelper toGraphHelper, @NonNull String sourceName, @NonNull String targetName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		toGraphHelper.setColor(this);
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
		s.appendAttributedEdge(sourceName, this, targetName);
	}

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
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
		toGraphHelper.setColor(this);
		s.setPenwidth(getConnectionRole().getPenwidth());
		s.appendAttributedNode(nodeName);
	}

	@Override
	public void destroy() {
		setCommonPartition(null);
		getIntermediatePartitions().clear();
		getSourceEnds().clear();
		setOwningRootRegion(null);
	}

	@Override
	public @NonNull String getColor() {
		return getConnectionRole().getColor();
	}

	@Override
	public int getFirstPass() {
		return passes.get(0);
	}

	public @Nullable String getIndexText() {
		StringBuilder s = null;
		for (@NonNull Integer index : passes) {
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
	public int getLastPass() {
		return passes.get(passes.size()-1);
	}

	@Override
	public @NonNull List<@NonNull Integer> getPasses() {
		return passes;
	}

	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public @NonNull GraphNode getEdgeSource() {
		throw new UnsupportedOperationException();
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
	public String toString() {
		return getSymbolName();
	}

	@Override
	public @NonNull ConnectionEnd getSource(@NonNull Partition sourcePartition) {
		@Nullable ConnectionEnd theSourceEnd = null;
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(this)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			Iterable<@NonNull MappingPartition> sourceRegionPartitions = QVTscheduleUtil.getRegionPartitions(sourceRegion);
			if (Iterables.contains(sourceRegionPartitions, sourcePartition)) {
				Role sourceRole = QVTscheduleUtil.getRole(sourcePartition, sourceEnd);
				if ((sourceRole != null) && !sourceRole.isChecked()) { //(sourceRole.isNew() || sourceRole.isLoaded())) {
					assert theSourceEnd == null;
					theSourceEnd = sourceEnd;
				}
			}
		}
		assert theSourceEnd != null;
		return theSourceEnd;
	}

	@Override
	public @NonNull Iterable<@NonNull Partition> getSourcePartitions() {
		Set<@NonNull Partition> sourcePartitions = new HashSet<>();
		for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(this)) {
			Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
			Iterable<@NonNull MappingPartition> sourceRegionPartitions = QVTscheduleUtil.getRegionPartitions(sourceRegion);
			for (@NonNull MappingPartition sourcePartition : sourceRegionPartitions) {
				if (QVTscheduleUtil.getMergedPartition(sourcePartition) == sourcePartition) {
					Role sourceRole = QVTscheduleUtil.getRole(sourcePartition, sourceEnd);
					if ((sourceRole != null) && !sourceRole.isChecked()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
						sourcePartitions.add(sourcePartition);
					}
				}
			}
		}
		return sourcePartitions;
	}

	@Override
	public @NonNull Iterable<@NonNull ConnectionEnd> getTargetConnectionEnds(@NonNull Partition targetPartition) {
		List<@NonNull ConnectionEnd> targetConnectionEnds = new ArrayList<>();
		for (@NonNull ConnectionEnd targetConnectionEnd : getTargetEnds()) {
			//	Region region = QVTscheduleUtil.getOwningRegion(targetConnectionEnd);
			//	RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
			//	Iterable<@NonNull Partition> partitions = regionAnalysis.getPartitions();
			//	for (@NonNull Partition partition : partitions) {
			Role role = QVTscheduleUtil.getRole(targetPartition, targetConnectionEnd);
			if ((role != null) && role.isOld()) {
				targetConnectionEnds.add(targetConnectionEnd);
			}
			//	}
		}
		return targetConnectionEnds;
	}

	@Override
	public @NonNull ConnectionRole getTargetConnectionRole(@NonNull Partition targetPartition, @NonNull ConnectionEnd connectionEnd) {
		ConnectionRole connectionRole = getTargetRole(connectionEnd);
		assert connectionRole != null;
		if (connectionRole.isPassed()) {
			boolean isHead = targetPartition.isHead(connectionEnd);
			if (!isHead) {
				connectionRole = ConnectionRole.PREFERRED_NODE;
			}
		}
		return connectionRole;
	}

	@Override
	public @NonNull Iterable<@NonNull Partition> getTargetPartitions() {
		List<@NonNull Partition> targetPartitions = new ArrayList<>();
		for (@NonNull ConnectionEnd target : getTargetEnds()) {
			Region region = QVTscheduleUtil.getOwningRegion(target);
			Iterable<@NonNull MappingPartition> partitions = QVTscheduleUtil.getRegionPartitions(region);
			for (@NonNull MappingPartition targetPartition : partitions) {
				if (QVTscheduleUtil.getMergedPartition(targetPartition) == targetPartition) {
					Role role = QVTscheduleUtil.getRole(targetPartition, target);
					if ((role != null) && role.isOld() && !targetPartitions.contains(targetPartition)) {
						boolean skipPartionedHead = false;
						if (target instanceof Node) {
							if (((Node)target).isHead() && !targetPartition.isHead(target)) {
								skipPartionedHead = true;
							}
						}
						if (!skipPartionedHead) {
							targetPartitions.add(targetPartition);
						}
					}
				}
			}
		}
		return targetPartitions;
	}

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
} //ConnectionImpl
