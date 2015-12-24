/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
 * An AbstractMergedQVTrelationVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTrelationVisitor<R, C>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractMergedQVTtemplateVisitor<R, C>
	implements QVTrelationVisitor<R>
{
	protected AbstractMergedQVTrelationVisitor(C context) {
		super(context);
	}

	@Override
	public R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return visiting(object);
	}

	@Override
	public R visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return visiting(object);
	}

	@Override
	public R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return visiting(object);
	}

	@Override
	public R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return visiting(object);
	}

	@Override
	public R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return visiting(object);
	}

	@Override
	public R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return visiting(object);
	}

	@Override
	public R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return visiting(object);
	}

	@Override
	public R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return visiting(object);
	}

	@Override
	public R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return visiting(object);
	}
}
