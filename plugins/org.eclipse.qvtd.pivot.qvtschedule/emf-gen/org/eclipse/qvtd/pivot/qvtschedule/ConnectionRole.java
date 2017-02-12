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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Role</b></em>'.
 * @extends GraphStringBuilder.GraphEdge
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConnectionRole defines which of many possible roles a connection plays
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole#isNode <em>Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnectionRole()
 * @model abstract="true"
 * @generated
 */
public interface ConnectionRole extends Element, GraphStringBuilder.GraphEdge
{
	/**
	 * Returns the value of the '<em><b>Node</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' attribute.
	 * @see #setNode(boolean)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnectionRole_Node()
	 * @model default="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ConnectionRole!node'"
	 * @generated
	 */
	boolean isNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole#isNode <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' attribute.
	 * @see #isNode()
	 * @generated
	 */
	void setNode(boolean value);

	@Nullable String getArrowhead();

	@NonNull String getColor();

	/**
	 * Return a label for the connection, null for none.
	 */
	@Nullable String getLabel();

	/**
	 * Return the pen width with which this connection is drawn.
	 */
	@NonNull Integer getPenwidth();

	/**
	 * Return the line style with which this connection is drawn, null for solid.
	 */
	@Nullable String getStyle();

	boolean isMandatory();
	boolean isPassed();
	boolean isPreferred();

	@NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole);
} // ConnectionRole
