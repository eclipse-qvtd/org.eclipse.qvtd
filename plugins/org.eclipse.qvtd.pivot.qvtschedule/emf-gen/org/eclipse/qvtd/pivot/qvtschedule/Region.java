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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion()
 * @model abstract="true" superTypes="org.eclipse.ocl.pivot.Element org.eclipse.qvtd.pivot.qvtschedule.GraphNode org.eclipse.ocl.pivot.Nameable org.eclipse.qvtd.pivot.qvtschedule.Symbolable org.eclipse.qvtd.pivot.qvtschedule.ToDOTable"
 * @generated
 */
public interface Region extends Element, GraphNode, Nameable, Symbolable, ToDOTable
{
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_Edges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getRegion
	 * @model opposite="region" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!edges'"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_Nodes()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getRegion
	 * @model opposite="region" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!nodes'"
	 * @generated
	 */
	EList<Node> getNodes();

	void addCallToChild(@NonNull Region region);
	void addEnforcedEdge(@NonNull NavigableEdge realizedEdge);
	boolean addIndex(int index);
	void addIntermediateConnection(@NonNull NodeConnection connection);
	void addRootConnection(@NonNull NodeConnection connection);
	void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node);
	void buildPredicatedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges);
	void buildRealizedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges);
	void checkIncomingConnections();
	void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges);
	void createIncomingConnections();

	/**
	 * Return all the nodes in this region that are call-tree ancestors of node.
	 */
	@NonNull Iterable<@NonNull Node> getAncestorsOf(@NonNull Node node);

	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<@NonNull Region> getCallableChildren();

	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<@NonNull Region> getCallableParents();

	/**
	 * Return the regions that this region calls.
	 */
	@NonNull Iterable<@NonNull Region> getCalledRegions();

	/**
	 * Return the regions the call this region.
	 */
	@NonNull Iterable<@NonNull Region> getCallingRegions();
	@Nullable Iterable<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel);
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement);
	@NonNull String getColor();
	@NonNull Iterable<@NonNull Node> getComposedNodes();
	@Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel);
	@NonNull Iterable<@NonNull Edge> getExpressionEdges();

	/**
	 * The schedule index at which the latest dependent becomes available and consequently the latest that deferred execution may occur.
	 */
	int getFinalExecutionIndex();
	int getFirstIndex();

	@NonNull List<@NonNull Node> getHeadNodes();
	@NonNull Iterable<@NonNull DatumConnection<?>> getIncomingConnections();
	@NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections();
	@NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections();
	@NonNull List<@NonNull NodeConnection> getIntermediateConnections();
	@NonNull String getIndexRangeText();
	@NonNull List<@NonNull Integer> getIndexes();

	/**
	 * The schedule index at which ALL invocations of this region occur.
	 */
	int getInvocationIndex();
	@Nullable ScheduledRegion getInvokingRegion();
	int getLastIndex();
	@NonNull List<@NonNull DatumConnection<?>> getLoopingConnections();
	@NonNull MultiRegion getMultiRegion();
	@Override
	@NonNull String getName();
	/**
	 * Return the nodes that are navigated by navigation from the region's guards.
	 */
	@NonNull Iterable<@NonNull Node> getNavigableNodes();
	@NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges();

	/**
	 * Return all nodes created by this region. i.e. Speculation or Realized nodes.
	 */
	@NonNull Iterable<@NonNull Node> getNewNodes();

	/**
	 * Return all the next connections from this region to another region.
	 * Where this is a hierarchical region the connections are those from the hierarchical head to its immediate internal regions.
	 */
	@NonNull Iterable<@NonNull DatumConnection<?>> getNextConnections();

	/**
	 * Return all nodes referenced by this region. i.e. Constant, Loaded, Predicated, Speculated nodes.
	 */
	@NonNull Iterable<@NonNull Node> getOldNodes();

	/**
	 * Return all connections from this (hierarchical) region to another (hierarchical) region.
	 */
	@NonNull Iterable<@NonNull DatumConnection<?>> getOutgoingConnections();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections();
	@NonNull Iterable<@NonNull Node> getPatternNodes();
	@NonNull Iterable<@NonNull NavigableEdge> getPredicatedNavigationEdges();
	@NonNull Iterable<@NonNull Edge> getRealizedEdges();
	@NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges();
	@NonNull Iterable<@NonNull Edge> getRecursionEdges();
	@NonNull List<@NonNull NodeConnection> getRootConnections();
	@NonNull SchedulerConstants getSchedulerConstants();
	@Nullable String getShape();
	@Nullable String getStyle();
	@NonNull Iterable<@NonNull Node> getTrueNodes();

	/**
	 * Return the regions that this region uses and how many times.
	 */
	@NonNull List<@NonNull NodeConnection> getUsedConnections();
	boolean isChildCompositionRegion();
	boolean isOperationRegion();
	boolean isRootCompositionRegion();
	void refineBindings(@NonNull Region bindingRegion);
	void removeCallToChild(@NonNull Region region);
	void replaceCallToChild(@NonNull Region oldRegion, @NonNull Region newRegion);
	void resetHead(@NonNull Node headNode);
	void setInvokingRegion(@NonNull ScheduledRegion invokingRegion);
	void toCallGraph(@NonNull GraphStringBuilder s);
	//	void toGraph(@NonNull GraphStringBuilder s);
	void toRegionGraph(@NonNull GraphStringBuilder s);
	void writeDebugGraphs(@Nullable String context);
} // Region
