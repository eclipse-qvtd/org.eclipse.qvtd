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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * @extends org.eclipse.ocl.pivot.utilities.Nameable
 * @extends GraphNode
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AbstractNode provides the analysis and status of a node in the pattern match or construction of a Mapping
 * or Composite Region.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster <em>Cluster</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole <em>Node Role</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getUtility <em>Utility</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends Element, ConnectionEnd, org.eclipse.ocl.pivot.utilities.Nameable, GraphNode
{
	/**
	 * Returns the value of the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Datum</em>' reference.
	 * @see #setClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_ClassDatum()
	 * @model required="true"
	 * @generated
	 */
	ClassDatum getClassDatum();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum <em>Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum</em>' reference.
	 * @see #getClassDatum()
	 * @generated
	 */
	void setClassDatum(ClassDatum value);

	/**
	 * Returns the value of the '<em><b>Cluster</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes <em>Member Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster</em>' reference.
	 * @see #setCluster(Cluster)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_Cluster()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes
	 * @model opposite="memberNodes"
	 * @generated
	 */
	Cluster getCluster();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster <em>Cluster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster</em>' reference.
	 * @see #getCluster()
	 * @generated
	 */
	void setCluster(Cluster value);

	/**
	 * Returns the value of the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Connection</em>' reference.
	 * @see #setIncomingConnection(NodeConnection)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_IncomingConnection()
	 * @model
	 * @generated
	 */
	NodeConnection getIncomingConnection();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Connection</em>' reference.
	 * @see #getIncomingConnection()
	 * @generated
	 */
	void setIncomingConnection(NodeConnection value);

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_IncomingEdges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode
	 * @model opposite="targetNode"
	 * @generated
	 */
	List<Edge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Node Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtschedule.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see #setNodeRole(Role)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_NodeRole()
	 * @model required="true"
	 * @generated NOT
	 */
	@NonNull Role getNodeRole();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole <em>Node Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Role</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see #getNodeRole()
	 * @generated
	 */
	void setNodeRole(Role value);

	/**
	 * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Connections</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_OutgoingConnections()
	 * @model
	 * @generated
	 */
	List<NodeConnection> getOutgoingConnections();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_OutgoingEdges()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode
	 * @model opposite="sourceNode"
	 * @generated
	 */
	List<Edge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Owning Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Region</em>' container reference.
	 * @see #setOwningRegion(Region)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_OwningRegion()
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes
	 * @model opposite="ownedNodes" required="true" transient="false"
	 * @generated
	 */
	@Override
	Region getOwningRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Region</em>' container reference.
	 * @see #getOwningRegion()
	 * @generated
	 */
	void setOwningRegion(Region value);

	/**
	 * Returns the value of the '<em><b>Utility</b></em>' attribute.
	 * The default value is <code>"NOT_KNOWN"</code>.
	 * The literals are from the enumeration {@link org.eclipse.qvtd.pivot.qvtschedule.Utility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utility</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Utility
	 * @see #setUtility(Utility)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_Utility()
	 * @model default="NOT_KNOWN" required="true"
	 * @generated NOT
	 */
	@NonNull Utility getUtility();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getUtility <em>Utility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utility</em>' attribute.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Utility
	 * @see #getUtility()
	 * @generated
	 */
	void setUtility(Utility value);

	/**
	 * Register element as a further expression that shares the value of the originating element of this node.
	 */
	void addOriginatingElement(@NonNull Element element);

	//	void addOutgoingConnection(@NonNull NodeConnection connection);

	/**
	 * Return the element from which this node originated. May be null for a synthetic node.
	 */
	@Nullable Element basicGetOriginatingElement();

	/**
	 * Return a variable that shares the value of the element from which this node originated. May be null.
	 */
	@Nullable VariableDeclaration basicGetOriginatingVariable();

	/**
	 * Create a new nodeRole node in region with the saem name, type etc as this node.
	 */
	@NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region);
	void destroy();

	/**
	 * Accumulate this node and all passed binding sources in the call-tree ancestry of this node.
	 * On completion there is exactly one entry per region from each possible call path.
	 */
	//	void getAllAncestors(@NonNull Set<@NonNull Node> ancestors);
	@NonNull Iterable<@NonNull CompleteClass> getCompleteClasses();
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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode_Name()
	 * @model required="true"
	 * @generated
	 */
	@Override
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	@Nullable NodeConnection getIncomingPassedConnection();
	//	@Nullable NodeConnection getIncomingUsedConnection();
	@NonNull String getLabel();
	@Nullable Node getNavigableTarget(@NonNull Property source2targetProperty);

	/**
	 * Return the element from which this node originated. Throws an IllegalStateException
	 * for a synthetic node that has no originating element.
	 */
	@NonNull Element getOriginatingElement();

	/**
	 * Return the element from which this node originated and also any variables and duplicates that
	 * share the same value. May be empty for a synthetic node.
	 */
	@NonNull Iterable<@NonNull Element> getOriginatingElements();

	@Nullable NavigableEdge getOutgoingNavigableEdge(@NonNull Property source2targetProperty);

	/**
	 * Get all sources that pass a value to this target.
	 */
	//	@NonNull Iterable<@NonNull Node> getPassedBindingSources();

	/**
	 * Get all targets that are passed a value from this source.
	 */
	//	@NonNull Iterable<@NonNull Node> getPassedBindingTargets();
	@Nullable Edge getOutgoingPredicateEdge(@NonNull Property source2targetProperty);
	//	@NonNull Iterable<@NonNull Node> getUsedBindingSources();
	@Nullable String getShape();
	@Nullable String getStyle();
	//	@NonNull Utility getUtility();

	void initialize(@NonNull Role nodeRole, @NonNull Region region, @NonNull Utility utility, /*@NonNull*/ String name, /*@NonNull*/ ClassDatum classDatum);

	/**
	 * Return true if this node is checked; i.e. isPredicated() or isSpeculated().
	 */
	boolean isChecked();

	/**
	 * Return true if this node is a Class object.
	 */
	boolean isClass();

	boolean isComposed();

	/**
	 * Return true if this node is a conditional part of a pattern.
	 */
	boolean isConditional();

	/**
	 * Return true if this node is a constant that can be computed at compile time.
	 *
	 * isConstant() is exclusive to isLoaded()/isSpeculation()/isSpeculated()/isPredicated()/isRealized()
	 */
	boolean isConstant();

	/**
	 * Return true if this node is a realized node with a corresponding relaized edge to a container.
	 */
	boolean isContained();

	/**
	 * Return true if this node is a DataType value.
	 */
	boolean isDataType();

	/**
	 * Return true if this node is a dependency; something from another region used by a computation for this node's region.
	 * A tree of dependency nodes and edges may provide an incoming edge for an operation to express the hidden computations of the operation.
	 */
	boolean isDependency();

	/**
	 * Return true if this is the predicated dispatcher for an overriding region.
	 *
	 * (The realized dispatcher in an invocation is not a predicated dispatcher.)
	 */
	boolean isDispatch();

	/**
	 * Return true if this node is an explicitly null value.
	 */
	boolean isNullLiteral();

	/**
	 * Return true if this node is part of an OCL expression; an iteration or operation other than
	 * oclAsType().
	 */
	boolean isExpression();

	/**
	 * Return true if this node is part of a head group from which many other nodes are navigable.
	 */
	boolean isHead();

	/**
	 * Return true if this node is a LoopExp iterator.
	 */
	boolean isIterator();

	/**
	 * Return true if this node is part of the checkable input domain and so may be loaded at will to satisfy
	 * the requirements of mapping execution.
	 *
	 * isLoaded() is exclusive to isConstant()/isPredicated()/isSpeculation()/isSpeculated()/isRealized()
	 */
	boolean isLoaded();

	/**
	 * Return true if this node is for a speculation/realized element.
	 */
	boolean isNew();

	/**
	 * Return true if this node is for a constant/loaded/predicated/speculated element.
	 */
	boolean isOld();

	boolean isOperation();

	/**
	 * Return true if this node is a pattern variable (class/datatype/null/true).
	 */
	boolean isPattern();

	/**
	 * Return true if the value of this node is part of the navigation path that must be validated
	 * by predicate matching prior to execution of a mapping.
	 *
	 * isPredicated() is exclusive to isConstant()/isLoaded()/isSpeculation()/isSpeculated()/isRealized()
	 */
	boolean isPredicated();

	/**
	 * Return true if this node has a primitive type and so should not be treated as a possible common sub-expression.
	 * null, boolean, string, integer, real and enum-literal are all primitive.
	 */
	boolean isPrimitive();

	/**
	 * Return true if the value of this node is determined by execution of a mapping.
	 *
	 * isRealized() is exclusive to isConstant()/isLoaded()/isSpeculation()/isSpeculated()/isPredicated()
	 */
	boolean isRealized();

	/**
	 * Return true if this is a required element, i.e. it has a TypedElement with a non-zero lower bound.
	 */
	boolean isRequired();

	/**
	 * Return true if this node is a speculated middle trace element that may havew benn created in anticipation
	 * of other dependencies.
	 *
	 * isSpeculated() is exclusive to isConstant()/isLoaded()/isSpeculation()/isPredicated()/isRealized()
	 */
	boolean isSpeculated();

	/**
	 * Return true if this node is a/the speculation of the realized middle trace element that is created in anticipation
	 * of other dependencies.
	 *
	 * isSpeculation() is exclusive to isConstant()/isLoaded()/isPredicated()/isSpeculated()/isPredicated()/isRealized()
	 */
	boolean isSpeculation();

	/**
	 * Return true if this is a SuccessNode that provides predication/speculation status.
	 */
	boolean isSuccess();

	/**
	 * Return true if this is realized node needs explicit enforcement of uniqueness.
	 */
	boolean isStrict();

	/**
	 * Return true if this is a "this" node.
	 *
	 */
	boolean isThis();

	/**
	 * Return true if this is a/the trace for a region.
	 *
	 * TBD. Multiple traces are allowed after region merging?
	 */
	boolean isTrace();

	/**
	 * Return true if this is a TrueNode that terminates a complex predicate expression.
	 */
	//	boolean isTrue();

	/**
	 * Return true if this node is an unconditional part of a pattern.
	 */
	boolean isUnconditional();

	//	void removeOutgoingConnection(@NonNull NodeConnection connection);

	/**
	 * Redesignate a head node as not-a-head, typically following a multi-headed split.
	 */
	void resetHead();

	void setContained(boolean isContained);

	/**
	 * Redesignate a guard node as a head.
	 */
	void setHead();

	/**
	 * Register variable as sharing the same value as the orginating element of this node..
	 */
	void setOriginatingVariable(@NonNull VariableDeclaration variable);

	/**
	 * Set isStrict true if this node is the realized node for a unique mapping invocation.
	 */
	void setStrict(boolean isStrict);

	/**
	 * Redesignate a guard node as a "this" head.
	 */
	void setThis();
} // Node
