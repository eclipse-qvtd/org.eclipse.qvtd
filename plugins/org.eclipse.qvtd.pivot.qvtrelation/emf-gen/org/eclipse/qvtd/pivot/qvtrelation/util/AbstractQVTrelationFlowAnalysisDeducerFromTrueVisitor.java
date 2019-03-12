/*******************************************************************************
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
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtrelation.util;

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateFlowAnalysisDeducerFromTrueVisitor;

/**
 * An AbstractQVTrelationFlowAnalysisDeducerFromTrueVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationFlowAnalysisDeducerFromTrueVisitor
	extends QVTtemplateFlowAnalysisDeducerFromTrueVisitor
	implements QVTrelationVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationFlowAnalysisDeducerFromTrueVisitor(@NonNull FlowAnalysis flowAnalysis) {
		super(flowAnalysis);
	}

	@Override
	public @Nullable Boolean visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Boolean visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Boolean visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Boolean visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Boolean visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Boolean visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable Boolean visitSharedVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull SharedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Boolean visitTemplateVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull TemplateVariable object) {
		return visitVariable(object);
	}
}
