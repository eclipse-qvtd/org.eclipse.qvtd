/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
 * Do not edit it.
 */
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
	protected AbstractWrappingQVTrelationVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	public @Nullable R visitDomainPattern(@NonNull org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object) {
		P prologue = preVisit(object);
		R result = delegate.visitDomainPattern(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitKey(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Key object) {
		P prologue = preVisit(object);
		R result = delegate.visitKey(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object) {
		P prologue = preVisit(object);
		R result = delegate.visitOppositePropertyCallExp(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Relation object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelation(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationCallExp(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationDomain(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationDomain(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationDomainAssignment(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationDomainAssignment(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationImplementation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationImplementation(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationModel(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationModel object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationModel(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRelationalTransformation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object) {
		P prologue = preVisit(object);
		R result = delegate.visitRelationalTransformation(object);
		return postVisit(object, prologue, result);
	}
}
