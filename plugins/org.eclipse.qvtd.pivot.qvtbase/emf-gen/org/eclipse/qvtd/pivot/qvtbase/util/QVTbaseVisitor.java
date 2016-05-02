/*******************************************************************************
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
 * from: org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTbaseVisitor<R> extends org.eclipse.ocl.pivot.util.Visitor<R>
{
	R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object);
	R visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object);
	R visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object);
	R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object);
	R visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object);
	R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object);
	R visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object);
	R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object);
	R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object);
}
