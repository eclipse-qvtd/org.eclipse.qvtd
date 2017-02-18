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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Connection Role Enum</b></em>',
 * and utility methods for working with them.
 * @extends GraphStringBuilder.GraphEdge
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnectionRole()
 * @model
 * @generated
 */
public enum ConnectionRole implements Enumerator, GraphStringBuilder.GraphEdge {
	/**
	 * The '<em><b>MANDATORY EDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY_EDGE_VALUE
	 * @generated
	 * @ordered
	 */
	MANDATORY_EDGE(0, "MANDATORY_EDGE", "MANDATORY_EDGE"),

	/**
	 * The '<em><b>MANDATORY NODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	MANDATORY_NODE(1, "MANDATORY_NODE", "MANDATORY_NODE"),

	/**
	 * The '<em><b>PASSED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSED_VALUE
	 * @generated
	 * @ordered
	 */
	PASSED(2, "PASSED", "PASSED"),

	/**
	 * The '<em><b>PREFERRED EDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFERRED_EDGE_VALUE
	 * @generated
	 * @ordered
	 */
	PREFERRED_EDGE(3, "PREFERRED_EDGE", "PREFERRED_EDGE"),

	/**
	 * The '<em><b>PREFERRED NODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFERRED_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	PREFERRED_NODE(4, "PREFERRED_NODE", "PREFERRED_NODE"), /**
	 * The '<em><b>UNDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(5, "UNDEFINED", "UNDEFINED");

	/**
	 * The '<em><b>MANDATORY EDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANDATORY EDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MANDATORY_EDGE connection 'passes' a used input edge that must be fully computed before use. This is typically for a
	 * collection, since it is not possible to determine when a last partial addition is the last, therefore all
	 * additions must occur before any access.
	 * <!-- end-model-doc -->
	 * @see #MANDATORY_EDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANDATORY_EDGE_VALUE = 0;

	/**
	 * The '<em><b>MANDATORY NODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MANDATORY NODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A MANDATORY_NODE connection 'passes' a used input node that must be fully computed before use. This is typically for a
	 * collection, since it is not possible to determine when a last partial addition is the last, therefore all
	 * additions must occur before any access.
	 * <!-- end-model-doc -->
	 * @see #MANDATORY_NODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANDATORY_NODE_VALUE = 1;

	/**
	 * The '<em><b>PASSED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PASSED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A PASSED connection passes a required input. This is typically from an introducer/producer/join to
	 * a consumer's head. A value must actually be passed by the call.
	 * <!-- end-model-doc -->
	 * @see #PASSED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASSED_VALUE = 2;

	/**
	 * The '<em><b>PREFERRED EDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PREFERRED EDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A PREFERRED_EDGE connection 'passes' a used input edge that is beneficially but not necessarily computed before use.
	 * If not computed before use, run-time overheads are incurred to defer reads until writes have occurred.
	 * <!-- end-model-doc -->
	 * @see #PREFERRED_EDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREFERRED_EDGE_VALUE = 3;

	/**
	 * The '<em><b>PREFERRED NODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PREFERRED NODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A PREFERRED_NODE connection 'passes' a used input node that is beneficially but not necessarily computed before use.
	 * If not computed before use, run-time overheads are incurred to defer reads until writes have occurred.
	 * <!-- end-model-doc -->
	 * @see #PREFERRED_NODE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREFERRED_NODE_VALUE = 4;

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An UNDEFINED connection is the intial state of a connection that evolves by merging.
	 * <!-- end-model-doc -->
	 * @see #UNDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 5;

	/**
	 * An array of all the '<em><b>Connection Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConnectionRole[] VALUES_ARRAY =
			new ConnectionRole[] {
			MANDATORY_EDGE,
			MANDATORY_NODE,
			PASSED,
			PREFERRED_EDGE,
			PREFERRED_NODE,
			UNDEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>Connection Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConnectionRole> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionRole get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionRole getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ConnectionRole get(int value) {
		switch (value) {
			case MANDATORY_EDGE_VALUE: return MANDATORY_EDGE;
			case MANDATORY_NODE_VALUE: return MANDATORY_NODE;
			case PASSED_VALUE: return PASSED;
			case PREFERRED_EDGE_VALUE: return PREFERRED_EDGE;
			case PREFERRED_NODE_VALUE: return PREFERRED_NODE;
			case UNDEFINED_VALUE: return UNDEFINED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConnectionRole(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

	public @Nullable String getArrowhead() {
		return null;
	}

	public @NonNull String getColor() {
		switch (this) {
			case MANDATORY_EDGE: return QVTscheduleConstants.ORDERING_COLOR;
			case MANDATORY_NODE: return QVTscheduleConstants.BINDING_COLOR;
			case PASSED: return QVTscheduleConstants.BINDING_COLOR;
			case PREFERRED_EDGE: return QVTscheduleConstants.ORDERING_COLOR;
			case PREFERRED_NODE: return QVTscheduleConstants.BINDING_COLOR;
		}
		throw new UnsupportedOperationException();
	}

	public @Nullable String getLabel() {
		return null;
	}

	public @NonNull Integer getPenwidth() {
		return QVTscheduleConstants.LINE_WIDTH;
	}

	public @NonNull String getStereotype() {
		switch (this) {
			case MANDATORY_EDGE: return "«mandatory»";
			case MANDATORY_NODE: return "«mandatory»";
			case PASSED: return "«passed»";
			case PREFERRED_EDGE: return "«preferred»";
			case PREFERRED_NODE: return "«preferred»";
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * Return the line style with which this connection is drawn, null for solid.
	 */
	public @Nullable String getStyle() {
		switch (this) {
			case MANDATORY_EDGE: return "dashed";
			case MANDATORY_NODE: return "dashed";
			case PASSED: return null;
			case PREFERRED_EDGE: return "dotted";
			case PREFERRED_NODE: return "dotted";
		}
		throw new UnsupportedOperationException();
	}

	public boolean isMandatory() {
		switch (this) {
			case MANDATORY_EDGE: return true;
			case MANDATORY_NODE: return true;
			case PASSED: return false;
			case PREFERRED_EDGE: return false;
			case PREFERRED_NODE: return false;
			case UNDEFINED: return false;
		}
		throw new UnsupportedOperationException();
	}

	public boolean isPassed() {
		switch (this) {
			case MANDATORY_EDGE: return false;
			case MANDATORY_NODE: return false;
			case PASSED: return true;
			case PREFERRED_EDGE: return false;
			case PREFERRED_NODE: return false;
			case UNDEFINED: return false;
		}
		throw new UnsupportedOperationException();
	}

	public boolean isPreferred() {
		switch (this) {
			case MANDATORY_EDGE: return true;
			case MANDATORY_NODE: return true;
			case PASSED: return false;
			case PREFERRED_EDGE: return true;
			case PREFERRED_NODE: return true;
			case UNDEFINED: return false;
		}
		throw new UnsupportedOperationException();
	}

	public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRoleEnum) {
		switch (this) {
			case MANDATORY_EDGE:
			case MANDATORY_NODE:{
				if (connectionRoleEnum.isPassed()) {
					return connectionRoleEnum;
				}
				if (connectionRoleEnum.isPreferred()) {
					return this;
				}
				break;
			}
			case PASSED: {
				if (connectionRoleEnum.isMandatory()) {
					return this;
				}
				if (connectionRoleEnum.isPreferred()) {
					return this;
				}
				break;
			}
			case PREFERRED_EDGE:
			case PREFERRED_NODE: {
				if (connectionRoleEnum.isPassed()) {
					return connectionRoleEnum;
				}
				if (connectionRoleEnum.isMandatory()) {
					return connectionRoleEnum;
				}
				break;
			}
			case UNDEFINED: {
				return connectionRoleEnum;
			}
		}
		throw new UnsupportedOperationException();
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
	public @NonNull GraphNode getEdgeSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull GraphNode getEdgeTarget() {
		throw new UnsupportedOperationException();
	}
} //ConnectionRoleEnum
