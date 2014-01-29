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
 * from: org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.pivot.qvtbase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTbaseVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTbaseVisitor<R, C, D extends QVTbaseVisitor<R>, P>
	extends org.eclipse.ocl.examples.pivot.util.AbstractWrappingVisitor<R, C, D, P>
	implements QVTbaseVisitor<R>
{
	protected AbstractWrappingQVTbaseVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	public @Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		P prologue = preVisit(object);
		R result = delegate.visitBaseModel(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		P prologue = preVisit(object);
		R result = delegate.visitDomain(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		P prologue = preVisit(object);
		R result = delegate.visitFunction(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		P prologue = preVisit(object);
		R result = delegate.visitFunctionParameter(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		P prologue = preVisit(object);
		R result = delegate.visitPattern(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		P prologue = preVisit(object);
		R result = delegate.visitPredicate(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		P prologue = preVisit(object);
		R result = delegate.visitRule(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
 		P prologue = preVisit(object);
		R result = delegate.visitTransformation(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		P prologue = preVisit(object);
		R result = delegate.visitTypedModel(object);
		return postVisit(object, prologue, result);
	}

	public @Nullable R visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		P prologue = preVisit(object);
		R result = delegate.visitUnit(object);
		return postVisit(object, prologue, result);
	}
}
