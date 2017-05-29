/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTr2QVTc;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TransformationAnalysis accumulates the tesults of analyzing a RelationalTransformation and its contents.
 */
public class TransformationAnalysis
{
	/**
	 * The parent QVTr to QVTc transformation.
	 */
	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	/**
	 * The analyzed RelationalTransformation.
	 */
	protected final @NonNull RelationalTransformation transformation;
	//	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * Map from each relation to its analysis.
	 */
	private final @NonNull Map<@NonNull Relation, org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis> relation2relationAnalysis = new HashMap<>();

	public TransformationAnalysis(@NonNull QVTr2QVTc qvtr2qvtc, @NonNull RelationalTransformation rTransformation) {
		this.qvtr2qvtc = qvtr2qvtc;
		this.transformation = rTransformation;
		for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(rTransformation)) {
			relation2relationAnalysis.put(relation, new RelationAnalysis(this, relation));
		}
	}

	public void analyze() {
		for (RelationAnalysis relationAnalysis : relation2relationAnalysis.values()) {
			relationAnalysis.analyze();
		}
	}

	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return qvtr2qvtc.getRelationalTransformation2TracePackage();
	}

	public @NonNull RelationAnalysis getRelationAnalysis(@NonNull Relation relation) {
		RelationAnalysis relationAnalysis = relation2relationAnalysis.get(relation);
		if (relationAnalysis != null) {
			return relationAnalysis;
		}
		TransformationAnalysis transformationAnalysis = qvtr2qvtc.getTransformationAnalysis(QVTrelationUtil.getContainingTransformation(relation));
		if (transformationAnalysis != this) {
			return transformationAnalysis.getRelationAnalysis(relation);
		}
		throw new IllegalStateException("No RelationAnalysis for '" + relation + "'");
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
