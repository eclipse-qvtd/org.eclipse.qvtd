/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtrelation.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTrelationVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTrelationVisitor<R, C, D extends QVTrelationVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvttemplate.util.AbstractDelegatingQVTtemplateVisitor<R, C, D>
	implements QVTrelationVisitor<R>
{
    protected AbstractDelegatingQVTrelationVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitDomainPattern(@NonNull org.eclipse.qvtd.pivot.qvtrelation.DomainPattern object) {
		return delegate.visitDomainPattern(object);
	}

	public @Nullable R visitKey(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Key object) {
		return delegate.visitKey(object);
	}

	public @Nullable R visitOppositePropertyCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp object) {
		return delegate.visitOppositePropertyCallExp(object);
	}

	public @Nullable R visitRelation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.Relation object) {
		return delegate.visitRelation(object);
	}

	public @Nullable R visitRelationCallExp(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp object) {
		return delegate.visitRelationCallExp(object);
	}

	public @Nullable R visitRelationDomain(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomain object) {
		return delegate.visitRelationDomain(object);
	}

	public @Nullable R visitRelationDomainAssignment(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment object) {
		return delegate.visitRelationDomainAssignment(object);
	}

	public @Nullable R visitRelationImplementation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation object) {
		return delegate.visitRelationImplementation(object);
	}

	public @Nullable R visitRelationModel(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationModel object) {
		return delegate.visitRelationModel(object);
	}

	public @Nullable R visitRelationalTransformation(@NonNull org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation object) {
		return delegate.visitRelationalTransformation(object);
	}
}
