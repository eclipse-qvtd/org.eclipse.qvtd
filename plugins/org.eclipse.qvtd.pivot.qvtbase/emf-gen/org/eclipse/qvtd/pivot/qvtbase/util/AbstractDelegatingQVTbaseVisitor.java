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
 * from: /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtbase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTbaseVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTbaseVisitor<R, C, D extends QVTbaseVisitor<R>>
	extends org.eclipse.ocl.examples.pivot.util.AbstractDelegatingVisitor<R, C, D>
	implements QVTbaseVisitor<R>
{
    protected AbstractDelegatingQVTbaseVisitor(@NonNull D delegate, @NonNull C context) {
        super(delegate, context);
    }

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return delegate.visitBaseModel(object);
	}

	public @Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return delegate.visitDomain(object);
	}

	public @Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return delegate.visitFunction(object);
	}

	public @Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return delegate.visitFunctionParameter(object);
	}

	public @Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return delegate.visitPattern(object);
	}

	public @Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return delegate.visitPredicate(object);
	}

	public @Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return delegate.visitRule(object);
	}

	public @Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return delegate.visitTransformation(object);
	}

	public @Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return delegate.visitTypedModel(object);
	}

	public @Nullable R visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		return delegate.visitUnit(object);
	}
}
