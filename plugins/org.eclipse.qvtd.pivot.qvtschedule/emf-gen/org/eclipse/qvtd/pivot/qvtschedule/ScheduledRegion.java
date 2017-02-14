/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;

public interface ScheduledRegion extends Region
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!name'"
	 * @generated
	 */
	@Override
	String getName();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Region}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getInvokingRegion <em>Invoking Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getScheduledRegion_Regions()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getInvokingRegion
	 * @model opposite="invokingRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ScheduledRegion!regions'"
	 * @generated
	 */
	EList<Region> getRegions();
	void addEdgeConnection(@NonNull EdgeConnection edgeConnection);
	void addNodeConnection(@NonNull NodeConnection nodeConnection);
	@NonNull NodeConnection getAttributeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull CompleteClass owningClass, @NonNull Property property, @NonNull ClassDatumAnalysis classDatumAnalysis);
	@NonNull Iterable<@NonNull Region> getCallableRegions();
	@NonNull Collection<@NonNull Connection> getConnections();
	@NonNull EdgeConnection getEdgeConnection(@NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property);
	@NonNull Iterable<org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection> getEdgeConnections();
	@Nullable Iterable<@NonNull Node> getIntroducingOrNewNodes(@NonNull Node headNode);
	@Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatumAnalysis requiredClassDatumAnalysis);
	@Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatumAnalysis classDatumAnalysis);
	@NonNull NodeConnection getNodeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis);
	@NonNull Iterable<@NonNull NodeConnection> getNodeConnections();
	@Nullable Region getNormalizedRegion(@NonNull Region region);
	void removeConnection(@NonNull Connection connection);
	void replaceSources(@NonNull NodeConnection connection, @NonNull Set<@NonNull Node> obsoleteSourceNodes, @NonNull Node newSourceNode);
	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
}