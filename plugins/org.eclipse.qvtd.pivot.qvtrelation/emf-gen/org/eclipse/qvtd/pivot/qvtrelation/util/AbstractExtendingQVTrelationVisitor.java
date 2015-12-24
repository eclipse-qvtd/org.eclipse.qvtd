/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingQVTrelationVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTrelationVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractExtendingQVTtemplateVisitor<R, C>
	implements QVTrelationVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTrelationVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return visitPattern(object);
	}

	@Override
	public R visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return visitElement(object);
	}

	@Override
	public R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return visitRule(object);
	}

	@Override
	public R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return visitOCLExpression(object);
	}

	@Override
	public R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return visitDomain(object);
	}

	@Override
	public R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return visitElement(object);
	}

	@Override
	public R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return visitElement(object);
	}

	@Override
	public R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return visitTransformation(object);
	}
}
