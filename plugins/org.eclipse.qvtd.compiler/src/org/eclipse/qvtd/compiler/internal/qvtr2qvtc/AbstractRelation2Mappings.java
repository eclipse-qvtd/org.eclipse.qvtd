/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * AbstractRelation2Mappings providides abstract support for conversion of a relation.
 */
/*public*/ abstract class AbstractRelation2Mappings extends QVTcoreHelper implements Relation2Mappings
{
	/**
	 * The parent transformation
	 */
	protected @NonNull final RelationalTransformation2CoreTransformation relationalTransformation2coreTransformation;
	protected @NonNull final RelationalTransformation2TracePackage relationalTransformation2tracePackage;
	protected @NonNull final QVTr2QVTc qvtr2qvtc;
	// Relations
	/**
	 * r: The relation being transformed
	 */
	protected final @NonNull RelationAnalysis relationAnalysis;
	protected final @NonNull Relation rRelation;
	/**
	 * The transformation containing the rRelation. i.e. rRelation.getOwningTransformation()
	 */
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull RelationalTransformation rTransformation;
	/**
	 * The name of the rRelation. i.e. rRelation.getName()
	 */
	protected final @NonNull String rRelationName;

	// Core
	/**
	 * mt: The transformation containing the result mapping
	 */
	protected final @NonNull Transformation cTransformation;

	public AbstractRelation2Mappings(@NonNull RelationalTransformation2CoreTransformation relationalTransformation2coreTransformation, @NonNull RelationAnalysis relationAnalysis) {
		super(relationalTransformation2coreTransformation.getEnvironmentFactory());
		this.relationalTransformation2coreTransformation = relationalTransformation2coreTransformation;
		this.relationalTransformation2tracePackage = relationalTransformation2coreTransformation.getRelationalTransformation2TracePackage();
		this.relationAnalysis = relationAnalysis;
		this.rRelation = relationAnalysis.getRelation();
		this.transformationAnalysis = relationAnalysis.getTransformationAnalysis();
		this.rTransformation = transformationAnalysis.getTransformation();
		this.qvtr2qvtc = transformationAnalysis.getQVTr2QVTc();
		this.rRelationName = PivotUtil.getName(rRelation);
		//
		this.cTransformation = relationalTransformation2coreTransformation.getCoreTransformation();
	}

	/**
	 * Create the name Mapping for a cTransformation.
	 */
	protected @NonNull Mapping createCoreMapping(@NonNull String name) {
		//		RelationalTransformation rt = QVTrelationUtil.getTransformation(relation);
		Mapping coreMapping = createMapping(name);
		qvtr2qvtc.putGlobalTrace(coreMapping, rRelation);
		coreMapping.setIsAbstract(rRelation.isIsAbstract());
		coreMapping.setTransformation(cTransformation);
		return coreMapping;
	}

	@Override
	public @NonNull Relation getRelation() {
		return rRelation;
	}

	@Override
	public @NonNull RelationAnalysis getRelationAnalysis() {
		return relationAnalysis;
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getTopRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhenRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull EnforceableRelationDomain2CoreMapping getWhereRelationDomain2CoreMapping(@NonNull TypedModel rEnforcedTypedModel) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull String toString() {
		return PivotUtil.getName(rTransformation) + "::" + rRelationName;
	}
}
