/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * @generated
 */
public interface NodeConnection extends Connection
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
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNodeConnection_ClassDatum()
	 * @model required="true"
	 * @generated
	 */
	ClassDatum getClassDatum();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatum <em>Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum</em>' reference.
	 * @see #getClassDatum()
	 * @generated
	 */
	void setClassDatum(ClassDatum value);

	/**
	 * Returns the value of the '<em><b>Mandatory Target Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mandatory Target Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory Target Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNodeConnection_MandatoryTargetNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getMandatoryTargetNodes();
	/**
	 * Returns the value of the '<em><b>Passed Target Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passed Target Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passed Target Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNodeConnection_PassedTargetNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getPassedTargetNodes();
	/**
	 * Returns the value of the '<em><b>Preferred Target Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Target Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Target Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNodeConnection_PreferredTargetNodes()
	 * @model ordered="false"
	 * @generated
	 */
	List<Node> getPreferredTargetNodes();
	/**
	 * Return true if this connection is for an available value.
	 */
	boolean isUsed();

	void addPassedTargetNode(@NonNull Node targetNode);
	void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater);
	@Nullable Node basicGetSource(@NonNull Partition sourcePartition);
	@Override
	@NonNull Iterable<@NonNull ConnectionEnd> getSources(@NonNull Partition sourcePartition);
	@NonNull Type getSourcesType(@NonNull IdResolver idResolver);
	@Override
	@NonNull Set<@NonNull Node> getTargetNodes();
	boolean isNode2Node();
	boolean isUsed(@NonNull Node targetNode);
	@Nullable ConnectionRole putTargetRole(@NonNull Node targetNode, @NonNull ConnectionRole newConnectionRole);
	@Nullable ConnectionRole removeTarget(@NonNull Node targetNode);
	void setCommonPartition(@NonNull Partition commonPartition, @NonNull List<@NonNull Partition> intermediatePartitions);
}