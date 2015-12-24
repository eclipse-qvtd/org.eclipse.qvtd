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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTrelationVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTrelationVisitor<R, C, D extends QVTrelationVisitor<R>, P>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractWrappingQVTtemplateVisitor<R, C, D, P>
	implements QVTrelationVisitor<R>
{
	protected AbstractWrappingQVTrelationVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitDomainPattern(org.eclipse.qvtd.pivot.qvtrelation.@NonNull DomainPattern object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDomainPattern(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitKey(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Key object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitKey(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull Relation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationCallExp(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationCallExp object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationDomain(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomain object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationDomain(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationDomainAssignment(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationDomainAssignment object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationDomainAssignment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationImplementation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationImplementation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationImplementation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationModel(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRelationalTransformation(org.eclipse.qvtd.pivot.qvtrelation.@NonNull RelationalTransformation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRelationalTransformation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
