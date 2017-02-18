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
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * @extends ToDOTable, GraphNode
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges <em>Owned Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes <em>Owned Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion <em>Owning Scheduled Region</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion()
 * @model abstract="true" superTypes="org.eclipse.ocl.pivot.Element org.eclipse.ocl.pivot.Nameable org.eclipse.qvtd.pivot.qvtschedule.Symbolable"
 * @generated
 */
public interface Region extends Element, Nameable, Symbolable, ToDOTable, GraphNode
{
	/**
	 * Returns the value of the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Scheduled Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #setOwningScheduledRegion(ScheduledRegion)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwningScheduledRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRegions
	 * @model opposite="ownedRegions" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!owningScheduledRegion'"
	 * @generated
	 */
	ScheduledRegion getOwningScheduledRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion <em>Owning Scheduled Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Scheduled Region</em>' container reference.
	 * @see #getOwningScheduledRegion()
	 * @generated
	 */
	void setOwningScheduledRegion(ScheduledRegion value);

	/**
	 * Returns the value of the '<em><b>Owned Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Edges</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwnedEdges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion
	 * @model opposite="owningRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!ownedEdges'"
	 * @generated
	 */
	EList<Edge> getOwnedEdges();

	/**
	 * Returns the value of the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getRegion_OwnedNodes()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion
	 * @model opposite="owningRegion" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!Region!ownedNodes'"
	 * @generated
	 */
	EList<Node> getOwnedNodes();

	void addCallToChild(@NonNull Region region);
	boolean addIndex(int index);
	void addIntermediateConnection(@NonNull NodeConnection connection);
	void addRootConnection(@NonNull NodeConnection connection);
	void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node);

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
	@NonNull String getColor();
	@NonNull Iterable<@NonNull Node> getComposedNodes();
	@NonNull Iterable<@NonNull Edge> getExpressionEdges();

	/**
	 * The schedule index at which the latest dependent becomes available and consequently the latest that deferred execution may occur.
	 */
	int getFinalExecutionIndex();
	int getFirstIndex();

	List<Node> getHeadNodes();
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
	int getLastIndex();
	@NonNull List<@NonNull DatumConnection<?>> getLoopingConnections();
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
	ScheduleModel getScheduleModel();
	@Nullable String getShape();
	@Nullable String getStyle();
	@NonNull Iterable<@NonNull Node> getTrueNodes();

	/**
	 * Return the regions that this region uses and how many times.
	 */
	@NonNull List<@NonNull NodeConnection> getUsedConnections();
	boolean isLoadingRegion();
	boolean isOperationRegion();
	void removeCallToChild(@NonNull Region region);
	void replaceCallToChild(@NonNull Region oldRegion, @NonNull Region newRegion);
	void resetHead(@NonNull Node headNode);
} // Region
