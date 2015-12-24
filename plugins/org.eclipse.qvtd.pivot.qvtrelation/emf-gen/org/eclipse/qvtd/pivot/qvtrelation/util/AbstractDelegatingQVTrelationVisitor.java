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
 * An AbstractDelegatingQVTrelationVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTrelationVisitor<R, C, D extends QVTrelationVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractDelegatingQVTtemplateVisitor<R, C, D>
	implements QVTrelationVisitor<R>
{
	protected AbstractDelegatingQVTrelationVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		return delegate.visitDomainPattern(object);
	}

	@Override
	public R visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		return delegate.visitKey(object);
	}

	@Override
	public R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		return delegate.visitRelation(object);
	}

	@Override
	public R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		return delegate.visitRelationCallExp(object);
	}

	@Override
	public R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		return delegate.visitRelationDomain(object);
	}

	@Override
	public R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		return delegate.visitRelationDomainAssignment(object);
	}

	@Override
	public R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		return delegate.visitRelationImplementation(object);
	}

	@Override
	public R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		return delegate.visitRelationModel(object);
	}

	@Override
	public R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		return delegate.visitRelationalTransformation(object);
	}
}
