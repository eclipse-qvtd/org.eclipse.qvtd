/*******************************************************************************
 * Copyright (c) 2013, 2021 Willink Transformations and others.
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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateAS2MonikerVisitor;

/**
 * An AbstractQVTrelationAS2MonikerVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTrelationAS2MonikerVisitor
	extends QVTtemplateAS2MonikerVisitor
	implements QVTrelationVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTrelationAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}

	@Override
	public @Nullable Object visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return visitPattern(object);
	}

	@Override
	public @Nullable Object visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return visitRule(object);
	}

	@Override
	public @Nullable Object visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public @Nullable Object visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return visitDomain(object);
	}

	@Override
	public @Nullable Object visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @Nullable Object visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return visitTransformation(object);
	}

	@Override
	public @Nullable Object visitSharedVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull SharedVariable object) {
		return visitVariable(object);
	}

	@Override
	public @Nullable Object visitTemplateVariable(org.eclipse.qvtd.pivot.qvtrelation.@NonNull TemplateVariable object) {
		return visitVariable(object);
	}
}
