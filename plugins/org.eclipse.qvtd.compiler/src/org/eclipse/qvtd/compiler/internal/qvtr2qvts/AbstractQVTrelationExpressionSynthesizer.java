/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;

public abstract class AbstractQVTrelationExpressionSynthesizer extends ExpressionSynthesizer implements QVTrelationVisitor<@Nullable Node>
{
	protected AbstractQVTrelationExpressionSynthesizer(@NonNull RelationAnalysis context, @Nullable AbstractQVTrelationExpressionSynthesizer unconditionalExpressionSynthesizer, @NonNull Utility utility) {
		super(context, unconditionalExpressionSynthesizer, utility);
	}

	@Override
	public @Nullable Node visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull CollectionTemplateExp object) {
		return visitTemplateExp(object);
	}

	@Override
	public @Nullable Node visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp object) {
		return visitTemplateExp(object);
	}

	@Override
	public @Nullable Node visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.@NonNull PropertyTemplateItem object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Node visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull TemplateExp object) {
		return visitLiteralExp(object);
	}

	@Override
	public @Nullable Node visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Node visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Node visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Node visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Node visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Node visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Node visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Node visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Node visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable Node visitSharedVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull SharedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Node visitTemplateVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull TemplateVariable object) {
		return visitVariable(object);
	}
}