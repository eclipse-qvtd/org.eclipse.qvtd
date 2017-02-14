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

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * @generated
 */
public interface NodeConnection extends DatumConnection<Node>
{
	/**
	 * Returns the value of the '<em><b>Class Datum Analysis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Datum Analysis</em>' reference.
	 * @see #setClassDatumAnalysis(ClassDatumAnalysis)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNodeConnection_ClassDatumAnalysis()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!NodeConnection!classDatumAnalysis'"
	 * @generated
	 */
	ClassDatumAnalysis getClassDatumAnalysis();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatumAnalysis <em>Class Datum Analysis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum Analysis</em>' reference.
	 * @see #getClassDatumAnalysis()
	 * @generated
	 */
	void setClassDatumAnalysis(ClassDatumAnalysis value);
	void addPassedTargetNode(@NonNull Node targetNode);
	//	void addSubConnection(@NonNull Connection subConnection);
	void addUsedTargetNode(@NonNull Node targetNode, boolean mustBeLater);
	@Nullable Node basicGetSource(@NonNull Region sourceRegion);
	//	@Nullable Connection basicGetSuperConnection();

	@Nullable Region getCommonRegion();
	@NonNull ConnectionRole getConnectionRole(@NonNull Node targetNode);

	@NonNull List<@NonNull Region> getIntermediateRegions();
	@Override
	@NonNull Node getSource(@NonNull Region sourceRegion);
	@Override
	@NonNull Iterable<@NonNull Node> getSources();

	@NonNull Type getSourcesType(@NonNull IdResolver idResolver);

	@Override
	@NonNull Node getTarget(@NonNull Region targetRegion);
	@Override
	@NonNull Map<@NonNull Node, @NonNull ConnectionRole> getTargets();

	/**
	 * Return true if this connection is for an available value.
	 */
	boolean isUsed();
	boolean isUsed(@NonNull Node targetNode);

	void removeSource(@NonNull Node sourceNode);
	void removeTarget(@NonNull Node targetNode);

	/**
	 * Configure the region from which all consumers of this connection can be called and any intermediteRegions that must propagate this connection.
	 */
	void setCommonRegion(@NonNull Region commonRegion, @NonNull List<@NonNull Region> intermediateRegions);
}