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
 * from: model/QVTbase.genmodel
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
 * An AbstractNullQVTbaseVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTbaseVisitor<R, C>
	extends org.eclipse.ocl.examples.pivot.util.AbstractNullVisitor<R, C> implements QVTbaseVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTbaseVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return null;
	}

	public @Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return null;
	}

	public @Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return null;
	}

	public @Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return null;
	}

	public @Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return null;
	}

	public @Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return null;
	}

	public @Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return null;
	}

	public @Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return null;
	}

	public @Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return null;
	}

	public @Nullable R visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		return null;
	}
}
