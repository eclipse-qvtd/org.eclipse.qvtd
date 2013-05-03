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
 */
public interface QVTbaseVisitor<R> extends org.eclipse.ocl.examples.pivot.util.Visitor<R>
{
	@Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object);
	@Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object);
	@Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object);
	@Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object);
	@Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object);
	@Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object);
	@Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object);
	@Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object);
	@Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object);
	@Nullable R visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object);
}
